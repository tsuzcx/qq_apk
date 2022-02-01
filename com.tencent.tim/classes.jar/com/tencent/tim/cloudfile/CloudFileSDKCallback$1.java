package com.tencent.tim.cloudfile;

import atgg;
import aths;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;

public class CloudFileSDKCallback$1
  implements Runnable
{
  public CloudFileSDKCallback$1(atgg paramatgg, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.DV).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)localObject;
        if ((((FileManagerEntity)localObject).nFileType == 0) || (((FileManagerEntity)localObject).nFileType == 2)) {
          aths.a().U((FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSDKCallback.1
 * JD-Core Version:    0.7.0.1
 */