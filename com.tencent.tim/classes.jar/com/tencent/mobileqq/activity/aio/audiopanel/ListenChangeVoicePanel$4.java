package com.tencent.mobileqq.activity.aio.audiopanel;

import acff;
import alik;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

class ListenChangeVoicePanel$4
  implements Runnable
{
  ListenChangeVoicePanel$4(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    if ((ListenChangeVoicePanel.a(this.this$0).get() == null) || (this.this$0.dq.get() == null)) {
      return;
    }
    Object localObject = (acff)((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getManager(51);
    int i;
    if (!((BaseChatPie)this.this$0.dq.get()).OV())
    {
      localObject = ((acff)localObject).a(((BaseChatPie)this.this$0.dq.get()).sessionInfo.aTl, ((BaseChatPie)this.this$0.dq.get()).sessionInfo.cZ, true);
      if (localObject == null) {
        break label199;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if (i != -1)
      {
        ListenChangeVoicePanel.a(this.this$0, i);
        ListenChangeVoicePanel.a(this.this$0)[i] = 1;
      }
      if (ListenChangeVoicePanel.a != null) {
        break;
      }
      ListenChangeVoicePanel.a = new alik();
      return;
      localObject = ((acff)localObject).a(((BaseChatPie)this.this$0.dq.get()).sessionInfo.aTl, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label199:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */