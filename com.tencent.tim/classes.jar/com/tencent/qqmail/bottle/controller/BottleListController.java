package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.bottle.model.BottleListCursorAdapterORM;
import com.tencent.qqmail.bottle.model.BottleListORM;
import com.tencent.qqmail.bottle.model.table.BottleListTableData;
import com.tencent.qqmail.bottle.model.table.BottleListTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottlerTableData;
import com.tencent.qqmail.bottle.model.table.BottlerTableDataORM;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.List;

public class BottleListController
{
  private static final int ERROR_NO_MORE_ITEM_CODE = 9955;
  private static final String LIST_QUERY = "t=bottle_list_app&listtype=app&synckey=%s&max=%s&count=%s";
  private static final String TAG = "BottleListController";
  private final BottleManager mBottleManager;
  private final RequestListCallback mDefaultRequestCallback = new BottleListController.6(this);
  private boolean mNewUnreadFlag = false;
  private WatcherArray<UpdateListWatcher> mUpdateListWatcherArray = new WatcherArray(UpdateListWatcher.class);
  private WatcherArray<UpdateUnreadStatusWatcher> mUpdateUnreadStatusWatcherArray = new WatcherArray(UpdateUnreadStatusWatcher.class);
  
  BottleListController(BottleManager paramBottleManager)
  {
    this.mBottleManager = paramBottleManager;
  }
  
