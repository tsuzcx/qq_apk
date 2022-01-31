import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class bje
  extends BroadcastReceiver
{
  public bje(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.jdField_a_of_type_AndroidOsBundle == null) || (TextUtils.isEmpty(this.a.c))) {}
    while (NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    Toast.makeText(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364114), 1).show();
    paramContext = new bjf(this);
    new Handler().postDelayed(paramContext, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bje
 * JD-Core Version:    0.7.0.1
 */