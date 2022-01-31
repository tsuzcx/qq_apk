package com.tencent.token.ui;

import android.content.res.Resources;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.ch;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.da;
import com.tencent.token.utils.x;

class ea
  implements da
{
  ea(dz paramdz) {}
  
  public void a(int paramInt)
  {
    h.a("BaseActivityonItemClicked");
    Object localObject;
    SendMessageToWX.Req localReq;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.a.a.mWeChatApi.isWXAppInstalled())
      {
        if (this.a.a.mWeChatApi.getWXAppSupportAPI() >= 553779201)
        {
          ch.a().a(System.currentTimeMillis(), 74);
          localObject = new WXWebpageObject();
          ((WXWebpageObject)localObject).webpageUrl = this.a.a.shareurl;
          localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
          ((WXMediaMessage)localObject).title = this.a.a.sharetitle;
          ((WXMediaMessage)localObject).description = this.a.a.getResources().getString(2131231448);
          ((WXMediaMessage)localObject).setThumbImage(x.a(this.a.a.getResources(), 2130838049));
          localReq = new SendMessageToWX.Req();
          localReq.transaction = String.valueOf(System.currentTimeMillis());
          localReq.message = ((WXMediaMessage)localObject);
          localReq.scene = 0;
          this.a.a.mWeChatApi.sendReq(localReq);
          return;
        }
        this.a.a.showToast(this.a.a.getString(2131231444));
        return;
      }
      EmbedWebBaseActivity.access$000(this.a.a);
      return;
    }
    if (this.a.a.mWeChatApi.isWXAppInstalled())
    {
      if (this.a.a.mWeChatApi.getWXAppSupportAPI() >= 553779201)
      {
        ch.a().a(System.currentTimeMillis(), 74);
        localObject = new WXWebpageObject();
        ((WXWebpageObject)localObject).webpageUrl = this.a.a.shareurl;
        localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
        ((WXMediaMessage)localObject).title = this.a.a.sharetitle;
        ((WXMediaMessage)localObject).description = this.a.a.getResources().getString(2131231448);
        ((WXMediaMessage)localObject).setThumbImage(x.a(this.a.a.getResources(), 2130838049));
        localReq = new SendMessageToWX.Req();
        localReq.transaction = String.valueOf(System.currentTimeMillis());
        localReq.message = ((WXMediaMessage)localObject);
        localReq.scene = 1;
        this.a.a.mWeChatApi.sendReq(localReq);
        return;
      }
      this.a.a.showToast(this.a.a.getString(2131231444));
      return;
    }
    EmbedWebBaseActivity.access$000(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ea
 * JD-Core Version:    0.7.0.1
 */