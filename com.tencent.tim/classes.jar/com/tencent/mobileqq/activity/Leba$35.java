package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import aneo;
import avsd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

class Leba$35
  implements Runnable
{
  Leba$35(Leba paramLeba) {}
  
  public void run()
  {
    localObject4 = (aneo)this.this$0.app.getManager(10);
    int j;
    Object localObject1;
    if (localObject4 != null)
    {
      j = ((aneo)localObject4).jn(1);
      if (localObject4 == null) {
        break label180;
      }
      localObject1 = ((aneo)localObject4).dF();
      label41:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      this.this$0.runOnUiThread(new Leba.35.1(this, j));
      if (localObject4 == null) {
        break label186;
      }
      i = ((aneo)localObject4).jn(2);
      label100:
      if ((i <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label191;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      i = 8;
      this.this$0.runOnUiThread(new Leba.35.2(this, (ArrayList)localObject1));
    }
    for (;;)
    {
      this.this$0.runOnUiThread(new Leba.35.5(this, i, j));
      return;
      j = 0;
      break;
      label180:
      localObject1 = null;
      break label41;
      label186:
      i = 0;
      break label100;
      for (;;)
      {
        for (;;)
        {
          try
          {
            label191:
            if (QLog.isColorLevel()) {
              QLog.d("UndealCount.Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
            }
            if (localObject4 == null) {
              continue;
            }
            localObject1 = ((aneo)localObject4).b(6);
            if (localObject4 == null) {
              continue;
            }
            localObject5 = ((aneo)localObject4).b(61);
            if (localObject4 == null) {
              continue;
            }
            localavsd = ((aneo)localObject4).b(3);
            localObject6 = "";
            localObject4 = "";
            if ((localObject1 == null) || (((avsd)localObject1).ES == null) || (((avsd)localObject1).ES.size() <= 0) || (((QZoneCountUserInfo)((avsd)localObject1).ES.get(0)).uin <= 0L) || (((avsd)localObject1).uCount <= 0L)) {
              continue;
            }
            localObject4 = ((avsd)localObject1).strShowMsg;
            localObject6 = ((QZoneCountUserInfo)((avsd)localObject1).ES.get(0)).uin + "";
            i = 1;
            localObject1 = localObject4;
            localObject4 = localObject6;
          }
          catch (Exception localException2)
          {
            avsd localavsd;
            Object localObject6;
            boolean bool;
            Object localObject2;
            i = 0;
            continue;
            Object localObject5 = localException2;
            Object localObject3 = localObject4;
            localObject4 = localObject5;
            continue;
            i = 0;
            localObject3 = localObject6;
            continue;
          }
          if ((i != 0) || (localObject5 == null) || (((avsd)localObject5).ES == null) || (((avsd)localObject5).ES.size() <= 0) || (((QZoneCountUserInfo)((avsd)localObject5).ES.get(0)).uin <= 0L) || (((avsd)localObject5).uCount <= 0L)) {
            continue;
          }
          localObject4 = ((avsd)localObject5).strShowMsg;
          localObject1 = ((QZoneCountUserInfo)((avsd)localObject5).ES.get(0)).uin + "";
          i = 1;
          localObject6 = localObject1;
          localObject5 = localObject4;
          if (i == 0)
          {
            localObject6 = localObject1;
            localObject5 = localObject4;
            if (localavsd != null)
            {
              localObject6 = localObject1;
              localObject5 = localObject4;
              if (localavsd.ES != null)
              {
                localObject6 = localObject1;
                localObject5 = localObject4;
                if (localavsd.ES.size() > 0)
                {
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (((QZoneCountUserInfo)localavsd.ES.get(0)).uin > 0L)
                  {
                    localObject6 = localObject1;
                    localObject5 = localObject4;
                    if (localavsd.uCount > 0L)
                    {
                      localObject5 = localavsd.strShowMsg;
                      localObject6 = ((QZoneCountUserInfo)localavsd.ES.get(0)).uin + "";
                    }
                  }
                }
              }
            }
          }
          bool = TextUtils.isEmpty((CharSequence)localObject5);
          if (bool) {
            continue;
          }
          i = -1;
          try
          {
            this.this$0.runOnUiThread(new Leba.35.3(this, (String)localObject5, (String)localObject6));
          }
          catch (Exception localException1) {}
        }
        QLog.e("Leba", 1, "updateQZoneRedFlag" + localException1);
        break;
        localObject2 = null;
        continue;
        localObject5 = null;
        continue;
        localavsd = null;
      }
      this.this$0.runOnUiThread(new Leba.35.4(this));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35
 * JD-Core Version:    0.7.0.1
 */