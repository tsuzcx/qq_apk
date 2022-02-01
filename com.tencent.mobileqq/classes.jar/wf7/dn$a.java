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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf(":");
    Object localObject;
    if (i >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, i));
      ((StringBuilder)localObject).append(":80");
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":80");
      paramString = ((StringBuilder)localObject).toString();
    }
    if (paramString.length() >= 7)
    {
      localObject = paramString;
      if (paramString.substring(0, 7).equalsIgnoreCase("http://")) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public boolean isValid()
  {
    return ((this.ls) || (System.currentTimeMillis() <= this.lq)) && (this.lr.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|mValidTimeMills=");
    localStringBuilder.append(this.lq);
    localStringBuilder.append("|mIsDefault=");
    localStringBuilder.append(this.ls);
    localStringBuilder.append("|mIPPortList=");
    localStringBuilder.append(this.lr);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.dn.a
 * JD-Core Version:    0.7.0.1
 */