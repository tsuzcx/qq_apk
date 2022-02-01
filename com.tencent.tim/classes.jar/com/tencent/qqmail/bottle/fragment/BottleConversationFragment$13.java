package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import java.util.ArrayList;

class BottleConversationFragment$13
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  BottleConversationFragment$13(BottleConversationFragment paramBottleConversationFragment, BottleConversation paramBottleConversation, ArrayList paramArrayList) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131690960)))
    {
      BottleConversationFragment.access$1300(this.this$0, this.val$bottleConversation);
      paramQMBottomDialog.dismiss();
      Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131692323), 1).show();
    }
    while (!paramString.equals(this.this$0.getString(2131690963))) {
      return;
    }
    ListViewRemoveItemAnimator.animateRemoval(BottleConversationFragment.access$400(this.this$0), this.val$array, new BottleConversationFragment.13.1(this));
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.13
 * JD-Core Version:    0.7.0.1
 */