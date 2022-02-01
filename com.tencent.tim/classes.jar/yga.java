import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class yga
{
  private Rect B;
  private int LF;
  private int LG;
  private double M = 1.0D;
  private double N = 1.0D;
  private double O = 1.0D;
  private double P = 1.0D;
  private double Q;
  private double R = 1.0D;
  private double S = -0.8D;
  private yfu jdField_a_of_type_Yfu;
  private yga.a jdField_a_of_type_Yga$a;
  private String aXA;
  private long fL;
  private long fM;
  private long fN;
  private long fO;
  private long fP;
  private Drawable mDrawable;
  private Rect y;
  
  public yga(Drawable paramDrawable, Point paramPoint, yfu.b paramb, yfu.a parama, double paramDouble, long paramLong, String paramString, int paramInt)
  {
    this(paramDrawable, paramPoint, paramb, parama, paramLong, paramDouble, false, paramString, paramInt);
  }
  
  public yga(Drawable paramDrawable, Point paramPoint, yfu.b paramb, yfu.a parama, long paramLong, double paramDouble, boolean paramBoolean, String paramString, int paramInt)
  {
    this.mDrawable = paramDrawable;
    this.jdField_a_of_type_Yfu = new yfu();
    this.R = paramDouble;
    this.fL = paramLong;
    paramDouble = paramDrawable.getIntrinsicWidth() * this.R;
    double d1 = paramDrawable.getIntrinsicHeight() * this.R;
    if (paramInt == 85) {
      this.jdField_a_of_type_Yfu.rect.set((float)(paramPoint.x - paramDouble), (float)(paramPoint.y - d1), paramPoint.x, paramPoint.y);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.a(paramb);
      this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.a(parama);
      this.aXA = paramString;
      if (paramBoolean) {
        this.jdField_a_of_type_Yfu.Lv = 5;
      }
      return;
      float f1;
      float f2;
      if (paramInt == 81)
      {
        paramDrawable = this.jdField_a_of_type_Yfu.rect;
        f1 = (float)(paramPoint.x - paramDouble / 2.0D);
        f2 = (float)(paramPoint.y - d1);
        d1 = paramPoint.x;
        paramDrawable.set(f1, f2, (float)(paramDouble / 2.0D + d1), paramPoint.y);
      }
      else
      {
        paramDrawable = this.jdField_a_of_type_Yfu.rect;
        f1 = (float)(paramPoint.x - paramDouble / 2.0D);
        f2 = paramPoint.y;
        double d2 = paramPoint.x;
        paramDrawable.set(f1, f2, (float)(paramDouble / 2.0D + d2), (float)(d1 + paramPoint.y));
      }
    }
  }
  
  private void KJ()
  {
    if (this.jdField_a_of_type_Yfu.rect.left < this.y.left) {
      this.jdField_a_of_type_Yfu.rect.offset(this.y.left - this.jdField_a_of_type_Yfu.rect.left, 0.0F);
    }
    if (this.jdField_a_of_type_Yfu.rect.right > this.y.right) {
      this.jdField_a_of_type_Yfu.rect.offset(this.y.right - this.jdField_a_of_type_Yfu.rect.right, 0.0F);
    }
    if (this.jdField_a_of_type_Yfu.rect.top < this.y.top) {
      this.jdField_a_of_type_Yfu.rect.offset(0.0F, this.y.top - this.jdField_a_of_type_Yfu.rect.top);
    }
    if (this.jdField_a_of_type_Yfu.rect.bottom > this.y.bottom) {
      this.jdField_a_of_type_Yfu.rect.offset(0.0F, this.y.bottom - this.jdField_a_of_type_Yfu.rect.bottom);
    }
  }
  
  private void KK()
  {
    this.M = 1.0D;
    this.N = 1.0D;
  }
  
  private void KL()
  {
    this.M = Math.max(1.0D - Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I) * 0.0003D, 0.8D);
  }
  
  private void KM()
  {
    this.N = Math.max(1.0D - Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J) * 0.0003D, 0.8D);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 * 2.0D + paramDouble2 * paramDouble3) / 2.0D * paramDouble3;
  }
  
  private double a(long paramLong)
  {
    if (Math.abs(this.P - this.N) < 0.01D) {
      return this.N;
    }
    paramLong -= this.fL;
    if (this.P < this.N)
    {
      double d = this.P;
      this.P = (paramLong * 2L / 1000.0D + d);
    }
    for (this.P = Math.min(this.N, this.P);; this.P = Math.max(this.N, this.P))
    {
      return this.P;
      this.P -= paramLong * 2L / 1000.0D;
    }
  }
  
  private int a(Rect paramRect, RectF paramRectF)
  {
    int j = 0;
    if (paramRect.left > paramRectF.left) {
      j = 1;
    }
    int i = j;
    if (paramRect.right < paramRectF.right) {
      i = j ^ 0x2;
    }
    j = i;
    if (paramRect.top > paramRectF.top) {
      j = i ^ 0x4;
    }
    i = j;
    if (paramRect.bottom < paramRectF.bottom) {
      i = j ^ 0x8;
    }
    return i;
  }
  
  private void a(int paramInt, Rect paramRect, RectF paramRectF)
  {
    double d3 = 0.0D;
    double d1;
    if ((paramInt & 0x1) > 0)
    {
      d1 = (paramRectF.left - paramRect.left) * -1.8D;
      this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I *= -0.8D;
    }
    for (;;)
    {
      double d2 = d1;
      if ((paramInt & 0x2) > 0)
      {
        d2 = (paramRectF.right - paramRect.right) * -1.8D;
        this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I *= -0.8D;
      }
      d1 = d3;
      if ((paramInt & 0x4) > 0)
      {
        d1 = (paramRectF.top - paramRect.top) * -1.8D;
        this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J *= -0.8D;
      }
      if ((paramInt & 0x8) > 0)
      {
        d1 = (paramRectF.bottom - paramRect.bottom) * (-1.0D + this.S);
        this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J *= this.S;
      }
      this.jdField_a_of_type_Yfu.rect.offset((float)d2, (float)d1);
      return;
      d1 = 0.0D;
    }
  }
  
  private void aw(long paramLong)
  {
    double d1 = this.jdField_a_of_type_Yfu.rect.centerX();
    double d2 = this.jdField_a_of_type_Yfu.rect.centerY();
    double d3 = this.mDrawable.getIntrinsicWidth() * this.R;
    double d4 = this.mDrawable.getIntrinsicHeight() * this.R;
    if (this.fP > 0L)
    {
      paramLong -= this.fP;
      if (paramLong > 500L)
      {
        this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 / 2.0D));
        this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 / 2.0D));
        this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 / 2.0D));
        this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 / 2.0D));
        KJ();
        this.jdField_a_of_type_Yfu.Lv = 0;
      }
    }
    else
    {
      return;
    }
    double d6;
    if (paramLong < 100L)
    {
      d5 = paramLong * 1.0D / 100.0D + 1.0D;
      d6 = paramLong * 0.4D / 100.0D + 1.0D;
      this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      KJ();
      return;
    }
    if (paramLong < 200L)
    {
      d5 = (paramLong - 100L) * -0.4D / 100.0D + 2.0D;
      d6 = (paramLong - 100L) * -0.6D / 100.0D + 1.4D;
      this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    if (paramLong < 300L)
    {
      d5 = (paramLong - 200L) * -0.6D / 100.0D + 1.6D;
      d6 = (paramLong - 200L) * 0.5D / 100.0D + 0.8D;
      this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    if (paramLong < 400L)
    {
      d5 = (paramLong - 300L) * 0.2D / 100.0D + 1.0D;
      d6 = (paramLong - 300L) * -0.3D / 100.0D + 1.3D;
      this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * d5 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 * d6 / 2.0D));
      this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 * d6 / 2.0D));
      return;
    }
    double d5 = (paramLong - 400L) * -0.2D / 100.0D + 1.2D;
    this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - d3 * d5 / 2.0D));
    this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * d5 / 2.0D));
    this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - d4 * 1.0D / 2.0D));
    this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + d4 * 1.0D / 2.0D));
  }
  
  private void ax(long paramLong)
  {
    double d1 = this.jdField_a_of_type_Yfu.rect.centerX();
    double d2 = this.jdField_a_of_type_Yfu.rect.centerY();
    double d3 = this.mDrawable.getIntrinsicWidth() * this.R;
    double d4 = this.mDrawable.getIntrinsicHeight() * this.R;
    this.O = b(paramLong);
    this.jdField_a_of_type_Yfu.rect.left = ((float)(d1 - this.O * d3 / 2.0D));
    this.jdField_a_of_type_Yfu.rect.right = ((float)(d1 + d3 * this.O / 2.0D));
    this.P = a(paramLong);
    this.jdField_a_of_type_Yfu.rect.top = ((float)(d2 - this.P * d4 / 2.0D));
    this.jdField_a_of_type_Yfu.rect.bottom = ((float)(d2 + this.P * d4 / 2.0D));
  }
  
  private void ay(long paramLong)
  {
    double d1 = (paramLong - this.fL) / 1000.0D;
    double d2 = a(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I, this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.ax, d1);
    double d3 = a(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J, this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.ay, d1);
    yfu.b localb = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b;
    localb.I += this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.ax * d1;
    localb = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b;
    localb.J += this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.ay * d1;
    double d4 = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I;
    double d5 = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J;
    localb = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b;
    localb.I = (0.0D * d1 * d4 + localb.I);
    localb = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b;
    localb.J = (0.0D * d1 * d5 + localb.J);
    this.jdField_a_of_type_Yfu.rect.offset((float)d2, (float)d3);
  }
  
  private double b(long paramLong)
  {
    if (Math.abs(this.O - this.M) < 0.01D) {
      return this.M;
    }
    paramLong -= this.fL;
    if (this.O < this.M)
    {
      double d = this.O;
      this.O = (paramLong * 2L / 1000.0D + d);
    }
    for (this.O = Math.min(this.M, this.O);; this.O = Math.max(this.M, this.O))
    {
      return this.O;
      this.O -= paramLong * 2L / 1000.0D;
    }
  }
  
  private int bp(int paramInt)
  {
    int j = 0;
    int i = j;
    if ((paramInt & 0x1) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I) > 100.0D) {
        i = 1;
      }
    }
    j = i;
    if ((paramInt & 0x2) > 0)
    {
      j = i;
      if (Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.I) > 100.0D) {
        j = i | 0x2;
      }
    }
    i = j;
    if ((paramInt & 0x4) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J) > 100.0D) {
        i = j | 0x4;
      }
    }
    j = i;
    if ((paramInt & 0x8) > 0)
    {
      j = i;
      if (Math.abs(this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b.J) > 100.0D) {
        j = i | 0x8;
      }
    }
    return j;
  }
  
  private void l(int paramInt, long paramLong)
  {
    this.fM = paramLong;
    this.M = 1.0D;
    this.N = 1.0D;
    if ((paramInt & 0x1) > 0) {
      KL();
    }
    if ((paramInt & 0x2) > 0) {
      KL();
    }
    if ((paramInt & 0x4) > 0) {
      KM();
    }
    if ((paramInt & 0x8) > 0) {
      KM();
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, long paramLong, Drawable paramDrawable)
  {
    if (this.y == null)
    {
      this.y = new Rect();
      this.y.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
    if (this.B == null) {
      this.B = new Rect();
    }
    if (this.jdField_a_of_type_Yfu.Lv == 5) {
      aw(paramLong);
    }
    if (this.jdField_a_of_type_Yfu.Lv != 5)
    {
      if (paramLong - this.fM > 170L) {
        KK();
      }
      ax(paramLong);
    }
    int i;
    if (this.jdField_a_of_type_Yfu.Lv != 3)
    {
      ay(paramLong);
      i = a(this.y, this.jdField_a_of_type_Yfu.rect);
      if (i != 0)
      {
        if ((i & 0x8) > 0)
        {
          if (this.fN == 0L) {
            this.fN = paramLong;
          }
          this.LF += 1;
          paramPaint = this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$b;
          paramPaint.I *= 0.95D;
          if ((this.jdField_a_of_type_Yfu.Lv != 4) && (this.LF >= 3))
          {
            this.jdField_a_of_type_Yfu.Lv = 4;
            this.fO = paramLong;
          }
        }
        this.LG += 1;
        if (this.LG == 3)
        {
          this.Q = this.jdField_a_of_type_Yfu.rect.left;
          this.jdField_a_of_type_Yfu.jdField_a_of_type_Yfu$a.ay = 2000.0D;
          this.S = -0.5D;
        }
        a(i, this.y, this.jdField_a_of_type_Yfu.rect);
        i = bp(i);
        if ((i != 0) && (this.jdField_a_of_type_Yfu.Lv != 4) && (this.jdField_a_of_type_Yfu.Lv != 5)) {
          l(i, paramLong);
        }
      }
    }
    long l;
    if (this.jdField_a_of_type_Yfu.Lv != 3)
    {
      int k = paramCanvas.save();
      float f = 0.0F;
      if (this.Q > 0.0D) {
        f = (float)((this.jdField_a_of_type_Yfu.rect.left - this.Q) * 360.0D / (3.141592653589793D * this.mDrawable.getIntrinsicHeight()));
      }
      paramCanvas.rotate(f, this.jdField_a_of_type_Yfu.rect.centerX(), this.jdField_a_of_type_Yfu.rect.centerY());
      int j = 255;
      i = j;
      if (this.jdField_a_of_type_Yfu.Lv == 4)
      {
        l = paramLong - this.fO - 2000L;
        i = j;
        if (l > 0L)
        {
          if (l <= 700L) {
            break label552;
          }
          this.jdField_a_of_type_Yfu.Lv = 3;
          i = 0;
        }
      }
      paramDrawable.setAlpha(i);
      this.jdField_a_of_type_Yfu.rect.round(this.B);
      paramDrawable.setBounds(this.B);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    for (;;)
    {
      this.fL = paramLong;
      if (this.fP == 0L) {
        this.fP = paramLong;
      }
      return;
      label552:
      i = (int)(255L - l * 255L / 700L);
      break;
      if (this.jdField_a_of_type_Yga$a != null) {
        this.jdField_a_of_type_Yga$a.a(this);
      }
    }
  }
  
  public void a(yga.a parama)
  {
    this.jdField_a_of_type_Yga$a = parama;
  }
  
  public long aB()
  {
    return this.fP;
  }
  
  public String py()
  {
    return this.aXA;
  }
  
  public static abstract interface a
  {
    public abstract void a(yga paramyga);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yga
 * JD-Core Version:    0.7.0.1
 */