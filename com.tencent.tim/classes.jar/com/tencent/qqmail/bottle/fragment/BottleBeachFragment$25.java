package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleBeachController.BottleSpamWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class BottleBeachFragment$25
  implements BottleBeachController.BottleSpamWatcher
{
  BottleBeachFragment$25(BottleBeachFragment paramBottleBeachFragment) {}
  
  public void onBottleSpamWatcher(int paramInt, String paramString1, String paramString2)
  {
    QMLog.log(4, "BottleBeachFragment", "onBottleSpamWatcher:" + paramInt + ",title:" + paramString1 + ",content:" + paramString2);
    BottleBeachFragment.access$702(this.this$0, paramInt);
    if ((paramInt != BottleBeachFragment.access$2300(this.this$0)) && (!SharedPreferenceUtil.isBottleSpamBlockClose(BottleBeachFragment.access$600(this.this$0), paramInt))) {
      BottleBeachFragment.access$2500(this.this$0, new BottleBeachFragment.25.1(this, paramString1, paramString2));
    }
    while (paramInt != BottleBeachFragment.access$2300(this.this$0)) {
      return;
    }
    SharedPreferenceUtil.setBottleSpamHashClose(BottleBeachFragment.access$600(this.this$0), BottleBeachFragment.access$2600(this.this$0), false);
    SharedPreferenceUtil.setBottleSpamHashClose(BottleBeachFragment.access$600(this.this$0), BottleBeachFragment.access$2700(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.25
 * JD-Core Version:    0.7.0.1
 */