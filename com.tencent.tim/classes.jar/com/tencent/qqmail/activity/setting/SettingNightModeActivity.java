package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.view.PopupFrame;
import com.tencent.qqmail.calendar.view.ScheduleTimeModifyView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.nightmode.NightModeUtils;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.ClockedMailHelper;
import com.tencent.qqmail.view.NoSkipSeekBar;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Calendar;

public class SettingNightModeActivity
  extends BaseActivityEx
  implements View.OnTouchListener
{
  public static final int DEFAULT_COLOR_TEMPERATURE_MAX = 70;
  public static final String TAG = "SettingNightModeActivit";
  private QMBaseView baseView;
  public int colorTemp = 70;
  private ScheduleTimeModifyView eventTimeItemView;
  private LinearLayout listContainer;
  private UITableItemView mNightModeAllDayItemView;
  private UITableView mNightModeAllDayTableView;
  private UITableItemView mNightModeItemView;
  private UITableView mNightModeSwitchTableView;
  private UITableContainer mNightModeTimePickTableView;
  private PopupFrame mPopupFrame;
  private UITableView.ClickListener nightModeClickListener = new SettingNightModeActivity.7(this);
  private View seekBarArea;
  private SeekBar seekbar;
  private QMTopBar topBar;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingNightModeActivity.class);
  }
  
  private void gotoSetting()
  {
    Intent localIntent = new Intent("android.settings.SETTINGS");
    if (intentExist(localIntent))
    {
      startActivity(localIntent);
      return;
    }
    QMLog.log(5, "SettingNightModeActivit", "No Intent available to handle ACTION_SETTINGS");
  }
  
  private boolean intentExist(Intent paramIntent)
  {
    return paramIntent.resolveActivity(getActivity().getPackageManager()) != null;
  }
  
  public void createNightModeTable()
  {
    this.mNightModeSwitchTableView = new UITableView(this);
    this.mNightModeItemView = this.mNightModeSwitchTableView.addItem(2131719894);
    this.mNightModeItemView.setChecked(SharedPreferenceUtil.inNightMode());
    ImageView localImageView = this.mNightModeItemView.getTailImage();
    if (SharedPreferenceUtil.inNightMode())
    {
      str = getString(2131720844);
      localImageView.setContentDescription(str);
      this.mNightModeSwitchTableView.setClickListener(this.nightModeClickListener);
      this.mNightModeTimePickTableView = new UITableContainer(getActivity());
      this.mNightModeTimePickTableView.setBackgroundClickable(false);
      this.eventTimeItemView = new ScheduleTimeModifyView(getActivity());
      this.eventTimeItemView.setCustomerLayoutParmas(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297616)));
      this.mNightModeTimePickTableView.addItem(this.eventTimeItemView);
      this.eventTimeItemView.setStartTime(Calendar.getInstance(), false);
      this.eventTimeItemView.setEndTime(Calendar.getInstance(), false);
      this.mNightModeSwitchTableView.commit();
      this.listContainer.addView(this.mNightModeSwitchTableView);
      this.listContainer.addView(this.mNightModeTimePickTableView);
      this.eventTimeItemView.setStartTimeOnClickListener(new SettingNightModeActivity.5(this));
      this.eventTimeItemView.setEndTimeOnClickListener(new SettingNightModeActivity.6(this));
      this.mNightModeAllDayTableView = new UITableView(this);
      this.mNightModeAllDayItemView = this.mNightModeAllDayTableView.addItem(2131719895);
      this.mNightModeAllDayItemView.setChecked(SharedPreferenceUtil.isNightModeAllDay());
      localImageView = this.mNightModeAllDayItemView.getTailImage();
      if (!SharedPreferenceUtil.isNightModeAllDay()) {
        break label383;
      }
    }
    label383:
    for (String str = getString(2131720844);; str = getString(2131720811))
    {
      localImageView.setContentDescription(str);
      if (SharedPreferenceUtil.isNightModeAllDay()) {
        this.mNightModeTimePickTableView.setVisibility(8);
      }
      this.mNightModeAllDayTableView.setClickListener(this.nightModeClickListener);
      this.mNightModeAllDayTableView.commit();
      this.listContainer.addView(this.mNightModeAllDayTableView);
      this.eventTimeItemView.setStartTimeRawText(SharedPreferenceUtil.getNightModeStartTime() / 100, SharedPreferenceUtil.getNightModeStartTime() % 100);
      this.eventTimeItemView.setEndTimeRawText(SharedPreferenceUtil.getNightModeEndTime() / 100, SharedPreferenceUtil.getNightModeEndTime() % 100);
      return;
      str = getString(2131720811);
      break;
    }
  }
  
  public void ensureFloatViewPermission()
  {
    QMLog.log(4, "SettingNightModeActivit", "Try to ensure FloatView Permission");
    if ((BrandUtil.isMiuiV8()) || ((BrandUtil.isMeizu()) && (NightModeUtils.isFlymeNeedPermissionForFloatWindow())))
    {
      boolean bool = NightModeUtils.isFloatWindowOpAllowed(this);
      QMLog.log(4, "SettingNightModeActivit", "floatWindowAllowed = " + bool);
      if (!bool)
      {
        QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131718911)).setMessage(2131718906).addAction(2131691246, new SettingNightModeActivity.10(this))).addAction(0, 2131719634, 0, new SettingNightModeActivity.9(this))).create();
        localQMUIDialog.setCancelable(false);
        localQMUIDialog.show();
      }
    }
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(getString(2131719894)).setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new SettingNightModeActivity.1(this));
    this.listContainer = ((LinearLayout)findViewById(2131372399));
    this.colorTemp = SharedPreferenceUtil.getNightModeTemperature();
    this.seekBarArea = findViewById(2131379308);
    this.seekbar = ((NoSkipSeekBar)findViewById(2131364876));
    this.seekbar.setMax(70);
    this.seekbar.setProgress(100 - this.colorTemp);
    this.seekbar.setOnTouchListener(this);
    this.seekbar.setOnSeekBarChangeListener(new SettingNightModeActivity.2(this));
    createNightModeTable();
    this.baseView.post(new SettingNightModeActivity.3(this));
  }
  
  public void initUI()
  {
    this.baseView = initBaseView(this, 2131558502);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int[] arrayOfInt = new int[2];
    this.seekBarArea.getLocationInWindow(arrayOfInt);
    boolean bool1 = bool2;
    if (this.mNightModeItemView.isChecked())
    {
      bool1 = bool2;
      if (paramMotionEvent.getY() > arrayOfInt[1])
      {
        bool1 = bool2;
        if (paramMotionEvent.getY() < arrayOfInt[1] + this.seekBarArea.getHeight()) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void onRelease() {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (NightModeUtils.getInstance().needToGotoNightMode()) {
        break label71;
      }
      Threads.runOnMainThread(new SettingNightModeActivity.8(this), 1000L);
    }
    for (;;)
    {
      DataCollector.logEvent("Event_NightMode_change_temperature");
      QMLog.log(4, "SettingNightModeActivit", "SeekBar.getProgress() " + this.seekbar.getProgress());
      return false;
      label71:
      updateNightModeTemper();
    }
  }
  
  public void refreshData()
  {
    this.mNightModeItemView.setChecked(SharedPreferenceUtil.inNightMode());
    this.mNightModeAllDayItemView.setChecked(SharedPreferenceUtil.isNightModeAllDay());
    if (SharedPreferenceUtil.inNightMode()) {}
    for (int i = 0;; i = 8)
    {
      showOrHideSomeSetting(i);
      return;
    }
  }
  
  public void render() {}
  
  public void showNightModeJustOneSecond()
  {
    NightModeUtils.getInstance().showNightMode(this.colorTemp * 65, true, false);
  }
  
  public void showOrHideSomeSetting(int paramInt)
  {
    this.mNightModeAllDayTableView.setVisibility(paramInt);
    this.mNightModeTimePickTableView.setVisibility(paramInt);
    findViewById(2131379308).setVisibility(paramInt);
    if (SharedPreferenceUtil.isNightModeAllDay()) {
      this.mNightModeTimePickTableView.setVisibility(8);
    }
  }
  
  public void showTimeDialog(boolean paramBoolean)
  {
    DataCollector.logEvent("Event_NightMode_custom_time");
    System.currentTimeMillis();
    if (paramBoolean) {}
    for (long l = NightModeUtils.getInstance().getStartTimeInMillis();; l = NightModeUtils.getInstance().getEndTimeInMillis())
    {
      this.mPopupFrame = ClockedMailHelper.getTimePickFrameWithOneTap(this, this.baseView, "", l, 1, new SettingNightModeActivity.4(this, paramBoolean));
      if (!this.mPopupFrame.isShown()) {
        this.mPopupFrame.show();
      }
      return;
    }
  }
  
  public void updateNightModeTemper()
  {
    QMLog.log(4, "SettingNightModeActivit", "updateNightModeTemper");
    if (NightModeUtils.getInstance().needToGotoNightMode())
    {
      NightModeUtils.getInstance().showNightMode(this.colorTemp * 65, false, false);
      return;
    }
    NightModeUtils.getInstance().hideNightMode(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity
 * JD-Core Version:    0.7.0.1
 */