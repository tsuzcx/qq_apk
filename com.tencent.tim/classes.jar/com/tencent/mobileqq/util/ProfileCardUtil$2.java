package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ProfileCardUtil$2
  implements Runnable
{
  public ProfileCardUtil$2(String paramString) {}
  
  public void run()
  {
    File localFile = new File(this.csw);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      boolean bool = localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, "delete result=" + bool + " f.path=" + this.csw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.2
 * JD-Core Version:    0.7.0.1
 */