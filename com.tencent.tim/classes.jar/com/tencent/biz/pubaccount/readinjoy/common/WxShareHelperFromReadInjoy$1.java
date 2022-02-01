package com.tencent.biz.pubaccount.readinjoy.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.qphone.base.util.QLog;
import rop;

class WxShareHelperFromReadInjoy$1
  implements Runnable
{
  WxShareHelperFromReadInjoy$1(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap, String paramString6) {}
  
  public void run()
  {
    Object localObject1 = new WXMiniProgramObject();
    ((WXMiniProgramObject)localObject1).withShareTicket = true;
    ((WXMiniProgramObject)localObject1).webpageUrl = this.adK;
    ((WXMiniProgramObject)localObject1).userName = this.adL;
    ((WXMiniProgramObject)localObject1).path = this.val$path;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = this.val$title;
    localWXMediaMessage.description = this.val$description;
    int i;
    int j;
    if (this.bZ != null)
    {
      localObject1 = this.bZ;
      i = this.bZ.getWidth();
      j = this.bZ.getHeight();
      j = Math.min(i / 5, j / 4);
      i = j * 5;
      j *= 4;
      if (this.val$path.startsWith("/pages/index/index?share=1&share_type=1"))
      {
        localObject1 = rop.a(rop.a(this.bZ, i, j, false, true), BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842580), true);
        if (localObject1 != null)
        {
          i = ((Bitmap)localObject1).getWidth();
          j = ((Bitmap)localObject1).getHeight();
          Object localObject2 = localObject1;
          if (((Bitmap)localObject1).getByteCount() > 128000)
          {
            localObject1 = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
            double d = Math.sqrt(64000.0D / (i * j));
            localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(i * d), (int)(d * j), true);
          }
          localWXMediaMessage.thumbData = WxShareHelperFromReadInjoy.c((Bitmap)localObject2);
        }
      }
    }
    for (;;)
    {
      localObject1 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject1).transaction = this.adM;
      ((SendMessageToWX.Req)localObject1).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject1).scene = 0;
      WxShareHelperFromReadInjoy.a(this.this$0, (SendMessageToWX.Req)localObject1);
      return;
      localObject1 = rop.a(this.bZ, i, j, false, true);
      break;
      if (QLog.isColorLevel()) {
        QLog.e("WxShareHelperFromReadInjoy", 2, "shareToMiniProgramWithPathAndId, error icon == null! title" + this.val$title + ", description = " + this.val$description + ", path = " + this.val$path + ", webPageUrl = " + this.adK + ", id = " + this.adL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.1
 * JD-Core Version:    0.7.0.1
 */