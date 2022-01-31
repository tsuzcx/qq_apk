package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import ezb;
import ezc;

public class QQToastNotifier
{
  private static final int jdField_a_of_type_Int = 1;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new ezb(this, Looper.getMainLooper());
  public Toast a;
  
  public QQToastNotifier(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    ezc localezc = new ezc(null);
    localezc.jdField_a_of_type_Int = paramInt4;
    localezc.b = paramInt1;
    localezc.c = paramInt3;
    localezc.d = paramInt2;
    localMessage.obj = localezc;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    ezc localezc = new ezc(null);
    localezc.jdField_a_of_type_Int = paramInt3;
    localezc.jdField_a_of_type_JavaLangString = paramString;
    localezc.c = paramInt2;
    localezc.d = paramInt1;
    localMessage.obj = localezc;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier
 * JD-Core Version:    0.7.0.1
 */