package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.qphone.base.util.BaseApplication;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  protected int a()
  {
    ClubContentJsonTask.a(this.a.a);
    SharedPreferences localSharedPreferences = this.a.a.a().getSharedPreferences("QQLite", 0);
    long l = localSharedPreferences.getLong("last_pull_club_content_update_time", 0L);
    ClubContentUpdateHandler localClubContentUpdateHandler;
    if (System.currentTimeMillis() - l > 43200000L)
    {
      localClubContentUpdateHandler = (ClubContentUpdateHandler)this.a.a.a(14);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.a();
        localSharedPreferences.edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    localSharedPreferences = this.a.a.a().getSharedPreferences("QQLite", 0);
    l = localSharedPreferences.getLong("last_pull_chatbackground_content_update_time", 0L);
    if (System.currentTimeMillis() - l > 43200000L)
    {
      localClubContentUpdateHandler = (ClubContentUpdateHandler)this.a.a.a(14);
      if (localClubContentUpdateHandler != null)
      {
        localClubContentUpdateHandler.b();
        localSharedPreferences.edit().putLong("last_pull_chatbackground_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */