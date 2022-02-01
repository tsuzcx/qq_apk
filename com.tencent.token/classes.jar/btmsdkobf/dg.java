package btmsdkobf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class dg
{
  private static cc<Integer, dg> mw = new cc(50);
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
    if (paramdg == null) {
      return;
    }
    try
    {
      paramdg.mu = System.currentTimeMillis();
      mw.put(Integer.valueOf(paramInt), paramdg);
      return;
    }
    finally
    {
      paramdg = finally;
      throw paramdg;
    }
  }
  
  private HashMap<String, String> cr()
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mr);
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append(";");
    this.mr = localStringBuilder.toString();
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
  
  public void f(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|ip|");
    localStringBuilder2.append(this.mi);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|port|");
    localStringBuilder2.append(this.mj);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|tryTimes|");
    localStringBuilder2.append(this.mk);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|apn|");
    localStringBuilder2.append(this.ml);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|requestType|");
    localStringBuilder2.append(this.mm);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|requestTime|");
    localStringBuilder2.append(this.mn);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|errorCode|");
    localStringBuilder2.append(this.errorCode);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|cmdids|");
    localStringBuilder2.append(this.mr);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|iplist|");
    localStringBuilder2.append(this.mq);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|lastRequest|");
    localStringBuilder2.append(this.mp);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|errorDetail|");
    localStringBuilder2.append(this.mo);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|isDetect|");
    localStringBuilder2.append(this.ms);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("|isConnect|");
    localStringBuilder2.append(this.mt);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dg
 * JD-Core Version:    0.7.0.1
 */