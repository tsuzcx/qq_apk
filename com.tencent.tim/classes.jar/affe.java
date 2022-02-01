import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affe
  extends afeu
{
  public affe(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ptt.so.658", paramQQAppInterface);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "download success: " + paramString);
    }
    for (;;)
    {
      try
      {
        str = alij.xX();
        if ((str != null) && (!str.equals("")))
        {
          aqhq.cn(str);
          if (new File(str).mkdir())
          {
            aqhq.W(paramString, str, false);
            if (QLog.isColorLevel()) {
              QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip success: " + paramString);
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip failed: " + localException.getMessage());
        continue;
      }
      try
      {
        if (!alij.cxi)
        {
          aqhq.cn(alij.xY());
          aqhq.rename(str, alij.xY());
        }
        super.HO(paramString);
        return;
      }
      finally {}
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aja()
  {
    Object localObject = (PttSilkAndChangeVoiceSoData)b();
    if (localObject == null) {
      return false;
    }
    int i = imm.getCpuArchitecture();
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload cpuArch = " + i + " isUserNeedDownload try match version=" + "3.4.4" + " data.version=" + ((PttSilkAndChangeVoiceSoData)localObject).version);
    }
    localObject = this.app.getPreferences();
    if (!((SharedPreferences)localObject).getBoolean("hasReportedCpuArch", false))
    {
      aomq.dVV();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hasReportedCpuArch", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (i > 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload return " + bool);
      }
      return bool;
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return PttSilkAndChangeVoiceSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10007;
  }
  
  public String un()
  {
    return "actEarlyPttSilkAndChangeVoiceSo";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affe
 * JD-Core Version:    0.7.0.1
 */