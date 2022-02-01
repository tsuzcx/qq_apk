import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aokg
  extends aoiz
{
  protected BaseApplicationImpl b;
  
  public aokg(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.b = paramBaseApplicationImpl;
  }
  
  private Bitmap a(aokg.a parama)
  {
    int j = 0;
    Object localObject2;
    if (parama == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return localObject2;
      int i = parama.g.thumbWidth;
      int k = parama.g.thumbHeight;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(parama.g.path, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = calculateInSampleSize(localOptions, i, k);
        Object localObject1 = ahbh.d(parama.g.path, localOptions);
        k = wja.dp2px(135.0F, BaseApplicationImpl.getContext().getResources());
        if (localOptions.outHeight > localOptions.outWidth * 2.0F)
        {
          i = (int)((localOptions.outHeight - localOptions.outWidth * 2.0F) / 2.0F);
          localOptions.outHeight = ((int)(localOptions.outWidth * 2.0F));
        }
        for (;;)
        {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, j, i, localOptions.outWidth, localOptions.outHeight);
          if (localOptions.outWidth <= k)
          {
            localObject1 = localObject2;
            if (localOptions.outHeight <= k) {}
          }
          else
          {
            localObject1 = aqhu.scaleBitmap((Bitmap)localObject2, k);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          return new aooy(parama.g.path).Q((Bitmap)localObject1);
          if (localOptions.outWidth <= localOptions.outHeight * 2.0F) {
            break label361;
          }
          j = (int)((localOptions.outWidth - localOptions.outHeight * 2.0F) / 2.0F);
          localOptions.outWidth = ((int)(localOptions.outHeight * 2.0F));
          i = 0;
        }
      }
      catch (Exception parama)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "make Thumb ", parama);
        }
        return null;
      }
      catch (OutOfMemoryError parama)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("_dataline_file", 2, "make Thumb OOM ", parama);
            continue;
            label361:
            i = 0;
          }
        }
      }
    }
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public aokg.a a(URL paramURL)
  {
    try
    {
      aokg.a locala = new aokg.a();
      paramURL = paramURL.getFile().split("\\|");
      locala.g = new LocalMediaInfo();
      locala.g.path = paramURL[0];
      locala.g.thumbWidth = Integer.parseInt(paramURL[1]);
      locala.g.thumbHeight = Integer.parseInt(paramURL[2]);
      locala.g.modifiedDate = Long.parseLong(paramURL[3]);
      locala.cMr = Boolean.parseBoolean(paramURL[4]);
      return locala;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.g.path);
    }
    return new File(acbn.SDCARD_ROOT);
  }
  
  public boolean azK()
  {
    return false;
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        j = 2;
      }
    }
    int k;
    int m;
    label96:
    do
    {
      do
      {
        return j;
        k = paramOptions.outHeight;
        m = paramOptions.outWidth;
        j = i;
      } while (k <= paramInt2);
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n < j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label96;
      n = j;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramURLDrawableHandler = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    Object localObject = new aokg.b();
    localObject = paramURLDrawableHandler.getThumb(paramDownloadParams.url, (aoow)localObject);
    paramURLDrawableHandler = (URLDrawableHandler)localObject;
    if (localObject == null)
    {
      paramURLDrawableHandler = BaseApplicationImpl.getContext();
      int i = ahav.getFileType(paramFile.getPath());
      paramURLDrawableHandler = drawableToBitmap(paramURLDrawableHandler.getResources().getDrawable(ahav.hL(i)));
    }
    paramDownloadParams = a(paramDownloadParams.url);
    paramFile = paramURLDrawableHandler;
    if (paramDownloadParams != null)
    {
      paramFile = paramURLDrawableHandler;
      if (paramDownloadParams.cMr)
      {
        paramFile = aqhu.c(paramURLDrawableHandler, wja.dp2px(12.0F, BaseApplicationImpl.getContext().getResources()));
        paramURLDrawableHandler.recycle();
      }
    }
    return paramFile;
  }
  
  class a
  {
    public boolean cMr;
    public LocalMediaInfo g;
    
    a() {}
  }
  
  class b
    implements aoow
  {
    public aokg.a a;
    
    b() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      this.jdField_a_of_type_Aokg$a = this.jdField_a_of_type_Aokg.a(paramURL);
      return aokg.a(this.jdField_a_of_type_Aokg, this.jdField_a_of_type_Aokg$a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokg
 * JD-Core Version:    0.7.0.1
 */