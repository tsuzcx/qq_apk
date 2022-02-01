package com.tencent.mobileqq.microapp.activity;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.app.b.b;
import com.tencent.qphone.base.util.QLog;

final class c
  extends b.b
{
  c(LoadingFragment paramLoadingFragment) {}
  
  public void a(b.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadingActivity", 2, "onStateChange...MiniAppStateMsg=" + parama);
    }
    switch (parama.a)
    {
    case 0: 
    case 1: 
    default: 
      return;
    case 2: 
      this.a.uiHandler.removeMessages(1);
      this.a.getActivity().setResult(-1);
      this.a.getActivity().finish();
      return;
    }
    LoadingFragment.access$102(this.a, true);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.activity.c
 * JD-Core Version:    0.7.0.1
 */