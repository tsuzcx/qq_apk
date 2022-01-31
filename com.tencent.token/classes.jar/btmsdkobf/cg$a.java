package btmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class cg$a
{
  public long hZ;
  public List ia = new ArrayList();
  public boolean ib = false;
  private int ic = 0;
  
  public cg$a(long paramLong, List paramList, boolean paramBoolean)
  {
    this.hZ = paramLong;
    if (paramList != null) {
      this.ia.addAll(paramList);
    }
    this.ib = paramBoolean;
  }
  
  private void a(List paramList)
  {
    int i = this.ia.size();
    if (i >= 2)
    {
      this.ia.addAll(i - 1, cg.a(paramList, true));
      return;
    }
    this.ia.addAll(cg.a(paramList, true));
  }
  
  private a bi()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = this.ia.iterator();
    while (localIterator.hasNext())
    {
      String str = w((String)localIterator.next());
      if (str != null) {
        localLinkedHashSet.add(str);
      }
    }
    return new a(this.hZ, new ArrayList(localLinkedHashSet), this.ib);
  }
  
  private dq.b bj()
  {
    if (this.ic >= this.ia.size()) {
      this.ic = 0;
    }
    return cg.v((String)this.ia.get(this.ic));
  }
  
  private void bk()
  {
    this.ic += 1;
    if (this.ic >= this.ia.size()) {
      this.ic = 0;
    }
  }
  
  private void bl()
  {
    this.ic = 0;
  }
  
  private static String w(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = null;
      return str;
    }
    int i = paramString.lastIndexOf(":");
    if (i >= 0) {}
    for (paramString = paramString.substring(0, i) + ":80";; paramString = str)
    {
      if (paramString.length() >= "http://".length())
      {
        str = paramString;
        if (paramString.substring(0, "http://".length()).equalsIgnoreCase("http://")) {
          break;
        }
      }
      return "http://" + paramString;
      str = paramString + ":80";
      eh.h("HIPList", "conv2HttpIPPort(): invalid ipPort(missing port): " + paramString);
    }
  }
  
  public boolean isValid()
  {
    return ((this.ib) || (System.currentTimeMillis() <= this.hZ)) && (this.ia.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|mValidTimeMills=").append(this.hZ).append("|mIsDefault=").append(this.ib).append("|mIPPortList=").append(this.ia);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cg.a
 * JD-Core Version:    0.7.0.1
 */