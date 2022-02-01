package com.tencent.qqmini.minigame.ui;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameRuntimeStateObserver$6
  implements ITTEngine.OnGetTraceRecordCallback
{
  GameRuntimeStateObserver$6(GameRuntimeStateObserver paramGameRuntimeStateObserver, boolean paramBoolean) {}
  
  public void onGetTraceRecord(@NonNull TraceStatistics paramTraceStatistics)
  {
    if (GameRuntimeStateObserver.access$400(this.this$0) != null) {}
    for (String str = GameRuntimeStateObserver.access$400(this.this$0).appId;; str = "")
    {
      MiniGameBeaconReport.reportJankTraceRecords(paramTraceStatistics, str, true, this.val$isFirstFrame);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.6
 * JD-Core Version:    0.7.0.1
 */