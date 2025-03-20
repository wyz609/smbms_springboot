package com.wen.fist_springboot_smbms.mapper;

import com.wen.fist_springboot_smbms.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Class name: BillMapper
 * Package: com.wen.fist_springboot_smbms.mapper
 * Description:  商品信息mapper接口
 *
 * @Create: 2025/3/19 16:29
 * @Author: jay
 * @Version: 1.0
 */
public interface BillMapper {

    // 查询订单总数
    int getBillCount(@Param("productName") String productName,
                     @Param("providerId") int providerId,
                     @Param("isPayment") int isPayment);

    // 查询订单列表(分页)
    List<Bill> getBillList(@Param("productName") String productName,
                           @Param("providerId") int providerId,
                           @Param("isPayment") int isPayment,
                           @Param("offset") int offset,
                           @Param("pageSize") int pageSize);


    // 添加订单
    int addBill(Bill bill);

    // 删除订单
    int deleteBill(@Param("id") int id);

    // 根据订单 ID 查询订单
    Bill findByBillId(@Param("id") int id);
    // 修改订单信息
    int modifyBill(Bill bill);
}

