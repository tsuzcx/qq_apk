package com.tencent.mobileqq.app.proxy;

import acxv;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.persistence.Entity;
import dv;

public class MpfileTaskProxy$1
  implements Runnable
{
  public MpfileTaskProxy$1(acxv paramacxv, Entity paramEntity, ProxyListener paramProxyListener, dv paramdv) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.e).clone();
    this.this$0.a.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_Dv.cl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */