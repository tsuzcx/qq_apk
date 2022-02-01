package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;

class CacheActivity$1
  implements Runnable
{
  CacheActivity$1(CacheActivity paramCacheActivity) {}
  
  public void run()
  {
    Threads.runOnMainThread(new CacheActivity.1.1(this, StringExtention.getHumanReadableSizeString(QMClearCacheManager.getCardCache()), StringExtention.getHumanReadableSizeString(QMClearCacheManager.getAvatarCache()), StringExtention.getHumanReadableSizeString(QMClearCacheManager.getLogCache()), StringExtention.getHumanReadableSizeString(QMClearCacheManager.getImageCache()), StringExtention.getHumanReadableSizeString(QMClearCacheManager.getAttachCache(false)), StringExtention.getHumanReadableSizeString(QMClearCacheManager.getDatabaseCache()), StringExtention.getHumanReadableSizeString(FileUtil.getSdcardUsableSpace()), StringExtention.getHumanReadableSizeString(FileUtil.getSdcardAllSpace())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.CacheActivity.1
 * JD-Core Version:    0.7.0.1
 */