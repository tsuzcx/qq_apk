package com.tencent.tim.cloudfile;

import atgg;
import aths;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CloudFileSDKCallback$2
  implements Runnable
{
  public CloudFileSDKCallback$2(atgg paramatgg, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.DV).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FileManagerEntity))
      {
        localObject = ((FileManagerEntity)localObject).combinePhotoList;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
            if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2)) {
              aths.a().U(localFileManagerEntity);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSDKCallback.2
 * JD-Core Version:    0.7.0.1
 */