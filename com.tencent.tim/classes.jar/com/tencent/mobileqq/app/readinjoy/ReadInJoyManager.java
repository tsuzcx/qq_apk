package com.tencent.mobileqq.app.readinjoy;

import acfp;
import acyy;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import aqgv;
import aqmr;
import awit;
import awiz;
import awja;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.content.ReadInJoyDataProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ljc.c;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ReadInJoyManager
  extends Observable
  implements Manager
{
  public static String TAG = ReadInJoyManager.class.getSimpleName();
  private SharedPreferences P;
  private CopyOnWriteArrayList<awja> S = new CopyOnWriteArrayList();
  private NotifyReceiver a;
  private BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private int cAz = 14;
  private HashMap<Integer, Integer> jp = new HashMap();
  private QQAppInterface mApp;
  private ExecutorService mExecutor = Executors.newSingleThreadExecutor();
  
  public ReadInJoyManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.a = new NotifyReceiver();
    this.P = awit.b(this.mApp, 1);
    if (((WindowManager)this.mApp.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getWidth() <= 720) {}
    for (int i = 14;; i = 24)
    {
      this.cAz = i;
      this.S.add(0, b());
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("notify_main_feeds_msg_newfeeds_read");
      paramQQAppInterface.addAction("notify_main_feeds_msg_newcomment_read");
      paramQQAppInterface.addAction("notify_main_feeds_msg_publish_fail");
      paramQQAppInterface.addAction("notify_main_feeds_msg_republish");
      paramQQAppInterface.addAction("notify_main_new_channel_clear");
      paramQQAppInterface.addAction("notify_main_guide_clear");
      paramQQAppInterface.addAction("config_local_channel_flag");
      paramQQAppInterface.addAction("config_follow_uin");
      paramQQAppInterface.addAction("config_update_app_setting");
      paramQQAppInterface.addAction("readInJoy_video_play_real_time_report");
      paramQQAppInterface.addAction("notify_main_share_friend_video");
      paramQQAppInterface.addAction("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
      this.mApp.getApp().registerReceiver(this.a, paramQQAppInterface);
      return;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private Bundle a(Uri paramUri, int[] paramArrayOfInt, long paramLong, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 176	android/os/Bundle
    //   6: dup
    //   7: invokespecial 177	android/os/Bundle:<init>	()V
    //   10: astore 13
    //   12: getstatic 182	android/os/Build$VERSION:SDK_INT	I
    //   15: bipush 11
    //   17: if_icmpge +6 -> 23
    //   20: aload 13
    //   22: areturn
    //   23: ldc 184
    //   25: astore 10
    //   27: iconst_0
    //   28: istore 6
    //   30: iload 6
    //   32: aload_2
    //   33: arraylength
    //   34: if_icmpge +67 -> 101
    //   37: aload 10
    //   39: astore 11
    //   41: iload 6
    //   43: ifle +25 -> 68
    //   46: new 186	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   53: aload 10
    //   55: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 193
    //   60: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 11
    //   68: new 186	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   75: aload 11
    //   77: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: iload 6
    //   83: iaload
    //   84: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 10
    //   92: iload 6
    //   94: iconst_1
    //   95: iadd
    //   96: istore 6
    //   98: goto -68 -> 30
    //   101: new 186	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   108: ldc 201
    //   110: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: lload_3
    //   114: invokestatic 206	java/lang/Long:toString	(J)Ljava/lang/String;
    //   117: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 208
    //   122: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 210
    //   127: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 212
    //   132: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 10
    //   137: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 214
    //   142: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_2
    //   149: aload_0
    //   150: getfield 69	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 218	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload_1
    //   160: aconst_null
    //   161: aload_2
    //   162: aconst_null
    //   163: ldc 220
    //   165: invokestatic 226	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: aload_2
    //   172: invokeinterface 232 1 0
    //   177: ifeq +130 -> 307
    //   180: aload_2
    //   181: astore_1
    //   182: aload 5
    //   184: arraylength
    //   185: istore 7
    //   187: iconst_0
    //   188: istore 6
    //   190: iload 6
    //   192: iload 7
    //   194: if_icmpge +113 -> 307
    //   197: aload 5
    //   199: iload 6
    //   201: aaload
    //   202: astore 10
    //   204: aload_2
    //   205: astore_1
    //   206: aload_2
    //   207: aload 10
    //   209: invokeinterface 236 2 0
    //   214: istore 8
    //   216: iload 8
    //   218: iflt +152 -> 370
    //   221: aload_2
    //   222: astore_1
    //   223: aload_2
    //   224: iload 8
    //   226: invokeinterface 240 2 0
    //   231: istore 9
    //   233: iload 9
    //   235: iconst_1
    //   236: if_icmpne +23 -> 259
    //   239: aload_2
    //   240: astore_1
    //   241: aload 13
    //   243: aload 10
    //   245: aload_2
    //   246: iload 8
    //   248: invokeinterface 244 2 0
    //   253: invokevirtual 248	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   256: goto +114 -> 370
    //   259: iload 9
    //   261: iconst_3
    //   262: if_icmpne +108 -> 370
    //   265: aload_2
    //   266: astore_1
    //   267: aload 13
    //   269: aload 10
    //   271: aload_2
    //   272: iload 8
    //   274: invokeinterface 252 2 0
    //   279: invokevirtual 256	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: goto +88 -> 370
    //   285: astore 5
    //   287: aload_2
    //   288: astore_1
    //   289: aload 5
    //   291: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   294: aload_2
    //   295: ifnull +9 -> 304
    //   298: aload_2
    //   299: invokeinterface 262 1 0
    //   304: aload 13
    //   306: areturn
    //   307: aload_2
    //   308: astore_1
    //   309: aload 13
    //   311: ldc_w 264
    //   314: aload_2
    //   315: invokeinterface 267 1 0
    //   320: i2l
    //   321: invokevirtual 248	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   324: aload_2
    //   325: ifnull -21 -> 304
    //   328: aload_2
    //   329: invokeinterface 262 1 0
    //   334: goto -30 -> 304
    //   337: astore_1
    //   338: aload 12
    //   340: astore_2
    //   341: aload_2
    //   342: ifnull +9 -> 351
    //   345: aload_2
    //   346: invokeinterface 262 1 0
    //   351: aload_1
    //   352: athrow
    //   353: astore 5
    //   355: aload_1
    //   356: astore_2
    //   357: aload 5
    //   359: astore_1
    //   360: goto -19 -> 341
    //   363: astore 5
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -80 -> 287
    //   370: iload 6
    //   372: iconst_1
    //   373: iadd
    //   374: istore 6
    //   376: goto -186 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	ReadInJoyManager
    //   0	379	1	paramUri	Uri
    //   0	379	2	paramArrayOfInt	int[]
    //   0	379	3	paramLong	long
    //   0	379	5	paramArrayOfString	String[]
    //   28	347	6	i	int
    //   185	10	7	j	int
    //   214	59	8	k	int
    //   231	32	9	m	int
    //   25	245	10	str1	String
    //   39	37	11	str2	String
    //   1	338	12	localObject	Object
    //   10	300	13	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   171	180	285	java/lang/Exception
    //   182	187	285	java/lang/Exception
    //   206	216	285	java/lang/Exception
    //   223	233	285	java/lang/Exception
    //   241	256	285	java/lang/Exception
    //   267	282	285	java/lang/Exception
    //   309	324	285	java/lang/Exception
    //   30	37	337	finally
    //   46	68	337	finally
    //   68	92	337	finally
    //   101	169	337	finally
    //   171	180	353	finally
    //   182	187	353	finally
    //   206	216	353	finally
    //   223	233	353	finally
    //   241	256	353	finally
    //   267	282	353	finally
    //   289	294	353	finally
    //   309	324	353	finally
    //   30	37	363	java/lang/Exception
    //   46	68	363	java/lang/Exception
    //   68	92	363	java/lang/Exception
    //   101	169	363	java/lang/Exception
  }
  
  private boolean a(Uri paramUri, awiz paramawiz, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("pushTime", Integer.valueOf(paramawiz.eBl));
    localContentValues.put("notifyType", Integer.valueOf(paramawiz.avA));
    localContentValues.put("feedsOwner", Long.valueOf(paramawiz.aBf));
    localContentValues.put("feedsID", Long.valueOf(paramawiz.sG));
    localContentValues.put("feedsSubject", paramawiz.cQM);
    localContentValues.put("deleteUin", Long.valueOf(paramawiz.aBj));
    localContentValues.put("publishFail", Integer.valueOf(paramawiz.eBn));
    localContentValues.put("likeUin", Long.valueOf(paramawiz.aBi));
    localContentValues.put("commentUin", Long.valueOf(paramawiz.aBg));
    localContentValues.put("commentID", paramawiz.cQN);
    localContentValues.put("replyUin", Long.valueOf(paramawiz.aBh));
    localContentValues.put("replyID", paramawiz.cQO);
    localContentValues.put("commentInfo", paramawiz.cQP);
    localContentValues.put("receiveTime", Long.valueOf(paramawiz.mReceiveTime));
    localContentValues.put("processSeq", Long.valueOf(paramLong));
    if (this.mApp.getApp().getContentResolver().insert(paramUri, localContentValues) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handlePushedFeedsMsgRecords, insertMsgRecordToFeedsTable failed, feedID=" + paramawiz.sG + ", commentID=" + paramawiz.cQN);
      }
      return false;
    }
    return true;
  }
  
  private awja b()
  {
    awja localawja = new awja();
    localawja.mStyle = 0;
    if (this.P == null) {
      return localawja;
    }
    if (!this.P.getBoolean("share_to_news", false)) {
      return localawja;
    }
    long l3 = this.P.getLong("config_feeds_newfeeds_leba_latest_owner", 0L);
    int i;
    long l1;
    long l2;
    int j;
    label119:
    int k;
    label144:
    String str;
    label185:
    int m;
    if (l3 > 0L)
    {
      i = 1;
      l1 = this.P.getLong("config_feeds_newcomment_leba_unread_count", 0L);
      l2 = this.P.getLong("config_feeds_publishfail_leba_unread_count", 0L);
      if (TextUtils.isEmpty(this.P.getString("config_new_channel_id_list", null))) {
        break label344;
      }
      j = 1;
      k = this.P.getInt("config_new_channel_notify_flag", 0);
      if ((j == 0) || (k == -1)) {
        break label349;
      }
      j = 1;
      str = this.P.getString("config_notify_guide_wording", null);
      k = this.P.getInt("config_notify_guide_flag", 0);
      if ((str == null) || (k == -1)) {
        break label354;
      }
      k = 1;
      if (this.P.getInt("readinjoy_push_channel_article_flag", 0) == -1) {
        break label359;
      }
      m = 1;
      label205:
      if (l1 <= 0L) {
        break label365;
      }
      localawja.mStyle = 1;
      localawja.mNum = ((int)l1);
      localawja.eBo = 3;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localawja.mText))
      {
        k = localawja.mText.length();
        if (k * 2 > this.cAz)
        {
          i = 0;
          j = 0;
          label266:
          if (j < k)
          {
            if (localawja.mText.charAt(j) >= 'ÿ') {
              break label745;
            }
            i += 1;
            label290:
            if ((i <= this.cAz) || (j <= 0)) {
              break label752;
            }
            localawja.mText = (localawja.mText.substring(0, j) + "...");
          }
        }
      }
      return localawja;
      i = 0;
      break;
      label344:
      j = 0;
      break label119;
      label349:
      j = 0;
      break label144;
      label354:
      k = 0;
      break label185;
      label359:
      m = 0;
      break label205;
      label365:
      if (j == 0) {
        break label389;
      }
      localawja.mStyle = 4;
      localawja.mText = acfp.m(2131713612);
    }
    label389:
    if ((k != 0) || (i != 0) || (m != 0))
    {
      l1 = this.P.getLong("config_notify_guide_updated_time", 0L);
      l2 = this.P.getLong("config_feeds_newfeeds_leba_updated_time", 0L);
      long l4 = this.P.getLong("readinjoy_push_channel_article_updated_time", 0L);
      HashMap localHashMap = new HashMap();
      if (k != 0) {
        localHashMap.put(Integer.valueOf(1), Long.valueOf(l1));
      }
      if (i != 0) {
        localHashMap.put(Integer.valueOf(2), Long.valueOf(l2));
      }
      if (m != 0) {
        localHashMap.put(Integer.valueOf(5), Long.valueOf(l4));
      }
      Iterator localIterator = localHashMap.keySet().iterator();
      i = 0;
      l1 = 0L;
      label531:
      if (localIterator.hasNext())
      {
        j = ((Integer)localIterator.next()).intValue();
        l2 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        if (l2 <= l1) {
          break label759;
        }
        l1 = l2;
        i = j;
      }
    }
    label745:
    label752:
    label759:
    for (;;)
    {
      break label531;
      switch (i)
      {
      case 3: 
      case 4: 
      default: 
        break;
      case 1: 
        localawja.mStyle = 2;
        localawja.mText = str;
        localawja.eBo = i;
        break;
      case 2: 
        localawja.mStyle = 2;
        localawja.mText = aqgv.A(this.mApp, Long.toString(l3));
        localawja.eBo = i;
        break;
      case 5: 
        localawja.mStyle = 2;
        localawja.mText = this.P.getString("readinjoy_push_channel_article_content_wording", "");
        localawja.eBo = i;
        break;
        if (l2 <= 0L) {
          break;
        }
        localawja.mStyle = 3;
        localawja.mResourceId = 2130846115;
        localawja.eBo = 4;
        break;
        i += 2;
        break label290;
        j += 1;
        break label266;
      }
    }
  }
  
  private void cPj()
  {
    if (this.P == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.P.edit();
    Object localObject = ReadInJoyDataProvider.V.buildUpon();
    ((Uri.Builder)localObject).appendQueryParameter("uin", this.mApp.getAccount());
    localObject = ((Uri.Builder)localObject).build();
    long l1 = this.P.getLong("config_feeds_newfeeds_leba_read_id", 0L);
    Bundle localBundle = a((Uri)localObject, new int[] { 10 }, l1, new String[] { "_id", "feedsOwner" });
    long l2 = localBundle.getLong("unread");
    l1 = 0L;
    if (l2 > 0L)
    {
      l3 = localBundle.getLong("_id");
      l1 = localBundle.getLong("feedsOwner");
      localEditor.putLong("config_feeds_newfeeds_leba_max_id", l3);
    }
    localEditor.putLong("config_feeds_newfeeds_leba_unread_count", l2);
    localEditor.putLong("config_feeds_newfeeds_leba_latest_owner", l1);
    localEditor.putLong("config_feeds_newfeeds_leba_updated_time", NetConnInfoCenter.getServerTime());
    l1 = this.P.getLong("config_feeds_newcomment_leba_read_id", 0L);
    localBundle = a((Uri)localObject, new int[] { 12, 11 }, l1, new String[] { "_id", "likeUin", "commentUin" });
    long l3 = localBundle.getLong("unread");
    l2 = 0L;
    l1 = 0L;
    if (l3 > 0L)
    {
      long l4 = localBundle.getLong("_id");
      l2 = localBundle.getLong("likeUin");
      l1 = localBundle.getLong("commentUin");
      localEditor.putLong("config_feeds_newcomment_leba_max_id", l4);
    }
    if (l2 > 0L) {}
    for (;;)
    {
      localEditor.putLong("config_feeds_newcomment_leba_latest_uin", l2);
      localEditor.putLong("config_feeds_newcomment_leba_unread_count", l3);
      l1 = this.P.getLong("config_feeds_publishfail_leba_read_id", 0L);
      localObject = a((Uri)localObject, new int[] { 999999 }, l1, new String[] { "_id" });
      l1 = ((Bundle)localObject).getLong("unread");
      if (l1 > 0L) {
        localEditor.putLong("config_feeds_publishfail_leba_max_id", ((Bundle)localObject).getLong("_id"));
      }
      localEditor.putLong("config_feeds_publishfail_leba_unread_count", l1);
      awit.a(localEditor, true);
      cPk();
      return;
      l2 = l1;
    }
  }
  
  private void cPk()
  {
    awja localawja = b();
    int i = localawja.a(c());
    if (i != 0)
    {
      this.S.set(0, localawja);
      ((acyy)this.mApp.getBusinessHandler(62)).k(true, true, i);
    }
  }
  
  private long ff()
  {
    if (this.P == null) {
      return 0L;
    }
    long l = this.P.getLong("config_feeds_process_seq", 0L) + 1L;
    SharedPreferences.Editor localEditor = this.P.edit();
    localEditor.putLong("config_feeds_process_seq", l);
    awit.a(localEditor, true);
    return l;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    if (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null) {
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = new BusinessInfoCheckUpdate.AppInfo();
    }
    for (;;)
    {
      return this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.clear();
    }
  }
  
  public awja c()
  {
    return (awja)this.S.get(0);
  }
  
  public void dl(Intent paramIntent)
  {
    if (this.P == null) {
      return;
    }
    switch (c().eBo)
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 4: 
      paramIntent.putExtra("channel_id", 9999);
      return;
    }
    long l = this.P.getLong("readinjoy_push_channel_article_content_channel_id", 0L);
    String str = this.P.getString("readinjoy_push_channel_article_content_channel_name", awit.cQB);
    Object localObject = this.P.getString("readinjoy_push_channel_article_content_article_id_list", "");
    ArrayList localArrayList = new ArrayList(((String)localObject).length());
    localObject = aqmr.split((String)localObject, ',');
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        localArrayList.add(Long.valueOf(Long.parseLong(localCharSequence)));
      }
      i += 1;
    }
    paramIntent.putExtra("channel_id", (int)l);
    paramIntent.putExtra("channel_name", str);
    paramIntent.putExtra("subscription_all_article_id", localArrayList);
  }
  
  public void ju(List<awiz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.mExecutor.execute(new ReadInJoyManager.1(this, paramList));
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo m()
  {
    if (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo == null) {
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    }
    for (;;)
    {
      return this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.clear();
    }
  }
  
  public void onDestroy()
  {
    this.mApp.getApp().unregisterReceiver(this.a);
  }
  
  public class NotifyReceiver
    extends BroadcastReceiver
  {
    public NotifyReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      ReadInJoyManager.a(ReadInJoyManager.this).execute(new ReadInJoyManager.NotifyReceiver.1(this, paramIntent));
    }
  }
  
  public static class a
    implements ljc.c
  {
    private int cAA;
    private int mPosition;
    private String mUin;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.mPosition = paramInt1;
      this.cAA = paramInt2;
      this.mUin = paramString;
    }
    
    public void f(boolean paramBoolean, String paramString, int paramInt)
    {
      paramString = new Intent("notify_main_subscribe_follow_state");
      paramString.putExtra("follow_uin", this.mUin);
      paramString.putExtra("follow_uin_position", this.mPosition);
      paramString.putExtra("follow_uin_smooth_dx", this.cAA);
      paramString.putExtra("follow_uin_status", paramBoolean);
      BaseApplication.getContext().sendBroadcast(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager
 * JD-Core Version:    0.7.0.1
 */