import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class jgu
{
  private static jgu b;
  public String RU;
  public int aze = 4;
  public int azf = 2000;
  public int azg = 4;
  public int azh = 2150;
  public int azi = 1;
  public int azj = 5;
  public int azk = 120000;
  public int azl = 1;
  public int azm = 1;
  public int azn = 0;
  public int azo = 0;
  public int azp = 5000;
  public int azq = 0;
  public int azr = 25000;
  public int azs = 1;
  public int azt;
  public int azu;
  public int enable = 1;
  public int maxVideoWidth = 720;
  
  private static int a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramInt1 >= paramArrayOfString.length)) {
      return paramInt2;
    }
    try
    {
      paramInt1 = Integer.parseInt(paramArrayOfString[paramInt1]);
      return paramInt1;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return paramInt2;
  }
  
  public static jgu a()
  {
    if (b == null) {
      b = b();
    }
    return b;
  }
  
  private static jgu b()
  {
    jgu localjgu = new jgu();
    Object localObject = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.qavDpc.name());
    localjgu.RU = ((String)localObject);
    if (!TextUtils.isEmpty(localjgu.RU))
    {
      localObject = ((String)localObject).split("\\|");
      localjgu.enable = a((String[])localObject, 0, 1);
      localjgu.aze = a((String[])localObject, 1, 4);
      localjgu.azf = a((String[])localObject, 2, 2000);
      localjgu.azg = a((String[])localObject, 3, 4);
      localjgu.azh = a((String[])localObject, 4, 2150);
      localjgu.maxVideoWidth = a((String[])localObject, 5, 720);
      localjgu.azi = a((String[])localObject, 6, 1);
      localjgu.azj = a((String[])localObject, 7, 5);
      localjgu.azk = a((String[])localObject, 8, 120000);
      localjgu.azl = a((String[])localObject, 9, 1);
      localjgu.azm = a((String[])localObject, 10, 1);
      localjgu.azn = a((String[])localObject, 11, 0);
      localjgu.azo = a((String[])localObject, 12, 0);
      localjgu.azp = a((String[])localObject, 13, 5000);
      localjgu.azq = a((String[])localObject, 14, 0);
      localjgu.azr = a((String[])localObject, 15, 25000);
      localjgu.azs = a((String[])localObject, 16, 1);
    }
    localjgu.azt = aqgz.getCpuNumber();
    localjgu.azu = ((int)(aqgz.getCpuMaxFreq() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordDpc", 2, "init=" + localjgu);
    }
    return localjgu;
  }
  
  public String toString()
  {
    return String.format(Locale.getDefault(), "QavRecordDpc:dpc=%s, default=%d|%d|%d|%d|%d|%d, value=%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%s|%s, system=%d|%d", new Object[] { this.RU, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2000), Integer.valueOf(4), Integer.valueOf(2150), Integer.valueOf(720), Integer.valueOf(this.enable), Integer.valueOf(this.aze), Integer.valueOf(this.azf), Integer.valueOf(this.azg), Integer.valueOf(this.azh), Integer.valueOf(this.maxVideoWidth), Integer.valueOf(this.azi), Integer.valueOf(this.azj), Integer.valueOf(this.azk), Integer.valueOf(this.azm), Integer.valueOf(this.azn), Integer.valueOf(this.azo), Integer.valueOf(this.azp), Integer.valueOf(this.azq), Integer.valueOf(this.azr), Integer.valueOf(this.azs), Integer.valueOf(this.azt), Integer.valueOf(this.azu) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgu
 * JD-Core Version:    0.7.0.1
 */