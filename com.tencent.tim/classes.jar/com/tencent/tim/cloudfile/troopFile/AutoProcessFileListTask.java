package com.tencent.tim.cloudfile.troopFile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import apbr;
import apcp;
import apsf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutoProcessFileListTask
  implements apcp, Runnable
{
  private final String TAG = "AutoProcessFileListTask.TroopAutoSaveToCloud";
  private apsf jdField_a_of_type_Apsf;
  private a jdField_a_of_type_ComTencentTimCloudfileTroopFileAutoProcessFileListTask$a;
  private final String cHs = "key_auto_copy_";
  private QQAppInterface mApp;
  private long mTroopUin;
  
  public AutoProcessFileListTask(QQAppInterface paramQQAppInterface, long paramLong, a parama)
  {
    this.mTroopUin = paramLong;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentTimCloudfileTroopFileAutoProcessFileListTask$a = parama;
  }
  
  private void c(List<apbr> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder().append("onFilesFinish files[");
    if (paramList != null) {}
    for (paramString = paramList.size() + "";; paramString = "null")
    {
      QLog.w("AutoProcessFileListTask.TroopAutoSaveToCloud", 1, paramString + "], isEnd[" + paramBoolean + "]");
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentTimCloudfileTroopFileAutoProcessFileListTask$a.j(this.mTroopUin, null);
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    paramString = this.mApp.getPreferences();
    long l2 = paramString.getLong("key_auto_copy_" + this.mTroopUin, 0L);
    localObject = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      boolean bool = paramBoolean;
      apbr localapbr;
      if (paramList.hasNext())
      {
        localapbr = (apbr)paramList.next();
        if (l1 - localapbr.uint32_upload_time <= 604800L) {
          break label243;
        }
        bool = true;
      }
      label243:
      long l3;
      for (;;)
      {
        if (bool) {
          break label433;
        }
        if (this.jdField_a_of_type_Apsf.G("/", paramLong)) {
          break;
        }
        this.jdField_a_of_type_ComTencentTimCloudfileTroopFileAutoProcessFileListTask$a.j(this.mTroopUin, (List)localObject);
        return;
        l3 = localapbr.uint32_upload_time * 1000L;
        if (l3 > l2) {
          break label321;
        }
        paramBoolean = true;
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.i("AutoProcessFileListTask.TroopAutoSaveToCloud", 1, this.mTroopUin + ":" + localapbr.str_file_name + " is Processed! isEnd!");
          bool = paramBoolean;
        }
      }
      label321:
      TroopFileCopyInfoEntity localTroopFileCopyInfoEntity = new TroopFileCopyInfoEntity();
      localTroopFileCopyInfoEntity.srcBizId = localapbr.dTg;
      localTroopFileCopyInfoEntity.strFileName = localapbr.str_file_name;
      localTroopFileCopyInfoEntity.troopUin = this.mTroopUin;
      localTroopFileCopyInfoEntity.uploadTime = l3;
      localTroopFileCopyInfoEntity.uploadUin = localapbr.aqT;
      localTroopFileCopyInfoEntity.strFileID = localapbr.mFileId;
      localTroopFileCopyInfoEntity.mStatus = 0;
      localTroopFileCopyInfoEntity.nFileSize = localapbr.uint64_file_size;
      localTroopFileCopyInfoEntity.lastRetryTime = (l1 - 21600L);
      localTroopFileCopyInfoEntity.insertTime = l1;
      ((List)localObject).add(localTroopFileCopyInfoEntity);
    }
    label433:
    onDestory();
    if (QLog.isColorLevel()) {
      QLog.i("AutoProcessFileListTask.TroopAutoSaveToCloud", 1, "find " + ((List)localObject).size() + " records for server");
    }
    if (((List)localObject).size() > 0)
    {
      paramList = (TroopFileCopyInfoEntity)((List)localObject).get(0);
      paramString.edit().putLong("key_auto_copy_" + this.mTroopUin, paramList.uploadTime).commit();
    }
    this.jdField_a_of_type_ComTencentTimCloudfileTroopFileAutoProcessFileListTask$a.j(this.mTroopUin, (List)localObject);
  }
  
  public void WC(int paramInt) {}
  
  public void a(apbr paramapbr, String paramString) {}
  
  public void a(List<apbr> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new AutoProcessFileListTask.1(this, paramList, paramBoolean, paramString, paramLong));
      return;
    }
    c(paramList, paramBoolean, paramString, paramLong);
  }
  
  public void j(apbr paramapbr) {}
  
  public void k(apbr paramapbr) {}
  
  public void l(apbr paramapbr) {}
  
  public void m(apbr paramapbr) {}
  
  public void n(apbr paramapbr) {}
  
  public void onDestory()
  {
    if (this.jdField_a_of_type_Apsf.a(this)) {
      this.jdField_a_of_type_Apsf.unregisterObserver(this);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Apsf = apsf.a(this.mApp, this.mTroopUin);
    if (!this.jdField_a_of_type_Apsf.a(this)) {
      this.jdField_a_of_type_Apsf.registerObserver(this);
    }
    this.jdField_a_of_type_Apsf.d(0, "/", this.mApp.getLongAccountUin());
  }
  
  public static abstract interface a
  {
    public abstract void j(long paramLong, List<TroopFileCopyInfoEntity> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoProcessFileListTask
 * JD-Core Version:    0.7.0.1
 */