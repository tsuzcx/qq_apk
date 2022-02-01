import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

class nsy
{
  private final nta jdField_a_of_type_Nta;
  private final nsx[] jdField_a_of_type_ArrayOfNsx;
  private int bcm;
  private int bcn;
  private char c = '\000';
  private int endIndex;
  private char f = '\000';
  private char[] l;
  private float li;
  private float lj;
  private float lk;
  private float ll;
  private float lm;
  private float ln;
  private float lo;
  private float lp;
  private int startIndex;
  
  nsy(nsx[] paramArrayOfnsx, nta paramnta)
  {
    this.jdField_a_of_type_ArrayOfNsx = paramArrayOfnsx;
    this.jdField_a_of_type_Nta = paramnta;
  }
  
  private boolean a(Canvas paramCanvas, Paint paramPaint, char[] paramArrayOfChar, int paramInt, float paramFloat)
  {
    if ((paramInt >= 0) && (paramInt < paramArrayOfChar.length))
    {
      paramCanvas.drawText(paramArrayOfChar, paramInt, 1, 0.0F, paramFloat, paramPaint);
      return true;
    }
    return false;
  }
  
  private void ah(int paramInt, boolean paramBoolean)
  {
    String str2 = null;
    this.l = null;
    char c2 = this.f;
    char c1 = c2;
    if (paramBoolean)
    {
      c1 = c2;
      if (c2 == 0) {
        c1 = '0';
      }
    }
    int i = 0;
    Object localObject;
    while (i < this.jdField_a_of_type_ArrayOfNsx.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfNsx[i].a(this.c, c1, this.jdField_a_of_type_Nta.qU());
      if (localObject != null)
      {
        this.l = this.jdField_a_of_type_ArrayOfNsx[i].b();
        this.startIndex = ((nsx.a)localObject).startIndex;
        this.endIndex = ((nsx.a)localObject).endIndex;
        str2 = this.jdField_a_of_type_ArrayOfNsx[i].kK();
      }
      i += 1;
    }
    if ((this.l != null) && (paramInt > 1) && (!TextUtils.isEmpty(str2)))
    {
      i = Math.min(paramInt - 1, 5);
      String str1 = new String(this.l);
      if (this.jdField_a_of_type_Nta.qU() == 1)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = str1;
          if (paramInt >= i) {
            break;
          }
          str1 = str1 + str2;
          this.startIndex += str2.length();
          paramInt += 1;
        }
      }
      localObject = str1;
      if (this.jdField_a_of_type_Nta.qU() == 2)
      {
        paramInt = 0;
        for (;;)
        {
          localObject = str1;
          if (paramInt >= i) {
            break;
          }
          str1 = str1 + str2;
          this.endIndex += str2.length();
          paramInt += 1;
        }
      }
      this.l = ((String)localObject).toCharArray();
    }
    if (this.l == null)
    {
      if (this.c == this.f)
      {
        this.l = new char[] { this.c };
        this.endIndex = 0;
        this.startIndex = 0;
      }
    }
    else {
      return;
    }
    this.l = new char[] { this.c, this.f };
    this.startIndex = 0;
    this.endIndex = 1;
  }
  
  private void baV()
  {
    float f1 = this.jdField_a_of_type_Nta.a(this.f);
    if ((this.ll == this.lm) && (this.lm != f1))
    {
      this.lm = f1;
      this.ll = f1;
      this.ln = f1;
    }
  }
  
  char a()
  {
    return this.c;
  }
  
  void a(int paramInt, char paramChar, boolean paramBoolean)
  {
    int i = 1;
    this.f = paramChar;
    this.lk = this.ll;
    this.lm = this.jdField_a_of_type_Nta.a(paramChar);
    this.ln = Math.max(this.lk, this.lm);
    ah(paramInt, paramBoolean);
    if (this.endIndex >= this.startIndex)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = -1)
    {
      this.bcn = paramInt;
      this.lp = this.lo;
      this.lo = 0.0F;
      return;
      paramInt = 0;
      break;
    }
  }
  
  float aq()
  {
    baV();
    return this.ll;
  }
  
  float ar()
  {
    baV();
    return this.ln;
  }
  
  void c(float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 1.0F)
    {
      this.c = this.f;
      this.lo = 0.0F;
      this.lp = 0.0F;
    }
    float f1 = this.jdField_a_of_type_Nta.as();
    float f2 = Math.abs(this.endIndex - this.startIndex) * f1 * paramFloat / f1;
    float f3 = (int)f2;
    float f4 = this.lp;
    this.li = ((f2 - f3) * f1 * this.bcn + f4 * (1.0F - paramFloat));
    int i = this.startIndex;
    this.bcm = ((int)f2 * this.bcn + i);
    this.lj = f1;
    if (paramBoolean)
    {
      this.ll = Math.max(this.lm, this.lk);
      if (paramFloat > 0.999F)
      {
        this.ll = this.lm;
        if (this.f == 0) {
          this.bcm = 0;
        }
      }
      return;
    }
    this.ll = (this.lk + (this.lm - this.lk) * paramFloat);
  }
  
  char d()
  {
    return this.f;
  }
  
  void draw(Canvas paramCanvas, Paint paramPaint)
  {
    if (a(paramCanvas, paramPaint, this.l, this.bcm, this.li))
    {
      if (this.bcm >= 0) {
        this.c = this.l[this.bcm];
      }
      this.lo = this.li;
    }
    a(paramCanvas, paramPaint, this.l, this.bcm + 1, this.li - this.lj);
    a(paramCanvas, paramPaint, this.l, this.bcm - 1, this.li + this.lj);
  }
  
  void onAnimationEnd()
  {
    baV();
    this.ln = this.ll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsy
 * JD-Core Version:    0.7.0.1
 */