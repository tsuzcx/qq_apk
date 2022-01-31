import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.RotateableView;

public class eyz
  extends Handler
{
  public eyz(RotateableView paramRotateableView) {}
  
  public void handleMessage(Message paramMessage)
  {
    RotateableView.a(this.a, 8.0F);
    if (RotateableView.a(this.a) >= 360.0F) {
      RotateableView.b(this.a, 360.0F);
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eyz
 * JD-Core Version:    0.7.0.1
 */