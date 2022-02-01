package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.onBottomDialogDismissListener;

class BottleConversationFragment$19
  implements QMBottomDialog.onBottomDialogDismissListener
{
  BottleConversationFragment$19(BottleConversationFragment paramBottleConversationFragment, View paramView, boolean[] paramArrayOfBoolean) {}
  
  public void onDismiss()
  {
    if ((this.val$view != null) && (this.val$controllerSelected[0] != 0)) {
      this.val$view.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.19
 * JD-Core Version:    0.7.0.1
 */