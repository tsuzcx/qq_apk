import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;

public class ankn
{
  private float[] U;
  public amag b;
  private amaf c;
  private int dBn;
  private Bitmap mBitmap;
  private String mOutputPath;
  
  private static long J(int paramInt)
  {
    return paramInt * 1000000000L / 25L;
  }
  
  private Bitmap O(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getWidth() % 2 == 1)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    }
    return localBitmap;
  }
  
  private void prepare()
    throws IOException
  {
    ram.d("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.mBitmap = O(this.mBitmap);
    ram.d("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.mBitmap.getWidth() + ", height = " + this.mBitmap.getHeight());
    amae localamae = new amae(this.mOutputPath, this.mBitmap.getWidth(), this.mBitmap.getHeight(), 532480, 1, false, 0);
    localamae.frameRate = 25;
    this.b = new amag();
    this.b.a(localamae);
    this.c = new amaf();
    this.c.a(localamae, this.b.getInputSurface());
    this.dBn = GlUtil.createTexture(3553, this.mBitmap);
    this.U = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void release()
  {
    ram.d("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
  }
  
  public int W(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
    ram.w("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", new Object[] { paramString1, paramString2 });
    if (!rox.fileExistsAndNotEmpty(paramString1))
    {
      ram.e("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
      return 940007;
    }
    this.mOutputPath = paramString2;
    try
    {
      this.mBitmap = BitmapFactory.decodeFile(paramString1);
      l = System.currentTimeMillis();
    }
    catch (OutOfMemoryError paramString2)
    {
      try
      {
        for (;;)
        {
          prepare();
          i = 0;
          for (;;)
          {
            if (i < 75)
            {
              this.b.dLU();
              this.c.e(3553, this.dBn, this.U, null, J(i));
              i += 1;
              continue;
              paramString2 = paramString2;
              System.gc();
              try
              {
                Thread.sleep(1000L);
                this.mBitmap = aqhu.m(paramString1, 540, 960);
                if (this.mBitmap == null) {
                  this.mBitmap = aqhu.m(paramString1, 360, 640);
                }
                if (this.mBitmap != null) {
                  break;
                }
                ram.e("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", new Object[] { paramString1, paramString2 });
                return 942014;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }
        }
        this.b.stop();
        release();
        i = 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l;
          ram.w("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", paramString1);
          int i = 942013;
          this.b.release();
          release();
        }
      }
      finally
      {
        release();
      }
      ram.w("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankn
 * JD-Core Version:    0.7.0.1
 */