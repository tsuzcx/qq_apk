package com.tencent.androidqqmail.mobileqq;

import android.util.Log;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

final class MobileQQEntryActivity$1
  implements IUiListener
{
  public void onCancel()
  {
    Log.d("MobileQQEntryActivity", "cancel");
  }
  
  public void onComplete(Object paramObject)
  {
    Log.d("MobileQQEntryActivity", "success");
  }
  
  public void onError(UiError paramUiError)
  {
    Log.d("MobileQQEntryActivity", "error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */