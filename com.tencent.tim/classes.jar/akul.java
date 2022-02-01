import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.json.JSONObject;

class akul
  implements aprb.a
{
  akul(akuk paramakuk, double paramDouble1, double paramDouble2, long paramLong) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (akuk.a(this.a).get() != null) {
      ((akuk.a)akuk.a(this.a).get()).a(paramJSONObject, paramInt, this.bR, this.cP, akuk.a(this.a), akuk.a(this.a));
    }
    long l = System.currentTimeMillis();
    paramBundle = new HashMap();
    paramBundle.put("cost", String.valueOf(l - this.val$startTime));
    paramBundle.put("result", String.valueOf(paramJSONObject));
    paramBundle.put("type", String.valueOf(akuk.a(this.a)));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actOnlineStatusCgi", true, 0L, 0L, paramBundle, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akul
 * JD-Core Version:    0.7.0.1
 */