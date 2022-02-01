package com.tencent.mobileqq.app.hiddenchat;

import aaiv;
import acqa;
import acxw;
import aizp;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class HiddenChatFragment$1
  implements Runnable
{
  HiddenChatFragment$1(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void run()
  {
    int j = 0;
    Object localObject1 = HiddenChatFragment.a(this.this$0).a().a().ei();
    HiddenChatFragment.a(this.this$0).hG((List)localObject1);
    Object localObject2 = HiddenChatFragment.i((List)localObject1, aizp.a().m(HiddenChatFragment.a(this.this$0)));
    localObject1 = new ArrayList(((List)localObject2).size());
    QQAppInterface localQQAppInterface = HiddenChatFragment.a(this.this$0);
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    int i;
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    }
    for (;;)
    {
      aaiv.a((List)localObject2, localQQAppInterface, localFragmentActivity, (List)localObject1, i);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("data|size");
        if (localObject1 != null) {
          break label217;
        }
        i = j;
        QLog.i("tag_hidden_chat", 2, i);
      }
      try
      {
        Collections.sort((List)localObject1, HiddenChatFragment.a(this.this$0));
        if (HiddenChatFragment.a(this.this$0) != null)
        {
          localObject2 = HiddenChatFragment.a(this.this$0).obtainMessage(2);
          ((Message)localObject2).obj = localObject1;
          HiddenChatFragment.a(this.this$0).removeMessages(2);
          HiddenChatFragment.a(this.this$0).sendMessage((Message)localObject2);
        }
        return;
        i = 0;
        continue;
        label217:
        i = ((List)localObject1).size();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentDataListManager", 2, "Comparator Exception: ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.1
 * JD-Core Version:    0.7.0.1
 */