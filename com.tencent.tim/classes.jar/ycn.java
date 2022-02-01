import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class ycn
  implements CustomMenuBar.a
{
  ycn(ycd paramycd) {}
  
  public void B(String paramString, int paramInt1, int paramInt2)
  {
    wja.bcO = true;
    this.this$0.mProgress = new arhz(ycd.f(this.this$0).getContext(), this.this$0.mActivity.getTitleBarHeight());
    long l = NetConnInfoCenter.getServerTime();
    String str2 = this.this$0.sessionInfo.aTl;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (ycd.c(this.this$0))
      {
        ycd.a(this.this$0);
        str1 = "";
        paramString = str1;
        if (this.this$0.a != null)
        {
          paramString = str1;
          if (this.this$0.a.HE != null)
          {
            paramString = str1;
            if (this.this$0.a.HE.size() > 0) {
              paramString = ((TroopInfo)this.this$0.a.HE.get(0)).troopuin;
            }
          }
        }
        anot.a(this.this$0.app, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.this$0.b.a(this.this$0.mActivity, this.this$0.app, this.this$0.app.getAccount(), this.this$0.sessionInfo.aTl, new yco(this));
      }
    }
    do
    {
      return;
      if (this.this$0.structingMsg != null) {
        kbp.a(this.this$0.app, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l), "", "" + this.this$0.structingMsg.msgId, ycd.a(this.this$0), false);
      }
      this.this$0.showLoading(2131697483);
      this.this$0.followPublicAccount();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.this$0.structingMsg != null) {
          kbp.a(this.this$0.app, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l), "", "" + this.this$0.structingMsg.msgId, "" + ycd.a(this.this$0), false);
        }
        if (ycd.c(this.this$0))
        {
          ycd.a(this.this$0, str2);
          str1 = "";
          paramString = str1;
          if (this.this$0.a != null)
          {
            paramString = str1;
            if (this.this$0.a.HE != null)
            {
              paramString = str1;
              if (this.this$0.a.HE.size() > 0) {
                paramString = ((TroopInfo)this.this$0.a.HE.get(0)).troopuin;
              }
            }
          }
          anot.a(this.this$0.app, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        this.this$0.cgQ();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    this.this$0.showLoading(2131697483);
    ycd.a(this.this$0, kaw.a().a(this.this$0.sessionInfo.aTl, 0, false, BaseApplication.getContext(), this.this$0.app, new ycp(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycn
 * JD-Core Version:    0.7.0.1
 */