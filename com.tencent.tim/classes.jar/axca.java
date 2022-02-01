import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;

public class axca
{
  public static boolean dtY;
  private boolean dtZ;
  private int eEz;
  private int height;
  private boolean isInited;
  private int width;
  
  public axca()
  {
    dtY = false;
  }
  
  public int QZ()
  {
    return this.eEz;
  }
  
  public boolean aOr()
  {
    return this.dtZ;
  }
  
  @MustRunOnGLThread
  public void akY()
  {
    if ((!this.isInited) || (this.dtZ)) {}
    Bitmap localBitmap1;
    do
    {
      return;
      localBitmap1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), "/sdcard/Tencent/aekit/test.png", 1);
    } while (!BitmapUtils.isLegal(localBitmap1));
    Bitmap localBitmap2;
    if (Math.abs(localBitmap1.getHeight() / localBitmap1.getWidth() - 1.777778F) > 0.0001D)
    {
      int i = (int)(localBitmap1.getWidth() * 16.0F / 9.0F);
      localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), i, Bitmap.Config.ARGB_8888);
      localBitmap2.eraseColor(-1);
      Canvas localCanvas = new Canvas(localBitmap2);
      Paint localPaint = new Paint(6);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(localBitmap1, 0.0F, (i - localBitmap1.getHeight()) / 2, localPaint);
      GlUtil.loadTexture(this.eEz, localBitmap2);
      localBitmap1.recycle();
      localBitmap2.recycle();
      this.width = localBitmap2.getWidth();
    }
    for (this.height = localBitmap2.getHeight();; this.height = localBitmap1.getHeight())
    {
      this.dtZ = true;
      return;
      GlUtil.loadTexture(this.eEz, localBitmap1);
      localBitmap1.recycle();
      this.width = localBitmap1.getWidth();
    }
  }
  
  @MustRunOnGLThread
  public void clear()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.eEz;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.dtZ = false;
    this.isInited = false;
    dtY = false;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  @MustRunOnGLThread
  public void initial()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.eEz = arrayOfInt[0];
    this.isInited = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axca
 * JD-Core Version:    0.7.0.1
 */