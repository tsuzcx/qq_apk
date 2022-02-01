package com.tencent.biz.pubaccount.persistence.manager;

import kew;

public class PublicAccountEntityHelper$1
  implements Runnable
{
  public PublicAccountEntityHelper$1(kew paramkew, PublicAccountEntityManagerFactory paramPublicAccountEntityManagerFactory) {}
  
  public void run()
  {
    try
    {
      this.b.verifyAuthentication();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper.1
 * JD-Core Version:    0.7.0.1
 */