package com.aaa.controller;

import com.aaa.entity.Items;
import com.aaa.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 钱浩洋
 * @date 2019/11/20 - 14:23
 */
@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //查询全部
    @RequestMapping("ItmesList")
/*    @ResponseBody*/
    public String  Items(Model model){
        List<Items> itemsList= itemsService.selectAll();
        model.addAttribute("itemsList",itemsList);
        return "ItemsList";
    }
    //修改
    @RequestMapping("updItmes")
    public String updItmes(Integer id,Model model){
        Items items = itemsService.selectId(id);
        model.addAttribute("items",items);
        return "updItmes";
    }
    //修改执行
    @RequestMapping("upd_do")
    public String upd_do(Items items){
        String lockUpd="project_upd";
        String clientId = UUID.randomUUID().toString();
        try {                                                   //setnx
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockUpd, clientId,30, TimeUnit.SECONDS);
            if (!result){
                return "error";
            }
            itemsService.updItems(items);
        }finally {
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockUpd))){
                stringRedisTemplate.delete(lockUpd);
            }
        }
        return "redirect:ItmesList";
    }
    //删除
    @RequestMapping("delItmes")
    public String delItmes(Integer id){
        String lockDel="project_del";
        String clientId = UUID.randomUUID().toString();
        try {                                                   //setnx
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockDel, clientId,30, TimeUnit.SECONDS);
            if (!result){
                return "error";
            }
            itemsService.delItmes(id);
        }finally {
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockDel))){
                stringRedisTemplate.delete(lockDel);
            }
        }
        return "redirect:ItmesList";
    }

}
