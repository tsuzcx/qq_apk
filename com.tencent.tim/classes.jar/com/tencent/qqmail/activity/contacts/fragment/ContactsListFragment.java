package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.QMContactGroupSelectActivity;
import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactSearchCursor;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Longs;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;
import rx.Observable;

public class ContactsListFragment
  extends ContactsBaseFragment
{
  private static final int REQUEST_CODE_CREATE = 200;
  public static final String TAG = "ContactsListFragment";
  private Account account;
  private int accountId;
  private ContactsListAdapter adapter;
  private Button btnAdd = null;
  private int[] checkedAccountIds;
  private TextView contactCountTv;
  private Future<ContactBaseListCursor> contactListCursor;
  private ListView contactListLV;
  private ContactGroup group;
  private int groupId;
  private boolean isChooseRecentSender;
  private boolean isEditMode;
  private boolean isLoadContact;
  private boolean isLoadContactError;
  private boolean isRefreshData;
  private boolean isSearching;
  private QMContentLoadingView listEmptyView;
  private LoadContactListWatcher loadContactListWatcher = new ContactsListFragment.1(this);
  private QMPopupWindow mPopupWindow;
  private FrameLayout mainWrapper;
  private FrameLayout.LayoutParams mainWrapperParam;
  private View maskView;
  private int nameListType;
  private long newContactId;
  private View.OnClickListener onReloadListener = new ContactsListFragment.5(this);
  private int pageId;
  private QMSearchBar scrollSearchBar;
  private ContactsListAdapter searchAdapter;
  private String searchKeyWord;
  private Future<ContactBaseListCursor> searchListCursor;
  private ListView searchListLV;
  private TextView selectOtherCountTv;
  private QMSideIndexer sideIndexer;
  private QMSearchBar stillSearchBar;
  private SyncContactWatcher syncContactWatcher = new ContactsListFragment.3(this);
  private SyncPhotoWatcher syncPhotoWatcher = new ContactsListFragment.4(this);
  private TextChangeTimer textChangeTimer = new TextChangeTimer();
  private QMTopBar topBar;
  private MailContact updateContact;
  private LoadVipContactListWatcher vipContactListWatcher = new ContactsListFragment.2(this);
  
  public ContactsListFragment(int paramInt1, int paramInt2, int paramInt3, MailContact paramMailContact, boolean paramBoolean)
  {
    super(false);
    this.pageId = paramInt1;
    this.accountId = paramInt2;
    this.groupId = paramInt3;
    this.updateContact = paramMailContact;
    this.isEditMode = paramBoolean;
    setDataSource();
  }
  
  public ContactsListFragment(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramInt3, null, paramBoolean);
  }
  
  public ContactsListFragment(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this(paramInt1, paramInt2, 0, null, false);
    this.isChooseRecentSender = paramBoolean;
    this.nameListType = paramInt3;
  }
  
  public ContactsListFragment(MailContact paramMailContact)
  {
    this(4, 0, 0, paramMailContact, false);
  }
  
  public ContactsListFragment(boolean paramBoolean)
  {
    this(0, 0, 0, null, paramBoolean);
  }
  
  private String generateTopBarTitle()
  {
    String str = getString(2131692063);
    if (this.pageId == 0) {
      str = getString(2131692063);
    }
    do
    {
      return str;
      if (this.pageId == 1) {
        return getString(2131692054);
      }
      if (this.pageId == 2) {
        return this.account.getEmail();
      }
      if (this.pageId == 3)
      {
        if (this.group != null) {
          return this.group.getName();
        }
        return "";
      }
      if (this.pageId == 4) {
        return "";
      }
    } while (this.pageId != 5);
    if (this.isChooseRecentSender) {
      return getString(2131690892);
    }
    return getString(2131692063);
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
      QMLog.log(6, "ContactsListFragment", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private QMPopupWindow getPopupWindow()
  {
    if (this.mPopupWindow == null) {
      this.mPopupWindow = new ContactsListFragment.12(this, getActivity(), true);
    }
    return this.mPopupWindow;
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
      QMLog.log(6, "ContactsListFragment", "getDataSource failed. " + localException.toString());
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
      this.stillSearchBar.getBtnRight().setOnClickListener(new ContactsListFragment.20(this));
      this.stillSearchBar.searchInput.addTextChangedListener(new ContactsListFragment.21(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
      this.mainWrapper.addView(this.stillSearchBar, localLayoutParams);
    }
    return this.stillSearchBar;
  }
  
  private void handleSelectContact()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ContactsListAdapter.getSelectContacts().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Long.valueOf(((MailContact)((Iterator)localObject).next()).getId()));
    }
    ContactsListAdapter.clearSelectContacts();
    localObject = new Intent();
    ((Intent)localObject).putExtra("result_select_contact_ids", Longs.toArray(localArrayList));
    getActivity().setResult(-1, (Intent)localObject);
    getActivity().finish();
  }
  
  private void initListFooter()
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(ActivityCompat.getColor(getActivity(), 2131167654));
    this.contactCountTv = new TextView(getActivity());
    this.contactCountTv.setLayoutParams(new LinearLayout.LayoutParams(-1, QMUIKit.dpToPx(48)));
    this.contactCountTv.setPadding(getResources().getDimensionPixelSize(2131297006), getResources().getDimensionPixelSize(2131297016), getResources().getDimensionPixelSize(2131297006), getResources().getDimensionPixelSize(2131297016));
    this.contactCountTv.setTextSize(13.0F);
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
      localView.setOnClickListener(new ContactsListFragment.22(this));
      localLinearLayout.addView(localView);
      this.contactListLV.addHeaderView(localLinearLayout);
      return;
      label128:
      localImageView.setVisibility(8);
    }
  }
  
  private void initSearchBar()
  {
    this.maskView = findViewById(2131365297);
    this.maskView.setOnClickListener(new ContactsListFragment.16(this));
    this.scrollSearchBar = new QMSearchBar(getActivity());
    this.scrollSearchBar.setStateNormal();
    this.scrollSearchBar.searchInitWrap.setOnClickListener(new ContactsListFragment.17(this));
    this.scrollSearchBar.setOnTouchListener(new ContactsListFragment.18(this));
    if ((AccountManager.shareInstance().getAccountList().size() > 1) && ((this.pageId == 0) || (this.pageId == 4)))
    {
      this.scrollSearchBar.setBtnRight(getString(2131719414));
      this.scrollSearchBar.getBtnRight().setOnClickListener(new ContactsListFragment.19(this));
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    this.mainWrapper.addView(this.scrollSearchBar, localLayoutParams);
    if ((this.pageId == 5) && (this.isChooseRecentSender)) {
      this.scrollSearchBar.setVisibility(8);
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131365300));
    this.topBar.setTitle(generateTopBarTitle());
    if ((this.pageId == 0) && (!this.isEditMode))
    {
      this.topBar.setButtonRightIcon(2130841090);
      this.topBar.getButtonRight().setOnClickListener(new ContactsListFragment.8(this));
      this.topBar.getButtonRight().setContentDescription(getString(2131720798));
      if (this.pageId != 5) {
        break label201;
      }
      this.topBar.setButtonLeftIcon(2130841088);
    }
    for (;;)
    {
      this.topBar.getButtonLeft().setOnClickListener(new ContactsListFragment.10(this));
      this.topBar.setCenterOnclickListener(new ContactsListFragment.11(this));
      return;
      if (!this.isEditMode) {
        break;
      }
      this.topBar.setButtonRightBlue(2131689701);
      this.topBar.getButtonRight().setEnabled(false);
      this.topBar.getButtonRight().setOnClickListener(new ContactsListFragment.9(this));
      this.btnAdd = ((Button)this.topBar.getButtonRight());
      break;
      label201:
      this.topBar.setButtonLeftBack();
    }
  }
  
  private void initView()
  {
    this.mainWrapper = ((FrameLayout)findViewById(2131365296));
    this.mainWrapperParam = ((FrameLayout.LayoutParams)this.mainWrapper.getLayoutParams());
    this.sideIndexer = ((QMSideIndexer)findViewById(2131365299));
    this.sideIndexer.init();
    this.sideIndexer.setCallback(new ContactsListFragment.13(this));
    this.contactListLV = ((ListView)findViewById(2131365288));
    if ((this.pageId == 5) && (this.isChooseRecentSender)) {
      ((ViewGroup.MarginLayoutParams)this.contactListLV.getLayoutParams()).setMargins(this.contactListLV.getListPaddingLeft(), 0, this.contactListLV.getListPaddingRight(), this.contactListLV.getListPaddingBottom());
    }
    this.searchListLV = ((ListView)findViewById(2131365298));
    this.searchListLV.setOnScrollListener(new ContactsListFragment.14(this));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131365289));
    ContactsListFragment.15 local15 = new ContactsListFragment.15(this);
    this.contactListLV.setOnItemClickListener(local15);
    this.searchListLV.setOnItemClickListener(local15);
  }
  
  private void logEvent()
  {
    if (this.pageId == 0)
    {
      DataCollector.logEvent("Event_Contact_NormalContact");
      return;
    }
    DataCollector.logEvent("Event_Contact_OtherContact");
  }
  
  private void querySectionMap()
  {
    QMContactManager.sharedInstance().querySectionMap(getDataSource()).subscribe(new ContactsListFragment.23(this));
  }
  
  private void refreshAddNumber()
  {
    if ((this.isEditMode) && (this.btnAdd != null))
    {
      int i = ContactsSelectAdapter.getSelectContacts().size();
      if (i > 0)
      {
        this.btnAdd.setEnabled(true);
        this.btnAdd.setText(getString(2131689701) + "(" + i + ")");
      }
    }
    else
    {
      return;
    }
    this.btnAdd.setEnabled(false);
    this.btnAdd.setText(getString(2131689701));
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
    if ((this.isEditMode) && (this.selectOtherCountTv != null))
    {
      int i = ContactsHelper.getOtherContactCount(ContactsListAdapter.getSelectContacts());
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
  
  private void refreshTopBar()
  {
    if (this.topBar.getButtonRight() != null)
    {
      if (!QMContactManager.sharedInstance().getCheckedAccountIds().isEmpty()) {
        break label42;
      }
      this.topBar.getButtonRight().setEnabled(false);
    }
    for (;;)
    {
      refreshAddNumber();
      refreshSelectOtherCount();
      return;
      label42:
      this.topBar.getButtonRight().setEnabled(true);
    }
  }
  
  private void renderNormalView()
  {
    if (((getDataSource() == null) || (getDataSource().getCount() == 0)) && (this.checkedAccountIds != null) && (this.checkedAccountIds.length > 0))
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
  
  private void scrollToNewContact()
  {
    if (this.newContactId != 0L)
    {
      if (!this.isSearching) {
        break label37;
      }
      ContactUIHelper.scrollTopNewContact(this.searchListLV, getSearchDataSource(), this.newContactId);
    }
    for (;;)
    {
      this.newContactId = 0L;
      return;
      label37:
      ContactUIHelper.scrollTopNewContact(this.contactListLV, getDataSource(), this.newContactId);
    }
  }
  
  private void setDataSource()
  {
    this.contactListCursor = Threads.submitTask(new ContactsListFragment.6(this));
  }
  
  private void setSearchDataSource()
  {
    this.searchListCursor = Threads.submitTask(new ContactsListFragment.7(this));
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
    boolean bool1;
    if (this.adapter == null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      ContactBaseListCursor localContactBaseListCursor = getDataSource();
      boolean bool2 = this.isEditMode;
      if (this.pageId == 5)
      {
        bool1 = true;
        this.adapter = new ContactsListAdapter(localFragmentActivity, localContactBaseListCursor, bool2, bool1);
        this.contactListLV.setAdapter(this.adapter);
        label60:
        querySectionMap();
        this.contactListLV.setVisibility(0);
        this.searchListLV.setVisibility(8);
        this.listEmptyView.setVisibility(8);
        if (this.adapter.getCount() <= 0) {
          break label181;
        }
        this.contactCountTv.setText(String.format(getString(2131692018), new Object[] { Integer.valueOf(this.adapter.getCount()) }));
        this.contactCountTv.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.pageId != 5) {
        ContactUIHelper.restoreAndClearPosition(this.pageId, this.groupId, this.contactListLV);
      }
      return;
      bool1 = false;
      break;
      this.adapter.notifyDataSetChanged();
      break label60;
      label181:
      this.contactCountTv.setVisibility(8);
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
    boolean bool1;
    if (this.searchAdapter == null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      ContactBaseListCursor localContactBaseListCursor = getSearchDataSource();
      boolean bool2 = this.isEditMode;
      if (this.pageId == 5)
      {
        bool1 = true;
        this.searchAdapter = new ContactsListAdapter(localFragmentActivity, localContactBaseListCursor, bool2, bool1);
        this.searchListLV.setAdapter(this.searchAdapter);
      }
    }
    for (;;)
    {
      this.sideIndexer.hide();
      this.contactListLV.setVisibility(8);
      this.searchListLV.setVisibility(0);
      this.listEmptyView.setVisibility(8);
      return;
      bool1 = false;
      break;
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
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    this.group = QMContactManager.sharedInstance().getContactGroupById(this.groupId);
    if (this.pageId == 0) {
      ContactsListAdapter.clearSelectContacts();
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initView();
    initSearchBar();
    initListHeader();
    initListFooter();
    logEvent();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    startTrace();
    getActivity().getWindow().setSoftInputMode(32);
    paramViewHolder = new FrameLayout.LayoutParams(-1, -1, 112);
    View localView = View.inflate(getActivity(), 2131559095, null);
    localView.setLayoutParams(paramViewHolder);
    localView.setVerticalFadingEdgeEnabled(false);
    TimReportManager.reportClickEvent(getActivity(), "0X8008908", 0, 0, 0, 0, 0, "", "", "", "");
    return localView;
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
    Watchers.bind(this.syncContactWatcher, paramBoolean);
    Watchers.bind(this.vipContactListWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.pageId != 5;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    if (this.pageId == 5) {
      return SCALE_TRANSITION_CONFIG;
    }
    return super.onFetchTransaction();
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onFragmentResult(paramInt1, paramInt2, paramHashMap);
      return;
      if ((paramHashMap != null) && (paramHashMap.get("edit_new_id") != null)) {
        this.newContactId = ((Long)paramHashMap.get("edit_new_id")).longValue();
      }
    }
  }
  
  public void onRelease()
  {
    ContactUIHelper.storePostion(this.pageId, this.groupId, this.contactListLV);
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
  
  public int refreshData()
  {
    refreshData(null);
    return 0;
  }
  
  public void render(int paramInt)
  {
    refreshTopBar();
    if ((this.isSearching) && (!StringExtention.isNullOrEmpty(this.searchKeyWord))) {
      renderSearchView();
    }
    for (;;)
    {
      endTrace("ContactsListFragment" + this.pageId);
      return;
      renderNormalView();
    }
  }
  
  public void showPopWindow(View paramView)
  {
    QMPopupWindow localQMPopupWindow = getPopupWindow();
    if (localQMPopupWindow.isShowing()) {
      localQMPopupWindow.dismiss();
    }
    if ((getDataSource() == null) || (getDataSource().getCount() == 0)) {}
    for (ArrayList localArrayList = Lists.newArrayList(new String[] { getString(2131692000) });; localArrayList = Lists.newArrayList(new String[] { getString(2131692000), getString(2131692052) }))
    {
      localQMPopupWindow.setAdapter(new PopupAdapter(getActivity(), 2131559771, 2131373495, localArrayList));
      localQMPopupWindow.setAnchor(paramView);
      localQMPopupWindow.showDown();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment
 * JD-Core Version:    0.7.0.1
 */