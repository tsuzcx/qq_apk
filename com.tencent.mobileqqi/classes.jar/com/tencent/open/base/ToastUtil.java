package com.tencent.open.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import hlr;
import hls;

public class ToastUtil
{
  protected static ToastUtil a;
  protected Handler a;
  public Toast a;
  
  static
  {
    jdField_a_of_type_ComTencentOpenBaseToastUtil = null;
  }
  
  public ToastUtil()
  {
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static ToastUtil a()
  {
    if (jdField_a_of_type_ComTencentOpenBaseToastUtil == null) {
      jdField_a_of_type_ComTencentOpenBaseToastUtil = new ToastUtil();
    }
    return jdField_a_of_type_ComTencentOpenBaseToastUtil;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hls(this, paramInt1, paramInt2));
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new hlr(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil
 * JD-Core Version:    0.7.0.1
 */