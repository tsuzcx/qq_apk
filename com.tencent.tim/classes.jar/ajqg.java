import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class ajqg
  implements BusinessObserver
{
  public ajqg(NearbyJsInterface paramNearbyJsInterface, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramBundle.optInt("retcode") == 0)
        {
          paramBundle = paramBundle.optString(this.val$uin);
          localObject = aqmj.U(this.this$0.context, this.val$uin);
          paramBundle = (String)localObject + "&uid=" + paramBundle + "&from=" + this.val$from;
          localObject = new Intent(this.this$0.context, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramBundle);
          this.this$0.context.startActivity((Intent)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "openProfileCard web url:" + paramBundle);
          }
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NearbyJsInterface", 2, "openProfileCard, exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqg
 * JD-Core Version:    0.7.0.1
 */