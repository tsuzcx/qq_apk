package com.tencent.biz.pubaccount.readinjoy.video;

import awit;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kxm;
import myp;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(myp parammyp) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    myp.a(this.this$0, awit.I(localQQAppInterface));
    myp.b(this.this$0, awit.J(localQQAppInterface));
    myp.a(this.this$0, awit.a(localQQAppInterface));
    myp.c(this.this$0, awit.K(localQQAppInterface));
    if ((myp.a(this.this$0) < 0.0F) || (myp.a(this.this$0) > 1.0D)) {
      myp.a(this.this$0, 0.8F);
    }
    if (myp.a(this.this$0) < 1000) {
      myp.b(this.this$0, 40000);
    }
    if (myp.b(this.this$0) == 1) {
      myp.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + myp.a(this.this$0) + ", mStrategyID = " + myp.b(this.this$0) + ", mStrategyDurationLimit = " + myp.a(this.this$0) + ", mStrategyDurationPercent = " + myp.a(this.this$0) + ", mOperator = " + myp.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */