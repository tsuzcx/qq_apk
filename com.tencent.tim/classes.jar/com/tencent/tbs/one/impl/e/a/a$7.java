package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

final class a$7
  extends TBSOneCallback<Void>
{
  a$7(a parama, String paramString1, String paramString2, File paramFile, Context paramContext, int paramInt) {}
  
  public final void onError(int paramInt, String paramString)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Failed to intercept component download stream by runtime extension: [%d] %s", new Object[] { this.a, this.b, Integer.valueOf(paramInt), paramString });
    this.f.j = 0;
    a.a(this.f, this.d, this.a, this.b, this.e, this.f.d, -1);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.f.a(com.tencent.tbs.one.impl.e.f.a(paramInt2, 70, 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.7
 * JD-Core Version:    0.7.0.1
 */