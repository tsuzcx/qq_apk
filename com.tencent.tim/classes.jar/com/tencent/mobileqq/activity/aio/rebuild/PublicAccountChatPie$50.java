package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import ycd;
import ydo;

public class PublicAccountChatPie$50
  implements Runnable
{
  public PublicAccountChatPie$50(ycd paramycd) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
      if ((localObject != null) && (((WebProcessManager)localObject).aFU())) {
        ((WebProcessManager)localObject).a(-1, new ydo(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.50
 * JD-Core Version:    0.7.0.1
 */