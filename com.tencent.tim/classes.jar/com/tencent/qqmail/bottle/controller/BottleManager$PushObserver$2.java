package com.tencent.qqmail.bottle.controller;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.bottle.fragment.BottleBeachFragment;
import com.tencent.qqmail.bottle.fragment.BottleConversationFragment;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.bottle.fragment.BottleListFragment;

class BottleManager$PushObserver$2
  implements Runnable
{
  BottleManager$PushObserver$2(BottleManager.PushObserver paramPushObserver, Object paramObject, BottleManager paramBottleManager) {}
  
  public void run()
  {
    String str = (String)((JSONObject)this.val$data).get("mailid");
    Activity localActivity;
    int i;
    if (str != null)
    {
      localActivity = QMActivityManager.shareInstance().getVisibleActivity();
      if ((localActivity == null) || (!(localActivity instanceof BottleFragmentActivity))) {
        break label158;
      }
      if (!(((BottleFragmentActivity)localActivity).getCurrentFragment() instanceof BottleBeachFragment)) {
        break label80;
      }
      i = 1;
    }
    label158:
    for (;;)
    {
      if (i != 0) {
        BottleListController_BottleListOverdueDataORM.update(this.val$manager.mDBOpenHelper.getReadableDatabase(), new BottleListController.BottleListOverdueData(str, true));
      }
      return;
      label80:
      if ((((BottleFragmentActivity)localActivity).getCurrentFragment() instanceof BottleListFragment))
      {
        this.val$manager.mBottleListController.refreshList();
        i = 0;
      }
      else if (((((BottleFragmentActivity)localActivity).getCurrentFragment() instanceof BottleConversationFragment)) && (str.equals(((BottleConversationFragment)((BottleFragmentActivity)localActivity).getCurrentFragment()).getBottleId())))
      {
        this.val$manager.mBottleConversationController.refreshConversation(str, null);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.PushObserver.2
 * JD-Core Version:    0.7.0.1
 */