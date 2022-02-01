import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vzz
  extends achq
{
  public vzz(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if ((this.this$0.J != null) && (this.this$0.J.isShowing())) {
      this.this$0.J.dismiss();
    }
    if (!paramBoolean)
    {
      paramString1 = this.this$0.mActivity.getResources().getString(2131719483);
      if (TextUtils.isEmpty(paramString3)) {
        break label175;
      }
    }
    for (;;)
    {
      QQToast.a(this.this$0.mActivity, 1, paramString3, 0).show(this.this$0.mActivity.getTitleBarHeight());
      return;
      paramString1 = this.this$0.mActivity.getResources().getString(2131694020);
      QQToast.a(this.this$0.mActivity, 2, paramString1, 0).show(this.this$0.mActivity.getTitleBarHeight());
      this.this$0.iStatus = -1;
      TroopInviteStatusFragment.a(this.this$0);
      this.this$0.bbf = true;
      this.this$0.mUiHandler.post(this.this$0.ec);
      return;
      label175:
      paramString3 = paramString1;
    }
  }
  
  protected void iv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInviteStatusFragment", 2, "onSendSystemMsgActionError logStr:" + paramString);
    }
    if ((this.this$0.J != null) && (this.this$0.J.isShowing()))
    {
      this.this$0.J.dismiss();
      paramString = this.this$0.mActivity.getResources().getString(2131720702);
      QQToast.a(this.this$0.mActivity, 1, paramString, 0).show(this.this$0.mActivity.getTitleBarHeight()).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */