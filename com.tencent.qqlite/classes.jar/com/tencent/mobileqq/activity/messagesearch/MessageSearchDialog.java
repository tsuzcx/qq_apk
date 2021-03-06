package com.tencent.mobileqq.activity.messagesearch;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import cgq;
import cgr;
import cgs;
import cgt;
import cgu;
import cgv;
import cgw;
import cgx;
import cgz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XListView;
import java.util.List;

public class MessageSearchDialog
  extends Dialog
  implements Handler.Callback
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cgt(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public MessageItem a;
  public MessageResultAdapter a;
  public SearchHistoryAdapter a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public MenuPopupDialog a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  private int e = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageSearchDialog.class.getSimpleName();
  }
  
  public MessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903235);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    j();
    d();
    e();
    f();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297962));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cgq(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    cgz localcgz = new cgz(this, null);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localcgz);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localcgz);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.a("");
  }
  
  private void e()
  {
    ((ImageButton)findViewById(2131297955)).setOnClickListener(new cgr(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298430));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cgs(this));
  }
  
  private void g()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, currentKeyword = " + str1);
    }
    if (str1.length() == 0) {}
    String str2;
    do
    {
      return;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a();
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.a() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) || (!str1.equalsIgnoreCase(str2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, skip, currentKeyword = " + str1 + ", mLastKeyword = " + str2);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(str1, MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH);
    a(2131363092);
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadMessageMore, currentKeyword = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(str, MessageResultAdapter.LOAD_TYPE.LOAD_MORE);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296867));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter = new MessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter = new SearchHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new cgu(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new cgv(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cgw(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new cgx(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296868));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363165);
  }
  
  private void k()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  private void l()
  {
    if (isShowing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.e;
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleMessage, msg.what = " + paramMessage.what);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      k();
      continue;
      l();
      continue;
      i();
      if (this.jdField_a_of_type_ComTencentWidgetXListView.a() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter);
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a((List)paramMessage.obj, paramMessage.arg1);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getCount() == 0)
      {
        c();
      }
      else
      {
        b();
        continue;
        if (this.jdField_a_of_type_ComTencentWidgetXListView.a() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.notifyDataSetChanged();
        b();
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */