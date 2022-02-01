package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import xmj;

public class RichStatItemBuilder$1
  implements Runnable
{
  public RichStatItemBuilder$1(xmj paramxmj) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(xmj.a().feedsId))
    {
      ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).K(new String[] { this.this$0.a.frienduin });
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "sign feedid is is null reget friend sign");
      }
    }
    SignatureHandler localSignatureHandler;
    do
    {
      return;
      localSignatureHandler = (SignatureHandler)this.this$0.app.getBusinessHandler(41);
    } while (localSignatureHandler == null);
    localSignatureHandler.eT(this.this$0.a.frienduin, this.this$0.a.feedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */