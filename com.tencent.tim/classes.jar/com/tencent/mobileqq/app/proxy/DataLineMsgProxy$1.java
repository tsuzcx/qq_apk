package com.tencent.mobileqq.app.proxy;

import acxt;
import com.tencent.mobileqq.persistence.EntityManager;

public class DataLineMsgProxy$1
  implements Runnable
{
  public DataLineMsgProxy$1(acxt paramacxt, EntityManager paramEntityManager, String paramString) {}
  
  public void run()
  {
    this.e.execSQL("create index if not exists " + this.bqY + "_index ON " + this.bqY + "(groupId, msgId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */