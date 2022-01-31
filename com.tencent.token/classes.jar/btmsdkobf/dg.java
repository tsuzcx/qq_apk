package btmsdkobf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class dg
{
  private static cc mw = new cc(50);
  public int errorCode = 0;
  public String mi = "";
  public String mj = "";
  public int mk = 0;
  public String ml = "";
  private String mm = "";
  public long mn = -1L;
  public String mo = "";
  public String mp = "";
  public String mq = "";
  public String mr = "";
  public boolean ms = false;
  public boolean mt = false;
  private long mu = 0L;
  private long mv = 0L;
  
  public static dg J(int paramInt)
  {
    try
    {
      dg localdg = (dg)mw.get(Integer.valueOf(paramInt));
      if (localdg != null) {
        localdg.mv = System.currentTimeMillis();
      }
      mw.a(Integer.valueOf(paramInt));
      return localdg;
    }
    finally {}
  }
  
  public static void a(dg paramdg, int paramInt)
  {
    if (paramdg == null) {}
    for (;;)
    {
      return;
      try
      {
        paramdg.mu = System.currentTimeMillis();
        mw.put(Integer.valueOf(paramInt), paramdg);
      }
      finally {}
    }
  }
  
  private HashMap cr()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("B4", this.ml);
    localHashMap.put("B20", this.mr);
    localHashMap.put("B7", String.valueOf(this.errorCode));
    localHashMap.put("B8", this.mo);
    localHashMap.put("B10", this.mq);
    localHashMap.put("B9", this.mp);
    localHashMap.put("B6", String.valueOf(this.mn));
    localHashMap.put("B5", this.mm);
    localHashMap.put("B3", this.mi);
    localHashMap.put("B11", this.mj);
    localHashMap.put("B12", String.valueOf(this.mk));
    localHashMap.put("B21", String.valueOf(this.ms));
    localHashMap.put("B22", String.valueOf(this.mt));
    return localHashMap;
  }
  
  public void I(int paramInt)
  {
    this.mr = (this.mr + String.valueOf(paramInt) + ";");
  }
  
  public void d(cl paramcl)
  {
    if (paramcl == null) {
      return;
    }
    this.mm = "1";
    eh.f("TcpInfoUpload", toString());
    paramcl.a(cr());
  }
  
  public void e(cl paramcl) {}
  
  public void f(cl paramcl) {}
  
  public void f(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (str != null)
        {
          localStringBuilder.append(str);
          localStringBuilder.append(";");
        }
      }
    }
  }
  
  public void g(cl paramcl) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|ip|" + this.mi);
    localStringBuilder.append("|port|" + this.mj);
    localStringBuilder.append("|tryTimes|" + this.mk);
    localStringBuilder.append("|apn|" + this.ml);
    localStringBuilder.append("|requestType|" + this.mm);
    localStringBuilder.append("|requestTime|" + this.mn);
    localStringBuilder.append("|errorCode|" + this.errorCode);
    localStringBuilder.append("|cmdids|" + this.mr);
    localStringBuilder.append("|iplist|" + this.mq);
    localStringBuilder.append("|lastRequest|" + this.mp);
    localStringBuilder.append("|errorDetail|" + this.mo);
    localStringBuilder.append("|isDetect|" + this.ms);
    localStringBuilder.append("|isConnect|" + this.mt);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dg
 * JD-Core Version:    0.7.0.1
 */