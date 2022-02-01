package com.tencent.mobileqq.minigame.api;

import acfp;
import android.content.Context;
import aqha;
import aqju;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class QQEnvImp$2
  implements Runnable
{
  QQEnvImp$2(QQEnvImp paramQQEnvImp, Context paramContext, DialogCallback paramDialogCallback) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.val$context, 230, null, GameWnsUtils.getGameErrorDialogContent(), acfp.m(2131711635), acfp.m(2131711636), new QQEnvImp.2.1(this), new QQEnvImp.2.2(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
    MiniReportManager.reportEventType(QQEnvImp.access$000(this.this$0).getGameInfoManager().getMiniAppConfig(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQEnvImp.2
 * JD-Core Version:    0.7.0.1
 */