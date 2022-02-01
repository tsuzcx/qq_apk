package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import ixp;
import java.lang.ref.WeakReference;
import jlc;

public class AVLoadingDialogActivity
  extends BaseActivity
{
  final String TAG = "AVLoadingDialogActivity_" + AudioHelper.hG();
  BroadcastReceiver mBroadcastReceiver = new ixp(this);
  Handler mHandler = new a(this.TAG);
  
  Dialog b()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131559761);
    localReportDialog.setCancelable(false);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131373180);
    if (localTextView != null) {
      localTextView.setText(2131698107);
    }
    return localReportDialog;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.mBroadcastReceiver, paramBundle);
    QLog.d(this.TAG, 1, "avideo doOnCreate");
    paramBundle = getIntent();
    String str = this.TAG + ".doOnCreate";
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getExtras();; paramBundle = null)
    {
      AudioHelper.I(str, paramBundle);
      return bool;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.d(this.TAG, 1, "doOnDestroy");
    this.mHandler.removeMessages(0);
    this.mHandler.removeMessages(1);
    unregisterReceiver(this.mBroadcastReceiver);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    QLog.d(this.TAG, 1, "doOnResume");
    showDialog(0);
    WeakReference localWeakReference = new WeakReference(this);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localWeakReference;
    this.mHandler.sendMessageDelayed(localMessage, 300L);
    localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = localWeakReference;
    this.mHandler.sendMessageDelayed(localMessage, 5000L);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return b();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public static class a
    extends Handler
  {
    final String TAG;
    
    a(String paramString)
    {
      this.TAG = paramString;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof WeakReference)))
      {
        localObject = (WeakReference)paramMessage.obj;
        if (localObject != null)
        {
          localObject = ((WeakReference)localObject).get();
          if ((localObject == null) || (!(localObject instanceof AVLoadingDialogActivity))) {}
        }
      }
      for (Object localObject = new WeakReference((AVLoadingDialogActivity)localObject);; localObject = null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          do
          {
            return;
          } while ((localObject == null) || (((WeakReference)localObject).get() == null));
          paramMessage = (Intent)((AVLoadingDialogActivity)((WeakReference)localObject).get()).getIntent().getParcelableExtra("avactivity_intent");
          paramMessage.setExtrasClassLoader(ResultRecord.class.getClassLoader());
          long l = jlc.a(paramMessage);
          QLog.w(this.TAG, 1, "avideo handleMessage MSG_START_AVACTIVITY, seq[" + l + "]");
          try
          {
            AudioHelper.I(this.TAG + ".MSG_START_AVACTIVITY", paramMessage.getExtras());
            ((AVLoadingDialogActivity)((WeakReference)localObject).get()).startActivity(paramMessage);
            ((AVLoadingDialogActivity)((WeakReference)localObject).get()).overridePendingTransition(2130772239, 0);
            return;
          }
          catch (Exception paramMessage)
          {
            QLog.w(this.TAG, 1, "MSG_START_AVACTIVITY, Exception, seq[" + l + "]", paramMessage);
            return;
          }
        } while ((localObject == null) || (((WeakReference)localObject).get() == null));
        ((AVLoadingDialogActivity)((WeakReference)localObject).get()).finish();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity
 * JD-Core Version:    0.7.0.1
 */