package com.tencent.qqmail.activity.readmail;

import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.calendar.view.ScheduleTimeReadView;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMCalendarSyncICSWatcher;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.utilities.uitableview.UITableItemMultiView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Map;
import moai.core.watcher.Watchers;

public class ReadIcsFragment
  extends MailFragment
{
  public static final String ARG_FROM_ICS = "arg_from_ics";
  private static final int FROM_FILE = 0;
  private static final int FROM_MAIL = 1;
  private static final String TAG = "ReadIcsFragment";
  private View acceptBtn;
  private TextView acceptBtnText;
  private int accountId;
  private AccountManager accountMgr;
  private View.OnClickListener attendeeListener = new ReadIcsFragment.5(this);
  private View btnGroupLayout;
  private View.OnClickListener calendarListener = new ReadIcsFragment.3(this);
  private QMCalendarManager calendarMgr;
  private TextView calendarTextView;
  private View declineBtn;
  private TextView declineBtnText;
  private QMCalendarEvent event;
  private View.OnClickListener eventOperationListener = new ReadIcsFragment.6(this);
  private int from;
  private boolean inCalendar;
  private View infoAttendeesContainerView;
  private TextView infoAttendeesTextView;
  private View infoBelongToContainerView;
  private TextView infoBelongToTextView;
  private View infoLocationContainerView;
  private TextView infoLocationTextView;
  private View infoRemarkArrowView;
  private View infoRemarkContainerView;
  private TextView infoRemarkTextView;
  private TextView infoRemindTextView;
  private TextView infoRepeatTextView;
  private TextView infoSubjectTextView;
  private ScheduleTimeReadView infoTimeItemView;
  private boolean isCheckedInCalendar;
  private LinearLayout loadingTable;
  private ScrollView mReadEventRootScrollView;
  private QMBaseView mReadEventView;
  private QMMailManager mailMgr;
  private String mailRemoteId;
  private View.OnClickListener onBodyClickListener = new ReadIcsFragment.4(this);
  private String savePath;
  private View tentativeBtn;
  private TextView tentativeBtnText;
  private QMCalendarSyncICSWatcher watcher = new ReadIcsFragment.1(this);
  
  public ReadIcsFragment(int paramInt, String paramString)
  {
    super(true);
    this.from = 1;
    this.savePath = null;
    this.accountId = paramInt;
    this.mailRemoteId = paramString;
    this.inCalendar = false;
    this.isCheckedInCalendar = false;
    QMCalendarManager.logEvent("Event_Calendar_Preview_Ics");
  }
  
  public ReadIcsFragment(String paramString)
  {
    super(true);
    this.from = 0;
    this.savePath = paramString;
    this.accountId = 0;
    this.mailRemoteId = null;
    this.inCalendar = false;
    this.isCheckedInCalendar = false;
    QMCalendarManager.logEvent("Event_Calendar_Preview_Ics");
  }
  
  private void doRender()
  {
    label94:
    label248:
    Object localObject;
    if ((this.event.getSubject() != null) && (!this.event.getSubject().equals("")))
    {
      this.infoSubjectTextView.setVisibility(0);
      this.infoSubjectTextView.setText(this.event.getSubject());
      if ((this.event.getLocation() == null) || (this.event.getLocation().equals(""))) {
        break label385;
      }
      this.infoLocationContainerView.setVisibility(0);
      this.infoLocationTextView.setText(this.event.getLocation());
      this.infoTimeItemView.setTime(this.event.getStartTime(), this.event.getEndTime(), this.event.isAllDay(), this.event.isLunarCalendar());
      if (!this.event.isAllDay()) {
        break label397;
      }
      this.infoRemindTextView.setText(QMCalendarUtil.getStringByAllDayReminder(this.event.getReminder(), this.event.getStartTime()));
      label163:
      this.infoRepeatTextView.setText(QMCalendarUtil.getStringByRecurringType(this.event.getRecurrenceType()));
      if ((this.event.getAttendees() == null) || (this.event.getAttendees().size() <= 0)) {
        break label424;
      }
      this.infoAttendeesContainerView.setVisibility(0);
      this.infoAttendeesTextView.setText(this.event.getAttendees().size() + 1 + "");
      if (this.event.getCalderFolderId() == -1) {
        break label436;
      }
      localObject = QMCalendarManager.getInstance().getCalendarFolder(this.event.getAccountId(), this.event.getCalderFolderId());
      Drawable localDrawable = DrawBitmapUtil.drawCircle(getActivity(), QMUIHelper.getCalendarColor(getActivity(), (QMCalendarFolder)localObject), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
      this.infoBelongToContainerView.setVisibility(0);
      this.infoBelongToTextView.setText(((QMCalendarFolder)localObject).getName());
      this.infoBelongToTextView.setCompoundDrawables(localDrawable, null, null, null);
    }
    for (;;)
    {
      localObject = QMCalendarUtil.getValidateBodyText(this.event.getBody());
      if ((localObject == null) || (((String)localObject).equals(""))) {
        break label448;
      }
      this.infoRemarkContainerView.setVisibility(0);
      this.infoRemarkTextView.setText((CharSequence)localObject);
      return;
      this.infoSubjectTextView.setVisibility(8);
      break;
      label385:
      this.infoLocationContainerView.setVisibility(8);
      break label94;
      label397:
      this.infoRemindTextView.setText(QMCalendarUtil.getStringByReminder(this.event.getReminder(), this.event.getStartTime()));
      break label163;
      label424:
      this.infoAttendeesContainerView.setVisibility(8);
      break label248;
      label436:
      this.infoBelongToContainerView.setVisibility(8);
    }
    label448:
    this.infoRemarkContainerView.setVisibility(8);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131694725);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void renderCreateInCalendar()
  {
    Map localMap = this.calendarMgr.getCalendarFoldersByAccountId(this.event.getAccountId());
    if ((QMSettingManager.sharedInstance().getCalendarDisplay()) && (localMap != null) && (!localMap.isEmpty()) && (!this.event.isDecline()))
    {
      this.calendarTextView.setText(2131694730);
      this.calendarTextView.setVisibility(0);
    }
    for (;;)
    {
      setButtonBarVisibility(8);
      this.loadingTable.setVisibility(8);
      return;
      this.calendarTextView.setVisibility(8);
    }
  }
  
  private void renderLoading()
  {
    this.calendarTextView.setVisibility(8);
    setButtonBarVisibility(8);
    this.loadingTable.setVisibility(0);
  }
  
  private void renderNone()
  {
    this.calendarTextView.setVisibility(8);
    setButtonBarVisibility(8);
    this.loadingTable.setVisibility(8);
  }
  
  private void renderResponseButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      setButtonBarVisibility(8);
      return;
    case 3: 
      this.acceptBtn.setBackgroundResource(2130839031);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167654));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840930), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130851774);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167170));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840933), null, null, null);
      this.declineBtn.setBackgroundResource(2130851774);
      this.declineBtnText.setTextColor(getResources().getColor(2131167173));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840931), null, null, null);
      this.acceptBtn.setClickable(false);
      this.tentativeBtn.setClickable(true);
      this.declineBtn.setClickable(true);
      setButtonBarVisibility(0);
      return;
    case 2: 
      this.acceptBtn.setBackgroundResource(2130851774);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167171));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840929), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130839030);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167654));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840934), null, null, null);
      this.declineBtn.setBackgroundResource(2130851774);
      this.declineBtnText.setTextColor(getResources().getColor(2131167173));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840931), null, null, null);
      this.acceptBtn.setClickable(true);
      this.tentativeBtn.setClickable(false);
      this.declineBtn.setClickable(true);
      setButtonBarVisibility(0);
      return;
    case 4: 
      this.acceptBtn.setBackgroundResource(2130851774);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167171));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840929), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130851774);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167170));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840933), null, null, null);
      this.declineBtn.setBackgroundResource(2130839033);
      this.declineBtnText.setTextColor(getResources().getColor(2131167654));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840932), null, null, null);
      this.acceptBtn.setClickable(true);
      this.tentativeBtn.setClickable(true);
      this.declineBtn.setClickable(false);
      setButtonBarVisibility(0);
      return;
    }
    setButtonBarVisibility(0);
  }
  
  private void renderViewInCalendar()
  {
    if (QMSettingManager.sharedInstance().getCalendarDisplay())
    {
      this.calendarTextView.setText(2131694732);
      this.calendarTextView.setVisibility(0);
      if ((this.event.getMeetingStatus() == 5) || (this.event.getMeetingStatus() == 7) || (this.event.getMeetingStatus() == 13) || (this.event.getMeetingStatus() == 15)) {
        setButtonBarVisibility(8);
      }
    }
    for (;;)
    {
      this.loadingTable.setVisibility(8);
      return;
      renderResponseButton(this.event.getAppointmentType());
      continue;
      this.calendarTextView.setVisibility(8);
      setButtonBarVisibility(8);
    }
  }
  
  private void setButtonBarVisibility(int paramInt)
  {
    this.btnGroupLayout.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (paramInt = getResources().getDimensionPixelSize(2131299250);; paramInt = 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mReadEventRootScrollView.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramInt);
      this.mReadEventRootScrollView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void initDataSource()
  {
    this.accountMgr = AccountManager.shareInstance();
    this.calendarMgr = QMCalendarManager.getInstance();
    this.mailMgr = QMMailManager.sharedInstance();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    this.mReadEventView.getScrollBodyView().setPadding(0, 0, 0, this.mReadEventView.getScrollBodyView().getPaddingBottom());
    paramView = new UITableContainer(getActivity());
    this.mReadEventView.addContentView(paramView);
    paramViewHolder = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    paramViewHolder.setMargins(paramViewHolder.leftMargin, QMUIKit.dpToPx(-1), paramViewHolder.rightMargin, paramViewHolder.bottomMargin);
    paramView.setLayoutParams(paramViewHolder);
    paramViewHolder = new UITableItemMultiView(getActivity());
    paramView.addItem(paramViewHolder);
    paramViewHolder.setCustomerPaddingLeft(0);
    paramViewHolder.setCustomerPaddingRight(0);
    paramView = paramViewHolder.setLayoutFromXml(2131558807);
    this.infoSubjectTextView = ((TextView)paramView.findViewById(2131369250));
    this.infoLocationContainerView = paramView.findViewById(2131369238);
    this.infoLocationTextView = ((TextView)paramView.findViewById(2131369237));
    this.infoTimeItemView = ((ScheduleTimeReadView)paramView.findViewById(2131369252));
    this.infoRepeatTextView = ((TextView)paramView.findViewById(2131369246));
    this.infoRemindTextView = ((TextView)paramView.findViewById(2131369245));
    this.infoBelongToContainerView = paramView.findViewById(2131369160);
    this.infoBelongToTextView = ((TextView)paramView.findViewById(2131369159));
    this.infoAttendeesContainerView = paramView.findViewById(2131369158);
    this.infoAttendeesTextView = ((TextView)paramView.findViewById(2131369157));
    this.infoRemarkContainerView = paramView.findViewById(2131369244);
    this.infoRemarkArrowView = paramView.findViewById(2131369243);
    this.infoRemarkTextView = ((TextView)paramView.findViewById(2131369242));
    this.infoAttendeesContainerView.setOnClickListener(this.attendeeListener);
    this.infoRemarkTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ReadIcsFragment.2(this));
    this.loadingTable = UITableItemFactory.addLoadingView(getActivity());
    this.mReadEventView.addContentView(this.loadingTable);
    this.calendarTextView = UITableItemFactory.addCenterTextView(getActivity());
    this.calendarTextView.setText(2131694730);
    this.calendarTextView.setOnClickListener(this.calendarListener);
    this.mReadEventView.addContentView(this.calendarTextView);
    this.btnGroupLayout = LayoutInflater.from(getActivity()).inflate(2131562906, null);
    this.acceptBtn = this.btnGroupLayout.findViewById(2131376650);
    this.tentativeBtn = this.btnGroupLayout.findViewById(2131376654);
    this.declineBtn = this.btnGroupLayout.findViewById(2131376652);
    this.acceptBtnText = ((TextView)this.acceptBtn.findViewById(2131376651));
    this.tentativeBtnText = ((TextView)this.tentativeBtn.findViewById(2131376655));
    this.declineBtnText = ((TextView)this.declineBtn.findViewById(2131376653));
    this.acceptBtn.setOnClickListener(this.eventOperationListener);
    this.tentativeBtn.setOnClickListener(this.eventOperationListener);
    this.declineBtn.setOnClickListener(this.eventOperationListener);
    paramView = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299250), 80);
    this.btnGroupLayout.setLayoutParams(paramView);
    this.mReadEventView.addView(this.btnGroupLayout);
    this.mReadEventRootScrollView = this.mReadEventView.getRootScrollView();
    setButtonBarVisibility(0);
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mReadEventView = new QMBaseView(getActivity());
    this.mReadEventView.initScrollView();
    this.mReadEventView.setBackgroundColor(getResources().getColor(2131167681));
    return this.mReadEventView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.watcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    this.infoAttendeesContainerView.setOnClickListener(null);
    this.infoRemarkContainerView.setOnClickListener(null);
    this.calendarTextView.setOnClickListener(null);
    this.acceptBtn.setOnClickListener(null);
    this.tentativeBtn.setOnClickListener(null);
    this.declineBtn.setOnClickListener(null);
  }
  
  public int refreshData()
  {
    if (this.from == 0) {
      this.event = this.mailMgr.getIcsEventFromFile(this.savePath);
    }
    for (;;)
    {
      if (this.event == null) {
        popBackStack();
      }
      return 0;
      if (this.from == 1)
      {
        if ((this.mailRemoteId != null) && (this.accountId != 0))
        {
          QMCalendarEvent localQMCalendarEvent = this.mailMgr.getIcsEventByRemoteMailId(this.mailRemoteId, this.accountId);
          if (localQMCalendarEvent != null)
          {
            this.event = localQMCalendarEvent;
            localQMCalendarEvent = this.calendarMgr.getCalendarEventByUid(this.event.getUid(), this.event.getAccountId());
            if (localQMCalendarEvent == null)
            {
              this.inCalendar = false;
              if (!this.isCheckedInCalendar) {
                this.calendarMgr.loadIcsEventsByAccount(this.accountMgr.getAccountList().getAccountById(this.event.getAccountId()));
              }
            }
            else
            {
              this.event = localQMCalendarEvent;
              this.inCalendar = true;
            }
          }
        }
      }
      else {
        popBackStack();
      }
    }
  }
  
  public void render(int paramInt)
  {
    doRender();
    if (this.from == 0)
    {
      renderNone();
      return;
    }
    if (this.inCalendar)
    {
      renderViewInCalendar();
      return;
    }
    if ((!this.inCalendar) && (this.isCheckedInCalendar))
    {
      renderCreateInCalendar();
      return;
    }
    if ((!this.inCalendar) && (!this.isCheckedInCalendar))
    {
      renderLoading();
      return;
    }
    renderCreateInCalendar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment
 * JD-Core Version:    0.7.0.1
 */