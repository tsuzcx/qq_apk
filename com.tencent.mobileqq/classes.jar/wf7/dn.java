package wf7;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class dn
  implements eu
{
  private static dn lg = null;
  private static dn.a lo = null;
  private static dn.a lp = null;
  private boolean lh = false;
  private dt li;
  private String lj = "mazu.3g.qq.com";
  private final Object lk = new Object();
  private String ll = "key_notset";
  private dn.a lm;
  private dn.a ln;
  private Context mContext;
  
  public dn(Context paramContext, boolean paramBoolean, dt paramdt, String paramString)
  {
    this.mContext = paramContext;
    this.lh = paramBoolean;
    this.li = paramdt;
    if (this.lh) {
      if (!TextUtils.isEmpty(paramString)) {
        this.lj = paramString;
      }
    }
    for (;;)
    {
      bM();
      a(this);
      return;
      this.lj = "mazutest.3g.qq.com";
      continue;
      if (this.li.co() == 1) {
        this.lj = "mazu-hk.3g.qq.com";
      } else {
        this.lj = a(1, paramdt);
      }
    }
  }
  
  private static String a(int paramInt, dt paramdt)
  {
    Object localObject = null;
    SparseArray localSparseArray = paramdt.cp();
    paramdt = (dt)localObject;
    if (localSparseArray != null) {
      paramdt = (String)localSparseArray.get(paramInt);
    }
    localObject = paramdt;
    if (TextUtils.isEmpty(paramdt)) {}
    switch (paramInt)
    {
    default: 
      localObject = "mazu.3g.qq.com";
      return localObject;
    case 1: 
      return "mazu.3g.qq.com";
    case 2: 
      return "mazuburst.3g.qq.com";
    case 3: 
      return "183.232.125.162";
    case 4: 
      return "163.177.71.153";
    }
    return "120.198.203.156";
  }
  
  public static String a(boolean paramBoolean, dt paramdt)
  {
    if (paramBoolean) {
      return "mazuburst-test.3g.qq.com";
    }
    if (paramdt.co() == 1) {
      return "mazuburst-hk.3g.qq.com";
    }
    return a(2, paramdt);
  }
  
  public static List<String> a(List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (b(str, paramBoolean)) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  private dn.a a(String paramString, boolean paramBoolean)
  {
    dn.a locala = this.li.v(paramString);
    if (locala != null)
    {
      if (locala.isValid()) {
        return locala;
      }
      if (paramBoolean) {
        this.li.a(paramString, 0L, null);
      }
    }
    return null;
  }
  
  private void a(String paramString, dn.a arg2, boolean paramBoolean)
  {
    if ((paramString == null) || (??? == null) || (!???.isValid())) {
      return;
    }
    dn.a locala = new dn.a(???.lq, ???.lr, ???.ls);
    if (paramBoolean) {
      dn.a.a(locala, k(true));
    }
    synchronized (this.lk)
    {
      this.lm = locala;
      this.ln = dn.a.a(this.lm);
      this.ll = paramString;
      return;
    }
  }
  
  public static void a(dn paramdn)
  {
    lg = paramdn;
  }
  
  private String ae(int paramInt)
  {
    Object localObject = new StringBuilder().append("");
    String str;
    if (this.lh)
    {
      str = "t_";
      localObject = str;
      if (paramInt != 1) {
        break label98;
      }
      if (!fj.dJ()) {
        break label92;
      }
      str = fj.getSSID();
      str = "wifi_" + str;
    }
    for (;;)
    {
      return (String)localObject + str;
      str = "r_";
      break;
      label92:
      str = "wifi_nonessid";
      continue;
      label98:
      str = "apn_" + paramInt;
    }
  }
  
  private static boolean b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.lastIndexOf(":");
      } while ((i <= 0) || (i == paramString.length() - 1));
      str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    } while (((!paramBoolean) && (!s(str))) || (!TextUtils.isDigitsOnly(paramString)));
    return true;
  }
  
  public static dn bK()
  {
    return lg;
  }
  
  private void bM()
  {
    String str = bO();
    synchronized (this.lk)
    {
      if ((this.ll != null) && (this.ll.equals(str)) && (this.lm != null) && (this.lm.isValid())) {
        return;
      }
      ??? = a(str, true);
      if ((??? != null) && (((dn.a)???).isValid()))
      {
        a(str, (dn.a)???, true);
        return;
      }
    }
    bN();
  }
  
  private void bN()
  {
    synchronized (this.lk)
    {
      if ((this.ll != null) && (this.ll.equals("key_default")) && (this.lm != null) && (this.lm.isValid())) {
        return;
      }
      a("key_default", j(true), false);
      return;
    }
  }
  
  private String bO()
  {
    Object localObject = new StringBuilder().append("");
    int i;
    if (this.lh)
    {
      str = "t_";
      localObject = str;
      i = ee.i(this.mContext);
      if (i != 1) {
        break label94;
      }
      str = fj.getSSID();
    }
    label94:
    for (String str = "wifi_" + str;; str = "apn_" + i)
    {
      return (String)localObject + str;
      str = "r_";
      break;
    }
  }
  
  private int bQ()
  {
    if (4 == fh.pO) {}
    int i;
    do
    {
      return 2;
      i = fg.l(this.mContext);
    } while (-1 == i);
    return i;
  }
  
  private dn.a j(boolean paramBoolean)
  {
    if ((paramBoolean) && (lo != null)) {
      return lo;
    }
    if ((!paramBoolean) && (lp != null)) {
      return lp;
    }
    Object localObject = k(paramBoolean);
    List localList = l(paramBoolean);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject);
    localArrayList.addAll(localList);
    localObject = new dn.a(0L, localArrayList, true);
    if (paramBoolean)
    {
      lo = (dn.a)localObject;
      return localObject;
    }
    lp = (dn.a)localObject;
    return localObject;
  }
  
  private List<String> k(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((List)localObject).add(Integer.valueOf(443));
    }
    for (;;)
    {
      String str = this.lj;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(String.format("%s:%d", new Object[] { str, Integer.valueOf(((Integer)((Iterator)localObject).next()).intValue()) }));
      }
      ((List)localObject).add(Integer.valueOf(80));
    }
    return localArrayList;
  }
  
  private List<String> l(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.lh) {
      return localArrayList;
    }
    Object localObject2 = new ArrayList();
    if (paramBoolean) {
      ((List)localObject2).add(Integer.valueOf(443));
    }
    Object localObject1;
    while (this.li.co() == 1)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.143.147", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.46", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.45", Integer.valueOf(i) }));
      }
      ((List)localObject2).add(Integer.valueOf(80));
    }
    switch (bQ())
    {
    default: 
      localObject1 = a(5, this.li);
    }
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(String.format("%s:%d", new Object[] { localObject1, Integer.valueOf(((Integer)((Iterator)localObject2).next()).intValue()) }));
      }
      localObject1 = a(4, this.li);
      continue;
      localObject1 = a(3, this.li);
    }
    return localArrayList;
  }
  
  private void m(boolean paramBoolean)
  {
    Object localObject2 = this.lk;
    if (paramBoolean) {}
    do
    {
      for (;;)
      {
        try
        {
          locala = this.lm;
          if (locala != null) {
            break;
          }
          bM();
          return;
        }
        finally {}
        dn.a locala = this.ln;
      }
    } while (localObject1.isValid());
    bN();
  }
  
  private static ev.a r(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.lastIndexOf(":");
      } while ((i <= 0) || (i == paramString.length() - 1));
      str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    } while (!TextUtils.isDigitsOnly(paramString));
    return new ev.a(str, Integer.parseInt(paramString));
  }
  
  private static boolean s(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
        {
          paramString = paramString.split("\\.");
          if ((paramString.length >= 4) && (Integer.parseInt(paramString[0]) <= 255) && (Integer.parseInt(paramString[1]) <= 255) && (Integer.parseInt(paramString[2]) <= 255))
          {
            int i = Integer.parseInt(paramString[3]);
            if (i <= 255) {
              return true;
            }
          }
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public void a(long paramLong, int paramInt, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramJceStruct instanceof m));
      localObject = (m)paramJceStruct;
      paramJceStruct = new dn.a(System.currentTimeMillis() + 1000L * ((m)localObject).aQ, a(((m)localObject).aP, false), false);
    } while (!paramJceStruct.isValid());
    paramInt = ee.i(this.mContext);
    int i = ((m)localObject).aS;
    if (i == paramInt)
    {
      localObject = bO();
      this.li.a((String)localObject, paramJceStruct.lq, paramJceStruct.lr);
      a((String)localObject, paramJceStruct, true);
      return;
    }
    Object localObject = ae(i);
    this.li.a((String)localObject, paramJceStruct.lq, paramJceStruct.lr);
  }
  
  public void bL()
  {
    bM();
  }
  
  public String bP()
  {
    Object localObject1 = null;
    Object localObject2 = n(false);
    if (localObject2 != null)
    {
      localObject2 = ((ev.a)localObject2).df();
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() >= "http://".length())
        {
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, "http://".length()).equalsIgnoreCase("http://")) {}
        }
        else
        {
          localObject1 = "http://" + (String)localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = this.lj;
      localObject2 = "http://" + (String)localObject1;
    }
    return localObject2;
  }
  
  public ev.a n(boolean paramBoolean)
  {
    m(true);
    Object localObject3 = this.lk;
    if (paramBoolean) {}
    try
    {
      for (Object localObject1 = this.lm; localObject1 != null; localObject1 = this.ln)
      {
        localObject1 = dn.a.b((dn.a)localObject1);
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public void o(boolean paramBoolean)
  {
    m(true);
    localObject2 = this.lk;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        locala = this.lm;
        if (locala != null) {
          dn.a.c(locala);
        }
        return;
      }
      finally {}
      dn.a locala = this.ln;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dn
 * JD-Core Version:    0.7.0.1
 */