import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONException;
import org.json.JSONObject;

public class lnq
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
    paramBaseArticleInfo = new lku().M(paramBaseArticleInfo).C(paramBaseArticleInfo);
    switch (paramInt)
    {
    default: 
      paramBaseArticleInfo.a("ReadInjoy_small_cell");
    }
    for (;;)
    {
      return paramBaseArticleInfo.E();
      paramBaseArticleInfo.a("ReadInjoy_large_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnq
 * JD-Core Version:    0.7.0.1
 */