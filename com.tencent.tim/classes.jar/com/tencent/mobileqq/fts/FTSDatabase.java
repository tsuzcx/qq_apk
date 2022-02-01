package com.tencent.mobileqq.fts;

import ahpy;
import ahqd;
import ahqe;
import ahql;
import ahqm;
import ahqn;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.fts.entity.FTSEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FTSDatabase
{
  private static ahqd a = new ahqe();
  private boolean enable = true;
  private boolean initialized;
  
  public FTSDatabase()
  {
    if (!this.enable) {
      log("Q.fts.troop.FTSDatabase", "w", "load so failed.");
    }
  }
  
  public static ahqd a()
  {
    return a;
  }
  
  public static void a(ahqd paramahqd)
  {
    a = paramahqd;
  }
  
  private synchronized native void closeNative();
  
  private void dpq()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      throw new RuntimeException("Cannot operate database on UI Thread.");
    }
  }
  
  private synchronized native boolean execSQLNative(String paramString);
  
  private synchronized native String getErrorMsg();
  
  private synchronized native boolean initNative(String paramString, boolean paramBoolean);
  
  private synchronized native boolean insertNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public static void log(String paramString1, String paramString2, String paramString3)
  {
    a().log(paramString1, paramString2, paramString3);
  }
  
  private synchronized native int queryIndexCount(String paramString);
  
  private synchronized native Object queryNative(String paramString, int[] paramArrayOfInt);
  
  private synchronized native boolean updateNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public List<FTSEntity> a(ahpy paramahpy)
  {
    dpq();
    if (!isAvailable()) {
      log("Q.fts.troop.FTSDatabase", "w", "query failed. FTSDatabase is not available");
    }
    Object localObject3;
    for (;;)
    {
      return null;
      Object localObject1 = new ArrayList();
      localObject3 = ahqn.a(paramahpy, (List)localObject1);
      int[] arrayOfInt = new int[((List)localObject1).size()];
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        arrayOfInt[i] = ((Integer)((List)localObject1).get(i)).intValue();
        i += 1;
      }
      long l1 = System.currentTimeMillis();
      try
      {
        localObject1 = (List)queryNative((String)localObject3, arrayOfInt);
        long l2 = System.currentTimeMillis();
        log("Q.fts.troop.FTSDatabase", "d", "query cost time = " + (l2 - l1) + " ; sql = " + (String)localObject3);
        localObject3 = new ArrayList();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((List)localObject3).add(ahqn.a((Map)((Iterator)localObject1).next(), paramahpy.x));
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return localObject3;
  }
  
  @Deprecated
  public List<Map> a(String paramString, int[] paramArrayOfInt)
  {
    dpq();
    if (!isAvailable())
    {
      log("Q.fts.troop.FTSDatabase", "w", "querySQL failed. FTSDatabase is not available");
      return null;
    }
    try
    {
      paramString = (List)queryNative(paramString, paramArrayOfInt);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public boolean a(FTSEntity paramFTSEntity)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    dpq();
    if (!isAvailable()) {
      log("Q.fts.troop.FTSDatabase", "w", "insert failed. FTSDatabase is not available");
    }
    do
    {
      return bool2;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramFTSEntity = ahqn.a(paramFTSEntity, localArrayList2, localArrayList1);
      int[] arrayOfInt = new int[localArrayList2.size()];
      int i = 0;
      while (i < localArrayList2.size())
      {
        arrayOfInt[i] = ((Integer)localArrayList2.get(i)).intValue();
        i += 1;
      }
      try
      {
        bool2 = insertNative(paramFTSEntity, arrayOfInt, (byte[][])localArrayList1.toArray(new byte[localArrayList1.size()][]));
        bool1 = bool2;
      }
      catch (UnsatisfiedLinkError paramFTSEntity)
      {
        for (;;)
        {
          paramFTSEntity.printStackTrace();
        }
      }
      bool2 = bool1;
    } while (bool1);
    try
    {
      log("Q.fts.troop.FTSDatabase", "w", "insert failed. error msg = " + getErrorMsg());
      return bool1;
    }
    catch (UnsatisfiedLinkError paramFTSEntity)
    {
      paramFTSEntity.printStackTrace();
      return bool1;
    }
  }
  
  public boolean anS()
  {
    dpq();
    boolean bool1;
    if (!isAvailable())
    {
      log("Q.fts.troop.FTSDatabase", "w", "beginTransaction failed. FTSDatabase is not available");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool2 = execSQL("BEGIN;");
        bool1 = bool2;
      } while (bool2);
      log("Q.fts.troop.FTSDatabase", "e", "beginTransaction failed.");
      bool1 = bool2;
    } while (execSQL("ROLLBACK;"));
    log("Q.fts.troop.FTSDatabase", "e", "beginTransaction ROLLBACK failed.");
    return bool2;
  }
  
  public boolean anT()
  {
    dpq();
    boolean bool1;
    if (!isAvailable())
    {
      log("Q.fts.troop.FTSDatabase", "w", "commitTransaction failed. FTSDatabase is not available");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool2 = execSQL("COMMIT;");
        bool1 = bool2;
      } while (bool2);
      log("Q.fts.troop.FTSDatabase", "e", "commitTransaction failed.");
      bool1 = bool2;
    } while (execSQL("ROLLBACK;"));
    log("Q.fts.troop.FTSDatabase", "e", "commitTransaction ROLLBACK failed.");
    return bool2;
  }
  
  public void close()
  {
    if (isAvailable()) {
      this.initialized = false;
    }
    try
    {
      log("Q.fts.troop.FTSDatabase", "i", Thread.currentThread().getName() + " native closeNative V2");
      closeNative();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public boolean d(Class<? extends FTSEntity> paramClass)
  {
    dpq();
    if (!isAvailable())
    {
      log("Q.fts.troop.FTSDatabase", "w", "createTable failed. FTSDatabase is not available");
      return false;
    }
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = true;
    String str2;
    for (;;)
    {
      str2 = ahqn.a(paramClass, ahql.anU(), bool1, bool2, bool3);
      try
      {
        bool4 = execSQLNative(str2);
        if (!bool4) {
          localObject = "";
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          boolean bool4;
          String str1 = getErrorMsg();
          Object localObject = str1;
          log("Q.fts.troop.FTSDatabase", "e", "Can't create virtual table. " + (String)localObject);
          if (!ahql.anU())
          {
            log("Q.fts.troop.FTSDatabase", "e", "createTable failed." + (String)localObject);
            return false;
            localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
            localUnsatisfiedLinkError1.printStackTrace();
            bool4 = false;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;)
          {
            localUnsatisfiedLinkError2.printStackTrace();
          }
          if (TextUtils.isEmpty(localUnsatisfiedLinkError1))
          {
            log("Q.fts.troop.FTSDatabase", "e", "createTable failed. No error msg.");
            return false;
          }
          if ((localUnsatisfiedLinkError1.contains("unrecognized parameter: notindexed")) && (bool2))
          {
            bool2 = false;
          }
          else if ((localUnsatisfiedLinkError1.contains("unrecognized parameter: compress")) && (bool3))
          {
            bool3 = false;
          }
          else if ((localUnsatisfiedLinkError1.contains("near \"NOT\": syntax error")) && (bool1))
          {
            bool1 = false;
          }
          else
          {
            if (localUnsatisfiedLinkError1.contains("table " + paramClass.getSimpleName() + " already exists"))
            {
              log("Q.fts.troop.FTSDatabase", "d", "createTable succeed. " + str2);
              return true;
            }
            log("Q.fts.troop.FTSDatabase", "e", "createTable failed. " + localUnsatisfiedLinkError1);
            return false;
          }
        }
      }
    }
    log("Q.fts.troop.FTSDatabase", "d", "createTable succeed. " + str2);
    return true;
  }
  
  public boolean execSQL(String paramString)
  {
    dpq();
    if (!isAvailable())
    {
      log("Q.fts.troop.FTSDatabase", "w", "execSQL failed. FTSDatabase is not available");
      return false;
    }
    try
    {
      boolean bool = execSQLNative(paramString);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void init(String paramString)
  {
    dpq();
    if (this.initialized)
    {
      log("Q.fts.troop.FTSDatabase", "w", "already initialized.");
      return;
    }
    if (!this.enable)
    {
      this.initialized = true;
      log("Q.fts.troop.FTSDatabase", "w", "init failed because so is not available.");
      return;
    }
    ahqm.v(new File(paramString));
    try
    {
      log("Q.fts.troop.FTSDatabase", "i", Thread.currentThread().getName() + " native initNative V2");
      bool = initNative(paramString, true);
      if (!bool)
      {
        this.enable = false;
        this.initialized = true;
        log("Q.fts.troop.FTSDatabase", "w", "init failed because initNative failed.");
        return;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
      this.initialized = true;
      log("Q.fts.troop.FTSDatabase", "d", "initNative succeed.");
    }
  }
  
  public boolean isAvailable()
  {
    return (this.initialized) && (this.enable);
  }
  
  protected boolean loadSo()
  {
    try
    {
      System.loadLibrary("FTSDatabaseV2");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a().b("Q.fts.troop.FTSDatabase", "w", "load FTSDatabaseV2 failed.", localUnsatisfiedLinkError);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fts.FTSDatabase
 * JD-Core Version:    0.7.0.1
 */