import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class afrz
{
  private static afrz a;
  public static int cTC = -1;
  public static int cTD = 1;
  public static int cTE = 2;
  public static int cTF = 3;
  private long XI;
  private int cTG = -1;
  
  public static afrz a()
  {
    if (a == null) {
      a = new afrz();
    }
    return a;
  }
  
  public int Dx()
  {
    return this.cTG;
  }
  
  public void E(Context paramContext, String paramString)
  {
    afsa localafsa = new afsa(this);
    String str2 = paramContext.getString(2131693228);
    String str1 = paramContext.getString(2131693212);
    long l = this.XI * 1000L;
    if (l > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l);
    }
    for (Object localObject = String.format(paramContext.getString(2131693226), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });; localObject = paramContext.getString(2131693227))
    {
      paramContext = aqha.a(paramContext, 230, str2, String.format(paramContext.getString(2131693225), new Object[] { paramString, localObject }), null, localafsa);
      if (paramContext != null)
      {
        paramContext.setNegativeButton(str1, localafsa);
        paramContext.show();
      }
      return;
    }
  }
  
  public void Nd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockPhoneStatus", 2, "pre:" + this.cTG + " now:" + paramInt);
    }
    this.cTG = paramInt;
  }
  
  public void je(long paramLong)
  {
    this.XI = paramLong;
  }
  
  public void update(byte[] paramArrayOfByte)
  {
    this.cTG = cTC;
    this.XI = 0L;
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "info is null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        devlock_mobile_phone.status localstatus = new devlock_mobile_phone.status();
        localstatus.mergeFrom(paramArrayOfByte);
        if (localstatus.u32_mb_mobile_state.has()) {
          this.cTG = localstatus.u32_mb_mobile_state.get();
        }
        if (localstatus.u32_audit_time.has())
        {
          this.XI = localstatus.u32_audit_time.get();
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockPhoneStatus", 2, "exception occurs");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrz
 * JD-Core Version:    0.7.0.1
 */