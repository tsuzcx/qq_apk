import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class adpa
{
  private static adpa a = new adpa();
  private static List<String> yn = new ArrayList();
  acnd b = new adpc(this);
  String buS = null;
  
  public static adpa a()
  {
    return a;
  }
  
  private void a(String paramString, TroopInfoData paramTroopInfoData)
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("forward_location", paramTroopInfoData.troopLocation);
    localIntent.putExtra("forward_latitude", paramTroopInfoData.troopLat);
    localIntent.putExtra("forward_longitude", paramTroopInfoData.troopLon);
    localIntent.putExtra("forward_cityid", paramTroopInfoData.cityId);
    localIntent.putExtra("key_qidian_private_troop", paramTroopInfoData.isQidianPrivateTroop);
    paramString = TroopBaseProxyActivity.a(BaseActivity.sTopActivity);
    paramTroopInfoData = new awjk(localQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramTroopInfoData);
    }
    TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, BaseActivity.sTopActivity, localIntent, paramString, "com.tencent.mobileqq.activity.TroopManageActivity", localQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public void GI(String paramString)
  {
    try
    {
      this.buS = new JSONObject(paramString).optString("gc");
      if (TextUtils.isEmpty(this.buS))
      {
        QLog.e("ark.Troop", 1, "troopUin empty!");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ark.Troop", 1, "json error!", paramString);
      paramString = getAppInterface();
      TroopPluginManager localTroopPluginManager = (TroopPluginManager)paramString.getManager(119);
      TroopInfo localTroopInfo = ((TroopManager)paramString.getManager(52)).b(this.buS);
      if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
      {
        localTroopPluginManager.a("troop_manage_plugin.apk", new adpb(this, paramString));
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131715553), 0).show();
    }
  }
  
  /* Error */
  protected void a(KQQ.BatchResponse paramBatchResponse, TroopInfoData paramTroopInfoData, TroopInfo paramTroopInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 227	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 229	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 230	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: aload_1
    //   24: getfield 234	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 235	[B
    //   30: invokevirtual 239	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 242	KQQ/BatchResponse:seq	I
    //   38: ifne -27 -> 11
    //   41: aload 7
    //   43: ifnull -32 -> 11
    //   46: aload 7
    //   48: getfield 246	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq -43 -> 11
    //   57: aload 7
    //   59: getfield 246	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 255	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore_1
    //   69: new 263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   72: dup
    //   73: invokespecial 264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   76: astore 7
    //   78: aload 7
    //   80: aload_1
    //   81: invokevirtual 265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   84: pop
    //   85: aload 7
    //   87: getfield 269	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   90: invokevirtual 274	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnonnull +54 -> 151
    //   100: iconst_0
    //   101: istore 4
    //   103: goto +338 -> 441
    //   106: aload_1
    //   107: ifnonnull -96 -> 11
    //   110: iload 5
    //   112: iload 4
    //   114: if_icmpge -103 -> 11
    //   117: aload 8
    //   119: iload 5
    //   121: invokeinterface 279 2 0
    //   126: checkcast 281	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   129: astore 7
    //   131: aload 7
    //   133: ifnonnull +30 -> 163
    //   136: iload 5
    //   138: iconst_1
    //   139: iadd
    //   140: istore 5
    //   142: goto -36 -> 106
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 284	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   150: return
    //   151: aload 8
    //   153: invokeinterface 288 1 0
    //   158: istore 4
    //   160: goto +281 -> 441
    //   163: aload 7
    //   165: getfield 292	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: istore 6
    //   173: iload 6
    //   175: bipush 72
    //   177: if_icmpne +31 -> 208
    //   180: iload 5
    //   182: ifne +26 -> 208
    //   185: getstatic 103	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   188: ldc_w 297
    //   191: iconst_1
    //   192: invokestatic 300	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   195: getstatic 103	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   198: invokevirtual 303	com/tencent/mobileqq/app/BaseActivity:getTitleBarHeight	()I
    //   201: invokevirtual 306	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   204: pop
    //   205: goto -69 -> 136
    //   208: iload 6
    //   210: ifne +228 -> 438
    //   213: aload 7
    //   215: getfield 310	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   218: invokevirtual 313	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   221: ifeq +217 -> 438
    //   224: aload 7
    //   226: getfield 310	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   229: invokevirtual 316	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   232: checkcast 312	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   235: astore 7
    //   237: aload 7
    //   239: astore_1
    //   240: aload 7
    //   242: ifnull -106 -> 136
    //   245: aload 7
    //   247: astore_1
    //   248: aload_2
    //   249: ifnull -113 -> 136
    //   252: aload_2
    //   253: aload 7
    //   255: invokevirtual 320	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   258: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +78 -> 339
    //   264: aload 7
    //   266: getfield 326	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   269: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   272: istore 6
    //   274: new 328	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 331
    //   284: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: astore 9
    //   289: aload_2
    //   290: ifnonnull +140 -> 430
    //   293: ldc_w 337
    //   296: astore_1
    //   297: ldc_w 339
    //   300: iconst_2
    //   301: aload 9
    //   303: aload_1
    //   304: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 341
    //   310: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 6
    //   315: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 346
    //   321: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 6
    //   326: i2l
    //   327: invokestatic 349	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   330: invokevirtual 352	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   333: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_3
    //   340: ifnull +17 -> 357
    //   343: aload_3
    //   344: aload 7
    //   346: invokevirtual 359	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   349: aload_2
    //   350: aload_3
    //   351: invokevirtual 362	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   354: putfield 365	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   357: aload_2
    //   358: aload 7
    //   360: getfield 326	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   363: invokevirtual 296	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   366: i2l
    //   367: invokestatic 349	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   370: putfield 94	com/tencent/mobileqq/troopinfo/TroopInfoData:isQidianPrivateTroop	Z
    //   373: aload 7
    //   375: astore_1
    //   376: aload_3
    //   377: ifnull -241 -> 136
    //   380: aload 7
    //   382: astore_1
    //   383: aload_2
    //   384: getfield 368	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   387: ifeq -251 -> 136
    //   390: new 370	com/tencent/mobileqq/ark/API/TroopArkHelper$3
    //   393: dup
    //   394: aload_0
    //   395: aload_3
    //   396: invokespecial 373	com/tencent/mobileqq/ark/API/TroopArkHelper$3:<init>	(Ladpa;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   399: iconst_5
    //   400: aconst_null
    //   401: iconst_0
    //   402: invokestatic 379	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   405: aload 7
    //   407: astore_1
    //   408: goto -272 -> 136
    //   411: astore_1
    //   412: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq -404 -> 11
    //   418: ldc_w 381
    //   421: iconst_2
    //   422: aload_1
    //   423: invokevirtual 382	java/lang/Exception:toString	()Ljava/lang/String;
    //   426: invokestatic 385	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: return
    //   430: aload_2
    //   431: getfield 388	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   434: astore_1
    //   435: goto -138 -> 297
    //   438: goto -302 -> 136
    //   441: aconst_null
    //   442: astore_1
    //   443: iconst_0
    //   444: istore 5
    //   446: goto -340 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	adpa
    //   0	449	1	paramBatchResponse	KQQ.BatchResponse
    //   0	449	2	paramTroopInfoData	TroopInfoData
    //   0	449	3	paramTroopInfo	TroopInfo
    //   101	58	4	i	int
    //   110	335	5	j	int
    //   171	154	6	k	int
    //   19	387	7	localObject	Object
    //   93	59	8	localList	List
    //   287	15	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	34	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   69	95	411	java/lang/Exception
    //   117	131	411	java/lang/Exception
    //   151	160	411	java/lang/Exception
    //   163	173	411	java/lang/Exception
    //   185	205	411	java/lang/Exception
    //   213	237	411	java/lang/Exception
    //   252	289	411	java/lang/Exception
    //   297	339	411	java/lang/Exception
    //   343	357	411	java/lang/Exception
    //   357	373	411	java/lang/Exception
    //   383	405	411	java/lang/Exception
    //   430	435	411	java/lang/Exception
  }
  
  public QQAppInterface getAppInterface()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpa
 * JD-Core Version:    0.7.0.1
 */