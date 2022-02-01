package c.t.m.g;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class bg
{
  private static List<String> a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add("mobile");
    a.add("16wifi");
    a.add("cmcc");
    a.add("360wifi");
    a.add("androidap");
    a.add("htcphone");
    a.add("xiaomi");
    a.add("lenovo");
    a.add("macbook");
  }
  
  @SuppressLint({"NewApi"})
  public static void a(List<ScanResult> paramList)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ScanResult localScanResult = (ScanResult)localIterator.next();
      String str = localScanResult.BSSID;
      if ((str == null) || (str.equals("000000000000")) || (str.equals("00-00-00-00-00-00")) || (str.equals("00:00:00:00:00:00")) || (localScanResult.level >= 0)) {
        localIterator.remove();
      } else if (localHashSet.contains(str)) {
        localIterator.remove();
      } else {
        localHashSet.add(str);
      }
    }
    new StringBuilder("after step1 filter : ").append(paramList.size());
    try
    {
      b(paramList);
      label142:
      new StringBuilder("after step2 filter : ").append(paramList.size());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label142;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void b(List<ScanResult> paramList)
  {
    ArrayList localArrayList2 = null;
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject = localArrayList2;
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      localObject = ((ScanResult)paramList.get(0)).getClass().getField("wifiSsid");
      ((Field)localObject).setAccessible(true);
      localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramList.next();
        if ((Build.VERSION.SDK_INT >= 21) && (localObject != null)) {
          try
          {
            if (((Field)localObject).get(localScanResult) == null)
            {
              paramList.remove();
              localArrayList2.add(localScanResult);
            }
          }
          catch (Exception localException) {}
        }
      }
      localArrayList2.size();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList1 = localArrayList2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bg
 * JD-Core Version:    0.7.0.1
 */