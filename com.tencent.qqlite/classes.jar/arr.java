import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class arr
  implements Runnable
{
  public arr(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getType();
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.a(), "dl_open_via_qq");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
    if (str.startsWith("image")) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_AndroidOsBundle.putParcelable("android.intent.extra.STREAM", localUri);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", i);
      localIntent.setData(localUri);
      localIntent.putExtra("sendMultiple", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("not_forward", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     arr
 * JD-Core Version:    0.7.0.1
 */