package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class CalendarNoneFragment
  extends CalendarBaseFragment
{
  private QMBaseView mBaseView;
  
  public CalendarNoneFragment()
  {
    super(false);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public void initTopbar(View paramView)
  {
    paramView = new QMTopBar(getActivity());
    this.mBaseView.addView(paramView);
    paramView.setTitle(getResources().getString(2131691226));
    paramView.setButtonLeftBack();
    paramView.setButtonLeftOnclickListener(new CalendarNoneFragment.1(this));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = View.inflate(getActivity(), 2131558800, null);
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    this.mBaseView.addContentView(paramViewHolder);
    this.mBaseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.mBaseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public Object onLastFragmentFinish()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Intent localIntent = null;
    if (localAccountList.size() > 1) {
      localIntent = MailFragmentActivity.createIntentToAccountList();
    }
    while (localAccountList.size() != 1) {
      return localIntent;
    }
    return MailFragmentActivity.createIntentToFolderList(localAccountList.get(0).getId());
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarNoneFragment
 * JD-Core Version:    0.7.0.1
 */