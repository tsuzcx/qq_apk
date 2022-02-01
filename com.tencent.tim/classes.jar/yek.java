import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class yek
  implements DialogInterface.OnClickListener
{
  public yek(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (acms)this.this$0.app.getBusinessHandler(20);
    if ((aqiw.isNetSupport(this.this$0.app.getApp().getApplicationContext())) && (paramDialogInterface != null)) {
      if (((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.sessionInfo.aTl).isTroopOwner(this.this$0.app.getCurrentAccountUin())) {
        paramDialogInterface.Fc(this.this$0.sessionInfo.aTl);
      }
    }
    for (;;)
    {
      new anov(this.this$0.app).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_quitgrp").a(new String[] { this.this$0.sessionInfo.aTl }).report();
      return;
      paramDialogInterface.Fb(this.this$0.sessionInfo.aTl);
      continue;
      if (paramDialogInterface != null) {
        QQToast.a(this.this$0.mActivity, 1, 2131696348, 0).show();
      } else {
        QQToast.a(this.this$0.mActivity, 1, 2131693293, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yek
 * JD-Core Version:    0.7.0.1
 */