package btmsdkobf;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class be
{
  static be fw;
  private ec fx = new ec("actionStats");
  public ec fy = new ec("stringStats");
  
  be(Context paramContext) {}
  
  public static void SaveStringData(int paramInt, String paramString)
  {
    r().a(r().fy, paramInt, paramString, false);
  }
  
  public static void SaveStringDataOnce(int paramInt, String paramString)
  {
    r().a(r().fy, paramInt, paramString, true);
  }
  
  public static String a(ArrayList paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localStringBuffer.append(((bd)paramArrayList.get(i)).ft);
      localStringBuffer.append("&");
      localStringBuffer.append(((bd)paramArrayList.get(i)).fs);
      if (((bd)paramArrayList.get(i)).errorCode != 0)
      {
        localStringBuffer.append("&");
        localStringBuffer.append(((bd)paramArrayList.get(i)).errorCode);
      }
      localStringBuffer.append(";");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void b(boolean paramBoolean)
  {
    ec.cS().putBoolean("id", paramBoolean);
  }
  
  static String d(int paramInt)
  {
    return "" + paramInt;
  }
  
  public static void e(int paramInt)
  {
    String str = d(paramInt);
    r().fx.remove(str);
  }
  
  public static void f(int paramInt)
  {
    String str = d(paramInt);
    r().fy.remove(str);
  }
  
  public static be r()
  {
    if (fw == null) {}
    try
    {
      if (fw == null) {
        fw = new be(bc.n());
      }
      return fw;
    }
    finally {}
  }
  
  public static void saveActionData(int paramInt)
  {
    r().a(paramInt, 0);
  }
  
  public static void saveActionData(int paramInt1, int paramInt2)
  {
    r().a(paramInt1, paramInt2);
  }
  
  public static void saveActionDataOnce(int paramInt)
  {
    r().b(paramInt, 0);
  }
  
  public static void w()
  {
    eg.f("ActionStats", "tryReportDataByShark");
    be localbe = r();
    if (!x())
    {
      localbe.s();
      localbe.t();
      return;
    }
    n localn = new n();
    localn.an = new ArrayList();
    Object localObject = localbe.u();
    int i;
    int k;
    int m;
    o localo;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      int j = 0;
      i = 0;
      k = j;
      m = i;
      if (((Iterator)localObject).hasNext())
      {
        localo = (o)((Iterator)localObject).next();
        m = localo.toByteArray().length;
        if (m > 1024000) {
          e(localo.ar);
        }
        if (i + m < 1024000)
        {
          eg.f("ActionStats", "ActionData:[" + localo.ar + "]");
          localn.an.add(localo);
          k = j + 1;
          j = i + m;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          ((Iterator)localObject).remove();
          k = i;
          i = j;
          j = k;
        }
      }
    }
    else
    {
      k = 0;
      m = 0;
    }
    localObject = localbe.v();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localo = (o)((Iterator)localObject).next();
        i = localo.toByteArray().length;
        if (i > 1024000) {
          f(localo.ar);
        }
        if (m + i < 1024000)
        {
          eg.f("ActionStats", "StringData:[" + localo.ar + "][" + localo.at + "]");
          localn.an.add(localo);
          m += i;
          k += 1;
        }
        else
        {
          ((Iterator)localObject).remove();
        }
      }
    }
    if ((localn.an == null) || (localn.an.size() <= 0))
    {
      eg.e("ActionStats", "vecFeature is null");
      return;
    }
    localObject = bx.ar();
    eg.e("ActionStats", "sendShark, ECmd.Cmd_CSFeature");
    ((bx)localObject).a(3651, localn, null, 2, new ex(localbe), 0L);
  }
  
  public static boolean x()
  {
    return ec.cS().getBoolean("id", true);
  }
  
  ArrayList a(ec paramec)
  {
    ArrayList localArrayList = new ArrayList();
    paramec = paramec.getAll();
    Object localObject2;
    if (paramec != null)
    {
      paramec = paramec.entrySet().iterator();
      if (paramec.hasNext()) {
        localObject2 = (Map.Entry)paramec.next();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (!(localObject2 instanceof String))) {
          break;
        }
        localObject2 = (String)localObject2;
        if (((String)localObject2).indexOf("$") <= 0) {
          break;
        }
        int j = Integer.valueOf((String)localObject1).intValue();
        localObject1 = ((String)localObject2).split("\\$");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break;
        }
        int k = localObject1.length;
        i = 0;
        if (i >= k) {
          break;
        }
        localObject2 = localObject1[i].split("\\|");
        if ((localObject2 == null) || (localObject2.length != 2)) {
          break label264;
        }
        long l = Long.valueOf(localObject2[0]).longValue();
        localObject2 = localObject2[1];
        o localo = new o();
        localo.ar = j;
        localo.timestamp = ((int)(l / 1000L));
        localo.at = new ArrayList();
        localo.at.add(localObject2);
        if (localo == null) {
          break label264;
        }
        localArrayList.add(localo);
      }
      catch (Exception localException) {}
      break;
      return localArrayList;
      label264:
      i += 1;
    }
  }
  
  ArrayList a(ec paramec, String paramString)
  {
    paramString = null;
    if (paramec == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramec = paramec.getAll();
      if (paramec != null)
      {
        paramec = paramec.entrySet().iterator();
        while (paramec.hasNext())
        {
          Object localObject = (Map.Entry)paramec.next();
          try
          {
            paramString = (String)((Map.Entry)localObject).getKey();
            localObject = ((Map.Entry)localObject).getValue();
            if ((localObject instanceof String)) {
              localArrayList.addAll(d(Integer.valueOf(paramString).intValue(), (String)localObject));
            }
          }
          catch (Exception paramString) {}
        }
      }
      return b(localArrayList);
    }
    catch (Exception paramec)
    {
      for (;;)
      {
        paramec = paramString;
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    ee.cT().addTask(new cq(this, paramInt1, paramInt2), "doxxx");
  }
  
  void a(ec paramec, int paramInt, String paramString, boolean paramBoolean)
  {
    ee.cT().addTask(new dh(this, paramString, paramInt, paramec, paramBoolean), "doxxx");
  }
  
  ArrayList b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bd localbd = (bd)paramArrayList.next();
      if (localbd.fs > 0)
      {
        o localo = new o();
        localo.ar = localbd.fr;
        localo.timestamp = ((int)(localbd.ft / 1000L));
        localo.count = localbd.fs;
        if (localbd.errorCode != 0)
        {
          localo.as = new ArrayList();
          localo.as.add(Integer.valueOf(localbd.errorCode));
        }
        localArrayList.add(localo);
      }
    }
    return localArrayList;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    ee.cT().addTask(new ct(this, paramInt1, paramInt2), "doxxx");
  }
  
  ArrayList d(int paramInt, String paramString)
  {
    localArrayList = new ArrayList();
    String str1 = paramString;
    if (paramString == null) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        str1 = str1.substring(i + 1);
        int i = str1.indexOf(";");
        if (i == -1) {
          continue;
        }
        paramString = new bd();
        String str2 = str1.substring(0, i);
        if (str2.indexOf("&") != -1)
        {
          paramString.fr = paramInt;
          paramString.ft = Long.parseLong(str2.substring(0, str2.indexOf("&")));
          if (paramString.ft == 0L) {
            paramString.ft = System.currentTimeMillis();
          }
          str2 = str2.substring(str2.indexOf("&") + 1);
          if (str2.indexOf("&") == -1) {
            break label198;
          }
          paramString.fs = Integer.parseInt(str2.substring(0, str2.indexOf("&")));
          paramString.errorCode = Integer.parseInt(str2.substring(str2.indexOf("&") + 1));
        }
        for (;;)
        {
          localArrayList.add(paramString);
          if (i != str1.length()) {
            break;
          }
          return localArrayList;
          label198:
          paramString.fs = Integer.parseInt(str2);
        }
        return localArrayList;
      }
      catch (Exception paramString) {}
    }
  }
  
  public void s()
  {
    this.fx.clear();
  }
  
  public void t()
  {
    r().fy.clear();
  }
  
  public ArrayList u()
  {
    return a(this.fx, "Action");
  }
  
  public ArrayList v()
  {
    return a(r().fy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.be
 * JD-Core Version:    0.7.0.1
 */