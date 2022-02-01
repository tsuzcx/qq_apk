import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.26;

public class zks
  implements View.OnTouchListener
{
  public zks(QRDisplayActivity.26 param26) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
      } while (QRDisplayActivity.a(this.a.this$0) == null);
      QRDisplayActivity.a(this.a.this$0, false);
      QRDisplayActivity.a(this.a.this$0).start();
      return true;
      if (QRDisplayActivity.a(this.a.this$0) != null) {
        QRDisplayActivity.a(this.a.this$0).cancel();
      }
    } while ((QRDisplayActivity.a(this.a.this$0)) || (paramMotionEvent.getAction() != 1));
    bgyd.c(this.a.this$0.d);
    this.a.this$0.onClick(this.a.this$0.d);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zks
 * JD-Core Version:    0.7.0.1
 */