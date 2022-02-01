import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class xyt
  extends acmc
{
  xyt(xys paramxys) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.this$0.mActivity.isFinishing()) {}
    label335:
    label336:
    for (;;)
    {
      return;
      if (this.this$0.a != null) {
        this.this$0.a.dismiss();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.this$0.sessionInfo.aTl)) {
            break label335;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        break;
        if (!paramBoolean) {
          break label336;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(this.this$0.sessionInfo.aTl);
        ujt.a(this.this$0.app, BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = this.this$0.app.a().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = paramPBRepeatMessageField.a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
          if (QLog.isDevelopLevel()) {
            QLog.d(this.this$0.TAG, 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.f(localRecentUser);
        }
        QQToast.a(this.this$0.mActivity, 2, this.this$0.mActivity.getResources().getString(2131720352), 0).show();
        if (this.this$0.aSq) {
          this.this$0.mActivity.setResult(-1);
        }
        this.this$0.finish();
        return;
        QQToast.a(this.this$0.mActivity, this.this$0.mActivity.getResources().getString(2131720350), 0).show();
        return;
      }
    }
  }
  
  public void fN(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!((String)paramList.next()).equals(this.this$0.sessionInfo.aTl));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, String.format("be deleted, current uin: %s", new Object[] { this.this$0.sessionInfo.aTl }));
        }
        this.this$0.finish();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyt
 * JD-Core Version:    0.7.0.1
 */