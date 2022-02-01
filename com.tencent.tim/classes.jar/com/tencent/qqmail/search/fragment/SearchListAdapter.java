package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.SearchListViewHelper;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.log.QMLog;

public class SearchListAdapter
  extends QMMailListAdapter
{
  public static final int TYPE_DATA = 0;
  public static final int TYPE_LOAD_MORE = 1;
  private final String TAG = "SearchListAdapter";
  private Mail[] cacheItem = null;
  private long getViewMaxElapsedTime = 0L;
  private final int getViewNormalElapsedTime = 30;
  private int getViewSlowCount = 0;
  private int getViewTotalCount = 0;
  private long getViewTotalElapsedTime = 0L;
  private boolean isError = false;
  private boolean isMoreLoading = false;
  protected QMSearchCursor mSearchCursor = null;
  private boolean showAvatar = false;
  
  public SearchListAdapter(Context paramContext, int paramInt, IMailListCursor paramIMailListCursor, ListView paramListView)
  {
    super(paramContext, paramInt, paramIMailListCursor, paramListView);
    this.mSearchCursor = ((QMSearchCursor)paramIMailListCursor);
    this.showAvatar = QMSettingManager.sharedInstance().getMailListIcon();
  }
  
  private void closeCursor()
  {
    if (this.mSearchCursor != null)
    {
      this.cacheItem = null;
      this.mSearchCursor.close();
      this.mSearchCursor.cleanRemoteSearchMails();
      this.mSearchCursor.cleanSearchMailQueue();
    }
  }
  
  public boolean canSearchRemote()
  {
    return this.mSearchCursor.canSearchRemote();
  }
  
  public void destroy()
  {
    try
    {
      closeCursor();
      this.mSearchCursor = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.mSearchCursor == null) {
      return 0;
    }
    if (canSearchRemote()) {
      i = 1;
    }
    return i + this.mSearchCursor.getCount();
  }
  
  public IMailListCursor getCursor()
  {
    return this.mSearchCursor;
  }
  
  public Mail getItem(int paramInt)
  {
    if ((this.cacheItem == null) || (this.cursor.getCount() != this.cacheItem.length)) {
      this.cacheItem = new Mail[this.cursor.getCount()];
    }
    if ((paramInt < this.cacheItem.length) && (paramInt > -1))
    {
      if (this.cacheItem[paramInt] == null) {
        this.cacheItem[paramInt] = this.mSearchCursor.getItem(paramInt);
      }
      return this.cacheItem[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Mail localMail = getItem(paramInt);
    if (localMail != null) {
      return localMail.getInformation().getId();
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    int i;
    int j;
    if ((getItemViewType(paramInt) == 1) && (canSearchRemote())) {
      if (paramView == null)
      {
        i = 1;
        if ((paramView instanceof MailListMoreItemView)) {
          break label175;
        }
        j = 1;
        label38:
        if ((i | j) == 0) {
          break label215;
        }
        paramView = new MailListMoreItemView(this.context);
      }
    }
    label83:
    label215:
    for (;;)
    {
      MailListMoreItemView localMailListMoreItemView = (MailListMoreItemView)paramView;
      long l2;
      if (this.isMoreLoading)
      {
        localMailListMoreItemView.showLoading(true);
        localMailListMoreItemView.setEnabled(false);
        l2 = System.currentTimeMillis() - l1;
        if (l2 > 30L) {
          this.getViewSlowCount += 1;
        }
        if (this.getViewMaxElapsedTime <= l2) {
          break label208;
        }
      }
      for (l1 = this.getViewMaxElapsedTime;; l1 = l2)
      {
        this.getViewMaxElapsedTime = l1;
        this.getViewTotalCount += 1;
        this.getViewTotalElapsedTime += l2;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        i = 0;
        break;
        j = 0;
        break label38;
        showMoreItemView(this.isError, localMailListMoreItemView);
        break label83;
        paramView = SearchListViewHelper.bindItemData(paramInt, paramView, this, this.showAvatar);
        break label83;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean hasMoreMail()
  {
    if (this.mSearchCursor == null) {
      return true;
    }
    return this.mSearchCursor.canLoadMore();
  }
  
  public boolean isLocalItem(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mSearchCursor != null)
    {
      bool1 = bool2;
      if (paramInt <= this.mSearchCursor.getLocalCount() - 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void printGetViewStatistics()
  {
    if (this.getViewTotalCount != 0) {}
    for (int i = this.getViewTotalCount;; i = 1)
    {
      QMLog.log(4, "SearchListAdapter", "getViewStatistics AverageTime:" + this.getViewTotalElapsedTime / i + ", getViewMaxElapsedTime:" + this.getViewMaxElapsedTime + ", getViewSlowRatio:" + this.getViewSlowCount / i);
      return;
    }
  }
  
  public void resetCursor()
  {
    try
    {
      closeCursor();
      notifyDataSetChanged();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void resetCursorAndNotCleanRemoteSearchMails()
  {
    try
    {
      if (this.mSearchCursor != null)
      {
        this.cacheItem = null;
        this.mSearchCursor.close();
        this.mSearchCursor.cleanSearchMailQueue();
      }
      notifyDataSetChanged();
      return;
    }
    finally {}
  }
  
  public void setCursor(QMSearchCursor paramQMSearchCursor)
  {
    if (this.mSearchCursor != paramQMSearchCursor)
    {
      this.cacheItem = null;
      if (this.mSearchCursor != null) {
        this.mSearchCursor.close();
      }
      this.mSearchCursor = paramQMSearchCursor;
    }
  }
  
  public void setError(boolean paramBoolean)
  {
    if (this.isError != paramBoolean)
    {
      this.isError = paramBoolean;
      this.isMoreLoading = false;
    }
  }
  
  public void setMoreLoading(boolean paramBoolean)
  {
    if (this.isMoreLoading != paramBoolean)
    {
      this.isError = false;
      this.isMoreLoading = paramBoolean;
    }
  }
  
  protected void showMoreItemView(boolean paramBoolean, MailListMoreItemView paramMailListMoreItemView)
  {
    if (paramBoolean)
    {
      paramMailListMoreItemView.showTips(2131719316);
      paramMailListMoreItemView.setEnabled(true);
      return;
    }
    if (hasMoreMail())
    {
      paramMailListMoreItemView.showTips(2131719324);
      paramMailListMoreItemView.setEnabled(true);
      return;
    }
    paramMailListMoreItemView.showTips(2131719315);
    paramMailListMoreItemView.setEnabled(false);
  }
  
  public void update(Runnable paramRunnable)
  {
    try
    {
      update(paramRunnable, false);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void update(Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      if (this.mSearchCursor != null) {
        this.mSearchCursor.asyncSearch(new SearchListAdapter.1(this), new SearchListAdapter.2(this, paramRunnable), paramBoolean);
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void updateRemote(boolean paramBoolean)
  {
    try
    {
      if (this.mSearchCursor != null)
      {
        if (paramBoolean) {
          this.mSearchCursor.setCanLoadMore(false);
        }
        this.mSearchCursor.refreshRemoteSearchCursor();
        notifyDataSetChanged();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListAdapter
 * JD-Core Version:    0.7.0.1
 */