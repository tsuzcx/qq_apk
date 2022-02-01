package com.tencent.biz.videostory.widget.view;

import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import srn;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(srn paramsrn, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (srn.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    EntityManager localEntityManager = srn.a(this.this$0).app.a().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = new WSPersonalEntity();
    localWSPersonalEntity.updateWeiShiFeedListEntity(srn.a(this.this$0), this.bR);
    if (localWSPersonalEntity.getStatus() == 1000) {
      localEntityManager.persist(localWSPersonalEntity);
    }
    for (;;)
    {
      localEntityManager.close();
      return;
      localEntityManager.update(localWSPersonalEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */