import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class agrr
  extends agrp
{
  final String TAG = "TroopFileViewerAdapter";
  QQAppInterface app;
  public apcy c;
  
  public agrr(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.app = paramQQAppInterface;
    this.ceX = ahav.b(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    if ((paramFileManagerEntity.isZipInnerFile) && (ahav.a(paramQQAppInterface, this, true))) {
      this.ceX = false;
    }
    this.c = apsv.a(paramQQAppInterface, paramFileManagerEntity);
    if ((this.c.Status == 2) || (this.c.Status == 3))
    {
      boolean bool2 = ahav.a(this);
      if (getCloudType() == 3) {
        if ((!this.ceX) || (!bool2)) {
          break label125;
        }
      }
    }
    for (;;)
    {
      this.ceX = bool1;
      return;
      label125:
      bool1 = false;
    }
  }
  
  public int bF()
  {
    if ((getCloudType() == 6) && (getOpType() == 31)) {
      return super.bF();
    }
    if (this.c != null) {
      return this.c.Status;
    }
    return 0;
  }
  
  public int getCloudType()
  {
    if (ahbj.fileExistsAndNotEmpty(super.getFilePath())) {
      return 3;
    }
    return super.getCloudType();
  }
  
  public String vH()
  {
    String str2 = ahbj.g(super.getFileSize());
    String str1 = str2;
    if (104 == super.b().busId)
    {
      str1 = str2;
      if (super.b().lastTime > 0L)
      {
        str1 = str2 + BaseApplicationImpl.getContext().getString(2131693588);
        str1 = str1 + apsv.i(BaseApplicationImpl.getContext(), super.b().lastTime);
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrr
 * JD-Core Version:    0.7.0.1
 */