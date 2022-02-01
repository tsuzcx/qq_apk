package com.tencent.mobileqq.data;

import ajpj;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$2
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$2(MessageForNearbyMarketGrayTips.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (ajpj)this.val$app.getManager(106);
    MessageForNearbyMarketGrayTips.a.a(this.this$0, ((ajpj)localObject).GA());
    String str = this.this$0.k(MessageForNearbyMarketGrayTips.a.a(this.this$0), false);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.this$0.k(MessageForNearbyMarketGrayTips.a.a(this.this$0), true);
    }
    this.this$0.HE((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE  faceScoreWording=" + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */