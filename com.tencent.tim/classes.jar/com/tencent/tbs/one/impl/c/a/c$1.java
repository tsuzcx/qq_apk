package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;
import java.io.File;

final class c$1
  implements Runnable
{
  c$1(File paramFile, Context paramContext, String paramString1, String paramString2) {}
  
  public final void run()
  {
    f.a("Starting standalone service to optimize dex %s", new Object[] { this.a.getAbsolutePath() });
    Intent localIntent = new Intent(this.b, TBSOneStandaloneService.class);
    localIntent.putExtra("implClassName", b.class.getName());
    localIntent.putExtra("dexPath", this.a.getAbsolutePath());
    localIntent.putExtra("dexName", this.a.getName());
    localIntent.putExtra("optimizedDirectory", this.c);
    localIntent.putExtra("librarySearchPath", this.d);
    this.b.startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.c.1
 * JD-Core Version:    0.7.0.1
 */