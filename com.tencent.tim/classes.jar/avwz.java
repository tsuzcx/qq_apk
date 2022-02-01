import android.graphics.Bitmap;

public class avwz
{
  private int ezg = -1;
  private int ezh;
  private Bitmap he;
  
  public int PN()
  {
    return this.ezg;
  }
  
  public int PO()
  {
    return this.ezh;
  }
  
  public int PP()
  {
    if (this.he != null) {
      return this.he.getByteCount();
    }
    return 0;
  }
  
  public void acd(int paramInt)
  {
    this.ezh = paramInt;
  }
  
  public void an(Bitmap paramBitmap)
  {
    this.he = paramBitmap;
  }
  
  public void eCm()
  {
    if (this.he == null) {}
    while (this.ezg > 0) {
      return;
    }
    this.ezg = avxc.a(this.he, true);
  }
  
  public void eCn()
  {
    if (this.he != null)
    {
      this.he.recycle();
      this.he = null;
    }
    avxc.deleteTexture(this.ezg);
    this.ezg = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwz
 * JD-Core Version:    0.7.0.1
 */