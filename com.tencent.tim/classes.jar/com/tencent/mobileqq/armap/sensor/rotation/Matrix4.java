package com.tencent.mobileqq.armap.sensor.rotation;

import java.io.Serializable;

public class Matrix4
  implements Serializable
{
  public static final int M00 = 0;
  public static final int M01 = 4;
  public static final int M02 = 8;
  public static final int M03 = 12;
  public static final int M10 = 1;
  public static final int M11 = 5;
  public static final int M12 = 9;
  public static final int M13 = 13;
  public static final int M20 = 2;
  public static final int M21 = 6;
  public static final int M22 = 10;
  public static final int M23 = 14;
  public static final int M30 = 3;
  public static final int M31 = 7;
  public static final int M32 = 11;
  public static final int M33 = 15;
  static Vector3 l_vex = new Vector3();
  static Vector3 l_vey = new Vector3();
  static Vector3 l_vez;
  static Quaternion quat = new Quaternion();
  private static final long serialVersionUID = -2717655254359579617L;
  public final float[] tmp = new float[16];
  public final float[] val = new float[16];
  
  static
  {
    l_vez = new Vector3();
  }
  
  public Matrix4()
  {
    this.val[0] = 1.0F;
    this.val[5] = 1.0F;
    this.val[10] = 1.0F;
    this.val[15] = 1.0F;
  }
  
  public Matrix4(Matrix4 paramMatrix4)
  {
    set(paramMatrix4);
  }
  
  public Matrix4(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }
  
  public Matrix4(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat);
  }
  
  public void getRotation(Quaternion paramQuaternion)
  {
    paramQuaternion.setFromMatrix(this);
  }
  
  public void getTranslation(Vector3 paramVector3)
  {
    paramVector3.x = this.val[12];
    paramVector3.y = this.val[13];
    paramVector3.z = this.val[14];
  }
  
  public float[] getValues()
  {
    return this.val;
  }
  
  public Matrix4 idt()
  {
    this.val[0] = 1.0F;
    this.val[4] = 0.0F;
    this.val[8] = 0.0F;
    this.val[12] = 0.0F;
    this.val[1] = 0.0F;
    this.val[5] = 1.0F;
    this.val[9] = 0.0F;
    this.val[13] = 0.0F;
    this.val[2] = 0.0F;
    this.val[6] = 0.0F;
    this.val[10] = 1.0F;
    this.val[14] = 0.0F;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }
  
  public Matrix4 inv()
  {
    float f = this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
    if (f == 0.0F) {
      throw new RuntimeException("non-invertible matrix");
    }
    f = 1.0F / f;
    this.tmp[0] = (this.val[9] * this.val[14] * this.val[7] - this.val[13] * this.val[10] * this.val[7] + this.val[13] * this.val[6] * this.val[11] - this.val[5] * this.val[14] * this.val[11] - this.val[9] * this.val[6] * this.val[15] + this.val[5] * this.val[10] * this.val[15]);
    this.tmp[4] = (this.val[12] * this.val[10] * this.val[7] - this.val[8] * this.val[14] * this.val[7] - this.val[12] * this.val[6] * this.val[11] + this.val[4] * this.val[14] * this.val[11] + this.val[8] * this.val[6] * this.val[15] - this.val[4] * this.val[10] * this.val[15]);
    this.tmp[8] = (this.val[8] * this.val[13] * this.val[7] - this.val[12] * this.val[9] * this.val[7] + this.val[12] * this.val[5] * this.val[11] - this.val[4] * this.val[13] * this.val[11] - this.val[8] * this.val[5] * this.val[15] + this.val[4] * this.val[9] * this.val[15]);
    this.tmp[12] = (this.val[12] * this.val[9] * this.val[6] - this.val[8] * this.val[13] * this.val[6] - this.val[12] * this.val[5] * this.val[10] + this.val[4] * this.val[13] * this.val[10] + this.val[8] * this.val[5] * this.val[14] - this.val[4] * this.val[9] * this.val[14]);
    this.tmp[1] = (this.val[13] * this.val[10] * this.val[3] - this.val[9] * this.val[14] * this.val[3] - this.val[13] * this.val[2] * this.val[11] + this.val[1] * this.val[14] * this.val[11] + this.val[9] * this.val[2] * this.val[15] - this.val[1] * this.val[10] * this.val[15]);
    this.tmp[5] = (this.val[8] * this.val[14] * this.val[3] - this.val[12] * this.val[10] * this.val[3] + this.val[12] * this.val[2] * this.val[11] - this.val[0] * this.val[14] * this.val[11] - this.val[8] * this.val[2] * this.val[15] + this.val[0] * this.val[10] * this.val[15]);
    this.tmp[9] = (this.val[12] * this.val[9] * this.val[3] - this.val[8] * this.val[13] * this.val[3] - this.val[12] * this.val[1] * this.val[11] + this.val[0] * this.val[13] * this.val[11] + this.val[8] * this.val[1] * this.val[15] - this.val[0] * this.val[9] * this.val[15]);
    this.tmp[13] = (this.val[8] * this.val[13] * this.val[2] - this.val[12] * this.val[9] * this.val[2] + this.val[12] * this.val[1] * this.val[10] - this.val[0] * this.val[13] * this.val[10] - this.val[8] * this.val[1] * this.val[14] + this.val[0] * this.val[9] * this.val[14]);
    this.tmp[2] = (this.val[5] * this.val[14] * this.val[3] - this.val[13] * this.val[6] * this.val[3] + this.val[13] * this.val[2] * this.val[7] - this.val[1] * this.val[14] * this.val[7] - this.val[5] * this.val[2] * this.val[15] + this.val[1] * this.val[6] * this.val[15]);
    this.tmp[6] = (this.val[12] * this.val[6] * this.val[3] - this.val[4] * this.val[14] * this.val[3] - this.val[12] * this.val[2] * this.val[7] + this.val[0] * this.val[14] * this.val[7] + this.val[4] * this.val[2] * this.val[15] - this.val[0] * this.val[6] * this.val[15]);
    this.tmp[10] = (this.val[4] * this.val[13] * this.val[3] - this.val[12] * this.val[5] * this.val[3] + this.val[12] * this.val[1] * this.val[7] - this.val[0] * this.val[13] * this.val[7] - this.val[4] * this.val[1] * this.val[15] + this.val[0] * this.val[5] * this.val[15]);
    this.tmp[14] = (this.val[12] * this.val[5] * this.val[2] - this.val[4] * this.val[13] * this.val[2] - this.val[12] * this.val[1] * this.val[6] + this.val[0] * this.val[13] * this.val[6] + this.val[4] * this.val[1] * this.val[14] - this.val[0] * this.val[5] * this.val[14]);
    this.tmp[3] = (this.val[9] * this.val[6] * this.val[3] - this.val[5] * this.val[10] * this.val[3] - this.val[9] * this.val[2] * this.val[7] + this.val[1] * this.val[10] * this.val[7] + this.val[5] * this.val[2] * this.val[11] - this.val[1] * this.val[6] * this.val[11]);
    this.tmp[7] = (this.val[4] * this.val[10] * this.val[3] - this.val[8] * this.val[6] * this.val[3] + this.val[8] * this.val[2] * this.val[7] - this.val[0] * this.val[10] * this.val[7] - this.val[4] * this.val[2] * this.val[11] + this.val[0] * this.val[6] * this.val[11]);
    this.tmp[11] = (this.val[8] * this.val[5] * this.val[3] - this.val[4] * this.val[9] * this.val[3] - this.val[8] * this.val[1] * this.val[7] + this.val[0] * this.val[9] * this.val[7] + this.val[4] * this.val[1] * this.val[11] - this.val[0] * this.val[5] * this.val[11]);
    this.tmp[15] = (this.val[4] * this.val[9] * this.val[2] - this.val[8] * this.val[5] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] + this.val[0] * this.val[5] * this.val[10]);
    this.val[0] = (this.tmp[0] * f);
    this.val[4] = (this.tmp[4] * f);
    this.val[8] = (this.tmp[8] * f);
    this.val[12] = (this.tmp[12] * f);
    this.val[1] = (this.tmp[1] * f);
    this.val[5] = (this.tmp[5] * f);
    this.val[9] = (this.tmp[9] * f);
    this.val[13] = (this.tmp[13] * f);
    this.val[2] = (this.tmp[2] * f);
    this.val[6] = (this.tmp[6] * f);
    this.val[10] = (this.tmp[10] * f);
    this.val[14] = (this.tmp[14] * f);
    this.val[3] = (this.tmp[3] * f);
    this.val[7] = (this.tmp[7] * f);
    this.val[11] = (this.tmp[11] * f);
    this.val[15] = (f * this.tmp[15]);
    return this;
  }
  
  public void lerp(Matrix4 paramMatrix4, float paramFloat)
  {
    int i = 0;
    while (i < 16)
    {
      this.val[i] = (this.val[i] * (1.0F - paramFloat) + paramMatrix4.val[i] * paramFloat);
      i += 1;
    }
  }
  
  public Matrix4 mul(Matrix4 paramMatrix4)
  {
    return mul_java(paramMatrix4);
  }
  
  public Matrix4 mul_java(Matrix4 paramMatrix4)
  {
    this.tmp[0] = (this.val[0] * paramMatrix4.val[0] + this.val[4] * paramMatrix4.val[1] + this.val[8] * paramMatrix4.val[2] + this.val[12] * paramMatrix4.val[3]);
    this.tmp[4] = (this.val[0] * paramMatrix4.val[4] + this.val[4] * paramMatrix4.val[5] + this.val[8] * paramMatrix4.val[6] + this.val[12] * paramMatrix4.val[7]);
    this.tmp[8] = (this.val[0] * paramMatrix4.val[8] + this.val[4] * paramMatrix4.val[9] + this.val[8] * paramMatrix4.val[10] + this.val[12] * paramMatrix4.val[11]);
    this.tmp[12] = (this.val[0] * paramMatrix4.val[12] + this.val[4] * paramMatrix4.val[13] + this.val[8] * paramMatrix4.val[14] + this.val[12] * paramMatrix4.val[15]);
    this.tmp[1] = (this.val[1] * paramMatrix4.val[0] + this.val[5] * paramMatrix4.val[1] + this.val[9] * paramMatrix4.val[2] + this.val[13] * paramMatrix4.val[3]);
    this.tmp[5] = (this.val[1] * paramMatrix4.val[4] + this.val[5] * paramMatrix4.val[5] + this.val[9] * paramMatrix4.val[6] + this.val[13] * paramMatrix4.val[7]);
    this.tmp[9] = (this.val[1] * paramMatrix4.val[8] + this.val[5] * paramMatrix4.val[9] + this.val[9] * paramMatrix4.val[10] + this.val[13] * paramMatrix4.val[11]);
    this.tmp[13] = (this.val[1] * paramMatrix4.val[12] + this.val[5] * paramMatrix4.val[13] + this.val[9] * paramMatrix4.val[14] + this.val[13] * paramMatrix4.val[15]);
    this.tmp[2] = (this.val[2] * paramMatrix4.val[0] + this.val[6] * paramMatrix4.val[1] + this.val[10] * paramMatrix4.val[2] + this.val[14] * paramMatrix4.val[3]);
    this.tmp[6] = (this.val[2] * paramMatrix4.val[4] + this.val[6] * paramMatrix4.val[5] + this.val[10] * paramMatrix4.val[6] + this.val[14] * paramMatrix4.val[7]);
    this.tmp[10] = (this.val[2] * paramMatrix4.val[8] + this.val[6] * paramMatrix4.val[9] + this.val[10] * paramMatrix4.val[10] + this.val[14] * paramMatrix4.val[11]);
    this.tmp[14] = (this.val[2] * paramMatrix4.val[12] + this.val[6] * paramMatrix4.val[13] + this.val[10] * paramMatrix4.val[14] + this.val[14] * paramMatrix4.val[15]);
    this.tmp[3] = (this.val[3] * paramMatrix4.val[0] + this.val[7] * paramMatrix4.val[1] + this.val[11] * paramMatrix4.val[2] + this.val[15] * paramMatrix4.val[3]);
    this.tmp[7] = (this.val[3] * paramMatrix4.val[4] + this.val[7] * paramMatrix4.val[5] + this.val[11] * paramMatrix4.val[6] + this.val[15] * paramMatrix4.val[7]);
    this.tmp[11] = (this.val[3] * paramMatrix4.val[8] + this.val[7] * paramMatrix4.val[9] + this.val[11] * paramMatrix4.val[10] + this.val[15] * paramMatrix4.val[11]);
    this.tmp[15] = (this.val[3] * paramMatrix4.val[12] + this.val[7] * paramMatrix4.val[13] + this.val[11] * paramMatrix4.val[14] + this.val[15] * paramMatrix4.val[15]);
    return set(this.tmp);
  }
  
  public Matrix4 set(Matrix3 paramMatrix3)
  {
    this.val[0] = paramMatrix3.val[0];
    this.val[1] = paramMatrix3.val[1];
    this.val[2] = paramMatrix3.val[2];
    this.val[3] = 0.0F;
    this.val[4] = paramMatrix3.val[3];
    this.val[5] = paramMatrix3.val[4];
    this.val[6] = paramMatrix3.val[5];
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = 1.0F;
    this.val[11] = 0.0F;
    this.val[12] = paramMatrix3.val[6];
    this.val[13] = paramMatrix3.val[7];
    this.val[14] = 0.0F;
    this.val[15] = paramMatrix3.val[8];
    return this;
  }
  
  public Matrix4 set(Matrix4 paramMatrix4)
  {
    return set(paramMatrix4.val);
  }
  
  public Matrix4 set(Quaternion paramQuaternion)
  {
    float f1 = paramQuaternion.x * paramQuaternion.x;
    float f2 = paramQuaternion.x * paramQuaternion.y;
    float f3 = paramQuaternion.x * paramQuaternion.z;
    float f4 = paramQuaternion.x * paramQuaternion.w;
    float f5 = paramQuaternion.y * paramQuaternion.y;
    float f6 = paramQuaternion.y * paramQuaternion.z;
    float f7 = paramQuaternion.y * paramQuaternion.w;
    float f8 = paramQuaternion.z * paramQuaternion.z;
    float f9 = paramQuaternion.z * paramQuaternion.w;
    this.val[0] = (1.0F - 2.0F * (f5 + f8));
    this.val[4] = (2.0F * (f2 - f9));
    this.val[8] = (2.0F * (f3 + f7));
    this.val[12] = 0.0F;
    this.val[1] = ((f2 + f9) * 2.0F);
    this.val[5] = (1.0F - (f8 + f1) * 2.0F);
    this.val[9] = (2.0F * (f6 - f4));
    this.val[13] = 0.0F;
    this.val[2] = ((f3 - f7) * 2.0F);
    this.val[6] = ((f4 + f6) * 2.0F);
    this.val[10] = (1.0F - (f1 + f5) * 2.0F);
    this.val[14] = 0.0F;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }
  
  public Matrix4 set(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34)
  {
    this.val[0] = paramVector31.x;
    this.val[4] = paramVector31.y;
    this.val[8] = paramVector31.z;
    this.val[1] = paramVector32.x;
    this.val[5] = paramVector32.y;
    this.val[9] = paramVector32.z;
    this.val[2] = (-paramVector33.x);
    this.val[6] = (-paramVector33.y);
    this.val[10] = (-paramVector33.z);
    this.val[12] = paramVector34.x;
    this.val[13] = paramVector34.y;
    this.val[14] = paramVector34.z;
    this.val[3] = 0.0F;
    this.val[7] = 0.0F;
    this.val[11] = 0.0F;
    this.val[15] = 1.0F;
    return this;
  }
  
  public Matrix4 set(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.val, 0, this.val.length);
    return this;
  }
  
  public Matrix4 setToLookAt(Vector3 paramVector31, Vector3 paramVector32)
  {
    l_vez.set(paramVector31).nor();
    l_vex.set(paramVector31).nor();
    l_vex.crs(paramVector32).nor();
    l_vey.set(l_vex).crs(l_vez).nor();
    idt();
    this.val[0] = l_vex.x;
    this.val[4] = l_vex.y;
    this.val[8] = l_vex.z;
    this.val[1] = l_vey.x;
    this.val[5] = l_vey.y;
    this.val[9] = l_vey.z;
    this.val[2] = (-l_vez.x);
    this.val[6] = (-l_vez.y);
    this.val[10] = (-l_vez.z);
    return this;
  }
  
  public Matrix4 setToOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    idt();
    float f1 = 2.0F / (paramFloat2 - paramFloat1);
    float f2 = 2.0F / (paramFloat4 - paramFloat3);
    float f3 = -2.0F / (paramFloat6 - paramFloat5);
    paramFloat1 = -(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1);
    paramFloat2 = -(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3);
    paramFloat3 = -(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5);
    this.val[0] = f1;
    this.val[1] = 0.0F;
    this.val[2] = 0.0F;
    this.val[3] = 0.0F;
    this.val[4] = 0.0F;
    this.val[5] = f2;
    this.val[6] = 0.0F;
    this.val[7] = 0.0F;
    this.val[8] = 0.0F;
    this.val[9] = 0.0F;
    this.val[10] = f3;
    this.val[11] = 0.0F;
    this.val[12] = paramFloat1;
    this.val[13] = paramFloat2;
    this.val[14] = paramFloat3;
    this.val[15] = 1.0F;
    return this;
  }
  
  public Matrix4 setToOrtho2D(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setToOrtho(paramFloat1, paramFloat1 + paramFloat3, paramFloat2, paramFloat2 + paramFloat4, 0.0F, 1.0F);
    return this;
  }
  
  public Matrix4 setToRotation(Vector3 paramVector3, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      idt();
      return this;
    }
    return set(quat.set(paramVector3, paramFloat));
  }
  
  public Matrix4 setToTranslation(Vector3 paramVector3)
  {
    idt();
    this.val[12] = paramVector3.x;
    this.val[13] = paramVector3.y;
    this.val[14] = paramVector3.z;
    return this;
  }
  
  public String toString()
  {
    return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
  }
  
  public Matrix4 tra()
  {
    this.tmp[0] = this.val[0];
    this.tmp[4] = this.val[1];
    this.tmp[8] = this.val[2];
    this.tmp[12] = this.val[3];
    this.tmp[1] = this.val[4];
    this.tmp[5] = this.val[5];
    this.tmp[9] = this.val[6];
    this.tmp[13] = this.val[7];
    this.tmp[2] = this.val[8];
    this.tmp[6] = this.val[9];
    this.tmp[10] = this.val[10];
    this.tmp[14] = this.val[11];
    this.tmp[3] = this.val[12];
    this.tmp[7] = this.val[13];
    this.tmp[11] = this.val[14];
    this.tmp[15] = this.val[15];
    return set(this.tmp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Matrix4
 * JD-Core Version:    0.7.0.1
 */