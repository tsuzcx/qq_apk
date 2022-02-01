import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.10;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.11;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.2;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.3;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.6;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.8;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class aoar
  extends accg
  implements Handler.Callback
{
  private ConcurrentLinkedQueue<aoau> K = new ConcurrentLinkedQueue();
  private volatile boolean cKV;
  private volatile boolean cKW;
  private String[] hg = { "docs.qq.com" };
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> iu = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> iv = new ConcurrentHashMap();
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> iw = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> ix = new ConcurrentHashMap();
  private Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public aoar(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  private boolean a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: aload_2
    //   7: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   10: invokestatic 91	aodb:aO	(Ljava/lang/String;)J
    //   13: lstore 9
    //   15: aload_0
    //   16: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: aload_2
    //   20: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   23: ldc 97
    //   25: lload 9
    //   27: invokestatic 101	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: new 103	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   37: ldc 106
    //   39: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: getfield 114	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerType	I
    //   46: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: getfield 120	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   53: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: getfield 123	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   60: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: ldc 129
    //   68: invokestatic 132	aodb:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +764 -> 839
    //   78: iload 8
    //   80: istore 6
    //   82: new 140	org/json/JSONObject
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: astore 12
    //   92: iload 8
    //   94: istore 6
    //   96: aload 12
    //   98: ldc 145
    //   100: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   103: istore 4
    //   105: iload 8
    //   107: istore 6
    //   109: aload 12
    //   111: ldc 151
    //   113: invokevirtual 155	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   116: ifeq +802 -> 918
    //   119: iload 8
    //   121: istore 6
    //   123: aload 12
    //   125: ldc 151
    //   127: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 11
    //   132: iload 8
    //   134: istore 6
    //   136: ldc 161
    //   138: new 103	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   145: ldc 163
    //   147: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 166	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:fileName	Ljava/lang/String;
    //   154: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   163: invokestatic 101	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   166: aload_2
    //   167: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   170: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 4
    //   175: tableswitch	default:+750 -> 925, 0:+211->386
    //   193: iconst_5
    //   194: istore 6
    //   196: aload_2
    //   197: iload 4
    //   199: putfield 179	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:retCode	I
    //   202: iload 8
    //   204: istore 6
    //   206: aload_2
    //   207: aload 11
    //   209: putfield 182	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjF	Ljava/lang/String;
    //   212: iload 8
    //   214: istore 6
    //   216: ldc 161
    //   218: iconst_1
    //   219: new 103	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   226: ldc 184
    //   228: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 4
    //   233: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc 186
    //   238: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: getfield 182	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjF	Ljava/lang/String;
    //   245: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: iload 8
    //   256: istore 6
    //   258: ldc 161
    //   260: ldc 194
    //   262: aload_2
    //   263: invokevirtual 195	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   266: aload_2
    //   267: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   270: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   273: iload 7
    //   275: istore 5
    //   277: iload 4
    //   279: ifne +320 -> 599
    //   282: iload 5
    //   284: istore 6
    //   286: aload_0
    //   287: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   290: aload_2
    //   291: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   294: ldc 197
    //   296: ldc 199
    //   298: new 103	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   305: ldc 106
    //   307: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_2
    //   311: getfield 114	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerType	I
    //   314: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: aload_2
    //   318: getfield 120	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   321: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: aload_2
    //   325: getfield 123	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   328: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: ldc 129
    //   336: invokestatic 132	aodb:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   339: iload 5
    //   341: istore 6
    //   343: ldc 161
    //   345: ldc 201
    //   347: new 103	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   354: aload_2
    //   355: getfield 179	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:retCode	I
    //   358: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc 203
    //   363: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_2
    //   367: getfield 182	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjF	Ljava/lang/String;
    //   370: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aload_2
    //   377: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   380: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   383: iload 5
    //   385: ireturn
    //   386: iload 8
    //   388: istore 6
    //   390: aload 12
    //   392: ldc 205
    //   394: invokevirtual 209	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   397: astore 14
    //   399: iload 8
    //   401: istore 6
    //   403: aload 14
    //   405: ldc 211
    //   407: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore 13
    //   412: iload 7
    //   414: istore 5
    //   416: iload 8
    //   418: istore 6
    //   420: aload_0
    //   421: getfield 40	aoar:mUIHandler	Landroid/os/Handler;
    //   424: ifnull -147 -> 277
    //   427: iload 7
    //   429: istore 5
    //   431: iload 8
    //   433: istore 6
    //   435: aload 13
    //   437: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne -163 -> 277
    //   443: iload 7
    //   445: istore 5
    //   447: iload 8
    //   449: istore 6
    //   451: aload_0
    //   452: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   455: ifnull -178 -> 277
    //   458: iload 8
    //   460: istore 6
    //   462: aload 14
    //   464: ldc 213
    //   466: invokevirtual 155	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   469: ifeq +125 -> 594
    //   472: iload 8
    //   474: istore 6
    //   476: aload 14
    //   478: ldc 213
    //   480: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   483: istore_3
    //   484: ldc 129
    //   486: astore 12
    //   488: iload 8
    //   490: istore 6
    //   492: aload 14
    //   494: ldc 215
    //   496: invokevirtual 155	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   499: ifeq +16 -> 515
    //   502: iload 8
    //   504: istore 6
    //   506: aload 14
    //   508: ldc 215
    //   510: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore 12
    //   515: aload_2
    //   516: iload_3
    //   517: putfield 217	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:urlType	I
    //   520: aload_2
    //   521: aload 12
    //   523: putfield 220	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:aTw	Ljava/lang/String;
    //   526: new 222	android/os/Bundle
    //   529: dup
    //   530: invokespecial 223	android/os/Bundle:<init>	()V
    //   533: astore 12
    //   535: aload 12
    //   537: ldc 225
    //   539: aload 13
    //   541: invokevirtual 229	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload 12
    //   546: ldc 231
    //   548: aload_2
    //   549: invokevirtual 235	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   552: aload_0
    //   553: getfield 40	aoar:mUIHandler	Landroid/os/Handler;
    //   556: sipush 8001
    //   559: invokevirtual 239	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   562: astore 14
    //   564: aload 14
    //   566: aload 12
    //   568: invokevirtual 245	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   571: aload_0
    //   572: getfield 40	aoar:mUIHandler	Landroid/os/Handler;
    //   575: aload 14
    //   577: invokevirtual 249	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   580: pop
    //   581: aload_0
    //   582: aload_2
    //   583: aload 13
    //   585: invokevirtual 252	aoar:b	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   588: iconst_1
    //   589: istore 5
    //   591: goto -314 -> 277
    //   594: iconst_0
    //   595: istore_3
    //   596: goto -112 -> 484
    //   599: iload 5
    //   601: istore 6
    //   603: aload_0
    //   604: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   607: aload_2
    //   608: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   611: ldc 197
    //   613: ldc 254
    //   615: new 103	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 256
    //   625: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: iload 4
    //   630: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: aload 11
    //   635: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: new 103	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   648: ldc 106
    //   650: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_2
    //   654: getfield 114	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerType	I
    //   657: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: aload_2
    //   661: getfield 120	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   664: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: aload_2
    //   668: getfield 123	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   671: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 132	aodb:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   680: goto -341 -> 339
    //   683: astore 11
    //   685: ldc 161
    //   687: iconst_1
    //   688: new 103	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 258
    //   698: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 11
    //   703: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   706: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: ldc 161
    //   717: ldc_w 261
    //   720: aload 11
    //   722: invokevirtual 264	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   725: aload_2
    //   726: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   729: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   732: ldc 161
    //   734: ldc_w 266
    //   737: aload_1
    //   738: aload_2
    //   739: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   742: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   745: ldc 161
    //   747: ldc_w 268
    //   750: aload_2
    //   751: invokevirtual 195	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   754: aload_2
    //   755: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   758: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   761: aload_0
    //   762: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   765: aload_2
    //   766: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   769: ldc 197
    //   771: ldc 254
    //   773: new 103	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   780: ldc_w 256
    //   783: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload 11
    //   788: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   791: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: new 103	java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   804: ldc 106
    //   806: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_2
    //   810: getfield 114	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerType	I
    //   813: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: aload_2
    //   817: getfield 120	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   820: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: aload_2
    //   824: getfield 123	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   827: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 132	aodb:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   836: iload 6
    //   838: ireturn
    //   839: ldc 161
    //   841: ldc_w 261
    //   844: ldc_w 273
    //   847: aload_2
    //   848: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   851: invokestatic 176	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload_0
    //   855: getfield 95	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   858: aload_2
    //   859: getfield 85	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   862: ldc 197
    //   864: ldc 254
    //   866: ldc_w 275
    //   869: new 103	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   876: ldc 106
    //   878: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: aload_2
    //   882: getfield 114	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerType	I
    //   885: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: aload_2
    //   889: getfield 120	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   892: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: aload_2
    //   896: getfield 123	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   899: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 132	aodb:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   908: iconst_0
    //   909: ireturn
    //   910: astore 11
    //   912: iconst_1
    //   913: istore 6
    //   915: goto -230 -> 685
    //   918: ldc 129
    //   920: astore 11
    //   922: goto -790 -> 132
    //   925: goto -733 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	aoar
    //   0	928	1	paramString	String
    //   0	928	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   483	113	3	i	int
    //   103	526	4	j	int
    //   275	325	5	bool1	boolean
    //   80	834	6	bool2	boolean
    //   4	440	7	bool3	boolean
    //   1	502	8	bool4	boolean
    //   13	13	9	l	long
    //   130	504	11	str1	String
    //   683	104	11	localException1	Exception
    //   910	1	11	localException2	Exception
    //   920	1	11	str2	String
    //   90	477	12	localObject1	Object
    //   410	174	13	str3	String
    //   397	179	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	92	683	java/lang/Exception
    //   96	105	683	java/lang/Exception
    //   109	119	683	java/lang/Exception
    //   123	132	683	java/lang/Exception
    //   136	173	683	java/lang/Exception
    //   196	202	683	java/lang/Exception
    //   206	212	683	java/lang/Exception
    //   216	254	683	java/lang/Exception
    //   258	273	683	java/lang/Exception
    //   286	339	683	java/lang/Exception
    //   343	383	683	java/lang/Exception
    //   390	399	683	java/lang/Exception
    //   403	412	683	java/lang/Exception
    //   420	427	683	java/lang/Exception
    //   435	443	683	java/lang/Exception
    //   451	458	683	java/lang/Exception
    //   462	472	683	java/lang/Exception
    //   476	484	683	java/lang/Exception
    //   492	502	683	java/lang/Exception
    //   506	515	683	java/lang/Exception
    //   603	680	683	java/lang/Exception
    //   515	588	910	java/lang/Exception
  }
  
  private void am(Runnable paramRunnable)
  {
    if (this.app == null) {}
    while (((TicketManager)this.app.getManager(2)).GetPskey(this.app.getCurrentAccountUin(), 16L, this.hg, new aoas(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  private String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.azt())
    {
      String str1 = aoag.a(paramTeamWorkFileImportInfo);
      String str2 = paramTeamWorkFileImportInfo.filePath;
      paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.WeiYunFileId;
      if (!TextUtils.isEmpty(str1)) {
        return str1;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo)) {
        return paramTeamWorkFileImportInfo;
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (str2 + this.app != null) {
          return this.app.getCurrentAccountUin();
        }
        return "";
      }
    }
    else
    {
      if (paramTeamWorkFileImportInfo.peerType == 1) {
        return paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;
      }
      if ((paramTeamWorkFileImportInfo.peerType == 3000) || (paramTeamWorkFileImportInfo.peerType == 0)) {
        return paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq + "_" + paramTeamWorkFileImportInfo.nSessionId;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) {
        return paramTeamWorkFileImportInfo.filePath;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.srcUrl)) {
        return paramTeamWorkFileImportInfo.srcUrl;
      }
    }
    return "";
  }
  
  private boolean b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = aodb.aO(paramTeamWorkFileImportInfo.traceId);
    aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    int n;
    String str2;
    boolean bool1;
    label350:
    Object localObject3;
    label412:
    int i;
    int j;
    label691:
    Object localObject2;
    label898:
    Object localObject4;
    label1641:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool2 = bool4;
          n = localJSONObject.getInt("ret");
          bool2 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool2 = bool4;
            localJSONObject.getString("msg");
          }
          bool2 = bool4;
          str2 = localJSONObject.getString("error");
          bool2 = bool4;
          aodb.Q("TeamWorkFileImportHandler", "addFileImportJob end:" + paramTeamWorkFileImportInfo.fileName, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.traceId);
          switch (n)
          {
          case 0: 
            bool2 = bool4;
            paramTeamWorkFileImportInfo.retCode = n;
            bool2 = bool4;
            paramTeamWorkFileImportInfo.cjF = str2;
            bool2 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
            bool2 = bool4;
            aodb.Q("TeamWorkFileImportHandler", "import file job fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.traceId);
            bool1 = bool3;
            if (n != 0) {
              break label2699;
            }
            bool2 = bool1;
            aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR, "");
            bool2 = bool1;
            aodb.Q("TeamWorkFileImportHandler", "import result", paramTeamWorkFileImportInfo.retCode + " " + paramTeamWorkFileImportInfo.cjF, paramTeamWorkFileImportInfo.traceId);
            return bool1;
          }
        }
        catch (Exception localException1) {}
        bool2 = bool4;
        localObject3 = localJSONObject.getString("url");
        bool1 = bool3;
        bool2 = bool4;
        if (this.mUIHandler != null)
        {
          bool1 = bool3;
          bool2 = bool4;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            bool1 = bool3;
            bool2 = bool4;
            if (this.app != null)
            {
              bool2 = bool4;
              if (localJSONObject.has("urlType"))
              {
                bool2 = bool4;
                i = localJSONObject.getInt("urlType");
                bool2 = bool4;
                j = paramTeamWorkFileImportInfo.dNR;
                bool2 = bool4;
                QLog.e("TeamWorkFileImportHandler", 1, " parseFileImportResult: " + i + ",importOption: " + j);
                bool2 = bool4;
                Object localObject1 = localObject3;
                if (!paramTeamWorkFileImportInfo.azu()) {
                  break label2862;
                }
                bool2 = bool4;
                localObject3 = aobw.nS((String)localObject3);
                if ((i == 1) || (i == 2))
                {
                  bool2 = bool4;
                  aodb.aN(this.app, "0X8009ECF");
                }
                if (i == 2)
                {
                  bool2 = bool4;
                  QLog.w("TeamWorkFileImportHandler", 1, "online preview has edited cache, import again");
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.urlType = i;
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.cjH = ((String)localObject3);
                  bool1 = bool3;
                  continue;
                  QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResult JSONException: " + localException1.toString());
                  anot.a(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                  aodb.Q("TeamWorkFileImportHandler", "parse import file json fail", localException1.getLocalizedMessage(), paramTeamWorkFileImportInfo.traceId);
                  aodb.Q("TeamWorkFileImportHandler", "parse import file json fail, param", paramString, paramTeamWorkFileImportInfo.traceId);
                  aodb.Q("TeamWorkFileImportHandler", "parse import file json fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.traceId);
                  aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=" + localException1.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
                  return bool2;
                }
              }
              else
              {
                i = 0;
                continue;
              }
              if (i == 1)
              {
                bool2 = bool4;
                paramTeamWorkFileImportInfo.cjH = null;
                localObject2 = localObject3;
                localObject3 = "";
                bool2 = bool4;
                if (localJSONObject.has("doc_id"))
                {
                  bool2 = bool4;
                  localObject3 = localJSONObject.getString("doc_id");
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.dNR == 7)
                {
                  bool2 = bool4;
                  if (paramTeamWorkFileImportInfo.peerType == 1)
                  {
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      bool2 = bool4;
                      RI((String)localObject3);
                    }
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      bool2 = bool4;
                      notifyUI(5, true, new Object[] { Integer.valueOf(0) });
                    }
                  }
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.dNR == 1)
                {
                  bool2 = bool4;
                  notifyUI(6, true, new Object[] { localObject2, localObject3, paramTeamWorkFileImportInfo });
                }
                bool2 = true;
              }
            }
          }
        }
        try
        {
          paramTeamWorkFileImportInfo.urlType = i;
          paramTeamWorkFileImportInfo.aTw = ((String)localObject3);
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("url", (String)localObject2);
          ((Bundle)localObject3).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
          localObject4 = this.mUIHandler.obtainMessage(8001);
          ((Message)localObject4).setData((Bundle)localObject3);
          this.mUIHandler.sendMessage((Message)localObject4);
          b(paramTeamWorkFileImportInfo, (String)localObject2);
          if ((j != 1) && (j != 7) && (!paramTeamWorkFileImportInfo.azr()) && (!paramTeamWorkFileImportInfo.azs())) {
            c(paramTeamWorkFileImportInfo, (String)localObject2);
          }
          anot.a(this.app, "dc00898", "", "", "0X8009066", "0X8009066", 0, 0, "", "", "", "");
          bool1 = true;
        }
        catch (Exception localException2) {}
        localObject2 = localObject3;
        if (i != 0) {
          break label2862;
        }
        bool2 = bool4;
        localObject2 = localObject3;
        if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.cjH)) {
          break label2862;
        }
        bool2 = bool4;
        localObject2 = aobw.bC((String)localObject3, paramTeamWorkFileImportInfo.cjH);
        bool2 = bool4;
        QLog.w("TeamWorkFileImportHandler", 1, "append edited url: " + (String)localObject2);
        break label2862;
        localObject3 = "";
        localObject4 = "";
        String str1 = "";
        bool2 = bool4;
        localObject2 = localObject3;
        if (localJSONObject.has("filePath"))
        {
          bool2 = bool4;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
          {
            bool2 = bool4;
            localObject2 = localJSONObject.getString("filePath");
          }
        }
        bool2 = bool4;
        localObject3 = localObject4;
        if (localJSONObject.has("md5"))
        {
          bool2 = bool4;
          localObject3 = localObject4;
          if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
          {
            bool2 = bool4;
            localObject3 = localJSONObject.getString("md5");
          }
        }
        bool2 = bool4;
        localObject4 = str1;
        if (localJSONObject.has("fileName"))
        {
          bool2 = bool4;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
          {
            bool2 = bool4;
            localObject4 = localJSONObject.getString("fileName");
          }
        }
        bool2 = bool4;
        str1 = paramTeamWorkFileImportInfo.folderId;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.redirectUrl = String.format(aoaf.cjC, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject3, "UTF-8"), URLEncoder.encode((String)localObject4, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), "preview" });
        bool2 = bool4;
        paramTeamWorkFileImportInfo.retCode = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.cjF = str2;
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
        bool1 = bool3;
        continue;
        bool2 = bool4;
        localObject2 = new JSONObject(str2);
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startRow")) {
          break label2865;
        }
        bool2 = bool4;
        i = ((JSONObject)localObject2).getInt("startRow");
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endRow")) {
          break label2870;
        }
        bool2 = bool4;
        j = ((JSONObject)localObject2).getInt("endRow");
        label1670:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startCol")) {
          break label2876;
        }
        bool2 = bool4;
        k = ((JSONObject)localObject2).getInt("startCol");
        label1699:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endCol")) {
          break label2882;
        }
        bool2 = bool4;
      }
    }
    label2699:
    label2862:
    label2865:
    label2870:
    label2876:
    label2882:
    for (int m = ((JSONObject)localObject2).getInt("endCol");; m = 0)
    {
      bool2 = bool4;
      localObject2 = aobw.ft(k);
      bool2 = bool4;
      localObject3 = aobw.ft(m);
      bool2 = bool4;
      localObject4 = new StringBuilder();
      bool2 = bool4;
      ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720912));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("1");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { Integer.valueOf(i) }));
          label1883:
          if (k != m) {
            break label2143;
          }
          bool2 = bool4;
          ((StringBuilder)localObject4).append("\n");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("2");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { localObject2 }));
        }
      }
      for (;;)
      {
        bool2 = bool4;
        paramTeamWorkFileImportInfo.retCode = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.cjF = ((StringBuilder)localObject4).toString();
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
        bool1 = bool3;
        break;
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("1");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1883;
        label2143:
        bool2 = bool4;
        ((StringBuilder)localObject4).append("\n");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("2");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { localObject2, localObject3 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { localObject2 }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131720908));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { localObject2, localObject3 }));
          }
        }
      }
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_PUBLIC_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.urlType = 0;
      bool1 = bool3;
      break label350;
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_USER_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.urlType = 0;
      bool1 = bool3;
      break label350;
      bool2 = bool4;
      l(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      n(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      notifyUI(5, true, new Object[] { Integer.valueOf(1) });
      bool1 = bool3;
      break label350;
      bool2 = bool1;
      aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
      break label412;
      aodb.Q("TeamWorkFileImportHandler", "parse import file json fail", "no result string", paramTeamWorkFileImportInfo.traceId);
      aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
      return false;
      break label691;
      break;
      break label898;
      i = 0;
      break label1641;
      j = 0;
      break label1670;
      k = 0;
      break label1699;
    }
  }
  
  private void d(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    aocg localaocg = aocg.a(paramJSONObject);
    if ((localaocg != null) && (localaocg.url != null)) {
      if (this.mUIHandler != null)
      {
        paramTeamWorkFileImportInfo.dNU = localaocg.dNU;
        paramTeamWorkFileImportInfo.cjI = localaocg.cjI;
        paramJSONObject = new Bundle();
        paramJSONObject.putString("url", localaocg.url);
        paramJSONObject.putParcelable("fileInfo", paramTeamWorkFileImportInfo);
        paramTeamWorkFileImportInfo = this.mUIHandler.obtainMessage(8001);
        paramTeamWorkFileImportInfo.setData(paramJSONObject);
        this.mUIHandler.sendMessage(paramTeamWorkFileImportInfo);
      }
    }
    while (this.mUIHandler == null) {
      return;
    }
    paramTeamWorkFileImportInfo.retCode = paramJSONObject.optInt("retcode", -1);
    paramJSONObject = this.mUIHandler.obtainMessage(8002);
    paramJSONObject.obj = paramTeamWorkFileImportInfo;
    this.mUIHandler.sendMessage(paramJSONObject);
  }
  
  private void dUf()
  {
    if (this.cKV) {
      return;
    }
    this.cKV = true;
    if (this.K != null) {
      while (!this.K.isEmpty())
      {
        aoau localaoau = (aoau)this.K.poll();
        if (localaoau != null)
        {
          if (localaoau.e != null)
          {
            localaoau.e.dNT = localaoau.hashCode();
            QLog.d("TeamWorkFileImportHandler", 2, "current job hashcode: " + localaoau.e.dNT);
          }
          localaoau.ei(this.app);
          notifyUI(4, false, localaoau.e);
        }
      }
    }
    this.cKV = false;
  }
  
  public void QH(boolean paramBoolean)
  {
    this.cKW = paramBoolean;
  }
  
  public void RI(String paramString)
  {
    if ((this.app == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    am(new TeamWorkFileImportHandler.8(this, paramString));
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.4(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    am(new TeamWorkFileImportHandler.3(this, paramJSONObject, paramTeamWorkFileImportInfo, paramInt));
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.iu.get(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo != null)
      {
        paramTeamWorkFileImportInfo.cKZ = paramBoolean;
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramString == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (aoag.d(paramTeamWorkFileImportInfo))
    {
      paramString = aodb.nZ(paramString);
      this.ix.put(str, aodb.bF(paramString, paramTeamWorkFileImportInfo.traceId));
      return;
    }
    this.iv.put(str, aodb.bF(paramString, paramTeamWorkFileImportInfo.traceId));
  }
  
  public void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.5(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    am(new TeamWorkFileImportHandler.11(this, paramTeamWorkFileImportInfo, paramJSONObject, paramInt));
  }
  
  public String c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    String str = "";
    if (paramTeamWorkFileImportInfo.peerType == 1) {
      str = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;
    }
    while (aoag.d(paramTeamWorkFileImportInfo))
    {
      return (String)this.ix.get(str);
      if ((paramTeamWorkFileImportInfo.peerType == 3000) || (paramTeamWorkFileImportInfo.peerType == 0)) {
        str = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq + "_" + paramTeamWorkFileImportInfo.nSessionId;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) {
        str = paramTeamWorkFileImportInfo.filePath;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.srcUrl)) {
        str = paramTeamWorkFileImportInfo.srcUrl;
      }
    }
    return (String)this.iv.get(str);
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool;
    do
    {
      return;
      QLog.d("TeamWorkFileImportHandler", 1, " --- createGrayTips ");
      bool = aetq.a().ahV();
    } while (((!paramTeamWorkFileImportInfo.isFromAIO) && (!paramTeamWorkFileImportInfo.azu())) || (!bool));
    if (paramTeamWorkFileImportInfo.azu()) {}
    for (String str = String.format(this.app.getApp().getString(2131720935), new Object[] { "\"" + ahbj.getFileNameNoEx(paramTeamWorkFileImportInfo.fileName) + "\"" });; str = String.format(this.app.getApp().getString(2131720934), new Object[] { "\"" + ahbj.getFileNameNoEx(paramTeamWorkFileImportInfo.fileName) + "\"" }))
    {
      MessageRecord localMessageRecord = anbi.d(-2063);
      long l = anaz.gQ();
      localMessageRecord.init(this.app.getCurrentAccountUin(), paramTeamWorkFileImportInfo.peerUin, paramTeamWorkFileImportInfo.peerUin, str, l, -2063, paramTeamWorkFileImportInfo.peerType, l);
      localMessageRecord.isread = true;
      localMessageRecord.saveExtInfoToExtStr("key_team_work_ext_info_new_url", paramString);
      localMessageRecord.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(paramTeamWorkFileImportInfo.cLa));
      this.app.b().b(localMessageRecord, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public void c(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.6(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public boolean c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = aodb.aO(paramTeamWorkFileImportInfo.traceId);
    aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    int n;
    String str2;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    int i;
    label938:
    int j;
    label965:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool1 = bool4;
          n = localJSONObject.getInt("ret");
          bool1 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool1 = bool4;
            localJSONObject.getString("msg");
          }
          bool1 = bool4;
          str2 = localJSONObject.getString("error");
          switch (n)
          {
          case 0: 
            bool1 = bool4;
            paramTeamWorkFileImportInfo.retCode = n;
            bool1 = bool4;
            paramTeamWorkFileImportInfo.cjF = str2;
            bool1 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
            bool2 = bool3;
            if (n != 0) {
              break label1843;
            }
            bool1 = bool2;
            aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR, "");
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResultForH5 JSONException: " + paramString.toString());
          aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=" + paramString.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
          return bool1;
        }
        bool1 = bool4;
        paramString = localJSONObject.getString("url");
        bool2 = bool3;
        bool1 = bool4;
        if (this.mUIHandler != null)
        {
          bool2 = bool3;
          bool1 = bool4;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool3;
            bool1 = bool4;
            if (this.app != null)
            {
              bool3 = true;
              bool2 = true;
              bool1 = bool3;
              localObject1 = new Bundle();
              bool1 = bool3;
              ((Bundle)localObject1).putString("url", paramString);
              bool1 = bool3;
              ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              bool1 = bool3;
              localObject2 = this.mUIHandler.obtainMessage(8001);
              bool1 = bool3;
              ((Message)localObject2).setData((Bundle)localObject1);
              bool1 = bool3;
              this.mUIHandler.sendMessage((Message)localObject2);
              bool1 = bool3;
              b(paramTeamWorkFileImportInfo, paramString);
              continue;
              localObject1 = "";
              localObject2 = "";
              String str1 = "";
              bool1 = bool4;
              paramString = (String)localObject1;
              if (localJSONObject.has("filePath"))
              {
                bool1 = bool4;
                paramString = (String)localObject1;
                if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
                {
                  bool1 = bool4;
                  paramString = localJSONObject.getString("filePath");
                }
              }
              bool1 = bool4;
              localObject1 = localObject2;
              if (localJSONObject.has("md5"))
              {
                bool1 = bool4;
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
                {
                  bool1 = bool4;
                  localObject1 = localJSONObject.getString("md5");
                }
              }
              bool1 = bool4;
              localObject2 = str1;
              if (localJSONObject.has("fileName"))
              {
                bool1 = bool4;
                localObject2 = str1;
                if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
                {
                  bool1 = bool4;
                  localObject2 = localJSONObject.getString("fileName");
                }
              }
              bool1 = bool4;
              str1 = paramTeamWorkFileImportInfo.folderId;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.redirectUrl = String.format(aoaf.cjC, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject1, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), URLEncoder.encode(paramString, "UTF-8"), "import" });
              bool1 = bool4;
              paramTeamWorkFileImportInfo.retCode = n;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.cjF = str2;
              bool1 = bool4;
              QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
              bool2 = bool3;
              continue;
              bool1 = bool4;
              paramString = new JSONObject(str2);
              bool1 = bool4;
              if (!paramString.has("startRow")) {
                break label1989;
              }
              bool1 = bool4;
              i = paramString.getInt("startRow");
              bool1 = bool4;
              if (!paramString.has("endRow")) {
                break label1994;
              }
              bool1 = bool4;
              j = paramString.getInt("endRow");
              bool1 = bool4;
              if (!paramString.has("startCol")) {
                break label2000;
              }
              bool1 = bool4;
              k = paramString.getInt("startCol");
              label992:
              bool1 = bool4;
              if (!paramString.has("endCol")) {
                break label2006;
              }
              bool1 = bool4;
            }
          }
        }
      }
    }
    label1173:
    label1432:
    label1843:
    label1986:
    label1989:
    label1994:
    label2000:
    label2006:
    for (int m = paramString.getInt("endCol");; m = 0)
    {
      bool1 = bool4;
      paramString = aobw.ft(k);
      bool1 = bool4;
      localObject1 = aobw.ft(m);
      bool1 = bool4;
      localObject2 = new StringBuilder();
      bool1 = bool4;
      ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720912));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("1");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { Integer.valueOf(i) }));
          if (k != m) {
            break label1432;
          }
          bool1 = bool4;
          ((StringBuilder)localObject2).append("\n");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("2");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { paramString }));
        }
      }
      for (;;)
      {
        bool1 = bool4;
        paramTeamWorkFileImportInfo.retCode = n;
        bool1 = bool4;
        paramTeamWorkFileImportInfo.cjF = ((StringBuilder)localObject2).toString();
        bool1 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
        bool2 = bool3;
        break;
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("1");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1173;
        bool1 = bool4;
        ((StringBuilder)localObject2).append("\n");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("2");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { paramString, localObject1 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { paramString }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { paramString, localObject1 }));
          }
        }
      }
      bool1 = bool2;
      aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
      break label1986;
      aodb.b(this.app, paramTeamWorkFileImportInfo.traceId, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.peerType + paramTeamWorkFileImportInfo.dNQ + paramTeamWorkFileImportInfo.dNR);
      return false;
      break;
      return bool2;
      i = 0;
      break label938;
      j = 0;
      break label965;
      k = 0;
      break label992;
    }
  }
  
  public boolean e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool2 = true;
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    boolean bool1;
    if (aoag.d(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iw.containsKey(paramTeamWorkFileImportInfo.filePath))) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      bool1 = bool2;
      if (!this.iw.containsKey(paramTeamWorkFileImportInfo))
      {
        do
        {
          bool1 = false;
          break;
          if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath))
          {
            bool1 = bool2;
            if (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath)) {
              break;
            }
          }
          paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
        } while (!this.iu.containsKey(paramTeamWorkFileImportInfo));
        bool1 = bool2;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        paramMessage = paramMessage.getData();
        TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)paramMessage.getParcelable("fileInfo");
        String str = paramMessage.getString("url");
        l(localTeamWorkFileImportInfo);
        if (QLog.isDevelopLevel()) {
          QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_SUCCESS:" + str);
        }
        paramMessage = str;
        if (localTeamWorkFileImportInfo != null)
        {
          str = aodb.bF(str, localTeamWorkFileImportInfo.traceId);
          paramMessage = str;
          if (aoag.d(localTeamWorkFileImportInfo)) {
            paramMessage = aodb.nZ(str);
          }
        }
        notifyUI(1, true, new Object[] { paramMessage, localTeamWorkFileImportInfo });
        anot.a(this.app, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("teamConvert", 2, "convert finish time [" + System.currentTimeMillis() / 1000L + "]");
        }
      } while (!this.cKW);
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131720919), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      return true;
      paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
      l(paramMessage);
      notifyUI(2, true, paramMessage);
    } while (!QLog.isDevelopLevel());
    QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_ERROR:" + paramMessage.fileName);
    return true;
  }
  
  public void j(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.K != null) && (paramTeamWorkFileImportInfo != null))
    {
      aodb.t(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo.dNQ != 10) {
        break label94;
      }
      this.K.add(new aoap(paramTeamWorkFileImportInfo, this.app));
    }
    for (;;)
    {
      dUf();
      aodb.fy(paramTeamWorkFileImportInfo.traceId);
      aodb.Q("TeamWorkFileImportHandler", "addFileImportJob start:" + paramTeamWorkFileImportInfo.fileName, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.traceId);
      return;
      label94:
      if (paramTeamWorkFileImportInfo.dNQ == 6) {
        this.K.add(new aoax(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.dNQ == 13) {
        this.K.add(new aoba(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.peerType == 1) {
        this.K.add(new aobb(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.peerType == 3000) {
        this.K.add(new aoay(paramTeamWorkFileImportInfo, this.app));
      } else if ((paramTeamWorkFileImportInfo.peerType == 6000) || (paramTeamWorkFileImportInfo.peerType == 6003)) {
        this.K.add(new aoax(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.dNQ == 12) {
        this.K.add(new aobd(paramTeamWorkFileImportInfo, this.app));
      } else {
        this.K.add(new aoav(paramTeamWorkFileImportInfo, this.app));
      }
    }
  }
  
  public void k(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.cKX) {
        break label48;
      }
      if (!aoag.d(paramTeamWorkFileImportInfo)) {
        break label33;
      }
      this.iw.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
    }
    label33:
    label48:
    while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath))
    {
      return;
      this.iu.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
      return;
    }
    if (aoag.d(paramTeamWorkFileImportInfo))
    {
      this.iw.put(paramTeamWorkFileImportInfo.filePath, paramTeamWorkFileImportInfo);
      return;
    }
    this.iu.put(paramTeamWorkFileImportInfo.filePath, paramTeamWorkFileImportInfo);
  }
  
  public void l(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str;
    if (aoag.d(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iw.containsKey(paramTeamWorkFileImportInfo.filePath)))
      {
        str = paramTeamWorkFileImportInfo.filePath;
        if (!TextUtils.isEmpty(str)) {
          this.iw.remove(str);
        }
      }
    }
    label127:
    for (;;)
    {
      paramTeamWorkFileImportInfo.dNT = 0;
      return;
      str = b(paramTeamWorkFileImportInfo);
      break;
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath))) {}
      for (str = paramTeamWorkFileImportInfo.filePath;; str = b(paramTeamWorkFileImportInfo))
      {
        if (TextUtils.isEmpty(str)) {
          break label127;
        }
        this.iu.remove(str);
        break;
      }
    }
  }
  
  public void m(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage(8002);
      localMessage.obj = paramTeamWorkFileImportInfo;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void n(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (aoag.d(paramTeamWorkFileImportInfo))
    {
      this.ix.remove(str);
      return;
    }
    this.iv.remove(str);
  }
  
  public void o(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.1(this, paramTeamWorkFileImportInfo));
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aobe.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void p(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.2(this, paramTeamWorkFileImportInfo));
  }
  
  public void q(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.7(this, paramTeamWorkFileImportInfo));
  }
  
  public void r(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    am(new TeamWorkFileImportHandler.10(this, paramTeamWorkFileImportInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoar
 * JD-Core Version:    0.7.0.1
 */