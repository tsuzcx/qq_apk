package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;

public class Update
  extends Step
  implements Handler.Callback
{
  private static final int A = 3;
  private static final int B = 4;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4, 20, 22 };
  private static final int y = 1;
  private static final int z = 2;
  private int C;
  private int D = 6000;
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private int a()
  {
    double d2 = (System.currentTimeMillis() - this.jdField_a_of_type_Long) * 1.0D / this.D * (this.C - 10);
    double d1;
    if (d2 < this.jdField_a_of_type_Double)
    {
      d1 = this.jdField_a_of_type_Double;
      this.jdField_a_of_type_Double = d1;
      if (this.jdField_a_of_type_Double >= 0.0D) {
        break label106;
      }
      this.jdField_a_of_type_Double = 0.0D;
    }
    for (;;)
    {
      return (int)this.jdField_a_of_type_Double;
      d1 = d2;
      if (d2 <= this.C - 10) {
        break;
      }
      d1 = this.jdField_a_of_type_Double + (this.C - this.jdField_a_of_type_Double) * 1.0D / 5.0D;
      break;
      label106:
      if (this.jdField_a_of_type_Double > 100.0D) {
        this.jdField_a_of_type_Double = 100.0D;
      }
    }
  }
  
  protected boolean a()
  {
    if (!BaseApplicationImpl.b) {
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    String str = System.getProperty("java.vm.version");
    if ((str != null) && (!str.startsWith("1"))) {
      this.D = 30000;
    }
    try
    {
      Thread.sleep(2000L);
      boolean bool = Step.AmStepFactory.a(0, this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, jdField_a_of_type_ArrayOfInt).b();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return true;
            localObject = this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a;
          } while (!(localObject instanceof InstallActivity));
          paramMessage = ((Activity)localObject).findViewById(2131297258);
          localObject = (ViewGroup)((Activity)localObject).findViewById(2131297257);
        } while ((paramMessage == null) || (localObject == null));
        paramMessage.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getApplicationContext(), 2130903649, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297959));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298822));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("升级中，请耐心等待...");
        ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Double = 0.0D;
        this.C = 90;
        return true;
        i = a();
        if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress() > i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getString(2131364255), new Object[] { Integer.valueOf(i) }));
      }
      if (i < 99)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
      return true;
    case 3: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_Double = 90.0D;
      this.C = 100;
      this.D = 6000;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, this.D);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */