package com.tencent.moai.mailsdk.util.aswbxml;

class ASWBXML$1
  implements ASWBXMLStreamQueue.ASWBXMLStreamQueueCallback
{
  ASWBXML$1(ASWBXML paramASWBXML, ASWBXML.StreamHandler paramStreamHandler) {}
  
  public void onDequeue(byte paramByte) {}
  
  public void onDequeue(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.val$streamHandler != null) {
      this.val$streamHandler.onData(paramArrayOfByte, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.aswbxml.ASWBXML.1
 * JD-Core Version:    0.7.0.1
 */