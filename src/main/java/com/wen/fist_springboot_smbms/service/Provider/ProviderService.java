package com.wen.fist_springboot_smbms.service.Provider;

import com.wen.fist_springboot_smbms.pojo.Provider;

import java.util.List;

/**
 * Class name: ProviderService
 * Package: com.wen.fist_springboot_smbms.service.Provider
 * Description:
 *
 * @Create: 2025/3/20 15:46
 * @Author: jay
 * @Version: 1.0
 */
public interface ProviderService {

    // 根据 供应商编码 或 供应商名称 查询供应商总数
    int getProviderCounts(String queryProCode,String queryProName)throws Exception;

    // 查询供应商数据列表
    List<Provider> getProviderList(String proCode, String proName, int currentPageNo, int pageSize) throws Exception;

    // 添加供应商信息
    boolean addProvider(Provider provider) throws Exception;

    // 删除供应商信息
    boolean deleteProvider(int providerId) throws Exception;

    // 根据Id查询供应商信息
    Provider findById(int providerId) throws Exception;

    // 修改供应商信息
    boolean modifyProvider(int id, Provider provider) throws Exception;
}
