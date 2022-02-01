package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.maillist.fragment.ConvMailListFragment;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.watcher.SearchMailWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment;

class SearchListFragment$17
  implements AdapterView.OnItemClickListener
{
  SearchListFragment$17(SearchListFragment paramSearchListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= SearchListFragment.access$3200(this.this$0).getHeaderViewsCount();
    Mail localMail;
    Object localObject;
    if ((paramView instanceof MailListItemView))
    {
      localMail = SearchListFragment.access$100(this.this$0).getItem(paramInt);
      if (localMail == null) {}
      SearchListFragment.access$1800(this.this$0);
      if (localMail.getStatus().isConversation()) {
        if (SearchListFragment.access$100(this.this$0).isLocalItem(paramInt))
        {
          localObject = new ConvMailListFragment(SearchListFragment.access$1500(this.this$0), localMail.getInformation().getFolderId(), localMail.getInformation().getId(), SearchListFragment.access$1700(this.this$0).getItemIds());
          this.this$0.hideKeyBoard();
          this.this$0.startFragment((BaseFragment)localObject);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject = new ConvMailListFragment(SearchListFragment.access$1500(this.this$0), 110, localMail.getInformation().getId(), SearchListFragment.access$1700(this.this$0).getItemIds());
      break;
      localObject = new ReadMailFragment(SearchListFragment.access$1500(this.this$0), SearchListFragment.access$800(this.this$0), localMail.getInformation().getId(), SearchListFragment.access$3300(this.this$0), SearchListFragment.access$1700(this.this$0).getItemIdsInFuture());
      ((ReadMailFragment)localObject).reuseMailData(localMail);
      if (!FolderLockDialog.isFolderLock(localMail.getInformation().getFolderId())) {
        break;
      }
      SearchListFragment.access$3000(this.this$0);
      this.this$0.hideKeyBoard();
      continue;
      if (SearchListFragment.access$1900(this.this$0).trim().length() != 0) {
        break label297;
      }
      QMLog.log(5, "SearchListFragment", "searchContent empty");
    }
    label297:
    if (!SearchListFragment.access$000(this.this$0))
    {
      if (!SearchListFragment.access$3400(this.this$0)) {
        break label348;
      }
      ((SearchMailWatcher)Watchers.of(SearchMailWatcher.class)).onComplete();
    }
    for (;;)
    {
      this.this$0.hideKeyBoard();
      SearchListFragment.access$1800(this.this$0);
      break;
      label348:
      SearchListFragment.access$002(this.this$0, true);
      SearchListFragment.access$100(this.this$0).setMoreLoading(true);
      SearchListFragment.access$100(this.this$0).getCursor().loadMore();
      SearchListFragment.access$100(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.17
 * JD-Core Version:    0.7.0.1
 */