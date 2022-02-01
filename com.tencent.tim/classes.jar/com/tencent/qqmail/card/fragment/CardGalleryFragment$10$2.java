package com.tencent.qqmail.card.fragment;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class CardGalleryFragment$10$2
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  CardGalleryFragment$10$2(CardGalleryFragment.10 param10, QMBottomDialog.BottomListSheetBuilder paramBottomListSheetBuilder) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    this.val$builder.setCheckedIndex(paramInt);
    paramInt = Integer.parseInt(paramString);
    CardGalleryFragment.access$900(this.this$1.this$0, paramInt);
    CardGalleryFragment.access$2300(this.this$1.this$0, true);
    CardGalleryFragment.access$2400(this.this$1.this$0);
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.10.2
 * JD-Core Version:    0.7.0.1
 */