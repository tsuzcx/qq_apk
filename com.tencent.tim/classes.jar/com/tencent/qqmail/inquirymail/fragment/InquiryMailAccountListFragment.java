package com.tencent.qqmail.inquirymail.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;

public class InquiryMailAccountListFragment
  extends InquiryMailBaseFragment
{
  public static final String TAG = "InquiryMailAccountListFragment";
  private final UITableView.ClickListener accountListClickListener = new InquiryMailAccountListFragment.1(this);
  private QMBaseView baseView;
  private List<QQMailAccount> qqMailAccounts;
  
  public InquiryMailAccountListFragment()
  {
    super(false);
  }
  
  private void initAccountList()
  {
    UITableView localUITableView = new UITableView(getActivity());
    Iterator localIterator = this.qqMailAccounts.iterator();
    while (localIterator.hasNext()) {
      localUITableView.addItem(((QQMailAccount)localIterator.next()).getEmail());
    }
    localUITableView.setDescription(2131694994);
    localUITableView.setClickListener(this.accountListClickListener);
    localUITableView.commit();
    this.baseView.addContentView(localUITableView);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131694977);
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new InquiryMailAccountListFragment.2(this));
  }
  
  public void initDataSource()
  {
    this.qqMailAccounts = AccountManager.shareInstance().getAccountList().getQQAccountList();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initAccountList();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
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
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailAccountListFragment
 * JD-Core Version:    0.7.0.1
 */