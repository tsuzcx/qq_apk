import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class aaug
{
  private static final String beo = aasa.SDCARD_ROOT + "/RDModules" + File.separator + "ConfigData_";
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.has("switch")) {
          break;
        }
        boolean bool = "on".equalsIgnoreCase(paramString2.getString("switch"));
        if (bool)
        {
          c(paramQQAppInterface.getApp(), paramInt, paramString1, 1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RDConfigServletProxy", 2, "parseSwitch, type:" + paramInt + " switch:" + bool + "  uin:" + paramString1);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.e("RDConfigServletProxy", 2, "parse switch exception " + paramQQAppInterface);
        return;
      }
      c(paramQQAppInterface.getApp(), paramInt, paramString1, 0);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.ConfigSeq paramConfigSeq, boolean paramBoolean, String paramString)
  {
    if ((paramConfigSeq == null) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = paramConfigSeq.type.get();
      if (!n(i, paramString)) {
        b(paramQQAppInterface.getApp(), i, paramString, 0);
      }
      j = b(paramQQAppInterface.getApp(), i, paramString);
      paramConfigSeq.version.set(j);
      if (paramBoolean) {
        paramConfigSeq.compress.set(1);
      }
      if (c(paramQQAppInterface.getApp(), i, paramString) < 0) {
        a(paramQQAppInterface.getApp(), i, paramString, new aauh(paramQQAppInterface, i, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("RDConfigServletProxy", 2, "setRequestConfig type:" + i + " version:" + j + " compress:" + paramBoolean + " uin:" + paramString);
  }
  
  /* Error */
  public static boolean a(Context paramContext, int paramInt, String paramString, aaug.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_3
    //   5: ifnonnull +9 -> 14
    //   8: iconst_0
    //   9: istore 7
    //   11: iload 7
    //   13: ireturn
    //   14: iload_1
    //   15: aload_2
    //   16: invokestatic 178	aaug:p	(ILjava/lang/String;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: new 13	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 32	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 180
    //   52: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_2
    //   59: aload_2
    //   60: invokestatic 185	aqhq:fileExists	(Ljava/lang/String;)Z
    //   63: ifne +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: aconst_null
    //   69: astore_0
    //   70: aconst_null
    //   71: astore 9
    //   73: new 187	java/io/FileInputStream
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   81: astore 10
    //   83: aload 10
    //   85: invokevirtual 192	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   88: lconst_0
    //   89: ldc2_w 193
    //   92: iconst_1
    //   93: invokevirtual 200	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +1345 -> 1443
    //   101: new 202	java/io/BufferedInputStream
    //   104: dup
    //   105: aload 10
    //   107: invokespecial 205	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore_0
    //   111: iconst_4
    //   112: newarray byte
    //   114: astore 11
    //   116: aload_0
    //   117: aload 11
    //   119: invokevirtual 211	java/io/InputStream:read	([B)I
    //   122: iconst_4
    //   123: if_icmpne +1314 -> 1437
    //   126: aload 11
    //   128: iconst_0
    //   129: invokestatic 217	wre:bytesToInt	([BI)I
    //   132: istore 4
    //   134: iload 4
    //   136: iconst_4
    //   137: if_icmple +10 -> 147
    //   140: iload 4
    //   142: ldc 218
    //   144: if_icmplt +85 -> 229
    //   147: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +29 -> 179
    //   153: ldc 90
    //   155: iconst_2
    //   156: new 13	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   163: ldc 220
    //   165: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: iconst_0
    //   180: istore 7
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 225	java/nio/channels/FileLock:release	()V
    //   190: aload 10
    //   192: ifnull +8 -> 200
    //   195: aload 10
    //   197: invokevirtual 228	java/io/FileInputStream:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 229	java/io/InputStream:close	()V
    //   208: iload 7
    //   210: ifne +165 -> 375
    //   213: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +11 -> 227
    //   219: ldc 90
    //   221: iconst_2
    //   222: ldc 231
    //   224: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_0
    //   228: ireturn
    //   229: iload 4
    //   231: newarray byte
    //   233: astore 11
    //   235: aload_0
    //   236: aload 11
    //   238: iconst_0
    //   239: iload 4
    //   241: invokevirtual 234	java/io/InputStream:read	([BII)I
    //   244: iload 4
    //   246: if_icmpeq +38 -> 284
    //   249: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +1197 -> 1449
    //   255: ldc 90
    //   257: iconst_2
    //   258: new 13	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   265: ldc 236
    //   267: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload 4
    //   272: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: goto +1168 -> 1449
    //   284: new 238	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   287: dup
    //   288: invokespecial 239	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:<init>	()V
    //   291: astore 9
    //   293: aload 9
    //   295: aload 11
    //   297: checkcast 241	[B
    //   300: invokevirtual 245	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   303: pop
    //   304: iconst_1
    //   305: istore 7
    //   307: goto -125 -> 182
    //   310: astore 11
    //   312: iconst_1
    //   313: istore 7
    //   315: goto -133 -> 182
    //   318: astore_2
    //   319: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq -132 -> 190
    //   325: ldc 90
    //   327: iconst_2
    //   328: ldc 247
    //   330: aload_2
    //   331: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: goto -144 -> 190
    //   337: astore_2
    //   338: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq -141 -> 200
    //   344: ldc 90
    //   346: iconst_2
    //   347: ldc 252
    //   349: aload_2
    //   350: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: goto -153 -> 200
    //   356: astore_0
    //   357: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq -152 -> 208
    //   363: ldc 90
    //   365: iconst_2
    //   366: ldc 254
    //   368: aload_0
    //   369: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto -164 -> 208
    //   375: aload 9
    //   377: ifnonnull +5 -> 382
    //   380: iconst_0
    //   381: ireturn
    //   382: iload_1
    //   383: aload 9
    //   385: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   388: invokevirtual 130	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   391: if_icmpeq +5 -> 396
    //   394: iconst_0
    //   395: ireturn
    //   396: aload 9
    //   398: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   401: ifnull +14 -> 415
    //   404: aload 9
    //   406: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   409: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   412: ifne +20 -> 432
    //   415: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +12 -> 430
    //   421: ldc 90
    //   423: iconst_2
    //   424: ldc_w 266
    //   427: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: iconst_0
    //   431: ireturn
    //   432: aload 9
    //   434: getfield 267	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   437: invokevirtual 130	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   440: istore 5
    //   442: iconst_0
    //   443: istore 4
    //   445: iload 7
    //   447: istore 8
    //   449: iload 8
    //   451: istore 7
    //   453: iload 4
    //   455: aload 9
    //   457: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   460: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   463: if_icmpge -452 -> 11
    //   466: aload 9
    //   468: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   471: iload 4
    //   473: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   476: checkcast 272	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   479: astore_0
    //   480: aload_0
    //   481: ifnull +114 -> 595
    //   484: aload_0
    //   485: getfield 276	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   488: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   491: istore 6
    //   493: aload_0
    //   494: getfield 281	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   497: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   500: iconst_1
    //   501: if_icmpne +169 -> 670
    //   504: aload_0
    //   505: getfield 285	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   508: invokevirtual 290	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   511: invokevirtual 296	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   514: invokestatic 302	akrf:inflateConfigString	([B)[B
    //   517: astore_2
    //   518: aload_2
    //   519: ifnonnull +85 -> 604
    //   522: ldc 90
    //   524: iconst_2
    //   525: new 13	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 304
    //   535: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: iload_1
    //   539: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: ldc_w 306
    //   545: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: iload 6
    //   550: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aconst_null
    //   560: astore_0
    //   561: aload_3
    //   562: iload 5
    //   564: iload 6
    //   566: aload_0
    //   567: iload 4
    //   569: iconst_1
    //   570: iadd
    //   571: aload 9
    //   573: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   576: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   579: invokeinterface 309 6 0
    //   584: istore 8
    //   586: iload 8
    //   588: istore 7
    //   590: iload 8
    //   592: ifeq -581 -> 11
    //   595: iload 4
    //   597: iconst_1
    //   598: iadd
    //   599: istore 4
    //   601: goto -152 -> 449
    //   604: new 69	java/lang/String
    //   607: dup
    //   608: aload_2
    //   609: ldc_w 311
    //   612: invokespecial 314	java/lang/String:<init>	([BLjava/lang/String;)V
    //   615: astore_0
    //   616: goto -55 -> 561
    //   619: astore_0
    //   620: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +7 -> 630
    //   626: aload_0
    //   627: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   630: aconst_null
    //   631: astore_0
    //   632: goto -71 -> 561
    //   635: astore_0
    //   636: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +7 -> 646
    //   642: aload_0
    //   643: invokevirtual 315	java/lang/OutOfMemoryError:printStackTrace	()V
    //   646: invokestatic 320	java/lang/System:gc	()V
    //   649: new 69	java/lang/String
    //   652: dup
    //   653: aload_2
    //   654: ldc_w 311
    //   657: invokespecial 314	java/lang/String:<init>	([BLjava/lang/String;)V
    //   660: astore_0
    //   661: goto -100 -> 561
    //   664: astore_0
    //   665: aconst_null
    //   666: astore_0
    //   667: goto -106 -> 561
    //   670: aload_0
    //   671: getfield 285	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   674: invokevirtual 290	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   677: invokevirtual 323	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   680: astore_0
    //   681: goto -120 -> 561
    //   684: astore 11
    //   686: aconst_null
    //   687: astore_0
    //   688: aconst_null
    //   689: astore 10
    //   691: aconst_null
    //   692: astore 9
    //   694: aconst_null
    //   695: astore_2
    //   696: aload 11
    //   698: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   701: ldc 90
    //   703: iconst_2
    //   704: new 13	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 325
    //   714: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload 11
    //   719: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: aload_0
    //   729: ifnull +7 -> 736
    //   732: aload_0
    //   733: invokevirtual 225	java/nio/channels/FileLock:release	()V
    //   736: aload 10
    //   738: ifnull +8 -> 746
    //   741: aload 10
    //   743: invokevirtual 228	java/io/FileInputStream:close	()V
    //   746: aload 9
    //   748: ifnull +8 -> 756
    //   751: aload 9
    //   753: invokevirtual 229	java/io/InputStream:close	()V
    //   756: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   759: ifeq +11 -> 770
    //   762: ldc 90
    //   764: iconst_2
    //   765: ldc 231
    //   767: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   770: iconst_0
    //   771: ireturn
    //   772: astore_0
    //   773: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq -40 -> 736
    //   779: ldc 90
    //   781: iconst_2
    //   782: ldc 247
    //   784: aload_0
    //   785: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   788: goto -52 -> 736
    //   791: astore_0
    //   792: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq -49 -> 746
    //   798: ldc 90
    //   800: iconst_2
    //   801: ldc 252
    //   803: aload_0
    //   804: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   807: goto -61 -> 746
    //   810: astore_0
    //   811: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   814: ifeq -58 -> 756
    //   817: ldc 90
    //   819: iconst_2
    //   820: ldc 254
    //   822: aload_0
    //   823: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   826: goto -70 -> 756
    //   829: astore_0
    //   830: aconst_null
    //   831: astore 11
    //   833: aconst_null
    //   834: astore 10
    //   836: aconst_null
    //   837: astore 9
    //   839: aconst_null
    //   840: astore_2
    //   841: iconst_1
    //   842: istore 4
    //   844: aload 11
    //   846: ifnull +8 -> 854
    //   849: aload 11
    //   851: invokevirtual 225	java/nio/channels/FileLock:release	()V
    //   854: aload 10
    //   856: ifnull +8 -> 864
    //   859: aload 10
    //   861: invokevirtual 228	java/io/FileInputStream:close	()V
    //   864: aload 9
    //   866: ifnull +8 -> 874
    //   869: aload 9
    //   871: invokevirtual 229	java/io/InputStream:close	()V
    //   874: iload 4
    //   876: ifne +82 -> 958
    //   879: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +11 -> 893
    //   885: ldc 90
    //   887: iconst_2
    //   888: ldc 231
    //   890: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: iconst_0
    //   894: ireturn
    //   895: astore 11
    //   897: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq -46 -> 854
    //   903: ldc 90
    //   905: iconst_2
    //   906: ldc 247
    //   908: aload 11
    //   910: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   913: goto -59 -> 854
    //   916: astore 10
    //   918: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   921: ifeq -57 -> 864
    //   924: ldc 90
    //   926: iconst_2
    //   927: ldc 252
    //   929: aload 10
    //   931: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   934: goto -70 -> 864
    //   937: astore 9
    //   939: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq -68 -> 874
    //   945: ldc 90
    //   947: iconst_2
    //   948: ldc 254
    //   950: aload 9
    //   952: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   955: goto -81 -> 874
    //   958: aload_2
    //   959: ifnonnull +5 -> 964
    //   962: iconst_0
    //   963: ireturn
    //   964: iload_1
    //   965: aload_2
    //   966: getfield 255	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   969: invokevirtual 130	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   972: if_icmpeq +5 -> 977
    //   975: iconst_0
    //   976: ireturn
    //   977: aload_2
    //   978: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   981: ifnull +13 -> 994
    //   984: aload_2
    //   985: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   988: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   991: ifne +20 -> 1011
    //   994: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   997: ifeq +12 -> 1009
    //   1000: ldc 90
    //   1002: iconst_2
    //   1003: ldc_w 266
    //   1006: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: iconst_0
    //   1010: ireturn
    //   1011: aload_2
    //   1012: getfield 267	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1015: invokevirtual 130	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1018: istore 5
    //   1020: iconst_0
    //   1021: istore 4
    //   1023: iload 4
    //   1025: aload_2
    //   1026: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1029: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1032: if_icmpge +131 -> 1163
    //   1035: aload_2
    //   1036: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1039: iload 4
    //   1041: invokevirtual 270	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1044: checkcast 272	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   1047: astore 9
    //   1049: aload 9
    //   1051: ifnull +207 -> 1258
    //   1054: aload 9
    //   1056: getfield 276	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1059: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1062: istore 6
    //   1064: aload 9
    //   1066: getfield 281	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1069: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1072: iconst_1
    //   1073: if_icmpne +169 -> 1242
    //   1076: aload 9
    //   1078: getfield 285	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1081: invokevirtual 290	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1084: invokevirtual 296	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1087: invokestatic 302	akrf:inflateConfigString	([B)[B
    //   1090: astore 10
    //   1092: aload 10
    //   1094: ifnonnull +71 -> 1165
    //   1097: ldc 90
    //   1099: iconst_2
    //   1100: new 13	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   1107: ldc_w 304
    //   1110: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: iload_1
    //   1114: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1117: ldc_w 306
    //   1120: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: iload 6
    //   1125: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1128: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1131: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1134: aconst_null
    //   1135: astore 9
    //   1137: aload_3
    //   1138: iload 5
    //   1140: iload 6
    //   1142: aload 9
    //   1144: iload 4
    //   1146: iconst_1
    //   1147: iadd
    //   1148: aload_2
    //   1149: getfield 259	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1152: invokevirtual 264	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1155: invokeinterface 309 6 0
    //   1160: ifne +98 -> 1258
    //   1163: aload_0
    //   1164: athrow
    //   1165: new 69	java/lang/String
    //   1168: dup
    //   1169: aload 10
    //   1171: ldc_w 311
    //   1174: invokespecial 314	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1177: astore 9
    //   1179: goto -42 -> 1137
    //   1182: astore 9
    //   1184: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +8 -> 1195
    //   1190: aload 9
    //   1192: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   1195: aconst_null
    //   1196: astore 9
    //   1198: goto -61 -> 1137
    //   1201: astore 9
    //   1203: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1206: ifeq +8 -> 1214
    //   1209: aload 9
    //   1211: invokevirtual 315	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1214: invokestatic 320	java/lang/System:gc	()V
    //   1217: new 69	java/lang/String
    //   1220: dup
    //   1221: aload 10
    //   1223: ldc_w 311
    //   1226: invokespecial 314	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1229: astore 9
    //   1231: goto -94 -> 1137
    //   1234: astore 9
    //   1236: aconst_null
    //   1237: astore 9
    //   1239: goto -102 -> 1137
    //   1242: aload 9
    //   1244: getfield 285	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1247: invokevirtual 290	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1250: invokevirtual 323	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1253: astore 9
    //   1255: goto -118 -> 1137
    //   1258: iload 4
    //   1260: iconst_1
    //   1261: iadd
    //   1262: istore 4
    //   1264: goto -241 -> 1023
    //   1267: astore_0
    //   1268: aconst_null
    //   1269: astore 11
    //   1271: aconst_null
    //   1272: astore 9
    //   1274: aconst_null
    //   1275: astore_2
    //   1276: iconst_1
    //   1277: istore 4
    //   1279: goto -435 -> 844
    //   1282: astore_0
    //   1283: aconst_null
    //   1284: astore 12
    //   1286: aconst_null
    //   1287: astore 9
    //   1289: iconst_1
    //   1290: istore 4
    //   1292: aload_2
    //   1293: astore 11
    //   1295: aload 12
    //   1297: astore_2
    //   1298: goto -454 -> 844
    //   1301: astore 12
    //   1303: aconst_null
    //   1304: astore 13
    //   1306: iconst_1
    //   1307: istore 4
    //   1309: aload_0
    //   1310: astore 9
    //   1312: aload_2
    //   1313: astore 11
    //   1315: aload 12
    //   1317: astore_0
    //   1318: aload 13
    //   1320: astore_2
    //   1321: goto -477 -> 844
    //   1324: astore 12
    //   1326: aload 9
    //   1328: astore 13
    //   1330: iconst_1
    //   1331: istore 4
    //   1333: aload_0
    //   1334: astore 9
    //   1336: aload_2
    //   1337: astore 11
    //   1339: aload 12
    //   1341: astore_0
    //   1342: aload 13
    //   1344: astore_2
    //   1345: goto -501 -> 844
    //   1348: astore 12
    //   1350: iconst_1
    //   1351: istore 4
    //   1353: aload_0
    //   1354: astore 11
    //   1356: aload 12
    //   1358: astore_0
    //   1359: goto -515 -> 844
    //   1362: astore 12
    //   1364: iconst_0
    //   1365: istore 4
    //   1367: aload_0
    //   1368: astore 11
    //   1370: aload 12
    //   1372: astore_0
    //   1373: goto -529 -> 844
    //   1376: astore 11
    //   1378: aconst_null
    //   1379: astore_2
    //   1380: aconst_null
    //   1381: astore_0
    //   1382: aconst_null
    //   1383: astore 9
    //   1385: goto -689 -> 696
    //   1388: astore 11
    //   1390: aconst_null
    //   1391: astore 12
    //   1393: aload_2
    //   1394: astore_0
    //   1395: aconst_null
    //   1396: astore 9
    //   1398: aload 12
    //   1400: astore_2
    //   1401: goto -705 -> 696
    //   1404: astore 11
    //   1406: aconst_null
    //   1407: astore 12
    //   1409: aload_0
    //   1410: astore 9
    //   1412: aload_2
    //   1413: astore_0
    //   1414: aload 12
    //   1416: astore_2
    //   1417: goto -721 -> 696
    //   1420: astore 11
    //   1422: aload_0
    //   1423: astore 12
    //   1425: aload_2
    //   1426: astore_0
    //   1427: aload 9
    //   1429: astore_2
    //   1430: aload 12
    //   1432: astore 9
    //   1434: goto -738 -> 696
    //   1437: iconst_1
    //   1438: istore 7
    //   1440: goto -1258 -> 182
    //   1443: iconst_1
    //   1444: istore 7
    //   1446: goto -1264 -> 182
    //   1449: iconst_0
    //   1450: istore 7
    //   1452: goto -1270 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1455	0	paramContext	Context
    //   0	1455	1	paramInt	int
    //   0	1455	2	paramString	String
    //   0	1455	3	parama	aaug.a
    //   132	1234	4	i	int
    //   440	699	5	j	int
    //   491	650	6	k	int
    //   9	1442	7	bool1	boolean
    //   447	144	8	bool2	boolean
    //   71	799	9	localConfig	com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
    //   937	14	9	localException1	Exception
    //   1047	131	9	localObject1	Object
    //   1182	9	9	localException2	Exception
    //   1196	1	9	localObject2	Object
    //   1201	9	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1229	1	9	str	String
    //   1234	1	9	localThrowable	java.lang.Throwable
    //   1237	196	9	localObject3	Object
    //   81	779	10	localFileInputStream	java.io.FileInputStream
    //   916	14	10	localException3	Exception
    //   1090	132	10	arrayOfByte1	byte[]
    //   114	182	11	arrayOfByte2	byte[]
    //   310	1	11	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   684	34	11	localException4	Exception
    //   831	19	11	localObject4	Object
    //   895	14	11	localException5	Exception
    //   1269	100	11	localObject5	Object
    //   1376	1	11	localException6	Exception
    //   1388	1	11	localException7	Exception
    //   1404	1	11	localException8	Exception
    //   1420	1	11	localException9	Exception
    //   1284	12	12	localObject6	Object
    //   1301	15	12	localObject7	Object
    //   1324	16	12	localObject8	Object
    //   1348	9	12	localObject9	Object
    //   1362	9	12	localObject10	Object
    //   1391	40	12	localContext	Context
    //   1304	39	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   293	304	310	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   186	190	318	java/lang/Exception
    //   195	200	337	java/lang/Exception
    //   204	208	356	java/lang/Exception
    //   604	616	619	java/lang/Exception
    //   604	616	635	java/lang/OutOfMemoryError
    //   649	661	664	java/lang/Throwable
    //   73	83	684	java/lang/Exception
    //   732	736	772	java/lang/Exception
    //   741	746	791	java/lang/Exception
    //   751	756	810	java/lang/Exception
    //   73	83	829	finally
    //   849	854	895	java/lang/Exception
    //   859	864	916	java/lang/Exception
    //   869	874	937	java/lang/Exception
    //   1165	1179	1182	java/lang/Exception
    //   1165	1179	1201	java/lang/OutOfMemoryError
    //   1217	1231	1234	java/lang/Throwable
    //   83	97	1267	finally
    //   101	111	1282	finally
    //   111	134	1301	finally
    //   147	179	1301	finally
    //   229	281	1301	finally
    //   284	293	1301	finally
    //   293	304	1324	finally
    //   696	701	1348	finally
    //   701	728	1362	finally
    //   83	97	1376	java/lang/Exception
    //   101	111	1388	java/lang/Exception
    //   111	134	1404	java/lang/Exception
    //   147	179	1404	java/lang/Exception
    //   229	281	1404	java/lang/Exception
    //   284	293	1404	java/lang/Exception
    //   293	304	1420	java/lang/Exception
  }
  
  public static int b(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return 0;
    }
    paramString = q(paramInt, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, 0);
  }
  
  private static void b(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    paramString = q(paramInt1, paramString);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt2);
    paramContext.commit();
  }
  
  public static int c(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext == null) {
      return -1;
    }
    paramString = r(paramInt, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, -1);
  }
  
  private static void c(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    paramString = r(paramInt1, paramString);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt2);
    paramContext.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RDConfigServletProxy", 2, "onConfigFailed type: " + paramInt1 + " result:" + paramInt2);
    }
  }
  
  public static boolean n(int paramInt, String paramString)
  {
    paramString = p(paramInt, paramString);
    if (TextUtils.isEmpty(paramString)) {}
    while (!aqhq.fileExists(paramString + File.separator + paramInt + ".cfg")) {
      return false;
    }
    return true;
  }
  
  public static String p(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return beo + paramInt + "_" + paramString;
    }
    return beo + paramInt;
  }
  
  private static String q(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return "rdconfigdataproxy_cp_" + paramInt + "_version_" + paramString;
    }
    return "rdconfigdataproxy_cp_" + paramInt + "_version";
  }
  
  private static String r(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      return "rdconfigdataproxy_cp_" + paramInt + "_switch_" + paramString;
    }
    return "rdconfigdataproxy_cp_" + paramInt + "_switch";
  }
  
  public static abstract interface a
  {
    public abstract boolean b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaug
 * JD-Core Version:    0.7.0.1
 */