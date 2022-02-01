import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaig
  implements View.OnClickListener
{
  aaig(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    int j;
    Intent localIntent;
    if (aahb.a(this.this$0) != null)
    {
      localQQAppInterface = aahb.a(this.this$0).app;
      if (localQQAppInterface == null) {
        break label1147;
      }
      j = localQQAppInterface.a().getSessionType();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
      }
      if ((j != 1) && (j != 2)) {
        break label551;
      }
      localIntent = new Intent(aahb.a(this.this$0).getApplicationContext(), AVActivity.class);
      if (localQQAppInterface.a().lk() != 1011) {
        break label109;
      }
    }
    label109:
    long l;
    label274:
    label551:
    int k;
    int m;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localQQAppInterface = null;
      break;
      if ((localQQAppInterface.bF()) && (localQQAppInterface.a().lk() != 1) && (localQQAppInterface.a().lk() != 3000) && (localQQAppInterface.a().up()) && (localQQAppInterface.a().uo()) && (localQQAppInterface.a().lk() != 1011) && (localQQAppInterface.a().lk() != 21))
      {
        localIntent = new Intent(aahb.a(this.this$0), VideoInviteActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("uinType", localQQAppInterface.a().lk());
        localIntent.putExtra("peerUin", localQQAppInterface.a().ay());
        localIntent.putExtra("extraUin", localQQAppInterface.a().gZ());
        if (j == 1)
        {
          bool = true;
          localIntent.putExtra("isAudioMode", bool);
          aahb.a(this.this$0).startActivity(localIntent);
          aahb.a(this.this$0).overridePendingTransition(2130772207, 0);
        }
      }
      for (;;)
      {
        anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
        break;
        bool = false;
        break label274;
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        if (localQQAppInterface.a().cx(localQQAppInterface.a().ay()))
        {
          localIntent.putExtra("sessionType", 3);
          localIntent.putExtra("GroupId", localQQAppInterface.a().ay());
          localIntent.putExtra("isDoubleVideoMeeting", true);
          aahb.a(this.this$0).startActivity(localIntent);
          aahb.a(this.this$0).overridePendingTransition(2130772207, 0);
          anot.a(localQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
        }
        else
        {
          localIntent.putExtra("sessionType", j);
          localIntent.putExtra("uin", localQQAppInterface.a().ay());
          aahb.a(this.this$0).startActivity(localIntent);
          aahb.a(this.this$0).overridePendingTransition(2130772207, 0);
          anot.a(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
        }
      }
      l = aahb.a(this.this$0).app.a().bG();
      k = aahb.a(this.this$0).app.a().lg();
      if ((l == 0L) && (aahb.a(this.this$0).app.a().lh() <= 0)) {
        break label1130;
      }
      m = localQQAppInterface.a().z(l);
      if (aahb.a(this.this$0).app.a().lh() <= 0) {
        break label685;
      }
      if ((localQQAppInterface.a().li() != 1) && (localQQAppInterface.a().li() != 3) && (QLog.isColorLevel())) {
        QLog.e("MultiVideoBar", 2, "status error");
      }
    }
    label685:
    label700:
    int i;
    if (m == 2)
    {
      localIntent = new Intent();
      if (localQQAppInterface.a().d(k, l) <= 0L) {
        break label939;
      }
      if (!localQQAppInterface.a().i(k, l)) {
        break label934;
      }
      i = 2;
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("GroupId", String.valueOf(l));
      localIntent.putExtra("Type", i);
      localIntent.putExtra("sessionType", j);
      localIntent.putExtra("uinType", jll.cM(k));
      localIntent.putExtra("MultiAVType", m);
      if (m != 2) {
        break label1034;
      }
      if (localQQAppInterface.a().as(String.valueOf(l)) != 14) {
        break label944;
      }
      ((aicu)localQQAppInterface.getManager(236)).e(aahb.a(this.this$0), localQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
      label863:
      aahb.a(this.this$0).overridePendingTransition(2130772207, 0);
      if (k != 2) {
        break label1049;
      }
      anot.a(localQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
      break;
      localIntent = new Intent(aahb.a(this.this$0).getApplicationContext(), AVActivity.class);
      break label700;
      label934:
      i = 1;
      continue;
      label939:
      i = 0;
    }
    label944:
    TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.b(l + "") == null)) {}
    for (boolean bool = false;; bool = true)
    {
      localIntent.putExtra("troopmember", bool);
      localIntent.putExtra("Fromwhere", "SmallScreen");
      avfh.a(localQQAppInterface, aahb.a(this.this$0), localIntent, 1);
      break label863;
      label1034:
      aahb.a(this.this$0).startActivity(localIntent);
      break label863;
      label1049:
      if (k != 1) {
        break;
      }
      if (localQQAppInterface.a().z(l) == 10)
      {
        anot.a(localQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        break;
      }
      anot.a(localQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      break;
      label1130:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      break;
      label1147:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "app is null");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaig
 * JD-Core Version:    0.7.0.1
 */