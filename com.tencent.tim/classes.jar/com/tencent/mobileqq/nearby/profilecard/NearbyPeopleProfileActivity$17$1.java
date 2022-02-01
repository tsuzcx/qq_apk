package com.tencent.mobileqq.nearby.profilecard;

import akcl;
import akcw;
import com.tencent.qphone.base.util.QLog;

public class NearbyPeopleProfileActivity$17$1
  implements Runnable
{
  public NearbyPeopleProfileActivity$17$1(akcl paramakcl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a.this$0.mMode == 1) {}
    do
    {
      return;
      if (NearbyPeopleProfileActivity.a(this.a.this$0) != null)
      {
        NearbyPeopleProfileActivity.a(this.a.this$0).cB(this.val$url, this.val$isSuccess);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "mDisplayModel == null ！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1
 * JD-Core Version:    0.7.0.1
 */