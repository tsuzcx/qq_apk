import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;

public class cbt
  implements View.OnClickListener
{
  public cbt(FraudTipsBar paramFraudTipsBar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar, 2);
    FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a();
    ReportController.b(FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar), "P_CliOper", "Safe_AntiFraud", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    Object localObject = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "http://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
    }
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramView = paramView.replace("$SUBAPP$", "notice");; paramView = paramView.replace("$SUBAPP$", "tips"))
    {
      paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a).replace("$USERUIN$", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).getAccount());
      localObject = new Intent(FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar), QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("injectrecommend", true);
      ((Intent)localObject).putExtra("url", paramView);
      FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).startActivity((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbt
 * JD-Core Version:    0.7.0.1
 */