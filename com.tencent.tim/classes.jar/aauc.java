import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class aauc
  extends aatv
{
  private final String TAG = "PacmanTextItem";
  private aatq a;
  public aatr a;
  private aatq b;
  private boolean bzx;
  private int ckv = 1;
  private int ckw = 15;
  int ckx = -1;
  int cky = -1;
  private Bitmap ew;
  private Bitmap ex;
  int mCurPos;
  private Paint mPaint = new Paint();
  public int mState;
  String mWording;
  
  public aauc(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString, aatr paramaatr, float paramFloat4, float paramFloat5, Bitmap paramBitmap1, Bitmap paramBitmap2, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    p(8, paramFloat1);
    p(9, paramFloat2);
    p(6, paramFloat4);
    p(7, paramFloat5);
    p(5, g(paramFloat3, paramFloat1 * paramFloat2));
    this.mWording = paramString;
    this.jdField_a_of_type_Aatr = paramaatr;
    this.mCurPos = 0;
    this.jdField_a_of_type_Aatq = new aatq(ci(this.mCurPos), this.jdField_a_of_type_Aatr, paramTypeface);
    this.jdField_a_of_type_Aatq.rL = (this.jdField_a_of_type_Aatr.rM + paramFloat4 + this.jdField_a_of_type_Aatr.rN);
    this.b = new aatq(ci(this.mCurPos + 50), this.jdField_a_of_type_Aatr, paramTypeface);
    this.b.rL = (this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth);
    this.mPaint.setAntiAlias(true);
    this.mState = 1;
    this.bzx = true;
    paramFloat2 = this.jdField_a_of_type_Aatq.a.mWidth + paramaatr.rM + paramaatr.rN;
    paramFloat1 = paramFloat2;
    if (this.b.bfJ) {
      paramFloat1 = paramFloat2 + this.b.a.mWidth;
    }
    p(3, paramFloat1);
    p(4, paramaatr.rM);
    this.ew = paramBitmap1;
    this.ex = paramBitmap2;
    this.ckx = -1;
    this.cky = -1;
  }
  
  private boolean Xo()
  {
    if (this.jdField_a_of_type_Aatq != null)
    {
      float f3 = q(6);
      float f4 = q(4) / 2.0F;
      float f2 = this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth;
      float f1 = f2;
      if (this.b != null)
      {
        f1 = f2;
        if (this.b.bfJ) {
          f1 = f2 + this.b.a.mWidth;
        }
      }
      if ((f4 + f3 > f1) || (f1 < 0.0F)) {
        return false;
      }
    }
    return true;
  }
  
  private void b(Canvas paramCanvas, RenderBuffer paramRenderBuffer)
  {
    boolean bool;
    if (this.ckv % this.ckw == 0)
    {
      if (!this.bzx)
      {
        bool = true;
        this.bzx = bool;
        this.ckv = 1;
      }
    }
    else
    {
      this.ckv += 1;
      if (paramCanvas == null) {
        break label160;
      }
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      if (!this.bzx) {
        break label152;
      }
      paramRenderBuffer = this.ew;
      paramCanvas.drawBitmap(paramRenderBuffer, new Rect(0, 0, paramRenderBuffer.getWidth(), paramRenderBuffer.getHeight()), new RectF(q(6), q(7), q(6) + this.jdField_a_of_type_Aatr.rM, q(7) + this.jdField_a_of_type_Aatr.rM), this.mPaint);
    }
    label152:
    label160:
    while (paramRenderBuffer == null) {
      for (;;)
      {
        return;
        bool = false;
        break;
        paramRenderBuffer = this.ex;
      }
    }
    if (this.ckx < 0) {
      this.ckx = GlUtil.createTexture(3553, this.ew);
    }
    if (this.cky < 0) {
      this.cky = GlUtil.createTexture(3553, this.ex);
    }
    if (this.bzx) {}
    for (int i = this.ckx;; i = this.cky)
    {
      a(paramRenderBuffer, i, this.jdField_a_of_type_Aatr.rM, this.jdField_a_of_type_Aatr.rM, null, q(6), q(7));
      return;
    }
  }
  
  private String ci(int paramInt)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.mWording))
    {
      localObject = "";
      return localObject;
    }
    if (this.mWording.length() <= paramInt) {
      return "";
    }
    if (this.mWording.length() > paramInt + 50) {}
    for (String str = this.mWording.substring(paramInt, paramInt + 50);; str = this.mWording.substring(paramInt, this.mWording.length()))
    {
      localObject = str;
      if (str != null) {
        break;
      }
      return "";
    }
  }
  
  private float g(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat2;
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    if (!Xo()) {}
    while (this.jdField_a_of_type_Aatq == null) {
      return;
    }
    if (this.jdField_a_of_type_Aatq.rL >= q(6) + this.jdField_a_of_type_Aatr.rM / 2.0F) {
      this.jdField_a_of_type_Aatq.a(paramRenderBuffer, null, this.jdField_a_of_type_Aatq.rL, q(7));
    }
    for (;;)
    {
      if ((this.b != null) && (this.b.bfJ)) {
        this.b.a(paramRenderBuffer, null, this.b.rL, q(7));
      }
      b(null, paramRenderBuffer);
      return;
      float f1 = q(6) + this.jdField_a_of_type_Aatr.rM / 2.0F;
      if (f1 > 0.0F)
      {
        f1 -= this.jdField_a_of_type_Aatq.rL;
        float f2 = q(3);
        float f3 = q(4);
        QLog.d("PacmanTextItem", 2, "draw area:" + f1 + "-" + 0.0F + "-" + f2 + "-" + f3);
        this.jdField_a_of_type_Aatq.a(paramRenderBuffer, new RectF(f1, 0.0F, f2, f3), f1 + this.jdField_a_of_type_Aatq.rL, q(7));
      }
      else
      {
        this.jdField_a_of_type_Aatq.a(paramRenderBuffer, null, this.jdField_a_of_type_Aatq.rL, q(7));
      }
    }
  }
  
  public void ay(float paramFloat)
  {
    if (this.mState == 1)
    {
      p(6, q(6) + paramFloat);
      if (this.jdField_a_of_type_Aatq != null) {
        break label49;
      }
    }
    label49:
    Object localObject;
    float f1;
    float f2;
    do
    {
      return;
      p(6, q(6) + paramFloat / 2.0F);
      break;
      localObject = this.jdField_a_of_type_Aatq;
      ((aatq)localObject).rL += paramFloat;
      if (this.b != null)
      {
        localObject = this.b;
        ((aatq)localObject).rL += paramFloat;
      }
      paramFloat = q(6);
      f1 = q(4) / 2.0F;
      f2 = this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth;
    } while ((paramFloat + f1 <= f2) && (f2 >= 0.0F));
    if ((this.b != null) && (this.b.bfJ))
    {
      localObject = this.jdField_a_of_type_Aatq;
      this.jdField_a_of_type_Aatq = this.b;
      this.b = ((aatq)localObject);
      this.mCurPos += 50;
      localObject = ci(this.mCurPos + 50);
      this.b.setText((String)localObject);
      f1 = q(3);
      paramFloat = f1;
      if (this.b.bfJ)
      {
        this.b.rL = (this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth);
        paramFloat = f1 + this.b.a.mWidth;
      }
      p(3, paramFloat);
      return;
    }
    p(3, 0.0F);
  }
  
  public void az(float paramFloat)
  {
    p(6, paramFloat);
    if ((this.jdField_a_of_type_Aatq != null) && (this.jdField_a_of_type_Aatq.bfJ))
    {
      this.jdField_a_of_type_Aatq.rL = (this.jdField_a_of_type_Aatr.rM + paramFloat + this.jdField_a_of_type_Aatr.rN);
      if (this.b != null) {
        this.b.rL = (this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!Xo()) {}
    float f1;
    do
    {
      return;
      f1 = q(6) + this.jdField_a_of_type_Aatr.rM / 2.0F;
      if (f1 > 0.0F)
      {
        paramCanvas.save();
        paramCanvas.clipRect(f1, q(7), paramCanvas.getWidth(), q(7) + q(4));
      }
      float f2 = q(7);
      if (this.jdField_a_of_type_Aatq != null)
      {
        this.jdField_a_of_type_Aatq.draw(paramCanvas, this.jdField_a_of_type_Aatq.rL, f2);
        if ((this.b != null) && (this.b.bfJ)) {
          this.b.draw(paramCanvas, this.b.rL, f2);
        }
      }
      if (f1 > 0.0F) {
        paramCanvas.restore();
      }
    } while (f1 + this.jdField_a_of_type_Aatr.rM / 2.0F <= 0.0F);
    b(paramCanvas, null);
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString.equals(this.mWording));
        this.mWording = paramString;
      } while (this.jdField_a_of_type_Aatq == null);
      paramString = ci(this.mCurPos);
      boolean bool = this.jdField_a_of_type_Aatq.bfJ;
      float f3 = this.jdField_a_of_type_Aatq.a.mWidth;
      float f1 = q(3);
      this.jdField_a_of_type_Aatq.setText(paramString);
      float f2 = f1;
      if (bool) {
        f2 = f1 - f3;
      }
      f1 = f2;
      if (this.jdField_a_of_type_Aatq.bfJ) {
        f1 = f2 + this.jdField_a_of_type_Aatq.a.mWidth;
      }
      f3 = f1;
      if (this.b != null)
      {
        bool = this.b.bfJ;
        f3 = this.b.a.mWidth;
        paramString = ci(this.mCurPos + 50);
        this.b.setText(paramString);
        this.b.rL = (this.jdField_a_of_type_Aatq.rL + this.jdField_a_of_type_Aatq.a.mWidth);
        f2 = f1;
        if (bool) {
          f2 = f1 - f3;
        }
        f3 = f2;
        if (this.b.bfJ) {
          f3 = f2 + this.b.a.mWidth;
        }
      }
      p(3, f3);
    } while ((this.b == null) || (!QLog.isColorLevel()));
    QLog.d("PacmanTextItem", 2, "PacmanTextItem settext: ManPOSX:" + q(6) + " param_width:" + q(3) + " isvalid:" + this.jdField_a_of_type_Aatq.bfJ + "-" + this.b.bfJ + " width:" + this.jdField_a_of_type_Aatq.a.mWidth + "-" + this.b.a.mWidth + " posx:" + this.jdField_a_of_type_Aatq.rL + "-" + this.b.rL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauc
 * JD-Core Version:    0.7.0.1
 */