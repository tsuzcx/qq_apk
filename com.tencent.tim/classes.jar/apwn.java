import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class apwn
{
  public static final String crJ = acfp.m(2131714012);
  public static final String crK = acfp.m(2131714016);
  public List<String> Iy;
  private apwn.a a;
  private QQAppInterface app;
  private TroopBatchAddFriendMgr b;
  public int bZm;
  public int dXL;
  public int dXM;
  public int dXN;
  public String displayName;
  public int state = 0;
  public String troopUin;
  public long ts;
  public int type = 0;
  public String uin;
  
  public apwn(QQAppInterface paramQQAppInterface, String paramString, int paramInt, apwn.a parama, List<String> paramList)
  {
    this.app = paramQQAppInterface;
    this.b = this.b;
    this.troopUin = paramString;
    this.type = paramInt;
    this.a = parama;
    this.Iy = paramList;
    this.ts = System.currentTimeMillis();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    if (!TextUtils.isEmpty(paramTroopMemberInfo.recommendRemark)) {
      return paramTroopMemberInfo.recommendRemark;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
      return paramTroopMemberInfo.troopnick;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.friendnick)) {
      return paramTroopMemberInfo.friendnick;
    }
    return paramTroopMemberInfo.memberuin;
  }
  
  /* Error */
  public static List<TroopMemberInfo> a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 99	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 100	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: bipush 51
    //   12: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15: checkcast 108	acff
    //   18: astore 12
    //   20: aload_0
    //   21: bipush 52
    //   23: invokevirtual 106	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 110	com/tencent/mobileqq/app/TroopManager
    //   29: aload_1
    //   30: invokevirtual 113	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   33: astore 11
    //   35: aload 11
    //   37: ifnonnull +6 -> 43
    //   40: aload 10
    //   42: areturn
    //   43: aconst_null
    //   44: astore 9
    //   46: iload_3
    //   47: ifeq +7 -> 54
    //   50: ldc 115
    //   52: astore 9
    //   54: aload_0
    //   55: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   58: astore 14
    //   60: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   63: lstore 7
    //   65: aload_0
    //   66: invokevirtual 127	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   69: invokevirtual 133	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   72: astore 13
    //   74: ldc 76
    //   76: invokevirtual 138	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   79: astore 15
    //   81: iconst_5
    //   82: anewarray 140	java/lang/String
    //   85: astore 16
    //   87: aload 16
    //   89: iconst_0
    //   90: ldc 141
    //   92: aastore
    //   93: aload 16
    //   95: iconst_1
    //   96: ldc 143
    //   98: aastore
    //   99: aload 16
    //   101: iconst_2
    //   102: ldc 144
    //   104: aastore
    //   105: aload 16
    //   107: iconst_3
    //   108: ldc 145
    //   110: aastore
    //   111: aload 16
    //   113: iconst_4
    //   114: ldc 146
    //   116: aastore
    //   117: aload_2
    //   118: ifnull +680 -> 798
    //   121: aload_2
    //   122: invokeinterface 152 1 0
    //   127: ifle +671 -> 798
    //   130: new 154	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   137: ldc 157
    //   139: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 163
    //   144: aload_2
    //   145: invokeinterface 152 1 0
    //   150: ldc 165
    //   152: invokestatic 171	java/util/Collections:nCopies	(ILjava/lang/Object;)Ljava/util/List;
    //   155: invokestatic 175	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   158: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 177
    //   163: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 17
    //   171: aload_2
    //   172: invokeinterface 152 1 0
    //   177: iconst_1
    //   178: iadd
    //   179: anewarray 140	java/lang/String
    //   182: astore 18
    //   184: aload 18
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: iconst_0
    //   190: istore 4
    //   192: iload 4
    //   194: aload_2
    //   195: invokeinterface 152 1 0
    //   200: if_icmpge +30 -> 230
    //   203: aload 18
    //   205: iload 4
    //   207: iconst_1
    //   208: iadd
    //   209: aload_2
    //   210: iload 4
    //   212: invokeinterface 184 2 0
    //   217: checkcast 140	java/lang/String
    //   220: aastore
    //   221: iload 4
    //   223: iconst_1
    //   224: iadd
    //   225: istore 4
    //   227: goto -35 -> 192
    //   230: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +38 -> 271
    //   236: ldc 192
    //   238: iconst_2
    //   239: new 154	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   246: ldc 194
    //   248: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 17
    //   253: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc 196
    //   258: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 13
    //   273: iconst_1
    //   274: aload 15
    //   276: aload 16
    //   278: aload 17
    //   280: aload 18
    //   282: aconst_null
    //   283: aconst_null
    //   284: aload 9
    //   286: aconst_null
    //   287: invokevirtual 209	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +687 -> 979
    //   295: aload_1
    //   296: astore_2
    //   297: aload_1
    //   298: invokeinterface 214 1 0
    //   303: istore_3
    //   304: iload_3
    //   305: ifeq +674 -> 979
    //   308: iconst_0
    //   309: istore 4
    //   311: aload_1
    //   312: astore_2
    //   313: iload 4
    //   315: istore 5
    //   317: aload_1
    //   318: astore 9
    //   320: new 76	com/tencent/mobileqq/data/TroopMemberInfo
    //   323: dup
    //   324: invokespecial 215	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   327: astore 15
    //   329: aload_1
    //   330: astore_2
    //   331: iload 4
    //   333: istore 5
    //   335: aload_1
    //   336: astore 9
    //   338: aload 15
    //   340: aload_1
    //   341: iconst_0
    //   342: invokeinterface 218 2 0
    //   347: putfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   350: aload_1
    //   351: astore_2
    //   352: iload 4
    //   354: istore 5
    //   356: aload_1
    //   357: astore 9
    //   359: aload 15
    //   361: aload_1
    //   362: iconst_1
    //   363: invokeinterface 222 2 0
    //   368: putfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   371: aload_1
    //   372: astore_2
    //   373: iload 4
    //   375: istore 5
    //   377: aload_1
    //   378: astore 9
    //   380: aload 15
    //   382: aload_1
    //   383: iconst_2
    //   384: invokeinterface 218 2 0
    //   389: putfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   392: aload_1
    //   393: astore_2
    //   394: iload 4
    //   396: istore 5
    //   398: aload_1
    //   399: astore 9
    //   401: aload 15
    //   403: aload_1
    //   404: iconst_3
    //   405: invokeinterface 218 2 0
    //   410: putfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   413: aload_1
    //   414: astore_2
    //   415: iload 4
    //   417: istore 5
    //   419: aload_1
    //   420: astore 9
    //   422: aload 15
    //   424: aload_1
    //   425: iconst_4
    //   426: invokeinterface 218 2 0
    //   431: putfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   434: aload_1
    //   435: astore_2
    //   436: iload 4
    //   438: istore 5
    //   440: aload_1
    //   441: astore 9
    //   443: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +72 -> 518
    //   449: aload_1
    //   450: astore_2
    //   451: iload 4
    //   453: istore 5
    //   455: aload_1
    //   456: astore 9
    //   458: ldc 192
    //   460: iconst_2
    //   461: new 154	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   468: ldc 226
    //   470: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 15
    //   475: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   478: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc 228
    //   483: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 15
    //   488: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   491: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc 233
    //   496: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 12
    //   501: aload 15
    //   503: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   506: invokevirtual 237	acff:isFriend	(Ljava/lang/String;)Z
    //   509: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   512: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_1
    //   519: astore_2
    //   520: iload 4
    //   522: istore 5
    //   524: aload_1
    //   525: astore 9
    //   527: aload 12
    //   529: aload 15
    //   531: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   534: invokevirtual 237	acff:isFriend	(Ljava/lang/String;)Z
    //   537: ifne +85 -> 622
    //   540: aload_1
    //   541: astore_2
    //   542: iload 4
    //   544: istore 5
    //   546: aload_1
    //   547: astore 9
    //   549: aload 15
    //   551: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   554: invokestatic 245	aqft:rl	(Ljava/lang/String;)Z
    //   557: ifeq +65 -> 622
    //   560: aload_1
    //   561: astore_2
    //   562: iload 4
    //   564: istore 5
    //   566: aload_1
    //   567: astore 9
    //   569: aload 15
    //   571: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   574: aload 14
    //   576: invokestatic 249	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   579: ifne +43 -> 622
    //   582: aload_1
    //   583: astore_2
    //   584: iload 4
    //   586: istore 5
    //   588: aload_1
    //   589: astore 9
    //   591: aload_0
    //   592: aload 15
    //   594: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   597: invokestatic 255	aprg:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   600: ifne +22 -> 622
    //   603: aload_1
    //   604: astore_2
    //   605: iload 4
    //   607: istore 5
    //   609: aload_1
    //   610: astore 9
    //   612: aload 10
    //   614: aload 15
    //   616: invokeinterface 259 2 0
    //   621: pop
    //   622: iload 4
    //   624: iconst_1
    //   625: iadd
    //   626: istore 6
    //   628: iload 6
    //   630: istore 4
    //   632: aload_1
    //   633: astore_2
    //   634: iload 6
    //   636: istore 5
    //   638: aload_1
    //   639: astore 9
    //   641: aload_1
    //   642: invokeinterface 262 1 0
    //   647: ifne -336 -> 311
    //   650: aload_1
    //   651: astore_2
    //   652: iload 6
    //   654: istore 5
    //   656: aload_1
    //   657: astore 9
    //   659: aload_1
    //   660: invokeinterface 265 1 0
    //   665: aconst_null
    //   666: astore_1
    //   667: iload 6
    //   669: istore 4
    //   671: aload_1
    //   672: astore_2
    //   673: iload 4
    //   675: istore 5
    //   677: aload_1
    //   678: astore 9
    //   680: aload 13
    //   682: invokevirtual 266	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   685: aload_1
    //   686: astore_2
    //   687: iload 4
    //   689: istore 5
    //   691: aload_1
    //   692: astore 9
    //   694: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +43 -> 740
    //   700: aload_1
    //   701: astore_2
    //   702: iload 4
    //   704: istore 5
    //   706: aload_1
    //   707: astore 9
    //   709: ldc 192
    //   711: iconst_2
    //   712: invokestatic 272	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   715: ldc_w 274
    //   718: iconst_1
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   727: lload 7
    //   729: lsub
    //   730: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   733: aastore
    //   734: invokestatic 284	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   737: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: aload_1
    //   741: ifnull +235 -> 976
    //   744: aload_1
    //   745: invokeinterface 265 1 0
    //   750: ldc 192
    //   752: iconst_1
    //   753: ldc_w 286
    //   756: iconst_3
    //   757: anewarray 4	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload 11
    //   764: getfield 291	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   767: aastore
    //   768: dup
    //   769: iconst_1
    //   770: aload 10
    //   772: invokeinterface 152 1 0
    //   777: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   780: aastore
    //   781: dup
    //   782: iconst_2
    //   783: iload 4
    //   785: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: invokestatic 299	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   792: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: aload 10
    //   797: areturn
    //   798: aload 13
    //   800: iconst_1
    //   801: aload 15
    //   803: aload 16
    //   805: ldc_w 301
    //   808: iconst_1
    //   809: anewarray 140	java/lang/String
    //   812: dup
    //   813: iconst_0
    //   814: aload_1
    //   815: aastore
    //   816: aconst_null
    //   817: aconst_null
    //   818: aload 9
    //   820: aconst_null
    //   821: invokevirtual 209	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   824: astore_1
    //   825: goto -534 -> 291
    //   828: astore_0
    //   829: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +13 -> 845
    //   835: ldc 192
    //   837: iconst_2
    //   838: ldc_w 303
    //   841: aload_0
    //   842: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   845: goto -95 -> 750
    //   848: astore_0
    //   849: aconst_null
    //   850: astore_1
    //   851: iconst_0
    //   852: istore 5
    //   854: aload_1
    //   855: astore_2
    //   856: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   859: ifeq +15 -> 874
    //   862: aload_1
    //   863: astore_2
    //   864: ldc 192
    //   866: iconst_2
    //   867: ldc_w 303
    //   870: aload_0
    //   871: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   874: iload 5
    //   876: istore 4
    //   878: aload_1
    //   879: ifnull -129 -> 750
    //   882: aload_1
    //   883: invokeinterface 265 1 0
    //   888: iload 5
    //   890: istore 4
    //   892: goto -142 -> 750
    //   895: astore_0
    //   896: iload 5
    //   898: istore 4
    //   900: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   903: ifeq -153 -> 750
    //   906: ldc 192
    //   908: iconst_2
    //   909: ldc_w 303
    //   912: aload_0
    //   913: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   916: iload 5
    //   918: istore 4
    //   920: goto -170 -> 750
    //   923: astore_0
    //   924: aconst_null
    //   925: astore_2
    //   926: aload_2
    //   927: ifnull +9 -> 936
    //   930: aload_2
    //   931: invokeinterface 265 1 0
    //   936: aload_0
    //   937: athrow
    //   938: astore_1
    //   939: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq -6 -> 936
    //   945: ldc 192
    //   947: iconst_2
    //   948: ldc_w 303
    //   951: aload_1
    //   952: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   955: goto -19 -> 936
    //   958: astore_0
    //   959: goto -33 -> 926
    //   962: astore_0
    //   963: iconst_0
    //   964: istore 5
    //   966: goto -112 -> 854
    //   969: astore_0
    //   970: aload 9
    //   972: astore_1
    //   973: goto -119 -> 854
    //   976: goto -226 -> 750
    //   979: iconst_0
    //   980: istore 4
    //   982: goto -311 -> 671
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	paramQQAppInterface	QQAppInterface
    //   0	985	1	paramString	String
    //   0	985	2	paramList	List<String>
    //   0	985	3	paramBoolean	boolean
    //   190	791	4	i	int
    //   315	650	5	j	int
    //   626	42	6	k	int
    //   63	665	7	l	long
    //   44	927	9	str1	String
    //   7	789	10	localArrayList	ArrayList
    //   33	730	11	localTroopInfo	TroopInfo
    //   18	510	12	localacff	acff
    //   72	727	13	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   58	517	14	str2	String
    //   79	723	15	localObject	Object
    //   85	719	16	arrayOfString1	String[]
    //   169	110	17	str3	String
    //   182	99	18	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   744	750	828	java/lang/Throwable
    //   60	87	848	java/lang/Throwable
    //   121	184	848	java/lang/Throwable
    //   192	221	848	java/lang/Throwable
    //   230	271	848	java/lang/Throwable
    //   271	291	848	java/lang/Throwable
    //   798	825	848	java/lang/Throwable
    //   882	888	895	java/lang/Throwable
    //   60	87	923	finally
    //   121	184	923	finally
    //   192	221	923	finally
    //   230	271	923	finally
    //   271	291	923	finally
    //   798	825	923	finally
    //   930	936	938	java/lang/Throwable
    //   297	304	958	finally
    //   320	329	958	finally
    //   338	350	958	finally
    //   359	371	958	finally
    //   380	392	958	finally
    //   401	413	958	finally
    //   422	434	958	finally
    //   443	449	958	finally
    //   458	518	958	finally
    //   527	540	958	finally
    //   549	560	958	finally
    //   569	582	958	finally
    //   591	603	958	finally
    //   612	622	958	finally
    //   641	650	958	finally
    //   659	665	958	finally
    //   680	685	958	finally
    //   694	700	958	finally
    //   709	740	958	finally
    //   856	862	958	finally
    //   864	874	958	finally
    //   297	304	962	java/lang/Throwable
    //   320	329	969	java/lang/Throwable
    //   338	350	969	java/lang/Throwable
    //   359	371	969	java/lang/Throwable
    //   380	392	969	java/lang/Throwable
    //   401	413	969	java/lang/Throwable
    //   422	434	969	java/lang/Throwable
    //   443	449	969	java/lang/Throwable
    //   458	518	969	java/lang/Throwable
    //   527	540	969	java/lang/Throwable
    //   549	560	969	java/lang/Throwable
    //   569	582	969	java/lang/Throwable
    //   591	603	969	java/lang/Throwable
    //   612	622	969	java/lang/Throwable
    //   641	650	969	java/lang/Throwable
    //   659	665	969	java/lang/Throwable
    //   680	685	969	java/lang/Throwable
    //   694	700	969	java/lang/Throwable
    //   709	740	969	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, apwn paramapwn)
  {
    Object localObject = a(paramQQAppInterface, paramapwn.troopUin);
    if (localObject == null) {}
    int j;
    int k;
    do
    {
      return;
      i = ((Integer)localObject[0]).intValue();
      int m = ((Integer)localObject[1]).intValue();
      j = ((Integer)localObject[2]).intValue();
      paramTroopInfo = (String)localObject[3];
      localObject = (String)localObject[4];
      aluk localaluk = ((TroopManager)paramQQAppInterface.getManager(52)).a();
      int n = (int)(localaluk.yT * i);
      k = (int)(localaluk.yU * i);
      if ((m >= n) && (j >= k) && (j > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V1 check nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b_%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool), paramapwn.troopUin }));
        if (!bool) {
          break;
        }
        alui.c(paramQQAppInterface, paramapwn.troopUin, m, j, paramTroopInfo, (String)localObject);
        return;
      }
      if ((m < n) && (i != 0))
      {
        paramTroopInfo = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
        m = paramTroopInfo.length();
        anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, paramapwn.troopUin, "", paramTroopInfo.substring(0, m - 1), "");
      }
    } while ((j >= k) || (i == 0));
    paramTroopInfo = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
    int i = paramTroopInfo.length();
    anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, paramapwn.troopUin, "", paramTroopInfo.substring(0, i - 1), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    long l = localSharedPreferences.getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin }), 0L);
    if ((l > 0L) && (l - System.currentTimeMillis() > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, String.format("dealWithOldTip force_troopUin_invalid=%b_%s_%b seq1_seq2=%d_%d", new Object[] { Boolean.valueOf(paramBoolean), paramTroopInfo.troopuin, Boolean.valueOf(bool), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq2) }));
      }
      if ((bool) || (paramBoolean))
      {
        int i = 0;
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq != 0L)
        {
          paramQQAppInterface.b().t(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq);
          paramTroopInfo.dwLastBAFTipMsgUniSeq = 0L;
          i = 1;
        }
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq2 != 0L)
        {
          paramQQAppInterface.b().t(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq2);
          paramTroopInfo.dwLastBAFTipMsgUniSeq2 = 0L;
          i = 1;
        }
        if (i != 0) {
          ((TroopManager)paramQQAppInterface.getManager(52)).i(paramTroopInfo);
        }
        if (bool)
        {
          paramQQAppInterface = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin });
          localSharedPreferences.edit().putInt(paramQQAppInterface, 0).apply();
        }
      }
      return;
    }
  }
  
  /* Error */
  public static Object[] a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 51
    //   3: invokevirtual 439	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6: checkcast 108	acff
    //   9: astore 17
    //   11: aload_0
    //   12: bipush 52
    //   14: invokevirtual 439	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   17: checkcast 110	com/tencent/mobileqq/app/TroopManager
    //   20: aload_1
    //   21: invokevirtual 113	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   24: astore 20
    //   26: aload 20
    //   28: ifnonnull +34 -> 62
    //   31: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   34: ifeq +26 -> 60
    //   37: ldc 192
    //   39: iconst_4
    //   40: invokestatic 272	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   43: ldc_w 444
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: invokestatic 284	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aconst_null
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 445	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   66: astore 19
    //   68: aload_0
    //   69: sipush 203
    //   72: invokevirtual 439	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   75: checkcast 447	aptw
    //   78: astore 21
    //   80: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   83: lstore 9
    //   85: aload_0
    //   86: invokevirtual 451	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   89: invokevirtual 454	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   92: astore 18
    //   94: aload 18
    //   96: iconst_1
    //   97: ldc 76
    //   99: invokevirtual 138	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   102: iconst_5
    //   103: anewarray 140	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: ldc 141
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: ldc 143
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: ldc 144
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: ldc 145
    //   125: aastore
    //   126: dup
    //   127: iconst_4
    //   128: ldc 146
    //   130: aastore
    //   131: ldc_w 301
    //   134: iconst_1
    //   135: anewarray 140	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: aconst_null
    //   143: aconst_null
    //   144: ldc 115
    //   146: aconst_null
    //   147: invokevirtual 209	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore 12
    //   152: aload 12
    //   154: ifnull +1544 -> 1698
    //   157: aload 12
    //   159: invokeinterface 214 1 0
    //   164: istore 11
    //   166: iload 11
    //   168: ifeq +1530 -> 1698
    //   171: aconst_null
    //   172: astore 16
    //   174: aconst_null
    //   175: astore 14
    //   177: aconst_null
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: iconst_0
    //   182: istore_3
    //   183: iconst_0
    //   184: istore 5
    //   186: iconst_0
    //   187: istore_2
    //   188: iload_3
    //   189: istore 7
    //   191: iload 5
    //   193: istore 6
    //   195: new 76	com/tencent/mobileqq/data/TroopMemberInfo
    //   198: dup
    //   199: invokespecial 215	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   202: astore 13
    //   204: iload_3
    //   205: istore 7
    //   207: iload 5
    //   209: istore 6
    //   211: aload 13
    //   213: aload 12
    //   215: iconst_0
    //   216: invokeinterface 218 2 0
    //   221: putfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   224: iload_3
    //   225: istore 7
    //   227: iload 5
    //   229: istore 6
    //   231: aload 13
    //   233: aload 12
    //   235: iconst_1
    //   236: invokeinterface 222 2 0
    //   241: putfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   244: iload_3
    //   245: istore 7
    //   247: iload 5
    //   249: istore 6
    //   251: aload 13
    //   253: aload 12
    //   255: iconst_2
    //   256: invokeinterface 218 2 0
    //   261: putfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   264: iload_3
    //   265: istore 7
    //   267: iload 5
    //   269: istore 6
    //   271: aload 13
    //   273: aload 12
    //   275: iconst_3
    //   276: invokeinterface 218 2 0
    //   281: putfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   284: iload_3
    //   285: istore 7
    //   287: iload 5
    //   289: istore 6
    //   291: aload 13
    //   293: aload 12
    //   295: iconst_4
    //   296: invokeinterface 218 2 0
    //   301: putfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   304: iload_3
    //   305: istore 7
    //   307: iload 5
    //   309: istore 6
    //   311: aload 13
    //   313: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   316: invokestatic 245	aqft:rl	(Ljava/lang/String;)Z
    //   319: ifeq +70 -> 389
    //   322: iload_3
    //   323: istore 7
    //   325: iload 5
    //   327: istore 6
    //   329: aload 13
    //   331: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   334: invokestatic 457	aqft:rk	(Ljava/lang/String;)Z
    //   337: ifne +52 -> 389
    //   340: iload_3
    //   341: istore 7
    //   343: iload 5
    //   345: istore 6
    //   347: aload 13
    //   349: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   352: aload 19
    //   354: invokestatic 249	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   357: ifne +32 -> 389
    //   360: aload 21
    //   362: ifnull +290 -> 652
    //   365: iload_3
    //   366: istore 7
    //   368: iload 5
    //   370: istore 6
    //   372: aload 21
    //   374: aload 13
    //   376: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   379: invokevirtual 460	aptw:gM	(Ljava/lang/String;)Z
    //   382: istore 11
    //   384: iload 11
    //   386: ifeq +266 -> 652
    //   389: aload_1
    //   390: astore 15
    //   392: iload_3
    //   393: istore 6
    //   395: iload 5
    //   397: istore_3
    //   398: iload_2
    //   399: iconst_1
    //   400: iadd
    //   401: istore 4
    //   403: iload 6
    //   405: istore_2
    //   406: aload_0
    //   407: astore_1
    //   408: aload 16
    //   410: astore 13
    //   412: aload 15
    //   414: astore_0
    //   415: aload 12
    //   417: invokeinterface 262 1 0
    //   422: ifne +1253 -> 1675
    //   425: aload 12
    //   427: invokeinterface 265 1 0
    //   432: aconst_null
    //   433: astore 15
    //   435: aload_0
    //   436: astore 16
    //   438: aload 13
    //   440: astore 12
    //   442: aload 15
    //   444: astore_0
    //   445: aload_0
    //   446: astore 17
    //   448: aload 18
    //   450: invokevirtual 266	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   453: aload_0
    //   454: astore 17
    //   456: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   459: ifeq +37 -> 496
    //   462: aload_0
    //   463: astore 17
    //   465: ldc 192
    //   467: iconst_4
    //   468: invokestatic 272	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   471: ldc_w 462
    //   474: iconst_1
    //   475: anewarray 4	java/lang/Object
    //   478: dup
    //   479: iconst_0
    //   480: invokestatic 124	android/os/SystemClock:elapsedRealtime	()J
    //   483: lload 9
    //   485: lsub
    //   486: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   489: aastore
    //   490: invokestatic 284	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   493: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 12
    //   498: astore 18
    //   500: aload 14
    //   502: astore 15
    //   504: aload 16
    //   506: astore 19
    //   508: aload_1
    //   509: astore 17
    //   511: iload_2
    //   512: istore 5
    //   514: iload_3
    //   515: istore 6
    //   517: iload 4
    //   519: istore 7
    //   521: aload_0
    //   522: ifnull +34 -> 556
    //   525: aload_0
    //   526: invokeinterface 265 1 0
    //   531: iload 4
    //   533: istore 7
    //   535: iload_3
    //   536: istore 6
    //   538: iload_2
    //   539: istore 5
    //   541: aload_1
    //   542: astore 17
    //   544: aload 16
    //   546: astore 19
    //   548: aload 14
    //   550: astore 15
    //   552: aload 12
    //   554: astore 18
    //   556: aload 18
    //   558: ifnull +659 -> 1217
    //   561: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +33 -> 597
    //   567: ldc 192
    //   569: iconst_2
    //   570: new 154	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 464
    //   580: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 18
    //   585: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   588: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload 18
    //   599: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   602: astore_1
    //   603: aload 18
    //   605: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   608: astore_0
    //   609: iconst_5
    //   610: anewarray 4	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload 20
    //   617: getfield 467	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   620: iload 7
    //   622: isub
    //   623: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: iload 6
    //   631: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: iload 5
    //   639: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: aastore
    //   643: dup
    //   644: iconst_3
    //   645: aload_0
    //   646: aastore
    //   647: dup
    //   648: iconst_4
    //   649: aload_1
    //   650: aastore
    //   651: areturn
    //   652: iload_3
    //   653: istore 7
    //   655: iload 5
    //   657: istore 6
    //   659: aload 17
    //   661: aload 13
    //   663: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   666: invokevirtual 237	acff:isFriend	(Ljava/lang/String;)Z
    //   669: ifeq +26 -> 695
    //   672: aload_1
    //   673: astore 13
    //   675: aload_0
    //   676: astore_1
    //   677: iload_2
    //   678: istore 4
    //   680: aload 13
    //   682: astore_0
    //   683: aload 16
    //   685: astore 13
    //   687: iload_3
    //   688: istore_2
    //   689: iload 5
    //   691: istore_3
    //   692: goto -277 -> 415
    //   695: iload_3
    //   696: iconst_1
    //   697: iadd
    //   698: istore 4
    //   700: iload 5
    //   702: istore_3
    //   703: iload 4
    //   705: istore 7
    //   707: iload 5
    //   709: istore 6
    //   711: aload 13
    //   713: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   716: ifle +8 -> 724
    //   719: iload 5
    //   721: iconst_1
    //   722: iadd
    //   723: istore_3
    //   724: iload 4
    //   726: istore 7
    //   728: iload_3
    //   729: istore 6
    //   731: aload 13
    //   733: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   736: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   739: ifne +46 -> 785
    //   742: iload 4
    //   744: istore 7
    //   746: iload_3
    //   747: istore 6
    //   749: aload 13
    //   751: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   754: ifle +1017 -> 1771
    //   757: aload 16
    //   759: ifnull +991 -> 1750
    //   762: iload 4
    //   764: istore 7
    //   766: iload_3
    //   767: istore 6
    //   769: aload 16
    //   771: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   774: aload 13
    //   776: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   779: if_icmpge +964 -> 1743
    //   782: goto +940 -> 1722
    //   785: iload 4
    //   787: istore 7
    //   789: iload_3
    //   790: istore 6
    //   792: aload 13
    //   794: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   797: ifle +108 -> 905
    //   800: aload 14
    //   802: ifnull +74 -> 876
    //   805: iload 4
    //   807: istore 7
    //   809: iload_3
    //   810: istore 6
    //   812: aload 14
    //   814: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   817: istore 5
    //   819: iload 4
    //   821: istore 7
    //   823: iload_3
    //   824: istore 6
    //   826: aload 13
    //   828: getfield 224	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   831: istore 8
    //   833: iload 5
    //   835: iload 8
    //   837: if_icmpge +32 -> 869
    //   840: aload 13
    //   842: astore 14
    //   844: aload_1
    //   845: astore 13
    //   847: aload_0
    //   848: astore_1
    //   849: iload_2
    //   850: istore 5
    //   852: aload 13
    //   854: astore_0
    //   855: aload 16
    //   857: astore 13
    //   859: iload 4
    //   861: istore_2
    //   862: iload 5
    //   864: istore 4
    //   866: goto -451 -> 415
    //   869: aload 14
    //   871: astore 13
    //   873: goto -33 -> 840
    //   876: aload 13
    //   878: astore 14
    //   880: aload_1
    //   881: astore 13
    //   883: aload_0
    //   884: astore_1
    //   885: iload_2
    //   886: istore 5
    //   888: aload 13
    //   890: astore_0
    //   891: aload 16
    //   893: astore 13
    //   895: iload 4
    //   897: istore_2
    //   898: iload 5
    //   900: istore 4
    //   902: goto -487 -> 415
    //   905: aload_0
    //   906: ifnonnull +744 -> 1650
    //   909: iload_2
    //   910: istore 5
    //   912: aload_1
    //   913: astore_0
    //   914: aload 13
    //   916: astore_1
    //   917: aload 16
    //   919: astore 13
    //   921: iload 4
    //   923: istore_2
    //   924: iload 5
    //   926: istore 4
    //   928: goto -513 -> 415
    //   931: astore_0
    //   932: aload 12
    //   934: astore 18
    //   936: aload 14
    //   938: astore 15
    //   940: aload 16
    //   942: astore 19
    //   944: aload_1
    //   945: astore 17
    //   947: iload_2
    //   948: istore 5
    //   950: iload_3
    //   951: istore 6
    //   953: iload 4
    //   955: istore 7
    //   957: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   960: ifeq -404 -> 556
    //   963: ldc 192
    //   965: iconst_4
    //   966: ldc_w 469
    //   969: aload_0
    //   970: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   973: aload 12
    //   975: astore 18
    //   977: aload 14
    //   979: astore 15
    //   981: aload 16
    //   983: astore 19
    //   985: aload_1
    //   986: astore 17
    //   988: iload_2
    //   989: istore 5
    //   991: iload_3
    //   992: istore 6
    //   994: iload 4
    //   996: istore 7
    //   998: goto -442 -> 556
    //   1001: astore 15
    //   1003: aconst_null
    //   1004: astore_0
    //   1005: aconst_null
    //   1006: astore 12
    //   1008: aconst_null
    //   1009: astore 13
    //   1011: aconst_null
    //   1012: astore 14
    //   1014: aconst_null
    //   1015: astore_1
    //   1016: iconst_0
    //   1017: istore_2
    //   1018: iconst_0
    //   1019: istore_3
    //   1020: iconst_0
    //   1021: istore 4
    //   1023: aload_0
    //   1024: astore 17
    //   1026: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1029: ifeq +17 -> 1046
    //   1032: aload_0
    //   1033: astore 17
    //   1035: ldc 192
    //   1037: iconst_4
    //   1038: ldc_w 469
    //   1041: aload 15
    //   1043: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1046: aload 12
    //   1048: astore 18
    //   1050: aload 13
    //   1052: astore 15
    //   1054: aload 14
    //   1056: astore 19
    //   1058: aload_1
    //   1059: astore 17
    //   1061: iload_2
    //   1062: istore 5
    //   1064: iload_3
    //   1065: istore 6
    //   1067: iload 4
    //   1069: istore 7
    //   1071: aload_0
    //   1072: ifnull -516 -> 556
    //   1075: aload_0
    //   1076: invokeinterface 265 1 0
    //   1081: aload 12
    //   1083: astore 18
    //   1085: aload 13
    //   1087: astore 15
    //   1089: aload 14
    //   1091: astore 19
    //   1093: aload_1
    //   1094: astore 17
    //   1096: iload_2
    //   1097: istore 5
    //   1099: iload_3
    //   1100: istore 6
    //   1102: iload 4
    //   1104: istore 7
    //   1106: goto -550 -> 556
    //   1109: astore_0
    //   1110: aload 12
    //   1112: astore 18
    //   1114: aload 13
    //   1116: astore 15
    //   1118: aload 14
    //   1120: astore 19
    //   1122: aload_1
    //   1123: astore 17
    //   1125: iload_2
    //   1126: istore 5
    //   1128: iload_3
    //   1129: istore 6
    //   1131: iload 4
    //   1133: istore 7
    //   1135: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1138: ifeq -582 -> 556
    //   1141: ldc 192
    //   1143: iconst_4
    //   1144: ldc_w 469
    //   1147: aload_0
    //   1148: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1151: aload 12
    //   1153: astore 18
    //   1155: aload 13
    //   1157: astore 15
    //   1159: aload 14
    //   1161: astore 19
    //   1163: aload_1
    //   1164: astore 17
    //   1166: iload_2
    //   1167: istore 5
    //   1169: iload_3
    //   1170: istore 6
    //   1172: iload 4
    //   1174: istore 7
    //   1176: goto -620 -> 556
    //   1179: astore_0
    //   1180: aconst_null
    //   1181: astore 12
    //   1183: aload 12
    //   1185: ifnull +10 -> 1195
    //   1188: aload 12
    //   1190: invokeinterface 265 1 0
    //   1195: aload_0
    //   1196: athrow
    //   1197: astore_1
    //   1198: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1201: ifeq -6 -> 1195
    //   1204: ldc 192
    //   1206: iconst_4
    //   1207: ldc_w 469
    //   1210: aload_1
    //   1211: invokestatic 306	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1214: goto -19 -> 1195
    //   1217: aload 19
    //   1219: ifnull +54 -> 1273
    //   1222: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +33 -> 1258
    //   1228: ldc 192
    //   1230: iconst_2
    //   1231: new 154	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 471
    //   1241: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload 19
    //   1246: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1249: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: aload 19
    //   1260: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1263: astore_1
    //   1264: aload 19
    //   1266: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1269: astore_0
    //   1270: goto -661 -> 609
    //   1273: aload 15
    //   1275: ifnull +124 -> 1399
    //   1278: aload 15
    //   1280: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1283: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1286: ifeq +104 -> 1390
    //   1289: aload 15
    //   1291: getfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1294: astore_0
    //   1295: aload 15
    //   1297: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1300: astore 13
    //   1302: aload_0
    //   1303: astore 12
    //   1305: aload 13
    //   1307: astore_1
    //   1308: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +203 -> 1514
    //   1314: ldc 192
    //   1316: iconst_2
    //   1317: new 154	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 471
    //   1327: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload 15
    //   1332: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1335: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc_w 473
    //   1341: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload 15
    //   1346: getfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1349: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: ldc_w 475
    //   1355: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload 15
    //   1360: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1363: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: ldc_w 477
    //   1369: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: aload_0
    //   1373: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: aload_0
    //   1383: astore_1
    //   1384: aload 13
    //   1386: astore_0
    //   1387: goto -778 -> 609
    //   1390: aload 15
    //   1392: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1395: astore_0
    //   1396: goto -101 -> 1295
    //   1399: aload 17
    //   1401: ifnull +238 -> 1639
    //   1404: aload 17
    //   1406: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1409: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1412: ifeq +110 -> 1522
    //   1415: aload 17
    //   1417: getfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1420: astore_0
    //   1421: aload 17
    //   1423: getfield 94	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1426: astore 13
    //   1428: aload_0
    //   1429: astore 12
    //   1431: aload 13
    //   1433: astore_1
    //   1434: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1437: ifeq +77 -> 1514
    //   1440: ldc 192
    //   1442: iconst_2
    //   1443: new 154	java/lang/StringBuilder
    //   1446: dup
    //   1447: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1450: ldc_w 471
    //   1453: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: aload 17
    //   1458: getfield 79	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1461: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: ldc_w 473
    //   1467: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: aload 17
    //   1472: getfield 91	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1475: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: ldc_w 475
    //   1481: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 17
    //   1486: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1489: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: ldc_w 477
    //   1495: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: aload_0
    //   1499: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1508: aload 13
    //   1510: astore_1
    //   1511: aload_0
    //   1512: astore 12
    //   1514: aload_1
    //   1515: astore_0
    //   1516: aload 12
    //   1518: astore_1
    //   1519: goto -910 -> 609
    //   1522: aload 17
    //   1524: getfield 88	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1527: astore_0
    //   1528: goto -107 -> 1421
    //   1531: astore_0
    //   1532: goto -349 -> 1183
    //   1535: astore_0
    //   1536: aload 17
    //   1538: astore 12
    //   1540: goto -357 -> 1183
    //   1543: astore 15
    //   1545: aload 12
    //   1547: astore_0
    //   1548: aconst_null
    //   1549: astore 12
    //   1551: aconst_null
    //   1552: astore 13
    //   1554: aconst_null
    //   1555: astore_1
    //   1556: iconst_0
    //   1557: istore_2
    //   1558: iconst_0
    //   1559: istore_3
    //   1560: iconst_0
    //   1561: istore 4
    //   1563: aconst_null
    //   1564: astore 14
    //   1566: goto -543 -> 1023
    //   1569: astore 15
    //   1571: aload_0
    //   1572: astore 16
    //   1574: aload 12
    //   1576: astore_0
    //   1577: aload 13
    //   1579: astore 12
    //   1581: aload 14
    //   1583: astore 13
    //   1585: aload 16
    //   1587: astore 14
    //   1589: goto -566 -> 1023
    //   1592: astore 15
    //   1594: aload_0
    //   1595: astore 17
    //   1597: iload 6
    //   1599: istore_3
    //   1600: iload_2
    //   1601: istore 4
    //   1603: aload 12
    //   1605: astore_0
    //   1606: aload 16
    //   1608: astore 12
    //   1610: aload 14
    //   1612: astore 13
    //   1614: aload_1
    //   1615: astore 14
    //   1617: aload 17
    //   1619: astore_1
    //   1620: iload 7
    //   1622: istore_2
    //   1623: goto -600 -> 1023
    //   1626: astore 15
    //   1628: aload 14
    //   1630: astore 13
    //   1632: aload 16
    //   1634: astore 14
    //   1636: goto -613 -> 1023
    //   1639: ldc_w 358
    //   1642: astore_0
    //   1643: ldc_w 358
    //   1646: astore_1
    //   1647: goto -1038 -> 609
    //   1650: aload_1
    //   1651: astore 13
    //   1653: aload_0
    //   1654: astore_1
    //   1655: iload_2
    //   1656: istore 5
    //   1658: aload 13
    //   1660: astore_0
    //   1661: aload 16
    //   1663: astore 13
    //   1665: iload 4
    //   1667: istore_2
    //   1668: iload 5
    //   1670: istore 4
    //   1672: goto -1257 -> 415
    //   1675: iload_3
    //   1676: istore 5
    //   1678: aload_1
    //   1679: astore 15
    //   1681: aload 13
    //   1683: astore 16
    //   1685: aload_0
    //   1686: astore_1
    //   1687: aload 15
    //   1689: astore_0
    //   1690: iload_2
    //   1691: istore_3
    //   1692: iload 4
    //   1694: istore_2
    //   1695: goto -1507 -> 188
    //   1698: aload 12
    //   1700: astore_0
    //   1701: aconst_null
    //   1702: astore 12
    //   1704: aconst_null
    //   1705: astore 14
    //   1707: aconst_null
    //   1708: astore_1
    //   1709: iconst_0
    //   1710: istore_2
    //   1711: iconst_0
    //   1712: istore_3
    //   1713: iconst_0
    //   1714: istore 4
    //   1716: aconst_null
    //   1717: astore 16
    //   1719: goto -1274 -> 445
    //   1722: aload_1
    //   1723: astore 15
    //   1725: aload_0
    //   1726: astore_1
    //   1727: iload_2
    //   1728: istore 5
    //   1730: aload 15
    //   1732: astore_0
    //   1733: iload 4
    //   1735: istore_2
    //   1736: iload 5
    //   1738: istore 4
    //   1740: goto -1325 -> 415
    //   1743: aload 16
    //   1745: astore 13
    //   1747: goto -25 -> 1722
    //   1750: aload_1
    //   1751: astore 15
    //   1753: aload_0
    //   1754: astore_1
    //   1755: iload_2
    //   1756: istore 5
    //   1758: aload 15
    //   1760: astore_0
    //   1761: iload 4
    //   1763: istore_2
    //   1764: iload 5
    //   1766: istore 4
    //   1768: goto -1353 -> 415
    //   1771: aload_1
    //   1772: ifnonnull -122 -> 1650
    //   1775: aload_0
    //   1776: astore_1
    //   1777: iload_2
    //   1778: istore 5
    //   1780: aload 13
    //   1782: astore_0
    //   1783: aload 16
    //   1785: astore 13
    //   1787: iload 4
    //   1789: istore_2
    //   1790: iload 5
    //   1792: istore 4
    //   1794: goto -1379 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1797	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1797	1	paramString	String
    //   187	1603	2	i	int
    //   182	1531	3	j	int
    //   401	1392	4	k	int
    //   184	1607	5	m	int
    //   193	1405	6	n	int
    //   189	1432	7	i1	int
    //   831	7	8	i2	int
    //   83	401	9	l	long
    //   164	221	11	bool	boolean
    //   150	1553	12	localObject1	Object
    //   202	1584	13	localObject2	Object
    //   175	1531	14	localObject3	Object
    //   390	590	15	localObject4	Object
    //   1001	41	15	localThrowable1	java.lang.Throwable
    //   1052	339	15	localObject5	Object
    //   1543	1	15	localThrowable2	java.lang.Throwable
    //   1569	1	15	localThrowable3	java.lang.Throwable
    //   1592	1	15	localThrowable4	java.lang.Throwable
    //   1626	1	15	localThrowable5	java.lang.Throwable
    //   1679	80	15	str	String
    //   172	1612	16	localObject6	Object
    //   9	1609	17	localObject7	Object
    //   92	1062	18	localObject8	Object
    //   66	1199	19	localObject9	Object
    //   24	592	20	localTroopInfo	TroopInfo
    //   78	295	21	localaptw	aptw
    // Exception table:
    //   from	to	target	type
    //   525	531	931	java/lang/Throwable
    //   80	152	1001	java/lang/Throwable
    //   1075	1081	1109	java/lang/Throwable
    //   80	152	1179	finally
    //   1188	1195	1197	java/lang/Throwable
    //   157	166	1531	finally
    //   195	204	1531	finally
    //   211	224	1531	finally
    //   231	244	1531	finally
    //   251	264	1531	finally
    //   271	284	1531	finally
    //   291	304	1531	finally
    //   311	322	1531	finally
    //   329	340	1531	finally
    //   347	360	1531	finally
    //   372	384	1531	finally
    //   415	432	1531	finally
    //   659	672	1531	finally
    //   711	719	1531	finally
    //   731	742	1531	finally
    //   749	757	1531	finally
    //   769	782	1531	finally
    //   792	800	1531	finally
    //   812	819	1531	finally
    //   826	833	1531	finally
    //   448	453	1535	finally
    //   456	462	1535	finally
    //   465	496	1535	finally
    //   1026	1032	1535	finally
    //   1035	1046	1535	finally
    //   157	166	1543	java/lang/Throwable
    //   415	432	1569	java/lang/Throwable
    //   195	204	1592	java/lang/Throwable
    //   211	224	1592	java/lang/Throwable
    //   231	244	1592	java/lang/Throwable
    //   251	264	1592	java/lang/Throwable
    //   271	284	1592	java/lang/Throwable
    //   291	304	1592	java/lang/Throwable
    //   311	322	1592	java/lang/Throwable
    //   329	340	1592	java/lang/Throwable
    //   347	360	1592	java/lang/Throwable
    //   372	384	1592	java/lang/Throwable
    //   659	672	1592	java/lang/Throwable
    //   711	719	1592	java/lang/Throwable
    //   731	742	1592	java/lang/Throwable
    //   749	757	1592	java/lang/Throwable
    //   769	782	1592	java/lang/Throwable
    //   792	800	1592	java/lang/Throwable
    //   812	819	1592	java/lang/Throwable
    //   826	833	1592	java/lang/Throwable
    //   448	453	1626	java/lang/Throwable
    //   456	462	1626	java/lang/Throwable
    //   465	496	1626	java/lang/Throwable
  }
  
  private boolean aBD()
  {
    Object localObject = a(this.app, this.troopUin);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V1 data=null");
      }
      return false;
    }
    int i = ((Integer)localObject[0]).intValue();
    int m = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    localObject = ((TroopManager)this.app.getManager(52)).a();
    int n = (int)(((aluk)localObject).yT * i);
    int k = (int)(((aluk)localObject).yU * i);
    if ((m >= n) && (j >= k) && (j > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkTipCondition_V1 nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) }));
      }
      if (!bool) {
        break;
      }
      return true;
    }
    if ((m < n) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
      m = ((String)localObject).length();
      anot.a(this.app, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, this.troopUin, "", ((String)localObject).substring(0, m - 1), "");
    }
    if ((j < k) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
      i = ((String)localObject).length();
      anot.a(this.app, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, this.troopUin, "", ((String)localObject).substring(0, i - 1), "");
    }
    return false;
  }
  
  private boolean aBE()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)this.app.getBusinessHandler(20)).a();
    List localList = gG();
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 notFrdMems not match");
      }
      return false;
    }
    this.uin = null;
    this.displayName = null;
    this.dXN = localList.size();
    int i = 0;
    while (i < localList.size())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localList.get(i);
      this.bZm = localTroopBatchAddFriendMgr.eS(localTroopMemberInfo.memberuin);
      if ((this.bZm >= 0) && (this.uin == null))
      {
        this.uin = localTroopMemberInfo.memberuin;
        this.displayName = a(this.app, localTroopMemberInfo);
        this.dXL = localTroopMemberInfo.commonFrdCnt;
      }
      if (localTroopMemberInfo.commonFrdCnt > this.dXM) {
        this.dXM = localTroopMemberInfo.commonFrdCnt;
      }
      i += 1;
    }
    if ((TextUtils.isEmpty(this.uin)) || (TextUtils.isEmpty(this.displayName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 already recommended");
      }
      mZ(localList);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "recommend " + this.uin);
    }
    return true;
  }
  
  public static String aG(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length > paramInt) {
      return paramString[paramInt];
    }
    return "";
  }
  
  public static String b(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      if (paramBoolean) {
        return "greyTips_exp";
      }
      return "greyTips_clk";
    case 2: 
      if (paramBoolean) {
        return "greyTips_exp_1";
      }
      return "greyTips_clk_1";
    case 3: 
      if (paramBoolean) {
        return "greyTips_exp_2";
      }
      return "greyTips_clk_2";
    case 4: 
      if (paramBoolean) {
        return "greyTips_exp_3";
      }
      return "greyTips_clk_3";
    }
    if (paramBoolean) {
      return "greyTips_exp_4";
    }
    return "greyTips_clk_4";
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, apwn paramapwn)
  {
    int j = paramapwn.dXN;
    int i = paramapwn.dXM;
    Object localObject1 = paramapwn.displayName;
    if ((paramQQAppInterface == null) || (paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "doInsertGrayTip invalidate params!");
      }
      return;
    }
    a(paramQQAppInterface, true, paramTroopInfo);
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V2 troopUin_type_nonFrdCnt_cmnFrdCnt=%s_%d_%d_%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramapwn.type), Integer.valueOf(j), Integer.valueOf(i) }));
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    Object localObject2 = paramQQAppInterface.b().f(paramTroopInfo.troopuin, 1);
    long l1;
    long l2;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
      l2 = anaz.gQ();
      if (j <= 1) {
        break label596;
      }
      localObject1 = String.format(Locale.getDefault(), crJ, new Object[] { localObject1, Integer.valueOf(j) });
      label208:
      if (i != 0) {
        break label619;
      }
    }
    label596:
    label619:
    for (localObject1 = (String)localObject1 + acfp.m(2131714013);; localObject1 = (String)localObject1 + acfp.m(2131714015))
    {
      localObject2 = acfp.m(2131714014);
      j = ((String)localObject1).indexOf((String)localObject2);
      int k = ((String)localObject2).length();
      localObject2 = new ahwa(paramTroopInfo.troopuin, paramTroopInfo.troopuin, (String)localObject1, 1, -5020, 135178, l2);
      ((ahwa)localObject2).wording = ((String)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 24);
      ((Bundle)localObject1).putString("key_action_DATA", paramTroopInfo.troopuin);
      ((Bundle)localObject1).putString("key_a_action_DATA", paramTroopInfo.troopcode);
      ((ahwa)localObject2).addHightlightItem(j, j + k, (Bundle)localObject1);
      ((ahwa)localObject2).bLT = (eO(paramapwn.type) + "-" + paramapwn.uin);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject1).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject1).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.b().b((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      paramTroopInfo.dwLastBAFTipMsgUniSeq2 = ((MessageForUniteGrayTip)localObject1).uniseq;
      localTroopManager.i(paramTroopInfo);
      localObject1 = ((acms)paramQQAppInterface.getBusinessHandler(20)).a();
      ((TroopBatchAddFriendMgr)localObject1).ib(paramapwn.uin, paramapwn.troopUin);
      if (paramapwn.type == 4) {
        ((TroopBatchAddFriendMgr)localObject1).TF(paramapwn.troopUin);
      }
      localObject1 = "1";
      if (i > 0) {
        localObject1 = "0";
      }
      apuh.n(paramQQAppInterface, paramTroopInfo.troopuin, l2);
      anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", b(true, paramapwn.type), 0, 0, paramTroopInfo.troopuin, Integer.toString(paramapwn.bZm), Integer.toString(paramTroopInfo.wMemberNum), (String)localObject1);
      return;
      l1 = Math.abs(new Random().nextInt());
      break;
      localObject1 = String.format(Locale.getDefault(), crK, new Object[] { localObject1 });
      break label208;
    }
  }
  
  public static String eO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "newJoin";
    case 2: 
      return "activeUser";
    case 3: 
      return "highFreqInteract";
    case 4: 
      return "newMember";
    }
    return "atMeOrReplyMe";
  }
  
  public static int eX(String paramString)
  {
    if ("newJoin".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("activeUser".equalsIgnoreCase(paramString)) {
      return 2;
    }
    if ("highFreqInteract".equalsIgnoreCase(paramString)) {
      return 3;
    }
    if ("newMember".equalsIgnoreCase(paramString)) {
      return 4;
    }
    if ("atMeOrReplyMe".equalsIgnoreCase(paramString)) {
      return 5;
    }
    return 0;
  }
  
  public static int en(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  public static int jR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 4: 
      return 5;
    }
    return 6;
  }
  
  public static int jS(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public static int jT(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 5;
    case 2: 
      return 6;
    case 3: 
      return 7;
    case 4: 
      return 8;
    }
    return 14;
  }
  
  public static boolean ml(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 6);
  }
  
  public static boolean u(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = v(paramQQAppInterface, paramString, paramInt);; bool = w(paramQQAppInterface, paramString, paramInt))
    {
      if (QLog.isColorLevel()) {}
      return bool;
    }
  }
  
  public static boolean v(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    aluk localaluk = ((TroopManager)localObject).a();
    if (localaluk.dxE != 1) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return false;
    }
    a(paramQQAppInterface, false, (TroopInfo)localObject);
    if (!localaluk.a((TroopInfo)localObject, aluk.aq)) {
      return false;
    }
    if (((TroopInfo)localObject).dwCmdUinJoinTime < localaluk.ahJ)
    {
      if ((QLog.isDevelopLevel()) && (((TroopInfo)localObject).dwCmdUinJoinTime == 0L)) {
        QLog.d("troopBatchAddFrd.Scene", 4, String.format(Locale.getDefault(), "checkCommCondition_V1 troop[%s] dwCmdUinJoinTime is 0!", new Object[] { paramString }));
      }
      return false;
    }
    if (TextUtils.equals(((TroopInfo)localObject).troopowneruin, paramQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    long l1 = localaluk.dxG * 86400;
    long l2 = NetConnInfoCenter.getServerTime();
    long l3 = l2 - ((TroopInfo)localObject).dwCmdUinJoinTime;
    if ((l3 > l1) || (l3 < 0L))
    {
      anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "joinDate", 0, 0, paramString, "", String.valueOf(l3 / 86400L), "");
      return false;
    }
    if (((TroopInfo)localObject).wMemberNum > localaluk.dxF)
    {
      anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, paramString, "", String.valueOf(((TroopInfo)localObject).wMemberNum), "");
      return false;
    }
    if (((TroopInfo)localObject).wClickBAFTipCount != 0) {
      return false;
    }
    if (((TroopInfo)localObject).wInsertBAFTipCount >= localaluk.dxH) {
      return false;
    }
    if ((((TroopInfo)localObject).wInsertBAFTipCount == 0) || (((TroopInfo)localObject).dwLastInsertBAFTipTime == 0L)) {
      return true;
    }
    if (l2 - ((TroopInfo)localObject).dwLastInsertBAFTipTime > 86400L) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "ONE_DAY_SECOND ");
    }
    return alui.A(((TroopInfo)localObject).dwLastInsertBAFTipTime, l2);
  }
  
  public static boolean w(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("checkCommCondition");
    localStringBuilder.append(" ").append(paramString).append("_").append(paramInt);
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      localStringBuilder.append(" ").append("err:").append("troopinfo is null");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    a(paramQQAppInterface, false, localTroopInfo);
    localObject = ((TroopManager)localObject).a();
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)paramQQAppInterface.getBusinessHandler(20)).a();
    String str = eO(paramInt);
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder.append(" ").append("err:").append("type invalid");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.qL(str))
    {
      localStringBuilder.append(" ").append("err:").append("switch off");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!((aluk)localObject).a(localTroopInfo, ((aluk)localObject).ar))
    {
      localStringBuilder.append(" ").append("err:").append("class invalid =").append(localTroopInfo.dwGroupClassExt);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (localTroopInfo.wMemberNum > ((aluk)localObject).dxW)
    {
      anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, localTroopInfo.troopuin, Integer.toString(en(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("member count").append(localTroopInfo.wMemberNum).append(">").append(((aluk)localObject).dxW);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.qM(paramString))
    {
      anot.a(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "grpNum", 0, 0, localTroopInfo.troopuin, Integer.toString(en(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("troop cant't insert tips ");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    localStringBuilder.append(" ").append("suc");
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public int LI()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.troopUin);
    if (localTroopInfo == null) {
      return -1;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", this.app.getCurrentAccountUin(), this.troopUin }), 0);
    if (i == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkSecurity need execute security check!");
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.Scene", 2, String.format("checkSecurity return %s. net connect err", new Object[] { localTroopInfo.troopuin }));
        }
        return -1;
      }
      ((acms)this.app.getBusinessHandler(20)).h(localTroopInfo.troopuin, localTroopInfo.troopcode, this.ts, this.type);
      return 0;
    }
    if (i != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "checkSecurity fail value: %s", new Object[] { Integer.valueOf(i) }));
      }
      return -1;
    }
    return 1;
  }
  
  public int LJ()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.app.getCurrentAccountUin(), this.troopUin }), 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkDataTroopMemberList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.type), this.troopUin }));
      }
      int i = j;
      if (bool) {
        i = j;
      }
      switch (((acms)this.app.getBusinessHandler(20)).a().b(this.troopUin, l, this.type))
      {
      default: 
        i = -1;
      case 1: 
        return i;
      }
    }
    return 0;
  }
  
  public int LK()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.app.getCurrentAccountUin(), this.troopUin }), 0L);
    Object localObject = ((TroopManager)this.app.getManager(52)).a();
    label109:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((aluk)localObject).dxX * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataCmnFrdCntList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.type), this.troopUin }));
      if (!bool)
      {
        i = j;
        if (this.type != 4) {}
      }
      else
      {
        localObject = ((acms)this.app.getBusinessHandler(20)).a();
        str = this.troopUin;
        k = this.type;
        if (!bool) {
          break label258;
        }
      }
    }
    label258:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool, this.Iy))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label109;
      }
    }
    return 0;
  }
  
  public int LL()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.app.getCurrentAccountUin(), this.troopUin }), 0L);
    Object localObject = ((TroopManager)this.app.getManager(52)).a();
    label109:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((aluk)localObject).dxY * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataRecmdRemarkList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.type), this.troopUin }));
      if (!bool)
      {
        i = j;
        if (this.type != 4) {}
      }
      else
      {
        localObject = ((acms)this.app.getBusinessHandler(20)).a();
        str = this.troopUin;
        k = this.type;
        if (!bool) {
          break label254;
        }
      }
    }
    label254:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label109;
      }
    }
    return 0;
  }
  
  public int LM()
  {
    if (this.type == 1) {}
    for (boolean bool = aBD(); (!QLog.isColorLevel()) || (bool); bool = aBE()) {
      return 1;
    }
    return -1;
  }
  
  public void Uc(String paramString)
  {
    this.state = -1;
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, String.format("onErr %s", new Object[] { paramString }));
    }
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public boolean aBF()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.troopUin);
    if (localTroopInfo == null)
    {
      this.state = -1;
      return false;
    }
    if (this.state != 5) {
      return false;
    }
    if (this.type == 1) {
      a(this.app, localTroopInfo, this);
    }
    for (;;)
    {
      this.state = 6;
      return true;
      b(this.app, localTroopInfo, this);
    }
  }
  
  public void bI(boolean paramBoolean, int paramInt)
  {
    int j = -1;
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("onStepAndNext troopUin_type_ts_suc_step=%s_%d_%d_%b_%d", new Object[] { this.troopUin, Integer.valueOf(this.type), Long.valueOf(this.ts), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    int i;
    if (paramBoolean)
    {
      i = paramInt;
      label66:
      this.state = i;
      if (this.state != 0) {
        break label118;
      }
      i = LI();
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      default: 
        return;
        i = -1;
        break label66;
        label118:
        if (this.state == 1)
        {
          i = LJ();
        }
        else if (this.state == 2)
        {
          i = LK();
        }
        else if (this.state == 3)
        {
          i = LM();
        }
        else if (this.state == 4)
        {
          i = LL();
        }
        else
        {
          if (this.state == 5)
          {
            ecv();
            return;
          }
          i = j;
          if (this.state == -1) {
            i = j;
          }
        }
        break;
      }
    }
    Uc(String.format("onStepAndNext err %s_%d_%d_%b_%d", new Object[] { this.troopUin, Integer.valueOf(this.type), Long.valueOf(this.ts), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    return;
    bI(true, this.state + 1);
  }
  
  public void ecv()
  {
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, "onSuc troopUin = " + this.troopUin + ",type = " + this.type + ",ts=" + this.ts);
    }
    if (this.a != null) {
      this.a.a(this);
    }
  }
  
  List<TroopMemberInfo> gG()
  {
    Object localObject1 = (TroopManager)this.app.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).a();
    localObject1 = ((TroopManager)localObject1).b(this.troopUin);
    int k = ((aluk)localObject2).iM(this.type);
    int j;
    int i;
    switch (this.type)
    {
    default: 
      return null;
    case 2: 
      localObject2 = a(this.app, this.troopUin, null, true);
      j = 0;
      i = 0;
      if (j < ((List)localObject2).size())
      {
        if (((TroopMemberInfo)((List)localObject2).get(j)).commonFrdCnt <= 0) {
          break label865;
        }
        i += 1;
      }
      break;
    }
    label859:
    label865:
    for (;;)
    {
      j += 1;
      break;
      if (i < k)
      {
        localObject2 = this.app;
        Object localObject3 = this.troopUin;
        String str = Integer.toString(i);
        if (localObject1 == null) {}
        for (i = 0;; i = ((TroopInfo)localObject1).wMemberNum)
        {
          anot.a((QQAppInterface)localObject2, "dc00899", "Grp_addFrd", "", "nonGreyTip", "actvie-res", 0, 0, (String)localObject3, str, Integer.toString(i), "");
          return null;
        }
        localObject1 = new ArrayList();
        localObject2 = a(this.app, this.troopUin, this.Iy, true);
        j = 0;
        i = 0;
        if (j < ((List)localObject2).size())
        {
          localObject3 = (TroopMemberInfo)((List)localObject2).get(j);
          if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
            }
            ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
          }
          if (((TroopMemberInfo)localObject3).commonFrdCnt < i) {
            break label859;
          }
          i = ((TroopMemberInfo)localObject3).commonFrdCnt;
        }
        for (;;)
        {
          if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
          break;
          if (((List)localObject1).size() == 0)
          {
            anot.a(this.app, "dc00899", "Grp_addFrd", "", "nonGreyTip", "discus-res", 0, 0, this.troopUin, Integer.toString(i), Integer.toString(((List)localObject2).size()), "");
            return localObject1;
            localObject1 = new ArrayList();
            localObject2 = a(this.app, this.troopUin, this.Iy, false);
            i = 0;
            while (i < ((List)localObject2).size())
            {
              localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
              if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                }
                ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
              }
              if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                ((List)localObject1).add(localObject3);
              }
              i += 1;
            }
            if (((List)localObject1).size() == 0)
            {
              localObject3 = this.app;
              str = this.troopUin;
              if (((List)localObject2).size() == 0) {}
              for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
              {
                anot.a((QQAppInterface)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "new_res", 0, 0, str, Integer.toString(i), "", "");
                return localObject1;
              }
              localObject1 = new ArrayList();
              localObject2 = a(this.app, this.troopUin, this.Iy, false);
              i = 0;
              while (i < ((List)localObject2).size())
              {
                localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
                if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                  }
                  ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
                }
                if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                  ((List)localObject1).add(localObject3);
                }
                i += 1;
              }
              if (((List)localObject1).size() == 0)
              {
                localObject3 = this.app;
                str = this.troopUin;
                if (((List)localObject2).size() == 0) {}
                for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
                {
                  anot.a((QQAppInterface)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "@_res", 0, 0, str, Integer.toString(i), "", "");
                  return localObject1;
                }
              }
              return localObject1;
            }
            return localObject1;
          }
          return localObject1;
        }
      }
      return localObject2;
    }
  }
  
  public boolean isValid()
  {
    return (this.state != -1) && (this.state != 6);
  }
  
  void mZ(List<TroopMemberInfo> paramList)
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)this.app.getBusinessHandler(20)).a();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (localTroopBatchAddFriendMgr.eR(((TroopMemberInfo)paramList.next()).memberuin) >= 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramList = ((TroopManager)this.app.getManager(52)).b(this.troopUin);
        if (paramList != null) {
          break label142;
        }
      }
      label142:
      for (i = 0;; i = paramList.wMemberNum)
      {
        anot.a(this.app, "dc00899", "Grp_addFrd", "", "nonGreyTip", "UinNum_total", 0, 0, this.troopUin, Integer.toString(en(this.type)), Integer.toString(i), "");
        return;
      }
    }
  }
  
  public void startCheck()
  {
    if (this.state == 5) {
      ecv();
    }
    if (this.state != 0) {
      return;
    }
    bI(true, 0);
  }
  
  public static abstract interface a
  {
    public abstract void a(apwn paramapwn);
    
    public abstract void b(apwn paramapwn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwn
 * JD-Core Version:    0.7.0.1
 */