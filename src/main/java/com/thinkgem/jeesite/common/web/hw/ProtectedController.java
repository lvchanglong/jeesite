package com.thinkgem.jeesite.common.web.hw;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.Site;
import com.thinkgem.jeesite.modules.cms.service.SiteService;
import com.thinkgem.jeesite.modules.cms.utils.CmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 保护方法
 * Created by lvchanglong on 2017/7/5.
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class ProtectedController extends BaseController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "/protected/test")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model) {
        Site site = CmsUtils.getSite(Site.defaultSiteId());
        model.addAttribute("site", site);
        model.addAttribute("isIndex", true);
        System.out.println(request.getParameter("username"));
        System.out.println(model);
        return "hw/protected/test";
    }

}
