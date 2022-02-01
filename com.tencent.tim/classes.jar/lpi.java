import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface lpi
{
  public abstract TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException;
  
  public abstract JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException;
  
  public abstract void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2);
  
  public abstract boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpi
 * JD-Core Version:    0.7.0.1
 */