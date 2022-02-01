package com.tencent.mobileqq.filemanager.app;

import agiq;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(agiq paramagiq, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.aO.containsKey("troop_video_preivew")) || (!this.aO.containsKey("troop_video_preivew_for_svip")) || (!this.aO.containsKey("troop_video_preivew_for_yearsvip")) || (!this.aO.containsKey("enable_file_media_platform"))) {
      return;
    }
    agiq.a(this.this$0, this.aO.getBoolean("troop_video_preivew", false));
    agiq.b(this.this$0, this.aO.getBoolean("troop_video_preivew_for_svip", false));
    agiq.c(this.this$0, this.aO.getBoolean("troop_video_preivew_for_yearsvip", false));
    agiq.d(this.this$0, this.aO.getBoolean("enable_file_media_platform", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + agiq.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + agiq.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + agiq.c(this.this$0) + "] UseMediaPlatform enabled[" + agiq.d(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */