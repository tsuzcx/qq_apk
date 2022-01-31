package com.tencent.mobileqq.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class SystemMsg
  extends JceStruct
{
  private static final String TAG = "Q.systemmsg.SystemMsg";
  public String append;
  public byte[] auth;
  public int cVession;
  public String inviteMemUin;
  public long lToMobile;
  public String managerUin;
  public String message;
  public byte op;
  public String requestUin;
  public String sMsg;
  public String strAddressBookNickName;
  public String strGroupName;
  public String strGroupNickName;
  public long strGroupUin;
  public String strNickName;
  public String strServerFromUinNickName = "";
  public String troopCode;
  public byte troopType;
  public int wSourceID;
  public int wSourceSubID;
  
  /* Error */
  public static SystemMsg decode(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 8
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_1
    //   16: ifnull +4518 -> 4534
    //   19: iload_3
    //   20: invokestatic 51	com/tencent/mobileqq/data/SystemMsg:isTroopSystemMessage	(I)Z
    //   23: ifeq +2527 -> 2550
    //   26: aload_1
    //   27: invokestatic 57	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   30: astore_2
    //   31: new 2	com/tencent/mobileqq/data/SystemMsg
    //   34: dup
    //   35: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: astore 9
    //   42: aload_1
    //   43: astore 10
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 62	com/tencent/mobileqq/data/SystemMsg:getTroopCodeFromTroopSysMsg	([B)Ljava/lang/String;
    //   50: putfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   53: aload_1
    //   54: astore 9
    //   56: aload_1
    //   57: astore 10
    //   59: aload_1
    //   60: aload_2
    //   61: invokestatic 68	com/tencent/mobileqq/data/SystemMsg:getTroopTypeFromTroopSysMsg	([B)B
    //   64: putfield 70	com/tencent/mobileqq/data/SystemMsg:troopType	B
    //   67: aload_1
    //   68: astore 9
    //   70: aload_1
    //   71: astore 10
    //   73: aload_1
    //   74: aload_2
    //   75: iload_3
    //   76: invokestatic 74	com/tencent/mobileqq/data/SystemMsg:getManagerUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   79: putfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   82: aload_1
    //   83: astore 9
    //   85: aload_1
    //   86: astore 10
    //   88: aload_1
    //   89: aload_2
    //   90: iload_3
    //   91: invokestatic 79	com/tencent/mobileqq/data/SystemMsg:getStrMsgFromTroopSysMsg	([BI)Ljava/lang/String;
    //   94: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   97: aload_1
    //   98: astore 9
    //   100: aload_1
    //   101: astore 10
    //   103: aload_1
    //   104: aload_2
    //   105: iload_3
    //   106: invokestatic 85	com/tencent/mobileqq/data/SystemMsg:getTroopOpFromTroopSysMsg	([BI)B
    //   109: putfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   112: aload_1
    //   113: astore 9
    //   115: aload_1
    //   116: astore 10
    //   118: aload_1
    //   119: aload_2
    //   120: iload_3
    //   121: invokestatic 90	com/tencent/mobileqq/data/SystemMsg:getRequestUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   124: putfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   127: aload_1
    //   128: astore 9
    //   130: aload_1
    //   131: astore 10
    //   133: aload_1
    //   134: aload_2
    //   135: iload_3
    //   136: invokestatic 96	com/tencent/mobileqq/data/SystemMsg:getAuthFromTroopSysMsg	([BI)[B
    //   139: putfield 98	com/tencent/mobileqq/data/SystemMsg:auth	[B
    //   142: aload_1
    //   143: astore 9
    //   145: aload_1
    //   146: astore 10
    //   148: aload_1
    //   149: aload_2
    //   150: iload_3
    //   151: invokestatic 101	com/tencent/mobileqq/data/SystemMsg:getInviteUinFromTroopSysMsg	([BI)Ljava/lang/String;
    //   154: putfield 103	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   157: aload_1
    //   158: astore 9
    //   160: aload_1
    //   161: astore 10
    //   163: aload_0
    //   164: aload_1
    //   165: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   168: iconst_1
    //   169: invokestatic 108	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore 9
    //   176: aload_1
    //   177: astore 10
    //   179: aload_0
    //   180: aload_1
    //   181: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   184: iconst_1
    //   185: invokestatic 111	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   188: astore 11
    //   190: aload_1
    //   191: astore 9
    //   193: aload_1
    //   194: astore 10
    //   196: aload_0
    //   197: aload_1
    //   198: getfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   201: iconst_1
    //   202: invokestatic 111	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   205: astore 12
    //   207: aload_1
    //   208: astore 9
    //   210: aload_1
    //   211: astore 10
    //   213: aload_0
    //   214: aload_1
    //   215: getfield 103	com/tencent/mobileqq/data/SystemMsg:inviteMemUin	Ljava/lang/String;
    //   218: iconst_1
    //   219: invokestatic 111	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   222: astore 13
    //   224: iload_3
    //   225: lookupswitch	default:+4311->4536, -1023:+844->1069, -1022:+252->477, -1021:+107->332, -1020:+453->678, 35:+453->678, 36:+107->332, 37:+252->477, 46:+844->1069, 84:+453->678, 85:+107->332, 86:+252->477, 87:+844->1069
    //   333: astore 9
    //   335: aload_1
    //   336: astore 10
    //   338: aload_1
    //   339: getfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   342: ifnull +74 -> 416
    //   345: aload_1
    //   346: astore 9
    //   348: aload_1
    //   349: astore 10
    //   351: aload_1
    //   352: getfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   355: aload 12
    //   357: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifne +56 -> 416
    //   363: aload_1
    //   364: astore 9
    //   366: aload_1
    //   367: astore 10
    //   369: aload_1
    //   370: new 119	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   377: aload 12
    //   379: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 125
    //   384: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   390: ldc 132
    //   392: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   395: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   404: aload_1
    //   405: areturn
    //   406: astore_1
    //   407: aload 9
    //   409: astore_0
    //   410: aload_1
    //   411: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   414: aload_0
    //   415: areturn
    //   416: aload_1
    //   417: astore 9
    //   419: aload_1
    //   420: astore 10
    //   422: aload_1
    //   423: new 119	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   430: ldc 149
    //   432: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 12
    //   437: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 149
    //   442: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc 125
    //   447: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   453: ldc 132
    //   455: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   458: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   467: aload_1
    //   468: areturn
    //   469: astore_0
    //   470: aload_0
    //   471: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   474: aload 10
    //   476: areturn
    //   477: aload_1
    //   478: astore 9
    //   480: aload_1
    //   481: astore 10
    //   483: aload_1
    //   484: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   487: ifnull +24 -> 511
    //   490: aload_1
    //   491: astore 9
    //   493: aload_1
    //   494: astore 10
    //   496: ldc 38
    //   498: aload_1
    //   499: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   502: invokevirtual 153	java/lang/String:trim	()Ljava/lang/String;
    //   505: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifeq +103 -> 611
    //   511: aload_1
    //   512: astore 9
    //   514: aload_1
    //   515: astore 10
    //   517: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   520: ldc 154
    //   522: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   525: astore_0
    //   526: aload_1
    //   527: astore 9
    //   529: aload_1
    //   530: astore 10
    //   532: aload_1
    //   533: aload_0
    //   534: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   537: aload_1
    //   538: astore 9
    //   540: aload_1
    //   541: astore 10
    //   543: aload_1
    //   544: getfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   547: ifnull +78 -> 625
    //   550: aload_1
    //   551: astore 9
    //   553: aload_1
    //   554: astore 10
    //   556: aload_1
    //   557: getfield 76	com/tencent/mobileqq/data/SystemMsg:managerUin	Ljava/lang/String;
    //   560: aload 12
    //   562: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifne +60 -> 625
    //   568: aload_1
    //   569: astore 9
    //   571: aload_1
    //   572: astore 10
    //   574: aload_1
    //   575: new 119	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   582: aload 12
    //   584: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc 125
    //   589: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   595: ldc 155
    //   597: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   600: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   609: aload_1
    //   610: areturn
    //   611: aload_1
    //   612: astore 9
    //   614: aload_1
    //   615: astore 10
    //   617: aload_1
    //   618: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   621: astore_0
    //   622: goto -96 -> 526
    //   625: aload_1
    //   626: astore 9
    //   628: aload_1
    //   629: astore 10
    //   631: aload_1
    //   632: new 119	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   639: ldc 149
    //   641: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 12
    //   646: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc 149
    //   651: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc 125
    //   656: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   662: ldc 155
    //   664: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   667: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   676: aload_1
    //   677: areturn
    //   678: aload_1
    //   679: astore 9
    //   681: aload_1
    //   682: astore 10
    //   684: aload_1
    //   685: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   688: ifnull +21 -> 709
    //   691: aload_1
    //   692: astore 9
    //   694: aload_1
    //   695: astore 10
    //   697: ldc 38
    //   699: aload_1
    //   700: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   703: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   706: ifeq +137 -> 843
    //   709: aload_1
    //   710: astore 9
    //   712: aload_1
    //   713: astore 10
    //   715: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   718: ldc 154
    //   720: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   723: astore_0
    //   724: aload_1
    //   725: astore 9
    //   727: aload_1
    //   728: astore 10
    //   730: aload_1
    //   731: aload_0
    //   732: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   735: aload_1
    //   736: astore 9
    //   738: aload_1
    //   739: astore 10
    //   741: aload_1
    //   742: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   745: ifnull +169 -> 914
    //   748: aload_1
    //   749: astore 9
    //   751: aload_1
    //   752: astore 10
    //   754: aload_1
    //   755: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   758: aload_2
    //   759: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   762: ifne +152 -> 914
    //   765: aload_1
    //   766: astore 9
    //   768: aload_1
    //   769: astore 10
    //   771: aload_1
    //   772: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   775: ifnull +82 -> 857
    //   778: aload_1
    //   779: astore 9
    //   781: aload_1
    //   782: astore 10
    //   784: aload_1
    //   785: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   788: aload 11
    //   790: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   793: ifne +64 -> 857
    //   796: aload_1
    //   797: astore 9
    //   799: aload_1
    //   800: astore 10
    //   802: aload_1
    //   803: new 119	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   810: aload 11
    //   812: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: ldc 125
    //   817: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   823: ldc 156
    //   825: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   828: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload_2
    //   832: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   841: aload_1
    //   842: areturn
    //   843: aload_1
    //   844: astore 9
    //   846: aload_1
    //   847: astore 10
    //   849: aload_1
    //   850: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   853: astore_0
    //   854: goto -130 -> 724
    //   857: aload_1
    //   858: astore 9
    //   860: aload_1
    //   861: astore 10
    //   863: aload_1
    //   864: new 119	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   871: ldc 149
    //   873: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload 11
    //   878: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc 149
    //   883: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: ldc 125
    //   888: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   894: ldc 156
    //   896: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   899: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: aload_2
    //   903: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   912: aload_1
    //   913: areturn
    //   914: aload_1
    //   915: astore 9
    //   917: aload_1
    //   918: astore 10
    //   920: aload_1
    //   921: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   924: ifnull +78 -> 1002
    //   927: aload_1
    //   928: astore 9
    //   930: aload_1
    //   931: astore 10
    //   933: aload_1
    //   934: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   937: aload 11
    //   939: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   942: ifne +60 -> 1002
    //   945: aload_1
    //   946: astore 9
    //   948: aload_1
    //   949: astore 10
    //   951: aload_1
    //   952: new 119	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   959: aload 11
    //   961: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc 125
    //   966: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   972: ldc 156
    //   974: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   977: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: ldc 149
    //   982: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload_2
    //   986: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: ldc 149
    //   991: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1000: aload_1
    //   1001: areturn
    //   1002: aload_1
    //   1003: astore 9
    //   1005: aload_1
    //   1006: astore 10
    //   1008: aload_1
    //   1009: new 119	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1016: ldc 149
    //   1018: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: aload 11
    //   1023: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: ldc 149
    //   1028: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: ldc 125
    //   1033: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1039: ldc 156
    //   1041: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1044: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc 149
    //   1049: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload_2
    //   1053: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc 149
    //   1058: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1067: aload_1
    //   1068: areturn
    //   1069: aload_1
    //   1070: astore 9
    //   1072: aload_1
    //   1073: astore 10
    //   1075: aload_1
    //   1076: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1079: ifnull +21 -> 1100
    //   1082: aload_1
    //   1083: astore 9
    //   1085: aload_1
    //   1086: astore 10
    //   1088: ldc 38
    //   1090: aload_1
    //   1091: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1094: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1097: ifeq +165 -> 1262
    //   1100: aload_1
    //   1101: astore 9
    //   1103: aload_1
    //   1104: astore 10
    //   1106: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1109: ldc 154
    //   1111: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1114: astore_0
    //   1115: aload_1
    //   1116: astore 9
    //   1118: aload_1
    //   1119: astore 10
    //   1121: aload_1
    //   1122: aload_0
    //   1123: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1126: aload_1
    //   1127: astore 9
    //   1129: aload_1
    //   1130: astore 10
    //   1132: aload_1
    //   1133: getfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1136: iconst_1
    //   1137: if_icmpeq +17 -> 1154
    //   1140: aload_1
    //   1141: astore 9
    //   1143: aload_1
    //   1144: astore 10
    //   1146: aload_1
    //   1147: getfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1150: iconst_4
    //   1151: if_icmpne +337 -> 1488
    //   1154: aload_1
    //   1155: astore 9
    //   1157: aload_1
    //   1158: astore 10
    //   1160: aload_1
    //   1161: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1164: ifnull +169 -> 1333
    //   1167: aload_1
    //   1168: astore 9
    //   1170: aload_1
    //   1171: astore 10
    //   1173: aload_1
    //   1174: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1177: aload_2
    //   1178: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1181: ifne +152 -> 1333
    //   1184: aload_1
    //   1185: astore 9
    //   1187: aload_1
    //   1188: astore 10
    //   1190: aload_1
    //   1191: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1194: ifnull +82 -> 1276
    //   1197: aload_1
    //   1198: astore 9
    //   1200: aload_1
    //   1201: astore 10
    //   1203: aload_1
    //   1204: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1207: aload 11
    //   1209: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1212: ifne +64 -> 1276
    //   1215: aload_1
    //   1216: astore 9
    //   1218: aload_1
    //   1219: astore 10
    //   1221: aload_1
    //   1222: new 119	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1229: aload 11
    //   1231: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc 125
    //   1236: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1242: ldc 157
    //   1244: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1247: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: aload_2
    //   1251: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1260: aload_1
    //   1261: areturn
    //   1262: aload_1
    //   1263: astore 9
    //   1265: aload_1
    //   1266: astore 10
    //   1268: aload_1
    //   1269: getfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   1272: astore_0
    //   1273: goto -158 -> 1115
    //   1276: aload_1
    //   1277: astore 9
    //   1279: aload_1
    //   1280: astore 10
    //   1282: aload_1
    //   1283: new 119	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1290: ldc 149
    //   1292: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload 11
    //   1297: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: ldc 149
    //   1302: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: ldc 125
    //   1307: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1313: ldc 157
    //   1315: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1318: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: aload_2
    //   1322: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1331: aload_1
    //   1332: areturn
    //   1333: aload_1
    //   1334: astore 9
    //   1336: aload_1
    //   1337: astore 10
    //   1339: aload_1
    //   1340: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1343: ifnull +78 -> 1421
    //   1346: aload_1
    //   1347: astore 9
    //   1349: aload_1
    //   1350: astore 10
    //   1352: aload_1
    //   1353: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1356: aload 11
    //   1358: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1361: ifne +60 -> 1421
    //   1364: aload_1
    //   1365: astore 9
    //   1367: aload_1
    //   1368: astore 10
    //   1370: aload_1
    //   1371: new 119	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1378: aload 11
    //   1380: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: ldc 125
    //   1385: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1391: ldc 157
    //   1393: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1396: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc 149
    //   1401: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: aload_2
    //   1405: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: ldc 149
    //   1410: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1419: aload_1
    //   1420: areturn
    //   1421: aload_1
    //   1422: astore 9
    //   1424: aload_1
    //   1425: astore 10
    //   1427: aload_1
    //   1428: new 119	java/lang/StringBuilder
    //   1431: dup
    //   1432: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1435: ldc 149
    //   1437: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: aload 11
    //   1442: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: ldc 149
    //   1447: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: ldc 125
    //   1452: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1458: ldc 157
    //   1460: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1463: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: ldc 149
    //   1468: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: aload_2
    //   1472: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: ldc 149
    //   1477: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1486: aload_1
    //   1487: areturn
    //   1488: aload_1
    //   1489: astore 9
    //   1491: aload_1
    //   1492: astore 10
    //   1494: aload_1
    //   1495: getfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1498: iconst_2
    //   1499: if_icmpne +323 -> 1822
    //   1502: aload_1
    //   1503: astore 9
    //   1505: aload_1
    //   1506: astore 10
    //   1508: aload_1
    //   1509: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1512: ifnull +155 -> 1667
    //   1515: aload_1
    //   1516: astore 9
    //   1518: aload_1
    //   1519: astore 10
    //   1521: aload_1
    //   1522: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1525: aload_2
    //   1526: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1529: ifne +138 -> 1667
    //   1532: aload_1
    //   1533: astore 9
    //   1535: aload_1
    //   1536: astore 10
    //   1538: aload_1
    //   1539: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1542: ifnull +68 -> 1610
    //   1545: aload_1
    //   1546: astore 9
    //   1548: aload_1
    //   1549: astore 10
    //   1551: aload_1
    //   1552: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1555: aload 11
    //   1557: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1560: ifne +50 -> 1610
    //   1563: aload_1
    //   1564: astore 9
    //   1566: aload_1
    //   1567: astore 10
    //   1569: aload_1
    //   1570: new 119	java/lang/StringBuilder
    //   1573: dup
    //   1574: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1577: aload 11
    //   1579: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: ldc 125
    //   1584: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1590: ldc 158
    //   1592: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1595: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: aload_2
    //   1599: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1608: aload_1
    //   1609: areturn
    //   1610: aload_1
    //   1611: astore 9
    //   1613: aload_1
    //   1614: astore 10
    //   1616: aload_1
    //   1617: new 119	java/lang/StringBuilder
    //   1620: dup
    //   1621: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1624: ldc 149
    //   1626: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: aload 11
    //   1631: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: ldc 149
    //   1636: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: ldc 125
    //   1641: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1647: ldc 158
    //   1649: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1652: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: aload_2
    //   1656: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1665: aload_1
    //   1666: areturn
    //   1667: aload_1
    //   1668: astore 9
    //   1670: aload_1
    //   1671: astore 10
    //   1673: aload_1
    //   1674: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1677: ifnull +78 -> 1755
    //   1680: aload_1
    //   1681: astore 9
    //   1683: aload_1
    //   1684: astore 10
    //   1686: aload_1
    //   1687: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1690: aload 11
    //   1692: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1695: ifne +60 -> 1755
    //   1698: aload_1
    //   1699: astore 9
    //   1701: aload_1
    //   1702: astore 10
    //   1704: aload_1
    //   1705: new 119	java/lang/StringBuilder
    //   1708: dup
    //   1709: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1712: aload 11
    //   1714: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: ldc 125
    //   1719: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1725: ldc 158
    //   1727: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1730: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: ldc 149
    //   1735: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload_2
    //   1739: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: ldc 149
    //   1744: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1750: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1753: aload_1
    //   1754: areturn
    //   1755: aload_1
    //   1756: astore 9
    //   1758: aload_1
    //   1759: astore 10
    //   1761: aload_1
    //   1762: new 119	java/lang/StringBuilder
    //   1765: dup
    //   1766: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1769: ldc 149
    //   1771: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload 11
    //   1776: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: ldc 149
    //   1781: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: ldc 125
    //   1786: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1792: ldc 158
    //   1794: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1797: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1800: ldc 149
    //   1802: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: aload_2
    //   1806: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: ldc 149
    //   1811: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1817: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1820: aload_1
    //   1821: areturn
    //   1822: aload_1
    //   1823: astore 9
    //   1825: aload_1
    //   1826: astore 10
    //   1828: aload_1
    //   1829: getfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   1832: iconst_3
    //   1833: if_icmpne +323 -> 2156
    //   1836: aload_1
    //   1837: astore 9
    //   1839: aload_1
    //   1840: astore 10
    //   1842: aload_1
    //   1843: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1846: ifnull +155 -> 2001
    //   1849: aload_1
    //   1850: astore 9
    //   1852: aload_1
    //   1853: astore 10
    //   1855: aload_1
    //   1856: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   1859: aload_2
    //   1860: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1863: ifne +138 -> 2001
    //   1866: aload_1
    //   1867: astore 9
    //   1869: aload_1
    //   1870: astore 10
    //   1872: aload_1
    //   1873: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1876: ifnull +68 -> 1944
    //   1879: aload_1
    //   1880: astore 9
    //   1882: aload_1
    //   1883: astore 10
    //   1885: aload_1
    //   1886: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   1889: aload 11
    //   1891: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1894: ifne +50 -> 1944
    //   1897: aload_1
    //   1898: astore 9
    //   1900: aload_1
    //   1901: astore 10
    //   1903: aload_1
    //   1904: new 119	java/lang/StringBuilder
    //   1907: dup
    //   1908: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1911: aload 11
    //   1913: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: ldc 125
    //   1918: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1924: ldc 159
    //   1926: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1929: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: aload_2
    //   1933: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1942: aload_1
    //   1943: areturn
    //   1944: aload_1
    //   1945: astore 9
    //   1947: aload_1
    //   1948: astore 10
    //   1950: aload_1
    //   1951: new 119	java/lang/StringBuilder
    //   1954: dup
    //   1955: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1958: ldc 149
    //   1960: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: aload 11
    //   1965: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: ldc 149
    //   1970: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: ldc 125
    //   1975: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1981: ldc 159
    //   1983: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   1986: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: aload_2
    //   1990: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1996: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   1999: aload_1
    //   2000: areturn
    //   2001: aload_1
    //   2002: astore 9
    //   2004: aload_1
    //   2005: astore 10
    //   2007: aload_1
    //   2008: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2011: ifnull +78 -> 2089
    //   2014: aload_1
    //   2015: astore 9
    //   2017: aload_1
    //   2018: astore 10
    //   2020: aload_1
    //   2021: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2024: aload 11
    //   2026: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2029: ifne +60 -> 2089
    //   2032: aload_1
    //   2033: astore 9
    //   2035: aload_1
    //   2036: astore 10
    //   2038: aload_1
    //   2039: new 119	java/lang/StringBuilder
    //   2042: dup
    //   2043: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2046: aload 11
    //   2048: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: ldc 125
    //   2053: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2059: ldc 159
    //   2061: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2064: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2067: ldc 149
    //   2069: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: aload_2
    //   2073: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: ldc 149
    //   2078: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2081: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2084: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2087: aload_1
    //   2088: areturn
    //   2089: aload_1
    //   2090: astore 9
    //   2092: aload_1
    //   2093: astore 10
    //   2095: aload_1
    //   2096: new 119	java/lang/StringBuilder
    //   2099: dup
    //   2100: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2103: ldc 149
    //   2105: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: aload 11
    //   2110: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: ldc 149
    //   2115: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: ldc 125
    //   2120: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2126: ldc 159
    //   2128: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2131: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: ldc 149
    //   2136: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2139: aload_2
    //   2140: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: ldc 149
    //   2145: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2151: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2154: aload_1
    //   2155: areturn
    //   2156: aload_1
    //   2157: astore 9
    //   2159: aload_1
    //   2160: astore 10
    //   2162: aload_1
    //   2163: getfield 87	com/tencent/mobileqq/data/SystemMsg:op	B
    //   2166: iconst_5
    //   2167: if_icmpne +2369 -> 4536
    //   2170: aload_1
    //   2171: astore 9
    //   2173: aload_1
    //   2174: astore 10
    //   2176: aload_1
    //   2177: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   2180: ifnull +213 -> 2393
    //   2183: aload_1
    //   2184: astore 9
    //   2186: aload_1
    //   2187: astore 10
    //   2189: aload_1
    //   2190: getfield 64	com/tencent/mobileqq/data/SystemMsg:troopCode	Ljava/lang/String;
    //   2193: aload_2
    //   2194: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2197: ifne +196 -> 2393
    //   2200: aload_1
    //   2201: astore 9
    //   2203: aload_1
    //   2204: astore 10
    //   2206: aload_1
    //   2207: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2210: ifnull +125 -> 2335
    //   2213: aload_1
    //   2214: astore 9
    //   2216: aload_1
    //   2217: astore 10
    //   2219: aload_1
    //   2220: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2223: aload 11
    //   2225: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2228: ifne +107 -> 2335
    //   2231: aload_1
    //   2232: astore 9
    //   2234: aload_1
    //   2235: astore 10
    //   2237: aload_1
    //   2238: new 119	java/lang/StringBuilder
    //   2241: dup
    //   2242: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2245: aload 11
    //   2247: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: ldc 125
    //   2252: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2258: ldc 156
    //   2260: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2263: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: aload_2
    //   2267: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2273: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2276: aload_1
    //   2277: astore 9
    //   2279: aload_1
    //   2280: astore 10
    //   2282: aload_1
    //   2283: new 119	java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2290: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2293: ldc 160
    //   2295: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2298: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: ldc 125
    //   2303: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: aload 13
    //   2308: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: ldc 125
    //   2313: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2319: ldc 161
    //   2321: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2324: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2327: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2330: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   2333: aload_1
    //   2334: areturn
    //   2335: aload_1
    //   2336: astore 9
    //   2338: aload_1
    //   2339: astore 10
    //   2341: aload_1
    //   2342: new 119	java/lang/StringBuilder
    //   2345: dup
    //   2346: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2349: ldc 149
    //   2351: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2354: aload 11
    //   2356: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: ldc 149
    //   2361: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2364: ldc 125
    //   2366: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2372: ldc 156
    //   2374: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2377: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: aload_2
    //   2381: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2387: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2390: goto -114 -> 2276
    //   2393: aload_1
    //   2394: astore 9
    //   2396: aload_1
    //   2397: astore 10
    //   2399: aload_1
    //   2400: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2403: ifnull +79 -> 2482
    //   2406: aload_1
    //   2407: astore 9
    //   2409: aload_1
    //   2410: astore 10
    //   2412: aload_1
    //   2413: getfield 92	com/tencent/mobileqq/data/SystemMsg:requestUin	Ljava/lang/String;
    //   2416: aload 11
    //   2418: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2421: ifne +61 -> 2482
    //   2424: aload_1
    //   2425: astore 9
    //   2427: aload_1
    //   2428: astore 10
    //   2430: aload_1
    //   2431: new 119	java/lang/StringBuilder
    //   2434: dup
    //   2435: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2438: aload 11
    //   2440: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: ldc 125
    //   2445: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2451: ldc 156
    //   2453: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2456: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: ldc 149
    //   2461: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2464: aload_2
    //   2465: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: ldc 149
    //   2470: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2476: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2479: goto -203 -> 2276
    //   2482: aload_1
    //   2483: astore 9
    //   2485: aload_1
    //   2486: astore 10
    //   2488: aload_1
    //   2489: new 119	java/lang/StringBuilder
    //   2492: dup
    //   2493: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2496: ldc 149
    //   2498: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2501: aload 11
    //   2503: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2506: ldc 149
    //   2508: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2511: ldc 125
    //   2513: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2519: ldc 156
    //   2521: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2524: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: ldc 149
    //   2529: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: aload_2
    //   2533: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2536: ldc 149
    //   2538: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2541: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2544: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2547: goto -271 -> 2276
    //   2550: new 163	java/io/DataInputStream
    //   2553: dup
    //   2554: new 165	java/io/ByteArrayInputStream
    //   2557: dup
    //   2558: aload_1
    //   2559: invokestatic 57	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   2562: invokespecial 168	java/io/ByteArrayInputStream:<init>	([B)V
    //   2565: invokespecial 171	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   2568: astore 11
    //   2570: iload_3
    //   2571: lookupswitch	default:+1967->4538, -2004:+1877->4448, -2003:+1843->4414, -1010:+1424->3995, -1009:+1105->3676, -1008:+849->3420, -1007:+586->3157, -1006:+156->2727, 9:+1843->4414, 187:+156->2727, 188:+586->3157, 189:+849->3420, 190:+1105->3676, 191:+1424->3995, 513:+1877->4448
    //   2693: getstatic 176	com/tencent/mobileqq/app/AppConstants:W	Ljava/lang/String;
    //   2696: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2699: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2702: ifeq +1832 -> 4534
    //   2705: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2708: dup
    //   2709: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2712: astore_0
    //   2713: aload_0
    //   2714: astore 9
    //   2716: aload_0
    //   2717: astore 10
    //   2719: aload_0
    //   2720: ldc 182
    //   2722: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2725: aload_0
    //   2726: areturn
    //   2727: new 2	com/tencent/mobileqq/data/SystemMsg
    //   2730: dup
    //   2731: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   2734: astore_0
    //   2735: aload_0
    //   2736: aload 11
    //   2738: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2741: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   2744: aload 11
    //   2746: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2749: newarray byte
    //   2751: astore_1
    //   2752: aload 11
    //   2754: aload_1
    //   2755: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2758: pop
    //   2759: aload_0
    //   2760: new 113	java/lang/String
    //   2763: dup
    //   2764: aload_1
    //   2765: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   2768: ldc 199
    //   2770: invokespecial 202	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2773: invokevirtual 153	java/lang/String:trim	()Ljava/lang/String;
    //   2776: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   2779: aload 11
    //   2781: lconst_1
    //   2782: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2785: pop2
    //   2786: aload_0
    //   2787: aload 11
    //   2789: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2792: putfield 211	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   2795: aload_0
    //   2796: aload 11
    //   2798: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2801: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   2804: aload 11
    //   2806: aload 11
    //   2808: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2811: i2l
    //   2812: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2815: pop2
    //   2816: aload 11
    //   2818: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2821: ifeq +1727 -> 4548
    //   2824: aload 11
    //   2826: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2829: istore_3
    //   2830: iload_3
    //   2831: newarray byte
    //   2833: astore_1
    //   2834: aload 11
    //   2836: aload_1
    //   2837: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2840: pop
    //   2841: aload_1
    //   2842: arraylength
    //   2843: ifne +173 -> 3016
    //   2846: aload_0
    //   2847: new 119	java/lang/StringBuilder
    //   2850: dup
    //   2851: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   2854: ldc 149
    //   2856: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: aload_2
    //   2860: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2863: ldc 149
    //   2865: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2871: ldc 214
    //   2873: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   2876: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2882: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   2885: aload 11
    //   2887: ldc2_w 215
    //   2890: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   2893: pop2
    //   2894: aload 11
    //   2896: aload 11
    //   2898: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   2901: newarray byte
    //   2903: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2906: pop
    //   2907: aload 11
    //   2909: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2912: pop
    //   2913: aload 11
    //   2915: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   2918: istore 5
    //   2920: iload 4
    //   2922: istore_3
    //   2923: iload_3
    //   2924: iload 5
    //   2926: if_icmpge +229 -> 3155
    //   2929: aload 11
    //   2931: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   2934: istore 4
    //   2936: aload 11
    //   2938: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   2941: newarray byte
    //   2943: astore_1
    //   2944: aload 11
    //   2946: aload_1
    //   2947: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   2950: pop
    //   2951: iload 4
    //   2953: sipush 1000
    //   2956: if_icmpne +107 -> 3063
    //   2959: new 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2962: dup
    //   2963: invokespecial 223	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   2966: astore_2
    //   2967: aload_2
    //   2968: aload_1
    //   2969: invokevirtual 227	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2972: checkcast 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   2975: astore_1
    //   2976: aload_1
    //   2977: ifnull +1564 -> 4541
    //   2980: aload_0
    //   2981: aload_1
    //   2982: getfield 231	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2985: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2988: putfield 238	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   2991: aload_0
    //   2992: aload_1
    //   2993: getfield 241	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2996: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2999: putfield 243	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   3002: aload_0
    //   3003: aload_1
    //   3004: getfield 247	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3007: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3010: putfield 254	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   3013: goto +1528 -> 4541
    //   3016: aload_1
    //   3017: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   3020: pop
    //   3021: aload_0
    //   3022: new 119	java/lang/StringBuilder
    //   3025: dup
    //   3026: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3029: ldc 149
    //   3031: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3034: aload_2
    //   3035: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3038: ldc 149
    //   3040: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3043: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3046: ldc 214
    //   3048: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3051: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3054: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3057: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3060: goto -175 -> 2885
    //   3063: iload 4
    //   3065: sipush 1001
    //   3068: if_icmpne +38 -> 3106
    //   3071: new 256	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3074: dup
    //   3075: invokespecial 257	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:<init>	()V
    //   3078: astore_2
    //   3079: aload_2
    //   3080: aload_1
    //   3081: invokevirtual 258	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3084: checkcast 256	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo
    //   3087: astore_1
    //   3088: aload_1
    //   3089: ifnull +1452 -> 4541
    //   3092: aload_0
    //   3093: aload_1
    //   3094: getfield 261	tencent/im/s2c/frdsysmsg/FrdSysMsg$TongXunLuNickInfo:str_tongxunlu_nickname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3097: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3100: putfield 263	com/tencent/mobileqq/data/SystemMsg:strAddressBookNickName	Ljava/lang/String;
    //   3103: goto +1438 -> 4541
    //   3106: iload 4
    //   3108: sipush 1002
    //   3111: if_icmpne +1430 -> 4541
    //   3114: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3117: dup
    //   3118: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3121: astore_2
    //   3122: aload_2
    //   3123: aload_1
    //   3124: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3127: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3130: astore_1
    //   3131: aload_1
    //   3132: ifnull +1409 -> 4541
    //   3135: aload_0
    //   3136: aload_1
    //   3137: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3140: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3143: putfield 40	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3146: goto +1395 -> 4541
    //   3149: astore_1
    //   3150: aconst_null
    //   3151: astore_1
    //   3152: goto -21 -> 3131
    //   3155: aload_0
    //   3156: areturn
    //   3157: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3160: dup
    //   3161: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3164: astore_0
    //   3165: aload_0
    //   3166: aload 11
    //   3168: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3171: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3174: aload 11
    //   3176: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3179: pop
    //   3180: aload 11
    //   3182: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3185: ifeq +1400 -> 4585
    //   3188: aload 11
    //   3190: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3193: istore_3
    //   3194: iload_3
    //   3195: newarray byte
    //   3197: astore_1
    //   3198: aload 11
    //   3200: aload_1
    //   3201: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3204: pop
    //   3205: aload_1
    //   3206: arraylength
    //   3207: ifne +146 -> 3353
    //   3210: aload_0
    //   3211: new 119	java/lang/StringBuilder
    //   3214: dup
    //   3215: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3218: ldc 149
    //   3220: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3223: aload_2
    //   3224: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3227: ldc 149
    //   3229: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3232: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3235: ldc_w 271
    //   3238: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3241: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3247: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3250: aload 11
    //   3252: ldc2_w 215
    //   3255: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   3258: pop2
    //   3259: aload 11
    //   3261: aload 11
    //   3263: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3266: newarray byte
    //   3268: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3271: pop
    //   3272: aload 11
    //   3274: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3277: istore 4
    //   3279: iload 5
    //   3281: istore_3
    //   3282: iload_3
    //   3283: iload 4
    //   3285: if_icmpge +133 -> 3418
    //   3288: aload 11
    //   3290: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3293: istore 5
    //   3295: aload 11
    //   3297: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3300: newarray byte
    //   3302: astore_1
    //   3303: aload 11
    //   3305: aload_1
    //   3306: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3309: pop
    //   3310: iload 5
    //   3312: sipush 1002
    //   3315: if_icmpne +1263 -> 4578
    //   3318: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3321: dup
    //   3322: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3325: astore_2
    //   3326: aload_2
    //   3327: aload_1
    //   3328: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3331: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3334: astore_1
    //   3335: aload_1
    //   3336: ifnull +1242 -> 4578
    //   3339: aload_0
    //   3340: aload_1
    //   3341: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3344: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3347: putfield 40	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3350: goto +1228 -> 4578
    //   3353: new 113	java/lang/String
    //   3356: dup
    //   3357: aload_1
    //   3358: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   3361: invokespecial 272	java/lang/String:<init>	([B)V
    //   3364: pop
    //   3365: aload_0
    //   3366: new 119	java/lang/StringBuilder
    //   3369: dup
    //   3370: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3373: ldc 149
    //   3375: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: aload_2
    //   3379: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: ldc 149
    //   3384: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3390: ldc_w 271
    //   3393: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3396: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3399: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3402: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3405: goto -155 -> 3250
    //   3408: astore_1
    //   3409: goto -2999 -> 410
    //   3412: astore_1
    //   3413: aconst_null
    //   3414: astore_1
    //   3415: goto -80 -> 3335
    //   3418: aload_0
    //   3419: areturn
    //   3420: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3423: dup
    //   3424: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3427: astore_0
    //   3428: aload_0
    //   3429: aload 11
    //   3431: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3434: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3437: aload 11
    //   3439: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3442: pop
    //   3443: aload 11
    //   3445: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3448: ifeq +1149 -> 4597
    //   3451: aload 11
    //   3453: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3456: istore_3
    //   3457: iload_3
    //   3458: newarray byte
    //   3460: astore_1
    //   3461: aload 11
    //   3463: aload_1
    //   3464: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3467: pop
    //   3468: aload_1
    //   3469: arraylength
    //   3470: ifne +146 -> 3616
    //   3473: aload_0
    //   3474: new 119	java/lang/StringBuilder
    //   3477: dup
    //   3478: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3481: ldc 149
    //   3483: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3486: aload_2
    //   3487: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: ldc 149
    //   3492: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3495: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3498: ldc_w 273
    //   3501: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3504: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3507: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3510: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3513: aload 11
    //   3515: ldc2_w 215
    //   3518: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   3521: pop2
    //   3522: aload 11
    //   3524: aload 11
    //   3526: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3529: newarray byte
    //   3531: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3534: pop
    //   3535: aload 11
    //   3537: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3540: istore 4
    //   3542: iload 6
    //   3544: istore_3
    //   3545: iload_3
    //   3546: iload 4
    //   3548: if_icmpge +126 -> 3674
    //   3551: aload 11
    //   3553: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3556: istore 5
    //   3558: aload 11
    //   3560: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3563: newarray byte
    //   3565: astore_1
    //   3566: aload 11
    //   3568: aload_1
    //   3569: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3572: pop
    //   3573: iload 5
    //   3575: sipush 1002
    //   3578: if_icmpne +1012 -> 4590
    //   3581: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3584: dup
    //   3585: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3588: astore_2
    //   3589: aload_2
    //   3590: aload_1
    //   3591: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3594: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3597: astore_1
    //   3598: aload_1
    //   3599: ifnull +991 -> 4590
    //   3602: aload_0
    //   3603: aload_1
    //   3604: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3607: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3610: putfield 40	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3613: goto +977 -> 4590
    //   3616: aload_1
    //   3617: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   3620: pop
    //   3621: aload_0
    //   3622: new 119	java/lang/StringBuilder
    //   3625: dup
    //   3626: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3629: ldc 149
    //   3631: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: aload_2
    //   3635: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3638: ldc 149
    //   3640: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3646: ldc_w 273
    //   3649: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3652: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3655: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3658: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3661: goto -148 -> 3513
    //   3664: astore_1
    //   3665: goto -3255 -> 410
    //   3668: astore_1
    //   3669: aconst_null
    //   3670: astore_1
    //   3671: goto -73 -> 3598
    //   3674: aload_0
    //   3675: areturn
    //   3676: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3679: dup
    //   3680: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   3683: astore_0
    //   3684: aload_0
    //   3685: aload 11
    //   3687: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3690: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   3693: aload 11
    //   3695: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3698: newarray byte
    //   3700: astore_1
    //   3701: aload 11
    //   3703: aload_1
    //   3704: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3707: pop
    //   3708: new 113	java/lang/String
    //   3711: dup
    //   3712: aload_1
    //   3713: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   3716: invokespecial 272	java/lang/String:<init>	([B)V
    //   3719: invokevirtual 153	java/lang/String:trim	()Ljava/lang/String;
    //   3722: astore 9
    //   3724: aload 9
    //   3726: ifnull +16 -> 3742
    //   3729: aload 9
    //   3731: astore_1
    //   3732: ldc 38
    //   3734: aload 9
    //   3736: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3739: ifeq +12 -> 3751
    //   3742: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3745: ldc 154
    //   3747: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3750: astore_1
    //   3751: aload_0
    //   3752: aload_1
    //   3753: putfield 81	com/tencent/mobileqq/data/SystemMsg:sMsg	Ljava/lang/String;
    //   3756: aload 11
    //   3758: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3761: ifeq +848 -> 4609
    //   3764: aload 11
    //   3766: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3769: istore_3
    //   3770: iload_3
    //   3771: newarray byte
    //   3773: astore_1
    //   3774: aload 11
    //   3776: aload_1
    //   3777: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3780: pop
    //   3781: aload_1
    //   3782: arraylength
    //   3783: ifne +152 -> 3935
    //   3786: aload_0
    //   3787: new 119	java/lang/StringBuilder
    //   3790: dup
    //   3791: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3794: ldc 149
    //   3796: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3799: aload_2
    //   3800: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: ldc 149
    //   3805: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3808: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3811: ldc_w 274
    //   3814: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3817: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3820: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3823: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3826: aload 11
    //   3828: ldc2_w 215
    //   3831: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   3834: pop2
    //   3835: aload 11
    //   3837: aload 11
    //   3839: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   3842: newarray byte
    //   3844: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3847: pop
    //   3848: aload 11
    //   3850: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3853: pop
    //   3854: aload 11
    //   3856: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   3859: istore 4
    //   3861: iload 7
    //   3863: istore_3
    //   3864: iload_3
    //   3865: iload 4
    //   3867: if_icmpge +126 -> 3993
    //   3870: aload 11
    //   3872: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3875: istore 5
    //   3877: aload 11
    //   3879: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   3882: newarray byte
    //   3884: astore_1
    //   3885: aload 11
    //   3887: aload_1
    //   3888: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   3891: pop
    //   3892: iload 5
    //   3894: sipush 1002
    //   3897: if_icmpne +705 -> 4602
    //   3900: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3903: dup
    //   3904: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   3907: astore_2
    //   3908: aload_2
    //   3909: aload_1
    //   3910: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3913: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   3916: astore_1
    //   3917: aload_1
    //   3918: ifnull +684 -> 4602
    //   3921: aload_0
    //   3922: aload_1
    //   3923: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3926: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3929: putfield 40	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   3932: goto +670 -> 4602
    //   3935: aload_1
    //   3936: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   3939: pop
    //   3940: aload_0
    //   3941: new 119	java/lang/StringBuilder
    //   3944: dup
    //   3945: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   3948: ldc 149
    //   3950: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3953: aload_2
    //   3954: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3957: ldc 149
    //   3959: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3962: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3965: ldc_w 274
    //   3968: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   3971: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3974: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3977: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   3980: goto -154 -> 3826
    //   3983: astore_1
    //   3984: goto -3574 -> 410
    //   3987: astore_1
    //   3988: aconst_null
    //   3989: astore_1
    //   3990: goto -73 -> 3917
    //   3993: aload_0
    //   3994: areturn
    //   3995: new 2	com/tencent/mobileqq/data/SystemMsg
    //   3998: dup
    //   3999: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4002: astore_0
    //   4003: aload_0
    //   4004: astore 9
    //   4006: aload_0
    //   4007: astore 10
    //   4009: aload_0
    //   4010: new 119	java/lang/StringBuilder
    //   4013: dup
    //   4014: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   4017: ldc 149
    //   4019: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4022: aload_2
    //   4023: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4026: ldc 149
    //   4028: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4031: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   4034: ldc_w 275
    //   4037: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   4040: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4043: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4046: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4049: aload_0
    //   4050: astore 9
    //   4052: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4055: dup
    //   4056: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4059: astore_1
    //   4060: aload_1
    //   4061: aload 11
    //   4063: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4066: putfield 188	com/tencent/mobileqq/data/SystemMsg:cVession	I
    //   4069: aload 11
    //   4071: aload 11
    //   4073: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4076: newarray byte
    //   4078: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4081: pop
    //   4082: aload_1
    //   4083: aload 11
    //   4085: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4088: putfield 211	com/tencent/mobileqq/data/SystemMsg:wSourceID	I
    //   4091: aload_1
    //   4092: aload 11
    //   4094: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4097: putfield 213	com/tencent/mobileqq/data/SystemMsg:wSourceSubID	I
    //   4100: aload 11
    //   4102: aload 11
    //   4104: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4107: i2l
    //   4108: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   4111: pop2
    //   4112: aload 11
    //   4114: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4117: ifeq +504 -> 4621
    //   4120: aload 11
    //   4122: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4125: istore_3
    //   4126: iload_3
    //   4127: newarray byte
    //   4129: astore_0
    //   4130: aload 11
    //   4132: aload_0
    //   4133: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4136: pop
    //   4137: aload_0
    //   4138: arraylength
    //   4139: ifne +168 -> 4307
    //   4142: aload_1
    //   4143: new 119	java/lang/StringBuilder
    //   4146: dup
    //   4147: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   4150: ldc 149
    //   4152: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4155: aload_2
    //   4156: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4159: ldc 149
    //   4161: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4164: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   4167: ldc_w 275
    //   4170: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   4173: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4176: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4179: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4182: aload 11
    //   4184: ldc2_w 215
    //   4187: invokevirtual 206	java/io/DataInputStream:skip	(J)J
    //   4190: pop2
    //   4191: aload 11
    //   4193: aload 11
    //   4195: invokevirtual 209	java/io/DataInputStream:readUnsignedShort	()I
    //   4198: newarray byte
    //   4200: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4203: pop
    //   4204: aload 11
    //   4206: invokevirtual 186	java/io/DataInputStream:readUnsignedByte	()I
    //   4209: istore 4
    //   4211: iload 8
    //   4213: istore_3
    //   4214: iload_3
    //   4215: iload 4
    //   4217: if_icmpge +195 -> 4412
    //   4220: aload 11
    //   4222: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4225: istore 5
    //   4227: aload 11
    //   4229: invokevirtual 220	java/io/DataInputStream:readShort	()S
    //   4232: newarray byte
    //   4234: astore_0
    //   4235: aload 11
    //   4237: aload_0
    //   4238: invokevirtual 192	java/io/DataInputStream:read	([B)I
    //   4241: pop
    //   4242: iload 5
    //   4244: sipush 1000
    //   4247: if_icmpne +108 -> 4355
    //   4250: new 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   4253: dup
    //   4254: invokespecial 223	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:<init>	()V
    //   4257: astore_2
    //   4258: aload_2
    //   4259: aload_0
    //   4260: invokevirtual 227	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4263: checkcast 222	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo
    //   4266: astore_0
    //   4267: aload_0
    //   4268: ifnull +346 -> 4614
    //   4271: aload_1
    //   4272: aload_0
    //   4273: getfield 231	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4276: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4279: putfield 238	com/tencent/mobileqq/data/SystemMsg:strGroupName	Ljava/lang/String;
    //   4282: aload_1
    //   4283: aload_0
    //   4284: getfield 241	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:str_group_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4287: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4290: putfield 243	com/tencent/mobileqq/data/SystemMsg:strGroupNickName	Ljava/lang/String;
    //   4293: aload_1
    //   4294: aload_0
    //   4295: getfield 247	tencent/im/s2c/frdsysmsg/FrdSysMsg$GroupInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4298: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4301: putfield 254	com/tencent/mobileqq/data/SystemMsg:strGroupUin	J
    //   4304: goto +310 -> 4614
    //   4307: aload_0
    //   4308: invokestatic 197	com/tencent/mobileqq/service/message/MessageUtils:b	([B)[B
    //   4311: pop
    //   4312: aload_1
    //   4313: new 119	java/lang/StringBuilder
    //   4316: dup
    //   4317: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   4320: ldc 149
    //   4322: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: aload_2
    //   4326: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4329: ldc 149
    //   4331: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4334: invokestatic 131	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   4337: ldc_w 275
    //   4340: invokevirtual 138	android/content/Context:getString	(I)Ljava/lang/String;
    //   4343: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4346: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4349: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4352: goto -170 -> 4182
    //   4355: iload 5
    //   4357: sipush 1002
    //   4360: if_icmpne +254 -> 4614
    //   4363: new 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4366: dup
    //   4367: invokespecial 266	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:<init>	()V
    //   4370: astore_2
    //   4371: aload_2
    //   4372: aload_0
    //   4373: invokevirtual 267	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4376: checkcast 265	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo
    //   4379: astore_0
    //   4380: aload_0
    //   4381: ifnull +233 -> 4614
    //   4384: aload_1
    //   4385: aload_0
    //   4386: getfield 270	tencent/im/s2c/frdsysmsg/FrdSysMsg$FriendMiscInfo:str_fromuin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4389: invokevirtual 236	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4392: putfield 40	com/tencent/mobileqq/data/SystemMsg:strServerFromUinNickName	Ljava/lang/String;
    //   4395: goto +219 -> 4614
    //   4398: astore_2
    //   4399: aload_1
    //   4400: astore_0
    //   4401: aload_2
    //   4402: astore_1
    //   4403: goto -3993 -> 410
    //   4406: astore_0
    //   4407: aconst_null
    //   4408: astore_0
    //   4409: goto -29 -> 4380
    //   4412: aload_1
    //   4413: areturn
    //   4414: aload_2
    //   4415: getstatic 176	com/tencent/mobileqq/app/AppConstants:W	Ljava/lang/String;
    //   4418: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4421: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4424: ifeq +110 -> 4534
    //   4427: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4430: dup
    //   4431: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4434: astore_0
    //   4435: aload_0
    //   4436: astore 9
    //   4438: aload_0
    //   4439: astore 10
    //   4441: aload_0
    //   4442: aload_1
    //   4443: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4446: aload_0
    //   4447: areturn
    //   4448: aload_2
    //   4449: getstatic 176	com/tencent/mobileqq/app/AppConstants:W	Ljava/lang/String;
    //   4452: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4455: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4458: ifeq +76 -> 4534
    //   4461: new 2	com/tencent/mobileqq/data/SystemMsg
    //   4464: dup
    //   4465: invokespecial 58	com/tencent/mobileqq/data/SystemMsg:<init>	()V
    //   4468: astore_0
    //   4469: aload_0
    //   4470: astore 9
    //   4472: aload_0
    //   4473: astore 10
    //   4475: aload_0
    //   4476: ldc_w 277
    //   4479: aload_1
    //   4480: invokestatic 282	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4483: invokestatic 286	com/tencent/mobileqq/utils/httputils/PkgTools:c	(Ljava/lang/String;)Ljava/lang/String;
    //   4486: putfield 144	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   4489: aload_0
    //   4490: areturn
    //   4491: astore_0
    //   4492: aconst_null
    //   4493: astore 10
    //   4495: goto -4025 -> 470
    //   4498: astore_1
    //   4499: aload_0
    //   4500: astore 10
    //   4502: aload_1
    //   4503: astore_0
    //   4504: goto -4034 -> 470
    //   4507: astore_1
    //   4508: aload_0
    //   4509: astore 10
    //   4511: aload_1
    //   4512: astore_0
    //   4513: goto -4043 -> 470
    //   4516: astore_1
    //   4517: aload_0
    //   4518: astore 10
    //   4520: aload_1
    //   4521: astore_0
    //   4522: goto -4052 -> 470
    //   4525: astore_1
    //   4526: aconst_null
    //   4527: astore_0
    //   4528: goto -4118 -> 410
    //   4531: astore_1
    //   4532: aload_0
    //   4533: areturn
    //   4534: aconst_null
    //   4535: areturn
    //   4536: aload_1
    //   4537: areturn
    //   4538: goto -1846 -> 2692
    //   4541: iload_3
    //   4542: iconst_1
    //   4543: iadd
    //   4544: istore_3
    //   4545: goto -1622 -> 2923
    //   4548: iconst_0
    //   4549: istore_3
    //   4550: goto -1720 -> 2830
    //   4553: astore_1
    //   4554: goto -4144 -> 410
    //   4557: astore_1
    //   4558: aconst_null
    //   4559: astore_1
    //   4560: goto -1584 -> 2976
    //   4563: astore_1
    //   4564: aload_0
    //   4565: astore 10
    //   4567: aload_1
    //   4568: astore_0
    //   4569: goto -4099 -> 470
    //   4572: astore_1
    //   4573: aconst_null
    //   4574: astore_1
    //   4575: goto -1487 -> 3088
    //   4578: iload_3
    //   4579: iconst_1
    //   4580: iadd
    //   4581: istore_3
    //   4582: goto -1300 -> 3282
    //   4585: iconst_0
    //   4586: istore_3
    //   4587: goto -1393 -> 3194
    //   4590: iload_3
    //   4591: iconst_1
    //   4592: iadd
    //   4593: istore_3
    //   4594: goto -1049 -> 3545
    //   4597: iconst_0
    //   4598: istore_3
    //   4599: goto -1142 -> 3457
    //   4602: iload_3
    //   4603: iconst_1
    //   4604: iadd
    //   4605: istore_3
    //   4606: goto -742 -> 3864
    //   4609: iconst_0
    //   4610: istore_3
    //   4611: goto -841 -> 3770
    //   4614: iload_3
    //   4615: iconst_1
    //   4616: iadd
    //   4617: istore_3
    //   4618: goto -404 -> 4214
    //   4621: iconst_0
    //   4622: istore_3
    //   4623: goto -497 -> 4126
    //   4626: astore_0
    //   4627: aload_1
    //   4628: areturn
    //   4629: astore_0
    //   4630: aconst_null
    //   4631: astore_0
    //   4632: goto -365 -> 4267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4635	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	4635	1	paramString1	String
    //   0	4635	2	paramString2	String
    //   0	4635	3	paramInt	int
    //   13	4205	4	i	int
    //   1	4360	5	j	int
    //   4	3539	6	k	int
    //   7	3855	7	m	int
    //   10	4202	8	n	int
    //   40	4431	9	localObject1	java.lang.Object
    //   43	4523	10	localObject2	java.lang.Object
    //   188	4048	11	localObject3	java.lang.Object
    //   205	440	12	str1	String
    //   222	2085	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   45	53	406	java/io/IOException
    //   59	67	406	java/io/IOException
    //   73	82	406	java/io/IOException
    //   88	97	406	java/io/IOException
    //   103	112	406	java/io/IOException
    //   118	127	406	java/io/IOException
    //   133	142	406	java/io/IOException
    //   148	157	406	java/io/IOException
    //   163	173	406	java/io/IOException
    //   179	190	406	java/io/IOException
    //   196	207	406	java/io/IOException
    //   213	224	406	java/io/IOException
    //   338	345	406	java/io/IOException
    //   351	363	406	java/io/IOException
    //   369	404	406	java/io/IOException
    //   422	467	406	java/io/IOException
    //   483	490	406	java/io/IOException
    //   496	511	406	java/io/IOException
    //   517	526	406	java/io/IOException
    //   532	537	406	java/io/IOException
    //   543	550	406	java/io/IOException
    //   556	568	406	java/io/IOException
    //   574	609	406	java/io/IOException
    //   617	622	406	java/io/IOException
    //   631	676	406	java/io/IOException
    //   684	691	406	java/io/IOException
    //   697	709	406	java/io/IOException
    //   715	724	406	java/io/IOException
    //   730	735	406	java/io/IOException
    //   741	748	406	java/io/IOException
    //   754	765	406	java/io/IOException
    //   771	778	406	java/io/IOException
    //   784	796	406	java/io/IOException
    //   802	841	406	java/io/IOException
    //   849	854	406	java/io/IOException
    //   863	912	406	java/io/IOException
    //   920	927	406	java/io/IOException
    //   933	945	406	java/io/IOException
    //   951	1000	406	java/io/IOException
    //   1008	1067	406	java/io/IOException
    //   1075	1082	406	java/io/IOException
    //   1088	1100	406	java/io/IOException
    //   1106	1115	406	java/io/IOException
    //   1121	1126	406	java/io/IOException
    //   1132	1140	406	java/io/IOException
    //   1146	1154	406	java/io/IOException
    //   1160	1167	406	java/io/IOException
    //   1173	1184	406	java/io/IOException
    //   1190	1197	406	java/io/IOException
    //   1203	1215	406	java/io/IOException
    //   1221	1260	406	java/io/IOException
    //   1268	1273	406	java/io/IOException
    //   1282	1331	406	java/io/IOException
    //   1339	1346	406	java/io/IOException
    //   1352	1364	406	java/io/IOException
    //   1370	1419	406	java/io/IOException
    //   1427	1486	406	java/io/IOException
    //   1494	1502	406	java/io/IOException
    //   1508	1515	406	java/io/IOException
    //   1521	1532	406	java/io/IOException
    //   1538	1545	406	java/io/IOException
    //   1551	1563	406	java/io/IOException
    //   1569	1608	406	java/io/IOException
    //   1616	1665	406	java/io/IOException
    //   1673	1680	406	java/io/IOException
    //   1686	1698	406	java/io/IOException
    //   1704	1753	406	java/io/IOException
    //   1761	1820	406	java/io/IOException
    //   1828	1836	406	java/io/IOException
    //   1842	1849	406	java/io/IOException
    //   1855	1866	406	java/io/IOException
    //   1872	1879	406	java/io/IOException
    //   1885	1897	406	java/io/IOException
    //   1903	1942	406	java/io/IOException
    //   1950	1999	406	java/io/IOException
    //   2007	2014	406	java/io/IOException
    //   2020	2032	406	java/io/IOException
    //   2038	2087	406	java/io/IOException
    //   2095	2154	406	java/io/IOException
    //   2162	2170	406	java/io/IOException
    //   2176	2183	406	java/io/IOException
    //   2189	2200	406	java/io/IOException
    //   2206	2213	406	java/io/IOException
    //   2219	2231	406	java/io/IOException
    //   2237	2276	406	java/io/IOException
    //   2282	2333	406	java/io/IOException
    //   2341	2390	406	java/io/IOException
    //   2399	2406	406	java/io/IOException
    //   2412	2424	406	java/io/IOException
    //   2430	2479	406	java/io/IOException
    //   2488	2547	406	java/io/IOException
    //   2719	2725	406	java/io/IOException
    //   4009	4049	406	java/io/IOException
    //   4052	4060	406	java/io/IOException
    //   4441	4446	406	java/io/IOException
    //   4475	4489	406	java/io/IOException
    //   45	53	469	java/lang/Exception
    //   59	67	469	java/lang/Exception
    //   73	82	469	java/lang/Exception
    //   88	97	469	java/lang/Exception
    //   103	112	469	java/lang/Exception
    //   118	127	469	java/lang/Exception
    //   133	142	469	java/lang/Exception
    //   148	157	469	java/lang/Exception
    //   163	173	469	java/lang/Exception
    //   179	190	469	java/lang/Exception
    //   196	207	469	java/lang/Exception
    //   213	224	469	java/lang/Exception
    //   338	345	469	java/lang/Exception
    //   351	363	469	java/lang/Exception
    //   369	404	469	java/lang/Exception
    //   422	467	469	java/lang/Exception
    //   483	490	469	java/lang/Exception
    //   496	511	469	java/lang/Exception
    //   517	526	469	java/lang/Exception
    //   532	537	469	java/lang/Exception
    //   543	550	469	java/lang/Exception
    //   556	568	469	java/lang/Exception
    //   574	609	469	java/lang/Exception
    //   617	622	469	java/lang/Exception
    //   631	676	469	java/lang/Exception
    //   684	691	469	java/lang/Exception
    //   697	709	469	java/lang/Exception
    //   715	724	469	java/lang/Exception
    //   730	735	469	java/lang/Exception
    //   741	748	469	java/lang/Exception
    //   754	765	469	java/lang/Exception
    //   771	778	469	java/lang/Exception
    //   784	796	469	java/lang/Exception
    //   802	841	469	java/lang/Exception
    //   849	854	469	java/lang/Exception
    //   863	912	469	java/lang/Exception
    //   920	927	469	java/lang/Exception
    //   933	945	469	java/lang/Exception
    //   951	1000	469	java/lang/Exception
    //   1008	1067	469	java/lang/Exception
    //   1075	1082	469	java/lang/Exception
    //   1088	1100	469	java/lang/Exception
    //   1106	1115	469	java/lang/Exception
    //   1121	1126	469	java/lang/Exception
    //   1132	1140	469	java/lang/Exception
    //   1146	1154	469	java/lang/Exception
    //   1160	1167	469	java/lang/Exception
    //   1173	1184	469	java/lang/Exception
    //   1190	1197	469	java/lang/Exception
    //   1203	1215	469	java/lang/Exception
    //   1221	1260	469	java/lang/Exception
    //   1268	1273	469	java/lang/Exception
    //   1282	1331	469	java/lang/Exception
    //   1339	1346	469	java/lang/Exception
    //   1352	1364	469	java/lang/Exception
    //   1370	1419	469	java/lang/Exception
    //   1427	1486	469	java/lang/Exception
    //   1494	1502	469	java/lang/Exception
    //   1508	1515	469	java/lang/Exception
    //   1521	1532	469	java/lang/Exception
    //   1538	1545	469	java/lang/Exception
    //   1551	1563	469	java/lang/Exception
    //   1569	1608	469	java/lang/Exception
    //   1616	1665	469	java/lang/Exception
    //   1673	1680	469	java/lang/Exception
    //   1686	1698	469	java/lang/Exception
    //   1704	1753	469	java/lang/Exception
    //   1761	1820	469	java/lang/Exception
    //   1828	1836	469	java/lang/Exception
    //   1842	1849	469	java/lang/Exception
    //   1855	1866	469	java/lang/Exception
    //   1872	1879	469	java/lang/Exception
    //   1885	1897	469	java/lang/Exception
    //   1903	1942	469	java/lang/Exception
    //   1950	1999	469	java/lang/Exception
    //   2007	2014	469	java/lang/Exception
    //   2020	2032	469	java/lang/Exception
    //   2038	2087	469	java/lang/Exception
    //   2095	2154	469	java/lang/Exception
    //   2162	2170	469	java/lang/Exception
    //   2176	2183	469	java/lang/Exception
    //   2189	2200	469	java/lang/Exception
    //   2206	2213	469	java/lang/Exception
    //   2219	2231	469	java/lang/Exception
    //   2237	2276	469	java/lang/Exception
    //   2282	2333	469	java/lang/Exception
    //   2341	2390	469	java/lang/Exception
    //   2399	2406	469	java/lang/Exception
    //   2412	2424	469	java/lang/Exception
    //   2430	2479	469	java/lang/Exception
    //   2488	2547	469	java/lang/Exception
    //   2719	2725	469	java/lang/Exception
    //   4009	4049	469	java/lang/Exception
    //   4441	4446	469	java/lang/Exception
    //   4475	4489	469	java/lang/Exception
    //   3122	3131	3149	java/lang/Exception
    //   3165	3194	3408	java/io/IOException
    //   3194	3250	3408	java/io/IOException
    //   3250	3279	3408	java/io/IOException
    //   3288	3310	3408	java/io/IOException
    //   3318	3326	3408	java/io/IOException
    //   3326	3335	3408	java/io/IOException
    //   3339	3350	3408	java/io/IOException
    //   3353	3405	3408	java/io/IOException
    //   3326	3335	3412	java/lang/Exception
    //   3428	3457	3664	java/io/IOException
    //   3457	3513	3664	java/io/IOException
    //   3513	3542	3664	java/io/IOException
    //   3551	3573	3664	java/io/IOException
    //   3581	3589	3664	java/io/IOException
    //   3589	3598	3664	java/io/IOException
    //   3602	3613	3664	java/io/IOException
    //   3616	3661	3664	java/io/IOException
    //   3589	3598	3668	java/lang/Exception
    //   3684	3724	3983	java/io/IOException
    //   3732	3742	3983	java/io/IOException
    //   3742	3751	3983	java/io/IOException
    //   3751	3770	3983	java/io/IOException
    //   3770	3826	3983	java/io/IOException
    //   3826	3861	3983	java/io/IOException
    //   3870	3892	3983	java/io/IOException
    //   3900	3908	3983	java/io/IOException
    //   3908	3917	3983	java/io/IOException
    //   3921	3932	3983	java/io/IOException
    //   3935	3980	3983	java/io/IOException
    //   3908	3917	3987	java/lang/Exception
    //   4060	4126	4398	java/io/IOException
    //   4126	4182	4398	java/io/IOException
    //   4182	4211	4398	java/io/IOException
    //   4220	4242	4398	java/io/IOException
    //   4250	4258	4398	java/io/IOException
    //   4258	4267	4398	java/io/IOException
    //   4271	4304	4398	java/io/IOException
    //   4307	4352	4398	java/io/IOException
    //   4363	4371	4398	java/io/IOException
    //   4371	4380	4398	java/io/IOException
    //   4384	4395	4398	java/io/IOException
    //   4371	4380	4406	java/lang/Exception
    //   19	39	4491	java/lang/Exception
    //   2550	2570	4491	java/lang/Exception
    //   2692	2713	4491	java/lang/Exception
    //   2727	2735	4491	java/lang/Exception
    //   3157	3165	4491	java/lang/Exception
    //   3420	3428	4491	java/lang/Exception
    //   3676	3684	4491	java/lang/Exception
    //   3995	4003	4491	java/lang/Exception
    //   4414	4435	4491	java/lang/Exception
    //   4448	4469	4491	java/lang/Exception
    //   3165	3194	4498	java/lang/Exception
    //   3194	3250	4498	java/lang/Exception
    //   3250	3279	4498	java/lang/Exception
    //   3288	3310	4498	java/lang/Exception
    //   3318	3326	4498	java/lang/Exception
    //   3339	3350	4498	java/lang/Exception
    //   3353	3405	4498	java/lang/Exception
    //   3428	3457	4507	java/lang/Exception
    //   3457	3513	4507	java/lang/Exception
    //   3513	3542	4507	java/lang/Exception
    //   3551	3573	4507	java/lang/Exception
    //   3581	3589	4507	java/lang/Exception
    //   3602	3613	4507	java/lang/Exception
    //   3616	3661	4507	java/lang/Exception
    //   3684	3724	4516	java/lang/Exception
    //   3732	3742	4516	java/lang/Exception
    //   3742	3751	4516	java/lang/Exception
    //   3751	3770	4516	java/lang/Exception
    //   3770	3826	4516	java/lang/Exception
    //   3826	3861	4516	java/lang/Exception
    //   3870	3892	4516	java/lang/Exception
    //   3900	3908	4516	java/lang/Exception
    //   3921	3932	4516	java/lang/Exception
    //   3935	3980	4516	java/lang/Exception
    //   19	39	4525	java/io/IOException
    //   2550	2570	4525	java/io/IOException
    //   2692	2713	4525	java/io/IOException
    //   2727	2735	4525	java/io/IOException
    //   3157	3165	4525	java/io/IOException
    //   3420	3428	4525	java/io/IOException
    //   3676	3684	4525	java/io/IOException
    //   3995	4003	4525	java/io/IOException
    //   4414	4435	4525	java/io/IOException
    //   4448	4469	4525	java/io/IOException
    //   4052	4060	4531	java/lang/Exception
    //   2735	2830	4553	java/io/IOException
    //   2830	2885	4553	java/io/IOException
    //   2885	2920	4553	java/io/IOException
    //   2929	2951	4553	java/io/IOException
    //   2959	2967	4553	java/io/IOException
    //   2967	2976	4553	java/io/IOException
    //   2980	3013	4553	java/io/IOException
    //   3016	3060	4553	java/io/IOException
    //   3071	3079	4553	java/io/IOException
    //   3079	3088	4553	java/io/IOException
    //   3092	3103	4553	java/io/IOException
    //   3114	3122	4553	java/io/IOException
    //   3122	3131	4553	java/io/IOException
    //   3135	3146	4553	java/io/IOException
    //   2967	2976	4557	java/lang/Exception
    //   2735	2830	4563	java/lang/Exception
    //   2830	2885	4563	java/lang/Exception
    //   2885	2920	4563	java/lang/Exception
    //   2929	2951	4563	java/lang/Exception
    //   2959	2967	4563	java/lang/Exception
    //   2980	3013	4563	java/lang/Exception
    //   3016	3060	4563	java/lang/Exception
    //   3071	3079	4563	java/lang/Exception
    //   3092	3103	4563	java/lang/Exception
    //   3114	3122	4563	java/lang/Exception
    //   3135	3146	4563	java/lang/Exception
    //   3079	3088	4572	java/lang/Exception
    //   4060	4126	4626	java/lang/Exception
    //   4126	4182	4626	java/lang/Exception
    //   4182	4211	4626	java/lang/Exception
    //   4220	4242	4626	java/lang/Exception
    //   4250	4258	4626	java/lang/Exception
    //   4271	4304	4626	java/lang/Exception
    //   4307	4352	4626	java/lang/Exception
    //   4363	4371	4626	java/lang/Exception
    //   4384	4395	4626	java/lang/Exception
    //   4258	4267	4629	java/lang/Exception
  }
  
  public static byte[] getAuthFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      case -1022: 
      case -1021: 
      case 36: 
      case 37: 
      case 85: 
      case 86: 
      default: 
        return null;
      case -1023: 
      case 46: 
      case 87: 
        paramInt = getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt);
        if ((paramInt == 1) || (paramInt == 4))
        {
          paramInt = PkgTools.a(paramArrayOfByte[15]) + 15;
          i = PkgTools.a(paramArrayOfByte, paramInt);
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
          return arrayOfByte;
        }
        break;
      case -1020: 
      case 35: 
      case 84: 
        paramInt = PkgTools.a(paramArrayOfByte[9]);
        paramInt = PkgTools.a(paramArrayOfByte, PkgTools.a(paramArrayOfByte[9]) + 10) + (paramInt + 10 + 2);
        i = PkgTools.a(paramArrayOfByte, paramInt);
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
        return arrayOfByte;
      }
    } while (paramInt != 5);
    paramInt = PkgTools.a(paramArrayOfByte[19]) + 19;
    int i = PkgTools.a(paramArrayOfByte, paramInt);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt + 2, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static String getInviteUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      default: 
        return null;
      }
    } while (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) != 5);
    return String.valueOf(PkgTools.a(paramArrayOfByte, 14));
  }
  
  public static String getManagerUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    switch (paramInt)
    {
    case -1020: 
    case 35: 
    case 84: 
    default: 
      return null;
    case -1023: 
    case 46: 
    case 87: 
      return String.valueOf(PkgTools.a(paramArrayOfByte, 10));
    }
    return String.valueOf(PkgTools.a(paramArrayOfByte, 5));
  }
  
  public static String getRequestUinFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    case -1023: 
    case -1022: 
    case -1021: 
    case 36: 
    case 37: 
    case 46: 
    case 85: 
    case 86: 
    case 87: 
      return String.valueOf(PkgTools.a(paramArrayOfByte, 10));
    }
    return String.valueOf(PkgTools.a(paramArrayOfByte, 5));
  }
  
  public static String getStrMsgFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte;
    switch (paramInt)
    {
    default: 
      return null;
    case -1023: 
    case 46: 
    case 87: 
      if (getTroopOpFromTroopSysMsg(paramArrayOfByte, paramInt) == 5)
      {
        paramInt = PkgTools.a(paramArrayOfByte[18]);
        arrayOfByte = new byte[paramInt];
        PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 19, paramInt);
      }
      break;
    }
    for (paramArrayOfByte = MessageUtils.b(arrayOfByte);; paramArrayOfByte = MessageUtils.b(arrayOfByte))
    {
      return String.valueOf(PkgTools.c(paramArrayOfByte, 0, paramInt));
      paramInt = PkgTools.a(paramArrayOfByte[9]);
      arrayOfByte = new byte[paramInt];
      PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 10, paramInt);
      return String.valueOf(PkgTools.c(MessageUtils.b(arrayOfByte), 0, paramInt));
      paramInt = PkgTools.a(paramArrayOfByte[14]);
      arrayOfByte = new byte[paramInt];
      PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 15, paramInt);
    }
  }
  
  public static String getTroopCodeFromTroopSysMsg(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return String.valueOf(PkgTools.a(paramArrayOfByte, 0));
  }
  
  public static byte getTroopOpFromTroopSysMsg(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    switch (paramInt)
    {
    case -1022: 
    case -1021: 
    case -1020: 
    case 35: 
    case 36: 
    case 37: 
    case 84: 
    case 85: 
    case 86: 
    default: 
      return -1;
    }
    return paramArrayOfByte[5];
  }
  
  public static int getTroopSystemMsgType(int paramInt)
  {
    int j = -1023;
    int i;
    if ((paramInt == -1020) || (paramInt == 84) || (paramInt == 35)) {
      i = -1020;
    }
    do
    {
      do
      {
        do
        {
          return i;
          if ((paramInt == -1021) || (paramInt == 85) || (paramInt == 36)) {
            return -1021;
          }
          if ((paramInt == -1022) || (paramInt == 86) || (paramInt == 37)) {
            return -1022;
          }
          i = j;
        } while (paramInt == -1023);
        i = j;
      } while (paramInt == 87);
      i = j;
    } while (paramInt == 46);
    return -1000;
  }
  
  public static byte getTroopTypeFromTroopSysMsg(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return paramArrayOfByte[4];
  }
  
  public static boolean isSystemMessage(int paramInt)
  {
    if ((paramInt <= -1006) && (paramInt >= -1010)) {}
    while ((paramInt == -1011) || ((paramInt >= 187) && (paramInt <= 191))) {
      return true;
    }
    return false;
  }
  
  public static boolean isTroopSystemMessage(int paramInt)
  {
    if ((paramInt <= -1020) && (paramInt >= -1023)) {}
    while (((paramInt >= 84) && (paramInt <= 87)) || ((paramInt >= 35) && (paramInt <= 37)) || (paramInt == 46) || (paramInt == 45)) {
      return true;
    }
    return false;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    try
    {
      this.cVession = paramJceInputStream.read(this.cVession, 0, true);
      this.sMsg = paramJceInputStream.read(this.sMsg, 1, false);
      this.append = paramJceInputStream.read(this.append, 2, false);
      this.message = paramJceInputStream.read(this.message, 3, false);
      this.troopCode = paramJceInputStream.read(this.troopCode, 4, false);
      this.managerUin = paramJceInputStream.readString(5, false);
      this.requestUin = paramJceInputStream.readString(6, false);
      this.troopType = paramJceInputStream.read(this.troopType, 7, true);
      this.op = paramJceInputStream.read(this.op, 8, true);
      this.auth = paramJceInputStream.read(this.auth, 9, false);
      this.lToMobile = paramJceInputStream.read(this.lToMobile, 10, true);
      this.strNickName = paramJceInputStream.read(this.strNickName, 11, false);
      return;
    }
    catch (Exception paramJceInputStream) {}
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVession, 0);
    if (this.sMsg != null) {
      paramJceOutputStream.write(this.sMsg, 1);
    }
    if (this.append != null) {
      paramJceOutputStream.write(this.append, 2);
    }
    if (this.message != null) {
      paramJceOutputStream.write(this.message, 3);
    }
    if (this.troopCode != null) {
      paramJceOutputStream.write(this.troopCode, 4);
    }
    if (this.managerUin != null) {
      paramJceOutputStream.write(this.managerUin, 5);
    }
    if (this.requestUin != null) {
      paramJceOutputStream.write(this.requestUin, 6);
    }
    paramJceOutputStream.write(this.troopType, 7);
    paramJceOutputStream.write(this.op, 8);
    if (this.auth != null) {
      paramJceOutputStream.write(this.auth, 9);
    }
    paramJceOutputStream.write(this.lToMobile, 10);
    if (this.strNickName != null) {
      paramJceOutputStream.write(this.strNickName, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SystemMsg
 * JD-Core Version:    0.7.0.1
 */