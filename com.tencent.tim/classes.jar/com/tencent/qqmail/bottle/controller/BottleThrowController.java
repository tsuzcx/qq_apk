package com.tencent.qqmail.bottle.controller;

import android.app.PendingIntent;
import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.model.BottleConversationCursorAdapterORM;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableData;
import com.tencent.qqmail.bottle.model.table.BottleConversationTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottleListExtraTableData;
import com.tencent.qqmail.bottle.model.table.BottleListExtraTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottleListTableData;
import com.tencent.qqmail.bottle.model.table.BottleListTableDataORM;
import com.tencent.qqmail.bottle.model.table.BottleThrowTableData;
import com.tencent.qqmail.bottle.model.table.BottleThrowTableDataORM;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import rx.Observable;

public class BottleThrowController
{
  public static final int CONTENT_CLOSE_LENGTH = 100;
  public static final int CONTENT_MAX_LENGTH = 140;
  public static final int CONTENT_MIN_LENGTH = 5;
  static final String GET_CITY_QUERY = "&t=bottle_getcity_app&mode=getcity&latlng=%s";
  private static final String PREFIX_BOTTLE_ID = "send_bottleid_";
  private static final String PREFIX_MSG_ID = "send_msgid_";
  static final String REPLY_QUERY = "&t=bottle_realtime_app&content=%s&mailId=%s";
  public static final int SEND_TYPE_FAIL = 2;
  public static final int SEND_TYPE_SENDING = 1;
  public static final int SEND_TYPE_SUCCESS = 0;
  private static final String TAG = "BottleThrowController";
  static final String THROW_QUERY = "t=bottle_send_app&content=%s&geo=%s&cityname=%s";
  private static final int THROW_TYPE_BEACH_REPLY = 0;
  private static final int THROW_TYPE_LIST_REPLY = 1;
  private static final int THROW_TYPE_THROW = 2;
  private WatcherArray<BottleLocationWatcher> mBottleLocationWatcherArray = new WatcherArray(BottleLocationWatcher.class);
  private final BottleManager mBottleManager;
  private final QMLocation.LocationListener mLocationListener = new BottleThrowController.5(this);
  private WatcherArray<OnBottleThrowWatcher> mOnBottleThrowWatcherArray = new WatcherArray(OnBottleThrowWatcher.class);
  
  BottleThrowController(BottleManager paramBottleManager)
  {
    this.mBottleManager = paramBottleManager;
  }
  
