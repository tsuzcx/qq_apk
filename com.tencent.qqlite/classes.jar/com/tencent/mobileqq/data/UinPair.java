package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="userUin,friendUin")
public class UinPair
  extends Entity
{
  public String friendUin;
  public String userUin;
  
  public UinPair() {}
  
  public UinPair(String paramString1, String paramString2)
  {
    this.userUin = paramString1;
    this.friendUin = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UinPair)) {
        break label123;
      }
      if (this.userUin == null)
      {
        if (((UinPair)paramObject).userUin != null) {
          break label123;
        }
        if (this.friendUin == null)
        {
          if (((UinPair)paramObject).friendUin == null) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
        return this.friendUin.equals(((UinPair)paramObject).friendUin);
      }
      if (!this.userUin.equals(((UinPair)paramObject).userUin)) {
        break label123;
      }
      if (this.friendUin != null) {
        break;
      }
    } while (((UinPair)paramObject).friendUin == null);
    return false;
    return this.friendUin.equals(((UinPair)paramObject).friendUin);
    label123:
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.UinPair
 * JD-Core Version:    0.7.0.1
 */