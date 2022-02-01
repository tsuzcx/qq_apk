import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterRspItem;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import dov.com.qq.im.ae.config.CameraPeakServiceHandler.2;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class axbm
  extends axbi
{
  private static final String TAG = axbm.class.getSimpleName();
  
  public axbm(PeakAppInterface paramPeakAppInterface)
  {
    super(paramPeakAppInterface);
  }
  
  private void A(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    paramObject = (GetTextValidStatusRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      if (paramObject.ValidStatus == 0) {
        bool1 = true;
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      axim localaxim;
      int i;
      long l2;
      if ((paramFromServiceMsg != null) && (paramObject != null))
      {
        localaxim = axim.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (!this.mB.containsKey("CameraModuleSvc.GetTextValidStatus")) {
          break label121;
        }
      }
      label121:
      for (long l1 = ((Long)this.mB.get("CameraModuleSvc.GetTextValidStatus")).longValue();; l1 = 0L)
      {
        localaxim.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetTextValidStatus", paramObject.Code);
        notifyUI(2, bool2, Boolean.valueOf(bool1));
        return;
      }
      bool1 = false;
    }
  }
  
  /* Error */
  public static String b(android.content.Context paramContext, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 111	java/io/File
    //   3: dup
    //   4: getstatic 116	awtn$b$a:cSO	Ljava/lang/String;
    //   7: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 122	java/io/File:exists	()Z
    //   17: ifne +9 -> 26
    //   20: aload 6
    //   22: invokevirtual 125	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 127	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   33: aload 6
    //   35: invokevirtual 132	java/io/File:getPath	()Ljava/lang/String;
    //   38: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: getstatic 139	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   50: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc 144
    //   55: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 9
    //   63: new 127	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   70: aload 6
    //   72: invokevirtual 132	java/io/File:getPath	()Ljava/lang/String;
    //   75: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 139	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   87: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: ldc 144
    //   92: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 10
    //   100: aload_1
    //   101: ifnonnull +6 -> 107
    //   104: ldc 149
    //   106: areturn
    //   107: aload_1
    //   108: invokevirtual 154	android/graphics/Bitmap:getWidth	()I
    //   111: istore 4
    //   113: aload_1
    //   114: invokevirtual 157	android/graphics/Bitmap:getHeight	()I
    //   117: istore_3
    //   118: iload_3
    //   119: istore_2
    //   120: iload_3
    //   121: sipush 250
    //   124: if_icmple +7 -> 131
    //   127: sipush 250
    //   130: istore_2
    //   131: iload 4
    //   133: istore_3
    //   134: iload 4
    //   136: sipush 250
    //   139: if_icmple +7 -> 146
    //   142: sipush 250
    //   145: istore_3
    //   146: aconst_null
    //   147: astore 7
    //   149: aconst_null
    //   150: astore 8
    //   152: new 159	java/io/BufferedOutputStream
    //   155: dup
    //   156: new 161	java/io/FileOutputStream
    //   159: dup
    //   160: aload 9
    //   162: invokestatic 167	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   165: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   168: invokespecial 173	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore 6
    //   173: aload 6
    //   175: astore 7
    //   177: aload_1
    //   178: getstatic 179	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   181: bipush 100
    //   183: aload 6
    //   185: invokevirtual 183	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   188: pop
    //   189: aload 6
    //   191: ifnull +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   199: aload_1
    //   200: invokevirtual 189	android/graphics/Bitmap:isRecycled	()Z
    //   203: ifne +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 192	android/graphics/Bitmap:recycle	()V
    //   210: aload_0
    //   211: aload 9
    //   213: aload 10
    //   215: iload_3
    //   216: iload_2
    //   217: invokestatic 197	aqhu:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   220: iconst_0
    //   221: istore 5
    //   223: iload_3
    //   224: istore 4
    //   226: iload_2
    //   227: istore_3
    //   228: iload 5
    //   230: istore_2
    //   231: new 111	java/io/File
    //   234: dup
    //   235: aload 10
    //   237: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 200	java/io/File:length	()J
    //   245: ldc2_w 201
    //   248: lcmp
    //   249: ifle +344 -> 593
    //   252: iload_2
    //   253: bipush 10
    //   255: if_icmpge +338 -> 593
    //   258: iload 4
    //   260: i2d
    //   261: ldc2_w 203
    //   264: dmul
    //   265: d2i
    //   266: istore 4
    //   268: iload_3
    //   269: i2d
    //   270: ldc2_w 203
    //   273: dmul
    //   274: d2i
    //   275: istore_3
    //   276: aload_0
    //   277: aload 9
    //   279: aload 10
    //   281: bipush 100
    //   283: iload 4
    //   285: invokestatic 210	java/lang/Math:max	(II)I
    //   288: bipush 100
    //   290: iload_3
    //   291: invokestatic 210	java/lang/Math:max	(II)I
    //   294: invokestatic 197	aqhu:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore_2
    //   301: goto -70 -> 231
    //   304: astore 6
    //   306: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   309: new 127	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   316: ldc 212
    //   318: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 6
    //   323: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -136 -> 199
    //   338: astore 8
    //   340: aconst_null
    //   341: astore 6
    //   343: aload 6
    //   345: astore 7
    //   347: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   350: new 127	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   357: ldc 212
    //   359: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 8
    //   364: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   367: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   386: aload_1
    //   387: invokevirtual 189	android/graphics/Bitmap:isRecycled	()Z
    //   390: ifne -180 -> 210
    //   393: aload_1
    //   394: invokevirtual 192	android/graphics/Bitmap:recycle	()V
    //   397: goto -187 -> 210
    //   400: astore 6
    //   402: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   405: new 127	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   412: ldc 212
    //   414: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 6
    //   419: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   422: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -45 -> 386
    //   434: astore 7
    //   436: aload 8
    //   438: astore 6
    //   440: aload 7
    //   442: astore 8
    //   444: aload 6
    //   446: astore 7
    //   448: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   451: new 127	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   458: ldc 212
    //   460: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 8
    //   465: invokevirtual 220	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   468: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 6
    //   479: ifnull +8 -> 487
    //   482: aload 6
    //   484: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   487: aload_1
    //   488: invokevirtual 189	android/graphics/Bitmap:isRecycled	()Z
    //   491: ifne -281 -> 210
    //   494: aload_1
    //   495: invokevirtual 192	android/graphics/Bitmap:recycle	()V
    //   498: goto -288 -> 210
    //   501: astore 6
    //   503: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   506: new 127	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   513: ldc 212
    //   515: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 6
    //   520: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   523: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: goto -45 -> 487
    //   535: astore_0
    //   536: aload 7
    //   538: ifnull +8 -> 546
    //   541: aload 7
    //   543: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   546: aload_1
    //   547: invokevirtual 189	android/graphics/Bitmap:isRecycled	()Z
    //   550: ifne +7 -> 557
    //   553: aload_1
    //   554: invokevirtual 192	android/graphics/Bitmap:recycle	()V
    //   557: aload_0
    //   558: athrow
    //   559: astore 6
    //   561: getstatic 16	axbm:TAG	Ljava/lang/String;
    //   564: new 127	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   571: ldc 212
    //   573: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 6
    //   578: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   581: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 219	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: goto -44 -> 546
    //   593: aload_1
    //   594: invokevirtual 200	java/io/File:length	()J
    //   597: ldc2_w 201
    //   600: lcmp
    //   601: ifle +6 -> 607
    //   604: ldc 149
    //   606: areturn
    //   607: aload 10
    //   609: areturn
    //   610: astore_0
    //   611: goto -75 -> 536
    //   614: astore 8
    //   616: goto -172 -> 444
    //   619: astore 8
    //   621: goto -278 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	paramContext	android.content.Context
    //   0	624	1	paramBitmap	Bitmap
    //   119	182	2	i	int
    //   117	174	3	j	int
    //   111	173	4	k	int
    //   221	8	5	m	int
    //   10	185	6	localObject1	Object
    //   304	18	6	localException1	java.lang.Exception
    //   341	41	6	localObject2	Object
    //   400	18	6	localException2	java.lang.Exception
    //   438	45	6	localObject3	Object
    //   501	18	6	localException3	java.lang.Exception
    //   559	18	6	localException4	java.lang.Exception
    //   147	199	7	localObject4	Object
    //   434	7	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   446	96	7	localObject5	Object
    //   150	1	8	localObject6	Object
    //   338	99	8	localException5	java.lang.Exception
    //   442	22	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   614	1	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   619	1	8	localException6	java.lang.Exception
    //   61	217	9	str1	String
    //   98	510	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   194	199	304	java/lang/Exception
    //   152	173	338	java/lang/Exception
    //   381	386	400	java/lang/Exception
    //   152	173	434	java/lang/OutOfMemoryError
    //   482	487	501	java/lang/Exception
    //   152	173	535	finally
    //   448	477	535	finally
    //   541	546	559	java/lang/Exception
    //   177	189	610	finally
    //   347	376	610	finally
    //   177	189	614	java/lang/OutOfMemoryError
    //   177	189	619	java/lang/Exception
  }
  
  private void c(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramString = SafeBitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramToServiceMsg.extraData;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localBundle.putByteArray("Rawdata", localByteArrayOutputStream.toByteArray());
    }
    send(paramToServiceMsg);
  }
  
  private void v(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    notifyUI(4, paramFromServiceMsg.isSuccess(), paramObject);
    if (!paramFromServiceMsg.isSuccess())
    {
      QLog.e(TAG, 2, "getFont fail: " + paramFromServiceMsg);
      ThreadManager.getUIHandler().post(new CameraPeakServiceHandler.2(this));
    }
    paramObject = (GetFontDataRsp)paramObject;
    axim localaxim = axim.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    if (this.mB.containsKey("CameraModuleSvc.GetFontData")) {}
    for (long l1 = ((Long)this.mB.get("CameraModuleSvc.GetFontData")).longValue();; l1 = 0L)
    {
      localaxim.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetFontData", paramObject.Code);
      return;
    }
  }
  
  private void w(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetImgValidStatusRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = paramObject.ValidStatus;; i = -2)
    {
      long l1;
      if ((paramFromServiceMsg != null) && (paramObject != null))
      {
        axim localaxim = axim.a();
        int j = paramFromServiceMsg.getResultCode();
        long l2 = System.currentTimeMillis();
        if (this.mB.containsKey("CameraModuleSvc.GetImgValidStatus"))
        {
          l1 = ((Long)this.mB.get("CameraModuleSvc.GetImgValidStatus")).longValue();
          localaxim.l(j, String.valueOf(l2 - l1), "CameraModuleSvc.GetImgValidStatus", paramObject.Code);
        }
      }
      else
      {
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
          break label138;
        }
      }
      label138:
      for (boolean bool = true;; bool = false)
      {
        notifyUI(5, bool, Integer.valueOf(i));
        return;
        l1 = 0L;
        break;
      }
    }
  }
  
  private void x(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetOnlineUserNumRsp)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      notifyUI(3, true, Integer.valueOf(paramObject.OnlineUserNum));
    }
    axim localaxim = axim.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    if (this.mB.containsKey("CameraModuleSvc.GetOnlineUserNum")) {}
    for (long l1 = ((Long)this.mB.get("CameraModuleSvc.GetOnlineUserNum")).longValue();; l1 = 0L)
    {
      localaxim.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetOnlineUserNum", paramObject.Code);
      return;
    }
  }
  
  private void y(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (GetBulkImageClassifyRsp)paramObject;
    int i;
    long l2;
    if (paramFromServiceMsg.isSuccess())
    {
      if ((localObject != null) && (((GetBulkImageClassifyRsp)localObject).MiltiRsps != null))
      {
        paramObject = new ArrayList();
        localObject = ((GetBulkImageClassifyRsp)localObject).MiltiRsps.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SmartFilterRspItem localSmartFilterRspItem = (SmartFilterRspItem)((Iterator)localObject).next();
          paramObject.add(new axkm(localSmartFilterRspItem.PituLabel, localSmartFilterRspItem.DisplayLabels));
        }
        axjp.a().oG(paramObject);
      }
      paramObject = axim.a();
      i = paramFromServiceMsg.getResultCode();
      l2 = System.currentTimeMillis();
      if (!this.mB.containsKey("CameraModuleSvc.GetBulkImageClassify")) {
        break label198;
      }
    }
    label198:
    for (long l1 = ((Long)this.mB.get("CameraModuleSvc.GetBulkImageClassify")).longValue();; l1 = 0L)
    {
      paramObject.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetBulkImageClassify", 0);
      return;
      if (1002 == paramFromServiceMsg.getResultCode())
      {
        axjp.a().aed(-6);
        break;
      }
      axjp.a().aed(-1);
      break;
    }
  }
  
  private void z(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!(paramObject instanceof GetRecommandTextByEmotionRsp)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    GetRecommandTextByEmotionRsp localGetRecommandTextByEmotionRsp = (GetRecommandTextByEmotionRsp)paramObject;
    String str;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      localArrayList = localGetRecommandTextByEmotionRsp.RecTexts;
      str = localGetRecommandTextByEmotionRsp.Emo;
      paramObject = localGetRecommandTextByEmotionRsp.UiNumConfig;
    }
    for (;;)
    {
      try
      {
        paramObject = new JSONObject(paramObject);
        bool = true;
        if ((paramFromServiceMsg != null) && (localGetRecommandTextByEmotionRsp != null))
        {
          axim localaxim = axim.a();
          int i = paramFromServiceMsg.getResultCode();
          long l2 = System.currentTimeMillis();
          if (this.mB.containsKey("CameraModuleSvc.GetRecommandTextByEmotion"))
          {
            l1 = ((Long)this.mB.get("CameraModuleSvc.GetRecommandTextByEmotion")).longValue();
            localaxim.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionRsp.Code);
          }
        }
        else
        {
          notifyUI(1, bool, new axdd(localArrayList, str, paramObject));
          return;
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        paramObject = null;
        continue;
        long l1 = 0L;
        continue;
      }
      paramObject = null;
      str = null;
      boolean bool = false;
    }
  }
  
  public void acm(String paramString)
  {
    this.mB.put("CameraModuleSvc", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetImgValidStatus");
    paramString = SafeBitmapFactory.decodeFile(paramString);
    String str = AETakeFacePhotoPreviewFragment.HM();
    if ((str != null) && (str.length() > 0))
    {
      c(localToServiceMsg, str);
      return;
    }
    axic.a(paramString, new axbn(this, localToServiceMsg));
  }
  
  public void acn(String paramString)
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqTextValidStatus] no network....");
      A(null, null);
      return;
    }
    this.mB.put("CameraModuleSvc.GetTextValidStatus", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetTextValidStatus");
    localToServiceMsg.extraData.putString("EmoText", paramString);
    send(localToServiceMsg);
  }
  
  public void ap(Bitmap paramBitmap)
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
      z(null, new ArrayList());
      return;
    }
    this.mB.put("CameraModuleSvc.GetRecommandTextByEmotion", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetRecommandTextByEmotion");
    if (paramBitmap != null)
    {
      Bundle localBundle = localToServiceMsg.extraData;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localBundle.putByteArray("Rawdata", localByteArrayOutputStream.toByteArray());
    }
    send(localToServiceMsg);
  }
  
  public void eIB()
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqOnlineUserNum] no network....");
      return;
    }
    this.mB.put("CameraModuleSvc.GetOnlineUserNum", Long.valueOf(System.currentTimeMillis()));
    send(new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetOnlineUserNum"));
  }
  
  public void fA(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
      return;
    }
    this.mB.put("CameraModuleSvc.GetBulkImageClassify", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetBulkImageClassify");
    localToServiceMsg.extraData.putSerializable("AI_FILTER_REQ_PICS", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void jK(String paramString1, String paramString2)
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqFontData] no network....");
      return;
    }
    this.mB.put("CameraModuleSvc.GetFontData", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetFontData");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("FontName", paramString1);
    localBundle.putString("Content", paramString2);
    send(localToServiceMsg);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return axbo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetRecommandTextByEmotion")) {
      z(paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      super.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetTextValidStatus"))
      {
        A(paramFromServiceMsg, paramObject);
      }
      else
      {
        if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
        {
          r(paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetOnlineUserNum")) {
          x(paramFromServiceMsg, paramObject);
        } else if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetFontData")) {
          v(paramFromServiceMsg, paramObject);
        } else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
          w(paramFromServiceMsg, paramObject);
        } else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) {
          y(paramFromServiceMsg, paramObject);
        }
      }
    }
  }
  
  protected void r(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    super.r(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbm
 * JD-Core Version:    0.7.0.1
 */