package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.util.Set;

class FramedConnection$7
  extends NamedRunnable
{
  FramedConnection$7(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, ErrorCode paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    FramedConnection.access$2700(this.this$0).onReset(this.val$streamId, this.val$errorCode);
    synchronized (this.this$0)
    {
      FramedConnection.access$2800(this.this$0).remove(Integer.valueOf(this.val$streamId));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.7
 * JD-Core Version:    0.7.0.1
 */