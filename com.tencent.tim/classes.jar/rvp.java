import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class rvp
  extends acfd
{
  public rvp(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onKickOutDevFResult isSuccess:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " result:", Integer.valueOf(paramInt1), " index:", Integer.valueOf(paramInt2) });
    }
    if (!paramBoolean)
    {
      if (QRLoginMgrActivity.a(this.this$0) == null) {
        QRLoginMgrActivity.a(this.this$0, new HashSet());
      }
      QRLoginMgrActivity.a(this.this$0).add(Long.valueOf(paramLong));
    }
    if (QRLoginMgrActivity.a(this.this$0) != null) {
      QRLoginMgrActivity.a(this.this$0).remove(Long.valueOf(paramLong));
    }
    if ((QRLoginMgrActivity.a(this.this$0) == null) || (QRLoginMgrActivity.a(this.this$0).size() == 0))
    {
      QRLoginMgrActivity.a(this.this$0);
      this.this$0.finish();
      if ((QRLoginMgrActivity.a(this.this$0) != null) && (QRLoginMgrActivity.a(this.this$0).size() > 0)) {
        QQToast.a(this.this$0.getApplicationContext(), 1, 2131717175, 0).show();
      }
    }
    while (paramInt2 != 100)
    {
      return;
      QQToast.a(this.this$0.getApplicationContext(), 2, 2131717176, 0).show();
      Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("status", "logout");
      this.this$0.getApplicationContext().sendBroadcast(localIntent);
      return;
    }
    QRLoginMgrActivity.a(this.this$0);
    if (paramBoolean)
    {
      QQToast.a(this.this$0.getApplicationContext(), 2, 2131717202, 0).show();
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, 2131717175, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvp
 * JD-Core Version:    0.7.0.1
 */