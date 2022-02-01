import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class jhd
  implements jhc
{
  final String TAG = getClass().getSimpleName() + "_" + AudioHelper.hG();
  public ijn a;
  protected jhc.a a;
  protected int azH;
  protected int azI;
  protected Bitmap bd;
  protected float hY;
  protected int mAlpha = 255;
  protected Canvas mCanvas = new Canvas();
  protected Context mContext;
  protected int mCurrentX;
  protected int mCurrentY;
  protected int mHeight;
  protected boolean mLoop;
  protected Paint mPaint;
  protected int mTextSize = 24;
  WeakReference<ZimuView> mViewRef;
  protected int mWidth;
  
  public jhd(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    this.mContext = paramContext;
    this.mPaint = new Paint(1);
    this.hY = paramFloat;
    this.azH = paramInt1;
    this.azI = paramInt2;
    this.mViewRef = paramWeakReference;
  }
  
  Bitmap H()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ijn.l)) {
      localObject3 = localObject1;
    }
    do
    {
      for (;;)
      {
        return localObject3;
        igd.aJ(this.TAG, "build:" + toString());
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
            QLog.e(this.TAG, 2, localOutOfMemoryError.getMessage());
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          localObject3 = localOutOfMemoryError;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, localException.getMessage());
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
    Typeface localTypeface = this.mPaint.getTypeface();
    if ((localTypeface != paramTypeface) || (paramInt != this.mPaint.getTextSize())) {
      QLog.w(this.TAG, 1, "setFontAttr, Typeface[" + localTypeface + "->" + paramTypeface + "], TextSize[" + this.mPaint.getTextSize() + "->" + paramInt + "]");
    }
    if (paramTypeface != null) {
      this.mPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_Jhc$a = parama;
    this.mPaint.setTextSize(paramInt);
    releaseBitmap();
    if (this.jdField_a_of_type_Ijn != null) {}
    for (paramTypeface = this.jdField_a_of_type_Ijn.l;; paramTypeface = null)
    {
      paramTypeface = (String)paramTypeface;
      this.mWidth = b(this.mPaint, paramTypeface);
      this.mHeight = c(this.mPaint);
      return;
    }
  }
  
  public void a(ijn paramijn)
  {
    releaseBitmap();
    Object localObject;
    if (this.jdField_a_of_type_Ijn != null)
    {
      localObject = this.jdField_a_of_type_Ijn.m;
      localObject = (String)localObject;
      this.jdField_a_of_type_Ijn = paramijn;
      if ((this.jdField_a_of_type_Ijn != null) && (!this.jdField_a_of_type_Ijn.isEnd()) && (paramijn != null) && (TextUtils.isEmpty(paramijn.m)) && (localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_Ijn.m = ((CharSequence)localObject);
      }
      if (this.jdField_a_of_type_Ijn == null) {
        break label124;
      }
    }
    label124:
    for (paramijn = this.jdField_a_of_type_Ijn.l;; paramijn = null)
    {
      paramijn = (String)paramijn;
      this.mWidth = b(this.mPaint, paramijn);
      return;
      localObject = null;
      break;
    }
  }
  
  protected int b(Paint paramPaint, String paramString)
  {
    float f3 = 0.0F;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      float[] arrayOfFloat = new float[j + 1];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      int i = 0;
      for (f1 = 0.0F;; f1 = f2 + f1)
      {
        f2 = f1;
        if (i >= j) {
          break;
        }
        f2 = arrayOfFloat[i];
        i += 1;
      }
    }
    float f2 = 0.0F;
    float f1 = f3;
    if (this.jdField_a_of_type_Jhc$a != null) {
      f1 = this.jdField_a_of_type_Jhc$a.hX;
    }
    return (int)Math.ceil(f2 + f1 / 2.0F);
  }
  
  protected int c(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    float f1 = paramPaint.descent;
    float f2 = paramPaint.ascent;
    return (int)(paramPaint.leading + (f1 - f2));
  }
  
  protected abstract void d(Canvas paramCanvas, int paramInt1, int paramInt2);
  
  public int getCurrentX()
  {
    return this.mCurrentX;
  }
  
  public int getHeight()
  {
    if (this.mHeight == 0) {
      this.mHeight = c(this.mPaint);
    }
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isRecycle()
  {
    return this.mLoop;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public int mu()
  {
    return this.mCurrentY;
  }
  
  public void recycle() {}
  
  public void release()
  {
    this.mPaint.setTypeface(null);
    this.mPaint = null;
    releaseBitmap();
  }
  
  public void releaseBitmap()
  {
    igd.aJ(this.TAG, "releaseBitmap:" + this.bd);
    if (this.bd != null)
    {
      if (!this.bd.isRecycled()) {
        this.bd.recycle();
      }
      this.bd = null;
    }
  }
  
  void requestRender()
  {
    if (this.mViewRef.get() != null) {
      ((ZimuView)this.mViewRef.get()).requestRender();
    }
  }
  
  public void setPosition(int paramInt1, int paramInt2)
  {
    this.mCurrentX = paramInt1;
    this.mCurrentY = paramInt2;
  }
  
  public void setRecycle(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void start(long paramLong)
  {
    igd.aJ(this.TAG, "start:" + paramLong);
  }
  
  public String toString()
  {
    return "ZimuItemView{mFontPara=" + this.jdField_a_of_type_Jhc$a.toString() + ", getTypeface=" + this.mPaint.getTypeface() + ", mTextSize=" + this.mTextSize + ", mAlpha=" + this.mAlpha + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mCurrentX=" + this.mCurrentX + ", mCurrentY=" + this.mCurrentY + ", mSentenceInfo=" + this.jdField_a_of_type_Ijn.toString() + ", mBitmapCache=" + this.bd + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhd
 * JD-Core Version:    0.7.0.1
 */