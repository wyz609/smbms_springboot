package com.wen.fist_springboot_smbms.mapper;

import com.wen.fist_springboot_smbms.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Class name: ProviderMapper
 * Package: com.wen.fist_springboot_smbms.mapper
 * Description: 供应商接口实现
 *
 * @Create: 2025/3/19 9:16
 * @Author: jay
 * @Version: 1.0
 */
public interface ProviderMapper {


    // 获取供应商总数
    int getProviderCounts(@Param("proCode") String proCode, @Param("proName") String proName);

    // 获取供应商列表（分页）
    List<Provider> getProviderList(@Param("proCode") String proCode, @Param("proName") String proName,
                                   @Param("offset") int offset, @Param("pageSize") int pageSize);

    // 添加供应商
    int addProvider(Provider provider);

    // 删除供应商
    int deleteProvider(@Param("id") int id);

    // 根据 ID 查找供应商
    Provider findById(@Param("id") int id);

    // 修改供应商
    int modifyProvider(@Param("id") Integer id, @Param("provider") Provider provider);


}
