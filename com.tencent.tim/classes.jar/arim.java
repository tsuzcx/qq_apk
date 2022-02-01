import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.RotateableView;

public class arim
  extends Handler
{
  public arim(RotateableView paramRotateableView) {}
  
  public void handleMessage(Message paramMessage)
  {
    RotateableView.a(this.b, RotateableView.a(this.b) + 8.0F);
    if (RotateableView.a(this.b) >= 360.0F) {
      RotateableView.a(this.b, RotateableView.a(this.b) - 360.0F);
    }
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arim
 * JD-Core Version:    0.7.0.1
 */