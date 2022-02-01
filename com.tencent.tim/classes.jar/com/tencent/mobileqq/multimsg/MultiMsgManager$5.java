package com.tencent.mobileqq.multimsg;

import ajlc;
import anpc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MultiMsgManager$5
  implements Runnable
{
  public MultiMsgManager$5(ajlc paramajlc, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.val$app.b().a(this.val$uin, this.val$type, this.rJ);
    int j;
    int k;
    StringBuilder localStringBuilder;
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction)))
    {
      localObject = ajlc.a().a(this.val$app, this.rJ);
      if (localObject != null)
      {
        j = ((List)localObject).size();
        k = ajlc.a().e((Collection)localObject);
        localObject = new HashMap();
        localStringBuilder = new StringBuilder();
        if (!this.val$isSuccess) {
          break label228;
        }
      }
    }
    label228:
    for (int i = 0;; i = 1)
    {
      ((HashMap)localObject).put("result", i + "");
      ((HashMap)localObject).put("msgCount", j + "");
      ((HashMap)localObject).put("picCount", k + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.val$app.getCurrentAccountUin(), "multiMsgSend", this.val$isSuccess, 30000L, 0L, (HashMap)localObject, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.5
 * JD-Core Version:    0.7.0.1
 */