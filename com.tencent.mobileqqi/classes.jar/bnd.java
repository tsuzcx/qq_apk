import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class bnd
  implements BusinessObserver
{
  public bnd(ScannerActivity paramScannerActivity, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2;
    Object localObject3;
    int i;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("result");
      localObject2 = localObject1;
      paramInt = j;
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject(paramBundle);
          localObject2 = localObject1;
          paramInt = j;
          localObject3 = localObject1;
          if (paramBundle.getInt("r") != 0) {
            break label807;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("d")) {
            break label512;
          }
          localObject2 = localObject1;
          paramInt = j;
          localObject3 = new QRActionEntity(paramBundle.getString("d"));
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("wpa")) {
            break label501;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("wpa"))) {
            break label501;
          }
          paramBoolean = true;
          localObject2 = localObject1;
          paramInt = j;
          bool = paramBundle.has("extvalue");
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("exttype")) {
            break label506;
          }
          localObject2 = localObject1;
          paramInt = j;
          if ("2".equals(paramBundle.getString("exttype"))) {
            break label823;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("exttype"))) {
            break label506;
          }
        }
        catch (Exception paramBundle)
        {
          boolean bool;
          Bundle localBundle;
          String str;
          paramBundle = (Bundle)localObject2;
        }
        localObject2 = localObject1;
        paramInt = j;
        localBundle = new Bundle();
        if (paramBoolean)
        {
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putBoolean("issupportwpa", paramBoolean);
        }
        if ((i != 0) && (bool))
        {
          localObject2 = localObject1;
          paramInt = j;
          str = paramBundle.getString("exttype");
          localObject2 = localObject1;
          paramInt = j;
          paramBundle = paramBundle.getString("extvalue");
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putString("exttype", str);
          localObject2 = localObject1;
          paramInt = j;
          localBundle.putString("extvalue", paramBundle);
        }
        localObject2 = localObject1;
        paramInt = j;
        i = QRResultHandler.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.b, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity, (QRActionEntity)localObject3, this.jdField_a_of_type_JavaLangString, localBundle);
        localObject2 = localObject1;
        paramInt = i;
        this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.a(i, this.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        paramInt = i;
        if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.l) {
          break;
        }
        localObject2 = localObject1;
        paramInt = i;
        this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.finish();
        return;
        label416:
        localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity, 230);
        ((QQCustomDialog)localObject1).setTitle(2131560527);
        ((QQCustomDialog)localObject1).setMessage(paramBundle);
        localObject2 = new bne(this);
        ((QQCustomDialog)localObject1).setPositiveButton(2131562539, new bnf(this, paramBundle));
        ((QQCustomDialog)localObject1).setNegativeButton(2131561746, (DialogInterface.OnClickListener)localObject2);
        ((QQCustomDialog)localObject1).setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
        ((QQCustomDialog)localObject1).show();
        this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.a(paramInt, paramBundle);
        return;
        label501:
        paramBoolean = false;
        continue;
        label506:
        i = 0;
      }
      label512:
      localObject2 = localObject1;
      paramInt = j;
      if (paramBundle.has("a_a"))
      {
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = paramBundle.getString("a_a");
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = JumpParser.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.b, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity, paramBundle);
        localObject3 = localObject1;
        if (paramBundle != null)
        {
          localObject2 = localObject1;
          paramInt = j;
          paramBundle.b();
        }
      }
      else
      {
        localObject2 = localObject1;
        paramInt = j;
        localObject3 = localObject1;
        if (paramBundle.has("url"))
        {
          localObject2 = localObject1;
          paramInt = j;
          i = paramBundle.getInt("url_level");
          localObject2 = localObject1;
          paramInt = j;
          paramBundle = paramBundle.getString("url");
          localObject2 = localObject1;
          paramInt = j;
          if (!TextUtils.isEmpty(paramBundle)) {
            if (i == 2)
            {
              localObject2 = localObject1;
              paramInt = j;
              paramBundle = Uri.parse(paramBundle).buildUpon().appendQueryParameter("sid", this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.b.getSid()).toString();
              paramInt = i;
              break label829;
            }
          }
        }
      }
    }
    for (;;)
    {
      label694:
      localObject2 = paramBundle;
      paramInt = j;
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity, PublicAccountBrowser.class);
      localObject2 = paramBundle;
      paramInt = j;
      ((Intent)localObject1).putExtra("url", paramBundle);
      localObject2 = paramBundle;
      paramInt = j;
      ScannerActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity, (Intent)localObject1);
      localObject2 = paramBundle;
      paramInt = j;
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.a(0, this.jdField_a_of_type_JavaLangString);
      localObject2 = paramBundle;
      paramInt = j;
      if (!this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.l) {
        break;
      }
      localObject2 = paramBundle;
      paramInt = j;
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.finish();
      return;
      paramInt = i;
      break label829;
      paramInt = 0;
      paramBundle = (Bundle)localObject1;
      label807:
      label823:
      label829:
      do
      {
        paramBundle = (Bundle)localObject3;
        paramInt = 0;
        break label416;
        paramBundle = (Bundle)localObject1;
        paramInt = 0;
        break label416;
        i = 1;
        break;
        if (paramInt == 1) {
          break label694;
        }
        localObject3 = paramBundle;
      } while (paramInt != 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnd
 * JD-Core Version:    0.7.0.1
 */