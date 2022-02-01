import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class anpa
{
  private static String a(anpa.a parama)
  {
    return parama.encode();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    anpa.a locala = new anpa.a();
    locala.roomId = paramLong9;
    locala.anb = paramLong1;
    locala.anc = paramLong2;
    locala.and = paramLong3;
    locala.ane = paramLong4;
    locala.anf = paramLong5;
    locala.uin = paramQQAppInterface.getCurrentUin();
    locala.ang = paramLong6;
    locala.anm = paramLong7;
    locala.anh = paramLong8;
    locala.toUin = paramString1;
    locala.cfJ = paramString2;
    paramString1 = a(locala);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    anot.m(paramQQAppInterface, "dc02653", paramString1, 1);
  }
  
  static class a
  {
    public long anb;
    public long anc;
    public long and;
    public long ane;
    public long anf;
    public long ang;
    public long anh;
    public long ani = 0L;
    public long anj = 4L;
    public long ank = getNetType();
    public long anl = Build.VERSION.SDK_INT;
    public long anm;
    public long ann = 0L;
    public long ano = 0L;
    public long anp = 0L;
    public long anq = 0L;
    public String cfI = "";
    public String cfJ;
    public String deviceName = Build.MODEL;
    public long roomId;
    public String toUin;
    public String uin;
    public String version = "3.4.4";
    
    public String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(this.roomId);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anb);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anc);
      localStringBuilder.append('|');
      localStringBuilder.append(this.and);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ane);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anf);
      localStringBuilder.append('|');
      localStringBuilder.append(this.uin);
      localStringBuilder.append('|');
      localStringBuilder.append(this.version);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ang);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anh);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ani);
      localStringBuilder.append('|');
      localStringBuilder.append(this.deviceName);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anj);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ank);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anl);
      localStringBuilder.append('|');
      localStringBuilder.append(this.toUin);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfI);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anm);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ann);
      localStringBuilder.append('|');
      localStringBuilder.append(this.ano);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anp);
      localStringBuilder.append('|');
      localStringBuilder.append(this.anq);
      localStringBuilder.append('|');
      localStringBuilder.append(this.cfJ);
      localStringBuilder.append('|');
      return localStringBuilder.toString();
    }
    
    public int getNetType()
    {
      int j = 0;
      int i;
      if (AppNetConnInfo.isWifiConn()) {
        i = 2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScoreReportController", 2, "getNetType: " + i);
        }
        return i;
        i = j;
        if (AppNetConnInfo.isMobileConn()) {
          switch (AppNetConnInfo.getMobileInfo())
          {
          default: 
            i = j;
            break;
          case 1: 
            i = 3;
            break;
          case 2: 
            i = 4;
            break;
          case 3: 
            i = 5;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpa
 * JD-Core Version:    0.7.0.1
 */