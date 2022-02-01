package com.tencent.qqmail.bottle.fragment;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleConversationController.LoadConversationError;
import com.tencent.qqmail.bottle.controller.BottleConversationController.UpdateConversationWatcher;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;
import com.tencent.qqmail.bottle.view.ReplyListView;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.QMContentLoadingView;

class BottleConversationFragment$35
  implements BottleConversationController.UpdateConversationWatcher
{
  BottleConversationFragment$35(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleConversationFragment", "mUpdateConversationWatcher onError:" + paramQMNetworkError);
    if ((paramQMNetworkError instanceof BottleConversationController.LoadConversationError))
    {
      BottleConversationController.LoadConversationError localLoadConversationError = (BottleConversationController.LoadConversationError)paramQMNetworkError;
      if (localLoadConversationError.code == -20001)
      {
        QMContentLoadingView localQMContentLoadingView = BottleConversationFragment.access$3600(this.this$0);
        if (StringExtention.isNullOrEmpty(localLoadConversationError.desp)) {}
        for (paramQMNetworkError = this.this$0.getString(2131690974);; paramQMNetworkError = localLoadConversationError.desp)
        {
          localQMContentLoadingView.showTips(paramQMNetworkError);
          BottleConversationFragment.access$400(this.this$0).setVisibility(8);
          BottleConversationFragment.access$3300(this.this$0, false);
          return;
        }
      }
    }
    if (StringExtention.isNullOrEmpty(paramQMNetworkError.desp)) {}
    for (paramQMNetworkError = this.this$0.getResources().getString(2131690974); BottleConversationFragment.access$1600(this.this$0).getCount() == 0; paramQMNetworkError = paramQMNetworkError.desp)
    {
      BottleConversationFragment.access$3300(this.this$0, false);
      BottleConversationFragment.access$3600(this.this$0).showTipsReload(paramQMNetworkError, BottleConversationFragment.access$3700(this.this$0));
      BottleConversationFragment.access$400(this.this$0).setVisibility(8);
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131697354), 1).show();
  }
  
  public void onSuccessInMainThread(BottleConversationCursor paramBottleConversationCursor)
  {
    BottleConversationFragment.access$3100(this.this$0, paramBottleConversationCursor.getUin());
    if (BottleConversationFragment.access$3200(this.this$0))
    {
      BottleConversationFragment.access$3300(this.this$0, true);
      BottleConversationFragment.access$2800(this.this$0, paramBottleConversationCursor, false);
      if ((BottleConversationFragment.access$1100(this.this$0)) && (!BottleConversationFragment.access$2400(this.this$0))) {
        BottleConversationFragment.access$400(this.this$0).expandWithoutAnimation();
      }
    }
    do
    {
      return;
      if (BottleConversationFragment.access$3400(this.this$0) != 2) {
        break;
      }
      BottleConversationFragment.access$3300(this.this$0, true);
      BottleConversationFragment.access$2800(this.this$0, paramBottleConversationCursor, false);
    } while ((!BottleConversationFragment.access$1100(this.this$0)) || (BottleConversationFragment.access$2400(this.this$0)));
    BottleConversationFragment.access$400(this.this$0).expandWithoutAnimation();
    return;
    if (BottleConversationFragment.access$3500(this.this$0) != null) {
      BottleConversationFragment.access$3500(this.this$0).close();
    }
    BottleConversationFragment.access$3502(this.this$0, paramBottleConversationCursor);
    BottleConversationFragment.access$2800(this.this$0, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.35
 * JD-Core Version:    0.7.0.1
 */