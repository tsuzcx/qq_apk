package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.controller.BottleThrowController.BottleThrowError;
import com.tencent.qqmail.bottle.controller.BottleThrowController.OnBottleThrowWatcher;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.view.QMTopBar;

class BottleThrowFragment$7
  implements BottleThrowController.OnBottleThrowWatcher
{
  BottleThrowFragment$7(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError, BottleConversationCursor paramBottleConversationCursor)
  {
    QMLog.log(6, "BottleThrowFragment", "mThrowWatcher onErrorInMainThread error:" + paramQMNetworkError);
    if ((this.this$0.isAttachedToActivity()) && (this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
      this.this$0.getTopBar().getButtonRight().setEnabled(true);
    }
    if (((paramQMNetworkError instanceof BottleThrowController.BottleThrowError)) && (((BottleThrowController.BottleThrowError)paramQMNetworkError).code == -20005)) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131721116)).setMessage(this.this$0.getString(2131691013, new Object[] { Integer.valueOf(5) })).addAction(2131696547, new BottleThrowFragment.7.1(this))).create().show();
    }
  }
  
  public void onSuccessInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor)
  {
    QMLog.log(4, "BottleThrowFragment", "mThrowWatcher onSuccessInMainThread");
  }
  
  public void onSuccessToWriteDBInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor)
  {
    QMLog.log(4, "BottleThrowFragment", "mThrowWatcher onSuccessToWriteDBInMainThread");
    BottleThrowFragment.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.7
 * JD-Core Version:    0.7.0.1
 */