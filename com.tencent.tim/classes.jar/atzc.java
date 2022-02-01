import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class atzc
  implements atzy.a
{
  protected agsd b;
  protected String gJ;
  protected int imageType;
  protected int nR;
  protected String thumbPath;
  
  public atzc(agsd paramagsd)
  {
    this.b = paramagsd;
    this.imageType = 0;
    this.nR = 0;
  }
  
  public boolean S(String paramString)
  {
    if (this.b.b().isZipInnerFile) {
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
    if (aueh.fileExistsAndNotEmpty(paramString)) {
      this.gJ = paramString;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("DefaultImageInfo", 2, "setImageOriginPath error  : can not find origin file [path] =  " + paramString);
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
    }
    for (this.imageType = 2; aueh.fileExistsAndNotEmpty(str); this.imageType = 1) {
      return audx.a(str, -1, -1, new File(str));
    }
    setState(1);
    return null;
  }
  
  public boolean ca()
  {
    return this.b.getFileSize() < atvz.fL();
  }
  
  public int getImageType()
  {
    return this.imageType;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzc
 * JD-Core Version:    0.7.0.1
 */