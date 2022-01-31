package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.util.GTUtil;
import com.tencent.widget.TraceUtils;
import java.util.Arrays;

public class Step
  implements Runnable
{
  public static final int a = 0;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "STEP_GROUP", "STEP_TRY_LOAD_DEX", "STEP_NAME_PROCESS", "STEP_SET_SPLASH", "STEP_DO_LOAD_DEX", "STEP_NEW_RUNTIME", "STEP_LOAD_DATA", "STEP_MEMORY_CACHE", "STEP_OLD_ONCREATE", "STEP_START_SERVICE", "STEP_INIT_SKIN", "STEP_URL_DRAWABLE", "STEP_UPDATE", "STEP_RDM", "STEP_MANAGE_THREAD", "STEP_LOAD_UI", "STEP_MORE_DATA", "STEP_QZPRELOAD", "STEP_START_SERVICE_LITE", "STEP_START_SERVICE_LITE_CMP", "STEP_UPDATE_BUBBLE", "STEP_UPDATE_AVSO" };
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  public static final int t = 19;
  public static final int u = 20;
  public static final int v = 21;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected StartupDirector a;
  protected String a;
  private int[] jdField_a_of_type_ArrayOfInt;
  protected int w;
  private int x;
  
  public static Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Step();
    }
    for (;;)
    {
      ((Step)localObject).w = paramInt;
      ((Step)localObject).jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = paramStartupDirector;
      if (paramInt != 0) {
        break;
      }
      ((Step)localObject).jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      ((Step)localObject).jdField_a_of_type_JavaLangString = Arrays.toString(paramArrayOfInt);
      return localObject;
      localObject = new LoadDex();
      continue;
      localObject = new NameProcess();
      continue;
      localObject = new InitMemoryCache();
      continue;
      localObject = new OldApplication();
      continue;
      localObject = new SetSplash();
      continue;
      localObject = new LoadData();
      continue;
      localObject = new NewRuntime();
      continue;
      localObject = new StartService();
      continue;
      localObject = new InitSkin();
      continue;
      localObject = new InitUrlDrawable();
      continue;
      localObject = new Update();
      continue;
      localObject = new Rdm();
      continue;
      localObject = new ManageThread();
      continue;
      localObject = new LoadUi();
      continue;
      localObject = new QZonePreLoader();
      continue;
      localObject = new StartServiceLiteCmp();
      continue;
      localObject = new UpdateBubbleZip();
      continue;
      localObject = new UpdateAvSo();
    }
    if (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      ((Step)localObject).jdField_a_of_type_JavaLangString = jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      return localObject;
    }
    ((Step)localObject).jdField_a_of_type_JavaLangString = "WTF";
    return localObject;
  }
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.x = paramInt;
  }
  
  protected boolean a()
  {
    if (this.w == 0)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i2 = arrayOfInt.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (!a(arrayOfInt[i1], this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, null).b()) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public final boolean b()
  {
    long l1 = 0L;
    if (StartupDirector.e)
    {
      l1 = SystemClock.uptimeMillis();
      TraceUtils.a(this.jdField_a_of_type_JavaLangString);
    }
    if ((StartupDirector.f) && (this.w != 0)) {
      GTUtil.a(0, "group_application_oncreate", this.jdField_a_of_type_JavaLangString, new int[0]);
    }
    boolean bool = a();
    if ((StartupDirector.f) && (this.w != 0)) {
      GTUtil.b(0, "group_application_oncreate", this.jdField_a_of_type_JavaLangString, new int[0]);
    }
    if (StartupDirector.e)
    {
      TraceUtils.a();
      Log.i("AutoMonitor", this.jdField_a_of_type_JavaLangString + ", cost=" + (SystemClock.uptimeMillis() - l1) + " results: " + bool);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(this.x, Boolean.valueOf(bool)).sendToTarget();
    }
    return bool;
  }
  
  public void run()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step
 * JD-Core Version:    0.7.0.1
 */