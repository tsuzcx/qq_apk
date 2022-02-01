package com.tencent.mobileqq.apollo.script;

import abrc;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class SpriteUIHandler$4
  implements Runnable
{
  SpriteUIHandler$4(SpriteUIHandler paramSpriteUIHandler, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (SpriteUIHandler.a(this.this$0).getApp() == null) {
        return;
      }
      XPanelContainer localXPanelContainer = (XPanelContainer)SpriteUIHandler.a(this.this$0).d().r().findViewById(2131377546);
      if (1 == this.Is)
      {
        if (localXPanelContainer.vm() != 21) {
          return;
        }
        SpriteUIHandler.a(this.this$0).d().hidePanel();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, localException, new Object[0]);
      return;
    }
    if (2 == this.Is)
    {
      BaseChatPie localBaseChatPie = SpriteUIHandler.a(this.this$0).d();
      if (localBaseChatPie != null)
      {
        ApolloPanel localApolloPanel = localBaseChatPie.a;
        if ((localApolloPanel != null) && (localApolloPanel.Ae() == 7))
        {
          localBaseChatPie.Ae(0);
          return;
        }
      }
      localException.abp(21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.4
 * JD-Core Version:    0.7.0.1
 */