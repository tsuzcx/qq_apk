import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class akdg
  implements BusinessObserver
{
  akdg(akcx paramakcx) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        ((ajpj)this.this$0.a.app.getManager(106)).go.put(this.this$0.a.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label602;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyProfileDisplayPanel", 2, "retCode = [" + paramInt + "]");
        }
        if (paramInt == 0) {
          break label302;
        }
        paramBundle = paramBundle.optString("msg");
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.this$0.a, 1, "" + paramBundle, 1).show();
          return;
        }
        QQToast.a(this.this$0.a, 1, acfp.m(2131708806), 1).show();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this.this$0.a, 1, acfp.m(2131708909), 1).show();
        if (!QLog.isColorLevel()) {
          break label647;
        }
      }
      QLog.e("NearbyProfileDisplayPanel", 2, "未知异常，请稍后重试", paramBundle);
      return;
      label302:
      if (paramBundle.optInt("retcode") == 0)
      {
        paramBundle = this.this$0;
        if (akcx.a(this.this$0)) {
          break label648;
        }
      }
    }
    label647:
    label648:
    for (paramBoolean = true;; paramBoolean = false)
    {
      akcx.a(paramBundle, paramBoolean);
      localObject = this.this$0.a;
      if (akcx.a(this.this$0)) {}
      for (paramBundle = acfp.m(2131708915);; paramBundle = acfp.m(2131708815))
      {
        QQToast.a((Context)localObject, 2, paramBundle, 1).show();
        ((ajvl)this.this$0.a.app.getBusinessHandler(119)).notifyUI(1000, true, new Object[] { Boolean.valueOf(akcx.a(this.this$0)), akcx.a(this.this$0).uin });
        akcx.a(this.this$0, 1, 60);
        if ((!akcx.a(this.this$0)) && (akcx.a(this.this$0).getChildAt(2).getVisibility() != 0))
        {
          paramBundle = (Button)akcx.a(this.this$0).getChildAt(1).findViewById(2131381048);
          paramBundle.setTextColor(this.this$0.a.getResources().getColor(2131167335));
          paramBundle.setBackgroundDrawable(this.this$0.a.getResources().getDrawable(2130846434));
        }
        if (!akcx.a(this.this$0)) {
          break;
        }
        paramBundle = (Button)akcx.a(this.this$0).getChildAt(1).findViewById(2131381048);
        paramBundle.setTextColor(this.this$0.a.getResources().getColor(2131167337));
        paramBundle.setBackgroundDrawable(this.this$0.a.getResources().getDrawable(2130846435));
        return;
      }
      label602:
      QQToast.a(this.this$0.a, 1, acfp.m(2131708800), 1).show();
      return;
      QQToast.a(this.this$0.a, 1, acfp.m(2131708898), 1).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdg
 * JD-Core Version:    0.7.0.1
 */