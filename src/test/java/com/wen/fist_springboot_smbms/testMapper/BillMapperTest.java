package com.wen.fist_springboot_smbms.testMapper;

import com.wen.fist_springboot_smbms.mapper.BillMapper;
import com.wen.fist_springboot_smbms.pojo.Bill;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class name: BillMapperTest
 * Package: com.wen.fist_springboot_smbms.testMapper
 * Description:
 *
 * @Create: 2025/3/19 16:56
 * @Author: jay
 * @Version: 1.0
 */
@SpringBootTest
public class BillMapperTest {

    @Resource
    private BillMapper billMapper;

    // 测试查询订单总数
    @Test
    public void testBillMapperCount(){
        int count = billMapper.getBillCount("", 0, 0);
        System.out.println("订单总数" + count);
        assertTrue(count >= 0);
    }

    // 测试查询订单列表
    @Test
    public void testBillList(){
        List<Bill> billList = billMapper.getBillList("", 0, 0, 0, 5);
        System.out.println("查询的订单列表：" + billList);
        assertNotNull(billList);
        assertTrue(billList.size() > 0);
    }


    // 测试添加订单信息到数据库
    @Test
    public void testAddBill(){
        Bill testBill = Bill.builder()
                .billCode("B001")
                .productName("Test Product")
                .productDesc("Test Description")
                .productUnit("pcs")
                .productCount(new BigDecimal("10"))
                .totalPrice(new BigDecimal("100"))
                .isPayment(0) // 未付款
                .createdBy(1)
                .creationDate(new Timestamp(System.currentTimeMillis()))
                .modifyBy(1)
                .modifyDate(new Timestamp(System.currentTimeMillis()))
                .providerId(1)
                .build();
        System.out.println(testBill);
        int rows = billMapper.addBill(testBill);
        System.out.println("插入的订单行数:" + rows);
        assertEquals(1, rows);
    }

    //测试根据ID删除订单
    @Test
    public void testDeleteBill(){
        int rows = billMapper.deleteBill(18);
        assertEquals(1, rows);
        System.out.println("删除订单的行数：" + rows);
    }


    // 测试更具Id查询订单信息
    @Test
    public void testFindByBillId(){
        Bill billId = billMapper.findByBillId(16);
        assertNotNull(billId);
        System.out.println("查询到的订单:" + billId);

    }

    @Test
    public void testModifyBill(){
        Bill billId = billMapper.findByBillId(16);
        billId.setProductName("百事可乐");

        int updateResult = billMapper.modifyBill(billId);
        System.out.println("修改结果：" + updateResult);
        assertEquals(1, updateResult);

    }
}

