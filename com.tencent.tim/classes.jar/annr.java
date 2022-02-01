import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ArkAppReportController.1;
import com.tencent.qphone.base.util.QLog;

public class annr
{
  private static String a(annr.a parama)
  {
    return parama.encode();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    annr.a locala = new annr.a();
    locala.appName = paramString1;
    locala.azn = paramString2;
    locala.cfo = paramString3;
    locala.akw = paramLong1;
    locala.entry = paramLong2;
    locala.amA = paramLong3;
    locala.amC = paramLong4;
    locala.amD = paramLong5;
    locala.cfp = paramString4;
    locala.cfq = paramString5;
    locala.count = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(locala);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(locala);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    anot.m(paramQQAppInterface, "dc01616", paramString1, 1);
  }
  
  static class a
  {
    public long akw = 0L;
    public long amA = 0L;
    public final long amB = 2L;
    public long amC = 0L;
    public long amD = 0L;
    public String appName = "";
    public String azn = "";
    public String cfo = "";
    public String cfp = "";
    public String cfq = "";
    public long count = 1L;
    public long entry = 0L;
    
    public String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(this.appName);
      localStringBuilder.append('|');
      localStringBuilder.append(this.azn);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfo);
      localStringBuilder.append('|');
      localStringBuilder.append(this.akw);
      localStringBuilder.append('|');
      localStringBuilder.append(this.entry);
      localStringBuilder.append('|');
      localStringBuilder.append("${count_unknown}");
      localStringBuilder.append('|');
      localStringBuilder.append(this.amA);
      localStringBuilder.append('|');
      localStringBuilder.append(2L);
      localStringBuilder.append('|');
      localStringBuilder.append(this.amC);
      localStringBuilder.append('|');
      localStringBuilder.append(this.amD);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfp);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfq);
      localStringBuilder.append('|');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annr
 * JD-Core Version:    0.7.0.1
 */