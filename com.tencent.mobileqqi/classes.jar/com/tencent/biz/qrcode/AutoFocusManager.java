package com.tencent.biz.qrcode;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;

final class AutoFocusManager
  implements Camera.AutoFocusCallback
{
  protected static final long a = 3000L;
  protected static final String a;
  protected static final Collection a;
  protected Camera a;
  protected Thread a;
  protected boolean a;
  protected boolean b = false;
  protected boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = AutoFocusManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilCollection = new ArrayList(2);
    jdField_a_of_type_JavaUtilCollection.add("auto");
    jdField_a_of_type_JavaUtilCollection.add("macro");
  }
  
  AutoFocusManager(Camera paramCamera)
  {
    this.jdField_a_of_type_Boolean = false;
    String str = paramCamera.getParameters().getFocusMode();
    this.c = jdField_a_of_type_JavaUtilCollection.contains(str);
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    if (this.c)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangThread = new AutoFocusManager.AutoFocusThread(this);
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void a()
  {
    try
    {
      if ((this.c) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangThread = new AutoFocusManager.AutoFocusThread(this);
        this.jdField_a_of_type_JavaLangThread.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/biz/qrcode/AutoFocusManager:c	Z
    //   6: ifeq +53 -> 59
    //   9: aload_0
    //   10: getfield 51	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_Boolean	Z
    //   13: ifeq +46 -> 59
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 51	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_Boolean	Z
    //   21: aload_0
    //   22: getfield 78	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   25: ifnull +15 -> 40
    //   28: aload_0
    //   29: getfield 78	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   32: invokevirtual 88	java/lang/Thread:interrupt	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 78	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   40: aload_0
    //   41: getfield 53	com/tencent/biz/qrcode/AutoFocusManager:b	Z
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 53	com/tencent/biz/qrcode/AutoFocusManager:b	Z
    //   52: aload_0
    //   53: getfield 71	com/tencent/biz/qrcode/AutoFocusManager:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   56: invokevirtual 91	android/hardware/Camera:cancelAutoFocus	()V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: goto -9 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	AutoFocusManager
    //   62	4	1	localObject	Object
    //   67	1	1	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	40	62	finally
    //   40	52	62	finally
    //   52	59	62	finally
    //   52	59	67	java/lang/RuntimeException
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onAutoFocus");
    }
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.AutoFocusManager
 * JD-Core Version:    0.7.0.1
 */