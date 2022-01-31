package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import gch;
import gci;
import gcj;

public class FMDialogUtil
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    BaseActivity localBaseActivity = SplashActivity.a;
    if (localBaseActivity == null) {}
    for (;;)
    {
      a(paramContext, paramContext.getString(paramInt1), paramInt2, paramFMDialogInterface);
      return;
      paramContext = localBaseActivity;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    gch localgch = new gch(paramFMDialogInterface);
    paramFMDialogInterface = new gci(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new gcj(paramContext, paramString, paramInt, localgch, paramFMDialogInterface));
      return;
    }
    DialogUtil.a(paramContext, 230, paramString, paramContext.getString(paramInt), 2131558705, 2131558706, localgch, paramFMDialogInterface).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil
 * JD-Core Version:    0.7.0.1
 */