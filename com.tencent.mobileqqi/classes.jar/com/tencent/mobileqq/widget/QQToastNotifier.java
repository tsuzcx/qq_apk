package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import hhj;
import hhk;

public class QQToastNotifier
{
  private static final int jdField_a_of_type_Int = 1;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new hhj(this, Looper.getMainLooper());
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
    hhk localhhk = new hhk(null);
    localhhk.jdField_a_of_type_Int = paramInt4;
    localhhk.b = paramInt1;
    localhhk.c = paramInt3;
    localhhk.d = paramInt2;
    localMessage.obj = localhhk;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    hhk localhhk = new hhk(null);
    localhhk.jdField_a_of_type_Int = paramInt3;
    localhhk.jdField_a_of_type_JavaLangString = paramString;
    localhhk.c = paramInt2;
    localhhk.d = paramInt1;
    localMessage.obj = localhhk;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier
 * JD-Core Version:    0.7.0.1
 */