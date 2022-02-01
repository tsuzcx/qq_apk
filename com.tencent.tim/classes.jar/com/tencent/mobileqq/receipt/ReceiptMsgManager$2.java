package com.tencent.mobileqq.receipt;

import alte;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import aonc;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ReceiptMsgManager$2
  implements Runnable
{
  public ReceiptMsgManager$2(alte paramalte, ArrayList paramArrayList, Bundle paramBundle, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.yT.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (((localChatMessage instanceof MessageForPic)) && (new File(((MessageForPic)localChatMessage).path).exists()))
      {
        MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
        int i = this.Q.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
        alte.a(this.this$0, localMessageForPic, i);
        localMessageForPic.md5 = alte.a(this.this$0, localMessageForPic.path);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        localOptions.inSampleSize = 1;
        SafeBitmapFactory.decodeFile(localMessageForPic.path, localOptions);
        localMessageForPic.width = localOptions.outWidth;
        localMessageForPic.height = localOptions.outHeight;
        alte.g(this.val$app, localChatMessage, Integer.toString(i));
        if (aonc.qi(localMessageForPic.path))
        {
          localMessageForPic.width = localOptions.outHeight;
          localMessageForPic.height = localOptions.outWidth;
          if (QLog.isColorLevel()) {
            QLog.d("ReceiptMsgManager", 2, new Object[] { "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height });
          }
        }
      }
    }
    alte.a(this.this$0, this.val$app, this.a.aTl, this.a.cZ, this.a.troopUin, alte.a(this.this$0, 2), false, this.yT, this.Q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.2
 * JD-Core Version:    0.7.0.1
 */