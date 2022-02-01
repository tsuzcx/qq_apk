import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

public class aveh
  implements ISecurityFileHelper
{
  private FilenameFilter a = new avei(this);
  private Pattern ao = Pattern.compile("\\d{5,}");
  
  public String declareBusinessFileName()
  {
    return "QQComicOffline";
  }
  
  public boolean doMigrate(File paramFile)
  {
    boolean bool2 = false;
    File localFile1 = new File(acbn.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString = localFile1.list(this.a);
    boolean bool1;
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      bool1 = true;
      return bool1;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label220;
      }
      Object localObject = arrayOfString[i];
      File localFile2 = new File(localFile1, (String)localObject);
      localObject = new File(paramFile.getAbsolutePath() + File.separator + (String)localObject + File.separator + declareBusinessFileName());
      int k = aqhq.ad(localFile2.getAbsolutePath(), ((File)localObject).getAbsolutePath());
      QLog.d("VipComicSecurityFileHelper", 2, "doMigrate：" + declareBusinessFileName() + " result = " + k + " fromFile = " + localFile2.getAbsolutePath() + " targetFile = " + ((File)localObject).getAbsolutePath());
      bool1 = bool2;
      if (k != 0) {
        break;
      }
      i += 1;
    }
    label220:
    return true;
  }
  
  public boolean needMigration()
  {
    Object localObject = new File(acbn.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/").list(this.a);
    boolean bool;
    StringBuilder localStringBuilder;
    if ((localObject != null) && (localObject.length > 0))
    {
      bool = true;
      localStringBuilder = new StringBuilder().append("needMigration: uinDirs.len=");
      if (localObject != null) {
        break label74;
      }
    }
    label74:
    for (localObject = Integer.valueOf(0);; localObject = localObject.length + " needMigration=" + bool)
    {
      QLog.i("VipComicSecurityFileHelper", 2, localObject);
      return bool;
      bool = false;
      break;
    }
  }
  
  public File oldBusinessDir(String paramString)
  {
    return new File(new File(acbn.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/"), paramString);
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    paramString = oldBusinessDir(paramString);
    return (paramString.isDirectory()) && (paramString.exists());
  }
  
  public String[] reportHistoryFileInfo()
  {
    long l2 = 0L;
    String[] arrayOfString1 = new String[2];
    File localFile = new File(acbn.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
    String[] arrayOfString2 = localFile.list(this.a);
    if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
    {
      int j = arrayOfString2.length;
      int i = 0;
      long l1 = 0L;
      while (i < j)
      {
        String str = arrayOfString2[i];
        l2 += aqhq.getFileOrFolderSize(new File(localFile, str).getAbsolutePath());
        l1 += aqhq.bb(new File(localFile, str).getAbsolutePath());
        i += 1;
      }
      arrayOfString1[0] = Long.toString(l2);
      arrayOfString1[1] = Long.toString(l1);
      QLog.d("VipComicSecurityFileHelper", 2, "reportHistoryFileInfo:" + declareBusinessFileName() + " fileAmount = " + l1 + " fileSize = " + l2);
    }
    return arrayOfString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveh
 * JD-Core Version:    0.7.0.1
 */