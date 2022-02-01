import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ajnw
  extends ImageSpan
{
  private int djV;
  private WeakReference<Drawable.Callback> e;
  private String imageUrl;
  private Context mContext;
  private URLDrawable mDrawable;
  
  public ajnw(Context paramContext, int paramInt1, String paramString, int paramInt2, Drawable.Callback paramCallback)
  {
    super(paramContext, paramInt1, 0);
    this.mContext = paramContext;
    this.imageUrl = paramString;
    this.djV = paramInt2;
    if (paramCallback != null) {
      this.e = new WeakReference(paramCallback);
    }
  }
  
  public ajnw(Context paramContext, int paramInt, String paramString, Drawable.Callback paramCallback)
  {
    this(paramContext, paramInt, paramString, 0, paramCallback);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    if ((paramCharSequence instanceof URLDrawable))
    {
      paramInt2 = 0;
      paramInt1 = 0;
      if (((URLDrawable)paramCharSequence).getStatus() == 1)
      {
        paramInt4 = paramCharSequence.getIntrinsicWidth();
        i = paramCharSequence.getIntrinsicHeight();
        paramInt1 = i;
        paramInt2 = paramInt4;
        if (i > this.djV)
        {
          paramInt1 = i;
          paramInt2 = paramInt4;
          if (this.djV > 0)
          {
            paramInt2 = paramInt4 * this.djV / i;
            paramInt1 = this.djV;
          }
        }
        paramPaint = this.mDrawable;
        if (paramInt2 <= 0) {
          break label221;
        }
        paramInt4 = paramInt2;
        if (paramInt1 <= 0) {
          break label227;
        }
      }
    }
    label221:
    label227:
    for (int i = paramInt1;; i = 0)
    {
      paramPaint.setBounds(0, 0, paramInt4, i);
      if (QLog.isColorLevel()) {
        QLog.i("UrlBottomImageSpan", 2, "draw status:" + ((URLDrawable)paramCharSequence).getStatus() + " width:" + paramInt2 + " height:" + paramInt1);
      }
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      paramInt4 = 0;
      break;
    }
  }
  
  public Drawable getDrawable()
  {
    if (this.mDrawable != null) {
      return this.mDrawable;
    }
    if (this.imageUrl != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      for (;;)
      {
        try
        {
          this.mDrawable = URLDrawable.getDrawable(this.imageUrl, (URLDrawable.URLDrawableOptions)localObject1);
          if (this.e != null)
          {
            localObject1 = (Drawable.Callback)this.e.get();
            if (localObject1 != null) {
              this.mDrawable.setCallback((Drawable.Callback)localObject1);
            }
            this.mDrawable.setURLDrawableListener(new ajnx(this));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder().append("getDrawable. first get url:").append(this.imageUrl).append("  cb:");
              if (localObject1 == null) {
                break label180;
              }
              bool = true;
              QLog.i("UrlBottomImageSpan", 2, bool);
            }
            return this.mDrawable;
          }
        }
        catch (Throwable localThrowable)
        {
          this.mDrawable = null;
          QLog.e("UrlBottomImageSpan", 2, "getDrawable error: " + localThrowable.getMessage());
          return super.getDrawable();
        }
        Object localObject2 = null;
        continue;
        label180:
        boolean bool = false;
      }
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt2 = 0;
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    int i;
    int j;
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1))
    {
      i = paramCharSequence.getIntrinsicWidth();
      j = paramCharSequence.getIntrinsicHeight();
      paramInt2 = j;
      paramInt1 = i;
      if (j > this.djV)
      {
        paramInt2 = j;
        paramInt1 = i;
        if (this.djV > 0)
        {
          paramInt1 = i * this.djV / j;
          paramInt2 = this.djV;
        }
      }
      URLDrawable localURLDrawable = this.mDrawable;
      if (paramInt1 > 0)
      {
        i = paramInt1;
        if (paramInt2 <= 0) {
          break label293;
        }
        j = paramInt2;
        label113:
        localURLDrawable.setBounds(0, 0, i, j);
      }
    }
    for (;;)
    {
      paramCharSequence = paramCharSequence.getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        j = paramPaint.bottom - paramPaint.top;
        int k = paramCharSequence.bottom - paramCharSequence.top;
        i = k / 2 - j / 4;
        k /= 2;
        j = j / 4 + k;
        paramFontMetricsInt.ascent = (-j);
        paramFontMetricsInt.top = (-j);
        paramFontMetricsInt.bottom = i;
        paramFontMetricsInt.descent = i;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UrlBottomImageSpan", 2, "getSize size:" + paramCharSequence.right + " width:" + paramInt1 + " height:" + paramInt2 + " imageUrl:" + this.imageUrl);
      }
      return paramCharSequence.right;
      i = 0;
      break;
      label293:
      j = 0;
      break label113;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnw
 * JD-Core Version:    0.7.0.1
 */