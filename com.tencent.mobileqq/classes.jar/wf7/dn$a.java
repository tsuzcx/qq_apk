package wf7;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class dn$a
{
  public long lq;
  public List<String> lr = new ArrayList();
  public boolean ls = false;
  private int lt = 0;
  
  public dn$a(long paramLong, List<String> paramList, boolean paramBoolean)
  {
    this.lq = paramLong;
    if (paramList != null) {
      this.lr.addAll(paramList);
    }
    this.ls = paramBoolean;
  }
  
  private a bR()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = this.lr.iterator();
    while (localIterator.hasNext())
    {
      String str = u((String)localIterator.next());
      if (str != null) {
        localLinkedHashSet.add(str);
      }
    }
    return new a(this.lq, new ArrayList(localLinkedHashSet), this.ls);
  }
  
  private ev.a bS()
  {
    if (this.lt >= this.lr.size()) {
      this.lt = 0;
    }
    return dn.t((String)this.lr.get(this.lt));
  }
  
  private void bT()
  {
    this.lt += 1;
    if (this.lt >= this.lr.size()) {
      this.lt = 0;
    }
  }
  
  private void p(List<String> paramList)
  {
    int i = this.lr.size();
    if (i >= 2)
    {
      this.lr.addAll(i - 1, dn.a(paramList, true));
      return;
    }
    this.lr.addAll(dn.a(paramList, true));
  }
  
  private static String u(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = null;
      return str;
    }
    int i = paramString.lastIndexOf(":");
    if (i >= 0) {}
    for (paramString = paramString.substring(0, i) + ":80";; paramString = paramString + ":80")
    {
      if (paramString.length() >= "http://".length())
      {
        str = paramString;
        if (paramString.substring(0, "http://".length()).equalsIgnoreCase("http://")) {
          break;
        }
      }
      return "http://" + paramString;
    }
  }
  
  public boolean isValid()
  {
    return ((this.ls) || (System.currentTimeMillis() <= this.lq)) && (this.lr.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|mValidTimeMills=").append(this.lq).append("|mIsDefault=").append(this.ls).append("|mIPPortList=").append(this.lr);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.dn.a
 * JD-Core Version:    0.7.0.1
 */