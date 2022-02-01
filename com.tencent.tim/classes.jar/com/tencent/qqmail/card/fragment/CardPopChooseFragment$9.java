package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.view.CardAvatarChooseView;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.view.QMTopBar;
import java.util.List;

class CardPopChooseFragment$9
  implements View.OnClickListener
{
  CardPopChooseFragment$9(CardPopChooseFragment paramCardPopChooseFragment, CardAvatarChooseView paramCardAvatarChooseView, MailContact paramMailContact) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    Object localObject = this.val$cardAvatar;
    if (!this.val$cardAvatar.getChecked())
    {
      bool1 = true;
      ((CardAvatarChooseView)localObject).setChecked(bool1);
      if (!this.val$cardAvatar.getChecked()) {
        break label137;
      }
      CardPopChooseFragment.access$1500(this.this$0).add(this.val$contact);
      if (!CardPopChooseFragment.access$1600(this.this$0).contains(this.val$contact)) {
        CardPopChooseFragment.access$1600(this.this$0).add(this.val$contact);
      }
      label89:
      localObject = CardPopChooseFragment.access$1700(this.this$0).getButtonRight();
      if (CardPopChooseFragment.access$1500(this.this$0).size() <= 0) {
        break label157;
      }
    }
    label137:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((View)localObject).setEnabled(bool1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
      CardPopChooseFragment.access$1500(this.this$0).remove(this.val$contact);
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.9
 * JD-Core Version:    0.7.0.1
 */