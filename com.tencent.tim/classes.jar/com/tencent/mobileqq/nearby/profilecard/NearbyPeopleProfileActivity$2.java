package com.tencent.mobileqq.nearby.profilecard;

import ajpj;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aqek;
import aqiw;
import aqmr;
import aurh;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$2
  implements Runnable
{
  NearbyPeopleProfileActivity$2(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, aurh paramaurh) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.aJB()))
    {
      this.a.aaZ(4);
      this.a.aaY(5);
      this.a.aaY(8);
    }
    Object localObject3 = this.this$0.app.a().createEntityManager();
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    label183:
    long l;
    label209:
    boolean bool2;
    if (localObject3 != null)
    {
      localObject1 = null;
      localObject2 = null;
      if (NearbyPeopleProfileActivity.a(this.this$0) == 0)
      {
        if (this.this$0.adP > 0L) {
          localObject2 = (NearbyPeopleCard)((EntityManager)localObject3).find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.this$0.adP) });
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!aqmr.isEmpty(this.this$0.e.uin))
          {
            localObject1 = (NearbyPeopleCard)((EntityManager)localObject3).find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.e.uin });
            break label715;
          }
        }
        ((EntityManager)localObject3).close();
        if (localObject1 == null) {
          break label1073;
        }
        localObject2 = ((NearbyPeopleCard)localObject1).vSeed;
        l = ((NearbyPeopleCard)localObject1).feedPreviewTime;
        bool1 = true;
        if (this.this$0.mMode == 1) {
          break label1064;
        }
        if (localObject1 != null) {
          break label1061;
        }
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).tinyId = this.this$0.adP;
        ((NearbyPeopleCard)localObject1).uin = this.this$0.e.uin;
        label261:
        if ((!TextUtils.isEmpty(this.this$0.e.nickname)) && (TextUtils.isEmpty(((NearbyPeopleCard)localObject1).nickname))) {
          ((NearbyPeopleCard)localObject1).nickname = this.this$0.e.nickname;
        }
        if (NearbyPeopleProfileActivity.kI(this.this$0.from))
        {
          if (this.this$0.e.age != -1) {
            ((NearbyPeopleCard)localObject1).age = this.this$0.e.age;
          }
          if (this.this$0.e.gender != -1) {
            ((NearbyPeopleCard)localObject1).gender = this.this$0.e.gender;
          }
          if (this.this$0.e.constellation != 0) {
            ((NearbyPeopleCard)localObject1).constellation = this.this$0.e.constellation;
          }
        }
        if (this.this$0.e.maritalStatus != 0) {
          ((NearbyPeopleCard)localObject1).maritalStatus = this.this$0.e.maritalStatus;
        }
        if (this.this$0.e.profession_id != 0) {
          ((NearbyPeopleCard)localObject1).job = this.this$0.e.profession_id;
        }
        if (!TextUtils.isEmpty(this.this$0.e.aOE)) {
          ((NearbyPeopleCard)localObject1).aioDistanceAndTime = this.this$0.e.aOE;
        }
        this.this$0.mUin = ((NearbyPeopleCard)localObject1).uin;
        localObject3 = (ajpj)this.this$0.app.getManager(106);
        String str = this.this$0.app.getCurrentAccountUin();
        boolean bool3 = this.this$0.aWh;
        if (this.this$0.from != -1) {
          break label763;
        }
        bool2 = true;
        label552:
        bool2 = ((ajpj)localObject3).a((NearbyPeopleCard)localObject1, str, bool3, bool2, this.this$0.dms, bool1);
        localObject3 = this.this$0.getIntent();
        bool1 = bool2;
        if (localObject3 != null)
        {
          bool1 = bool2;
          if (((Intent)localObject3).getIntExtra("refresh_flag", 0) == 1) {
            bool1 = true;
          }
        }
        if (!bool1) {
          this.this$0.mHandler.obtainMessage(101, localObject1).sendToTarget();
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.nearby_people_card.", 4, "isNeedUpdateNearbyCard tinyid is: " + ((NearbyPeopleCard)localObject1).tinyId + " uin is: " + ((NearbyPeopleCard)localObject1).uin + " " + bool1);
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if ((!aqiw.isNetSupport(BaseApplication.getContext())) && (bool1))
      {
        this.this$0.runOnUiThread(new NearbyPeopleProfileActivity.2.1(this));
        label715:
        return;
        if (NearbyPeopleProfileActivity.a(this.this$0) <= 0L) {
          break label183;
        }
        localObject1 = (NearbyPeopleCard)((EntityManager)localObject3).find(NearbyPeopleCard.class, "nowId=?", new String[] { String.valueOf(NearbyPeopleProfileActivity.a(this.this$0)) });
        break label183;
        label763:
        bool2 = false;
        break label552;
      }
      if ((this.a != null) && (this.a.aJB()))
      {
        this.a.aaY(6);
        this.a.aaY(9);
      }
      int i = (int)this.this$0.e.Gz;
      if (this.this$0.e.Gz == 1L) {
        i = 6;
      }
      for (;;)
      {
        if (this.this$0.mMode != 1)
        {
          if (!bool1) {
            break;
          }
          if (this.this$0.adP > 0L)
          {
            aqek.a(this.this$0.c, this.this$0.app, this.this$0.adP, null, this.this$0.dms, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
            return;
          }
          aqek.a(this.this$0.c, this.this$0.app, 0L, this.this$0.e.uin, this.this$0.dms, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
          return;
        }
        aqek.a(this.this$0.c, this.this$0.app, 0L, this.this$0.app.getCurrentAccountUin(), this.this$0.dms, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.kI(this.this$0.from), NearbyPeopleProfileActivity.a(this.this$0), NearbyPeopleProfileActivity.a(this.this$0));
        return;
      }
      label1061:
      break label261;
      label1064:
      bool1 = true;
      localObject1 = localObject2;
      continue;
      label1073:
      l = 0L;
      localObject2 = null;
      break label209;
      bool1 = true;
      l = 0L;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.2
 * JD-Core Version:    0.7.0.1
 */