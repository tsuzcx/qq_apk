package com.tencent.mobileqq.activity.aio.item;

import afpu;
import ajdg;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.Serializable;
import java.util.List;

class MarketFaceItemBuilder$5
  implements Runnable
{
  MarketFaceItemBuilder$5(MarketFaceItemBuilder paramMarketFaceItemBuilder, String paramString, MarketFaceItemBuilder.b paramb) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.mContext, H5MagicPlayerActivity.class);
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("autoPlay", this.aUX);
    localIntent.putExtra("senderUin", this.a.mMessage.senderuin);
    localIntent.putExtra("selfUin", this.this$0.app.getCurrentAccountUin());
    localIntent.putExtra("sessionInfo", this.this$0.sessionInfo);
    localIntent.putExtra("emoticon", this.a.c.e);
    Object localObject = (ajdg)this.this$0.app.getManager(14);
    EmoticonPackage localEmoticonPackage = ((ajdg)localObject).b(this.a.c.e.epId);
    if (localEmoticonPackage != null)
    {
      localObject = ((ajdg)localObject).az(localEmoticonPackage.childEpId);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
      }
    }
    this.this$0.mContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */