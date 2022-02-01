package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.bottle.model.BottleBeachCursorAdapterORM;
import com.tencent.qqmail.bottle.model.table.BottleBeachTableData;
import com.tencent.qqmail.bottle.model.table.BottleBeachTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableData;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottlerTableData;
import com.tencent.qqmail.bottle.model.table.BottlerTableDataORM;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import rx.Observable;

public class BottleBeachController
{
  static final String PICK_ARGUMENT_PICKKEY = "&pickkey=%s";
  static final String PICK_BOTTLE_QUERY = "&t=bottle_pick_app&picktype=%s&latlng=%s&v=%s";
  static final String PICK_TYPE_FIRST = "first";
  static final String PICK_TYPE_PULL = "pull";
  private static final String TAG = "BottleBeachController";
  private WatcherArray<BottleLoadWatcher> mBottleLoadWatcherArray = new WatcherArray(BottleLoadWatcher.class);
  private final BottleManager mBottleManager;
  private WatcherArray<BottlePickupWatcher> mBottlePickupWatcherArray = new WatcherArray(BottlePickupWatcher.class);
  private WatcherArray<BottleSpamWatcher> mBottleSpamWatcherWatcherArray = new WatcherArray(BottleSpamWatcher.class);
  private long mLastRequestTime = 0L;
  private boolean mWaitingRequest = false;
  private int remainingTimes = 10;
  
  BottleBeachController(BottleManager paramBottleManager)
  {
    this.mBottleManager = paramBottleManager;
  }
  
  private void invokeBottleLoadWatcher(BottleBeach[] paramArrayOfBottleBeach)
  {
    QMLog.log(4, "BottleBeachController", "invokeBottleLoadWatcher");
    Threads.runOnMainThread(new BottleBeachController.3(this, paramArrayOfBottleBeach));
  }
  
