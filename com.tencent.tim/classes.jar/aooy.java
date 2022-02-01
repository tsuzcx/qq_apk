import android.graphics.Bitmap;
import android.graphics.Matrix;

public class aooy
  extends aoov
  implements aoou
{
  String path;
  
  public aooy(String paramString)
  {
    this.path = paramString;
  }
  
  public Bitmap Q(Bitmap paramBitmap)
  {
    int i = aoop.eI(this.path);
    if (i == 0) {
      return getBitmap(paramBitmap);
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(i, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if ((localObject == null) || (localObject == paramBitmap)) {
      throw new OutOfMemoryError("OOM");
    }
    paramBitmap.recycle();
    return getBitmap((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooy
 * JD-Core Version:    0.7.0.1
 */