  private void invokeUpdateListWatcherError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleListController", "invokeUpdateListWatcherError:" + paramQMNetworkError.toString());
    Threads.runOnMainThread(new BottleListController.2(this, paramQMNetworkError));
  }
  
  private void invokeUpdateListWatcherSuccess(BottleListCursor paramBottleListCursor)
  {
    QMLog.log(4, "BottleListController", "invokeUpdateListWatcherSuccess");
    Threads.runOnMainThread(new BottleListController.1(this, paramBottleListCursor));
  }
  
  private void invokeUpdateUnreadStatusWatcherSuccess()
  {
    Threads.runOnMainThread(new BottleListController.8(this));
  }
  
  private boolean isDatabaseOverdue(BottleListCursor paramBottleListCursor1, BottleListCursor paramBottleListCursor2)
  {
    return !paramBottleListCursor1.equals(paramBottleListCursor2);
  }
  
  private boolean isServerOverdue(BottleListCursor paramBottleListCursor)
  {
    if ((paramBottleListCursor == null) || (paramBottleListCursor.timestamp == 0L)) {}
    while ((this.mBottleManager.mSettings.isListOverdue()) || (this.mBottleManager.mSettings.getListSvnTime() > paramBottleListCursor.timestamp)) {
      return true;
    }
    return false;
  }
  
  private void parseListAndWriteToDB(JSONObject paramJSONObject)
  {
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    String str1 = this.mBottleManager.mBottlerController.getMyUin();
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        String str2 = paramJSONObject.getString("total");
        Object localObject = paramJSONObject.getString("totalunread");
        String str4 = paramJSONObject.getString("lastunreadtime");
        String str3 = paramJSONObject.getString("svrtime");
        JSONArray localJSONArray1 = paramJSONObject.getJSONArray("more");
        JSONArray localJSONArray2 = paramJSONObject.getJSONArray("deleted");
        JSONArray localJSONArray3 = paramJSONObject.getJSONArray("added");
        paramJSONObject = paramJSONObject.getJSONArray("updated");
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          i = Integer.parseInt((String)localObject);
          if ((str4 == null) || (str4.length() <= 0)) {
            break label340;
          }
          l = Long.parseLong(str4);
          updateUnreadCountAndTime(l, i);
          if (localJSONArray2 != null)
          {
            localObject = new String[1];
            i = j;
            if (i < localJSONArray2.size())
            {
              localObject[0] = localJSONArray2.getString(i);
              localSQLiteDatabase.execSQL("DELETE FROM bottlelist WHERE bottleid=?", (Object[])localObject);
              i += 1;
              continue;
            }
          }
          replaceJSON(localSQLiteDatabase, localJSONArray1, str1);
          replaceJSON(localSQLiteDatabase, paramJSONObject, str1);
          replaceJSON(localSQLiteDatabase, localJSONArray3, str1);
          i = Integer.parseInt(str2);
          l = Long.parseLong(str3);
          this.mBottleManager.mSettings.setListTotalAndSvnTime(i, l);
          if (((localJSONArray1 == null) || (localJSONArray1.size() == 0)) && ((paramJSONObject == null) || (paramJSONObject.size() == 0)) && ((localJSONArray3 == null) || (localJSONArray3.size() == 0)))
          {
            localSQLiteDatabase.setTransactionSuccessful();
            return;
          }
          this.mBottleManager.mSettings.updateListDBChangedTimeStamp();
          continue;
        }
        int i = 0;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.log(6, "BottleListController", "parseListAndWriteToDB error", paramJSONObject);
        BottleManager.log(paramJSONObject);
        return;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      continue;
      label340:
      long l = 0L;
    }
  }
  
  private BottleListCursor readListFromDB()
  {
    Object localObject2 = null;
    Cursor localCursor = BottleListORM.rawQuery(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "FROM bottlelist LEFT JOIN bottler ON bottlelist.uin=bottler.uin LEFT JOIN bottleconv ON bottlelist.bottleid=bottleconv.bottleid GROUP BY bottlelist.bottleid ORDER BY bottlelist.time DESC", null);
    int j = this.mBottleManager.mSettings.getListTotal();
    long l2 = this.mBottleManager.mSettings.getListSvnTime();
    long l3 = this.mBottleManager.mSettings.getListDBChangedTimeStamp();
    long l1 = l2;
    int i = j;
    if (localCursor.getCount() == 0)
    {
      l1 = l2;
      i = j;
      if (j == 0)
      {
        i = 0;
        l1 = 0L;
        this.mBottleManager.mSettings.setListTotalAndSvnTime(0, 0L);
      }
    }
    Object localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToLast())
      {
        localObject1 = new BottleList();
        BottleListORM.fill(localCursor, (BottleList)localObject1);
        if (BottleThrowController.isUnsendBottleId(((BottleList)localObject1).getBottleId())) {
          break label209;
        }
      }
    }
    for (localObject1 = ((BottleList)localObject1).getBottleId();; localObject1 = localObject2)
    {
      localObject1 = new BottleListCursor(l1, i, (String)localObject1, l3, new BottleListCursorAdapterORM(localCursor));
      QMLog.log(4, "BottleListController", "readListFromDB: " + localObject1);
      return localObject1;
      label209:
      if (localCursor.moveToPrevious()) {
        break;
      }
    }
  }
  
  private void replaceJSON(SQLiteDatabase paramSQLiteDatabase, JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray == null) {
      return;
    }
    BottleListTableData localBottleListTableData = new BottleListTableData();
    BottlerTableData localBottlerTableData = new BottlerTableData();
    char[] arrayOfChar = new char[1024];
    int i = 0;
    label33:
    Object localObject1;
    String str2;
    String str1;
    Object localObject3;
    boolean bool1;
    int k;
    String str3;
    Object localObject2;
    String str4;
    int m;
    long l;
    int j;
    if (i < paramJSONArray.size())
    {
      localObject1 = paramJSONArray.getJSONObject(i);
      str2 = ((JSONObject)localObject1).getString("mailId");
      str1 = ((JSONObject)localObject1).getString("unreadCount");
      localObject3 = ((JSONObject)localObject1).getString("updateTime");
      bool1 = ((JSONObject)localObject1).getBooleanValue("pick");
      k = ((JSONObject)localObject1).getIntValue("type");
      str3 = ((JSONObject)localObject1).getString("summary");
      localObject2 = ((JSONObject)localObject1).getJSONObject("user");
      str4 = ((JSONObject)localObject1).getString("distance");
      localObject1 = ((JSONObject)localObject1).getString("bottlecity");
      m = Integer.parseInt(str1);
      l = Long.parseLong((String)localObject3);
      if ((str4 != null) && (str4.length() != 0)) {
        break label398;
      }
      j = -1;
      label170:
      if (str3 == null) {
        break label409;
      }
      str1 = str3.replaceAll("\n", " ");
      label188:
      if (arrayOfChar.length >= str3.length() * 2) {
        break label450;
      }
      arrayOfChar = new char[str3.length() * 2];
    }
    label398:
    label409:
    label450:
    for (;;)
    {
      localObject3 = new StringBuilder();
      str3 = this.mBottleManager.processEmoji(str3, (StringBuilder)localObject3, arrayOfChar);
      if (localObject2 != null)
      {
        String str6 = ((JSONObject)localObject2).getString("avatar");
        str4 = ((JSONObject)localObject2).getString("name");
        String str5 = ((JSONObject)localObject2).getString("uin");
        String str7 = ((JSONObject)localObject2).getString("gender");
        localObject2 = ((JSONObject)localObject2).getString("bigAvatar");
        boolean bool2 = "male".equals(str7);
        str6 = BottleManager.formatAvatarUrl(str6);
        localObject2 = BottleManager.formatAvatarUrl((String)localObject2);
        localBottleListTableData.setAll(str2, m, str1, str3, ((StringBuilder)localObject3).toString(), l, k, null, (String)localObject1, j, bool1, str5);
        localBottlerTableData.setAll(str5, str6, (String)localObject2, str4, false, bool2, 0);
      }
      for (;;)
      {
        BottleListTableDataORM.replace(paramSQLiteDatabase, localBottleListTableData);
        BottlerTableDataORM.replace(paramSQLiteDatabase, localBottlerTableData);
        BottleListController_BottleListOverdueDataORM.update(paramSQLiteDatabase, new BottleListOverdueData(str2, true));
        i += 1;
        break label33;
        break;
        j = (int)Double.parseDouble(str4);
        break label170;
        str1 = "";
        break label188;
        localBottleListTableData.setAll(str2, m, str1, str3, ((StringBuilder)localObject3).toString(), l, k, null, (String)localObject1, j, bool1, paramString);
      }
    }
  }
  
  private void requestList(BottleListCursor paramBottleListCursor, boolean paramBoolean, RequestListCallback paramRequestListCallback)
  {
    QMLog.log(4, "BottleListController", "requestList bSync:" + paramBoolean);
    if ((paramBottleListCursor == null) || (paramBottleListCursor.timestamp == 0L)) {
      paramBottleListCursor = String.format("t=bottle_list_app&listtype=app&synckey=%s&max=%s&count=%s", new Object[] { "0", "", "20" });
    }
    while (RequestFilter.isRequestOnRunning(paramBottleListCursor))
    {
      QMLog.log(4, "BottleListController", "requestList: running:" + paramBottleListCursor);
      return;
      if (paramBoolean) {
        paramBottleListCursor = String.format("t=bottle_list_app&listtype=app&synckey=%s&max=%s&count=%s", new Object[] { String.valueOf(paramBottleListCursor.timestamp), "", "" });
      } else if (paramBottleListCursor.lastBottleId == null) {
        paramBottleListCursor = String.format("t=bottle_list_app&listtype=app&synckey=%s&max=%s&count=%s", new Object[] { String.valueOf(paramBottleListCursor.timestamp), "", "" });
      } else {
        paramBottleListCursor = String.format("t=bottle_list_app&listtype=app&synckey=%s&max=%s&count=%s", new Object[] { String.valueOf(paramBottleListCursor.timestamp), paramBottleListCursor.lastBottleId, "20" });
      }
    }
    RequestFilter.resetRequestRunningState(paramBottleListCursor);
    this.mBottleManager.httpGet("bottle_list", paramBottleListCursor, new BottleListController.7(this, paramBottleListCursor, paramRequestListCallback));
  }
  
  private void updateUnreadCountAndTime(long paramLong, int paramInt)
  {
    long l = this.mBottleManager.mSettings.getUnreadLastTime();
    QMLog.log(4, "BottleListController", "parseMobileSyncToUpdateUnreadTime: oldTime:" + l + ", time:" + paramLong + ", count:" + paramInt);
    if ((this.mNewUnreadFlag) || (paramLong > l)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mNewUnreadFlag = bool;
      if (paramLong > 0L) {
        this.mBottleManager.mSettings.setUnreadLastTime(paramLong);
      }
      this.mBottleManager.mSettings.setUnreadCount(paramInt);
      invokeUpdateUnreadStatusWatcherSuccess();
      return;
    }
  }
  
  public void bindUpdateListWatcher(UpdateListWatcher paramUpdateListWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mUpdateListWatcherArray.add(paramUpdateListWatcher);
      return;
    }
    this.mUpdateListWatcherArray.remove(paramUpdateListWatcher);
  }
  
  public void bindUpdateUnreadStatusWatcher(UpdateUnreadStatusWatcher paramUpdateUnreadStatusWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mUpdateUnreadStatusWatcherArray.add(paramUpdateUnreadStatusWatcher);
      return;
    }
    this.mUpdateUnreadStatusWatcherArray.remove(paramUpdateUnreadStatusWatcher);
  }
  
  void decBottleUnreadCount(int paramInt)
  {
    this.mBottleManager.mSettings.decBottleUnreadCount(paramInt);
    invokeUpdateUnreadStatusWatcherSuccess();
  }
  
  boolean deleteBottle(String[] paramArrayOfString)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    BottleListController_ListBottleInfoCursorAdapterORM localBottleListController_ListBottleInfoCursorAdapterORM = new BottleListController_ListBottleInfoCursorAdapterORM(localSQLiteDatabase, " WHERE bottleid=?", paramArrayOfString);
    if (localBottleListController_ListBottleInfoCursorAdapterORM.getCount() > 0) {
      if (localBottleListController_ListBottleInfoCursorAdapterORM.getItem(0).unreadCnt > 0) {
        decBottleUnreadCount(1);
      }
    }
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        localSQLiteDatabase.execSQL("DELETE FROM bottlelist WHERE bottleid=?", paramArrayOfString);
        localSQLiteDatabase.execSQL("DELETE FROM bottlelistextra WHERE bottleid=?", paramArrayOfString);
        localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=?", paramArrayOfString);
        this.mBottleManager.mBottlerController.deleteBottler(localSQLiteDatabase);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        return bool;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      bool = false;
    }
  }
  
  public int getBottleUnreadCount()
  {
    return this.mBottleManager.mSettings.getUnreadCount();
  }
  
  public boolean hasNewBottle()
  {
    return this.mNewUnreadFlag;
  }
  
  boolean isListBottle(String[] paramArrayOfString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramArrayOfString = this.mBottleManager.mDBOpenHelper.getReadableDatabase().rawQuery("SELECT bottleid FROM bottlelist WHERE bottleid=?", paramArrayOfString);
    if (paramArrayOfString != null)
    {
      bool1 = bool2;
      if (paramArrayOfString.getCount() > 0) {
        bool1 = true;
      }
      paramArrayOfString.close();
    }
    return bool1;
  }
  
  public void loadList(BottleListCursor paramBottleListCursor)
  {
    QMLog.log(4, "BottleListController", "loadList");
    Threads.runInBackground(new BottleListController.3(this, paramBottleListCursor));
  }
  
  public void loadMore(BottleListCursor paramBottleListCursor)
  {
    QMLog.log(4, "BottleListController", "loadMore");
    ValidateHelper.notNull(paramBottleListCursor);
    Threads.runInBackground(new BottleListController.4(this, paramBottleListCursor));
  }
  
  public void parseMobileSyncToUpdateUnreadTime(int paramInt, JSONObject paramJSONObject)
  {
    if (paramInt != this.mBottleManager.mAccountId)
    {
      QMLog.log(5, "BottleListController", "parseMobileSyncToUpdateUnreadTime change account: " + paramInt + ", " + this.mBottleManager.mAccountId);
      return;
    }
    if (paramJSONObject.containsKey("plpunreadtime")) {}
    for (long l = paramJSONObject.getLongValue("plpunreadtime");; l = -1L)
    {
      if (paramJSONObject.containsKey("plpunreadcnt")) {}
      for (paramInt = paramJSONObject.getIntValue("plpunreadcnt");; paramInt = -1)
      {
        if ((l == -1L) || (paramInt == -1))
        {
          QMLog.log(5, "BottleListController", "parseMobileSyncToUpdateUnreadTime time:" + l + ", count:" + paramInt);
          return;
        }
        updateUnreadCountAndTime(l, paramInt);
        return;
      }
    }
  }
  
  public void readDataFromDB()
  {
    this.mDefaultRequestCallback.onSuccess();
  }
  
  public void refreshList()
  {
    Threads.runInBackground(new BottleListController.5(this));
  }
  
  void refreshList(RequestListCallback paramRequestListCallback)
  {
    ValidateHelper.notMainThread();
    BottleListCursor localBottleListCursor = readListFromDB();
    requestList(localBottleListCursor, true, paramRequestListCallback);
    localBottleListCursor.close();
  }
  
  public void remove(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.remove(paramString, paramOnActionCallback);
  }
  
  public void remove(List<String> paramList, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.remove(paramList, paramOnActionCallback);
  }
  
  public void spam(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.spam(paramString, paramOnActionCallback);
  }
  
  public void unmarkNewUnread()
  {
    this.mNewUnreadFlag = false;
    this.mBottleManager.mSettings.setUnreadLastTime(this.mBottleManager.mSettings.getListSvnTime());
  }
  
  void willRefreshList()
  {
    BottleManager.log("willRefreshList: ");
    if (this.mUpdateListWatcherArray.length() > 0) {
      refreshList();
    }
  }
  
  static class BottleListOverdueData
  {
    String bottleId;
    boolean convOverdue;
    
    public BottleListOverdueData() {}
    
    public BottleListOverdueData(String paramString, boolean paramBoolean)
    {
      this.bottleId = paramString;
      this.convOverdue = paramBoolean;
    }
  }
  
  static class ListBottleInfo
  {
    String bottleId;
    String uin;
    int unreadCnt;
  }
  
  static abstract interface RequestListCallback
  {
    public abstract void onError(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccess();
  }
  
  public static abstract interface UpdateListWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccessInMainThread(BottleListCursor paramBottleListCursor);
  }
  
  public static abstract interface UpdateUnreadStatusWatcher
  {
    public abstract void onSuccessInMainThread(boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController
 * JD-Core Version:    0.7.0.1
 */