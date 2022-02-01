import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class ajgn
  extends ajgf
{
  private static final String bRg = aoqr.oz(ajgr.ROOT_PATH + "shortvideo" + File.separator);
  private String bRh = (String)this.mMap.get("thumbMd5");
  private String mMD5 = (String)this.mMap.get("md5");
  
  public ajgn(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if ((TextUtils.isEmpty(this.mMD5)) || (TextUtils.isEmpty(this.bRh))) {
      printLog("md5:" + this.mMD5 + " mThumbMD5:" + this.bRh);
    }
  }
  
  private String fP(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(bRg);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String lX(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(bRg);
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String lY(String paramString)
  {
    return ShortVideoUtils.bw(paramString, "jpg");
  }
  
  public static String lZ(String paramString)
  {
    paramString = ShortVideoUtils.nq(paramString);
    return paramString + "MsgBackUp";
  }
  
  public ajem a()
  {
    MsgBackupResEntity localMsgBackupResEntity = this.a;
    int i = localMsgBackupResEntity.msgSubType;
    ajem localajem = new ajem();
    String str1 = xo();
    String str2 = getAbsolutePath();
    boolean bool1 = fileExists(str1);
    boolean bool2 = fileExists(str2);
    if (QLog.isColorLevel()) {
      printLog("getResDownloadObject,entity:" + localMsgBackupResEntity.toLogString() + " tempPath:" + str1 + " exist:" + bool1 + " realPath:" + str2 + " exist:" + bool2);
    }
    localajem.aWb = str1;
    if ((!bool1) && (!bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localajem.cnO = bool1;
      return localajem;
    }
  }
  
  public String getAbsolutePath()
  {
    switch (this.a.msgSubType)
    {
    default: 
      return null;
    case 4: 
    case 5: 
    case 6: 
      return lZ(this.mMD5);
    }
    return lY(this.bRh);
  }
  
  public String xo()
  {
    switch (this.a.msgSubType)
    {
    default: 
      return null;
    case 4: 
    case 5: 
    case 6: 
      return fP(this.mMD5);
    }
    return lX(this.bRh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgn
 * JD-Core Version:    0.7.0.1
 */