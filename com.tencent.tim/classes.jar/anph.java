import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class anph
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    anph.a locala = new anph.a();
    locala.cfS = paramString1;
    locala.cfT = paramString2;
    locala.cfU = paramString3;
    locala.cfV = paramString4;
    locala.anx = paramInt1;
    locala.any = paramInt2;
    locala.anz = paramInt3;
    locala.cfW = paramString5;
    locala.cfX = paramString6;
    locala.cfY = paramString7;
    locala.cfZ = paramString8;
    paramString1 = locala.encode();
    if (QLog.isColorLevel()) {
      QLog.i("SubscribeReportController", 1, "getReportingDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a("${uin_unknown}", paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc05263");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt2);
      paramString1.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    anot.m(localQQAppInterface, "dc05263", a(localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7), paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, 1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
  
  static class a
  {
    public long anv = System.currentTimeMillis();
    public long anw = AppSetting.getAppId();
    public long anx;
    public long any;
    public long anz;
    public String cfQ = aqgz.getIMEI();
    public String cfR = "";
    public String cfS;
    public String cfT;
    public String cfU;
    public String cfV;
    public String cfW;
    public String cfX;
    public String cfY;
    public String cfZ;
    public String platform = "AND";
    public String version = "3.4.4.3058";
    
    public String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(this.anv);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anw);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfQ);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfR);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfS);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfT);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfU);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfV);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anx);
      localStringBuilder.append('|');
      localStringBuilder.append(this.any);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anz);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfW);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfX);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfY);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfZ);
      localStringBuilder.append('|');
      localStringBuilder.append(this.version);
      localStringBuilder.append('|');
      localStringBuilder.append(this.platform);
      localStringBuilder.append('|');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anph
 * JD-Core Version:    0.7.0.1
 */