  private PendingIntent createPendingIntent(String paramString)
  {
    paramString = LaunchWebPush.createBottleFailToThrowIntent(this.mBottleManager.mAccountId, paramString);
    return PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, paramString, 268435456);
  }
  
  static String formatMsgId(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  private static String generateBottleId()
  {
    return "send_bottleid_" + System.currentTimeMillis() + String.valueOf((int)(Math.random() * 10000.0D));
  }
  
  private static String generateMsgId()
  {
    return "send_msgid_" + System.currentTimeMillis() + String.valueOf((int)(Math.random() * 10000.0D));
  }
  
  private void invokeBottleLocationWatcherError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "BottleThrowController", "invokeBottleLocationWatcherError error:" + paramQMNetworkError);
    Threads.runOnMainThread(new BottleThrowController.2(this, paramQMNetworkError));
  }
  
  private void invokeBottleLocationWatcherSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "BottleThrowController", "invokeBottleLocationWatcherSuccess");
    Threads.runOnMainThread(new BottleThrowController.1(this, paramString1, paramString2));
  }
  
  private void invokeBottleThrowWatcherError(String paramString, QMNetworkError paramQMNetworkError, boolean paramBoolean)
  {
    Threads.runOnMainThread(new BottleThrowController.7(this, paramQMNetworkError, this.mBottleManager.mBottleConversationController.readConversationFromDB(paramString, false), paramBoolean, paramString));
  }
  
  private void invokeBottleThrowWatcherSuccess(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getReadableDatabase();
    Object localObject2 = new StringBuilder().append("FROM bottleconv LEFT JOIN bottler ON bottleconv.uin=bottler.uin WHERE bottleid=?");
    Object localObject1;
    if (paramString2 == null)
    {
      localObject1 = "";
      localObject2 = (String)localObject1;
      if (paramString2 != null) {
        break label144;
      }
      paramString2 = new String[1];
      paramString2[0] = paramString1;
      label61:
      localObject1 = new BottleConversationCursorAdapterORM(localSQLiteDatabase, (String)localObject2, paramString2);
      paramString2 = null;
      if (((BottleConversationCursorAdapterORM)localObject1).getCount() != 1) {
        break label166;
      }
      paramString2 = ((BottleConversationCursorAdapterORM)localObject1).getItem(0);
    }
    for (;;)
    {
      ((BottleConversationCursorAdapterORM)localObject1).close();
      if (paramString2 != null) {
        Threads.runOnMainThread(new BottleThrowController.6(this, paramBoolean1, paramString2, this.mBottleManager.mBottleConversationController.readConversationFromDB(paramString1, false)));
      }
      sendBottleSuccessNotification(paramBoolean1, paramString1, paramBoolean2);
      return;
      localObject1 = " AND msgid=?";
      break;
      label144:
      localObject1 = new String[2];
      localObject1[0] = paramString1;
      localObject1[1] = paramString2;
      paramString2 = (String)localObject1;
      break label61;
      label166:
      QMLog.log(6, "BottleThrowController", "invokeBottleThrowWatcherSuccess adapterORM count:" + ((BottleConversationCursorAdapterORM)localObject1).getCount());
    }
  }
  
  static boolean isUnsendBottleId(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("send_bottleid_"));
  }
  
  static boolean isUnsendMsgId(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("send_msgid_"));
  }
  
  private void logThrowDetailEvent(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    String str;
    switch (paramInt1)
    {
    case 1: 
    default: 
      str = "DetailEvent_Bottle_Reply";
    }
    for (;;)
    {
      this.mBottleManager.logDetailEvent(str, paramInt2, String.format("len:%d,geo:%s,time:%d", new Object[] { Integer.valueOf(paramString1.length()), paramString2, Long.valueOf(System.currentTimeMillis() - paramLong) }));
      return;
      str = "DetailEvent_Bottle_Throw";
      continue;
      str = "DetailEvent_Bottle_Beach_Reply";
    }
  }
  
  private int parseSendResponseAndWriteToDB(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, JSONObject paramJSONObject)
  {
    ValidateHelper.notNullAndNotEmpty(paramString1);
    ValidateHelper.notNullAndNotEmpty(paramString2);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString1;
    localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getWritableDatabase();
    j = 0;
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        localObject = paramJSONObject.getString("error");
        paramJSONObject = paramJSONObject.getString("updatetime");
        i = Integer.parseInt((String)localObject);
        if ((i == 0) || (i == 1) || (i == 2)) {
          continue;
        }
        BottleThrowController_ConversationUnreadDataORM.update(localSQLiteDatabase, new ConversationUnreadData(paramString1, paramString3, 2));
        i = -20003;
      }
      catch (Exception paramString1)
      {
        Object localObject;
        long l;
        QMLog.log(6, "BottleThrowController", "parseSendResponseAndWriteToDB error: ", paramString1);
        BottleManager.log(paramString1);
        return -20001;
        int i = j;
        if (paramString3.equals(paramString4)) {
          continue;
        }
        localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=? AND msgid=?", new String[] { paramString1, paramString3 });
        i = j;
        continue;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      this.mBottleManager.mSettings.setListOverdue(true);
      if ((i == 0) || (i == -20004)) {
        BottleThrowController_BottleListOverdueDataORM.update(localSQLiteDatabase, new BottleListOverdueData(paramString2, true));
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      if (!paramString1.equals(paramString2)) {
        this.mBottleManager.mBottleListController.willRefreshList();
      }
      return i;
      l = Long.parseLong(paramJSONObject);
      paramJSONObject = this.mBottleManager.mBottlerController.getMyUin();
      localObject = new BottleConversationTableData();
      ((BottleConversationTableData)localObject).setAll(paramString2, paramString4, l, null, paramString5, null, "", true, "", "", 0, paramJSONObject);
      BottleConversationTableDataORM.replace(localSQLiteDatabase, (BottleConversationTableData)localObject);
      if (paramString1.equals(paramString2)) {
        continue;
      }
      localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=? AND msgid=?", new String[] { paramString1, paramString3 });
      localSQLiteDatabase.execSQL("UPDATE bottleconv SET bottleid=? WHERE bottleid=?", new String[] { paramString2, paramString1 });
      paramString3 = null;
      paramString4 = new BottleThrowController_BottleListAllDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?", arrayOfString);
      if (paramString4.getCount() == 1) {
        paramString3 = paramString4.getItem(0);
      }
      paramString4.close();
      if (paramString3 != null)
      {
        paramString3.bottleid = paramString2;
        BottleThrowController_BottleListAllDataORM.replace(localSQLiteDatabase, paramString3);
      }
      paramString3 = null;
      paramString4 = new BottleThrowController_BottleListExtraAllDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?", arrayOfString);
      if (paramString4.getCount() == 1) {
        paramString3 = paramString4.getItem(0);
      }
      paramString4.close();
      if (paramString3 != null)
      {
        paramString3.bottleid = paramString2;
        BottleThrowController_BottleListExtraAllDataORM.replace(localSQLiteDatabase, paramString3);
      }
      localSQLiteDatabase.execSQL("DELETE FROM bottlelist WHERE bottleid=?", arrayOfString);
      localSQLiteDatabase.execSQL("DELETE FROM bottlelistextra WHERE bottleid=?", arrayOfString);
      localSQLiteDatabase.execSQL("DELETE FROM beachbottle WHERE bottleid=?", arrayOfString);
      i = j;
    }
  }
  
  private void requestLocality()
  {
    this.mBottleManager.getCoordinateObservable().subscribe(new BottleThrowController.3(this));
  }
  
  private void requestLocality(BottleManager.Coordinate paramCoordinate)
  {
    BottleManager.log("requestLocality: " + paramCoordinate);
    if (paramCoordinate == null)
    {
      invokeBottleLocationWatcherError(new LocationError(-20001));
      return;
    }
    String str = this.mBottleManager.mSettings.getLocality(paramCoordinate.lat, paramCoordinate.lng);
    BottleManager.log("requestLocality: locality: " + str);
    if (str != null)
    {
      invokeBottleLocationWatcherSuccess(paramCoordinate.toString(), str);
      return;
    }
    str = String.format("&t=bottle_getcity_app&mode=getcity&latlng=%s", new Object[] { paramCoordinate.toString() });
    this.mBottleManager.httpGet("bottle_setting", str, new BottleThrowController.4(this, paramCoordinate));
  }
  
  private void sendBottleSuccessNotification(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = QMApplicationContext.sharedInstance();
    int i;
    if (paramBoolean2) {
      if (paramBoolean1) {
        i = 2131691000;
      }
    }
    for (;;)
    {
      localObject = ((Context)localObject).getString(i);
      paramString = createPendingIntent(paramString);
      QMNotificationConstructor.getInstance().notifySendBottle((String)localObject, (String)localObject, "", 2130840992, paramString, true);
      return;
      i = 2131690997;
      continue;
      if (paramBoolean1) {
        i = 2131690990;
      } else {
        i = 2131690989;
      }
    }
  }
  
  private void sendBottleToCGI(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ValidateHelper.notNullAndNotEmpty(paramString1);
    int i = 1;
    Object localObject = new BottleThrowController_ThrowTypeDataCursorAdapterORM(this.mBottleManager.mDBOpenHelper.getReadableDatabase(), "WHERE bottleid=?", new String[] { paramString1 });
    if (((BottleThrowController_ThrowTypeDataCursorAdapterORM)localObject).getCount() == 1) {
      i = ((BottleThrowController_ThrowTypeDataCursorAdapterORM)localObject).getItem(0).throwType;
    }
    ((BottleThrowController_ThrowTypeDataCursorAdapterORM)localObject).close();
    String str;
    if (isUnsendBottleId(paramString1))
    {
      str = StringExtention.encodeURI(paramString3);
      if (paramString4 == null)
      {
        localObject = "";
        if (paramString5 != null) {
          break label164;
        }
        paramString5 = "";
      }
    }
    label95:
    for (paramString5 = String.format("t=bottle_send_app&content=%s&geo=%s&cityname=%s", new Object[] { str, localObject, paramString5 });; paramString5 = String.format("&t=bottle_realtime_app&content=%s&mailId=%s", new Object[] { StringExtention.encodeURI(paramString3), paramString1 }))
    {
      long l = System.currentTimeMillis();
      this.mBottleManager.httpPost("bottle_send", paramString5, new BottleThrowController.10(this, i, paramString3, paramString4, l, paramString1, paramString2));
      return;
      localObject = paramString4;
      break;
      paramString5 = StringExtention.encodeURI(paramString5);
      break label95;
    }
  }
  
  private String writeSendContentToDB(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    BottleManager.log("writeSendContentToDB: " + paramString1 + ", " + paramString2 + ", geo:" + paramString3 + ", city:" + paramString4);
    String str1 = this.mBottleManager.mBottlerController.getMyUin();
    String str2 = generateMsgId();
    long l1 = System.currentTimeMillis() / 1000L;
    SQLiteDatabase localSQLiteDatabase = this.mBottleManager.mDBOpenHelper.getReadableDatabase();
    Object localObject1 = new String[1];
    localObject1[0] = paramString1;
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        Object localObject2 = new BottleThrowController_ConversationDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?ORDER BY time DESC LIMIT 1", (String[])localObject1);
        if (((BottleThrowController_ConversationDataCursorAdapterORM)localObject2).getCount() != 1) {
          break label556;
        }
        l1 = ((BottleThrowController_ConversationDataCursorAdapterORM)localObject2).getItem(0).time + 1L;
        ((BottleThrowController_ConversationDataCursorAdapterORM)localObject2).close();
        if (isUnsendBottleId(paramString1))
        {
          i = 2;
          localObject2 = new BottleThrowTableData();
          ((BottleThrowTableData)localObject2).setAll(paramString1, paramString3, paramString4, i);
          BottleThrowTableDataORM.replace(localSQLiteDatabase, (BottleThrowTableData)localObject2);
          if (isUnsendBottleId(paramString1))
          {
            if (paramString2.length() <= 20) {
              break label565;
            }
            paramString4 = paramString2.substring(0, 20);
            long l2 = System.currentTimeMillis() / 1000L;
            localObject1 = new BottleListTableData();
            ((BottleListTableData)localObject1).setAll(paramString1, 0, paramString4, null, "", l2, 30, paramString3, null, -1, true, str1);
            BottleListTableDataORM.replace(localSQLiteDatabase, (BottleListTableData)localObject1);
            paramString3 = new BottleListExtraTableData();
            paramString3.setAll(paramString1, 1, 1L, false, 0);
            BottleListExtraTableDataORM.replace(localSQLiteDatabase, paramString3);
            paramString3 = new BottleConversationTableData();
            paramString3.setAll(paramString1, str2, l1, null, paramString2, null, "", true, "", "", 1, str1);
            BottleConversationTableDataORM.replace(localSQLiteDatabase, paramString3);
            this.mBottleManager.mSettings.updateListDBChangedTimeStamp();
            localSQLiteDatabase.setTransactionSuccessful();
            return str2;
          }
        }
        else
        {
          if (!this.mBottleManager.mBottleBeachController.isBeachBottle((String[])localObject1)) {
            break label559;
          }
          i = 0;
          continue;
        }
        if (!this.mBottleManager.mBottleBeachController.isBeachBottle((String[])localObject1)) {
          continue;
        }
        paramString3 = new BottleThrowController_BottleBeachDataCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?", (String[])localObject1);
        paramString4 = paramString3.getItem(0);
        paramString3.close();
        localObject2 = new BottleListTableData();
        if (paramString4.content.length() > 20)
        {
          paramString3 = paramString4.content.substring(0, 20);
          ((BottleListTableData)localObject2).setAll(paramString4.bottleid, 0, paramString3, null, "", paramString4.time, paramString4.type, paramString4.geo, paramString4.city, paramString4.distance, true, paramString4.uin);
          BottleListTableDataORM.replace(localSQLiteDatabase, (BottleListTableData)localObject2);
          paramString3 = new BottleListExtraTableData();
          paramString3.setAll(paramString4.bottleid, 1, 0, false, 0);
          BottleListExtraTableDataORM.replace(localSQLiteDatabase, paramString3);
          localSQLiteDatabase.execSQL("DELETE FROM beachbottle WHERE bottleid=?", (Object[])localObject1);
          continue;
        }
        paramString3 = paramString4.content;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      continue;
      label556:
      continue;
      label559:
      int i = 1;
      continue;
      label565:
      paramString4 = paramString2;
    }
  }
  
  public void abortLoadLocality()
  {
    this.mBottleManager.mLocation.removeLocationUpdates();
  }
  
  public void bindLocationWatch(BottleLocationWatcher paramBottleLocationWatcher, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBottleLocationWatcherArray.add(paramBottleLocationWatcher);
      return;
    }
    this.mBottleLocationWatcherArray.remove(paramBottleLocationWatcher);
  }
  
  public void bindOnBottleThrowWatcher(OnBottleThrowWatcher paramOnBottleThrowWatcher, boolean paramBoolean)
  {
    
    if (paramBoolean)
    {
      this.mOnBottleThrowWatcherArray.add(paramOnBottleThrowWatcher);
      return;
    }
    this.mOnBottleThrowWatcherArray.remove(paramOnBottleThrowWatcher);
  }
  
  public boolean isOpenedLBS()
  {
    return this.mBottleManager.mSettings.isOpenedLBS();
  }
  
  public void loadLocality(boolean paramBoolean)
  {
    int i = this.mBottleManager.mLocation.getProvider();
    BottleManager.log("loadLocality: " + paramBoolean + ", provider: " + i);
    if (i == 0)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mBottleManager.mSettings.getLastRequestToOpenLBSTime();
      if ((paramBoolean) || (l1 - l2 > 259200000L))
      {
        this.mBottleManager.mSettings.updateLastRequestToOpenLBSTime();
        invokeBottleLocationWatcherError(new LocationError(-20002));
        return;
      }
      invokeBottleLocationWatcherError(new LocationError(-20001));
      return;
    }
    this.mBottleManager.mLocation.setLocationListener(this.mLocationListener);
    this.mBottleManager.mLocation.requestLocationUpdates();
  }
  
  public void replyBottle(String paramString1, String paramString2)
  {
    sendBottle(paramString1, paramString2, null, null);
  }
  
  public void resendBottle(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("bottleId:" + paramString1 + ", msgId:" + paramString2);
    }
    Threads.runInBackground(new BottleThrowController.8(this, paramString1, paramString2));
  }
  
  public void sendBottle(String paramString1, String paramString2, String paramString3)
  {
    String str = generateBottleId();
    paramString1 = paramString1.trim();
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.length() < 5))
    {
      invokeBottleThrowWatcherError(str, new BottleThrowError(-20005), false);
      return;
    }
    sendBottle(str, paramString1, paramString2, paramString3);
  }
  
  void sendBottle(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QMLog.log(4, "BottleThrowController", "sendBottle: bottleId: " + paramString1 + ", content: " + paramString2 + ", geo:" + paramString3 + ", cityName:" + paramString4);
    ValidateHelper.notNullAndNotEmpty(paramString1);
    ValidateHelper.notNullAndNotEmpty(paramString2);
    Threads.runInBackground(new BottleThrowController.9(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public void setOpenedLBS(boolean paramBoolean)
  {
    this.mBottleManager.mSettings.setOpenedLBS(paramBoolean);
  }
  
  static class BottleBeachData
  {
    String bottleid;
    String city;
    String content;
    String contentheader;
    long convsvrtime;
    String displaycontent;
    int distance;
    String emoji;
    String geo;
    String imageurl;
    int number;
    String subject;
    long time;
    int type;
    String uin;
  }
  
  static class BottleListAllData
  {
    String bottleid;
    String city;
    String displaysummary;
    int distance;
    String emoji;
    String geo;
    boolean isMine;
    String summary;
    long time;
    int type;
    String uin;
    int unreadCnt;
  }
  
  static class BottleListExtraAllData
  {
    String bottleid;
    long convdbtimestamp;
    boolean convoverdue;
    long convsvrtime;
    int total;
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
  
  public static abstract interface BottleLocationWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError);
    
    public abstract void onSuccessInMainThread(String paramString1, String paramString2);
  }
  
  public static class BottleThrowError
    extends QMNetworkError
  {
    public static final int ERROR_CANNOT_RECEIVE_CODE = -20004;
    public static final int ERROR_CONTENT_INVALID_CODE = -20005;
    public static final int ERROR_DATA_CODE = -20001;
    private static final int ERROR_DEFAULT_CODE = -20000;
    public static final int ERROR_LOGIC_CODE = -20003;
    public static final int ERROR_NO_SUCH_BOTTLE_CODE = -20006;
    public static final int ERROR_USED_UP_CODE = -20002;
    
    public BottleThrowError(int paramInt)
    {
      super(paramInt);
    }
  }
  
  static class ConversationData
  {
    String bottleId;
    long time;
  }
  
  static class ConversationUnreadData
  {
    String bottleId;
    String msgId;
    int unread;
    
    public ConversationUnreadData() {}
    
    public ConversationUnreadData(String paramString1, String paramString2, int paramInt)
    {
      this.bottleId = paramString1;
      this.msgId = paramString2;
      this.unread = paramInt;
    }
  }
  
  public static class LocationError
    extends QMNetworkError
  {
    private static final int ERROR_DEFAULT_CODE = -20000;
    public static final int ERROR_LOCATION_CODE = -20003;
    public static final int ERROR_LOGIC_CODE = -20001;
    public static final int ERROR_NO_PERMISSION_CODE = -20002;
    
    public LocationError(int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static abstract interface OnBottleThrowWatcher
  {
    public abstract void onErrorInMainThread(QMNetworkError paramQMNetworkError, BottleConversationCursor paramBottleConversationCursor);
    
    public abstract void onSuccessInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor);
    
    public abstract void onSuccessToWriteDBInMainThread(BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor);
  }
  
  static class ThrowTypeData
  {
    String bottleId;
    int throwType;
  }
  
  static class UnsendConversationData
  {
    String bottleId;
    String city;
    String content;
    String geo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController
 * JD-Core Version:    0.7.0.1
 */