package com.tencent.tim.filemanager.core;

import android.text.TextUtils;
import atvp;
import java.util.Map;

public class WpsFileEditStore$2
  implements Runnable
{
  public WpsFileEditStore$2(atvp paramatvp, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.cIe))
    {
      this.this$0.a(this.val$filePath, false, false, null);
      return;
    }
    atvp.a(this.this$0).put(this.val$filePath, this.cIe);
    this.this$0.jh(this.val$filePath, this.cIe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.WpsFileEditStore.2
 * JD-Core Version:    0.7.0.1
 */