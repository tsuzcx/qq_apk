package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class FramedConnection$4
  extends NamedRunnable
{
  FramedConnection$4(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    if (FramedConnection.access$2700(this.this$0).onRequest(this.val$streamId, this.val$requestHeaders)) {
      try
      {
        this.this$0.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
        synchronized (this.this$0)
        {
          FramedConnection.access$2800(this.this$0).remove(Integer.valueOf(this.val$streamId));
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.4
 * JD-Core Version:    0.7.0.1
 */