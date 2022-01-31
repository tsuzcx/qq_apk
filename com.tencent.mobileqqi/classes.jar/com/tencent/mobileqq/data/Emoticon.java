package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId")
public class Emoticon
  extends Entity
{
  public static final int JOB_MAGIC = 2;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 1;
  public String eId;
  public String encryptKey;
  public String epId;
  public int height;
  public boolean isSound;
  public int jobType;
  public String keyword;
  public String keywords;
  public String magicValue;
  public String name;
  public boolean value;
  public int width;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Emoticon))) {}
    do
    {
      return false;
      paramObject = (Emoticon)paramObject;
    } while ((paramObject.eId == null) || (!paramObject.eId.equals(this.eId)) || (paramObject.epId == null) || (!paramObject.epId.equals(this.epId)));
    return true;
  }
  
  public String getMapKey()
  {
    return this.epId + "_" + this.eId;
  }
  
  public boolean hasEncryptKey()
  {
    return (this.encryptKey != null) && (!this.encryptKey.equals(""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Emoticon
 * JD-Core Version:    0.7.0.1
 */