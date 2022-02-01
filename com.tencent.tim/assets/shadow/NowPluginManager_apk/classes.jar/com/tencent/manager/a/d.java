package com.tencent.manager.a;

import android.content.Context;
import com.tencent.manager.c;
import com.tencent.util.e.a;
import java.io.File;

public class d
{
  c a;
  Context b;
  
  private String a()
  {
    if (this.b.getPackageName().equals("com.tencent.mtt")) {
      return "sdcard/QQBrowser/plugins/com.tencent.now";
    }
    return "sdcard/Now/plugin";
  }
  
  public String a(String paramString)
  {
    File localFile2 = this.b.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      a.a("", "getDownload root fail,use back-up dir");
      localFile2 = new File(a());
      if (localFile2 == null) {
        return null;
      }
      localFile1 = localFile2;
      if (!localFile2.exists())
      {
        localFile2.mkdir();
        localFile1 = localFile2;
      }
    }
    localFile1 = new File(localFile1.getPath() + "/" + 14);
    if ((!localFile1.exists()) && (!localFile1.mkdir())) {
      localFile1 = new File(a());
    }
    for (;;)
    {
      paramString = new File(localFile1.getAbsoluteFile() + "/" + paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return paramString.getAbsolutePath();
    }
  }
  
  public void a(Context paramContext, c paramc)
  {
    this.a = paramc;
    this.b = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.d
 * JD-Core Version:    0.7.0.1
 */