  private void invokeBottlePickupWatcherError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleBeachController", "invokeBottlePickupWatcherError");
    Threads.runOnMainThread(new BottleBeachController.2(this, paramQMNetworkError));
  }
  
  private void invokeBottlePickupWatcherSuccess(int paramInt, BottleBeach[] paramArrayOfBottleBeach1, BottleBeach[] paramArrayOfBottleBeach2)
  {
    QMLog.log(4, "BottleBeachController", "invokeBottlePickupWatcherSuccess");
    Threads.runOnMainThread(new BottleBeachController.1(this, paramInt, paramArrayOfBottleBeach1, paramArrayOfBottleBeach2));
  }
  
  private void invokeBottleSpamWatcher(int paramInt, String paramString1, String paramString2)
  {
    if (this.mBottleSpamWatcherWatcherArray.length() > 0)
    {
      Iterator localIterator = this.mBottleSpamWatcherWatcherArray.iterator();
      while (localIterator.hasNext()) {
        ((BottleSpamWatcher)localIterator.next()).onBottleSpamWatcher(paramInt, paramString1, paramString2);
      }
    }
  }
  
  private Object parseAndWriteToDB(JSONObject paramJSONObject)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    BottleBeachTableData localBottleBeachTableData = new BottleBeachTableData();
    BottlerTableData localBottlerTableData = new BottlerTableData();
    BottleConversationTableData localBottleConversationTableData = new BottleConversationTableData();
    Object localObject1 = new char[256];
    int i;
    int j;
    label178:
    int m;
    try
    {
      localSQLiteDatabase.beginTransaction();
      str2 = paramJSONObject.getString("time_remain");
      str1 = paramJSONObject.getString("error");
      localJSONArray = paramJSONObject.getJSONArray("bottles");
      i = Integer.parseInt(str1);
      QMLog.log(4, "BottleBeachController", "parseAndWriteToDB iError:" + i);
      if ((i != 0) && (i != -1)) {
        break label817;
      }
      paramJSONObject = new BottleBeachController_TopBottlerColorCursorAdapterORM(localSQLiteDatabase, "ORDER BY beachbottle.number DESC LIMIT 1", null);
      if (paramJSONObject.getCount() != 1) {
        break label896;
      }
      i = paramJSONObject.getItem(0).tagColor + 1;
      paramJSONObject.close();
      if (Math.random() >= 0.5D) {
        break label928;
      }
      j = 1;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        String str2;
        String str1;
        JSONArray localJSONArray;
        Object localObject2;
        String str10;
        String str11;
        String str3;
        String str4;
        Object localObject4;
        String str5;
        String str6;
        String str7;
        Object localObject3;
        String str8;
        String str9;
        String str12;
        boolean bool;
        long l;
        label416:
        int n;
        int i1;
        label548:
        QMLog.log(6, "BottleBeachController", "parseAndWriteToDB error", paramJSONObject);
        BottleManager.log(paramJSONObject);
        i = -20005;
        localSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    if (j < localJSONArray.size())
    {
      localObject2 = localJSONArray.getJSONObject(j);
      str10 = ((JSONObject)localObject2).getString("type");
      k = Integer.parseInt(str10);
      if (k < 0)
      {
        if (k == -1) {
          break label917;
        }
        if (k != -5) {
          break label933;
        }
        break label917;
      }
      str1 = ((JSONObject)localObject2).getString("mailid");
      str11 = ((JSONObject)localObject2).getString("time");
      str3 = ((JSONObject)localObject2).getString("geo");
      localObject1 = ((JSONObject)localObject2).getString("distance");
      str4 = ((JSONObject)localObject2).getString("imgurl");
      localObject4 = ((JSONObject)localObject2).getString("content");
      str5 = ((JSONObject)localObject2).getString("subject");
      str6 = ((JSONObject)localObject2).getString("bottlecity");
      str7 = ((JSONObject)localObject2).getString("adurl");
      localObject3 = ((JSONObject)localObject2).getJSONObject("user");
      localObject2 = ((JSONObject)localObject3).getString("avatar");
      str8 = ((JSONObject)localObject3).getString("name");
      str9 = ((JSONObject)localObject3).getString("uin");
      str12 = ((JSONObject)localObject3).getString("gender");
      localObject3 = ((JSONObject)localObject3).getString("bigAvatar");
      bool = "male".equals(str12);
      l = Long.parseLong(str11);
      if ((localObject1 == null) || (((String)localObject1).equals(""))) {
        break label940;
      }
      k = (int)Double.parseDouble((String)localObject1);
      n = Integer.parseInt(str10);
      localObject1 = str1;
      if (str1 != null)
      {
        localObject1 = str1;
        if (str1.equals(""))
        {
          localObject1 = str1;
          if (n == 32) {
            localObject1 = "ad_bottleid_" + String.valueOf(System.currentTimeMillis());
          }
        }
      }
      i1 = this.mBottleManager.mSettings.getAndIncreaseBeachBottleNumber();
      str1 = this.mBottleManager.processContent(this.mBottleManager.mContext, (String)localObject4, n, null);
      if (paramJSONObject.length < str1.length() * 2)
      {
        paramJSONObject = new char[str1.length() * 2];
        localObject4 = new StringBuilder();
        str10 = this.mBottleManager.processEmoji(str1, (StringBuilder)localObject4, paramJSONObject);
        localBottleBeachTableData.setAll((String)localObject1, n, str5, l, str3, str6, k, null, str1, str10, ((StringBuilder)localObject4).toString(), str4, i1, str9, 0L, m, str7);
        BottleBeachTableDataORM.replace(localSQLiteDatabase, localBottleBeachTableData);
        localBottlerTableData.setAll(str9, BottleManager.formatAvatarUrl((String)localObject2), BottleManager.formatAvatarUrl((String)localObject3), str8, false, bool, 0);
        BottlerTableDataORM.replace(localSQLiteDatabase, localBottlerTableData);
        localBottleConversationTableData.setAll((String)localObject1, null, l, null, str1, str10, ((StringBuilder)localObject4).toString(), false, str4, "", 0, str9);
        BottleConversationTableDataORM.replace(localSQLiteDatabase, localBottleConversationTableData);
        localArrayList.add(new BottleBeach((String)localObject1, l, k, str4, str9, (String)localObject2, (String)localObject3, str8, bool, str6, null, str1, str10, ((StringBuilder)localObject4).toString(), n, m, str7));
        break label921;
      }
    }
    else
    {
      if (localArrayList.size() != 0) {
        break label948;
      }
      i = -20002;
      break label948;
    }
    label817:
    label948:
    for (;;)
    {
      this.remainingTimes = Integer.parseInt(str2);
      QMLog.log(4, "BottleBeachController", "parseAndWriteToDB remainingTimes:" + this.remainingTimes);
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      if (localArrayList.size() > 0)
      {
        return localArrayList.toArray(new BottleBeach[0]);
        if (i == -1001) {
          i = -20001;
        } else if (i == -1002) {
          i = -20006;
        } else {
          i = -20005;
        }
      }
      else
      {
        return Integer.valueOf(i);
        break label548;
        i = 0;
        break;
        m = i + j;
        j = 0;
        paramJSONObject = (JSONObject)localObject1;
        i = k;
        break label178;
        for (i = -20002;; i = -20005)
        {
          j += 1;
          break;
          j = 0;
          break label901;
        }
        localObject1 = "0";
        break label416;
      }
    }
  }
  
  private BottleBeach[] readBeachBottlesFromDB()
  {
    BottleBeachCursorAdapterORM localBottleBeachCursorAdapterORM = new BottleBeachCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "FROM beachbottle LEFT JOIN bottler ON beachbottle.uin=bottler.uin ORDER BY beachbottle.number DESC", null);
    int j = localBottleBeachCursorAdapterORM.getCount();
    BottleBeach[] arrayOfBottleBeach = new BottleBeach[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBottleBeach[i] = localBottleBeachCursorAdapterORM.getItem(i);
      i += 1;
    }
    localBottleBeachCursorAdapterORM.close();
    return arrayOfBottleBeach;
  }
  
  private void requestBottle(int paramInt, boolean paramBoolean, String paramString)
  {
    this.mBottleManager.getCoordinateObservable().subscribe(new BottleBeachController.8(this, paramInt, paramBoolean, paramString));
  }
  
  private void requestBottle(int paramInt, boolean paramBoolean, String paramString, BottleManager.Coordinate paramCoordinate)
  {
    QMLog.log(4, "BottleBeachController", "requestBottle: count: " + paramInt + ", firstLoader:" + paramBoolean + ", geo:" + paramCoordinate + ", pickkey:" + paramString);
    String str;
    if (paramBoolean)
    {
      str = "first";
      if (paramCoordinate != null) {
        break label174;
      }
    }
    label174:
    for (paramCoordinate = "";; paramCoordinate = paramCoordinate.toString())
    {
      str = String.format("&t=bottle_pick_app&picktype=%s&latlng=%s&v=%s", new Object[] { str, paramCoordinate, AppConfig.getCodeVersion() });
      paramCoordinate = str;
      if (paramString != null) {
        paramCoordinate = str + String.format("&pickkey=%s", new Object[] { paramString });
      }
      this.mBottleManager.httpPost("bottle_pick", paramCoordinate, new BottleBeachController.9(this, paramBoolean, paramInt));
      return;
      str = "pull";
      break;
    }
  }
  
  public void bindBottleLoadWatcher(BottleLoadWatcher paramBottleLoadWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mBottleLoadWatcherArray.add(paramBottleLoadWatcher);
      return;
    }
    this.mBottleLoadWatcherArray.remove(paramBottleLoadWatcher);
  }
  
  public void bindBottlePickUpWatcher(BottlePickupWatcher paramBottlePickupWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mBottlePickupWatcherArray.add(paramBottlePickupWatcher);
      return;
    }
    this.mBottlePickupWatcherArray.remove(paramBottlePickupWatcher);
  }
  
  public void bindBottleSpamWatcher(BottleSpamWatcher paramBottleSpamWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mBottleSpamWatcherWatcherArray.add(paramBottleSpamWatcher);
      return;
    }
    this.mBottleSpamWatcherWatcherArray.remove(paramBottleSpamWatcher);
  }
  
  public void checkBottlePanel()
  {
    int i = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new BottleBeachController.10(this));
    localQMCallback.setOnError(new BottleBeachController.11(this));
    CGIManager.httpPost(i, "bottle_panel", "t=bottle_panel_app&plpfrom=mailapp&plaform=android", localQMCallback);
  }
  
  boolean deleteBottle(String[] paramArrayOfString)
  {
    QMLog.log(4, "BottleBeachController", "deleteBottle");
    boolean bool = false;
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    BottleBeachController_BeachBottleInfoCursorAdapterORM localBottleBeachController_BeachBottleInfoCursorAdapterORM = new BottleBeachController_BeachBottleInfoCursorAdapterORM(localSQLiteDatabase, " WHERE bottleid=?", paramArrayOfString);
    if (localBottleBeachController_BeachBottleInfoCursorAdapterORM.getCount() > 0) {}
    try
    {
      localSQLiteDatabase.beginTransaction();
      localSQLiteDatabase.execSQL("DELETE FROM beachbottle WHERE bottleid=?", paramArrayOfString);
      localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=?", paramArrayOfString);
      this.mBottleManager.mBottlerController.deleteBottler(localSQLiteDatabase);
      localSQLiteDatabase.setTransactionSuccessful();
      bool = true;
      localSQLiteDatabase.endTransaction();
      return bool;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public boolean isBeachBottle(String paramString)
  {
    return isBeachBottle(new String[] { paramString });
  }
  
  boolean isBeachBottle(String[] paramArrayOfString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Cursor localCursor = this.mBottleManager.mDBOpenHelper.getReadableDatabase().rawQuery("SELECT bottleid FROM beachbottle WHERE bottleid=?", paramArrayOfString);
    if (localCursor != null)
    {
      bool1 = bool2;
      if (localCursor.getCount() > 0) {
        bool1 = true;
      }
      localCursor.close();
    }
    BottleManager.log("isBeachBottle: " + Arrays.toString(paramArrayOfString) + ", bBeachBottle:" + bool1);
    return bool1;
  }
  
  public void loadBeachBottle()
  {
    Threads.runInBackground(new BottleBeachController.7(this));
  }
  
  public void remove(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.remove(paramString, paramOnActionCallback);
  }
  
  public void requestBeachBottle()
  {
    long l = System.currentTimeMillis();
    QMLog.log(4, "BottleBeachController", String.format("requestBeachBottle: %s, time:%s", new Object[] { Boolean.valueOf(this.mWaitingRequest), Long.valueOf(l - this.mLastRequestTime) }));
    if (!this.mWaitingRequest)
    {
      if (l - this.mLastRequestTime < 5000L)
      {
        this.mWaitingRequest = true;
        Threads.runInBackground(new BottleBeachController.4(this), l - this.mLastRequestTime);
      }
    }
    else {
      return;
    }
    Threads.runInBackground(new BottleBeachController.5(this));
  }
  
  public void requestBeachBottle(String paramString)
  {
    QMLog.log(4, "BottleBeachController", "requestBeachBottle pickKey:" + paramString);
    Threads.runInBackground(new BottleBeachController.6(this, paramString));
  }
  
  public void spam(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.spam(paramString, paramOnActionCallback);
  }
  
  static class BeachBottleInfo
  {
    String bottleId;
    String uin;
  }
  
  public static abstract interface BottleLoadWatcher
  {
    public abstract void onBottleLoadInMainThread(BottleBeach[] paramArrayOfBottleBeach);
  }
  
  public static class BottlePickupError
    extends QMNetworkError
  {
    public static final int ERROR_CGI_DATA_INVALID_CODE = -20005;
    private static final int ERROR_DEFAULT_CODE = -20000;
    public static final int ERROR_EMPTY_BOTTLE_CODE = -20002;
    public static final int ERROR_INITIALIZATION_CODE = -20004;
    public static final int ERROR_TOO_FREQUENT_CODE = -20006;
    public static final int ERROR_USED_UP_CODE = -20001;
    public final int expectedCount;
    
    public BottlePickupError(int paramInt1, int paramInt2)
    {
      super(paramInt1);
      this.expectedCount = paramInt2;
    }
  }
  
  public static abstract interface BottlePickupWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccessInMainThread(int paramInt, BottleBeach[] paramArrayOfBottleBeach1, BottleBeach[] paramArrayOfBottleBeach2);
  }
  
  public static abstract interface BottleSpamWatcher
  {
    public abstract void onBottleSpamWatcher(int paramInt, String paramString1, String paramString2);
  }
  
  static class TopBottlerColor
  {
    String bottleId;
    int tagColor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController
 * JD-Core Version:    0.7.0.1
 */