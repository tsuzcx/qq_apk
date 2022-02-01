package com.tencent.qqmail.namelist.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.namelist.NameListAdapter;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.NameListUIHelper;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.cursor.NameListSearchCursor;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.namelist.watcher.AddNameListWatcher;
import com.tencent.qqmail.namelist.watcher.DeleteNameListWatcher;
import com.tencent.qqmail.namelist.watcher.LoadNameListWatcher;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.HashMap;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import rx.Observable;

public class NameListMainFragment
  extends NameListBaseFragment
{
  public static final int REQUEST_TO_ADD_CONTACT = 2;
  private static final int REQUEST_TO_CHOOSE_CONTACT = 0;
  private static final int REQUEST_TO_DETAIL = 1;
  public static final String SELECT_EMAIL_DATA = "select_email_data";
  public static final String TAG = "NameListMainFragment";
  private AddNameListWatcher addNameListWatcher = new NameListMainFragment.18(this);
  private int chooseAddType;
  private TextView contactCountTv;
  private DeleteNameListWatcher deleteNameListWatcher = new NameListMainFragment.19(this);
  private boolean isInitData;
  private LoadNameListWatcher loadNameListWatcher = new NameListMainFragment.17(this);
  private int mAccountId;
  private NameListAdapter mAdapter;
  private QMContentLoadingView mEmptyView;
  private boolean mFromReadMail;
  private boolean mIsLoadNameList;
  private boolean mIsLoadNameListError;
  private boolean mIsSearching;
  private ItemScrollListView mListView;
  private FrameLayout mMainWrapper;
  private FrameLayout.LayoutParams mMainWrapperParam;
  private View mMaskView;
  private Future<NameListBaseCursor> mNameListCursor;
  private String mReadMailEmail;
  private QMSearchBar mScrollSearchBar;
  private NameListAdapter mSearchAdapter;
  private String mSearchKeyWord;
  private ItemScrollListView mSearchListView;
  private Future<NameListBaseCursor> mSearchNameListCursor;
  private QMSideIndexer mSideIndexer;
  private QMSearchBar mStillSearchBar;
  private TextChangeTimer mTextChangeTimer = new TextChangeTimer();
  private QMTopBar mTopBar;
  private int mType;
  private View.OnClickListener onReloadListener = new NameListMainFragment.13(this);
  
  public NameListMainFragment(int paramInt1, int paramInt2)
  {
    super(false);
    this.mAccountId = paramInt1;
    this.mType = paramInt2;
    if (!QMSettingManager.sharedInstance().isNameListContactLoad(this.mAccountId))
    {
      QMContactManager.sharedInstance().loadAccountContacts(new int[] { paramInt1 });
      QMSettingManager.sharedInstance().setNameListContactHasLoad(this.mAccountId, true);
    }
  }
  
  public NameListMainFragment(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    this(paramInt1, paramInt2);
    this.mFromReadMail = paramBoolean;
    this.mReadMailEmail = paramString;
  }
  
  private NameListBaseCursor getDataSource()
  {
    try
    {
      if (this.mNameListCursor != null)
      {
        NameListBaseCursor localNameListBaseCursor = (NameListBaseCursor)this.mNameListCursor.get();
        return localNameListBaseCursor;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private NameListBaseCursor getSearchDataSource()
  {
    try
    {
      if (this.mSearchNameListCursor != null)
      {
        NameListBaseCursor localNameListBaseCursor = (NameListBaseCursor)this.mSearchNameListCursor.get();
        return localNameListBaseCursor;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private QMSearchBar getStillSearchBar()
  {
    if (this.mStillSearchBar == null)
    {
      this.mStillSearchBar = new QMSearchBar(getActivity());
      this.mStillSearchBar.setStateSearch();
      this.mStillSearchBar.setVisibility(8);
      this.mStillSearchBar.setBtnRight();
      this.mStillSearchBar.getBtnRight().setText(getString(2131691246));
      this.mStillSearchBar.getBtnRight().setOnClickListener(new NameListMainFragment.11(this));
      this.mStillSearchBar.searchInput.addTextChangedListener(new NameListMainFragment.12(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
      this.mMainWrapper.addView(this.mStillSearchBar, localLayoutParams);
    }
    return this.mStillSearchBar;
  }
  
  private void handleNewAddAddress(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      String[] arrayOfString = (String[])paramHashMap.get("select_email_data");
      NameListManager.sharedInstance().addNameList(this.mAccountId, this.mType, arrayOfString);
      this.chooseAddType = ((Integer)paramHashMap.get("arg_choose_type")).intValue();
    }
  }
  
  private void handleNewSelectedAddress(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      paramIntent = paramIntent.getStringArrayExtra("result_select_contact_emails");
      NameListManager.sharedInstance().addNameList(this.mAccountId, this.mType, paramIntent);
    }
  }
  
  private void initListFooter()
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    this.contactCountTv = new TextView(getActivity());
    this.contactCountTv.setLayoutParams(new LinearLayout.LayoutParams(-1, QMUIKit.dpToPx(48)));
    this.contactCountTv.setPadding(getResources().getDimensionPixelSize(2131297006), getResources().getDimensionPixelSize(2131297016), getResources().getDimensionPixelSize(2131297006), getResources().getDimensionPixelSize(2131297016));
    this.contactCountTv.setTextSize(13.0F);
    this.contactCountTv.setBackgroundResource(2131167654);
    this.contactCountTv.setGravity(17);
    this.contactCountTv.setTextColor(getResources().getColor(2131167531));
    localLinearLayout.addView(this.contactCountTv);
    this.mListView.addFooterView(localLinearLayout);
  }
  
  private void initSearchBar()
  {
    this.mMaskView = findViewById(2131372202);
    this.mMaskView.setOnClickListener(new NameListMainFragment.7(this));
    this.mScrollSearchBar = new QMSearchBar(getActivity());
    this.mScrollSearchBar.setStateNormal();
    this.mScrollSearchBar.searchInitWrap.setOnClickListener(new NameListMainFragment.8(this));
    this.mScrollSearchBar.setOnTouchListener(new NameListMainFragment.9(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    this.mMainWrapper.addView(this.mScrollSearchBar, localLayoutParams);
  }
  
  private void initTopbar()
  {
    this.mTopBar = ((QMTopBar)findViewById(2131372205));
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    int i;
    if (AccountManager.shareInstance().getAccountList().size() == 1)
    {
      localObject = this.mTopBar;
      if (this.mType == NameListContact.NameListContactType.BLACK.ordinal())
      {
        i = 2131690878;
        ((QMTopBar)localObject).setTitle(i);
      }
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftBack();
      this.mTopBar.setButtonLeftOnclickListener(new NameListMainFragment.3(this));
      this.mTopBar.setButtonRightIcon(2130841079);
      this.mTopBar.setButtonRightOnclickListener(new NameListMainFragment.4(this));
      if (this.mType != NameListContact.NameListContactType.BLACK.ordinal()) {
        break label170;
      }
      this.mTopBar.getButtonRight().setContentDescription(getString(2131720840));
      return;
      i = 2131721876;
      break;
      this.mTopBar.setTitle(((Account)localObject).getEmail());
    }
    label170:
    this.mTopBar.getButtonRight().setContentDescription(getString(2131720841));
  }
  
  private void initView()
  {
    this.mMainWrapper = ((FrameLayout)findViewById(2131372201));
    this.mMainWrapperParam = ((FrameLayout.LayoutParams)this.mMainWrapper.getLayoutParams());
    this.mSideIndexer = ((QMSideIndexer)findViewById(2131372204));
    this.mSideIndexer.init();
    this.mSideIndexer.setCallback(new NameListMainFragment.5(this));
    this.mListView = ((ItemScrollListView)findViewById(2131372199));
    this.mSearchListView = ((ItemScrollListView)findViewById(2131372203));
    this.mEmptyView = ((QMContentLoadingView)findViewById(2131372200));
    NameListMainFragment.6 local6 = new NameListMainFragment.6(this);
    this.mListView.setOnItemClickListener(local6);
    this.mListView.setOnRightViewClickListener(new NameListMainFragment.1OnRightViewClickListener(this));
    this.mSearchListView.setOnItemClickListener(local6);
  }
  
  private void querySectionMap()
  {
    QMContactManager.sharedInstance().querySectionMap(getDataSource()).subscribe(new NameListMainFragment.14(this));
  }
  
  private void refreshNormalData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (getDataSource() != null) {
      getDataSource().refresh(false, paramQMRefreshCallback);
    }
  }
  
  private void refreshSearchData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (getSearchDataSource() == null) {
      setSearchDataSource();
    }
    ((NameListSearchCursor)getSearchDataSource()).setSearchKey(this.mSearchKeyWord);
    getSearchDataSource().refresh(false, paramQMRefreshCallback);
  }
  
  private void renderNormalView()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() == 0))
    {
      if (this.mIsLoadNameListError)
      {
        showErrorView();
        return;
      }
      if (this.mIsLoadNameList)
      {
        showEmptyView();
        return;
      }
      showLoadingView();
      return;
    }
    showListView();
  }
  
  private void renderSearchView()
  {
    if ((getSearchDataSource() == null) || (getSearchDataSource().getCount() == 0))
    {
      showSearchEmptyView();
      return;
    }
    showSearchListView();
  }
  
  private void setDataSource()
  {
    this.mNameListCursor = Threads.submitTask(new NameListMainFragment.15(this));
  }
  
  private void setSearchDataSource()
  {
    this.mSearchNameListCursor = Threads.submitTask(new NameListMainFragment.16(this));
  }
  
  private void showEmptyView()
  {
    showListView();
    if (this.mType == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (String str = getString(2131690875);; str = getString(2131721873))
    {
      this.mEmptyView.showTips(str);
      this.mEmptyView.setVisibility(0);
      return;
    }
  }
  
  private void showErrorView()
  {
    showListView();
    QMContentLoadingView localQMContentLoadingView = this.mEmptyView;
    if (this.mType == NameListContact.NameListContactType.BLACK.ordinal()) {}
    for (int i = 2131690876;; i = 2131721874)
    {
      localQMContentLoadingView.showTipsReload(i, this.onReloadListener);
      this.mEmptyView.setVisibility(0);
      return;
    }
  }
  
  private void showListView()
  {
    this.mListView.setVisibility(0);
    this.mSearchListView.setVisibility(8);
    this.mEmptyView.setVisibility(8);
    if (this.mAdapter == null)
    {
      this.mAdapter = new NameListAdapter(getActivity(), getDataSource(), this.mIsSearching);
      this.mListView.setAdapter(this.mAdapter);
      querySectionMap();
      this.mListView.requestLayout();
      if (this.mAdapter.getCount() <= 0) {
        break label175;
      }
      this.contactCountTv.setText(String.format(getString(2131692018), new Object[] { Integer.valueOf(this.mAdapter.getCount()) }));
      this.contactCountTv.setVisibility(0);
    }
    for (;;)
    {
      if (this.mFromReadMail)
      {
        this.mFromReadMail = false;
        NameListUIHelper.scrollTopNewContact(this.mListView, getDataSource(), NameListContact.generateId(this.mAccountId, this.mReadMailEmail));
      }
      return;
      this.mAdapter.notifyDataSetChanged();
      break;
      label175:
      this.contactCountTv.setVisibility(8);
    }
  }
  
  private void showLoadingView()
  {
    this.mListView.setVisibility(8);
    this.mSearchListView.setVisibility(8);
    this.mSideIndexer.hide();
    this.mEmptyView.showLoading(true);
    this.mEmptyView.setVisibility(0);
  }
  
  private void showSearchEmptyView()
  {
    this.mListView.setVisibility(8);
    this.mSearchListView.setVisibility(8);
    if (this.mSearchAdapter != null) {
      this.mSearchAdapter.notifyDataSetChanged();
    }
    this.mSideIndexer.hide();
    this.mEmptyView.showTips(2131692060);
    this.mEmptyView.setVisibility(0);
  }
  
  private void showSearchListView()
  {
    if (this.mSearchAdapter == null)
    {
      this.mSearchAdapter = new NameListAdapter(getActivity(), getSearchDataSource(), this.mIsSearching);
      this.mSearchListView.setAdapter(this.mSearchAdapter);
    }
    for (;;)
    {
      this.mSideIndexer.hide();
      this.mListView.setVisibility(8);
      this.mSearchListView.setVisibility(0);
      this.mEmptyView.setVisibility(8);
      return;
      this.mSearchAdapter.notifyDataSetChanged();
    }
  }
  
  private void showTipsError(String paramString)
  {
    runOnMainThread(new NameListMainFragment.21(this, paramString));
  }
  
  private void showTipsSuccess(String paramString)
  {
    runOnMainThread(new NameListMainFragment.20(this, paramString));
  }
  
  private void toggleMaskView()
  {
    if ((this.mIsSearching) && (StringExtention.isNullOrEmpty(this.mSearchKeyWord)))
    {
      this.mMaskView.setVisibility(0);
      return;
    }
    this.mMaskView.setVisibility(8);
  }
  
  private void toggleSearchModel(boolean paramBoolean)
  {
    this.mIsSearching = paramBoolean;
    if (paramBoolean)
    {
      this.mListView.setVisibility(0);
      this.mSearchListView.setVisibility(8);
      this.mEmptyView.setVisibility(8);
      QMSearchBar localQMSearchBar = getStillSearchBar();
      localQMSearchBar.setVisibility(0);
      localQMSearchBar.searchInput.setText("");
      localQMSearchBar.searchInput.requestFocus();
      this.mSearchKeyWord = "";
      this.mScrollSearchBar.setVisibility(8);
      showKeyBoard();
      this.mTopBar.hide();
      this.mMainWrapperParam.setMargins(0, 0, 0, 0);
    }
    for (;;)
    {
      toggleMaskView();
      return;
      this.mListView.setVisibility(0);
      this.mSearchListView.setVisibility(8);
      if ((getDataSource() == null) || (getDataSource().getCount() != 0)) {
        this.mEmptyView.setVisibility(8);
      }
      if (this.mStillSearchBar != null)
      {
        this.mStillSearchBar.setVisibility(8);
        this.mStillSearchBar.searchInput.setText("");
        this.mStillSearchBar.searchInput.clearFocus();
      }
      this.mSearchKeyWord = "";
      this.mScrollSearchBar.setVisibility(0);
      hideKeyBoard();
      this.mTopBar.show();
      this.mMainWrapperParam.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
      refreshNormalData(new NameListMainFragment.10(this));
    }
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopbar();
    initView();
    initSearchBar();
    initListFooter();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = new FrameLayout.LayoutParams(-1, -1, 112);
    View localView = View.inflate(getActivity(), 2131559680, null);
    localView.setLayoutParams(paramViewHolder);
    localView.setVerticalFadingEdgeEnabled(false);
    return localView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (paramInt2 == -1) {}
      for (boolean bool = true;; bool = false)
      {
        handleNewSelectedAddress(bool, paramIntent);
        return;
      }
    } while (paramInt2 != -1);
    showTipsSuccess(getString(2131690886));
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadNameListWatcher, paramBoolean);
    Watchers.bind(this.addNameListWatcher, paramBoolean);
    Watchers.bind(this.deleteNameListWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (!this.mIsSearching) && (this.mListView.isFold());
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1) {}
    for (boolean bool = true;; bool = false)
    {
      handleNewAddAddress(bool, paramHashMap);
      return;
    }
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    if (!this.isInitData)
    {
      setDataSource();
      this.isInitData = true;
    }
    if (this.mIsSearching) {
      if (getSearchDataSource() != null) {
        getSearchDataSource().refresh(false, new NameListMainFragment.1(this));
      }
    }
    while (getDataSource() == null) {
      return 0;
    }
    getDataSource().refresh(false, new NameListMainFragment.2(this));
    return 0;
  }
  
  public void render(int paramInt)
  {
    if ((this.mIsSearching) && (!StringExtention.isNullOrEmpty(this.mSearchKeyWord)))
    {
      renderSearchView();
      return;
    }
    renderNormalView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment
 * JD-Core Version:    0.7.0.1
 */