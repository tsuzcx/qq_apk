package com.facebook.stetho.websocket;

import java.io.IOException;

class WebSocketSession$1
  implements ReadCallback
{
  WebSocketSession$1(WebSocketSession paramWebSocketSession) {}
  
  private void handleBinaryFrame(byte[] paramArrayOfByte, int paramInt)
  {
    WebSocketSession.access$400(this.this$0).onMessage(this.this$0, paramArrayOfByte, paramInt);
  }
  
  private void handleClose(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    if (paramInt >= 2)
    {
      i = paramArrayOfByte[0];
      i = paramArrayOfByte[1] & 0xFF | (i & 0xFF) << 8;
      if (paramInt > 2)
      {
        paramArrayOfByte = new String(paramArrayOfByte, 2, paramInt - 2);
        paramInt = i;
      }
    }
    for (;;)
    {
      if (!WebSocketSession.access$100(this.this$0)) {
        WebSocketSession.access$200(this.this$0, 1000, "Received close frame");
      }
      this.this$0.markAndSignalClosed(paramInt, paramArrayOfByte);
      return;
      paramArrayOfByte = null;
      paramInt = i;
      continue;
      paramInt = 1006;
      paramArrayOfByte = "Unparseable close frame";
    }
  }
  
  private void handlePing(byte[] paramArrayOfByte, int paramInt)
  {
    WebSocketSession.access$300(this.this$0, FrameHelper.createPongFrame(paramArrayOfByte, paramInt));
  }
  
  private void handlePong(byte[] paramArrayOfByte, int paramInt) {}
  
  private void handleTextFrame(byte[] paramArrayOfByte, int paramInt)
  {
    WebSocketSession.access$400(this.this$0).onMessage(this.this$0, new String(paramArrayOfByte, 0, paramInt));
  }
  
  public void onCompleteFrame(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    switch (paramByte)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      WebSocketSession.access$000(this.this$0, new IOException("Unsupported frame opcode=" + paramByte));
      return;
    case 8: 
      handleClose(paramArrayOfByte, paramInt);
      return;
    case 9: 
      handlePing(paramArrayOfByte, paramInt);
      return;
    case 10: 
      handlePong(paramArrayOfByte, paramInt);
      return;
    case 1: 
      handleTextFrame(paramArrayOfByte, paramInt);
      return;
    }
    handleBinaryFrame(paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WebSocketSession.1
 * JD-Core Version:    0.7.0.1
 */