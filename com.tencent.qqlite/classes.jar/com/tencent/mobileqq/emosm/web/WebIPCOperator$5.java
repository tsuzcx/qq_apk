package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class WebIPCOperator$5
  implements EmojiIPCAlarmer.TimeoutObserver
{
  WebIPCOperator$5(WebIPCOperator paramWebIPCOperator) {}
  
  public void onTimeOut(int paramInt)
  {
    WebIPCOperator.RequestItem localRequestItem = this.this$0.removeRequest(paramInt);
    if (localRequestItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.this$0.setRespFailCode(localBundle, 1001);
      localRequestItem.reqbundle.putBundle("response", localBundle);
      this.this$0.runOnUiThread(new WebIPCOperator.5.1(this, localRequestItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator.5
 * JD-Core Version:    0.7.0.1
 */