package com.tencent.tim.mvp.cloudfile;

import aths;
import aujb;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;

public class TopLevelFileListPresenter$1$1
  implements Runnable
{
  public TopLevelFileListPresenter$1$1(aujb paramaujb, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$list.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      aths.a().U(localFileManagerEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.TopLevelFileListPresenter.1.1
 * JD-Core Version:    0.7.0.1
 */