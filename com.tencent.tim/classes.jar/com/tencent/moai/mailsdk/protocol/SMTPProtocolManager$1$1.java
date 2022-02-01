package com.tencent.moai.mailsdk.protocol;

import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;

class SMTPProtocolManager$1$1
  implements DataListener
{
  private long sendByte = 0L;
  private long totalByte = this.val$mimeMessage.getSize();
  
  SMTPProtocolManager$1$1(SMTPProtocolManager.1 param1, MimeMessage paramMimeMessage) {}
  
  public void onDataChange(long paramLong)
  {
    this.sendByte += paramLong;
    if (this.this$1.val$sendMailCallBack != null) {
      this.this$1.val$sendMailCallBack.onProgress(this.sendByte, this.totalByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.SMTPProtocolManager.1.1
 * JD-Core Version:    0.7.0.1
 */