package com.wen.fist_springboot_smbms.controller;

import com.wen.fist_springboot_smbms.pojo.Bill;
import com.wen.fist_springboot_smbms.pojo.Provider;
import com.wen.fist_springboot_smbms.service.Bill.BillService;
import com.wen.fist_springboot_smbms.service.Provider.ProviderService;
import com.wen.fist_springboot_smbms.util.PageSupport;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Class name: BillController
 * Package: com.wen.fist_springboot_smbms.controller
 * Description:
 *
 * @Create: 2025/3/20 16:40
 * @Author: jay
 * @Version: 1.0
 */
@Controller
@RequestMapping("/bill") // 统一设置 API访问前缀
public class BillController {

    @Resource
    private BillService billService;

    @Resource
    private ProviderService providerService;

    @GetMapping("/query")
    public String query(@RequestParam(value = "queryProductName", required = false, defaultValue = "") String queryProductName,
                        @RequestParam(value = "queryProviderId", required = false, defaultValue = "") int queryProviderId,
                        @RequestParam(value = "queryIsPayment",required = false,defaultValue = "") int queryIsPayment,
                        @RequestParam(value = "pageIndex", required = false,defaultValue = "") int currentPageNo,
                        Model model) throws Exception {


        int pageSize = 5; // 每页显示订单数量
        int totalCount = billService.getBillCount(queryProductName, queryProviderId, queryIsPayment);

        // 分页逻辑代码
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        // 控制当前页范围
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        //查询订单列表
        List<Bill> billList = billService.getBillList(queryProductName, queryProviderId, queryIsPayment, currentPageNo, pageSize);

        // 查询供应商列表
        List<Provider> providerList = providerService.getProviderList("", "", 1, providerService.getProviderCounts("",""));

        model.addAttribute("billList", billList);
        model.addAttribute("providerList", providerList);
        model.addAttribute("queryProductName",queryProductName);
        model.addAttribute("queryProviderId",queryProviderId);
        model.addAttribute("queryIsPayment",queryIsPayment);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("totalPageCount",totalPageCount);

        return "billlist";
    }

}

