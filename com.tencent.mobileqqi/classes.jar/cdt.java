import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;

public class cdt
  implements View.OnClickListener
{
  public cdt(ChatActivity paramChatActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2);
    ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    Object localObject = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "http://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
    }
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramView = paramView.replace("$SUBAPP$", "notice");; paramView = paramView.replace("$SUBAPP$", "tips"))
    {
      paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.a).replace("$USERUIN$", this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b.getAccount());
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("injectrecommend", true);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.startActivity((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdt
 * JD-Core Version:    0.7.0.1
 */