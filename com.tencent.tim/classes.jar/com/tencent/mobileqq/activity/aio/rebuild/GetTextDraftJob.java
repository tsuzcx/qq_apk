package com.tencent.mobileqq.activity.aio.rebuild;

import aiyx;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class GetTextDraftJob
  implements Runnable
{
  private aiyx a;
  private WeakReference<QQAppInterface> bV;
  private WeakReference<BaseChatPie> dU;
  private SessionInfo sessionInfo;
  private MqqHandler uiHandler;
  
  public GetTextDraftJob(MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, aiyx paramaiyx, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.uiHandler = paramMqqHandler;
    this.sessionInfo = paramSessionInfo;
    this.a = paramaiyx;
    this.bV = new WeakReference(paramQQAppInterface);
    this.dU = new WeakReference(paramBaseChatPie);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetTextDraftJob", 2, "getting text draft");
    }
    Object localObject = (QQAppInterface)this.bV.get();
    if (localObject == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob app == null");
      return;
    }
    if (this.a == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "AIO---GetTextDraftJob mDraftManager == null");
      return;
    }
    localObject = this.a.b((QQAppInterface)localObject, this.sessionInfo.aTl, this.sessionInfo.cZ);
    if ((localObject != null) && (((DraftTextInfo)localObject).sourceMsgText != null))
    {
      this.uiHandler.postDelayed(new GetTextDraftJob.1(this, (DraftTextInfo)localObject), 500L);
      return;
    }
    this.uiHandler.post(new GetTextDraftJob.2(this, (DraftTextInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob
 * JD-Core Version:    0.7.0.1
 */