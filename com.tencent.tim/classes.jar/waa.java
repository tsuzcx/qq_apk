import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class waa
  extends acnd
{
  public waa(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "onGetGroupInviteStatus success:" + paramBoolean + " group_members_num:" + paramInt2 + " group_friends_num:" + paramInt3 + " friends_uins:" + paramArrayList + " status:" + paramInt4);
    }
    if (this.this$0.mUiHandler != null) {
      this.this$0.mUiHandler.removeCallbacks(this.this$0.eb);
    }
    if (this.this$0.J != null) {
      this.this$0.J.dismiss();
    }
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (this.this$0)
      {
        this.this$0.pK = paramArrayList;
        this.this$0.bLD = paramInt3;
        this.this$0.bLC = paramInt2;
        this.this$0.iStatus = paramInt4;
        paramInt1 = paramInt4;
        if (paramInt4 == 5)
        {
          paramInt1 = paramInt4;
          if (this.this$0.bbf)
          {
            paramInt1 = paramInt4;
            if (this.this$0.mActivity != null)
            {
              paramInt1 = paramInt4;
              if (!this.this$0.mActivity.isFinishing())
              {
                this.this$0.bbf = false;
                this.this$0.mUiHandler.postDelayed(this.this$0.ed, 1000L);
                paramInt1 = paramInt4;
              }
            }
          }
        }
        if (paramInt1 != 6) {
          if (this.this$0.bbe)
          {
            paramArrayList = "1";
            aqfr.b("Grp_AIO", "invite", "in_exp", 0, 0, new String[] { paramArrayList, String.valueOf(paramInt1) });
            TroopInviteStatusFragment.a(this.this$0);
            return;
          }
        }
      }
      switch (paramInt1)
      {
      default: 
        QQToast.a(this.this$0.mActivity, 1, acfp.m(2131715827), 0).show(this.this$0.mActivity.getTitleBarHeight()).show();
        paramInt1 = paramInt4;
        break;
      case 1282: 
      case 1283: 
      case 1284: 
      case 1285: 
        synchronized (this.this$0)
        {
          this.this$0.pK = paramArrayList;
          this.this$0.bLD = paramInt3;
          this.this$0.bLC = paramInt2;
          this.this$0.iStatus = 6;
          paramInt1 = 6;
        }
        paramArrayList = "2";
        continue;
        aqfr.b("Grp_AIO", "invite", "in_past", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     waa
 * JD-Core Version:    0.7.0.1
 */