package com.tencent.tim.mvp.cloudfile;

import auhh;
import auhk.h;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudFileAndFolderOperationPresenter$2
  implements Runnable
{
  public CloudFileAndFolderOperationPresenter$2(auhh paramauhh, List paramList1, List paramList2, auhk.h paramh, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Iterator localIterator = this.KN.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      this.KO.add(auhh.b(localFileInfo));
    }
    ThreadManager.getUIHandler().post(new CloudFileAndFolderOperationPresenter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.CloudFileAndFolderOperationPresenter.2
 * JD-Core Version:    0.7.0.1
 */