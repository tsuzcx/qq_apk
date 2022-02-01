package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class FileJsPlugin$14
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$14(FileJsPlugin paramFileJsPlugin, String paramString, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    int i = ((MiniAppFileManager)FileJsPlugin.access$6000(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath);
    if (i == 9999)
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "invalid path" + this.val$filePath);
    }
    String str = ((MiniAppFileManager)FileJsPlugin.access$6100(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$filePath);
    if (TextUtils.isEmpty(str))
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    if (new File(str).isDirectory())
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "operation not permitted, unlink " + this.val$filePath);
    }
    if (!new File(str).exists())
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    long l2 = FileUtils.delete(str, false);
    FileJsPlugin.access$2500(this.this$0).updateFolderSize(i, -l2);
    FileJsPlugin.access$1000(this.this$0, this.val$req.event, true, this.val$startMS, l1, str);
    return FileJsPlugin.access$1200(this.this$0, this.val$req, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */