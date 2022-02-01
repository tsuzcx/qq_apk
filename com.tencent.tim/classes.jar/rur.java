import android.os.CountDownTimer;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;

public class rur
  extends CountDownTimer
{
  public rur(QRDisplayActivity paramQRDisplayActivity, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    QRDisplayActivity.a(this.this$0, true);
    if (QRDisplayActivity.a(this.this$0) == null)
    {
      QRDisplayActivity.b(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 4, "enter longclick");
      }
    }
    do
    {
      do
      {
        return;
      } while (QRDisplayActivity.a(this.this$0) == null);
      QRDisplayActivity.c(this.this$0);
    } while (!QLog.isColorLevel());
    QLog.d("QRDisplayActivity", 4, "enter longclickstop");
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rur
 * JD-Core Version:    0.7.0.1
 */