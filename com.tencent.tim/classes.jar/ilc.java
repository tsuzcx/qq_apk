import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class ilc
  implements jhc
{
  protected boolean Sa = true;
  protected ijn a;
  protected jhc.a a;
  protected Bitmap bd;
  protected int mAlpha = 255;
  protected Canvas mCanvas = new Canvas();
  protected boolean mLoop;
  protected Paint mPaint = new Paint(1);
  protected int mTextSize = 32;
  
  public ilc(ijn paramijn, boolean paramBoolean)
  {
    this.mPaint.setTextSize(this.mTextSize);
    this.jdField_a_of_type_Ijn = paramijn;
    this.mLoop = paramBoolean;
  }
  
  Bitmap H()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ijn.l))
    {
      igd.aJ("ARZimuItemTask", "TextUtils.isEmpty(mSentenceInfo.src_text) == null");
      localObject3 = localObject1;
    }
    do
    {
      for (;;)
      {
        return localObject3;
        igd.aJ("ARZimuItemTask", "build:" + toString());
        localObject1 = localObject3;
        Object localObject2 = localObject4;
        try
        {
          int i = getWidth();
          localObject1 = localObject3;
          localObject2 = localObject4;
          int j = getHeight();
          localObject1 = localObject3;
          localObject2 = localObject4;
          localObject3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localObject1 = localObject3;
          localObject2 = localObject3;
          this.mCanvas.setBitmap((Bitmap)localObject3);
          localObject1 = localObject3;
          localObject2 = localObject3;
          d(this.mCanvas, i, j);
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("ARZimuItemTask", 2, localOutOfMemoryError.getMessage());
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          localObject3 = localOutOfMemoryError;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ARZimuItemTask", 2, localException.getMessage());
    return localOutOfMemoryError;
  }
  
  public Bitmap I()
  {
    if ((this.bd == null) || (this.bd.isRecycled())) {
      this.bd = H();
    }
    return this.bd;
  }
  
  public void a(Typeface paramTypeface, int paramInt, jhc.a parama)
  {
    if (paramTypeface != null) {
      this.mPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_Jhc$a = parama;
    this.mPaint.setTextSize(paramInt);
  }
  
  public void a(ijn paramijn)
  {
    this.jdField_a_of_type_Ijn = paramijn;
    this.bd = null;
    this.Sa = true;
  }
  
  protected abstract void d(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public boolean isValidate()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return this.Sa;
  }
  
  public void setRecycle(boolean paramBoolean) {}
  
  public int x(long paramLong)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilc
 * JD-Core Version:    0.7.0.1
 */