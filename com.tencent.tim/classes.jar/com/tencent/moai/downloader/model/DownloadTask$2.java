package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.delegate.RenameDelegate;
import com.tencent.moai.downloader.file.DownloadFileUtil;

class DownloadTask$2
  implements RenameDelegate
{
  DownloadTask$2(DownloadTask paramDownloadTask) {}
  
  public String rename(String paramString)
  {
    return DownloadFileUtil.defaultRename(paramString, this.this$0.getFileName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.DownloadTask.2
 * JD-Core Version:    0.7.0.1
 */