package com.tencent.mobileqq.app.activateFriends;

import acoe;
import acof;
import anaz;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$2
  implements Runnable
{
  public void run()
  {
    long l = acof.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (anaz.gQ() - l > 259200L)
    {
      acof.a(this.this$0).removeCallbacks(acof.a(this.this$0));
      this.this$0.cyu = acof.b(this.this$0);
      acoe.a(acof.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */