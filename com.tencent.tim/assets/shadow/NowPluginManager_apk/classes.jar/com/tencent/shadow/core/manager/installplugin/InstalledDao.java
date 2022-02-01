package com.tencent.shadow.core.manager.installplugin;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class InstalledDao
{
  private static final Logger mLogger = LoggerFactory.getLogger(InstalledDao.class);
  private InstalledPluginDBHelper mDBHelper;
  
  public InstalledDao(InstalledPluginDBHelper paramInstalledPluginDBHelper)
  {
    this.mDBHelper = paramInstalledPluginDBHelper;
  }
  
  private String[] getArrayStringByColumnName(String paramString, Cursor paramCursor)
  {
    int j = 0;
    int k = paramCursor.getColumnIndex(paramString);
    int i;
    if (!paramCursor.isNull(k)) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = paramCursor.getString(k);
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        paramCursor = new String[localJSONArray.length()];
        i = j;
        for (;;)
        {
          paramString = paramCursor;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramCursor[i] = localJSONArray.getString(i);
          i += 1;
        }
        i = 0;
      }
      catch (JSONException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    paramString = null;
    return paramString;
  }
  
  private Pair<InstalledPlugin, List<ContentValues>> parseConfig(PluginConfig paramPluginConfig)
  {
    Object localObject1 = new ArrayList();
    InstalledPlugin localInstalledPlugin = new InstalledPlugin();
    if (paramPluginConfig.pluginLoader != null)
    {
      localInstalledPlugin.pluginLoaderFile = new InstalledPlugin.Part(3, paramPluginConfig.pluginLoader.file, null, null);
      ((List)localObject1).add(new InstalledRow(paramPluginConfig.pluginLoader.hash, null, paramPluginConfig.pluginLoader.file.getAbsolutePath(), 3));
    }
    if (paramPluginConfig.runTime != null)
    {
      localInstalledPlugin.runtimeFile = new InstalledPlugin.Part(4, paramPluginConfig.runTime.file, null, null);
      ((List)localObject1).add(new InstalledRow(paramPluginConfig.runTime.hash, null, paramPluginConfig.runTime.file.getAbsolutePath(), 4));
    }
    Object localObject3;
    if (paramPluginConfig.plugins != null)
    {
      localObject3 = paramPluginConfig.plugins.entrySet();
      localObject2 = new HashMap();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        PluginConfig.PluginFileInfo localPluginFileInfo = (PluginConfig.PluginFileInfo)localEntry.getValue();
        ((Map)localObject2).put(localEntry.getKey(), new InstalledPlugin.PluginPart(1, localPluginFileInfo.businessName, localPluginFileInfo.file, null, null, localPluginFileInfo.dependsOn, localPluginFileInfo.hostWhiteList));
        ((List)localObject1).add(new InstalledRow(localPluginFileInfo.hash, localPluginFileInfo.businessName, (String)localEntry.getKey(), localPluginFileInfo.dependsOn, localPluginFileInfo.file.getAbsolutePath(), 1, localPluginFileInfo.hostWhiteList));
      }
      localInstalledPlugin.plugins = ((Map)localObject2);
    }
    Object localObject2 = new InstalledRow();
    ((InstalledRow)localObject2).type = 5;
    ((InstalledRow)localObject2).filePath = paramPluginConfig.UUID;
    ((List)localObject1).add(localObject2);
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (InstalledRow)((Iterator)localObject1).next();
      ((InstalledRow)localObject3).installedTime = paramPluginConfig.storageDir.lastModified();
      ((InstalledRow)localObject3).UUID = paramPluginConfig.UUID;
      ((InstalledRow)localObject3).version = paramPluginConfig.UUID_NickName;
      ((List)localObject2).add(((InstalledRow)localObject3).toContentValues());
    }
    localInstalledPlugin.UUID = paramPluginConfig.UUID;
    localInstalledPlugin.UUID_NickName = paramPluginConfig.UUID_NickName;
    return new Pair(localInstalledPlugin, localObject2);
  }
  
  public int deleteByUUID(String paramString)
  {
    mLogger.info("deleteByUUID {}", paramString);
    SQLiteDatabase localSQLiteDatabase = this.mDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int i = localSQLiteDatabase.delete("shadowPluginManager", "uuid =?", new String[] { paramString });
      localSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public InstalledPlugin getInstalledPluginByUUID(String paramString)
  {
    Cursor localCursor = this.mDBHelper.getReadableDatabase().rawQuery("select * from shadowPluginManager where uuid = ?", new String[] { paramString });
    InstalledPlugin localInstalledPlugin = new InstalledPlugin();
    localInstalledPlugin.UUID = paramString;
    label146:
    Object localObject1;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndex("type"));
      if (i == 5)
      {
        localInstalledPlugin.UUID_NickName = localCursor.getString(localCursor.getColumnIndex("version"));
      }
      else
      {
        File localFile = new File(localCursor.getString(localCursor.getColumnIndex("filePath")));
        paramString = localCursor.getString(localCursor.getColumnIndex("odexPath"));
        if (paramString == null)
        {
          paramString = null;
          localObject1 = localCursor.getString(localCursor.getColumnIndex("libPath"));
          if (localObject1 != null) {
            break label207;
          }
        }
        label207:
        for (localObject1 = null;; localObject1 = new File((String)localObject1))
        {
          if (i != 3) {
            break label219;
          }
          localInstalledPlugin.pluginLoaderFile = new InstalledPlugin.Part(i, localFile, paramString, (File)localObject1);
          break;
          paramString = new File(paramString);
          break label146;
        }
        label219:
        if (i == 4)
        {
          localInstalledPlugin.runtimeFile = new InstalledPlugin.Part(i, localFile, paramString, (File)localObject1);
        }
        else
        {
          Object localObject2 = null;
          try
          {
            localObject3 = localCursor.getString(localCursor.getColumnIndex("businessName"));
            localObject2 = localObject3;
          }
          catch (IllegalStateException localIllegalStateException1)
          {
            for (;;)
            {
              Object localObject3;
              String str;
              mLogger.error(localIllegalStateException1.getMessage());
            }
          }
          str = localCursor.getString(localCursor.getColumnIndex("partKey"));
          if ((i == 1) || (i == 2))
          {
            localObject3 = new String[0];
            try
            {
              localObject4 = getArrayStringByColumnName("dependsOn", localCursor);
              localObject3 = localObject4;
            }
            catch (IllegalStateException localIllegalStateException2)
            {
              for (;;)
              {
                Object localObject4;
                mLogger.error(localIllegalStateException2.getMessage());
              }
            }
            localObject4 = new String[0];
            try
            {
              String[] arrayOfString = getArrayStringByColumnName("hostWhiteList", localCursor);
              localObject4 = arrayOfString;
            }
            catch (IllegalStateException localIllegalStateException3)
            {
              for (;;)
              {
                mLogger.error(localIllegalStateException3.getMessage());
              }
            }
            localInstalledPlugin.plugins.put(str, new InstalledPlugin.PluginPart(i, localObject2, localFile, paramString, (File)localObject1, (String[])localObject3, (String[])localObject4));
            continue;
          }
          throw new RuntimeException("出现不认识的type==" + i);
        }
      }
    }
    localCursor.close();
    mLogger.info(localInstalledPlugin.UUID);
    mLogger.info(localInstalledPlugin.UUID_NickName);
    if (localInstalledPlugin.pluginLoaderFile != null) {
      if (localInstalledPlugin.pluginLoaderFile.pluginFile != null)
      {
        mLogger.info("installedPlugin.pluginLoaderFile.pluginFile = " + localInstalledPlugin.pluginLoaderFile.pluginFile.toString());
        if (localInstalledPlugin.runtimeFile == null) {
          break label782;
        }
        if (localInstalledPlugin.runtimeFile.pluginFile == null) {
          break label768;
        }
        mLogger.info("installedPlugin.runtimeFile.pluginFile = " + localInstalledPlugin.runtimeFile.pluginFile.toString());
      }
    }
    for (;;)
    {
      mLogger.info(localInstalledPlugin.runtimeFile.pluginFile.toString());
      if (localInstalledPlugin.plugins == null) {
        break label796;
      }
      mLogger.info("installedPlugin.plugins size = " + localInstalledPlugin.plugins.size());
      paramString = localInstalledPlugin.plugins.values().iterator();
      while (paramString.hasNext())
      {
        localObject1 = (InstalledPlugin.PluginPart)paramString.next();
        mLogger.info("pluginPart.pluginFile = " + ((InstalledPlugin.PluginPart)localObject1).pluginFile.toString());
      }
      mLogger.info("installedPlugin.pluginLoaderFile.pluginFile == null");
      break;
      mLogger.info("installedPlugin.pluginLoaderFile == null");
      break;
      label768:
      mLogger.info("installedPlugin.runtimeFile.pluginFile == null");
      continue;
      label782:
      mLogger.info("installedPlugin.runtimeFile == null");
    }
    label796:
    mLogger.info("installedPlugin.plugins == null");
    mLogger.info("installedPlugin hashCode {}", Integer.valueOf(localInstalledPlugin.hashCode()));
    return localInstalledPlugin;
  }
  
  public List<InstalledPlugin> getLastPlugins(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.mDBHelper.getReadableDatabase();
    Object localObject2 = localSQLiteDatabase.rawQuery("select uuid from shadowPluginManager where  type = ?   order by installedTime desc limit " + paramInt, new String[] { String.valueOf(5) });
    Object localObject1 = new ArrayList();
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("uuid")));
    }
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).add(getInstalledPluginByUUID((String)((Iterator)localObject1).next()));
    }
    localSQLiteDatabase.close();
    return localObject2;
  }
  
  public InstalledPlugin insert(PluginConfig paramPluginConfig)
  {
    mLogger.info("insert, uuid {}, runtime {}, loader {}, storageDir {}, plugins {}" + paramPluginConfig.UUID, new Object[] { paramPluginConfig.runTime, paramPluginConfig.pluginLoader, paramPluginConfig.storageDir, paramPluginConfig.plugins });
    SQLiteDatabase localSQLiteDatabase = this.mDBHelper.getWritableDatabase();
    Pair localPair = parseConfig(paramPluginConfig);
    Object localObject = (List)localPair.second;
    localSQLiteDatabase.beginTransaction();
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localSQLiteDatabase.replace("shadowPluginManager", null, (ContentValues)((Iterator)localObject).next());
      }
      localObject = new ContentValues();
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    ((ContentValues)localObject).put("installedTime", Long.valueOf(paramPluginConfig.storageDir.lastModified()));
    localSQLiteDatabase.update("shadowPluginManager", (ContentValues)localObject, "uuid = ?", new String[] { paramPluginConfig.UUID });
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
    return (InstalledPlugin)localPair.first;
  }
  
  public boolean updatePlugin(String paramString, int paramInt, ContentValues paramContentValues)
  {
    mLogger.info("updatePlugin UUID = %s, type = %d, contentValues = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramContentValues.toString() });
    if ((paramInt != 3) && (paramInt != 4)) {
      throw new RuntimeException("不支持更新 type:" + paramInt);
    }
    SQLiteDatabase localSQLiteDatabase = this.mDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramInt = localSQLiteDatabase.update("shadowPluginManager", paramContentValues, "uuid = ? and type = ?", new String[] { paramString, String.valueOf(paramInt) });
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      if (paramInt > 0) {
        return true;
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    return false;
  }
  
  public boolean updatePlugin(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    mLogger.info("updatePlugin UUID = %s, parrKey = %s, contentValues = %s", new Object[] { paramString1, paramString2, paramContentValues.toString() });
    SQLiteDatabase localSQLiteDatabase = this.mDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int i = localSQLiteDatabase.update("shadowPluginManager", paramContentValues, "uuid = ? and partKey = ?", new String[] { paramString1, paramString2 });
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      if (i > 0) {
        return true;
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.InstalledDao
 * JD-Core Version:    0.7.0.1
 */