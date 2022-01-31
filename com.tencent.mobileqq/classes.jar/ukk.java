import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class ukk
{
  @NonNull
  private final Bitmap a;
  
  public ukk(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new NullPointerException("bitmap should not be null");
    }
    this.a = paramBitmap;
  }
  
  public int a()
  {
    return this.a.getWidth();
  }
  
  public Bitmap a()
  {
    return Bitmap.createBitmap(this.a);
  }
  
  public int b()
  {
    return this.a.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukk
 * JD-Core Version:    0.7.0.1
 */