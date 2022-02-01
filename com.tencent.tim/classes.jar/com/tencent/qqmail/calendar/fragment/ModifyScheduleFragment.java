package com.tencent.qqmail.calendar.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.data.ScheduleListCursor;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarManager.CalendarCreateType;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.reminder.QMReminderer;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.view.DataPickerViewGroup;
import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.calendar.view.PopupFrame;
import com.tencent.qqmail.calendar.view.ScheduleTimeModifyView;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomCustomBuilder;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView;
import com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView.OnCheckChangeListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.utilities.uitableview.UITableItemTextView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;
import org.apache.commons.lang3.StringUtils;

public class ModifyScheduleFragment
  extends CalendarBaseFragment
  implements View.OnClickListener, EventChecker.EventCheckerListener, DataPickerViewGroup.DatePickerListener
{
  private static int CHOSE_LIST_TYPE_ACCOUNT = 0;
  private static int CHOSE_LIST_TYPE_FOLDER = 1;
  private final int EDIT_TYPE_CANCEL = -1;
  private final int EDIT_TYPE_CREATE = 1;
  private final int EDIT_TYPE_MODIFY = 2;
  private int EditType;
  private UITableItemTextView eventBelongToItemView;
  private UITableItemCheckBoxView eventIsAllDayItemView;
  private EditText eventLocationEditText;
  private UITableItemTextView eventRecurringItemView;
  private EditText eventRemarksEditText;
  private UITableItemTextView eventRemindItemView;
  private EditText eventSubjectItemView;
  private ScheduleTimeModifyView eventTimeItemView;
  private boolean isEndTimeModifiedByUser;
  private boolean isRelated;
  private boolean isStartTimeModifiedAfter;
  private List<HashMap<String, Object>> mAccountData;
  private QMCalendarManager.CalendarCreateType mCreateType = QMCalendarManager.CalendarCreateType.CREATE_NONE;
  private QMCalendarEvent mCurrentEvent;
  private boolean mCurrentShowKeyboard = false;
  private UITableContainer mEventAllDayTable;
  private UITableContainer mEventAttributeTable;
  private UITableContainer mEventTimeTable;
  private QMBaseView mModifyEventView;
  private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = null;
  private QMCalendarEvent mOriginalEvent;
  private PopupFrame mPopupFrame;
  private QMSchedule mSchedule;
  private int modifyTimeItemId;
  private UITableItemCheckBoxView.OnCheckChangeListener onCheckListener = new ModifyScheduleFragment.4(this);
  private QMCalendarManager qmCalendarManager = QMCalendarManager.getInstance();
  private ScheduleUpdateWatcher scheduleUpdateWatcher = new ModifyScheduleFragment.1(this);
  private Calendar selectDay;
  private String startTimeHandleEvent;
  
  public ModifyScheduleFragment(long paramLong, String paramString, boolean paramBoolean)
  {
    super(false);
    this.mCreateType = QMCalendarManager.CalendarCreateType.CREATE_BY_CONTENT_DETECT;
    this.EditType = 1;
    this.selectDay = Calendar.getInstance();
    paramLong = QMCalendarUtil.correctTimeToSecond(paramLong);
    this.selectDay.setTimeInMillis(paramLong);
    if (paramBoolean)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      localCalendar.set(11, 9);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      this.mCurrentEvent = new QMCalendarEvent(localCalendar.getTimeInMillis(), localCalendar.getTimeInMillis() + this.qmCalendarManager.getDefaultEventDuration() * 60000);
      this.mCurrentEvent.setReminder(0);
    }
    for (;;)
    {
      this.mCurrentEvent.setSubject(paramString);
      if (QMCalendarManager.getInstance().getDefaultAccountId() == 0) {
        this.mCurrentEvent.setCategory(1);
      }
      this.mCurrentEvent.setUntil(new GregorianCalendar(2036, 11, 31).getTimeInMillis());
      this.mCurrentEvent.setIsAllDay(paramBoolean);
      int i = this.qmCalendarManager.getDefaultAccountId();
      int j = this.qmCalendarManager.getDefaultFolderId();
      this.mCurrentEvent.setAccountId(i);
      this.mCurrentEvent.setCalderFolderId(j);
      paramString = QMCalendarManager.getInstance().getCalendarFolder(i, j);
      if (paramString != null)
      {
        this.mCurrentEvent.setAccountName(paramString.getAccountName());
        this.mCurrentEvent.setAccountType(paramString.getAccountType());
      }
      this.mOriginalEvent = ((QMCalendarEvent)this.mCurrentEvent.clone());
      return;
      this.mCurrentEvent = new QMCalendarEvent(paramLong, this.qmCalendarManager.getDefaultEventDuration() * 60000 + paramLong);
      this.mCurrentEvent.setReminder(this.qmCalendarManager.getDefaultReminderTime());
    }
  }
  
  protected ModifyScheduleFragment(QMCalendarEvent paramQMCalendarEvent, QMSchedule paramQMSchedule)
  {
    super(false);
    this.EditType = 2;
    this.mCurrentEvent = ((QMCalendarEvent)paramQMCalendarEvent.clone());
    this.mSchedule = paramQMSchedule;
    if (this.mCurrentEvent.isAllDay())
    {
      paramQMCalendarEvent = Calendar.getInstance();
      paramQMCalendarEvent.setTimeInMillis(this.mCurrentEvent.getStartTime());
      paramQMCalendarEvent.set(11, 9);
      paramQMCalendarEvent.set(12, 0);
      paramQMCalendarEvent.set(13, 0);
      this.mCurrentEvent.setStartTime(paramQMCalendarEvent.getTimeInMillis());
      if (QMCalendarUtil.compareTime(this.mCurrentEvent.getStartTime(), this.mCurrentEvent.getEndTime() - 1000L, this.mCurrentEvent.isAllDay()) != 0) {
        break label216;
      }
      this.mCurrentEvent.setEndTime(paramQMCalendarEvent.getTimeInMillis() + this.qmCalendarManager.getDefaultEventDuration() * 60000);
    }
    for (;;)
    {
      this.mOriginalEvent = ((QMCalendarEvent)this.mCurrentEvent.clone());
      return;
      label216:
      paramQMCalendarEvent.setTimeInMillis(this.mCurrentEvent.getEndTime());
      paramQMCalendarEvent.add(13, -1);
      paramQMCalendarEvent.set(11, 9);
      paramQMCalendarEvent.set(12, 0);
      paramQMCalendarEvent.set(13, 0);
      this.mCurrentEvent.setEndTime(paramQMCalendarEvent.getTimeInMillis());
    }
  }
  
  protected ModifyScheduleFragment(Calendar paramCalendar)
  {
    super(false);
    this.mCreateType = QMCalendarManager.CalendarCreateType.CREATE_MANUALLY;
    this.EditType = 1;
    this.selectDay = paramCalendar;
    long l = QMCalendarUtil.correctTimeToSecond(paramCalendar.getTimeInMillis());
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    ScheduleListCursor localScheduleListCursor = new ScheduleListCursor(paramCalendar);
    QMSchedule localQMSchedule = null;
    if (localScheduleListCursor.getCount() > 0) {
      localQMSchedule = localScheduleListCursor.getItem(localScheduleListCursor.getCount() - 1);
    }
    int j;
    int k;
    if ((localQMSchedule != null) && (localQMSchedule.getStartTime() > localCalendar1.getTimeInMillis()) && (QMCalendarUtil.getDiffDays(localQMSchedule.getEventStartTime(), paramCalendar.getTimeInMillis()) == 0))
    {
      localCalendar2.setTimeInMillis(localQMSchedule.getStartTime());
      localCalendar2.add(11, 1);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      localScheduleListCursor.close();
      this.mCurrentEvent = new QMCalendarEvent(localCalendar2.getTimeInMillis(), localCalendar2.getTimeInMillis() + this.qmCalendarManager.getDefaultEventDuration() * 60000);
      this.mCurrentEvent.setIsAllDay(false);
      this.mCurrentEvent.setAccountId(QMCalendarManager.getInstance().getDefaultAccountId());
      this.mCurrentEvent.setCalderFolderId(QMCalendarManager.getInstance().getDefaultFolderId());
      this.mCurrentEvent.setReminder(this.qmCalendarManager.getDefaultReminderTime());
      j = this.qmCalendarManager.getDefaultAccountId();
      k = this.qmCalendarManager.getDefaultFolderId();
      this.mCurrentEvent.setAccountId(j);
      this.mCurrentEvent.setCalderFolderId(k);
      paramCalendar = this.mCurrentEvent;
      if (j != 0) {
        break label511;
      }
    }
    label511:
    for (int i = 1;; i = 0)
    {
      paramCalendar.setCategory(i);
      paramCalendar = QMCalendarManager.getInstance().getCalendarFolder(j, k);
      if (paramCalendar != null)
      {
        this.mCurrentEvent.setAccountName(paramCalendar.getAccountName());
        this.mCurrentEvent.setAccountType(paramCalendar.getAccountType());
      }
      this.mOriginalEvent = ((QMCalendarEvent)this.mCurrentEvent.clone());
      return;
      localCalendar2.setTimeInMillis(l);
      if (localCalendar2.get(11) >= 23)
      {
        if (QMCalendarUtil.getDiffDays(localCalendar1, localCalendar2) != 0)
        {
          localCalendar2.set(11, 0);
          localCalendar2.set(12, 0);
          localCalendar2.set(13, 0);
          break;
        }
        localCalendar2.setTimeInMillis(l);
        localCalendar2.add(11, 1);
        localCalendar2.set(12, 0);
        localCalendar2.set(13, 0);
        break;
      }
      localCalendar2.add(11, 1);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      break;
    }
  }
  
  public ModifyScheduleFragment(Calendar paramCalendar, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this(paramCalendar);
    this.mCreateType = convertRelatedTypeToCreateType(paramInt1);
    this.isRelated = true;
    this.mCurrentEvent.setRelateType(paramInt1);
    this.mCurrentEvent.setRelateAccountId(paramInt2);
    this.mCurrentEvent.setRelatedId(paramString1);
    this.mCurrentEvent.setSubject(paramString2);
    this.mOriginalEvent = ((QMCalendarEvent)this.mCurrentEvent.clone());
  }
  
  private QMCalendarManager.CalendarCreateType convertRelatedTypeToCreateType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return QMCalendarManager.CalendarCreateType.CREATE_NONE;
    case 1: 
      return QMCalendarManager.CalendarCreateType.CREATE_BY_RELATED_MAIL;
    }
    return QMCalendarManager.CalendarCreateType.CREATE_BY_RELATED_NOTE;
  }
  
  private void deleteEvent(QMCalendarEvent paramQMCalendarEvent, int paramInt, QMSchedule paramQMSchedule)
  {
    if (paramQMCalendarEvent.getCategory() == 1)
    {
      CalendarProviderManager.sharedInstance().deleteLocalEvent(paramQMCalendarEvent.getId(), paramInt, paramQMSchedule);
      return;
    }
    QMCalendarManager.getInstance().deleteEvent(paramQMCalendarEvent.getId(), paramInt, paramQMSchedule);
  }
  
  private List<HashMap<String, Object>> getAccountData()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = Lists.newArrayList();
    if ((this.EditType == 1) || ((this.EditType == 2) && (this.mOriginalEvent.getCategory() != 1))) {
      ((List)localObject1).addAll(AccountManager.shareInstance().getAccountList().toArrayList());
    }
    if ((this.EditType == 1) || ((this.EditType == 2) && (this.mOriginalEvent.getCategory() == 1))) {
      ((List)localObject1).add(QMCalendarManager.getInstance().getLocalAccount());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Account localAccount = (Account)((Iterator)localObject1).next();
      Object localObject2 = QMCalendarManager.getInstance().getSortedCalendarFoldersByAccountId(localAccount.getId());
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        int j;
        for (int i = 0; ((Iterator)localObject2).hasNext(); i = j)
        {
          QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((Iterator)localObject2).next();
          j = i;
          if (localQMCalendarFolder.isEditable())
          {
            j = i;
            if (localQMCalendarFolder.isSelfFolder())
            {
              j = i;
              if (i == 0)
              {
                localHashMap = new HashMap();
                localHashMap.put("type", Integer.valueOf(CHOSE_LIST_TYPE_ACCOUNT));
                localHashMap.put("account", localAccount);
                localArrayList.add(localHashMap);
                j = 1;
              }
              HashMap localHashMap = new HashMap();
              localHashMap.put("type", Integer.valueOf(CHOSE_LIST_TYPE_FOLDER));
              localHashMap.put("folder", localQMCalendarFolder);
              localHashMap.put("folderName", localQMCalendarFolder.getName());
              localArrayList.add(localHashMap);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private String getAccountTitle(Account paramAccount)
  {
    QMCalendarProtocolManager.LoginType localLoginType = QMCalendarProtocolManager.getLoginType(paramAccount, 0);
    if (paramAccount.getId() == 0) {
      return paramAccount.getName();
    }
    if (localLoginType.getAccountType() == 0)
    {
      if (paramAccount.getProtocol() != 14) {
        break label83;
      }
      localLoginType.setAccountType(1);
      localLoginType.setName("Exchange");
    }
    for (;;)
    {
      return localLoginType.getName() + "(" + paramAccount.getEmail() + ")";
      label83:
      localLoginType.setAccountType(2);
      localLoginType.setName("CalDAV");
    }
  }
  
  private String getBelongCalendarName(QMCalendarFolder paramQMCalendarFolder)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramQMCalendarFolder.getAccountId());
    if (localAccount != null)
    {
      if ((localAccount.isQQMail()) && (AccountManager.shareInstance().getAccountList().getQQMailAccountNumber() == 1)) {
        return paramQMCalendarFolder.getName() + "(QQ)";
      }
      if ((localAccount.isTencentDotCom()) && (AccountManager.shareInstance().getAccountList().getQQMailAccountNumber() == 1)) {
        return paramQMCalendarFolder.getName() + "(Tencent)";
      }
      return paramQMCalendarFolder.getName() + "(" + localAccount.getEmail() + ")";
    }
    return paramQMCalendarFolder.getName() + "(系统日历)";
  }
  
  private void logOnCreate()
  {
    if (this.isEndTimeModifiedByUser) {
      QMCalendarManager.logEvent("Event_Calendar_Create_Change_EndTime");
    }
    if (this.isStartTimeModifiedAfter) {
      QMCalendarManager.logEvent("Event_Calendar_Create_Change_EndTime_Then_StartTime");
    }
    if (this.startTimeHandleEvent != null)
    {
      QMCalendarManager.logEvent(this.startTimeHandleEvent);
      this.startTimeHandleEvent = null;
    }
  }
  
  private void modifyTime(Calendar paramCalendar, int paramInt)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramInt == 2131366556) {
      if (this.mCurrentEvent.isAllDay())
      {
        localGregorianCalendar.setTimeInMillis(this.mCurrentEvent.getStartTime());
        localGregorianCalendar.set(1, paramCalendar.get(1));
        localGregorianCalendar.set(2, paramCalendar.get(2));
        localGregorianCalendar.set(5, paramCalendar.get(5));
        this.eventTimeItemView.setStartTime(localGregorianCalendar, this.mCurrentEvent.isAllDay());
        this.mCurrentEvent.setStartTime(localGregorianCalendar.getTimeInMillis());
        if (this.isEndTimeModifiedByUser) {
          break label223;
        }
        if (!this.mCurrentEvent.isAllDay()) {
          localGregorianCalendar.setTimeInMillis(localGregorianCalendar.getTimeInMillis() + (this.mOriginalEvent.getEndTime() - this.mOriginalEvent.getStartTime()));
        }
        this.eventTimeItemView.setEndTime(localGregorianCalendar, this.mCurrentEvent.isAllDay());
        this.mCurrentEvent.setEndTime(localGregorianCalendar.getTimeInMillis());
        if (this.mPopupFrame.getContentView() != null) {
          this.startTimeHandleEvent = ((DataPickerViewGroup)this.mPopupFrame.getContentView()).getLogEvent();
        }
      }
    }
    label223:
    while (paramInt != 2131366553) {
      for (;;)
      {
        setTimeColor(this.mCurrentEvent.getStartTime(), this.mCurrentEvent.getEndTime(), this.mCurrentEvent.isAllDay());
        return;
        localGregorianCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
        continue;
        this.isStartTimeModifiedAfter = true;
      }
    }
    this.isEndTimeModifiedByUser = true;
    if (this.mCurrentEvent.isAllDay())
    {
      localGregorianCalendar.setTimeInMillis(this.mCurrentEvent.getEndTime());
      localGregorianCalendar.set(1, paramCalendar.get(1));
      localGregorianCalendar.set(2, paramCalendar.get(2));
      localGregorianCalendar.set(5, paramCalendar.get(5));
    }
    for (;;)
    {
      this.eventTimeItemView.setEndTime(localGregorianCalendar, this.mCurrentEvent.isAllDay());
      this.mCurrentEvent.setEndTime(localGregorianCalendar.getTimeInMillis());
      break;
      localGregorianCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    }
  }
  
  private void observeKeyboard(boolean paramBoolean)
  {
    QMBaseView localQMBaseView = this.mModifyEventView;
    if (paramBoolean)
    {
      if (this.mOnGlobalLayoutListener == null) {
        this.mOnGlobalLayoutListener = new ModifyScheduleFragment.9(this, localQMBaseView);
      }
      localQMBaseView.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
      return;
    }
    localQMBaseView.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    this.mOnGlobalLayoutListener = null;
  }
  
  private void onShowKeyboard(boolean paramBoolean)
  {
    if (paramBoolean) {}
    View localView;
    do
    {
      return;
      localView = getActivity().getCurrentFocus();
    } while (localView == null);
    localView.clearFocus();
    this.eventSubjectItemView.setFocusable(false);
    this.eventLocationEditText.setFocusable(false);
    this.eventRemarksEditText.setFocusable(false);
    this.eventSubjectItemView.setFocusable(true);
    this.eventSubjectItemView.setFocusableInTouchMode(true);
    this.eventLocationEditText.setFocusable(true);
    this.eventLocationEditText.setFocusableInTouchMode(true);
    this.eventRemarksEditText.setFocusable(true);
    this.eventRemarksEditText.setFocusableInTouchMode(true);
  }
  
  private void setTimeColor(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QMCalendarUtil.compareTime(paramLong1, paramLong2, paramBoolean) <= 0)
    {
      this.eventTimeItemView.setEndTimeViewLegal(true);
      return;
    }
    this.eventTimeItemView.setEndTimeViewLegal(false);
  }
  
  private void showAccountChoseDialog()
  {
    Object localObject = new QMBottomDialog.BottomCustomBuilder(getActivity());
    ((QMBottomDialog.BottomCustomBuilder)localObject).setTitle(2131691226);
    ((QMBottomDialog.BottomCustomBuilder)localObject).setLayoutId(2131558803);
    localObject = ((QMBottomDialog.BottomCustomBuilder)localObject).build();
    ListView localListView = (ListView)((QMBottomDialog)localObject).findViewById(2131370584);
    if (this.mAccountData == null) {
      this.mAccountData = getAccountData();
    }
    MyAdapter localMyAdapter = new MyAdapter(getActivity());
    localListView.setAdapter(localMyAdapter);
    localListView.setOnItemClickListener(new ModifyScheduleFragment.8(this, localMyAdapter, (QMBottomDialog)localObject));
    ((QMBottomDialog)localObject).show();
    ((QMBottomDialog)localObject).setCanceledOnTouchOutside(true);
  }
  
  private void showAllDayRemindChoseDialog()
  {
    int k = 0;
    Object localObject = new int[5];
    Object tmp9_7 = localObject;
    tmp9_7[0] = -1;
    Object tmp13_9 = tmp9_7;
    tmp13_9[1] = 0;
    Object tmp17_13 = tmp13_9;
    tmp17_13[2] = 900;
    Object tmp23_17 = tmp17_13;
    tmp23_17[3] = 2340;
    Object tmp29_23 = tmp23_17;
    tmp29_23[4] = 9540;
    tmp29_23;
    int i = 0;
    int j = -1;
    while (i < localObject.length)
    {
      if (this.mCurrentEvent.getReminder() == localObject[i]) {
        j = i;
      }
      i += 1;
    }
    localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity(), true);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(2131691146);
    if (j == -1) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(QMCalendarUtil.getStringByAllDayReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()), String.valueOf(this.mCurrentEvent.getReminder()));
    }
    for (i = k;; i = j)
    {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691138), "-1");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691144), "0");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691140), "900");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691145), "2340");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691143), "9540");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(i);
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ModifyScheduleFragment.6(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).show();
      ((QMBottomDialog)localObject).setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  private void showRecurringChoseDialog()
  {
    int k = 0;
    Object localObject = new int[6];
    Object tmp10_8 = localObject;
    tmp10_8[0] = -1;
    Object tmp14_10 = tmp10_8;
    tmp14_10[1] = 0;
    Object tmp18_14 = tmp14_10;
    tmp18_14[2] = 7;
    Object tmp23_18 = tmp18_14;
    tmp23_18[3] = 1;
    Object tmp27_23 = tmp23_18;
    tmp27_23[4] = 2;
    Object tmp31_27 = tmp27_23;
    tmp31_27[5] = 5;
    tmp31_27;
    int j = -1;
    int i = 0;
    while (i < localObject.length)
    {
      if (this.mCurrentEvent.getRecurrenceType() == localObject[i]) {
        j = i;
      }
      i += 1;
    }
    localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity(), true);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(2131691119);
    if (!QMCalendarUtil.isRecurrenceSupported(this.mCurrentEvent)) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(QMCalendarUtil.createReadableStringOfRecurrence(this.mCurrentEvent), String.valueOf(this.mCurrentEvent.getRecurrenceType()));
    }
    for (i = k;; i = j)
    {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691115), "-1");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691113), "0");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691117), "7");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691116), "1");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691114), "2");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691118), "5");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(i);
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ModifyScheduleFragment.7(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).show();
      ((QMBottomDialog)localObject).setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  private void showRemindChoseDialog()
  {
    int k = 0;
    Object localObject = new int[6];
    Object tmp10_8 = localObject;
    tmp10_8[0] = -1;
    Object tmp14_10 = tmp10_8;
    tmp14_10[1] = 0;
    Object tmp18_14 = tmp14_10;
    tmp18_14[2] = 5;
    Object tmp22_18 = tmp18_14;
    tmp22_18[3] = 15;
    Object tmp27_22 = tmp22_18;
    tmp27_22[4] = 60;
    Object tmp32_27 = tmp27_22;
    tmp32_27[5] = 1440;
    tmp32_27;
    int i = 0;
    int j = -1;
    while (i < localObject.length)
    {
      if (this.mCurrentEvent.getReminder() == localObject[i]) {
        j = i;
      }
      i += 1;
    }
    localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity(), true);
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(2131691146);
    if (j == -1) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(QMCalendarUtil.getStringByReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()), String.valueOf(this.mCurrentEvent.getReminder()));
    }
    for (i = k;; i = j)
    {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691138), "-1");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691135), "0");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691137), "5");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691136), "15");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691141), "60");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691139), "1440");
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(i);
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ModifyScheduleFragment.5(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).show();
      ((QMBottomDialog)localObject).setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  public void createEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent.getRecurrenceType() == 7) {
      this.qmCalendarManager.verifyRecurrenceEventTime(paramQMCalendarEvent);
    }
    if (paramQMCalendarEvent.getCategory() != 1)
    {
      this.qmCalendarManager.createEvent(paramQMCalendarEvent);
      return;
    }
    CalendarProviderManager.sharedInstance().createLocalEvent(paramQMCalendarEvent);
  }
  
  public void finish()
  {
    super.finish();
    getActivity().overridePendingTransition(2130772430, 2130772402);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if (this.mCurrentEvent.getAppointmentType() != 0)
    {
      this.mEventAttributeTable = new UITableContainer(getActivity());
      this.eventRemindItemView = new UITableItemTextView(getActivity());
      this.eventRemindItemView.setTitle(2131691146);
      this.eventRemindItemView.setTextWithGrayStyle(getString(2131691138));
      this.mEventAttributeTable.addItem(this.eventRemindItemView);
      this.mModifyEventView.addContentView(this.mEventAttributeTable);
      return;
    }
    this.eventSubjectItemView = UITableItemFactory.addEditText(getActivity(), UITableItemFactory.UITableItemTypeSingle);
    this.eventSubjectItemView.setGravity(16);
    this.eventSubjectItemView.setMinimumHeight(getResources().getDimensionPixelSize(2131299351));
    paramView = this.eventSubjectItemView;
    int i;
    if (this.EditType == 1)
    {
      i = 2131691066;
      label145:
      paramView.setHint(i);
      this.eventSubjectItemView.setTextSize(2, 20.0F);
      this.mModifyEventView.addContentView(this.eventSubjectItemView);
      this.mEventTimeTable = new UITableContainer(getActivity());
      this.mEventTimeTable.setBackgroundClickable(false);
      this.mModifyEventView.addContentView(this.mEventTimeTable);
      this.eventTimeItemView = new ScheduleTimeModifyView(getActivity());
      this.mEventTimeTable.addItem(this.eventTimeItemView);
      this.eventIsAllDayItemView = new UITableItemCheckBoxView(getActivity());
      this.eventIsAllDayItemView.setTitle(2131691112);
      this.eventIsAllDayItemView.setChecked(false);
      this.eventIsAllDayItemView.setOnCheckChangeListener(this.onCheckListener);
      this.mEventAllDayTable = new UITableContainer(getActivity());
      this.mEventAllDayTable.addItem(this.eventIsAllDayItemView);
      this.mModifyEventView.addContentView(this.mEventAllDayTable);
      this.mEventAttributeTable = new UITableContainer(getActivity());
      this.eventRemindItemView = new UITableItemTextView(getActivity());
      this.eventRemindItemView.setTitle(2131691146);
      this.eventRemindItemView.setTextWithGrayStyle(getString(2131691138));
      this.eventRecurringItemView = new UITableItemTextView(getActivity());
      this.eventRecurringItemView.setTitle(2131691119);
      this.eventRecurringItemView.setTextWithGrayStyle(getString(2131691115));
      this.eventBelongToItemView = new UITableItemTextView(getActivity());
      this.eventBelongToItemView.setTitle(2131691226);
      this.eventBelongToItemView.setTextWithGrayStyle(getString(2131691095));
      this.mEventAttributeTable.addItem(this.eventRemindItemView);
      this.mEventAttributeTable.addItem(this.eventRecurringItemView);
      this.mEventAttributeTable.addItem(this.eventBelongToItemView);
      this.mModifyEventView.addContentView(this.mEventAttributeTable);
      this.eventLocationEditText = UITableItemFactory.addEditText(getActivity(), UITableItemFactory.UITableItemTypeTop);
      this.eventLocationEditText.setHint(2131691120);
      this.eventLocationEditText.setSingleLine(true);
      this.mModifyEventView.addContentView(this.eventLocationEditText);
      this.eventRemarksEditText = UITableItemFactory.addEditText(getActivity(), UITableItemFactory.UITableItemTypeBottom);
      this.eventRemarksEditText.setHint(2131691133);
      this.eventRemarksEditText.setMinLines(4);
      this.mModifyEventView.addContentView(this.eventRemarksEditText);
      if (this.EditType != 1) {
        break label651;
      }
      this.eventSubjectItemView.setText(this.mCurrentEvent.getSubject());
    }
    for (;;)
    {
      KeyBoardHelper.showSoftInputDelay(this.eventSubjectItemView, 300L);
      if ((this.mCurrentEvent == null) || (this.mCurrentEvent.getSubject() == null)) {
        break;
      }
      this.eventSubjectItemView.setSelection(this.mCurrentEvent.getSubject().length());
      return;
      i = 2131691149;
      break label145;
      label651:
      if (this.mCurrentEvent.isLunarCalendar())
      {
        this.mEventTimeTable.setVisibility(8);
        this.mEventAllDayTable.setVisibility(8);
        this.eventRecurringItemView.setVisibility(8);
        this.eventBelongToItemView.setVisibility(8);
      }
      this.eventSubjectItemView.setText(this.mCurrentEvent.getSubject());
      this.eventLocationEditText.setText(this.mCurrentEvent.getLocation());
      this.eventRemarksEditText.setText(this.mCurrentEvent.getBody());
    }
  }
  
  public void initTopbar(View paramView)
  {
    paramView = new QMTopBar(getActivity());
    this.mModifyEventView.addView(paramView);
    Resources localResources = getResources();
    if (this.EditType == 1) {}
    for (int i = 2131691066;; i = 2131691090)
    {
      paramView.setTitle(localResources.getString(i));
      paramView.setButtonLeftNormal(2131691088);
      paramView.setButtonRightBlue(2131691089);
      paramView.setButtonLeftOnclickListener(new ModifyScheduleFragment.2(this));
      paramView.setButtonRightOnclickListener(new ModifyScheduleFragment.3(this));
      return;
    }
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mModifyEventView = new QMBaseView(getActivity());
    this.mModifyEventView.initScrollView();
    this.mModifyEventView.setBackgroundColor(getResources().getColor(2131167681));
    return this.mModifyEventView;
  }
  
  public void modifyEvent(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, Solution paramSolution)
  {
    if (paramQMCalendarEvent1.getCategory() == 1) {
      CalendarProviderManager.sharedInstance().modifyLocalEvent(paramQMCalendarEvent1, paramQMCalendarEvent2, this.mSchedule, paramSolution.getModifyType());
    }
    do
    {
      return;
      paramQMCalendarEvent2.setModifyTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
      if ((paramQMCalendarEvent1.getRelateAccountId() == 0) && (this.isRelated)) {
        paramQMCalendarEvent2.setRelateAccountId(paramQMCalendarEvent2.getAccountId());
      }
      if ((paramQMCalendarEvent2.getAccountId() != paramQMCalendarEvent1.getAccountId()) || (paramQMCalendarEvent2.getCalderFolderId() != paramQMCalendarEvent1.getCalderFolderId()))
      {
        Object localObject = AccountManager.shareInstance().getAccountList();
        Account localAccount = ((AccountList)localObject).getAccountById(paramQMCalendarEvent1.getAccountId());
        localObject = ((AccountList)localObject).getAccountById(paramQMCalendarEvent2.getAccountId());
        if ((localAccount != null) && (localAccount.isQQMail()) && (localObject != null) && (!((Account)localObject).isQQMail()) && (paramQMCalendarEvent2.getReminder() < 0)) {
          paramQMCalendarEvent2.setReminder(0);
        }
        deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
        if ((!paramQMCalendarEvent1.isRecurring()) && (paramQMCalendarEvent2.isRecurring())) {
          QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
        }
        for (;;)
        {
          paramQMCalendarEvent2.setCreateTime(System.currentTimeMillis());
          paramQMCalendarEvent2.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent2));
          createEvent(paramQMCalendarEvent2);
          return;
          if ((paramQMCalendarEvent1.isRecurring()) && (!paramQMCalendarEvent2.isRecurring()))
          {
            paramQMCalendarEvent2.setRecurrenceType(-1);
          }
          else if (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())
          {
            QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
            this.qmCalendarManager.changeExceptionsForEvent(paramQMCalendarEvent2, this.mSchedule.getEventStartTime());
            this.qmCalendarManager.deleteExceptionsForEvent(paramQMCalendarEvent1.getId(), this.mSchedule.getEventStartTime());
          }
          else if (paramQMCalendarEvent1.isRecurring())
          {
            if (paramSolution.getModifyType() == 0)
            {
              paramQMCalendarEvent2.setRecurrenceType(-1);
              paramQMCalendarEvent2.setExceptionHashMap(null);
              paramQMCalendarEvent2.setExceptions(null);
            }
            else if ((paramSolution.getModifyType() == 1) && (this.qmCalendarManager.isStartDateChange(paramQMCalendarEvent1, paramQMCalendarEvent2)))
            {
              QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
            }
          }
          else if ((paramQMCalendarEvent1.isRecurring()) && (paramQMCalendarEvent2.isRecurring()) && (paramSolution.getModifyType() == 0))
          {
            paramQMCalendarEvent2.setRecurrenceType(-1);
            paramQMCalendarEvent2.setExceptionHashMap(null);
            paramQMCalendarEvent2.setExceptions(null);
          }
        }
      }
      if ((!paramQMCalendarEvent1.isRecurring()) && (paramQMCalendarEvent2.isRecurring()))
      {
        deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
        QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
        paramQMCalendarEvent2.setCreateTime(System.currentTimeMillis());
        paramQMCalendarEvent2.setUid("");
        createEvent(paramQMCalendarEvent2);
        return;
      }
      if ((paramQMCalendarEvent1.isRecurring()) && (!paramQMCalendarEvent2.isRecurring()))
      {
        deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
        paramQMCalendarEvent2.setCreateTime(System.currentTimeMillis());
        paramQMCalendarEvent2.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent2));
        createEvent(paramQMCalendarEvent2);
        return;
      }
      if (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())
      {
        deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
        QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
        this.qmCalendarManager.changeExceptionsForEvent(paramQMCalendarEvent2, this.mSchedule.getEventStartTime());
        this.qmCalendarManager.deleteExceptionsForEvent(paramQMCalendarEvent1.getId(), this.mSchedule.getEventStartTime());
        paramQMCalendarEvent2.setCreateTime(System.currentTimeMillis());
        paramQMCalendarEvent2.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent2));
        createEvent(paramQMCalendarEvent2);
        return;
      }
      if ((!paramQMCalendarEvent1.isRecurring()) || (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())) {
        break;
      }
      if (paramSolution.getModifyType() == 0)
      {
        if (((this.qmCalendarManager.isStartDateChange(paramQMCalendarEvent1, paramQMCalendarEvent2)) || (this.qmCalendarManager.isEndDateChange(paramQMCalendarEvent1, paramQMCalendarEvent2))) && (this.qmCalendarManager.isActiveSyncAccount(paramQMCalendarEvent1.getAccountId())))
        {
          deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
          paramQMCalendarEvent2.setRecurrenceType(-1);
          paramQMCalendarEvent2.setExceptionHashMap(null);
          paramQMCalendarEvent2.setExceptions(null);
          paramQMCalendarEvent2.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent2));
          createEvent(paramQMCalendarEvent2);
          return;
        }
        this.qmCalendarManager.modifyEvent(paramQMCalendarEvent2, paramSolution.getModifyType(), this.mSchedule);
        return;
      }
    } while (paramSolution.getModifyType() != 1);
    deleteEvent(paramQMCalendarEvent1, paramSolution.getModifyType(), this.mSchedule);
    if (this.qmCalendarManager.isStartDateChange(paramQMCalendarEvent1, paramQMCalendarEvent2)) {
      QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
    }
    this.qmCalendarManager.changeExceptionsForEvent(paramQMCalendarEvent2, this.mSchedule.getEventStartTime());
    this.qmCalendarManager.deleteExceptionsForEvent(paramQMCalendarEvent1.getId(), this.mSchedule.getEventStartTime());
    paramQMCalendarEvent2.setCreateTime(System.currentTimeMillis());
    paramQMCalendarEvent2.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent2));
    createEvent(paramQMCalendarEvent2);
    return;
    this.qmCalendarManager.modifyEvent(paramQMCalendarEvent2, paramSolution.getModifyType(), this.mSchedule);
  }
  
  public void onBackPressed()
  {
    if ((this.mPopupFrame != null) && (this.mPopupFrame.getVisibility() == 0))
    {
      this.mPopupFrame.onBackPressed();
      return;
    }
    super.onBackPressed();
    getActivity().overridePendingTransition(2130772430, 2130772402);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMCalendarManager.getInstance().bindLoadEventListWatcher(this.scheduleUpdateWatcher, paramBoolean);
    if (this.eventTimeItemView != null)
    {
      this.eventTimeItemView.setStartTimeOnClickListener(this);
      this.eventTimeItemView.setEndTimeOnClickListener(this);
      this.eventTimeItemView.setOnClickListener(this);
    }
    if (this.eventRemindItemView != null) {
      this.eventRemindItemView.setOnClickListener(this);
    }
    if (this.eventRecurringItemView != null) {
      this.eventRecurringItemView.setOnClickListener(this);
    }
    if (this.eventBelongToItemView != null) {
      this.eventBelongToItemView.setOnClickListener(this);
    }
    observeKeyboard(paramBoolean);
  }
  
  public void onCheckError() {}
  
  public void onCheckSuccess(Solution paramSolution)
  {
    if (this.mCurrentEvent.isAllDay())
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.mCurrentEvent.getStartTime());
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      this.mCurrentEvent.setStartTime(localCalendar.getTimeInMillis());
      localCalendar.setTimeInMillis(this.mCurrentEvent.getEndTime());
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.add(5, 1);
      this.mCurrentEvent.setEndTime(localCalendar.getTimeInMillis());
    }
    switch (paramSolution.getAction())
    {
    }
    for (;;)
    {
      paramSolution = new HashMap();
      paramSolution.put("event", this.mCurrentEvent);
      setFragmentResult(-1, paramSolution);
      finish();
      return;
      createEvent(this.mCurrentEvent);
      QMReminderer.reDeploySentinel();
      QMCalendarManager.logCreateEvent(this.mCreateType);
      logOnCreate();
      continue;
      modifyEvent(this.mOriginalEvent, this.mCurrentEvent, paramSolution);
      QMReminderer.reDeploySentinel();
      QMCalendarManager.logEvent("Event_Calendar_Modify_Event");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.eventRemindItemView) {
      if (this.mCurrentEvent.isAllDay()) {
        showAllDayRemindChoseDialog();
      }
    }
    DataPickerViewGroup localDataPickerViewGroup;
    label128:
    Calendar localCalendar;
    boolean bool;
    label198:
    label252:
    label254:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          showRemindChoseDialog();
          continue;
          if (paramView == this.eventRecurringItemView)
          {
            showRecurringChoseDialog();
          }
          else
          {
            if (paramView != this.eventBelongToItemView) {
              break;
            }
            showAccountChoseDialog();
          }
        }
        if (paramView == this.eventTimeItemView.getStartContainerView())
        {
          if (this.mPopupFrame == null)
          {
            localDataPickerViewGroup = (DataPickerViewGroup)getActivity().getLayoutInflater().inflate(2131558802, null);
            this.mPopupFrame = new PopupFrame(getActivity(), this.mModifyEventView, localDataPickerViewGroup);
            localDataPickerViewGroup.setDatePickerListener(this);
            if (this.mPopupFrame.hasShow()) {
              break label252;
            }
            this.modifyTimeItemId = 2131366556;
            localCalendar = Calendar.getInstance();
            localCalendar.setTimeInMillis(this.mCurrentEvent.getStartTime());
            localDataPickerViewGroup.setStartPageMonth(localCalendar);
            localDataPickerViewGroup.setTime(localCalendar.get(11), localCalendar.get(12));
            if (this.mCurrentEvent.isAllDay()) {
              break label254;
            }
            bool = true;
            localDataPickerViewGroup.setTimeEnable(bool);
            if (!this.mCurrentEvent.isAllDay()) {
              break label259;
            }
            localDataPickerViewGroup.changeTabSelected(0);
          }
          for (;;)
          {
            KeyBoardHelper.hideKeyBoard(this.eventSubjectItemView);
            paramView.setSelected(true);
            this.mPopupFrame.show();
            break;
            localDataPickerViewGroup = (DataPickerViewGroup)this.mPopupFrame.getContentView();
            break label128;
            break;
            bool = false;
            break label198;
            localDataPickerViewGroup.changeTabSelected(1);
          }
        }
      } while (paramView != this.eventTimeItemView.getEndContainerView());
      if (this.mPopupFrame != null) {
        break;
      }
      localDataPickerViewGroup = (DataPickerViewGroup)LayoutInflater.from(getActivity()).inflate(2131558802, null);
      this.mPopupFrame = new PopupFrame(getActivity(), (ViewGroup)getActivity().getWindow().getDecorView(), localDataPickerViewGroup);
      localDataPickerViewGroup.setDatePickerListener(this);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.mCurrentEvent.getEndTime());
    } while (this.mPopupFrame.hasShow());
    label259:
    label337:
    this.modifyTimeItemId = 2131366553;
    localDataPickerViewGroup.setStartPageMonth(localCalendar);
    localDataPickerViewGroup.setTime(localCalendar.get(11), localCalendar.get(12));
    if (!this.mCurrentEvent.isAllDay())
    {
      bool = true;
      label407:
      localDataPickerViewGroup.setTimeEnable(bool);
      if (!this.mCurrentEvent.isAllDay()) {
        break label468;
      }
      localDataPickerViewGroup.changeTabSelected(0);
    }
    for (;;)
    {
      KeyBoardHelper.hideKeyBoard(this.eventSubjectItemView);
      paramView.setSelected(true);
      this.mPopupFrame.show();
      break;
      localDataPickerViewGroup = (DataPickerViewGroup)this.mPopupFrame.getContentView();
      break label337;
      bool = false;
      break label407;
      label468:
      localDataPickerViewGroup.changeTabSelected(1);
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onPickCancel(Calendar paramCalendar)
  {
    this.eventTimeItemView.setStartTimeViewSelected(false);
    this.eventTimeItemView.setEndTimeViewSelected(false);
  }
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    this.eventTimeItemView.setStartTimeViewSelected(false);
    this.eventTimeItemView.setEndTimeViewSelected(false);
    modifyTime(paramCalendar, this.modifyTimeItemId);
    return true;
  }
  
  public void onRelease()
  {
    if (this.eventSubjectItemView != null) {
      KeyBoardHelper.hideKeyBoard(this.eventSubjectItemView);
    }
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar) {}
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    if (this.mCurrentEvent.getAppointmentType() != 0)
    {
      if (this.mCurrentEvent.isAllDay())
      {
        this.eventRemindItemView.setTextWithGrayStyle(QMCalendarUtil.getStringByAllDayReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()));
        return;
      }
      this.eventRemindItemView.setTextWithGrayStyle(QMCalendarUtil.getStringByReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()));
      return;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.mCurrentEvent.getStartTime());
    this.eventTimeItemView.setStartTime((Calendar)localObject, this.mCurrentEvent.isAllDay());
    ((Calendar)localObject).setTimeInMillis(this.mCurrentEvent.getEndTime());
    this.eventTimeItemView.setEndTime((Calendar)localObject, this.mCurrentEvent.isAllDay());
    if (this.mCurrentEvent.isAllDay())
    {
      this.eventIsAllDayItemView.setChecked(true);
      this.eventRemindItemView.setTextWithGrayStyle(QMCalendarUtil.getStringByAllDayReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()));
      label168:
      if ((this.mSchedule == null) || (StringUtils.isBlank(this.mSchedule.getExceptionId()))) {
        break label347;
      }
      this.eventRecurringItemView.setVisibility(8);
    }
    for (;;)
    {
      localObject = QMCalendarManager.getInstance().getCalendarFolder(this.mCurrentEvent.getAccountId(), this.mCurrentEvent.getCalderFolderId());
      if (localObject == null) {
        break;
      }
      Drawable localDrawable = DrawBitmapUtil.drawCircle(getActivity(), QMUIHelper.getCalendarColor(getActivity(), (QMCalendarFolder)localObject), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
      this.eventBelongToItemView.setTextWithGrayStyle(getBelongCalendarName((QMCalendarFolder)localObject));
      this.eventBelongToItemView.getDetailView().setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      this.eventBelongToItemView.getDetailView().setCompoundDrawables(localDrawable, null, null, null);
      this.eventBelongToItemView.getDetailView().setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131296762));
      return;
      this.eventIsAllDayItemView.setChecked(false);
      this.eventRemindItemView.setTextWithGrayStyle(QMCalendarUtil.getStringByReminder(this.mCurrentEvent.getReminder(), this.mCurrentEvent.getStartTime()));
      break label168;
      label347:
      this.eventRecurringItemView.setTextWithGrayStyle(QMCalendarUtil.createReadableStringOfRecurrence(this.mCurrentEvent));
    }
  }
  
  class MyAdapter
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    
    public MyAdapter(Context paramContext)
    {
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    public int getCount()
    {
      return ModifyScheduleFragment.this.mAccountData.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return ((Integer)((HashMap)ModifyScheduleFragment.this.mAccountData.get(paramInt)).get("type")).intValue();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (getItemViewType(paramInt) == ModifyScheduleFragment.CHOSE_LIST_TYPE_FOLDER)
      {
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getTag().equals("folder")) {}
        }
        else
        {
          localView = this.mInflater.inflate(2131558804, null);
        }
        localView.setTag("folder");
        paramView = (RadioButton)localView.findViewById(2131376604);
        localObject = (QMCalendarFolder)((HashMap)ModifyScheduleFragment.this.mAccountData.get(paramInt)).get("folder");
        if ((ModifyScheduleFragment.this.mCurrentEvent.getAccountId() == ((QMCalendarFolder)localObject).getAccountId()) && (ModifyScheduleFragment.this.mCurrentEvent.getCalderFolderId() == ((QMCalendarFolder)localObject).getId()))
        {
          paramView.setChecked(true);
          paramView.setTag(localObject);
          paramView.setText(((QMCalendarFolder)localObject).getName());
          paramView.setCompoundDrawables(DrawBitmapUtil.drawCircle(ModifyScheduleFragment.this.getActivity(), QMUIHelper.getCalendarColor(ModifyScheduleFragment.this.getActivity(), (QMCalendarFolder)localObject), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE), null, paramView.getCompoundDrawables()[2], null);
          paramView.setCompoundDrawablePadding(ModifyScheduleFragment.this.getResources().getDimensionPixelSize(2131296762));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        paramView.setChecked(false);
        break;
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getTag().equals("account")) {}
        }
        else
        {
          localView = this.mInflater.inflate(2131558805, null);
        }
        localView.setTag("account");
        paramView = (TextView)localView.findViewById(2131379577);
        paramView.setEnabled(false);
        localObject = (Account)((HashMap)ModifyScheduleFragment.this.mAccountData.get(paramInt)).get("account");
        paramView.setTag(localObject);
        paramView.setText(ModifyScheduleFragment.this.getAccountTitle((Account)localObject));
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean isEnabled(int paramInt)
    {
      return ((Integer)((HashMap)ModifyScheduleFragment.this.mAccountData.get(paramInt)).get("type")).intValue() == 1;
    }
  }
  
  public class Solution
  {
    private int action;
    private int modifyType = 0;
    
    public Solution() {}
    
    public int getAction()
    {
      return this.action;
    }
    
    public int getModifyType()
    {
      return this.modifyType;
    }
    
    public void setAction(int paramInt)
    {
      this.action = paramInt;
    }
    
    public void setModifyType(int paramInt)
    {
      this.modifyType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment
 * JD-Core Version:    0.7.0.1
 */