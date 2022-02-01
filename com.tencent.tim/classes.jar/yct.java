import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

class yct
  implements aprb.a
{
  yct(ycd paramycd) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (apsa)this.this$0.app.getManager(132);
    paramInt = paramJSONObject.eT(this.this$0.sessionInfo.aTl);
    paramJSONObject.aK(this.this$0.sessionInfo.aTl, 0, paramInt & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yct
 * JD-Core Version:    0.7.0.1
 */