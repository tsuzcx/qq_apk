package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FilterItem
  implements Serializable
{
  public static final int TYPE_BLACK = 5;
  public static final int TYPE_COLD = 4;
  public static final int TYPE_FAST = 0;
  public static final int TYPE_LITTLE_FAST = 11;
  public static final int TYPE_LOCATION = 7;
  public static final int TYPE_LOMO = 3;
  public static final int TYPE_NONE = -1;
  public static final int TYPE_PICTURE = 10;
  public static final int TYPE_REVERT = 2;
  public static final int TYPE_SLOW = 1;
  public static final int TYPE_SPEED = 8;
  public static final int TYPE_TEMP = 9;
  public static final int TYPE_TIME = 6;
  public static final int TYPE_VERY_SLOW = 12;
  public final String filterConfigMd5;
  public final String filterConfigUrl;
  public final long filterId;
  @NonNull
  public final String filterName;
  public final int filterType;
  
  private FilterItem(long paramLong, @NonNull String paramString1, int paramInt, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      throw new IllegalArgumentException("illegal filter type : " + paramInt + " from id : " + paramLong);
    case 10: 
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
        throw new IllegalArgumentException("can not find url or md5 : type=" + paramInt + ", url=" + paramString2 + ", md5=" + paramString3 + " from id : " + paramLong);
      }
      break;
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("filter name should not be empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("filter id should not less than zero : " + paramLong);
    }
    this.filterId = paramLong;
    this.filterName = paramString1;
    this.filterType = paramInt;
    this.filterConfigUrl = paramString2;
    this.filterConfigMd5 = paramString3;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("proxy required");
  }
  
  private Object writeReplace()
  {
    return new SerializationProxy(this, null);
  }
  
  public boolean isLocalType()
  {
    switch (this.filterType)
    {
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "FilterItem{id=" + this.filterId + ", name='" + this.filterName + '\'' + ", type=" + this.filterType + ", url='" + this.filterConfigUrl + '\'' + ", md5='" + this.filterConfigMd5 + '\'' + '}';
  }
  
  public static class FilterItemIllegalException
    extends Exception
  {
    public FilterItemIllegalException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static class SerializationProxy
    implements Serializable
  {
    private static final long serialVersionUID = 2L;
    public final String filterConfigMd5;
    public final String filterConfigUrl;
    public final long filterId;
    @NonNull
    public final String filterName;
    public final int filterType;
    
    private SerializationProxy(@NonNull FilterItem paramFilterItem)
    {
      this.filterId = paramFilterItem.filterId;
      this.filterName = paramFilterItem.filterName;
      this.filterType = paramFilterItem.filterType;
      this.filterConfigUrl = paramFilterItem.filterConfigUrl;
      this.filterConfigMd5 = paramFilterItem.filterConfigMd5;
    }
    
    private Object readResolve()
    {
      return new FilterItem(this.filterId, this.filterName, this.filterType, this.filterConfigUrl, this.filterConfigMd5, null);
    }
  }
  
  public static class a
  {
    public String filterConfigMd5;
    public String filterConfigUrl;
    public long filterId;
    public String filterName;
    public int filterType;
    
    public FilterItem a()
      throws FilterItem.FilterItemIllegalException
    {
      try
      {
        FilterItem localFilterItem = new FilterItem(this.filterId, this.filterName, this.filterType, this.filterConfigUrl, this.filterConfigMd5, null);
        return localFilterItem;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new FilterItem.FilterItemIllegalException("create FilterItem instance failed", localIllegalArgumentException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.FilterItem
 * JD-Core Version:    0.7.0.1
 */