package com.tencent.qqmail.namelist.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;

public class NameListAccountListFragment
  extends NameListBaseFragment
{
  private final UITableView.ClickListener accountListClickListener = new NameListAccountListFragment.2(this);
  private AccountList allAccounts;
  private QMBaseView baseView;
  private List<QQMailAccount> qqMailAccounts;
  private int type;
  
  public NameListAccountListFragment(int paramInt)
  {
    super(false);
    this.type = paramInt;
  }
  
  private void initBlackList()
  {
    UITableView localUITableView = new UITableView(getActivity());
    Iterator localIterator = this.allAccounts.iterator();
    while (localIterator.hasNext()) {
      localUITableView.addItem(((Account)localIterator.next()).getEmail());
    }
    localUITableView.setClickListener(this.accountListClickListener);
    localUITableView.commit();
    this.baseView.addContentView(localUITableView);
  }
  
  private void initTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.type == NameListContact.NameListContactType.BLACK.ordinal()) {
      localQMTopBar.setTitle(2131690878);
    }
    for (;;)
    {
      localQMTopBar.setButtonLeftBack();
      localQMTopBar.setButtonLeftOnclickListener(new NameListAccountListFragment.1(this));
      return;
      if (this.type == NameListContact.NameListContactType.WHITE.ordinal()) {
        localQMTopBar.setTitle(2131721876);
      }
    }
  }
  
  private void initWhiteList()
  {
    UITableView localUITableView = new UITableView(getActivity());
    Iterator localIterator = this.qqMailAccounts.iterator();
    while (localIterator.hasNext()) {
      localUITableView.addItem(((QQMailAccount)localIterator.next()).getEmail());
    }
    if ((this.qqMailAccounts != null) && (this.allAccounts.size() > this.qqMailAccounts.size())) {
      localUITableView.setDescription(2131721875);
    }
    localUITableView.setClickListener(this.accountListClickListener);
    localUITableView.commit();
    this.baseView.addContentView(localUITableView);
  }
  
  public void initDataSource()
  {
    this.qqMailAccounts = AccountManager.shareInstance().getAccountList().getQQAccountList();
    this.allAccounts = AccountManager.shareInstance().getAccountList();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopbar();
    if (this.type == NameListContact.NameListContactType.BLACK.ordinal()) {
      initBlackList();
    }
    while (this.type != NameListContact.NameListContactType.WHITE.ordinal()) {
      return;
    }
    initWhiteList();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = new QMBaseView(getActivity());
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAccountListFragment
 * JD-Core Version:    0.7.0.1
 */