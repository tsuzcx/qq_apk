import android.graphics.Matrix;

public class akpm
{
  private final float[] C = new float[9];
  private final Matrix matrix = new Matrix();
  private float rotation;
  protected float x;
  protected float y;
  private float zoom = 1.0F;
  
  private void cl(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.matrix.getValues(this.C);
    this.x = this.C[2];
    this.y = this.C[5];
    if (paramBoolean1) {
      this.zoom = ((float)Math.hypot(this.C[1], this.C[4]));
    }
    if (paramBoolean2) {
      this.rotation = ((float)Math.toDegrees(Math.atan2(this.C[3], this.C[4])));
    }
  }
  
  public static int compare(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2 + 0.001F) {
      return 1;
    }
    if (paramFloat1 < paramFloat2 - 0.001F) {
      return -1;
    }
    return 0;
  }
  
  public static boolean equals(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= paramFloat2 - 0.001F) && (paramFloat1 <= paramFloat2 + 0.001F);
  }
  
  public void V(float paramFloat1, float paramFloat2)
  {
    this.matrix.postTranslate(paramFloat1, paramFloat2);
    cl(false, false);
  }
  
  public void W(float paramFloat1, float paramFloat2)
  {
    this.matrix.postTranslate(-this.x + paramFloat1, -this.y + paramFloat2);
    cl(false, false);
  }
  
  public akpm b()
  {
    akpm localakpm = new akpm();
    localakpm.c(this);
    return localakpm;
  }
  
  public void c(akpm paramakpm)
  {
    this.x = paramakpm.x;
    this.y = paramakpm.y;
    this.zoom = paramakpm.zoom;
    this.rotation = paramakpm.rotation;
    this.matrix.set(paramakpm.matrix);
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.matrix.postScale(paramFloat1 / this.zoom, paramFloat1 / this.zoom, paramFloat2, paramFloat3);
    cl(true, false);
  }
  
  public void d(Matrix paramMatrix)
  {
    paramMatrix.set(this.matrix);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (akpm)paramObject;
    } while ((equals(paramObject.x, this.x)) && (equals(paramObject.y, this.y)) && (equals(paramObject.zoom, this.zoom)) && (equals(paramObject.rotation, this.rotation)));
    return false;
  }
  
  public Matrix getMatrix()
  {
    return this.matrix;
  }
  
  public float getRotation()
  {
    return this.rotation;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public float getZoom()
  {
    return this.zoom;
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.x != 0.0F)
    {
      i = Float.floatToIntBits(this.x);
      if (this.y == 0.0F) {
        break label95;
      }
      j = Float.floatToIntBits(this.y);
      label37:
      if (this.zoom == 0.0F) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = Float.floatToIntBits(this.zoom);; k = 0)
    {
      if (this.rotation != 0.0F) {
        m = Float.floatToIntBits(this.rotation);
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  public void k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.matrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    cl(true, false);
  }
  
  public void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.matrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
    cl(false, true);
  }
  
  public void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.matrix.postRotate(-this.rotation + paramFloat1, paramFloat2, paramFloat3);
    cl(false, true);
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f;
    for (;;)
    {
      f = paramFloat4;
      if (paramFloat4 >= -180.0F) {
        break;
      }
      paramFloat4 += 360.0F;
    }
    while (f > 180.0F) {
      f -= 360.0F;
    }
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.zoom = paramFloat3;
    this.rotation = f;
    this.matrix.reset();
    if (paramFloat3 != 1.0F) {
      this.matrix.postScale(paramFloat3, paramFloat3);
    }
    if (f != 0.0F) {
      this.matrix.postRotate(f);
    }
    this.matrix.postTranslate(paramFloat1, paramFloat2);
  }
  
  public String toString()
  {
    return "{x=" + this.x + ",y=" + this.y + ",zoom=" + this.zoom + ",rotation=" + this.rotation + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpm
 * JD-Core Version:    0.7.0.1
 */