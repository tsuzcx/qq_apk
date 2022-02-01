package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.DeleteMailSyncRemoteWatcher;
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
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.base.SaveArgumentField;

public class ConvMailListFragment
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
  private static final int REQUEST_FROM_CONV_MAIL_LIST = 4;
  private static final int REQUEST_FROM_MOVE_MAIL_ACTIVITY = 2;
  public static final String TAG = "ConvMailListFragment";
  @SaveArgumentField
  private int accountId;
  private QMMailListAdapter adapter;
  @SaveArgumentField
  protected long aggregateType;
  private SyncPhotoWatcher avatarWatcher = new ConvMailListFragment.3(this);
  private QMBaseView baseView;
  private HashMap<Integer, Long> checkMap = new HashMap();
  private TextView delButton = null;
  private View.OnClickListener deleteClickEvent = new ConvMailListFragment.19(this);
  private final DeleteMailSyncRemoteWatcher deleteMailSyncRemoteWatcher = new ConvMailListFragment.6(this);
  private final MailDeleteWatcher deleteWatcher = new ConvMailListFragment.9(this);
  @SaveArgumentField
  private int folderId;
  private QMBottomBar footerBar;
  private boolean isEditing = false;
  private boolean isLoading = false;
  private Future<QMMailListCursor> listCursor = null;
  private QMContentLoadingView listEmptyView;
  private ItemScrollListView listView;
  private LoadListWatcher listWatcher = new ConvMailListFragment.1(this);
  private FrameLayout mBottomView;
  private RelativeLayout mContainBottomLayout;
  @SaveArgumentField
  private int mailFlag;
  private MailOperate mailOperate = new MailOperate();
  private TextView markButton = null;
  private View.OnClickListener markClickEvent = new ConvMailListFragment.18(this);
  private TextView moveButton = null;
  private View.OnClickListener moveClickEvent = new ConvMailListFragment.20(this);
  private final MailMoveWatcher movetoWatcher = new ConvMailListFragment.11(this);
  private View.OnClickListener onReloadListener = new ConvMailListFragment.17(this);
  @SaveArgumentField
  private long parentId;
  @SaveArgumentField
  private long[] parentListIds;
  private final MailPurgeDeleteWatcher purgeDeleteWatcher = new ConvMailListFragment.10(this);
  private LoadMailWatcher readMailWatcher = new ConvMailListFragment.4(this);
  private int readState = 0;
  private final MailUnReadWatcher readWatcher = new ConvMailListFragment.8(this);
  private TextView rejectButton = null;
  private View.OnClickListener rejectClickEvent = new ConvMailListFragment.21(this);
  private final MailRejectWatcher rejectWatcher = new ConvMailListFragment.2(this);
  private int starState = 0;
  private final MailStartWatcher starWatcher = new ConvMailListFragment.7(this);
  private final MailTagWatcher tagWatcher = new ConvMailListFragment.12(this);
  
  public ConvMailListFragment(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    super(true);
    this.accountId = paramInt1;
    this.folderId = paramInt2;
    this.parentId = paramLong1;
    this.parentListIds = paramArrayOfLong;
    this.aggregateType = paramLong2;
    paramInt1 = i;
    if (paramInt2 == 110) {
      paramInt1 = 128;
    }
    this.mailFlag = paramInt1;
    setDataSource();
  }
  
  public ConvMailListFragment(int paramInt1, int paramInt2, long paramLong, long[] paramArrayOfLong)
  {
    super(true);
    this.accountId = paramInt1;
    this.folderId = paramInt2;
    this.parentId = paramLong;
    this.parentListIds = paramArrayOfLong;
    paramInt1 = i;
    if (paramInt2 == 110) {
      paramInt1 = 128;
    }
    this.mailFlag = paramInt1;
    setDataSource();
  }
  
  private void doRender()
  {
    if ((getDataSource() == null) || (getDataSource().getCount() < 1))
    {
      renderLoading();
      return;
    }
    renderList();
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
      QMLog.log(6, "ConvMailListFragment", "getDataSource failed. " + localException.toString());
    }
    return null;
  }
  
  private MailOperate getMailOperate()
  {
    return this.mailOperate;
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
          break label79;
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
    label79:
    return true;
  }
  
  private boolean isSelectSystemMail()
  {
    if (getDataSource() != null)
    {
      int k = this.listView.getHeaderViewsCount();
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
          break label105;
        }
        Mail localMail = getDataSource().getItem(j);
        if ((localMail != null) && (localMail.getStatus().isSystemMail()) && (this.listView.isItemChecked(j + k)))
        {
          return true;
          i = this.adapter.getCount();
          break;
        }
        j += 1;
      }
    }
    label105:
    return false;
  }
  
  private void markAllRead()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695662)).setMessage(2131721118).addAction(2131691246, new ConvMailListFragment.25(this))).addAction(2131695664, new ConvMailListFragment.24(this))).create().show();
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
      localBottomListSheetBuilder.setOnSheetItemClickListener(new ConvMailListFragment.23(this));
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
  
  private void markMailPopup(View paramView, int paramInt)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof View))) {
      paramView = (View)paramView.getTag();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (((paramInt & 0x1) == 1) && (!Mail.isAdConv(this.aggregateType)))
      {
        if (this.readState == 0) {
          localArrayList.add(getString(2131695671));
        }
      }
      else
      {
        localArrayList.add(getString(2131695664));
        if (((paramInt & 0x4) == 4) && (getAccountId() != 0)) {
          localArrayList.add(getString(2131720744));
        }
        if ((paramInt & 0x2) == 2)
        {
          if (this.starState != 0) {
            break label245;
          }
          localArrayList.add(getString(2131695669));
        }
      }
      for (;;)
      {
        PopupAdapter localPopupAdapter = new PopupAdapter(getActivity(), 2131559771, 2131373495, localArrayList);
        new ConvMailListFragment.22(this, getActivity(), paramView, localPopupAdapter, localArrayList).show();
        return;
        if (this.readState == 1)
        {
          localArrayList.add(getString(2131695668));
          break;
        }
        if (this.readState != 2) {
          break;
        }
        localArrayList.add(getString(2131695668));
        localArrayList.add(getString(2131695671));
        break;
        label245:
        if (this.starState == 1)
        {
          localArrayList.add(getString(2131695672));
        }
        else if (this.starState == 2)
        {
          localArrayList.add(getString(2131695669));
          localArrayList.add(getString(2131695672));
        }
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
    int i = getAccountId();
    long[] arrayOfLong = getSelectedMailIds();
    if (this.parentId == 0L) {}
    for (boolean bool = false;; bool = true)
    {
      startActivityForResult(TagMailActivity.createIntent(i, arrayOfLong, bool), 3);
      return;
    }
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
  
  private void operationDone()
  {
    if (getDataSource() == null) {
      return;
    }
    runInBackground(new ConvMailListFragment.5(this));
  }
  
  private void pullToBack()
  {
    super.onButtonBackClick();
  }
  
  private void readMail(Mail paramMail)
  {
    ReadMailFragment localReadMailFragment = new ReadMailFragment(this.folderId, paramMail.getInformation().getId(), this.parentId, this.aggregateType, getDataSource().getItemIdsInFuture(), this.parentListIds);
    ((ReadMailFragment)localReadMailFragment).reuseMailData(paramMail);
    startFragmentForResult(localReadMailFragment, 4);
    DataCollector.logPerformanceBegin("Performance_List_Read_Mail", this.accountId, "Performance_List_Read_Mail" + MailListFragment.listReadMailBeginTime);
    QMLog.log(4, "ConvMailListFragment", "read mail logPerformanceBegin key:" + MailListFragment.listReadMailBeginTime + ", time:" + MailListFragment.listReadMailBeginTime);
  }
  
  private void refreshBottomBar()
  {
    boolean bool2 = true;
    boolean bool1;
    label65:
    TextView localTextView;
    if (getSelectedMailIds().length > 0)
    {
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
        if ((!bool1) || (isSelectSystemMail())) {
          break label107;
        }
        ((TextView)localObject).setEnabled(bool2);
      }
      if (this.markButton != null)
      {
        localTextView = this.markButton;
        if (!bool1) {
          break label112;
        }
      }
    }
    label107:
    label112:
    for (Object localObject = getString(2131695666);; localObject = getString(2131695662))
    {
      localTextView.setText((CharSequence)localObject);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label65;
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
      localQMTopBar.setButtonLeftOnclickListener(new ConvMailListFragment.15(this));
      localQMTopBar.setButtonRightOnclickListener(new ConvMailListFragment.16(this));
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
    if (this.adapter != null)
    {
      this.adapter.notifyDataSetChanged();
      return;
    }
    this.adapter = new QMMailListAdapter(getActivity(), 0, getDataSource(), this.listView);
    this.adapter.setMoreLoadingState(-1);
    this.listView.setAdapter(this.adapter);
    this.adapter.setWhichRightViewShow(new boolean[] { 1, 0 });
  }
  
  private void renderLoading()
  {
    this.isLoading = true;
    this.listEmptyView.showLoading(true);
    this.mContainBottomLayout.setVisibility(8);
  }
  
  private void renderTitle()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (localQMTopBar == null) {}
    do
    {
      return;
      localQMTopBar.setTitle(getString(2131692321));
    } while (this.parentId == 0L);
    int i = QMMailManager.sharedInstance().getConvUnreadCount(this.parentId);
    if (i > 0) {}
    for (String str = "(" + i + ")";; str = null)
    {
      localQMTopBar.setTitleSec(str);
      return;
    }
  }
  
  private void renderTitleForEditMode()
  {
    if (this.checkMap.size() < 1)
    {
      getTopBar().setTitle(2131695646);
      return;
    }
    getTopBar().setTitle(String.format(getString(2131695642), new Object[] { Integer.valueOf(this.checkMap.size()) }));
  }
  
  private void setAllSelectState(boolean paramBoolean)
  {
    int i = 0;
    int j = this.listView.getHeaderViewsCount();
    int k;
    if (paramBoolean)
    {
      refreshSelectedButton(true);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        k = this.adapter.getCount();
        while (i < k)
        {
          if (!this.listView.isItemChecked(i + j)) {
            this.listView.setItemChecked(i + j, true);
          }
          this.checkMap.put(Integer.valueOf(i), Long.valueOf(this.adapter.getItem(i).getInformation().getId()));
          i += 1;
        }
        setEditingSelectItemType();
      }
    }
    for (;;)
    {
      refreshBottomBar();
      renderTitleForEditMode();
      return;
      refreshSelectedButton(false);
      if ((getDataSource() != null) && (this.adapter != null))
      {
        k = this.adapter.getCount();
        i = 0;
        while (i < k)
        {
          if (this.listView.isItemChecked(i + j)) {
            this.listView.setItemChecked(i + j, false);
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
    this.listCursor = Threads.submitTask(new ConvMailListFragment.13(this));
  }
  
  private void setEditingSelectItemType()
  {
    int i;
    int j;
    int m;
    int k;
    if (this.checkMap.size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label246;
      }
      Iterator localIterator = this.checkMap.keySet().iterator();
      j = 0;
      i = 0;
      m = 0;
      k = 0;
      label39:
      if (!localIterator.hasNext()) {
        break label257;
      }
      MailStatus localMailStatus = getDataSource().getItem(((Integer)localIterator.next()).intValue()).getStatus();
      boolean bool1 = localMailStatus.isUnread();
      boolean bool2 = localMailStatus.isStarred();
      if (!bool1) {
        break label156;
      }
      k = 1;
      label97:
      if (!bool2) {
        break label162;
      }
      i = j;
      j = 1;
      label106:
      if ((k == 0) || (m == 0) || (j == 0) || (i == 0)) {
        break label173;
      }
    }
    for (;;)
    {
      if ((k == 0) && (m != 0))
      {
        this.readState = 0;
        label137:
        if ((i == 0) || (j != 0)) {
          break label218;
        }
        this.starState = 0;
      }
      label156:
      label162:
      label173:
      label218:
      do
      {
        return;
        i = 0;
        break;
        m = 1;
        break label97;
        n = 1;
        j = i;
        i = n;
        break label106;
        n = j;
        j = i;
        i = n;
        break label39;
        if ((k != 0) && (m == 0))
        {
          this.readState = 1;
          break label137;
        }
        if ((k == 0) || (m == 0)) {
          break label137;
        }
        this.readState = 2;
        break label137;
        if ((i == 0) && (j != 0))
        {
          this.starState = 1;
          return;
        }
      } while ((i == 0) || (j == 0));
      this.starState = 2;
      return;
      label246:
      this.readState = 0;
      this.starState = 0;
      return;
      label257:
      int n = i;
      i = j;
      j = n;
    }
  }
  
  private void setListViewItemEventListener()
  {
    if (this.listView == null)
    {
      QMLog.log(6, "ConvMailListFragment", "addListViewItemEventListener listview is null");
      return;
    }
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    this.listView.setOnItemClickListener(new ConvMailListFragment.26(this));
    this.listView.setOnItemLongClickListener(new ConvMailListFragment.27(this, arrayOfBoolean));
    this.listView.setOnTouchListener(new ConvMailListFragment.28(this, arrayOfBoolean));
    this.listView.setOnRightViewClickListener(new ConvMailListFragment.29(this));
  }
  
  private void toggleEditingState()
  {
    if ((this.isLoading) || (this.isEditing)) {
      return;
    }
    this.isEditing = true;
    this.checkMap.clear();
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
    this.isEditing = false;
    this.checkMap.clear();
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
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
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
      operationDone();
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      return;
    }
    setAllSelectState(false);
    this.checkMap.clear();
    operationDone();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.deleteMailSyncRemoteWatcher, paramBoolean);
    Watchers.bind(this.listWatcher, paramBoolean);
    Watchers.bind(this.readMailWatcher, paramBoolean);
    Watchers.bind(this.readWatcher, paramBoolean);
    Watchers.bind(this.purgeDeleteWatcher, paramBoolean);
    Watchers.bind(this.starWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.movetoWatcher, paramBoolean);
    Watchers.bind(this.tagWatcher, paramBoolean);
    Watchers.bind(this.rejectWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
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
    if ((paramInt == 4) && (this.isEditing))
    {
      toggleNormalState();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Object onLastFragmentFinish()
  {
    try
    {
      MailListFragment localMailListFragment = new MailListFragment(getAccountId(), this.folderId);
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
      ListViewHelper.getNextUnread(this.listView, getDataSource(), new ConvMailListFragment.14(this));
      return;
    }
    super.onTopBarCenterClick();
  }
  
  public int refreshData()
  {
    getDataSource().refresh(true, null);
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
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment
 * JD-Core Version:    0.7.0.1
 */