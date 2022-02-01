import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.19;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ocu
  implements aprb.a
{
  public ocu(PublicAccountUtil.19 param19) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result :" + paramJSONObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocu
 * JD-Core Version:    0.7.0.1
 */