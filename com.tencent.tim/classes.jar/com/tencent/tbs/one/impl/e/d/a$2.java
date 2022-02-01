package com.tencent.tbs.one.impl.e.d;

import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

final class a$2
  extends TBSOneCallback<Void>
{
  a$2(a parama, String paramString1, String paramString2, File paramFile) {}
  
  public final void onError(int paramInt, String paramString)
  {
    this.d.b = 0;
    this.d.a(paramInt, paramString, null);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.d.a(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d.a.2
 * JD-Core Version:    0.7.0.1
 */