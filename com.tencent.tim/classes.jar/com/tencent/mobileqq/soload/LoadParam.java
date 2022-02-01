package com.tencent.mobileqq.soload;

import aagd;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadParam
  implements Serializable
{
  public static int CALL_TYPE_ASYNC;
  public static int CALL_TYPE_ASYNC_BY_SYNC = 2;
  public static int CALL_TYPE_SYNC = 1;
  public int mCallType = CALL_TYPE_ASYNC;
  public List<LoadItem> mLoadItems = new LinkedList();
  public long mReportSeq = 0L;
  
  public static int getItemSize(LoadParam paramLoadParam)
  {
    if ((paramLoadParam == null) || (paramLoadParam.mLoadItems == null)) {
      return 0;
    }
    return paramLoadParam.mLoadItems.size();
  }
  
  public static String getReportStr(LoadParam paramLoadParam)
  {
    if ((paramLoadParam == null) || (paramLoadParam.mLoadItems == null) || (paramLoadParam.mLoadItems.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramLoadParam = paramLoadParam.mLoadItems.iterator();
    int i = 1;
    if (paramLoadParam.hasNext())
    {
      LoadItem localLoadItem = (LoadItem)paramLoadParam.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localLoadItem.name);
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isValid(LoadParam paramLoadParam)
  {
    return (paramLoadParam != null) && (paramLoadParam.isValid());
  }
  
  public boolean isSame(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {}
    while ((this.mCallType != paramLoadParam.mCallType) || (paramLoadParam.mLoadItems.size() != this.mLoadItems.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramLoadParam.mLoadItems.size()) {
        break label94;
      }
      LoadItem localLoadItem = (LoadItem)paramLoadParam.mLoadItems.get(i);
      if (!((LoadItem)this.mLoadItems.get(i)).isSame(localLoadItem)) {
        break;
      }
      i += 1;
    }
    label94:
    return true;
  }
  
  boolean isValid()
  {
    if ((this.mLoadItems == null) || (this.mLoadItems.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      LoadItem localLoadItem = (LoadItem)localIterator.next();
      if ((localLoadItem == null) || (TextUtils.isEmpty(localLoadItem.name)) || (localLoadItem.lops == null)) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadParam{mCallType=" + this.mCallType + "mLoadItems=" + this.mLoadItems + '}';
  }
  
  public static class LoadItem
    implements Serializable
  {
    public LoadOptions lops;
    public String name;
    public String soFileName;
    
    public LoadItem(String paramString)
    {
      this(paramString, null);
    }
    
    public LoadItem(String paramString, LoadOptions paramLoadOptions)
    {
      this.name = paramString;
      this.soFileName = ("lib" + paramString + ".so");
      if (paramLoadOptions != null)
      {
        this.lops = paramLoadOptions;
        return;
      }
      this.lops = new LoadOptions.a().a();
    }
    
    public boolean isSame(LoadItem paramLoadItem)
    {
      if (!aagd.j(paramLoadItem.name, this.name)) {
        return false;
      }
      return this.lops.isSame(paramLoadItem.lops);
    }
    
    public String toString()
    {
      return "LoadItem{name='" + this.name + '\'' + ", lops=" + this.lops + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadParam
 * JD-Core Version:    0.7.0.1
 */