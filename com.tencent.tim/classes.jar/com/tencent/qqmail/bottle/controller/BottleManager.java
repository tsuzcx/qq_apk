package com.tencent.qqmail.bottle.controller;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.view.VerticalCenterImageSpan;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Observer;

public class BottleManager
{
  private static final String BATCH_REMOVE_QUERY = "t=bottle_error_app&cmd=del";
  public static final boolean DEBUG = false;
  private static final boolean DEBUG_CGI = false;
  private static final int[] DEFAULT_BOTTLE_AVATAR_LARGE = { 2130838952, 2130838955, 2130838958, 2130838961, 2130838964 };
  private static final int[] DEFAULT_BOTTLE_AVATAR_MIDDLE;
  private static final int[] DEFAULT_BOTTLE_AVATAR_SMALL;
  private static final String ERROR_JSON = "&ef=js";
  private static final String PARAM_LIST_MAILID = "&mailid=$mailid$";
  private static final String PARAM_MAILID = "mailid";
  private static final String PLATFORM = "&plpfrom=mailapp&plaform=android";
  private static final String REMOVE_MSG_QUERY = "cmd=delsession&t=bottle_error_app&mailid=%s&msgid=%s";
  private static final String REMOVE_QUERY = "t=bottle_error_app&cmd=del&mailid=%s";
  private static final String SPAM_QUERY = "&mailid=%s&s=readmail_spam&Fun=Del&isspam=true&mailaction=mail_spam&resp_charset=UTF8&t=bottle_error_app";
  private static final String TAG = "BottleManager";
  private static final boolean USE_QMLOG_TO_DEBUG = true;
  private static volatile BottleManager sInstance = null;
  final int mAccountId;
  final BottleBeachController mBottleBeachController;
  final BottleConversationController mBottleConversationController;
  final BottleListController mBottleListController;
  final BottleThrowController mBottleThrowController;
  final BottlerController mBottlerController;
  final Context mContext;
  final BottleSQLiteOpenHelper mDBOpenHelper;
  final QMLocation mLocation;
  final BottleSettings mSettings;
  private String[][] sortedEmoji = (String[][])null;
  
  static
  {
    DEFAULT_BOTTLE_AVATAR_SMALL = new int[] { 2130838954, 2130838957, 2130838960, 2130838963, 2130838966 };
    DEFAULT_BOTTLE_AVATAR_MIDDLE = new int[] { 2130838953, 2130838956, 2130838959, 2130838962, 2130838965 };
  }
  
  BottleManager(Context paramContext, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    this.mAccountId = paramInt;
    this.mDBOpenHelper = new BottleSQLiteOpenHelper(paramContext, paramInt, paramCursorFactory);
    this.mSettings = new BottleSettings(paramContext, this.mAccountId);
    this.mLocation = new QMLocation(paramContext);
    this.mContext = paramContext;
    this.mBottleBeachController = new BottleBeachController(this);
    this.mBottleListController = new BottleListController(this);
    this.mBottleConversationController = new BottleConversationController(this);
    this.mBottleThrowController = new BottleThrowController(this);
    this.mBottlerController = new BottlerController(this);
    initInBackground();
    QMNotification.registNotification("receivePushBottle", new PushObserver(this));
  }
  
  public static boolean available()
  {
    return QMSettingManager.sharedInstance().getDefaultBottleAccountID() != -1;
  }
  
  private static int binarySearchEmoji(String[][] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfString.length - 1;
    int j = 0;
    if (j <= i)
    {
      int n = j + i >>> 1;
      int i1 = paramArrayOfString[n][0].length();
      int k = 0;
      int m = 0;
      while ((k < i1) && (m == 0))
      {
        int i2 = k + paramInt1;
        if (i2 < paramInt2) {
          m = paramArrayOfString[n][0].charAt(k) - paramString.charAt(i2);
        }
        k += 1;
      }
      if (m < 0) {
        j = n + 1;
      }
      for (;;)
      {
        break;
        if (m <= 0) {
          break label123;
        }
        i = n - 1;
      }
      label123:
      return n;
    }
    return j ^ 0xFFFFFFFF;
  }
  
