package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.view.CalendarScrollView.CalenderListener;
import com.tencent.qqmail.calendar.view.CalendarViewGroup;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Calendar;

public class CalendarMainFragment
  extends CalendarBaseFragment
  implements CalendarScrollView.CalenderListener
{
  public static final String TAG = "CalendarMainFragment";
  private static final long miliSecondsPerDay = 86400000L;
  private boolean isFromReadMail = false;
  private CalendarViewGroup mViewGroup;
  private LinearLayout mWeekdayTitleView;
  private ScheduleUpdateWatcher scheduleUpdateWatcher = new CalendarMainFragment.1(this);
  private long timeMillis = Calendar.getInstance().getTimeInMillis();
  
  protected CalendarMainFragment()
  {
    super(false);
  }
  
  protected CalendarMainFragment(long paramLong)
  {
    super(false);
    this.isFromReadMail = true;
    this.timeMillis = paramLong;
  }
  
  private String getCalendarString(int paramInt1, int paramInt2)
  {
    return String.format(getString(2131691124), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private Calendar getSelectedDay()
  {
    return this.mViewGroup.getSelectedDay();
  }
  
  private TextView getSingleWeekdayTitle(int paramInt)
  {
    TextView localTextView = new TextView(getActivity());
    if (QMCalendarUtil.isWeekendDay(paramInt)) {
      localTextView.setTextColor(getResources().getColor(2131165509));
    }
    for (;;)
    {
      localTextView.setTextSize(11.0F);
      localTextView.setText(QMCalendarUtil.getWeekStringForShort(paramInt));
      localTextView.setGravity(17);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      localLayoutParams.weight = 1.0F;
      localTextView.setLayoutParams(localLayoutParams);
      return localTextView;
      localTextView.setTextColor(getResources().getColor(2131165508));
    }
  }
  
  private boolean isNeedToRefresh(QMCalendarEvent paramQMCalendarEvent)
  {
    long l1 = paramQMCalendarEvent.getStartTime();
    long l2 = paramQMCalendarEvent.getEndTime();
    Calendar localCalendar = (Calendar)getSelectedDay().clone();
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l3 = localCalendar.getTimeInMillis();
    long l4 = 86400000L + l3 - 1000L;
    if ((l1 <= l4) && (l2 >= l3)) {
      return true;
    }
    if ((paramQMCalendarEvent.isRecurring()) && (l1 <= l4) && ((paramQMCalendarEvent.getUntil() >= l3) || (paramQMCalendarEvent.getUntil() == 0L)))
    {
      if (paramQMCalendarEvent.getRecurrenceType() == 0) {
        return true;
      }
      int i;
      if (paramQMCalendarEvent.getRecurrenceType() == 1)
      {
        i = localCalendar.get(7);
        if ((i > 0) && (i < 8) && (paramQMCalendarEvent.getDayOfWeek() == Math.pow(2.0D, i - 1))) {
          return true;
        }
      }
      else
      {
        if (paramQMCalendarEvent.getRecurrenceType() == 2) {
          return true;
        }
        if (paramQMCalendarEvent.getRecurrenceType() == 5) {
          return true;
        }
        if (paramQMCalendarEvent.getRecurrenceType() == 7)
        {
          i = localCalendar.get(7);
          if ((i != 1) && (i != 7)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void paddingWeekdayTitleView()
  {
    int j = QMCalendarManager.getInstance().getDefaultStartDayOfWeek() - 1;
    int i = 0;
    while (i < 7)
    {
      this.mWeekdayTitleView.addView(getSingleWeekdayTitle(j % 7 + 1));
      j += 1;
      i += 1;
    }
  }
  
  private void reDraw()
  {
    this.mViewGroup.reDraw();
  }
  
  private void refreshSelectedDaySchedule()
  {
    this.mViewGroup.refreshSelectedDaySchedule();
  }
  
  private void shortcutDialog()
  {
    QMLog.log(4, "CalendarMainFragment", "show shortcutDialog");
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131691050))).setMessage(getString(2131691051)).addAction(2131691246, new CalendarMainFragment.7(this))).addAction(2131696547, new CalendarMainFragment.6(this))).create().show();
  }
  
  private void showSyncSystemDialog()
  {
    QMLog.log(4, "CalendarMainFragment", "show syncSystem");
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131691221))).setMessage(getString(2131691223)).addAction(2131691224, new CalendarMainFragment.9(this))).addAction(2131691225, new CalendarMainFragment.8(this))).create().show();
  }
  
  private void showTipsDialog()
  {
    int i = SharedPreferenceUtil.getCalendarEnterCount();
    if ((SharedPreferenceUtil.getSyncSystemCalendarTipCount() == 0) && (!QMCalendarManager.getInstance().isShowSystemCalendar()))
    {
      showSyncSystemDialog();
      SharedPreferenceUtil.setCalendarEnterCount(1);
      SharedPreferenceUtil.setSyncSystemCalendarTipCount(1);
    }
    do
    {
      return;
      if ((i == 1) && (!ShortcutUtility.isShortcutExist(getString(2131689759))))
      {
        shortcutDialog();
        SharedPreferenceUtil.setCalendarEnterCount(2);
        return;
      }
    } while (i > 1);
    SharedPreferenceUtil.setCalendarEnterCount(1);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    showTipsDialog();
  }
  
  public void initTopbar(View paramView)
  {
    paramView = getTopBar();
    Calendar localCalendar = Calendar.getInstance();
    paramView.setTitle(getCalendarString(localCalendar.get(1), localCalendar.get(2) + 1));
    paramView.setTitleClicable(true);
    paramView.setButtonLeftBack();
    paramView.setButtonRightIcon(2130841079);
    paramView.setButtonRightSecondIcon(2130841087, new CalendarMainFragment.2(this));
    paramView.setButtonLeftOnclickListener(new CalendarMainFragment.3(this));
    paramView.setButtonRightOnclickListener(new CalendarMainFragment.4(this));
    paramView.setCenterOnclickListener(new CalendarMainFragment.5(this));
    paramView.getButtonRight().setContentDescription(getString(2131720842));
    paramView.getButtonRightSecondIcon().setContentDescription(getString(2131720856));
    if (!QMCalendarManager.getInstance().isExistEditableCalendar()) {
      paramView.getButtonRight().setEnabled(false);
    }
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    Object localObject = View.inflate(getActivity(), 2131558799, null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setVerticalFadingEdgeEnabled(false);
    this.mWeekdayTitleView = ((LinearLayout)((View)localObject).findViewById(2131382191));
    paddingWeekdayTitleView();
    this.mViewGroup = ((CalendarViewGroup)((View)localObject).findViewById(2131364176));
    this.mViewGroup.setCalenderListener(this);
    paramViewHolder.addView((View)localObject);
    if (this.isFromReadMail)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(this.timeMillis);
      setStartPageMonth((Calendar)localObject);
    }
    return paramViewHolder;
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMCalendarManager.getInstance().bindLoadEventListWatcher(this.scheduleUpdateWatcher, paramBoolean);
  }
  
  public void onChangeMonth(int paramInt1, int paramInt2)
  {
    QMTopBar localQMTopBar = getTopBar();
    String str = getCalendarString(paramInt2, paramInt1);
    TextView localTextView = localQMTopBar.getTitleView();
    float f = localTextView.getPaint().measureText(str);
    if (f > localTextView.getWidth() - localTextView.getPaddingLeft() - localTextView.getPaddingRight()) {
      localTextView.setWidth((int)(f + localTextView.getPaddingLeft() + localTextView.getPaddingRight() + 1.0F));
    }
    localQMTopBar.setTitle(str);
  }
  
  public void onDayViewDoubleClick(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView)
  {
    startFragment(new ModifyScheduleFragment(this.mViewGroup.getSelectedDay()));
  }
  
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
  
  public void onLongClickDate(CalendarDayData paramCalendarDayData, View paramView) {}
  
  public void onRelease()
  {
    this.mViewGroup.release();
  }
  
  public void onScheduleItemClick(QMSchedule paramQMSchedule)
  {
    ReadScheduleFragment localReadScheduleFragment = new ReadScheduleFragment();
    localReadScheduleFragment.prepareEvent(paramQMSchedule);
    startFragment(localReadScheduleFragment);
  }
  
  public boolean onScheduleItemLongClick(QMSchedule paramQMSchedule)
  {
    return false;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView) {}
  
  public int refreshData()
  {
    QMCalendarManager localQMCalendarManager = QMCalendarManager.getInstance();
    localQMCalendarManager.syncCalendar();
    localQMCalendarManager.syncLocalCalendar();
    return 0;
  }
  
  public void render(int paramInt)
  {
    refreshSelectedDaySchedule();
  }
  
  public void setStartPageMonth(Calendar paramCalendar)
  {
    this.mViewGroup.setStartPageMonth(paramCalendar);
  }
  
  public static abstract interface CreditCardDetailCallback
  {
    public abstract void callback(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment
 * JD-Core Version:    0.7.0.1
 */