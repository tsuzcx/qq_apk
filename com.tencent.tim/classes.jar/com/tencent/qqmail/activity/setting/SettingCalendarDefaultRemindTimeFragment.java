package com.tencent.qqmail.activity.setting;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class SettingCalendarDefaultRemindTimeFragment
  extends SettingCalendarBaseFragment
{
  private UITableView.ClickListener RemindTimeListener = new SettingCalendarDefaultRemindTimeFragment.2(this);
  private QMBaseView mBaseView;
  private UITableView mRemindTimeTable;
  private QMTopBar mTopBar = null;
  
  protected SettingCalendarDefaultRemindTimeFragment()
  {
    super(false);
  }
  
  public QMTopBar getTopBar()
  {
    if (this.mTopBar == null) {
      this.mTopBar = new QMTopBar(getActivity());
    }
    return this.mTopBar;
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mRemindTimeTable = new UITableView(getActivity());
    this.mBaseView.addContentView(this.mRemindTimeTable);
    this.mRemindTimeTable.addItem(2131691149);
    this.mRemindTimeTable.addItem(2131719686);
    this.mRemindTimeTable.setClickListener(this.RemindTimeListener);
    this.mRemindTimeTable.commit();
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(2131719690);
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarDefaultRemindTimeFragment.1(this));
    this.mBaseView.addView(this.mTopBar);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    return this.mBaseView;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    popBackStack();
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultRemindTimeFragment
 * JD-Core Version:    0.7.0.1
 */