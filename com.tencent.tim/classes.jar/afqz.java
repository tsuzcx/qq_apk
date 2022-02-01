import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class afqz
  extends NativeGifImage
{
  boolean cas = false;
  private boolean cat;
  private boolean restart;
  private boolean running = true;
  
  public afqz(File paramFile, int paramInt, boolean paramBoolean)
    throws IOException
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void doApplyNextFrame()
  {
    if ((QLog.isColorLevel()) && (this.cas)) {
      QLog.d("VoiceGifImage", 2, "doApplyNextFrame");
    }
    super.doApplyNextFrame();
    if (this.cat)
    {
      this.cat = false;
      this.restart = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.running) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null)
      {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
        if ((QLog.isColorLevel()) && (this.cas)) {
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running ");
        }
      }
    }
    label57:
    do
    {
      do
      {
        do
        {
          break label57;
          break label57;
          do
          {
            return;
          } while ((!QLog.isColorLevel()) || (!this.cas));
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running, mFirstFrameBitmap is null");
          return;
          if (!this.restart) {
            break;
          }
          if (this.mFirstFrameBitmap != null) {
            paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
          }
          for (;;)
          {
            if (sPaused) {
              break label161;
            }
            executeNewTask();
            if ((!QLog.isColorLevel()) || (!this.cas)) {
              break;
            }
            QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart  !sPaused");
            return;
            if ((QLog.isColorLevel()) && (this.cas)) {
              QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart, mFirstFrameBitmap is null");
            }
          }
        } while (this.mIsInPendingAction);
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      } while ((!QLog.isColorLevel()) || (!this.cas));
      QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !mIsInPendingAction  !mIsInPendingAction");
      return;
      super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    } while ((!QLog.isColorLevel()) || (!this.cas));
    label161:
    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw else");
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.restart)
      {
        this.cat = true;
        super.reset();
        if ((QLog.isColorLevel()) && (this.cas)) {
          QLog.d("VoiceGifImage", 2, "getNextFrame restart");
        }
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
  
  public void start()
  {
    this.running = true;
    if ((QLog.isColorLevel()) && (this.cas)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame start");
    }
  }
  
  public void stop()
  {
    this.running = false;
    this.restart = true;
    if ((QLog.isColorLevel()) && (this.cas)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqz
 * JD-Core Version:    0.7.0.1
 */