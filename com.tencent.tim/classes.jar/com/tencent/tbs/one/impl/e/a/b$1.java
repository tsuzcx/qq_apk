package com.tencent.tbs.one.impl.e.a;

import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

final class b$1
  extends TBSOneCallback<Void>
{
  b$1(b paramb, String paramString, File paramFile) {}
  
  public final void onError(int paramInt, String paramString)
  {
    this.c.b = 0;
    this.c.a(paramInt, paramString, null);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.b.1
 * JD-Core Version:    0.7.0.1
 */