package com.tencent.mobileqq.maproam.data;

import java.io.Serializable;

public class PersonalInfo
  implements Serializable, Cloneable
{
  public String enc_id;
  public String lEctID;
  public String seg;
  public String uid;
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.data.PersonalInfo
 * JD-Core Version:    0.7.0.1
 */