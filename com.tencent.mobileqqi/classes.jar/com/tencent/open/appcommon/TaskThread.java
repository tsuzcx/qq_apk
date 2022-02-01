package com.tencent.open.appcommon;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import hkj;
import java.io.File;

public class TaskThread
  extends Thread
{
  protected static TaskThread a;
  public static final String a;
  protected Handler a;
  
  static
  {
    jdField_a_of_type_JavaLangString = TaskThread.class.getName();
    jdField_a_of_type_ComTencentOpenAppcommonTaskThread = null;
  }
  
  public static TaskThread a()
  {
    if (jdField_a_of_type_ComTencentOpenAppcommonTaskThread == null) {
      jdField_a_of_type_ComTencentOpenAppcommonTaskThread = new TaskThread();
    }
    return jdField_a_of_type_ComTencentOpenAppcommonTaskThread;
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("applist", 0);
    if ((!localSharedPreferences.getBoolean("hasCopyAppImg", false)) && (Common.a()))
    {
      FileUtils.a(paramContext, "app_icon", Common.b() + ImageCache.b + "app");
      FileUtils.a(paramContext, "ad_icon", Common.b() + ImageCache.b + "ad");
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("hasCopyAppImg", true);
      paramContext.commit();
      LogUtility.b("applist", "copy icon success");
    }
  }
  
  public void a()
  {
    AppViewBaseActivity.b(true);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.b().post(new hkj(this, paramInt));
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = new File(Common.e());
    if (((File)localObject).exists()) {
      FileUtils.a((File)localObject);
    }
    if (TextUtils.isEmpty(paramString)) {
      FileUtils.a("Page/system", Common.f());
    }
    for (;;)
    {
      AppViewBaseActivity.b(true);
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramBoolean))
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      return;
      localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        FileUtils.a((Context)localObject, "Page/system", Common.a() + File.separator + paramString);
        if (new File(Common.a() + File.separator + paramString).exists()) {
          Common.d(paramString);
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.TaskThread
 * JD-Core Version:    0.7.0.1
 */