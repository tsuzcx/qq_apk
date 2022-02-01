import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public final class jsm
  implements DialogInterface.OnClickListener
{
  public jsm(int paramInt, QQAppInterface paramQQAppInterface, long paramLong, Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$type == 1)
    {
      zjq.a().a(this.val$app, this.qA, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      this.val$handler.sendEmptyMessage(0);
      l = NetConnInfoCenter.getServerTimeMillis();
      ((ackq)this.val$app.getBusinessHandler(31)).f(String.valueOf(this.qA), true, l);
      return;
    }
    zjq.a().a(this.val$app, this.qA, false, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    this.val$handler.sendEmptyMessage(1);
    long l = NetConnInfoCenter.getServerTimeMillis();
    ((ackq)this.val$app.getBusinessHandler(31)).f(String.valueOf(this.qA), false, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsm
 * JD-Core Version:    0.7.0.1
 */