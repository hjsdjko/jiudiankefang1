
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房间预定
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangjianyuding")
public class FangjianyudingController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianyudingController.class);

    @Autowired
    private FangjianyudingService fangjianyudingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FangjianService fangjianService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangjianyudingService.queryPage(params);

        //字典表数据转换
        List<FangjianyudingView> list =(List<FangjianyudingView>)page.getList();
        for(FangjianyudingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjianyudingEntity fangjianyuding = fangjianyudingService.selectById(id);
        if(fangjianyuding !=null){
            //entity转view
            FangjianyudingView view = new FangjianyudingView();
            BeanUtils.copyProperties( fangjianyuding , view );//把实体数据重构到view中

                //级联表
                FangjianEntity fangjian = fangjianService.selectById(fangjianyuding.getFangjianId());
                if(fangjian != null){
                    BeanUtils.copyProperties( fangjian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangjianId(fangjian.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fangjianyuding.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianyudingEntity fangjianyuding, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangjianyuding:{}",this.getClass().getName(),fangjianyuding.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            fangjianyuding.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


            FangjianEntity fangjianEntity = fangjianService.selectById(fangjianyuding.getFangjianId());
            YonghuEntity yonghuEntity = yonghuService.selectById(fangjianyuding.getYonghuId());
            if(yonghuEntity.getNewMoney() < fangjianEntity.getFangjianNewMoney()){
                return R.error("余额不足不能预定");
            }
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - fangjianEntity.getFangjianNewMoney());
            fangjianEntity.setStatusTypes(2);
            boolean b1 = fangjianService.updateById(fangjianEntity);
            if(!b1){
                return R.error();
            }
            boolean b = yonghuService.updateById(yonghuEntity);
            if(!b){
                return R.error();
            }
            fangjianyuding.setCreateTime(new Date());
            fangjianyudingService.insert(fangjianyuding);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianyudingEntity fangjianyuding, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangjianyuding:{}",this.getClass().getName(),fangjianyuding.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            fangjianyuding.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FangjianyudingEntity> queryWrapper = new EntityWrapper<FangjianyudingEntity>()
            .notIn("id",fangjianyuding.getId())
            .andNew()
            .eq("yonghu_id", fangjianyuding.getYonghuId())
            .eq("fangjian_id", fangjianyuding.getFangjianId())
            .eq("fangjianyuding_types", fangjianyuding.getFangjianyudingTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectOne(queryWrapper);
        fangjianyuding.setUpdateTime(new Date());
        if(fangjianyudingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fangjianyuding.set
            //  }
            fangjianyudingService.updateById(fangjianyuding);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangjianyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 退房
     */
    @RequestMapping("/tuifang")
    public R tuifang(Integer id){
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectById(id);
        FangjianEntity fangjianEntity = fangjianService.selectById(fangjianyudingEntity.getFangjianId());
        YonghuEntity yonghuEntity = yonghuService.selectById(fangjianyudingEntity.getYonghuId());
        boolean b1 = fangjianyudingService.updateById(fangjianyudingEntity);
        if(!b1){
            return R.error();
        }
        FangjianyudingEntity fangjianyudingEntity1 = fangjianyudingService.selectById(id);
        Double riqi =  Integer.parseInt(String.valueOf((fangjianyudingEntity1.getUpdateTime().getTime() - fangjianyudingEntity1.getFangjianyudingTime().getTime())/(24*60*60*1000)))*fangjianEntity.getFangjianNewMoney() ;
        if(yonghuEntity.getNewMoney() < riqi){
            return R.error("需缴费：￥"+riqi+"，余额为："+yonghuEntity.getNewMoney()+"，差："+(riqi - yonghuEntity.getNewMoney())+"余额不足请充值");
        }
        yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - riqi);
        boolean b = yonghuService.updateById(yonghuEntity);
        if(!b){
            return R.error();
        }
        fangjianEntity.setStatusTypes(1);
        fangjianyudingEntity1.setFangjianyudingTypes(3);
        boolean b2 = fangjianService.updateById(fangjianEntity);
        if(!b2){
            return R.error();
        }
        boolean b3 = fangjianyudingService.updateById(fangjianyudingEntity1);
        if(!b3){
            return R.error();
        }
        return R.ok("退房成功，住房天"+(fangjianyudingEntity1.getUpdateTime().getTime() - fangjianyudingEntity1.getFangjianyudingTime().getTime())/(24*60*60*1000)+"，扣除费用为："+riqi);
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<FangjianyudingEntity> fangjianyudingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangjianyudingEntity fangjianyudingEntity = new FangjianyudingEntity();
//                            fangjianyudingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangjianyudingEntity.setFangjianId(Integer.valueOf(data.get(0)));   //房间 要改的
//                            fangjianyudingEntity.setFangjianyudingTime(new Date(data.get(0)));          //预定时间 要改的
//                            fangjianyudingEntity.setUpdateTime(new Date(data.get(0)));          //退房时间 要改的
//                            fangjianyudingEntity.setFangjianyudingTypes(Integer.valueOf(data.get(0)));   //预定状态 要改的
//                            fangjianyudingEntity.setCreateTime(date);//时间
                            fangjianyudingList.add(fangjianyudingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fangjianyudingService.insertBatch(fangjianyudingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangjianyudingService.queryPage(params);

        //字典表数据转换
        List<FangjianyudingView> list =(List<FangjianyudingView>)page.getList();
        for(FangjianyudingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjianyudingEntity fangjianyuding = fangjianyudingService.selectById(id);
            if(fangjianyuding !=null){


                //entity转view
                FangjianyudingView view = new FangjianyudingView();
                BeanUtils.copyProperties( fangjianyuding , view );//把实体数据重构到view中

                //级联表
                    FangjianEntity fangjian = fangjianService.selectById(fangjianyuding.getFangjianId());
                if(fangjian != null){
                    BeanUtils.copyProperties( fangjian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangjianId(fangjian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangjianyuding.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangjianyudingEntity fangjianyuding, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangjianyuding:{}",this.getClass().getName(),fangjianyuding.toString());
        Wrapper<FangjianyudingEntity> queryWrapper = new EntityWrapper<FangjianyudingEntity>()
            .eq("yonghu_id", fangjianyuding.getYonghuId())
            .eq("fangjian_id", fangjianyuding.getFangjianId())
            .eq("fangjianyuding_types", fangjianyuding.getFangjianyudingTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectOne(queryWrapper);
        if(fangjianyudingEntity==null){
            fangjianyuding.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fangjianyuding.set
        //  }
        fangjianyudingService.insert(fangjianyuding);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
