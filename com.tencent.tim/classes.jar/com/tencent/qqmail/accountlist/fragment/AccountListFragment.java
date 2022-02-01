package com.tencent.qqmail.accountlist.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.mobeta.android.dslv.DragSortListView;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.AccountSectionController;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter.ViewHolder;
import com.tencent.qqmail.accountlist.adapter.AccountListDragAdapter;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.activity.setting.SettingCacheClearActivity;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.FolderHasNewHelper;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
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
import com.tencent.qqmail.model.mail.watcher.RenderSyncErrorBarWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.search.fragment.SearchListFragment;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.PopupAdapterDividerLine;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.SyncErrorBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;

public class AccountListFragment
  extends MailFragment
{
  private static final int ADD_APP_FOLDER_REQUEST_CODE = 2;
  private static final int ADD_FOLDER_REQUEST_CODE = 1;
  private static final long ANIMATION_DURATION = 1000L;
  public static final String CONTROLLER_ACCOUNT_LIST = "accountList";
  public static final String FROM_CONTROLLER = "fromController";
  public static final String TAG = "AccountListFragment";
  private boolean autoOpenSearch = false;
  private SyncPhotoWatcher avatarWatcher = new AccountListFragment.33(this);
  private QMBaseView baseView;
  private final MailDeleteWatcher deleteWatcher = new AccountListFragment.3(this);
  private HashMap<Integer, Boolean> editingItems = new HashMap();
  private QMFolder folderForClickShowHomeTip = null;
  private FolderHasNewHelper folderHasNewHelper = FolderHasNewHelper.getInstance();
  private IObserver folderShowHomeObserver = new IObserver(new AccountListFragment.7(this));
  private FolderUnreadCountWatcher folderUnreadCountWatcher = new FolderUnreadCountWatcherImpl(null);
  private FtnQueryExpireUnreadWatcher ftnQueryExpireUnreadWatcher = new AccountListFragment.5(this);
  private boolean isLogPopularize;
  private LoadListWatcher loadMailListWatcher = new AccountListFragment.31(this);
  private FolderLockDialog lockDialog;
  private AccountListDragAdapter mAccountDragAdapter;
  private DragSortListView mAccountListDrag;
  private ItemScrollListView mAccountListPull;
  private AccountManager mAccountManager = null;
  private AccountBaseAdapter mAccountPullAdapter;
  private final BottleOpenNotifyWatcher mBottleOpenNotifyWatcher = new AccountListFragment.10(this);
  private FrameLayout mBottomView;
  private RelativeLayout mContainBottomLayout;
  private int mCurPos;
  private List<AccountListUI> mDragData;
  private AccountSectionController mDragListController;
  private boolean mEditMode = false;
  private int mEditShowCounter = 0;
  private final HashMap<String, Boolean> mInboxFolderMap = new HashMap();
  private boolean mIsFtnUnreadSync = false;
  public boolean mIsGoingToComposeNote = false;
  private LoadAttachFolderListWatcher mLoadAttachFolderListWatcher = new AccountListFragment.6(this);
  private QMListPopupWindow mPopWindow;
  private List<AccountListUI> mPullData;
  protected QMUnlockFolderPwdWatcher mUnlockFolderPwd = new AccountListFragment.34(this);
  private final BottleListController.UpdateUnreadStatusWatcher mUnreadWatch = new AccountListFragment.9(this);
  private MailOperate mailOperate = new MailOperate();
  private boolean needExpandItemForClickFolderShowHomeTip = false;
  private Timer netTimer;
  private PopupWindow outOfSightHasNewPw;
  private Runnable outofSightHasNewPwRunnable;
  private PopularizeBanner popularizeBanner;
  private PopularizeBanner popularizeBannerForDrag;
  private RenderSyncErrorBarWatcher renderSyncErrorBarWatcher = new AccountListFragment.35(this);
  private Runnable renderTask = new AccountListFragment.11(this);
  private JSONArray sceneArray;
  private QMSearchBar searchBar;
  private SyncErrorBar syncErrorBar;
  private final SyncPhotoWatcher syncPhotoWatcher = new AccountListFragment.4(this);
  private SyncWatcher syncWatcher = new AccountListFragment.32(this);
  private QMTaskListChangeWatcher taskListChangeWatcher = new AccountListFragment.1(this);
  private MailUnReadWatcher unreadWatcher = new AccountListFragment.2(this);
  
  public AccountListFragment()
  {
    super(false);
  }
  
  public AccountListFragment(boolean paramBoolean)
  {
    super(false);
    this.autoOpenSearch = paramBoolean;
  }
  
  private void autoExpandItemForClickFolderShowHomeTip()
  {
    List localList = this.mAccountPullAdapter.getData();
    int i = 0;
    for (;;)
    {
      if (i < localList.size())
      {
        if (isTheFolderClickTip(((AccountListUI)localList.get(i)).mFolder))
        {
          scrollToTheFolderWhenInvisible(i);
          Threads.runOnMainThread(new AccountListFragment.12(this, i), 600L);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void bindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("folder_show_home_tip_click", this.folderShowHomeObserver);
      return;
    }
    QMNotification.unregistNotification("folder_show_home_tip_click", this.folderShowHomeObserver);
  }
  
  private void displayToggleAnimation(boolean paramBoolean, ListView paramListView)
  {
    Object localObject = new AccountListFragment.36(this);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setAnimationListener(new AccountListFragment.37(this));
    int j = paramListView.getFirstVisiblePosition();
    int k = paramListView.getLastVisiblePosition();
    int i = 0;
    if (i < k - j + 1)
    {
      ViewGroup localViewGroup = (ViewGroup)paramListView.getChildAt(i);
      localObject = null;
      if (localViewGroup != null) {
        localObject = localViewGroup.getChildAt(0);
      }
      if ((localViewGroup != null) && (localObject != null) && ((((View)localObject).getTag() instanceof AccountBaseAdapter.ViewHolder)))
      {
        localObject = (AccountBaseAdapter.ViewHolder)((View)localObject).getTag();
        if ((((AccountBaseAdapter.ViewHolder)localObject).checkbox != null) && (((AccountBaseAdapter.ViewHolder)localObject).data.mType != AccountListUI.ITEMTYPE.BTN))
        {
          if (!paramBoolean) {
            break label174;
          }
          ((AccountBaseAdapter.ViewHolder)localObject).checkbox.setVisibility(0);
          ((AccountBaseAdapter.ViewHolder)localObject).handler.setVisibility(0);
          ((AccountBaseAdapter.ViewHolder)localObject).arrow.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label174:
        ((AccountBaseAdapter.ViewHolder)localObject).checkbox.setVisibility(8);
        ((AccountBaseAdapter.ViewHolder)localObject).handler.setVisibility(8);
        ((AccountBaseAdapter.ViewHolder)localObject).arrow.setVisibility(0);
      }
    }
  }
  
  private void gotoCompose()
  {
    if (SendMailInterAppsManager.getInstance().hasFile()) {
      DataCollector.logEvent("Event_Local_File_Reply_But_Compose");
    }
    if (this.mBottomView.isShown())
    {
      this.mBottomView.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.mAccountListPull.getLayoutParams()).setMargins(0, 0, 0, 0);
    }
    TimReportManager.reportClickEvent(getActivity(), "0X8008905", 0, 0, 0, 0, 0, "", "", "", "");
    AccountList localAccountList = this.mAccountManager.getAccountList();
    Account localAccount;
    if ((localAccountList != null) && (localAccountList.size() > 0))
    {
      localAccount = localAccountList.getDefaultMailAccount();
      if (localAccount == null) {
        break label115;
      }
    }
    for (;;)
    {
      startActivity(ComposeMailActivity.createIntentWithAccountFromList(localAccount));
      return;
      label115:
      localAccount = localAccountList.get(0);
    }
  }
  
  private void gotoFolderList(int paramInt)
  {
    startFragment(new FolderListFragment(paramInt));
  }
  
  private void gotoMailList(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mPullData.iterator();
    AccountListUI localAccountListUI;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localAccountListUI = (AccountListUI)((Iterator)localObject1).next();
    } while ((localAccountListUI.mFolder == null) || (localAccountListUI.mFolder.getType() != 1) || (localAccountListUI.mFolder.getAccountId() != paramInt2) || (localAccountListUI.mFolder.getId() != paramInt1));
    Object localObject2;
    for (localObject1 = localAccountListUI.mData.getName();; localObject2 = null) {
      try
      {
        startFragment(new MailListFragment(paramInt2, paramInt1, (String)localObject1, "from_account_list"));
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
  
  private void gotoSetting()
  {
    startActivity(SettingActivity.createIntent("from_account_list"));
  }
  
  private void initClearCacheDialog()
  {
    SettingCacheClearActivity.showRemindClearCacheDialog(getActivity(), this.baseView, new AccountListFragment.39(this));
  }
  
  private List<AccountListUI> initDragData()
  {
    Object localObject = new ArrayList();
    AccountList localAccountList = this.mAccountManager.getAccountList();
    if (localAccountList.size() > 0) {
      localObject = QMAccountHelper.returnFoldersAndAccounts(localAccountList, false);
    }
    return localObject;
  }
  
  private void initEvent()
  {
    this.mAccountListPull.setOnItemClickListener(new AccountListFragment.26(this));
    this.mAccountListPull.setOnItemLongClickListener(new AccountListFragment.27(this));
    this.mAccountListPull.setDataCollectCallback(new AccountListFragment.28(this));
    this.mAccountListPull.setOnRightViewClickListener(new AccountListFragment.29(this));
    this.mAccountListDrag.setOnItemClickListener(new AccountListFragment.30(this));
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(0);
    this.popularizeBanner.setOnBannerCancelListener(new AccountListFragment.14(this));
    this.popularizeBannerForDrag = new PopularizeBanner(0);
    this.popularizeBannerForDrag.setOnBannerCancelListener(new AccountListFragment.15(this));
  }
  
  private void initSearchBar()
  {
    this.searchBar.setStateNormal();
    this.searchBar.setBtnRight();
    this.searchBar.getBtnRight().setText(2131693000);
    this.searchBar.getBtnRight().setVisibility(8);
    this.searchBar.getBtnRight().setOnClickListener(new AccountListFragment.18(this));
    this.searchBar.searchInitWrap.setOnClickListener(new AccountListFragment.19(this));
  }
  
  private void initTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (localQMTopBar.getButtonLeft() != null) {
      localQMTopBar.getButtonLeft().setVisibility(8);
    }
    localQMTopBar.setTitle(getResources().getString(2131693036));
    localQMTopBar.setCenterOnclickListener(new AccountListFragment.22(this));
    refreshTopbar();
  }
  
  private void initView()
  {
    initPopularizeBannerView();
    initSyncErrorBar();
    this.popularizeBanner.render(this.mAccountListPull, false);
    this.popularizeBannerForDrag.render(this.mAccountListDrag, false);
    QMSearchBar localQMSearchBar = new QMSearchBar(getActivity());
    localQMSearchBar.setStateNormal();
    localQMSearchBar.setBtnRight();
    localQMSearchBar.getBtnRight().setText(2131693000);
    localQMSearchBar.setSearchbarEnable(false);
    localQMSearchBar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    this.mAccountListDrag.addHeaderView(localQMSearchBar);
    localQMSearchBar.getBtnRight().setOnClickListener(new AccountListFragment.16(this));
    localQMSearchBar.getBtnRight().setVisibility(8);
    this.mAccountDragAdapter = new AccountListDragAdapter(getActivity(), Collections.EMPTY_LIST);
    this.mAccountListDrag.setDragEnabled(false);
    this.mAccountListDrag.setAdapter(this.mAccountDragAdapter);
    this.mDragListController = new AccountSectionController(this.mAccountListDrag, this.mAccountDragAdapter);
    this.mAccountListDrag.setFloatViewManager(this.mDragListController);
    this.mAccountListDrag.setOnTouchListener(this.mDragListController);
    this.searchBar = new QMSearchBar(getActivity());
    initSearchBar();
    this.mAccountListPull.addHeaderView(this.searchBar);
    this.mAccountListPull.addHeaderView(this.syncErrorBar);
    this.mAccountListPull.setOnRefreshListener(new AccountListFragment.17(this));
    this.mAccountPullAdapter = new AccountBaseAdapter(getActivity(), Collections.EMPTY_LIST);
    this.mAccountListPull.setAdapter(this.mAccountPullAdapter);
  }
  
  private boolean isTheFolderClickTip(QMFolder paramQMFolder)
  {
    return (paramQMFolder != null) && (this.folderForClickShowHomeTip != null) && (paramQMFolder.getId() == this.folderForClickShowHomeTip.getId());
  }
  
  private void launchAccountChooser()
  {
    QMAccountHelper.saveProcessingFolderToConfig(this.mDragData);
    startActivityForResult(AddFolderAccountListActivity.createIntent(), 1);
  }
  
  private void logEvent()
  {
    int i = 0;
    if (i < this.mDragData.size())
    {
      AccountListUI localAccountListUI = (AccountListUI)this.mDragData.get(i);
      if ((localAccountListUI.mData != null) && (localAccountListUI.mFolder != null)) {
        switch (localAccountListUI.mFolder.getId())
        {
        case -18: 
        case -17: 
        case -16: 
        case -15: 
        case -10: 
        case -8: 
        case -7: 
        case -6: 
        default: 
          if (!localAccountListUI.mData.isShouldShow()) {
            DataCollector.logEvent("Event_Hide_User_Folder");
          }
          break;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!localAccountListUI.mData.isShouldShow())
        {
          DataCollector.logEvent("Event_Hide_AllInbox");
        }
        else
        {
          DataCollector.logEvent("Event_Show_AllInbox");
          continue;
          if (!localAccountListUI.mData.isShouldShow())
          {
            DataCollector.logEvent("Event_Hide_Vip_Contact");
          }
          else
          {
            DataCollector.logEvent("Event_Show_Vip_Contact");
            continue;
            if (!localAccountListUI.mData.isShouldShow())
            {
              DataCollector.logEvent("Event_Hide_AllStars");
            }
            else
            {
              DataCollector.logEvent("Event_Show_AllStars");
              continue;
              if (!localAccountListUI.mData.isShouldShow())
              {
                DataCollector.logEvent("Event_Hide_AllUnread");
              }
              else
              {
                DataCollector.logEvent("Event_Show_AllUnread");
                continue;
                if (!localAccountListUI.mData.isShouldShow())
                {
                  DataCollector.logEvent("Event_Hide_AllSelf");
                }
                else
                {
                  DataCollector.logEvent("Event_Show_AllSelf");
                  continue;
                  if (!localAccountListUI.mData.isShouldShow())
                  {
                    DataCollector.logEvent("Event_Hide_AllUnread");
                  }
                  else
                  {
                    DataCollector.logEvent("Event_Show_AllUnread");
                    continue;
                    if (!localAccountListUI.mData.isShouldShow())
                    {
                      DataCollector.logEvent("Event_Hide_AllDraft");
                    }
                    else
                    {
                      DataCollector.logEvent("Event_Show_AllDraft");
                      continue;
                      if (!localAccountListUI.mData.isShouldShow())
                      {
                        DataCollector.logEvent("Event_Hide_AllSent");
                      }
                      else
                      {
                        DataCollector.logEvent("Event_Show_AllSent");
                        continue;
                        if (!localAccountListUI.mData.isShouldShow())
                        {
                          DataCollector.logEvent("Event_Hide_AllTrash");
                        }
                        else
                        {
                          DataCollector.logEvent("Event_Show_AllTrash");
                          continue;
                          if (!localAccountListUI.mData.isShouldShow())
                          {
                            DataCollector.logEvent("Event_Hide_Note");
                          }
                          else
                          {
                            DataCollector.logEvent("Event_Show_Note");
                            continue;
                            if (!localAccountListUI.mData.isShouldShow())
                            {
                              DataCollector.logEvent("Event_Hide_Ftn");
                            }
                            else
                            {
                              DataCollector.logEvent("Event_Show_Ftn");
                              continue;
                              DataCollector.logEvent("Event_Show_User_Folder");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void logPopularize()
  {
    if ((this.mPullData != null) && (this.mPullData.size() > 0) && (!this.isLogPopularize))
    {
      Iterator localIterator = this.mPullData.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((AccountListUI)localIterator.next()).mFolder;
        if ((localObject != null) && (((QMFolder)localObject).getType() == 130))
        {
          localObject = PopularizeManager.sharedInstance().getPopularizeById(((QMFolder)localObject).getId());
          if (localObject != null) {
            if (((Popularize)localObject).getBannerPosition() == 0)
            {
              QMLog.log(4, "AccountListFragment", "DATACOLLECTION_EVENT_TOP_BOX_POPULARIZE_SHOW");
              DataCollector.logEvent("Event_Top_Box_popularize_Show");
              DataCollector.logDetailEvent("DetailEvent_Top_Box_Popularize_Show", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              DataCollector.logDetailEventWithDetailMessage("DetailEvent_Top_Box_Popularize_Show", ((Popularize)localObject).getReportId() + "", 0L, 0L, ((Popularize)localObject).getReportId() + "");
              this.isLogPopularize = true;
            }
            else if (((Popularize)localObject).getBannerPosition() == 1)
            {
              QMLog.log(4, "AccountListFragment", "DATACOLLECTION_EVENT_BOTTOM_BOX_POPULARIZE_SHOW");
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
  
  private void logState()
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < this.mPullData.size())
    {
      localObject = (AccountListUI)this.mPullData.get(i);
      if ((localObject != null) && (((AccountListUI)localObject).mFolder != null)) {
        localArrayList1.add(Integer.valueOf(((AccountListUI)localObject).mFolder.getId()));
      }
      i += 1;
    }
    if (localArrayList1.contains(Integer.valueOf(-1)))
    {
      DataCollector.logStatus("AppStat_is_Show_AllInbox", "1");
      if (!localArrayList1.contains(Integer.valueOf(-3))) {
        break label409;
      }
      DataCollector.logStatus("AppStat_is_Show_Vip_Contacts", "1");
      label123:
      if (!localArrayList1.contains(Integer.valueOf(-2))) {
        break label421;
      }
      DataCollector.logStatus("AppStat_is_Show_AllStars", "1");
      label147:
      if (!localArrayList1.contains(Integer.valueOf(-9))) {
        break label433;
      }
      DataCollector.logStatus("AppStat_is_Show_AllUnread", "1");
      label171:
      if (!localArrayList1.contains(Integer.valueOf(-14))) {
        break label445;
      }
      DataCollector.logStatus("AppStat_is_Show_AllReceivers", "1");
      label195:
      if (!localArrayList1.contains(Integer.valueOf(-19))) {
        break label457;
      }
      DataCollector.logStatus("AppStat_is_Show_AllAttach", "1");
      label219:
      if (!localArrayList1.contains(Integer.valueOf(-11))) {
        break label469;
      }
      DataCollector.logStatus("AppStat_is_Show_AllDraft", "1");
      label243:
      if (!localArrayList1.contains(Integer.valueOf(-13))) {
        break label481;
      }
      DataCollector.logStatus("AppStat_is_Show_AllSent", "1");
      label267:
      if (!localArrayList1.contains(Integer.valueOf(-12))) {
        break label493;
      }
      DataCollector.logStatus("AppStat_is_Show_AllDeleted", "1");
      label291:
      if (!localArrayList1.contains(Integer.valueOf(-4))) {
        break label505;
      }
      DataCollector.logStatus("AppStat_is_Show_Note", "1");
      label315:
      if (!localArrayList1.contains(Integer.valueOf(-5))) {
        break label517;
      }
      DataCollector.logStatus("AppStat_is_Show_Ftn", "1");
    }
    ArrayList localArrayList2;
    for (;;)
    {
      localObject = AccountManager.shareInstance().getAccountList();
      localArrayList2 = new ArrayList();
      i = 0;
      while (i < ((AccountList)localObject).size())
      {
        localArrayList2.add(Integer.valueOf(QMFolderManager.sharedInstance().getInboxFolderId(((AccountList)localObject).get(i).getId())));
        i += 1;
      }
      DataCollector.logStatus("AppStat_is_Show_AllInbox", "0");
      break;
      label409:
      DataCollector.logStatus("AppStat_is_Show_Vip_Contacts", "0");
      break label123;
      label421:
      DataCollector.logStatus("AppStat_is_Show_AllStars", "0");
      break label147;
      label433:
      DataCollector.logStatus("AppStat_is_Show_AllUnread", "0");
      break label171;
      label445:
      DataCollector.logStatus("AppStat_is_Show_AllReceivers", "0");
      break label195;
      label457:
      DataCollector.logStatus("AppStat_is_Show_AllAttach", "0");
      break label219;
      label469:
      DataCollector.logStatus("AppStat_is_Show_AllDraft", "0");
      break label243;
      label481:
      DataCollector.logStatus("AppStat_is_Show_AllSent", "0");
      break label267;
      label493:
      DataCollector.logStatus("AppStat_is_Show_AllDeleted", "0");
      break label291;
      label505:
      DataCollector.logStatus("AppStat_is_Show_Note", "0");
      break label315;
      label517:
      DataCollector.logStatus("AppStat_is_Show_Ftn", "0");
    }
    Object localObject = new StringBuilder();
    i = j;
    QMFolder localQMFolder;
    if (i < localArrayList2.size())
    {
      localQMFolder = QMFolderManager.sharedInstance().getFolder(((Integer)localArrayList2.get(i)).intValue());
      if (localQMFolder == null) {
        localObject = null;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localArrayList1.contains(localArrayList2.get(i))) {
          ((StringBuilder)localObject).append(localQMFolder.getAccountId() + "#1");
        }
        for (;;)
        {
          if (i != localArrayList2.size() - 1) {
            ((StringBuilder)localObject).append("%");
          }
          i += 1;
          break;
          ((StringBuilder)localObject).append(localQMFolder.getAccountId() + "#0");
        }
      }
      DataCollector.logStatus("AppStat_is_Show_Inbox", ((StringBuilder)localObject).toString());
      return;
    }
  }
  
  private void postRenderTaskIfNotExist()
  {
    Threads.runOnMainThreadIfNotExist(this.renderTask, 500L);
  }
  
  private void refreshTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.mEditMode)
    {
      localQMTopBar.setButtonRightBlue(2131693745);
      if (localQMTopBar.getButtonLeft() != null) {
        localQMTopBar.getButtonLeft().setVisibility(8);
      }
      localQMTopBar.getButtonRight().setContentDescription(getString(2131720827));
    }
    for (;;)
    {
      localQMTopBar.setButtonRightOnclickListener(new AccountListFragment.23(this));
      localQMTopBar.setButtonLeftOnclickListener(new AccountListFragment.24(this));
      return;
      localQMTopBar.setButtonRightIcon(2130841095);
      localQMTopBar.setButtonLeftBack();
      localQMTopBar.getButtonRight().setContentDescription(getString(2131720813));
    }
  }
  
  private void render()
  {
    updatePullData();
    this.mAccountListPull.onRefreshComplete();
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if ((!this.mIsFtnUnreadSync) && (localFtnManager != null))
    {
      QMLog.log(3, "AccountListFragment", "Ftn unread account render try to read exp unread async");
      localFtnManager.asyncFtnExpireTime();
      this.mIsFtnUnreadSync = true;
    }
    if ((QMSettingManager.sharedInstance().getUpgradeFromOldApp()) && (!QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount()) && (QMPushConfigUtil.getTopbarRightButtonHasNewUnClick()))
    {
      getTopBar().showRedDot(true);
      logPopularize();
      ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
      ThirdPartyCallDialogHelpler.showTCPDialogWhenActivityResumed();
      if (getResources().getConfiguration().orientation != 1) {
        break label224;
      }
      this.mAccountListPull.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
    }
    for (;;)
    {
      if (this.needExpandItemForClickFolderShowHomeTip)
      {
        this.needExpandItemForClickFolderShowHomeTip = false;
        autoExpandItemForClickFolderShowHomeTip();
      }
      return;
      if ((QMPushConfigUtil.getTopbarRightButtonHasNewUnClick()) && (((QMPushConfigUtil.getTopbarPopWindowHasNewUnClick()) && (!QMSettingManager.sharedInstance().getNewVersionRead()) && (QMPushConfigUtil.showUpgradeVersion())) || ((QMPushConfigUtil.getBetaPopWindowItem()) && (QMPushConfigUtil.showBetaVersion()))))
      {
        getTopBar().showRedDot(true);
        if (QMPushConfigUtil.showUpgradeVersion())
        {
          DataCollector.logEvent("Event_Topbar_Red_Dot_Show");
          break;
        }
        if (!QMPushConfigUtil.showBetaVersion()) {
          break;
        }
        DataCollector.logEvent("Event_Beta_Topbar_Red_Dot_Show");
        break;
      }
      getTopBar().showRedDot(false);
      break;
      label224:
      this.mAccountListPull.setAdvertiseMode(false);
    }
  }
  
  private void restorePostion()
  {
    Object localObject = getActivity();
    if ((localObject != null) && ((localObject instanceof MailFragmentActivity)))
    {
      localObject = (MailFragmentActivity)localObject;
      int i = ((MailFragmentActivity)localObject).getLastPageTop();
      int j = ((MailFragmentActivity)localObject).getLastPageIndex();
      if (j > -1)
      {
        ((MailFragmentActivity)localObject).clearLastPageInfo();
        if (this.mAccountListPull != null) {
          this.mAccountListPull.setSelectionFromTop(j, i);
        }
      }
    }
  }
  
  private void scrollToTheFolderWhenInvisible(int paramInt)
  {
    if (!this.mAccountListPull.isItemVisibleAtPositon(paramInt)) {
      this.mAccountListPull.setSelection(paramInt);
    }
  }
  
  private void toggleEditMode()
  {
    Object localObject = getActivity().getCurrentFocus();
    if (localObject != null) {
      ((View)localObject).clearFocus();
    }
    int i;
    int j;
    AccountListUI localAccountListUI;
    if (this.mEditMode)
    {
      localObject = this.mDragData.iterator();
      i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label130;
      }
      localAccountListUI = (AccountListUI)((Iterator)localObject).next();
      if (localAccountListUI.mData == null) {
        break label730;
      }
      Boolean localBoolean = (Boolean)this.mInboxFolderMap.get(localAccountListUI.mData.getName());
      if ((localBoolean == null) || (localAccountListUI.mData.isShouldShow()) || (localBoolean.booleanValue() == localAccountListUI.mData.isShouldShow())) {
        break label730;
      }
      i = 1;
    }
    label130:
    label730:
    for (;;)
    {
      break;
      j = 0;
      if ((this.mEditMode) && (j != 0))
      {
        DataCollector.logEvent("Event_Accountlist_Hide_Inbox_Dialog_Show");
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131693745)).setMessage(2131693912).addAction(2131691246, new AccountListFragment.21(this))).addAction(0, 2131696547, new AccountListFragment.20(this))).create().show();
        return;
      }
      this.mInboxFolderMap.clear();
      boolean bool;
      if (!this.mEditMode)
      {
        bool = true;
        this.mEditMode = bool;
        this.mAccountListDrag.setDragEnabled(this.mEditMode);
        if (!this.mEditMode) {
          break label510;
        }
        if (this.editingItems != null) {
          this.editingItems.clear();
        }
        this.mAccountListPull.setEnablePullToRefresh(false);
        updateDragData();
        j = this.mAccountListPull.getFirstVisiblePosition();
        k = this.mAccountListPull.getHeaderViewsCount();
        m = this.mAccountListDrag.getHeaderViewsCount();
        localObject = this.mAccountListPull.getChildAt(0);
        if (localObject != null) {
          break label501;
        }
      }
      label501:
      for (i = 0;; i = ((View)localObject).getTop())
      {
        this.mCurPos = this.mAccountListPull.getFirstVisiblePosition();
        this.mAccountListDrag.setVisibility(0);
        this.mContainBottomLayout.setVisibility(8);
        this.mAccountListDrag.setSelection(this.mCurPos);
        this.mAccountListPull.setLongClickable(false);
        this.mAccountListDrag.setSelectionFromTop(j - (k - m), i);
        this.mInboxFolderMap.clear();
        localObject = this.mDragData.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAccountListUI = (AccountListUI)((Iterator)localObject).next();
          if ((localAccountListUI.mData != null) && (localAccountListUI.mData.getName() != null) && (localAccountListUI.mData.getName().contains(getString(2131693913)))) {
            this.mInboxFolderMap.put(localAccountListUI.mData.getName(), Boolean.valueOf(localAccountListUI.mData.isShouldShow()));
          }
        }
        bool = false;
        break;
      }
      label510:
      this.mAccountListPull.setEnablePullToRefresh(true);
      j = this.mAccountListDrag.getFirstVisiblePosition();
      int k = this.mAccountListDrag.getHeaderViewsCount();
      int m = this.mAccountListPull.getHeaderViewsCount();
      localObject = this.mAccountListDrag.getChildAt(0);
      if (localObject == null) {}
      for (i = 0;; i = ((View)localObject).getTop())
      {
        this.mCurPos = this.mAccountListDrag.getFirstVisiblePosition();
        this.mContainBottomLayout.setVisibility(0);
        this.mAccountListDrag.setVisibility(8);
        this.mAccountListPull.setSelection(this.mCurPos);
        logEvent();
        QMAccountHelper.saveAccountAndFolderToConfig(this.mDragData, this.mEditMode);
        this.mPullData = initPullData();
        this.mAccountPullAdapter = new AccountBaseAdapter(getActivity(), this.mPullData);
        this.mAccountPullAdapter.setAccountListUI(this.mPullData);
        this.mAccountListPull.setAdapter(this.mAccountPullAdapter);
        this.mAccountListPull.setLongClickable(true);
        this.mAccountListPull.setSelectionFromTop(j - (k - m), i);
        if (this.mEditShowCounter > 0) {
          DataCollector.logEvent("Event_Attach_Show_FavList");
        }
        this.mEditShowCounter = 0;
        refreshTopbar();
        displayToggleAnimation(this.mEditMode, this.mAccountListDrag);
        return;
      }
    }
  }
  
  private void updateDragData()
  {
    this.mDragData = initDragData();
    this.mAccountDragAdapter.setAccountListUI(this.mDragData);
    this.mAccountDragAdapter.notifyDataSetChanged();
    this.popularizeBanner.render(this.mAccountListPull, false);
    this.popularizeBannerForDrag.render(this.mAccountListDrag, false);
  }
  
  private void updatePullData()
  {
    this.mPullData = initPullData();
    this.mAccountPullAdapter.setAccountListUI(this.mPullData);
    this.mAccountPullAdapter.notifyDataSetChanged();
    this.popularizeBanner.render(this.mAccountListPull, false);
    this.popularizeBannerForDrag.render(this.mAccountListDrag, false);
    renderSyncErrorBar();
    if (!this.mEditMode) {}
  }
  
  public void cancelEdit()
  {
    if ((this.editingItems != null) && (!this.editingItems.isEmpty()))
    {
      Iterator localIterator = this.mDragData.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (AccountListUI)localIterator.next();
        if ((((AccountListUI)localObject).mData != null) && (this.editingItems.containsKey(Integer.valueOf(((AccountListUI)localObject).mData.getId()))))
        {
          int j = ((AccountListUI)localObject).mData.getFolderId();
          ((AccountListUI)localObject).mData.setShouldShow(((Boolean)this.editingItems.get(Integer.valueOf(((AccountListUI)localObject).mData.getId()))).booleanValue());
          boolean bool = ((AccountListUI)localObject).mData.isShouldShow();
          if (j == -19)
          {
            localObject = QMSettingManager.sharedInstance();
            if (bool)
            {
              i = 1;
              label146:
              ((QMSettingManager)localObject).setStarAttachDisplay(i);
            }
          }
          else
          {
            if (j != -3) {
              continue;
            }
            localObject = QMSettingManager.sharedInstance();
            if (!bool) {
              break label183;
            }
          }
          label183:
          for (int i = 1;; i = 2)
          {
            ((QMSettingManager)localObject).setAddrVipDisplay(i);
            break;
            i = 2;
            break label146;
          }
        }
      }
    }
  }
  
  public void initDataSource()
  {
    QMPushMailNotify.getInstance().cancelAllNotifyNewMail();
    this.mAccountManager = AccountManager.shareInstance();
    QMTaskManager.sharedInstance(1).bindTaskListChangeWatcherList(this.taskListChangeWatcher, true);
    Object localObject = getActivity().getIntent().getExtras();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("savetomyftnkey");
      localObject = ((Bundle)localObject).getString("savetomyftncode");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        QMLog.log(4, "AccountListFragment", "handleSaveToMyFtn:" + str + "," + (String)localObject);
        LaunchSaveToMyFtn.handleSaveFtn(str, (String)localObject);
      }
    }
    bindEvent(true);
    if (this.autoOpenSearch) {
      startFragment(new SearchListFragment(0));
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    int i = 0;
    this.baseView = ((QMBaseView)paramView);
    this.mContainBottomLayout = ThirdPartyCallDialogHelpler.initLayout(this.baseView, false, this.mContainBottomLayout);
    this.mAccountListPull = ThirdPartyCallDialogHelpler.initListView(this.mContainBottomLayout, this.mAccountListPull);
    this.mBottomView = ThirdPartyCallDialogHelpler.initBottomview(this.mContainBottomLayout, this.mBottomView);
    this.mAccountListPull.setPadding(0, 0, 0, getResources().getDimensionPixelSize(2131297349));
    this.mAccountListPull.setClipToPadding(false);
    this.mAccountListDrag = new DragSortListView(QMApplicationContext.sharedInstance());
    this.mAccountListDrag.initStyle();
    this.baseView.addView(this.mAccountListDrag, 0);
    initView();
    initPopupWindow();
    initTopbar();
    initEvent();
    int j = 0;
    while (i < this.mAccountManager.getAccountList().size())
    {
      if (QMPrivateProtocolManager.getPhotoBitmapByEmail(this.mAccountManager.getAccountList().get(i).getEmail(), 4) == null)
      {
        QMPrivateProtocolManager.sharedInstance().loadEmailIcon(this.mAccountManager.getAccountList().get(i).getEmail());
        j = 1;
      }
      i += 1;
    }
    if (j != 0) {
      QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, true);
    }
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().getStringExtra("fromController") != null) && (getActivity().getIntent().getStringExtra("fromController").equals("otherapp"))) {
      this.mBottomView.postDelayed(new AccountListFragment.8(this, this), 20L);
    }
  }
  
  public void initPopupWindow()
  {
    this.mPopWindow = new AccountListFragment.25(this, getActivity(), true);
  }
  
  public List<AccountListUI> initPullData()
  {
    List localList = QMAccountHelper.returnFoldersAndAccounts(this.mAccountManager.getAccountList(), true);
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if ((localList != null) && (localList.size() > 0)) {
      i = 0;
    }
    while (i < localList.size())
    {
      AccountListUI localAccountListUI = (AccountListUI)localList.get(i);
      if (localAccountListUI != null) {
        localStringBuilder.append(localAccountListUI.mItemName + ",");
      }
      i += 1;
      continue;
      if (localList != null) {
        break label141;
      }
      localStringBuilder.append("accountList data null");
    }
    for (;;)
    {
      QMLog.log(4, "AccountListFragment", "initPullData:" + localStringBuilder.toString());
      return localList;
      label141:
      localStringBuilder.append("accountList data empty");
    }
  }
  
  public void initSyncErrorBar()
  {
    this.syncErrorBar = new SyncErrorBar(getActivity());
    this.syncErrorBar.setOnBarItemClickListener(new AccountListFragment.13(this));
  }
  
  protected void launchAddAccount()
  {
    startActivity(AccountTypeListActivity.createIntent("extra_from_mail"));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == -1) {
        updateDragData();
      }
    }
    boolean bool2;
    FtnExpireInfo localFtnExpireInfo;
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 9) || (paramIntent == null) || (this.mAccountPullAdapter == null));
      bool2 = paramIntent.getBooleanExtra("arg_ftn_unread_isupdate", false);
      localFtnExpireInfo = (FtnExpireInfo)paramIntent.getSerializableExtra("arg_ftn_unread_info");
      paramIntent = paramIntent.getStringExtra("from");
    } while (localFtnExpireInfo == null);
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if (localFtnManager != null) {
      if ((StringExtention.isNullOrEmpty(paramIntent)) || (!paramIntent.equalsIgnoreCase("ftn"))) {
        break label158;
      }
    }
    for (;;)
    {
      localFtnManager.setIsFromFtn(bool1);
      localFtnManager.setFtnExpUnreadUpdate(bool2);
      localFtnManager.setFtnExpireInfo(localFtnExpireInfo);
      if (localFtnManager.isFtnExpUnreadNeedShow()) {
        FolderDataManager.sharedInstance().setInnerFtnUnreadCount(0);
      }
      runOnMainThread(new AccountListFragment.38(this));
      return;
      label158:
      bool1 = false;
    }
  }
  
  public void onBackPressed()
  {
    if (this.mEditMode)
    {
      QMLog.log(4, "AccountListFragment", "onBackPressed toggleEditMode");
      cancelEdit();
      toggleEditMode();
      return;
    }
    if (AdvertiseAnimUtil.advertiseViewForeground)
    {
      QMLog.log(4, "AccountListFragment", "onBackPressed advertiseViewForeground");
      AdvertiseAnimUtil.hideAdvertiseView(getActivity(), this.baseView, this.baseView.getAdvertiseView(), this.mAccountListPull);
      return;
    }
    QMLog.log(4, "AccountListFragment", "onBackPressed");
    QMWatcherCenter.triggerAppGotoBackground();
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    if (this.mAccountListPull != null) {
      this.mAccountListPull.onRefreshCompleteWithoutAnimation();
    }
    this.isLogPopularize = false;
    ThirdPartyCallDialogHelpler.hideTCPDialogWhenActivityPaused();
    if (this.netTimer != null)
    {
      QMLog.log(4, "AccountListFragment", "onPause to cancel socket timer");
      this.netTimer.cancel();
      this.netTimer = null;
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.syncWatcher, paramBoolean);
    Watchers.bind(this.loadMailListWatcher, paramBoolean);
    Watchers.bind(this.folderUnreadCountWatcher, paramBoolean);
    Watchers.bind(this.mLoadAttachFolderListWatcher, paramBoolean);
    Watchers.bind(this.mBottleOpenNotifyWatcher, paramBoolean);
    Watchers.bind(this.unreadWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.renderSyncErrorBarWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
    Object localObject = BottleManager.getInstance();
    if (localObject != null) {
      ((BottleManager)localObject).getBottleListController().bindUpdateUnreadStatusWatcher(this.mUnreadWatch, paramBoolean);
    }
    localObject = FtnManager.sharedInstance();
    if (localObject != null)
    {
      QMLog.log(4, "AccountListFragment", "Ftn-expunread folder bind-watcher tobind: " + paramBoolean);
      ((FtnManager)localObject).bindFtnQueryExpireUnreadListener(this.ftnQueryExpireUnreadWatcher, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    if (i == 2) {
      this.mAccountListPull.setAdvertiseMode(false);
    }
    while (i != 1) {
      return;
    }
    this.mAccountListPull.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      if ((this.mPopWindow != null) && (this.mPopWindow.isShowing()))
      {
        this.mPopWindow.dismiss();
        return false;
      }
      showPopMenuWindow(getTopBar().getButtonRight());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    Watchers.bind(this.syncWatcher, false);
    Watchers.bind(this.folderUnreadCountWatcher, false);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, false);
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if (localFtnManager != null) {
      localFtnManager.bindFtnQueryExpireUnreadListener(this.ftnQueryExpireUnreadWatcher, false);
    }
    QMTaskManager.sharedInstance(1).bindTaskListChangeWatcherList(this.taskListChangeWatcher, false);
    bindEvent(false);
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    render();
  }
  
  public void renderSyncErrorBar()
  {
    if (this.syncErrorBar != null)
    {
      if (this.syncErrorBar.render(0, 3)) {
        this.mAccountPullAdapter.notifyDataSetChanged();
      }
      if ((this.syncErrorBar.getCode() == 2) && (this.netTimer == null))
      {
        QMLog.log(4, "AccountListFragment", "render network unavailable to start socket timer");
        startCheckNetTimer();
      }
    }
  }
  
  public void showPopMenuWindow(View paramView)
  {
    if ((this.mPopWindow == null) || (paramView == null)) {
      return;
    }
    if (this.mPopWindow.isShowing()) {
      this.mPopWindow.dismiss();
    }
    Object localObject = Lists.newArrayList(new String[] { getString(2131691909) });
    ArrayList localArrayList = Lists.newArrayList(new Integer[] { Integer.valueOf(2130840816) });
    if ((AccountManager.shareInstance().getAccountList().getDefaultNoteAccount() != null) && (QMSettingManager.sharedInstance().getNoteDisplay()))
    {
      ((List)localObject).add(getString(2131691913));
      localArrayList.add(Integer.valueOf(2130840813));
    }
    ((List)localObject).add(getString(2131720003));
    localArrayList.add(Integer.valueOf(2130840837));
    localObject = new PopupAdapterDividerLine(getActivity(), 2131559772, 2131373496, (List)localObject, localArrayList);
    this.mPopWindow.setAdapter((ListAdapter)localObject);
    this.mPopWindow.setAnchor(paramView);
    this.mPopWindow.showDown();
  }
  
  public void startCheckNetTimer()
  {
    this.netTimer = new Timer();
    AccountListFragment.40 local40 = new AccountListFragment.40(this);
    this.netTimer.schedule(local40, 0L, 30000L);
  }
  
  class FolderUnreadCountWatcherImpl
    implements FolderUnreadCountWatcher, Runnable
  {
    private static final long WAIT_TIME = 100L;
    
    private FolderUnreadCountWatcherImpl() {}
    
    public void onUpdateAccount(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (AccountListFragment.this.mPullData != null)
      {
        Iterator localIterator = AccountListFragment.this.mPullData.iterator();
        while (localIterator.hasNext())
        {
          AccountListUI localAccountListUI = (AccountListUI)localIterator.next();
          if ((localAccountListUI.mAccount != null) && (localAccountListUI.mAccount.getId() == paramInt1))
          {
            localAccountListUI.accUnreadCount = paramInt2;
            localAccountListUI.accHasNewMail = paramBoolean;
            AccountListFragment.this.removeCallbackOnMain(this);
            Threads.runOnMainThreadIfNotExist(this, 100L);
          }
        }
      }
    }
    
    public void onUpdateFolder(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (AccountListFragment.this.mPullData != null)
      {
        Iterator localIterator = AccountListFragment.this.mPullData.iterator();
        while (localIterator.hasNext())
        {
          AccountListUI localAccountListUI = (AccountListUI)localIterator.next();
          if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == paramInt1))
          {
            localAccountListUI.mFolder.setCliUnreadCount(paramInt2);
            localAccountListUI.mFolder.setHasNewMail(paramBoolean);
            AccountListFragment.this.removeCallbackOnMain(this);
            Threads.runOnMainThreadIfNotExist(this, 100L);
          }
        }
      }
    }
    
    public void run()
    {
      AccountListFragment.this.mAccountPullAdapter.setAccountListUI(AccountListFragment.this.mPullData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment
 * JD-Core Version:    0.7.0.1
 */