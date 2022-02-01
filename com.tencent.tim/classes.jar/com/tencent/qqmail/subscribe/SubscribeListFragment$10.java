package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.activity.webviewexplorer.SubscribeWebViewExplorer;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMSubscribeListItemView.OnArticleClickListener;
import java.util.ArrayList;

class SubscribeListFragment$10
  implements QMSubscribeListItemView.OnArticleClickListener
{
  SubscribeListFragment$10(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onClick(Object paramObject, int paramInt)
  {
    int i = Integer.parseInt(String.valueOf(paramObject));
    paramObject = SubscribeListFragment.access$1100(this.this$0).getItem(i);
    if (paramObject == null) {
      return;
    }
    ArrayList localArrayList = paramObject.getArticleList();
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (paramInt == 0)
      {
        DataCollector.logEvent("Event_Click_RSS_Mail");
        paramObject = new ReadMailFragment(0, ((SubscribeMailUI)localArrayList.get(0)).getSubscribe().getMid(), SubscribeListFragment.access$1500(this.this$0), SubscribeListFragment.access$000(this.this$0).getItemIdsInFuture());
        this.this$0.startFragmentForResult(paramObject, 106);
        return;
      }
      DataCollector.logEvent("Event_Click_RSS_Article");
      if (paramObject.useSnapShot())
      {
        paramObject = new ReadMailFragment(0, ((SubscribeMailUI)localArrayList.get(0)).getSubscribe().getMid(), SubscribeListFragment.access$1500(this.this$0), SubscribeListFragment.access$000(this.this$0).getItemIdsInFuture());
        this.this$0.startFragmentForResult(paramObject, 106);
        return;
      }
      paramObject = (SubscribeMailUI)localArrayList.get(paramInt - 1);
      paramObject = SubscribeWebViewExplorer.createIntent(this.this$0.getActivity(), paramObject.getSubscribe().getMid(), paramObject.getSubscribe().getPreviewUrl(), paramObject.getSubscribe().getSubject(), true, paramObject.getSubscribe().getBigIcon(), paramObject.getSubscribe().getIcon());
      this.this$0.startActivity(paramObject);
      return;
    }
    QMLog.log(6, "hill", i + ", subscribe mail article length is 0!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.10
 * JD-Core Version:    0.7.0.1
 */