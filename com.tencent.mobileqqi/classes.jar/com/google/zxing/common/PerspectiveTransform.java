package com.google.zxing.common;

public final class PerspectiveTransform
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;
  
  private PerspectiveTransform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.a = paramFloat1;
    this.b = paramFloat4;
    this.c = paramFloat7;
    this.d = paramFloat2;
    this.e = paramFloat5;
    this.f = paramFloat8;
    this.g = paramFloat3;
    this.h = paramFloat6;
    this.i = paramFloat9;
  }
  
  public static PerspectiveTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = paramFloat1 - paramFloat3 + paramFloat5 - paramFloat7;
    float f2 = paramFloat2 - paramFloat4 + paramFloat6 - paramFloat8;
    if ((f1 == 0.0F) && (f2 == 0.0F)) {
      return new PerspectiveTransform(paramFloat3 - paramFloat1, paramFloat5 - paramFloat3, paramFloat1, paramFloat4 - paramFloat2, paramFloat6 - paramFloat4, paramFloat2, 0.0F, 0.0F, 1.0F);
    }
    float f3 = paramFloat3 - paramFloat5;
    float f4 = paramFloat7 - paramFloat5;
    paramFloat5 = paramFloat4 - paramFloat6;
    float f5 = paramFloat8 - paramFloat6;
    paramFloat6 = f3 * f5 - f4 * paramFloat5;
    f4 = (f5 * f1 - f4 * f2) / paramFloat6;
    paramFloat5 = (f2 * f3 - f1 * paramFloat5) / paramFloat6;
    return new PerspectiveTransform(paramFloat3 - paramFloat1 + f4 * paramFloat3, paramFloat7 - paramFloat1 + paramFloat5 * paramFloat7, paramFloat1, f4 * paramFloat4 + (paramFloat4 - paramFloat2), paramFloat5 * paramFloat8 + (paramFloat8 - paramFloat2), paramFloat2, f4, paramFloat5, 1.0F);
  }
  
  public static PerspectiveTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    PerspectiveTransform localPerspectiveTransform = b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    return a(paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16).a(localPerspectiveTransform);
  }
  
  public static PerspectiveTransform b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8).a();
  }
  
  PerspectiveTransform a()
  {
    return new PerspectiveTransform(this.e * this.i - this.f * this.h, this.f * this.g - this.d * this.i, this.d * this.h - this.e * this.g, this.c * this.h - this.b * this.i, this.a * this.i - this.c * this.g, this.b * this.g - this.a * this.h, this.b * this.f - this.c * this.e, this.c * this.d - this.a * this.f, this.a * this.e - this.b * this.d);
  }
  
  PerspectiveTransform a(PerspectiveTransform paramPerspectiveTransform)
  {
    return new PerspectiveTransform(this.a * paramPerspectiveTransform.a + this.d * paramPerspectiveTransform.b + this.g * paramPerspectiveTransform.c, this.a * paramPerspectiveTransform.d + this.d * paramPerspectiveTransform.e + this.g * paramPerspectiveTransform.f, this.a * paramPerspectiveTransform.g + this.d * paramPerspectiveTransform.h + this.g * paramPerspectiveTransform.i, this.b * paramPerspectiveTransform.a + this.e * paramPerspectiveTransform.b + this.h * paramPerspectiveTransform.c, this.b * paramPerspectiveTransform.d + this.e * paramPerspectiveTransform.e + this.h * paramPerspectiveTransform.f, this.b * paramPerspectiveTransform.g + this.e * paramPerspectiveTransform.h + this.h * paramPerspectiveTransform.i, this.c * paramPerspectiveTransform.a + this.f * paramPerspectiveTransform.b + this.i * paramPerspectiveTransform.c, this.c * paramPerspectiveTransform.d + this.f * paramPerspectiveTransform.e + this.i * paramPerspectiveTransform.f, this.c * paramPerspectiveTransform.g + this.f * paramPerspectiveTransform.h + this.i * paramPerspectiveTransform.i);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    int k = paramArrayOfFloat.length;
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.e;
    float f6 = this.f;
    float f7 = this.g;
    float f8 = this.h;
    float f9 = this.i;
    int j = 0;
    while (j < k)
    {
      float f10 = paramArrayOfFloat[j];
      float f11 = paramArrayOfFloat[(j + 1)];
      float f12 = f3 * f10 + f6 * f11 + f9;
      paramArrayOfFloat[j] = ((f1 * f10 + f4 * f11 + f7) / f12);
      paramArrayOfFloat[(j + 1)] = ((f10 * f2 + f11 * f5 + f8) / f12);
      j += 2;
    }
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int k = paramArrayOfFloat1.length;
    int j = 0;
    while (j < k)
    {
      float f1 = paramArrayOfFloat1[j];
      float f2 = paramArrayOfFloat2[j];
      float f3 = this.c * f1 + this.f * f2 + this.i;
      paramArrayOfFloat1[j] = ((this.a * f1 + this.d * f2 + this.g) / f3);
      paramArrayOfFloat2[j] = ((f1 * this.b + f2 * this.e + this.h) / f3);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.PerspectiveTransform
 * JD-Core Version:    0.7.0.1
 */