import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class qf
  implements BusinessObserver
{
  public qf(QRJumpActivity paramQRJumpActivity, Activity paramActivity, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Bundle localBundle1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRJumpActivity.isFinishing()) {
      return;
    }
    if ((paramBoolean) && (paramBundle != null)) {
      paramBundle = paramBundle.getString("result");
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(paramBundle);
        if (((JSONObject)localObject3).getInt("r") == 0) {
          paramBundle = new QRActionEntity(((JSONObject)localObject3).getString("d"));
        }
        boolean bool;
        Object localObject1;
        Bundle localBundle2;
        paramBundle = null;
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (((JSONObject)localObject3).has("wpa"))
          {
            paramBoolean = "1".equals(((JSONObject)localObject3).getString("wpa"));
            bool = ((JSONObject)localObject3).has("extvalue");
            if (((JSONObject)localObject3).has("exttype"))
            {
              if ("2".equals(((JSONObject)localObject3).getString("exttype"))) {
                break label307;
              }
              if ("1".equals(((JSONObject)localObject3).getString("exttype")))
              {
                break label307;
                localBundle1 = new Bundle();
                if (!paramBoolean) {}
              }
            }
            try
            {
              localBundle1.putBoolean("issupportwpa", paramBoolean);
              if ((paramInt != 0) && (bool))
              {
                localObject2 = ((JSONObject)localObject3).getString("exttype");
                localObject3 = ((JSONObject)localObject3).getString("extvalue");
                localBundle1.putString("exttype", (String)localObject2);
                localBundle1.putString("extvalue", (String)localObject3);
              }
              localObject2 = localBundle1;
              localBundle1 = paramBundle;
              paramBundle = (Bundle)localObject2;
            }
            catch (Exception localException2)
            {
              localBundle2 = paramBundle;
              paramBundle = (Bundle)localObject1;
              localObject1 = localBundle2;
              continue;
            }
            QRResultHandler.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRJumpActivity.app, this.jdField_a_of_type_AndroidAppActivity, localBundle1, this.jdField_a_of_type_JavaLangString, paramBundle);
            this.jdField_a_of_type_AndroidAppActivity.finish();
            return;
            paramInt = 0;
            continue;
            paramBundle = paramBundle;
            paramBundle = null;
            continue;
          }
        }
        catch (Exception localException1)
        {
          localObject2 = null;
          localObject1 = paramBundle;
          paramBundle = (Bundle)localObject2;
          continue;
          paramBoolean = false;
          continue;
        }
        paramBundle = null;
        localObject1 = localBundle2;
        continue;
      }
      continue;
      label307:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     qf
 * JD-Core Version:    0.7.0.1
 */