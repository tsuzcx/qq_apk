package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;
import oop;

public class QzoneVerticalVideoPluginApk$2
  implements Runnable
{
  public QzoneVerticalVideoPluginApk$2(oop paramoop) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("sp_weishi_update_plugin", "query_plugin_last_time", System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.QzoneVerticalVideoPluginApk.2
 * JD-Core Version:    0.7.0.1
 */