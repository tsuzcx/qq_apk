package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class BottleConversationFragment$18
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  BottleConversationFragment$18(BottleConversationFragment paramBottleConversationFragment, BottleConversation paramBottleConversation, boolean[] paramArrayOfBoolean, View paramView) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131690960)))
    {
      BottleConversationFragment.access$1300(this.this$0, this.val$bottleConversation);
      paramQMBottomDialog.dismiss();
      Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131692323), 1).show();
    }
    while (!paramString.equals(this.this$0.getString(2131690962))) {
      return;
    }
    this.val$controllerSelected[0] = false;
    paramQMBottomDialog.dismiss();
    BottleConversationFragment.access$900(this.this$0, this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.18
 * JD-Core Version:    0.7.0.1
 */