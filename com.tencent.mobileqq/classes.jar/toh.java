import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class toh
  implements pye
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pub.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject;
    if ((paramppu != null) && (paramppu.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramppu.a())))
    {
      localObject = paramContainer.findViewBaseByName("id_article_brand_optimization");
      TemplateBean localTemplateBean = paramppu.a().mProteusTemplateBean;
      paramContainer = null;
      if (localTemplateBean != null) {
        paramContainer = localTemplateBean.findViewById("id_top_left_mask");
      }
      if ((localObject instanceof try))
      {
        localObject = (try)localObject;
        ((try)localObject).a(paramppu);
        if (paramContainer == null) {
          break label96;
        }
        ((try)localObject).a(true);
      }
    }
    return;
    label96:
    ((try)localObject).a(false);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     toh
 * JD-Core Version:    0.7.0.1
 */