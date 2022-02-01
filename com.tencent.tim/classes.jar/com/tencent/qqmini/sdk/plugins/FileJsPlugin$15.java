package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class FileJsPlugin$15
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$15(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    boolean bool = false;
    long l2 = System.currentTimeMillis();
    if ((((MiniAppFileManager)FileJsPlugin.access$6200(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$zipFilePath) == 9999) && (!((MiniAppFileManager)FileJsPlugin.access$6300(this.this$0).getManager(MiniAppFileManager.class)).isPackageRelativePath(this.val$zipFilePath)))
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$zipFilePath);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "permission denied, open " + this.val$zipFilePath);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$6400(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$targetPath) != 2)
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$targetPath);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "permission denied, open " + this.val$targetPath);
    }
    Object localObject = ((MiniAppFileManager)FileJsPlugin.access$6500(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$zipFilePath);
    String str1 = ((MiniAppFileManager)FileJsPlugin.access$6600(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$targetPath);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists()))
    {
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l2, (String)localObject);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$zipFilePath);
    }
    long l1 = FileUtils.getFileOrFolderSize(str1);
    int i = ZipUtil.unZipFolder((String)localObject, str1);
    localObject = this.this$0;
    String str2 = this.val$req.event;
    if (i == 0) {
      bool = true;
    }
    FileJsPlugin.access$1000((FileJsPlugin)localObject, str2, bool, this.val$startMS, l2, this.val$zipFilePath);
    if (i == 0)
    {
      l2 = FileUtils.getFileOrFolderSize(str1);
      FileJsPlugin.access$2500(this.this$0).updateFolderSize(2, l2 - l1);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null);
    }
    return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "read zip data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */