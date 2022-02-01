import android.graphics.Bitmap;
import android.graphics.Matrix;

public class arij
{
  private Bitmap mBitmap;
  private int mRotation;
  
  public arij(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.mRotation = 0;
  }
  
  public arij(Bitmap paramBitmap, int paramInt)
  {
    this.mBitmap = paramBitmap;
    this.mRotation = (paramInt % 360);
  }
  
  public Matrix a()
  {
    Matrix localMatrix = new Matrix();
    if (this.mRotation != 0)
    {
      int i = this.mBitmap.getWidth() / 2;
      int j = this.mBitmap.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.mRotation);
      localMatrix.postTranslate(getWidth() / 2, getHeight() / 2);
    }
    return localMatrix;
  }
  
  public boolean aGE()
  {
    return this.mRotation / 90 % 2 != 0;
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getHeight()
  {
    if (aGE()) {
      return this.mBitmap.getWidth();
    }
    return this.mBitmap.getHeight();
  }
  
  public int getRotation()
  {
    return this.mRotation;
  }
  
  public int getWidth()
  {
    if (aGE()) {
      return this.mBitmap.getHeight();
    }
    return this.mBitmap.getWidth();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arij
 * JD-Core Version:    0.7.0.1
 */