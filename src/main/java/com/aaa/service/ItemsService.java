package com.aaa.service;

import com.aaa.entity.Items;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/11/20 - 14:35
 */
public interface ItemsService {

    List<Items> selectAll();

    Items selectId(Integer id);

    Items updItems(Items items);

    void delItmes(Integer id);
}
