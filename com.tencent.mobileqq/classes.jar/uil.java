import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class uil
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qma.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject;
    if ((paramqfw != null) && (paramqfw.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramqfw.a())))
    {
      localObject = paramContainer.findViewBaseByName("id_article_brand_optimization");
      TemplateBean localTemplateBean = paramqfw.a().mProteusTemplateBean;
      paramContainer = null;
      if (localTemplateBean != null) {
        paramContainer = localTemplateBean.findViewById("id_top_left_mask");
      }
      if ((localObject instanceof ump))
      {
        localObject = (ump)localObject;
        ((ump)localObject).a(paramqfw);
        if (paramContainer == null) {
          break label96;
        }
        ((ump)localObject).a(true);
      }
    }
    return;
    label96:
    ((ump)localObject).a(false);
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uil
 * JD-Core Version:    0.7.0.1
 */