package com.tencent.mobileqq.nearby.profilecard;

import akgm;
import akyj;
import aooi;
import aool;
import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class NearbyProfileEditTribePanel$16
  implements Runnable
{
  public NearbyProfileEditTribePanel$16(akgm paramakgm) {}
  
  public void run()
  {
    akgm.a(this.this$0, (PicInfo)this.this$0.W.poll());
    if (akgm.a(this.this$0) == null) {
      return;
    }
    CompressInfo localCompressInfo = new CompressInfo(akgm.a(this.this$0).localPath, 0);
    localCompressInfo.picType = 0;
    akyj.b(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + localCompressInfo.destPath);
    }
    if (!aqmr.isEmpty(localCompressInfo.destPath))
    {
      aool localaool = new aool();
      localaool.cNy = true;
      localaool.dQ = localCompressInfo.destPath;
      localaool.mFileType = 8;
      this.this$0.a.app.a().a(localaool);
      return;
    }
    this.this$0.a.runOnUiThread(new NearbyProfileEditTribePanel.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16
 * JD-Core Version:    0.7.0.1
 */