import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoHelper;

public class xjf
  implements View.OnClickListener
{
  public xjf(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    int j;
    if (BannerManager.a(this.a) != null)
    {
      localQQAppInterface = BannerManager.a(this.a).app;
      if (localQQAppInterface == null) {
        break label1111;
      }
      j = localQQAppInterface.a().e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
      }
      if ((j != 1) && (j != 2)) {
        break label288;
      }
      paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
      if (localQQAppInterface.a().f() != 1011) {
        break label101;
      }
    }
    label101:
    Object localObject;
    label288:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      paramView.addFlags(262144);
      paramView.addFlags(268435456);
      if (localQQAppInterface.a().b(localQQAppInterface.a().c()))
      {
        paramView.putExtra("sessionType", 3);
        paramView.putExtra("GroupId", localQQAppInterface.a().c());
        paramView.putExtra("isDoubleVideoMeeting", true);
        BannerManager.a(this.a).startActivity(paramView);
        BannerManager.a(this.a).overridePendingTransition(2131034238, 0);
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
        return;
      }
      paramView.putExtra("sessionType", j);
      paramView.putExtra("uin", localQQAppInterface.a().c());
      BannerManager.a(this.a).startActivity(paramView);
      BannerManager.a(this.a).overridePendingTransition(2131034238, 0);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
      return;
      if (j != 5) {
        break label479;
      }
      paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), PSTNC2CActivity.class);
      paramView.addFlags(262144);
      paramView.addFlags(268435456);
      localObject = new PstnSessionInfo();
      ((PstnSessionInfo)localObject).jdField_a_of_type_JavaLangString = localQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).d = localQQAppInterface.a().a().d;
      ((PstnSessionInfo)localObject).jdField_b_of_type_JavaLangString = localQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).c = localQQAppInterface.a().a().c;
      ((PstnSessionInfo)localObject).jdField_a_of_type_Int = localQQAppInterface.a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject).jdField_b_of_type_Int = localQQAppInterface.a().a().jdField_b_of_type_Int;
      paramView.putExtra("pstn_session_info", (Parcelable)localObject);
      BannerManager.a(this.a).startActivity(paramView);
      BannerManager.a(this.a).overridePendingTransition(2131034238, 0);
    } while (localQQAppInterface == null);
    PstnUtils.a(localQQAppInterface.getApp());
    return;
    label479:
    long l = BannerManager.a(this.a).app.a().b();
    int k = BannerManager.a(this.a).app.a().a();
    if ((l != 0L) || (BannerManager.a(this.a).app.a().b() > 0))
    {
      int m = localQQAppInterface.a().b(l);
      label630:
      int i;
      if (BannerManager.a(this.a).app.a().b() > 0) {
        if (localQQAppInterface.a().c() > 0L)
        {
          paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), GuildMultiActivity.class);
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80057ED", "0X80057ED", 0, 0, "", "", "", "");
          if (localQQAppInterface.a().a(k, l) <= 0L) {
            break label915;
          }
          if (!localQQAppInterface.a().a(k, l)) {
            break label910;
          }
          i = 2;
        }
      }
      for (;;)
      {
        paramView.addFlags(262144);
        paramView.addFlags(268435456);
        paramView.putExtra("GroupId", String.valueOf(l));
        paramView.putExtra("Type", i);
        paramView.putExtra("sessionType", j);
        paramView.putExtra("uinType", UITools.b(k));
        paramView.putExtra("MultiAVType", m);
        if (m != 2) {
          break label1005;
        }
        if (localQQAppInterface.a().c(String.valueOf(l)) != 14) {
          break label920;
        }
        ((GroupVideoManager)localQQAppInterface.getManager(235)).a(BannerManager.a(this.a), localQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
        label786:
        BannerManager.a(this.a).overridePendingTransition(2131034238, 0);
        if (k != 2) {
          break label1019;
        }
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
        return;
        if ((localQQAppInterface.a().c() == 1) || (localQQAppInterface.a().c() == 3) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.e("MultiVideoBar", 2, "status error");
        return;
        if (m == 2)
        {
          paramView = new Intent();
          break label630;
        }
        paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
        break label630;
        label910:
        i = 1;
        continue;
        label915:
        i = 0;
      }
      label920:
      localObject = (TroopManager)localQQAppInterface.getManager(51);
      if ((localObject == null) || (((TroopManager)localObject).a(l + "") != null)) {
        break label1127;
      }
    }
    label1111:
    label1127:
    for (boolean bool = false;; bool = true)
    {
      paramView.putExtra("troopmember", bool);
      paramView.putExtra("Fromwhere", "SmallScreen");
      GroupVideoHelper.a(localQQAppInterface, BannerManager.a(this.a), paramView, 1);
      break label786;
      label1005:
      BannerManager.a(this.a).startActivity(paramView);
      break label786;
      label1019:
      if (k != 1) {
        break;
      }
      if (localQQAppInterface.a().b(l) == 10)
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "app is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjf
 * JD-Core Version:    0.7.0.1
 */