package com.tencent.qqmail.inquirymail.fragment;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.inquirymail.adapter.InquiryMailListAdapter;
import com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor;
import com.tencent.qqmail.inquirymail.watcher.AddToWhiteListWatcher;
import com.tencent.qqmail.inquirymail.watcher.LoadInquiryMailWatcher;
import com.tencent.qqmail.inquirymail.watcher.RemoveBlackListWatcher;
import com.tencent.qqmail.inquirymail.watcher.RetrieveMailWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.base.SaveArgumentField;

public class InquiryMailListFragment
  extends InquiryMailBaseFragment
{
  public static final String TAG = "InquiryMailListFragment";
  private Account account;
  @SaveArgumentField
  private int accountId;
  private InquiryMailListAdapter adapter;
  private AddToWhiteListWatcher addToWhiteListWatcher = new InquiryMailListFragment.3(this);
  private QMBaseView baseView;
  private Future<InquiryMailListCursor> cursor;
  private TextView footerView;
  private boolean hasAddFooterView;
  private boolean isRefreshData;
  private ListView listView;
  private LoadInquiryMailWatcher loadInquiryMailWatcher = new InquiryMailListFragment.1(this);
  private QMContentLoadingView loadingView;
  private RemoveBlackListWatcher removeBlackListWatcher = new InquiryMailListFragment.4(this);
  private RetrieveMailWatcher retrieveMailWatcher = new InquiryMailListFragment.2(this);
  
  public InquiryMailListFragment(int paramInt)
  {
    super(true);
    this.accountId = paramInt;
    setDataSource();
  }
  
  private void doRender()
  {
    switch (getDataSource().getState())
    {
    default: 
      return;
    case 1: 
      if (getDataSource().getCount() <= 0)
      {
        renderLoading();
        return;
      }
      renderTopBarLoading(true);
      renderList();
      return;
    case 0: 
      if (getDataSource().getCount() <= 0)
      {
        renderEmpty();
        return;
      }
      renderList();
      return;
    }
    if (getDataSource().getCount() <= 0)
    {
      renderList();
      return;
    }
    renderList();
  }
  
  private InquiryMailListCursor getDataSource()
  {
    try
    {
      if (this.cursor != null)
      {
        InquiryMailListCursor localInquiryMailListCursor = (InquiryMailListCursor)this.cursor.get();
        return localInquiryMailListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "InquiryMailListFragment", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private void initFooterView()
  {
    this.footerView = new TextView(getActivity());
    this.footerView.setText(getString(2131694995));
    this.footerView.setTextColor(getResources().getColor(2131167531));
    this.footerView.setPadding(getResources().getDimensionPixelSize(2131297535), getResources().getDimensionPixelSize(2131297534), getResources().getDimensionPixelSize(2131297535), getResources().getDimensionPixelSize(2131297534));
    this.footerView.setGravity(17);
    this.footerView.setBackgroundColor(getResources().getColor(2131167654));
    this.footerView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
  }
  
  private void initListView()
  {
    this.listView.setDivider(null);
    this.listView.setDividerHeight(0);
    this.listView.setOnItemClickListener(new InquiryMailListFragment.8(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(this.account.getEmail());
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new InquiryMailListFragment.7(this));
  }
  
  private void operationDone(boolean paramBoolean)
  {
    if (getDataSource() == null) {
      return;
    }
    getDataSource().refresh(false, new InquiryMailListFragment.6(this, paramBoolean));
  }
  
  private void renderEmpty()
  {
    this.loadingView.showTips(2131695606);
  }
  
  private void renderList()
  {
    this.loadingView.hide();
    if (getDataSource().canLoadMore()) {
      if ((this.listView.getFooterViewsCount() > 0) && (this.hasAddFooterView))
      {
        this.listView.removeFooterView(this.footerView);
        this.hasAddFooterView = false;
      }
    }
    while (this.adapter != null)
    {
      this.adapter.notifyDataSetChanged();
      return;
      if ((this.listView.getFooterViewsCount() == 0) && (!this.hasAddFooterView))
      {
        this.listView.addFooterView(this.footerView);
        this.hasAddFooterView = true;
        if ((Build.VERSION.SDK_INT < 19) && (this.listView.getAdapter() != null) && (!(this.listView.getAdapter() instanceof HeaderViewListAdapter)) && (this.adapter != null)) {
          this.listView.setAdapter(this.adapter);
        }
      }
    }
    this.adapter = new InquiryMailListAdapter(getActivity(), this.listView, getDataSource());
    this.listView.setAdapter(this.adapter);
  }
  
  private void renderLoading()
  {
    this.loadingView.showLoading(true);
  }
  
  private void renderLoadingMore(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.adapter == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.adapter.setMoreLoading();
      return;
    }
    this.adapter.setMoreLoadingNormal(paramBoolean2);
  }
  
  private void renderTopBarLoading(boolean paramBoolean)
  {
    getTopBar().showLoading(paramBoolean);
  }
  
  private void setDataSource()
  {
    this.cursor = Threads.submitTask(new InquiryMailListFragment.5(this));
  }
  
  private void showTipsError(int paramInt)
  {
    runOnMainThread(new InquiryMailListFragment.10(this, paramInt));
  }
  
  private void showTipsLoading(int paramInt)
  {
    runOnMainThread(new InquiryMailListFragment.9(this, paramInt));
  }
  
  private void showTipsSuccess(int paramInt)
  {
    runOnMainThread(new InquiryMailListFragment.11(this, paramInt));
  }
  
  public void initDataSource()
  {
    DataCollector.logEvent("Event_Received_Mail_Show");
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initListView();
    initFooterView();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.loadingView = this.baseView.addListEmptyView();
    this.listView = this.baseView.addPtrListView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadInquiryMailWatcher, paramBoolean);
    Watchers.bind(this.retrieveMailWatcher, paramBoolean);
    Watchers.bind(this.addToWhiteListWatcher, paramBoolean);
    Watchers.bind(this.removeBlackListWatcher, paramBoolean);
  }
  
  public void onRelease()
  {
    this.adapter = null;
    this.listView.setAdapter(null);
    InquiryMailListCursor localInquiryMailListCursor = getDataSource();
    if (localInquiryMailListCursor != null) {
      localInquiryMailListCursor.close();
    }
  }
  
  public int refreshData()
  {
    if (this.isRefreshData)
    {
      InquiryMailListCursor localInquiryMailListCursor = getDataSource();
      if (localInquiryMailListCursor != null) {
        localInquiryMailListCursor.refresh(false, null);
      }
    }
    this.isRefreshData = true;
    return 0;
  }
  
  public void render(int paramInt)
  {
    doRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment
 * JD-Core Version:    0.7.0.1
 */