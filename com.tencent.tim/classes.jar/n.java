import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Arrays;

public class n
  extends k
{
  public static boolean aA;
  private int[] L;
  private int[] R;
  private int[] S;
  private int[] T;
  private int[] U;
  private final HiBoomTextView a;
  private Canvas b;
  private int[] codes;
  private Rect dst = new Rect();
  private Paint j;
  private Rect src = new Rect();
  
  public n(HiBoomTextView paramHiBoomTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramHiBoomTextView;
    this.R = new int[2];
    this.S = new int[2];
    this.T = new int[2];
    this.U = new int[3];
  }
  
  private void M()
  {
    if ((this.L != null) && (this.L.length > 5))
    {
      int i = 1;
      while (i < this.L.length)
      {
        int k = this.L[i];
        int m = this.L[(i + 1)];
        int n = this.L[(i + 2)];
        int i1 = this.L[(i + 3)];
        int i2 = this.L[(i + 4)];
        if ((k >= 0) && (k < this.codes.length)) {
          c(this.codes[k], m, n, i1, i2);
        }
        i += 5;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    j.i("HiBoomFont.FounderHiBoomLayout", "drawMissingWord....char:" + String.valueOf((char)paramInt1) + "  code:" + paramInt1 + "  x:" + paramInt2 + "  y:" + paramInt3 + "  width:" + paramInt4 + "  height:" + paramInt5);
    if ((paramInt4 > 0) && (paramInt5 > 0))
    {
      if (this.b != null) {
        break label260;
      }
      this.b = new Canvas(this.d);
    }
    for (;;)
    {
      if (this.j == null)
      {
        this.j = new Paint();
        this.j.setColor(-16777216);
      }
      this.j.setTextSize(paramInt5);
      char c = (char)paramInt1;
      float f1 = paramInt5 / 2.0F;
      float f2 = (this.j.descent() + this.j.ascent()) / 2.0F;
      this.b.drawText(String.valueOf(c), paramInt2, f1 - f2 + paramInt3, this.j);
      if (aA)
      {
        Paint localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(-16776961);
        localPaint.setStrokeWidth(1.0F);
        this.b.drawRect(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5, localPaint);
      }
      return;
      label260:
      this.b.setBitmap(this.d);
    }
  }
  
  private boolean checkData()
  {
    return (this.codes.length > 0) && (this.U[0] > 0) && (this.U[1] > 0);
  }
  
  private void s(String paramString) {}
  
  public void O()
  {
    if ((this.U[0] <= 0) || (this.U[1] <= 0))
    {
      s("bitmap宽高异常");
      return;
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      j.e("HiBoomFont.FounderHiBoomLayout", "动画执行中....");
      return;
    }
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    this.frameIndex = 0;
    i.a().a(this.mFont.mFontId, this.codes, this.R, this.U, this.mFont.mAnimationId, this.M);
    if ((this.M[0] > 0) && (this.M[1] > 0))
    {
      X();
      return;
    }
    j.i("HiBoomFont.FounderHiBoomLayout", "该字体不支持动画....animInfo:" + Arrays.toString(this.M) + "  ttf path:" + this.mFont.mFontPath);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new o(this));
  }
  
  public int a(int paramInt1, int paramInt2, lc paramlc)
  {
    return 0;
  }
  
  public void a(ETFont paramETFont)
  {
    int k = 0;
    this.mFont = new ETFont(0, null, 0.0F);
    this.mFont.copy(paramETFont);
    paramETFont = paramETFont.mText;
    if (TextUtils.isEmpty(paramETFont)) {}
    for (;;)
    {
      return;
      int m = paramETFont.length();
      int i;
      if (this.codes != null)
      {
        i = k;
        if (this.codes.length == m) {}
      }
      else
      {
        this.codes = new int[m];
        i = k;
      }
      while (i < m)
      {
        this.codes[i] = paramETFont.charAt(i);
        i += 1;
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int k;
    label26:
    int[] arrayOfInt1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      i = 1;
      if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
        break label239;
      }
      k = 1;
      if (i == 0) {
        break label245;
      }
      arrayOfInt1 = this.S;
      int[] arrayOfInt2 = this.R;
      int[] arrayOfInt3 = this.T;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      arrayOfInt3[0] = paramInt1;
      arrayOfInt2[0] = paramInt1;
      arrayOfInt1[0] = paramInt1;
      label69:
      if (k == 0) {
        break label266;
      }
      arrayOfInt1 = this.S;
      arrayOfInt2 = this.R;
      arrayOfInt3 = this.T;
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      arrayOfInt3[1] = paramInt1;
      arrayOfInt2[1] = paramInt1;
      arrayOfInt1[1] = paramInt1;
    }
    for (;;)
    {
      if (paramInt3 > 0)
      {
        if ((this.S[0] > paramInt3) || (this.S[0] == 0))
        {
          arrayOfInt1 = this.S;
          this.R[0] = paramInt3;
          arrayOfInt1[0] = paramInt3;
        }
        if ((this.S[1] > paramInt3) || (this.S[1] == 0))
        {
          arrayOfInt1 = this.S;
          this.R[1] = paramInt3;
          arrayOfInt1[1] = paramInt3;
        }
      }
      if (i.a().getHiBoomViewSize(this.mFont.mFontId, this.codes, this.R) != 0) {
        break label287;
      }
      this.T[0] = 0;
      this.T[1] = 0;
      return this.T;
      i = 0;
      break;
      label239:
      k = 0;
      break label26;
      label245:
      arrayOfInt1 = this.S;
      this.R[0] = 0;
      arrayOfInt1[0] = 0;
      break label69;
      label266:
      arrayOfInt1 = this.S;
      this.R[1] = 0;
      arrayOfInt1[1] = 0;
    }
    label287:
    if (i == 0) {
      this.T[0] = this.R[0];
    }
    if (k == 0) {
      this.T[1] = this.R[1];
    }
    return this.T;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
    throws Exception
  {
    return new int[0];
  }
  
  public boolean onDraw(Canvas paramCanvas)
  {
    this.L = i.a().a(this.mFont.mFontId, this.codes, this.R, this.U, this.mFont.mAnimationId, this.M);
    if (checkData())
    {
      s("onDraw.....");
      if (!c(this.U[0], this.U[1])) {
        return false;
      }
      Q();
      M();
      System.nanoTime();
      i.a().a(this.mFont.mFontId, this.codes, this.mFont.mAnimationId, this.frameIndex, this.d, this.S);
      if (i.isDebug) {
        System.nanoTime();
      }
      int i = this.U[2];
      this.src.set(0, 0, this.R[0] * 1000 / i - 1, this.R[1] * 1000 / i - 1);
      int k;
      switch (p.$SwitchMap$android$widget$ImageView$ScaleType[this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.getScaleType().ordinal()])
      {
      default: 
        i = (this.T[0] - this.R[0]) / 2;
        k = (this.T[1] - this.R[1]) / 2;
        this.dst.set(i, k, this.R[0] + i, this.R[1] + k);
      }
      for (;;)
      {
        paramCanvas.drawBitmap(this.d, this.src, this.dst, null);
        if ((this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.ciS) && (this.frameIndex == 0)) {
          O();
        }
        return true;
        this.dst.set(0, 0, this.T[0], this.T[1]);
        continue;
        this.dst.set(this.T[0] - this.R[0], 0, this.T[0] - this.R[0] + this.R[0], this.R[1]);
        continue;
        this.dst.set(0, 0, this.R[0], this.R[1]);
        continue;
        float f = Math.max(this.T[0] / this.R[0] * 1.0F, this.T[1] / this.R[1] * 1.0F);
        i = (int)((this.R[0] * f - this.T[0]) / 2.0F);
        k = (int)((f * this.R[1] - this.T[1]) / 2.0F);
        this.dst.set(-i, -k, this.R[0] + i, k + this.R[1]);
      }
    }
    s(acfp.m(2131706565));
    return false;
  }
  
  public void release()
  {
    super.release();
    j.i("HiBoomFont.FounderHiBoomLayout", "release....");
    this.codes = null;
    this.b = null;
    if (this.j != null)
    {
      this.j.reset();
      this.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     n
 * JD-Core Version:    0.7.0.1
 */