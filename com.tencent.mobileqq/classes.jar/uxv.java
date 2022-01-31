import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import java.util.Map;

public class uxv
  implements uxw
{
  private float jdField_a_of_type_Float = 1.0F;
  protected final int a;
  public Bitmap a;
  private String jdField_a_of_type_JavaLangString;
  public Map<String, Bitmap> a;
  protected final int b;
  
  public uxv(int paramInt1, int paramInt2, float paramFloat, Map<String, Bitmap> paramMap, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaLangString = uyl.a(new Object[] { "rounded", "r=", Integer.valueOf(paramInt1), "dm=", Integer.valueOf(paramInt2), "ds=", Float.valueOf(paramFloat) });
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        float f3 = f2 / f1;
        int m = (int)f2;
        int k = (int)f1;
        int j;
        int i;
        if (f3 > this.jdField_a_of_type_Float)
        {
          m = (int)(paramBitmap.getWidth() * this.jdField_a_of_type_Float);
          j = (paramBitmap.getHeight() - m) / 2;
          i = 0;
          if (this.jdField_a_of_type_JavaUtilMap == null) {
            break label422;
          }
          localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get("RT:w=" + k + "h=" + m);
          if ((localBitmap == null) || (localBitmap.isRecycled()))
          {
            paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
            localBitmap = paramBitmap;
            if (this.jdField_a_of_type_JavaUtilMap != null)
            {
              this.jdField_a_of_type_JavaUtilMap.put("RT:w=" + k + "h=" + m, paramBitmap);
              localBitmap = paramBitmap;
            }
            Paint localPaint = new Paint();
            localPaint.setAntiAlias(true);
            localPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
              break label414;
            }
            paramBitmap = Bitmap.createBitmap(localBitmap.getWidth(), localBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            paramBitmap.eraseColor(0);
            new Canvas(paramBitmap).drawRoundRect(new RectF(this.b, this.b, localBitmap.getWidth() - this.b, localBitmap.getHeight() - this.b), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, localPaint);
            return paramBitmap;
          }
        }
        else
        {
          k = (int)(paramBitmap.getHeight() / this.jdField_a_of_type_Float);
          i = (paramBitmap.getWidth() - k) / 2;
          j = 0;
          continue;
        }
        localBitmap.eraseColor(0);
        uyk.a(paramBitmap, localBitmap, i, j, k, m, null, false);
        continue;
        paramBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      catch (Exception paramBitmap)
      {
        ved.e("RoundedTransformation", "occur error:" + paramBitmap);
        return null;
      }
      label414:
      continue;
      label422:
      Bitmap localBitmap = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxv
 * JD-Core Version:    0.7.0.1
 */