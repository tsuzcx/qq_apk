package com.tencent.mobileqq.app.proxy;

import acxt;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.Entity;
import dv;

public class DataLineMsgProxy$2
  implements Runnable
{
  public DataLineMsgProxy$2(acxt paramacxt, Entity paramEntity, ProxyListener paramProxyListener, dv paramdv) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.e).clone();
    this.this$0.a.addMsgQueue(String.valueOf(0), 0, this.this$0.bqX, localDataLineMsgRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_Dv.cl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */