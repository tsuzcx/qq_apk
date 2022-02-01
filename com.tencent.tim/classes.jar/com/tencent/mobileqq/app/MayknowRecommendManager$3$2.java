package com.tencent.mobileqq.app;

import achg;
import achj;
import com.tencent.qphone.base.util.QLog;

public class MayknowRecommendManager$3$2
  implements Runnable
{
  public MayknowRecommendManager$3$2(achj paramachj, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "isSuccess :" + this.bIj + " onAddReqStatesChanged: " + this.boz);
    }
    this.a.this$0.bG(this.boz, true);
    ((FriendListHandler)achg.a(this.a.this$0).getBusinessHandler(1)).notifyUI(108, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.3.2
 * JD-Core Version:    0.7.0.1
 */