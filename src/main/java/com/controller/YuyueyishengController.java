
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
 * 预约医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuyueyisheng")
public class YuyueyishengController {
    private static final Logger logger = LoggerFactory.getLogger(YuyueyishengController.class);

    @Autowired
    private YuyueyishengService yuyueyishengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuanzheService huanzheService;
    @Autowired
    private YishengService yishengService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("患者".equals(role))
            params.put("huanzheId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yuyueyishengService.queryPage(params);

        //字典表数据转换
        List<YuyueyishengView> list =(List<YuyueyishengView>)page.getList();
        for(YuyueyishengView c:list){
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
        YuyueyishengEntity yuyueyisheng = yuyueyishengService.selectById(id);
        if(yuyueyisheng !=null){
            //entity转view
            YuyueyishengView view = new YuyueyishengView();
            BeanUtils.copyProperties( yuyueyisheng , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(yuyueyisheng.getHuanzheId());
                if(huanzhe != null){
                    BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzheId(huanzhe.getId());
                }
                //级联表
                YishengEntity yisheng = yishengService.selectById(yuyueyisheng.getYishengId());
                if(yisheng != null){
                    BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYishengId(yisheng.getId());
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
    public R save(@RequestBody YuyueyishengEntity yuyueyisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuyueyisheng:{}",this.getClass().getName(),yuyueyisheng.toString());

            yuyueyisheng.setInsertTime(new Date());
            yuyueyisheng.setCreateTime(new Date());
            yuyueyishengService.insert(yuyueyisheng);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuyueyishengEntity yuyueyisheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuyueyisheng:{}",this.getClass().getName(),yuyueyisheng.toString());

            yuyueyishengService.updateById(yuyueyisheng);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yuyueyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YuyueyishengEntity> yuyueyishengList = new ArrayList<>();//上传的东西
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
                            YuyueyishengEntity yuyueyishengEntity = new YuyueyishengEntity();
//                            yuyueyishengEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            yuyueyishengEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            yuyueyishengEntity.setYuyueyishengContent("");//照片
//                            yuyueyishengEntity.setYuyueTime(new Date(data.get(0)));          //预约日期 要改的
//                            yuyueyishengEntity.setShijidianTypes(Integer.valueOf(data.get(0)));   //时间段 要改的
//                            yuyueyishengEntity.setInsertTime(date);//时间
//                            yuyueyishengEntity.setCreateTime(date);//时间
                            yuyueyishengList.add(yuyueyishengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yuyueyishengService.insertBatch(yuyueyishengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
