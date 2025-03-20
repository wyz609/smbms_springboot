package com.wen.fist_springboot_smbms.service.Bill;

import com.wen.fist_springboot_smbms.mapper.BillMapper;
import com.wen.fist_springboot_smbms.pojo.Bill;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class name: BillServiceImpl
 * Package: com.wen.fist_springboot_smbms.service.Bill
 * Description: service层接口实现类
 *
 * @Create: 2025/3/20 15:26
 * @Author: jay
 * @Version: 1.0
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    // 根据 商品名称，供应商id，是否付款来查询订单总数
    @Override
    public int getBillCount(String queryProductName, int queryProviderId, int queryIsPayment) throws Exception {
        int billCount = 0;
        billCount = billMapper.getBillCount(queryProductName, queryProviderId, queryIsPayment);
        return billCount;
    }

    // 根据 商品名称，供应商id，是否付款，查询订单列表
    @Override
    public List<Bill> getBillList(String queryProductName, int queryProviderId, int queryIsPayment,int currentPageNo,int pageSize) throws Exception {
        return billMapper.getBillList(queryProductName, queryProviderId, queryIsPayment, currentPageNo, pageSize);
    }

    // 根据 id删除订单
    @Override
    public boolean deleteBill(int billId) {
        return billMapper.deleteBill(billId) > 0;
    }

    // 添加订单信息
    @Override
    public boolean addBill(Bill bill) {
        return billMapper.addBill(bill) > 0;
    }

    // 根据 订单id查询订单
    @Override
    public Bill findByBillId(int billId) throws Exception {
        return billMapper.findByBillId(billId);
    }

    // 修改订单信息
    @Override
    public boolean modifyBill(int billId, Bill bill) throws Exception {
        return billMapper.modifyBill(billId,bill) > 0;
    }
}

