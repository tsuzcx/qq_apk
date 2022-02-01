package com.tencent.qqmail.subscribe;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.ListViewHelper.OnHandleListScroll;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;
import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.SubscribeMailWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncSubscribeThumbWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.popularize.view.PopularizeSubscribeListView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMSubscribeListItemView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.app.ActivityCompat;
import moai.fragment.base.NullMailException;
import moai.fragment.base.SaveArgumentField;

public class SubscribeListFragment
  extends MailFragment
  implements ListViewHelper.OnHandleListScroll
{
  public static final String ARG_ACCOUNT_ID = "accountid";
  public static final int REQUEST_CODE_FROM_SUBSCRIBE = 106;
  public static final String TAG = "SubscribeListFragment";
  @SaveArgumentField
  private int accountId;
  private QMSubscribeListAdapter adapter;
  @SaveArgumentField
  private long aggregateType;
  private final MailDeleteWatcher deleteWatcher = new SubscribeListFragment.3(this);
  boolean hasAddBannerView = false;
  boolean hasAddSubscribeMailView = false;
  private boolean isFastScroll = false;
  private boolean isFirstEnter;
  private boolean isPreloaded = true;
  private Future<QMSubscribeColumnCursor> listCursor = null;
  private QMContentLoadingView listEmptyView;
  private PtrListView listView;
  private Mail mMail;
  private MailOperate mailOperate = new MailOperate();
  private MailListMoreItemView moreLoading;
  private PopularizeBanner popularizeBanner;
  private PopularizeSubscribeListView popularizeSubscribeListView;
  private SubscribeMailWatcher subscribeMailWatcher = new SubscribeListFragment.1(this);
  private SyncSubscribeThumbWatcher syncSubscribeThumbWatcher = new SubscribeListFragment.2(this);
  
  public SubscribeListFragment(int paramInt, long paramLong)
    throws NullMailException
  {
    super(true);
    this.accountId = paramInt;
    this.aggregateType = paramLong;
    this.mMail = QMMailManager.sharedInstance().getAggregateMail(paramInt, paramLong);
    if (this.mMail == null) {
      throw new NullMailException("accountId:" + paramInt + ", type:" + paramLong);
    }
    setDataSource(paramInt);
  }
  
  private void doRender()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() < 1))
    {
      renderLoading();
      return;
    }
    renderList();
  }
  
  private void doRenderError()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() < 1))
    {
      renderError();
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131720635), 0).show();
    renderList();
  }
  
  private QMSubscribeColumnCursor getDataSource()
  {
    try
    {
      if (this.listCursor != null)
      {
        QMSubscribeColumnCursor localQMSubscribeColumnCursor = (QMSubscribeColumnCursor)this.listCursor.get();
        return localQMSubscribeColumnCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "SubscribeListFragment", "getDataSource failed. " + localException.getMessage());
    }
    return null;
  }
  
  private void initListView()
  {
    ListViewHelper.addListScrollHandler(this.listView, this);
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(2);
  }
  
  private PopularizeSubscribeListView initPopularizeSubscribeView()
  {
    this.popularizeSubscribeListView = new PopularizeSubscribeListView(getActivity());
    this.popularizeSubscribeListView.setPage(2);
    this.popularizeSubscribeListView.setOnSubscribeItemClickListener(new SubscribeListFragment.7(this));
    this.popularizeSubscribeListView.setOnSubscribeItemLongClickListener(new SubscribeListFragment.8(this));
    return this.popularizeSubscribeListView;
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftOnclickListener(new SubscribeListFragment.9(this));
    localQMTopBar.setButtonLeftBack();
  }
  
  private void operationDone(Runnable paramRunnable)
  {
    if (getDataSource() == null) {
      return;
    }
    getDataSource().refresh(true, new SubscribeListFragment.4(this, paramRunnable));
  }
  
  private void refreshFooterLoadingView()
  {
    int i;
    if (this.adapter != null)
    {
      i = this.listView.getFooterViewsCount();
      if (((this.adapter.getCount() > 4) || (i <= 0)) && (this.adapter.cursorCanLoadMore())) {
        break label53;
      }
      this.listView.removeFooterView(this.moreLoading);
    }
    label53:
    while ((this.adapter.getCount() <= 4) || (i != 0) || (!this.adapter.cursorCanLoadMore())) {
      return;
    }
    this.listView.addFooterView(this.moreLoading);
  }
  
  private void refreshPopularizeView()
  {
    int i = this.popularizeBanner.getDataCount();
    if ((i > 0) && (!this.hasAddBannerView)) {}
    do
    {
      this.popularizeBanner.render(this.listView, false);
      for (;;)
      {
        if (this.isFirstEnter)
        {
          this.isFirstEnter = false;
          i = this.popularizeSubscribeListView.render(false);
          if ((i <= 0) || (this.hasAddSubscribeMailView)) {
            break;
          }
          this.listView.addHeaderView(this.popularizeSubscribeListView);
        }
        return;
        if ((i <= 0) && (this.hasAddBannerView)) {
          this.popularizeBanner.remove(this.listView);
        }
      }
    } while ((i > 0) || (!this.hasAddSubscribeMailView));
    this.listView.removeHeaderView(this.popularizeSubscribeListView);
  }
  
  private void renderError()
  {
    this.listEmptyView.showTips(2131720635);
    this.listView.setVisibility(8);
  }
  
  private void renderList()
  {
    this.listView.setVisibility(0);
    this.listEmptyView.hide();
    if (this.adapter != null)
    {
      refreshFooterLoadingView();
      this.adapter.updateCursor();
      this.adapter.notifyDataSetChanged();
    }
    for (;;)
    {
      refreshPopularizeView();
      return;
      DataCollector.logEvent("Event_Enter_RSS");
      this.adapter = new QMSubscribeListAdapter(getActivity(), getDataSource());
      this.adapter.setOnArticleClick(new SubscribeListFragment.10(this));
      this.adapter.setOnArticleLongClickListener(new SubscribeListFragment.11(this));
      this.popularizeBanner.render(this.listView, false);
      this.listView.addHeaderView(this.popularizeSubscribeListView);
      this.hasAddBannerView = true;
      this.hasAddSubscribeMailView = true;
      this.listView.addFooterView(this.moreLoading);
      this.listView.setAdapter(this.adapter);
      initListView();
      refreshFooterLoadingView();
    }
  }
  
  private void renderLoading()
  {
    this.listEmptyView.showLoading(true);
    this.listView.setVisibility(8);
  }
  
  private void renderTitle()
  {
    getTopBar().setTitle(getString(2131719929));
  }
  
  private void setDataSource(int paramInt)
  {
    this.listCursor = Threads.submitTask(new SubscribeListFragment.5(this, paramInt));
    Threads.runInBackground(new SubscribeListFragment.6(this, paramInt));
  }
  
  private void showDeleteDialog(String paramString, Runnable paramRunnable)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new SubscribeListFragment.12(this, paramRunnable));
    localBottomListSheetBuilder.addItem(getString(2131692498));
    localBottomListSheetBuilder.setTitle(paramString);
    localBottomListSheetBuilder.build().show();
  }
  
  public void initDataSource()
  {
    this.isFirstEnter = true;
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = super.initUI(paramViewHolder);
    this.listEmptyView = paramViewHolder.addListEmptyView();
    this.listView = paramViewHolder.addPtrListView();
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, QMUIKit.dpToPx(48));
    this.moreLoading = new MailListMoreItemView(getActivity());
    this.moreLoading.setBackgroundColor(getResources().getColor(2131167486));
    this.moreLoading.setLayoutParams(localLayoutParams);
    refreshFooterLoadingView();
    paramViewHolder.setBackgroundColor(ActivityCompat.getColor(getActivity(), 2131167682));
    initPopularizeBannerView();
    initPopularizeSubscribeView();
    return paramViewHolder;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 106) && (paramInt2 == 1002) && (getDataSource() != null) && (getDataSource().getCount() == 0))
    {
      QMMailManager.sharedInstance().updateSubscribeEntrance(this.accountId);
      onButtonBackClick();
    }
  }
  
  public void onBackPressed()
  {
    QMMailManager.sharedInstance().markSubscribeAllAsUnread(this.accountId, false);
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    this.popularizeSubscribeListView.setRener(false);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMSubscribeThumbManager.sharedInstance().bindSyncSubscribeThumbWatcher(this.syncSubscribeThumbWatcher, paramBoolean);
    Watchers.bind(this.subscribeMailWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
  }
  
  public void onButtonBackClick()
  {
    QMMailManager.sharedInstance().markSubscribeAllAsUnread(this.accountId, false);
    super.onButtonBackClick();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.listView != null) {
      this.listView.requestLayout();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    ImageCompresser.getInstance().clearMemoryCache();
    QMSubscribeThumbManager.sharedInstance().bindSyncSubscribeThumbWatcher(this.syncSubscribeThumbWatcher, false);
    Watchers.bind(this.subscribeMailWatcher, false);
    if (this.adapter != null) {
      this.adapter.destroy();
    }
    this.adapter = null;
    this.listView.setAdapter(null);
    this.listView.setOnScrollListener(null);
    if (getDataSource() != null) {
      getDataSource().close();
    }
  }
  
  public void onScrollFlingSpeed(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramFloat == 0.0F) {}
    for (this.isFastScroll = false;; this.isFastScroll = true)
    {
      if (this.adapter != null) {
        this.adapter.updateScrollState(this.isFastScroll);
      }
      return;
    }
  }
  
  public void onScrollIdle(int paramInt1, int paramInt2)
  {
    int j = this.listView.getHeaderViewsCount();
    int i = 0;
    while (i < paramInt2)
    {
      View localView = this.listView.getChildAt(i);
      if ((localView instanceof QMSubscribeListItemView)) {
        this.adapter.setViewImages(paramInt1 - j + i, (QMSubscribeListItemView)localView);
      }
      i += 1;
    }
  }
  
  public void onScrollToEnd(ListView paramListView)
  {
    if (this.adapter != null)
    {
      this.adapter.cursorLoadMore();
      DataCollector.logEvent("Event_Load_More_RSS");
    }
  }
  
  public void onTouchScrollSpeed(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramFloat == 0.0F) {}
    for (this.isFastScroll = false;; this.isFastScroll = true)
    {
      this.adapter.updateScrollState(this.isFastScroll);
      return;
    }
  }
  
  public int refreshData()
  {
    if ((!this.isPreloaded) && (getDataSource() != null)) {
      getDataSource().refresh();
    }
    this.isPreloaded = false;
    if ((this.adapter != null) && (getDataSource() != null) && (getDataSource().isChanged())) {
      this.adapter.clear();
    }
    return 0;
  }
  
  public void render(int paramInt)
  {
    renderTitle();
    doRender();
  }
  
  class RefreshThumbRunnable
    implements Runnable
  {
    private Bitmap mBitmap;
    private int mIndex;
    private int mPosition;
    
    public RefreshThumbRunnable(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      this.mPosition = paramInt1;
      this.mIndex = paramInt2;
      this.mBitmap = paramBitmap;
    }
    
    public void run()
    {
      int i = SubscribeListFragment.this.listView.getFirstVisiblePosition() - SubscribeListFragment.this.listView.getHeaderViewsCount();
      int j = SubscribeListFragment.this.listView.getLastVisiblePosition();
      int k = SubscribeListFragment.this.listView.getHeaderViewsCount();
      if ((i <= this.mPosition) && (this.mPosition <= j - k))
      {
        i = this.mPosition - i;
        if ((SubscribeListFragment.this.listView.getChildAt(i) instanceof QMSubscribeListItemView)) {
          ((QMSubscribeListItemView)SubscribeListFragment.this.listView.getChildAt(i)).setImage(this.mBitmap, this.mIndex);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment
 * JD-Core Version:    0.7.0.1
 */