package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager.ClearAttachCallback;
import java.util.ArrayList;

class CacheActivity$2$1
  implements QMClearCacheManager.ClearAttachCallback
{
  CacheActivity$2$1(CacheActivity.2 param2) {}
  
  public void onResult(ArrayList<String> paramArrayList)
  {
    DownloadInfoManager.shareInstance().deleteDownloadInfoByPaths(paramArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.CacheActivity.2.1
 * JD-Core Version:    0.7.0.1
 */