package com.tencent.mobileqq.armap.sensor.rotation;

import java.io.Serializable;

public class Matrix3
  implements Serializable
{
  public static final int M00 = 0;
  public static final int M01 = 3;
  public static final int M02 = 6;
  public static final int M10 = 1;
  public static final int M11 = 4;
  public static final int M12 = 7;
  public static final int M20 = 2;
  public static final int M21 = 5;
  public static final int M22 = 8;
  private static final long serialVersionUID = 7907569533774959788L;
  private float[] tmp = new float[9];
  public float[] val = new float[9];
  
  public Matrix3()
  {
    idt();
  }
  
  public Matrix3(Matrix3 paramMatrix3)
  {
    set(paramMatrix3);
  }
  
  private static void d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat2[0];
    float f3 = paramArrayOfFloat1[3];
    float f4 = paramArrayOfFloat2[1];
    float f5 = paramArrayOfFloat1[6];
    float f6 = paramArrayOfFloat2[2];
    float f7 = paramArrayOfFloat1[0];
    float f8 = paramArrayOfFloat2[3];
    float f9 = paramArrayOfFloat1[3];
    float f10 = paramArrayOfFloat2[4];
    float f11 = paramArrayOfFloat1[6];
    float f12 = paramArrayOfFloat2[5];
    float f13 = paramArrayOfFloat1[0];
    float f14 = paramArrayOfFloat2[6];
    float f15 = paramArrayOfFloat1[3];
    float f16 = paramArrayOfFloat2[7];
    float f17 = paramArrayOfFloat1[6];
    float f18 = paramArrayOfFloat2[8];
    float f19 = paramArrayOfFloat1[1];
    float f20 = paramArrayOfFloat2[0];
    float f21 = paramArrayOfFloat1[4];
    float f22 = paramArrayOfFloat2[1];
    float f23 = paramArrayOfFloat1[7];
    float f24 = paramArrayOfFloat2[2];
    float f25 = paramArrayOfFloat1[1];
    float f26 = paramArrayOfFloat2[3];
    float f27 = paramArrayOfFloat1[4];
    float f28 = paramArrayOfFloat2[4];
    float f29 = paramArrayOfFloat1[7];
    float f30 = paramArrayOfFloat2[5];
    float f31 = paramArrayOfFloat1[1];
    float f32 = paramArrayOfFloat2[6];
    float f33 = paramArrayOfFloat1[4];
    float f34 = paramArrayOfFloat2[7];
    float f35 = paramArrayOfFloat1[7];
    float f36 = paramArrayOfFloat2[8];
    float f37 = paramArrayOfFloat1[2];
    float f38 = paramArrayOfFloat2[0];
    float f39 = paramArrayOfFloat1[5];
    float f40 = paramArrayOfFloat2[1];
    float f41 = paramArrayOfFloat1[8];
    float f42 = paramArrayOfFloat2[2];
    float f43 = paramArrayOfFloat1[2];
    float f44 = paramArrayOfFloat2[3];
    float f45 = paramArrayOfFloat1[5];
    float f46 = paramArrayOfFloat2[4];
    float f47 = paramArrayOfFloat1[8];
    float f48 = paramArrayOfFloat2[5];
    float f49 = paramArrayOfFloat1[2];
    float f50 = paramArrayOfFloat2[6];
    float f51 = paramArrayOfFloat1[5];
    float f52 = paramArrayOfFloat2[7];
    float f53 = paramArrayOfFloat1[8];
    float f54 = paramArrayOfFloat2[8];
    paramArrayOfFloat1[0] = (f1 * f2 + f3 * f4 + f5 * f6);
    paramArrayOfFloat1[1] = (f19 * f20 + f21 * f22 + f23 * f24);
    paramArrayOfFloat1[2] = (f37 * f38 + f39 * f40 + f41 * f42);
    paramArrayOfFloat1[3] = (f7 * f8 + f9 * f10 + f11 * f12);
    paramArrayOfFloat1[4] = (f25 * f26 + f27 * f28 + f29 * f30);
    paramArrayOfFloat1[5] = (f43 * f44 + f45 * f46 + f47 * f48);
    paramArrayOfFloat1[6] = (f13 * f14 + f15 * f16 + f17 * f18);
    paramArrayOfFloat1[7] = (f31 * f32 + f33 * f34 + f35 * f36);
    paramArrayOfFloat1[8] = (f49 * f50 + f51 * f52 + f53 * f54);
  }
  
  public float[] getValues()
  {
    return this.val;
  }
  
  public Matrix3 idt()
  {
    this.val[0] = 1.0F;
    this.val[1] = 0.0F;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = 1.0F;
    this.val[5] = 0.0F;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = 1.0F;
    return this;
  }
  
  public Matrix3 rotate(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return this;
    }
    float f = 0.01745329F * paramFloat;
    paramFloat = (float)Math.cos(f);
    f = (float)Math.sin(f);
    this.tmp[0] = paramFloat;
    this.tmp[1] = f;
    this.tmp[2] = 0.0F;
    this.tmp[3] = (-f);
    this.tmp[4] = paramFloat;
    this.tmp[5] = 0.0F;
    this.tmp[6] = 0.0F;
    this.tmp[7] = 0.0F;
    this.tmp[8] = 1.0F;
    d(this.val, this.tmp);
    return this;
  }
  
  public Matrix3 scale(float paramFloat1, float paramFloat2)
  {
    this.tmp[0] = paramFloat1;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = paramFloat2;
    this.tmp[5] = 0.0F;
    this.tmp[6] = 0.0F;
    this.tmp[7] = 0.0F;
    this.tmp[8] = 1.0F;
    d(this.val, this.tmp);
    return this;
  }
  
  public Matrix3 scale(Vector2 paramVector2)
  {
    this.tmp[0] = paramVector2.x;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = paramVector2.y;
    this.tmp[5] = 0.0F;
    this.tmp[6] = 0.0F;
    this.tmp[7] = 0.0F;
    this.tmp[8] = 1.0F;
    d(this.val, this.tmp);
    return this;
  }
  
  public Matrix3 set(Matrix3 paramMatrix3)
  {
    System.arraycopy(paramMatrix3.val, 0, this.val, 0, this.val.length);
    return this;
  }
  
  public Matrix3 set(Matrix4 paramMatrix4)
  {
    this.val[0] = paramMatrix4.val[0];
    this.val[1] = paramMatrix4.val[1];
    this.val[2] = paramMatrix4.val[2];
    this.val[3] = paramMatrix4.val[4];
    this.val[4] = paramMatrix4.val[5];
    this.val[5] = paramMatrix4.val[6];
    this.val[6] = paramMatrix4.val[8];
    this.val[7] = paramMatrix4.val[9];
    this.val[8] = paramMatrix4.val[10];
    return this;
  }
  
  public String toString()
  {
    return "[" + this.val[0] + "|" + this.val[3] + "|" + this.val[6] + "]\n[" + this.val[1] + "|" + this.val[4] + "|" + this.val[7] + "]\n[" + this.val[2] + "|" + this.val[5] + "|" + this.val[8] + "]";
  }
  
  public Matrix3 translate(float paramFloat1, float paramFloat2)
  {
    this.tmp[0] = 1.0F;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = 1.0F;
    this.tmp[5] = 0.0F;
    this.tmp[6] = paramFloat1;
    this.tmp[7] = paramFloat2;
    this.tmp[8] = 1.0F;
    d(this.val, this.tmp);
    return this;
  }
  
  public Matrix3 translate(Vector2 paramVector2)
  {
    this.tmp[0] = 1.0F;
    this.tmp[1] = 0.0F;
    this.tmp[2] = 0.0F;
    this.tmp[3] = 0.0F;
    this.tmp[4] = 1.0F;
    this.tmp[5] = 0.0F;
    this.tmp[6] = paramVector2.x;
    this.tmp[7] = paramVector2.y;
    this.tmp[8] = 1.0F;
    d(this.val, this.tmp);
    return this;
  }
  
  public Matrix3 transpose()
  {
    float f1 = this.val[1];
    float f2 = this.val[2];
    float f3 = this.val[3];
    float f4 = this.val[5];
    float f5 = this.val[6];
    float f6 = this.val[7];
    this.val[3] = f1;
    this.val[6] = f2;
    this.val[1] = f3;
    this.val[7] = f4;
    this.val[2] = f5;
    this.val[5] = f6;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Matrix3
 * JD-Core Version:    0.7.0.1
 */