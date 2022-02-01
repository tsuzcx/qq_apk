package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

class CardGalleryFragment$3$1
  implements Runnable
{
  CardGalleryFragment$3$1(CardGalleryFragment.3 param3) {}
  
  public void run()
  {
    CardGalleryFragment.access$1000(this.this$1.this$0).setTitle(CardGalleryFragment.access$1100(this.this$1.this$0));
    if ((CardGalleryFragment.access$100(this.this$1.this$0).size() > 0) && (CardGalleryFragment.access$1000(this.this$1.this$0) != null) && (CardGalleryFragment.access$1000(this.this$1.this$0).getOnlyButtonRight() != null)) {
      CardGalleryFragment.access$1000(this.this$1.this$0).getOnlyButtonRight().setEnabled(true);
    }
    if (CardGalleryFragment.access$000(this.this$1.this$0) == 2)
    {
      if (CardGalleryFragment.access$800(this.this$1.this$0).shouldShowBirthdayCake())
      {
        DataCollector.logEvent("Event_Card_Birthday_Button_Show");
        CardGalleryFragment.access$1200(this.this$1.this$0).setVisibility(0);
        return;
      }
      CardGalleryFragment.access$1200(this.this$1.this$0).setVisibility(8);
      return;
    }
    CardGalleryFragment.access$1200(this.this$1.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.3.1
 * JD-Core Version:    0.7.0.1
 */