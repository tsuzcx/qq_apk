import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class qw
  implements BusinessObserver
{
  public qw(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean1, View paramView, boolean paramBoolean2, ScannerView paramScannerView) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
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
            break label804;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("d")) {
            break;
          }
          localObject2 = localObject1;
          paramInt = j;
          localObject3 = new QRActionEntity(paramBundle.getString("d"));
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("wpa")) {
            break label503;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("wpa"))) {
            break label503;
          }
          paramBoolean = true;
          localObject2 = localObject1;
          paramInt = j;
          bool = paramBundle.has("extvalue");
          localObject2 = localObject1;
          paramInt = j;
          if (!paramBundle.has("exttype")) {
            break label508;
          }
          localObject2 = localObject1;
          paramInt = j;
          if ("2".equals(paramBundle.getString("exttype"))) {
            break label820;
          }
          localObject2 = localObject1;
          paramInt = j;
          if (!"1".equals(paramBundle.getString("exttype"))) {
            break label508;
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
        i = QRResultHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, (QRActionEntity)localObject3, this.jdField_a_of_type_JavaLangString, localBundle);
        localObject2 = localObject1;
        paramInt = i;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localObject1;
          paramInt = i;
          this.jdField_a_of_type_MqqAppAppActivity.finish();
        }
        localObject2 = localObject1;
        paramInt = i;
        ScannerUtils.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        label414:
        localObject1 = DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
        ((QQCustomDialog)localObject1).setTitle(2131362436);
        ((QQCustomDialog)localObject1).setMessage(paramBundle);
        localObject2 = new qx(this);
        ((QQCustomDialog)localObject1).setPositiveButton(2131362791, new qy(this, paramBundle));
        ((QQCustomDialog)localObject1).setNegativeButton(2131362790, (DialogInterface.OnClickListener)localObject2);
        ((QQCustomDialog)localObject1).setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
        ((QQCustomDialog)localObject1).show();
        ScannerUtils.a(paramInt, paramBundle, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        label503:
        paramBoolean = false;
        continue;
        label508:
        i = 0;
      }
      localObject2 = localObject1;
      paramInt = j;
      if (paramBundle.has("a_a"))
      {
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = paramBundle.getString("a_a");
        localObject2 = localObject1;
        paramInt = j;
        paramBundle = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle);
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
              paramBundle = Uri.parse(paramBundle).buildUpon().appendQueryParameter("sid", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid()).toString();
              paramInt = i;
              break label826;
            }
          }
        }
      }
    }
    for (;;)
    {
      label690:
      localObject2 = paramBundle;
      paramInt = j;
      localObject1 = new Intent(this.jdField_a_of_type_MqqAppAppActivity, PublicAccountBrowser.class);
      localObject2 = paramBundle;
      paramInt = j;
      ((Intent)localObject1).putExtra("url", paramBundle);
      localObject2 = paramBundle;
      paramInt = j;
      this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject1);
      localObject2 = paramBundle;
      paramInt = j;
      ScannerUtils.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = paramBundle;
      paramInt = j;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localObject2 = paramBundle;
      paramInt = j;
      this.jdField_a_of_type_MqqAppAppActivity.finish();
      return;
      paramInt = i;
      break label826;
      paramInt = 0;
      paramBundle = (Bundle)localObject1;
      label804:
      label820:
      label826:
      do
      {
        paramBundle = (Bundle)localObject3;
        paramInt = 0;
        break label414;
        paramBundle = (Bundle)localObject1;
        paramInt = 0;
        break label414;
        i = 1;
        break;
        if (paramInt == 1) {
          break label690;
        }
        localObject3 = paramBundle;
      } while (paramInt != 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     qw
 * JD-Core Version:    0.7.0.1
 */