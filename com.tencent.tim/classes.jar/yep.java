import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class yep
  extends accd
{
  public yep(TroopChatPie paramTroopChatPie) {}
  
  protected void a(apsw.b paramb)
  {
    if ((paramb.dVM == 2) && (paramb.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onTroopGagStatusChange:" + paramb.uin);
      }
      if (this.this$0.sessionInfo.aTl.equals(paramb.uin)) {
        this.this$0.a(paramb.a, true);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramString1.equals(this.this$0.sessionInfo.aTl))
      {
        TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
        TroopInfo localTroopInfo = localTroopManager.c(this.this$0.sessionInfo.aTl);
        if (localTroopInfo == null) {
          break;
        }
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3)) {
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).show();
          }
        }
        while ((this.this$0.sessionInfo.aTl.equals(paramString1)) && (localTroopInfo != null))
        {
          this.this$0.sessionInfo.aTn = localTroopInfo.getTroopName();
          paramString1 = this.this$0.mActivity.getIntent();
          paramString1.putExtra("uinname", localTroopInfo.getTroopName());
          this.this$0.bo(paramString1);
          return;
          localTroopInfo.troopname = paramString2;
          localTroopInfo.hasSetNewTroopName = true;
          if ((this.this$0.mc()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead))
          {
            localTroopInfo.isNewTroop = false;
            apuh.a(this.this$0.app, localTroopInfo, this.this$0.mActivity, new yeq(this));
          }
          localTroopManager.i(localTroopInfo);
          this.this$0.chH();
        }
      }
    }
  }
  
  protected void ar(Object paramObject)
  {
    if (this.this$0.a != null) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
  
  protected void bd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.this$0.mActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.this$0.mActivity.getString(2131698432);; str = this.this$0.mActivity.getString(2131698341))
      {
        QQToast.a(this.this$0.mActivity.getApplicationContext(), 2, str, 1).show(this.this$0.mActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.this$0.mActivity.getApplicationContext(), 1, 2131698431, 1).show(this.this$0.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yep
 * JD-Core Version:    0.7.0.1
 */