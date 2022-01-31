package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.ch;
import com.tencent.token.utils.x;

class bc
  implements View.OnClickListener
{
  bc(AssistantRecommendFriendQrcode paramAssistantRecommendFriendQrcode) {}
  
  public void onClick(View paramView)
  {
    ch.a().a(System.currentTimeMillis(), 62);
    if (AssistantRecommendFriendQrcode.access$200(this.a).isWXAppInstalled())
    {
      if (AssistantRecommendFriendQrcode.access$200(this.a).getWXAppSupportAPI() >= 553779201)
      {
        paramView = new WXWebpageObject();
        paramView.webpageUrl = "http://m.aq.qq.com/lp?i=18";
        paramView = new WXMediaMessage(paramView);
        paramView.title = this.a.getResources().getString(2131231438);
        paramView.description = AssistantRecommendFriendQrcode.access$400(this.a);
        paramView.setThumbImage(x.a(this.a.getResources(), 2130838049));
        SendMessageToWX.Req localReq = new SendMessageToWX.Req();
        localReq.transaction = String.valueOf(System.currentTimeMillis());
        localReq.message = paramView;
        localReq.scene = 1;
        AssistantRecommendFriendQrcode.access$200(this.a).sendReq(localReq);
        return;
      }
      this.a.showToast(this.a.getString(2131231444));
      return;
    }
    AssistantRecommendFriendQrcode.access$300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bc
 * JD-Core Version:    0.7.0.1
 */