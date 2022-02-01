package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactSearchCursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import rx.Observable;

public class ComposeMobileContactsActivity
  extends BaseActivityEx
{
  private static final String TAG = "ComposeMobileContactsActivity";
  private ComposeContactsAdapter adapter;
  private TextView btnAdd;
  private Future<ContactBaseListCursor> contactListCursor;
  private ListView contactListLV;
  private boolean isLoadContact;
  private boolean isRefreshData;
  private boolean isSearching;
  private QMContentLoadingView listEmptyView;
  private LoadContactListWatcher loadContactListWatcher = new ComposeMobileContactsActivity.1(this);
  private FrameLayout mainWrapper;
  private FrameLayout.LayoutParams mainWrapperParam;
  private View maskView;
  private QMSearchBar scrollSearchBar;
  private ComposeContactsAdapter searchAdapter;
  private String searchKeyWord = "";
  private Future<ContactBaseListCursor> searchListCursor;
  private ListView searchListLV;
  private QMSideIndexer sideIndexer;
  private QMSearchBar stillSearchBar;
  private TextChangeTimer textChangeTimer = new TextChangeTimer();
  private QMTopBar topBar;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), ComposeMobileContactsActivity.class);
  }
  
  private ContactBaseListCursor getDataSource()
  {
    try
    {
      if (this.contactListCursor != null)
      {
        ContactBaseListCursor localContactBaseListCursor = (ContactBaseListCursor)this.contactListCursor.get();
        return localContactBaseListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ComposeMobileContactsActivity", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private ContactBaseListCursor getSearchDataSource()
  {
    try
    {
      if (this.searchListCursor != null)
      {
        ContactBaseListCursor localContactBaseListCursor = (ContactBaseListCursor)this.searchListCursor.get();
        return localContactBaseListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "ComposeMobileContactsActivity", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private QMSearchBar getStillSearchBar()
  {
    if (this.stillSearchBar == null)
    {
      this.stillSearchBar = new QMSearchBar(getActivity());
      this.stillSearchBar.setStateSearch();
      this.stillSearchBar.setVisibility(8);
      this.stillSearchBar.setBtnRight();
      this.stillSearchBar.getBtnRight().setText(getString(2131691246));
      this.stillSearchBar.getBtnRight().setOnClickListener(new ComposeMobileContactsActivity.13(this));
      this.stillSearchBar.searchInput.addTextChangedListener(new ComposeMobileContactsActivity.14(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
      this.mainWrapper.addView(this.stillSearchBar, localLayoutParams);
    }
    return this.stillSearchBar;
  }
  
  private void initSearchBar()
  {
    this.maskView = findViewById(2131365149);
    this.maskView.setOnClickListener(new ComposeMobileContactsActivity.10(this));
    this.scrollSearchBar = new QMSearchBar(getActivity());
    this.scrollSearchBar.setStateNormal();
    this.scrollSearchBar.searchInitWrap.setOnClickListener(new ComposeMobileContactsActivity.11(this));
    this.scrollSearchBar.setOnTouchListener(new ComposeMobileContactsActivity.12(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    this.mainWrapper.addView(this.scrollSearchBar, localLayoutParams);
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(2131692088);
    this.topBar.setButtonRightBlue(2131689701);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonRight().setEnabled(false);
    this.topBar.getButtonRight().setOnClickListener(new ComposeMobileContactsActivity.4(this));
    this.topBar.getButtonLeft().setOnClickListener(new ComposeMobileContactsActivity.5(this));
    this.topBar.setCenterOnclickListener(new ComposeMobileContactsActivity.6(this));
    this.btnAdd = ((TextView)this.topBar.getButtonRight());
  }
  
  private void initView()
  {
    this.mainWrapper = ((FrameLayout)findViewById(2131365252));
    this.mainWrapperParam = ((FrameLayout.LayoutParams)this.mainWrapper.getLayoutParams());
    this.sideIndexer = ((QMSideIndexer)findViewById(2131365151));
    this.sideIndexer.init();
    this.sideIndexer.setCallback(new ComposeMobileContactsActivity.7(this));
    this.contactListLV = ((ListView)findViewById(2131365148));
    this.searchListLV = ((ListView)findViewById(2131365150));
    this.searchListLV.setOnScrollListener(new ComposeMobileContactsActivity.8(this));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    ComposeMobileContactsActivity.9 local9 = new ComposeMobileContactsActivity.9(this);
    this.contactListLV.setOnItemClickListener(local9);
    this.searchListLV.setOnItemClickListener(local9);
  }
  
  private void querySectionMap()
  {
    QMContactManager.sharedInstance().querySectionMap(getDataSource()).subscribe(new ComposeMobileContactsActivity.15(this));
  }
  
  private void refreshAddNumber()
  {
    int i = ComposeContactsAdapter.getSelectContacts().size();
    if (i > 0)
    {
      this.btnAdd.setEnabled(true);
      this.btnAdd.setText(getString(2131689701) + "(" + i + ")");
      if (this.stillSearchBar != null)
      {
        this.stillSearchBar.setBtnRight();
        this.stillSearchBar.getBtnRight().setText(getString(2131693745) + "(" + i + ")");
      }
    }
    do
    {
      return;
      this.btnAdd.setEnabled(false);
      this.btnAdd.setText(getString(2131689701));
    } while (this.stillSearchBar == null);
    this.stillSearchBar.setBtnRight();
    this.stillSearchBar.getBtnRight().setText(getString(2131691246));
  }
  
  private void refreshData(QMRefreshCallback paramQMRefreshCallback)
  {
    if ((this.isSearching) && (!StringExtention.isNullOrEmpty(this.searchKeyWord)))
    {
      refreshSearchData(paramQMRefreshCallback);
      return;
    }
    refreshNormalData(paramQMRefreshCallback);
  }
  
  private void refreshNormalData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (this.isRefreshData) {
      getDataSource().refresh(false, paramQMRefreshCallback);
    }
    this.isRefreshData = true;
  }
  
  private void refreshSearchData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (getSearchDataSource() == null) {
      setSearchDataSource();
    }
    ((ContactSearchCursor)getSearchDataSource()).setSearchKey(this.searchKeyWord);
    getSearchDataSource().refresh(false, paramQMRefreshCallback);
  }
  
  private void renderNormalView()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() == 0))
    {
      if (this.isLoadContact)
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
    this.contactListCursor = Threads.submitTask(new ComposeMobileContactsActivity.2(this));
  }
  
  private void setSearchDataSource()
  {
    this.searchListCursor = Threads.submitTask(new ComposeMobileContactsActivity.3(this));
  }
  
  private void showEmptyView()
  {
    this.contactListLV.setVisibility(8);
    this.searchListLV.setVisibility(8);
    this.sideIndexer.hide();
    this.listEmptyView.showTips(2131692057);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showKeyBoard()
  {
    KeyBoardHelper.showKeyBoard(0, 1);
  }
  
  private void showListView()
  {
    if (this.adapter == null)
    {
      this.adapter = new ComposeContactsAdapter(getActivity(), getDataSource());
      this.contactListLV.setAdapter(this.adapter);
    }
    for (;;)
    {
      querySectionMap();
      this.contactListLV.setVisibility(0);
      this.searchListLV.setVisibility(8);
      this.listEmptyView.setVisibility(8);
      return;
      this.adapter.notifyDataSetChanged();
    }
  }
  
  private void showLoadingView()
  {
    this.contactListLV.setVisibility(8);
    this.searchListLV.setVisibility(8);
    this.sideIndexer.hide();
    this.listEmptyView.showLoading(true);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showSearchEmptyView()
  {
    this.contactListLV.setVisibility(8);
    this.searchListLV.setVisibility(8);
    this.sideIndexer.hide();
    this.listEmptyView.showTips(2131692060);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showSearchListView()
  {
    if (this.searchAdapter == null)
    {
      this.searchAdapter = new ComposeContactsAdapter(getActivity(), getSearchDataSource());
      this.searchListLV.setAdapter(this.searchAdapter);
    }
    for (;;)
    {
      this.sideIndexer.hide();
      this.contactListLV.setVisibility(8);
      this.searchListLV.setVisibility(0);
      this.listEmptyView.setVisibility(8);
      return;
      this.searchAdapter.notifyDataSetChanged();
    }
  }
  
  private void toggleMaskView()
  {
    if ((this.isSearching) && (StringExtention.isNullOrEmpty(this.searchKeyWord)))
    {
      this.maskView.setVisibility(0);
      return;
    }
    this.maskView.setVisibility(8);
  }
  
  private void toggleSearchModel(boolean paramBoolean)
  {
    this.isSearching = paramBoolean;
    if (paramBoolean)
    {
      this.contactListLV.setVisibility(0);
      this.searchListLV.setVisibility(8);
      this.listEmptyView.setVisibility(8);
      this.stillSearchBar = getStillSearchBar();
      this.stillSearchBar.setVisibility(0);
      this.stillSearchBar.searchInput.setText("");
      this.stillSearchBar.searchInput.requestFocus();
      this.searchKeyWord = "";
      this.scrollSearchBar.setVisibility(8);
      showKeyBoard();
      this.topBar.hide();
      this.mainWrapperParam.setMargins(0, 0, 0, 0);
    }
    for (;;)
    {
      toggleMaskView();
      refreshAddNumber();
      return;
      this.contactListLV.setVisibility(0);
      this.searchListLV.setVisibility(8);
      if ((getDataSource() == null) || (getDataSource().getCount() != 0)) {
        this.listEmptyView.setVisibility(8);
      }
      if (this.stillSearchBar != null)
      {
        this.stillSearchBar.setVisibility(8);
        this.stillSearchBar.searchInput.setText("");
        this.stillSearchBar.searchInput.clearFocus();
      }
      this.searchKeyWord = "";
      this.scrollSearchBar.setVisibility(0);
      hideKeyBoard();
      this.topBar.show();
      this.mainWrapperParam.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    }
  }
  
  public void initDataSource()
  {
    setDataSource();
  }
  
  public void initDom()
  {
    initTopBar();
    initView();
    initSearchBar();
  }
  
  public void initUI()
  {
    setContentView(2131558479);
  }
  
  public void onBackground()
  {
    super.onBackground();
    hideKeyBoard();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadContactListWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    this.textChangeTimer.release();
    if (this.sideIndexer != null)
    {
      this.sideIndexer.recycle();
      this.sideIndexer = null;
    }
    if (getDataSource() != null) {
      getDataSource().close();
    }
    if (getSearchDataSource() != null) {
      getSearchDataSource().close();
    }
    if (this.adapter != null)
    {
      this.adapter = null;
      this.contactListLV.setAdapter(null);
    }
    if (this.searchAdapter != null)
    {
      this.searchAdapter = null;
      this.searchListLV.setAdapter(null);
    }
  }
  
  public void refreshData()
  {
    refreshData(null);
  }
  
  public void render()
  {
    if ((this.isSearching) && (!StringExtention.isNullOrEmpty(this.searchKeyWord))) {
      renderSearchView();
    }
    for (;;)
    {
      refreshAddNumber();
      return;
      renderNormalView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity
 * JD-Core Version:    0.7.0.1
 */