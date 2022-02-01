import android.graphics.Rect;

public class axid
{
  public float[] angles;
  public Rect mFace;
  
  public axid(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFace = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getArea()
  {
    return Math.abs(this.mFace.left - this.mFace.right) * Math.abs(this.mFace.top - this.mFace.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axid
 * JD-Core Version:    0.7.0.1
 */