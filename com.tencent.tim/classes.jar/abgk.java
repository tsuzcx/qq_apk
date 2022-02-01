import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abgk
  extends wnu
  implements abgl.a
{
  abgl a = abgl.a();
  double bO;
  int mPaddingTop;
  int mRadius;
  List<abgk.b> mStickers;
  Paint mTextPaint = new Paint();
  String uinAndDiyId;
  
  public abgk(Resources paramResources)
  {
    super(paramResources);
  }
  
  public void Bv(String paramString)
  {
    this.uinAndDiyId = paramString;
  }
  
  public Object L()
  {
    return getCallback();
  }
  
  public List<abgk.b> dC()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.mStickers != null)
        {
          localList1 = this.mStickers;
          return localList1;
        }
        List localList1 = this.a.a(this);
        if ((localList1 == null) || (localList1.isEmpty())) {
          break label188;
        }
        this.mStickers = new ArrayList();
        if (i < localList1.size())
        {
          DiyPendantSticker localDiyPendantSticker = (DiyPendantSticker)localList1.get(i);
          int j = -16777216;
          try
          {
            int k = Color.parseColor(localDiyPendantSticker.fontColor);
            j = k;
          }
          catch (Exception localException)
          {
            QLog.e("DiyPendantDrawable", 1, new Object[] { "parse sticker text color failed.", localException.getMessage() });
            continue;
          }
          this.mStickers.add(new abgk.a(i, localDiyPendantSticker.angle, localDiyPendantSticker.text, localDiyPendantSticker.fontId, localDiyPendantSticker.fontType, j));
          i += 1;
          continue;
        }
        localList2 = this.mStickers;
      }
      finally {}
      continue;
      label188:
      List localList2 = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = dC();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((abgk.b)((Iterator)localObject).next()).draw(paramCanvas, this.mPaint);
      }
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = paramRect.width();
    this.mPaddingTop = Math.abs(paramRect.height() - i);
    this.bO = (i / 250.0D);
    this.mRadius = ((int)(100.0D * this.bO));
  }
  
  public class a
    implements abgk.b
  {
    double bP;
    Rect bx = new Rect();
    int mFontColor;
    int mFontId;
    int mFontType;
    int mIndex;
    String mText;
    Rect mTextBounds = new Rect();
    
    a(int paramInt1, double paramDouble, String paramString, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bP = (0.0174532925199433D * paramDouble);
      this.mIndex = paramInt1;
      this.mText = paramString;
      this.mFontColor = paramInt4;
      this.mFontId = paramInt2;
      this.mFontType = paramInt3;
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      Object localObject = abgk.this.a.a(abgk.this, this.mIndex);
      float f;
      if (localObject != null)
      {
        Rect localRect1 = abgk.this.getBounds();
        int i = localRect1.width();
        int j = localRect1.height();
        i = (int)(i / 2 + Math.sin(this.bP) * abgk.this.mRadius);
        j = (int)(j / 2 - Math.cos(this.bP) * abgk.this.mRadius);
        int k = (int)(((Bitmap)localObject).getWidth() * abgk.this.bO);
        int m = (int)(((Bitmap)localObject).getHeight() * abgk.this.bO);
        this.bx.set(i - k / 2, j - m / 2 + abgk.this.mPaddingTop / 2, k / 2 + i, m / 2 + j + abgk.this.mPaddingTop / 2);
        Rect localRect2;
        if (this.bx.left < localRect1.left)
        {
          localRect2 = this.bx;
          localRect2.right += localRect1.left - this.bx.left;
          this.bx.left = localRect1.left;
        }
        if (this.bx.top < localRect1.top)
        {
          localRect2 = this.bx;
          localRect2.bottom += localRect1.top - this.bx.top;
          this.bx.top = localRect1.top;
        }
        if (this.bx.right > localRect1.right)
        {
          localRect2 = this.bx;
          localRect2.left += localRect1.right - this.bx.right;
          this.bx.right = localRect1.right;
        }
        if (this.bx.bottom > localRect1.bottom)
        {
          localRect2 = this.bx;
          localRect2.top += localRect1.bottom - this.bx.bottom;
          this.bx.bottom = localRect1.bottom;
        }
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.bx, paramPaint);
        if (QLog.isColorLevel()) {
          QLog.d("DiyPendantDrawable", 2, "draw sticker index = " + this.mIndex + "scaleFactor=" + abgk.this.bO + ", x=" + i + ", y=" + j + ", w=" + k + ", h=" + m);
        }
        if (!TextUtils.isEmpty(this.mText))
        {
          i = (int)(10.0D * abgk.this.bO);
          this.mTextBounds.set(this.bx.left + i, this.bx.top + i, this.bx.right - i, this.bx.bottom - i);
          f = aqgm.a(abgk.this.mTextPaint, this.mTextBounds, this.mText);
          if (this.mFontType != 1) {
            break label891;
          }
          localObject = new Paint();
          ((Paint)localObject).setTextSize(f);
          i = (int)((Paint)localObject).measureText(this.mText);
          j = (int)Math.min(f + 10.0D * abgk.this.bO, this.mTextBounds.height());
          localObject = abgk.this.a.a(abgk.this, this.mText, this.mFontId, this.mFontType, f, this.mFontColor, i, j, paramPaint);
          if (localObject != null)
          {
            i = this.bx.centerX();
            j = this.bx.centerY();
            this.mTextBounds.set(i - ((Bitmap)localObject).getWidth() / 2, j - ((Bitmap)localObject).getHeight() / 2, i + ((Bitmap)localObject).getWidth() / 2, j + ((Bitmap)localObject).getHeight() / 2);
            paramCanvas.drawBitmap((Bitmap)localObject, null, this.mTextBounds, paramPaint);
          }
          if (QLog.isColorLevel())
          {
            if ("draw textInfo text = " + this.mText + " fontId = " + this.mFontId + " fontType = " + 1 + " color = " + this.mFontColor + " fontBitmap Existed = " + localObject == null) {
              break label885;
            }
            bool = true;
            QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
          }
        }
      }
      label885:
      label891:
      do
      {
        return;
        bool = false;
        break;
        paramPaint = abgk.this.a.a(abgk.this, this.mFontId, this.mFontType);
        if (paramPaint != null) {
          abgk.this.mTextPaint.setTypeface(paramPaint);
        }
        abgk.this.mTextPaint.setColor(this.mFontColor);
        abgk.this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        abgk.this.mTextPaint.setTextSize(f);
        localObject = abgk.this.mTextPaint.getFontMetrics();
        f = (this.mTextBounds.bottom + this.mTextBounds.top - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
        paramCanvas.drawText(this.mText, this.mTextBounds.centerX(), f, abgk.this.mTextPaint);
      } while (!QLog.isColorLevel());
      if ("draw textInfo text = " + this.mText + " fontId = " + this.mFontId + " fontType = " + this.mFontType + " color = " + this.mFontColor + " localTypeFace Existed = " + paramPaint != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgk
 * JD-Core Version:    0.7.0.1
 */