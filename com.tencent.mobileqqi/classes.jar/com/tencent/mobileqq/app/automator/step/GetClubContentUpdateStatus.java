package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  protected int a()
  {
    SharedPreferences localSharedPreferences = this.a.a.a().getSharedPreferences("mobileQQi", 0);
    long l = localSharedPreferences.getLong("last_pull_club_content_update_time", 0L);
    if (System.currentTimeMillis() - l > 43200000L)
    {
      ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)this.a.a.a(15);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.a();
        localSharedPreferences.edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */