import android.graphics.Bitmap;
import android.graphics.Matrix;

public class sqm
{
  public static Bitmap C(Bitmap paramBitmap)
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
    int k = ((Long)spp.a().getValue("SmartCutPicWidth", Long.valueOf(224L))).intValue();
    float f1 = k / i;
    float f2 = k / j;
    akxe.M("Q.videostory", "Q.videostory.capture", "resizeImage", k + " " + k);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqm
 * JD-Core Version:    0.7.0.1
 */