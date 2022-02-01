import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class ymp
  extends acnd
{
  ymp(ymn paramymn) {}
  
  protected void u(boolean paramBoolean, Object paramObject)
  {
    ymn.a(this.b).removeMessages(1);
    if ((this.b.a == null) || (!this.b.a.isShowing()))
    {
      QLog.e("SeparateForward", 1, new Object[] { "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.b.a != null) {
      this.b.a.dismiss();
    }
    ajlc.a().lD.clear();
    if ((paramBoolean) && (paramObject != null))
    {
      ajlc.a().lD.putAll((Map)paramObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
      }
    }
    for (;;)
    {
      if (ajlc.a().lD.size() != 0) {
        break label201;
      }
      paramObject = (BaseActivity)this.b.ai.get();
      if (paramObject == null) {
        break;
      }
      QQToast.a(paramObject, 2131700605, 0).show(paramObject.getTitleBarHeight());
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
    }
    label201:
    this.b.b((Map)paramObject, ajlc.a().xL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymp
 * JD-Core Version:    0.7.0.1
 */