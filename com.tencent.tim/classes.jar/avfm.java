import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginManager.1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class avfm
  implements Manager
{
  public avfn a;
  private HashSet<String> bR = new HcePluginManager.1(this);
  public byte[] hW;
  
  public avfm(AppInterface paramAppInterface) {}
  
  public static String FO()
  {
    String str2 = "";
    String str1 = str2;
    if (BaseApplicationImpl.getApplication().getRuntime() != null)
    {
      str1 = str2;
      if (BaseApplicationImpl.getApplication().getRuntime().getAccount() != null) {
        str1 = MD5.toMD5(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      }
    }
    return str1;
  }
  
  public static avfm a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (avfm)((QQAppInterface)localAppRuntime).getManager(291);
    }
    return null;
  }
  
  public int B(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HcePluginManager", 2, "matchAID fail  commandApdu is null");
      }
      return -1;
    }
    Iterator localIterator = this.bR.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      byte[] arrayOfByte = avfj.aj(str);
      if (QLog.isColorLevel()) {
        QLog.i("HcePluginManager", 2, "aidApdu: " + avfj.bytesToHexString(arrayOfByte) + " commandApdu" + avfj.bytesToHexString(paramArrayOfByte));
      }
      if (Arrays.equals(arrayOfByte, paramArrayOfByte))
      {
        if (QLog.isColorLevel()) {
          QLog.i("HcePluginManager", 2, "matchAID succ, aid=" + str);
        }
        return 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginManager", 2, "matchAID fail  no match aid");
    }
    return -1;
  }
  
  public boolean B(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length >= 2) && (paramArrayOfByte[0] == 0) && (paramArrayOfByte[1] == -92);
  }
  
  public void aX(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      aqfe.J(paramContext, "vfcState", paramInt + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("HcePluginManager", 2, "onVfcPluginLifecycle state " + paramInt + " Context " + paramContext);
    }
  }
  
  public boolean cH(Context paramContext)
  {
    return (paramContext != null) && ("1".equals(aqfe.get(paramContext, "vfcState")));
  }
  
  public void ezK()
  {
    aqfe.J(BaseApplicationImpl.getApplication(), "vfcStartTime", System.currentTimeMillis() + "");
  }
  
  public long iM()
  {
    String str = aqfe.get(BaseApplicationImpl.getApplication(), "vfcStartTime");
    if (aqmr.isEmpty(str)) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public boolean isLogin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return (localAppRuntime != null) && (localAppRuntime.isLogin());
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfm
 * JD-Core Version:    0.7.0.1
 */