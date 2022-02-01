import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifIndex8;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class afra
  extends NativeGifIndex8
{
  private boolean cau;
  private boolean cav;
  private boolean mRunning = true;
  
  public afra(File paramFile, int paramInt, boolean paramBoolean)
    throws IOException
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void doApplyNextFrame()
  {
    super.doApplyNextFrame();
    if (this.cav)
    {
      this.cav = false;
      this.cau = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.mRunning) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      if (!this.cau) {
        break;
      }
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
    return;
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.cau)
      {
        this.cav = true;
        super.reset();
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
  
  public void start()
  {
    this.mRunning = true;
  }
  
  public void stop()
  {
    this.mRunning = false;
    this.cau = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afra
 * JD-Core Version:    0.7.0.1
 */