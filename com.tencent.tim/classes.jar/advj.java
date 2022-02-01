import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;

public final class advj
{
  private static advj b = new advj();
  private static advj c = new advj();
  private static advj d = new advj();
  public float w;
  public float x;
  public float y;
  public float z;
  
  public advj a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
    return this;
  }
  
  public advj a(Matrix4 paramMatrix4)
  {
    paramMatrix4 = paramMatrix4.val;
    float f1 = this.x;
    float f2 = paramMatrix4[0];
    float f3 = this.y;
    float f4 = paramMatrix4[4];
    float f5 = this.z;
    float f6 = paramMatrix4[8];
    float f7 = this.w;
    float f8 = paramMatrix4[12];
    float f9 = this.x;
    float f10 = paramMatrix4[1];
    float f11 = this.y;
    float f12 = paramMatrix4[5];
    float f13 = this.z;
    float f14 = paramMatrix4[9];
    float f15 = this.w;
    float f16 = paramMatrix4[13];
    float f17 = this.x;
    float f18 = paramMatrix4[2];
    float f19 = this.y;
    float f20 = paramMatrix4[6];
    float f21 = this.z;
    float f22 = paramMatrix4[10];
    float f23 = this.w;
    float f24 = paramMatrix4[14];
    float f25 = this.x;
    float f26 = paramMatrix4[3];
    float f27 = this.y;
    float f28 = paramMatrix4[7];
    float f29 = this.z;
    float f30 = paramMatrix4[11];
    float f31 = this.w;
    return a(f1 * f2 + f3 * f4 + f5 * f6 + f7 * f8, f9 * f10 + f11 * f12 + f13 * f14 + f15 * f16, f17 * f18 + f19 * f20 + f21 * f22 + f23 * f24, paramMatrix4[15] * f31 + (f25 * f26 + f27 * f28 + f29 * f30));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (advj)paramObject;
      if (Float.floatToIntBits(this.x) != Float.floatToIntBits(paramObject.x)) {
        return false;
      }
      if (Float.floatToIntBits(this.y) != Float.floatToIntBits(paramObject.y)) {
        return false;
      }
      if (Float.floatToIntBits(this.z) != Float.floatToIntBits(paramObject.z)) {
        return false;
      }
    } while (Float.floatToIntBits(this.w) == Float.floatToIntBits(paramObject.w));
    return false;
  }
  
  public int hashCode()
  {
    return (((Float.floatToIntBits(this.x) + 31) * 31 + Float.floatToIntBits(this.y)) * 31 + Float.floatToIntBits(this.z)) * 31 + Float.floatToIntBits(this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advj
 * JD-Core Version:    0.7.0.1
 */