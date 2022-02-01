package com.tencent.qqmail.activity.setting;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class SettingCalendarDefaultSyncTimeFragment
  extends SettingCalendarBaseFragment
{
  private int defaultSyncTime;
  private QMBaseView mBaseView;
  private QMRadioGroup mSyncTime;
  private QMTopBar mTopBar = null;
  private QMCalendarManager qmCalendarManager = QMCalendarManager.getInstance();
  
  protected SettingCalendarDefaultSyncTimeFragment()
  {
    super(false);
  }
  
  private void onBack()
  {
    if (this.mSyncTime.hasChange()) {
      this.qmCalendarManager.modifyDefaultSyncTime(this.mSyncTime.getSelectedItem());
    }
    popBackStack();
  }
  
  public QMTopBar getTopBar()
  {
    if (this.mTopBar == null) {
      this.mTopBar = new QMTopBar(getActivity());
    }
    return this.mTopBar;
  }
  
  public void initDataSource()
  {
    this.defaultSyncTime = this.qmCalendarManager.getDefaultSyncTime();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mSyncTime = new QMRadioGroup(getActivity());
    this.mBaseView.addContentView(this.mSyncTime);
    this.mSyncTime.addItem(0, 2131691220);
    this.mSyncTime.addItem(1, 2131691217);
    this.mSyncTime.addItem(2, 2131691219);
    this.mSyncTime.addItem(3, 2131691218);
    this.mSyncTime.addItem(4, 2131691215);
    this.mSyncTime.commit();
    this.mSyncTime.setSelectedItem(this.defaultSyncTime);
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(2131719705);
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarDefaultSyncTimeFragment.1(this));
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
    onBack();
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultSyncTimeFragment
 * JD-Core Version:    0.7.0.1
 */