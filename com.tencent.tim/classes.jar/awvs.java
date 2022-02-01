import android.graphics.Bitmap;
import android.graphics.Rect;

public class awvs
{
  public final boolean dsW;
  public final int eDe;
  public final int eDf;
  public final int eDg;
  public final int height;
  public final int width;
  public final int x;
  public final int y;
  
  public awvs(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.dsW = paramBoolean;
    this.eDf = paramInt5;
    this.eDe = paramInt6;
    this.eDg = paramInt7;
  }
  
  public static awvs a(Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new awvs(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public static awvs a(Rect paramRect, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new awvs(paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public String toString()
  {
    return "CropConfig{x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", addPadding=" + this.dsW + ", verticalPadding=" + this.eDe + ", horizontalPadding=" + this.eDf + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvs
 * JD-Core Version:    0.7.0.1
 */