import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class who
  implements BusinessObserver
{
  who(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, ScannerParams paramScannerParams, View paramView, whu paramwhu) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = Uri.parse((String)localObject1);
    label35:
    label235:
    int i;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, String.format("JumpUrl requestUrlDecode authSig=%s url=%s", new Object[] { localObject2, localObject1 }));
      }
      if ((paramBoolean) && (paramBundle != null))
      {
        paramBundle = paramBundle.getString("result");
        paramInt = j;
      }
    }
    else
    {
      Object localObject3;
      for (;;)
      {
        boolean bool;
        try
        {
          localObject3 = new JSONObject(paramBundle);
          paramInt = j;
          if (((JSONObject)localObject3).getInt("r") != 0) {
            break label823;
          }
          paramInt = j;
          if (!((JSONObject)localObject3).has("d")) {
            break label559;
          }
          paramInt = j;
          paramBundle = new wfj(((JSONObject)localObject3).getString("d"));
          paramInt = j;
          if (!((JSONObject)localObject3).has("wpa")) {
            break label548;
          }
          paramInt = j;
          if (!"1".equals(((JSONObject)localObject3).getString("wpa"))) {
            break label548;
          }
          paramBoolean = true;
          paramInt = j;
          bool = ((JSONObject)localObject3).has("extvalue");
          paramInt = j;
          if (!((JSONObject)localObject3).has("exttype")) {
            break label553;
          }
          paramInt = j;
          if ("2".equals(((JSONObject)localObject3).getString("exttype"))) {
            break label831;
          }
          paramInt = j;
          if (!"1".equals(((JSONObject)localObject3).getString("exttype"))) {
            break label553;
          }
        }
        catch (Exception paramBundle) {}
        paramInt = j;
        Bundle localBundle = new Bundle();
        if (paramBoolean)
        {
          paramInt = j;
          localBundle.putBoolean("issupportwpa", paramBoolean);
        }
        if ((i != 0) && (bool))
        {
          paramInt = j;
          String str = ((JSONObject)localObject3).getString("exttype");
          paramInt = j;
          localObject3 = ((JSONObject)localObject3).getString("extvalue");
          paramInt = j;
          localBundle.putString("exttype", str);
          paramInt = j;
          localBundle.putString("extvalue", (String)localObject3);
        }
        paramInt = j;
        localBundle.putString("authSig", (String)localObject2);
        paramInt = j;
        i = wfn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle, this.jdField_a_of_type_JavaLangString, localBundle);
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b)
        {
          paramInt = i;
          this.jdField_a_of_type_MqqAppAppActivity.finish();
        }
        paramInt = i;
        whm.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramInt = i;
        if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e) {
          break;
        }
        paramInt = i;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
        return;
        label423:
        QLog.e("ScannerUtils", 1, "handle url error: " + paramBundle.getMessage());
        label451:
        paramBundle = bbcv.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
        paramBundle.setTitle(2131717233);
        paramBundle.setMessage((CharSequence)localObject1);
        localObject2 = new whp(this);
        paramBundle.setPositiveButton(2131694793, new whq(this, (String)localObject1));
        paramBundle.setNegativeButton(2131690596, (DialogInterface.OnClickListener)localObject2);
        paramBundle.setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
        paramBundle.show();
        whm.a(paramInt, (String)localObject1, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        localObject2 = ((Uri)localObject2).getQueryParameter("authKey");
        break label35;
        label548:
        paramBoolean = false;
        continue;
        label553:
        i = 0;
      }
      label559:
      paramInt = j;
      if (((JSONObject)localObject3).has("a_a"))
      {
        paramInt = j;
        paramBundle = ((JSONObject)localObject3).getString("a_a");
        paramInt = j;
        paramBundle = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle);
        if (paramBundle == null) {
          break label837;
        }
        paramInt = j;
        paramBundle.c();
        return;
      }
      paramInt = j;
      if (((JSONObject)localObject3).has("url"))
      {
        paramInt = j;
        i = ((JSONObject)localObject3).getInt("url_level");
        paramInt = j;
        paramBundle = ((JSONObject)localObject3).getString("url");
        paramInt = j;
        if (TextUtils.isEmpty(paramBundle)) {
          break label861;
        }
        if (i != 2) {
          break label855;
        }
        paramInt = j;
        paramBundle = Uri.parse(paramBundle).toString();
        paramInt = i;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt != 1)
        {
          localObject1 = paramBundle;
          if (paramInt != 2) {
            break label837;
          }
        }
        try
        {
          localObject1 = new Intent(this.jdField_a_of_type_MqqAppAppActivity, PublicAccountBrowser.class);
          ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject1).putExtra("fromQrcode", true);
          ((Intent)localObject1).putExtra("url", paramBundle);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_sacan_qr");
          if (this.jdField_a_of_type_MqqAppAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true)
          {
            this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject1);
            this.jdField_a_of_type_MqqAppAppActivity.finish();
          }
          for (;;)
          {
            whm.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
              break;
            }
            this.jdField_a_of_type_MqqAppAppActivity.finish();
            return;
            this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject1);
          }
          label823:
          break label837;
          paramInt = 0;
          break label451;
          label831:
          i = 1;
          break label235;
          label837:
          paramInt = 0;
        }
        catch (Exception localException)
        {
          paramInt = 0;
          localObject1 = paramBundle;
          paramBundle = localException;
        }
      }
      break label423;
      label855:
      paramInt = i;
      continue;
      label861:
      paramBundle = (Bundle)localObject1;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */