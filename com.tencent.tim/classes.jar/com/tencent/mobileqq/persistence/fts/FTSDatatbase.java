package com.tencent.mobileqq.persistence.fts;

import akwf;
import android.os.Build.VERSION;
import android.text.TextUtils;
import aqoe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class FTSDatatbase
{
  private String bUt;
  private String bUu;
  private boolean isClear;
  private boolean isInit;
  private QQAppInterface mApp;
  private boolean mEnable;
  private String mUin;
  
  public FTSDatatbase(QQAppInterface paramQQAppInterface)
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      acxu.ENABLE = false;
    }
    for (int i = 0;; i = 1)
    {
      boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabase");
      if (!bool) {
        acxu.ENABLE = false;
      }
      if ((i != 0) && (bool)) {}
      for (this.mEnable = true;; this.mEnable = false)
      {
        this.mApp = paramQQAppInterface;
        this.mUin = paramQQAppInterface.getCurrentAccountUin();
        this.bUt = this.mUin;
        this.bUu = (this.mApp.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.bUt + "-IndexQQMsg.db");
        return;
      }
    }
  }
  
  private synchronized native int batchTrans(ArrayList<FTSEntity> paramArrayList, String paramString, int paramInt);
  
  private synchronized native int closeFTS();
  
  private synchronized native int createCursor(String paramString);
  
  private synchronized native int createIndexTable(String paramString, int paramInt);
  
  private synchronized native int deleteIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int initFTS(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  private synchronized native int insertIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int isTableExist(String paramString);
  
  private synchronized native ArrayList<String> queryCustomized(String paramString);
  
  private synchronized native int queryIndexCount(String paramString);
  
  private synchronized native ArrayList<FTSEntity> queryIndexTable(String paramString1, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3);
  
  private synchronized native int readCursor(String paramString);
  
  private synchronized native int updateIndexTable(FTSEntity paramFTSEntity);
  
  public boolean G(String paramString, boolean paramBoolean)
  {
    if (!this.isInit) {}
    for (;;)
    {
      return false;
      int i;
      if (paramBoolean) {
        i = 1;
      }
      try
      {
        for (;;)
        {
          i = createIndexTable(paramString, i);
          if (i == 0) {
            break label64;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.fts.db", 2, "createIndexTable: failure");
          return false;
          i = 0;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.e("Q.fts.db", 2, paramString, new Object[0]);
          i = -1;
        }
      }
    }
    label64:
    return true;
  }
  
  public int a(ArrayList<FTSEntity> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.isInit) {}
    long l;
    do
    {
      return -1;
      l = System.currentTimeMillis();
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.fts.db", 2, "transToDatabase: entities == null");
    return -1;
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FTSEntity localFTSEntity = (FTSEntity)((Iterator)localObject).next();
      if (localFTSEntity.mOpt == 16) {
        localFTSEntity.mContent = localFTSEntity.createDeleteSQL();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.db", 1, "msg transToDatabase create cost:" + (System.currentTimeMillis() - l));
    }
    if (paramInt1 == 2)
    {
      localObject = "DeleteCursor";
      if (paramInt1 != 2) {
        break label215;
      }
    }
    for (;;)
    {
      paramInt1 = batchTrans(paramArrayList, (String)localObject, paramInt2);
      if ((paramInt1 == -1) && (QLog.isColorLevel())) {
        QLog.w("Q.fts.db", 2, "transToDatabase: failure");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.db", 1, "msg transToDatabase batchTrans cost:" + (System.currentTimeMillis() - l));
      }
      return paramInt1;
      localObject = "SyncCursor";
      break;
      label215:
      paramInt2 = -1;
    }
  }
  
  public ArrayList<FTSEntity> a(akwf paramakwf)
  {
    long l1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramakwf.sql))
        {
          if (!QLog.isColorLevel()) {
            break label335;
          }
          QLog.e("Q.fts.db", 2, "query: sql is null");
          break label335;
        }
        if (TextUtils.isEmpty(paramakwf.bUw))
        {
          if (!QLog.isColorLevel()) {
            break label337;
          }
          QLog.e("Q.fts.db", 2, "query: classpath is null");
          break label337;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.db", 2, "query: sql = " + paramakwf.sql);
        }
        l1 = System.nanoTime();
        paramakwf = queryIndexTable(paramakwf.sql, paramakwf.gc, paramakwf.KW, paramakwf.or, paramakwf.type, paramakwf.dpr, paramakwf.bUv, paramakwf.bUw, paramakwf.dps);
        l2 = System.nanoTime();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("query: list = ");
          if (paramakwf == null)
          {
            i = 0;
            QLog.i("Q.fts.db", 2, i + ", cost = " + (l2 - l1) / 1000000L + "ms");
          }
        }
        else
        {
          if ((paramakwf == null) || (paramakwf.isEmpty())) {
            break label333;
          }
          l1 = System.nanoTime();
          localObject = paramakwf.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((FTSEntity)((Iterator)localObject).next()).postRead();
          continue;
        }
        int i = paramakwf.size();
      }
      catch (Exception paramakwf)
      {
        paramakwf.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.db", 2, "query: failure, ", paramakwf);
        }
        return null;
      }
    }
    long l2 = System.nanoTime();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.db", 2, "query: postRead cost = " + (l2 - l1) / 1000000L + "ms");
    }
    return paramakwf;
    label333:
    return null;
    label335:
    return null;
    label337:
    return null;
  }
  
  public int b(ArrayList<FTSEntity> paramArrayList, int paramInt)
  {
    if (!this.isInit) {}
    do
    {
      do
      {
        return -1;
        if (paramArrayList != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.fts.db", 2, "insertAddWithTransToDatabase: entities == null");
      return -1;
      if (batchTrans(paramArrayList, "UpgradeCursor", paramInt) > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.db", 2, "insertAddWithTransToDatabase: failure");
    return -1;
    return 0;
  }
  
  public void close()
  {
    if ((this.isClear) || (hasInit()))
    {
      this.isClear = false;
      this.isInit = false;
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native closeFTS V1");
      if ((closeFTS() != 0) && (QLog.isColorLevel())) {
        QLog.e("Q.fts.db", 2, "close: failure");
      }
    }
  }
  
  public void dDB()
  {
    close();
    File localFile = new File(this.bUu);
    if ((localFile.exists()) && (localFile.isFile())) {
      localFile.delete();
    }
  }
  
  public int dE(String paramString)
  {
    if (!this.isInit) {
      return -1;
    }
    try
    {
      int i = readCursor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.fts.db", 2, paramString, new Object[0]);
    }
    return -1;
  }
  
  public int dF(String paramString)
  {
    if (!hasInit()) {
      return -1;
    }
    return queryIndexCount(paramString);
  }
  
  public boolean hasInit()
  {
    return (this.isInit) && (this.mEnable);
  }
  
  public void init()
  {
    String str = QLog.class.getName().replace('.', '/');
    if (QLog.isColorLevel()) {}
    for (int i = 1;; i = 0)
    {
      int j = aqoe.ak(this.mApp);
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native initFTS V1");
      if (initFTS(this.bUt, str, i, j) == 0) {
        break;
      }
      this.isInit = false;
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "init: failure");
      }
      return;
    }
    this.isInit = true;
  }
  
  public boolean nO(String paramString)
  {
    if (!this.isInit) {}
    do
    {
      return false;
      if (createCursor(paramString) == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.db", 2, "creatAssistTable: failure");
    return false;
    return true;
  }
  
  public boolean nP(String paramString)
  {
    if (!this.isInit) {}
    while (isTableExist(paramString) != 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSDatatbase
 * JD-Core Version:    0.7.0.1
 */