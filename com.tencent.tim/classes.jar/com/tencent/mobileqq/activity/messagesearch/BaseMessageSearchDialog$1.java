package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.view.View;
import ayxa;
import com.tencent.qphone.base.util.QLog;
import wja;
import zkw;

public class BaseMessageSearchDialog$1
  implements Runnable
{
  public BaseMessageSearchDialog$1(zkw paramzkw, View paramView, Activity paramActivity) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.val$rootView.getLocationOnScreen(arrayOfInt);
    int i = ayxa.getNotchInScreenHeight(this.val$activity);
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageSearchDialog", 2, "rootView post : x -> " + arrayOfInt[0] + ", y -> " + arrayOfInt[1] + ", notchHeight -> " + i);
    }
    if (arrayOfInt[1] < i) {
      this.val$rootView.setPadding(this.val$rootView.getPaddingLeft(), i, this.val$rootView.getPaddingRight(), this.val$rootView.getPaddingBottom());
    }
    wja.eR(this.this$0.findViewById(2131366542));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */