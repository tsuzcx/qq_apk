import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

final class yfo
  implements DialogInterface.OnClickListener
{
  yfo(AbsShareMsg paramAbsShareMsg, FragmentActivity paramFragmentActivity, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "qbShowWpaResultDialog back");
      }
      if (this.jdField_c_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        paramDialogInterface = this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("appid");
        if (paramDialogInterface != null) {
          ahkr.a(this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity, true, this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("callback_type"), Long.parseLong(paramDialogInterface));
        }
      }
      jqo.a(this.val$context, 0, "", "");
      anot.a(this.val$app, "CliOper", "", this.a.aTl, "0X8004B56", "0X8004B56", 0, 0, "", "", "", "");
      this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    anot.a(this.val$app, "CliOper", "", this.a.aTl, "0X8004B55", "0X8004B55", 0, 0, "", "", "", "");
    if (!(this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      paramDialogInterface = new Intent(this.val$context, SplashActivity.class);
      paramDialogInterface.putExtra("tab_index", MainFragment.bIk);
      paramDialogInterface.addFlags(67108864);
      paramDialogInterface.addFlags(268435456);
      this.val$context.startActivity(paramDialogInterface);
      this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    this.jdField_c_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a().bHA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfo
 * JD-Core Version:    0.7.0.1
 */