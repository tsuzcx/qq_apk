import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONException;
import org.json.JSONObject;

public class lmd
  implements lpi
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    return lle.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((paramlie != null) && (paramlie.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramlie.a())))
    {
      paramContainer = paramContainer.findViewBaseByName("id_article_triple_image_interact");
      if ((paramContainer != null) && ((paramContainer instanceof kow))) {
        ((kow)paramContainer).setModel(paramlie);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmd
 * JD-Core Version:    0.7.0.1
 */