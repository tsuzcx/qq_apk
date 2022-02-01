package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

class FramedConnection$Reader$3
  extends NamedRunnable
{
  FramedConnection$Reader$3(FramedConnection.Reader paramReader, String paramString, Object[] paramArrayOfObject, Settings paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this.this$1.this$0.frameWriter.ackSettings(this.val$peerSettings);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
 * JD-Core Version:    0.7.0.1
 */