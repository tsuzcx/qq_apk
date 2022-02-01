package com.tencent.mobileqq.data;

import afcf;
import afcj;
import afck;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.List;

public class DatingInfo
  extends Entity
{
  @notColumn
  private static final int FLAG_MASK_COMMENT_NEW_OVER = 32;
  @notColumn
  private static final int FLAG_MASK_STRANGER_NEW_OVER = 8;
  @notColumn
  private static final int FLAG_MASK_VISIT_NEW_OVER = 2;
  @notColumn
  public static final int TYPE_COMMENT = 1;
  @notColumn
  private List<afcf> commentList = new ArrayList(20);
  public String commentPacked;
  @unique
  public String datingId;
  public int datingSubject;
  public long datingTime;
  @notColumn
  public boolean isInit;
  @notColumn
  public long lastUpdateTime;
  @notColumn
  private int nPrivateFlag;
  public int owner;
  @notColumn
  public String strDatingTime;
  @notColumn
  private List<afcj> strangerInfos = new ArrayList(20);
  public String strangerInfosPacked;
  @notColumn
  private List<afcj> visitorInfos = new ArrayList(20);
  public String visitorInfosPacked;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (DatingInfo)paramObject;
    } while (((this.datingId != null) || (paramObject.datingId != null)) && ((this.datingId == null) || (!this.datingId.equals(paramObject.datingId))));
    return true;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.datingId)) {
      return "".hashCode();
    }
    return this.datingId.hashCode();
  }
  
  public void init()
  {
    if (this.datingTime == 0L) {}
    for (this.strDatingTime = "";; this.strDatingTime = afck.a(this.datingTime, this.datingSubject, false))
    {
      afcj.x(this.visitorInfos, this.visitorInfosPacked);
      this.nPrivateFlag |= 0x2;
      afcf.x(this.commentList, this.commentPacked);
      this.nPrivateFlag |= 0x20;
      afcj.x(this.strangerInfos, this.strangerInfosPacked);
      this.nPrivateFlag |= 0x8;
      return;
    }
  }
  
  public boolean isDefaultValue()
  {
    boolean bool = false;
    if ((this.datingSubject == 0) || (this.datingTime == 0L)) {
      bool = true;
    }
    return bool;
  }
  
  public void prewrite()
  {
    for (;;)
    {
      synchronized (this.strangerInfos)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.strangerInfosPacked = afcj.pack(this.strangerInfos);
          synchronized (this.visitorInfos)
          {
            if ((this.nPrivateFlag & 0x2) == 2) {
              this.visitorInfosPacked = afcj.pack(this.visitorInfos);
            }
          }
        }
      }
      synchronized (this.commentList)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.commentPacked = afcf.pack(this.commentList);
          return;
          this.strangerInfosPacked = "";
          continue;
          localObject1 = finally;
          throw localObject1;
          this.visitorInfosPacked = "";
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        this.commentPacked = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingInfo
 * JD-Core Version:    0.7.0.1
 */