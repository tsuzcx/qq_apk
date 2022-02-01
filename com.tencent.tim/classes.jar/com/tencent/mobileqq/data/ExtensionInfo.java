package com.tencent.mobileqq.data;

import ajoi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionInfo
  extends Entity
{
  public static final int AUDIO_PANEL_TYPE__LS = 2;
  public static final int AUDIO_PANEL_TYPE__NONE = -1;
  public static final int AUDIO_PANEL_TYPE__PRESS_RECORDER = 0;
  public static final int AUDIO_PANEL_TYPE__RECORDER = 1;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final int CHAT_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_SHOW_NONE_PANEL = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final int FEED_TYPE_QSTORY = 2;
  public static final int FEED_TYPE_QZONE = 0;
  public static final int FEED_TYPE_WEISHI = 1;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public static final String TAG = "ExtensionInfo";
  public static final int TYPE_FROM_CHAT = 1;
  public static final int TYPE_FROM_CONTACT = 0;
  @defaultValue(defaultInteger=-1)
  public int audioPanelType = -1;
  @Deprecated
  public int bestIntimacyDays;
  public int bestIntimacyType = 0;
  @notColumn
  public long chatAnimStartTime;
  public int chatDays;
  public int chatHotLevel = 0;
  public int chatInputType = 0;
  public long colorRingId;
  public long commingRingId;
  public byte[] diyFontConfigBytes;
  public ConcurrentHashMap<Integer, String> diyFontConfigMap;
  public byte[] diyFontTimestampBytes;
  public ConcurrentHashMap<Integer, Integer> diyFontTimestampMap;
  public int faceId;
  public long faceIdUpdateTime;
  public String feedContent;
  public boolean feedHasPhoto;
  public String feedPhotoUrl;
  public long feedTime;
  public int feedType;
  public int fontEffect;
  public long fontEffectLastUpdateTime;
  @notColumn
  public long frdshipAnimStartTime;
  public int friendRingId;
  public int friendshipChatDays;
  public int friendshipLevel = 0;
  public boolean hasRemindChat;
  public boolean hasRemindFrdship;
  public boolean hasRemindIntimate;
  public boolean hasRemindLoverChat;
  public boolean hasRemindPraise;
  public boolean hasRemindQzoneVisit;
  @defaultValue(defaultInteger=0)
  public int hiddenChatSwitch;
  @notColumn
  public long intimateAnimStartTime;
  public int intimate_chatDays;
  public int intimate_level = 0;
  public int intimate_type = 0;
  public boolean isAdded2C2C;
  @notColumn
  public boolean isDataChanged;
  public boolean isExtinguish;
  public int isGrayTipMultiRemind = 0;
  public int isGrayTipRemind = 0;
  public boolean isListenTogetherOpen;
  @defaultValue(defaultInteger=0)
  public int isSharingLocation;
  public long lastChatTime;
  @notColumn
  public long lastFriendshipGrayPushTime = -1L;
  public long lastFriendshipTime;
  @notColumn
  public long lastGrayPushTime = -1L;
  public long lastHotReactiveReCheckInTs;
  public long lastIceBreakChatTs;
  public long lastIceBreakCheckTs;
  public long lastPLNewsTimestamp;
  public long lastPullPLNewsTimestamp;
  public long lastQzoneVisitTime;
  @defaultValue(defaultInteger=0)
  public long lastShareLbsMsgUniseq;
  public long lastUpdateTime;
  public long last_intimate_chatTime;
  public long lastpraiseTime;
  public long latestPLUpdateTimestamp;
  public long localChatRecTs;
  public long localChatSendTs;
  @notColumn
  public long loverChatAnimStartTime;
  public int loverChatDays;
  public int loverChatLevel = 0;
  public int loverFlag;
  public long loverLastChatTime;
  public boolean loverTransFlag;
  public long mTogetherBusinessFlag;
  public int magicFont;
  public long makeFrdsTs;
  public boolean messageEnablePreview = true;
  @defaultValue(defaultInteger=0)
  public int messageEnablePreviewNew;
  public boolean messageEnableSound = true;
  @defaultValue(defaultInteger=0)
  public int messageEnableSoundNew;
  public boolean messageEnableVibrate = true;
  @defaultValue(defaultInteger=0)
  public int messageEnableVibrateNew;
  @notColumn
  public ConcurrentHashMap<Long, ajoi> mutualMarks;
  public int mutual_mark_version;
  public String mutual_marks_store_json;
  public int newBestIntimacyType = 0;
  public long openDoNotDisturbTime;
  public int pendantDiyId;
  public long pendantId;
  @notColumn
  public long praiseAnimStartTime;
  @Deprecated
  public int praiseDays;
  public int praiseHotLevel = 0;
  public int pttChangeVoiceType = 0;
  public int qzoneHotDays;
  @notColumn
  public long qzoneVisitAnimStartTime;
  public int qzoneVisitType = 0;
  public byte[] richBuffer;
  @notColumn
  public RichStatus richStatus;
  public long richTime;
  public int showC2CPanel = 1;
  public long timestamp;
  @defaultValue(defaultInteger=-1)
  public long topPositionTime;
  public long uVipFont;
  @unique
  public String uin;
  public int vipFontType;
  
  private void migrateOldExtensionInfoToNewMutualMark()
  {
    if (this.mutual_mark_version < 818)
    {
      if ((this.qzoneVisitType >= 1) && (this.qzoneVisitType <= 2) && ((this.mutualMarks == null) || (this.mutualMarks.get(Long.valueOf(8L)) == null)))
      {
        if (this.mutualMarks == null) {
          this.mutualMarks = new ConcurrentHashMap();
        }
        ajoi localajoi = new ajoi();
        localajoi.type = 8L;
        localajoi.ada = this.qzoneVisitType;
        localajoi.HR = this.lastQzoneVisitTime;
        localajoi.adb = this.qzoneHotDays;
        localajoi.cpw = this.hasRemindQzoneVisit;
        this.mutualMarks.put(Long.valueOf(localajoi.type), localajoi);
      }
      this.mutual_mark_version = 818;
    }
  }
  
  public RichStatus getRichStatus()
  {
    return getRichStatus(false);
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.getEmptyStatus();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.parseStatus(this.richBuffer);
      this.richStatus.time = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = new RichStatus(null);
    }
  }
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
  
  public boolean isTogetherBusinessOpen(int paramInt)
  {
    return (this.mTogetherBusinessFlag & paramInt) != 0L;
  }
  
  /* Error */
  public void postRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 289	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   4: ifnull +45 -> 49
    //   7: new 291	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 289	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   15: invokespecial 294	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_1
    //   19: new 296	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 299	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 303	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: checkcast 208	java/util/concurrent/ConcurrentHashMap
    //   38: putfield 305	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   49: aload_0
    //   50: getfield 310	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   53: ifnull +45 -> 98
    //   56: new 291	java/io/ByteArrayInputStream
    //   59: dup
    //   60: aload_0
    //   61: getfield 310	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   64: invokespecial 294	java/io/ByteArrayInputStream:<init>	([B)V
    //   67: astore_1
    //   68: new 296	java/io/ObjectInputStream
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 299	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_2
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 303	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 208	java/util/concurrent/ConcurrentHashMap
    //   87: putfield 312	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   98: aload_0
    //   99: getfield 314	com/tencent/mobileqq/data/ExtensionInfo:mutual_marks_store_json	Ljava/lang/String;
    //   102: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +341 -> 446
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 314	com/tencent/mobileqq/data/ExtensionInfo:mutual_marks_store_json	Ljava/lang/String;
    //   113: invokestatic 324	ajoi:b	(Ljava/lang/String;)Ljava/util/concurrent/ConcurrentHashMap;
    //   116: putfield 198	com/tencent/mobileqq/data/ExtensionInfo:mutualMarks	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload_0
    //   120: invokespecial 326	com/tencent/mobileqq/data/ExtensionInfo:migrateOldExtensionInfoToNewMutualMark	()V
    //   123: return
    //   124: astore_1
    //   125: ldc_w 328
    //   128: iconst_1
    //   129: new 330	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 333
    //   139: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: goto -106 -> 49
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: ldc_w 328
    //   166: iconst_1
    //   167: new 330	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 333
    //   177: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_2
    //   194: ifnull -145 -> 49
    //   197: aload_2
    //   198: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   201: goto -152 -> 49
    //   204: astore_1
    //   205: ldc_w 328
    //   208: iconst_1
    //   209: new 330	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 333
    //   219: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: goto -186 -> 49
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   249: aload_2
    //   250: athrow
    //   251: astore_1
    //   252: ldc_w 328
    //   255: iconst_1
    //   256: new 330	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 333
    //   266: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_1
    //   270: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: goto -33 -> 249
    //   285: astore_1
    //   286: ldc_w 328
    //   289: iconst_1
    //   290: new 330	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 333
    //   300: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: goto -218 -> 98
    //   319: astore_3
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_2
    //   323: astore_1
    //   324: ldc_w 328
    //   327: iconst_1
    //   328: new 330	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 333
    //   338: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_3
    //   342: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   345: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_2
    //   355: ifnull -257 -> 98
    //   358: aload_2
    //   359: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   362: goto -264 -> 98
    //   365: astore_1
    //   366: ldc_w 328
    //   369: iconst_1
    //   370: new 330	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 333
    //   380: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_1
    //   384: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   387: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: goto -298 -> 98
    //   399: astore_2
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: ifnull +7 -> 410
    //   406: aload_1
    //   407: invokevirtual 308	java/io/ObjectInputStream:close	()V
    //   410: aload_2
    //   411: athrow
    //   412: astore_1
    //   413: ldc_w 328
    //   416: iconst_1
    //   417: new 330	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 333
    //   427: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: goto -33 -> 410
    //   446: aload_0
    //   447: aconst_null
    //   448: putfield 198	com/tencent/mobileqq/data/ExtensionInfo:mutualMarks	Ljava/util/concurrent/ConcurrentHashMap;
    //   451: goto -332 -> 119
    //   454: astore_2
    //   455: goto -53 -> 402
    //   458: astore_3
    //   459: goto -137 -> 322
    //   462: astore_2
    //   463: goto -222 -> 241
    //   466: astore_3
    //   467: goto -306 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	ExtensionInfo
    //   18	61	1	localObject1	java.lang.Object
    //   124	19	1	localException1	java.lang.Exception
    //   162	1	1	localObject2	java.lang.Object
    //   204	19	1	localException2	java.lang.Exception
    //   240	6	1	localObject3	java.lang.Object
    //   251	19	1	localException3	java.lang.Exception
    //   285	19	1	localException4	java.lang.Exception
    //   323	1	1	localObject4	java.lang.Object
    //   365	19	1	localException5	java.lang.Exception
    //   401	6	1	localObject5	java.lang.Object
    //   412	19	1	localException6	java.lang.Exception
    //   27	171	2	localObjectInputStream	java.io.ObjectInputStream
    //   238	12	2	localObject6	java.lang.Object
    //   321	38	2	localObject7	java.lang.Object
    //   399	12	2	localObject8	java.lang.Object
    //   454	1	2	localObject9	java.lang.Object
    //   462	1	2	localObject10	java.lang.Object
    //   158	23	3	localException7	java.lang.Exception
    //   319	23	3	localException8	java.lang.Exception
    //   458	1	3	localException9	java.lang.Exception
    //   466	1	3	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   45	49	124	java/lang/Exception
    //   19	28	158	java/lang/Exception
    //   197	201	204	java/lang/Exception
    //   19	28	238	finally
    //   245	249	251	java/lang/Exception
    //   94	98	285	java/lang/Exception
    //   68	77	319	java/lang/Exception
    //   358	362	365	java/lang/Exception
    //   68	77	399	finally
    //   406	410	412	java/lang/Exception
    //   79	90	454	finally
    //   324	354	454	finally
    //   79	90	458	java/lang/Exception
    //   30	41	462	finally
    //   163	193	462	finally
    //   30	41	466	java/lang/Exception
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 353	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 354	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_1
    //   13: new 353	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 354	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 5
    //   22: new 356	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 359	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 305	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: ifnull +23 -> 58
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 305	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: invokevirtual 363	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: invokevirtual 366	java/io/ObjectOutputStream:flush	()V
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 370	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: putfield 289	com/tencent/mobileqq/data/ExtensionInfo:diyFontTimestampBytes	[B
    //   58: aload_0
    //   59: getfield 312	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnull +416 -> 478
    //   65: new 356	java/io/ObjectOutputStream
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 359	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 312	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   80: invokevirtual 363	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: invokevirtual 366	java/io/ObjectOutputStream:flush	()V
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 370	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   93: putfield 310	com/tencent/mobileqq/data/ExtensionInfo:diyFontConfigBytes	[B
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   112: aload_0
    //   113: getfield 198	com/tencent/mobileqq/data/ExtensionInfo:mutualMarks	Ljava/util/concurrent/ConcurrentHashMap;
    //   116: ifnull +305 -> 421
    //   119: aload_0
    //   120: getfield 198	com/tencent/mobileqq/data/ExtensionInfo:mutualMarks	Ljava/util/concurrent/ConcurrentHashMap;
    //   123: invokevirtual 375	java/util/concurrent/ConcurrentHashMap:size	()I
    //   126: ifle +295 -> 421
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 198	com/tencent/mobileqq/data/ExtensionInfo:mutualMarks	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: invokestatic 378	ajoi:b	(Ljava/util/concurrent/ConcurrentHashMap;)Ljava/lang/String;
    //   137: putfield 314	com/tencent/mobileqq/data/ExtensionInfo:mutual_marks_store_json	Ljava/lang/String;
    //   140: return
    //   141: astore_2
    //   142: ldc_w 328
    //   145: iconst_1
    //   146: new 330	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 380
    //   156: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: goto -68 -> 104
    //   175: astore_1
    //   176: ldc_w 328
    //   179: iconst_1
    //   180: new 330	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 380
    //   190: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: goto -94 -> 112
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_1
    //   212: aload 4
    //   214: astore_2
    //   215: ldc_w 328
    //   218: iconst_1
    //   219: new 330	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 380
    //   229: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_3
    //   233: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull -142 -> 112
    //   257: aload_2
    //   258: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   261: goto -149 -> 112
    //   264: astore_1
    //   265: ldc_w 328
    //   268: iconst_1
    //   269: new 330	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 380
    //   279: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: goto -183 -> 112
    //   298: astore_1
    //   299: ldc_w 328
    //   302: iconst_1
    //   303: new 330	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 380
    //   313: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_1
    //   317: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto -76 -> 253
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_2
    //   335: aload_2
    //   336: ifnull +7 -> 343
    //   339: aload_2
    //   340: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 371	java/io/ObjectOutputStream:close	()V
    //   351: aload_1
    //   352: athrow
    //   353: astore_2
    //   354: ldc_w 328
    //   357: iconst_1
    //   358: new 330	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 380
    //   368: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_2
    //   372: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   375: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: goto -41 -> 343
    //   387: astore_2
    //   388: ldc_w 328
    //   391: iconst_1
    //   392: new 330	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 380
    //   402: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_2
    //   406: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -67 -> 351
    //   421: aload_0
    //   422: ldc_w 382
    //   425: putfield 314	com/tencent/mobileqq/data/ExtensionInfo:mutual_marks_store_json	Ljava/lang/String;
    //   428: return
    //   429: astore_1
    //   430: goto -95 -> 335
    //   433: astore 4
    //   435: aload_1
    //   436: astore_3
    //   437: aload 4
    //   439: astore_1
    //   440: goto -105 -> 335
    //   443: astore_3
    //   444: aload_1
    //   445: astore 4
    //   447: aload_3
    //   448: astore_1
    //   449: aload_2
    //   450: astore_3
    //   451: aload 4
    //   453: astore_2
    //   454: goto -119 -> 335
    //   457: astore_3
    //   458: aload_2
    //   459: astore_1
    //   460: aload 4
    //   462: astore_2
    //   463: goto -248 -> 215
    //   466: astore_3
    //   467: aload_2
    //   468: astore 4
    //   470: aload_1
    //   471: astore_2
    //   472: aload 4
    //   474: astore_1
    //   475: goto -260 -> 215
    //   478: aconst_null
    //   479: astore_1
    //   480: goto -384 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	ExtensionInfo
    //   12	97	1	localObject1	java.lang.Object
    //   175	19	1	localException1	java.lang.Exception
    //   211	39	1	localObject2	java.lang.Object
    //   264	19	1	localException2	java.lang.Exception
    //   298	19	1	localException3	java.lang.Exception
    //   332	20	1	localObject3	java.lang.Object
    //   429	7	1	localObject4	java.lang.Object
    //   439	41	1	localObject5	java.lang.Object
    //   30	71	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   141	19	2	localException4	java.lang.Exception
    //   214	126	2	localObject6	java.lang.Object
    //   353	19	2	localException5	java.lang.Exception
    //   387	63	2	localException6	java.lang.Exception
    //   453	19	2	localObject7	java.lang.Object
    //   1	1	3	localObject8	java.lang.Object
    //   209	139	3	localException7	java.lang.Exception
    //   436	1	3	localObject9	java.lang.Object
    //   443	5	3	localObject10	java.lang.Object
    //   450	1	3	localObject11	java.lang.Object
    //   457	1	3	localException8	java.lang.Exception
    //   466	1	3	localException9	java.lang.Exception
    //   3	210	4	localObject12	java.lang.Object
    //   433	5	4	localObject13	java.lang.Object
    //   445	28	4	localObject14	java.lang.Object
    //   20	69	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   100	104	141	java/lang/Exception
    //   108	112	175	java/lang/Exception
    //   22	31	209	java/lang/Exception
    //   257	261	264	java/lang/Exception
    //   249	253	298	java/lang/Exception
    //   22	31	332	finally
    //   339	343	353	java/lang/Exception
    //   347	351	387	java/lang/Exception
    //   31	58	429	finally
    //   58	75	429	finally
    //   75	96	433	finally
    //   215	245	443	finally
    //   31	58	457	java/lang/Exception
    //   58	75	457	java/lang/Exception
    //   75	96	466	java/lang/Exception
  }
  
  public void removeAllMutualMark()
  {
    this.bestIntimacyType = 0;
    this.bestIntimacyDays = 0;
    this.praiseHotLevel = 0;
    this.chatHotLevel = 0;
    this.loverChatLevel = 0;
    this.loverTransFlag = false;
    this.qzoneVisitType = 0;
    this.hiddenChatSwitch = 0;
    this.qzoneHotDays = 0;
    this.lastQzoneVisitTime = 0L;
    this.newBestIntimacyType = 0;
    this.localChatSendTs = 0L;
    this.localChatRecTs = 0L;
    this.lastIceBreakChatTs = 0L;
    this.friendshipLevel = 0;
    this.friendshipChatDays = 0;
    this.lastFriendshipTime = 0L;
    this.intimate_type = 0;
    this.intimate_level = 0;
    this.intimate_chatDays = 0;
    this.last_intimate_chatTime = 0L;
    this.isExtinguish = false;
    if (this.mutualMarks != null) {
      this.mutualMarks.clear();
    }
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
    this.richStatus = null;
    this.isAdded2C2C = false;
  }
  
  public void setTogetherBusiness(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.mTogetherBusinessFlag |= paramInt;
      return;
    }
    this.mTogetherBusinessFlag &= (paramInt ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */