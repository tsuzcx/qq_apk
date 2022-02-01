package com.tencent.mobileqq.apollo.script;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import wja;
import wki;
import xeh;

class SpriteUIHandler$1
  implements Runnable
{
  SpriteUIHandler$1(SpriteUIHandler paramSpriteUIHandler, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = this.this$0.a();
      if (localObject1 == null)
      {
        QLog.e("cmshow_scripted_SpriteUIHandler", 1, "adatper is null.");
        return;
      }
      int i = wja.a(this.ad, (ListAdapter)localObject1);
      if (i >= 0)
      {
        XListView localXListView = this.this$0.a();
        Object localObject2 = (ChatMessage)((wki)localObject1).getItem(i);
        if ((localXListView != null) && (localObject2 != null) && ((localObject2 instanceof MessageForApollo)))
        {
          localObject1 = ((wki)localObject1).a.a((ChatMessage)localObject2, (BaseAdapter)localObject1);
          if ((localObject1 instanceof ApolloItemBuilder))
          {
            localObject1 = (ApolloItemBuilder)localObject1;
            localObject2 = (BaseChatItemLayout)wja.a(localXListView, wja.a(this.ad, localXListView.getAdapter()));
            if (localObject2 != null)
            {
              ((ApolloItemBuilder)localObject1).q((View)localObject2, this.Is, this.val$ret);
              localXListView.getFirstVisiblePosition();
              int j = localXListView.getLastVisiblePosition();
              i = 0;
              while (i < j)
              {
                BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)wja.a(localXListView, i);
                if (localBaseChatItemLayout != null) {
                  ((ApolloItemBuilder)localObject1).a(localBaseChatItemLayout, (BaseChatItemLayout)localObject2, this.Is, this.val$ret);
                }
                i += 1;
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onActionDownloadNotify], error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.1
 * JD-Core Version:    0.7.0.1
 */