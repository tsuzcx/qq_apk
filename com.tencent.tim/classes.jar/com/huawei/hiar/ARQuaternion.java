package com.huawei.hiar;

class ARQuaternion
{
  public static final ARQuaternion IDENTITY = new ARQuaternion();
  private float w = 1.0F;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public ARQuaternion()
  {
    setValues(0.0F, 0.0F, 0.0F, 1.0F);
  }
  
  public ARQuaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setValues(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public ARQuaternion(ARQuaternion paramARQuaternion)
  {
    if (paramARQuaternion == null) {
      throw new IllegalArgumentException();
    }
    setValues(paramARQuaternion.x, paramARQuaternion.y, paramARQuaternion.z, paramARQuaternion.w);
  }
  
  public ARQuaternion(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 4)) {
      throw new IllegalArgumentException();
    }
    setValues(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
  }
  
  public static ARQuaternion fromMatrix(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length - 1 < paramInt1 + 2 + paramInt2 * 2)) {
      throw new IllegalArgumentException();
    }
    float f10 = paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 0)];
    float f1 = paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 1)];
    float f2 = paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 2)];
    float f3 = paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 0)];
    float f11 = paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 1)];
    float f4 = paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 2)];
    float f5 = paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 0)];
    float f6 = paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 1)];
    float f12 = paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 2)];
    float f7 = (float)Math.sqrt(Math.max(0.0F, 1.0F + f10 + f11 + f12));
    float f8 = (float)Math.sqrt(Math.max(0.0F, 1.0F + f10 - f11 - f12));
    float f9 = (float)Math.sqrt(Math.max(0.0F, 1.0F - f10 + f11 - f12));
    f10 = (float)Math.sqrt(Math.max(0.0F, 1.0F - f10 - f11 + f12));
    return new ARQuaternion(Math.copySign(0.5F * f8, f6 - f4), Math.copySign(0.5F * f9, f2 - f5), Math.copySign(f10 * 0.5F, f3 - f1), 0.5F * f7);
  }
  
  public static ARQuaternion makeInterpolated(ARQuaternion paramARQuaternion1, ARQuaternion paramARQuaternion2, float paramFloat)
  {
    if ((paramARQuaternion1 == null) || (paramARQuaternion2 == null) || (paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException();
    }
    ARQuaternion localARQuaternion2 = new ARQuaternion();
    float f2 = paramARQuaternion1.x * paramARQuaternion2.x + paramARQuaternion1.y * paramARQuaternion2.y + paramARQuaternion1.z * paramARQuaternion2.z + paramARQuaternion1.w * paramARQuaternion2.w;
    float f1 = f2;
    ARQuaternion localARQuaternion1 = paramARQuaternion2;
    if (f2 < 0.0F)
    {
      localARQuaternion1 = new ARQuaternion(paramARQuaternion2);
      f1 = -f2;
      localARQuaternion1.x = (-localARQuaternion1.x);
      localARQuaternion1.y = (-localARQuaternion1.y);
      localARQuaternion1.z = (-localARQuaternion1.z);
      localARQuaternion1.w = (-localARQuaternion1.w);
    }
    f2 = (float)Math.acos(f1);
    f1 = (float)Math.sqrt(1.0F - f1 * f1);
    if (Math.abs(f1) > 0.001D)
    {
      float f3 = 1.0F / f1;
      f1 = (float)Math.sin((1.0F - paramFloat) * f2) * f3;
      paramFloat = (float)Math.sin(f2 * paramFloat) * f3;
    }
    for (;;)
    {
      localARQuaternion2.x = (paramARQuaternion1.x * f1 + localARQuaternion1.x * paramFloat);
      localARQuaternion2.y = (paramARQuaternion1.y * f1 + localARQuaternion1.y * paramFloat);
      localARQuaternion2.z = (paramARQuaternion1.z * f1 + localARQuaternion1.z * paramFloat);
      localARQuaternion2.w = (f1 * paramARQuaternion1.w + localARQuaternion1.w * paramFloat);
      localARQuaternion2.normalizeInPlace();
      return localARQuaternion2;
      f1 = 1.0F - paramFloat;
    }
  }
  
  private static void multiplyQuaternions(ARQuaternion paramARQuaternion1, ARQuaternion paramARQuaternion2, ARQuaternion paramARQuaternion3)
  {
    paramARQuaternion3.x = (paramARQuaternion1.x * paramARQuaternion2.w + paramARQuaternion1.y * paramARQuaternion2.z - paramARQuaternion1.z * paramARQuaternion2.y + paramARQuaternion1.w * paramARQuaternion2.x);
    paramARQuaternion3.y = (-paramARQuaternion1.x * paramARQuaternion2.z + paramARQuaternion1.y * paramARQuaternion2.w + paramARQuaternion1.z * paramARQuaternion2.x + paramARQuaternion1.w * paramARQuaternion2.y);
    paramARQuaternion3.z = (paramARQuaternion1.x * paramARQuaternion2.y - paramARQuaternion1.y * paramARQuaternion2.x + paramARQuaternion1.z * paramARQuaternion2.w + paramARQuaternion1.w * paramARQuaternion2.z);
    paramARQuaternion3.w = (-paramARQuaternion1.x * paramARQuaternion2.x - paramARQuaternion1.y * paramARQuaternion2.y - paramARQuaternion1.z * paramARQuaternion2.z + paramARQuaternion1.w * paramARQuaternion2.w);
  }
  
  private void normalizeInPlace()
  {
    float f = (float)(1.0D / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w));
    this.x *= f;
    this.y *= f;
    this.z *= f;
    this.w = (f * this.w);
  }
  
  public static void rotateVector(ARQuaternion paramARQuaternion, float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    if ((paramARQuaternion == null) || (paramArrayOfFloat1 == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramArrayOfFloat1.length < paramInt1 + 3) || (paramArrayOfFloat2.length < paramInt2 + 3)) {
      throw new IllegalArgumentException();
    }
    float f8 = paramArrayOfFloat1[(paramInt1 + 0)];
    float f9 = paramArrayOfFloat1[(paramInt1 + 1)];
    float f10 = paramArrayOfFloat1[(paramInt1 + 2)];
    float f1 = paramARQuaternion.x();
    float f2 = paramARQuaternion.y();
    float f3 = paramARQuaternion.z();
    float f4 = paramARQuaternion.w();
    float f5 = f4 * f8 + f2 * f10 - f3 * f9;
    float f6 = f4 * f9 + f3 * f8 - f1 * f10;
    float f7 = f4 * f10 + f1 * f9 - f2 * f8;
    f8 = f8 * -f1 - f9 * f2 - f3 * f10;
    paramArrayOfFloat2[(paramInt2 + 0)] = (f5 * f4 + -f1 * f8 + -f3 * f6 - -f2 * f7);
    paramArrayOfFloat2[(paramInt2 + 1)] = (f6 * f4 + -f2 * f8 + -f1 * f7 - -f3 * f5);
    paramArrayOfFloat2[(paramInt2 + 2)] = (f8 * -f3 + f7 * f4 + -f2 * f5 - -f1 * f6);
  }
  
  public ARQuaternion compose(ARQuaternion paramARQuaternion)
  {
    if (paramARQuaternion == null) {
      throw new IllegalArgumentException();
    }
    ARQuaternion localARQuaternion = new ARQuaternion();
    multiplyQuaternions(this, paramARQuaternion, localARQuaternion);
    return localARQuaternion;
  }
  
  public void getTransformedAxis(int paramInt1, float paramFloat, float[] paramArrayOfFloat, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2) || (paramArrayOfFloat == null) || (paramInt2 < 0) || (paramArrayOfFloat.length < paramInt2 + 3)) {
      throw new IllegalArgumentException();
    }
    float[] arrayOfFloat = new float[3];
    float[] tmp42_40 = arrayOfFloat;
    tmp42_40[0] = 0.0F;
    float[] tmp46_42 = tmp42_40;
    tmp46_42[1] = 0.0F;
    float[] tmp50_46 = tmp46_42;
    tmp50_46[2] = 0.0F;
    tmp50_46;
    arrayOfFloat[paramInt1] = paramFloat;
    rotateVector(this, arrayOfFloat, 0, paramArrayOfFloat, paramInt2);
  }
  
  public void getValues(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 4)) {
      throw new IllegalArgumentException();
    }
    paramArrayOfFloat[(paramInt + 0)] = this.x;
    paramArrayOfFloat[(paramInt + 1)] = this.y;
    paramArrayOfFloat[(paramInt + 2)] = this.z;
    paramArrayOfFloat[(paramInt + 3)] = this.w;
  }
  
  public ARQuaternion inverse()
  {
    return new ARQuaternion(-this.x, -this.y, -this.z, this.w);
  }
  
  public void setValues(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public void setValues(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 4)) {
      throw new IllegalArgumentException();
    }
    setValues(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
  }
  
  public void toMatrix(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    if ((paramArrayOfFloat == null) || (paramInt1 < 0) || (paramArrayOfFloat.length < paramInt1 + 16)) {
      throw new IllegalArgumentException();
    }
    float f2 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    if (f2 > 0.0F) {
      f1 = 2.0F / f2;
    }
    float f5 = this.x * f1;
    float f8 = this.y * f1;
    float f4 = f1 * this.z;
    f1 = this.w * f5;
    f2 = this.w * f8;
    float f3 = this.w * f4;
    f5 *= this.x;
    float f6 = this.x * f8;
    float f7 = this.x * f4;
    f8 *= this.y;
    float f9 = this.y * f4;
    f4 *= this.z;
    paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 0)] = (1.0F - (f8 + f4));
    paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 1)] = (f6 - f3);
    paramArrayOfFloat[(paramInt1 + 0 + paramInt2 * 2)] = (f7 + f2);
    paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 0)] = (f3 + f6);
    paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 1)] = (1.0F - (f4 + f5));
    paramArrayOfFloat[(paramInt1 + 1 + paramInt2 * 2)] = (f9 - f1);
    paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 0)] = (f7 - f2);
    paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 1)] = (f1 + f9);
    paramArrayOfFloat[(paramInt1 + 2 + paramInt2 * 2)] = (1.0F - (f5 + f8));
  }
  
  public String toString()
  {
    return String.format("[%.3f, %.3f, %.3f, %.3f]", new Object[] { Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z), Float.valueOf(this.w) });
  }
  
  public float[] transformedAxis(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    getTransformedAxis(paramInt, paramFloat, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public float w()
  {
    return this.w;
  }
  
  public float x()
  {
    return this.x;
  }
  
  public float[] xAxis()
  {
    return transformedAxis(0, 1.0F);
  }
  
  public float y()
  {
    return this.y;
  }
  
  public float[] yAxis()
  {
    return transformedAxis(1, 1.0F);
  }
  
  public float z()
  {
    return this.z;
  }
  
  public float[] zAxis()
  {
    return transformedAxis(2, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARQuaternion
 * JD-Core Version:    0.7.0.1
 */