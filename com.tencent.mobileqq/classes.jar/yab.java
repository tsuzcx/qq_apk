import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class yab
  extends altm
{
  public yab(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onKickOutDevFResult isSuccess:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " result:", Integer.valueOf(paramInt1), " index:", Integer.valueOf(paramInt2) });
    }
    if (!paramBoolean)
    {
      if (QRLoginMgrActivity.a(this.a) == null) {
        QRLoginMgrActivity.a(this.a, new HashSet());
      }
      QRLoginMgrActivity.a(this.a).add(Long.valueOf(paramLong));
    }
    if (QRLoginMgrActivity.a(this.a) != null) {
      QRLoginMgrActivity.a(this.a).remove(Long.valueOf(paramLong));
    }
    if ((QRLoginMgrActivity.a(this.a) == null) || (QRLoginMgrActivity.a(this.a).size() == 0))
    {
      QRLoginMgrActivity.a(this.a);
      this.a.finish();
      if ((QRLoginMgrActivity.a(this.a) != null) && (QRLoginMgrActivity.a(this.a).size() > 0)) {
        QQToast.a(this.a.getApplicationContext(), 1, 2131717598, 0).a();
      }
    }
    while (paramInt2 != 100)
    {
      return;
      QQToast.a(this.a.getApplicationContext(), 2, 2131717599, 0).a();
      Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("status", "logout");
      this.a.getApplicationContext().sendBroadcast(localIntent);
      return;
    }
    QRLoginMgrActivity.a(this.a);
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, 2131717624, 0).a();
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, 2131717598, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */