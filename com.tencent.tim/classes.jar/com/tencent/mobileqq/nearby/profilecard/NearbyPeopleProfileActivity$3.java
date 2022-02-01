package com.tencent.mobileqq.nearby.profilecard;

import aqek;
import aqiw;
import aqmr;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyPeopleProfileActivity$3
  implements Runnable
{
  NearbyPeopleProfileActivity$3(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((!aqiw.isNetSupport(BaseApplication.getContext())) && (this.this$0.crC)) {}
    byte[] arrayOfByte;
    long l;
    do
    {
      do
      {
        return;
      } while (NearbyPeopleProfileActivity.a(this.this$0) == null);
      arrayOfByte = NearbyPeopleProfileActivity.a(this.this$0).vSeed;
      l = NearbyPeopleProfileActivity.a(this.this$0).feedPreviewTime;
      if (this.this$0.adP > 0L)
      {
        aqek.a(this.this$0.c, this.this$0.app, this.this$0.adP, null, this.this$0.dms, arrayOfByte, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
    } while (aqmr.isEmpty(this.this$0.e.uin));
    aqek.a(this.this$0.c, this.this$0.app, 0L, this.this$0.e.uin, this.this$0.dms, arrayOfByte, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.3
 * JD-Core Version:    0.7.0.1
 */