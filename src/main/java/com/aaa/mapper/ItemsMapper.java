package com.aaa.mapper;

import com.aaa.entity.Items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2019/11/20 - 14:37
 */
@Mapper
public interface ItemsMapper {
    Items selectId(Integer id);

    List<Items> selectAll();

    void updItems(Items items);

    void delItmes(Integer id);
}
