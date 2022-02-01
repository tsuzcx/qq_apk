package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="keyword")
public class EmoticonKeywords
  extends Entity
{
  public String keyword;
  public long lastReqTime;
  
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
      } while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof EmoticonKeywords)));
      paramObject = (EmoticonKeywords)paramObject;
    } while (!this.keyword.equals(paramObject.keyword));
    return true;
  }
  
  public int hashCode()
  {
    return this.keyword.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoticonKeywords").append("{").append("keyword = ").append(this.keyword).append(",lastReqTime = ").append(this.lastReqTime).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonKeywords
 * JD-Core Version:    0.7.0.1
 */