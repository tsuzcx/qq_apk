package tmsdk.common.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.c.a.c;
import tmsdk.common.d.a.b.e;
import tmsdk.common.e.g;

public class d
{
  private final String a = "IpPlot";
  private Context b;
  private boolean c = false;
  private e d;
  private final String e = "http://mazutest.3g.qq.com";
  private final String f = "http://mazu.3g.qq.com";
  private ArrayList g = new ArrayList();
  private ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();
  private volatile int j;
  private volatile int k;
  private volatile long l;
  private ArrayList m = new ArrayList();
  private ArrayList n = new ArrayList();
  private ArrayList o = new ArrayList();
  private ArrayList p = new ArrayList();
  private Object q = new Object();
  private int r = 0;
  private ArrayList s = new ArrayList();
  private String t = null;
  
  public d(Context paramContext, boolean paramBoolean, e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IpPlot() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("IpPlot() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    this.b = paramContext;
    this.c = paramBoolean;
    this.d = parame;
    l();
    e();
    h();
  }
  
  private final ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i1 = paramArrayList.size() - 1;
      while (i1 > 0)
      {
        double d1 = i1;
        double d2 = Math.random();
        Double.isNaN(d1);
        int i2 = (int)(d1 * d2);
        String str = (String)paramArrayList.get(i1);
        paramArrayList.set(i1, paramArrayList.get(i2));
        paramArrayList.set(i2, str);
        i1 -= 1;
      }
      return paramArrayList;
    }
    return new ArrayList();
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(" is null");
      paramArrayList.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(" is null");
      paramArrayList.toString();
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(".size <= 0");
      paramArrayList.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("printList() ");
      paramArrayList.append(paramString);
      paramArrayList.append(".size <= 0");
      paramArrayList.toString();
      return;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printList() ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]: ");
        localStringBuilder.append((String)paramArrayList.get(i1));
        localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("printList() ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]: ");
        localStringBuilder.append((String)paramArrayList.get(i1));
        localStringBuilder.toString();
      }
      i1 += 1;
    }
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if (paramArrayList1 != null) {
      this.m = a(c(paramArrayList1));
    }
    if (paramArrayList2 != null) {
      this.n = a(c(paramArrayList2));
    }
    if (paramArrayList3 != null) {
      this.o = a(c(paramArrayList3));
    }
  }
  
  private void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ArrayList localArrayList;
    switch (p())
    {
    default: 
      return;
    case 2: 
      if (paramBoolean) {
        localArrayList = this.i;
      } else {
        localArrayList = this.o;
      }
      paramArrayList.addAll(localArrayList);
      return;
    case 1: 
      if (paramBoolean) {
        localArrayList = this.h;
      } else {
        localArrayList = this.n;
      }
      paramArrayList.addAll(localArrayList);
      return;
    }
    if (paramBoolean) {
      localArrayList = this.g;
    } else {
      localArrayList = this.m;
    }
    paramArrayList.addAll(localArrayList);
  }
  
  private String b(String paramString)
  {
    String str;
    for (;;)
    {
      str = paramString;
      if (!paramString.startsWith(" ")) {
        break;
      }
      paramString = paramString.substring(1, paramString.length()).trim();
    }
    while (str.endsWith(" ")) {
      str = str.substring(0, str.length() - 1).trim();
    }
    return str;
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList.addAll(this.p);
  }
  
  private void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i1 = p();
    ArrayList localArrayList;
    if (i1 != 0)
    {
      if (paramBoolean) {
        localArrayList = this.g;
      } else {
        localArrayList = this.m;
      }
      paramArrayList.addAll(localArrayList);
    }
    if (1 != i1)
    {
      if (paramBoolean) {
        localArrayList = this.h;
      } else {
        localArrayList = this.n;
      }
      paramArrayList.addAll(localArrayList);
    }
    if (2 != i1)
    {
      if (paramBoolean) {
        localArrayList = this.i;
      } else {
        localArrayList = this.o;
      }
      paramArrayList.addAll(localArrayList);
    }
  }
  
  private ArrayList c(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i1 = paramArrayList.size();
    if (i1 <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    i1 -= 1;
    while (i1 >= 0)
    {
      String str = (String)paramArrayList.get(i1);
      if (!TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHttpList() ipStr[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]:");
        localStringBuilder.append(str);
        localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHttpList() ipStr[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]:");
        localStringBuilder.append(str);
        localStringBuilder.toString();
        if (!c(str))
        {
          paramArrayList.remove(i1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHttpList() no an ip, ipStr: ");
          localStringBuilder.append(str);
          localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHttpList() no an ip, ipStr: ");
          localStringBuilder.append(str);
          localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(str);
          localArrayList.add(localStringBuilder.toString());
        }
      }
      i1 -= 1;
    }
    return localArrayList;
  }
  
  private boolean c(String paramString)
  {
    paramString = b(paramString);
    if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
    {
      paramString = paramString.split("\\.");
      if (paramString.length < 4) {
        return false;
      }
      if ((Integer.parseInt(paramString[0]) < 255) && (Integer.parseInt(paramString[1]) < 255) && (Integer.parseInt(paramString[2]) < 255) && (Integer.parseInt(paramString[3]) < 255)) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    AtomicLong localAtomicLong = new AtomicLong();
    AtomicReference localAtomicReference1 = new AtomicReference();
    AtomicReference localAtomicReference2 = new AtomicReference();
    AtomicReference localAtomicReference3 = new AtomicReference();
    this.d.a(localAtomicLong, localAtomicReference1, localAtomicReference2, localAtomicReference3);
    synchronized (this.q)
    {
      if (localAtomicLong.get() > 0L) {
        this.l = localAtomicLong.get();
      }
      this.j = this.d.c();
      this.k = this.d.b();
      a((ArrayList)localAtomicReference1.get(), (ArrayList)localAtomicReference2.get(), (ArrayList)localAtomicReference3.get());
      return;
    }
  }
  
  private long f()
  {
    synchronized (this.q)
    {
      long l1 = this.l;
      return l1;
    }
  }
  
  private boolean g()
  {
    long l1 = f();
    boolean bool = false;
    if (l1 <= 0L) {
      return false;
    }
    if (System.currentTimeMillis() > l1) {
      bool = true;
    }
    return bool;
  }
  
  private void h()
  {
    synchronized (this.q)
    {
      if (this.s == null) {
        return;
      }
      if (m()) {
        return;
      }
      j();
      a(false, this.s);
      b(this.s);
      b(false, this.s);
      i();
      if (this.s.size() <= this.p.size())
      {
        k();
        i();
      }
      return;
    }
  }
  
  private void i()
  {
    for (;;)
    {
      int i1;
      synchronized (this.q)
      {
        int i2 = this.s.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (!TextUtils.isEmpty((CharSequence)this.s.get(i1)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("printWrokingIpList() mWorkingIpList[");
            localStringBuilder.append(i1);
            localStringBuilder.append("]: ");
            localStringBuilder.append((String)this.s.get(i1));
            localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("printWrokingIpList() mWorkingIpList[");
            localStringBuilder.append(i1);
            localStringBuilder.append("]: ");
            localStringBuilder.append((String)this.s.get(i1));
            localStringBuilder.toString();
          }
        }
        else {
          return;
        }
      }
      i1 += 1;
    }
  }
  
  private void j()
  {
    synchronized (this.q)
    {
      this.r = 0;
      this.s.clear();
      return;
    }
  }
  
  private void k()
  {
    synchronized (this.q)
    {
      j();
      a(true, this.s);
      b(this.s);
      b(true, this.s);
      i();
      this.l = 0L;
      this.d.a(0L, new ArrayList(), new ArrayList(), new ArrayList());
      return;
    }
  }
  
  private void l()
  {
    synchronized (this.q)
    {
      if (this.c)
      {
        this.g.clear();
        this.h.clear();
        this.p.clear();
        this.p.clear();
        this.p.add("http://mazutest.3g.qq.com");
      }
      else
      {
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.p.clear();
        this.p.add("http://mazu.3g.qq.com");
      }
      return;
    }
  }
  
  private boolean m()
  {
    boolean bool = g();
    if (bool) {
      k();
    }
    return bool;
  }
  
  private String n()
  {
    if (this.c) {
      return "http://mazutest.3g.qq.com";
    }
    return "http://mazu.3g.qq.com";
  }
  
  private String o()
  {
    synchronized (this.s)
    {
      int i1 = this.s.size();
      if (i1 <= 0)
      {
        str = n();
        return str;
      }
      if (this.r >= i1) {
        this.r = 0;
      }
      String str = (String)this.s.get(this.r);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpInIpList() mCurIpIdx: ");
      localStringBuilder.append(this.r);
      localStringBuilder.append(" ip: ");
      localStringBuilder.append(str);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpInIpList() mCurIpIdx: ");
      localStringBuilder.append(this.r);
      localStringBuilder.append(" ip: ");
      localStringBuilder.append(str);
      localStringBuilder.toString();
      if (TextUtils.isEmpty(str))
      {
        str = n();
        return str;
      }
      return str;
    }
  }
  
  private int p()
  {
    int i1;
    if (4 == c.a) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = 2;
    if (i1 != 0)
    {
      i1 = i2;
    }
    else
    {
      i1 = g.f(this.b);
      if (-1 == i1) {
        i1 = i2;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOper() oper:");
    localStringBuilder.append(i1);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOper() oper:");
    localStringBuilder.append(i1);
    localStringBuilder.toString();
    return i1;
  }
  
  public int a()
  {
    return this.j;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.q)
    {
      this.j = paramInt1;
      this.k = paramInt2;
      this.d.a(paramInt1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("handleNewIpList() hash: ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(" hashSeqNo: ");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append(" validperiod: ");
    ((StringBuilder)???).append(paramInt3);
    ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("handleNewIpList() hash: ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(" hashSeqNo: ");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append(" validperiod: ");
    ((StringBuilder)???).append(paramInt3);
    ((StringBuilder)???).toString();
    a("cmvips", paramArrayList1);
    a("unvips", paramArrayList2);
    a("ctvips", paramArrayList3);
    synchronized (this.q)
    {
      a(paramInt1, paramInt2);
      a(paramArrayList1, paramArrayList2, paramArrayList3);
      this.l = (System.currentTimeMillis() + paramInt3 * 1000);
      this.d.a(this.l, paramArrayList1, paramArrayList2, paramArrayList3);
      h();
      return;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.q)
    {
      this.t = paramString;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsTest() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsTest() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    this.c = paramBoolean;
    l();
    h();
  }
  
  public int b()
  {
    return this.k;
  }
  
  public String c()
  {
    m();
    String str = o();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIp() ip: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIp() ip: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public void d()
  {
    synchronized (this.s)
    {
      this.r += 1;
      if (this.r >= this.s.size()) {
        this.r = 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoNextIp() size: ");
      localStringBuilder.append(this.s.size());
      localStringBuilder.append(" mCurIpIdx: ");
      localStringBuilder.append(this.r);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoNextIp() size: ");
      localStringBuilder.append(this.s.size());
      localStringBuilder.append(" mCurIpIdx: ");
      localStringBuilder.append(this.r);
      localStringBuilder.toString();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */