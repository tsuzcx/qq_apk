package com.tencent.mobileqq.apollo;

import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

final class ApolloRender$22
  implements Runnable
{
  public void run()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).toggleSoftInput(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.22
 * JD-Core Version:    0.7.0.1
 */