import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class anop
{
  public static boolean cIU;
  
  private static String F(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "unknown";
    }
    switch (aqiw.getNetworkType(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, anop.a parama)
  {
    parama.deviceModel = aqgz.getDeviceModel();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.c();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      parama.cfA = localSosoLbsInfo.a.city;
    }
    parama.cfz = F(paramQQAppInterface);
    return parama.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anop.a parama)
  {
    parama = a(paramQQAppInterface, parama);
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, "reportPushEvent detail=" + parama);
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushReportController", 1, "not Rumtime");
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", "dc03266");
      paramQQAppInterface.putExtra("reporting_detail", parama);
      paramQQAppInterface.putExtra("reporting_count", 1);
      paramQQAppInterface.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, " Rumtime");
    }
    anot.m(paramQQAppInterface, "dc03266", parama, 1);
  }
  
  public static void a(String paramString, anop.a parama)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("&")))
    {
      paramString = paramString.split("&");
      int i = 0;
      while (i < paramString.length)
      {
        if (paramString[i].contains("pushfrom"))
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length >= 2)) {
            parama.cfB = arrayOfString[1];
          }
        }
        i += 1;
      }
    }
  }
  
  public static class a
  {
    public String Uq = "";
    public String Ur = "";
    public String cfA = "";
    public String cfB = "";
    public String cfC = "";
    public String cfD = "";
    public String cfE = "";
    public String cfz = "";
    public String contentTitle = "";
    public String contentType = "";
    public String d1 = String.valueOf(System.currentTimeMillis() / 1000L);
    public String d2 = "";
    public String d3 = "";
    public String d4 = "";
    public String deviceModel = "";
    public String feedID = "";
    public String type = "cartoon";
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer(64);
      localStringBuffer.append(this.deviceModel).append("|");
      localStringBuffer.append(this.cfz).append("|");
      localStringBuffer.append(this.cfA).append("|");
      localStringBuffer.append(this.Uq).append("|");
      localStringBuffer.append(this.Ur).append("|");
      localStringBuffer.append(this.type).append("|");
      localStringBuffer.append(this.cfB).append("|");
      localStringBuffer.append(this.feedID).append("|");
      localStringBuffer.append(this.cfC).append("|");
      localStringBuffer.append(this.contentTitle).append("|");
      localStringBuffer.append(this.cfD).append("|");
      localStringBuffer.append(this.contentType).append("|");
      localStringBuffer.append(this.cfE).append("|");
      localStringBuffer.append(this.d1).append("|");
      localStringBuffer.append(this.d2).append("|");
      localStringBuffer.append(this.d3).append("|");
      localStringBuffer.append(this.d4).append("|");
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anop
 * JD-Core Version:    0.7.0.1
 */