package com.tencent.mobileqq.armap.sensor.rotation;

import advf;
import java.io.Serializable;

public class Quaternion
  implements Serializable
{
  private static Quaternion a = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  private static Quaternion b = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  private static final long serialVersionUID = -7661875440774897168L;
  public float w;
  public float x;
  public float y;
  public float z;
  
  public Quaternion()
  {
    idt();
  }
  
  public Quaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public Quaternion(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }
  
  public Quaternion(Vector3 paramVector3, float paramFloat)
  {
    set(paramVector3, paramFloat);
  }
  
  public Quaternion conjugate()
  {
    this.x = (-this.x);
    this.y = (-this.y);
    this.z = (-this.z);
    return this;
  }
  
  public Quaternion cpy()
  {
    return new Quaternion(this);
  }
  
  public float dot(Quaternion paramQuaternion)
  {
    return this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Quaternion)) {
        return false;
      }
      paramObject = (Quaternion)paramObject;
    } while ((this.x == paramObject.x) && (this.y == paramObject.y) && (this.z == paramObject.z) && (this.w == paramObject.w));
    return false;
  }
  
  public Quaternion idt()
  {
    set(0.0F, 0.0F, 0.0F, 1.0F);
    return this;
  }
  
  public float len()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
  }
  
  public float len2()
  {
    return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
  }
  
  public Quaternion mul(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    this.z *= paramFloat;
    this.w *= paramFloat;
    return this;
  }
  
  public Quaternion mulLeft(Quaternion paramQuaternion)
  {
    float f1 = paramQuaternion.w;
    float f2 = this.x;
    float f3 = paramQuaternion.x;
    float f4 = this.w;
    float f5 = paramQuaternion.y;
    float f6 = this.z;
    float f7 = paramQuaternion.z;
    float f8 = this.y;
    float f9 = paramQuaternion.w;
    float f10 = this.y;
    float f11 = paramQuaternion.y;
    float f12 = this.w;
    float f13 = paramQuaternion.z;
    float f14 = this.x;
    float f15 = paramQuaternion.x;
    float f16 = this.z;
    float f17 = paramQuaternion.w;
    float f18 = this.z;
    float f19 = paramQuaternion.z;
    float f20 = this.w;
    float f21 = paramQuaternion.x;
    float f22 = this.y;
    float f23 = paramQuaternion.y;
    float f24 = this.x;
    float f25 = paramQuaternion.w;
    float f26 = this.w;
    float f27 = paramQuaternion.x;
    float f28 = this.x;
    float f29 = paramQuaternion.y;
    float f30 = this.y;
    float f31 = paramQuaternion.z;
    float f32 = this.z;
    this.x = (f1 * f2 + f3 * f4 + f5 * f6 - f7 * f8);
    this.y = (f9 * f10 + f11 * f12 + f13 * f14 - f15 * f16);
    this.z = (f17 * f18 + f19 * f20 + f21 * f22 - f23 * f24);
    this.w = (f25 * f26 - f27 * f28 - f29 * f30 - f31 * f32);
    return this;
  }
  
  public Quaternion nor()
  {
    float f = len2();
    if ((f != 0.0F) && (Math.abs(f - 1.0F) > 1.0E-005F))
    {
      f = (float)Math.sqrt(f);
      this.w /= f;
      this.x /= f;
      this.y /= f;
      this.z /= f;
    }
    return this;
  }
  
  public Quaternion set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
    return this;
  }
  
  public Quaternion set(Quaternion paramQuaternion)
  {
    return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
  }
  
  public Quaternion set(Vector3 paramVector3, float paramFloat)
  {
    float f = (float)Math.toRadians(paramFloat);
    paramFloat = (float)Math.sin(f / 2.0F);
    f = (float)Math.cos(f / 2.0F);
    return set(paramVector3.x * paramFloat, paramVector3.y * paramFloat, paramFloat * paramVector3.z, f).nor();
  }
  
  public Quaternion setFromAxes(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    float f = paramFloat1 + paramFloat5 + paramFloat9;
    double d1;
    double d4;
    double d3;
    double d2;
    if (f >= 0.0F)
    {
      d1 = Math.sqrt(f + 1.0F);
      d4 = 0.5D * d1;
      d1 = 0.5D / d1;
      d3 = (paramFloat8 - paramFloat6) * d1;
      d2 = (paramFloat3 - paramFloat7) * d1;
      d1 *= (paramFloat4 - paramFloat2);
    }
    for (;;)
    {
      return set((float)d3, (float)d2, (float)d1, (float)d4);
      if ((paramFloat1 > paramFloat5) && (paramFloat1 > paramFloat9))
      {
        d1 = Math.sqrt(1.0D + paramFloat1 - paramFloat5 - paramFloat9);
        d3 = d1 * 0.5D;
        d4 = 0.5D / d1;
        d2 = (paramFloat4 + paramFloat2) * d4;
        d1 = (paramFloat3 + paramFloat7) * d4;
        d4 *= (paramFloat8 - paramFloat6);
      }
      else if (paramFloat5 > paramFloat9)
      {
        d1 = Math.sqrt(1.0D + paramFloat5 - paramFloat1 - paramFloat9);
        d2 = 0.5D * d1;
        d4 = 0.5D / d1;
        d3 = (paramFloat4 + paramFloat2) * d4;
        d1 = (paramFloat8 + paramFloat6) * d4;
        d4 *= (paramFloat3 - paramFloat7);
      }
      else
      {
        d2 = Math.sqrt(1.0D + paramFloat9 - paramFloat1 - paramFloat5);
        d1 = 0.5D * d2;
        d4 = 0.5D / d2;
        d3 = (paramFloat3 + paramFloat7) * d4;
        d2 = (paramFloat8 + paramFloat6) * d4;
        d4 *= (paramFloat4 - paramFloat2);
      }
    }
  }
  
  public Quaternion setFromAxis(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat4 = 0.01745329F * paramFloat4;
    float f = advf.sin(paramFloat4 / 2.0F);
    return set(paramFloat1 * f, paramFloat2 * f, f * paramFloat3, advf.cos(paramFloat4 / 2.0F)).nor();
  }
  
  public Quaternion setFromAxis(Vector3 paramVector3, float paramFloat)
  {
    return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
  }
  
  public Quaternion setFromMatrix(Matrix4 paramMatrix4)
  {
    return setFromAxes(paramMatrix4.val[0], paramMatrix4.val[4], paramMatrix4.val[8], paramMatrix4.val[1], paramMatrix4.val[5], paramMatrix4.val[9], paramMatrix4.val[2], paramMatrix4.val[6], paramMatrix4.val[10]);
  }
  
  public Quaternion slerp(Quaternion paramQuaternion, float paramFloat)
  {
    if (equals(paramQuaternion)) {
      return this;
    }
    float f1 = dot(paramQuaternion);
    if (f1 < 0.0D)
    {
      paramQuaternion.mul(-1.0F);
      f1 = -f1;
    }
    for (;;)
    {
      float f3 = 1.0F - paramFloat;
      float f2 = paramFloat;
      if (1.0F - f1 > 0.1D)
      {
        double d1 = Math.acos(f1);
        double d2 = 1.0D / Math.sin(d1);
        f3 = (float)(Math.sin((1.0F - paramFloat) * d1) * d2);
        f2 = (float)(Math.sin(d1 * paramFloat) * d2);
      }
      set(this.x * f3 + paramQuaternion.x * f2, this.y * f3 + paramQuaternion.y * f2, this.z * f3 + paramQuaternion.z * f2, f3 * this.w + paramQuaternion.w * f2);
      return this;
    }
  }
  
  public String toString()
  {
    return "[" + this.x + "|" + this.y + "|" + this.z + "|" + this.w + "]";
  }
  
  public void transform(Vector3 paramVector3)
  {
    b.set(this);
    b.conjugate();
    b.mulLeft(a.set(paramVector3.x, paramVector3.y, paramVector3.z, 0.0F)).mulLeft(this);
    paramVector3.x = b.x;
    paramVector3.y = b.y;
    paramVector3.z = b.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Quaternion
 * JD-Core Version:    0.7.0.1
 */