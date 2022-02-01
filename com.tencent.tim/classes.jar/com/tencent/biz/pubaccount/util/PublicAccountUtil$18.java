package com.tencent.biz.pubaccount.util;

import acbn;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import ocp;

public final class PublicAccountUtil$18
  implements Runnable
{
  public PublicAccountUtil$18(QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.d(acbn.blw, -3006);
    if (TextUtils.isEmpty(this.apN))
    {
      localObject = this.ael;
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForStructing))) {
        break label108;
      }
    }
    label108:
    for (Object localObject = ocp.b((MessageForStructing)localMessageRecord, (String)localObject, null, null, this.abC);; localObject = ocp.b(this.val$app, (String)localObject, null, null, this.abC))
    {
      if (localObject != null) {
        this.a.b((MessageRecord)localObject, this.val$app.getCurrentUin());
      }
      return;
      localObject = this.apN + ": " + this.ael;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.18
 * JD-Core Version:    0.7.0.1
 */