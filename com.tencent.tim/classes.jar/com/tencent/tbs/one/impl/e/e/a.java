package com.tencent.tbs.one.impl.e.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;

public final class a
  extends b
{
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    super(paramContext, paramString, parama, paramFile, paramBundle);
  }
  
  final File a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      paramContext = new File(paramContext.getDir("tbs", 0), "core_share");
      File localFile = new File(paramContext, "MANIFEST");
      if (localFile.exists()) {
        try
        {
          int i = e.a(localFile).a;
          int j = this.b.c;
          if (i == j) {
            return paramContext;
          }
        }
        catch (TBSOneException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
  
  protected final e.a c()
  {
    return e.a.i;
  }
  
  public final void d()
  {
    h.a(2001, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.e.a
 * JD-Core Version:    0.7.0.1
 */