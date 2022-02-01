package com.tencent.mobileqq.filemanager.multioperate;

import aghw;
import agys;
import agyx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class OfflineFileMultiOperate$1
  implements Runnable
{
  public OfflineFileMultiOperate$1(agys paramagys, List paramList1, List paramList2, agyx paramagyx) {}
  
  public void run()
  {
    if (this.qw.size() == 1) {
      agys.a(this.this$0).b().b((MessageRecord)this.qw.get(0), false);
    }
    while ((this.val$fileList != null) && (this.val$fileList.size() > 0))
    {
      Iterator localIterator = this.val$fileList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        localFileManagerEntity.bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("OfflineFileMultiOperate", 1, "ChatHistory entity[" + localFileManagerEntity.getId() + "] del File:" + localFileManagerEntity.nSessionId);
        }
        agys.a(this.this$0).a().ca(localFileManagerEntity.nSessionId);
      }
      if (this.qw.size() > 1) {
        agys.a(this.this$0).b().V(this.qw, false);
      }
    }
    if (this.a != null) {
      this.a.gg(3, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */