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
  private static dn lg;
  private static dn.a lo;
  private static dn.a lp;
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
    if (this.lh)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.lj = paramString;
      } else {
        this.lj = "mazutest.3g.qq.com";
      }
    }
    else if (this.li.co() == 1) {
      this.lj = "mazu-hk.3g.qq.com";
    } else {
      this.lj = a(1, paramdt);
    }
    bM();
    a(this);
  }
  
  private static String a(int paramInt, dt paramdt)
  {
    paramdt = paramdt.cp();
    if (paramdt != null) {
      paramdt = (String)paramdt.get(paramInt);
    } else {
      paramdt = null;
    }
    Object localObject = paramdt;
    if (TextUtils.isEmpty(paramdt))
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          break label69;
        }
        if (paramInt == 3) {
          break label66;
        }
        if (paramInt == 4) {
          break label63;
        }
        if (paramInt == 5) {}
      }
      else
      {
        return "mazu.3g.qq.com";
      }
      return "120.198.203.156";
      label63:
      return "163.177.71.153";
      label66:
      return "183.232.125.162";
      label69:
      localObject = "mazuburst.3g.qq.com";
    }
    return localObject;
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
    if ((paramString != null) && (??? != null))
    {
      if (!???.isValid()) {
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
  }
  
  public static void a(dn paramdn)
  {
    lg = paramdn;
  }
  
  private String ae(int paramInt)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    Object localObject1;
    if (this.lh) {
      localObject1 = "t_";
    } else {
      localObject1 = "r_";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramInt == 1)
    {
      if (fj.dJ())
      {
        localObject1 = fj.getSSID();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wifi_");
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localObject1 = "wifi_nonessid";
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apn_");
      ((StringBuilder)localObject1).append(paramInt);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  private static boolean b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = paramString.lastIndexOf(":");
    if (i > 0)
    {
      if (i == paramString.length() - 1) {
        return false;
      }
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      if (((paramBoolean) || (s(str))) && (TextUtils.isDigitsOnly(paramString))) {
        return true;
      }
    }
    return false;
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
      bN();
      return;
    }
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    Object localObject1;
    if (this.lh) {
      localObject1 = "t_";
    } else {
      localObject1 = "r_";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = ee.i(this.mContext);
    if (i == 1)
    {
      localObject1 = fj.getSSID();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wifi_");
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("apn_");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  private int bQ()
  {
    if (4 == fh.pO) {
      return 2;
    }
    int i = fg.l(this.mContext);
    if (-1 == i) {
      return 2;
    }
    return i;
  }
  
  private dn.a j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = lo;
      if (localObject != null) {
        return localObject;
      }
    }
    if (!paramBoolean)
    {
      localObject = lp;
      if (localObject != null) {
        return localObject;
      }
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
    } else {
      ((List)localObject).add(Integer.valueOf(80));
    }
    String str = this.lj;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(String.format("%s:%d", new Object[] { str, Integer.valueOf(((Integer)((Iterator)localObject).next()).intValue()) }));
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
    } else {
      ((List)localObject2).add(Integer.valueOf(80));
    }
    Object localObject1;
    if (this.li.co() == 1)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.143.147", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.46", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.45", Integer.valueOf(i) }));
      }
    }
    int i = bQ();
    if (i != 0)
    {
      if (i != 1) {
        localObject1 = a(5, this.li);
      } else {
        localObject1 = a(4, this.li);
      }
    }
    else {
      localObject1 = a(3, this.li);
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(String.format("%s:%d", new Object[] { localObject1, Integer.valueOf(((Integer)((Iterator)localObject2).next()).intValue()) }));
    }
    return localArrayList;
  }
  
  private void m(boolean paramBoolean)
  {
    Object localObject2 = this.lk;
    if (paramBoolean) {}
    try
    {
      dn.a locala = this.lm;
      break label24;
      locala = this.ln;
      label24:
      if (locala == null)
      {
        bM();
        return;
      }
      if (!locala.isValid()) {
        bN();
      }
      return;
    }
    finally {}
  }
  
  private static ev.a r(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf(":");
    if (i > 0)
    {
      if (i == paramString.length() - 1) {
        return null;
      }
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      if (TextUtils.isDigitsOnly(paramString)) {
        return new ev.a(str, Integer.parseInt(paramString));
      }
    }
    return null;
  }
  
  private static boolean s(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
      {
        paramString = paramString.split("\\.");
        if (paramString.length < 4) {
          return false;
        }
        if ((Integer.parseInt(paramString[0]) <= 255) && (Integer.parseInt(paramString[1]) <= 255) && (Integer.parseInt(paramString[2]) <= 255))
        {
          int i = Integer.parseInt(paramString[3]);
          if (i <= 255) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void a(long paramLong, int paramInt, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return;
    }
    if (!(paramJceStruct instanceof m)) {
      return;
    }
    Object localObject = (m)paramJceStruct;
    paramJceStruct = new dn.a(System.currentTimeMillis() + ((m)localObject).aQ * 1000L, a(((m)localObject).aP, false), false);
    if (!paramJceStruct.isValid()) {
      return;
    }
    paramInt = ee.i(this.mContext);
    int i = ((m)localObject).aS;
    if (i == paramInt)
    {
      localObject = bO();
      this.li.a((String)localObject, paramJceStruct.lq, paramJceStruct.lr);
      a((String)localObject, paramJceStruct, true);
      return;
    }
    localObject = ae(i);
    this.li.a((String)localObject, paramJceStruct.lq, paramJceStruct.lr);
  }
  
  public void bL()
  {
    bM();
  }
  
  public String bP()
  {
    Object localObject1 = n(false);
    if (localObject1 != null)
    {
      localObject2 = ((ev.a)localObject1).df();
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() >= 7)
        {
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, 7).equalsIgnoreCase("http://")) {}
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("http://");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = this.lj;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("http://");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
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
      Object localObject1 = this.lm;
      break label29;
      localObject1 = this.ln;
      label29:
      if (localObject1 != null)
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
    Object localObject2 = this.lk;
    if (paramBoolean) {}
    try
    {
      dn.a locala = this.lm;
      break label29;
      locala = this.ln;
      label29:
      if (locala != null) {
        dn.a.c(locala);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dn
 * JD-Core Version:    0.7.0.1
 */