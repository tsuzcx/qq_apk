package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class FramedConnection$5
  extends NamedRunnable
{
  FramedConnection$5(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    boolean bool = FramedConnection.access$2700(this.this$0).onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
    if (bool) {}
    try
    {
      this.this$0.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
      if ((bool) || (this.val$inFinished)) {
        synchronized (this.this$0)
        {
          FramedConnection.access$2800(this.this$0).remove(Integer.valueOf(this.val$streamId));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.5
 * JD-Core Version:    0.7.0.1
 */