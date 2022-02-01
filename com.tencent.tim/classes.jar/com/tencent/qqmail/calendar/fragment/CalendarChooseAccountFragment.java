package com.tencent.qqmail.calendar.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class CalendarChooseAccountFragment
  extends CalendarScrollBaseFragment
{
  private final UITableView.ClickListener calendarChooseAccountTableOnClickListener = new CalendarChooseAccountFragment.2(this);
  private String code;
  private boolean handleLastFragmentFinish = true;
  private UITableView mAccountTable;
  private List<QQMailAccount> mAccounts;
  
  public CalendarChooseAccountFragment(String paramString)
  {
    this.code = paramString;
  }
  
  private void createCalendarChooseAccountTable()
  {
    if (this.mAccountTable == null)
    {
      this.mAccountTable = new UITableView(getActivity());
      this.mAccountTable.setClickListener(this.calendarChooseAccountTableOnClickListener);
      this.mContainer.addView(this.mAccountTable);
    }
    this.mAccountTable.clear();
    Iterator localIterator = this.mAccounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.mAccountTable.addItem(localAccount.getEmail());
    }
    this.mAccountTable.setDescription(2131691167);
    this.mAccountTable.commit();
  }
  
  private void followShareCalendar(int paramInt, String paramString1, String paramString2)
  {
    if (!QMCalendarManager.getInstance().isExistAccountForCalendar(paramInt))
    {
      showCalendarSettingDialog();
      return;
    }
    QMCalendarManager.getInstance().followShareCalendarFolder(paramInt, true, paramString1, paramString2);
  }
  
  private void showCalendarSettingDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131691168).addAction(2131691246, new CalendarChooseAccountFragment.4(this))).addAction(2131719634, new CalendarChooseAccountFragment.3(this))).create().show();
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    this.mAccounts = AccountManager.shareInstance().getAccountList().getQQAccountList();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    createCalendarChooseAccountTable();
  }
  
  public void initTopbar(View paramView)
  {
    paramView = getTopBar();
    paramView.setTitle(2131691166);
    paramView.setButtonLeftIcon(2130841088);
    paramView.setButtonLeftOnclickListener(new CalendarChooseAccountFragment.1(this));
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public Object onLastFragmentFinish()
  {
    if ((this.handleLastFragmentFinish) && (QMActivityManager.shareInstance().getActivitySize() <= 1))
    {
      if (AccountManager.shareInstance().getAccountList().size() == 1) {
        return MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      }
      return MailFragmentActivity.createIntentToAccountList();
    }
    return super.onLastFragmentFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarChooseAccountFragment
 * JD-Core Version:    0.7.0.1
 */