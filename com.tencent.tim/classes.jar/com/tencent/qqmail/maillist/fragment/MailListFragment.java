package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.activity.tagmail.TagMailActivity;
import com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListBarHelper;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.FolderUnreadCountWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.model.mail.watcher.MailSentWatcher;
import com.tencent.qqmail.model.mail.watcher.MailSpamWatcher;
import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.mail.watcher.RenderSyncErrorBarWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.AdvertiseFilter;
import com.tencent.qqmail.popularize.model.CommercialAdvertiseEnum;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.DataCollectorHelper;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.subscribe.SubscribeListFragment;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMLockTipsView;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.SyncErrorBar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment;
import moai.fragment.base.SaveArgumentField;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

public class MailListFragment
  extends MailFragment
{
  public static final String FROM_ACCOUNT_LIST = "from_account_list";
  public static final String FROM_INNER_FOLDER_LIST = "from_inner_folder_list";
  public static final String FROM_OUT_FOLDER_LIST = "from_out_folder_list";
  public static final String NOTIFICATION_KEY_FOLDER_SHOW_HOME_TIP_CLICK = "folder_show_home_tip_click";
  public static final String NOTIFICATION_KEY_FOLDER_TOP_TIP_CLICK = "folder_top_tip_click";
  private static final int REQUEST_FROM_MAIL_LIST_TO_VIP_INDEX = 1;
  private static final int REQUEST_FROM_MOVE_MAIL_ACTIVITY = 2;
  private static final int REQUEST_FROM_TAG_MAIL_ACTIVITY = 3;
  private static final int REQUEST_UNLOCK_SEARCH_LIST = 1;
  private static final int SINGLE_NOTQQMAIL_TYPE = 2;
  private static final int SINGLE_QQMAIL_TYPE = 1;
  public static final String TAG = "MailListFragment";
  private static final int VIRTUAL_FOLDER_TYPE = 0;
  private static int[] lastPosition = null;
  public static long listReadMailBeginTime;
  public static long refreshBeginTime;
  private Account account;
  private QMMailListAdapter adapter;
  private RelativeLayout addAccountBar;
  private SyncPhotoWatcher avatarWatcher = new MailListFragment.14(this);
  private QMBaseView baseView;
  private TextView btnAllReadOrIdentify;
  View.OnClickListener btnAllReadOrIdentifyEvent = new MailListFragment.46(this);
  private TextView btnDelete;
  private View.OnClickListener btnDeleteEvent = new MailListFragment.39(this);
  private TextView btnEmpty;
  private View.OnClickListener btnEmptyEvent = new MailListFragment.38(this);
  private TextView btnMark;
  View.OnClickListener btnMarkEvent = new MailListFragment.47(this);
  private TextView btnMoveTo;
  View.OnClickListener btnMoveToEvent = new MailListFragment.36(this);
  private TextView btnReject;
  private View.OnClickListener btnRejectEvent = new MailListFragment.37(this);
  private HashMap<Integer, Long> checkMap = new HashMap();
  private Popularize commercialPopularize;
  private QMContentLoadingView contentLoadingView;
  private final MailDeleteWatcher deleteWatcher = new MailListFragment.6(this);
  private SyncErrorBar emptySyncErrorBar;
  private long exposeAdsItemAppearTime = -1L;
  private int exposeAdsItemIndex = -1;
  private QMFolder folder;
  private QMUnlockFolderPwdWatcher folderLockWatcher = new MailListFragment.48(this);
  private RelativeLayout folderTopOrShowHomeBar;
  private int folderType;
  private FolderUnreadCountWatcher folderUnreadCountWatcher = new MailListFragment.1(this);
  private QMBottomBar footerBar;
  private RelativeLayout gMailUnloadBar;
  private boolean hasSelect = false;
  private RelativeLayout inquiryMailBar;
  private boolean isDeleting = false;
  private boolean isEditing = false;
  private boolean isEmpty = false;
  private boolean isFootbarInit = false;
  private boolean isLoading = false;
  private boolean isLoadingAuto = false;
  private boolean isPreloaded = true;
  private boolean isRejectBtnTitleDef = true;
  private boolean isUpdating = false;
  private int lastIndex = -1;
  private int lastTop = -1;
  private int lastVisibleItem;
  private Future<QMMailListCursor> listCursor;
  private ItemScrollListView listView;
  private LoadListWatcher loadMailListWatcher = new MailListFragment.2(this);
  private FolderLockDialog lockDialog;
  private HashMap<Integer, LockInfo> lockInforMap = new HashMap();
  private QMLockTipsView lockTipsView;
  @SaveArgumentField
  private int mAccountId;
  private FrameLayout mBottomView;
  private RelativeLayout mContainBottomLayout;
  @SaveArgumentField
  private int mFolderId;
  @SaveArgumentField
  private String mFrom;
  @SaveArgumentField
  private String mTopBarTitle;
  private MailOperate mailOperate = new MailOperate();
  private MailSentWatcher mailSentWatcher = new MailListFragment.9(this);
  private final MailMoveWatcher moveToWatcher = new MailListFragment.8(this);
  private boolean onIncrementalUpdate;
  private View.OnClickListener onReloadListener = new MailListFragment.30(this);
  private PopularizeBanner popularizeBanner;
  private int popularizePage;
  private final MailPurgeDeleteWatcher purgeDeleteWatcher = new MailListFragment.7(this);
  private int readState = 0;
  private final MailUnReadWatcher readWatcher = new MailListFragment.5(this);
  private final MailRejectWatcher rejectWatcher = new MailListFragment.12(this);
  private RenderSyncErrorBarWatcher renderSyncErrorBarWatcher = new MailListFragment.16(this);
  private boolean reportAdsItemIndexFlag = false;
  private QMSearchBar searchBar;
  private int selectAdConvCnt = 0;
  private int selectClockSendCnt = 0;
  private int selectReadCnt = 0;
  private int selectStartCnt = 0;
  private int selectSubConvCnt = 0;
  private int selectSysCnt = 0;
  private int selectUnReadCnt = 0;
  private int selectUnStartCnt = 0;
  private MailSpamWatcher spamWatcher = new MailListFragment.13(this);
  private int starState = 0;
  private final MailStartWatcher starWatcher = new MailListFragment.4(this);
  private ArrayList<Long> syncCounter = new ArrayList();
  private SyncErrorBar syncErrorBar;
  private SyncWatcher syncWatcher = new MailListFragment.15(this);
  private IObserver tagObserver = new IObserver(new MailListFragment.10(this));
  @Deprecated
  private final MailTagWatcher tagWatcher = new MailListFragment.11(this);
  private QMBaseFragment tmpIntentForLockDialog;
  
  public MailListFragment(int paramInt1, int paramInt2)
    throws MailListFragment.NullFolderException
  {
    super(true);
    this.mAccountId = paramInt1;
    this.mFolderId = paramInt2;
    QMLog.log(4, "MailListFragment", "maillist aid[%d] fid[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.folder = QMFolderManager.sharedInstance().getFolder(this.mFolderId);
    if (this.folder == null) {
      throw new NullFolderException("folderId:" + this.mFolderId);
    }
    setDataSource();
    if (this.folder.getId() == -1) {
      this.popularizePage = 7;
    }
    while (this.folder.getType() != 1) {
      return;
    }
    this.popularizePage = 8;
  }
  
  public MailListFragment(int paramInt1, int paramInt2, String paramString)
    throws MailListFragment.NullFolderException
  {
    this(paramInt1, paramInt2);
    this.mTopBarTitle = paramString;
  }
  
  public MailListFragment(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws MailListFragment.NullFolderException
  {
    this(paramInt1, paramInt2, paramString1);
    this.mFrom = paramString2;
  }
  
  private void addSyncCounter()
  {
    this.syncCounter.add(Long.valueOf(System.currentTimeMillis()));
  }
  
  private boolean canMaillistShowPullDownAD()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    return ((localAccount != null) && (localAccount.getId() == this.mAccountId)) || (this.mAccountId == 0);
  }
  
  private void clearAdMailCnt()
  {
    this.selectAdConvCnt = 0;
  }
  
  private void clearSltClockSendMailCnt()
  {
    this.selectClockSendCnt = 0;
  }
  
  private void clearSltSubConvMailCnt()
  {
    this.selectSubConvCnt = 0;
  }
  
  private void clearSltSystemMailCnt()
  {
    this.selectSysCnt = 0;
  }
  
  private void clearSyncCounter()
  {
    this.syncCounter.clear();
  }
  
  private void decreaseAdMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isSubscribeConv())) {
      this.selectAdConvCnt -= 1;
    }
  }
  
  private void decreaseEditingSelectMailState(MailStatus paramMailStatus)
  {
    boolean bool1 = paramMailStatus.isUnread();
    boolean bool2 = paramMailStatus.isStarred();
    if (bool1) {
      this.selectUnReadCnt -= 1;
    }
    while (bool2)
    {
      this.selectStartCnt -= 1;
      return;
      this.selectReadCnt -= 1;
    }
    this.selectUnStartCnt -= 1;
  }
  
  private void decreaseSltClockSendMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getInformation().getSendUtc() > 0L)) {
      this.selectClockSendCnt -= 1;
    }
  }
  
  private void decreaseSltSubConvMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isSubscribeConv())) {
      this.selectSubConvCnt -= 1;
    }
  }
  
  private void decreaseSltSystemMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isSystemMail())) {
      this.selectSysCnt -= 1;
    }
  }
  
  private void deleteMail(int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    runOnMainThread(new MailListFragment.40(this));
    this.isDeleting = true;
    Threads.runInBackground(new MailListFragment.41(this, paramInt, paramArrayOfLong, paramBoolean));
  }
  
  private void doRender(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QMMailListCursor localQMMailListCursor = getDataSource();
    if (localQMMailListCursor == null)
    {
      QMLog.log(6, "MailListFragment", "no datasource err!!!");
      return;
    }
    int i = localQMMailListCursor.getState();
    int j = localQMMailListCursor.getCount();
    QMLog.log(4, "MailListFragment", "doRender: state: " + i + ", count: " + j + ", renderList: " + paramBoolean);
    if (j < 1)
    {
      switch (i)
      {
      case 0: 
      default: 
        refreshTopBarLoading(false);
        if ((this.adapter != null) && (this.adapter.getMoreLoadingState() == 1)) {
          refreshMoreLoading(false);
        }
        Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
        if ((localAccount != null) && (localAccount.getEmail().toLowerCase().endsWith("@tencent.com")) && (this.folder.getType() == 1)) {
          showTencentAuthTip();
        }
        break;
      }
      for (;;)
      {
        refreshTopBarLoading(false);
        return;
        renderLoading();
        continue;
        bool1 = renderLockTipsView();
        bool2 = renderPopularizeView();
        boolean bool3 = renderSyncError();
        QMLog.log(4, "MailListFragment", "doRender, canLoadMore: " + localQMMailListCursor.canLoadMore() + ", hasLock: " + bool1 + ", hasPopularize: " + bool2 + ", hasSyncError: " + bool3);
        if (((localQMMailListCursor.canLoadMore()) || (bool1) || (bool2) || (bool3)) && (paramBoolean))
        {
          renderList();
        }
        else
        {
          renderEmpty();
          DataCollector.logPerformanceEnd("Performance_Click_Maillist" + this.mAccountId, "");
        }
      }
    }
    switch (i)
    {
    case 0: 
    default: 
      refreshTopBarLoading(false);
      refreshMoreLoading(false);
      if (QMSettingManager.sharedInstance().getAggregateAdMail()) {
        logAggregateMail(localQMMailListCursor);
      }
    case 1: 
      for (;;)
      {
        renderPopularizeView();
        renderLockTipsView();
        renderInquiryMailBar();
        renderSyncError();
        if (!paramBoolean) {
          break;
        }
        renderList();
        return;
        if (!localQMMailListCursor.canLoadMore()) {
          break label466;
        }
        refreshMoreLoading(true);
        refreshTopBarLoading(false);
      }
      label466:
      if (!this.listView.isRefreshing()) {}
      for (;;)
      {
        refreshTopBarLoading(bool1);
        refreshMoreLoading(false);
        break;
        bool1 = false;
      }
    }
    if (!this.listView.isRefreshing()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      refreshTopBarLoading(bool1);
      refreshMoreLoading(false);
      break;
    }
  }
  
  private int getBottomBarType()
  {
    if (this.mAccountId == 0) {
      return 0;
    }
    if ((this.account != null) && (this.account.isQQMail())) {
      return 1;
    }
    return 2;
  }
  
  private QMMailListCursor getDataSource()
  {
    try
    {
      if (this.listCursor != null)
      {
        QMMailListCursor localQMMailListCursor = (QMMailListCursor)this.listCursor.get();
        return localQMMailListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "MailListFragment", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private String getFormattedAddress()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.checkMap.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      localObject2 = getDataSource().getItem(((Integer)localObject2).intValue()).getInformation().getFrom();
      if (!localArrayList2.contains(((MailContact)localObject2).getAddress()))
      {
        localArrayList1.add(localObject2);
        localArrayList2.add(((MailContact)localObject2).getAddress());
      }
    }
    int k = Math.min(localArrayList1.size(), 2);
    int i = 0;
    if (i < k)
    {
      localObject1 = ((MailContact)localArrayList1.get(i)).getName();
      localObject2 = ((MailContact)localArrayList1.get(i)).getAddress();
      int j;
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        j = 1;
        localStringBuilder.append((String)localObject1).append("<");
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject2);
        if (j != 0) {
          localStringBuilder.append(">");
        }
        if (i < k - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
        break;
        j = 0;
      }
    }
    if (localArrayList1.size() > 2) {
      localStringBuilder.append("...");
    }
    localArrayList1.clear();
    localArrayList2.clear();
    return localStringBuilder.toString();
  }
  
  private long[] getSelectMailIds()
  {
    return getSelectMailIds(this.checkMap);
  }
  
  private long[] getSelectMailIds(HashMap<Integer, Long> paramHashMap)
  {
    long[] arrayOfLong = new long[paramHashMap.size()];
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)paramHashMap.get((Integer)localIterator.next())).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  private ArrayList<Long> getSelectMailIdsIncludeConvChild()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap(this.checkMap);
    if (getDataSource() != null)
    {
      i = 0;
      if (i < getDataSource().getCount())
      {
        localObject = getDataSource().getItem(i);
        if ((localObject != null) && (localHashMap.containsKey(Integer.valueOf(i))))
        {
          if (!((Mail)localObject).getStatus().isAdConv()) {
            break label120;
          }
          localArrayList.addAll(QMMailManager.sharedInstance().getAdMailIds(((Mail)localObject).getInformation().getAccountId(), false));
          localHashMap.remove(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          break;
          label120:
          if (((Mail)localObject).getStatus().isSubscribeConv())
          {
            localArrayList.addAll(QMMailManager.sharedInstance().getSubscribeMailIds(((Mail)localObject).getInformation().getAccountId()));
            localHashMap.remove(Integer.valueOf(i));
          }
        }
      }
    }
    Object localObject = getSelectMailIds(localHashMap);
    int k = localObject.length;
    int i = j;
    while (i < k)
    {
      localArrayList.add(Long.valueOf(localObject[i]));
      i += 1;
    }
    localHashMap.clear();
    return localArrayList;
  }
  
  private void gotoCompose()
  {
    TimReportManager.reportClickEvent(getActivity(), "0X8008905", 0, 0, 0, 0, 0, "", "", "", "");
    startActivity(ComposeMailActivity.createIntentWithFolder(this.account, this.folder));
  }
  
  private void increaseAdMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isAdConv())) {
      this.selectAdConvCnt += 1;
    }
  }
  
  private void increaseEditingSelectMailState(MailStatus paramMailStatus)
  {
    boolean bool1 = paramMailStatus.isUnread();
    boolean bool2 = paramMailStatus.isStarred();
    if (bool1) {
      this.selectUnReadCnt += 1;
    }
    while (bool2)
    {
      this.selectStartCnt += 1;
      return;
      this.selectReadCnt += 1;
    }
    this.selectUnStartCnt += 1;
  }
  
  private void increaseSltSubConvMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isSubscribeConv())) {
      this.selectSubConvCnt += 1;
    }
  }
  
  private void increaseSltSystemMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getStatus().isSystemMail())) {
      this.selectSysCnt += 1;
    }
  }
  
  private void increaseStlClockSendMailCnt(Mail paramMail)
  {
    if ((paramMail != null) && (paramMail.getInformation().getSendUtc() > 0L)) {
      this.selectClockSendCnt += 1;
    }
  }
  
  private void initAddAccountBar()
  {
    QMSettingManager.sharedInstance().setPopFolderGuideAdd(this.folder.getAccountId(), this.mFolderId);
    this.addAccountBar = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131559517, null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297366), 80);
    this.addAccountBar.setLayoutParams(localLayoutParams);
    ((TextView)this.addAccountBar.findViewById(2131371074)).setText(this.folder.getPopEmail());
    this.addAccountBar.setOnClickListener(new MailListFragment.26(this));
  }
  
  private void initFooterBar()
  {
    if (this.btnEmpty != null) {
      return;
    }
    this.btnEmpty = this.footerBar.addButton(0, getString(2131691534), this.btnEmptyEvent);
    this.btnAllReadOrIdentify = this.footerBar.addButton(0, getString(2131695662), this.btnAllReadOrIdentifyEvent);
    this.btnDelete = this.footerBar.addButton(1, getString(2131692498), this.btnDeleteEvent);
    this.btnMoveTo = this.footerBar.addButton(0, getString(2131696005), this.btnMoveToEvent);
    this.btnReject = this.footerBar.addButton(0, getString(2131695627), this.btnRejectEvent);
    this.btnMark = this.footerBar.addButton(0, getString(2131695666), this.btnMarkEvent);
    this.isFootbarInit = true;
  }
  
  private void initGMailUnloadBar()
  {
    this.gMailUnloadBar = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131559518, null));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297431), 80);
    this.gMailUnloadBar.setLayoutParams(localLayoutParams);
    ((TextView)this.gMailUnloadBar.findViewById(2131379750)).setText(QMSharedPreferenceManager.getInstance().getGmailErrorMsg());
    this.gMailUnloadBar.findViewById(2131379742).setOnClickListener(new MailListFragment.27(this));
  }
  
  private void initInquiryMailBar()
  {
    DataCollector.logEvent("Event_Received_Mail_Tips_Show");
    if ((this.addAccountBar != null) || (this.gMailUnloadBar != null)) {}
    while (this.inquiryMailBar != null) {
      return;
    }
    this.inquiryMailBar = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131559519, null));
    this.inquiryMailBar.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297366), 80);
    this.inquiryMailBar.setLayoutParams(localLayoutParams);
    this.inquiryMailBar.setOnClickListener(new MailListFragment.24(this));
    Threads.runOnMainThread(new MailListFragment.25(this), 10000L);
    this.baseView.addView(this.inquiryMailBar);
  }
  
  private void initListView()
  {
    this.searchBar = new QMSearchBar(getActivity());
    this.searchBar.setStateNormal();
    this.searchBar.setBtnRight();
    this.searchBar.getBtnRight().setVisibility(8);
    this.searchBar.getBtnRight().setOnClickListener(new MailListFragment.32(this));
    this.searchBar.searchInitWrap.setContentDescription(getString(2131720854));
    this.searchBar.searchInitWrap.setOnClickListener(new MailListFragment.33(this));
    this.lockTipsView = new QMLockTipsView(getActivity());
    this.lockTipsView.setOnClickListener(new MailListFragment.34(this));
    initPopularizeBannerView();
    initSyncErrorBar();
    this.popularizeBanner.render(this.listView, false);
    this.listView.addHeaderView(this.searchBar, null, false);
    this.listView.addHeaderView(this.syncErrorBar, null, false);
    this.listView.addHeaderView(this.lockTipsView, null, false);
    this.listView.setOnRefreshListener(new MailListFragment.35(this));
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(this.popularizePage);
  }
  
  private void initSyncErrorBar()
  {
    this.syncErrorBar = new SyncErrorBar(getActivity());
    this.syncErrorBar.setOnBarItemClickListener(new MailListFragment.31(this));
  }
  
  private void initTipsBarView()
  {
    if (needShowGMailTips())
    {
      initGMailUnloadBar();
      this.baseView.addView(this.gMailUnloadBar);
    }
    do
    {
      return;
      if (needGuide())
      {
        initAddAccountBar();
        this.baseView.addView(this.addAccountBar);
        return;
      }
    } while (!MailListBarHelper.isNeedInitFolderTopOrShowHomeBar());
    this.folderTopOrShowHomeBar = MailListBarHelper.initFolderTopOrShowHomeBar(getActivity(), this.folder, getTips());
    this.baseView.addView(this.folderTopOrShowHomeBar);
    if (MailListBarHelper.isNeedFolderTopTip())
    {
      KvHelper.eventFolderBarShowSetTop(new double[0]);
      return;
    }
    KvHelper.eventFolderBarShowMailBox(new double[0]);
  }
  
  private void initTopBar()
  {
    refreshTopBar();
  }
  
  private boolean isSelectAll()
  {
    int k = this.listView.getHeaderViewsCount();
    if (getDataSource() != null)
    {
      int i;
      int j;
      if (getDataSource().canLoadMore())
      {
        i = this.adapter.getCount() - 1;
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label77;
        }
        if (!this.listView.isItemChecked(j + k))
        {
          return false;
          i = this.adapter.getCount();
          break;
        }
        j += 1;
      }
    }
    return false;
    label77:
    return true;
  }
  
  private boolean isSelectConv()
  {
    return (this.selectSubConvCnt > 0) || (this.selectAdConvCnt > 0);
  }
  
  private boolean isSelectSystemMail()
  {
    return this.selectSysCnt > 0;
  }
  
  private boolean isSyncCounter()
  {
    int i = QMSettingManager.sharedInstance().getInquiryMailTipsTimes() - 1;
    long l1 = QMSettingManager.sharedInstance().getInquiryMailTipsInterval();
    if (this.syncCounter.size() < i) {
      return false;
    }
    long l2 = ((Long)this.syncCounter.get(this.syncCounter.size() - i)).longValue();
    return System.currentTimeMillis() - l2 < l1;
  }
  
  private void logAggregateMail(QMMailListCursor paramQMMailListCursor)
  {
    int i = 50;
    int j;
    try
    {
      j = paramQMMailListCursor.getCount();
      if (j <= 50) {
        break label155;
      }
    }
    catch (Exception paramQMMailListCursor)
    {
      Mail localMail;
      label81:
      QMLog.log(6, "MailListFragment", "logAdMail err:" + paramQMMailListCursor.toString());
      return;
    }
    if (j < i)
    {
      localMail = paramQMMailListCursor.getItem(j);
      if ((localMail != null) && (localMail.getStatus() != null) && (localMail.getStatus().isAdConv()))
      {
        if (j >= 5) {
          break label160;
        }
        paramQMMailListCursor = "Event_AdMail_Top_FIVE";
      }
    }
    for (;;)
    {
      DataCollector.logEvent(paramQMMailListCursor);
      if (localMail.getStatus().isUnread())
      {
        paramQMMailListCursor = "Event_AdMail_Is_UnRead";
        DataCollector.logEvent(paramQMMailListCursor);
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label154;
        }
        DataCollector.logEvent("Event_AdMail_Behind_UnRead");
        return;
        paramQMMailListCursor = "Event_AdMail_Is_Read";
        break label81;
        j += 1;
        break;
      }
      for (;;)
      {
        j = 0;
        break;
        label154:
        return;
        label155:
        i = j;
      }
      label160:
      if (j < 20) {
        paramQMMailListCursor = "Event_AdMail_Top_Twenty";
      } else {
        paramQMMailListCursor = "Event_AdMail_Behind_UnRead";
      }
    }
  }
  
  private void markCommercialAdIsRead()
  {
    if (this.commercialPopularize != null)
    {
      this.commercialPopularize.setIsRead(true);
      PopularizeManager.sharedInstance().updatePopularizeIsRead(true, this.commercialPopularize);
    }
  }
  
  private void markMailPopup()
  {
    int i = getBottomBarType();
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (this.readState == 0)
    {
      localBottomListSheetBuilder.addItem(2130840825, getString(2131695671), getString(2131695671));
      if ((this.account != null) && (this.account.isQQMail()) && (this.folder != null) && (this.folder.getSvrUnreadCount() > 0)) {
        localBottomListSheetBuilder.addItem(2130840822, getString(2131695664), getString(2131695664));
      }
      if (((i == 1) || (i == 2)) && (this.folderType != 6) && (this.folderType != 5)) {
        localBottomListSheetBuilder.addItem(2130840841, getString(2131720744), getString(2131720744));
      }
      if ((this.starState != 2) && (!isSelectConv())) {
        break label310;
      }
      localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
      localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
    }
    for (;;)
    {
      localBottomListSheetBuilder.setOnSheetItemClickListener(new MailListFragment.45(this));
      localBottomListSheetBuilder.build().show();
      return;
      if (this.readState == 1)
      {
        localBottomListSheetBuilder.addItem(2130840823, getString(2131695668), getString(2131695668));
        break;
      }
      if (this.readState != 2) {
        break;
      }
      localBottomListSheetBuilder.addItem(2130840823, getString(2131695668), getString(2131695668));
      localBottomListSheetBuilder.addItem(2130840825, getString(2131695671), getString(2131695671));
      break;
      label310:
      if (this.starState == 0) {
        localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
      } else if (this.starState == 1) {
        localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
      }
    }
  }
  
  private void markReadEventClick()
  {
    if ((this.isEmpty) || (!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showInfo(2131695646);
      return;
    }
    this.mailOperate.unreadMail(getSelectMailIds(), false, false);
  }
  
  private void markStarEventClick()
  {
    if ((this.isEmpty) || (!this.isEditing) || (this.isLoading)) {}
    do
    {
      return;
      if ((this.checkMap == null) || (this.checkMap.isEmpty()))
      {
        getTips().showInfo(2131695646);
        return;
      }
    } while (getSelectMailIds().length <= 0);
    this.mailOperate.starMail(getSelectMailIds(), true);
  }
  
  private void markTagEventClick()
  {
    if ((this.isEmpty) || (!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showInfo(2131695646);
      return;
    }
    startActivityForResult(TagMailActivity.createIntent(this.mAccountId, getSelectMailIdsIncludeConvChild(), false), 3);
  }
  
  private void markUnStarEventClick()
  {
    if ((this.isEmpty) || (!this.isEditing) || (this.isLoading)) {}
    do
    {
      return;
      if ((this.checkMap == null) || (this.checkMap.isEmpty()))
      {
        getTips().showInfo(2131695646);
        return;
      }
    } while (getSelectMailIds().length <= 0);
    this.mailOperate.starMail(getSelectMailIds(), false);
  }
  
  private void markUnreadEventClick()
  {
    if ((this.isEmpty) || (!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showInfo(2131695646);
      return;
    }
    this.mailOperate.unreadMail(getSelectMailIds(), true, false);
  }
  
  private boolean needGuide()
  {
    if (this.folder == null) {}
    while ((!this.folder.isQQPopFolder()) || (QMSettingManager.sharedInstance().getPopFolderGuideAdd(this.folder.getAccountId(), this.mFolderId))) {
      return false;
    }
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    String str = this.folder.getPopEmail();
    int i = 0;
    for (;;)
    {
      if (i >= localAccountList.size()) {
        break label86;
      }
      if (localAccountList.get(i).getEmail().equals(str)) {
        break;
      }
      i += 1;
    }
    label86:
    return true;
  }
  
  private boolean needShowGMailTips()
  {
    if (this.account == null) {}
    while (!this.account.isGMail()) {
      return false;
    }
    return QMSharedPreferenceManager.getInstance().getGmailErrorMsgShow();
  }
  
  private boolean needShowInquiryMailTips()
  {
    if ((this.folder == null) || (this.account == null)) {}
    while ((this.folder.getType() != 1) || (!this.account.isQQMail())) {
      return false;
    }
    return true;
  }
  
  private void operationDone()
  {
    operationDone(null);
  }
  
  private void operationDone(Runnable paramRunnable)
  {
    if (getDataSource() == null) {
      return;
    }
    runInBackground(new MailListFragment.3(this, paramRunnable));
  }
  
  private void popMarkAllReadDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695662)).setMessage(2131721119).addAction(2131691246, new MailListFragment.44(this))).addAction(2131695664, new MailListFragment.43(this))).create().show();
  }
  
  private void refreshFooterBar()
  {
    if (!this.isFootbarInit) {}
    label296:
    label558:
    label568:
    for (;;)
    {
      return;
      int i = getBottomBarType();
      if (i == 0)
      {
        if (this.folderType != 4)
        {
          this.btnAllReadOrIdentify.setVisibility(0);
          this.btnDelete.setVisibility(0);
          if (this.folderType == 5) {
            this.btnDelete.setText(getString(2131697042));
          }
          if ((this.account == null) || (!this.account.isQQMail())) {
            break label127;
          }
          this.btnMoveTo.setVisibility(0);
          this.btnReject.setVisibility(0);
        }
        for (;;)
        {
          this.btnEmpty.setVisibility(8);
          this.btnMark.setVisibility(8);
          return;
          this.btnAllReadOrIdentify.setVisibility(8);
          break;
          label127:
          this.btnMoveTo.setVisibility(8);
          this.btnReject.setVisibility(8);
        }
      }
      if (i == 2)
      {
        if ((this.folderType != 4) && (this.folderType != 5) && (this.folderType != 6))
        {
          this.btnAllReadOrIdentify.setVisibility(0);
          if ((this.folderType != 5) && (this.folderType != 6)) {
            break label296;
          }
          this.btnEmpty.setVisibility(0);
          this.btnMark.setVisibility(0);
        }
        for (;;)
        {
          this.btnDelete.setVisibility(0);
          if ((this.folderType == 5) || (this.folderType == 6)) {
            this.btnDelete.setText(getString(2131697042));
          }
          this.btnReject.setVisibility(8);
          if (this.folderType == 4) {
            break label317;
          }
          this.btnMoveTo.setVisibility(0);
          return;
          this.btnAllReadOrIdentify.setVisibility(8);
          break;
          this.btnEmpty.setVisibility(8);
          this.btnMark.setVisibility(8);
        }
        label317:
        this.btnMoveTo.setVisibility(8);
        return;
      }
      if (i == 1)
      {
        if ((this.folderType != 4) && (this.folderType != 5) && (this.folderType != 6))
        {
          this.btnAllReadOrIdentify.setVisibility(0);
          if ((this.folderType != 5) && (this.folderType != 6)) {
            break label525;
          }
          this.btnEmpty.setVisibility(0);
          this.btnMark.setVisibility(0);
          this.btnDelete.setVisibility(0);
          if ((this.folderType == 5) || (this.folderType == 6)) {
            this.btnDelete.setText(getString(2131697042));
          }
          if ((this.folderType == 4) || (this.folderType == 15)) {
            break label546;
          }
          this.btnMoveTo.setVisibility(0);
          label462:
          if ((this.folderType == 5) || (this.folderType == 6) || (this.folderType == 4)) {
            break label558;
          }
          this.btnReject.setVisibility(0);
        }
        for (;;)
        {
          if (this.folderType != 3) {
            break label568;
          }
          this.btnReject.setVisibility(8);
          return;
          this.btnAllReadOrIdentify.setVisibility(8);
          break;
          this.btnEmpty.setVisibility(8);
          this.btnMark.setVisibility(8);
          break label398;
          this.btnMoveTo.setVisibility(8);
          break label462;
          this.btnReject.setVisibility(8);
        }
      }
    }
  }
  
  private void refreshFooterState()
  {
    boolean bool;
    if (this.checkMap.size() > 0)
    {
      if (this.btnDelete != null) {
        this.btnDelete.setEnabled(true);
      }
      TextView localTextView;
      if (this.btnMoveTo != null)
      {
        localTextView = this.btnMoveTo;
        if (!isSelectConv())
        {
          bool = true;
          localTextView.setEnabled(bool);
        }
      }
      else
      {
        if (this.btnMark != null)
        {
          localTextView = this.btnMark;
          if (isSelectConv()) {
            break label107;
          }
          bool = true;
          label72:
          localTextView.setEnabled(bool);
        }
        if (this.btnReject != null)
        {
          if (this.folderType != 15) {
            break label112;
          }
          this.btnReject.setEnabled(true);
        }
      }
    }
    label107:
    label112:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label72;
      if ((isSelectConv()) || (isSelectSystemMail()))
      {
        this.btnReject.setEnabled(false);
        return;
      }
      if (isSelectSystemMail())
      {
        this.btnReject.setEnabled(false);
        return;
      }
      this.btnReject.setEnabled(true);
      return;
      if (this.btnAllReadOrIdentify != null) {
        this.btnAllReadOrIdentify.setEnabled(true);
      }
      if (this.btnDelete != null) {
        this.btnDelete.setEnabled(false);
      }
      if (this.btnMoveTo != null) {
        this.btnMoveTo.setEnabled(false);
      }
      if (this.btnReject != null) {
        this.btnReject.setEnabled(false);
      }
    } while (this.btnMark == null);
    this.btnMark.setEnabled(false);
  }
  
  private void refreshMoreLoading(boolean paramBoolean)
  {
    if (this.adapter != null)
    {
      if (paramBoolean) {
        this.adapter.setMoreLoading();
      }
    }
    else {
      return;
    }
    this.adapter.setMoreLoadingNormal(false);
  }
  
  private void refreshSelectedButton(boolean paramBoolean)
  {
    if (this.isEditing)
    {
      if (paramBoolean) {
        getTopBar().setButtonLeftNormal(2131719470);
      }
    }
    else {
      return;
    }
    getTopBar().setButtonLeftNormal(2131719469);
  }
  
  private void refreshTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (!this.isEditing)
    {
      localQMTopBar.setButtonLeftBack();
      if (this.mFolderId == -3) {
        localQMTopBar.setButtonRightIcon(2130841094);
      }
    }
    for (;;)
    {
      localQMTopBar.setButtonLeftOnclickListener(new MailListFragment.22(this));
      localQMTopBar.setButtonRightOnclickListener(new MailListFragment.23(this));
      return;
      localQMTopBar.setButtonRightIcon(2130841089);
      localQMTopBar.getButtonRight().setContentDescription(getString(2131691909));
      continue;
      localQMTopBar.setButtonLeftNormal(2131719469);
      localQMTopBar.setButtonRightBlue(2131691246);
    }
  }
  
  private void refreshTopBarLoading(boolean paramBoolean)
  {
    this.isLoadingAuto = paramBoolean;
    renderTopBarTitle();
    getTopBar().showLoading(paramBoolean);
  }
  
  private void renderEmpty()
  {
    if (this.adapter != null) {
      this.adapter.notifyDataSetChanged();
    }
    this.isEmpty = true;
    this.contentLoadingView.showTips(2131695606);
    this.mContainBottomLayout.setVisibility(8);
    renderEmptySyncError();
  }
  
  private void renderEmptySyncError()
  {
    this.emptySyncErrorBar = new SyncErrorBar(getActivity());
    this.emptySyncErrorBar.setOnBarItemClickListener(new MailListFragment.19(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131299664);
    this.emptySyncErrorBar.setLayoutParams(localLayoutParams);
    this.baseView.addView(this.emptySyncErrorBar);
    if ((this.folder.getType() == 1) && (this.folder.getId() != -1) && (this.syncErrorBar != null) && (AccountManager.shareInstance().getAccountList() != null) && (this.mFrom != null))
    {
      if (!this.mFrom.equals("from_account_list")) {
        break label147;
      }
      this.emptySyncErrorBar.render(this.mAccountId, 4);
    }
    label147:
    while ((!this.mFrom.equals("from_inner_folder_list")) && (!this.mFrom.equals("from_out_folder_list"))) {
      return;
    }
    this.emptySyncErrorBar.render(this.mAccountId, 5);
  }
  
  private void renderError(QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("loadlist. ");
    if (this.account == null) {}
    for (String str = null;; str = this.account.getEmail())
    {
      DataCollectorHelper.writeRenderMailListLog("DetailEvent_Render_Maillist", paramQMNetworkError, str);
      this.isEmpty = true;
      DataCollector.logException(7, 12, "Event_Error", getString(2131695607), true);
      this.contentLoadingView.showTipsReload(2131695607, this.onReloadListener);
      this.mContainBottomLayout.setVisibility(8);
      return;
    }
  }
  
  private void renderInquiryMailBar()
  {
    if (this.inquiryMailBar != null)
    {
      if ((isSyncCounter()) && (needShowInquiryMailTips())) {
        this.inquiryMailBar.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.inquiryMailBar.setVisibility(8);
  }
  
  private void renderList()
  {
    this.isLoading = false;
    this.isEmpty = false;
    this.contentLoadingView.hide();
    this.mContainBottomLayout.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = PopularizeManager.sharedInstance().getPopularize(new AdvertiseFilter(new MailListFragment.28(this))).iterator();
    if (localIterator.hasNext())
    {
      Popularize localPopularize = (Popularize)localIterator.next();
      String str = localPopularize.isExpire() + "";
      StringBuilder localStringBuilder = new StringBuilder();
      if (!localPopularize.isCancel()) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MailListFragment", String.format("isExpire %s Cancel %s isRead %s ensureVirtualAdsMailDownloaded %s ", new Object[] { str, bool + "", localPopularize.isRead() + "", VirtualAdManager.getInstance().ensureVirtualAdsMailDownloaded(localPopularize) + "" }));
        if ((!NativeAdsHelper.shouldExposeAdvertiseDetailInMaillist(localPopularize)) || ((AccountManager.shareInstance().getAccountList().getDefaultMailAccount().getId() != this.mAccountId) && (this.mAccountId != 0))) {
          break;
        }
        localArrayList.add(localPopularize);
        this.commercialPopularize = localPopularize;
        break;
      }
    }
    if (this.adapter != null)
    {
      this.adapter.setPopularizedData(localArrayList);
      this.adapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (!this.reportAdsItemIndexFlag) {
        reportAdsItemLocation();
      }
      DataCollector.logPerformanceEnd("Performance_Click_Maillist" + this.mAccountId, "");
      return;
      this.adapter = new QMMailListAdapter(getActivity(), 0, getDataSource(), this.listView);
      this.adapter.setPopularizedData(localArrayList);
      if ((this.folderType == 4) || (this.folderType == 102) || (this.folderType == 5) || (this.folderType == 6) || (this.folderType == 15)) {
        this.adapter.setWhichRightViewShow(new boolean[] { 1, 0 });
      }
      this.listView.setAdapter(this.adapter);
      if ((this.commercialPopularize != null) && (this.commercialPopularize.getCommercialAdvertiseType() == CommercialAdvertiseEnum.NATIVE_ADS_PRO)) {
        this.listView.setOnScrollListener(new MailListFragment.29(this));
      }
    }
  }
  
  private void renderLoading()
  {
    this.isLoading = true;
    this.isEmpty = false;
    this.contentLoadingView.showLoading(true);
    this.mContainBottomLayout.setVisibility(8);
  }
  
  private boolean renderLockTipsView()
  {
    boolean bool = false;
    Object localObject1 = QMFolderManager.sharedInstance();
    this.lockTipsView.hide();
    this.lockInforMap.clear();
    Object localObject2 = AccountManager.shareInstance().getAccountList();
    int i;
    if (this.mAccountId == 0)
    {
      localObject2 = ((AccountList)localObject2).iterator();
      Account localAccount;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localAccount = (Account)((Iterator)localObject2).next();
      } while (!localAccount.isLocked());
      switch (this.mFolderId)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        updateLockInfor(localAccount, i);
        break;
        i = ((QMFolderManager)localObject1).getQQMailVipFolderId(localAccount.getId());
        continue;
        i = ((QMFolderManager)localObject1).getQQMailStarredFolderId(localAccount.getId());
        continue;
        i = ((QMFolderManager)localObject1).getQQMailUnreadFolderId(localAccount.getId());
      }
    }
    if (((AccountList)localObject2).isAccountLocked(this.mAccountId)) {}
    switch (this.folderType)
    {
    case 15: 
    default: 
      i = 0;
      updateLockInfor(((AccountList)localObject2).getAccountById(this.mAccountId), i);
      if (this.lockInforMap.size() > 0)
      {
        if (this.lockInforMap.size() <= 1) {
          break label343;
        }
        localObject1 = String.format(getResources().getString(2131719328), new Object[] { Integer.valueOf(this.lockInforMap.size()) });
        this.lockTipsView.setTips((String)localObject1);
      }
      break;
    }
    for (;;)
    {
      this.lockTipsView.show();
      bool = true;
      return bool;
      i = ((QMFolderManager)localObject1).getQQMailVipFolderId(this.mAccountId);
      break;
      i = ((QMFolderManager)localObject1).getQQMailStarredFolderId(this.mAccountId);
      break;
      i = ((QMFolderManager)localObject1).getQQMailUnreadFolderId(this.mAccountId);
      break;
      i = this.mFolderId;
      break;
      label343:
      localObject1 = this.lockInforMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        this.lockTipsView.setTips(((LockInfo)this.lockInforMap.get(localObject2)).getPersonaCnt(), false);
      }
    }
  }
  
  private boolean renderPopularizeView()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.popularizePage != 7)
    {
      bool1 = bool2;
      if (this.popularizePage != 8) {}
    }
    else
    {
      bool1 = bool2;
      if (this.popularizeBanner.render(this.listView, false) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean renderSyncError()
  {
    boolean bool2 = false;
    if ((this.emptySyncErrorBar != null) && (this.emptySyncErrorBar.getParent() != null)) {
      this.baseView.removeView(this.emptySyncErrorBar);
    }
    boolean bool1;
    if (this.folder != null)
    {
      bool1 = true;
      ValidateHelper.assertInDebug("folder is null, check what happened", bool1);
      bool1 = bool2;
      if (this.folder != null)
      {
        bool1 = bool2;
        if (this.folder.getType() == 1)
        {
          bool1 = bool2;
          if (this.folder.getId() != -1)
          {
            bool1 = bool2;
            if (this.syncErrorBar != null)
            {
              bool1 = bool2;
              if (AccountManager.shareInstance().getAccountList() != null)
              {
                bool1 = bool2;
                if (this.mFrom != null)
                {
                  if (!this.mFrom.equals("from_account_list")) {
                    break label142;
                  }
                  bool1 = this.syncErrorBar.render(this.mAccountId, 4);
                }
              }
            }
          }
        }
      }
    }
    label142:
    do
    {
      return bool1;
      bool1 = false;
      break;
      if (this.mFrom.equals("from_inner_folder_list")) {
        break label168;
      }
      bool1 = bool2;
    } while (!this.mFrom.equals("from_out_folder_list"));
    label168:
    return this.syncErrorBar.render(this.mAccountId, 5);
  }
  
  private void renderTipsBarView(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.gMailUnloadBar != null) {
        this.gMailUnloadBar.setVisibility(0);
      }
      if (this.addAccountBar != null) {
        this.addAccountBar.setVisibility(0);
      }
      if (this.inquiryMailBar != null) {
        this.inquiryMailBar.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.gMailUnloadBar != null) {
        this.gMailUnloadBar.setVisibility(8);
      }
      if (this.addAccountBar != null) {
        this.addAccountBar.setVisibility(8);
      }
    } while (this.inquiryMailBar == null);
    this.inquiryMailBar.setVisibility(8);
  }
  
  private void renderTitleForEditMode()
  {
    if (this.isEditing)
    {
      if (this.checkMap.size() < 1) {
        getTopBar().setTitle(2131695646);
      }
    }
    else {
      return;
    }
    getTopBar().setTitle(String.format(getString(2131695642), new Object[] { Integer.valueOf(this.checkMap.size()) }));
  }
  
  private void renderTopBarTitle()
  {
    renderTopBarTitle(true);
  }
  
  private void renderTopBarTitle(boolean paramBoolean)
  {
    if (getTopBar() == null) {
      return;
    }
    if (this.isEditing)
    {
      renderTitleForEditMode();
      return;
    }
    this.folder = QMFolderManager.sharedInstance().getFolder(this.mFolderId, paramBoolean);
    if (this.folder == null)
    {
      QMLog.log(5, "MailListFragment", "renderTopBarTitle. folder is null.");
      return;
    }
    this.folderType = this.folder.getType();
    int i = QMFolderManager.sharedInstance().getDisplayUnreadCount(this.folder);
    if (this.isLoadingAuto)
    {
      getTopBar().setTitle(2131721229);
      return;
    }
    String str = this.mTopBarTitle;
    QMTopBar localQMTopBar;
    if (str != null)
    {
      getTopBar().setTitle(str);
      localQMTopBar = getTopBar();
      if (i <= 0) {
        break label174;
      }
    }
    label174:
    for (str = "(" + i + ")";; str = null)
    {
      localQMTopBar.setTitleSec(str);
      return;
      getTopBar().setTitle(this.folder.getName());
      break;
    }
  }
  
  private void reportAdsItemLocation()
  {
    this.reportAdsItemIndexFlag = true;
    this.exposeAdsItemIndex = NativeAdsHelper.getInstance().getIndexOfExposeAdsItemInMailList();
    if (this.exposeAdsItemIndex < 0) {}
    while ((this.commercialPopularize == null) || (this.commercialPopularize.getCommercialAdvertiseType() != CommercialAdvertiseEnum.NATIVE_ADS_PRO)) {
      return;
    }
    NativeAdsHelper.getInstance().logNativeAdsItemLocation(this.commercialPopularize.getServerId(), this.exposeAdsItemIndex);
  }
  
  private void reportAdsItemShowTime()
  {
    if ((this.exposeAdsItemIndex < 0) || (this.exposeAdsItemAppearTime <= 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      l2 = this.exposeAdsItemAppearTime;
      this.exposeAdsItemAppearTime = -1L;
    } while ((this.commercialPopularize == null) && (this.commercialPopularize.getCommercialAdvertiseType() != CommercialAdvertiseEnum.NATIVE_ADS_PRO));
    int i = this.commercialPopularize.getServerId();
    NativeAdsHelper.getInstance().logNativeAdsShowInMailistDuration(i, l1 - l2);
  }
  
  private void resetEditingSelectMailState()
  {
    this.selectUnStartCnt = 0;
    this.selectStartCnt = 0;
    this.selectReadCnt = 0;
    this.selectUnReadCnt = 0;
  }
  
  private void restorePosition()
  {
    if (this.lastIndex > -1)
    {
      this.listView.setSelectionFromTop(this.lastIndex, this.lastTop);
      this.lastTop = -1;
      this.lastIndex = -1;
    }
  }
  
  private void savePosition()
  {
    int i = 0;
    View localView;
    if (this.listView != null)
    {
      this.lastIndex = this.listView.getFirstVisiblePosition();
      localView = this.listView.getChildAt(0);
      if (localView != null) {
        break label81;
      }
    }
    for (;;)
    {
      this.lastTop = i;
      QMLog.log(2, "MailListFragment", "savePosition: " + this.lastIndex + ", " + this.lastTop);
      return;
      label81:
      i = localView.getTop();
    }
  }
  
  private void setAllSelectState(boolean paramBoolean)
  {
    int j = 0;
    int k = this.listView.getHeaderViewsCount();
    clearSltSystemMailCnt();
    clearSltSubConvMailCnt();
    clearSltClockSendMailCnt();
    clearAdMailCnt();
    resetEditingSelectMailState();
    int i;
    if (paramBoolean)
    {
      refreshSelectedButton(true);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        if (getDataSource().canLoadMore()) {
          i = this.adapter.getCount() - 1;
        }
        for (;;)
        {
          if (j >= i) {
            break label204;
          }
          try
          {
            Mail localMail = getDataSource().getMailItem(j);
            if (!this.listView.isItemChecked(j + k)) {
              this.listView.setItemChecked(j + k, true);
            }
            this.checkMap.put(Integer.valueOf(j), Long.valueOf(getDataSource().getItemId(j)));
            increaseSltSystemMailCnt(localMail);
            increaseSltSubConvMailCnt(localMail);
            increaseAdMailCnt(localMail);
            increaseStlClockSendMailCnt(localMail);
            increaseEditingSelectMailState(localMail.getStatus());
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QMLog.log(6, "MailListFragment", "can loadmore error count");
            }
          }
          j += 1;
          continue;
          i = this.adapter.getCount();
        }
        label204:
        setEditingSelectItemType();
      }
    }
    for (;;)
    {
      updateRejectBtnState();
      refreshFooterState();
      renderTitleForEditMode();
      return;
      refreshSelectedButton(false);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        if (getDataSource().canLoadMore()) {}
        for (i = this.adapter.getCount() - 1;; i = this.adapter.getCount())
        {
          j = 0;
          while (j < i)
          {
            if (this.listView.isItemChecked(j + k)) {
              this.listView.setItemChecked(j + k, false);
            }
            j += 1;
          }
        }
      }
      this.listView.clearChoices();
      this.checkMap.clear();
      setEditingSelectItemType();
    }
  }
  
  private void setDataSource()
  {
    this.listCursor = Threads.submitTask(new MailListFragment.17(this));
  }
  
  private void setEditingSelectItemType()
  {
    if (getDataSource() == null) {}
    label51:
    label93:
    do
    {
      for (;;)
      {
        return;
        boolean bool;
        if (this.checkMap.size() > 0)
        {
          bool = true;
          this.hasSelect = bool;
          if (!this.hasSelect) {
            break;
          }
          if ((this.selectUnReadCnt > 0) || (this.selectReadCnt <= 0)) {
            break label93;
          }
          this.readState = 0;
          if ((this.selectUnStartCnt <= 0) || (this.selectStartCnt > 0)) {
            break label137;
          }
          this.starState = 0;
        }
        for (;;)
        {
          if (this.btnAllReadOrIdentify == null) {
            break label179;
          }
          this.btnAllReadOrIdentify.setText(2131695666);
          return;
          bool = false;
          break;
          if ((this.selectUnReadCnt > 0) && (this.selectReadCnt <= 0))
          {
            this.readState = 1;
            break label51;
          }
          if ((this.selectUnReadCnt <= 0) || (this.selectReadCnt <= 0)) {
            break label51;
          }
          this.readState = 2;
          break label51;
          if ((this.selectUnStartCnt <= 0) && (this.selectStartCnt > 0)) {
            this.starState = 1;
          } else if ((this.selectUnStartCnt > 0) && (this.selectStartCnt > 0)) {
            this.starState = 2;
          }
        }
      }
      this.selectUnReadCnt = 0;
      this.selectReadCnt = 0;
      this.selectStartCnt = 0;
      this.selectUnStartCnt = 0;
      this.readState = 0;
      this.starState = 0;
    } while (this.btnAllReadOrIdentify == null);
    label137:
    label179:
    this.btnAllReadOrIdentify.setText(2131695662);
  }
  
  private void setListViewItemEventListener()
  {
    if (this.listView == null)
    {
      QMLog.log(6, "MailListFragment", "addListViewItemEventListener listview is null");
      return;
    }
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    this.listView.setOnItemClickListener(new MailListItemClick());
    this.listView.setOnRightViewClickListener(new MailListOnRightViewClickListener(null));
    this.listView.setDataCollectCallback(new MailListFragment.49(this));
    this.listView.setOnItemLongClickListener(new MailListFragment.50(this, arrayOfBoolean));
    this.listView.setOnTouchListener(new MailListFragment.51(this, arrayOfBoolean));
  }
  
  private void showAsyncDeleteClockSendMailDialog()
  {
    Threads.runOnMainThread(new MailListFragment.42(this));
  }
  
  private void showTencentAuthTip()
  {
    DataCollector.logException(7, 13, "Event_Error", getString(2131695611), true);
    this.contentLoadingView.showTips(2131695611);
  }
  
  private void toggleEditingState()
  {
    if ((this.isLoading) || (this.isEditing) || (this.isEmpty)) {
      return;
    }
    this.isEditing = true;
    this.listView.setChoiceMode(2);
    this.listView.setEnablePullToRefresh(false);
    Object localObject = this.listView;
    if (!this.isEditing) {}
    for (boolean bool = true;; bool = false)
    {
      ((ItemScrollListView)localObject).setCouldScrollDecidByUser(bool);
      if (this.adapter != null)
      {
        this.adapter.setIsEditing(true);
        this.adapter.notifyDataSetChanged();
      }
      refreshTopBar();
      initFooterBar();
      refreshFooterBar();
      this.footerBar.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131297365));
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      renderTipsBarView(this.isEditing);
      this.mBottomView.setVisibility(8);
      this.searchBar.setSearchbarEnable(false);
      this.lockTipsView.setEnabled(false);
      return;
    }
  }
  
  private void toggleNormalState()
  {
    this.isEditing = false;
    this.checkMap.clear();
    clearSltSystemMailCnt();
    clearSltSubConvMailCnt();
    clearSltClockSendMailCnt();
    clearAdMailCnt();
    setAllSelectState(false);
    this.listView.setChoiceMode(0);
    this.listView.setEnablePullToRefresh(true);
    Object localObject = this.listView;
    if (!this.isEditing) {}
    for (boolean bool = true;; bool = false)
    {
      ((ItemScrollListView)localObject).setCouldScrollDecidByUser(bool);
      if (this.adapter != null)
      {
        this.adapter.setIsEditing(false);
        this.adapter.notifyDataSetChanged();
      }
      refreshTopBar();
      renderTopBarTitle();
      this.footerBar.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      renderTipsBarView(this.isEditing);
      ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
      this.searchBar.setSearchbarEnable(true);
      this.lockTipsView.setEnabled(true);
      return;
    }
  }
  
  private void updateLockInfor(Account paramAccount, int paramInt)
  {
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt);
    if (localQMFolder != null)
    {
      int i = Math.max(localQMFolder.getPersonalCount(), 0);
      if (i > 0) {
        this.lockInforMap.put(Integer.valueOf(paramAccount.getId()), new LockInfo(paramAccount.getId(), paramInt, paramAccount.getEmail(), i));
      }
    }
  }
  
  private void updateRejectBtnState()
  {
    if (!this.isFootbarInit) {}
    do
    {
      do
      {
        return;
        if (((this.checkMap == null) || (this.checkMap.size() <= 0) || (this.checkMap.size() != this.selectSubConvCnt)) && (this.folderType != 15)) {
          break;
        }
        this.btnReject.setText(getString(2131695640));
      } while (!this.isRejectBtnTitleDef);
      this.isRejectBtnTitleDef = false;
      refreshFooterBar();
      return;
      this.btnReject.setText(getString(2131695627));
    } while (this.isRejectBtnTitleDef);
    this.isRejectBtnTitleDef = true;
    refreshFooterBar();
  }
  
  protected void gotoVipList()
  {
    startFragmentForResult(new VIPContactsIndexFragment(this.mAccountId, true), 1);
  }
  
  public void initDataSource()
  {
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    paramView = (QMBaseView)paramView;
    initTopBar();
    initListView();
    initTipsBarView();
    setListViewItemEventListener();
    ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
    TimReportManager.reportClickEvent(getActivity(), "0X8008902", 0, 0, 0, 0, 0, "", "", "", "");
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.contentLoadingView = this.baseView.addListEmptyView();
    this.mContainBottomLayout = ThirdPartyCallDialogHelpler.initLayout(this.baseView, true, this.mContainBottomLayout);
    this.listView = ThirdPartyCallDialogHelpler.initListView(this.mContainBottomLayout, this.listView);
    this.mBottomView = ThirdPartyCallDialogHelpler.initBottomview(this.mContainBottomLayout, this.mBottomView);
    this.footerBar = new QMBottomBar(getActivity());
    this.footerBar.setVisibility(8);
    this.baseView.addView(this.footerBar);
    return this.baseView;
  }
  
  public void markAllMailRead()
  {
    int i = AccountManager.shareInstance().getAccountList().size();
    Object localObject1 = QMMailManager.sharedInstance();
    if ((i > 1) && ((this.mFolderId == -1) || (this.mFolderId == -9))) {
      this.mailOperate.unreadMail(getDataSource().getItemIds(), false, true);
    }
    for (;;)
    {
      markCommercialAdIsRead();
      return;
      if ((this.account != null) && (this.account.isQQMail()))
      {
        if (this.folder != null)
        {
          int j = this.mFolderId;
          if (j == -3)
          {
            ((QMMailManager)localObject1).markMailRead(this.mAccountId, new String[] { "addrvip_addrvip_" });
            localObject1 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.mAccountId, 17);
            i = j;
            if (localObject1 != null)
            {
              i = j;
              if (((ArrayList)localObject1).get(0) != null) {
                i = ((QMFolder)((ArrayList)localObject1).get(0)).getId();
              }
            }
            label158:
            if ((this.adapter == null) || (getDataSource() == null)) {
              break label473;
            }
            if (!getDataSource().canLoadMore()) {
              break label475;
            }
          }
          label473:
          label475:
          for (j = this.adapter.getCount() - 1;; j = this.adapter.getCount())
          {
            localObject1 = new long[j];
            int k = 0;
            while (k < j)
            {
              localObject1[k] = getDataSource().getItemId(k);
              k += 1;
            }
            if (j == -9)
            {
              ((QMMailManager)localObject1).markMailRead(this.mAccountId, new String[] { "1", "3", "8", "9", "subscribe", "pop", "personal" });
              localObject1 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.mAccountId, 18);
              i = j;
              if (localObject1 == null) {
                break label158;
              }
              i = j;
              if (((ArrayList)localObject1).get(0) == null) {
                break label158;
              }
              i = ((QMFolder)((ArrayList)localObject1).get(0)).getId();
              break label158;
            }
            String str = ((QMMailManager)localObject1).getCGIRemoteId(this.folder);
            if ((this.folder.getType() == 1) && (QMSettingManager.sharedInstance().getAggregateSubscribeMail()))
            {
              Object localObject2 = QMFolderManager.sharedInstance().getFolder(QMFolderManager.sharedInstance().getQQMailSubFolderId(this.mAccountId));
              if (localObject2 != null)
              {
                localObject2 = ((QMMailManager)localObject1).getCGIRemoteId((QMFolder)localObject2);
                ((QMMailManager)localObject1).markMailRead(this.mAccountId, new String[] { str, localObject2 });
                i = j;
                break label158;
              }
              ((QMMailManager)localObject1).markMailRead(this.mAccountId, new String[] { str });
              i = j;
              break label158;
            }
            ((QMMailManager)localObject1).markMailRead(this.mAccountId, new String[] { str });
            i = j;
            break label158;
            break;
          }
          this.mailOperate.unreadMailLocal(i, (long[])localObject1, false);
        }
      }
      else {
        this.mailOperate.unreadMail(getDataSource().getItemIds(), false, false);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      setAllSelectState(false);
      this.checkMap.clear();
      operationDone();
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 3) && (paramInt2 == 1001))
      {
        setAllSelectState(false);
        this.checkMap.clear();
        operationDone();
        return;
      }
      if ((paramInt1 == 1) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getExtras().get("lockinfos");
        if (paramIntent != null)
        {
          paramIntent = ((ArrayList)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            LockInfo localLockInfo = (LockInfo)paramIntent.next();
            if (localLockInfo.isUnLock()) {
              this.lockInforMap.remove(Integer.valueOf(localLockInfo.getAccountId()));
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.isEditing) {
      toggleNormalState();
    }
    do
    {
      return;
      if (AdvertiseAnimUtil.advertiseViewForeground)
      {
        AdvertiseAnimUtil.hideAdvertiseView(getActivity(), this.baseView, this.baseView.getAdvertiseView(), this.listView);
        return;
      }
    } while (AdvertiseAnimUtil.duringAnimation);
    onButtonBackClick();
  }
  
  public void onBackground()
  {
    super.onBackground();
    if (this.listView != null) {
      this.listView.onRefreshCompleteWithoutAnimation();
    }
    clearSyncCounter();
    reportAdsItemShowTime();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadMailListWatcher, paramBoolean);
    Watchers.bind(this.starWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.purgeDeleteWatcher, paramBoolean);
    Watchers.bind(this.readWatcher, paramBoolean);
    Watchers.bind(this.moveToWatcher, paramBoolean);
    Watchers.bind(this.tagWatcher, paramBoolean);
    Watchers.bind(this.rejectWatcher, paramBoolean);
    Watchers.bind(this.spamWatcher, paramBoolean);
    Watchers.bind(this.syncWatcher, paramBoolean);
    Watchers.bind(this.mailSentWatcher, paramBoolean);
    Watchers.bind(this.folderUnreadCountWatcher, paramBoolean);
    Watchers.bind(this.renderSyncErrorBarWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
    QMNotification.registNotification("TOGGLE_VIEW_TYPE", this.tagObserver);
  }
  
  public void onButtonBackClick()
  {
    Threads.runInBackground(new MailListFragment.52(this));
    super.onButtonBackClick();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = getResources().getConfiguration().orientation;
    if ((i == 2) && (this.folderType == 1)) {
      this.listView.setAdvertiseMode(false);
    }
    while ((i != 1) || (this.folderType != 1) || (!canMaillistShowPullDownAD())) {
      return;
    }
    this.listView.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    MailListBarHelper.resetFolderTipFlag();
    if (this.folderTopOrShowHomeBar != null) {
      this.folderTopOrShowHomeBar.setVisibility(8);
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (!this.isEditing) && (this.listView.isFold());
  }
  
  public void onForeground()
  {
    super.onForeground();
    this.reportAdsItemIndexFlag = false;
    KvHelper.eventMaillistExpose(new double[0]);
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2) && (this.adapter != null)) {
      this.adapter.notifyDataSetChanged();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.isEditing))
    {
      toggleNormalState();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Object onLastFragmentFinish()
  {
    Threads.cancelTask(this.listCursor);
    Threads.runInBackground(new MailListFragment.53(this));
    if (((this.folder.getType() == 1) && (AccountManager.shareInstance().getAccountList().size() > 1)) || ((this.mFrom != null) && (this.mFrom.equals("from_schema")))) {
      return new AccountListFragment();
    }
    if (this.mAccountId != 0) {
      return new FolderListFragment(this.mAccountId);
    }
    return null;
  }
  
  public void onRelease()
  {
    QMNotification.unregistNotification("TOGGLE_VIEW_TYPE", this.tagObserver);
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if ((this.adapter != null) && (localObject != null) && (!((Account)localObject).isActiveSyncMail()))
    {
      localObject = this.adapter.getHitMailIds();
      if (localObject != null) {
        Threads.runInBackground(new MailListFragment.20(this, (ConcurrentHashSet)localObject));
      }
    }
    savePosition();
    lastPosition = new int[] { this.lastIndex, this.lastTop, this.mFolderId };
    this.adapter = null;
    this.listView.setAdapter(null);
    if (getDataSource() != null) {
      getDataSource().close();
    }
    this.baseView.removeAdvertiseView();
    NativeAdsHelper.getInstance().setLockForUpdateMaillistExposeState(false);
  }
  
  public void onTopBarCenterClick()
  {
    if (getDataSource() != null)
    {
      DataCollector.logEvent("Event_Touch_Title");
      ListViewHelper.getNextUnread(this.listView, getDataSource(), new MailListFragment.21(this));
      return;
    }
    super.onTopBarCenterClick();
  }
  
  public int refreshData()
  {
    if (!this.isPreloaded) {
      getDataSource().refresh(getDataSource().isOverdue(), new MailListFragment.18(this));
    }
    this.isPreloaded = false;
    return 0;
  }
  
  public void render(int paramInt)
  {
    this.listView.onRefreshComplete();
    renderTopBarTitle();
    doRender(true);
    if (getDataSource() != null) {
      getDataSource().popIn();
    }
    if (lastPosition != null)
    {
      if (lastPosition[2] == this.mFolderId)
      {
        this.lastIndex = lastPosition[0];
        this.lastTop = lastPosition[1];
        restorePosition();
      }
      lastPosition = null;
    }
    ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
    Configuration localConfiguration = getResources().getConfiguration();
    if ((this.folderType == 1) && (localConfiguration.orientation == 1) && (canMaillistShowPullDownAD()))
    {
      this.listView.setAdvertiseMode(AdvertiseManager.getInstance().ensureAdvertiseAvailable());
      return;
    }
    this.listView.setAdvertiseMode(false);
  }
  
  public final class MailListItemClick
    implements AdapterView.OnItemClickListener
  {
    public MailListItemClick() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if ((MailListFragment.this.listView == null) || (MailListFragment.this.adapter == null)) {}
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        MailListFragment.this.listView.setOnItemClickListener(null);
        int i = MailListFragment.this.listView.getHeaderViewsCount();
        paramInt -= i;
        if ((paramInt < 0) || (MailListFragment.this.getDataSource() == null))
        {
          MailListFragment.this.listView.setOnItemClickListener(this);
          continue;
        }
        Object localObject1;
        if (MailListFragment.this.isEditing)
        {
          if (((paramView instanceof MailListItemView)) || ((paramView instanceof HorizontalScrollItemView)))
          {
            localObject1 = MailListFragment.this.adapter.getItem(paramInt);
            if (MailListFragment.this.checkMap.containsKey(Integer.valueOf(paramInt))) {
              break label294;
            }
            l1 = MailListFragment.this.getDataSource().getItemId(paramInt);
            MailListFragment.this.checkMap.put(Integer.valueOf(paramInt), Long.valueOf(l1));
            MailListFragment.this.listView.setItemChecked(i + paramInt, true);
            MailListFragment.this.increaseSltSystemMailCnt((Mail)localObject1);
            MailListFragment.this.increaseSltSubConvMailCnt((Mail)localObject1);
            MailListFragment.this.increaseAdMailCnt((Mail)localObject1);
            MailListFragment.this.increaseStlClockSendMailCnt((Mail)localObject1);
            MailListFragment.this.increaseEditingSelectMailState(((Mail)localObject1).getStatus());
          }
          for (;;)
          {
            MailListFragment.this.updateRejectBtnState();
            MailListFragment.this.refreshFooterState();
            MailListFragment.this.renderTitleForEditMode();
            MailListFragment.this.setEditingSelectItemType();
            MailListFragment.this.refreshSelectedButton(MailListFragment.access$1900(MailListFragment.this));
            MailListFragment.this.listView.setOnItemClickListener(this);
            break;
            label294:
            MailListFragment.this.checkMap.remove(Integer.valueOf(paramInt));
            MailListFragment.this.listView.setItemChecked(i + paramInt, false);
            MailListFragment.this.decreaseSltSystemMailCnt((Mail)localObject1);
            MailListFragment.this.decreaseSltSubConvMailCnt((Mail)localObject1);
            MailListFragment.this.decreaseSltClockSendMailCnt((Mail)localObject1);
            MailListFragment.this.decreaseAdMailCnt((Mail)localObject1);
            MailListFragment.this.decreaseEditingSelectMailState(((Mail)localObject1).getStatus());
          }
        }
        if ((paramView instanceof MailListMoreItemView))
        {
          if ((MailListFragment.this.getDataSource().canLoadMore()) && (paramInt == MailListFragment.this.getDataSource().getCount()) && (!MailListFragment.this.isLoading))
          {
            MailListFragment.this.adapter.setMoreLoading();
            Threads.runInBackground(new MailListFragment.MailListItemClick.1(this));
          }
          MailListFragment.this.listView.setItemChecked(i + paramInt, false);
          MailListFragment.this.listView.setOnItemClickListener(this);
          continue;
        }
        Mail localMail = MailListFragment.this.adapter.getItem(paramInt);
        long l1 = 0L;
        Object localObject3 = localMail.getStatus();
        label525:
        long l2;
        MailInformation localMailInformation;
        if (((MailStatus)localObject3).isSubscribeConv())
        {
          l1 = Mail.addAttrs(new Long[] { Long.valueOf(0L), Long.valueOf(8192L) });
          l2 = l1;
          if (((MailStatus)localObject3).isHybirdList()) {
            l2 = Mail.addAttrs(new Long[] { Long.valueOf(l1), Long.valueOf(16384L) });
          }
          localMailInformation = localMail.getInformation();
          if (!((MailStatus)localObject3).isSubscribeConv()) {
            break label658;
          }
        }
        try
        {
          localObject1 = new SubscribeListFragment(localMailInformation.getAccountId(), l2);
          MailListFragment.this.startFragment((BaseFragment)localObject1);
          for (;;)
          {
            label603:
            paramView.setSelected(true);
            MailListFragment.this.listView.setOnItemClickListener(this);
            break;
            if (!((MailStatus)localObject3).isAdConv()) {
              break label525;
            }
            l1 = Mail.addAttrs(new Long[] { Long.valueOf(0L), Long.valueOf(2048L) });
            break label525;
            label658:
            if (((MailStatus)localObject3).isAdConv())
            {
              try
              {
                localObject1 = new AggregateMailListFragment(MailListFragment.this.mAccountId, l2);
                MailListFragment.this.startFragment((BaseFragment)localObject1);
                if ((MailListFragment.this.commercialPopularize == null) || (MailListFragment.this.commercialPopularize.isExpire()) || (MailListFragment.this.commercialPopularize.isCancel())) {
                  continue;
                }
                KvHelper.eventCommercialMailMailListClickWithData(new double[0]);
                if (!MailListFragment.this.commercialPopularize.isRead()) {
                  DataCollector.logEvent("Event_AD_Mail_Mail_List_Click");
                }
                i = NativeAdsHelper.getInstance().getIndexOfExposeAdsItemInMailList();
                QMLog.log(4, "MailListFragment", "click ad item positon = " + paramInt + " indexOfMaillistExposeItem = " + i);
                if (i == paramInt) {
                  NativeAdsHelper.getInstance().logNativeAdsItemClick(MailListFragment.this.commercialPopularize.getServerId());
                }
                if ((i >= 0) || (!localMail.getStatus().isUnread())) {
                  continue;
                }
                QMLog.log(4, "MailListFragment", "Come into inner mailist cause other unread");
                NativeAdsHelper.getInstance().log(MailListFragment.this.commercialPopularize.getServerId(), "Event_Native_AD_Inner_Mail_List_Expose_From_Unread");
              }
              catch (Exception localException1) {}
            }
            else
            {
              if (!((MailStatus)localObject3).isConversation()) {
                break label933;
              }
              localObject2 = new ConvMailListFragment(MailListFragment.this.mAccountId, MailListFragment.this.mFolderId, localMailInformation.getId(), MailListFragment.this.getDataSource().getItemIds());
              MailListFragment.this.startFragment((BaseFragment)localObject2);
            }
          }
          label933:
          Object localObject2 = localMailInformation.getFrom();
          boolean bool;
          label962:
          int j;
          String str1;
          String str2;
          if ((((MailStatus)localObject3).isGroupMail()) || (!StringUtils.isEmpty(localMailInformation.getGroupId())))
          {
            bool = true;
            i = localMailInformation.getAccountId();
            j = MailListFragment.this.mFolderId;
            l1 = localMailInformation.getId();
            localObject3 = localMailInformation.getSubject();
            str1 = ((MailContact)localObject2).getNick();
            str2 = ((MailContact)localObject2).getAddress();
            if (MailListFragment.this.getDataSource() != null) {
              break label1184;
            }
          }
          label1184:
          for (localObject2 = null;; localObject2 = MailListFragment.this.getDataSource().getItemIdsInFuture())
          {
            localObject2 = new ReadMailFragment(i, j, l1, (String)localObject3, str1, str2, bool, (Future)localObject2);
            i = localMailInformation.getFolderId();
            if (!FolderLockDialog.isFolderLock(i)) {
              break label1199;
            }
            if (MailListFragment.this.lockDialog != null) {
              MailListFragment.this.lockDialog.dismissTips();
            }
            if (MailListFragment.this.getActivity() != null)
            {
              MailListFragment.access$2502(MailListFragment.this, new FolderLockDialog(MailListFragment.this.getActivity(), i, localMailInformation.getAccountId(), MailListFragment.this.folderLockWatcher));
              MailListFragment.this.lockDialog.createDialog(1);
              MailListFragment.this.lockDialog.showDialog();
              MailListFragment.access$2702(MailListFragment.this, (QMBaseFragment)localObject2);
              paramView.setSelected(true);
            }
            MailListFragment.this.listView.setOnItemClickListener(this);
            break;
            bool = false;
            break label962;
          }
          label1199:
          MailListFragment.this.startFragmentWithBackStackChangedListener((BaseFragment)localObject2, new MailListFragment.MailListItemClick.2(this));
          ((ReadMailFragment)localObject2).reuseMailData(localMail);
          MailListFragment.listReadMailBeginTime = new Date().getTime();
          DataCollector.logPerformanceBegin("Performance_List_Read_Mail", MailListFragment.this.mAccountId, "Performance_List_Read_Mail" + MailListFragment.listReadMailBeginTime);
          QMLog.log(4, "MailListFragment", "read mail logPerformanceBegin key:" + MailListFragment.listReadMailBeginTime + ", time:" + MailListFragment.listReadMailBeginTime);
        }
        catch (Exception localException2)
        {
          break label603;
        }
      }
    }
  }
  
  final class MailListOnRightViewClickListener
    implements ItemScrollListView.OnRightViewClickListener
  {
    private MailListOnRightViewClickListener() {}
    
    public void onRightViewClick(View paramView, int paramInt)
    {
      QMLog.log(4, "MailListFragment", "onRightViewClick, View id:" + paramView.getId() + ", position:" + paramInt + ",folderType:" + MailListFragment.this.folderType);
      if ((paramView != null) && (paramView.getId() == 2131377335))
      {
        DataCollector.logEvent("Event_Maillist_Delete_Mail");
        if ((MailListFragment.this.commercialPopularize != null) && (paramInt == NativeAdsHelper.getInstance().getIndexOfExposeAdsItemInMailList())) {
          NativeAdsHelper.getInstance().log(MailListFragment.this.commercialPopularize.getServerId(), "Event_Native_AD_Mail_List_Delete");
        }
        paramView = MailListFragment.this.adapter.getItem(paramInt);
        if ((paramView != null) && (paramView.getInformation() != null))
        {
          if ((MailListFragment.this.folderType != 5) && (MailListFragment.this.folderType != 6)) {
            break label224;
          }
          ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(MailListFragment.this.getActivity()).setTitle(2131697042)).setMessage(2131697043).addAction(2131691246, new MailListFragment.MailListOnRightViewClickListener.2(this))).addAction(0, 2131691840, 2, new MailListFragment.MailListOnRightViewClickListener.1(this, paramView, paramInt))).create().show();
        }
      }
      label224:
      label372:
      while ((paramView == null) || (paramView.getId() != 2131377336))
      {
        return;
        if (MailListFragment.this.folderType == 4)
        {
          if (paramView.getInformation().getSendUtc() > 0L) {}
          for (boolean bool = true; (bool) && (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())); bool = false)
          {
            MailListFragment.this.showAsyncDeleteClockSendMailDialog();
            return;
          }
          int i;
          if (bool)
          {
            i = 2131691551;
            if (!bool) {
              break label372;
            }
          }
          for (int j = 2131691549;; j = 2131692978)
          {
            ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(MailListFragment.this.getActivity()).setTitle(i)).setMessage(j).addAction(2131691246, new MailListFragment.MailListOnRightViewClickListener.4(this))).addAction(0, 2131691840, 2, new MailListFragment.MailListOnRightViewClickListener.3(this, paramView, paramInt, bool))).create().show();
            return;
            i = 2131692977;
            break;
          }
        }
        MailListFragment.this.runInBackground(new MailListFragment.MailListOnRightViewClickListener.5(this, paramView, paramInt));
        return;
      }
      MailListFragment.this.runInBackground(new MailListFragment.MailListOnRightViewClickListener.6(this, paramInt));
    }
  }
  
  public static class NullFolderException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public NullFolderException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment
 * JD-Core Version:    0.7.0.1
 */