  private static int calculateBottleAvatarIndex(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    int j = 0;
    while (i < paramString.length())
    {
      j += paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  public static void dumpCGI(String paramString) {}
  
  static boolean equalsCoordinate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    boolean bool;
    Locale localLocale;
    if ((Math.abs(paramDouble1 - paramDouble3) < 0.01D) && (Math.abs(paramDouble2 - paramDouble4) < 0.01D))
    {
      bool = true;
      localLocale = Locale.getDefault();
      if (!bool) {
        break label108;
      }
    }
    label108:
    for (int i = 1;; i = 0)
    {
      QMLog.log(2, "BottleManager", String.format(localLocale, "equalsCoordinate: (%.4f,%.4f),(%.4f,%.4f), %d", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3), Double.valueOf(paramDouble4), Integer.valueOf(i) }));
      return bool;
      bool = false;
      break;
    }
  }
  
  static String formatAvatarUrl(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.startsWith("/cgi-bin/")) {
      return QMNetworkConfig.getCgiRequestHost(0) + paramString;
    }
    return "http://" + paramString;
  }
  
  public static String formatNickName(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return QMApplicationContext.sharedInstance().getString(2131690955);
  }
  
  static int generateResponseNotificationId(String paramString)
  {
    return Math.abs(paramString.hashCode());
  }
  
  @Nullable
  private Coordinate getCoordinate(Location paramLocation)
  {
    double d1 = this.mSettings.getLat();
    double d2 = this.mSettings.getLng();
    if (paramLocation != null)
    {
      double d3 = paramLocation.getLatitude();
      double d4 = paramLocation.getLongitude();
      if ((!this.mSettings.validLatLng(d1, d2)) || (!equalsCoordinate(d1, d2, d3, d4))) {
        this.mSettings.setCoordinate(d3, d4);
      }
      return new Coordinate(d3, d4);
    }
    if (this.mSettings.validLatLng(d1, d2)) {
      return new Coordinate(d1, d2);
    }
    return null;
  }
  
  private static int getDefaultBottleAvatar(String paramString, int paramInt)
  {
    int i = calculateBottleAvatarIndex(paramString);
    switch (paramInt)
    {
    default: 
      return DEFAULT_BOTTLE_AVATAR_LARGE[(i % DEFAULT_BOTTLE_AVATAR_LARGE.length)];
    case 0: 
      return DEFAULT_BOTTLE_AVATAR_SMALL[(i % DEFAULT_BOTTLE_AVATAR_SMALL.length)];
    }
    return DEFAULT_BOTTLE_AVATAR_MIDDLE[(i % DEFAULT_BOTTLE_AVATAR_MIDDLE.length)];
  }
  
  private String getEmojiUrl(int paramInt)
  {
    if (paramInt < 10) {
      return "http://rescdn.qqmail.com/plpemotion/h00" + paramInt + ".png";
    }
    if (paramInt < 100) {
      return "http://rescdn.qqmail.com/plpemotion/h0" + paramInt + ".png";
    }
    return "http://rescdn.qqmail.com/plpemotion/h" + paramInt + ".png";
  }
  
  @Nullable
  public static BottleManager getInstance()
  {
    int i = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    if (i == -1)
    {
      log("BottleManager.getInstance null");
      return null;
    }
    if (sInstance == null) {}
    for (;;)
    {
      try
      {
        if (sInstance == null) {
          sInstance = new BottleManager(QMApplicationContext.sharedInstance(), i, null);
        }
        return sInstance;
      }
      finally {}
      if (sInstance.mAccountId == i) {
        continue;
      }
      try
      {
        if (sInstance.mAccountId != i) {
          sInstance = new BottleManager(QMApplicationContext.sharedInstance(), i, null);
        }
      }
      finally {}
    }
  }
  
  private void initEmoji()
  {
    if (this.sortedEmoji == null)
    {
      String[] arrayOfString1 = { "NO", "81" };
      String[] arrayOfString2 = { "OK", "82" };
      String[] arrayOfString3 = { "乒乓", "103" };
      String[] arrayOfString4 = { "亲亲", "31" };
      String[] arrayOfString5 = { "偷笑", "8" };
      String[] arrayOfString6 = { "傲慢", "11" };
      String[] arrayOfString7 = { "再见", "25" };
      String[] arrayOfString8 = { "冷汗", "5" };
      String[] arrayOfString9 = { "凋谢", "68" };
      String[] arrayOfString10 = { "发呆", "15" };
      String[] arrayOfString11 = { "发怒", "22" };
      String[] arrayOfString12 = { "发抖", "86" };
      String[] arrayOfString13 = { "可怜", "42" };
      String[] arrayOfString14 = { "可爱", "9" };
      String[] arrayOfString15 = { "右哼哼", "36" };
      String[] arrayOfString16 = { "右太极", "97" };
      String[] arrayOfString17 = { "吐", "7" };
      String[] arrayOfString18 = { "吓", "51" };
      String[] arrayOfString19 = { "咒骂", "44" };
      String[] arrayOfString20 = { "哈欠", "49" };
      String[] arrayOfString21 = { "啤酒", "100" };
      String[] arrayOfString22 = { "回头", "90" };
      String[] arrayOfString23 = { "坏笑", "38" };
      String[] arrayOfString24 = { "大兵", "41" };
      String[] arrayOfString25 = { "大哭", "17" };
      String[] arrayOfString26 = { "太阳", "70" };
      String[] arrayOfString27 = { "委屈", "28" };
      String[] arrayOfString28 = { "尴尬", "21" };
      String[] arrayOfString29 = { "左哼哼", "48" };
      String[] arrayOfString30 = { "左太极", "96" };
      String[] arrayOfString31 = { "差劲", "79" };
      String[] arrayOfString32 = { "弱", "73" };
      String[] arrayOfString33 = { "强", "72" };
      String[] arrayOfString34 = { "得意", "16" };
      String[] arrayOfString35 = { "微笑", "12" };
      String[] arrayOfString36 = { "心碎", "56" };
      String[] arrayOfString37 = { "快哭了", "50" };
      String[] arrayOfString38 = { "怄火", "87" };
      String[] arrayOfString39 = { "惊恐", "53" };
      String[] arrayOfString40 = { "惊讶", "2" };
      String[] arrayOfString41 = { "折磨", "104" };
      String[] arrayOfString42 = { "抠鼻", "45" };
      String[] arrayOfString43 = { "拥抱", "37" };
      String[] arrayOfString44 = { "挥手", "92" };
      String[] arrayOfString45 = { "握手", "74" };
      String[] arrayOfString46 = { "撇嘴", "13" };
      String[] arrayOfString47 = { "擦汗", "27" };
      String[] arrayOfString48 = { "敲打", "26" };
      String[] arrayOfString49 = { "晕", "40" };
      String[] arrayOfString50 = { "流汗", "24" };
      String[] arrayOfString51 = { "流泪", "23" };
      String[] arrayOfString52 = { "炸弹", "59" };
      String[] arrayOfString53 = { "爱你", "80" };
      String[] arrayOfString54 = { "爱心", "55" };
      String[] arrayOfString55 = { "玫瑰", "67" };
      String[] arrayOfString56 = { "瓢虫", "62" };
      String[] arrayOfString57 = { "疑问", "29" };
      String[] arrayOfString58 = { "白眼", "10" };
      String[] arrayOfString59 = { "睡", "30" };
      String[] arrayOfString60 = { "礼物", "71" };
      String[] arrayOfString61 = { "糗大了", "47" };
      String[] arrayOfString62 = { "胜利", "75" };
      String[] arrayOfString63 = { "菜刀", "98" };
      String[] arrayOfString64 = { "蛋糕", "57" };
      String[] arrayOfString65 = { "街舞", "94" };
      String[] arrayOfString66 = { "衰", "33" };
      String[] arrayOfString67 = { "西瓜", "99" };
      String[] arrayOfString68 = { "足球", "61" };
      String[] arrayOfString69 = { "跳绳", "91" };
      String[] arrayOfString70 = { "跳跳", "85" };
      String[] arrayOfString71 = { "转圈", "88" };
      String[] arrayOfString72 = { "酷", "4" };
      String[] arrayOfString73 = { "闭嘴", "52" };
      String[] arrayOfString74 = { "难过", "3" };
      String[] arrayOfString75 = { "饥饿", "43" };
      String[] arrayOfString76 = { "骷髅", "101" };
      String[] arrayOfString77 = { "鼓掌", "46" };
      this.sortedEmoji = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, { "便便", "63" }, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, { "刀", "60" }, { "勾引", "77" }, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, { "呲牙", "1" }, arrayOfString19, { "咖啡", "64" }, arrayOfString20, arrayOfString21, { "嘘", "19" }, arrayOfString22, { "困", "20" }, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, { "奋斗", "35" }, arrayOfString27, { "害羞", "18" }, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, { "憨笑", "32" }, { "抓狂", "6" }, arrayOfString41, arrayOfString42, { "抱拳", "76" }, arrayOfString43, { "拳头", "78" }, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, { "月亮", "69" }, arrayOfString50, arrayOfString51, { "激动", "93" }, arrayOfString52, arrayOfString53, arrayOfString54, { "爱情", "83" }, { "猪头", "66" }, { "献吻", "95" }, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, { "磕头", "89" }, { "示爱", "54" }, arrayOfString60, { "篮球", "102" }, arrayOfString61, arrayOfString62, { "色", "14" }, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, { "调皮", "0" }, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, { "鄙视", "39" }, arrayOfString72, { "闪电", "58" }, arrayOfString73, { "阴险", "34" }, arrayOfString74, { "飞吻", "84" }, arrayOfString75, { "饭", "65" }, arrayOfString76, arrayOfString77 };
    }
  }
  
  private void initInBackground()
  {
    Threads.runInBackground(new BottleManager.1(this));
  }
  
  public static void log(String paramString)
  {
    QMLog.log(2, "BottleManager_debug", paramString);
  }
  
  public static void log(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    QMLog.log(6, "BottleManager_error", localStringWriter.toString());
    paramThrowable.printStackTrace();
  }
  
  private int removeSubPost(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString2 == null)
    {
      QMLog.log(6, "BottleManager", "msgId is null!");
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.mDBOpenHelper.getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      localSQLiteDatabase.execSQL("DELETE FROM bottleconv WHERE bottleid=? AND msgid=?", new String[] { paramString1, paramString2 });
      BottleManager_UpdateConversationTotalCursorAdapterORM localBottleManager_UpdateConversationTotalCursorAdapterORM = new BottleManager_UpdateConversationTotalCursorAdapterORM(localSQLiteDatabase, "WHERE bottleid=?", new String[] { paramString1 });
      if (localBottleManager_UpdateConversationTotalCursorAdapterORM.getCount() == 1) {
        i = localBottleManager_UpdateConversationTotalCursorAdapterORM.getItem(0).total;
      }
      localBottleManager_UpdateConversationTotalCursorAdapterORM.close();
      int j = i;
      if (!BottleThrowController.isUnsendMsgId(paramString2))
      {
        j = i;
        if (i > 0)
        {
          j = i - 1;
          BottleManager_UpdateConversationTotalORM.update(localSQLiteDatabase, new UpdateConversationTotal(paramString1, j));
        }
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return j;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public void clearResponseNotify(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      QMNotificationConstructor.getInstance().clearPushBottleNotify(generateResponseNotificationId(paramString));
    }
  }
  
  public BottleBeachController getBottleBeachController()
  {
    return this.mBottleBeachController;
  }
  
  public BottleConversationController getBottleConversationController()
  {
    return this.mBottleConversationController;
  }
  
  public BottleListController getBottleListController()
  {
    return this.mBottleListController;
  }
  
  public BottleThrowController getBottleThrowController()
  {
    return this.mBottleThrowController;
  }
  
  public BottlerController getBottlerController()
  {
    return this.mBottlerController;
  }
  
  rx.Observable<Coordinate> getCoordinateObservable()
  {
    return this.mLocation.getLastKnownLocationObservable().flatMap(new BottleManager.2(this));
  }
  
  public Bitmap getDefalAvatar(String paramString, int paramInt)
  {
    int i = getDefaultBottleAvatar(paramString, paramInt);
    paramString = i + "" + paramInt;
    Bitmap localBitmap = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    localBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), i);
    QMAvatar localQMAvatar = new QMAvatar(paramInt);
    localQMAvatar.setAvatar(localBitmap);
    localBitmap = localQMAvatar.getBitmap();
    ImageDownloadManager.shareInstance().addMemoryCache(paramString, localBitmap);
    return localBitmap;
  }
  
  QMNetworkRequest httpGet(String paramString1, String paramString2, QMCallback paramQMCallback)
  {
    paramString2 = paramString2 + "&ef=js" + "&plpfrom=mailapp&plaform=android";
    return CGIManager.httpGet(this.mAccountId, paramString1, paramString2, paramQMCallback);
  }
  
  QMNetworkRequest httpMultiPost(String paramString1, String paramString2, List<QMFileEntity> paramList, QMCallback paramQMCallback)
  {
    paramString2 = paramString2 + "&ef=js" + "&plpfrom=mailapp&plaform=android";
    return CGIManager.httpMultiPost(this.mAccountId, paramString1, paramString2, paramList, paramQMCallback);
  }
  
  QMNetworkRequest httpPost(String paramString1, String paramString2, QMCallback paramQMCallback)
  {
    paramString2 = paramString2 + "&ef=js" + "&plpfrom=mailapp&plaform=android";
    return CGIManager.httpPost(this.mAccountId, paramString1, paramString2, paramQMCallback);
  }
  
  public boolean loadAvatar(String paramString1, String paramString2, int paramInt, AvatarCallback paramAvatarCallback)
  {
    log("loadAvatar: " + paramString1);
    String str = paramString1 + paramString2 + paramInt;
    Object localObject = ImageDownloadManager.shareInstance().getThumbBitmapFromLocalByKey(str);
    if (localObject != null)
    {
      QMLog.log(2, "BottleManager", "AvatarDisplay: ava has exists");
      paramAvatarCallback.onSuccessInMainThread2(paramString2, (Bitmap)localObject);
      return true;
    }
    if (paramString1 != null)
    {
      localObject = new DownloadInfo();
      ((DownloadInfo)localObject).setAccountId(this.mAccountId);
      ((DownloadInfo)localObject).setUrl(paramString1);
      ((DownloadInfo)localObject).setImageDownloadListener(new BottleManager.3(this, paramInt, str, paramAvatarCallback, paramString2));
      ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject);
    }
    return false;
  }
  
  public void logDetailEvent(String paramString1, long paramLong, String paramString2)
  {
    DataCollector.logDetailEvent(paramString1, this.mAccountId, paramLong, paramString2);
  }
  
  public void logEvent(String paramString)
  {
    DataCollector.logEvent(paramString);
  }
  
  public void logPerformanceBegin(String paramString1, String paramString2)
  {
    DataCollector.logPerformanceBegin(paramString1, this.mAccountId, paramString2);
  }
  
  public void logPerformanceEnd(String paramString)
  {
    DataCollector.logPerformanceEnd(paramString, "" + this.mAccountId);
  }
  
  String processContent(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return paramString1;
                } while (!paramString1.startsWith("#"));
                paramInt = paramString1.indexOf('#', 1);
              } while (paramInt <= 1);
              paramString2 = paramString1.substring(1, paramInt);
              if (paramInt + 1 < paramString1.length()) {}
              for (paramString1 = paramString1.substring(paramInt + 1);; paramString1 = "") {
                return paramContext.getString(2131690972, new Object[] { paramString2, paramString1 });
              }
            } while (!"1".equals(paramString2));
            return paramContext.getString(2131690971, new Object[] { paramString1 });
          } while (!paramString1.startsWith("#"));
          paramInt = paramString1.indexOf('#', 1);
        } while (paramInt <= 1);
        if (paramInt + 1 < paramString1.length()) {
          return paramString1.substring(paramInt + 1);
        }
        return "";
      } while (!paramString1.startsWith("@"));
      paramInt = paramString1.indexOf('@', 1);
    } while (paramInt <= 1);
    if (paramInt + 1 < paramString1.length()) {
      return paramString1.substring(paramInt + 1);
    }
    return "";
  }
  
  String processEmoji(String paramString, StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    initEmoji();
    int m = paramString.length();
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = paramString.indexOf('/', j);
      if (k < 0)
      {
        paramString.getChars(j, m, paramArrayOfChar, i);
        i = m - j + i;
      }
    }
    for (;;)
    {
      return String.copyValueOf(paramArrayOfChar, 0, i);
      k += 1;
      int n = binarySearchEmoji(this.sortedEmoji, paramString, k, m);
      if (n >= 0)
      {
        paramString.getChars(j, k - 1, paramArrayOfChar, i);
        i += k - 1 - j;
        paramStringBuilder.append(i).append(",");
        paramArrayOfChar[i] = ' ';
        i += 1;
        paramStringBuilder.append(i).append(",");
        paramStringBuilder.append(this.sortedEmoji[n][1]).append(",");
      }
      for (j = k + this.sortedEmoji[n][0].length();; j = k)
      {
        break;
        paramString.getChars(j, k, paramArrayOfChar, i);
        i += k - j;
      }
    }
  }
  
  void remove(String paramString, OnActionCallback paramOnActionCallback)
  {
    log("remove: " + paramString);
    Threads.runInBackground(new BottleManager.6(this, paramString, paramOnActionCallback));
  }
  
  void remove(String paramString1, String paramString2, OnActionCallback paramOnActionCallback)
  {
    QMLog.log(4, "BottleManager", "remove: " + paramString1 + ", msgId:" + paramString2);
    Threads.runInBackground(new BottleManager.5(this, paramString2, paramString1, paramOnActionCallback));
  }
  
  void remove(List<String> paramList, OnActionCallback paramOnActionCallback)
  {
    Threads.runInBackground(new BottleManager.7(this, paramList, paramOnActionCallback));
  }
  
  public void setContentWithEmoji(TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, ViewHolderTag paramViewHolderTag, int paramInt)
  {
    paramString1 = new SpannableString(paramString1);
    Resources localResources = QMApplicationContext.sharedInstance().getResources();
    int k = 0;
    int m = 0;
    int i1 = paramString2.length();
    int n = 0;
    int i = 0;
    int j = 0;
    if (n < i1)
    {
      Object localObject1;
      Object localObject2;
      if (paramString2.charAt(n) == ',') {
        if (i == 2)
        {
          localObject1 = getEmojiUrl(j);
          localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject1);
          if (localObject2 != null)
          {
            localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject2);
            ((BitmapDrawable)localObject1).setBounds(0, 0, paramInt, paramInt);
            localObject1 = new VerticalCenterImageSpan((Drawable)localObject1);
            if (m <= paramString1.length()) {
              paramString1.setSpan(localObject1, k, m, 17);
            }
            label141:
            i = 0;
            j = 0;
            m = 0;
            k = 0;
          }
        }
      }
      for (;;)
      {
        n += 1;
        break;
        localObject2 = new DownloadInfo();
        ((DownloadInfo)localObject2).setUrl((String)localObject1);
        ((DownloadInfo)localObject2).setImageDownloadListener(new BottleManager.4(this, paramViewHolderTag, paramString3, paramString4, localResources, paramInt, paramString1, k, m, paramTextView));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject2);
        break label141;
        i += 1;
        continue;
        switch (i)
        {
        default: 
          break;
        case 0: 
          k = k * 10 + paramString2.charAt(n) - 48;
          break;
        case 1: 
          m = m * 10 + paramString2.charAt(n) - 48;
          break;
        case 2: 
          j = j * 10 + paramString2.charAt(n) - 48;
        }
      }
    }
    paramTextView.setText(paramString1);
  }
  
  void spam(String paramString, OnActionCallback paramOnActionCallback)
  {
    QMLog.log(4, "BottleManager", "spam: " + paramString);
    Threads.runInBackground(new BottleManager.8(this, paramString, paramOnActionCallback));
  }
  
  public static abstract interface AvatarCallback
  {
    public abstract void onErrorInMainThread2(String paramString, Bitmap paramBitmap);
    
    public abstract void onSuccessInMainThread2(String paramString, Bitmap paramBitmap);
  }
  
  static class Coordinate
  {
    final double lat;
    final double lng;
    
    public Coordinate(double paramDouble1, double paramDouble2)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
    }
    
    public String toString()
    {
      return String.format(Locale.getDefault(), "%.6f,%.6f", new Object[] { Double.valueOf(this.lat), Double.valueOf(this.lng) });
    }
  }
  
  static class PushObserver
    implements Observer
  {
    private final WeakReference<BottleManager> wManager;
    
    PushObserver(BottleManager paramBottleManager)
    {
      this.wManager = new WeakReference(paramBottleManager);
    }
    
    private void handleNotify(BottleManager paramBottleManager, JSONObject paramJSONObject, boolean paramBoolean)
    {
      if (paramJSONObject.containsKey("notified")) {
        QMLog.log(4, "BottleManager", "no need to notfiy bottle again");
      }
      for (;;)
      {
        return;
        boolean bool1 = QMServiceManager.hasSound();
        Uri localUri = QMSettingManager.sharedInstance().getPushSoundUri(false);
        boolean bool2 = QMServiceManager.hasVibrate();
        QMNotificationConstructor localQMNotificationConstructor = QMNotificationConstructor.getInstance();
        int i;
        int j;
        if (paramJSONObject.containsKey("pickkey"))
        {
          localObject = paramJSONObject.getString("pickkey");
          try
          {
            i = Integer.parseInt(paramJSONObject.getString("a"));
            if ((localObject == null) || (((String)localObject).length() <= 0) || (i == -1)) {
              continue;
            }
            j = Math.abs(((String)localObject).hashCode());
            String str1 = paramBottleManager.mContext.getString(2131690982);
            paramJSONObject = paramJSONObject.getString("content");
            localObject = LaunchWebPush.createBottleNewPush(i, (String)localObject);
            localQMNotificationConstructor.notifyPushBottle(j, str1, paramJSONObject, paramJSONObject, null, bool1, localUri, bool2, PendingIntent.getActivity(paramBottleManager.mContext, 0, (Intent)localObject, 268435456));
            return;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              i = -1;
            }
          }
        }
        if (!paramJSONObject.containsKey("mailid")) {
          continue;
        }
        Object localObject = paramJSONObject.getString("mailid");
        try
        {
          i = Integer.parseInt(paramJSONObject.getString("a"));
          if ((localObject == null) || (((String)localObject).length() <= 0) || (i == -1)) {
            continue;
          }
          j = BottleManager.generateResponseNotificationId((String)localObject);
          String str2 = paramBottleManager.mContext.getString(2131690982);
          paramJSONObject = paramJSONObject.getString("content");
          localObject = LaunchWebPush.createBottleResponse(i, (String)localObject);
          localQMNotificationConstructor.notifyPushBottle(j, str2, paramJSONObject, paramJSONObject, null, bool1, localUri, bool2, PendingIntent.getActivity(paramBottleManager.mContext, 0, (Intent)localObject, 268435456));
          if (!paramBoolean) {
            continue;
          }
          Threads.runInBackground(new BottleManager.PushObserver.1(this, localQMNotificationConstructor, j), 2000L);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = -1;
          }
        }
      }
    }
    
    public void update(java.util.Observable paramObservable, Object paramObject)
    {
      paramObservable = (BottleManager)this.wManager.get();
      boolean bool = AppStatusUtil.isAppOnForeground();
      QMLog.log(4, "BottleManager", "PushObserver: fg:" + bool + ", manager:" + paramObservable + ", data:" + paramObject);
      if (paramObservable != null) {
        try
        {
          i = Integer.parseInt(((JSONObject)paramObject).getString("a"));
          if (i != paramObservable.mAccountId)
          {
            QMLog.log(5, "BottleManager", String.format(Locale.getDefault(), "plp uin changed, old[%d], from[%d]", new Object[] { Integer.valueOf(paramObservable.mAccountId), Integer.valueOf(i) }));
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = -1;
          }
          if (paramObject != null) {
            handleNotify(paramObservable, (JSONObject)paramObject, bool);
          }
          Threads.runInBackground(new BottleManager.PushObserver.2(this, paramObject, paramObservable));
          return;
        }
      }
      QMNotification.unregistNotification("receivePushBottle", this);
    }
  }
  
  static class UpdateConversationTotal
  {
    String bottleId;
    int total;
    
    public UpdateConversationTotal() {}
    
    public UpdateConversationTotal(String paramString, int paramInt)
    {
      this.bottleId = paramString;
      this.total = paramInt;
    }
  }
  
  public static class ViewHolderTag
  {
    public String bottleid;
    public String msgid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager
 * JD-Core Version:    0.7.0.1
 */