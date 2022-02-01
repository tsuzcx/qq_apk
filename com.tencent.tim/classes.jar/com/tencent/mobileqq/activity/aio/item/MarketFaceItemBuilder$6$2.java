package com.tencent.mobileqq.activity.aio.item;

import afke;
import aiyr;
import ajdg;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import anot;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import xju;

public class MarketFaceItemBuilder$6$2
  implements Runnable
{
  public MarketFaceItemBuilder$6$2(xju paramxju, Emoticon paramEmoticon, String paramString, MarketFaceItemBuilder.b paramb) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.d != null) && (this.d.jobType == 2) && (this.a.this$0.mContext != null) && ((this.a.this$0.mContext instanceof FragmentActivity)))
    {
      localObject1 = (FragmentActivity)this.a.this$0.mContext;
      if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && (aiyr.apU())) {
        ((FragmentActivity)localObject1).getChatFragment().a().a(this.d, 1, this.aUY, false);
      }
      anot.a(this.a.this$0.app, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    if ((this.d != null) && (this.d.jobType == 4) && (this.a.this$0.b.ajr()))
    {
      if (!this.a.this$0.bgY) {
        break label431;
      }
      this.b.tf.setVisibility(0);
      this.b.tf.setImageResource(2130838101);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and needplay epId = " + this.d.epId);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.a.this$0.mContext, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.aUY);
      ((Intent)localObject1).putExtra("selfUin", this.a.this$0.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.a.this$0.sessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.d);
      Object localObject2 = (ajdg)this.a.this$0.app.getManager(14);
      EmoticonPackage localEmoticonPackage = ((ajdg)localObject2).b(this.d.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((ajdg)localObject2).az(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.a.this$0.mContext.startActivity((Intent)localObject1);
      return;
      label431:
      this.b.tf.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.2
 * JD-Core Version:    0.7.0.1
 */