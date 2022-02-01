package com.tencent.mobileqq.activity.aio.rebuild;

import abep;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import aqiw;
import arxh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import mqq.manager.TicketManager;
import yam;
import yam.a;

public class HotChatPie$21
  implements Runnable
{
  public HotChatPie$21(yam paramyam, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 1;
    if (!aqiw.isNetworkAvailable(this.this$0.mContext)) {
      QQToast.a(this.this$0.mContext, 1, this.this$0.mContext.getString(2131696273), 0).show();
    }
    while ((this.this$0.b == null) || (!this.this$0.b.isBuLuoHotChat())) {
      return;
    }
    Object localObject1 = (TicketManager)this.this$0.app.getManager(2);
    Object localObject2 = this.this$0.app.getCurrentAccountUin();
    if (localObject1 != null) {}
    for (localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = null)
    {
      Bundle localBundle = new Bundle();
      Object localObject3 = this.this$0.b.getTribeId();
      localBundle.putString("bid", (String)localObject3);
      localBundle.putString("num", this.val$num + "");
      Object localObject4 = new StringBuilder();
      TextView localTextView;
      if (this.val$start <= 0)
      {
        i = 0;
        localBundle.putString("start", i + "");
        localBundle.putString("Cookie", "uin=o" + (String)localObject2 + ";skey=" + (String)localObject1);
        localBundle.putString("Referer", String.format("https://buluo.qq.com/mobile/barindex.html?bid=%s&scene=detail_titleNav&_wv=1027", new Object[] { localObject3 }));
        localObject1 = this.this$0.mContext;
        localObject2 = this.this$0.z;
        localObject3 = this.this$0.a;
        localObject4 = yam.a(this.this$0);
        localTextView = this.this$0.KH;
        if (this.val$start != 0) {
          break label357;
        }
      }
      label357:
      for (int i = j;; i = 2)
      {
        new arxh("https://buluo.qq.com/cgi-bin/bar/post/get_post_from_reliao", "GET", new yam.a((Context)localObject1, (XListView)localObject2, (abep)localObject3, (PullRefreshHeader)localObject4, localTextView, i)).dL(localBundle);
        return;
        i = this.val$start;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.21
 * JD-Core Version:    0.7.0.1
 */