package com.tencent.qqmail.folderlist;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.alibaba.fastjson.JSONArray;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.activity.setting.SettingCacheClearActivity;
import com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.attachment.activity.AttachFolderListFragment;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.adapter.QMFolderListDragAdapter;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.folderlist.model.IListItem.ItemType;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.maillist.view.MailListBarHelper;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.BottleOpenNotifyWatcher;
import com.tencent.qqmail.model.mail.watcher.FolderUnreadCountWatcher;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.mail.watcher.QMTaskListChangeWatcher;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.RelativeVerifyWatcher;
import com.tencent.qqmail.model.mail.watcher.RenderSyncErrorBarWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.movemail.ManageFolderActivity;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.search.fragment.SearchListFragment;
import com.tencent.qqmail.sendmaillist.SendMailListFragment;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import com.tencent.qqmail.utilities.ui.PopupAdapterDividerLine;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.SyncErrorBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment;
import moai.fragment.base.SaveArgumentField;
import moai.oss.KvHelper;
import rx.Observable;

public class FolderListFragment
  extends MailFragment
{
  public static final String CONTROLLER_FOLDER_LIST = "folderList";
  public static final String FROM_CONTROLLER = "fromController";
  public static final String TAG = "FolderListFragment";
  private final int MAX_INIT_SYNC_COUNT = 5;
  private final int REQUEST_ADD_APP_FOLDER = 1;
  private final int REQUEST_MANAGE_FOLDER = 0;
  private final int REQUEST_TIM_GUIDE_TO_LOGIN = 2;
  private Set<Integer> activeFolderIds;
  private boolean autoOpenSearch = false;
  private QMBaseView baseView;
  private final MailDeleteWatcher deleteWatcher = new FolderListFragment.6(this);
  private HashMap<Integer, Boolean> editingItems = new HashMap();
  private QMContentLoadingView emptyView = null;
  private QMUnlockFolderPwdWatcher folderLockWatcher = new FolderListFragment.8(this);
  private IObserver folderTopTipObserver = new IObserver(new FolderListFragment.12(this));
  private FolderUnreadCountWatcher folderUnreadCountWatcher = new FolderListFragment.43(this);
  private FtnQueryExpireUnreadWatcher ftnQueryExpireUnreadWatcher = new FolderListFragment.44(this);
  private int initSyncCount = 0;
  private int initialLastVisiblePosition = -1;
  private boolean isLoadingAuto = false;
  private boolean isLogPopularize;
  private LoadListWatcher listWatcher = new FolderListFragment.46(this);
  private FolderLockDialog lockDialog;
  private AccountManager mAccMan = null;
  private Account mAccount = null;
  @SaveArgumentField
  private int mAccountId = 0;
  private AccountList mAccounts = null;
  private QMFolderListAdapter mAdapter;
  private ArrayList<QMFolder> mAllRealFolders = new ArrayList();
  private ArrayList<FolderData> mAllUniversalFolderDatas = new ArrayList();
  private final BottleOpenNotifyWatcher mBottleOpenNotifyWatcher = new FolderListFragment.36(this);
  private FrameLayout mBottomView;
  private LoadAttachFolderListWatcher mCheckAttachFolderListWatcher = new FolderListFragment.10(this);
  private RelativeLayout mContainBottomLayout;
  private List<IListFolder> mCurFolderList = null;
  private QMFolderListDragAdapter mDragAdapter;
  private DragSortController mDragListController;
  private boolean mEditMode = false;
  private int mEditShowCounter = 0;
  private List<QMFolder> mFolders = null;
  private final HashMap<String, Boolean> mInboxFolderMap = new HashMap();
  private boolean mIsFtnUnreadSync = false;
  private boolean mIsGoingToComposeNote = false;
  private ItemScrollListView mList;
  private DragSortListView mListDrag;
  private QMMailManager mMailMan = null;
  private int mNewFolderId = 0;
  private PopularizeBanner mPopularizeBanner;
  private PopularizeBanner mPopularizeBannerForDrag;
  public QMPopupWindow mPopupWindow;
  private SyncErrorBar mSyncErrorBar;
  private int mTotalAccountNum = 0;
  private final BottleListController.UpdateUnreadStatusWatcher mUnreadWatch = new FolderListFragment.37(this);
  private MailOperate mailOperate = new MailOperate();
  private Timer netTimer;
  private View.OnClickListener onReloadListener = new FolderListFragment.32(this);
  private PopupWindow outOfSightHasNewPw;
  private Runnable outofSightHasNewPwRunnable;
  private RelativeVerifyWatcher relativeAccWatcher = new FolderListFragment.7(this);
  private RenderSyncErrorBarWatcher renderSyncErrorBarWatcher = new FolderListFragment.11(this);
  private JSONArray sceneArray;
  private SyncWatcher syncWatcher = new FolderListFragment.45(this);
  private QMTaskListChangeWatcher taskListChangeWatcher = new FolderListFragment.9(this);
  private MailUnReadWatcher unreadWatcher = new FolderListFragment.5(this);
  
  public FolderListFragment(int paramInt)
  {
    super(true);
    this.mAccountId = paramInt;
  }
  
  public FolderListFragment(int paramInt, boolean paramBoolean)
  {
    super(true);
    this.mAccountId = paramInt;
    this.autoOpenSearch = paramBoolean;
  }
  
  private void autoExpandItemForClickFolderTopTip()
  {
    Threads.runOnMainThread(new FolderListFragment.41(this), 600L);
  }
  
  private void bindEvenet(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("folder_top_tip_click", this.folderTopTipObserver);
      return;
    }
    QMNotification.unregistNotification("folder_top_tip_click", this.folderTopTipObserver);
  }
  
  private void enterEditMode()
  {
    swapEditState(true);
    renderMode();
    toggleModeRefreshFolderData();
    this.mInboxFolderMap.clear();
    Iterator localIterator = this.mCurFolderList.iterator();
    while (localIterator.hasNext())
    {
      IListFolder localIListFolder = (IListFolder)localIterator.next();
      if ((localIListFolder.getName() != null) && (localIListFolder.getName().contains(getString(2131693913)))) {
        this.mInboxFolderMap.put(localIListFolder.getName(), Boolean.valueOf(localIListFolder.shouldShow()));
      }
    }
    resetScrollPosition(this.mList, this.mListDrag);
  }
  
  private void enterNormalMode()
  {
    Iterator localIterator = this.mCurFolderList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      IListFolder localIListFolder = (IListFolder)localIterator.next();
      Boolean localBoolean = (Boolean)this.mInboxFolderMap.get(localIListFolder.getName());
      if ((localBoolean == null) || (localIListFolder.shouldShow()) || (localBoolean.booleanValue() == localIListFolder.shouldShow())) {
        break label222;
      }
      i = 1;
    }
    label222:
    for (;;)
    {
      break;
      if (i != 0)
      {
        DataCollector.logEvent("Event_Folderlist_Hide_Inbox_Dialog_Show");
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131693745)).setMessage(2131693912).addAction(2131691246, new FolderListFragment.25(this))).addAction(0, 2131696547, new FolderListFragment.24(this))).create().show();
        return;
      }
      if (this.editingItems != null) {
        this.editingItems.clear();
      }
      this.mInboxFolderMap.clear();
      swapEditState(false);
      saveFolderOrder();
      renderMode();
      toggleModeRefreshFolderData();
      resetScrollPosition(this.mListDrag, this.mList);
      if (this.mEditShowCounter > 0) {
        DataCollector.logEvent("Event_Attach_Show_FavList");
      }
      this.mEditShowCounter = 0;
      return;
    }
  }
  
  private int findReverseNearestSectionPosition(int paramInt)
  {
    paramInt -= 1;
    while (paramInt >= 0)
    {
      if (this.mAdapter.getItemViewType(paramInt) == IListItem.ItemType.SECTION.ordinal()) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  private int getTheFolderClickTipPosition(QMFolder paramQMFolder)
  {
    List localList = this.mAdapter.getData();
    int i = 0;
    while (i < localList.size())
    {
      if (isTheFolderClickTip((IListFolder)localList.get(i), paramQMFolder)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void gotoImageScan() {}
  
  private void gotoManageFolder(QMFolder paramQMFolder)
  {
    int i = paramQMFolder.getType();
    int j = paramQMFolder.getAccountId();
    if ((paramQMFolder.getId() != -4) && (FolderLockDialog.isFolderLock(paramQMFolder.getId())))
    {
      if (this.lockDialog != null) {
        this.lockDialog.dismissTips();
      }
      this.lockDialog = new FolderLockDialog(getActivity(), paramQMFolder.getId(), j, new FolderListFragment.47(this, paramQMFolder, i));
      this.lockDialog.createDialog(1);
      this.lockDialog.showDialog();
      return;
    }
    gotoManageFolder(paramQMFolder, i, j);
  }
  
  private void gotoManageFolder(QMFolder paramQMFolder, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    if (paramQMFolder == null) {}
    while (!FolderListItemHelper.folderTypeIsEditable(paramInt1)) {
      return;
    }
    Object localObject1;
    int i;
    boolean bool1;
    if (paramQMFolder != null)
    {
      localObject1 = Integer.valueOf(paramQMFolder.getId());
      i = ((Integer)localObject1).intValue();
      localObject1 = localObject2;
      if (paramQMFolder != null) {
        localObject1 = paramQMFolder.getName();
      }
      if (14 != paramInt1) {
        break label92;
      }
      bool1 = true;
      label61:
      if (13 != paramInt1) {
        break label98;
      }
    }
    for (;;)
    {
      startActivityForResult(ManageFolderActivity.createIntentForRename(paramInt2, i, (String)localObject1, bool1, bool2, false), 0);
      return;
      localObject1 = null;
      break;
      label92:
      bool1 = false;
      break label61;
      label98:
      bool2 = false;
    }
  }
  
  private void gotoSetting()
  {
    if (!QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount()) {
      QMSettingManager.sharedInstance().setAppTopBarGuideUpgradedAccount();
    }
    startActivity(SettingActivity.createIntent("from_none"));
  }
  
  private void handleRightViewClickDeleteOrHide(int paramInt)
  {
    IListFolder localIListFolder = this.mAdapter.getItem(paramInt);
    int i = ((QMFolder)localIListFolder.getData()).getId();
    if (QMFolderManager.isAppFolder((QMFolder)localIListFolder.getData()))
    {
      QMLog.log(4, "FolderListFragment", "hide app folder:" + i);
      ListViewRemoveItemAnimator.animateRemoval(this.mList, Arrays.asList(new Integer[] { Integer.valueOf(paramInt) }), new FolderListFragment.2(this, localIListFolder, i));
      switch (i)
      {
      default: 
        if (((QMFolder)localIListFolder.getData()).getType() == 130) {
          DataCollector.logEvent("Event_Popularize_Click_Hide");
        }
        break;
      }
    }
    while ((((QMFolder)localIListFolder.getData()).getType() != 5) && (((QMFolder)localIListFolder.getData()).getType() != 6)) {
      for (;;)
      {
        return;
        DataCollector.logEvent("Event_Addressbook_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Bottle_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Calendar_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Ftn_Click_Hide");
        continue;
        DataCollector.logEvent("Event_Note_Click_Hide");
      }
    }
    this.mList.reset();
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131691517)).setMessage(2131697041).addAction(2131691246, new FolderListFragment.4(this))).addAction(0, 2131691839, 2, new FolderListFragment.3(this, localIListFolder))).create().show();
  }
  
  private void handleRightViewClickRead(int paramInt)
  {
    IListFolder localIListFolder;
    int i;
    if ((this.mAdapter != null) && (this.mAdapter.canRightScroll(paramInt)))
    {
      localIListFolder = this.mAdapter.getItem(paramInt);
      paramInt = ((QMFolder)localIListFolder.getData()).getId();
      i = ((QMFolder)localIListFolder.getData()).getAccountId();
      if (paramInt == -10) {
        this.mList.reset();
      }
    }
    else
    {
      return;
    }
    runInBackground(new FolderListFragment.1(this, localIListFolder, i, paramInt));
  }
  
  private void handleRightViewClickTop(int paramInt)
  {
    IListFolder localIListFolder = this.mAdapter.getItem(paramInt);
    QMFolder localQMFolder = (QMFolder)localIListFolder.getData();
    if (this.mTotalAccountNum > 1)
    {
      showHomeFolder(localQMFolder);
      return;
    }
    setTopFolder(paramInt, localIListFolder, localQMFolder);
  }
  
  private void initClearCacheDialog()
  {
    SettingCacheClearActivity.showRemindClearCacheDialog(getActivity(), this.baseView, new FolderListFragment.51(this));
  }
  
  private void initData()
  {
    this.mAccount = this.mAccMan.getAccountList().getAccountById(this.mAccountId);
    if (this.mAccount == null) {
      QMLog.log(6, "FolderListFragment", "account null with id " + this.mAccountId);
    }
    this.mTotalAccountNum = this.mAccMan.getAccountList().size();
    Object localObject = getActivity().getIntent().getExtras();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("savetomyftnkey");
      localObject = ((Bundle)localObject).getString("savetomyftncode");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        QMLog.log(3, "FolderListFragment", "handleSaveToMyFtn:" + str + "," + (String)localObject);
        LaunchSaveToMyFtn.handleSaveFtn(str, (String)localObject);
      }
    }
    if (this.mTotalAccountNum > 1) {
      this.activeFolderIds = FolderDataManager.sharedInstance().getActiveFolderIdsByAccountId(this.mAccountId);
    }
  }
  
  private void initDragSortListView()
  {
    QMSearchBar localQMSearchBar = new QMSearchBar(getActivity());
    localQMSearchBar.setStateNormal();
    localQMSearchBar.setSearchbarEnable(false);
    localQMSearchBar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.mDragAdapter = new QMFolderListDragAdapter(getActivity(), this.mAccountId, new ArrayList());
    this.mPopularizeBannerForDrag.render(this.mListDrag, false);
    this.mListDrag.addHeaderView(localQMSearchBar);
    this.mListDrag.setAdapter(this.mDragAdapter);
    this.mListDrag.setDragEnabled(true);
    this.mDragListController = new FolderListFragment.16(this, this.mListDrag, 2131367366, 6, 0);
    this.mListDrag.setFloatViewManager(this.mDragListController);
    this.mListDrag.setOnTouchListener(this.mDragListController);
    this.mListDrag.setOnItemClickListener(new FolderListFragment.17(this));
  }
  
  private void initItemScrollListView()
  {
    this.mPopularizeBanner.render(this.mList, false);
    QMSearchBar localQMSearchBar = new QMSearchBar(getActivity());
    localQMSearchBar.setStateNormal();
    localQMSearchBar.searchInitWrap.setOnClickListener(new FolderListFragment.18(this));
    this.mList.addHeaderView(localQMSearchBar);
    this.mList.addHeaderView(this.mSyncErrorBar);
    this.mList.setOnRefreshListener(new FolderListFragment.19(this));
    this.mList.setOnRightViewClickListener(new FolderOnRightViewClickListener(null));
    this.mList.setDataCollectCallback(new FolderListFragment.20(this));
    this.mList.setOnItemClickListener(new FolderListItemListener(null));
    this.mList.setOnItemLongClickListener(new FolderListFragment.21(this));
    this.mAdapter = new QMFolderListAdapter(getActivity(), this.mAccountId, new ArrayList());
    this.mAdapter.setActiveFolderIds(this.activeFolderIds);
    this.mList.setAdapter(this.mAdapter);
    initPopupWindow();
    renderTopBar();
    localQMSearchBar.setOnClickListener(new FolderListFragment.22(this));
  }
  
  private void initPopularizeBannerView()
  {
    if (this.mAccMan.getAccountList().size() > 1) {}
    for (int i = -1;; i = 0)
    {
      this.mPopularizeBanner = new PopularizeBanner(i);
      this.mPopularizeBannerForDrag = new PopularizeBanner(i);
      this.mPopularizeBanner.setOnBannerCancelListener(new FolderListFragment.13(this));
      this.mPopularizeBannerForDrag.setOnBannerCancelListener(new FolderListFragment.14(this));
      return;
    }
  }
  
  private void initPopupWindow()
  {
    this.mPopupWindow = new FolderListFragment.26(this, getActivity(), true);
  }
  
  private void initSyncErrorBar()
  {
    this.mSyncErrorBar = new SyncErrorBar(getActivity());
    this.mSyncErrorBar.setOnBarItemClickListener(new FolderListFragment.15(this));
  }
  
  private void initView()
  {
    initPopularizeBannerView();
    initSyncErrorBar();
    initClearCacheDialog();
    initItemScrollListView();
    initDragSortListView();
  }
  
  private static boolean isMultiAccount()
  {
    return AccountManager.shareInstance().getAccountList().size() > 1;
  }
  
  private boolean isTheFolderClickTip(IListFolder paramIListFolder, QMFolder paramQMFolder)
  {
    return (paramIListFolder != null) && (paramIListFolder.getData() != null) && (paramQMFolder != null) && (((QMFolder)paramIListFolder.getData()).getId() == paramQMFolder.getId());
  }
  
  private boolean isTop(int paramInt1, int paramInt2)
  {
    return paramInt2 == paramInt1 - 1;
  }
  
  private void logPopularize()
  {
    if ((this.mCurFolderList != null) && (this.mCurFolderList.size() > 0) && (!this.isLogPopularize))
    {
      Iterator localIterator = this.mCurFolderList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (QMFolder)((IListFolder)localIterator.next()).getData();
        if ((localObject != null) && (((QMFolder)localObject).getType() == 130))
        {
          localObject = PopularizeManager.sharedInstance().getPopularizeById(((QMFolder)localObject).getId());
          if (localObject != null) {
            if (((Popularize)localObject).getBannerPosition() == 0)
            {
              QMLog.log(4, "FolderListFragment", "DATACOLLECTION_EVENT_TOP_BOX_POPULARIZE_SHOW");
              DataCollector.logEvent("Event_Top_Box_popularize_Show");
              DataCollector.logDetailEvent("DetailEvent_Top_Box_Popularize_Show", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              DataCollector.logDetailEventWithDetailMessage("DetailEvent_Top_Box_Popularize_Show", ((Popularize)localObject).getReportId() + "", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              this.isLogPopularize = true;
            }
            else if (((Popularize)localObject).getBannerPosition() == 1)
            {
              QMLog.log(4, "FolderListFragment", "DATACOLLECTION_EVENT_BOTTOM_BOX_POPULARIZE_SHOW");
              DataCollector.logEvent("Event_Bottom_Box_popularize_Show");
              DataCollector.logDetailEvent("DetailEvent_Bottom_Box_Popularize_Show", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              DataCollector.logDetailEventWithDetailMessage("DetailEvent_Bottom_Box_Popularize_Show", ((Popularize)localObject).getReportId() + "", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              this.isLogPopularize = true;
            }
          }
        }
      }
      DataCollector.submit();
    }
  }
  
  private QMFolder moveFolderToPosition(IListFolder paramIListFolder, int paramInt)
  {
    List localList = this.mAdapter.getData();
    localList.remove(paramIListFolder);
    paramInt += 1;
    QMFolder localQMFolder = (QMFolder)((IListFolder)localList.get(paramInt)).getData();
    localList.add(paramInt, paramIListFolder);
    this.mAdapter.notifyDataSetChanged();
    return localQMFolder;
  }
  
  private void refreshFolderData()
  {
    runOnMainThread(new FolderListFragment.30(this));
    if ((!this.mEditMode) && (!AccountManager.shareInstance().getAccountList().hasMultiAccounts())) {}
  }
  
  private void refreshTopBarLoading(boolean paramBoolean)
  {
    runOnMainThread(new FolderListFragment.42(this, paramBoolean));
  }
  
  private void renderMode()
  {
    ItemScrollListView localItemScrollListView = this.mList;
    if (!this.mEditMode) {}
    for (boolean bool = true;; bool = false)
    {
      localItemScrollListView.setEnablePullToRefresh(bool);
      this.mAdapter.setIsEditing(this.mEditMode);
      return;
    }
  }
  
  private void renderSyncErrorBar()
  {
    SyncErrorBar localSyncErrorBar;
    int j;
    if (this.mSyncErrorBar != null)
    {
      localSyncErrorBar = this.mSyncErrorBar;
      j = this.mAccountId;
      if (!isMultiAccount()) {
        break label64;
      }
    }
    label64:
    for (int i = 2;; i = 1)
    {
      localSyncErrorBar.render(j, i);
      if ((this.mSyncErrorBar.getCode() == 2) && (this.netTimer == null))
      {
        QMLog.log(4, "FolderListFragment", "render network unavailable to start socket timer");
        startCheckNetTimer();
      }
      return;
    }
  }
  
  private void renderTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.mAccount != null)
    {
      if (this.isLoadingAuto) {
        localQMTopBar.setTitle(2131721229);
      }
    }
    else
    {
      if (!isMultiAccount()) {
        break label137;
      }
      if (!this.mEditMode) {
        break label108;
      }
      localQMTopBar.setButtonLeftNormal("新建");
      localQMTopBar.setButtonRightBlue(2131693745);
    }
    for (;;)
    {
      localQMTopBar.setButtonRightOnclickListener(new FolderListFragment.27(this));
      localQMTopBar.setButtonLeftOnclickListener(new FolderListFragment.28(this));
      localQMTopBar.setCenterOnclickListener(new FolderListFragment.29(this));
      return;
      localQMTopBar.setTitle(this.mAccount.getEmail());
      break;
      label108:
      localQMTopBar.setButtonLeftBack();
      localQMTopBar.setButtonRightIcon(2130841089);
      localQMTopBar.getButtonRight().setContentDescription(getString(2131691909));
      continue;
      label137:
      if (this.mEditMode)
      {
        localQMTopBar.setButtonLeftNormal("新建");
        localQMTopBar.setButtonRightBlue(2131693745);
      }
      else
      {
        localQMTopBar.setButtonLeftBack();
        localQMTopBar.setButtonRightIcon(2130841095);
        localQMTopBar.getButtonRight().setContentDescription(getString(2131720813));
      }
    }
  }
  
  private static void resetScrollPosition(ListView paramListView1, ListView paramListView2)
  {
    int n = 0;
    int i = paramListView1.getFirstVisiblePosition();
    View localView = paramListView1.getChildAt(0);
    if (localView == null) {}
    int m;
    for (int k = 0;; k = localView.getTop())
    {
      j = i + (paramListView2.getHeaderViewsCount() - paramListView1.getHeaderViewsCount());
      if (paramListView1.getFirstVisiblePosition() >= paramListView1.getHeaderViewsCount()) {
        break;
      }
      m = 0;
      for (;;)
      {
        i = j;
        if (m >= paramListView1.getHeaderViewsCount()) {
          break;
        }
        i = j;
        if (paramListView1.getChildAt(m) != null) {
          if (paramListView1.getChildAt(m).getHeight() != 0)
          {
            i = j;
            if (paramListView1.getChildAt(m).getVisibility() != 8) {}
          }
          else
          {
            i = j + 1;
          }
        }
        m += 1;
        j = i;
      }
    }
    i = j;
    int j = i;
    if (paramListView2.getFirstVisiblePosition() < paramListView2.getHeaderViewsCount())
    {
      m = 0;
      for (;;)
      {
        j = i;
        if (m >= paramListView2.getHeaderViewsCount()) {
          break;
        }
        j = i;
        if (paramListView2.getChildAt(m) != null) {
          if (paramListView2.getChildAt(m).getHeight() != 0)
          {
            j = i;
            if (paramListView2.getChildAt(m).getVisibility() != 8) {}
          }
          else
          {
            j = i - 1;
          }
        }
        m += 1;
        i = j;
      }
    }
    if (j < 0) {}
    for (i = n;; i = j)
    {
      paramListView2.setSelectionFromTop(i, k);
      return;
    }
  }
  
  private void saveFolderOrder()
  {
    if ((this.mTotalAccountNum == 1) && (this.mCurFolderList != null))
    {
      localObject1 = new ArrayList();
      localObject2 = FolderDataManager.getHomeAppIdList();
      localObject3 = this.mCurFolderList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label167;
        }
        localObject4 = (IListFolder)((Iterator)localObject3).next();
        if (((IListFolder)localObject4).getType() == IListItem.ItemType.ITEM)
        {
          localQMFolder = (QMFolder)((IListFolder)localObject4).getData();
          if (localQMFolder != null)
          {
            if (!QMFolderManager.isAppFolder(localQMFolder))
            {
              localIterator = this.mAllUniversalFolderDatas.iterator();
              if (!localIterator.hasNext()) {
                continue;
              }
              localFolderData = (FolderData)localIterator.next();
              if (localQMFolder.getId() != localFolderData.getFolderId()) {
                break;
              }
              localFolderData.setShouldShow(((IListFolder)localObject4).shouldShow());
              continue;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(localQMFolder.getId()));
          }
        }
      }
      label167:
      FolderDataManager.setSeqByFolderDataListOrder(this.mAllUniversalFolderDatas);
      FolderDataManager.sharedInstance().deleteFolderDataList();
      FolderDataManager.sharedInstance().insertFolderDataList(this.mAllUniversalFolderDatas);
      ((ArrayList)localObject1).add(Integer.valueOf(-20));
      if (!((ArrayList)localObject2).equals(localObject1)) {
        FolderDataManager.setHomeAppIdList((ArrayList)localObject1);
      }
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Integer)((Iterator)localObject2).next()).intValue();
        if ((i < 0) && (i != -20)) {
          ((ArrayList)localObject3).add(Integer.valueOf(i));
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        if ((i < 0) && (i != -20)) {
          ((ArrayList)localObject4).add(Integer.valueOf(i));
        }
      }
      if (!((ArrayList)localObject3).equals(localObject4))
      {
        FolderDataManager.sharedInstance().sendApplicationShowInHome((ArrayList)localObject4);
        DataCollector.logEvent("Event_Appfolder_Moved");
        QMLog.log(4, "FolderListFragment", "change default app seq to send config");
      }
      syncRealFoldersOrder(this.mAccount, this.mAllRealFolders);
    }
    while (this.mTotalAccountNum < 1)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      QMFolder localQMFolder;
      Iterator localIterator;
      FolderData localFolderData;
      int i;
      return;
    }
    syncRealFoldersOrder(this.mAccount, this.mAllRealFolders);
  }
  
  private boolean saveRealFoldersOrderToDB(int paramInt, ArrayList<QMFolder> paramArrayList)
  {
    Object localObject = QMFolderManager.sharedInstance().getAllFoldersByAccountId(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((QMFolder)((Iterator)localObject).next()).getId()));
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList2.add(Integer.valueOf(((QMFolder)paramArrayList.next()).getId()));
    }
    if (!localArrayList2.equals(localArrayList1))
    {
      QMMailManager.sharedInstance().saveFolderOrder(localArrayList2);
      return true;
    }
    return false;
  }
  
  private void scrollToTheFolderWhenInvisible(int paramInt)
  {
    if (!this.mList.isItemVisibleAtPositon(paramInt)) {
      this.mList.setSelection(paramInt);
    }
  }
  
  private void setTopFolder(int paramInt, IListFolder paramIListFolder, QMFolder paramQMFolder)
  {
    int i = findReverseNearestSectionPosition(paramInt);
    if (!isTop(paramInt, i))
    {
      paramIListFolder = moveFolderToPosition(paramIListFolder, i);
      if (this.mAllRealFolders.size() == 0) {
        this.mAllRealFolders = QMFolderManager.sharedInstance().getAllFoldersByAccountId(this.mAccountId);
      }
      QMFolderListDragAdapter.reorderAllRealFolders(this.mAllRealFolders, paramQMFolder, paramIListFolder);
      syncRealFoldersOrder(this.mAccount, this.mAllRealFolders);
    }
    for (;;)
    {
      KvHelper.eventFolderSwipeShowSetTopClick(new double[0]);
      return;
      this.mList.reset();
    }
  }
  
  private void showError()
  {
    if (this.emptyView != null)
    {
      DataCollector.logException(7, 11, "Event_Error", getString(2131693942), true);
      this.emptyView.showTipsReload(2131693942, this.onReloadListener);
      this.mContainBottomLayout.setVisibility(8);
    }
  }
  
  private void showFolderList()
  {
    if (this.mList != null)
    {
      this.emptyView.hide();
      if (!this.mEditMode) {
        refreshFolderData();
      }
      swapEditState(this.mEditMode);
      this.mPopularizeBanner.render(this.mList, false);
      this.mPopularizeBannerForDrag.render(this.mListDrag, false);
      logPopularize();
    }
  }
  
  private void showHomeFolder(QMFolder paramQMFolder)
  {
    if (this.mAdapter.isShowHomeFolderId(paramQMFolder))
    {
      this.activeFolderIds.remove(Integer.valueOf(paramQMFolder.getId()));
      paramQMFolder = FolderDataManager.sharedInstance().getFolderDataByFolderId(paramQMFolder.getId());
      FolderDataManager.sharedInstance().deleteFolderDataById(paramQMFolder);
      KvHelper.eventFolderSwipeNotShowMailBoxClick(new double[0]);
    }
    for (;;)
    {
      this.mAdapter.notifyDataSetChanged();
      return;
      this.activeFolderIds.add(Integer.valueOf(paramQMFolder.getId()));
      QMAccountHelper.addActiveFolderToDB(paramQMFolder, this.mAccounts);
      KvHelper.eventFolderSwipeShowMailBoxClick(new double[0]);
    }
  }
  
  private void showLoading()
  {
    runOnMainThread(new FolderListFragment.33(this));
  }
  
  private void swapEditState(boolean paramBoolean)
  {
    int j = 8;
    Object localObject = getActivity().getCurrentFocus();
    if (localObject != null)
    {
      ((View)localObject).clearFocus();
      this.mEditMode = paramBoolean;
      localObject = this.mListDrag;
      if (!paramBoolean) {
        break label136;
      }
      i = 0;
      label39:
      ((DragSortListView)localObject).setVisibility(i);
      localObject = this.mContainBottomLayout;
      if (!paramBoolean) {
        break label142;
      }
    }
    label136:
    label142:
    for (int i = j;; i = 0)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      renderTopBar();
      return;
      if ((this.mListDrag != null) && (this.mListDrag.getFocusedChild() != null))
      {
        this.mListDrag.clearChildFocus(this.mListDrag.getFocusedChild());
        break;
      }
      if ((this.mContainBottomLayout == null) || (this.mContainBottomLayout.getFocusedChild() == null)) {
        break;
      }
      this.mContainBottomLayout.clearChildFocus(this.mContainBottomLayout.getFocusedChild());
      break;
      i = 8;
      break label39;
    }
  }
  
  private void syncRealFoldersOrder(Account paramAccount, ArrayList<QMFolder> paramArrayList)
  {
    if (saveRealFoldersOrderToDB(paramAccount.getId(), paramArrayList)) {
      QMMailManager.sharedInstance().syncFolderOrder(paramAccount, paramArrayList, null);
    }
  }
  
  private void timGuideToLogin()
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131721070)).setMessage(2131721069).addAction(2131691552, new FolderListFragment.54(this))).addAction(2131721068, new FolderListFragment.53(this))).create();
    localQMUIDialog.setOnDismissListener(new FolderListFragment.55(this));
    localQMUIDialog.show();
  }
  
  private void toggleModeRefreshFolderData()
  {
    runOnMainThread(new FolderListFragment.23(this));
  }
  
  public void cancelEdit()
  {
    if ((this.editingItems != null) && (!this.editingItems.isEmpty()) && (this.mListDrag != null))
    {
      int i = 0;
      if (i < this.mListDrag.getAdapter().getCount())
      {
        Object localObject = (IListFolder)this.mListDrag.getAdapter().getItem(i);
        if ((localObject != null) && (((IListFolder)localObject).getData() != null) && (this.editingItems.containsKey(Integer.valueOf(((QMFolder)((IListFolder)localObject).getData()).getId()))))
        {
          int k = ((QMFolder)((IListFolder)localObject).getData()).getId();
          ((IListFolder)localObject).setShouldShow(((Boolean)this.editingItems.get(Integer.valueOf(k))).booleanValue());
          boolean bool = ((IListFolder)localObject).shouldShow();
          if (k == -19)
          {
            localObject = QMSettingManager.sharedInstance();
            if (!bool) {
              break label193;
            }
            j = 1;
            label156:
            ((QMSettingManager)localObject).setStarAttachDisplay(j);
          }
          if (k == -3)
          {
            localObject = QMSettingManager.sharedInstance();
            if (!bool) {
              break label198;
            }
          }
        }
        label193:
        label198:
        for (int j = 1;; j = 2)
        {
          ((QMSettingManager)localObject).setAddrVipDisplay(j);
          i += 1;
          break;
          j = 2;
          break label156;
        }
      }
    }
  }
  
  public void dismissOutOfSightHasNewHint()
  {
    if (this.outOfSightHasNewPw != null) {
      this.outOfSightHasNewPw.dismiss();
    }
  }
  
  protected void gotoCompose()
  {
    if (SendMailInterAppsManager.getInstance().hasFile()) {
      DataCollector.logEvent("Event_Local_File_Reply_But_Compose");
    }
    this.mBottomView.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.mList.getLayoutParams()).setMargins(0, 0, 0, 0);
    TimReportManager.reportClickEvent(getActivity(), "0X8008905", 0, 0, 0, 0, 0, "", "", "", "");
    startActivity(ComposeMailActivity.createIntentWithAccountFromList(this.mAccount));
  }
  
  public void initDataSource()
  {
    this.mAccMan = AccountManager.shareInstance();
    this.mMailMan = QMMailManager.sharedInstance();
    this.mAccounts = AccountManager.shareInstance().getAccountList();
    QMTaskManager.sharedInstance(1).bindTaskListChangeWatcherList(this.taskListChangeWatcher, true);
    initData();
    bindEvenet(true);
    if (this.autoOpenSearch) {
      startFragment(new SearchListFragment(this.mAccountId));
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initView();
    if ((!isMultiAccount()) && (getActivity().getIntent() != null) && (getActivity().getIntent().getStringExtra("fromController") != null) && (getActivity().getIntent().getStringExtra("fromController").equals("otherapp"))) {
      this.mBottomView.postDelayed(new FolderListFragment.34(this, this), 20L);
    }
    if ((this.mTotalAccountNum == 1) && (!SharedPreferenceUtil.getFolderTopHaveTip())) {
      Threads.runOnMainThread(new FolderListFragment.35(this), 600L);
    }
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.mContainBottomLayout = ThirdPartyCallDialogHelpler.initLayout(this.baseView, true, this.mContainBottomLayout);
    this.mList = ThirdPartyCallDialogHelpler.initListView(this.mContainBottomLayout, this.mList);
    this.mBottomView = ThirdPartyCallDialogHelpler.initBottomview(this.mContainBottomLayout, this.mBottomView);
    this.mList.setPadding(0, 0, 0, getResources().getDimensionPixelSize(2131297349));
    this.mList.setClipToPadding(false);
    this.emptyView = this.baseView.addListEmptyView();
    this.mListDrag = new DragSortListView(QMApplicationContext.sharedInstance());
    this.mListDrag.initStyle();
    this.baseView.addView(this.mListDrag, 0);
    return this.baseView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    Object localObject;
    if (paramInt1 == 0)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = (QMFolderManager.FolderOperationType)paramIntent.getSerializableExtra("folderopertype");
        paramInt1 = paramIntent.getIntExtra("folderId", 0);
        if ((localObject != null) && ((localObject == QMFolderManager.FolderOperationType.ADD_FOLDER) || (localObject == QMFolderManager.FolderOperationType.ADD_TAG) || (localObject == QMFolderManager.FolderOperationType.REMOVE_TAG) || (localObject == QMFolderManager.FolderOperationType.REMOVE_FOLDER)) && (paramInt1 != 0)) {
          this.mNewFolderId = paramInt1;
        }
      }
      refreshData();
      refreshFolderData();
      if (this.mEditMode) {
        enterEditMode();
      }
    }
    label237:
    do
    {
      boolean bool2;
      do
      {
        do
        {
          return;
          enterNormalMode();
          return;
          if (paramInt1 != 9) {
            break;
          }
        } while ((paramIntent == null) || (this.mAdapter == null));
        bool2 = paramIntent.getBooleanExtra("arg_ftn_unread_isupdate", false);
        localObject = (FtnExpireInfo)paramIntent.getSerializableExtra("arg_ftn_unread_info");
        paramIntent = paramIntent.getStringExtra("from");
      } while (localObject == null);
      FtnManager localFtnManager = FtnManager.sharedInstance();
      if (localFtnManager != null) {
        if ((StringExtention.isNullOrEmpty(paramIntent)) || (!paramIntent.equalsIgnoreCase("ftn"))) {
          break label237;
        }
      }
      for (;;)
      {
        localFtnManager.setIsFromFtn(bool1);
        localFtnManager.setFtnExpUnreadUpdate(bool2);
        localFtnManager.setFtnExpireInfo((FtnExpireInfo)localObject);
        if (localFtnManager.isFtnExpUnreadNeedShow()) {
          FolderDataManager.sharedInstance().setInnerFtnUnreadCount(0);
        }
        runOnMainThread(new FolderListFragment.39(this));
        return;
        bool1 = false;
      }
    } while ((paramInt1 != 1) || (paramInt2 != -1));
    refreshFolderData();
  }
  
  public void onBackPressed()
  {
    if (this.mEditMode)
    {
      QMLog.log(4, "FolderListFragment", "onBackPressed enterNormalMode");
      cancelEdit();
      enterNormalMode();
      return;
    }
    if ((AdvertiseAnimUtil.advertiseViewForeground) && (!AccountManager.shareInstance().getAccountList().hasMultiAccounts()))
    {
      QMLog.log(4, "FolderListFragment", "onBackPressed advertiseViewForeground");
      AdvertiseAnimUtil.hideAdvertiseView(getActivity(), this.baseView, this.baseView.getAdvertiseView(), this.mList);
      return;
    }
    QMLog.log(4, "FolderListFragment", "onBackPressed");
    Threads.runInBackground(new FolderListFragment.48(this));
    if (AccountManager.shareInstance().getAccountList().size() == 1) {
      QMWatcherCenter.triggerAppGotoBackground();
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    if (this.mList != null) {
      this.mList.onRefreshCompleteWithoutAnimation();
    }
    this.isLogPopularize = false;
    ThirdPartyCallDialogHelpler.hideTCPDialogWhenActivityPaused();
    dismissOutOfSightHasNewHint();
    if (this.netTimer != null)
    {
      QMLog.log(4, "FolderListFragment", "onPause to stop socket timer");
      this.netTimer.cancel();
      this.netTimer = null;
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.listWatcher, paramBoolean);
    Watchers.bind(this.syncWatcher, paramBoolean);
    Watchers.bind(this.relativeAccWatcher, paramBoolean);
    Watchers.bind(this.folderUnreadCountWatcher, paramBoolean);
    Watchers.bind(this.mCheckAttachFolderListWatcher, paramBoolean);
    Watchers.bind(this.mBottleOpenNotifyWatcher, paramBoolean);
    Watchers.bind(this.unreadWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.renderSyncErrorBarWatcher, paramBoolean);
    Object localObject = BottleManager.getInstance();
    if (localObject != null) {
      ((BottleManager)localObject).getBottleListController().bindUpdateUnreadStatusWatcher(this.mUnreadWatch, paramBoolean);
    }
    localObject = FtnManager.sharedInstance();
    if (localObject != null)
    {
      QMLog.log(3, "FolderListFragment", "Ftn-expunread folder bind-watcher tobind: " + paramBoolean);
      ((FtnManager)localObject).bindFtnQueryExpireUnreadListener(this.ftnQueryExpireUnreadWatcher, paramBoolean);
    }
  }
  
  public void onButtonBackClick()
  {
    Threads.runInBackground(new FolderListFragment.49(this));
    super.onButtonBackClick();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    if (i == 2) {
      this.mList.setAdvertiseMode(false);
    }
    while (i != 1) {
      return;
    }
    this.mList.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (this.mTotalAccountNum > 1) && (this.mList.isFold());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing()))
      {
        this.mPopupWindow.dismiss();
        return false;
      }
      showPopWindow(getTopBar().getButtonRight());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Object onLastFragmentFinish()
  {
    Threads.runInBackground(new FolderListFragment.31(this));
    if (isMultiAccount()) {
      return new AccountListFragment();
    }
    return super.onLastFragmentFinish();
  }
  
  public void onRelease()
  {
    QMTaskManager.sharedInstance(1).bindTaskListChangeWatcherList(this.taskListChangeWatcher, false);
    bindEvenet(false);
  }
  
  public int refreshData()
  {
    this.mFolders = QMFolderManager.sharedInstance().getFoldersByAccountId(this.mAccountId);
    if ((this.mFolders == null) || ((this.mFolders.size() == 0) && (this.initSyncCount < 5)))
    {
      QMLog.log(5, "FolderListFragment", "no folders and reload, initSyncCount = " + this.initSyncCount);
      Threads.runInBackground(new FolderListFragment.38(this));
      return 0;
    }
    this.initSyncCount = 0;
    return 0;
  }
  
  public void render(int paramInt)
  {
    runOnMainThread(new FolderListFragment.40(this), 200L);
    this.mList.onRefreshComplete();
    Object localObject;
    if ((this.mFolders == null) || (this.mFolders.size() == 0))
    {
      showLoading();
      refreshTopBarLoading(QMMailManager.sharedInstance().isAccountUpdating(this.mAccountId));
      QMLog.log(4, "FolderListFragment", "TopBar debug render account update: " + QMMailManager.sharedInstance().isAccountUpdating(this.mAccountId));
      localObject = FtnManager.sharedInstance();
      if ((!isMultiAccount()) && (!this.mIsFtnUnreadSync) && (localObject != null))
      {
        QMLog.log(4, "FolderListFragment", "Ftn unread folder render try to read exp unread async");
        ((FtnManager)localObject).asyncFtnExpireTime();
        this.mIsFtnUnreadSync = true;
      }
      if ((AccountManager.shareInstance().getAccountList().size() != 1) || (!QMSettingManager.sharedInstance().getUpgradeFromOldApp()) || (QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount()) || (!QMPushConfigUtil.getTopbarRightButtonHasNewUnClick())) {
        break label239;
      }
      getTopBar().showRedDot(true);
    }
    for (;;)
    {
      ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
      ThirdPartyCallDialogHelpler.showTCPDialogWhenActivityResumed();
      localObject = getResources().getConfiguration();
      if ((AccountManager.shareInstance().getAccountList().hasMultiAccounts()) || (((Configuration)localObject).orientation != 1)) {
        break label340;
      }
      this.mList.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
      return;
      showFolderList();
      break;
      label239:
      if ((AccountManager.shareInstance().getAccountList().size() == 1) && (QMPushConfigUtil.getTopbarRightButtonHasNewUnClick()) && (((QMPushConfigUtil.getTopbarPopWindowHasNewUnClick()) && (QMPushConfigUtil.showUpgradeVersion()) && (!QMSettingManager.sharedInstance().getNewVersionRead())) || ((QMPushConfigUtil.getBetaPopWindowItem()) && (QMPushConfigUtil.showBetaVersion()))))
      {
        getTopBar().showRedDot(true);
        if (QMPushConfigUtil.showUpgradeVersion()) {
          DataCollector.logEvent("Event_Topbar_Red_Dot_Show");
        } else if (QMPushConfigUtil.showBetaVersion()) {
          DataCollector.logEvent("Event_Beta_Topbar_Red_Dot_Show");
        }
      }
      else
      {
        getTopBar().showRedDot(false);
      }
    }
    label340:
    this.mList.setAdvertiseMode(false);
  }
  
  public void showOutOfSightHasNewHint()
  {
    QMLog.log(4, "FolderListFragment", "showOutOfSightHasNewHint");
    if (this.outofSightHasNewPwRunnable == null) {
      this.outofSightHasNewPwRunnable = new FolderListFragment.50(this);
    }
    this.mList.postDelayed(this.outofSightHasNewPwRunnable, 300L);
  }
  
  public void showPopWindow(View paramView)
  {
    if (this.mPopupWindow.isShowing()) {
      this.mPopupWindow.dismiss();
    }
    Object localObject = Lists.newArrayList(new String[] { getString(2131691909) });
    ArrayList localArrayList = Lists.newArrayList(new Integer[] { Integer.valueOf(2130840816) });
    if ((AccountManager.shareInstance().getAccountList().getDefaultNoteAccount() != null) && (AccountManager.shareInstance().getAccountList().getDefaultFtnAccount() != null) && (QMSettingManager.sharedInstance().getNoteDisplay()))
    {
      ((List)localObject).add(getString(2131691913));
      localArrayList.add(Integer.valueOf(2130840813));
    }
    ((List)localObject).add(getString(2131720003));
    localArrayList.add(Integer.valueOf(2130840837));
    localObject = new PopupAdapterDividerLine(getActivity(), 2131559772, 2131373496, (List)localObject, localArrayList);
    this.mPopupWindow.setAdapter((ListAdapter)localObject);
    this.mPopupWindow.setAnchor(paramView);
    this.mPopupWindow.showDown();
  }
  
  public void startCheckNetTimer()
  {
    this.netTimer = new Timer();
    FolderListFragment.52 local52 = new FolderListFragment.52(this);
    this.netTimer.schedule(local52, 0L, 30000L);
  }
  
  final class FolderListItemListener
    implements AdapterView.OnItemClickListener
  {
    private FolderListItemListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Object localObject1 = (IListFolder)FolderListFragment.this.mList.getAdapter().getItem(paramInt);
      if (localObject1 == null) {
        QMLog.log(6, "FolderListFragment", "onItemClick null folder ");
      }
      int i;
      int j;
      Object localObject3;
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (((IListFolder)localObject1).getData() == null)
        {
          QMLog.log(6, "FolderListFragment", "onItemClick null pos: " + paramInt);
        }
        else
        {
          i = ((QMFolder)((IListFolder)localObject1).getData()).getId();
          j = ((QMFolder)((IListFolder)localObject1).getData()).getType();
          QMLog.log(4, "FolderListFragment", "folder list on item click folderId:" + i);
          if (i == -10)
          {
            localObject1 = new SendMailListFragment();
            FolderListFragment.this.startFragment((BaseFragment)localObject1);
          }
          label777:
          do
          {
            for (;;)
            {
              paramView.setSelected(true);
              break;
              if (i == -18)
              {
                QMCalendarManager.logEvent("Event_Click_Calendar");
                if (QMCalendarManager.getInstance().isShowSystemCalendar())
                {
                  RxPermissions.getInstance(FolderListFragment.this.getActivity()).request(new String[] { "android.permission.WRITE_CALENDAR" }).subscribe(new FolderListFragment.FolderListItemListener.1(this));
                }
                else
                {
                  localObject1 = CalendarFragmentActivity.createIntent();
                  FolderListFragment.this.startActivity((Intent)localObject1);
                }
              }
              else
              {
                if (-4 == i)
                {
                  if (FolderLockDialog.isFolderLock(i))
                  {
                    if (FolderListFragment.this.getActivity() == null) {
                      break;
                    }
                    FolderListFragment.access$102(FolderListFragment.this, new FolderLockDialog(FolderListFragment.this.getActivity(), i, FolderListFragment.this.mAccountId, FolderListFragment.this.folderLockWatcher));
                    FolderListFragment.access$402(FolderListFragment.this, false);
                    FolderListFragment.this.lockDialog.createDialog(1);
                    FolderListFragment.this.lockDialog.showDialog();
                    break;
                  }
                  DataCollector.logEvent("Event_Click_Note_Box");
                  localObject1 = NoteListActivity.createIntent();
                  FolderListFragment.this.startActivity((Intent)localObject1);
                  continue;
                }
                if (-5 == i)
                {
                  DataCollector.logEvent("Event_Click_Ftn_Box");
                  localObject1 = FtnListActivity.createIntent();
                  FolderListFragment.this.startActivityForResult((Intent)localObject1, 9);
                }
                else if (i == -3)
                {
                  DataCollector.logEvent("Event_Click_Vip_Box");
                  if (!QMMailManager.sharedInstance().hasVip())
                  {
                    localObject1 = new VIPContactsIndexFragment(FolderListFragment.this.mAccountId, false);
                    FolderListFragment.this.startFragment((BaseFragment)localObject1);
                  }
                  else
                  {
                    try
                    {
                      localObject1 = new MailListFragment(FolderListFragment.this.mAccountId, ((QMFolder)((IListFolder)localObject1).getData()).getId(), ((IListFolder)localObject1).getName());
                      FolderListFragment.this.startFragment((BaseFragment)localObject1);
                    }
                    catch (MailListFragment.NullFolderException localNullFolderException1)
                    {
                      localNullFolderException1.printStackTrace();
                    }
                  }
                }
                else
                {
                  Object localObject2;
                  if (i == -16)
                  {
                    localObject2 = BottleFragmentActivity.createIntent();
                    FolderListFragment.this.startActivity((Intent)localObject2);
                  }
                  else if (i == -19)
                  {
                    DataCollector.logEvent("Event_Click_Attach_Box");
                    localObject2 = new AttachFolderListFragment(FolderListFragment.this.mAccountId, i);
                    FolderListFragment.this.startFragment((BaseFragment)localObject2);
                  }
                  else if (j == 130)
                  {
                    localObject2 = PopularizeManager.sharedInstance().getPopularizeById(i);
                    if ((localObject2 != null) && (((Popularize)localObject2).getOpenUrl() != null)) {
                      PopularizeUIHelper.handleActionAndGotoLink(FolderListFragment.this.getActivity(), (Popularize)localObject2);
                    } else {
                      QMLog.log(6, "FolderListFragment", "folderList getPopularizeItemData null");
                    }
                  }
                  else if (j == 140)
                  {
                    PopularizeUIHelper.handleMyAppAction();
                    localObject2 = new AppFolderListFragment();
                    FolderListFragment.this.startFragment((BaseFragment)localObject2);
                  }
                  else if (i == -22)
                  {
                    localObject2 = ContactsFragmentActivity.createContactsListIntent();
                    FolderListFragment.this.startActivity((Intent)localObject2);
                  }
                  else if (i == -2)
                  {
                    try
                    {
                      localObject2 = new MailListFragment(FolderListFragment.this.mAccountId, FolderListItemHelper.getRealStarredFolderId(FolderListFragment.this.mFolders), ((IListFolder)localObject2).getName());
                      FolderListFragment.this.startFragment((BaseFragment)localObject2);
                    }
                    catch (MailListFragment.NullFolderException localNullFolderException2)
                    {
                      localNullFolderException2.printStackTrace();
                    }
                  }
                  else
                  {
                    if (i != -23) {
                      break label777;
                    }
                    localObject3 = CardFragmentActivity.createIntentToGallery(QMCardManager.shareInstance().getJumpCardDefaulType(), false);
                    FolderListFragment.this.startActivity((Intent)localObject3);
                    DataCollector.logEvent("Event_Card_Click_Card_Item");
                  }
                }
              }
            }
            if (!FolderLockDialog.isFolderLock(i)) {
              break label859;
            }
          } while (FolderListFragment.this.isRemoving());
          FolderListFragment.access$102(FolderListFragment.this, new FolderLockDialog(FolderListFragment.this.getActivity(), i, FolderListFragment.this.mAccountId, FolderListFragment.this.folderLockWatcher));
          FolderListFragment.this.lockDialog.createDialog(1);
          FolderListFragment.this.lockDialog.showDialog();
        }
      }
      label859:
      if (((QMFolder)((IListFolder)localObject3).getData()).getType() == 1) {
        DataCollector.logEvent("Event_Click_Inbox");
      }
      for (;;)
      {
        try
        {
          if (paramInt > FolderListFragment.this.initialLastVisiblePosition) {
            MailListBarHelper.isNeedFolderTopTip((QMFolder)((IListFolder)localObject3).getData(), FolderListFragment.this.mAccountId, FolderListFragment.this.mTotalAccountNum);
          }
          MailListBarHelper.isNeedFolderShowHomeTip((QMFolder)((IListFolder)localObject3).getData(), FolderListFragment.this.mAccountId, FolderListFragment.this.mTotalAccountNum, FolderListFragment.this.mAdapter.isShowHomeFolderId((QMFolder)((IListFolder)localObject3).getData()));
          i = FolderListFragment.this.mAccountId;
          j = ((QMFolder)((IListFolder)localObject3).getData()).getId();
          String str = ((IListFolder)localObject3).getName();
          if (!FolderListFragment.access$900()) {
            continue;
          }
          localObject3 = "from_inner_folder_list";
          localObject3 = new MailListFragment(i, j, str, (String)localObject3);
          FolderListFragment.this.startFragment((BaseFragment)localObject3);
        }
        catch (MailListFragment.NullFolderException localNullFolderException3)
        {
          localNullFolderException3.printStackTrace();
          continue;
        }
        DataCollector.logPerformanceBegin("Performance_Click_Maillist", FolderListFragment.this.mAccountId, "Performance_Click_Maillist" + FolderListFragment.this.mAccountId);
        break;
        localObject3 = "from_out_folder_list";
      }
    }
  }
  
  class FolderOnRightViewClickListener
    implements ItemScrollListView.OnRightViewClickListener
  {
    private FolderOnRightViewClickListener() {}
    
    public void onRightViewClick(View paramView, int paramInt)
    {
      if ((paramView != null) && (paramView.getId() == 2131377336)) {
        FolderListFragment.this.handleRightViewClickRead(paramInt);
      }
      do
      {
        return;
        if ((paramView != null) && (paramView.getId() == 2131377335))
        {
          FolderListFragment.this.handleRightViewClickDeleteOrHide(paramInt);
          return;
        }
      } while ((paramView == null) || (paramView.getId() != 2131377337));
      FolderListFragment.this.handleRightViewClickTop(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment
 * JD-Core Version:    0.7.0.1
 */