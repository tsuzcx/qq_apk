package com.tencent.qqmail.ftn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.attachment.activity.ImagePagerActivity;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.search.view.SearchToggleView;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMContentLoadingView;
import java.util.Date;
import java.util.Timer;

public class FtnSearchListActivity
  extends BaseActivityEx
{
  public static final String ACCOUNT_ID = "accountid";
  public static final String KEY_WORD = "keyword";
  private static final int SHOW_STATUS_ERROR = 4;
  private static final int SHOW_STATUS_FILE = 3;
  private static final int SHOW_STATUS_LOADING = 1;
  private static final int SHOW_STATUS_NO_FILE = 2;
  public static final String TAG = "SearchFtnListActivity";
  private int accountId;
  private FtnSearchListAdapter adapter;
  private boolean firstTimeCreate;
  private ListView ftnListView;
  private FtnUI ftnUI;
  private AdapterView.OnItemClickListener itemClickListener = new FtnSearchListActivity.12(this);
  private AdapterView.OnItemLongClickListener itemLongClickListener = new FtnSearchListActivity.13(this);
  private String keyword;
  private int lastIndex = -1;
  private int lastTop = -1;
  private QMContentLoadingView listEmptyView;
  private AbsListView.OnScrollListener listScrollListener = new FtnSearchListActivity.14(this);
  private selectItemData m_selectItemData = new selectItemData(null);
  private IObserver observerDelFileError = new FtnSearchListActivity.4(this, null);
  private IObserver observerDelFileSuccess = new FtnSearchListActivity.3(this, null);
  private IObserver observerRenewFileError = new FtnSearchListActivity.2(this, null);
  private IObserver observerRenewFileSuccess = new FtnSearchListActivity.1(this, null);
  private View.OnClickListener onClickListenerSearchCancel = new FtnSearchListActivity.11(this);
  private View.OnClickListener onClickListenerSearchCleaner = new FtnSearchListActivity.10(this);
  private TextView.OnEditorActionListener onEditListenerSearchInput = new FtnSearchListActivity.8(this);
  private View.OnTouchListener onTouchListenerSearchInput = new FtnSearchListActivity.7(this);
  private QMSearchBar searchBar;
  private SearchToggleView searchToggleView;
  private TextWatcher textWatcherSearchInput = new FtnSearchListActivity.9(this);
  private String uin = "";
  
  private void changeShowStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      renderNormal();
      return;
    case 2: 
      renderEmpty();
      return;
    case 4: 
      renderError();
      return;
    }
    renderLoading();
  }
  
  private void delayShowKeyBoard(long paramLong)
  {
    new Timer().schedule(new FtnSearchListActivity.6(this), paramLong);
  }
  
  private String getKeyword()
  {
    return this.keyword;
  }
  
  private MailBigAttach getMailBigAttach(FileInfo paramFileInfo)
  {
    paramFileInfo = FtnCommonUtils.fileInfo2BigAttach(paramFileInfo);
    setSelectItemData(paramFileInfo.getFid(), (int)paramFileInfo.getExpire().getTime() / 1000);
    return paramFileInfo;
  }
  
  private void handleSearchFtnList(String paramString)
  {
    String str = paramString.trim().replace(" ", "%");
    setKeyword(str);
    if (str.equals("")) {}
    for (this.ftnUI = FtnManager.sharedInstance().searchFtnList();; this.ftnUI = FtnManager.sharedInstance().searchFtnList(paramString))
    {
      Threads.runOnMainThread(new FtnSearchListActivity.15(this, paramString));
      return;
    }
  }
  
  private void hideFtnListView()
  {
    if (this.ftnListView != null) {
      this.ftnListView.setVisibility(8);
    }
  }
  
  private void hideSearchCleaner()
  {
    this.searchBar.searchInputCleaner.setVisibility(8);
  }
  
  private void hideSearchTips()
  {
    getTips().hide();
  }
  
  private void hideSearchToggle()
  {
    this.searchToggleView.setVisibility(8);
  }
  
  private void initListView()
  {
    this.ftnListView.setOnItemClickListener(this.itemClickListener);
    this.ftnListView.setOnItemLongClickListener(this.itemLongClickListener);
    this.ftnListView.setOnScrollListener(this.listScrollListener);
    this.adapter = new FtnSearchListAdapter(this);
    this.adapter.setFtnUI(this.ftnUI);
    this.ftnListView.setAdapter(this.adapter);
  }
  
  private void initSearchBar()
  {
    this.searchToggleView = ((SearchToggleView)findViewById(2131377864));
    this.searchToggleView.init();
    this.searchToggleView.setToggleViewCallback(new FtnSearchListActivity.5(this));
    this.searchBar = new QMSearchBar(this);
    this.searchBar.setStateSearch();
    this.searchBar.setBtnRight();
    this.searchBar.getBtnRight().setText(2131691246);
    this.searchBar.getBtnRight().setVisibility(0);
    this.searchBar.getBtnRight().setOnClickListener(this.onClickListenerSearchCancel);
    this.searchBar.setSearchHint(2131694073);
    this.searchBar.searchInput.setText(getKeyword());
    this.searchBar.searchInput.setFocusable(true);
    this.searchBar.searchInput.setFocusableInTouchMode(true);
    this.searchBar.searchInput.requestFocus();
    this.searchBar.searchInput.setOnTouchListener(this.onTouchListenerSearchInput);
    this.searchBar.searchInput.setOnEditorActionListener(this.onEditListenerSearchInput);
    this.searchBar.searchInput.addTextChangedListener(this.textWatcherSearchInput);
    this.searchBar.searchInputCleaner.setVisibility(8);
    this.searchBar.searchInputCleaner.setOnClickListener(this.onClickListenerSearchCleaner);
    ((RelativeLayout)findViewById(2131377822)).addView(this.searchBar);
  }
  
  private void renderEmpty()
  {
    this.listEmptyView.showTips(2131694064);
    hideFtnListView();
  }
  
  private void renderError()
  {
    this.listEmptyView.showTips(2131694065);
    hideFtnListView();
  }
  
  private void renderLoading()
  {
    this.listEmptyView.showLoading(true);
    hideFtnListView();
  }
  
  private void renderNormal()
  {
    this.listEmptyView.hide();
    showFtnListView();
  }
  
  private void restorePosition()
  {
    if ((this.ftnListView != null) && (this.lastIndex > -1)) {
      this.ftnListView.setSelectionFromTop(this.lastIndex, this.lastTop);
    }
  }
  
  private void restorePositionToTop()
  {
    this.lastIndex = -1;
  }
  
  private void savePosition()
  {
    int i = 0;
    View localView;
    if (this.ftnListView != null)
    {
      this.lastIndex = this.ftnListView.getFirstVisiblePosition();
      localView = this.ftnListView.getChildAt(0);
      if (localView != null) {
        break label39;
      }
    }
    for (;;)
    {
      this.lastTop = i;
      return;
      label39:
      i = localView.getTop();
    }
  }
  
  private void setEditFocusable()
  {
    this.searchBar.searchInput.setFocusable(true);
    this.searchBar.searchInput.setFocusableInTouchMode(true);
    this.searchBar.searchInput.requestFocus();
    Editable localEditable = this.searchBar.searchInput.getText();
    Selection.setSelection(localEditable, localEditable.length());
  }
  
  private void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  private void setSearchInput(String paramString)
  {
    if (this.searchBar.searchInput != null)
    {
      this.searchBar.searchInput.setVisibility(0);
      this.searchBar.searchInput.setText(paramString);
    }
  }
  
  private void setSelectItemData(String paramString, int paramInt)
  {
    this.m_selectItemData.fid = paramString;
    this.m_selectItemData.expireTime = paramInt;
  }
  
  private void showFtnListView()
  {
    if (this.ftnListView != null) {
      this.ftnListView.setVisibility(0);
    }
  }
  
  private void showKeyBoard()
  {
    KeyBoardHelper.showKeyBoard(0, 2);
  }
  
  private void showRenewTipsError()
  {
    getTips().showError("续期失败");
  }
  
  private void showRenewTipsSuccess()
  {
    getTips().showSuccess("续期成功");
  }
  
  private void showSearchCleaner()
  {
    this.searchBar.searchInputCleaner.setVisibility(0);
  }
  
  private void showSearchTipsLoading()
  {
    getTips().showLoading("中转站搜索中...");
  }
  
  private void showSearchToggle()
  {
    this.searchToggleView.setVisibility(0);
  }
  
  private void startBigAttachmentActivity(MailBigAttach paramMailBigAttach, int paramInt)
  {
    if (FtnCommonUtils.isFileTypeImage(FileUtil.getFileNameSuffix(paramMailBigAttach.getName())))
    {
      startActivityForResult(ImagePagerActivity.createIntent(paramMailBigAttach, paramInt, "from_ftnlist"), 2);
      return;
    }
    startActivityForResult(FtnAttachmentActivity.createIntentToPreview(getActivity(), paramMailBigAttach), 9);
  }
  
  private void updateFtnList(FtnUI paramFtnUI, String paramString)
  {
    if (paramFtnUI == null) {
      return;
    }
    savePosition();
    this.adapter.setFtnUI(paramFtnUI);
    this.adapter.notifyDataSetChanged();
    restorePosition();
    hideSearchTips();
    if ((!this.firstTimeCreate) && (!this.keyword.equals("")))
    {
      hideSearchToggle();
      if (paramFtnUI.getCount() <= 0) {
        break label81;
      }
      changeShowStatus(3);
    }
    for (;;)
    {
      updateImageFtnUI(paramString);
      return;
      this.firstTimeCreate = false;
      break;
      label81:
      changeShowStatus(2);
    }
  }
  
  private void updateImageFtnUI(String paramString)
  {
    if (ImagePagerCache.imageFtnUIs != null)
    {
      ImagePagerCache.imageFtnUIs.release();
      ImagePagerCache.imageFtnUIs = null;
    }
    if ((paramString == null) || (paramString.equals("")))
    {
      ImagePagerCache.imageFtnUIs = FtnManager.sharedInstance().getFtnList(1);
      ImagePagerCache.fidIndex = FtnManager.sharedInstance().getFidIndex(1);
      return;
    }
    ImagePagerCache.imageFtnUIs = FtnManager.sharedInstance().searchFtnList(1, paramString);
    ImagePagerCache.fidIndex = FtnManager.sharedInstance().getFidIndex(1, paramString);
  }
  
  private void updateItemExpireTime()
  {
    int i = this.m_selectItemData.expireTime;
    int j = FtnCommonUtils.getExpireTimeFromNowSecond(FtnListActivity.mRenewDay);
    if (i <= j) {
      FtnManager.sharedInstance().updateFtn(this.m_selectItemData.fid, "expiretime", j + "");
    }
  }
  
  public void initDataSource()
  {
    this.keyword = getIntent().getExtras().getString("keyword");
    this.uin = getIntent().getStringExtra("extra_uin");
    this.accountId = getIntent().getExtras().getInt("accountid");
    this.firstTimeCreate = true;
    this.ftnUI = FtnManager.sharedInstance().searchFtnList();
  }
  
  public void initDom()
  {
    initSearchBar();
    initListView();
    delayShowKeyBoard(300L);
  }
  
  public void initTips(QMTips paramQMTips)
  {
    paramQMTips.setCanceledOnTouchOutside(true);
  }
  
  public void initUI()
  {
    setContentView(2131563015);
    this.ftnListView = ((ListView)findViewById(2131367782));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    this.searchToggleView = ((SearchToggleView)findViewById(2131377864));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2) {
      if (!getKeyword().equals("")) {
        break label47;
      }
    }
    label47:
    for (this.ftnUI = FtnManager.sharedInstance().searchFtnList();; this.ftnUI = FtnManager.sharedInstance().searchFtnList(this.keyword))
    {
      updateFtnList(this.ftnUI, this.keyword);
      return;
    }
  }
  
  public void onBackground()
  {
    super.onBackground();
    savePosition();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("actiondelfilesucc", this.observerDelFileSuccess);
      QMNotification.registNotification("actiondelfileerror", this.observerDelFileError);
      QMNotification.registNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
      QMNotification.registNotification("actionrenewfileerror", this.observerRenewFileError);
      return;
    }
    QMNotification.unregistNotification("actiondelfilesucc", this.observerDelFileSuccess);
    QMNotification.unregistNotification("actiondelfileerror", this.observerDelFileError);
    QMNotification.unregistNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
    QMNotification.unregistNotification("actionrenewfileerror", this.observerRenewFileError);
  }
  
  public void onOverridePendingTransition()
  {
    overridePendingTransition(0, 0);
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    overridePendingTransition(0, 0);
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  class selectItemData
  {
    public int expireTime = 0;
    public String fid = "";
    
    private selectItemData() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity
 * JD-Core Version:    0.7.0.1
 */