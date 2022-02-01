package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

class CardGalleryFragment$10
  implements View.OnClickListener
{
  CardGalleryFragment$10(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onClick(View paramView)
  {
    CardGalleryFragment.access$1000(this.this$0).showRedDot(false);
    ArrayList localArrayList = CardGalleryFragment.access$100(this.this$0);
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      QMLog.log(4, "CardGalleryFragment", "select type 0");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity(), true);
    int j = 0;
    int k = 0;
    label71:
    QMCardType localQMCardType;
    int i;
    if (j < localArrayList.size())
    {
      localQMCardType = (QMCardType)localArrayList.get(j);
      switch (localQMCardType.getTypeId())
      {
      default: 
        i = 2130840880;
        label139:
        if ((CardGalleryFragment.access$2200(this.this$0) == null) || (CardGalleryFragment.access$2200(this.this$0).indexOf(Integer.valueOf(localQMCardType.getTypeId())) == -1)) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localBottomListSheetBuilder.addItem(i, localQMCardType.getTypeName(), String.valueOf(localQMCardType.getTypeId()), bool);
      if (CardGalleryFragment.access$000(this.this$0) == localQMCardType.getTypeId()) {
        k = j;
      }
      j += 1;
      break label71;
      i = 2130840879;
      break label139;
      i = 2130840873;
      break label139;
      i = 2130840877;
      break label139;
      i = 2130840878;
      break label139;
      i = 2130840874;
      break label139;
      i = 2130840876;
      break label139;
      localBottomListSheetBuilder.setCheckedIndex(k);
      localBottomListSheetBuilder.setOnBottomDialogDismissListener(new CardGalleryFragment.10.1(this));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new CardGalleryFragment.10.2(this, localBottomListSheetBuilder));
      localBottomListSheetBuilder.build().show();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.10
 * JD-Core Version:    0.7.0.1
 */