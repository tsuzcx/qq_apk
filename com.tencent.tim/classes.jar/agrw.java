import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class agrw
  implements agsd
{
  private boolean cfd;
  private boolean cfe;
  private boolean cff;
  private int state = 0;
  
  static agsd a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new agrp(paramQQAppInterface, paramFileManagerEntity);
  }
  
  static agsd a(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    return new agrs(paramQQAppInterface, paramWeiYunFileInfo);
  }
  
  static agsd a(FileInfo paramFileInfo)
  {
    return new agrq(paramFileInfo);
  }
  
  static agsd b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new agrr(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void JA(boolean paramBoolean)
  {
    this.cfe = paramBoolean;
  }
  
  public void Jz(boolean paramBoolean)
  {
    this.cfd = paramBoolean;
  }
  
  public boolean amo()
  {
    return this.cff;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public String vF()
  {
    return "";
  }
  
  public String vH()
  {
    String str2 = "";
    String str1 = str2;
    if (ga() > 0L)
    {
      str1 = str2;
      if (getCloudType() != 3) {
        if ((getFileId() == null) || (getFileId().length() <= 0)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      str1 = str2;
      if (i == 0) {
        str1 = "" + BaseApplicationImpl.getContext().getString(2131693588) + ahav.i(ga(), DW());
      }
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrw
 * JD-Core Version:    0.7.0.1
 */