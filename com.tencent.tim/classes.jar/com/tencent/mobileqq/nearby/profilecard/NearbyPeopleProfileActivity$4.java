package com.tencent.mobileqq.nearby.profilecard;

import ajpj;
import aqek;
import aqiw;
import aqmr;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyPeopleProfileActivity$4
  implements Runnable
{
  NearbyPeopleProfileActivity$4(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    Object localObject = (ajpj)this.this$0.app.getManager(106);
    this.this$0.crC = ((ajpj)localObject).b(NearbyPeopleProfileActivity.a(this.this$0));
    if (!this.this$0.crC) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((!aqiw.isNetSupport(BaseApplication.getContext())) && (this.this$0.crC));
      localObject = NearbyPeopleProfileActivity.a(this.this$0).vSeed;
      l = NearbyPeopleProfileActivity.a(this.this$0).feedPreviewTime;
      if (this.this$0.adP > 0L)
      {
        aqek.a(this.this$0.c, this.this$0.app, this.this$0.adP, null, this.this$0.dms, (byte[])localObject, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
    } while (aqmr.isEmpty(this.this$0.e.uin));
    aqek.a(this.this$0.c, this.this$0.app, 0L, this.this$0.e.uin, this.this$0.dms, (byte[])localObject, l, true, this.this$0.e.Gz, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.4
 * JD-Core Version:    0.7.0.1
 */