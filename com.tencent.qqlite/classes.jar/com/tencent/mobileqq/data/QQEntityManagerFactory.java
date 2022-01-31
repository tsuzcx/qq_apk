package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;
import ddy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQEntityManagerFactory
  extends EntityManagerFactory
{
  static final int DB_VERSION = 99;
  private static final int FLAG_CHECK_AUTHENTICATION = -1;
  protected static boolean isUpdateFromLowV74 = false;
  public String TAG = "QQEntityManagerFactory";
  protected boolean bUpdated = false;
  protected SQLiteOpenHelper dbHelper;
  protected int dbVersion = 1;
  protected QQEntityManagerFactory.SQLiteOpenHelperImpl mInnerDbHelper;
  public String name;
  
  public QQEntityManagerFactory(String paramString)
  {
    super(paramString);
    this.name = paramString;
  }
  
  public static void checkColumnChange(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    String str1;
    Cursor localCursor2;
    if (localCursor1 != null) {
      do
      {
        if (!localCursor1.moveToNext()) {
          break;
        }
        str1 = SecurityUtile.a(localCursor1.getString(0));
        localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
      } while (localCursor2 == null);
    }
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        if (str1.equals("mr_fileManager"))
        {
          Object localObject1 = FileManagerEntity.class;
          Object localObject3 = TableBuilder.a((Class)localObject1);
          if (localCursor2.moveToFirst())
          {
            localObject1 = SecurityUtile.a(localCursor2.getString(0)).split(",");
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              Field localField = (Field)((Iterator)localObject3).next();
              i = 1;
              if (i >= localObject1.length) {
                break label428;
              }
              String str2 = localObject1[i].trim().split(" ")[0];
              if (!localField.getName().equals(str2)) {
                break label347;
              }
              i = 1;
              if (i != 0) {
                continue;
              }
              if (!localField.isAnnotationPresent(defaultzero.class)) {
                break label354;
              }
              bool = true;
              localArrayList.add(TableBuilder.a(str1, localField.getName(), (String)TableBuilder.a.get(localField.getType()), bool));
              continue;
            }
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localCursor2.close();
      }
      Object localObject2;
      if (str1.equals(DataLineMsgRecord.tableName()))
      {
        localObject2 = DataLineMsgRecord.class;
      }
      else if (str1.startsWith("mr_"))
      {
        localObject2 = MessageRecord.class;
      }
      else if (str1.equals("recent"))
      {
        localObject2 = RecentUser.class;
      }
      else
      {
        localObject2 = Class.forName(paramString + "." + str1);
        continue;
        label347:
        i += 1;
        continue;
        label354:
        bool = false;
        continue;
        localCursor1.close();
        com.tencent.mobileqq.app.SQLiteDatabase.f();
        paramSQLiteDatabase.beginTransaction();
        try
        {
          paramString = localArrayList.iterator();
          while (paramString.hasNext()) {
            paramSQLiteDatabase.execSQL((String)paramString.next());
          }
          paramSQLiteDatabase.setTransactionSuccessful();
        }
        finally
        {
          paramSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.g();
        }
        paramSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.g();
        return;
        label428:
        i = 0;
      }
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    int i = 99;
    if (this.dbHelper == null) {}
    try
    {
      Context localContext = BaseApplication.getContext();
      this.dbVersion = ((Integer)localContext.getPackageManager().getApplicationInfo(localContext.getPackageName(), 128).metaData.get("DBVersion")).intValue();
      if (this.dbVersion < 1) {
        this.dbVersion = 99;
      }
      label63:
      int j = this.dbVersion;
      if (VersionUtils.e())
      {
        paramString = paramString + ".db";
        if (j < 1) {}
        for (;;)
        {
          this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString, null, i, new ddy(this));
          this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
          return this.dbHelper;
          i = j;
        }
      }
      paramString = paramString + ".db";
      if (j < 1) {}
      for (;;)
      {
        this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString, null, i);
        break;
        i = j;
      }
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Groups()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Friends()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RecentUser()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new FriendMore()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DataLineMsgRecord()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonPackage()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Emoticon()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new EmoticonTab()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new RoamSetting()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopMemberInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopRemindSettingData()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ShieldListInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ContactCard()));
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = String.valueOf(AppConstants.Z);
    localMessageRecord.istroop = 1001;
    paramSQLiteDatabase.execSQL(TableBuilder.a(localMessageRecord));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new OpenTroopInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new Stranger()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new CommonlyUsedTroop()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
  }
  
  protected String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  public boolean isUpdateFromLowV74()
  {
    return isUpdateFromLowV74;
  }
  
  public boolean isUpdated()
  {
    return this.bUpdated;
  }
  
  public void resetUpdateFromLowV74()
  {
    isUpdateFromLowV74 = false;
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20) {
      this.mInnerDbHelper.dropAllTable();
    }
    do
    {
      return;
      if (paramInt1 < 70) {
        paramSQLiteDatabase.execSQL(TableBuilder.a(new ExtensionInfo()));
      }
      if (paramInt1 < 34)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a(DiscussionInfo.class.getSimpleName()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscussionInfo()));
      }
      checkColumnChange(getPackageName(), paramSQLiteDatabase);
      if (paramInt1 < 29) {
        paramSQLiteDatabase.execSQL(TableBuilder.a(new Ability()));
      }
      if (paramInt1 < 35) {
        paramSQLiteDatabase.execSQL(TableBuilder.a(new PhoneContact()));
      }
      if (paramInt1 < 36)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a("TroopSelfInfo"));
        paramSQLiteDatabase.execSQL(TableBuilder.a(TroopInfo.class.getSimpleName()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopInfo()));
        this.bUpdated = true;
      }
      if (paramInt1 < 41)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a(Card.class.getSimpleName()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new Card()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(ResourcePluginInfo.class.getSimpleName()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new ResourcePluginInfo()));
      }
      if (paramInt1 < 48)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a(Setting.class.getSimpleName()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new Setting()));
      }
      if (paramInt1 <= 66)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a(new SearchHistory()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new Stranger()));
      }
      if (paramInt1 < 74) {
        isUpdateFromLowV74 = true;
      }
      if (paramInt1 <= 84)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.a(new ExpiredPushBanner()));
        paramSQLiteDatabase.execSQL(TableBuilder.a(new ShortVideoUpInfo()));
      }
      if ((paramInt1 > 89) || (paramInt1 <= 93)) {
        paramSQLiteDatabase.execSQL(TableBuilder.a("DatingInfo"));
      }
    } while (paramInt1 > 97);
    paramSQLiteDatabase.execSQL(TableBuilder.a(ExtensionInfo.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a("MessageForColorRing"));
    paramSQLiteDatabase.execSQL(TableBuilder.a("DatingInfo"));
    paramSQLiteDatabase.execSQL(TableBuilder.a("MessageForVideo"));
    paramSQLiteDatabase.execSQL(TableBuilder.a("mr_dataline_printer"));
    paramSQLiteDatabase.execSQL(TableBuilder.a("MessageForQzoneFeed"));
    paramSQLiteDatabase.execSQL(TableBuilder.a("QZoneCover"));
  }
  
  public void verifyAuthentication()
  {
    EntityManager localEntityManager;
    if (this.name.matches("^[0-9]*$"))
    {
      localEntityManager = createEntityManager();
      localAbility = (Ability)localEntityManager.a(Ability.class, "flags=?", new String[] { String.valueOf(-1) });
      if (localAbility != null) {
        break label74;
      }
      localAbility = new Ability();
      localAbility.flags = -1;
      localAbility.uin = this.name;
      localEntityManager.b(localAbility);
    }
    label74:
    while ((localAbility.uin != null) && (localAbility.uin.equals(this.name))) {
      return;
    }
    this.mInnerDbHelper.dropAllTable();
    Ability localAbility = new Ability();
    localAbility.flags = -1;
    localAbility.uin = this.name;
    localEntityManager.b(localAbility);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */