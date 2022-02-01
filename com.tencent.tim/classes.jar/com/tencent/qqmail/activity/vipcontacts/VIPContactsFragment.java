package com.tencent.qqmail.activity.vipcontacts;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.QMContactGroupSelectActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactSearchCursor;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;
import rx.Observable;

public class VIPContactsFragment
  extends QMBaseFragment
{
  public static final int REQUEST_CODE_OTHER = 200;
  public static final String TAG = "VIPContactsFragment";
  private Account account;
  private int accountId;
  private VIPContactsAdapter adapter;
  private TextView btnAdd;
  private int[] checkedAccountIds;
  private TextView contactCountTv;
  private Future<ContactBaseListCursor> contactListCursor;
  private ListView contactListLV;
  private ContactGroup group;
  private int groupId;
  private boolean isChooseRecentSender;
  private boolean isLoadContact;
  private boolean isLoadContactError;
  private boolean isRefreshData;
  private boolean isSearching;
  private QMContentLoadingView listEmptyView;
  private LoadContactListWatcher loadContactListWatcher = new VIPContactsFragment.1(this);
  private FrameLayout mainWrapper;
  private FrameLayout.LayoutParams mainWrapperParam;
  private View maskView;
  private int nameListType;
  private View.OnClickListener onReloadListener = new VIPContactsFragment.3(this);
  private int pageId;
  private QMSearchBar scrollSearchBar;
  private VIPContactsAdapter searchAdapter;
  private String searchKeyWord;
  private Future<ContactBaseListCursor> searchListCursor;
  private ListView searchListLV;
  private TextView selectOtherCountTv;
  private QMSideIndexer sideIndexer;
  private QMSearchBar stillSearchBar;
  private TextChangeTimer textChangeTimer = new TextChangeTimer();
  private QMTopBar topBar;
  private LoadVipContactListWatcher vipContactListWatcher = new VIPContactsFragment.2(this);
  
  public VIPContactsFragment()
  {
    this(0, 0, 0);
  }
  
  public VIPContactsFragment(int paramInt1, int paramInt2, int paramInt3)
  {
    super(false);
    this.pageId = paramInt1;
    this.accountId = paramInt2;
    this.groupId = paramInt3;
    setDataSource();
  }
  
  private void backToIndexFragment()
  {
    QMLog.log(4, "VIPContactsFragment", "click right add contact backToIndexFragment");
    onBackPressed();
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
      QMLog.log(6, "VIPContactsFragment", "getDataSource failed. " + localException.toString());
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
      QMLog.log(6, "VIPContactsFragment", "getDataSource failed. " + localException.toString());
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
      this.stillSearchBar.getBtnRight().setOnClickListener(new VIPContactsFragment.16(this));
      this.stillSearchBar.searchInput.addTextChangedListener(new VIPContactsFragment.17(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
      this.mainWrapper.addView(this.stillSearchBar, localLayoutParams);
    }
    return this.stillSearchBar;
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
    this.contactListLV.addFooterView(localLinearLayout);
  }
  
  private void initListHeader()
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    View localView;
    ImageView localImageView;
    if (this.pageId == 0)
    {
      localView = LayoutInflater.from(getActivity()).inflate(2131559097, localLinearLayout, false);
      localImageView = (ImageView)localView.findViewById(2131368698);
      if (!QMSettingManager.sharedInstance().getMailListIcon()) {
        break label128;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.selectOtherCountTv = ((TextView)localView.findViewById(2131377950));
      this.selectOtherCountTv.setVisibility(8);
      localView.setOnClickListener(new VIPContactsFragment.18(this));
      localLinearLayout.addView(localView);
      this.contactListLV.addHeaderView(localLinearLayout);
      return;
      label128:
      localImageView.setVisibility(8);
    }
  }
  
  private void initSearchBar()
  {
    this.maskView = findViewById(2131365149);
    this.maskView.setOnClickListener(new VIPContactsFragment.12(this));
    this.scrollSearchBar = new QMSearchBar(getActivity());
    this.scrollSearchBar.setStateNormal();
    this.scrollSearchBar.searchInitWrap.setOnClickListener(new VIPContactsFragment.13(this));
    this.scrollSearchBar.setOnTouchListener(new VIPContactsFragment.14(this));
    if ((AccountManager.shareInstance().getAccountList().size() > 1) && ((this.pageId == 0) || (this.pageId == 4)))
    {
      this.scrollSearchBar.setBtnRight(getString(2131719414));
      this.scrollSearchBar.getBtnRight().setOnClickListener(new VIPContactsFragment.15(this));
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    this.mainWrapper.addView(this.scrollSearchBar, localLayoutParams);
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(2131695178);
    this.topBar.setButtonRightBlue(2131689701);
    this.topBar.getButtonRight().setEnabled(false);
    this.topBar.getButtonRight().setOnClickListener(new VIPContactsFragment.6(this));
    if (this.pageId == 0) {
      this.topBar.setButtonLeftNormal(2131691246);
    }
    for (;;)
    {
      this.topBar.getButtonLeft().setOnClickListener(new VIPContactsFragment.7(this));
      this.topBar.setCenterOnclickListener(new VIPContactsFragment.8(this));
      this.btnAdd = ((TextView)this.topBar.getButtonRight());
      return;
      this.topBar.setButtonLeftBack();
    }
  }
  
  private void initView()
  {
    this.mainWrapper = ((FrameLayout)findViewById(2131365252));
    this.mainWrapperParam = ((FrameLayout.LayoutParams)this.mainWrapper.getLayoutParams());
    this.sideIndexer = ((QMSideIndexer)findViewById(2131365151));
    this.sideIndexer.init();
    this.sideIndexer.setCallback(new VIPContactsFragment.9(this));
    this.contactListLV = ((ListView)findViewById(2131365148));
    this.searchListLV = ((ListView)findViewById(2131365150));
    this.searchListLV.setOnScrollListener(new VIPContactsFragment.10(this));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    VIPContactsFragment.11 local11 = new VIPContactsFragment.11(this);
    this.contactListLV.setOnItemClickListener(local11);
    this.searchListLV.setOnItemClickListener(local11);
  }
  
  private void querySectionMap()
  {
    QMContactManager.sharedInstance().querySectionMap(getDataSource()).subscribe(new VIPContactsFragment.19(this));
  }
  
  private void refreshAddNumber()
  {
    int i = VIPContactsAdapter.getSelectContacts().size();
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
    this.checkedAccountIds = QMContactManager.sharedInstance().getCheckedAccountArray();
    if ((this.isSearching) && (!StringExtention.isNullOrEmpty(this.searchKeyWord)))
    {
      refreshSearchData(paramQMRefreshCallback);
      return;
    }
    refreshNormalData(paramQMRefreshCallback);
  }
  
  private void refreshNormalData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (this.isRefreshData)
    {
      if ((getDataSource() != null) && ((this.pageId == 0) || (this.pageId == 4))) {
        getDataSource().setAccountIds(this.checkedAccountIds);
      }
      if (getDataSource() != null) {
        getDataSource().refresh(false, paramQMRefreshCallback);
      }
    }
    this.isRefreshData = true;
  }
  
  private void refreshSearchData(QMRefreshCallback paramQMRefreshCallback)
  {
    if (getSearchDataSource() == null) {
      setSearchDataSource();
    }
    ((ContactSearchCursor)getSearchDataSource()).setSearchKey(this.searchKeyWord);
    if ((this.pageId == 0) || (this.pageId == 4)) {
      getSearchDataSource().setAccountIds(this.checkedAccountIds);
    }
    getSearchDataSource().refresh(false, paramQMRefreshCallback);
  }
  
  private void refreshSelectOtherCount()
  {
    if (this.selectOtherCountTv != null)
    {
      int i = ContactsHelper.getOtherContactCount(VIPContactsAdapter.getSelectContacts());
      if (i > 0)
      {
        this.selectOtherCountTv.setText(String.format(getString(2131692066), new Object[] { String.valueOf(i) }));
        this.selectOtherCountTv.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.selectOtherCountTv.setVisibility(8);
  }
  
  private void renderNormalView()
  {
    if (((getDataSource() == null) || (getDataSource().getCount() == 0)) && (this.checkedAccountIds.length > 0))
    {
      if (this.isLoadContactError)
      {
        showErrorView();
        return;
      }
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
    this.contactListCursor = Threads.submitTask(new VIPContactsFragment.4(this));
  }
  
  private void setSearchDataSource()
  {
    this.searchListCursor = Threads.submitTask(new VIPContactsFragment.5(this));
  }
  
  private void showEmptyView()
  {
    showListView();
    this.listEmptyView.showTips(2131692057);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showErrorView()
  {
    showListView();
    this.listEmptyView.showTipsReload(2131692044, this.onReloadListener);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showListView()
  {
    if (this.adapter == null)
    {
      this.adapter = new VIPContactsAdapter(getActivity(), getDataSource());
      this.contactListLV.setAdapter(this.adapter);
    }
    for (;;)
    {
      querySectionMap();
      this.sideIndexer.show();
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
    if (this.searchAdapter != null) {
      this.searchAdapter.notifyDataSetChanged();
    }
    this.sideIndexer.hide();
    this.listEmptyView.showTips(2131692060);
    this.listEmptyView.setVisibility(0);
  }
  
  private void showSearchListView()
  {
    if (this.searchAdapter == null)
    {
      this.searchAdapter = new VIPContactsAdapter(getActivity(), getSearchDataSource());
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
      if (this.adapter != null) {
        this.adapter.notifyDataSetChanged();
      }
      this.searchListLV.setVisibility(8);
      this.listEmptyView.setVisibility(8);
      QMSearchBar localQMSearchBar = getStillSearchBar();
      localQMSearchBar.setVisibility(0);
      localQMSearchBar.searchInput.setText("");
      localQMSearchBar.searchInput.requestFocus();
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
      refreshSelectOtherCount();
      return;
      this.contactListLV.setVisibility(0);
      if (this.adapter != null) {
        this.adapter.notifyDataSetChanged();
      }
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
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource()
  {
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    this.group = QMContactManager.sharedInstance().getContactGroupById(this.groupId);
    if (this.pageId == 0) {
      VIPContactsAdapter.clearSelectContacts();
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initView();
    initSearchBar();
    initListHeader();
    initListFooter();
    DataCollector.logEvent("Event_Contact_Show_AddVipList");
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131558479, null, false);
  }
  
  public void launchContactsGroupSelect()
  {
    startActivity(QMContactGroupSelectActivity.createIntent());
  }
  
  public void onBackground()
  {
    super.onBackground();
    hideKeyBoard();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadContactListWatcher, paramBoolean);
    Watchers.bind(this.vipContactListWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.pageId != 0;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    if (this.pageId == 0) {
      return SCALE_TRANSITION_CONFIG;
    }
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    if (this.pageId == 0) {
      return SCALE_TRANSITION_CONFIG;
    }
    return SLIDE_TRANSITION_CONFIG;
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
      this.contactListLV.setAdapter(null);
      this.adapter = null;
    }
    if (this.searchAdapter != null)
    {
      this.searchAdapter = null;
      this.searchListLV.setAdapter(null);
    }
  }
  
  public int refreshData()
  {
    refreshData(null);
    return 0;
  }
  
  public void render(int paramInt)
  {
    if ((this.isSearching) && (!StringExtention.isNullOrEmpty(this.searchKeyWord))) {
      renderSearchView();
    }
    for (;;)
    {
      refreshAddNumber();
      refreshSelectOtherCount();
      return;
      renderNormalView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment
 * JD-Core Version:    0.7.0.1
 */