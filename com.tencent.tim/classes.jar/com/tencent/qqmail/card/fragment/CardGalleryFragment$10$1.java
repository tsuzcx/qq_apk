package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.onBottomDialogDismissListener;
import java.util.ArrayList;
import java.util.Iterator;

class CardGalleryFragment$10$1
  implements QMBottomDialog.onBottomDialogDismissListener
{
  CardGalleryFragment$10$1(CardGalleryFragment.10 param10) {}
  
  public void onDismiss()
  {
    if ((CardGalleryFragment.access$2200(this.this$1.this$0) != null) && (CardGalleryFragment.access$2200(this.this$1.this$0).size() > 0))
    {
      Iterator localIterator = CardGalleryFragment.access$2200(this.this$1.this$0).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        CardGalleryFragment.access$800(this.this$1.this$0).handleTypeListRedDot(i);
      }
      CardGalleryFragment.access$2200(this.this$1.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.10.1
 * JD-Core Version:    0.7.0.1
 */