package com.tencent.biz.pubaccount.util;

import acbn;
import kvs;
import kvv;
import ocp;

public final class PublicAccountUtil$22
  implements Runnable
{
  public PublicAccountUtil$22(String paramString) {}
  
  public void run()
  {
    if (acbn.blO.equals(this.val$uin))
    {
      kvv.aHx();
      return;
    }
    if (acbn.blP.equals(this.val$uin))
    {
      kvs.aHx();
      return;
    }
    ocp.pm(this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.22
 * JD-Core Version:    0.7.0.1
 */