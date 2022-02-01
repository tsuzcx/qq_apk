package com.tencent.tim.filemanager.fileviewer.model;

import atzy.b;
import auau;
import auay;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import smq;

public class TroopFileModel$11
  implements Runnable
{
  public TroopFileModel$11(auau paramauau, FileManagerEntity paramFileManagerEntity, atzy.b paramb) {}
  
  public void run()
  {
    if (this.g.isZipInnerFile)
    {
      smq.a(this.this$0.mAppInterface, this.g.TroopUin, this.g.zipFilePath, this.g.busId, new auay(this));
      return;
    }
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.g.TroopUin);
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileModel", 4, "bad troopUin" + this.g.TroopUin);
        }
        this.a.djD();
        return;
      }
    }
    finally {}
    localObject.a(this.g.strTroopFilePath, this.g.fileName, this.g.fileSize, this.g.busId, auau.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.11
 * JD-Core Version:    0.7.0.1
 */