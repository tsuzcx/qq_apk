package com.tencent.qqmail.card.fragment;

import android.content.res.Resources;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;

class CardGalleryFragment$3
  implements Runnable
{
  CardGalleryFragment$3(CardGalleryFragment paramCardGalleryFragment, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = CardGalleryFragment.access$800(this.this$0).getAllCardTypeList();
    int i;
    if ((CardGalleryFragment.access$000(this.this$0) == -1) && (localArrayList.size() > 0))
    {
      i = ((QMCardType)localArrayList.get(0)).getTypeId();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        QMCardType localQMCardType = (QMCardType)localIterator.next();
        if (localQMCardType.isDefault()) {
          i = localQMCardType.getTypeId();
        }
      }
    }
    for (;;)
    {
      CardGalleryFragment.access$900(this.this$0, i);
      CardGalleryFragment.access$102(this.this$0, localArrayList);
      if (!this.this$0.getResources().getString(2131691287).equals(CardGalleryFragment.access$1000(this.this$0).getTitle())) {
        CardGalleryFragment.access$1300(this.this$0, new CardGalleryFragment.3.1(this));
      }
      CardGalleryFragment.access$200(this.this$0).refresh(this.val$forceReload, CardGalleryFragment.access$1400(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.3
 * JD-Core Version:    0.7.0.1
 */