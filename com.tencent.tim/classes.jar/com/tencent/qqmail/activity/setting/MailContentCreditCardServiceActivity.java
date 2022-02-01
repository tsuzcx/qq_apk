package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;

public class MailContentCreditCardServiceActivity
  extends BaseActivityEx
{
  public static final String TAG = "SettingAppActivity";
  private QMBaseView baseView;
  private UITableItemView debugClearServerSetting;
  private SparseArray<UITableItemView> itemViews = new SparseArray();
  private final UITableView.ClickListener tableOnClickListener = new MailContentCreditCardServiceActivity.1(this);
  private UITableView tableView;
  
  private void createAppTableView()
  {
    this.tableView = new UITableView(this);
    this.baseView.addContentView(this.tableView);
  }
  
  public static Intent createIntent(Context paramContext)
  {
    return new Intent(paramContext, MailContentCreditCardServiceActivity.class);
  }
  
  private void debug()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().getQQAccountList().iterator();
    while (localIterator.hasNext())
    {
      QQMailAccount localQQMailAccount = (QQMailAccount)localIterator.next();
      QMMailManager.sharedInstance().setMailReminderRequestState(true, localQQMailAccount.getId(), 0, 0);
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131718764);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createAppTableView();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().getQQAccountList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (QQMailAccount)localIterator.next();
      int i = ((QQMailAccount)localObject).getId();
      localObject = ((QQMailAccount)localObject).getEmail();
      boolean bool = SharedPreferenceUtil.getCreditCardDialogAccept(i);
      localObject = this.tableView.addItem((String)localObject);
      ((UITableItemView)localObject).setChecked(bool);
      this.itemViews.put(i, localObject);
    }
    this.debugClearServerSetting = this.tableView.addItem("Debug: 清除服务器授权配置");
    this.tableView.setClickListener(this.tableOnClickListener);
    this.tableView.setDescription(2131718774);
    this.tableView.commit();
    this.debugClearServerSetting.setVisibility(8);
  }
  
  public void initUI()
  {
    this.baseView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.MailContentCreditCardServiceActivity
 * JD-Core Version:    0.7.0.1
 */