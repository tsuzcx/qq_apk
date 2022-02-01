import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

public class aini
{
  public static final String aUb = DeviceProfileManager.DpcNames.ltcfg.name();
  public DeviceProfileManager.a a = new ainj(this);
  public long abL = 3000L;
  public int dec = 50;
  public int ded = 0;
  
  private aini()
  {
    dsZ();
    DeviceProfileManager.a(this.a);
  }
  
  public static aini a()
  {
    return aini.a.b();
  }
  
  private void dsZ()
  {
    String str = DeviceProfileManager.b().jf(aUb);
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 4)
        {
          this.dec = Integer.valueOf(arrayOfString[0]).intValue();
          this.ded = Integer.valueOf(arrayOfString[1]).intValue();
          this.abL = Long.valueOf(arrayOfString[2]).longValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.dpc", 2, String.format("loadDpc, dpcValue: %s, [%s]", new Object[] { str, this }));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ListenTogether.dpc", 1, "loadDpc", localException);
        this.dec = 50;
        this.ded = 0;
        this.abL = 3000L;
      }
    }
  }
  
  public String toString()
  {
    return "ListenTogetherDPC{maxCacheCount=" + this.dec + ", preDownloadNetType=" + this.ded + ", playingAdjustInterval=" + this.abL + '}';
  }
  
  static class a
  {
    private static final aini b = new aini(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aini
 * JD-Core Version:    0.7.0.1
 */