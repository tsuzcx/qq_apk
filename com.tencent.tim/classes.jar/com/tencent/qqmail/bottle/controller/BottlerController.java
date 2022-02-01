package com.tencent.qqmail.bottle.controller;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.bottle.model.BottlerCursorAdapterORM;
import com.tencent.qqmail.bottle.model.table.BottlerTableData;
import com.tencent.qqmail.bottle.model.table.BottlerTableDataORM;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BottlerController
{
  static final String GETNAME_QUERY = "mode=getname&t=bottle_setting_getname_app";
  public static final int IS_MINE_ME = 1;
  public static final int IS_MINE_OTHER = 0;
  public static final int IS_MIN_ME_ALIAS = 2;
  static final String MY_BOTTLER_ALIAS_UIN = "@@mYboTtLe3.1415926";
  public static final int NICKNAME_MAX_LENGTH = 10;
  static final String SET_GENDER_QUERY = "mode=setappinfo&t=bottle_setting_setappinfo_app&gender=%s";
  static final String SET_NAME_QUERY = "mode=setappinfo&t=bottle_setting_setappinfo_app&name=%s";
  private static final String TAG = "BottlerController";
  private Future<Bottler[]> asyncQueryMyInformation;
  private final BottleManager mBottleManager;
  private Bottler mMyInformation;
  private WatcherArray<MyInformationUpdatedWatcher> mMyInformationUpdatedWatcherArray = new WatcherArray(MyInformationUpdatedWatcher.class);
  final ArrayList<InternalMyInformationUpdatedWatcher> mMyInformationUpdatedWatcherToWaitMyUin = new ArrayList();
  private boolean retryRequestMyInformation = false;
  
  BottlerController(BottleManager paramBottleManager)
  {
    this.mBottleManager = paramBottleManager;
    initMyInformation();
  }
  
  private void initMyInformation()
  {
    this.asyncQueryMyInformation = Threads.submitTask(new BottlerController.1(this));
  }
  
  private void invokeMyInformationUpdatedWatcherError(QMNetworkError paramQMNetworkError)
  {
    Threads.runOnMainThread(new BottlerController.7(this, paramQMNetworkError));
    synchronized (this.mMyInformationUpdatedWatcherToWaitMyUin)
    {
      Iterator localIterator = this.mMyInformationUpdatedWatcherToWaitMyUin.iterator();
      if (localIterator.hasNext()) {
        ((InternalMyInformationUpdatedWatcher)localIterator.next()).onError(paramQMNetworkError);
      }
    }
    this.mMyInformationUpdatedWatcherToWaitMyUin.clear();
  }
  
  private void invokeMyInformationUpdatedWatcherSuccess(Bottler arg1)
  {
    if (??? != null)
    {
      this.mMyInformation = ???;
      Threads.runOnMainThread(new BottlerController.6(this, ???));
      synchronized (this.mMyInformationUpdatedWatcherToWaitMyUin)
      {
        Iterator localIterator = this.mMyInformationUpdatedWatcherToWaitMyUin.iterator();
        if (localIterator.hasNext()) {
          ((InternalMyInformationUpdatedWatcher)localIterator.next()).onSuccess();
        }
      }
      this.mMyInformationUpdatedWatcherToWaitMyUin.clear();
    }
  }
  
  public static boolean isAlias(String paramString)
  {
    return "@@mYboTtLe3.1415926".equals(paramString);
  }
  
  private void parseMyInformationAndWriteToDB(JSONObject paramJSONObject)
  {
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    String str1 = paramJSONObject.getString("enuin");
    String str2 = paramJSONObject.getString("useruin");
    String str3 = paramJSONObject.getString("gender");
    String str4 = paramJSONObject.getString("anonymous");
    String str5 = paramJSONObject.getString("avatar");
    String str6 = paramJSONObject.getString("bigAvatar");
    paramJSONObject = paramJSONObject.getString("name");
    boolean bool1 = "1".equals(str4);
    boolean bool2 = "male".equals(str3);
    String str7 = BottleManager.formatAvatarUrl(str5);
    String str8 = BottleManager.formatAvatarUrl(str6);
    BottlerTableData localBottlerTableData = new BottlerTableData();
    localBottlerTableData.setAll(str1, str7, str8, paramJSONObject, bool1, bool2, 1);
    BottlerTableDataORM.replace(localSQLiteDatabase, localBottlerTableData);
    localBottlerTableData.setAll("@@mYboTtLe3.1415926", str7, str8, paramJSONObject, bool1, bool2, 2);
    BottlerTableDataORM.replace(localSQLiteDatabase, localBottlerTableData);
    QMLog.log(4, "BottlerController", String.format("parseMyInformation enuin:%s, useruin:%s, gender:%s, anonymous:%s, avatar:%s, bigAvatar:%s, name:%s", new Object[] { str1, str2, str3, str4, str5, str6, paramJSONObject }));
  }
  
  private Bottler readMyInformationFromDB()
  {
    BottlerCursorAdapterORM localBottlerCursorAdapterORM = new BottlerCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "WHERE isMine=1", null);
    try
    {
      int i = localBottlerCursorAdapterORM.getCount();
      if (i == 0) {
        return null;
      }
      Bottler localBottler = localBottlerCursorAdapterORM.getItem(0);
      return localBottler;
    }
    finally
    {
      localBottlerCursorAdapterORM.close();
    }
  }
  
  private void requestMyInformationFromCGI()
  {
    QMLog.log(4, "BottlerController", "requestMyInformationFromCGI");
    if (RequestFilter.isRequestOnRunning("mode=getname&t=bottle_setting_getname_app")) {
      return;
    }
    RequestFilter.setRequestRunningState("mode=getname&t=bottle_setting_getname_app");
    this.mBottleManager.httpGet("bottle_setting", "mode=getname&t=bottle_setting_getname_app", new BottlerController.5(this));
  }
  
  private void submitMyAvatar(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      localObject = FileUtil.getExternalQQMailCacheDirPath();
      if (localObject == null) {
        QMLog.log(6, "BottlerController", "submitMyAvatar cacheDir null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (String)localObject + File.separator + "bottle_my_avatar.jpg";
    if (!ImageUtil.writeBitmapToLocation(paramBitmap, Bitmap.CompressFormat.JPEG, 80, (String)localObject))
    {
      QMLog.log(6, "BottlerController", "submitMyAvatar write bitmap failed");
      return;
    }
    paramBitmap = new QMFileEntity(new File((String)localObject), "application/octet-stream", "binaryfile");
    localObject = new ArrayList();
    ((List)localObject).add(paramBitmap);
    if (this.mMyInformation == null)
    {
      QMLog.log(6, "BottlerController", "submitMyAvatar my information is null");
      return;
    }
    this.mBottleManager.httpMultiPost("bottle_setting", "mode=iconupload&t=bottle_setting_iconupload_app", (List)localObject, new BottlerController.4(this));
  }
  
  private void submitMyNickName(String paramString)
  {
    QMLog.log(4, "BottlerController", "submitMyNickName nickname:" + paramString);
    String str;
    if (paramString != null)
    {
      str = paramString.trim();
      paramString = str;
      if (str.length() > 10) {
        throw new IllegalArgumentException("max charater 10");
      }
    }
    if ((paramString != null) && (this.mMyInformation != null) && (!paramString.equals(this.mMyInformation.getName())))
    {
      this.mMyInformation.setAll(this.mMyInformation.getUin(), this.mMyInformation.getAvatar(), this.mMyInformation.getBigAvatar(), paramString, this.mMyInformation.isMale(), this.mMyInformation.isAnonymous());
      str = String.format("mode=setappinfo&t=bottle_setting_setappinfo_app&name=%s", new Object[] { StringExtention.encodeURI(paramString) });
      this.mBottleManager.httpGet("bottle_setting", str, new BottlerController.2(this, paramString));
    }
  }
  
  public void bindMyInformationUpdatedWatcher(MyInformationUpdatedWatcher paramMyInformationUpdatedWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mMyInformationUpdatedWatcherArray.add(paramMyInformationUpdatedWatcher);
      return;
    }
    this.mMyInformationUpdatedWatcherArray.remove(paramMyInformationUpdatedWatcher);
  }
  
  void deleteBottler(SQLiteDatabase paramSQLiteDatabase)
  {
    SQLiteDatabase localSQLiteDatabase = paramSQLiteDatabase;
    if (paramSQLiteDatabase == null) {}
    try
    {
      localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
      localSQLiteDatabase.execSQL("DELETE FROM bottler WHERE bottler.uin NOT IN (SELECT beachbottle.uin FROM beachbottle) AND bottler.uin NOT IN (SELECT bottlelist.uin FROM bottlelist) AND bottler.uin NOT IN (SELECT bottleconv.uin FROM bottleconv) AND bottler.isMine=0");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "BottlerController", "deleteBottler sql exception", paramSQLiteDatabase);
    }
  }
  
  public Bottler getBottler(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if (paramString.length() > 0)
      {
        localObject1 = new BottlerCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "WHERE uin=?", new String[] { paramString });
        paramString = localObject2;
        if (((BottlerCursorAdapterORM)localObject1).getCount() == 1) {
          paramString = ((BottlerCursorAdapterORM)localObject1).getItem(0);
        }
        ((BottlerCursorAdapterORM)localObject1).close();
        localObject1 = paramString;
      }
    }
    return localObject1;
  }
  
  public Bottler getMyInformation()
  {
    if (this.mMyInformation == null)
    {
      Bottler localBottler;
      try
      {
        Bottler[] arrayOfBottler = (Bottler[])this.asyncQueryMyInformation.get(1000L, TimeUnit.MILLISECONDS);
        this.mMyInformation = arrayOfBottler[0];
        if (this.mMyInformation != null) {
          return this.mMyInformation;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "BottlerController", "getMyInformation err: ", localException);
        localBottler = new Bottler();
        localBottler.setAll("@@mYboTtLe3.1415926", "", "", "", true, false);
        return localBottler;
      }
      return localBottler[1];
    }
    return this.mMyInformation;
  }
  
  public String getMyUin()
  {
    return getMyInformation().getUin();
  }
  
  public boolean isMine(String paramString)
  {
    if ("@@mYboTtLe3.1415926".equals(paramString)) {}
    while ((this.mMyInformation != null) && (this.mMyInformation.getUin() != null) && (this.mMyInformation.getUin().equals(paramString))) {
      return true;
    }
    return false;
  }
  
  public void refreshMyInformation()
  {
    BottleManager.log("loadMyInformation");
    Threads.runInBackground(new BottlerController.8(this));
  }
  
  public void submitMyGender(boolean paramBoolean)
  {
    QMLog.log(4, "BottlerController", "submitMyGender isMale:" + paramBoolean);
    if ((this.mMyInformation != null) && (paramBoolean != this.mMyInformation.isMale()))
    {
      this.mMyInformation.setAll(this.mMyInformation.getUin(), this.mMyInformation.getAvatar(), this.mMyInformation.getBigAvatar(), this.mMyInformation.getName(), paramBoolean, this.mMyInformation.isAnonymous());
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (String str = "male";; str = "female")
    {
      str = String.format("mode=setappinfo&t=bottle_setting_setappinfo_app&gender=%s", new Object[] { str });
      this.mBottleManager.httpGet("bottle_setting", str, new BottlerController.3(this, paramBoolean));
      return;
    }
  }
  
  public void submitMyInformcation(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("submitMyInformcation: ").append(paramString).append(", avatar:");
    if (paramBitmap != null) {}
    for (boolean bool = true;; bool = false)
    {
      BottleManager.log(bool);
      submitMyNickName(paramString);
      submitMyAvatar(paramBitmap);
      return;
    }
  }
  
  static abstract interface InternalMyInformationUpdatedWatcher
  {
    public abstract void onError(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccess();
  }
  
  public static class LoadMyInformationError
    extends QMNetworkError
  {
    private static final int ERROR_DEFAULT_CODE = -20000;
    public static final int ERROR_UNLOADED_CODE = -20001;
    
    public LoadMyInformationError(int paramInt)
    {
      super(paramInt);
    }
  }
  
  static class MyInformationData
  {
    String avatar;
    String bigAvatar;
    boolean male;
    String name;
    String uin;
    
    public MyInformationData() {}
    
    public MyInformationData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    {
      this.uin = paramString1;
      this.name = paramString2;
      this.avatar = paramString3;
      this.bigAvatar = paramString4;
      this.male = paramBoolean;
    }
  }
  
  public static abstract interface MyInformationUpdatedWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
    
    public abstract void onMyInformationUpdatedInMainThread(Bottler paramBottler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController
 * JD-Core Version:    0.7.0.1
 */