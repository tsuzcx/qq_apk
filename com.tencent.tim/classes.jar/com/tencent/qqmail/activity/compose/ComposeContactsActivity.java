package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.contact.cursor.ContactSearchCursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
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

public class ComposeContactsActivity
  extends BaseActivityEx
{
  private static final int REQUEST_FOR_MOBILE_CONTACT = 200;
  private static final int REQUEST_FOR_RTX_CONTACT = 300;
  private static final String TAG = "ComposeContactsActivity";
  private ComposeContactsAdapter adapter;
  private TextView btnAdd;
  private int[] checkedAccountIds;
  private Future<ContactBaseListCursor> contactListCursor;
  private ListView contactListLV;
  private long endTime;
  private boolean hasRTXContacts = false;
  private boolean isLoadContact;
  private boolean isLoadContactError;
  private boolean isRefreshData;
  private boolean isSearching;
  private QMContentLoadingView listEmptyView;
  private LoadContactListWatcher loadContactListWatcher = new ComposeContactsActivity.1(this);
  private LinearLayout mHeaderView;
  private FrameLayout mainWrapper;
  private FrameLayout.LayoutParams mainWrapperParam;
  private View maskView;
  private View.OnClickListener onReloadListener = new ComposeContactsActivity.3(this);
  private QMSearchBar scrollSearchBar;
  private ComposeContactsAdapter searchAdapter;
  private String searchKeyWord = "";
  private Future<ContactBaseListCursor> searchListCursor;
  private ListView searchListLV;
  private TextView selectOtherCountTv;
  private QMSideIndexer sideIndexer;
  private long startTime;
  private QMSearchBar stillSearchBar;
  private TextChangeTimer textChangeTimer = new TextChangeTimer();
  private QMTopBar topBar;
  private LoadVipContactListWatcher vipContactListWatcher = new ComposeContactsActivity.2(this);
  
  private LinearLayout generateAddMobileContactsView()
  {
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTextView.setText(getResources().getString(2131692054));
    localTextView.setTextColor(getResources().getColor(2131166572));
    localTextView.setTextSize(2, 16.0F);
    localTextView.setDuplicateParentStateEnabled(true);
    localObject = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.selectOtherCountTv = new TextView(this);
    this.selectOtherCountTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.selectOtherCountTv.setTextColor(getResources().getColor(2131166576));
    this.selectOtherCountTv.setTextSize(2, 14.0F);
    this.selectOtherCountTv.setDuplicateParentStateEnabled(true);
    this.selectOtherCountTv.setVisibility(4);
    int i = getResources().getDimensionPixelSize(2131297032);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297614)));
    ((LinearLayout)localObject).setBackgroundResource(2130845611);
    ((LinearLayout)localObject).setGravity(16);
    ((LinearLayout)localObject).setOrientation(0);
    ((LinearLayout)localObject).setClickable(true);
    ((LinearLayout)localObject).addView(localTextView);
    ((LinearLayout)localObject).addView(this.selectOtherCountTv);
    ((LinearLayout)localObject).setPadding(i, 0, i, 0);
    return localObject;
  }
  
  private LinearLayout generateAddRTXContactsView()
  {
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localTextView.setText(getResources().getString(2131692074));
    localTextView.setTextColor(getResources().getColor(2131166572));
    localTextView.setTextSize(2, 16.0F);
    localTextView.setDuplicateParentStateEnabled(true);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localObject1 = new TextView(this);
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setTextColor(getResources().getColor(2131166576));
    ((TextView)localObject1).setTextSize(2, 14.0F);
    ((TextView)localObject1).setDuplicateParentStateEnabled(true);
    ((TextView)localObject1).setVisibility(4);
    int i = getResources().getDimensionPixelSize(2131297032);
    localObject2 = new LinearLayout(this);
    ((LinearLayout)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297614)));
    ((LinearLayout)localObject2).setBackgroundResource(2130845611);
    ((LinearLayout)localObject2).setGravity(16);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setClickable(true);
    ((LinearLayout)localObject2).addView(localTextView);
    ((LinearLayout)localObject2).addView((View)localObject1);
    ((LinearLayout)localObject2).setPadding(i, 0, i, 0);
    return localObject2;
  }
  
  public static ArrayList<MailContact> getAllCheckedContacts()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(ComposeContactsAdapter.getSelectContacts());
    ComposeContactsAdapter.clearSelectContacts();
    return localArrayList;
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
      QMLog.log(6, "ComposeContactsActivity", "getDataSource failed. " + localException.toString());
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
      QMLog.log(6, "ComposeContactsActivity", "getDataSource failed. " + localException.toString());
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
      this.stillSearchBar.getBtnRight().setOnClickListener(new ComposeContactsActivity.16(this));
      this.stillSearchBar.searchInput.addTextChangedListener(new ComposeContactsActivity.17(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
      this.mainWrapper.addView(this.stillSearchBar, localLayoutParams);
    }
    return this.stillSearchBar;
  }
  
  private void initListHeader()
  {
    this.mHeaderView = new LinearLayout(this);
    this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.mHeaderView.setOrientation(1);
    LinearLayout localLinearLayout = generateAddMobileContactsView();
    localLinearLayout.setOnClickListener(new ComposeContactsActivity.18(this));
    this.mHeaderView.addView(localLinearLayout);
    if (DeviceUtil.isWeWorkInstalled())
    {
      localLinearLayout = generateAddRTXContactsView();
      localLinearLayout.setBackgroundResource(2130838855);
      localLinearLayout.setOnClickListener(new ComposeContactsActivity.19(this));
      this.mHeaderView.addView(localLinearLayout);
      this.hasRTXContacts = true;
    }
    this.mHeaderView.setPadding(0, 0, 0, 1);
    this.mHeaderView.setBackgroundResource(2130841260);
    this.contactListLV.addHeaderView(this.mHeaderView);
  }
  
  private void initSearchBar()
  {
    this.maskView = findViewById(2131365149);
    this.maskView.setOnClickListener(new ComposeContactsActivity.12(this));
    this.scrollSearchBar = new QMSearchBar(getActivity());
    this.scrollSearchBar.setStateNormal();
    this.scrollSearchBar.searchInitWrap.setOnClickListener(new ComposeContactsActivity.13(this));
    this.scrollSearchBar.setOnTouchListener(new ComposeContactsActivity.14(this));
    if (AccountManager.shareInstance().getAccountList().size() > 1)
    {
      this.scrollSearchBar.setBtnRight(getString(2131719414));
      this.scrollSearchBar.getBtnRight().setOnClickListener(new ComposeContactsActivity.15(this));
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    this.mainWrapper.addView(this.scrollSearchBar, localLayoutParams);
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(2131692088);
    this.topBar.setButtonRightBlue(2131689701);
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.getButtonRight().setEnabled(false);
    this.topBar.getButtonRight().setOnClickListener(new ComposeContactsActivity.6(this));
    this.topBar.getButtonLeft().setOnClickListener(new ComposeContactsActivity.7(this));
    this.topBar.setCenterOnclickListener(new ComposeContactsActivity.8(this));
    this.btnAdd = ((TextView)this.topBar.getButtonRight());
  }
  
  private void initView()
  {
    this.mainWrapper = ((FrameLayout)findViewById(2131365252));
    this.mainWrapperParam = ((FrameLayout.LayoutParams)this.mainWrapper.getLayoutParams());
    this.sideIndexer = ((QMSideIndexer)findViewById(2131365151));
    this.sideIndexer.init();
    this.sideIndexer.setCallback(new ComposeContactsActivity.9(this));
    this.contactListLV = ((ListView)findViewById(2131365148));
    this.searchListLV = ((ListView)findViewById(2131365150));
    this.searchListLV.setOnScrollListener(new ComposeContactsActivity.10(this));
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    ComposeContactsActivity.11 local11 = new ComposeContactsActivity.11(this);
    this.contactListLV.setOnItemClickListener(local11);
    this.searchListLV.setOnItemClickListener(local11);
  }
  
  private void querySectionMap()
  {
    QMContactManager.sharedInstance().querySectionMap(getDataSource()).subscribe(new ComposeContactsActivity.20(this));
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
    if ((this.isRefreshData) && (getDataSource() != null))
    {
      getDataSource().setAccountIds(this.checkedAccountIds);
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
    getSearchDataSource().setAccountIds(this.checkedAccountIds);
    getSearchDataSource().refresh(false, paramQMRefreshCallback);
  }
  
  private void refreshSelectOtherCount()
  {
    if (this.selectOtherCountTv != null)
    {
      int i = ContactsHelper.getMobileContactCount(ComposeContactsAdapter.getSelectContacts());
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
    this.selectOtherCountTv.setVisibility(4);
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
    this.contactListCursor = Threads.submitTask(new ComposeContactsActivity.4(this));
  }
  
  private void setSearchDataSource()
  {
    this.searchListCursor = Threads.submitTask(new ComposeContactsActivity.5(this));
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
  
  private void showKeyBoard()
  {
    KeyBoardHelper.showKeyBoard(0, 1);
  }
  
  private void showListView()
  {
    if (this.adapter == null)
    {
      this.adapter = new ComposeContactsAdapter(getActivity(), getDataSource());
      this.adapter.setHideEmailCount(true);
      this.contactListLV.setAdapter(this.adapter);
    }
    for (;;)
    {
      querySectionMap();
      this.contactListLV.setVisibility(0);
      this.searchListLV.setVisibility(8);
      this.listEmptyView.setVisibility(8);
      if (this.adapter.getCount() <= 0) {
        break;
      }
      this.mHeaderView.setPadding(0, 0, 0, 0);
      this.mHeaderView.setBackgroundResource(0);
      return;
      this.adapter.notifyDataSetChanged();
    }
    this.mHeaderView.setPadding(0, 0, 0, 1);
    this.mHeaderView.setBackgroundResource(2130841260);
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
      this.searchAdapter = new ComposeContactsAdapter(getActivity(), getSearchDataSource());
      this.searchAdapter.setHideEmailCount(true);
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
  
  protected void gotoComposeMobileContacts()
  {
    startActivityForResult(ComposeMobileContactsActivity.createIntent(), 200);
  }
  
  protected void gotoRTXContactList()
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setPackage("com.tencent.wework");
    try
    {
      startActivityForResult(localIntent, 300);
      return;
    }
    catch (Exception localException)
    {
      Toast.makeText(getApplicationContext(), getString(2131696561), 0).show();
    }
  }
  
  public void initDataSource()
  {
    setDataSource();
    ComposeContactsAdapter.clearSelectContacts();
  }
  
  public void initDom()
  {
    initTopBar();
    initView();
    initSearchBar();
    initListHeader();
  }
  
  public void initUI()
  {
    this.startTime = System.currentTimeMillis();
    setContentView(2131558479);
  }
  
  public void launchContactsGroupSelect()
  {
    startActivity(QMContactGroupSelectActivity.createIntent());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 200) {
      if (paramInt2 == -1)
      {
        setResult(-1);
        finish();
      }
    }
    ArrayList localArrayList1;
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 300) || (paramInt2 != -1));
      localArrayList1 = paramIntent.getStringArrayListExtra("nickname");
      paramIntent = paramIntent.getStringArrayListExtra("email");
    } while ((localArrayList1 == null) || (paramIntent == null));
    setResult(-1);
    ArrayList localArrayList2 = new ArrayList();
    paramInt2 = Math.min(localArrayList1.size(), paramIntent.size());
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localArrayList2.add(new MailContact((String)localArrayList1.get(paramInt1), (String)paramIntent.get(paramInt1)));
      paramInt1 += 1;
    }
    this.adapter.addSelectContacts(localArrayList2);
    finish();
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
      if (this.hasRTXContacts) {
        DataCollector.logEvent("Event_RTX_Compose_Contact_Show");
      }
      refreshAddNumber();
      refreshSelectOtherCount();
      if (this.endTime == 0L)
      {
        this.endTime = System.currentTimeMillis();
        QMLog.log(4, "ComposeContactsActivity", "#render begintime : " + this.startTime + " endtime : " + this.endTime + " totaltime : " + (this.endTime - this.startTime));
      }
      return;
      renderNormalView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity
 * JD-Core Version:    0.7.0.1
 */