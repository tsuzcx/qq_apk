package btmsdkobf;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
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
  
  public static String a(ArrayList<bd> paramArrayList)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
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
    if (fw == null) {
      try
      {
        if (fw == null) {
          fw = new be(bc.n());
        }
      }
      finally {}
    }
    return fw;
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
    int j = 0;
    int i = 0;
    n localn = new n();
    localn.an = new ArrayList();
    Object localObject = localbe.u();
    o localo;
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localo = (o)((Iterator)localObject).next();
        j = localo.toByteArray().length;
        if (j > 1024000) {
          e(localo.ar);
        }
        j += i;
        if (j < 1024000)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ActionData:[");
          localStringBuilder.append(localo.ar);
          localStringBuilder.append("]");
          eg.f("ActionStats", localStringBuilder.toString());
          localn.an.add(localo);
          i = j;
        }
        else
        {
          ((Iterator)localObject).remove();
        }
      }
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
        i += j;
        if (i < 1024000)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("StringData:[");
          localStringBuilder.append(localo.ar);
          localStringBuilder.append("][");
          localStringBuilder.append(localo.at);
          localStringBuilder.append("]");
          eg.f("ActionStats", localStringBuilder.toString());
          localn.an.add(localo);
          j = i;
        }
        else
        {
          ((Iterator)localObject).remove();
        }
      }
    }
    if ((localn.an != null) && (localn.an.size() > 0))
    {
      localObject = bx.ar();
      eg.e("ActionStats", "sendShark, ECmd.Cmd_CSFeature");
      ((bx)localObject).a(3651, localn, null, 2, new cj()
      {
        public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
        {
          paramAnonymousJceStruct = new StringBuilder();
          paramAnonymousJceStruct.append("sendShark, ECmd.Cmd_CSFeature, retCode:[");
          paramAnonymousJceStruct.append(paramAnonymousInt3);
          paramAnonymousJceStruct.append("]dataRetCode:[");
          paramAnonymousJceStruct.append(paramAnonymousInt4);
          paramAnonymousJceStruct.append("]");
          eg.e("ActionStats", paramAnonymousJceStruct.toString());
          if (paramAnonymousInt3 == 0)
          {
            this.a.s();
            this.a.t();
          }
        }
      }, 0L);
      return;
    }
    eg.e("ActionStats", "vecFeature is null");
  }
  
  public static boolean x()
  {
    return ec.cS().getBoolean("id", true);
  }
  
  ArrayList<o> a(ec paramec)
  {
    ArrayList localArrayList = new ArrayList();
    paramec = paramec.getAll();
    if (paramec != null) {
      paramec = paramec.entrySet().iterator();
    }
    for (;;)
    {
      Object localObject2;
      if (paramec.hasNext()) {
        localObject2 = (Map.Entry)paramec.next();
      }
      try
      {
        Object localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && ((localObject2 instanceof String)))
        {
          localObject2 = (String)localObject2;
          if (((String)localObject2).indexOf("$") > 0)
          {
            int j = Integer.valueOf((String)localObject1).intValue();
            localObject1 = ((String)localObject2).split("\\$");
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              int k = localObject1.length;
              int i = 0;
              while (i < k)
              {
                localObject2 = localObject1[i].split("\\|");
                if ((localObject2 != null) && (localObject2.length == 2))
                {
                  long l = Long.valueOf(localObject2[0]).longValue();
                  localObject2 = localObject2[1];
                  o localo = new o();
                  localo.ar = j;
                  localo.timestamp = ((int)(l / 1000L));
                  localo.at = new ArrayList();
                  localo.at.add(localObject2);
                  localArrayList.add(localo);
                }
                i += 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        label261:
        break label261;
      }
    }
    return localArrayList;
  }
  
  ArrayList<o> a(ec paramec, String paramString)
  {
    paramString = null;
    if (paramec == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramec = paramec.getAll();
      if (paramec != null) {
        paramec = paramec.entrySet().iterator();
      }
      for (;;)
      {
        Object localObject;
        if (paramec.hasNext()) {
          localObject = (Map.Entry)paramec.next();
        }
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
  
  void a(final int paramInt1, final int paramInt2)
  {
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        String str1 = be.d(paramInt1);
        long l = System.currentTimeMillis();
        String str2 = be.a(be.this).getString(str1, null);
        if ((str2 != null) && (str2.length() > 8192)) {
          return;
        }
        Object localObject1 = new ArrayList();
        Object localObject2 = new bd();
        ((bd)localObject2).fr = paramInt1;
        ((bd)localObject2).ft = l;
        ((bd)localObject2).fs = 1;
        ((bd)localObject2).errorCode = paramInt2;
        ((ArrayList)localObject1).add(localObject2);
        localObject1 = be.a((ArrayList)localObject1);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          if (str2 != null) {
            ((StringBuilder)localObject2).append(str2);
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          be.a(be.this).putString(str1, ((StringBuilder)localObject2).toString());
        }
      }
    }, "doxxx");
  }
  
  void a(final ec paramec, final int paramInt, final String paramString, final boolean paramBoolean)
  {
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        String str1 = paramString;
        if (str1 != null)
        {
          if (str1.length() <= 0) {
            return;
          }
          String str2 = be.d(paramInt);
          str1 = paramec.getString(str2, null);
          if ((str1 == null) || (paramBoolean)) {
            str1 = "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(System.currentTimeMillis());
          localStringBuilder.append("|");
          localStringBuilder.append(paramString);
          localStringBuilder.append("$");
          if (localStringBuilder.length() > 16384) {
            return;
          }
          paramec.putString(str2, localStringBuilder.toString());
        }
      }
    }, "doxxx");
  }
  
  ArrayList<o> b(ArrayList<bd> paramArrayList)
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
  
  void b(final int paramInt1, final int paramInt2)
  {
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        String str = be.d(paramInt1);
        long l = System.currentTimeMillis();
        Object localObject1 = new ArrayList();
        Object localObject2 = new bd();
        ((bd)localObject2).fr = paramInt1;
        ((bd)localObject2).ft = l;
        ((bd)localObject2).fs = 1;
        ((bd)localObject2).errorCode = paramInt2;
        ((ArrayList)localObject1).add(localObject2);
        localObject1 = be.a((ArrayList)localObject1);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          be.a(be.this).putString(str, ((StringBuilder)localObject2).toString());
        }
      }
    }, "doxxx");
  }
  
  ArrayList<bd> d(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramString;
    if (paramString == null) {
      return localArrayList;
    }
    try
    {
      for (;;)
      {
        int i = str1.indexOf(";");
        if (i == -1) {
          break;
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
          if (str2.indexOf("&") != -1)
          {
            paramString.fs = Integer.parseInt(str2.substring(0, str2.indexOf("&")));
            paramString.errorCode = Integer.parseInt(str2.substring(str2.indexOf("&") + 1));
          }
          else
          {
            paramString.fs = Integer.parseInt(str2);
          }
          localArrayList.add(paramString);
        }
        if (i == str1.length()) {
          return localArrayList;
        }
        str1 = str1.substring(i + 1);
      }
      return localArrayList;
    }
    catch (Exception paramString) {}
    return localArrayList;
  }
  
  public void s()
  {
    this.fx.clear();
  }
  
  public void t()
  {
    r().fy.clear();
  }
  
  public ArrayList<o> u()
  {
    return a(this.fx, "Action");
  }
  
  public ArrayList<o> v()
  {
    return a(r().fy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.be
 * JD-Core Version:    0.7.0.1
 */