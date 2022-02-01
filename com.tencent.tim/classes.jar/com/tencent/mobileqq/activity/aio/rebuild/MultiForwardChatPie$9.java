package com.tencent.mobileqq.activity.aio.rebuild;

import acrb;
import ahgq;
import ajlc;
import ajlg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ybl;

public class MultiForwardChatPie$9
  implements Runnable
{
  public MultiForwardChatPie$9(ybl paramybl, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.mActivity.isFinishing()) {}
    do
    {
      return;
      localObject2 = this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, this.rJ);
      localObject1 = localObject2;
      Object localObject3;
      if (localObject2 == null)
      {
        localObject3 = this.this$0.app.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((acrb)localObject3).b(this.rJ);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.rJ == 0L)
        {
          localObject3 = ybl.a(this.this$0);
          ajlc.a().xL.clear();
          ajlc.a().xL.addAll(ybl.a(this.this$0));
          HashMap localHashMap = new HashMap();
          int i = 0;
          while (i < ybl.a(this.this$0).size())
          {
            ChatMessage localChatMessage = (ChatMessage)ybl.a(this.this$0).get(i);
            localObject2 = localChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = ajlc.a().a(localChatMessage.senderuin, localChatMessage.msgseq, this.this$0.app);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (((String)localObject1).trim().length() != 0) {}
            }
            else
            {
              localObject2 = ajlg.me(localChatMessage.senderuin);
            }
            localHashMap.put(localChatMessage.senderuin, localObject2);
            i += 1;
          }
          ajlc.a().lD.clear();
          ajlc.a().lD.putAll(localHashMap);
          localObject2 = localObject3;
        }
      }
    } while ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing)));
    Object localObject2 = (MessageForStructing)localObject2;
    Object localObject1 = new Bundle();
    if ((((MessageForStructing)localObject2).structingMsg.source_puin != null) && (!"".equals(((MessageForStructing)localObject2).structingMsg.source_puin))) {
      ((Bundle)localObject1).putString("source_puin", ((MessageForStructing)localObject2).structingMsg.source_puin);
    }
    ((Bundle)localObject1).putInt("forward_type", -3);
    ((MessageForStructing)localObject2).structingMsg.mCommentText = null;
    ((Bundle)localObject1).putInt("structmsg_service_id", ((MessageForStructing)localObject2).structingMsg.mMsgServiceID);
    ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((MessageForStructing)localObject2).structingMsg.getBytes());
    ((Bundle)localObject1).putLong("structmsg_uniseq", this.rJ);
    ((Bundle)localObject1).putInt("accostType", ((MessageForStructing)localObject2).structingMsg.sourceAccoutType);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ahgq.f((Activity)this.this$0.mContext, (Intent)localObject2, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.9
 * JD-Core Version:    0.7.0.1
 */