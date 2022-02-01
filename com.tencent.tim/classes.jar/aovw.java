import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class aovw
  implements BusinessObserver
{
  public aovw(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.xa(false);
    this.this$0.rightViewText.setEnabled(true);
    TroopBarReplyActivity localTroopBarReplyActivity = this.this$0;
    this.this$0.getString(2131698503);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9992) });
        continue;
        paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9991) });
        continue;
      }
      this.this$0.cOP = false;
      QQToast.a(localTroopBarReplyActivity, 1, paramBundle, 0).show(this.this$0.getTitleBarHeight());
      return;
      paramBundle = paramBundle.getJSONObject("result");
      localObject = new StringBuffer();
      if ((this.this$0.cu != null) && (this.this$0.cu.size() > 0)) {
        ((StringBuffer)localObject).append("0");
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        ((StringBuffer)localObject).append("1");
      }
      if (!TextUtils.isEmpty(aprv.f(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener))) {
        ((StringBuffer)localObject).append("2");
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        ((StringBuffer)localObject).append("5");
      }
      ((StringBuffer)localObject).append("8");
      this.this$0.cOn = true;
      paramBundle.optString("pid");
      paramBundle.optString("bid");
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", paramBundle.toString());
      this.this$0.setResult(-1, (Intent)localObject);
      this.this$0.finish();
      this.this$0.cOP = false;
      return;
      paramBundle = this.this$0.getString(2131698504, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovw
 * JD-Core Version:    0.7.0.1
 */