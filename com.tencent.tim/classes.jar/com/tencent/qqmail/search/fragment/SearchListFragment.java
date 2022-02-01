package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.SearchHistoryItem;
import com.tencent.qqmail.maillist.SearchHistoryManager;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.mail.watcher.SearchMailWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.search.view.SearchToggleView;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMLockTipsView;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.SaveArgumentField;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public class SearchListFragment
  extends QMBaseFragment
{
  private static final int HISTORY_SHOW_COUNT = 5;
  private static final String TAG = "SearchListFragment";
  private SyncPhotoWatcher avatarWatcher = new SearchListFragment.7(this);
  private boolean bQQGroup = false;
  private final Runnable changeSearchTypeTask = new SearchListFragment.22(this);
  private final Runnable changeTextTask = new SearchListFragment.14(this);
  private View currentSelectedButton = null;
  private String filterFolderName = "";
  private QMUnlockFolderPwdWatcher folderLockWatcher = new SearchListFragment.23(this);
  private boolean isDirty = true;
  private boolean isHistoryItemClicked = false;
  private boolean isMoreLoading = false;
  private boolean isSearchContentChanged = false;
  private boolean isSearchTypeChanged = false;
  private QMSearchCursor listCursor;
  private ListView listView;
  private FolderLockDialog lockDialog;
  private SparseArray<SparseArray<LockInfo>> lockInforMap;
  private QMLockTipsView lockTipsView;
  @SaveArgumentField
  private int mAccountId;
  private SearchListAdapter mAdapter;
  @SaveArgumentField
  private int mFolderId;
  private ListView mHistoryRecordListView;
  @SaveArgumentField
  private long[] mMailIds;
  private int mOldSoftInputMode = 0;
  private SearchHistoryAdaptor mSearchHistoryAdaptor;
  private ArrayList<SearchHistoryItem> mSearchHistoryItems;
  private SearchHistoryManager mSearchHistoryManager;
  private View mSearchListAll;
  private View mSearchListGroup;
  private View mSearchListReceiver;
  private View mSearchListSender;
  private View mSearchListSubject;
  private RelativeLayout mSearchResultLayout;
  private SearchToggleView mSearchToggleView;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  private final MailMoveWatcher moveWatcher = new SearchListFragment.2(this);
  private boolean needCleanRemoteSearchMails = false;
  private final MailPurgeDeleteWatcher purgeDeleteWatcher = new SearchListFragment.4(this);
  private final MailUnReadWatcher readWatcher = new SearchListFragment.5(this);
  private QMSearchBar searchBar;
  private EditText searchBarInput;
  private String searchContent = "";
  private SearchMailWatcher searchMailWatcher = new SearchListFragment.1(this);
  private int searchType;
  private final View.OnClickListener searchTypeButtonClickListener = new SearchListFragment.21(this);
  private final MailStartWatcher starWatcher = new SearchListFragment.3(this);
  private IObserver tagObserver = new IObserver(new SearchListFragment.6(this));
  
  public SearchListFragment(int paramInt)
  {
    super(true);
    this.mAccountId = paramInt;
  }
  
  public SearchListFragment(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    super(true);
    this.mAccountId = paramInt1;
    this.mFolderId = paramInt2;
    this.mMailIds = paramArrayOfLong;
  }
  
  private void addSearchHistoryItem()
  {
    synchronized (this.mSearchHistoryManager)
    {
      if (((this.isSearchContentChanged) || (this.isSearchTypeChanged)) && (this.searchContent != null) && (!this.searchContent.equals("")))
      {
        this.isSearchContentChanged = false;
        this.isSearchTypeChanged = false;
        SearchHistoryItem localSearchHistoryItem = new SearchHistoryItem();
        localSearchHistoryItem.setSearchContent(this.searchContent);
        localSearchHistoryItem.setSearchTime(System.currentTimeMillis());
        localSearchHistoryItem.setSearchType(this.searchType);
        this.mSearchHistoryManager.add(localSearchHistoryItem);
        this.mSearchHistoryManager.save();
        KvHelper.eventSearchHistoryFinish(new double[0]);
        OssHelper.searchContent(new Object[] { Integer.valueOf(this.searchType), this.searchContent });
      }
      return;
    }
  }
  
  private void bindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.searchMailWatcher, paramBoolean);
    Watchers.bind(this.folderLockWatcher, paramBoolean);
    Watchers.bind(this.moveWatcher, paramBoolean);
    Watchers.bind(this.readWatcher, paramBoolean);
    Watchers.bind(this.starWatcher, paramBoolean);
    Watchers.bind(this.purgeDeleteWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("TOGGLE_VIEW_TYPE", this.tagObserver);
      return;
    }
    QMNotification.unregistNotification("TOGGLE_VIEW_TYPE", this.tagObserver);
  }
  
  private void clearLockInforByAccountId(int paramInt)
  {
    SparseArray localSparseArray = getAccountIdLockInforMap();
    if (localSparseArray != null) {
      localSparseArray.delete(paramInt);
    }
  }
  
  private void closeIMM()
  {
    if (getActivity() != null) {
      ((InputMethodManager)getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBarInput.getWindowToken(), 0);
    }
  }
  
  private void closeSearch()
  {
    this.searchBarInput.setText("");
    MailListItemView.setHighLightKeywords("".split(" "));
    MailListItemView.setHighLightType(7);
    hideKeyBoard();
    popBackStack();
  }
  
  private void forceClearRemoteSearchMailsForOrderList()
  {
    this.needCleanRemoteSearchMails = true;
  }
  
  private SparseArray<LockInfo> getAccountIdLockInforMap()
  {
    if (this.lockInforMap == null) {
      this.lockInforMap = new SparseArray();
    }
    return (SparseArray)this.lockInforMap.get(this.searchType);
  }
  
  private QMSearchCursor getDataSource()
  {
    return this.listCursor;
  }
  
  private void hideTipsView()
  {
    if ((this.lockInforMap != null) && (this.lockInforMap.size() != 0))
    {
      this.lockInforMap.clear();
      renderTipsView();
    }
  }
  
  private void initHistoryRecordListView(View paramView)
  {
    this.mHistoryRecordListView = ((ListView)paramView.findViewById(2131368540));
    this.mHistoryRecordListView.setOnScrollListener(new SearchListFragment.18(this));
    this.mHistoryRecordListView.setOnItemClickListener(new SearchListFragment.19(this));
  }
  
  private void initListView(View paramView)
  {
    this.lockTipsView = new QMLockTipsView(getActivity());
    this.lockTipsView.setOnClickListener(new SearchListFragment.15(this));
    this.lockTipsView.hide();
    this.listView = ((ListView)paramView.findViewById(2131377911));
    this.listView.addHeaderView(this.lockTipsView, null, false);
    this.listView.setOnScrollListener(new SearchListFragment.16(this));
    this.listView.setOnItemClickListener(new SearchListFragment.17(this));
    if (this.mAdapter == null)
    {
      this.mAdapter = new SearchListAdapter(getActivity(), 0, getDataSource(), this.listView);
      this.listView.setAdapter(this.mAdapter);
    }
  }
  
  private void initNewSearch()
  {
    Log.d("hill-searchCrash", "initNewSearch:");
    if ((this.searchContent != null) && (!this.searchContent.equals("")))
    {
      MailListItemView.setHighLightKeywords(splitToKeywords(this.searchContent));
      MailListItemView.setHighLightType(this.searchType);
    }
    this.isMoreLoading = false;
    if (this.mAdapter != null)
    {
      this.mAdapter.setMoreLoading(false);
      this.mAdapter.setError(false);
      if (this.needCleanRemoteSearchMails)
      {
        this.needCleanRemoteSearchMails = false;
        this.mAdapter.resetCursor();
      }
    }
    else
    {
      return;
    }
    this.mAdapter.resetCursorAndNotCleanRemoteSearchMails();
  }
  
  private void initSearchTypeButton(View paramView)
  {
    this.mSearchListSender = paramView.findViewById(2131377877);
    this.mSearchListGroup = paramView.findViewById(2131377873);
    this.mSearchListReceiver = paramView.findViewById(2131377876);
    this.mSearchListSubject = paramView.findViewById(2131377878);
    this.mSearchListAll = paramView.findViewById(2131377870);
    this.mSearchListSender.setOnClickListener(this.searchTypeButtonClickListener);
    this.mSearchListGroup.setOnClickListener(this.searchTypeButtonClickListener);
    this.mSearchListReceiver.setOnClickListener(this.searchTypeButtonClickListener);
    this.mSearchListSubject.setOnClickListener(this.searchTypeButtonClickListener);
    this.mSearchListAll.setOnClickListener(this.searchTypeButtonClickListener);
    this.mSearchListGroup.setContentDescription(getString(2131720850));
    this.mSearchListSender.setContentDescription(getString(2131720852));
    this.mSearchListReceiver.setContentDescription(getString(2131720851));
    this.mSearchListSubject.setContentDescription(getString(2131720853));
    this.mSearchListAll.setContentDescription(getString(2131720849));
    updateSearchButton();
  }
  
  private boolean isFiltered()
  {
    return (this.searchContent != null) && (",html,head,body,style,title,meta,link,img,div,span,table,th,tr,td,li,ul,fieldset,label,input,button,<,</,>,".indexOf("," + this.searchContent.trim().toLowerCase() + ",") > -1);
  }
  
  private void keepLoading()
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.setMoreLoading(true);
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  private void prepareSearch(Runnable paramRunnable)
  {
    Log.d("hill-searchCrash", "prepareSearch:");
    StringBuilder localStringBuilder;
    if (this.listCursor != null)
    {
      localStringBuilder = new StringBuilder().append("  prepare cursor:").append(this.mAccountId).append(",").append(this.mFolderId).append(",").append(this.searchType).append(",").append(this.searchContent).append(",");
      if (this.mMailIds != null) {
        break label151;
      }
    }
    label151:
    for (Object localObject = "null";; localObject = Integer.valueOf(this.mMailIds.length))
    {
      QMLog.log(4, "SearchListFragment", localObject);
      this.listCursor.setSearchInfo(this.mAccountId, this.mFolderId, this.searchType, this.searchContent, this.mMailIds);
      if (this.mAdapter != null) {
        this.mAdapter.update(paramRunnable);
      }
      return;
    }
  }
  
  private void refreshSearchData(boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.update(null, paramBoolean);
    }
  }
  
  private void refreshSearchDataAfterUnlock()
  {
    SearchListFragment.24 local24 = new SearchListFragment.24(this);
    forceClearRemoteSearchMailsForOrderList();
    initNewSearch();
    search(local24);
  }
  
  private void renderEmpty()
  {
    this.mSearchToggleView.setVisibility(0);
    this.mSearchResultLayout.setVisibility(8);
    this.mHistoryRecordListView.setVisibility(8);
  }
  
  private void renderHistory()
  {
    synchronized (this.mSearchHistoryManager)
    {
      this.mSearchHistoryItems = this.mSearchHistoryManager.getNewestSearchHistory(5);
      if ((this.mSearchHistoryItems == null) || (this.mSearchHistoryItems.size() == 0))
      {
        renderEmpty();
        return;
      }
    }
    this.mHistoryRecordListView.setVisibility(0);
    this.mSearchResultLayout.setVisibility(8);
    if (this.mSearchHistoryAdaptor == null)
    {
      this.mSearchHistoryAdaptor = new SearchHistoryAdaptor(getActivity(), this.mSearchHistoryItems);
      this.mSearchHistoryAdaptor.setSearchHistoryListener(new SearchListFragment.20(this));
      this.mHistoryRecordListView.setAdapter(this.mSearchHistoryAdaptor);
      return;
    }
    this.mSearchHistoryAdaptor.setSearchHistoryItems(this.mSearchHistoryItems);
  }
  
  private void renderSearchResult(Runnable paramRunnable)
  {
    prepareSearch(paramRunnable);
    this.mSearchResultLayout.setVisibility(0);
    this.mHistoryRecordListView.setVisibility(8);
  }
  
  private void renderTipsView()
  {
    Object localObject = getAccountIdLockInforMap();
    if ((localObject == null) || (((SparseArray)localObject).size() <= 0))
    {
      this.lockTipsView.hide();
      return;
    }
    if (((SparseArray)localObject).size() > 1)
    {
      localObject = String.format(getResources().getString(2131719328), new Object[] { Integer.valueOf(((SparseArray)localObject).size()) });
      this.lockTipsView.setTips((String)localObject);
    }
    for (;;)
    {
      this.lockTipsView.show();
      return;
      localObject = (LockInfo)((SparseArray)localObject).valueAt(0);
      this.lockTipsView.setTips(((LockInfo)localObject).getPersonaCnt(), false);
    }
  }
  
  private void search(Runnable paramRunnable)
  {
    if (this.searchContent.length() == 0) {
      renderHistory();
    }
    while (isFiltered()) {
      return;
    }
    Log.d("hill-searchCrash", "condi:3");
    renderSearchResult(paramRunnable);
  }
  
  private void setDataSource()
  {
    this.listCursor = QMMailManager.sharedInstance().getSearchListCursor(this.mAccountId, this.mFolderId, this.searchType, this.searchContent, this.mMailIds);
  }
  
  private void setEnableIncrementalSearch(boolean paramBoolean)
  {
    getDataSource().setEnableIncrementalSearch(paramBoolean);
  }
  
  private void showLockDialog()
  {
    if (this.lockDialog != null) {
      this.lockDialog.dismissTips();
    }
    if (getActivity() != null)
    {
      this.lockDialog = new FolderLockDialog(getActivity(), this.mFolderId, this.mAccountId, this.folderLockWatcher);
      this.lockDialog.createDialog(1);
      this.lockDialog.showDialog();
    }
  }
  
  private String[] splitToKeywords(String paramString)
  {
    String[] arrayOfString = null;
    if (paramString != null) {
      arrayOfString = paramString.trim().split(" ");
    }
    return arrayOfString;
  }
  
  private void updateSearchButton()
  {
    View localView;
    if (this.bQQGroup)
    {
      this.mSearchListGroup.setVisibility(0);
      this.mSearchListSender.setVisibility(8);
      this.mSearchListReceiver.setVisibility(8);
      if (this.currentSelectedButton != null) {
        this.currentSelectedButton.setSelected(false);
      }
      if (this.searchType != 1) {
        break label118;
      }
      if (!this.bQQGroup) {
        break label110;
      }
      localView = this.mSearchListGroup;
      label68:
      this.currentSelectedButton = localView;
    }
    for (;;)
    {
      this.currentSelectedButton.setSelected(true);
      return;
      this.mSearchListGroup.setVisibility(8);
      this.mSearchListSender.setVisibility(0);
      this.mSearchListReceiver.setVisibility(0);
      break;
      label110:
      localView = this.mSearchListSender;
      break label68;
      label118:
      if (this.searchType == 2)
      {
        if (this.bQQGroup) {}
        for (localView = this.mSearchListGroup;; localView = this.mSearchListReceiver)
        {
          this.currentSelectedButton = localView;
          break;
        }
      }
      if (this.searchType == 4) {
        this.currentSelectedButton = this.mSearchListSubject;
      } else {
        this.currentSelectedButton = this.mSearchListAll;
      }
    }
  }
  
  private void updateSearchTypeChangeByClick()
  {
    if ((this.mSearchListSender.isSelected()) || (this.mSearchListGroup.isSelected()))
    {
      this.searchType = 1;
      KvHelper.eventSearchSwitchSenderNew(new double[0]);
      return;
    }
    if (this.mSearchListReceiver.isSelected())
    {
      this.searchType = 2;
      KvHelper.eventSearchSwitchReceiverNew(new double[0]);
      return;
    }
    if (this.mSearchListSubject.isSelected())
    {
      this.searchType = 4;
      KvHelper.eventSearchSwitchSubjectNew(new double[0]);
      return;
    }
    this.searchType = 7;
    KvHelper.eventSearchSwitchAllNew(new double[0]);
  }
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource()
  {
    Log.d("hill-searchCrash", "initDataSource:");
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(this.mFolderId);
    Log.v("SearchListFragment", "search_mail_list: accountId: " + this.mAccountId + ", folderId: " + this.mFolderId + ", fd: " + localQMFolder);
    if (localQMFolder != null) {
      if (localQMFolder.getType() != 8) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      this.bQQGroup = bool;
      this.filterFolderName = localQMFolder.getName();
      this.mSearchHistoryManager = SearchHistoryManager.shareInstance();
      this.searchType = SearchHistoryManager.getSearchDefaultType();
      setDataSource();
      bindEvent(true);
      return;
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    Log.d("hill-searchCrash", "initDom:");
    initSearchBarView(paramView);
    initHistoryRecordListView(paramView);
    this.mSearchResultLayout = ((RelativeLayout)paramView.findViewById(2131377854));
    initSearchTypeButton(this.mSearchResultLayout);
    initListView(this.mSearchResultLayout);
  }
  
  protected void initSearchBarView(View paramView)
  {
    this.mSearchToggleView = ((SearchToggleView)paramView.findViewById(2131377864));
    this.mSearchToggleView.init();
    this.mSearchToggleView.setToggleViewCallback(new SearchListFragment.8(this));
    this.searchBar = new QMSearchBar(getActivity());
    this.searchBar.setStateSearch();
    this.searchBar.setBtnRight();
    if (this.filterFolderName.length() > 0) {
      this.searchBar.setSearchHint(this.filterFolderName);
    }
    for (;;)
    {
      ((RelativeLayout)paramView.findViewById(2131377843)).addView(this.searchBar);
      paramView = this.searchBar.getBtnRight();
      paramView.setText(2131691246);
      paramView.setVisibility(0);
      paramView.setContentDescription(getString(2131720804));
      paramView.setOnClickListener(new SearchListFragment.9(this));
      paramView = this.searchBar.searchInputCleaner;
      paramView.setVisibility(8);
      paramView.setOnClickListener(new SearchListFragment.10(this));
      this.searchBarInput = this.searchBar.searchInput;
      this.searchBarInput.setText(this.searchContent);
      this.searchBarInput.setOnTouchListener(new SearchListFragment.11(this));
      this.searchBarInput.setOnEditorActionListener(new SearchListFragment.12(this));
      this.searchBarInput.addTextChangedListener(new SearchListFragment.13(this, paramView));
      KeyBoardHelper.showSoftInputDelay(this.searchBarInput, 100L);
      return;
      this.searchBar.setSearchHint(2131690284);
    }
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131563019, null, false);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return new BaseFragment.TransitionConfig(2130772431, 2130772431, 2130772431, 2130772431);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      MailListItemView.setHighLightKeywords("".split(" "));
      MailListItemView.setHighLightType(7);
      hideKeyBoard();
      popBackStack();
      return true;
    }
    if (paramInt == 82) {}
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      if (paramInt != 3) {}
    }
  }
  
  public void onRelease()
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.printGetViewStatistics();
      this.mAdapter.destroy();
    }
    bindEvent(false);
    closeIMM();
    this.listCursor.release();
    this.listCursor = null;
    this.mAdapter = null;
    this.listView.setAdapter(null);
    this.mMailIds = null;
  }
  
  public void onWindowConfiguration(boolean paramBoolean)
  {
    Window localWindow = getActivity().getWindow();
    if (paramBoolean)
    {
      this.mOldSoftInputMode = localWindow.getAttributes().softInputMode;
      localWindow.setSoftInputMode(36);
      return;
    }
    if (this.mOldSoftInputMode == 0)
    {
      localWindow.getAttributes().softInputMode = this.mOldSoftInputMode;
      localWindow.setSoftInputMode(0);
      return;
    }
    localWindow.setSoftInputMode(this.mOldSoftInputMode);
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    if (this.searchContent.length() == 0) {
      renderHistory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment
 * JD-Core Version:    0.7.0.1
 */