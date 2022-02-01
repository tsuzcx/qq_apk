package com.tencent.tim.cloudfile;

import atgg;
import aths;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;

public class CloudFileSDKCallback$4
  implements Runnable
{
  public CloudFileSDKCallback$4(atgg paramatgg, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.val$list).iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2)) {
        aths.a().U(localFileManagerEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSDKCallback.4
 * JD-Core Version:    0.7.0.1
 */