import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.NeonControl.1;
import com.tencent.mobileqq.ar.NeonControl.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adfn
{
  private static adfn jdField_a_of_type_Adfn;
  public static boolean bMz = true;
  adfn.a jdField_a_of_type_Adfn$a;
  private boolean bMy;
  public final Object mLock = new Object();
  
  private adfn()
  {
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
    if (!((SharedPreferences)localObject1).contains("sp_cpu_neon_support")) {
      ThreadManager.post(new NeonControl.1(this, (SharedPreferences)localObject1, false), 5, null, true);
    }
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("sp_cpu_neon_support", false);
    boolean bool3 = adfw.a().bMK;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (bool3)
      {
        i = 1;
        if (!bool2) {
          break label174;
        }
        j = 1;
        label97:
        QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0) }));
      }
    }
    else
    {
      localObject1 = this.mLock;
      if ((!bool3) || (!bool2)) {
        break label179;
      }
    }
    for (;;)
    {
      try
      {
        this.bMy = bool1;
        return;
      }
      finally {}
      i = 0;
      break;
      label174:
      j = 0;
      break label97;
      label179:
      bool1 = false;
    }
  }
  
  public static adfn a()
  {
    if (jdField_a_of_type_Adfn == null) {
      jdField_a_of_type_Adfn = new adfn();
    }
    return jdField_a_of_type_Adfn;
  }
  
  public void aC(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Adfn$a == null)
    {
      this.jdField_a_of_type_Adfn$a = new adfn.a();
      this.jdField_a_of_type_Adfn$a.cEi = paramInt;
    }
    if (this.jdField_a_of_type_Adfn$a.cEi != paramInt)
    {
      if ((this.jdField_a_of_type_Adfn$a.total > 0L) || (this.jdField_a_of_type_Adfn$a.count > 0)) {
        doReport();
      }
      this.jdField_a_of_type_Adfn$a.cEi = paramInt;
      this.jdField_a_of_type_Adfn$a.total = 0L;
      this.jdField_a_of_type_Adfn$a.count = 0;
    }
    adfn.a locala = this.jdField_a_of_type_Adfn$a;
    locala.total += paramLong;
    locala = this.jdField_a_of_type_Adfn$a;
    locala.count += 1;
  }
  
  public boolean aee()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.bMy;
      return bool;
    }
  }
  
  public void doReport()
  {
    if (this.jdField_a_of_type_Adfn$a == null) {}
    adfn.a locala;
    int i;
    do
    {
      do
      {
        return;
        locala = new adfn.a();
        locala.total = this.jdField_a_of_type_Adfn$a.total;
        locala.count = this.jdField_a_of_type_Adfn$a.count;
        locala.cEi = this.jdField_a_of_type_Adfn$a.cEi;
        this.jdField_a_of_type_Adfn$a.cEi = -2147483648;
        this.jdField_a_of_type_Adfn$a.total = 0L;
        this.jdField_a_of_type_Adfn$a.count = 0;
      } while ((locala.total <= 0L) || (locala.count <= 0) || (locala.cEi == -2147483648));
      i = (int)(locala.total / locala.count);
    } while ((i < 0) || (i >= 600000));
    ThreadManager.post(new NeonControl.2(this, locala, i), 5, null, false);
  }
  
  public class a
  {
    public int cEi;
    public int count;
    long total;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfn
 * JD-Core Version:    0.7.0.1
 */