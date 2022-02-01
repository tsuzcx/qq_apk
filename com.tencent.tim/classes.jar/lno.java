import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONException;
import org.json.JSONObject;

public class lno
  implements lpi
{
  private BaseTemplateFactory templateFactory;
  
  public lno(VafContext paramVafContext)
  {
    this.templateFactory = paramVafContext.getTemplateFactory();
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    if (this.templateFactory != null) {
      return this.templateFactory.getTemplateBean(paramJSONObject);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    return new lku().N(paramBaseArticleInfo).C(paramBaseArticleInfo).E();
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_proteus_collection_view");
    if ((paramContainer instanceof ltp)) {
      ((ltp)paramContainer).setModel(paramlie);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lno
 * JD-Core Version:    0.7.0.1
 */