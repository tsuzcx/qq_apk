import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

final class wmn
  implements ausj.a
{
  wmn(jln paramjln, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, Context paramContext, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Jln.dismiss();
    QQAppInterface localQQAppInterface;
    switch (this.cT[paramInt])
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 10002))
      {
        anot.a(this.val$app, "CliOper", "", "", "0X8005150", "0X8005150", 0, 0, "", "", "", "");
        if (!acgr.y(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl))
        {
          this.d.vh(this.d.a().getString(2131696215));
          anot.a(this.val$app, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
          localQQAppInterface = this.val$app;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1001) {}
          for (paramView = "0";; paramView = "1")
          {
            anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "0", "", "");
            return;
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1010) && (!afck.F(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl)))
      {
        this.d.vh(this.d.a().getString(2131696215));
        anot.a(this.val$app, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
        return;
      }
      wmj.a(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.Uc, null);
      anot.a(this.val$app, "CliOper", "", "", "0X8004861", "0X8004861", 0, 0, "", "", "", "");
      return;
    case 2: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 10002))
      {
        anot.a(this.val$app, "CliOper", "", "", "0X8005151", "0X8005151", 0, 0, "", "", "", "");
        if (!acgr.y(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl))
        {
          this.d.vh(this.d.a().getString(2131696216));
          anot.a(this.val$app, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
          localQQAppInterface = this.val$app;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1001) {}
          for (paramView = "0";; paramView = "1")
          {
            anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "1", "", "");
            return;
          }
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ == 1010) && (!afck.F(this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl)))
      {
        this.d.vh(this.d.a().getString(2131696216));
        anot.a(this.val$app, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
        return;
      }
      wmj.a(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.Uc, null);
      anot.a(this.val$app, "CliOper", "", "", "0X8004C09", "0X8004C09", 0, 0, "", "", "", "");
      return;
    }
    paramView = ((asgx)this.val$app.getManager(165)).qW(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl);
    jqs.b(this.val$app, this.val$context, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmn
 * JD-Core Version:    0.7.0.1
 */