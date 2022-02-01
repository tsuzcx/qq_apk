package com.tencent.qqmail.folderlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.FolderDataCache;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper.UnsupportedGetDatabase;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Splitter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FolderDataSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final String TAG = "FolderDataSQLite";
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_FOLDERDATA(id integer primary key, folderId integer, accountId integer, name varchar, section integer, sequence integer, type integer, shouldShow integer, persistence integer, processing integer )";
  private static final String sqlCreateForUpgrade = "CREATE TABLE IF NOT EXISTS QM_FOLDERDATA(id integer primary key, folderId integer, accountId integer, name varchar, section integer, sequence integer, type integer, shouldShow integer, persistence integer, processing integer )";
  private static final String sqlDelete = "DELETE FROM QM_FOLDERDATA";
  private static final String sqlDeleteAccountInbox = "DELETE FROM QM_FOLDERDATA WHERE type=3 AND accountId=?";
  private static final String sqlDeleteById = "DELETE FROM QM_FOLDERDATA WHERE id=?";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_FOLDERDATA";
  private static final String sqlInsert = "REPLACE INTO QM_FOLDERDATA (id , folderId , accountId , name , section , sequence , type , shouldShow , persistence , processing ) VALUES (?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQuery = "SELECT * FROM QM_FOLDERDATA ORDER BY section";
  private FolderDataCache memoryStore = new FolderDataCache();
  
  public FolderDataSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private ArrayList<FolderData> parseFromDefaultFolder()
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0);
    Object localObject1 = localSharedPreferences.getString("default_folder_key2", "");
    Object localObject3 = Lists.newArrayList(Splitter.on("\n").trimResults().omitEmptyStrings().split((String)localObject1));
    localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    int i;
    Object localObject4;
    int j;
    Object localObject5;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      i = 0;
      if (i < ((List)localObject3).size())
      {
        localObject4 = ((String)((List)localObject3).get(i)).split(",", -1);
        int k;
        if (localObject4.length == 2)
        {
          j = Integer.parseInt(localObject4[0]);
          k = Integer.parseInt(localObject4[1]);
          if (j == 3) {
            ((ArrayList)localObject1).add(FolderDataManager.generateAccountFolderData(k));
          }
        }
        label302:
        for (;;)
        {
          i += 1;
          break;
          if ((localObject4.length == 7) || (localObject4.length == 8))
          {
            k = Integer.parseInt(localObject4[0]);
            int m = Integer.parseInt(localObject4[1]);
            int n = Integer.parseInt(localObject4[2]);
            boolean bool1 = "1".equals(localObject4[3]);
            boolean bool2 = "1".equals(localObject4[4]);
            localObject5 = localObject4[5];
            boolean bool3 = "1".equals(localObject4[6]);
            if (localObject4.length == 7) {}
            for (j = 0;; j = Integer.parseInt(localObject4[7]))
            {
              if ((k != 0) && (k != 3)) {
                break label302;
              }
              ((ArrayList)localObject1).add(FolderDataManager.generateFolderData(m, n, (String)localObject5, k, i, j, bool1, bool2, bool3));
              break;
            }
          }
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject3 = new ArrayList();
      localObject4 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FolderData)((Iterator)localObject4).next();
        i = ((FolderData)localObject5).getAccountId();
        j = ((FolderData)localObject5).getFolderId();
        if ((i != -1) && (((FolderData)localObject5).getName().contains(QMApplicationContext.sharedInstance().getString(2131694793))))
        {
          ((ArrayList)localObject3).add(localObject5);
          ((FolderData)localObject5).setType(3);
        }
        if ((j == -4) || (j == -5) || (j == -16) || (j == -18) || (((FolderData)localObject5).getType() == 1))
        {
          ((FolderData)localObject5).setSection(2);
          ((FolderData)localObject5).setShouldShow(true);
          ((ArrayList)localObject2).add(localObject5);
        }
        else
        {
          ((FolderData)localObject5).setSection(0);
          if (j == -2) {
            ((FolderData)localObject5).setShouldShow(true);
          }
          localArrayList.add(localObject5);
        }
      }
      if (((ArrayList)localObject3).size() == 1)
      {
        localObject2 = (FolderData)((ArrayList)localObject3).get(0);
        localObject3 = parseFromInboxFolder();
        if (localObject3 != null)
        {
          ((FolderData)localObject3).setAccountId(((FolderData)localObject2).getAccountId());
          ((FolderData)localObject3).setFolderId(((FolderData)localObject2).getFolderId());
          localArrayList.remove(localObject2);
          localArrayList.add(((FolderData)localObject3).getSequence(), localObject3);
        }
      }
      FolderDataManager.setSeqByFolderDataListOrder(localArrayList);
    }
    ((ArrayList)localObject1).clear();
    ((ArrayList)localObject1).addAll(localArrayList);
    localSharedPreferences.edit().clear().commit();
    return localObject1;
  }
  
  private FolderData parseFromInboxFolder()
  {
    Object localObject = QMApplicationContext.sharedInstance().getSharedPreferences("accounts_info", 0).getString("inbox_folder_key2", "");
    localObject = Lists.newArrayList(Splitter.on("\n").trimResults().omitEmptyStrings().split((String)localObject));
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = (String)((List)localObject).get(0);
    if (StringExtention.isNullOrEmpty((String)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split(",", -1);
    int i;
    boolean bool;
    if (localObject.length >= 4)
    {
      i = Integer.parseInt(localObject[0]);
      "1".equals(localObject[1]);
      bool = "1".equals(localObject[2]);
      "1".equals(localObject[3]);
    }
    for (;;)
    {
      return FolderDataManager.generateFolderData(-1, 0, QMApplicationContext.sharedInstance().getString(2131693913), 0, 2, i, bool, true, false);
      bool = true;
      i = 0;
    }
  }
  
  private ArrayList<FolderData> queryFolderData(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject = null;
    localSQLiteDatabase = null;
    localArrayList = new ArrayList();
    Arrays.fill(new int[40], -2147483648);
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_FOLDERDATA ORDER BY section", null);
      if (paramSQLiteDatabase != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        int j = paramSQLiteDatabase.getCount();
        int i = 0;
        if (i < j)
        {
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          paramSQLiteDatabase.moveToPosition(i);
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          FolderData localFolderData = new FolderData();
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setFolderId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("folderId")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setAccountId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("accountId")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("name")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setSection(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("section")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setSequence(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("sequence")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          localFolderData.setType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("type")));
          localSQLiteDatabase = paramSQLiteDatabase;
          localObject = paramSQLiteDatabase;
          if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("shouldShow")) == 1)
          {
            bool = true;
            label295:
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localFolderData.setShouldShow(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("persistence")) != 1) {
              break label417;
            }
            bool = true;
            label336:
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localFolderData.setPersistence(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("processing")) != 1) {
              break label423;
            }
          }
          label417:
          label423:
          for (boolean bool = true;; bool = false)
          {
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localFolderData.setProcessing(bool);
            localSQLiteDatabase = paramSQLiteDatabase;
            localObject = paramSQLiteDatabase;
            localArrayList.add(localFolderData);
            i += 1;
            break;
            bool = false;
            break label295;
            bool = false;
            break label336;
          }
        }
      }
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.close();
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        QMLog.log(6, "FolderDataSQLite", paramSQLiteDatabase.getMessage());
      } while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label486;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_FOLDERDATA(id integer primary key, folderId integer, accountId integer, name varchar, section integer, sequence integer, type integer, shouldShow integer, persistence integer, processing integer )");
    QMLog.log(4, "FolderDataSQLite", "create table");
  }
  
  public void deleteAccountInbox(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.memoryStore.delete(new FolderDataSQLite.2(this, paramInt), new FolderDataSQLite.3(this, paramInt, paramSQLiteDatabase));
  }
  
  public void deleteAllFolderData(SQLiteDatabase paramSQLiteDatabase)
  {
    this.memoryStore.clear();
    paramSQLiteDatabase.execSQL("DELETE FROM QM_FOLDERDATA");
  }
  
  public void deleteFolderData(SQLiteDatabase paramSQLiteDatabase, FolderData paramFolderData)
  {
    if (paramFolderData != null) {
      this.memoryStore.delete(new FolderDataSQLite.4(this, paramFolderData), new FolderDataSQLite.5(this, paramFolderData, paramSQLiteDatabase));
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_FOLDERDATA");
    QMLog.log(4, "FolderDataSQLite", "drop table");
  }
  
  public void initCache(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = queryFolderData(paramSQLiteDatabase).iterator();
    while (paramSQLiteDatabase.hasNext())
    {
      FolderData localFolderData = (FolderData)paramSQLiteDatabase.next();
      this.memoryStore.insert(Integer.valueOf(localFolderData.getId()), localFolderData);
    }
    QMLog.log(3, "FolderDataSQLite", "init cache size:" + this.memoryStore.size());
  }
  
  public void insertFolderData(SQLiteDatabase paramSQLiteDatabase, FolderData paramFolderData)
  {
    if (paramFolderData != null) {
      this.memoryStore.insert(Integer.valueOf(paramFolderData.getId()), paramFolderData, new FolderDataSQLite.1(this, paramFolderData, paramSQLiteDatabase));
    }
  }
  
  /* Error */
  public void insertFolderData(SQLiteDatabase paramSQLiteDatabase, ArrayList<FolderData> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +134 -> 135
    //   4: aload_2
    //   5: invokevirtual 140	java/util/ArrayList:size	()I
    //   8: ifle +127 -> 135
    //   11: new 383	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_1
    //   20: invokevirtual 408	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   23: aload_2
    //   24: invokevirtual 144	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore_2
    //   28: aload_2
    //   29: invokeinterface 150 1 0
    //   34: ifeq +102 -> 136
    //   37: aload_2
    //   38: invokeinterface 154 1 0
    //   43: checkcast 156	com/tencent/qqmail/folderlist/model/FolderData
    //   46: astore 4
    //   48: aload_0
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 410	com/tencent/qqmail/folderlist/FolderDataSQLite:insertFolderData	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/folderlist/model/FolderData;)V
    //   55: aload 4
    //   57: ifnull -29 -> 28
    //   60: aload_3
    //   61: aload 4
    //   63: invokevirtual 166	com/tencent/qqmail/folderlist/model/FolderData:getName	()Ljava/lang/String;
    //   66: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 412
    //   72: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 4
    //   77: invokevirtual 415	com/tencent/qqmail/folderlist/model/FolderData:isShouldShow	()Z
    //   80: invokevirtual 418	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: ldc_w 420
    //   86: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: goto -62 -> 28
    //   93: astore_2
    //   94: bipush 6
    //   96: ldc 8
    //   98: aload_2
    //   99: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokestatic 324	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   105: aload_1
    //   106: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   109: iconst_4
    //   110: ldc 8
    //   112: new 383	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 425
    //   122: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_3
    //   126: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 324	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   135: return
    //   136: aload_1
    //   137: invokevirtual 431	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   140: aload_1
    //   141: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   144: goto -35 -> 109
    //   147: astore_2
    //   148: aload_1
    //   149: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	FolderDataSQLite
    //   0	154	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	154	2	paramArrayList	ArrayList<FolderData>
    //   18	108	3	localStringBuilder	java.lang.StringBuilder
    //   46	30	4	localFolderData	FolderData
    // Exception table:
    //   from	to	target	type
    //   19	28	93	java/lang/Exception
    //   28	55	93	java/lang/Exception
    //   60	90	93	java/lang/Exception
    //   136	140	93	java/lang/Exception
    //   19	28	147	finally
    //   28	55	147	finally
    //   60	90	147	finally
    //   94	105	147	finally
    //   136	140	147	finally
  }
  
  public void parseFromXML(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = parseFromDefaultFolder();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      insertFolderData(paramSQLiteDatabase, localArrayList);
    }
  }
  
  public ArrayList<FolderData> queryActiveFolderData()
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new FolderDataSQLite.9(this, localArrayList));
    return localArrayList;
  }
  
  public Set<Integer> queryActiveFolderIdsByAccountId(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    this.memoryStore.select(new FolderDataSQLite.10(this, paramInt, localHashSet));
    return localHashSet;
  }
  
  public FolderData queryFolderDataByFolderId(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new FolderDataSQLite.8(this, paramInt, localArrayList));
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (FolderData)localArrayList.get(0);
    }
    return null;
  }
  
  public FolderData queryFolderDataById(int paramInt)
  {
    return (FolderData)this.memoryStore.get(Integer.valueOf(paramInt));
  }
  
  public ArrayList<FolderData> queryFolderDataBySection(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new FolderDataSQLite.7(this, paramInt, localArrayList));
    return localArrayList;
  }
  
  public ArrayList<FolderData> queryFolderDataList()
  {
    ArrayList localArrayList = new ArrayList();
    this.memoryStore.select(new FolderDataSQLite.6(this, localArrayList));
    return localArrayList;
  }
  
  public void updateActiveFolderDataProcessing(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    this.memoryStore.updateByKey(Integer.valueOf(paramInt), new FolderDataSQLite.11(this, paramBoolean), new FolderDataSQLite.12(this, paramBoolean, paramSQLiteDatabase, paramInt));
  }
  
  /* Error */
  public void updateAppFolderDataSecAndSeq(SQLiteDatabase paramSQLiteDatabase, ArrayList<FolderData> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +90 -> 91
    //   4: aload_2
    //   5: invokevirtual 140	java/util/ArrayList:size	()I
    //   8: ifle +83 -> 91
    //   11: aload_1
    //   12: invokevirtual 408	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   15: aload_2
    //   16: invokevirtual 144	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 150 1 0
    //   26: ifeq +66 -> 92
    //   29: aload_2
    //   30: invokeinterface 154 1 0
    //   35: checkcast 156	com/tencent/qqmail/folderlist/model/FolderData
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 44	com/tencent/qqmail/folderlist/FolderDataSQLite:memoryStore	Lcom/tencent/qqmail/model/cache/FolderDataCache;
    //   43: aload_3
    //   44: invokevirtual 373	com/tencent/qqmail/folderlist/model/FolderData:getId	()I
    //   47: invokestatic 377	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: new 497	com/tencent/qqmail/folderlist/FolderDataSQLite$13
    //   53: dup
    //   54: aload_0
    //   55: aload_3
    //   56: invokespecial 498	com/tencent/qqmail/folderlist/FolderDataSQLite$13:<init>	(Lcom/tencent/qqmail/folderlist/FolderDataSQLite;Lcom/tencent/qqmail/folderlist/model/FolderData;)V
    //   59: new 500	com/tencent/qqmail/folderlist/FolderDataSQLite$14
    //   62: dup
    //   63: aload_0
    //   64: aload_3
    //   65: aload_1
    //   66: invokespecial 501	com/tencent/qqmail/folderlist/FolderDataSQLite$14:<init>	(Lcom/tencent/qqmail/folderlist/FolderDataSQLite;Lcom/tencent/qqmail/folderlist/model/FolderData;Lcom/tencent/moai/database/sqlite/SQLiteDatabase;)V
    //   69: invokevirtual 494	com/tencent/qqmail/model/cache/FolderDataCache:updateByKey	(Ljava/lang/Object;Lcom/tencent/qqmail/model/cache/IReducer;Ljava/lang/Runnable;)V
    //   72: goto -52 -> 20
    //   75: astore_2
    //   76: bipush 6
    //   78: ldc 8
    //   80: aload_2
    //   81: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokestatic 324	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   91: return
    //   92: aload_1
    //   93: invokevirtual 431	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   96: aload_1
    //   97: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   100: return
    //   101: astore_2
    //   102: aload_1
    //   103: invokevirtual 423	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   106: aload_2
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	FolderDataSQLite
    //   0	108	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	108	2	paramArrayList	ArrayList<FolderData>
    //   38	27	3	localFolderData	FolderData
    // Exception table:
    //   from	to	target	type
    //   11	20	75	java/lang/Exception
    //   20	72	75	java/lang/Exception
    //   92	96	75	java/lang/Exception
    //   11	20	101	finally
    //   20	72	101	finally
    //   76	87	101	finally
    //   92	96	101	finally
  }
  
  public void upgradeTableFor5000(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_FOLDERDATA(id integer primary key, folderId integer, accountId integer, name varchar, section integer, sequence integer, type integer, shouldShow integer, persistence integer, processing integer )");
    parseFromXML(paramSQLiteDatabase);
  }
  
  public void upgradeTableFor5013(SQLiteDatabase paramSQLiteDatabase)
  {
    QMLog.log(4, "FolderDataSQLite", "upgradeTableFor5013");
    paramSQLiteDatabase.execSQL("UPDATE QM_FOLDERDATA SET shouldShow=1 WHERE name LIKE '%收件箱'");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite
 * JD-Core Version:    0.7.0.1
 */