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

final class zxz
  implements BusinessObserver
{
  zxz(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, ScannerParams paramScannerParams, View paramView, zyf paramzyf) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Uri localUri = Uri.parse((String)localObject1);
    Object localObject2;
    label32:
    int j;
    Object localObject3;
    zvn localzvn;
    label172:
    label236:
    Bundle localBundle;
    int i;
    if (localUri == null)
    {
      localObject2 = null;
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, String.format("JumpUrl requestUrlDecode authSig=%s url=%s", new Object[] { localObject2, localObject1 }));
      }
      j = 0;
      if ((!paramBoolean) || (paramBundle == null)) {
        break label878;
      }
      paramBundle = paramBundle.getString("result");
      paramInt = j;
      boolean bool;
      try
      {
        localObject3 = new JSONObject(paramBundle);
        paramInt = j;
        if (((JSONObject)localObject3).getInt("r") != 0) {
          break label875;
        }
        paramInt = j;
        if (!((JSONObject)localObject3).has("d")) {
          break label608;
        }
        paramInt = j;
        localzvn = new zvn(((JSONObject)localObject3).getString("d"));
        paramInt = j;
        if (!((JSONObject)localObject3).has("wpa")) {
          break label583;
        }
        paramInt = j;
        if (!"1".equals(((JSONObject)localObject3).getString("wpa"))) {
          break label583;
        }
        paramBoolean = true;
        paramInt = j;
        bool = ((JSONObject)localObject3).has("extvalue");
        paramInt = j;
        if (!((JSONObject)localObject3).has("exttype")) {
          break label588;
        }
        paramInt = j;
        if ("2".equals(((JSONObject)localObject3).getString("exttype"))) {
          break label883;
        }
        paramInt = j;
        if (!"1".equals(((JSONObject)localObject3).getString("exttype"))) {
          break label588;
        }
      }
      catch (Exception paramBundle) {}
      paramInt = j;
      localBundle = new Bundle();
      if (paramBoolean)
      {
        paramInt = j;
        localBundle.putBoolean("issupportwpa", paramBoolean);
      }
      if ((i != 0) && (bool))
      {
        paramInt = j;
        paramBundle = ((JSONObject)localObject3).getString("exttype");
        paramInt = j;
        localObject3 = ((JSONObject)localObject3).getString("extvalue");
        paramInt = j;
        localBundle.putString("exttype", paramBundle);
        paramInt = j;
        localBundle.putString("extvalue", (String)localObject3);
      }
      paramInt = j;
      localBundle.putString("authSig", (String)localObject2);
      if (localUri != null) {
        break label594;
      }
    }
    for (paramBundle = null;; paramBundle = localUri.getQueryParameter("jump_from"))
    {
      if (paramBundle != null)
      {
        paramInt = j;
        if ("webapi".equalsIgnoreCase(paramBundle))
        {
          paramInt = j;
          localBundle.putString("sourceId", "3_40002");
        }
      }
      paramInt = j;
      i = zvr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, localzvn, this.jdField_a_of_type_JavaLangString, localBundle);
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b)
      {
        paramInt = i;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      paramInt = i;
      zxx.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = i;
      if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e) {
        break;
      }
      paramInt = i;
      this.jdField_a_of_type_MqqAppAppActivity.finish();
      return;
      label458:
      QLog.e("ScannerUtils", 1, "handle url error: " + paramBundle.getMessage());
      label486:
      paramBundle = bhlq.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
      paramBundle.setTitle(2131715962);
      paramBundle.setMessage((CharSequence)localObject1);
      localObject2 = new zya(this);
      paramBundle.setPositiveButton(2131694098, new zyb(this, (String)localObject1));
      paramBundle.setNegativeButton(2131690580, (DialogInterface.OnClickListener)localObject2);
      paramBundle.setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
      paramBundle.show();
      zxx.a(paramInt, (String)localObject1, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localObject2 = localUri.getQueryParameter("authKey");
      break label32;
      label583:
      paramBoolean = false;
      break label172;
      label588:
      i = 0;
      break label236;
      label594:
      paramInt = j;
    }
    label608:
    paramInt = j;
    if (((JSONObject)localObject3).has("a_a"))
    {
      paramInt = j;
      paramBundle = ((JSONObject)localObject3).getString("a_a");
      paramInt = j;
      paramBundle = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle);
      if (paramBundle != null)
      {
        paramInt = j;
        paramBundle.a();
      }
    }
    else
    {
      paramInt = j;
      if (((JSONObject)localObject3).has("url"))
      {
        paramInt = j;
        i = ((JSONObject)localObject3).getInt("url_level");
        paramInt = j;
        paramBundle = ((JSONObject)localObject3).getString("url");
        paramInt = j;
        if (TextUtils.isEmpty(paramBundle)) {
          break label913;
        }
        if (i != 2) {
          break label907;
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
            break label889;
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
            zxx.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
              break;
            }
            this.jdField_a_of_type_MqqAppAppActivity.finish();
            return;
            this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject1);
          }
          label875:
          break label889;
          label878:
          paramInt = 0;
          break label486;
          label883:
          i = 1;
          break label236;
          label889:
          paramInt = 0;
        }
        catch (Exception localException)
        {
          paramInt = 0;
          localObject1 = paramBundle;
          paramBundle = localException;
        }
      }
      break label458;
      label907:
      paramInt = i;
      continue;
      label913:
      paramBundle = (Bundle)localObject1;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */