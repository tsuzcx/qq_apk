package com.tencent.tim.cloudfile;

import agne;
import android.content.SharedPreferences;
import ateh;
import athu.a;
import athv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public final class CloudFileUtils$1
  implements Runnable
{
  public CloudFileUtils$1(QQAppInterface paramQQAppInterface, athu.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileUtils", 2, "queryFileEntitiesFromDB thread start");
    }
    Object localObject1;
    if (this.val$app.getApplication().getSharedPreferences("OfflineFileMerge" + this.val$app.getCurrentUin(), 0).getLong("LastRequestTime", 0L) + 82800000L > NetConnInfoCenter.getServerTimeMillis())
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileUtils", 2, "queryFileEntitiesFromDB frequency control, pass this time");
      }
      localObject1 = new ArrayList(this.val$app.a().eV());
      Object localObject2;
      if (this.a != null)
      {
        localObject2 = new ArrayList();
        ((List)localObject2).addAll((Collection)localObject1);
        this.a.nH((List)localObject2);
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
          ateh localateh = (ateh)this.val$app.getBusinessHandler(180);
          if (((FileManagerEntity)localObject2).peerType == 3000) {
            localateh.c((FileManagerEntity)localObject2, false);
          } else if ((((FileManagerEntity)localObject2).peerType != 1) && (((FileManagerEntity)localObject2).peerType != 6000)) {
            localateh.a((FileManagerEntity)localObject2, false);
          }
        }
      }
    }
    else
    {
      this.val$app.addObserver(new athv(this), true);
      localObject1 = (ateh)this.val$app.getBusinessHandler(180);
      ((ateh)localObject1).kO(0, 30);
      ((ateh)localObject1).kP(0, 30);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileUtils.1
 * JD-Core Version:    0.7.0.1
 */