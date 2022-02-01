package com.tencent.mobileqq.activity.chathistory;

import acfp;
import akvm;
import akwh;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import anot;
import arkk;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import ton;
import top;

public class ChatHistoryByDateFragment
  extends IphoneTitleBarFragment
{
  private static String TAG = "ChatHistoryByDateFragment";
  public arkk a;
  public CalendarDay a;
  public DatePickerView a;
  public String aYZ;
  private akvm b;
  public CalendarDay b;
  private akwh c;
  public CalendarDay c;
  public HashMap<String, Boolean> hc = new HashMap();
  public QQAppInterface mApp;
  private String mFriendUin;
  public String mTroopUin;
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject = top.ox();
    localObject = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.aYZ, Long.valueOf(l1), Long.valueOf(l2), localObject });
    List localList;
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null) && (l2 * 1000L < this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()))
    {
      localList = this.jdField_c_of_type_Akwh.aF((String)localObject);
      localObject = localList;
      if (localList != null)
      {
        localObject = localList;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "slowtable data:" + localList);
        }
      }
    }
    for (localObject = localList; (localObject != null) && (((List)localObject).size() > 0); localObject = this.jdField_b_of_type_Akvm.rawQuery(MessageRecord.class, (String)localObject, null)) {
      return (MessageRecord)((List)localObject).get(0);
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
  
  private String h(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1;
    if (paramInt2 < 10)
    {
      str1 = "0" + paramInt2;
      if (paramInt3 >= 10) {
        break label113;
      }
    }
    label113:
    for (String str2 = "0" + paramInt3;; str2 = paramInt3 + "")
    {
      return paramInt1 + "-" + str1 + "-" + str2;
      str1 = paramInt2 + "";
      break;
    }
  }
  
  public void fR(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "queryMessageInMonth:" + paramInt1 + "-" + paramInt2);
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryByDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public int getContentLayoutId()
  {
    return 2131560773;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    super.setTitle(acfp.m(2131703690));
    Object localObject = getActivity();
    AppInterface localAppInterface;
    if (localObject == null)
    {
      localAppInterface = null;
      if (!(localAppInterface instanceof QQAppInterface)) {
        break label99;
      }
      this.mApp = ((QQAppInterface)localAppInterface);
      this.mTroopUin = paramBundle.getString("troop_uin");
      this.mFriendUin = paramBundle.getString("uin");
      if ((this.mTroopUin != null) || (this.mFriendUin != null)) {
        break label119;
      }
      QLog.e(TAG, 1, "Uin is null");
    }
    label99:
    do
    {
      return;
      localAppInterface = ((FragmentActivity)localObject).getAppInterface();
      break;
      QLog.e(TAG, 1, "app is null");
    } while (localObject == null);
    ((FragmentActivity)localObject).finish();
    return;
    label119:
    this.aYZ = MessageRecord.getTableName(this.mTroopUin, 1);
    this.jdField_b_of_type_Akvm = ((akvm)this.mApp.a().createMessageRecordEntityManager());
    paramBundle = this.mApp.a(1).b(this.mTroopUin, 1);
    localObject = this.mApp.b().c(this.mTroopUin, 1);
    this.jdField_c_of_type_Akwh = ((akwh)localAppInterface.getManager(201));
    long l = this.jdField_c_of_type_Akwh.ar(this.aYZ);
    if (paramBundle != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(paramBundle.time * 1000L);
    }
    if ((paramBundle == null) || (paramBundle.time == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      if ((localObject != null) && (((MessageRecord)localObject).time != 0L)) {
        break label476;
      }
    }
    label476:
    for (this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());; this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(((MessageRecord)localObject).time * 1000L))
    {
      QLog.i(TAG, 1, "firstMessage : " + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay + " lastMssage : " + this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.mContentView.findViewById(2131373278));
      this.jdField_a_of_type_Arkk = new a(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_Arkk);
      fR(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
      anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_exp", 0, 0, this.mTroopUin, "", "", "");
      return;
      if ((l != 0L) && (l < paramBundle.time))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(l * 1000L);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
      break;
    }
  }
  
  public class a
    implements arkk
  {
    CalendarDay d;
    CalendarDay e;
    
    public a(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
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
      String str = ChatHistoryByDateFragment.this.mTroopUin;
      ChatHistoryBubbleListForTroopFragment.a(ChatHistoryByDateFragment.this.getActivity(), str, paramMessageRecord, -1, 3);
      anot.a(ChatHistoryByDateFragment.this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_clk", 0, 0, ChatHistoryByDateFragment.this.mTroopUin, "", "", "");
      QLog.i(ChatHistoryByDateFragment.TAG, 1, "clickDay: CalendarDay" + paramCalendarDay + " | MessageRecord:" + paramMessageRecord);
    }
    
    public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
    {
      if (!ChatHistoryByDateFragment.a(ChatHistoryByDateFragment.this, paramInt1, paramInt2)) {
        ChatHistoryByDateFragment.this.fR(paramInt1, paramInt2);
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryByDateFragment
 * JD-Core Version:    0.7.0.1
 */