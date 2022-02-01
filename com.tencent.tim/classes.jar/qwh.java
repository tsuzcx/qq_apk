import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import java.util.Map;

public class qwh
  implements qwi
{
  protected final int AD;
  public Bitmap cw;
  public Map<String, Bitmap> gc;
  private String key;
  protected final int radius;
  private float scale = 1.0F;
  
  public qwh(int paramInt1, int paramInt2, float paramFloat, Map<String, Bitmap> paramMap, Bitmap paramBitmap)
  {
    this.radius = paramInt1;
    this.AD = paramInt2;
    this.scale = paramFloat;
    this.gc = paramMap;
    this.cw = null;
    this.key = qwr.b(new Object[] { "rounded", "r=", Integer.valueOf(paramInt1), "dm=", Integer.valueOf(paramInt2), "ds=", Float.valueOf(paramFloat) });
  }
  
  public String key()
  {
    return this.key;
  }
  
  public Bitmap z(Bitmap paramBitmap)
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
        if (f3 > this.scale)
        {
          m = (int)(paramBitmap.getWidth() * this.scale);
          j = (paramBitmap.getHeight() - m) / 2;
          i = 0;
          if (this.gc == null) {
            break label422;
          }
          localBitmap = (Bitmap)this.gc.get("RT:w=" + k + "h=" + m);
          if ((localBitmap == null) || (localBitmap.isRecycled()))
          {
            paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
            localBitmap = paramBitmap;
            if (this.gc != null)
            {
              this.gc.put("RT:w=" + k + "h=" + m, paramBitmap);
              localBitmap = paramBitmap;
            }
            Paint localPaint = new Paint();
            localPaint.setAntiAlias(true);
            localPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            if ((this.cw != null) && (!this.cw.isRecycled())) {
              break label414;
            }
            paramBitmap = Bitmap.createBitmap(localBitmap.getWidth(), localBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            paramBitmap.eraseColor(0);
            new Canvas(paramBitmap).drawRoundRect(new RectF(this.AD, this.AD, localBitmap.getWidth() - this.AD, localBitmap.getHeight() - this.AD), this.radius, this.radius, localPaint);
            return paramBitmap;
          }
        }
        else
        {
          k = (int)(paramBitmap.getHeight() / this.scale);
          i = (paramBitmap.getWidth() - k) / 2;
          j = 0;
          continue;
        }
        localBitmap.eraseColor(0);
        qwq.a(paramBitmap, localBitmap, i, j, k, m, null, false);
        continue;
        paramBitmap = this.cw;
      }
      catch (Exception paramBitmap)
      {
        ram.e("RoundedTransformation", "occur error:" + paramBitmap);
        return null;
      }
      label414:
      continue;
      label422:
      Bitmap localBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwh
 * JD-Core Version:    0.7.0.1
 */