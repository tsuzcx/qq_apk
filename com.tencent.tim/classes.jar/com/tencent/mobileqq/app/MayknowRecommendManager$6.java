package com.tencent.mobileqq.app;

import achg;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class MayknowRecommendManager$6
  implements Runnable
{
  public MayknowRecommendManager$6(achg paramachg, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, real start, entryType = " + this.cws, new Object[0]));
    ((FriendListHandler)achg.a(this.this$0).getBusinessHandler(1)).a(null, null, this.cws, this.ab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.6
 * JD-Core Version:    0.7.0.1
 */