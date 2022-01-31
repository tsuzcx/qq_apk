import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public class ehx
  implements DialogInterface.OnClickListener
{
  public ehx(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_privacy_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.a());
    localBundle.putInt("key_privacy_type", 3);
    PrivacyDeclareHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, localBundle, this.a.jdField_a_of_type_ComTencentMobileqqAppPrivacyDeclareHelper$Callback);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehx
 * JD-Core Version:    0.7.0.1
 */