import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class uij
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qmc.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((paramqfw != null) && (paramqfw.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramqfw.a())))
    {
      ViewBase localViewBase = paramContainer.findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase != null) && ((localViewBase instanceof una))) {
        ((una)localViewBase).a(paramqfw, true);
      }
      paramContainer = paramContainer.findViewBaseByName("id_article_double_image");
      if ((paramContainer != null) && ((paramContainer instanceof unz))) {
        ((unz)paramContainer).a(paramqfw);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uij
 * JD-Core Version:    0.7.0.1
 */