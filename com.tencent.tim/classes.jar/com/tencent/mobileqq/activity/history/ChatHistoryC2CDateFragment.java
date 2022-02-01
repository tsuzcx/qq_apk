package com.tencent.mobileqq.activity.history;

import achs;
import achs.a;
import akvm;
import akwh;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anot;
import arkk;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import ton;
import top;
import zfh;

public class ChatHistoryC2CDateFragment
  extends ChatHistoryBaseFragment
{
  private static String TAG = "Q.history.C2CDateFragment";
  achs.a a;
  public b a;
  public CalendarDay a;
  public DatePickerView a;
  private akvm b;
  public CalendarDay b;
  private String bag;
  boolean brh = false;
  private achs jdField_c_of_type_Achs;
  private akwh jdField_c_of_type_Akwh;
  public CalendarDay c;
  private CalendarDay f;
  public HashMap<String, Boolean> hc = new HashMap();
  public QQAppInterface mApp;
  private String mFriendUin;
  private String mNickName;
  private int mUinType;
  
  public ChatHistoryC2CDateFragment()
  {
    this.jdField_a_of_type_Achs$a = new zfh(this);
  }
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = l1 + 86400L;
    Object localObject1 = null;
    Object localObject2 = top.ox();
    localObject2 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.bag, Long.valueOf(l1), Long.valueOf(l2), localObject2 });
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null) && (1000L * l2 < this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis())) {
      if (this.jdField_c_of_type_Akwh != null)
      {
        localObject2 = this.jdField_c_of_type_Akwh.aF((String)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(TAG, 2, "slowtable data:" + localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    while ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      return (MessageRecord)((List)localObject1).get(0);
      if (this.jdField_b_of_type_Akvm != null) {
        localObject1 = this.jdField_b_of_type_Akvm.rawQuery(MessageRecord.class, (String)localObject2, null);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    this.hc.put(paramInt1 + "-" + paramInt2, paramBoolean);
  }
  
  private boolean az(int paramInt1, int paramInt2)
  {
    Boolean localBoolean = (Boolean)this.hc.get(paramInt1 + "-" + paramInt2);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  private void cpf()
  {
    this.bag = MessageRecord.getTableName(this.mFriendUin, 0);
    this.jdField_b_of_type_Akvm = ((akvm)this.mApp.a().createMessageRecordEntityManager());
    MessageRecord localMessageRecord = this.mApp.a(0).b(this.mFriendUin, 0);
    QQMessageFacade.Message localMessage = this.mApp.b().c(this.mFriendUin, 0);
    this.jdField_c_of_type_Akwh = ((akwh)getActivity().app.getManager(201));
    long l = this.jdField_c_of_type_Akwh.ar(this.bag);
    if (localMessageRecord != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessageRecord.time * 1000L);
    }
    if ((localMessageRecord == null) || (localMessageRecord.time == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
    }
    while ((localMessage == null) || (localMessage.time == 0L))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      return;
      if ((l != 0L) && (l < localMessageRecord.time)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(l * 1000L);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessage.time * 1000L);
  }
  
  private void e(Calendar paramCalendar)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(paramCalendar.getTimeInMillis());
    paramCalendar = new CalendarDay(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, 1);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTimeInMillis(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis());
    BitSet localBitSet = ((achs)getActivity().app.getManager(92)).b(localCalendar, paramCalendar);
    int i = 0;
    localCalendar = (Calendar)localCalendar.clone();
    ArrayList localArrayList = new ArrayList(31);
    while ((localCalendar.before(paramCalendar)) || (localCalendar.equals(paramCalendar)))
    {
      if (localBitSet.get(i))
      {
        MessageRecord localMessageRecord = new MessageRecord();
        localMessageRecord.time = (localCalendar.getTimeInMillis() / 1000L);
        localArrayList.add(localMessageRecord);
      }
      localCalendar.add(5, 1);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.b(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, localArrayList);
    }
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, Boolean.valueOf(true));
  }
  
  boolean Vm()
  {
    CalendarDay localCalendarDay1 = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    CalendarDay localCalendarDay2 = this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    Calendar localCalendar = this.jdField_c_of_type_Achs.c();
    if ((localCalendar != null) && (this.jdField_c_of_type_Achs.aaQ()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localCalendar.getTimeInMillis());
      this.brh = true;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "initStartEndDate ", this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString(), " ", this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString() });
      }
      if ((localCalendarDay1 != null) && (localCalendarDay2 != null)) {
        break label137;
      }
    }
    label137:
    while ((localCalendarDay1 != null) && (localCalendarDay1.getTimeInMillis() != this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()) && (localCalendarDay2 != null) && (localCalendarDay2.getTimeInMillis() != this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()))
    {
      return true;
      cpf();
      this.brh = false;
      break;
    }
    return false;
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_c_of_type_Achs.c(this.jdField_a_of_type_Achs$a);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_Achs.b(this.jdField_a_of_type_Achs$a);
    boolean bool = Vm();
    if (bool)
    {
      this.hc.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$b.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    }
    if (this.brh) {
      e(this.jdField_c_of_type_Achs.c());
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.getAdapter().notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.getAdapter().getItemCount() - 1);
      }
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 6, 0, "", "", "", "");
      return;
      gf(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
    }
  }
  
  public void ge(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public void gf(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "queryLocalMessageInMonth:" + paramInt1 + "-" + paramInt2);
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void init(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    AppInterface localAppInterface;
    if (localFragmentActivity == null)
    {
      localAppInterface = null;
      if (!(localAppInterface instanceof QQAppInterface)) {
        break label79;
      }
      this.mApp = ((QQAppInterface)localAppInterface);
      this.jdField_c_of_type_Achs = ((achs)this.mApp.getManager(92));
      this.mFriendUin = paramBundle.getString("uin");
      if (this.mFriendUin != null) {
        break label98;
      }
      QLog.e(TAG, 1, "Uin is null");
    }
    label79:
    do
    {
      return;
      localAppInterface = localFragmentActivity.getAppInterface();
      break;
      QLog.e(TAG, 1, "app is null");
    } while (localFragmentActivity == null);
    localFragmentActivity.finish();
    return;
    label98:
    this.mUinType = paramBundle.getInt("uintype");
    this.mNickName = paramBundle.getString("uinname");
    Vm();
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.mContentView.findViewById(2131373278));
    QLog.i(TAG, 1, "firstMessage : " + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay + " lastMssage : " + this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$b = new b(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$b);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560773, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    init(getActivity().getIntent().getExtras());
  }
  
  static class a
    implements DialogInterface.OnCancelListener
  {
    private final WeakReference<ChatHistoryC2CDateFragment> mHost;
    
    a(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment)
    {
      this.mHost = new WeakReference(paramChatHistoryC2CDateFragment);
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      ChatHistoryC2CDateFragment localChatHistoryC2CDateFragment = (ChatHistoryC2CDateFragment)this.mHost.get();
      if ((localChatHistoryC2CDateFragment != null) && (localChatHistoryC2CDateFragment.getActivity() != null) && (!localChatHistoryC2CDateFragment.getActivity().isFinishing())) {
        paramDialogInterface.dismiss();
      }
    }
  }
  
  public class b
    implements arkk
  {
    CalendarDay d;
    CalendarDay e;
    
    public b(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
    {
      this.d = paramCalendarDay1;
      this.e = paramCalendarDay2;
    }
    
    public CalendarDay a()
    {
      if (this.d == null) {
        return new CalendarDay(System.currentTimeMillis());
      }
      return this.d;
    }
    
    public void a(CalendarDay paramCalendarDay, MessageRecord paramMessageRecord)
    {
      if (ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this).aaQ())
      {
        ChatHistoryC2CDateFragment.this.a(ChatHistoryC2CDateFragment.this.getString(2131720488), new ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this));
        ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this, paramCalendarDay);
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(paramCalendarDay.getTimeInMillis());
        ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this).i(localCalendar);
      }
      for (;;)
      {
        QLog.i(ChatHistoryC2CDateFragment.access$100(), 1, "clickDay: CalendarDay" + paramCalendarDay + " | MessageRecord:" + paramMessageRecord);
        return;
        ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this);
        ChatHistoryActivity.a(ChatHistoryC2CDateFragment.this.getActivity(), ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this), ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this), ChatHistoryC2CDateFragment.b(ChatHistoryC2CDateFragment.this), paramMessageRecord.time, paramMessageRecord.shmsgseq, 0);
      }
    }
    
    public void a(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
    {
      this.d = paramCalendarDay1;
      this.e = paramCalendarDay2;
    }
    
    public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
    {
      if (!ChatHistoryC2CDateFragment.a(ChatHistoryC2CDateFragment.this, paramInt1, paramInt2))
      {
        if (ChatHistoryC2CDateFragment.this.brh) {
          ChatHistoryC2CDateFragment.this.ge(paramInt1, paramInt2);
        }
      }
      else {
        return;
      }
      ChatHistoryC2CDateFragment.this.gf(paramInt1, paramInt2);
    }
    
    public CalendarDay b()
    {
      if (this.e == null)
      {
        CalendarDay localCalendarDay = new CalendarDay(System.currentTimeMillis());
        return new CalendarDay(localCalendarDay.year + 1, localCalendarDay.month, localCalendarDay.month);
      }
      return this.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment
 * JD-Core Version:    0.7.0.1
 */