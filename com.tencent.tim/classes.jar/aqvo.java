import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.HashMap;
import org.json.JSONObject;

public class aqvo
  extends awlz
{
  private HashMap<String, awlz> pq;
  
  public aqvo(String paramString, View paramView, HashMap<String, awlz> paramHashMap)
  {
    super(paramString, paramView);
    this.pq = paramHashMap;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    int i = rpq.getScreenWidth(this.ey.getContext());
    paramLayoutParams.width = Math.max((int)(i * 108.0F / 360.0F), rpq.dip2px(this.ey.getContext(), 108.0F));
    paramLayoutParams.height = Math.max((int)(i * 126.0F / 360.0F), rpq.dip2px(this.ey.getContext(), 126.0F));
    return paramLayoutParams;
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    if ("border".equals(paramString1))
    {
      if ((awlz)this.pq.get(paramString1) != null) {}
      return;
    }
    super.setAttribute(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvo
 * JD-Core Version:    0.7.0.1
 */