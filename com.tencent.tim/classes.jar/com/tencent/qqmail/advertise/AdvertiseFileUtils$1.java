package com.tencent.qqmail.advertise;

import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.io.FilenameFilter;

class AdvertiseFileUtils$1
  implements FilenameFilter
{
  AdvertiseFileUtils$1(AdvertiseFileUtils paramAdvertiseFileUtils) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((paramString != null) && (paramString.contains(".nomedia")))
    {
      QMLog.log(4, AdvertiseFileUtils.TAG, "AdvertiseManager FilenameFilter noAccept" + paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseFileUtils.1
 * JD-Core Version:    0.7.0.1
 */