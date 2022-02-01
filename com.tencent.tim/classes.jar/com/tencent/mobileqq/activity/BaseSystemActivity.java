package com.tencent.mobileqq.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;

public class BaseSystemActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private static int bEP;
  private static StringBuffer jdField_g_of_type_JavaLangStringBuffer = new StringBuffer();
  private static Calendar jdField_g_of_type_JavaUtilCalendar = ;
  CursorAdapter a;
  HashMap<Long, Long> gx = new HashMap();
  private XListView mListView;
  String peerUin;
  
  private static int J(long paramLong)
  {
    int i = -1;
    int j = (int)((System.currentTimeMillis() + bEP) / 86400000L);
    int k = (int)((bEP + paramLong) / 86400000L);
    if (k == j) {
      i = 2131721204;
    }
    do
    {
      return i;
      if (k == j - 1) {
        return 2131721953;
      }
    } while (k != j - 2);
    return 2131690832;
  }
  
  public static String f(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    jdField_g_of_type_JavaLangStringBuffer.setLength(0);
    jdField_g_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    int k = J(paramLong);
    if (k != -1)
    {
      if (k != 2131721204) {
        jdField_g_of_type_JavaLangStringBuffer.append(BaseApplication.getContext().getString(k));
      }
      i = 1;
    }
    int m = jdField_g_of_type_JavaUtilCalendar.get(11);
    int j = jdField_g_of_type_JavaUtilCalendar.get(12);
    if (i != 0) {
      if (k == 2131721204) {
        if (m == 24)
        {
          i = 24;
          if (i < 10) {
            jdField_g_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_g_of_type_JavaLangStringBuffer.append(i);
          jdField_g_of_type_JavaLangStringBuffer.append(':');
          if (j < 10) {
            jdField_g_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_g_of_type_JavaLangStringBuffer.append(j);
        }
      }
    }
    for (;;)
    {
      return jdField_g_of_type_JavaLangStringBuffer.toString();
      i = m % 24;
      break;
      if (!paramBoolean)
      {
        jdField_g_of_type_JavaLangStringBuffer.append(' ');
        if (m < 10) {
          jdField_g_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_g_of_type_JavaLangStringBuffer.append(m);
        jdField_g_of_type_JavaLangStringBuffer.append(':');
        if (j < 10) {
          jdField_g_of_type_JavaLangStringBuffer.append('0');
        }
        jdField_g_of_type_JavaLangStringBuffer.append(j);
        continue;
        jdField_g_of_type_JavaLangStringBuffer.append(jdField_g_of_type_JavaUtilCalendar.get(1)).append('/').append(jdField_g_of_type_JavaUtilCalendar.get(2) + 1).append('/').append(jdField_g_of_type_JavaUtilCalendar.get(5));
        if (!paramBoolean)
        {
          jdField_g_of_type_JavaLangStringBuffer.append(' ');
          jdField_g_of_type_JavaLangStringBuffer.append(m);
          jdField_g_of_type_JavaLangStringBuffer.append(':');
          if (j < 10) {
            jdField_g_of_type_JavaLangStringBuffer.append('0');
          }
          jdField_g_of_type_JavaLangStringBuffer.append(j);
        }
      }
    }
  }
  
  private void init()
    throws Exception
  {
    super.setContentView(2131561725);
    setContentBackgroundResource(2130838900);
    this.mListView = ((XListView)findViewById(2131379117));
    this.peerUin = ay();
    if (this.peerUin == null) {
      throw new Exception("peerUin is null");
    }
    this.a = a();
    if (this.a == null) {
      throw new Exception("mAdapter is null");
    }
    this.mListView.setAdapter(this.a);
    this.mListView.setTranscriptMode(1);
    this.mListView.setSelection(0);
    this.app.b().addObserver(this);
    setTitle(j());
    bEP = TimeZone.getDefault().getRawOffset();
  }
  
  protected long K(long paramLong)
  {
    if (this.gx.containsKey(Long.valueOf(paramLong))) {
      return ((Long)this.gx.get(Long.valueOf(paramLong))).longValue();
    }
    return -1L;
  }
  
  protected CursorAdapter a()
  {
    return null;
  }
  
  protected String ay()
  {
    return null;
  }
  
  protected void b(Cursor paramCursor)
  {
    Object localObject1 = null;
    this.gx.clear();
    if (paramCursor.moveToFirst()) {
      do
      {
        long l1 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
        long l2 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
        }
        this.gx.put(Long.valueOf(l1), Long.valueOf(l2));
        localObject1 = localObject2;
      } while (paramCursor.moveToNext());
    }
    paramCursor.moveToFirst();
  }
  
  protected void bJp() {}
  
  protected Cursor getCursor()
  {
    return null;
  }
  
  protected CharSequence j()
  {
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      init();
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(0);
    this.rightViewText.setCompoundDrawablesWithIntrinsicBounds(2130851678, 0, 0, 0);
    return this.rightViewText;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.b().deleteObserver(this);
    if (this.a != null) {
      this.a.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.changeCursor(getCursor());
  }
  
  public void refresh()
  {
    b(getCursor());
    this.a.changeCursor(getCursor());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.peerUin.equals(paramObservable.frienduin)) && (paramObservable.istroop == 0))
      {
        this.app.b().ca(this.peerUin, 0);
        runOnUiThread(new BaseSystemActivity.1(this));
      }
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new BaseSystemActivity.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseSystemActivity
 * JD-Core Version:    0.7.0.1
 */