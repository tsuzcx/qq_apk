package com.tencent.android.tpush.data;

import java.io.Serializable;

public class CachedMessageIntent
  implements Serializable
{
  private static final long serialVersionUID = 1724218633838690967L;
  public String intent = "";
  public long msgId;
  public String pkgName = "";
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CachedMessageIntent))
    {
      paramObject = (CachedMessageIntent)paramObject;
      return (paramObject.pkgName.equals(this.pkgName)) && (paramObject.msgId == this.msgId);
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return "CachedMessageIntent [pkgName=" + this.pkgName + ", msgId=" + this.msgId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.CachedMessageIntent
 * JD-Core Version:    0.7.0.1
 */