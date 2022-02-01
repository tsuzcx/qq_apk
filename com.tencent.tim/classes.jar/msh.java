import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class msh
  implements aprb.a
{
  public msh(ReadInJoyWebDataManager.5 param5) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      this.a.this$0.bH(this.a.VO, Integer.toString(msg.aTW));
      try
      {
        if ((this.a.a != null) && ((this.a.a instanceof msg.b))) {
          this.a.a.aa(paramJSONObject);
        }
        paramBundle = paramJSONObject.toString();
        msg.a(this.a.this$0, this.a.VO, paramBundle);
        if (this.a.aw != null)
        {
          this.a.aw.put("data", paramBundle);
          this.a.this$0.a(this.a.val$url, this.a.aw.toString(), "", this.a.aw);
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:storeParams putData JSONException :" + paramBundle);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result :" + paramJSONObject);
      }
    }
    do
    {
      return;
      this.a.this$0.bH(this.a.VO, Integer.toString(msg.aTV));
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msh
 * JD-Core Version:    0.7.0.1
 */