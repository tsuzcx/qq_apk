import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class ajgk
  extends ajgf
{
  private static final String bRc = aoqr.oz(ajgr.ROOT_PATH + "ptt" + File.separator);
  public static String bRf = acbn.SDCARD_PATH + "ptt" + File.separator;
  private String bRd = (String)this.mMap.get("uuid");
  private String bRe = (String)this.mMap.get("selfuin");
  private String mMD5 = (String)this.mMap.get("md5");
  
  public ajgk(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if (this.mMD5 == null) {
      this.mMD5 = "";
    }
    if (this.bRd == null) {
      this.bRd = "";
    }
    if (this.bRe == null) {
      this.bRe = "";
    }
    if ((TextUtils.isEmpty(this.mMD5)) || (TextUtils.isEmpty(this.bRd)) || (TextUtils.isEmpty(this.bRe))) {
      printLog("md5:" + this.mMD5 + " mUUID:" + this.bRd + " mSelfuin:" + this.bRe);
    }
  }
  
  public static String bj(String paramString1, String paramString2)
  {
    return aoqr.oz(bRf + paramString2 + File.separator + paramString1);
  }
  
  public ajem a()
  {
    Object localObject = this.a;
    String str = xo();
    boolean bool = fileExists(str);
    if (QLog.isColorLevel()) {
      printLog("getResDownloadObject,entity:" + ((MsgBackupResEntity)localObject).toLogString() + " tempPath:" + str + " exist:" + bool);
    }
    localObject = new ajem();
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      ((ajem)localObject).cnO = bool;
      ((ajem)localObject).aWb = str;
      return localObject;
    }
  }
  
  public String getAbsolutePath()
  {
    return bj(this.mMD5, this.bRe);
  }
  
  public String xo()
  {
    return bRc + this.mMD5 + this.bRd + this.bRe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgk
 * JD-Core Version:    0.7.0.1
 */