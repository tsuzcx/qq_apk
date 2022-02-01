import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class arfl
  extends Handler
{
  public arfl(DraggableGridView paramDraggableGridView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    DraggableGridView.c(this.c, paramMessage.arg1);
    DraggableGridView.a(this.c).smoothScrollBy(DraggableGridView.d(this.c), 0);
    DraggableGridView.a(this.c, (int)DraggableGridView.a(this.c), (int)DraggableGridView.b(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfl
 * JD-Core Version:    0.7.0.1
 */