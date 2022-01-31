import android.graphics.Bitmap;
import android.graphics.Matrix;

public class wyd
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (!paramBitmap.isRecycled())
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        int k = ((Long)wwt.a().a("SmartCutPicWidth", Long.valueOf(224L))).intValue();
        float f1 = k / i;
        float f2 = k / j;
        atpg.a("Q.videostory", "Q.videostory.capture", "resizeImage", k + " " + k);
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f1, f2);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyd
 * JD-Core Version:    0.7.0.1
 */