package com.tencent.mobileqq.activity;

import ajrb;
import android.app.Dialog;
import android.os.Bundle;
import aqcw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import vet;
import veu;
import vev;

public class LbsBaseActivity
  extends IphoneTitleBarActivity
{
  private Dialog R;
  private Dialog S;
  private Dialog T;
  
  private boolean PM()
  {
    return ajrb.nA(getAppInterface().getAccount());
  }
  
  private void T(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  private void U(Runnable paramRunnable)
  {
    paramRunnable = new vet(this, paramRunnable);
    this.S = aqcw.a(this, 2131693145, vv(), 2131692910, 2131692907, new veu(this), new vev(this));
    this.S.setOnDismissListener(paramRunnable);
    this.S.show();
  }
  
  protected void R(Runnable paramRunnable)
  {
    T(paramRunnable);
  }
  
  protected void S(Runnable paramRunnable)
  {
    if (PM())
    {
      T(paramRunnable);
      return;
    }
    U(paramRunnable);
  }
  
  public void aL(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  public void bQr()
  {
    finish();
  }
  
  /* Error */
  public void c(Dialog paramDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 110	android/app/Dialog:dismiss	()V
    //   4: aload_1
    //   5: invokestatic 115	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 115	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 115	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   20: aload_2
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	LbsBaseActivity
    //   0	22	1	paramDialog	Dialog
    //   9	1	2	localException	java.lang.Exception
    //   15	6	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.R != null) && (this.R.isShowing())) {
      c(this.R);
    }
    if ((this.S != null) && (this.S.isShowing())) {
      c(this.S);
    }
    if ((this.T != null) && (this.T.isShowing())) {
      this.T.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected int vv()
  {
    return 2131693140;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity
 * JD-Core Version:    0.7.0.1
 */