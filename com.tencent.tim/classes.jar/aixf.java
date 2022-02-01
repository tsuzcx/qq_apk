import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;

public class aixf
  extends Handler
{
  public aixf(LyricViewInternal paramLyricViewInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.this$0.requestLayout();
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixf
 * JD-Core Version:    0.7.0.1
 */