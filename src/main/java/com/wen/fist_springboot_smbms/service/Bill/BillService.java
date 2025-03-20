package com.wen.fist_springboot_smbms.service.Bill;

import com.wen.fist_springboot_smbms.pojo.Bill;

import java.util.List;

/**
 * Class name: BillService
 * Package: com.wen.fist_springboot_smbms.service.Bill
 * Description: 订单的服务层接口
 *
 * @Create: 2025/3/20 15:16
 * @Author: jay
 * @Version: 1.0
 */
public interface BillService {

    // 根据商品的名称，供应商id，是否付款，查询订单总数
    int getBillCount(String queryProductName, int queryProviderId, int queryIsPayment)throws Exception;

    // 根据 商品名称，供应商id，是否付款，查询订单列表
    List<Bill> getBillList(String queryProductName, int queryProviderId, int queryIsPayment,int currentPageNo, int pageSize)throws Exception;

    // 删除订单
    boolean deleteBill(int billId);

    // 添加订单
    boolean addBill(Bill bill);

    // 根据Id查询订单信息
    Bill findByBillId(int billId)throws Exception;

    //修改订单信息
    boolean modifyBill(int billId, Bill bill)throws Exception;

}

