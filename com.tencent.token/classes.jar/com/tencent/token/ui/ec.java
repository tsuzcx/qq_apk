package com.tencent.token.ui;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.dh;
import com.tencent.token.utils.t;

final class ec
  implements dh
{
  ec(eb parameb) {}
  
  public final void a(int paramInt)
  {
    e.a("FacePKActivityonItemClicked");
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
          p.a().a(System.currentTimeMillis(), 74);
          localObject = new WXWebpageObject();
          ((WXWebpageObject)localObject).webpageUrl = (FacePKActivity.access$000(this.a.a) + "&out=1");
          localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
          ((WXMediaMessage)localObject).title = FacePKActivity.access$100(this.a.a);
          ((WXMediaMessage)localObject).description = FacePKActivity.access$200(this.a.a);
          ((WXMediaMessage)localObject).setThumbImage(t.a(this.a.a.getResources(), 2130837614));
          localReq = new SendMessageToWX.Req();
          localReq.transaction = String.valueOf(System.currentTimeMillis());
          localReq.message = ((WXMediaMessage)localObject);
          localReq.scene = 0;
          this.a.a.mWeChatApi.sendReq(localReq);
          return;
        }
        this.a.a.showToast(this.a.a.getString(2131362385));
        return;
      }
      FacePKActivity.access$300(this.a.a);
      return;
    }
    if (this.a.a.mWeChatApi.isWXAppInstalled())
    {
      if (this.a.a.mWeChatApi.getWXAppSupportAPI() >= 553779201)
      {
        p.a().a(System.currentTimeMillis(), 74);
        localObject = new WXWebpageObject();
        ((WXWebpageObject)localObject).webpageUrl = (FacePKActivity.access$000(this.a.a) + "&out=1");
        localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
        ((WXMediaMessage)localObject).title = FacePKActivity.access$200(this.a.a);
        ((WXMediaMessage)localObject).description = "";
        ((WXMediaMessage)localObject).setThumbImage(t.a(this.a.a.getResources(), 2130837614));
        localReq = new SendMessageToWX.Req();
        localReq.transaction = String.valueOf(System.currentTimeMillis());
        localReq.message = ((WXMediaMessage)localObject);
        localReq.scene = 1;
        this.a.a.mWeChatApi.sendReq(localReq);
        return;
      }
      this.a.a.showToast(this.a.a.getString(2131362385));
      return;
    }
    FacePKActivity.access$300(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ec
 * JD-Core Version:    0.7.0.1
 */