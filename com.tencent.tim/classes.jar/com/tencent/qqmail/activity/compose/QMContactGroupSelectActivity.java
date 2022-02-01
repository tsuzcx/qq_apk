package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;

public class QMContactGroupSelectActivity
  extends BaseActivityEx
{
  private static final String TAG = "QMContactGroupSelectActivity";
  private AccountList accountsList;
  private QMBaseView baseView;
  private List<Integer> checkedAccountIds;
  private UITableView tableView;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMContactGroupSelectActivity.class);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new QMContactGroupSelectActivity.2(this));
  }
  
  public void initDataSource()
  {
    this.accountsList = AccountManager.shareInstance().getAccountList();
    this.checkedAccountIds = QMContactManager.sharedInstance().getCheckedAccountIds();
  }
  
  public void initDom()
  {
    initTopBar();
    this.tableView = new UITableView(this);
    this.tableView.setCaption(2131692040);
    Iterator localIterator = this.accountsList.iterator();
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      UITableItemView localUITableItemView = this.tableView.addItem(localAccount.getEmail());
      localUITableItemView.setTailImage(2130850509);
      localUITableItemView.setChecked(this.checkedAccountIds.contains(Integer.valueOf(localAccount.getId())));
      StringBuilder localStringBuilder = new StringBuilder();
      if (localUITableItemView.isChecked()) {}
      for (String str = getString(2131720855);; str = "")
      {
        localUITableItemView.setContentDescription(str + localAccount.getEmail());
        break;
      }
    }
    this.tableView.setClickListener(new QMContactGroupSelectActivity.1(this));
    this.tableView.commit();
    this.baseView.addContentView(this.tableView);
  }
  
  public void initUI()
  {
    this.baseView = initScrollView(this);
  }
  
  public void onBackground()
  {
    super.onBackground();
    QMContactManager.sharedInstance().saveCheckedAccountIds(this.checkedAccountIds);
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
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMContactGroupSelectActivity
 * JD-Core Version:    0.7.0.1
 */