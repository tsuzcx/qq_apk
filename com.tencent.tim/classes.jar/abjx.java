import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class abjx
  extends abjs<Canvas>
{
  private Rect mDstRect = new Rect();
  private Paint mPaint = new Paint(2);
  private Rect mSrcRect = new Rect();
  
  public boolean a(Canvas paramCanvas, float paramFloat)
  {
    boolean bool = false;
    if (paramCanvas == null) {
      return bool;
    }
    label25:
    abjv localabjv;
    Bitmap localBitmap;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.fj.iterator();
        if (!localIterator.hasNext()) {
          break label360;
        }
        localabjv = (abjv)localIterator.next();
        localabjv.updateState();
        if (!localabjv.isValidate())
        {
          localIterator.remove();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CanvasDisplay", 2, "remove invalidate barrage:" + localabjv);
          continue;
        }
        localBitmap = localabjv.getDrawingCache();
      }
      finally {}
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramCanvas.save();
        if (paramFloat == 1.0F)
        {
          if (this.mPaint.getAlpha() != localabjv.mAlpha) {
            this.mPaint.setAlpha(localabjv.mAlpha);
          }
          label165:
          if (localabjv.mScale <= 0.0F) {
            break label388;
          }
        }
      }
    }
    label388:
    for (float f1 = localabjv.mScale;; f1 = 1.0F)
    {
      float f2 = localabjv.jU;
      float f3 = localabjv.ek;
      float f4 = localabjv.jU;
      float f5 = localabjv.mWidth;
      float f6 = localabjv.ek;
      paramCanvas.clipRect(f2, f3, f4 + f5 * f1, f1 * localabjv.mHeight + f6);
      paramCanvas.translate(localabjv.jU, localabjv.ek);
      if (localabjv.mScale != 0.0F) {
        paramCanvas.scale(localabjv.mScale, localabjv.mScale);
      }
      this.mSrcRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.mDstRect.set(0, 0, localabjv.mWidth, localabjv.mHeight);
      paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.mDstRect, this.mPaint);
      paramCanvas.restore();
      break label25;
      this.mPaint.setAlpha((int)(255.0F * paramFloat));
      break label165;
      label360:
      bool = this.fj.isEmpty();
      if (!bool) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjx
 * JD-Core Version:    0.7.0.1
 */