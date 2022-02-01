package com.tencent.tim.cloudfile.troopFile;

import android.content.SharedPreferences;
import android.text.TextUtils;
import apcy;
import apsc;
import atgi;
import athu;
import atmr;
import com.tencent.cloudfile.CloudAIORecentFileExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AutoRetryManager$3$1
  implements Runnable
{
  AutoRetryManager$3$1(AutoRetryManager.3 param3, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (this.a.g == null)
    {
      QLog.e("AutoRetryManager.TroopAutoSaveToCloud", 1, "statusInfo is null");
      return;
    }
    if (this.a.b == null)
    {
      QLog.e("AutoRetryManager.TroopAutoSaveToCloud", 1, "saveInfo is null");
      return;
    }
    if (!AutoRetryManager.a(this.a.this$0).getApplication().getSharedPreferences(AutoRetryManager.a(this.a.this$0).getCurrentAccountUin(), 0).getBoolean("tim_cloudfile_autosave_flag", true))
    {
      QLog.w("AutoRetryManager.TroopAutoSaveToCloud", 1, "!!!!!!!autosave is off!!!!!!!");
      return;
    }
    if ((TroopFileCopyInfoEntity)AutoRetryManager.a(this.a.this$0).find(TroopFileCopyInfoEntity.class, this.a.g.FilePath) != null)
    {
      QLog.w("AutoRetryManager.TroopAutoSaveToCloud", 1, "file:" + this.a.g.FilePath + "is in db, maybe is process!");
      return;
    }
    CloudAIORecentFileExt localCloudAIORecentFileExt = athu.a(AutoRetryManager.a(this.a.this$0), this.l);
    TroopFileData localTroopFileData = apsc.a(this.a.b.troopUin).a(AutoRetryManager.a(this.a.this$0), this.a.b.strFileID);
    long l2 = this.a.b.uploadUin;
    long l1 = l2;
    if (localTroopFileData != null)
    {
      l1 = l2;
      if (!TextUtils.isEmpty(localTroopFileData.FromUin)) {
        l1 = Long.parseLong(localTroopFileData.FromUin);
      }
    }
    this.a.b.uploadUin = l1;
    localCloudAIORecentFileExt.creatorUin = l1;
    localCloudAIORecentFileExt.uuid = this.l.strTroopFilePath;
    atgi.a().a(localCloudAIORecentFileExt, new atmr(this, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoRetryManager.3.1
 * JD-Core Version:    0.7.0.1
 */