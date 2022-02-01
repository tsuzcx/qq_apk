import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract class akyl
{
  public static int dpY = 80;
  public static int dpZ = 70;
  public static int dqa = 80;
  public static int dqb = 960;
  public static int dqc = 1920;
  public static int dqd = 960;
  public static int dqe = 960;
  public static int dqf = 960;
  public static int dqg = 960;
  public static int dqh = 960;
  protected String TAG = getClass().getSimpleName();
  CompressInfo b;
  protected int dqi;
  
  akyl(CompressInfo paramCompressInfo)
  {
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.srcPath))) {
      throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }
    this.b = paramCompressInfo;
    int i = a(paramCompressInfo);
    this.dqi = i;
    if (i == -1) {
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
  }
  
  private int b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!aqhq.fileExistsAndNotEmpty(paramString1))) {
      akxe.b(this.TAG, this.b.localUUID + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return 0;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        Bitmap localBitmap3 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        Bitmap localBitmap1 = localBitmap3;
        if (localBitmap3 != null) {
          break;
        }
        akxe.b(this.TAG, this.b.localUUID + " sampleCompress()", " bm == null, maybe is broken");
        return 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.b.Nr(true);
        akxe.b(this.TAG, this.b.localUUID + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:" + 1 + " oomKeepCompress:" + paramBoolean);
      }
    } while (!paramBoolean);
    localOptions.inSampleSize = 4;
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        i = 2;
        paramBoolean = akyr.b(paramString2, localBitmap2, Hm(), this.b.localUUID, this.b);
        if (localBitmap2 != null) {
          localBitmap2.recycle();
        }
        if (paramBoolean) {
          return i;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        this.b.Nr(false);
        paramString1.printStackTrace();
        akxe.b(this.TAG, this.b.localUUID + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:" + 2);
        return 0;
      }
      i = 0;
    }
  }
  
  protected int Hm()
  {
    int i;
    if (this.b.picQuality == 2) {
      i = 100;
    }
    for (;;)
    {
      akxe.a(this.TAG, "getCompressQuality", "compressQuality = " + i);
      return i;
      switch (this.b.networkType)
      {
      case 2: 
      case 3: 
      default: 
        i = dpZ;
        break;
      case 1: 
        i = dpY;
        break;
      case 4: 
        i = dqa;
      }
    }
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  final boolean asV()
  {
    boolean bool2;
    if (!aqhq.fileExistsAndNotEmpty(this.b.srcPath))
    {
      akxe.b(this.TAG, this.b.localUUID + " startThumbnail()", " src file does not exist");
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      if (this.b.destPath == null)
      {
        this.b.destPath = akyr.mG(this.b.srcPath);
        if (TextUtils.isEmpty(this.b.destPath))
        {
          akxe.b(this.TAG, this.b.localUUID + " startThumbnail()", " destPath is empty");
          return false;
        }
      }
      if ((aqhq.fileExistsAndNotEmpty(this.b.destPath)) && (!this.b.cuR))
      {
        akxe.b(this.TAG, this.b.localUUID + " startThumbnail()", " destPath exist. return true");
        return true;
      }
      try
      {
        if (this.b.picType == 2) {}
        for (bool1 = akyr.a(this.b.srcPath, this.b.destPath, this.b.cuP, this.b.localUUID, 3, this.b.a);; bool1 = akyr.a(this.b.srcPath, this.b.destPath, this.b.cuP, this.b.localUUID, 0, this.b.a))
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.b.destPath = "";
          akxe.b(this.TAG, this.b.localUUID + " startThumbnail()", " compressAIOThumbnail is failed");
          return bool1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          akxe.b(this.TAG, "startThumbnail()", localException.getMessage());
          boolean bool1 = false;
        }
      }
    }
  }
  
  final boolean asW()
  {
    if (this.b.picQuality == 2) {
      if (akyr.getFileSize(this.b.srcPath) <= aopb.hm())
      {
        this.b.destPath = this.b.srcPath;
        this.b.bUE = (this.TAG + this.b.localUUID + acfp.m(2131709649));
        akxe.a(this.TAG, this.b.localUUID + " commonCompress()", acfp.m(2131709648));
        if (this.b.picType != 2) {
          this.b.cuQ = true;
        }
      }
    }
    for (;;)
    {
      return true;
      akxe.b(this.TAG, this.b.localUUID + " commonCompress()", acfp.m(2131709653));
      continue;
      int i = getMaxFileSize();
      if (akyr.getFileSize(this.b.srcPath) > i)
      {
        akxe.a(this.TAG, this.b.localUUID + " commonCompress()", " src file size > max, file size:" + akyr.getFileSize(this.b.srcPath) + " max:" + i);
        this.b.destPath = akyr.as(this.b.srcPath, this.b.picQuality);
        if (TextUtils.isEmpty(this.b.destPath))
        {
          akxe.b(this.TAG, this.b.localUUID + " commonCompress()", " destPath is empty");
          return false;
        }
        if (aqhq.fileExistsAndNotEmpty(this.b.destPath))
        {
          akxe.b(this.TAG, this.b.localUUID + " commonCompress()", " destPath exist. return true");
          return true;
        }
        this.b.dpz = 0;
        int j = b(this.b.srcPath, this.b.destPath, true);
        if (j != 0)
        {
          Object localObject1 = this.b;
          ((CompressInfo)localObject1).dpz = (j + ((CompressInfo)localObject1).dpz);
          if (akyr.getFileSize(this.b.destPath) > i)
          {
            if (this.b.dpz >= 2)
            {
              this.b.Nr(false);
              this.b.bUE = (this.TAG + this.b.localUUID + " commonCompress() 面积是原来的1/16，不能再小了fileSize:" + akyr.getFileSize(this.b.destPath) + " max:" + i);
              akxe.b(this.TAG, this.b.localUUID + " commonCompress()", " 面积是原来的1/16，不能再小了fileSize:" + akyr.getFileSize(this.b.destPath) + " max:" + i);
              aqhq.deleteFile(this.b.destPath);
              this.b.destPath = "";
              return false;
            }
            Object localObject2 = this.b.destPath;
            localObject1 = (String)localObject2 + "_second";
            this.b.destPath = "";
            j = b((String)localObject2, (String)localObject1, false);
            aqhq.deleteFile((String)localObject2);
            if (j != 0)
            {
              localObject2 = this.b;
              ((CompressInfo)localObject2).dpz = (j + ((CompressInfo)localObject2).dpz);
              this.b.destPath = ((String)localObject1);
              if (akyr.getFileSize((String)localObject1) > i)
              {
                this.b.Nr(false);
                this.b.bUE = (this.TAG + this.b.localUUID + " commonCompress()" + acfp.m(2131709654) + akyr.getFileSize((String)localObject1) + " max:" + i);
                akxe.b(this.TAG, this.b.localUUID + " commonCompress()", acfp.m(2131709655) + akyr.getFileSize((String)localObject1) + " max:" + i);
                aqhq.deleteFile(this.b.destPath);
                this.b.destPath = "";
                return false;
              }
            }
            else
            {
              this.b.destPath = "";
              this.b.bUE = (this.TAG + this.b.localUUID + " commonCompress()" + acfp.m(2131709652));
              akxe.b(this.TAG, this.b.localUUID + " commonCompress()", acfp.m(2131709650));
              return false;
            }
          }
        }
        else
        {
          this.b.destPath = "";
          this.b.bUE = (this.TAG + this.b.localUUID + " commonCompress() sampleCompress failed");
          akxe.b(this.TAG, this.b.localUUID + " commonCompress()", " sampleCompress failed");
          return false;
        }
      }
      else
      {
        this.b.destPath = this.b.srcPath;
        this.b.bUE = (this.TAG + this.b.localUUID + acfp.m(2131709656));
        akxe.a(this.TAG, this.b.localUUID + " commonCompress()", acfp.m(2131709651));
        if (this.b.picType != 2) {
          this.b.cuQ = true;
        }
      }
    }
  }
  
  protected abstract boolean asX();
  
  final int getMaxFileSize()
  {
    if (this.b.networkType == 1) {
      return 20971520;
    }
    return 4194304;
  }
  
  final boolean start()
  {
    if (this.dqi == 2) {
      return asW();
    }
    return asX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyl
 * JD-Core Version:    0.7.0.1
 */