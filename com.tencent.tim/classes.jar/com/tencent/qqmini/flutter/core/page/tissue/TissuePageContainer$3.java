package com.tencent.qqmini.flutter.core.page.tissue;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class TissuePageContainer$3
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  TissuePageContainer$3(TissuePageContainer paramTissuePageContainer) {}
  
  public void onMessage(ByteBuffer paramByteBuffer, BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    QMLog.w("miniapp-TISSUE", new String(paramByteBuffer.array(), Charset.forName("utf8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer.3
 * JD-Core Version:    0.7.0.1
 */