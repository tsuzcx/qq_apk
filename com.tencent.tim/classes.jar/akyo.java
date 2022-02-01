import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pic.CompressInfo;
import java.io.IOException;

public class akyo
  extends akyl
{
  akyo(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.picQuality)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 1;
    }
    return 2;
  }
  
  protected boolean asX()
  {
    boolean bool1 = true;
    if (this.dqi == 1)
    {
      if ((this.b.cuS) && (akyr.nT(this.b.srcPath)))
      {
        this.b.destPath = this.b.srcPath;
        this.b.bUE = (this.TAG + this.b.localUUID + acfp.m(2131709657));
        akxe.a(this.TAG, this.b.localUUID + " compress()", acfp.m(2131709658));
      }
      for (;;)
      {
        return bool1;
        this.b.destPath = akyr.as(this.b.srcPath, this.b.picQuality);
        if (TextUtils.isEmpty(this.b.destPath))
        {
          akxe.b(this.TAG, "compress()", this.b.localUUID + " destPath is empty");
          return false;
        }
        if (aqhq.fileExistsAndNotEmpty(this.b.destPath))
        {
          akxe.b(this.TAG, "compress()", this.b.localUUID + " destPath exist. return true");
          return true;
        }
        try
        {
          Bitmap localBitmap = aqhu.d(this.b.srcPath, null);
          if (localBitmap == null)
          {
            akxe.b(this.TAG, "compress()", this.b.localUUID + " bm == null, maybe is broken");
            return false;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.b.Nr(true);
          akxe.b(this.TAG, "compress()", this.b.localUUID + " decodeFile oom, execute commonCompress()");
          this.b.destPath = "";
          return asW();
        }
        boolean bool2 = akyr.b(this.b.destPath, localOutOfMemoryError, Hm(), this.b.localUUID, this.b);
        if (!JpegExifReader.isCrashJpeg(this.b.srcPath)) {}
        try
        {
          if (!aqhu.a(new ExifInterface(this.b.srcPath), new ExifInterface(this.b.destPath))) {
            akxe.b(this.TAG, "compress()", "Failed to save exif");
          }
          bool1 = bool2;
          if (localOutOfMemoryError != null)
          {
            localOutOfMemoryError.recycle();
            return bool2;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            akxe.b(this.TAG, "compress()", "cannot read exif, " + localIOException.getMessage());
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyo
 * JD-Core Version:    0.7.0.1
 */