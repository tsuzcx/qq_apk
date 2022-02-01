import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import org.json.JSONException;
import org.json.JSONObject;

public class lmb
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
    return lkz.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    paramlie = paramContainer.findViewBaseByName("id_large_video_icon");
    if (paramlie != null) {
      paramlie.setVisibility(0);
    }
    paramlie = paramContainer.findViewBaseByName("id_video_bg");
    if (paramlie != null) {
      paramlie.setVisibility(8);
    }
    paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
    if (paramContainer != null) {
      paramContainer.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmb
 * JD-Core Version:    0.7.0.1
 */