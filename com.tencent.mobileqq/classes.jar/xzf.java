import android.os.CountDownTimer;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;

public class xzf
  extends CountDownTimer
{
  public xzf(QRDisplayActivity paramQRDisplayActivity, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    QRDisplayActivity.a(this.a, true);
    if (QRDisplayActivity.a(this.a) == null)
    {
      QRDisplayActivity.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 4, "enter longclick");
      }
    }
    do
    {
      do
      {
        return;
      } while (QRDisplayActivity.a(this.a) == null);
      QRDisplayActivity.c(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("QRDisplayActivity", 4, "enter longclickstop");
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzf
 * JD-Core Version:    0.7.0.1
 */