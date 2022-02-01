package com.tencent.biz.pubaccount.serviceAccountFolder;

import aalb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import nyn;
import tog;

public class ServiceAccountFolderManager$5
  implements Runnable
{
  public ServiceAccountFolderManager$5(nyn paramnyn, ArrayList paramArrayList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = this.eg.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aalb.l(this.val$app, str, 1008);
      this.val$app.b().ca(str, 1008);
      this.val$app.a().h(str, 1008, true);
    }
    this.this$0.ad(this.val$app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.5
 * JD-Core Version:    0.7.0.1
 */