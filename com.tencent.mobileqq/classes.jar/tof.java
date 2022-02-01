import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class tof
  implements pye
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pud.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((paramppu != null) && (paramppu.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramppu.a())))
    {
      ViewBase localViewBase = paramContainer.findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase != null) && ((localViewBase instanceof tse))) {
        ((tse)localViewBase).a(paramppu, true);
      }
      paramContainer = paramContainer.findViewBaseByName("id_article_double_image");
      if ((paramContainer != null) && ((paramContainer instanceof tti))) {
        ((tti)paramContainer).a(paramppu);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tof
 * JD-Core Version:    0.7.0.1
 */