package com.tencent.mobileqq.apollo.process.ui.framework;

import android.view.View;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;

class QzoneGameFloatView$1
  implements Runnable
{
  QzoneGameFloatView$1(QzoneGameFloatView paramQzoneGameFloatView, int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    if (this.cqL == 1) {
      QzoneGameFloatView.a(this.this$0, true);
    }
    for (;;)
    {
      if ((this.h != null) && (this.h.mGameType == 5))
      {
        QzoneGameFloatView.b(this.this$0, true);
        QzoneGameFloatView.c(this.this$0, true);
        if ((this.this$0.AR != null) && (this.this$0.AR.getVisibility() == 0)) {
          this.this$0.AR.setVisibility(8);
        }
      }
      return;
      QzoneGameFloatView.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView.1
 * JD-Core Version:    0.7.0.1
 */