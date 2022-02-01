package com.tencent.qqmail.view.fingerprint;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import moai.oss.KvHelper;

public class FingerPrintDialog
  extends ReportDialogFragment
  implements Callback
{
  private static final int DEFAULT_MAX_RETRY_TIMES = 3;
  private static final long LOCK_DURATION = 60000L;
  public static final String TAG = "FingerPrintDialog";
  private Button cancelBtn;
  private DismissListener dismissListener;
  private String failTimesStringFormat;
  private FingerprintCallback fingerprintCallback;
  private BaseFingerprintManager fingerprintManger;
  private int maxRetryTimes = 3;
  private ImageView stateImg;
  private TextView stateTv;
  
  private static void addRetryTimes()
  {
    SharedPreferenceUtil.setFingerprintRetryTimes(SharedPreferenceUtil.getFingerprintRetryTimes() + 1);
  }
  
  private static long getLastFailtime()
  {
    long l = SharedPreferenceUtil.getFingerprintLastFailTime();
    QMLog.log(4, "FingerPrintDialog", "getLastFailtime val = " + l + " Diff from now = " + (l - System.currentTimeMillis()));
    return l;
  }
  
  private static int getRetryTimes()
  {
    int i = SharedPreferenceUtil.getFingerprintRetryTimes();
    QMLog.log(4, "FingerPrintDialog", "getRetryTimes val = " + i);
    return i;
  }
  
  private static long getUnlockTime()
  {
    long l = SharedPreferenceUtil.getFingerprintUnlockTime();
    QMLog.log(4, "FingerPrintDialog", "getUnlockTime val = " + l + " Diff from now = " + (l - System.currentTimeMillis()));
    return SharedPreferenceUtil.getFingerprintUnlockTime();
  }
  
  public static boolean isRequestNormal()
  {
    return System.currentTimeMillis() >= getUnlockTime();
  }
  
  private static void setLastFailtime(long paramLong)
  {
    SharedPreferenceUtil.setFingerprintLastFailTime(paramLong);
  }
  
  private static void setRetryTimes(int paramInt)
  {
    SharedPreferenceUtil.setFingerprintRetryTimes(paramInt);
  }
  
  private static void setUnlockTime(long paramLong)
  {
    SharedPreferenceUtil.setFingerprintUnlockTime(paramLong);
  }
  
  public void dismiss()
  {
    super.dismissAllowingStateLoss();
    if (this.dismissListener != null) {
      this.dismissListener.onDismiss();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.fingerprintCallback = ((FingerprintCallback)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement FingerprintCallback");
    }
  }
  
  public void onAuthenticated()
  {
    setRetryTimes(0);
    setUnlockTime(-1L);
    this.stateImg.setImageResource(2130840707);
    this.stateTv.setText(2131719853);
    Threads.runOnMainThread(new FingerPrintDialog.2(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setCancelable(false);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559231, paramViewGroup, false);
    this.stateImg = ((ImageView)paramLayoutInflater.findViewById(2131367107));
    this.stateTv = ((TextView)paramLayoutInflater.findViewById(2131367108));
    this.cancelBtn = ((Button)paramLayoutInflater.findViewById(2131372255));
    this.cancelBtn.setOnClickListener(new FingerPrintDialog.1(this));
    this.fingerprintManger = FingerprintFactory.createInstance();
    this.fingerprintManger.setCallback(this);
    this.failTimesStringFormat = getString(2131719852);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onError()
  {
    this.stateImg.setImageResource(2130840706);
    this.stateTv.setText(2131719851);
    setUnlockTime(System.currentTimeMillis() + 60000L);
  }
  
  public boolean onFail()
  {
    boolean bool = false;
    this.stateImg.setImageResource(2130840706);
    addRetryTimes();
    int i = getRetryTimes();
    QMLog.log(4, "FingerPrintDialog", "onFail for the " + i + " times");
    this.stateTv.setText(String.format(this.failTimesStringFormat, new Object[] { Integer.valueOf(this.maxRetryTimes - i) }));
    if (i >= this.maxRetryTimes)
    {
      KvHelper.eventFingerprintOvertry(new double[0]);
      onError();
      this.fingerprintManger.stopListening();
      this.stateImg.postDelayed(new FingerPrintDialog.3(this), 700L);
    }
    for (;;)
    {
      setLastFailtime(System.currentTimeMillis());
      return bool;
      bool = true;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("FingerPrintDialog", "onPause");
    this.fingerprintManger.stopListening();
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("FingerPrintDialog", "onResume");
    if (isRequestNormal())
    {
      this.fingerprintManger.startListening();
      this.stateImg.setImageResource(2130840491);
      this.stateTv.setText(2131719854);
      setUnlockTime(-1L);
      if (System.currentTimeMillis() > getLastFailtime() + 60000L) {
        setRetryTimes(0);
      }
      return;
    }
    onError();
  }
  
  public void setDismissListener(DismissListener paramDismissListener)
  {
    this.dismissListener = paramDismissListener;
  }
  
  public static abstract interface DismissListener
  {
    public abstract void onDismiss();
  }
  
  public static abstract interface FingerprintCallback
  {
    public abstract void onAuthenticated();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.FingerPrintDialog
 * JD-Core Version:    0.7.0.1
 */