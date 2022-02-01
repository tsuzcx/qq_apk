package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

class FaceDownloader$2
  implements Runnable
{
  FaceDownloader$2(FaceDownloader paramFaceDownloader) {}
  
  public void run()
  {
    Object localObject = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2|1");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "initDPCFlag headWapConn:" + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length > 7) {}
    try
    {
      FaceDownloader.cb(Integer.parseInt(localObject[7]));
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initDPCFlag DPC_WAP_DIRECT_CONNECT=" + FaceDownloader.access$500());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.qqhead.FaceDownloader", 2, "initDPCFlag error :", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.2
 * JD-Core Version:    0.7.0.1
 */