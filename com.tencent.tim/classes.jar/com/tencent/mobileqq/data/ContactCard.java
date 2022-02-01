package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ContactCard
  extends Entity
{
  public byte bAge;
  public byte bSex = -1;
  public boolean bindQQ;
  public String mobileCode;
  @unique
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public String strCity;
  public String strContactName;
  public String strCountry;
  public String strProvince;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ContactCard
 * JD-Core Version:    0.7.0.1
 */