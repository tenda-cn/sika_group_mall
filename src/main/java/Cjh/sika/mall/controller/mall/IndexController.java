
package Cjh.sika.mall.controller.mall;

import Cjh.sika.mall.common.Constants;
import Cjh.sika.mall.common.IndexConfigTypeEnum;
import Cjh.sika.mall.controller.vo.SikaMallIndexCarouselVO;
import Cjh.sika.mall.controller.vo.SikaMallIndexCategoryVO;
import Cjh.sika.mall.controller.vo.SikaMallIndexConfigGoodsVO;
import Cjh.sika.mall.service.SikaMallCarouselService;
import Cjh.sika.mall.service.SikaMallCategoryService;
import Cjh.sika.mall.service.SikaMallIndexConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private SikaMallCarouselService sikaMallCarouselService;

    @Resource
    private SikaMallIndexConfigService newBeeMallIndexConfigService;

    @Resource
    private SikaMallCategoryService sikaMallCategoryService;

    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        List<SikaMallIndexCategoryVO> categories = sikaMallCategoryService.getCategoriesForIndex();
        if (CollectionUtils.isEmpty(categories)) {
            return "error/error_5xx";
        }
        List<SikaMallIndexCarouselVO> carousels = sikaMallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        List<SikaMallIndexConfigGoodsVO> hotGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        List<SikaMallIndexConfigGoodsVO> newGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        List<SikaMallIndexConfigGoodsVO> recommendGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
        request.setAttribute("categories", categories);//分类数据
        request.setAttribute("carousels", carousels);//轮播图
        request.setAttribute("hotGoodses", hotGoodses);//热销商品
        request.setAttribute("newGoodses", newGoodses);//新品
        request.setAttribute("recommendGoodses", recommendGoodses);//推荐商品
        return "mall/index";
    }
}
