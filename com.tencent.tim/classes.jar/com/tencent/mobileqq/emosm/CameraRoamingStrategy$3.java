package com.tencent.mobileqq.emosm;

import accj;
import affs;
import affx;
import afgw;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CameraRoamingStrategy$3
  implements Runnable
{
  public CameraRoamingStrategy$3(affs paramaffs, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.val$list.size())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.val$list.get(i);
      if (!TextUtils.isEmpty(localCameraEmotionData.resid))
      {
        localCameraEmotionData.RomaingType = "needDel";
        this.this$0.a().b(localCameraEmotionData);
        anot.a(this.this$0.app, "dc00898", "", "", "0X800A372", "0X800A372", 0, 0, "", "", localCameraEmotionData.resid, "");
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("CameraRoamingStrategy", 2, "delete from local, Roma Type: " + localCameraEmotionData.RomaingType);
        }
        this.this$0.a().a(localCameraEmotionData);
      }
    }
    ((afgw)this.this$0.app.getManager(334)).cZq();
    ((accj)this.this$0.app.getBusinessHandler(160)).f(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */