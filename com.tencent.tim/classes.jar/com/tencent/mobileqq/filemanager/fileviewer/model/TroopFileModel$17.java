package com.tencent.mobileqq.filemanager.fileviewer.model;

import aguk.b;
import aguu;
import agve;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import smq;

public class TroopFileModel$17
  implements Runnable
{
  public TroopFileModel$17(aguu paramaguu, FileManagerEntity paramFileManagerEntity, aguk.b paramb) {}
  
  public void run()
  {
    if (this.g.isZipInnerFile)
    {
      smq.a(this.this$0.mAppInterface, this.g.TroopUin, this.g.zipFilePath, this.g.busId, new agve(this));
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.g.TroopUin);
    if (localTroopFileTransferManager == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileModel<FileAssistant>", 4, "bad troopUin" + this.g.TroopUin);
      }
      this.a.djD();
      return;
    }
    localTroopFileTransferManager.a(this.g.strTroopFilePath, this.g.fileName, this.g.fileSize, this.g.busId, aguu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.17
 * JD-Core Version:    0.7.0.1
 */