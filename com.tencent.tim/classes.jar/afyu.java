import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.wiget.FrameAnimationDrawable.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@Deprecated
public class afyu
  extends Drawable
  implements Handler.Callback
{
  private boolean bQS;
  private Rect bX;
  private Handler bm;
  private int cLs;
  private volatile boolean cbS;
  private Bitmap eY;
  private String[] ff;
  private int mCurPos;
  private long mDuration = 1000L;
  private Paint mPaint = new Paint(1);
  private long py;
  
  public afyu()
  {
    this.mPaint.setAntiAlias(true);
    this.bm = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void ddY()
  {
    Object localObject;
    if ((this.mCurPos >= 0) && (this.mCurPos < this.cLs))
    {
      localObject = this.ff[this.mCurPos];
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject = afxw.decodeFile((String)localObject, localOptions);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.eY = ((Bitmap)localObject);
        ThreadManager.getUIHandler().post(new FrameAnimationDrawable.1(this));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FrameAnimationDrawable", 2, "updateCurBitmap fail.", localException);
    }
  }
  
  public void T(String[] paramArrayOfString)
  {
    int i = 0;
    stopAnimation();
    this.ff = paramArrayOfString;
    this.mCurPos = 0;
    if (this.ff == null)
    {
      this.cLs = i;
      if (this.cLs != 0) {
        break label56;
      }
    }
    label56:
    for (long l = 0L;; l = this.mDuration / this.cLs)
    {
      this.py = l;
      ddY();
      return;
      i = this.ff.length;
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.eY != null) && (!this.eY.isRecycled()))
    {
      if (this.bX == null) {
        this.bX = new Rect();
      }
      this.bX.set(0, 0, this.eY.getWidth(), this.eY.getHeight());
      paramCanvas.drawBitmap(this.eY, this.bX, getBounds(), this.mPaint);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.mCurPos += 1;
      if (this.bQS) {
        this.mCurPos %= this.cLs;
      }
      if ((this.mCurPos >= 0) && (this.mCurPos < this.cLs))
      {
        long l1 = System.currentTimeMillis();
        ddY();
        if (this.cbS)
        {
          long l2 = System.currentTimeMillis();
          l1 = Math.max(this.py - (l2 - l1), 0L);
          this.bm.sendEmptyMessageDelayed(10, l1);
        }
      }
      else
      {
        this.cbS = false;
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    int i;
    if (this.ff == null)
    {
      i = 0;
      this.cLs = i;
      if (this.cLs != 0) {
        break label43;
      }
    }
    label43:
    for (paramLong = 0L;; paramLong = this.mDuration / this.cLs)
    {
      this.py = paramLong;
      return;
      i = this.ff.length;
      break;
    }
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.bQS = paramBoolean;
  }
  
  public void startAnimation()
  {
    if (!this.cbS)
    {
      this.cbS = true;
      this.bm.removeMessages(10);
      this.bm.sendEmptyMessage(10);
    }
  }
  
  public void stopAnimation()
  {
    if (this.cbS)
    {
      this.cbS = false;
      this.bm.removeMessages(10);
      this.mCurPos = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyu
 * JD-Core Version:    0.7.0.1
 */