import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class aale
{
  private static aale a;
  private long LZ;
  public zxc b;
  private String bdp = "yyyy-MM-dd";
  private StringBuffer g = new StringBuffer(25);
  private HashMap<String, HashMap<String, String>> hU;
  private HashMap<String, Boolean> hV = new HashMap();
  
  private aale()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    this.hU = new HashMap();
    cvh();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localBaseApplicationImpl != null) {
      localObject1 = localBaseApplicationImpl.getContentResolver();
    }
    try
    {
      localObject1 = Settings.System.getString((ContentResolver)localObject1, "date_format");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (this.bdp = ((String)localObject1);; this.bdp = "yyyy-MM-dd")
      {
        this.b = new zxc(Looper.getMainLooper());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private boolean WC()
  {
    if (System.currentTimeMillis() >= this.LZ)
    {
      cvh();
      this.hU.clear();
      return false;
    }
    return true;
  }
  
  public static aale a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aale();
      }
      return a;
    }
    finally {}
  }
  
  private void cvh()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.LZ = localCalendar.getTimeInMillis();
  }
  
  public void bq(String paramString, boolean paramBoolean)
  {
    this.hV.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void cvi()
  {
    if (this.b != null) {
      this.b.stop();
    }
  }
  
  public void cvj()
  {
    if (this.b != null) {
      this.b.pause();
    }
  }
  
  public void cvk()
  {
    if (this.b != null) {
      this.b.resume();
    }
  }
  
  public boolean iP(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.equals(this.bdp, paramString)) {
      if (TextUtils.isEmpty(paramString)) {
        break label43;
      }
    }
    label43:
    for (this.bdp = paramString;; this.bdp = "yyyy-MM-dd")
    {
      bool = true;
      if (this.hU != null) {
        this.hU.clear();
      }
      return bool;
    }
  }
  
  public boolean iQ(String paramString)
  {
    return this.hV.containsKey(paramString);
  }
  
  public String qy()
  {
    return this.bdp;
  }
  
  public String t(String arg1, long paramLong)
  {
    HashMap localHashMap = (HashMap)this.hU.get(???);
    if ((localHashMap == null) || (!WC()))
    {
      localHashMap = new HashMap();
      this.hU.put(???, localHashMap);
      ??? = null;
    }
    for (;;)
    {
      String str = ???;
      if (??? == null) {}
      synchronized (this.g)
      {
        str = aqmu.a(this.g, 1000L * paramLong, true, this.bdp);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.g.toString() + "," + str);
        }
        localHashMap.put(String.valueOf(paramLong), str);
        return str;
        ??? = (String)localHashMap.get(String.valueOf(paramLong));
        if (??? == null) {
          localHashMap.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aale
 * JD-Core Version:    0.7.0.1
 */