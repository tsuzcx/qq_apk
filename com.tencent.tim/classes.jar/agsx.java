import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class agsx
  implements aguk.a
{
  protected agsd b;
  protected String gJ;
  protected int imageType;
  protected int nR;
  protected int orientation;
  protected String thumbPath;
  
  public agsx(agsd paramagsd)
  {
    this.b = paramagsd;
    this.imageType = 0;
    this.nR = 0;
    this.orientation = -1;
  }
  
  public boolean S(String paramString)
  {
    if ((this.b.b() != null) && (this.b.b().isZipInnerFile)) {
      return paramString.equalsIgnoreCase(String.valueOf(this.b.fR()));
    }
    return (paramString.equalsIgnoreCase(this.b.getUuid())) || (paramString.equalsIgnoreCase(this.b.getFileId()));
  }
  
  public void aA(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.thumbPath = paramString;
      this.b.Ji(paramString);
    }
  }
  
  public void aB(String paramString)
  {
    if (ahbj.fileExistsAndNotEmpty(paramString)) {
      this.gJ = paramString;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("DefaultImageInfo", 2, "setImageOriginPath error  : can not find origin file [path] =  " + paramString);
  }
  
  public String av()
  {
    return this.gJ;
  }
  
  public String aw()
  {
    String str2 = this.b.vF();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = this.b.vG();
      if (str1 != null) {
        break label44;
      }
      str1 = "";
    }
    return str1;
    label44:
    this.imageType = 2;
    return str1;
  }
  
  public agsd b()
  {
    return this.b;
  }
  
  public URL c()
  {
    String str = this.b.vF();
    if (TextUtils.isEmpty(str))
    {
      str = this.b.vG();
      if (str == null)
      {
        setState(1);
        return null;
      }
      this.imageType = 2;
    }
    while (ahbj.fileExistsAndNotEmpty(str)) {
      if (this.imageType == 1)
      {
        return AsyncImageView.g(str);
        this.imageType = 1;
      }
      else
      {
        return AsyncImageView.a(str, -1, -1, new File(str), false, false, false);
      }
    }
    setState(1);
    return null;
  }
  
  public boolean ca()
  {
    return this.b.getFileSize() < agmx.fL();
  }
  
  public int getImageType()
  {
    return this.imageType;
  }
  
  public int getOrientation()
  {
    if (this.orientation == -1) {}
    try
    {
      String str = this.b.vF();
      if (ahbj.fileExistsAndNotEmpty(str))
      {
        this.orientation = JpegExifReader.readOrientation(str);
        return this.orientation;
      }
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.orientation = 0;
      }
    }
  }
  
  public boolean isLoading()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.b == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.b.b();
    } while (localFileManagerEntity == null);
    if (localFileManagerEntity.isZipInnerFile)
    {
      if (localFileManagerEntity.status == 2) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if (this.nR == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void setState(int paramInt)
  {
    this.nR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsx
 * JD-Core Version:    0.7.0.1
 */