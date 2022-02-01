package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmj;
import com.tencent.common.app.BaseApplicationImpl;
import uzn;

public class FriendProfileCardActivity$30$2
  implements Runnable
{
  public FriendProfileCardActivity$30$2(uzn paramuzn) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    aqmj.b(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.30.2
 * JD-Core Version:    0.7.0.1
 */