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
    new StringBuilder().append("IpPlot() isTest: ").append(paramBoolean).toString();
    new StringBuilder().append("IpPlot() isTest: ").append(paramBoolean).toString();
    this.b = paramContext;
    this.c = paramBoolean;
    this.d = parame;
    l();
    e();
    h();
  }
  
  private final ArrayList a(ArrayList paramArrayList)
  {
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject = new ArrayList();
      return localObject;
    }
    int i1 = paramArrayList.size() - 1;
    for (;;)
    {
      localObject = paramArrayList;
      if (i1 <= 0) {
        break;
      }
      int i2 = (int)(i1 * Math.random());
      localObject = (String)paramArrayList.get(i1);
      paramArrayList.set(i1, paramArrayList.get(i2));
      paramArrayList.set(i2, localObject);
      i1 -= 1;
    }
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      new StringBuilder().append("printList() ").append(paramString).append(" is null").toString();
      new StringBuilder().append("printList() ").append(paramString).append(" is null").toString();
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      new StringBuilder().append("printList() ").append(paramString).append(".size <= 0").toString();
      new StringBuilder().append("printList() ").append(paramString).append(".size <= 0").toString();
      return;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    label121:
    if (i1 < i2) {
      if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i1))) {
        break label148;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label121;
      break;
      label148:
      new StringBuilder().append("printList() ").append(paramString).append("[").append(i1).append("]: ").append((String)paramArrayList.get(i1)).toString();
      new StringBuilder().append("printList() ").append(paramString).append("[").append(i1).append("]: ").append((String)paramArrayList.get(i1)).toString();
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
    switch (p())
    {
    default: 
      return;
    case 0: 
      if (paramBoolean) {}
      for (localArrayList = this.g;; localArrayList = this.m)
      {
        paramArrayList.addAll(localArrayList);
        return;
      }
    case 1: 
      if (paramBoolean) {}
      for (localArrayList = this.h;; localArrayList = this.n)
      {
        paramArrayList.addAll(localArrayList);
        return;
      }
    }
    if (paramBoolean) {}
    for (ArrayList localArrayList = this.i;; localArrayList = this.o)
    {
      paramArrayList.addAll(localArrayList);
      return;
    }
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
    if (paramArrayList == null) {}
    int i1;
    label46:
    do
    {
      return;
      i1 = p();
      if (i1 != 0)
      {
        if (!paramBoolean) {
          break;
        }
        localArrayList = this.g;
        paramArrayList.addAll(localArrayList);
      }
      if (1 != i1)
      {
        if (!paramBoolean) {
          break label85;
        }
        localArrayList = this.h;
        paramArrayList.addAll(localArrayList);
      }
    } while (2 == i1);
    if (paramBoolean) {}
    for (ArrayList localArrayList = this.i;; localArrayList = this.o)
    {
      paramArrayList.addAll(localArrayList);
      return;
      localArrayList = this.m;
      break;
      label85:
      localArrayList = this.n;
      break label46;
    }
  }
  
  private ArrayList c(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    int i1;
    do
    {
      return null;
      i1 = paramArrayList.size();
    } while (i1 <= 0);
    ArrayList localArrayList = new ArrayList();
    i1 -= 1;
    if (i1 >= 0)
    {
      String str = (String)paramArrayList.get(i1);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i1 -= 1;
        break;
        new StringBuilder().append("getHttpList() ipStr[").append(i1).append("]:").append(str).toString();
        new StringBuilder().append("getHttpList() ipStr[").append(i1).append("]:").append(str).toString();
        if (!c(str))
        {
          paramArrayList.remove(i1);
          new StringBuilder().append("getHttpList() no an ip, ipStr: ").append(str).toString();
          new StringBuilder().append("getHttpList() no an ip, ipStr: ").append(str).toString();
        }
        else
        {
          localArrayList.add("http://" + str);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean c(String paramString)
  {
    paramString = b(paramString);
    if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
    {
      paramString = paramString.split("\\.");
      if (paramString.length >= 4) {
        break label30;
      }
    }
    label30:
    while ((Integer.parseInt(paramString[0]) >= 255) || (Integer.parseInt(paramString[1]) >= 255) || (Integer.parseInt(paramString[2]) >= 255) || (Integer.parseInt(paramString[3]) >= 255)) {
      return false;
    }
    return true;
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
    if (l1 <= 0L) {}
    while (System.currentTimeMillis() <= l1) {
      return false;
    }
    return true;
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
          if (TextUtils.isEmpty((CharSequence)this.s.get(i1))) {
            break label135;
          }
          new StringBuilder().append("printWrokingIpList() mWorkingIpList[").append(i1).append("]: ").append((String)this.s.get(i1)).toString();
          new StringBuilder().append("printWrokingIpList() mWorkingIpList[").append(i1).append("]: ").append((String)this.s.get(i1)).toString();
        }
      }
      return;
      label135:
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
        return;
      }
      this.g.clear();
      this.h.clear();
      this.i.clear();
      this.p.clear();
      this.p.add("http://mazu.3g.qq.com");
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
        str1 = n();
        return str1;
      }
      if (this.r >= i1) {
        this.r = 0;
      }
      String str1 = (String)this.s.get(this.r);
      new StringBuilder().append("getIpInIpList() mCurIpIdx: ").append(this.r).append(" ip: ").append(str1).toString();
      new StringBuilder().append("getIpInIpList() mCurIpIdx: ").append(this.r).append(" ip: ").append(str1).toString();
      if (TextUtils.isEmpty(str1))
      {
        str1 = n();
        return str1;
      }
    }
    return str2;
  }
  
  private int p()
  {
    int i2 = 2;
    int i1;
    if (4 == c.a)
    {
      i1 = 1;
      if (i1 == 0) {
        break label66;
      }
      i1 = i2;
    }
    for (;;)
    {
      new StringBuilder().append("getOper() oper:").append(i1).toString();
      new StringBuilder().append("getOper() oper:").append(i1).toString();
      return i1;
      i1 = 0;
      break;
      label66:
      int i3 = g.f(this.b);
      i1 = i2;
      if (-1 != i3) {
        i1 = i3;
      }
    }
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
    new StringBuilder().append("handleNewIpList() hash: ").append(paramInt1).append(" hashSeqNo: ").append(paramInt2).append(" validperiod: ").append(paramInt3).toString();
    new StringBuilder().append("handleNewIpList() hash: ").append(paramInt1).append(" hashSeqNo: ").append(paramInt2).append(" validperiod: ").append(paramInt3).toString();
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
    new StringBuilder().append("setIsTest() isTest: ").append(paramBoolean).toString();
    new StringBuilder().append("setIsTest() isTest: ").append(paramBoolean).toString();
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
    new StringBuilder().append("getIp() ip: ").append(str).toString();
    new StringBuilder().append("getIp() ip: ").append(str).toString();
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
      new StringBuilder().append("gotoNextIp() size: ").append(this.s.size()).append(" mCurIpIdx: ").append(this.r).toString();
      new StringBuilder().append("gotoNextIp() size: ").append(this.s.size()).append(" mCurIpIdx: ").append(this.r).toString();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */