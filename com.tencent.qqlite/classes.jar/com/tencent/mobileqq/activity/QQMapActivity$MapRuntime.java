package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import bdw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import mqq.app.MobileQQ;

public class QQMapActivity$MapRuntime
  extends PluginRuntime
  implements Thread.UncaughtExceptionHandler
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdw(this);
  private Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  
  protected void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.process.exit");
    paramBundle.addAction("mqql.intent.action.ACCOUNT_CHANGED");
    paramBundle.addAction("mqql.intent.action.LOGOUT");
    paramBundle.addAction("mqql.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName());
    MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    Step.AmStepFactory.a(11, BaseApplicationImpl.a, null).b();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    PluginRuntime.handleCrash(paramThrowable, "QQMapActivity", MobileQQ.getContext());
    if (this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler != null) {
      this.jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.MapRuntime
 * JD-Core Version:    0.7.0.1
 */