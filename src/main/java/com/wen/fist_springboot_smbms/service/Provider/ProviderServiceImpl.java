package com.wen.fist_springboot_smbms.service.Provider;

import com.wen.fist_springboot_smbms.mapper.ProviderMapper;
import com.wen.fist_springboot_smbms.pojo.Provider;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class name: ProviderServiceImpl
 * Package: com.wen.fist_springboot_smbms.service.Provider
 * Description: service层接口的具体实现类
 *
 * @Create: 2025/3/20 16:13
 * @Author: jay
 * @Version: 1.0
 */
@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderMapper providerMapper;

    @Override
    public int getProviderCounts(String queryProCode, String queryProName) throws Exception {
        return providerMapper.getProviderCounts(queryProCode, queryProName);
    }

    @Override
    public List<Provider> getProviderList(String proCode, String proName, int currentPageNo, int pageSize) throws Exception {
        return providerMapper.getProviderList(proCode, proName, currentPageNo, pageSize);
    }

    @Override
    public boolean addProvider(Provider provider) throws Exception {
        return providerMapper.addProvider(provider) > 0;
    }

    @Override
    public boolean deleteProvider(int providerId) throws Exception {
        return providerMapper.deleteProvider(providerId) > 0;
    }

    @Override
    public Provider findById(int providerId) throws Exception {
        return providerMapper.findById(providerId);
    }

    @Override
    public boolean modifyProvider(int id, Provider provider) throws Exception {
        return providerMapper.modifyProvider(id, provider) > 0;
    }
}

