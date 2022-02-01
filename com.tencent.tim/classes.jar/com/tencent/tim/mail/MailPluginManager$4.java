package com.tencent.tim.mail;

import augo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;

public class MailPluginManager$4
  implements Runnable
{
  public MailPluginManager$4(augo paramaugo) {}
  
  public void run()
  {
    localObject3 = null;
    localObject1 = null;
    try
    {
      localEntityTransaction = augo.a(this.this$0).getTransaction();
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      localEntityTransaction.begin();
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      boolean bool = augo.a(this.this$0).isOpen();
      if (!bool) {
        return;
      }
    }
    catch (Exception localException)
    {
      EntityTransaction localEntityTransaction;
      localObject3 = localObject1;
      localException.printStackTrace();
      return;
    }
    finally
    {
      if (localObject3 == null) {
        break label224;
      }
      localObject3.end();
    }
    localObject1 = localEntityTransaction;
    localObject3 = localEntityTransaction;
    if (augo.a(this.this$0).getStatus() == 1000)
    {
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      augo.a(this.this$0).persistOrReplace(augo.a(this.this$0));
    }
    for (;;)
    {
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      localEntityTransaction.commit();
      if (localEntityTransaction == null) {
        break;
      }
      localEntityTransaction.end();
      return;
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      if (augo.a(this.this$0).getStatus() != 1001)
      {
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        if (augo.a(this.this$0).getStatus() != 1002) {}
      }
      else
      {
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        augo.a(this.this$0).update(augo.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginManager.4
 * JD-Core Version:    0.7.0.1
 */