package com.facebook.stetho.websocket;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class ReadHandler
{
  private final BufferedInputStream mBufferedInput;
  private final ByteArrayOutputStream mCurrentPayload = new ByteArrayOutputStream();
  private final SimpleEndpoint mEndpoint;
  
  public ReadHandler(InputStream paramInputStream, SimpleEndpoint paramSimpleEndpoint)
  {
    this.mBufferedInput = new BufferedInputStream(paramInputStream, 1024);
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  public void readLoop(ReadCallback paramReadCallback)
    throws IOException
  {
    Frame localFrame = new Frame();
    do
    {
      localFrame.readFrom(this.mBufferedInput);
      this.mCurrentPayload.write(localFrame.payloadData, 0, (int)localFrame.payloadLen);
      if (localFrame.fin)
      {
        byte[] arrayOfByte = this.mCurrentPayload.toByteArray();
        paramReadCallback.onCompleteFrame(localFrame.opcode, arrayOfByte, arrayOfByte.length);
        this.mCurrentPayload.reset();
      }
    } while (localFrame.opcode != 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.ReadHandler
 * JD-Core Version:    0.7.0.1
 */