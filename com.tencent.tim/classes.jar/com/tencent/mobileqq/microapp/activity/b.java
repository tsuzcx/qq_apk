package com.tencent.mobileqq.microapp.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

final class b
  implements DialogInterface.OnDismissListener
{
  b(LoadingFragment paramLoadingFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.getActivity().doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.activity.b
 * JD-Core Version:    0.7.0.1
 */