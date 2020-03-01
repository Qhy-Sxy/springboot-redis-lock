package com.aaa.service;

import com.aaa.entity.Items;
import com.aaa.mapper.ItemsMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/11/20 - 14:36
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;

    @Override
    @Cacheable(cacheNames = "Itmeslist",key = "'AllItem'")
    public List<Items> selectAll() {
        return itemsMapper.selectAll();
    }

    @Override
    @Cacheable(cacheNames = "Itmeslist",key = "#id")
    public Items selectId(Integer id) {
        return itemsMapper.selectId(id);
    }

    @Override
    @CacheEvict(cacheNames = "Itmeslist",allEntries = true)
    //@CachePut(cacheNames = "Itmeslist",key = "#items.id")
    public Items updItems(Items items) {
        itemsMapper.updItems(items);
        return itemsMapper.selectId(items.getId());
    }
    @Override
    @CacheEvict(cacheNames = "Itmeslist",allEntries = true)
    public void delItmes(Integer id) {
        itemsMapper.delItmes(id);
    }
}
