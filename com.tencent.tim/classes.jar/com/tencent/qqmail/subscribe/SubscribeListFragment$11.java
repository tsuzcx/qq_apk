package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.view.QMSubscribeListItemView.OnArticleLongClickListener;
import java.util.ArrayList;

class SubscribeListFragment$11
  implements QMSubscribeListItemView.OnArticleLongClickListener
{
  SubscribeListFragment$11(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onLongClick(Object paramObject, int paramInt)
  {
    paramInt = Integer.parseInt(String.valueOf(paramObject));
    QMSubscribeListItem localQMSubscribeListItem = SubscribeListFragment.access$1100(this.this$0).getItem(paramInt);
    if (localQMSubscribeListItem != null) {}
    for (paramObject = localQMSubscribeListItem.getArticleList();; paramObject = null)
    {
      if ((paramObject != null) && (!paramObject.isEmpty()))
      {
        paramObject = (SubscribeMailUI)paramObject.get(0);
        SubscribeListFragment.access$1400(this.this$0, localQMSubscribeListItem.getSender(), new SubscribeListFragment.11.1(this, paramObject));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.11
 * JD-Core Version:    0.7.0.1
 */