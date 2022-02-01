import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ajgi
  extends ajgf
{
  public ajgi(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
  }
  
  public ajem a()
  {
    boolean bool2 = false;
    MsgBackupResEntity localMsgBackupResEntity = this.a;
    ajem localajem = new ajem();
    String str1 = c(localMsgBackupResEntity);
    if (str1 == null)
    {
      printLog("getResDownloadObject realPath is null");
      localajem.cnO = false;
      return localajem;
    }
    String str2 = lW(str1);
    boolean bool3 = fileExists(str2);
    boolean bool4 = fileExists(str1);
    if (QLog.isColorLevel()) {
      printLog("getResDownloadObject,entity:" + localMsgBackupResEntity.toLogString() + " tempPath:" + str2 + " exist:" + bool3 + " realPath:" + str1 + " exist:" + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {
        bool1 = true;
      }
    }
    localajem.cnO = bool1;
    localajem.aWb = str2;
    return localajem;
  }
  
  public String b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    String str1 = (String)this.mMap.get("md5");
    String str2 = (String)this.mMap.get("isOriginal");
    int i;
    if (str2 != null) {
      if (!str2.equals("0")) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = paramMsgBackupResEntity.msgSubType;
      if (j == 1) {
        if (i == 0) {
          paramMsgBackupResEntity = "chatimg";
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1))
        {
          try
          {
            paramMsgBackupResEntity = aoiz.getFilePath(new URL(paramMsgBackupResEntity, null, str1).toString());
            return paramMsgBackupResEntity;
          }
          catch (MalformedURLException paramMsgBackupResEntity)
          {
            paramMsgBackupResEntity.printStackTrace();
          }
          i = 0;
          break;
          paramMsgBackupResEntity = "chatraw";
          continue;
          if (j == 2) {
            paramMsgBackupResEntity = "chatimg";
          } else if (j == 3) {
            paramMsgBackupResEntity = "chatthumb";
          } else {
            return null;
          }
        }
      }
      return null;
      i = 1;
    }
  }
  
  public String c(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return b(paramMsgBackupResEntity);
  }
  
  public String getAbsolutePath()
  {
    return b(this.a);
  }
  
  public String lW(String paramString)
  {
    try
    {
      paramString = paramString.substring(Gn());
      paramString = ajgr.ROOT_PATH + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String xo()
  {
    String str = c(this.a);
    if (TextUtils.isEmpty(str))
    {
      printLog("getTempPath realPath is null");
      return null;
    }
    return lW(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgi
 * JD-Core Version:    0.7.0.1
 */