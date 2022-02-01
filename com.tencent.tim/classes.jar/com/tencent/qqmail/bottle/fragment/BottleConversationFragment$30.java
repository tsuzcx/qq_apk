package com.tencent.qqmail.bottle.fragment;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.controller.BottleThrowController.BottleThrowError;
import com.tencent.qqmail.bottle.controller.BottleThrowController.OnBottleThrowWatcher;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.view.ReplyListView;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleConversationFragment$30
  implements BottleThrowController.OnBottleThrowWatcher
{
  BottleConversationFragment$30(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleConversationFragment.access$2702(this.this$0, paramBottleConversationCursor);
    if (!BottleConversationFragment.access$1100(this.this$0))
    {
      BottleConversationFragment.access$2800(this.this$0, paramBottleConversationCursor, false);
      if ((paramQMNetworkError instanceof BottleThrowController.BottleThrowError))
      {
        paramQMNetworkError = (BottleThrowController.BottleThrowError)paramQMNetworkError;
        if (paramQMNetworkError.code != -20006) {
          break label70;
        }
        Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131690983), 1).show();
      }
    }
    label70:
    while (paramQMNetworkError.code != -20005) {
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131691013, new Object[] { Integer.valueOf(5) }), 1).show();
  }
  
  public void onSuccessInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleConversationFragment.access$2702(this.this$0, paramBottleConversationCursor);
    BottleConversationFragment.access$2800(this.this$0, paramBottleConversationCursor, false);
  }
  
  public void onSuccessToWriteDBInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleConversationFragment.access$400(this.this$0).setEditTextContent("");
    if (BottleConversationFragment.access$1100(this.this$0))
    {
      BottleConversationFragment.access$2900(this.this$0, 3);
      return;
    }
    BottleConversationFragment.access$2702(this.this$0, paramBottleConversationCursor);
    BottleConversationFragment.access$3002(this.this$0, true);
    BottleConversationFragment.access$2800(this.this$0, paramBottleConversationCursor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.30
 * JD-Core Version:    0.7.0.1
 */