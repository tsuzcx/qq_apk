package com.tencent.tbs.one.impl.e;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class i$5
  extends a<e<File>>
{
  i$5(i parami, Context paramContext, String paramString1, String paramString2, File paramFile, int paramInt) {}
  
  public final void a()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = c.a(this.b, this.c, this.d);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      c.a(localInputStream, this.e, null);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localObject3 = localObject1;
      a(313, "Failed to unzip local component from " + this.d + " to " + this.e.getAbsolutePath() + ", localRepository: " + this.c, localIOException);
      return;
    }
    finally
    {
      c.a(localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.5
 * JD-Core Version:    0.7.0.1
 */