import android.graphics.Bitmap;
import android.graphics.Matrix;

public class zai
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i;
    int j;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((i > 0) && (j > 0)) {}
    }
    else
    {
      return paramBitmap;
    }
    int k = ((Long)yyw.a().a("SmartCutPicWidth", Long.valueOf(224L))).intValue();
    float f1 = k / i;
    float f2 = k / j;
    awiw.a("Q.videostory", "Q.videostory.capture", "resizeImage", k + " " + k);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zai
 * JD-Core Version:    0.7.0.1
 */