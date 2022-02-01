package com.tencent.tim.mvp.cloudfile;

import auhh;
import auhi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudFileAndFolderOperationPresenter$1$1
  implements Runnable
{
  public CloudFileAndFolderOperationPresenter$1$1(auhi paramauhi) {}
  
  public void run()
  {
    Iterator localIterator = this.a.KN.iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      this.a.KO.add(auhh.b(localFileInfo));
    }
    ThreadManager.getUIHandler().post(new CloudFileAndFolderOperationPresenter.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.CloudFileAndFolderOperationPresenter.1.1
 * JD-Core Version:    0.7.0.1
 */