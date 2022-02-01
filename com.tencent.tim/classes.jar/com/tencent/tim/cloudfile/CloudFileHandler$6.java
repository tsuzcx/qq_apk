package com.tencent.tim.cloudfile;

import ahav;
import aqhq;
import aqhs;
import ateh;
import audn;
import auef;
import aueh;
import com.tencent.cloudfile.FileInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class CloudFileHandler$6
  implements Runnable
{
  public CloudFileHandler$6(ateh paramateh, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.qD.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileInfo)localIterator.next();
      if (ahav.getFileType(((FileInfo)localObject).localPath) == 0)
      {
        String str = aqhs.bytes2HexStr(ahav.t(((FileInfo)localObject).localPath));
        if (str == null)
        {
          QLog.d("CloudFileHandler", 1, "thumb file name is null, filepath " + ((FileInfo)localObject).localPath);
        }
        else
        {
          str = str.toUpperCase();
          str = audn.a().wb() + auef.D(5, str);
          if (aueh.fileExistsAndNotEmpty(str))
          {
            QLog.d("CloudFileHandler", 1, "thumb has already exist " + str);
          }
          else
          {
            localObject = auef.lf(((FileInfo)localObject).localPath);
            if ((localObject == null) || (!aqhq.fileExistsAndNotEmpty((String)localObject))) {
              QLog.d("CloudFileHandler", 1, "create thumb failed " + (String)localObject);
            } else if (aueh.fileExistsAndNotEmpty(str)) {
              QLog.d("CloudFileHandler", 1, "create thumb success " + str);
            } else if (aqhq.renameFile(new File((String)localObject), new File(str))) {
              QLog.d("CloudFileHandler", 1, "rename thumb success " + str);
            } else {
              QLog.d("CloudFileHandler", 1, "rename thumb failed " + str);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileHandler.6
 * JD-Core Version:    0.7.0.1
 */