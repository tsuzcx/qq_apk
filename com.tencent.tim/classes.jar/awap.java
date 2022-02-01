import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class awap
{
  awap.a a = new awap.a();
  HashMap<Integer, awao> qN = new HashMap();
  
  private t a()
  {
    try
    {
      t localt = t.a.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isub" }));
      return localt;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("UniKingCardHelper/SimManager", "getIsub error:" + localThrowable.getMessage());
    }
    return null;
  }
  
  private void a(int paramInt, awao paramawao)
  {
    if (this.qN != null) {
      this.qN.put(Integer.valueOf(paramInt), paramawao);
    }
  }
  
  private int bE(Context paramContext)
  {
    try
    {
      String str = awam.getIMSI(paramContext);
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = avpp.a().getIMSI();
      }
      eu(10, paramContext);
      a(10, Boolean.valueOf(true));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainIMSI error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  private int bF(Context paramContext)
  {
    try
    {
      ev(10, awam.bP(paramContext));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainPhoneNum error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  private void clear()
  {
    if (this.qN != null) {
      this.qN.clear();
    }
  }
  
  abstract int a(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;
  
  abstract int a(t paramt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;
  
  awao a(int paramInt)
  {
    if ((this.qN != null) && (this.qN.containsKey(Integer.valueOf(paramInt)))) {
      return (awao)this.qN.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  void a(int paramInt, Boolean paramBoolean)
  {
    awao localawao2 = a(paramInt);
    awao localawao1 = localawao2;
    if (localawao2 == null) {
      localawao1 = new awao();
    }
    localawao1.WU(paramBoolean.booleanValue());
    a(paramInt, localawao1);
  }
  
  abstract int b(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;
  
  int bG(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = TelephonyManager.class.getMethod("isMultiSimEnabled", new Class[0]);
      if (localMethod != null)
      {
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        if (bool) {
          return 10;
        }
        return 11;
      }
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "isMultiSimEnabled error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  abstract int c(Context paramContext, int[] paramArrayOfInt)
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;
  
  void eu(int paramInt, String paramString)
  {
    awao localawao2 = a(paramInt);
    awao localawao1 = localawao2;
    if (localawao2 == null) {
      localawao1 = new awao();
    }
    localawao1.aaA(paramString);
    a(paramInt, localawao1);
  }
  
  void ev(int paramInt, String paramString)
  {
    awao localawao2 = a(paramInt);
    awao localawao1 = localawao2;
    if (localawao2 == null) {
      localawao1 = new awao();
    }
    localawao1.setPhoneNum(paramString);
    a(paramInt, localawao1);
  }
  
  public awao getDataSimInfo()
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.qN != null)
    {
      i = 0;
      if (i <= 10)
      {
        localObject = a(i);
        if ((localObject == null) || (!((awao)localObject).aLY()) || (TextUtils.isEmpty(((awao)localObject).gK()))) {}
      }
    }
    awao localawao;
    label98:
    do
    {
      return localObject;
      i += 1;
      break;
      if (this.qN != null)
      {
        i = 0;
        for (;;)
        {
          if (i > 10) {
            break label98;
          }
          localawao = a(i);
          if (localawao != null)
          {
            localObject = localawao;
            if (localawao.aLY()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (this.qN == null) {
        break label132;
      }
      localawao = a(10);
      if (localawao == null) {
        break label132;
      }
      localObject = localawao;
    } while (!TextUtils.isEmpty(localawao.gK()));
    label132:
    if (this.qN != null)
    {
      i = j;
      for (;;)
      {
        if (i > 10) {
          break label169;
        }
        localawao = a(i);
        localObject = localawao;
        if (localawao != null) {
          break;
        }
        i += 1;
      }
    }
    label169:
    return null;
  }
  
  public void gx(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      clear();
      bE(paramContext);
      bF(paramContext);
      t localt = a();
      j = 2;
      int[] arrayOfInt2 = null;
      int[] arrayOfInt1 = null;
      i = j;
      if (localt != null) {
        arrayOfInt1 = arrayOfInt2;
      }
      try
      {
        arrayOfInt2 = localt.e();
        i = j;
        arrayOfInt1 = arrayOfInt2;
        if (arrayOfInt2 != null)
        {
          arrayOfInt1 = arrayOfInt2;
          i = arrayOfInt2.length;
          arrayOfInt1 = arrayOfInt2;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QZLog.e("UniKingCardHelper/SimManager", "getActiveSubIdList error:" + localThrowable.getMessage());
          i = j;
        }
      }
      this.a.ezI = i;
      if ((i > 1) && (bG(paramContext) != 11))
      {
        this.a.dpF = true;
        a(paramContext, arrayOfInt1);
        b(paramContext, arrayOfInt1);
        if (a(localt) != 0) {
          c(paramContext, arrayOfInt1);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      int j;
      int i;
      QZLog.e("UniKingCardHelper/SimManager", "initAllInfo error:" + paramContext.getMessage());
      return;
    }
    finally
    {
      this.a.aAF = (System.currentTimeMillis() - l);
    }
  }
  
  public class a
  {
    public awao a;
    public long aAF = 0L;
    public awao b = null;
    public boolean dpF = false;
    public int ezI = 0;
    public int ezJ = 0;
    
    a()
    {
      this.jdField_a_of_type_Awao = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awap
 * JD-Core Version:    0.7.0.1
 */