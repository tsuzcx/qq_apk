package com.tencent.qqmail.sendmaillist;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.calendar.view.DataPickerViewGroup;
import com.tencent.qqmail.calendar.view.PopupFrame;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.task.QMTask.QMTaskState;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeState;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.view.ClockedMailHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Collections;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;

public class SendMailListFragment
  extends MailFragment
{
  public static final String ARG_ACCOUNT_ID = "accountId";
  public static final String ARG_CANCEL_FAIL_MAIL = "arg_cancel_fail_mail";
  public static final String ARG_IS_CANCEL_FAIL = "arg_is_cancel_fail";
  private static final long FIVE_MINUTE = 18000L;
  public static final String TAG = "SendMailListFragment";
  private QMBaseView baseView;
  private float currentX = 0.0F;
  private float currentY = 0.0F;
  private QMGetVerifyImageWatcher getVerifyImageWatcher = new SendMailListFragment.1(this);
  private boolean isFinish = false;
  private int lastIndex = -1;
  private int lastTop = -1;
  private PopupFrame popupFrame;
  public IObserver refreshSendMailIObserver = new IObserver(new SendMailListFragment.3(this));
  public IObserver refreshSendProgressIObserver = new IObserver(new SendMailListFragment.4(this));
  private ItemScrollListView sendMailList;
  private SendMailListAdapter sendMailListAdapter;
  private ArrayList<QMTask> sendMailTaskList = null;
  private QMVerifyImageDialog verifyDialog;
  
  public SendMailListFragment()
  {
    super(false);
  }
  
  private boolean composeMailInSending(ComposeMailUI paramComposeMailUI)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateReady) || (paramComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateWaiting) || (paramComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateSending)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramComposeMailUI.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceled);
      bool1 = bool2;
    } while (paramComposeMailUI.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateFail);
    return false;
  }
  
  private void deleteMail(QMSendMailTask paramQMSendMailTask)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(localFragmentActivity).setTitle(2131692498)).setMessage(2131719524).addAction(2131691246, new SendMailListFragment.9(this))).addAction(0, 2131691840, 2, new SendMailListFragment.8(this, paramQMSendMailTask))).create().show();
  }
  
  private void edit(int paramInt)
  {
    ComposeMailUI localComposeMailUI = getMailByTaskId(paramInt);
    if (localComposeMailUI != null)
    {
      localComposeMailUI.setSendRequest(null);
      startActivity(ComposeMailActivity.createIntentToEditMail(localComposeMailUI.toString(), paramInt));
    }
  }
  
  private ComposeMailUI getMailByTaskId(int paramInt)
  {
    ArrayList localArrayList = getSendMailTaskList(false);
    int i = 0;
    while (i < localArrayList.size())
    {
      if (((QMTask)localArrayList.get(i)).getId() == paramInt) {
        return ((QMSendMailTask)localArrayList.get(i)).getMail();
      }
      i += 1;
    }
    return null;
  }
  
  private ArrayList<QMTask> getSendMailTaskList(boolean paramBoolean)
  {
    if ((this.sendMailTaskList == null) || (paramBoolean))
    {
      ArrayList localArrayList = QMTaskManager.sharedInstance(1).getTaskList();
      if (this.sendMailTaskList == null) {
        this.sendMailTaskList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          QMSendMailTask localQMSendMailTask = (QMSendMailTask)localArrayList.get(i);
          if (localQMSendMailTask.getTaskState() != QMTask.QMTaskState.QMTaskStateSuccess)
          {
            if ((localQMSendMailTask.getTaskState() == QMTask.QMTaskState.QMTaskStateCanceling) && (localQMSendMailTask.getCurrentRequest() == null)) {
              localQMSendMailTask.cancel();
            }
            this.sendMailTaskList.add(localArrayList.get(i));
          }
          i += 1;
        }
        this.sendMailTaskList.clear();
      }
      sortTaskListByTime(this.sendMailTaskList);
    }
    return this.sendMailTaskList;
  }
  
  private void goAccountList()
  {
    startFragment(new AccountListFragment());
    overridePendingTransition(2130772421, 2130772420);
  }
  
  private void goFolderList(int paramInt)
  {
    startFragment(new FolderListFragment(paramInt));
    overridePendingTransition(2130772421, 2130772420);
  }
  
  private boolean inCancelRegion(float paramFloat1, float paramFloat2, View paramView)
  {
    MailListItemView localMailListItemView = (MailListItemView)((HorizontalScrollItemView)paramView).getContentView();
    if ((paramFloat2 - paramView.getTop() > localMailListItemView.getProgressCancelMarginTop() - localMailListItemView.getCancelIconWidth() / 2) && (paramFloat2 - paramView.getTop() < localMailListItemView.getProgressCancelMarginTop() + localMailListItemView.getCancelIconWidth() * 3 / 2))
    {
      paramFloat2 = localMailListItemView.getRight();
      int i = localMailListItemView.getCancelIconMarginRight();
      if (paramFloat2 - paramFloat1 < localMailListItemView.getCancelIconWidth() * 3 / 2 + i) {
        return true;
      }
    }
    return false;
  }
  
  private void registerListener()
  {
    QMNotification.registNotification("refresh_sending_list", this.refreshSendMailIObserver);
    QMNotification.registNotification("refresh_sending_progress", this.refreshSendProgressIObserver);
  }
  
  private void renderList()
  {
    renderTopBar();
    ArrayList localArrayList = getSendMailTaskList(true);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {}
    for (int i = localArrayList.size();; i = 0)
    {
      if (i <= 0)
      {
        if (!this.isFinish)
        {
          popBackStack();
          this.isFinish = true;
        }
        return;
      }
      this.sendMailListAdapter = new SendMailListAdapter(getActivity(), 0, localArrayList);
      this.sendMailList.setAdapter(this.sendMailListAdapter);
      return;
    }
  }
  
  private void renderTopBar()
  {
    int j = 0;
    getTopBar().setTitle(2131719539);
    getTopBar().setButtonLeftBack();
    ArrayList localArrayList = getSendMailTaskList(false);
    int i = j;
    if (localArrayList != null)
    {
      i = j;
      if (localArrayList.size() > 0) {
        i = localArrayList.size();
      }
    }
    if (i > 0)
    {
      getTopBar().setTitleSec("(" + String.valueOf(i) + ")");
      return;
    }
    getTopBar().setTitleSec("");
  }
  
  private void showClockPopupFrame(QMSendMailTask paramQMSendMailTask)
  {
    if (this.popupFrame == null)
    {
      long l1 = System.currentTimeMillis();
      long l2 = ClockedMailHelper.NEXT_ONE_HOUR_AND_FIVE_MINUTE;
      String str = QMApplicationContext.sharedInstance().getString(2131691547);
      this.popupFrame = ClockedMailHelper.getTimePickFrame(getActivity(), this.baseView, str, l1 + l2, 0, new SendMailListFragment.12(this, paramQMSendMailTask));
      ((Button)((DataPickerViewGroup)this.popupFrame.getContentView()).findViewById(2131366030)).setText(getString(2131719473));
    }
    if (!this.popupFrame.hasShow()) {
      this.popupFrame.show();
    }
  }
  
  private void showItemActionDialog(boolean paramBoolean, QMSendMailTask paramQMSendMailTask, View paramView)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131719525);
    if (paramBoolean) {
      localBottomListSheetBuilder.addItem(getString(2131691256));
    }
    while (paramQMSendMailTask.getTaskState() == QMTask.QMTaskState.QMTaskStateCanceling)
    {
      localBottomListSheetBuilder.addItem(getString(2131692498));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new SendMailListFragment.10(this, paramQMSendMailTask, paramView));
      localBottomListSheetBuilder.setOnBottomDialogDismissListener(new SendMailListFragment.11(this, paramView));
      localBottomListSheetBuilder.build().show();
      return;
    }
    Object localObject = paramQMSendMailTask.getMail();
    if (localObject != null) {}
    for (localObject = ((ComposeMailUI)localObject).getErrMsg();; localObject = "")
    {
      if ((getString(2131697375).equals(localObject)) || (getString(2131697367).equals(localObject))) {
        localBottomListSheetBuilder.addItem(getString(2131694375));
      }
      localBottomListSheetBuilder.addItem(getString(2131718838));
      if ((paramQMSendMailTask.getMail() != null) && (SendMailListAdapter.isExceedAttachLimit((String)localObject))) {
        localBottomListSheetBuilder.addItem(getString(2131692322));
      }
      localBottomListSheetBuilder.addItem(getString(2131718665));
      break;
    }
  }
  
  private static ArrayList<QMTask> sortTaskListByTime(ArrayList<QMTask> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    Collections.sort(paramArrayList, new SendMailListFragment.2());
    return paramArrayList;
  }
  
  private void unRegisterListener()
  {
    QMNotification.unregistNotification("refresh_sending_list", this.refreshSendMailIObserver);
    QMNotification.unregistNotification("refresh_sending_progress", this.refreshSendProgressIObserver);
  }
  
  private void updateSendingProgress(int paramInt)
  {
    double d = 0.0D;
    Object localObject = getSendMailTaskList(false);
    int i = 0;
    if (i < ((ArrayList)localObject).size()) {
      if (paramInt == ((QMTask)((ArrayList)localObject).get(i)).getId()) {
        d = ((QMSendMailTask)((ArrayList)localObject).get(i)).getSendingProgress();
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        paramInt = this.sendMailList.getFirstVisiblePosition();
        localObject = (HorizontalScrollItemView)this.sendMailList.getChildAt(i - paramInt);
        if (localObject != null) {}
      }
      else
      {
        return;
        i += 1;
        break;
      }
      localObject = (MailListItemView)((HorizontalScrollItemView)localObject).getContentView();
      ((MailListItemView)localObject).getItemData().progress = d;
      ((MailListItemView)localObject).invalidate();
      return;
      i = -1;
    }
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.sendMailList = new ItemScrollListView(this.baseView.getContext());
    this.sendMailList.setEnablePullToRefresh(false);
    paramViewHolder = new FrameLayout.LayoutParams(-1, -1, 48);
    paramViewHolder.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.baseView.addView(this.sendMailList, paramViewHolder);
    this.sendMailList.setOnItemClickListener(new SendMailListFragment.5(this));
    this.sendMailList.setOnTouchListener(new SendMailListFragment.6(this));
    this.sendMailList.setOnRightViewClickListener(new SendMailListFragment.7(this));
    this.baseView.setBackgroundColor(ActivityCompat.getColor(getActivity(), 2131167681));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      registerListener();
    }
    for (;;)
    {
      Watchers.bind(this.getVerifyImageWatcher, paramBoolean);
      return;
      unRegisterListener();
    }
  }
  
  public void onButtonBackClick()
  {
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      Object localObject = AccountManager.shareInstance();
      if (localObject == null)
      {
        super.onButtonBackClick();
        return;
      }
      localObject = ((AccountManager)localObject).getAccountList();
      if ((localObject == null) || (((AccountList)localObject).size() <= 0))
      {
        super.onButtonBackClick();
        return;
      }
      if (((AccountList)localObject).size() == 1)
      {
        goFolderList(((AccountList)localObject).get(0).getId());
        return;
      }
      goAccountList();
      return;
    }
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.sendMailList.isFold();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      onButtonBackClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    renderList();
  }
  
  @TargetApi(21)
  public void restorePostion()
  {
    if (this.lastIndex > -1) {
      this.sendMailList.setSelectionFromTop(this.lastIndex, this.lastTop);
    }
  }
  
  public void savePostion()
  {
    int i = 0;
    this.lastIndex = this.sendMailList.getFirstVisiblePosition();
    View localView = this.sendMailList.getChildAt(0);
    if (localView == null) {}
    for (;;)
    {
      this.lastTop = i;
      return;
      i = localView.getTop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment
 * JD-Core Version:    0.7.0.1
 */