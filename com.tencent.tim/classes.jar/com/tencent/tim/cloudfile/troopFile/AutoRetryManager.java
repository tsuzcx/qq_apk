package com.tencent.tim.cloudfile.troopFile;

import android.os.Handler;
import atmt;
import atmt.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutoRetryManager
  implements atmt.a, Runnable
{
  private final String TAG = "AutoRetryManager.TroopAutoSaveToCloud";
  private atmt a;
  private String cHu = "50";
  private EntityManager em;
  private QQAppInterface mApp;
  private Handler mHandler;
  private List<TroopFileCopyInfoEntity> yc = new ArrayList();
  
  public AutoRetryManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.em = this.mApp.a().createEntityManager();
    this.a = new atmt(this.mApp, this);
  }
  
  private void a(TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new AutoRetryManager.2(this, paramTroopFileCopyInfoEntity, paramBoolean));
  }
  
  public void a(boolean paramBoolean, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity)
  {
    a(paramTroopFileCopyInfoEntity, paramBoolean);
    euf();
  }
  
  public void euf()
  {
    this.mHandler.postDelayed(this, 3000L);
  }
  
  public void nO(List<TroopFileCopyInfoEntity> paramList)
  {
    this.mHandler.post(new AutoRetryManager.1(this, paramList));
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacks(this);
  }
  
  public void run()
  {
    if (this.yc.size() > 0)
    {
      localObject = (TroopFileCopyInfoEntity)this.yc.remove(0);
      this.a.a((TroopFileCopyInfoEntity)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AutoRetryManager.TroopAutoSaveToCloud", 1, "cache is null or size is 0， retry DB faild records");
    }
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = this.em;
    String str = this.cHu;
    localObject = ((EntityManager)localObject).query(TroopFileCopyInfoEntity.class, false, "mStatus=? and lastRetryTime < ? and insertTime < ", new String[] { "0", String.valueOf(l - 21600L), String.valueOf(l - 604800L) }, null, null, null, str);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AutoRetryManager.TroopAutoSaveToCloud", 1, "query over none faild record");
      }
      this.em.close();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("AutoRetryManager.TroopAutoSaveToCloud", 1, "query over find " + ((List)localObject).size() + " records");
    }
    this.yc.addAll((Collection)localObject);
    run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoRetryManager
 * JD-Core Version:    0.7.0.1
 */