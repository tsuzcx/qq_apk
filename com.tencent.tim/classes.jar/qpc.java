import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class qpc
{
  @NonNull
  private final Bitmap bitmap;
  
  public qpc(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new NullPointerException("bitmap should not be null");
    }
    this.bitmap = paramBitmap;
  }
  
  public Bitmap S()
  {
    return Bitmap.createBitmap(this.bitmap);
  }
  
  public int getHeight()
  {
    return this.bitmap.getHeight();
  }
  
  public int getWidth()
  {
    return this.bitmap.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */