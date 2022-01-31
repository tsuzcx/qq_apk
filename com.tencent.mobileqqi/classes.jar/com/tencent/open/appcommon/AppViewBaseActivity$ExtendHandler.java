package com.tencent.open.appcommon;

import android.os.Handler;
import android.os.Message;
import com.tencent.open.base.LogUtility;
import java.io.PrintStream;
import java.lang.ref.WeakReference;

public class AppViewBaseActivity$ExtendHandler
  extends Handler
{
  protected final WeakReference a;
  
  public AppViewBaseActivity$ExtendHandler(AppViewBaseActivity paramAppViewBaseActivity)
  {
    this.a = new WeakReference(paramAppViewBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    System.out.println(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (AppViewBaseActivity)this.a.get();
    } while (paramMessage == null);
    try
    {
      paramMessage.l();
      return;
    }
    catch (Exception paramMessage)
    {
      LogUtility.c("AppViewBaseActivity", "extendHandler>>>", paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.AppViewBaseActivity.ExtendHandler
 * JD-Core Version:    0.7.0.1
 */