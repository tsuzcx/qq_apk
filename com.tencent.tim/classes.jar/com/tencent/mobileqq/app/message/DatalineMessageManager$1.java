package com.tencent.mobileqq.app.message;

import acqp;
import acxw;
import anaz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import dv;

public class DatalineMessageManager$1
  implements Runnable
{
  public DatalineMessageManager$1(acqp paramacqp, DataLineMsgRecord paramDataLineMsgRecord, dv paramdv) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = anaz.gQ();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      acxw localacxw = this.this$0.app.a().a();
      RecentUser localRecentUser = localacxw.a(String.valueOf(this.this$0.bqy), this.this$0.czi);
      localRecentUser.setType(this.this$0.czi);
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localacxw.e(localRecentUser);
      acqp.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localEntityManager);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      this.this$0.b.as(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_Dv.cl();
      localEntityManager.close();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.1
 * JD-Core Version:    0.7.0.1
 */