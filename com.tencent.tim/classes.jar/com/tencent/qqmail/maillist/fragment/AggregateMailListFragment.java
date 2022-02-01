package com.tencent.qqmail.maillist.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.activity.tagmail.TagMailActivity;
import com.tencent.qqmail.animation.SynchronousAnimator;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadMailWatcher;
import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.AdvertiseFilter;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.popularize.view.PopularizeMailListItemView;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.SaveArgumentField;

public class AggregateMailListFragment
  extends MailFragment
{
  private static final int BUTTON_ITEM_DEL = 32;
  private static final int BUTTON_ITEM_MARK = 16;
  private static final int BUTTON_ITEM_MOVE = 64;
  private static final int BUTTON_ITEM_REJECT = 128;
  private static final int CLEAR_ALL_SELECT_TAG = 3;
  private static final int MENU_ITEM_READ = 1;
  private static final int MENU_ITEM_STAR = 2;
  private static final int MENU_ITEM_TAG = 4;
  private static final int REQUEST_FROM_MOVE_MAIL_ACTIVITY = 2;
  private static final String TAG = "AdMailListFragment";
  @SaveArgumentField
  private int accountId;
  private AggregateMailListAdapter adapter;
  @SaveArgumentField
  private long aggregateType;
  private SyncPhotoWatcher avatarWatcher = new AggregateMailListFragment.3(this);
  private QMBaseView baseView;
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Long> checkMap = new HashMap();
  @SuppressLint({"UseSparseArrays"})
  private HashMap<Integer, Integer> checkPopualrizeMap = new HashMap();
  private TextView delButton = null;
  private View.OnClickListener deleteClickEvent = new AggregateMailListFragment.23(this);
  private final MailDeleteWatcher deleteWatcher = new AggregateMailListFragment.8(this);
  private QMBottomBar footerBar;
  boolean hasScollDeleteMail = false;
  boolean isCancelPopularizeAnimationComplete = false;
  boolean isCancelPopularizeAnimationStart = false;
  boolean isDeleteMailAnimationComplete = false;
  boolean isDeleteMailAnimationStart = false;
  private boolean isEditing = false;
  private boolean isLoading = false;
  private boolean isLogPopularize = false;
  private boolean isPreloaded = true;
  private Future<QMMailListCursor> listCursor = null;
  private QMContentLoadingView listEmptyView;
  private ItemScrollListView listView;
  private LoadListWatcher listWatcher = new AggregateMailListFragment.1(this);
  private FrameLayout mBottomView;
  private RelativeLayout mContainBottomLayout;
  private MailOperate mailOperate = new MailOperate();
  private TextView markButton = null;
  private View.OnClickListener markClickEvent = new AggregateMailListFragment.22(this);
  private TextView moveButton = null;
  private View.OnClickListener moveClickEvent = new AggregateMailListFragment.25(this);
  private final MailMoveWatcher movetoWatcher = new AggregateMailListFragment.10(this);
  private View.OnClickListener onReloadListener = new AggregateMailListFragment.21(this);
  private PopularizeBanner popularizeBanner;
  private final int popularizePage;
  private final MailPurgeDeleteWatcher purgeDeleteWatcher = new AggregateMailListFragment.9(this);
  private LoadMailWatcher readMailWatcher = new AggregateMailListFragment.4(this);
  private int readState = 0;
  private final MailUnReadWatcher readWatcher = new AggregateMailListFragment.7(this);
  private TextView rejectButton = null;
  private View.OnClickListener rejectClickEvent = new AggregateMailListFragment.26(this);
  private final MailRejectWatcher rejectWatcher = new AggregateMailListFragment.2(this);
  private int starState = 0;
  private final MailStartWatcher starWatcher = new AggregateMailListFragment.6(this);
  private SynchronousAnimator synchronousAnimator = new AggregateMailListFragment.24(this);
  private final MailTagWatcher tagWatcher = new AggregateMailListFragment.11(this);
  
  public AggregateMailListFragment(int paramInt, long paramLong)
  {
    super(true);
    this.accountId = paramInt;
    this.aggregateType = paramLong;
    if (Mail.isAdConv(paramLong)) {}
    for (this.popularizePage = 1;; this.popularizePage = -1)
    {
      setDataSource();
      return;
    }
  }
  
  private void doRender()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() < 1)) {
      renderLoading();
    }
    do
    {
      return;
      renderList();
    } while ((this.adapter.getPopularizedCount() <= 0) || (this.isLogPopularize));
    if (Mail.isAdConv(this.aggregateType))
    {
      Iterator localIterator = this.adapter.getPopularizedData().iterator();
      while (localIterator.hasNext())
      {
        Popularize localPopularize = (Popularize)localIterator.next();
        DataCollector.logEvent("Event_Admail_popularize_Show");
        if (localPopularize != null)
        {
          DataCollector.logDetailEvent("DetailEvent_Admail_Popularize_Show", 0L, 0L, localPopularize.getReportId() + "");
          DataCollector.logDetailEventWithDetailMessage("DetailEvent_Admail_Popularize_Show", localPopularize.getReportId() + "", 0L, 0L, localPopularize.getReportId() + "");
        }
        DataCollector.submit();
      }
    }
    this.isLogPopularize = true;
  }
  
  private int getAccountId()
  {
    return this.accountId;
  }
  
  private IMailListCursor getDataSource()
  {
    try
    {
      if (this.listCursor != null)
      {
        IMailListCursor localIMailListCursor = (IMailListCursor)this.listCursor.get();
        return localIMailListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "AdMailListFragment", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private MailOperate getMailOperate()
  {
    return this.mailOperate;
  }
  
  private int[] getSelectPopularizeIds()
  {
    int[] arrayOfInt = new int[this.checkPopualrizeMap.size()];
    Iterator localIterator = this.checkPopualrizeMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      arrayOfInt[i] = ((Integer)this.checkPopualrizeMap.get(localInteger)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private long[] getSelectedMailIds()
  {
    long[] arrayOfLong = new long[this.checkMap.size()];
    Iterator localIterator = this.checkMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      arrayOfLong[i] = ((Long)this.checkMap.get(localInteger)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  private HashSet<String> getSelectedUsers()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.checkMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashSet.add(getDataSource().getItem(localInteger.intValue()).getInformation().getFrom().getName());
    }
    return localHashSet;
  }
  
  private void initBottomBar(int paramInt)
  {
    QMBottomBar localQMBottomBar = this.footerBar;
    if ((paramInt & 0x10) == 16) {
      this.markButton = localQMBottomBar.addButton(0, getString(2131695662), this.markClickEvent);
    }
    if ((paramInt & 0x20) == 32) {
      this.delButton = localQMBottomBar.addButton(1, getString(2131692498), this.deleteClickEvent);
    }
    if (getAccountId() != 0)
    {
      if ((paramInt & 0x40) == 64) {
        this.moveButton = localQMBottomBar.addButton(0, getString(2131696005), this.moveClickEvent);
      }
      if (((paramInt & 0x80) == 128) && (AccountManager.shareInstance().getAccountList().getAccountById(getAccountId()).isQQMail())) {
        this.rejectButton = localQMBottomBar.addButton(0, getString(2131718728), this.rejectClickEvent);
      }
    }
  }
  
  private void initListView()
  {
    this.popularizeBanner.render(this.listView, false);
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(this.popularizePage);
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
        label39:
        if (j >= i) {
          break label91;
        }
        if (this.adapter.getItemViewType(j) != 3) {
          break label74;
        }
      }
      label74:
      while (this.listView.isItemChecked(j + k))
      {
        j += 1;
        break label39;
        i = this.adapter.getCount();
        break;
      }
      return false;
    }
    else
    {
      return false;
    }
    label91:
    return true;
  }
  
  private boolean isSelectSystemMail()
  {
    if (getDataSource() != null)
    {
      int k = this.listView.getHeaderViewsCount();
      int m = this.adapter.getPopularizedCount();
      int i;
      int j;
      if (getDataSource().canLoadMore())
      {
        i = this.adapter.getCount() - 1;
        j = 0;
      }
      for (;;)
      {
        if (j >= i - m) {
          break label120;
        }
        Mail localMail = getDataSource().getItem(j);
        if ((localMail != null) && (localMail.getStatus().isSystemMail()) && (this.listView.isItemChecked(j + k + m)))
        {
          return true;
          i = this.adapter.getCount();
          break;
        }
        j += 1;
      }
    }
    label120:
    return false;
  }
  
  private boolean isTencentAccount()
  {
    Account localAccount = null;
    if (this.accountId != 0) {
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    }
    return (localAccount != null) && (localAccount.getEmail().contains("@tencent.com"));
  }
  
  private boolean isToppedAdItem(View paramView)
  {
    if (((paramView instanceof MailListItemView)) && (((MailListItemView)paramView).getItemData().isToppedAd)) {
      return true;
    }
    return ((paramView instanceof HorizontalScrollItemView)) && ((((HorizontalScrollItemView)paramView).getContentView() instanceof MailListItemView)) && (((MailListItemView)((HorizontalScrollItemView)paramView).getContentView()).getItemData().isToppedAd);
  }
  
  private void markAllMailRead()
  {
    Threads.runInBackground(new AggregateMailListFragment.15(this));
  }
  
  private void markAllRead()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695662)).setMessage(2131721118).addAction(2131691246, new AggregateMailListFragment.29(this))).addAction(2131695664, new AggregateMailListFragment.28(this))).create().show();
  }
  
  private void markCommercialAdRead()
  {
    Threads.runInBackground(new AggregateMailListFragment.16(this));
  }
  
  private void markMailPopup(int paramInt)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (((paramInt & 0x1) == 1) && (!Mail.isAdConv(this.aggregateType)))
    {
      if (this.readState == 0) {
        localBottomListSheetBuilder.addItem(2130840825, getString(2131695671), getString(2131695671));
      }
    }
    else
    {
      localBottomListSheetBuilder.addItem(2130840822, getString(2131695664), getString(2131695664));
      if (((paramInt & 0x4) == 4) && (getAccountId() != 0)) {
        localBottomListSheetBuilder.addItem(2130840841, getString(2131720744), getString(2131720744));
      }
      if ((paramInt & 0x2) == 2)
      {
        if (this.starState != 0) {
          break label253;
        }
        localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
      }
    }
    for (;;)
    {
      localBottomListSheetBuilder.setOnSheetItemClickListener(new AggregateMailListFragment.27(this));
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
      label253:
      if (this.starState == 1)
      {
        localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
      }
      else if (this.starState == 2)
      {
        localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
        localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
      }
    }
  }
  
  private void markRead()
  {
    if ((!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showSuccess(2131695646, 700L);
      return;
    }
    this.mailOperate.unreadMail(getSelectedMailIds(), false, false);
  }
  
  private void markStar()
  {
    if ((!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showSuccess(2131695646, 700L);
      return;
    }
    this.mailOperate.starMail(getSelectedMailIds(), true);
  }
  
  private void markTag()
  {
    if ((!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showSuccess(2131695646, 700L);
      return;
    }
    startActivityForResult(TagMailActivity.createIntent(getAccountId(), getSelectedMailIds(), true), 3);
  }
  
  private void markUnStar()
  {
    if ((!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showSuccess(2131695646, 700L);
      return;
    }
    this.mailOperate.starMail(getSelectedMailIds(), false);
  }
  
  private void markUnread()
  {
    if ((!this.isEditing) || (this.isLoading)) {
      return;
    }
    if ((this.checkMap == null) || (this.checkMap.isEmpty()))
    {
      getTips().showSuccess(2131695646, 700L);
      return;
    }
    this.mailOperate.unreadMail(getSelectedMailIds(), true, false);
  }
  
  private void onClickPopularizeItem(PopularizeMailListItemView paramPopularizeMailListItemView, int paramInt)
  {
    paramPopularizeMailListItemView = this.adapter.getPopularizedData(paramInt);
    if (this.isEditing)
    {
      int i = this.listView.getHeaderViewsCount();
      if (!this.checkPopualrizeMap.containsKey(Integer.valueOf(paramInt)))
      {
        this.checkPopualrizeMap.put(Integer.valueOf(paramInt), Integer.valueOf(paramPopularizeMailListItemView.getId()));
        this.listView.setItemChecked(i + paramInt, true);
      }
      for (;;)
      {
        refreshBottomBar();
        renderTitleForEditMode();
        refreshSelectedButton(isSelectAll());
        return;
        this.checkPopualrizeMap.remove(Integer.valueOf(paramInt));
        this.listView.setItemChecked(i + paramInt, false);
      }
    }
    PopularizeUIHelper.handleAction(getActivity(), paramPopularizeMailListItemView, new AggregateMailListFragment.17(this));
  }
  
  private void onLongClickPopularizeItem(PopularizeMailListItemView paramPopularizeMailListItemView, int paramInt)
  {
    if (this.isEditing) {
      return;
    }
    toggleEditingState();
    this.adapter.getPopularizedData(paramInt);
    int i = this.listView.getHeaderViewsCount();
    this.listView.setItemChecked(i + paramInt, true);
    refreshBottomBar();
    renderTitleForEditMode();
  }
  
  private void operationDone()
  {
    getDataSource().refresh(true, new AggregateMailListFragment.5(this));
  }
  
  private void pullToBack()
  {
    super.onButtonBackClick();
  }
  
  private void readMail(Mail paramMail)
  {
    if (paramMail == null)
    {
      QMLog.log(5, "AdMailListFragment", "readMail mail == null");
      ValidateHelper.assertInDebug("readMail, mail == null ", false);
      return;
    }
    if (paramMail.getStatus().isConversation()) {}
    ReadMailFragment localReadMailFragment;
    for (paramMail = new ConvMailListFragment(this.accountId, paramMail.getInformation().getFolderId(), paramMail.getInformation().getId(), this.aggregateType, getDataSource().getItemIds());; paramMail = localReadMailFragment)
    {
      startFragment(paramMail);
      return;
      localReadMailFragment = new ReadMailFragment(0, paramMail.getInformation().getId(), this.aggregateType, getDataSource().getItemIdsInFuture());
      ((ReadMailFragment)localReadMailFragment).reuseMailData(paramMail);
    }
  }
  
  private void refreshBottomBar()
  {
    boolean bool3 = false;
    int i;
    if (getSelectPopularizeIds().length > 0)
    {
      i = 1;
      if (i == 0) {
        break label97;
      }
      if (this.delButton != null) {
        this.delButton.setEnabled(true);
      }
      if (this.moveButton != null) {
        this.moveButton.setEnabled(false);
      }
      if (this.rejectButton != null) {
        this.rejectButton.setEnabled(false);
      }
      if (this.markButton != null)
      {
        this.markButton.setEnabled(false);
        this.markButton.setText(getString(2131695666));
      }
    }
    label97:
    boolean bool1;
    do
    {
      return;
      i = 0;
      break;
      if (getSelectedMailIds().length <= 0) {
        break label217;
      }
      bool1 = true;
      if (this.delButton != null) {
        this.delButton.setEnabled(bool1);
      }
      if (this.moveButton != null) {
        this.moveButton.setEnabled(bool1);
      }
      if (this.rejectButton != null)
      {
        localObject = this.rejectButton;
        boolean bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (!isSelectSystemMail()) {
            bool2 = true;
          }
        }
        ((TextView)localObject).setEnabled(bool2);
      }
    } while (this.markButton == null);
    this.markButton.setEnabled(true);
    TextView localTextView = this.markButton;
    if (bool1) {}
    for (Object localObject = getString(2131695666);; localObject = getString(2131695662))
    {
      localTextView.setText((CharSequence)localObject);
      return;
      label217:
      bool1 = false;
      break;
    }
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
      View localView = localQMTopBar.getButtonRight();
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    for (;;)
    {
      localQMTopBar.setButtonLeftOnclickListener(new AggregateMailListFragment.18(this));
      localQMTopBar.setButtonRightOnclickListener(new AggregateMailListFragment.19(this));
      return;
      localQMTopBar.setButtonLeftNormal(2131719469);
      localQMTopBar.setButtonRightBlue(2131691246);
      localQMTopBar.getButtonRight().setVisibility(0);
    }
  }
  
  private void renderError()
  {
    this.isLoading = false;
    DataCollector.logException(7, 1, "Event_Error", getString(2131695607), true);
    this.listEmptyView.showTipsReload(2131695607, this.onReloadListener);
    this.mContainBottomLayout.setVisibility(8);
  }
  
  private void renderList()
  {
    this.isLoading = false;
    this.mContainBottomLayout.setVisibility(0);
    this.listEmptyView.hide();
    Object localObject = PopularizeManager.sharedInstance().getPopularize(new AdvertiseFilter(new AggregateMailListFragment.20(this)));
    if (((ArrayList)localObject).size() == 0) {
      localObject = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(2, this.popularizePage));
    }
    for (;;)
    {
      int i;
      if (this.adapter != null)
      {
        this.adapter.setPopularize((ArrayList)localObject, this.popularizePage);
        this.adapter.notifyDataSetChanged();
        this.popularizeBanner.render(this.listView, false);
        i = 0;
      }
      for (;;)
      {
        if (i < this.adapter.getCount())
        {
          localObject = this.adapter.getItem(i);
          if ((localObject != null) && (((Mail)localObject).getStatus().isUnread()) && (((Mail)localObject).getStatus().getToppedAdTime() > 0L) && (new Date().getTime() < ((Mail)localObject).getStatus().getToppedAdTime() * 1000L)) {
            DataCollector.logEvent("Event_Effect_Admail_Show");
          }
        }
        else
        {
          return;
          DataCollector.logEvent("Event_AD_Mail_Show");
          Iterator localIterator = ((ArrayList)localObject).iterator();
          while (localIterator.hasNext())
          {
            Popularize localPopularize = (Popularize)localIterator.next();
            NativeAdsHelper.getInstance().log(localPopularize.getServerId(), "Event_AD_Mail_Show");
          }
          this.adapter = new AggregateMailListAdapter(getActivity(), 0, getDataSource(), this.listView);
          this.adapter.setWhichRightViewShow(new boolean[] { 1, 0 });
          this.adapter.setMoreLoadingState(-1);
          this.adapter.setPopularize((ArrayList)localObject, this.popularizePage);
          this.listView.setAdapter(this.adapter);
          break;
        }
        i += 1;
      }
    }
  }
  
  private void renderLoading()
  {
    this.isLoading = true;
    this.listEmptyView.showLoading(true);
    this.mContainBottomLayout.setVisibility(8);
  }
  
  private void renderTitle()
  {
    int j = 2131693930;
    if (getActivity() != null)
    {
      int i = j;
      if (Mail.isAdConv(this.aggregateType))
      {
        i = j;
        if (isTencentAccount()) {
          i = 2131693931;
        }
      }
      getTopBar().setTitle(getActivity().getResources().getString(i));
    }
  }
  
  private void renderTitleForEditMode()
  {
    if (this.checkMap.size() + this.checkPopualrizeMap.size() < 1)
    {
      getTopBar().setTitle(2131695646);
      return;
    }
    getTopBar().setTitle(String.format(getString(2131695642), new Object[] { Integer.valueOf(this.checkMap.size() + this.checkPopualrizeMap.size()) }));
  }
  
  private void setAllSelectState(boolean paramBoolean)
  {
    int j = 0;
    int k = this.listView.getHeaderViewsCount();
    int m = this.adapter.getPopularizedCount();
    int i;
    if (paramBoolean)
    {
      refreshSelectedButton(true);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        int n = this.adapter.getCount();
        i = 0;
        while (i < n - m)
        {
          if (!this.listView.isItemChecked(i + k + m)) {
            this.listView.setItemChecked(i + k + m, true);
          }
          this.checkMap.put(Integer.valueOf(i), Long.valueOf(this.adapter.getItem(i + m).getInformation().getId()));
          i += 1;
        }
        ArrayList localArrayList = this.adapter.getPopularizedData();
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = j;
          while (i < localArrayList.size())
          {
            if (!this.listView.isItemChecked(i + k)) {
              this.listView.setItemChecked(i + k, true);
            }
            i += 1;
          }
        }
        setEditingSelectItemType();
      }
    }
    for (;;)
    {
      this.checkPopualrizeMap.clear();
      refreshBottomBar();
      renderTitleForEditMode();
      return;
      refreshSelectedButton(false);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        j = this.adapter.getCount();
        i = 0;
        while (i < j)
        {
          if (this.listView.isItemChecked(i + k)) {
            this.listView.setItemChecked(i + k, false);
          }
          i += 1;
        }
        setEditingSelectItemType();
      }
      this.checkMap.clear();
    }
  }
  
  private void setDataSource()
  {
    this.listCursor = Threads.submitTask(new AggregateMailListFragment.12(this));
    Threads.runInBackground(new AggregateMailListFragment.13(this));
  }
  
  private void setEditingSelectItemType()
  {
    int i;
    int m;
    int k;
    int j;
    int n;
    if (this.checkMap.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label274;
      }
      Iterator localIterator = this.checkMap.keySet().iterator();
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (getDataSource() != null)
          {
            Object localObject = getDataSource().getItem(((Integer)localIterator.next()).intValue());
            if (localObject != null)
            {
              localObject = ((Mail)localObject).getStatus();
              boolean bool1 = ((MailStatus)localObject).isUnread();
              boolean bool2 = ((MailStatus)localObject).isStarred();
              if (bool1)
              {
                n = 1;
                label114:
                if (!bool2) {
                  break label188;
                }
                i = m;
                k = 1;
                label124:
                if ((n == 0) || (j == 0) || (k == 0) || (i == 0)) {
                  break label193;
                }
                m = k;
                k = i;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((n == 0) && (j != 0))
      {
        this.readState = 0;
        label160:
        if ((k == 0) || (m != 0)) {
          break label244;
        }
        this.starState = 0;
        label174:
        return;
        i = 0;
        break;
        j = 1;
        n = i;
        break label114;
        label188:
        i = 1;
        break label124;
      }
      label193:
      for (m = n;; m = n)
      {
        n = m;
        m = i;
        i = n;
        break;
        if ((n != 0) && (j == 0))
        {
          this.readState = 1;
          break label160;
        }
        if ((n == 0) || (j == 0)) {
          break label160;
        }
        this.readState = 2;
        break label160;
        label244:
        if ((k == 0) && (m != 0))
        {
          this.starState = 1;
          return;
        }
        if ((k == 0) || (m == 0)) {
          break label174;
        }
        this.starState = 2;
        return;
        this.readState = 0;
        this.starState = 0;
        return;
        n = i;
        i = m;
      }
      label274:
      n = k;
      k = m;
      m = n;
      n = i;
    }
  }
  
  private void setListViewItemEventListener()
  {
    if (this.listView == null)
    {
      QMLog.log(6, "AdMailListFragment", "addListViewItemEventListener listview is null");
      return;
    }
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    this.listView.setOnItemClickListener(new AggregateMailListFragment.30(this));
    this.listView.setOnItemLongClickListener(new AggregateMailListFragment.31(this, arrayOfBoolean));
    this.listView.setOnTouchListener(new AggregateMailListFragment.32(this, arrayOfBoolean));
    this.listView.setOnRightViewClickListener(new AggregateMailListFragment.33(this));
  }
  
  private void toggleEditingState()
  {
    if ((this.isLoading) || (this.isEditing)) {
      return;
    }
    this.isEditing = true;
    this.checkMap.clear();
    this.checkPopualrizeMap.clear();
    this.listView.setChoiceMode(2);
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
      renderTitle();
      refreshBottomBar();
      this.footerBar.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131297365));
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mBottomView.setVisibility(8);
      return;
    }
  }
  
  private void toggleNormalState()
  {
    Log.d("AdMailListFragment", "toggleNormalState: " + this.adapter);
    this.isEditing = false;
    this.checkMap.clear();
    this.checkPopualrizeMap.clear();
    setAllSelectState(false);
    this.listView.setChoiceMode(0);
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
      renderTitle();
      refreshBottomBar();
      this.footerBar.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
      return;
    }
  }
  
  public void initDataSource()
  {
    if (Mail.isAdConv(this.aggregateType)) {
      DataCollector.logEvent("Event_Enter_AD");
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initPopularizeBannerView();
    initTopBar();
    initListView();
    initBottomBar(240);
    setListViewItemEventListener();
    ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.listEmptyView = this.baseView.addListEmptyView();
    this.mContainBottomLayout = ThirdPartyCallDialogHelpler.initLayout(this.baseView, false, this.mContainBottomLayout);
    this.listView = ThirdPartyCallDialogHelpler.initListView(this.mContainBottomLayout, this.listView);
    this.mBottomView = ThirdPartyCallDialogHelpler.initBottomview(this.mContainBottomLayout, this.mBottomView);
    this.footerBar = new QMBottomBar(getActivity());
    this.footerBar.setVisibility(8);
    this.baseView.addView(this.footerBar);
    return this.baseView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 3) && (paramInt2 == 1001))
    {
      setAllSelectState(false);
      this.checkMap.clear();
      this.checkPopualrizeMap.clear();
      operationDone();
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      return;
    }
    setAllSelectState(false);
    this.checkMap.clear();
    this.checkPopualrizeMap.clear();
    operationDone();
  }
  
  public void onBackPressed()
  {
    markAllMailRead();
    markCommercialAdRead();
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    this.isLogPopularize = false;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.listWatcher, paramBoolean);
    Watchers.bind(this.readMailWatcher, paramBoolean);
    Watchers.bind(this.readWatcher, paramBoolean);
    Watchers.bind(this.purgeDeleteWatcher, paramBoolean);
    Watchers.bind(this.starWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.movetoWatcher, paramBoolean);
    Watchers.bind(this.tagWatcher, paramBoolean);
    Watchers.bind(this.rejectWatcher, paramBoolean);
    Watchers.bind(this.avatarWatcher, paramBoolean);
  }
  
  public void onButtonBackClick()
  {
    markAllMailRead();
    markCommercialAdRead();
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (!this.isEditing) && (this.listView.isFold());
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    getDataSource().refresh(null);
    if (getDataSource().getCount() <= 1) {
      pullToBack();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.isEditing) {
        toggleNormalState();
      }
      for (;;)
      {
        return true;
        onButtonBackClick();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Object onLastFragmentFinish()
  {
    try
    {
      MailListFragment localMailListFragment = new MailListFragment(getAccountId(), 0);
      return localMailListFragment;
    }
    catch (MailListFragment.NullFolderException localNullFolderException) {}
    return super.onLastFragmentFinish();
  }
  
  public void onRelease()
  {
    this.adapter = null;
    if (getDataSource() != null) {
      getDataSource().close();
    }
    this.listView.setAdapter(null);
  }
  
  public void onTopBarCenterClick()
  {
    if (getDataSource() != null)
    {
      ListViewHelper.getNextUnread(this.listView, getDataSource(), new AggregateMailListFragment.14(this));
      return;
    }
    super.onTopBarCenterClick();
  }
  
  public int refreshData()
  {
    if (!this.isPreloaded) {
      getDataSource().refresh(true, null);
    }
    this.isPreloaded = false;
    if ((getDataSource() != null) && (getDataSource().getCount() == 0))
    {
      if (Mail.isAdConv(this.aggregateType)) {
        QMMailManager.sharedInstance().updateAdvertiseEntrance(this.accountId);
      }
      super.onButtonBackClick();
    }
    return 0;
  }
  
  public void render(int paramInt)
  {
    renderTitle();
    doRender();
    if (getDataSource() != null) {
      getDataSource().popIn();
    }
    ThirdPartyCallDialogHelpler.showBottomView(this.mBottomView, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment
 * JD-Core Version:    0.7.0.1
 */