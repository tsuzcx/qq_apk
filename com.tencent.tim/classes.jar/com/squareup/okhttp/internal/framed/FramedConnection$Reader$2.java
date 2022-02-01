package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;

class FramedConnection$Reader$2
  extends NamedRunnable
{
  FramedConnection$Reader$2(FramedConnection.Reader paramReader, String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public void execute()
  {
    FramedConnection.access$2000(this.this$1.this$0).onSettings(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
 * JD-Core Version:    0.7.0.1
 */