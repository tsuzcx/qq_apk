package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemBaseView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class ScheduleTimeModifyView
  extends UITableItemBaseView
{
  private View container;
  private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
  private LinearLayout mEndContainerView;
  private TextView mEndFirstView;
  private TextView mEndSecondView;
  private Calendar mEndTimeCalendar;
  private LinearLayout.LayoutParams mItemLayout = new LinearLayout.LayoutParams(-1, -1, 1.0F);
  private View.OnClickListener mOnEndContainerClickListener;
  private View.OnClickListener mOnStartContainerClickListener;
  private LinearLayout mStartContainerView;
  private TextView mStartFirstView;
  private TextView mStartSecondView;
  private Calendar mStartTimeCalendar;
  private ArrayList<View> viewList = new ArrayList();
  
  public ScheduleTimeModifyView(Context paramContext)
  {
    super(paramContext);
    setCustomerLayoutParmas(this.layoutParams);
    initData();
    initDom();
  }
  
  private String getTimeDesc(int paramInt)
  {
    if (paramInt < 5) {
      return "深夜";
    }
    if (paramInt < 11) {
      return "上午";
    }
    if (paramInt < 14) {
      return "中午";
    }
    if (paramInt < 18) {
      return "下午";
    }
    return "晚上";
  }
  
  private void initData()
  {
    this.mStartTimeCalendar = Calendar.getInstance();
    this.mEndTimeCalendar = Calendar.getInstance();
  }
  
  private void initDom()
  {
    this.container = setLayoutFromXml(2131558809);
    this.mStartContainerView = ((LinearLayout)this.container.findViewById(2131366556));
    this.mStartFirstView = ((TextView)this.container.findViewById(2131366557));
    this.mStartSecondView = ((TextView)this.container.findViewById(2131366558));
    this.mEndContainerView = ((LinearLayout)this.container.findViewById(2131366553));
    this.mEndFirstView = ((TextView)this.container.findViewById(2131366554));
    this.mEndSecondView = ((TextView)this.container.findViewById(2131366555));
  }
  
  private void renderEndTimeView(Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.mEndFirstView.setText(QMCalendarUtil.getWeekString(paramCalendar));
        this.mEndSecondView.setText(QMCalendarUtil.getDayString(paramCalendar));
        this.mEndSecondView.setTextSize(2, 17);
        return;
      }
      this.mEndFirstView.setText(QMCalendarUtil.getWeekString(paramCalendar));
      this.mEndSecondView.setText(QMCalendarUtil.getMonthDayString(paramCalendar));
      this.mEndSecondView.setTextSize(2, 20);
      return;
    }
    if (paramBoolean2)
    {
      this.mEndFirstView.setText(QMCalendarUtil.getDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
      this.mEndSecondView.setText(QMCalendarUtil.getTimeString(paramCalendar));
      this.mEndSecondView.setTextSize(2, 20);
      return;
    }
    this.mEndFirstView.setText(QMCalendarUtil.getMonthDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
    this.mEndSecondView.setText(QMCalendarUtil.getTimeString(paramCalendar));
    this.mEndSecondView.setTextSize(2, 20);
  }
  
  private void renderStartTimeView(Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.mStartFirstView.setText(QMCalendarUtil.getWeekString(paramCalendar));
        this.mStartSecondView.setText(QMCalendarUtil.getDayString(paramCalendar));
        this.mStartSecondView.setTextSize(2, 17);
        return;
      }
      this.mStartFirstView.setText(QMCalendarUtil.getWeekString(paramCalendar));
      this.mStartSecondView.setText(QMCalendarUtil.getMonthDayString(paramCalendar));
      this.mStartSecondView.setTextSize(2, 20);
      return;
    }
    if (paramBoolean2)
    {
      this.mStartFirstView.setText(QMCalendarUtil.getDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
      this.mStartSecondView.setText(QMCalendarUtil.getTimeString(paramCalendar));
      this.mStartSecondView.setTextSize(2, 20);
      return;
    }
    this.mStartFirstView.setText(QMCalendarUtil.getMonthDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
    this.mStartSecondView.setText(QMCalendarUtil.getTimeString(paramCalendar));
    this.mStartSecondView.setTextSize(2, 20);
  }
  
  private void renderTimeView(Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    boolean bool = false;
    if ((paramCalendar1.get(1) != localCalendar.get(1)) || (paramCalendar2.get(1) != localCalendar.get(1))) {
      bool = true;
    }
    renderStartTimeView(paramCalendar1, paramBoolean, bool);
    renderEndTimeView(paramCalendar2, paramBoolean, bool);
  }
  
  public View addItemView(View paramView)
  {
    if ((paramView != null) && (!this.viewList.contains(paramView))) {
      this.viewList.add(paramView);
    }
    return paramView;
  }
  
  public LinearLayout getEndContainerView()
  {
    return this.mEndContainerView;
  }
  
  public LinearLayout getStartContainerView()
  {
    return this.mStartContainerView;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if ((this.viewList != null) && (this.viewList.size() > 0))
    {
      Iterator localIterator = this.viewList.iterator();
      while (localIterator.hasNext()) {
        addView((View)localIterator.next(), this.mItemLayout);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setEndTime(Calendar paramCalendar, boolean paramBoolean)
  {
    this.mEndTimeCalendar = ((Calendar)paramCalendar.clone());
    renderTimeView(this.mStartTimeCalendar, this.mEndTimeCalendar, paramBoolean);
  }
  
  public void setEndTimeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnEndContainerClickListener = paramOnClickListener;
    this.mEndContainerView.setOnClickListener(paramOnClickListener);
  }
  
  public void setEndTimeRawText(int paramInt1, int paramInt2)
  {
    this.mEndFirstView.setVisibility(8);
    Object localObject;
    if (paramInt1 >= 10)
    {
      localObject = "" + paramInt1;
      if (paramInt2 < 10) {
        break label197;
      }
    }
    label197:
    for (String str1 = "" + paramInt2;; str1 = "0" + paramInt2)
    {
      String str2 = getTimeDesc(paramInt1);
      localObject = new SpannableString(str2 + "  " + (String)localObject + " : " + str1);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131167535)), str2.length(), ((SpannableString)localObject).length(), 17);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(16, true), 0, str2.length(), 17);
      this.mEndSecondView.setText((CharSequence)localObject);
      return;
      localObject = "0" + paramInt1;
      break;
    }
  }
  
  public void setEndTimeViewLegal(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = getResources().getColor(2131167519);; i = getResources().getColor(2131167539))
    {
      this.mEndFirstView.setTextColor(i);
      this.mEndSecondView.setTextColor(i);
      return;
    }
  }
  
  public void setEndTimeViewSelected(boolean paramBoolean)
  {
    this.mEndContainerView.setSelected(paramBoolean);
  }
  
  public void setStartTime(Calendar paramCalendar, boolean paramBoolean)
  {
    this.mStartTimeCalendar = ((Calendar)paramCalendar.clone());
    renderTimeView(this.mStartTimeCalendar, this.mEndTimeCalendar, paramBoolean);
  }
  
  public void setStartTimeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnStartContainerClickListener = paramOnClickListener;
    this.mStartContainerView.setOnClickListener(paramOnClickListener);
  }
  
  public void setStartTimeRawText(int paramInt1, int paramInt2)
  {
    this.mStartFirstView.setVisibility(8);
    Object localObject;
    if (paramInt1 >= 10)
    {
      localObject = "" + paramInt1;
      if (paramInt2 < 10) {
        break label197;
      }
    }
    label197:
    for (String str1 = "" + paramInt2;; str1 = "0" + paramInt2)
    {
      String str2 = getTimeDesc(paramInt1);
      localObject = new SpannableString(str2 + "  " + (String)localObject + " : " + str1);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131167535)), str2.length(), ((SpannableString)localObject).length(), 17);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(16, true), 0, str2.length(), 17);
      this.mStartSecondView.setText((CharSequence)localObject);
      return;
      localObject = "0" + paramInt1;
      break;
    }
  }
  
  public void setStartTimeViewLegal(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = getResources().getColor(2131167519);; i = getResources().getColor(2131167539))
    {
      this.mStartFirstView.setTextColor(i);
      this.mStartSecondView.setTextColor(i);
      return;
    }
  }
  
  public void setStartTimeViewSelected(boolean paramBoolean)
  {
    this.mStartContainerView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleTimeModifyView
 * JD-Core Version:    0.7.0.1
 */