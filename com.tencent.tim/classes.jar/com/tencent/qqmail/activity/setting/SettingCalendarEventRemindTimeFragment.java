package com.tencent.qqmail.activity.setting;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class SettingCalendarEventRemindTimeFragment
  extends SettingCalendarBaseFragment
{
  private int defaultReminderTime;
  private QMBaseView mBaseView;
  private QMRadioGroup mRemindTime;
  private QMTopBar mTopBar = null;
  private QMCalendarManager qmCalendarManager = QMCalendarManager.getInstance();
  
  protected SettingCalendarEventRemindTimeFragment()
  {
    super(false);
  }
  
  private void onBack()
  {
    if (this.mRemindTime.hasChange()) {
      this.qmCalendarManager.modifyDefaultReminderTime(this.mRemindTime.getSelectedItem());
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
    this.defaultReminderTime = this.qmCalendarManager.getDefaultReminderTime();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mRemindTime = new QMRadioGroup(getActivity());
    this.mBaseView.addContentView(this.mRemindTime);
    this.mRemindTime.addItem(-1, 2131691138);
    this.mRemindTime.addItem(0, 2131691135);
    this.mRemindTime.addItem(5, 2131691137);
    this.mRemindTime.addItem(15, 2131691136);
    this.mRemindTime.addItem(60, 2131691141);
    this.mRemindTime.addItem(1440, 2131691139);
    this.mRemindTime.commit();
    this.mRemindTime.setSelectedItem(this.defaultReminderTime);
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(2131691149);
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.setButtonLeftOnclickListener(new SettingCalendarEventRemindTimeFragment.1(this));
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarEventRemindTimeFragment
 * JD-Core Version:    0.7.0.1
 */