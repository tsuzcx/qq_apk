package com.tencent.qqmail.card.fragment;

import android.util.Log;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.view.CardGallery;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import java.util.ArrayList;
import java.util.HashMap;

class CardGalleryFragment$2
  extends QMRefreshCallback
{
  CardGalleryFragment$2(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onBeforeRefresh() {}
  
  public void onRefreshComplete()
  {
    boolean bool = true;
    int i = 0;
    if ((CardGalleryFragment.access$100(this.this$0) != null) && (CardGalleryFragment.access$100(this.this$0).size() > 0)) {
      if (CardGalleryFragment.access$000(this.this$0) != 1) {
        break label66;
      }
    }
    while (CardGalleryFragment.access$200(this.this$0).getCount() == 0)
    {
      CardGalleryFragment.access$300(this.this$0);
      CardGalleryFragment.access$700(this.this$0);
      return;
      label66:
      bool = false;
    }
    CardGalleryFragment.access$400(this.this$0).render(CardGalleryFragment.access$200(this.this$0), bool);
    CardGalleryFragment.access$500(this.this$0);
    Integer localInteger = (Integer)CardGalleryFragment.access$600(this.this$0).get(Integer.valueOf(CardGalleryFragment.access$000(this.this$0)));
    Log.d("CardGalleryFragment", "refreshCallback pos: " + localInteger + ", type: " + CardGalleryFragment.access$000(this.this$0));
    CardGallery localCardGallery = CardGalleryFragment.access$400(this.this$0);
    if (localInteger == null) {}
    for (;;)
    {
      localCardGallery.setSelection(i);
      break;
      i = localInteger.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.2
 * JD-Core Version:    0.7.0.1
 */