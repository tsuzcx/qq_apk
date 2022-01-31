package com.tencent.i18n.publicaccount;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class WhitePublicAccount
  extends Entity
{
  @unique
  public String uin;
  
  public WhitePublicAccount() {}
  
  public WhitePublicAccount(long paramLong)
  {
    this.uin = String.valueOf(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.publicaccount.WhitePublicAccount
 * JD-Core Version:    0.7.0.1
 */