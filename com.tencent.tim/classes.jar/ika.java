import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason;
import java.io.File;
import java.lang.ref.WeakReference;

public class ika
  extends ijy
{
  public ika()
  {
    igd.aJ("MagicfaceNormalDecoder", "==init==");
  }
  
  @TargetApi(16)
  private Bitmap a(String paramString, Bitmap paramBitmap)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (localOptions.outWidth * localOptions.outHeight == 0) {
      return null;
    }
    int i = localOptions.outWidth * localOptions.outHeight;
    if (Build.VERSION.SDK_INT >= 15) {
      localOptions.inBitmap = paramBitmap;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 1;
      while (i > 921600)
      {
        localOptions.inSampleSize *= 2;
        i /= 4;
      }
      if (paramBitmap != null) {
        paramBitmap.recycle();
      }
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      igd.aL("MagicfaceNormalDecoder", "getBitmap|decodeFile failed.");
    }
    return null;
  }
  
  public int kT()
  {
    long l2 = 0L;
    long l1 = 0L;
    long l4 = 1000 / this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.fps;
    long l3 = 0L;
    int m = this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.repeat_count;
    String str = this.a.getId();
    Bitmap localBitmap2 = null;
    if (this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasbackground) {
      localBitmap2 = a(this.videoPath + "background/background.png", null);
    }
    Bitmap localBitmap1 = null;
    int i = 0;
    int j = 0;
    int k;
    Object localObject;
    long l5;
    long l6;
    for (;;)
    {
      if (j < m)
      {
        k = 0;
        if ((k >= this.a.kR()) || (!this.RS))
        {
          j += 1;
        }
        else
        {
          this.a.bw(i, j);
          localObject = this.videoPath + this.a.aI(k) + File.separator + this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.src_prefix + k + ".png";
          igd.aJ("MagicfaceNormalDecoder", "maigcfaceDecoder:" + this.a.kR() + "|" + (String)localObject);
          l5 = System.currentTimeMillis();
          localBitmap1 = a((String)localObject, localBitmap1);
          l6 = System.currentTimeMillis();
          l3 = System.currentTimeMillis() - l3;
          if (l3 >= l4) {
            break;
          }
        }
      }
    }
    label464:
    label610:
    for (;;)
    {
      try
      {
        Thread.sleep(l4 - l3);
        if ((k == this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.frame_index) && (this.bm != null))
        {
          W(str, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.is_repeat);
          l3 = System.currentTimeMillis();
          if (localBitmap1 != null) {
            continue;
          }
          igd.aJ("MagicfaceNormalDecoder", "maigcfaceDecoder bmp null:" + (String)localObject);
          k += 1;
          l2 += l6 - l5;
          i += 1;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        if ((k != this.a.anV) || (this.bm == null)) {
          continue;
        }
        iW(str);
        continue;
        if (this.bn == null) {
          break label610;
        }
      }
      if (this.bn.get() != null)
      {
        localObject = (ijy.b)this.bn.get();
        long l7 = System.currentTimeMillis();
        boolean bool1;
        if (this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width == -1)
        {
          bool1 = true;
          if (this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height != -1) {
            break label525;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          ((ijy.b)localObject).a(localBitmap1, localBitmap2, bool1, bool2, false, false, this.a.rect);
          l1 = System.currentTimeMillis() - l7 + l1;
          break;
          bool1 = false;
          break label464;
        }
        igd.aJ("MagicfaceNormalDecoder", String.format("maigcfaceDecoder| readCost=%s(ms), renderCost=%s(ms), r=(%s), frame(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(this.a.kR()) }));
        if (localBitmap1 != null) {
          localBitmap1.recycle();
        }
        if (i == this.a.kR() * m) {
          return 1;
        }
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ika
 * JD-Core Version:    0.7.0.1
 */