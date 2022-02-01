package com.tencent.mobileqq.apollo.lightGame;

import abme;
import abmm;
import acfp;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.qphone.base.util.QLog;

public class CmGameLoadingView$2
  implements Runnable
{
  CmGameLoadingView$2(CmGameLoadingView paramCmGameLoadingView, CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong, CmGameStartChecker.b paramb) {}
  
  public void run()
  {
    if ((this.val$startCheckParam != null) && (this.val$startCheckParam.mLoadingOnMainProcess))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameLoadingView", 2, "onDownloadConfirm close gameUI");
      }
      abmm.a().i(this.val$startCheckParam);
    }
    String str = String.format(acfp.m(2131704107), new Object[] { Float.valueOf((float)this.NT * 1.0F / 1024.0F / 1024.0F) });
    this.this$0.setProgressViewVisibility(false);
    this.this$0.PL.setText(str);
    this.this$0.PL.setVisibility(0);
    this.this$0.fB.setVisibility(0);
    this.this$0.fB.setText(acfp.m(2131704100));
    this.this$0.fB.setOnClickListener(new abme(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.2
 * JD-Core Version:    0.7.0.1
 */