import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class dnk
  extends BroadcastReceiver
{
  public dnk(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.jdField_a_of_type_AndroidOsBundle == null) || (TextUtils.isEmpty(this.a.c))) {}
    while (NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      return;
    }
    Toast.makeText(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562444), 1).show();
    paramContext = new dnl(this);
    new Handler().postDelayed(paramContext, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnk
 * JD-Core Version:    0.7.0.1
 */