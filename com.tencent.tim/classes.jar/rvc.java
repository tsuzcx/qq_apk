import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class rvc
  implements BusinessObserver
{
  public rvc(QRJumpActivity paramQRJumpActivity, String paramString1, String paramString2, Activity paramActivity, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    int i = 0;
    if (this.a.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRJumpActivity", 2, String.format("JumpUrl onReceive suc=%b ", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("result");
      QLog.i("QRJumpActivity", 2, String.format("JumpUrl onReceive result=%s", new Object[] { paramBundle }));
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramBundle);
        rtt localrtt;
        if (((JSONObject)localObject2).getInt("r") == 0) {
          localrtt = new rtt(((JSONObject)localObject2).getString("d"));
        }
        boolean bool;
        Bundle localBundle;
        paramBundle = null;
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (((JSONObject)localObject2).has("wpa"))
          {
            paramBoolean = "1".equals(((JSONObject)localObject2).getString("wpa"));
            bool = ((JSONObject)localObject2).has("extvalue");
            paramInt = i;
            if (((JSONObject)localObject2).has("exttype"))
            {
              if ("2".equals(((JSONObject)localObject2).getString("exttype"))) {
                break label353;
              }
              paramInt = i;
              if ("1".equals(((JSONObject)localObject2).getString("exttype"))) {
                break label353;
              }
            }
            paramBundle = new Bundle();
            if (paramBoolean) {}
            try
            {
              paramBundle.putBoolean("issupportwpa", paramBoolean);
              if ((paramInt != 0) && (bool))
              {
                localObject1 = ((JSONObject)localObject2).getString("exttype");
                localObject2 = ((JSONObject)localObject2).getString("extvalue");
                paramBundle.putString("exttype", (String)localObject1);
                paramBundle.putString("extvalue", (String)localObject2);
              }
              paramBundle.putString("authKey", this.aCz);
              paramBundle.putString("authSig", this.aCA);
              localObject1 = paramBundle;
              paramBundle = localrtt;
            }
            catch (Exception localException)
            {
              localBundle = paramBundle;
              paramBundle = localrtt;
              continue;
            }
            if (localObject1 != null) {
              rtw.a(this.a.app, this.val$context, paramBundle, this.aCB, (Bundle)localObject1);
            }
            this.val$context.finish();
            return;
            paramBundle = paramBundle;
            paramBundle = null;
            continue;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle = localrtt;
          continue;
          paramBoolean = false;
          continue;
        }
      }
      continue;
      label353:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvc
 * JD-Core Version:    0.7.0.1
 */