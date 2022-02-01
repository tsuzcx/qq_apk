import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class ymo
  extends acfd
{
  ymo(ymn paramymn) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    ymn.a(this.b).removeMessages(1);
    if ((this.b.a == null) || (!this.b.a.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.b.a.dismiss();
      ajlc.a().lD.clear();
      if ((paramBoolean) && (paramObject != null)) {
        ajlc.a().lD.putAll((Map)paramObject);
      }
      if (ajlc.a().lD.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.b.ai.get();
        if (localBaseActivity != null) {
          QQToast.a(this.b.mApp.getApp(), 2131700605, 0).show(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.b.b((Map)paramObject, ajlc.a().xL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymo
 * JD-Core Version:    0.7.0.1
 */