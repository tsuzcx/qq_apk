import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class tuc
  implements qdy
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pzx.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((parampvc != null) && (parampvc.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampvc.a())))
    {
      ViewBase localViewBase = paramContainer.findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase != null) && ((localViewBase instanceof tyx))) {
        ((tyx)localViewBase).a(parampvc, true);
      }
      paramContainer = paramContainer.findViewBaseByName("id_article_double_image");
      if ((paramContainer != null) && ((paramContainer instanceof tzy))) {
        ((tzy)paramContainer).a(parampvc);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */