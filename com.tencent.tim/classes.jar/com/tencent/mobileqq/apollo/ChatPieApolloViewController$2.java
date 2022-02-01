package com.tencent.mobileqq.apollo;

import abin;
import abyv;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$2
  implements Runnable
{
  public ChatPieApolloViewController$2(abin paramabin, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine start");
    ApolloCmdChannel.getChannel(this.d.app).setActivityContext(this.d.mActivity);
    if (this.this$0.c == null)
    {
      float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      this.this$0.c = new ApolloRender(f, this.d.a, 0);
      this.this$0.c.setUseGlobalTimer(true);
    }
    abyv.b(this.this$0.a);
    if (!ApolloEngine.BJ())
    {
      abyv.a(this.this$0.a);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine !isEngineReady");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine isEngineReady");
      }
      if (abin.a(this.this$0))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine but AIO destroy!");
        return;
      }
    } while (this.this$0.c == null);
    this.this$0.c.preLoadDirector();
    abin.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */