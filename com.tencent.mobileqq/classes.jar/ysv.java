import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.IPrePullListener;
import org.json.JSONObject;

public class ysv
  implements MiniAppPrePullManager.IPrePullListener
{
  public ysv(GdtPreLoader.1 param1) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    yxp.b("GdtPreLoader", String.format("MiniAppPrePullManager.getInstance().prePullAppinfoByLink end:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */