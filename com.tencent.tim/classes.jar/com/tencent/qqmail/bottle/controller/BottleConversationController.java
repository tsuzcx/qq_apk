package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.model.BottleConversationCursorAdapterORM;
import com.tencent.qqmail.bottle.model.BottleConversationORM;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableData;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottlerTableData;
import com.tencent.qqmail.bottle.model.table.BottlerTableDataORM;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;

public class BottleConversationController
{
  static final String CONVERSATION_QUERY = "t=bottle_read_app&prefecth=0&mailId=%s&synckey=%s&max=%s&count=%s";
  private static final String TAG = "BottleConversationController";
  private final BottleManager mBottleManager;
  private WatcherArray<ConversationSyncWatcher> mConversationSyncWatcherArray = new WatcherArray(ConversationSyncWatcher.class);
  private WatcherArray<UpdateConversationWatcher> mUpdateConversationWatcherArray = new WatcherArray(UpdateConversationWatcher.class);
  
  BottleConversationController(BottleManager paramBottleManager)
  {
    this.mBottleManager = paramBottleManager;
  }
  
  private int countUnsendSubPost(String[] paramArrayOfString)
  {
    int i = 0;
    int j = 0;
    paramArrayOfString = this.mBottleManager.mDBOpenHelper.getReadableDatabase().rawQuery("SELECT count(*) FROM bottleconv WHERE bottleid=? AND unsend<>0", paramArrayOfString);
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.moveToFirst()) {
        i = paramArrayOfString.getInt(0);
      }
      paramArrayOfString.close();
    }
    return i;
  }
  
  private void invokeUpdateConversationWatcherError(QMNetworkError paramQMNetworkError)
  {
    BottleManager.log("invokeUpdateConversationWatcherError: " + paramQMNetworkError);
    Threads.runOnMainThread(new BottleConversationController.5(this, paramQMNetworkError));
  }
  
  private void invokeUpdateConversationWatcherSuccess(BottleConversationCursor paramBottleConversationCursor)
  {
    Threads.runOnMainThread(new BottleConversationController.4(this, paramBottleConversationCursor));
  }
  
  private boolean isOverdue(BottleConversationCursor paramBottleConversationCursor)
  {
    if ((paramBottleConversationCursor != null) && (BottleThrowController.isUnsendBottleId(paramBottleConversationCursor.bottleId))) {}
    while ((paramBottleConversationCursor != null) && (paramBottleConversationCursor.svnTime != 0L) && (paramBottleConversationCursor.unreadInList <= 0) && (!paramBottleConversationCursor.convOverdue)) {
      return false;
    }
    return true;
  }
  
  private int parseAndWriteToDB(String paramString, JSONObject paramJSONObject)
  {
    String str1 = this.mBottleManager.mBottlerController.getMyUin();
    if (str1 == null) {
      throw new DevRuntimeException("parseAndWriteToDB uin:null");
    }
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    BottleConversationTableData localBottleConversationTableData = new BottleConversationTableData();
    char[] arrayOfChar = new char[256];
    String[] arrayOfString;
    long l1;
    int m;
    int i;
    int i1;
    label220:
    long l2;
    try
    {
      localSQLiteDatabase.beginTransaction();
      arrayOfString = new String[1];
      arrayOfString[0] = paramString;
      k = 0;
      int i2 = 0;
      int j = 0;
      localObject1 = new BottleConversationController_ListBottlerDataCursorAdapterORM(localSQLiteDatabase, " WHERE bottleid=?", arrayOfString);
      if (((BottleConversationController_ListBottlerDataCursorAdapterORM)localObject1).getCount() != 1) {
        break label901;
      }
      localObject2 = ((BottleConversationController_ListBottlerDataCursorAdapterORM)localObject1).getItem(0);
      l1 = ((ListBottlerData)localObject2).time;
      m = ((ListBottlerData)localObject2).unreadCnt;
      i = ((ListBottlerData)localObject2).type;
      j = 1;
      ((BottleConversationController_ListBottlerDataCursorAdapterORM)localObject1).close();
      i1 = j;
      n = i;
      if (j != 0) {
        break label912;
      }
      localObject1 = new BottleConversationController_BeachBottlerDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?", arrayOfString);
      k = j;
      j = i2;
      if (((BottleConversationController_BeachBottlerDataCursorAdapterORM)localObject1).getCount() == 1)
      {
        i = ((BottleConversationController_BeachBottlerDataCursorAdapterORM)localObject1).getItem(0).type;
        j = 1;
        k = 1;
      }
      ((BottleConversationController_BeachBottlerDataCursorAdapterORM)localObject1).close();
      i1 = k;
      k = j;
      n = i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        int n;
        Object localObject3;
        Object localObject4;
        boolean bool;
        Object localObject5;
        String str5;
        String str6;
        String str7;
        paramString.printStackTrace();
        QMLog.log(6, "BottleConversationController", "parseAndWriteToDB error", paramString);
        return -20002;
        QMLog.log(5, "BottleConversationController", "parseAndWriteToDB added null");
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    String str2 = paramJSONObject.getString("mailid");
    String str3 = paramJSONObject.getString("total");
    String str4 = paramJSONObject.getString("svrtime");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("added");
    Object localObject1 = paramJSONObject.getJSONArray("deleted");
    if (localObject1 != null)
    {
      localObject2 = new String[2];
      localObject2[0] = paramString;
      localObject2[1] = null;
      i = 0;
      label288:
      if (i < ((JSONArray)localObject1).size())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject3 == null) {
          break label920;
        }
        localObject2[1] = ((JSONObject)localObject3).getString("msgid");
        localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=? AND msgid=?", (Object[])localObject2);
        break label920;
      }
    }
    localObject4 = paramJSONObject.getJSONObject("user");
    if ((localObject4 != null) && (((JSONObject)localObject4).size() > 0))
    {
      localObject3 = ((JSONObject)localObject4).getString("avatar");
      localObject2 = ((JSONObject)localObject4).getString("name");
      paramJSONObject = ((JSONObject)localObject4).getString("uin");
      localObject1 = ((JSONObject)localObject4).getString("gender");
      localObject4 = ((JSONObject)localObject4).getString("bigAvatar");
      localObject3 = BottleManager.formatAvatarUrl((String)localObject3);
      localObject4 = BottleManager.formatAvatarUrl((String)localObject4);
      bool = "male".equals(localObject1);
      localObject1 = new BottlerTableData();
      ((BottlerTableData)localObject1).setAll(paramJSONObject, (String)localObject3, (String)localObject4, (String)localObject2, false, bool, 0);
      break label927;
      label458:
      if (i < localJSONArray.size())
      {
        localObject5 = localJSONArray.getJSONObject(i);
        str5 = ((JSONObject)localObject5).getString("time");
        localObject2 = ((JSONObject)localObject5).getString("content");
        bool = ((JSONObject)localObject5).getBooleanValue("isMine");
        localObject3 = ((JSONObject)localObject5).getString("msgid");
        localObject4 = ((JSONObject)localObject5).getString("imageUrl");
        localObject5 = ((JSONObject)localObject5).getString("audioUrl");
        l2 = Long.parseLong(str5);
        str5 = this.mBottleManager.processContent(this.mBottleManager.mContext, (String)localObject2, n, (String)localObject3);
        if ((localObject2 == null) || (arrayOfChar.length >= ((String)localObject2).length() * 2)) {
          break label898;
        }
        arrayOfChar = new char[((String)localObject2).length() * 2];
        label593:
        localObject2 = new StringBuilder();
        str6 = this.mBottleManager.processEmoji(str5, (StringBuilder)localObject2, arrayOfChar);
        str7 = ((StringBuilder)localObject2).toString();
        if (!bool) {
          break label946;
        }
      }
    }
    label898:
    label901:
    label912:
    label920:
    label927:
    label944:
    label946:
    for (Object localObject2 = str1;; localObject2 = paramJSONObject)
    {
      localBottleConversationTableData.setAll(str2, (String)localObject3, l2, null, str5, str6, str7, bool, (String)localObject4, (String)localObject5, 0, (String)localObject2);
      BottleConversationTableDataORM.replace(localSQLiteDatabase, localBottleConversationTableData);
      i += 1;
      break label458;
      if (localObject1 != null) {
        BottlerTableDataORM.replace(localSQLiteDatabase, (BottlerTableData)localObject1);
      }
      localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=? AND msgid IS NULL", arrayOfString);
      if (k != 0) {
        throw new DevRuntimeException("parseAndWriteToDB beach");
      }
      for (;;)
      {
        l2 = Long.parseLong(str4);
        i = Integer.parseInt(str3);
        BottleConversationController_BottleListDataORM.update(localSQLiteDatabase, new BottleListData(str2, 0, paramJSONObject));
        BottleConversationController_BottleListExtraDataORM.replace(localSQLiteDatabase, new BottleListExtraData(paramString, i, l2, false, l2));
        if (m > 0)
        {
          this.mBottleManager.mSettings.updateListDBChangedTimeStamp();
          this.mBottleManager.mBottleListController.decBottleUnreadCount(1);
        }
        for (;;)
        {
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          return 0;
          paramString = new BottleConversationController_ConversationDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=? ORDER BY time DESC LIMIT 1", arrayOfString);
          if ((paramString.getCount() == 1) && (l1 != paramString.getItem(0).time)) {
            this.mBottleManager.mSettings.setListOverdue(true);
          }
          paramString.close();
        }
        break label593;
        m = 0;
        l1 = 0L;
        i = 0;
        break;
        if (i1 != 0) {
          break label220;
        }
        break label220;
        i += 1;
        break label288;
        for (;;)
        {
          if (localJSONArray == null) {
            break label944;
          }
          i = 0;
          break;
          localObject1 = null;
          paramJSONObject = str1;
        }
      }
    }
  }
  
  private void requestConversation(String paramString, boolean paramBoolean, BottleConversationCursor paramBottleConversationCursor)
  {
    ValidateHelper.notNullAndNotEmpty(paramString);
    if (BottleThrowController.isUnsendBottleId(paramString)) {
      throw new IllegalArgumentException("thrown bottleid: " + paramString);
    }
    if (this.mBottleManager.mBottlerController.getMyUin() == null)
    {
      QMLog.log(4, "BottleConversationController", "requestConversation uin:null");
      throw new DevRuntimeException("requestConversation uin: null");
    }
    if ((paramBottleConversationCursor == null) || (paramBottleConversationCursor.svnTime == 0L)) {
      paramBottleConversationCursor = String.format("t=bottle_read_app&prefecth=0&mailId=%s&synckey=%s&max=%s&count=%s", new Object[] { paramString, "0", "", "20" });
    }
    for (;;)
    {
      if (paramBoolean) {
        Threads.runOnMainThread(new BottleConversationController.6(this));
      }
      this.mBottleManager.httpGet("bottle_read", paramBottleConversationCursor, new BottleConversationController.7(this, paramString));
      return;
      if (paramBoolean) {
        paramBottleConversationCursor = String.format("t=bottle_read_app&prefecth=0&mailId=%s&synckey=%s&max=%s&count=%s", new Object[] { paramString, String.valueOf(paramBottleConversationCursor.svnTime), "", "" });
      } else if (paramBottleConversationCursor.lastMsgId == null) {
        paramBottleConversationCursor = String.format("t=bottle_read_app&prefecth=0&mailId=%s&synckey=%s&max=%s&count=%s", new Object[] { paramString, String.valueOf(paramBottleConversationCursor.svnTime), "", "" });
      } else {
        paramBottleConversationCursor = String.format("t=bottle_read_app&prefecth=0&mailId=%s&synckey=%s&max=%s&count=%s", new Object[] { paramString, "", paramBottleConversationCursor.lastMsgId, "20" });
      }
    }
  }
  
  void autoLoadMore(String paramString)
  {
    ValidateHelper.notMainThread();
    BottleConversationCursor localBottleConversationCursor = readConversationFromDB(paramString, false);
    if ((localBottleConversationCursor.getCount() < 10) && (localBottleConversationCursor.getCount() < localBottleConversationCursor.totalInConversation) && (localBottleConversationCursor.lastMsgId != null)) {
      requestConversation(paramString, false, localBottleConversationCursor);
    }
    localBottleConversationCursor.close();
  }
  
  public void bindConversationSyncWatcher(ConversationSyncWatcher paramConversationSyncWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mConversationSyncWatcherArray.add(paramConversationSyncWatcher);
      return;
    }
    this.mConversationSyncWatcherArray.remove(paramConversationSyncWatcher);
  }
  
  public void bindUpdateConversationWatcher(UpdateConversationWatcher paramUpdateConversationWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mUpdateConversationWatcherArray.add(paramUpdateConversationWatcher);
      return;
    }
    this.mUpdateConversationWatcherArray.remove(paramUpdateConversationWatcher);
  }
  
  public String getBottleUin(String paramString)
  {
    Object localObject3 = this.mBottleManager.mDBOpenHelper.getReadableDatabase();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    Object localObject4 = this.mBottleManager.mBottlerController.getMyUin();
    Object localObject1;
    Object localObject2;
    if (localObject4 != null)
    {
      localObject1 = ((SQLiteDatabase)localObject3).rawQuery("SELECT DISTINCT uin FROM bottleconv WHERE bottleid=?", arrayOfString);
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToPosition(-1);
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = ((Cursor)localObject1).getString(0);
          if (!((String)localObject4).equals(localObject2)) {
            ((Cursor)localObject1).close();
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject4 = new BottleConversationController_GeneralConversationInfoDataCursorAdapterORM((SQLiteDatabase)localObject3, " FROM bottlelist LEFT JOIN bottlelistextra ON bottlelist.bottleid=bottlelistextra.bottleid WHERE bottlelist.bottleid=?", arrayOfString);
        localObject1 = localObject2;
        if (((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject4).getCount() == 1) {
          localObject1 = ((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject4).getItem(0).uin;
        }
        ((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject4).close();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = ((SQLiteDatabase)localObject3).rawQuery("SELECT DISTINCT uin FROM beachbottle WHERE bottleid=?", arrayOfString);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          if (((Cursor)localObject3).moveToFirst()) {
            localObject1 = ((Cursor)localObject3).getString(0);
          }
          ((Cursor)localObject3).close();
          localObject2 = localObject1;
        }
      }
      BottleManager.log("getBottleUin: " + paramString + ", " + (String)localObject2);
      return localObject2;
      localObject2 = null;
      break;
      localObject2 = null;
    }
  }
  
  int getCountInDB(String paramString)
  {
    int i = 0;
    int j = 0;
    paramString = this.mBottleManager.mDBOpenHelper.getReadableDatabase().rawQuery("SELECT count(*) from bottleconv WHERE bottleid=?", new String[] { paramString });
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    return i;
  }
  
  public String getDraft(String paramString)
  {
    BottleConversationController_DraftDataCursorAdapterORM localBottleConversationController_DraftDataCursorAdapterORM = new BottleConversationController_DraftDataCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "WHERE bottleid=?", new String[] { paramString });
    try
    {
      if (localBottleConversationController_DraftDataCursorAdapterORM.getCount() == 1)
      {
        String str = localBottleConversationController_DraftDataCursorAdapterORM.getItem(0).draft;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        return paramString;
      }
      return "";
    }
    finally
    {
      localBottleConversationController_DraftDataCursorAdapterORM.close();
    }
  }
  
  boolean isTopMessage(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString2 == null) {}
    while ((BottleThrowController.isUnsendBottleId(paramString1)) || (BottleThrowController.isUnsendMsgId(paramString2))) {
      return false;
    }
    paramString1 = new BottleConversationController_QueryFirstMessageCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "WHERE bottleid=? AND unsend=0 ORDER BY time DESC LIMIT 1", new String[] { paramString1 });
    if (paramString1.getCount() == 1) {
      bool = paramString2.equals(paramString1.getItem(0).msgId);
    }
    paramString1.close();
    return bool;
  }
  
  public void loadConversation(String paramString, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleManager.log("loadConversation: " + paramString + ", " + paramBottleConversationCursor);
    Threads.runInBackground(new BottleConversationController.1(this, paramBottleConversationCursor, paramString));
  }
  
  public void loadMore(String paramString, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleManager.log("loadMore: " + paramString + ", " + paramBottleConversationCursor);
    ValidateHelper.notNullAndNotEmpty(paramString);
    ValidateHelper.notNull(paramBottleConversationCursor);
    if (!paramString.equals(paramBottleConversationCursor.bottleId)) {
      throw new IllegalArgumentException("bottleId diff: " + paramString + ", cur:" + paramBottleConversationCursor);
    }
    Threads.runInBackground(new BottleConversationController.2(this, paramBottleConversationCursor, paramString));
  }
  
  BottleConversationCursor readConversationFromDB(String paramString, boolean paramBoolean)
  {
    Object localObject5 = this.mBottleManager.mDBOpenHelper.getReadableDatabase();
    Object localObject6 = new String[1];
    localObject6[0] = paramString;
    long l1 = 0L;
    int j = 0;
    Object localObject1 = null;
    int k = 0;
    int i = 0;
    Object localObject2 = this.mBottleManager.mBottlerController.getMyUin();
    Object localObject7 = new BottleConversationController_GeneralConversationInfoDataCursorAdapterORM((SQLiteDatabase)localObject5, "FROM bottlelist LEFT JOIN bottlelistextra ON bottlelist.bottleid=bottlelistextra.bottleid WHERE bottlelist.bottleid=?", (String[])localObject6);
    Object localObject3;
    int m;
    boolean bool;
    long l2;
    Object localObject4;
    if (((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject7).getCount() == 1)
    {
      localObject1 = ((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject7).getItem(0);
      i = ((GeneralConversationInfoData)localObject1).total;
      l1 = ((GeneralConversationInfoData)localObject1).svnTime;
      localObject3 = ((GeneralConversationInfoData)localObject1).city;
      m = ((GeneralConversationInfoData)localObject1).distance;
      k = ((GeneralConversationInfoData)localObject1).total;
      j = ((GeneralConversationInfoData)localObject1).unread;
      bool = ((GeneralConversationInfoData)localObject1).convOverdue;
      l2 = ((GeneralConversationInfoData)localObject1).dbTimeStamp;
      localObject4 = ((GeneralConversationInfoData)localObject1).uin;
      i = 1;
    }
    for (;;)
    {
      ((BottleConversationController_GeneralConversationInfoDataCursorAdapterORM)localObject7).close();
      if ((!paramBoolean) || (i != 0)) {
        break;
      }
      QMLog.log(4, "BottleConversationController", "readConversationFromDB strict: " + paramString);
      return null;
      localObject3 = new BottleConversationController_GeneralBeachInfoDataCursorAdapterORM((SQLiteDatabase)localObject5, "WHERE bottleid=?", (String[])localObject6);
      if (((BottleConversationController_GeneralBeachInfoDataCursorAdapterORM)localObject3).getCount() == 1)
      {
        localObject2 = ((BottleConversationController_GeneralBeachInfoDataCursorAdapterORM)localObject3).getItem(0);
        localObject2.getClass();
        l1 = 1L;
        localObject1 = ((GeneralBeachInfoData)localObject2).city;
        j = ((GeneralBeachInfoData)localObject2).distance;
        localObject2.getClass();
        k = 1;
        localObject2.getClass();
        localObject2.getClass();
        localObject2.getClass();
        localObject2 = ((GeneralBeachInfoData)localObject2).uin;
        i = 2;
      }
      ((BottleConversationController_GeneralBeachInfoDataCursorAdapterORM)localObject3).close();
      bool = false;
      int n = 0;
      m = j;
      l2 = 0L;
      j = n;
      localObject3 = localObject1;
      localObject4 = localObject2;
    }
    localObject7 = BottleConversationORM.rawQuery((SQLiteDatabase)localObject5, "FROM bottleconv LEFT JOIN bottler ON bottleconv.uin=bottler.uin WHERE bottleid=? ORDER BY time DESC", (String[])localObject6);
    if (localObject7 != null)
    {
      BottleConversation localBottleConversation = new BottleConversation();
      if (((Cursor)localObject7).moveToLast())
      {
        localObject5 = null;
        localObject6 = null;
        do
        {
          do
          {
            BottleConversationORM.fill((Cursor)localObject7, localBottleConversation);
            localObject1 = localObject6;
            if (localObject6 == null)
            {
              localObject1 = localObject6;
              if (!this.mBottleManager.mBottlerController.isMine(localBottleConversation.getUin())) {
                localObject1 = localBottleConversation.getMsgId();
              }
            }
            localObject2 = localObject5;
            if (localObject5 == null)
            {
              localObject2 = localObject5;
              if (!BottleThrowController.isUnsendMsgId(localBottleConversation.getMsgId())) {
                localObject2 = localBottleConversation.getMsgId();
              }
            }
            if (!((Cursor)localObject7).moveToPrevious()) {
              break;
            }
            localObject5 = localObject2;
            localObject6 = localObject1;
          } while (localObject2 == null);
          localObject5 = localObject2;
          localObject6 = localObject1;
        } while (localObject1 == null);
      }
    }
    for (;;)
    {
      paramString = new BottleConversationCursor(paramString, l1, j, k, m, (String)localObject3, (String)localObject2, bool, l2, (String)localObject1, (String)localObject4, new BottleConversationCursorAdapterORM((Cursor)localObject7));
      BottleManager.log("readConversationFromDB: " + paramString);
      return paramString;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public void refreshConversation(String paramString, BottleConversationCursor paramBottleConversationCursor)
  {
    BottleManager.log("refreshConversation: " + paramString + ", " + paramBottleConversationCursor);
    if (paramBottleConversationCursor != null)
    {
      requestConversation(paramString, true, paramBottleConversationCursor);
      return;
    }
    Threads.runInBackground(new BottleConversationController.3(this, paramString));
  }
  
  public void remove(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.remove(paramString, paramOnActionCallback);
  }
  
  public void remove(String paramString1, String paramString2, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.remove(paramString1, paramString2, paramOnActionCallback);
  }
  
  public void setDraft(String paramString1, String paramString2)
  {
    BottleManager.log("setDraft: " + paramString1 + ", draft:" + paramString2);
    Threads.runInBackground(new BottleConversationController.8(this, paramString1, paramString2));
  }
  
  public void spam(String paramString, OnActionCallback paramOnActionCallback)
  {
    this.mBottleManager.spam(paramString, paramOnActionCallback);
  }
  
  static class BeachBottlerData
  {
    String bottleId;
    int type;
    String uin;
  }
  
  static class BottleListData
  {
    String bottleId;
    String uin;
    int unreadCnt;
    
    public BottleListData() {}
    
    public BottleListData(String paramString1, int paramInt, String paramString2)
    {
      this.bottleId = paramString1;
      this.unreadCnt = paramInt;
      this.uin = paramString2;
    }
  }
  
  static class BottleListExtraData
  {
    String bottleId;
    boolean convOverdue;
    long dbTimeStamp;
    long svnTime;
    int total;
    
    public BottleListExtraData() {}
    
    public BottleListExtraData(String paramString, int paramInt, long paramLong1, boolean paramBoolean, long paramLong2)
    {
      this.bottleId = paramString;
      this.total = paramInt;
      this.svnTime = paramLong1;
      this.convOverdue = paramBoolean;
      this.dbTimeStamp = paramLong2;
    }
  }
  
  static class ConversationData
  {
    String bottleId;
    long time;
  }
  
  public static abstract interface ConversationSyncWatcher
  {
    public abstract void onEndInMainThread();
    
    public abstract void onStartInMainThread();
  }
  
  static class ConversationTotalData
  {
    String bottleId;
    int total;
  }
  
  static class DraftData
  {
    String bottleId;
    String draft;
    
    public DraftData() {}
    
    public DraftData(String paramString1, String paramString2)
    {
      this.bottleId = paramString1;
      this.draft = paramString2;
    }
  }
  
  static class GeneralBeachInfoData
  {
    String bottleId;
    String city;
    final boolean convOverdue = false;
    final long dbTimeStamp = 0L;
    int distance;
    long svnTime;
    final int total = 1;
    String uin;
    final int unread = 0;
  }
  
  static class GeneralConversationInfoData
  {
    String bottleId;
    String city;
    boolean convOverdue;
    long dbTimeStamp;
    int distance;
    long svnTime;
    int total;
    String uin;
    int unread;
  }
  
  static class ListBottlerData
  {
    String bottleId;
    long time;
    int type;
    String uin;
    int unreadCnt;
  }
  
  public static class LoadConversationError
    extends QMNetworkError
  {
    public static final int ERROR_BOTTLE_LIST_CODE = -20003;
    public static final int ERROR_CGI_DATA_INVALID_CODE = -20002;
    private static final int ERROR_DEFAULT_CODE = -20000;
    public static final int ERROR_NO_SUCH_BOTTLE_CODE = -20001;
    
    public LoadConversationError(int paramInt)
    {
      super(paramInt);
    }
    
    public LoadConversationError(int paramInt, String paramString)
    {
      super(paramInt, paramString);
    }
  }
  
  static class NickNameData
  {
    String name;
    String uin;
  }
  
  static class QueryFirstMessage
  {
    String bottleId;
    String msgId;
  }
  
  public static abstract interface UpdateConversationWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccessInMainThread(BottleConversationCursor paramBottleConversationCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController
 * JD-Core Version:    0.7.0.1
 */