import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class awil
  extends Handler
{
  awil(awij paramawij, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    if (this.o.getCallback() == null) {}
    do
    {
      do
      {
        return;
      } while ((paramMessage.what != 1000) || (!awij.a(this.o).Hw) || (!awij.a(this.o)));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.o.startTime) / (1000.0F / awij.a(this.o).frameRate));
      int i;
      if ((awij.b(this.o)) && (awij.a(this.o).c.getFrameCount() != 0)) {
        i = k % awij.a(this.o).c.getFrameCount();
      }
      for (;;)
      {
        awij.a(this.o).c.setFrame(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / awij.a(this.o).frameRate;
        this.o.uiHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.o.invalidateSelf();
        return;
        i = k;
        if (k >= awij.a(this.o).c.getFrameCount())
        {
          j = 1;
          i = k;
        }
      }
      this.o.stop();
      this.o.invalidateSelf();
    } while (this.o.b == null);
    this.o.b.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awil
 * JD-Core Version:    0.7.0.1
 */