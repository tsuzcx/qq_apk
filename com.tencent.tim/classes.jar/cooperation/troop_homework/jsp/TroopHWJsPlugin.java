package cooperation.troop_homework.jsp;

import acbn;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import apqz;
import aqfy;
import aqgo;
import aqhu;
import aqul;
import arwv;
import ausj;
import awjs;
import awjs.b;
import awjs.c;
import awjt;
import awjt.a;
import awjv;
import awjw;
import awjx;
import awjy;
import awjz;
import awka;
import awkc;
import awkc.a;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ilp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import skj;
import skj.a;

public class TroopHWJsPlugin
  extends WebViewPlugin
  implements awjt.a, awkc.a, skj.a
{
  public static final String cQU = acbn.bmm + "homeworkTmp/";
  private awjt jdField_a_of_type_Awjt;
  awkc jdField_a_of_type_Awkc = null;
  String aEt;
  public String aFT;
  String cQV;
  String cQW = null;
  String cQX = null;
  private String cQY;
  boolean dqC = false;
  boolean dqD = false;
  private boolean dqE;
  int eBs = 540;
  int eBt = 540;
  int eBu = 1;
  int eBv = -1;
  ausj mActionSheet = null;
  skj mClient = null;
  int mMaxWidth = 0;
  String mPackageName = null;
  String mTroopUin;
  private Handler mUiHandler = new awjy(this);
  HashMap<Integer, String> qR = new HashMap();
  HashMap<Integer, b> qS = new HashMap();
  
  public TroopHWJsPlugin()
  {
    this.mPluginNameSpace = "homework";
  }
  
  @NonNull
  public static Intent a(int paramInt, Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 47);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", true);
    return localIntent;
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2, TroopHWJsPlugin paramTroopHWJsPlugin)
    throws IOException, JSONException
  {
    // Byte code:
    //   0: new 201	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 208	java/io/File:length	()J
    //   11: ldc2_w 209
    //   14: lcmp
    //   15: ifle +290 -> 305
    //   18: aconst_null
    //   19: astore 12
    //   21: new 65	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   28: astore 15
    //   30: new 212	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_1
    //   42: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 17
    //   47: getstatic 222	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   50: putfield 225	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   53: aload 17
    //   55: iconst_1
    //   56: putfield 228	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   59: aload_1
    //   60: aload 17
    //   62: invokestatic 234	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 17
    //   68: getfield 237	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: istore 8
    //   73: aload 17
    //   75: getfield 240	android/graphics/BitmapFactory$Options:outHeight	I
    //   78: istore 10
    //   80: iload 8
    //   82: ifle +1198 -> 1280
    //   85: iload 10
    //   87: ifgt +6 -> 93
    //   90: goto +1190 -> 1280
    //   93: iload 8
    //   95: iload_2
    //   96: if_icmpgt +25 -> 121
    //   99: aload_1
    //   100: astore 11
    //   102: aload_3
    //   103: ifnull +1180 -> 1283
    //   106: aload_3
    //   107: getfield 242	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQV	Ljava/lang/String;
    //   110: iload_0
    //   111: aload_1
    //   112: iload 8
    //   114: iload 10
    //   116: aload_3
    //   117: invokestatic 245	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;ILjava/lang/String;IILcooperation/troop_homework/jsp/TroopHWJsPlugin;)Ljava/lang/String;
    //   120: areturn
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: new 247	android/graphics/Matrix
    //   130: dup
    //   131: invokespecial 248	android/graphics/Matrix:<init>	()V
    //   134: astore 16
    //   136: fconst_1
    //   137: fstore 5
    //   139: iconst_0
    //   140: istore 7
    //   142: aload_1
    //   143: invokestatic 254	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   146: istore 9
    //   148: iload 9
    //   150: iconst_5
    //   151: if_icmpeq +1135 -> 1286
    //   154: iload 9
    //   156: bipush 6
    //   158: if_icmpeq +1128 -> 1286
    //   161: iload 9
    //   163: bipush 7
    //   165: if_icmpeq +1121 -> 1286
    //   168: iload 9
    //   170: bipush 8
    //   172: if_icmpne +6 -> 178
    //   175: goto +1111 -> 1286
    //   178: iload 7
    //   180: ifeq +127 -> 307
    //   183: iload 10
    //   185: iload_2
    //   186: idiv
    //   187: istore 8
    //   189: aload 17
    //   191: iconst_0
    //   192: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   195: iload 8
    //   197: iload 8
    //   199: iconst_1
    //   200: iushr
    //   201: ior
    //   202: istore 8
    //   204: iload 8
    //   206: iload 8
    //   208: iconst_2
    //   209: iushr
    //   210: ior
    //   211: istore 8
    //   213: iload 8
    //   215: iload 8
    //   217: iconst_4
    //   218: iushr
    //   219: ior
    //   220: istore 8
    //   222: iload 8
    //   224: iload 8
    //   226: bipush 8
    //   228: iushr
    //   229: ior
    //   230: istore 8
    //   232: aload 17
    //   234: iload 8
    //   236: iload 8
    //   238: bipush 16
    //   240: iushr
    //   241: ior
    //   242: iconst_1
    //   243: iadd
    //   244: iconst_1
    //   245: iushr
    //   246: putfield 257	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   249: new 259	java/io/FileInputStream
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore 13
    //   259: fload 5
    //   261: fstore 4
    //   263: aload 14
    //   265: astore 12
    //   267: aload 13
    //   269: aconst_null
    //   270: aload 17
    //   272: invokestatic 264	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   275: astore 11
    //   277: aload 11
    //   279: ifnonnull +37 -> 316
    //   282: aconst_null
    //   283: astore 11
    //   285: aload 13
    //   287: ifnull +996 -> 1283
    //   290: aload 13
    //   292: invokevirtual 267	java/io/FileInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 270	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: invokestatic 275	java/lang/System:gc	()V
    //   305: aconst_null
    //   306: areturn
    //   307: iload 8
    //   309: iload_2
    //   310: idiv
    //   311: istore 8
    //   313: goto -124 -> 189
    //   316: iload 7
    //   318: ifeq +425 -> 743
    //   321: iload_2
    //   322: i2f
    //   323: fstore 6
    //   325: fload 5
    //   327: fstore 4
    //   329: aload 11
    //   331: astore 12
    //   333: aload 11
    //   335: invokevirtual 281	android/graphics/Bitmap:getHeight	()I
    //   338: i2f
    //   339: fstore 5
    //   341: fload 5
    //   343: fstore 4
    //   345: aload 11
    //   347: astore 12
    //   349: fload 6
    //   351: fload 5
    //   353: fdiv
    //   354: fstore 5
    //   356: fload 5
    //   358: fstore 4
    //   360: goto +932 -> 1292
    //   363: fload 5
    //   365: fstore 4
    //   367: aload 11
    //   369: astore 12
    //   371: aload 16
    //   373: fload 5
    //   375: fload 5
    //   377: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   380: aload 11
    //   382: astore 12
    //   384: aload 13
    //   386: ifnull +887 -> 1273
    //   389: aload 13
    //   391: invokevirtual 267	java/io/FileInputStream:close	()V
    //   394: aload 11
    //   396: iconst_0
    //   397: iconst_0
    //   398: aload 11
    //   400: invokevirtual 288	android/graphics/Bitmap:getWidth	()I
    //   403: aload 11
    //   405: invokevirtual 281	android/graphics/Bitmap:getHeight	()I
    //   408: aload 16
    //   410: iconst_1
    //   411: invokestatic 292	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   414: astore 14
    //   416: aload 11
    //   418: aload 14
    //   420: if_acmpeq +8 -> 428
    //   423: aload 11
    //   425: invokevirtual 295	android/graphics/Bitmap:recycle	()V
    //   428: aload 14
    //   430: invokevirtual 288	android/graphics/Bitmap:getWidth	()I
    //   433: istore_2
    //   434: aload 14
    //   436: invokevirtual 281	android/graphics/Bitmap:getHeight	()I
    //   439: istore 7
    //   441: aconst_null
    //   442: astore 13
    //   444: aconst_null
    //   445: astore 12
    //   447: aload 14
    //   449: invokestatic 299	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(Landroid/graphics/Bitmap;)I
    //   452: istore 8
    //   454: iload 8
    //   456: ifle +608 -> 1064
    //   459: new 301	java/io/ByteArrayOutputStream
    //   462: dup
    //   463: sipush 1024
    //   466: invokespecial 304	java/io/ByteArrayOutputStream:<init>	(I)V
    //   469: astore 11
    //   471: aload 14
    //   473: getstatic 310	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   476: iload 8
    //   478: aload 11
    //   480: invokevirtual 314	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   483: pop
    //   484: aload_3
    //   485: ifnull +785 -> 1270
    //   488: aload 15
    //   490: aload 11
    //   492: invokevirtual 318	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   495: iconst_2
    //   496: invokestatic 324	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   499: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +28 -> 534
    //   509: ldc_w 332
    //   512: iconst_2
    //   513: iconst_2
    //   514: anewarray 151	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: ldc_w 334
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload 8
    //   527: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: invokestatic 344	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   534: aload 14
    //   536: ifnull +8 -> 544
    //   539: aload 14
    //   541: invokevirtual 295	android/graphics/Bitmap:recycle	()V
    //   544: aload_3
    //   545: ifnull +83 -> 628
    //   548: aload_3
    //   549: aload_3
    //   550: getfield 242	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQV	Ljava/lang/String;
    //   553: iload_0
    //   554: iconst_1
    //   555: ldc_w 346
    //   558: aconst_null
    //   559: iconst_m1
    //   560: invokevirtual 349	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   563: astore 13
    //   565: aload 15
    //   567: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   573: ifne +14 -> 587
    //   576: aload 13
    //   578: ldc_w 357
    //   581: aload 15
    //   583: invokevirtual 363	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   586: pop
    //   587: aload 13
    //   589: ldc_w 365
    //   592: iload_2
    //   593: invokevirtual 368	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload 13
    //   599: ldc_w 370
    //   602: iload 7
    //   604: invokevirtual 368	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   607: pop
    //   608: aload_3
    //   609: aload_3
    //   610: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   613: iconst_1
    //   614: anewarray 374	java/lang/String
    //   617: dup
    //   618: iconst_0
    //   619: aload 13
    //   621: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   624: aastore
    //   625: invokevirtual 379	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   628: aload 11
    //   630: ifnull +633 -> 1263
    //   633: new 65	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   640: getstatic 85	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQU	Ljava/lang/String;
    //   643: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload_1
    //   647: aload_1
    //   648: ldc_w 381
    //   651: invokevirtual 384	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   654: iconst_1
    //   655: iadd
    //   656: aload_1
    //   657: ldc_w 386
    //   660: invokevirtual 384	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   663: invokevirtual 390	java/lang/String:substring	(II)Ljava/lang/String;
    //   666: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokestatic 393	java/lang/System:currentTimeMillis	()J
    //   672: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: aload_1
    //   676: invokestatic 402	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   679: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: astore_3
    //   686: new 404	com/tencent/mm/vfs/VFSFileOutputStream
    //   689: dup
    //   690: aload_3
    //   691: invokespecial 405	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Ljava/lang/String;)V
    //   694: astore_1
    //   695: aload_1
    //   696: aload 11
    //   698: invokevirtual 318	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   701: invokevirtual 409	com/tencent/mm/vfs/VFSFileOutputStream:write	([B)V
    //   704: aload_3
    //   705: iconst_0
    //   706: invokestatic 415	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   709: astore 12
    //   711: aload_1
    //   712: astore_3
    //   713: aload 12
    //   715: astore_1
    //   716: aload 11
    //   718: ifnull +8 -> 726
    //   721: aload 11
    //   723: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   726: aload_1
    //   727: astore 11
    //   729: aload_3
    //   730: ifnull +10 -> 740
    //   733: aload_3
    //   734: invokevirtual 417	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   737: aload_1
    //   738: astore 11
    //   740: aload 11
    //   742: areturn
    //   743: iload_2
    //   744: i2f
    //   745: fstore 6
    //   747: fload 5
    //   749: fstore 4
    //   751: aload 11
    //   753: astore 12
    //   755: aload 11
    //   757: invokevirtual 288	android/graphics/Bitmap:getWidth	()I
    //   760: i2f
    //   761: fstore 5
    //   763: fload 5
    //   765: fstore 4
    //   767: aload 11
    //   769: astore 12
    //   771: fload 6
    //   773: fload 5
    //   775: fdiv
    //   776: fstore 5
    //   778: fload 5
    //   780: fstore 4
    //   782: goto +510 -> 1292
    //   785: fload 5
    //   787: fstore 4
    //   789: aload 11
    //   791: astore 12
    //   793: aload 16
    //   795: fload 5
    //   797: fneg
    //   798: fload 5
    //   800: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   803: goto -423 -> 380
    //   806: astore 11
    //   808: aload 12
    //   810: astore 11
    //   812: aload 16
    //   814: fload 4
    //   816: fload 4
    //   818: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   821: aload 11
    //   823: astore 12
    //   825: aload 13
    //   827: ifnull +446 -> 1273
    //   830: aload 13
    //   832: invokevirtual 267	java/io/FileInputStream:close	()V
    //   835: goto -441 -> 394
    //   838: fload 5
    //   840: fstore 4
    //   842: aload 11
    //   844: astore 12
    //   846: aload 16
    //   848: fload 5
    //   850: fload 5
    //   852: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   855: fload 5
    //   857: fstore 4
    //   859: aload 11
    //   861: astore 12
    //   863: aload 16
    //   865: ldc_w 418
    //   868: invokevirtual 422	android/graphics/Matrix:postRotate	(F)Z
    //   871: pop
    //   872: goto -492 -> 380
    //   875: astore_1
    //   876: aload 13
    //   878: astore_3
    //   879: aload_3
    //   880: ifnull +7 -> 887
    //   883: aload_3
    //   884: invokevirtual 267	java/io/FileInputStream:close	()V
    //   887: aload_1
    //   888: athrow
    //   889: fload 5
    //   891: fneg
    //   892: fstore 6
    //   894: fload 5
    //   896: fstore 4
    //   898: aload 11
    //   900: astore 12
    //   902: aload 16
    //   904: fload 5
    //   906: fload 6
    //   908: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   911: goto -531 -> 380
    //   914: fload 5
    //   916: fstore 4
    //   918: aload 11
    //   920: astore 12
    //   922: aload 16
    //   924: fload 5
    //   926: fload 5
    //   928: fneg
    //   929: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   932: fload 5
    //   934: fstore 4
    //   936: aload 11
    //   938: astore 12
    //   940: aload 16
    //   942: ldc_w 423
    //   945: invokevirtual 422	android/graphics/Matrix:postRotate	(F)Z
    //   948: pop
    //   949: goto -569 -> 380
    //   952: fload 5
    //   954: fstore 4
    //   956: aload 11
    //   958: astore 12
    //   960: aload 16
    //   962: fload 5
    //   964: fload 5
    //   966: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   969: fload 5
    //   971: fstore 4
    //   973: aload 11
    //   975: astore 12
    //   977: aload 16
    //   979: ldc_w 423
    //   982: invokevirtual 422	android/graphics/Matrix:postRotate	(F)Z
    //   985: pop
    //   986: goto -606 -> 380
    //   989: fload 5
    //   991: fstore 4
    //   993: aload 11
    //   995: astore 12
    //   997: aload 16
    //   999: fload 5
    //   1001: fneg
    //   1002: fload 5
    //   1004: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   1007: fload 5
    //   1009: fstore 4
    //   1011: aload 11
    //   1013: astore 12
    //   1015: aload 16
    //   1017: ldc_w 423
    //   1020: invokevirtual 422	android/graphics/Matrix:postRotate	(F)Z
    //   1023: pop
    //   1024: goto -644 -> 380
    //   1027: fload 5
    //   1029: fstore 4
    //   1031: aload 11
    //   1033: astore 12
    //   1035: aload 16
    //   1037: fload 5
    //   1039: fload 5
    //   1041: invokevirtual 285	android/graphics/Matrix:setScale	(FF)V
    //   1044: fload 5
    //   1046: fstore 4
    //   1048: aload 11
    //   1050: astore 12
    //   1052: aload 16
    //   1054: ldc_w 424
    //   1057: invokevirtual 422	android/graphics/Matrix:postRotate	(F)Z
    //   1060: pop
    //   1061: goto -681 -> 380
    //   1064: iload 8
    //   1066: ifne +16 -> 1082
    //   1069: aload_3
    //   1070: ifnull +12 -> 1082
    //   1073: aload_3
    //   1074: getfield 127	cooperation/troop_homework/jsp/TroopHWJsPlugin:mUiHandler	Landroid/os/Handler;
    //   1077: iconst_1
    //   1078: invokevirtual 430	android/os/Handler:sendEmptyMessage	(I)Z
    //   1081: pop
    //   1082: aconst_null
    //   1083: astore 11
    //   1085: goto -582 -> 503
    //   1088: astore 11
    //   1090: aconst_null
    //   1091: astore_1
    //   1092: aload 13
    //   1094: astore_3
    //   1095: aload 11
    //   1097: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   1100: aconst_null
    //   1101: astore 12
    //   1103: aload_3
    //   1104: ifnull +7 -> 1111
    //   1107: aload_3
    //   1108: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   1111: aload 12
    //   1113: astore 11
    //   1115: aload_1
    //   1116: ifnull -376 -> 740
    //   1119: aload_1
    //   1120: invokevirtual 417	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1123: aload 12
    //   1125: astore 11
    //   1127: goto -387 -> 740
    //   1130: aload 11
    //   1132: ifnull +8 -> 1140
    //   1135: aload 11
    //   1137: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   1140: aload_3
    //   1141: ifnull +7 -> 1148
    //   1144: aload_3
    //   1145: invokevirtual 417	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   1148: aload_1
    //   1149: athrow
    //   1150: astore_1
    //   1151: aload 12
    //   1153: astore_3
    //   1154: goto -24 -> 1130
    //   1157: astore_1
    //   1158: aload 12
    //   1160: astore_3
    //   1161: goto -31 -> 1130
    //   1164: astore 12
    //   1166: aload_1
    //   1167: astore_3
    //   1168: aload 12
    //   1170: astore_1
    //   1171: goto -41 -> 1130
    //   1174: astore 13
    //   1176: aload_1
    //   1177: astore 11
    //   1179: aload_3
    //   1180: astore 12
    //   1182: aload 13
    //   1184: astore_1
    //   1185: aload 11
    //   1187: astore_3
    //   1188: aload 12
    //   1190: astore 11
    //   1192: goto -62 -> 1130
    //   1195: astore_1
    //   1196: aload 11
    //   1198: astore_3
    //   1199: aconst_null
    //   1200: astore 12
    //   1202: aload_1
    //   1203: astore 11
    //   1205: aload 12
    //   1207: astore_1
    //   1208: goto -113 -> 1095
    //   1211: astore 12
    //   1213: aconst_null
    //   1214: astore_1
    //   1215: aload 11
    //   1217: astore_3
    //   1218: aload 12
    //   1220: astore 11
    //   1222: goto -127 -> 1095
    //   1225: astore 12
    //   1227: aload 11
    //   1229: astore_3
    //   1230: aload 12
    //   1232: astore 11
    //   1234: goto -139 -> 1095
    //   1237: astore_1
    //   1238: aconst_null
    //   1239: astore_3
    //   1240: goto -361 -> 879
    //   1243: astore_1
    //   1244: aload 13
    //   1246: astore_3
    //   1247: goto -368 -> 879
    //   1250: astore 13
    //   1252: fload 5
    //   1254: fstore 4
    //   1256: aload 12
    //   1258: astore 13
    //   1260: goto -448 -> 812
    //   1263: aconst_null
    //   1264: astore_3
    //   1265: aconst_null
    //   1266: astore_1
    //   1267: goto -551 -> 716
    //   1270: goto -767 -> 503
    //   1273: aload 12
    //   1275: astore 11
    //   1277: goto -883 -> 394
    //   1280: aconst_null
    //   1281: astore 11
    //   1283: aload 11
    //   1285: areturn
    //   1286: iconst_1
    //   1287: istore 7
    //   1289: goto -1111 -> 178
    //   1292: fload 4
    //   1294: f2d
    //   1295: ldc2_w 432
    //   1298: dcmpg
    //   1299: ifge +56 -> 1355
    //   1302: ldc_w 434
    //   1305: fstore 5
    //   1307: iload 9
    //   1309: tableswitch	default:+43 -> 1352, 2:+-524->785, 3:+-471->838, 4:+-420->889, 5:+-395->914, 6:+-357->952, 7:+-320->989, 8:+-282->1027
    //   1353: <illegal opcode>
    //   1354: fload_1
    //   1355: fconst_1
    //   1356: fstore 5
    //   1358: goto -51 -> 1307
    //   1361: astore_1
    //   1362: aconst_null
    //   1363: astore 11
    //   1365: aload 12
    //   1367: astore_3
    //   1368: goto -238 -> 1130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1371	0	paramInt1	int
    //   0	1371	1	paramString	String
    //   0	1371	2	paramInt2	int
    //   0	1371	3	paramTroopHWJsPlugin	TroopHWJsPlugin
    //   261	1032	4	f1	float
    //   137	1220	5	f2	float
    //   323	584	6	f3	float
    //   140	1148	7	i	int
    //   71	994	8	j	int
    //   146	1162	9	k	int
    //   78	109	10	m	int
    //   100	690	11	localObject1	Object
    //   806	1	11	localIOException1	IOException
    //   810	274	11	localObject2	Object
    //   1088	8	11	localIOException2	IOException
    //   1113	251	11	localObject3	Object
    //   19	1140	12	localObject4	Object
    //   1164	5	12	localObject5	Object
    //   1180	26	12	localTroopHWJsPlugin	TroopHWJsPlugin
    //   1211	8	12	localIOException3	IOException
    //   1225	141	12	localIOException4	IOException
    //   257	836	13	localObject6	Object
    //   1174	71	13	localObject7	Object
    //   1250	1	13	localIOException5	IOException
    //   1258	1	13	localIOException6	IOException
    //   125	415	14	localBitmap	Bitmap
    //   28	554	15	localStringBuilder	StringBuilder
    //   134	919	16	localMatrix	android.graphics.Matrix
    //   37	234	17	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   30	80	297	java/lang/OutOfMemoryError
    //   106	121	297	java/lang/OutOfMemoryError
    //   127	136	297	java/lang/OutOfMemoryError
    //   290	295	297	java/lang/OutOfMemoryError
    //   389	394	297	java/lang/OutOfMemoryError
    //   394	416	297	java/lang/OutOfMemoryError
    //   423	428	297	java/lang/OutOfMemoryError
    //   428	441	297	java/lang/OutOfMemoryError
    //   447	454	297	java/lang/OutOfMemoryError
    //   721	726	297	java/lang/OutOfMemoryError
    //   733	737	297	java/lang/OutOfMemoryError
    //   830	835	297	java/lang/OutOfMemoryError
    //   883	887	297	java/lang/OutOfMemoryError
    //   887	889	297	java/lang/OutOfMemoryError
    //   1107	1111	297	java/lang/OutOfMemoryError
    //   1119	1123	297	java/lang/OutOfMemoryError
    //   1135	1140	297	java/lang/OutOfMemoryError
    //   1144	1148	297	java/lang/OutOfMemoryError
    //   1148	1150	297	java/lang/OutOfMemoryError
    //   267	277	806	java/io/IOException
    //   333	341	806	java/io/IOException
    //   349	356	806	java/io/IOException
    //   371	380	806	java/io/IOException
    //   755	763	806	java/io/IOException
    //   771	778	806	java/io/IOException
    //   793	803	806	java/io/IOException
    //   846	855	806	java/io/IOException
    //   863	872	806	java/io/IOException
    //   902	911	806	java/io/IOException
    //   922	932	806	java/io/IOException
    //   940	949	806	java/io/IOException
    //   960	969	806	java/io/IOException
    //   977	986	806	java/io/IOException
    //   997	1007	806	java/io/IOException
    //   1015	1024	806	java/io/IOException
    //   1035	1044	806	java/io/IOException
    //   1052	1061	806	java/io/IOException
    //   267	277	875	finally
    //   333	341	875	finally
    //   349	356	875	finally
    //   371	380	875	finally
    //   755	763	875	finally
    //   771	778	875	finally
    //   793	803	875	finally
    //   846	855	875	finally
    //   863	872	875	finally
    //   902	911	875	finally
    //   922	932	875	finally
    //   940	949	875	finally
    //   960	969	875	finally
    //   977	986	875	finally
    //   997	1007	875	finally
    //   1015	1024	875	finally
    //   1035	1044	875	finally
    //   1052	1061	875	finally
    //   459	471	1088	java/io/IOException
    //   1073	1082	1088	java/io/IOException
    //   471	484	1150	finally
    //   488	503	1150	finally
    //   503	534	1157	finally
    //   539	544	1157	finally
    //   548	587	1157	finally
    //   587	628	1157	finally
    //   633	695	1157	finally
    //   695	711	1164	finally
    //   1095	1100	1174	finally
    //   471	484	1195	java/io/IOException
    //   488	503	1195	java/io/IOException
    //   503	534	1211	java/io/IOException
    //   539	544	1211	java/io/IOException
    //   548	587	1211	java/io/IOException
    //   587	628	1211	java/io/IOException
    //   633	695	1211	java/io/IOException
    //   695	711	1225	java/io/IOException
    //   142	148	1237	finally
    //   183	189	1237	finally
    //   189	195	1237	finally
    //   232	259	1237	finally
    //   307	313	1237	finally
    //   812	821	1243	finally
    //   142	148	1250	java/io/IOException
    //   183	189	1250	java/io/IOException
    //   189	195	1250	java/io/IOException
    //   232	259	1250	java/io/IOException
    //   307	313	1250	java/io/IOException
    //   459	471	1361	finally
    //   1073	1082	1361	finally
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnull +128 -> 134
    //   9: new 301	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 304	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 310	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 314	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 318	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 324	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 441	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 442	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 441	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 441	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramBitmap	Bitmap
    //   0	141	1	paramInt	int
    //   4	56	2	localObject1	Object
    //   61	2	2	localIOException1	IOException
    //   72	41	2	localObject2	Object
    //   118	19	2	localIOException2	IOException
    //   19	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   9	20	68	java/lang/Exception
    //   84	92	94	java/io/IOException
    //   9	20	101	finally
    //   108	116	118	java/io/IOException
    //   22	32	126	finally
    //   34	43	126	finally
    //   73	77	126	finally
    //   22	32	130	java/lang/Exception
    //   34	43	130	java/lang/Exception
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, TroopHWJsPlugin paramTroopHWJsPlugin)
    throws IOException, JSONException
  {
    localStringBuilder = null;
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(paramString2);
        try
        {
          localStringBuilder = new StringBuilder();
          arrayOfByte1 = new byte[30720];
          int i = localFileInputStream.read(arrayOfByte1);
          if (i == -1) {
            continue;
          }
          if (i >= 30720) {
            continue;
          }
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          localStringBuilder.append(aqgo.encodeToString(arrayOfByte2, 2));
          continue;
          if (paramString2 == null) {
            continue;
          }
        }
        finally
        {
          paramString2 = localFileInputStream;
        }
      }
      finally
      {
        FileInputStream localFileInputStream;
        byte[] arrayOfByte1;
        paramString2 = localStringBuilder;
        continue;
      }
      paramString2.close();
      throw paramString1;
      localStringBuilder.append(aqgo.encodeToString(arrayOfByte1, 2));
    }
    if (paramTroopHWJsPlugin != null)
    {
      paramString1 = paramTroopHWJsPlugin.a(paramString1, paramInt1, 1, "stop", null, -1);
      if (!TextUtils.isEmpty(localStringBuilder.toString())) {
        paramString1.put("imgstr", localStringBuilder);
      }
      paramString1.put("width", paramInt2);
      paramString1.put("height", paramInt3);
      paramTroopHWJsPlugin.callJs(paramTroopHWJsPlugin.aEt, new String[] { paramString1.toString() });
    }
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return paramString2;
  }
  
  private void acL(int paramInt)
  {
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      return;
    }
    ausj localausj = ausj.b(this.mRuntime.getActivity());
    localausj.addButton(2131719499, 1);
    localausj.addButton(2131719488, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new awjv(this, paramInt, localausj));
    localausj.show();
    this.mActionSheet = localausj;
  }
  
  private void acM(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.getActivity())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131691243, 0).show();
      return;
    }
    int i;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label132;
      }
      if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new awjw(this, localActivity, paramInt), 3, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
        continue;
      }
      this.aFT = c(localActivity, paramInt);
      return;
      this.aFT = c(localActivity, paramInt);
      return;
      label132:
      i = 1;
    }
  }
  
  /* Error */
  private Bitmap c(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 242	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQV	Ljava/lang/String;
    //   14: iload_1
    //   15: iconst_2
    //   16: ldc_w 346
    //   19: aconst_null
    //   20: iconst_m1
    //   21: invokevirtual 349	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   24: astore 6
    //   26: new 546	android/media/MediaMetadataRetriever
    //   29: dup
    //   30: invokespecial 547	android/media/MediaMetadataRetriever:<init>	()V
    //   33: astore 7
    //   35: aload 7
    //   37: aload_2
    //   38: invokevirtual 550	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   41: aload 7
    //   43: ldc2_w 551
    //   46: invokevirtual 556	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +388 -> 439
    //   54: aload_0
    //   55: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBs	I
    //   58: ifgt +131 -> 189
    //   61: sipush 540
    //   64: istore_1
    //   65: aload_0
    //   66: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBt	I
    //   69: ifgt +128 -> 197
    //   72: sipush 540
    //   75: istore_3
    //   76: aload_2
    //   77: iload_1
    //   78: iload_3
    //   79: invokestatic 562	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +62 -> 148
    //   89: aload 4
    //   91: aload 4
    //   93: invokestatic 299	cooperation/troop_homework/jsp/TroopHWJsPlugin:e	(Landroid/graphics/Bitmap;)I
    //   96: invokestatic 564	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Landroid/graphics/Bitmap;I)Ljava/lang/String;
    //   99: astore 5
    //   101: aload 5
    //   103: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +42 -> 148
    //   109: aload 6
    //   111: ldc_w 357
    //   114: aload 5
    //   116: invokevirtual 363	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload 6
    //   122: ldc_w 365
    //   125: aload 4
    //   127: invokevirtual 288	android/graphics/Bitmap:getWidth	()I
    //   130: invokevirtual 368	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload 6
    //   136: ldc_w 370
    //   139: aload 4
    //   141: invokevirtual 281	android/graphics/Bitmap:getHeight	()I
    //   144: invokevirtual 368	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 7
    //   150: invokevirtual 567	android/media/MediaMetadataRetriever:release	()V
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   158: iconst_1
    //   159: anewarray 374	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: aload 6
    //   166: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   169: aastore
    //   170: invokevirtual 379	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   173: aload 4
    //   175: ifnull +209 -> 384
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 295	android/graphics/Bitmap:recycle	()V
    //   186: aload 4
    //   188: areturn
    //   189: aload_0
    //   190: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBs	I
    //   193: istore_1
    //   194: goto -129 -> 65
    //   197: aload_0
    //   198: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBt	I
    //   201: istore_3
    //   202: goto -126 -> 76
    //   205: astore 5
    //   207: aconst_null
    //   208: astore_2
    //   209: aconst_null
    //   210: astore 4
    //   212: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +34 -> 249
    //   218: ldc_w 332
    //   221: iconst_2
    //   222: new 65	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 569
    //   232: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 5
    //   237: invokevirtual 572	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 576	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload 7
    //   251: invokevirtual 567	android/media/MediaMetadataRetriever:release	()V
    //   254: goto -101 -> 153
    //   257: astore 5
    //   259: goto -106 -> 153
    //   262: astore 5
    //   264: aconst_null
    //   265: astore_2
    //   266: aconst_null
    //   267: astore 4
    //   269: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +34 -> 306
    //   275: ldc_w 332
    //   278: iconst_2
    //   279: new 65	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 569
    //   289: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 5
    //   294: invokevirtual 577	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 576	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 7
    //   308: invokevirtual 567	android/media/MediaMetadataRetriever:release	()V
    //   311: goto -158 -> 153
    //   314: astore 5
    //   316: goto -163 -> 153
    //   319: astore 5
    //   321: aconst_null
    //   322: astore_2
    //   323: aconst_null
    //   324: astore 4
    //   326: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +34 -> 363
    //   332: ldc_w 332
    //   335: iconst_2
    //   336: new 65	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 579
    //   346: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 5
    //   351: invokevirtual 580	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 576	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload 7
    //   365: invokevirtual 567	android/media/MediaMetadataRetriever:release	()V
    //   368: goto -215 -> 153
    //   371: astore 5
    //   373: goto -220 -> 153
    //   376: astore_2
    //   377: aload 7
    //   379: invokevirtual 567	android/media/MediaMetadataRetriever:release	()V
    //   382: aload_2
    //   383: athrow
    //   384: aload_2
    //   385: ifnull -378 -> 7
    //   388: aload_2
    //   389: areturn
    //   390: astore 5
    //   392: goto -239 -> 153
    //   395: astore 4
    //   397: goto -15 -> 382
    //   400: astore 5
    //   402: aconst_null
    //   403: astore 4
    //   405: goto -79 -> 326
    //   408: astore 5
    //   410: goto -84 -> 326
    //   413: astore 5
    //   415: aconst_null
    //   416: astore 4
    //   418: goto -149 -> 269
    //   421: astore 5
    //   423: goto -154 -> 269
    //   426: astore 5
    //   428: aconst_null
    //   429: astore 4
    //   431: goto -219 -> 212
    //   434: astore 5
    //   436: goto -224 -> 212
    //   439: aconst_null
    //   440: astore 4
    //   442: goto -294 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	TroopHWJsPlugin
    //   0	445	1	paramInt	int
    //   0	445	2	paramString	String
    //   75	127	3	i	int
    //   82	243	4	localBitmap	Bitmap
    //   395	1	4	localRuntimeException1	java.lang.RuntimeException
    //   403	38	4	localObject	Object
    //   99	16	5	str	String
    //   205	31	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   257	1	5	localRuntimeException2	java.lang.RuntimeException
    //   262	31	5	localRuntimeException3	java.lang.RuntimeException
    //   314	1	5	localRuntimeException4	java.lang.RuntimeException
    //   319	31	5	localJSONException1	JSONException
    //   371	1	5	localRuntimeException5	java.lang.RuntimeException
    //   390	1	5	localRuntimeException6	java.lang.RuntimeException
    //   400	1	5	localJSONException2	JSONException
    //   408	1	5	localJSONException3	JSONException
    //   413	1	5	localRuntimeException7	java.lang.RuntimeException
    //   421	1	5	localRuntimeException8	java.lang.RuntimeException
    //   426	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   434	1	5	localIllegalArgumentException3	java.lang.IllegalArgumentException
    //   24	141	6	localJSONObject	JSONObject
    //   33	345	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   35	50	205	java/lang/IllegalArgumentException
    //   249	254	257	java/lang/RuntimeException
    //   35	50	262	java/lang/RuntimeException
    //   306	311	314	java/lang/RuntimeException
    //   35	50	319	org/json/JSONException
    //   363	368	371	java/lang/RuntimeException
    //   35	50	376	finally
    //   54	61	376	finally
    //   65	72	376	finally
    //   76	84	376	finally
    //   89	148	376	finally
    //   189	194	376	finally
    //   197	202	376	finally
    //   212	249	376	finally
    //   269	306	376	finally
    //   326	363	376	finally
    //   148	153	390	java/lang/RuntimeException
    //   377	382	395	java/lang/RuntimeException
    //   54	61	400	org/json/JSONException
    //   65	72	400	org/json/JSONException
    //   76	84	400	org/json/JSONException
    //   189	194	400	org/json/JSONException
    //   197	202	400	org/json/JSONException
    //   89	148	408	org/json/JSONException
    //   54	61	413	java/lang/RuntimeException
    //   65	72	413	java/lang/RuntimeException
    //   76	84	413	java/lang/RuntimeException
    //   189	194	413	java/lang/RuntimeException
    //   197	202	413	java/lang/RuntimeException
    //   89	148	421	java/lang/RuntimeException
    //   54	61	426	java/lang/IllegalArgumentException
    //   65	72	426	java/lang/IllegalArgumentException
    //   76	84	426	java/lang/IllegalArgumentException
    //   189	194	426	java/lang/IllegalArgumentException
    //   197	202	426	java/lang/IllegalArgumentException
    //   89	148	434	java/lang/IllegalArgumentException
  }
  
  public static String c(Activity paramActivity, int paramInt)
  {
    Object localObject = "";
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {}
    BaseApplication localBaseApplication;
    String str;
    Intent localIntent;
    do
    {
      return localObject;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = aqul.getSDKPrivatePath(acbn.oM + System.currentTimeMillis() + ".jpg");
      localObject = new File(str).getParentFile();
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        QQToast.a(localBaseApplication, 2131719242, 0).show();
      }
      localIntent = new Intent();
      FileProvider7Helper.setSystemCapture(paramActivity, new File(str), localIntent);
      localObject = str;
    } while (paramActivity == null);
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return str;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      QQToast.a(localBaseApplication, 2131691243, 0).show();
    }
    return str;
  }
  
  @TargetApi(12)
  public static int e(Bitmap paramBitmap)
  {
    int j = 100;
    int i;
    if (Build.VERSION.SDK_INT >= 12)
    {
      i = paramBitmap.getByteCount();
      if (i <= 41246720) {
        break label40;
      }
      j = 0;
    }
    label40:
    do
    {
      return j;
      i = paramBitmap.getRowBytes() * paramBitmap.getHeight();
      break;
      if (i > 6291456) {
        return 50;
      }
      if (i > 1048576) {
        return 80;
      }
    } while (i <= 102400);
    return 90;
  }
  
  public static void eDX()
  {
    int j = 0;
    Object localObject = new VFSFile(cQU);
    int i;
    if (((VFSFile)localObject).exists())
    {
      localObject = ((VFSFile)localObject).listFiles();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = new VFSFile(acbn.bmm);
    if (((VFSFile)localObject).exists())
    {
      localObject = ((VFSFile)localObject).listFiles();
      i = j;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
  }
  
  public b a(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt1, String paramString, Bitmap paramBitmap, a parama, int paramInt2)
  {
    paramTroopHWJsPlugin.getClass();
    b localb = new b(paramTroopHWJsPlugin);
    localb.id = paramInt1;
    localb.jdField_b_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$a = parama;
    localb.c = new awjs.c(paramTroopHWJsPlugin.mRuntime.a(), paramString, parama.mTroopUin);
    localb.c.a(localb.jdField_b_of_type_Awjs$b);
    localb.hi = paramBitmap;
    localb.cGT = paramString;
    localb.type = paramInt2;
    return localb;
  }
  
  public JSONObject a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("webid", paramString1);
      localJSONObject.put("state", paramString2);
      localJSONObject.put("path", "");
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("url", paramString3);
      }
      if (paramInt2 == 0)
      {
        localJSONObject.put("type", "record");
        localJSONObject.put("time", paramInt3);
        return localJSONObject;
      }
      if (paramInt2 == 2)
      {
        localJSONObject.put("type", "video");
        return localJSONObject;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return localJSONObject;
    }
    localJSONObject.put("type", "image");
    return localJSONObject;
  }
  
  public void acN(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.getActivity())
    {
      this.mUiHandler.sendEmptyMessage(3);
      return;
    }
    int i;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label135;
      }
      if ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new awjx(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
        continue;
      }
      acO(paramInt);
      return;
      acO(paramInt);
      return;
      label135:
      i = 1;
    }
  }
  
  public void acO(int paramInt)
  {
    Activity localActivity = this.mRuntime.getActivity();
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewFragment != null))
    {
      Intent localIntent = new Intent(localActivity, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 47);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
      localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
      if (paramInt == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      if ((localActivity instanceof AbsBaseWebViewActivity)) {
        ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)3);
      }
      while (localWebViewFragment == null) {
        return;
      }
      localWebViewFragment.a(this, localIntent, (byte)3);
      return;
    }
    this.mUiHandler.sendEmptyMessage(3);
  }
  
  protected void acP(int paramInt)
  {
    if (this.mRuntime == null) {}
    for (Activity localActivity = null; localActivity == null; localActivity = this.mRuntime.getActivity())
    {
      this.mUiHandler.sendEmptyMessage(4);
      return;
    }
    int i;
    if ((localActivity instanceof AppActivity))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label135;
      }
      if ((localActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        ((AppActivity)localActivity).requestPermissions(new awjz(this, paramInt, localActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
        continue;
      }
      acQ(paramInt);
      return;
      acQ(paramInt);
      return;
      label135:
      i = 1;
    }
  }
  
  public void acQ(int paramInt)
  {
    Activity localActivity = this.mRuntime.getActivity();
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (((localActivity instanceof AbsBaseWebViewActivity)) || (localWebViewFragment != null))
    {
      Intent localIntent = a(paramInt, localActivity, this.mRuntime.a().getCurrentAccountUin());
      if ((localActivity instanceof AbsBaseWebViewActivity)) {
        ((AbsBaseWebViewActivity)localActivity).a(this, localIntent, (byte)5);
      }
      while (localWebViewFragment == null) {
        return;
      }
      localWebViewFragment.a(this, localIntent, (byte)5);
      return;
    }
    this.mUiHandler.sendEmptyMessage(4);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramString)) {
      super.callJs(paramString, paramVarArgs);
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    while (!"getFileInfo".equals(paramBundle.getString("method"))) {
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(paramBundle.getLong("sessionId"));
    localForwardFileInfo.Oj(paramBundle.getInt("cloudType"));
    localForwardFileInfo.setType(paramBundle.getInt("type"));
    localForwardFileInfo.setLocalPath(paramBundle.getString("filePath"));
    localForwardFileInfo.setFileName(paramBundle.getString("fileName"));
    localForwardFileInfo.setFileSize(paramBundle.getLong("fileSize"));
    localForwardFileInfo.jA(paramBundle.getLong("troopCode"));
    paramBundle = new Intent();
    paramBundle.setClass(this.mRuntime.getActivity(), TroopFileDetailBrowserActivity.class);
    paramBundle.putExtra("fileinfo", localForwardFileInfo);
    paramBundle.putExtra("removemementity", true);
    paramBundle.putExtra("forward_from_troop_file", true);
    paramBundle.putExtra("not_forward", true);
    paramBundle.putExtra("last_time", 0);
    this.mRuntime.getActivity().startActivityForResult(paramBundle, 102);
  }
  
  public String cu(String paramString1, String paramString2)
  {
    paramString2 = arwv.toMD5(paramString2) + apqz.lb(paramString2);
    paramString1 = aqul.getSDKPrivatePath(acbn.bmn + paramString1 + File.separator);
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString1 + paramString2;
  }
  
  public String cv(String paramString1, String paramString2)
  {
    paramString1 = cu(paramString1, paramString2);
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return "";
  }
  
  public void d(String paramString, double paramDouble)
  {
    this.qR.put(Integer.valueOf(this.eBu), paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.eBu);
      localJSONObject.put("state", "stop");
      localJSONObject.put("path", paramString);
      localJSONObject.put("time", Math.round(paramDouble / 1000.0D));
      callJs(this.aEt, new String[] { localJSONObject.toString() });
      this.eBu += 1;
      if (this.dqD) {
        ThreadManager.post(new TroopHWJsPlugin.6(this, paramString), 2, null, false);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void eB(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString = "{'webid':'" + this.cQV + "', 'type':'record', 'state':'downloaded', 'url':'" + paramString + "'}";
      callJs(this.aEt, new String[] { paramString });
      return;
      String str = "{'webid':'" + this.cQV + "', 'type':'record', 'state':'stopPlay', 'url':'" + paramString + "'}";
      callJs(this.aEt, new String[] { str });
    } while ((this.cQW == null) || (!this.cQW.equals(paramString)));
    this.cQW = null;
  }
  
  public void eC(int paramInt, String paramString)
  {
    callJs(this.aEt, new String[] { a(this.cQV, paramInt, 0, "stopPlay", null, -1).toString() });
    if ((this.eBv != -1) && (paramInt == this.eBv)) {
      this.eBv = -1;
    }
  }
  
  public void eDY() {}
  
  public void eDZ() {}
  
  public void f(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("url", paramString1);
      paramString2.put("state", paramInt1);
      paramString2.put("finishLen", 0);
      paramString2.put("fileLen", 0);
      if (paramInt1 == 3) {
        paramString2.put("filePath", paramString3);
      }
      callJs(this.cQY, new String[] { paramString2.toString() });
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934597L) {
      this.dqC = this.jdField_a_of_type_Awkc.YA();
    }
    while ((paramLong != 2L) || (!this.dqC)) {
      return false;
    }
    paramString = "{'webid':" + this.cQV + ", 'type':'home', 'state':'click'}";
    callJs(this.aEt, new String[] { paramString });
    this.dqC = false;
    return false;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +17 -> 18
    //   4: ldc 129
    //   6: aload_3
    //   7: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 4
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 359	org/json/JSONObject
    //   23: dup
    //   24: aload 5
    //   26: iconst_0
    //   27: aaload
    //   28: invokespecial 913	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: ldc_w 915
    //   35: aload 4
    //   37: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +83 -> 123
    //   43: aload_0
    //   44: aload_1
    //   45: ldc_w 916
    //   48: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: iconst_1
    //   52: anewarray 374	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc_w 582
    //   60: aastore
    //   61: invokevirtual 379	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   68: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnonnull +11 -> 84
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -49 -> 32
    //   84: new 136	android/content/Intent
    //   87: dup
    //   88: invokespecial 610	android/content/Intent:<init>	()V
    //   91: astore_2
    //   92: aload_2
    //   93: ldc_w 921
    //   96: aload 5
    //   98: iconst_0
    //   99: aaload
    //   100: invokevirtual 163	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   103: pop
    //   104: aload_1
    //   105: iconst_m1
    //   106: aload_2
    //   107: invokevirtual 925	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   110: aload_1
    //   111: invokevirtual 928	android/app/Activity:isFinishing	()Z
    //   114: ifne +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 931	android/app/Activity:finish	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: aload_1
    //   124: ifnull +102 -> 226
    //   127: aload_1
    //   128: ldc_w 933
    //   131: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 15
    //   136: aload_1
    //   137: ldc_w 686
    //   140: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 16
    //   145: aload_0
    //   146: aload 15
    //   148: putfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   151: aload_0
    //   152: aload 16
    //   154: putfield 242	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQV	Ljava/lang/String;
    //   157: aload_0
    //   158: aload_3
    //   159: putfield 109	cooperation/troop_homework/jsp/TroopHWJsPlugin:mPackageName	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: ldc_w 935
    //   167: ldc_w 582
    //   170: invokevirtual 937	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: putfield 938	cooperation/troop_homework/jsp/TroopHWJsPlugin:mTroopUin	Ljava/lang/String;
    //   176: aload_0
    //   177: aload_1
    //   178: ldc_w 940
    //   181: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   184: putfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBs	I
    //   187: aload_0
    //   188: aload_1
    //   189: ldc_w 945
    //   192: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   195: putfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBt	I
    //   198: aload_0
    //   199: getfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBs	I
    //   202: ifne +10 -> 212
    //   205: aload_0
    //   206: sipush 540
    //   209: putfield 89	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBs	I
    //   212: aload_0
    //   213: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBt	I
    //   216: ifne +10 -> 226
    //   219: aload_0
    //   220: sipush 540
    //   223: putfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBt	I
    //   226: ldc_w 947
    //   229: aload 4
    //   231: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +73 -> 307
    //   237: aload_0
    //   238: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   241: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   244: astore_1
    //   245: new 136	android/content/Intent
    //   248: dup
    //   249: invokespecial 610	android/content/Intent:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: new 949	android/content/ComponentName
    //   257: dup
    //   258: aload_1
    //   259: ldc_w 951
    //   262: invokespecial 952	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   265: invokevirtual 956	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   268: pop
    //   269: aload_2
    //   270: ldc_w 686
    //   273: aload_0
    //   274: getfield 242	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQV	Ljava/lang/String;
    //   277: invokevirtual 163	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   280: pop
    //   281: aload_0
    //   282: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   285: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifeq +10 -> 298
    //   291: aload_1
    //   292: aload_2
    //   293: invokevirtual 960	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   296: iconst_1
    //   297: ireturn
    //   298: aload_0
    //   299: aload_2
    //   300: iconst_1
    //   301: invokevirtual 963	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   304: goto -8 -> 296
    //   307: ldc_w 965
    //   310: aload 4
    //   312: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +110 -> 425
    //   318: iconst_m1
    //   319: istore 6
    //   321: aload_1
    //   322: ifnull +12 -> 334
    //   325: aload_1
    //   326: ldc_w 684
    //   329: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   332: istore 6
    //   334: aload_0
    //   335: getfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   338: iconst_m1
    //   339: if_icmpne +36 -> 375
    //   342: aload_0
    //   343: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   346: iload 6
    //   348: aload_0
    //   349: getfield 118	cooperation/troop_homework/jsp/TroopHWJsPlugin:qR	Ljava/util/HashMap;
    //   352: iload 6
    //   354: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 374	java/lang/String
    //   363: invokevirtual 972	awkc:eD	(ILjava/lang/String;)V
    //   366: aload_0
    //   367: iload 6
    //   369: putfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   372: goto -76 -> 296
    //   375: iload 6
    //   377: aload_0
    //   378: getfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   381: if_icmpeq -85 -> 296
    //   384: aload_0
    //   385: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   388: invokevirtual 900	awkc:YA	()Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   396: iload 6
    //   398: aload_0
    //   399: getfield 118	cooperation/troop_homework/jsp/TroopHWJsPlugin:qR	Ljava/util/HashMap;
    //   402: iload 6
    //   404: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   410: checkcast 374	java/lang/String
    //   413: invokevirtual 972	awkc:eD	(ILjava/lang/String;)V
    //   416: aload_0
    //   417: iload 6
    //   419: putfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   422: goto -126 -> 296
    //   425: ldc_w 974
    //   428: aload 4
    //   430: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +49 -> 482
    //   436: aload_1
    //   437: ifnull +2472 -> 2909
    //   440: aload_1
    //   441: ldc_w 684
    //   444: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   447: istore 6
    //   449: aload_0
    //   450: getfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   453: iconst_m1
    //   454: if_icmpeq -158 -> 296
    //   457: iload 6
    //   459: aload_0
    //   460: getfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   463: if_icmpne -167 -> 296
    //   466: aload_0
    //   467: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   470: invokevirtual 900	awkc:YA	()Z
    //   473: pop
    //   474: aload_0
    //   475: iconst_m1
    //   476: putfield 107	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBv	I
    //   479: goto -183 -> 296
    //   482: ldc_w 976
    //   485: aload 4
    //   487: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   490: ifeq +204 -> 694
    //   493: bipush 10
    //   495: istore 7
    //   497: iconst_0
    //   498: istore 6
    //   500: aload_1
    //   501: ifnull +34 -> 535
    //   504: aload_1
    //   505: ldc_w 978
    //   508: bipush 10
    //   510: invokevirtual 981	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   513: istore 7
    //   515: aload_0
    //   516: aload_1
    //   517: ldc_w 940
    //   520: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 97	cooperation/troop_homework/jsp/TroopHWJsPlugin:mMaxWidth	I
    //   526: aload_1
    //   527: ldc_w 983
    //   530: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   533: istore 6
    //   535: iload 6
    //   537: iconst_1
    //   538: if_icmpne +13 -> 551
    //   541: aload_0
    //   542: sipush 29954
    //   545: invokespecial 454	cooperation/troop_homework/jsp/TroopHWJsPlugin:acM	(I)V
    //   548: goto -252 -> 296
    //   551: iload 6
    //   553: iconst_2
    //   554: if_icmpne +12 -> 566
    //   557: aload_0
    //   558: iload 7
    //   560: invokevirtual 985	cooperation/troop_homework/jsp/TroopHWJsPlugin:acN	(I)V
    //   563: goto -267 -> 296
    //   566: iload 6
    //   568: iconst_3
    //   569: if_icmpne +116 -> 685
    //   572: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +30 -> 605
    //   578: ldc_w 332
    //   581: iconst_2
    //   582: new 65	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 987
    //   592: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aload_0
    //   606: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   609: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   612: ifne +13 -> 625
    //   615: aload_0
    //   616: getfield 938	cooperation/troop_homework/jsp/TroopHWJsPlugin:mTroopUin	Ljava/lang/String;
    //   619: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   622: ifeq +54 -> 676
    //   625: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +46 -> 674
    //   631: ldc_w 332
    //   634: iconst_2
    //   635: new 65	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 994
    //   645: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   652: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc_w 996
    //   658: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_0
    //   662: getfield 938	cooperation/troop_homework/jsp/TroopHWJsPlugin:mTroopUin	Ljava/lang/String;
    //   665: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 576	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: iconst_1
    //   675: ireturn
    //   676: aload_0
    //   677: iload 7
    //   679: invokevirtual 998	cooperation/troop_homework/jsp/TroopHWJsPlugin:acP	(I)V
    //   682: goto -386 -> 296
    //   685: aload_0
    //   686: iload 7
    //   688: invokespecial 1000	cooperation/troop_homework/jsp/TroopHWJsPlugin:acL	(I)V
    //   691: goto -395 -> 296
    //   694: ldc_w 1002
    //   697: aload 4
    //   699: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +187 -> 889
    //   705: lconst_0
    //   706: lstore 8
    //   708: bipush 102
    //   710: istore 6
    //   712: aconst_null
    //   713: astore 5
    //   715: aconst_null
    //   716: astore 4
    //   718: aload_1
    //   719: ifnull +2181 -> 2900
    //   722: aload_1
    //   723: ldc_w 1004
    //   726: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: astore 5
    //   731: aload_1
    //   732: ldc_w 1006
    //   735: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   738: astore 4
    //   740: aload_1
    //   741: ldc_w 935
    //   744: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 15
    //   749: aload_1
    //   750: ldc_w 1008
    //   753: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore_3
    //   757: aload_1
    //   758: ldc_w 1010
    //   761: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   764: astore_2
    //   765: aload 15
    //   767: astore_1
    //   768: aload_3
    //   769: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   772: ifne +12 -> 784
    //   775: aload_3
    //   776: invokestatic 1015	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   779: invokevirtual 1018	java/lang/Long:longValue	()J
    //   782: lstore 8
    //   784: aload_2
    //   785: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   788: ifne +12 -> 800
    //   791: aload_2
    //   792: invokestatic 1021	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   795: invokevirtual 1024	java/lang/Integer:intValue	()I
    //   798: istore 6
    //   800: aload_1
    //   801: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   804: ifne +66 -> 870
    //   807: aload_0
    //   808: getfield 101	cooperation/troop_homework/jsp/TroopHWJsPlugin:mClient	Lskj;
    //   811: aload_1
    //   812: invokestatic 1015	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   815: invokevirtual 1018	java/lang/Long:longValue	()J
    //   818: aload 4
    //   820: aload 5
    //   822: lload 8
    //   824: iload 6
    //   826: aload_0
    //   827: invokevirtual 1029	skj:a	(JLjava/lang/String;Ljava/lang/String;JILskj$a;)V
    //   830: goto -534 -> 296
    //   833: astore_2
    //   834: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq -541 -> 296
    //   840: ldc_w 332
    //   843: iconst_2
    //   844: new 65	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 1031
    //   854: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_1
    //   858: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 1033	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -571 -> 296
    //   870: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq -577 -> 296
    //   876: ldc_w 332
    //   879: iconst_2
    //   880: ldc_w 1035
    //   883: invokestatic 1033	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   886: goto -590 -> 296
    //   889: ldc_w 1037
    //   892: aload 4
    //   894: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   897: ifeq +73 -> 970
    //   900: aload_1
    //   901: ifnull +1992 -> 2893
    //   904: aload_1
    //   905: ldc_w 692
    //   908: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   911: astore_1
    //   912: aload_0
    //   913: getfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   916: ifnonnull +19 -> 935
    //   919: aload_0
    //   920: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   923: aload_1
    //   924: invokevirtual 1040	awkc:abN	(Ljava/lang/String;)V
    //   927: aload_0
    //   928: aload_1
    //   929: putfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   932: goto -636 -> 296
    //   935: aload_0
    //   936: getfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   939: aload_1
    //   940: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   943: ifne -647 -> 296
    //   946: aload_0
    //   947: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   950: invokevirtual 900	awkc:YA	()Z
    //   953: pop
    //   954: aload_0
    //   955: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   958: aload_1
    //   959: invokevirtual 1040	awkc:abN	(Ljava/lang/String;)V
    //   962: aload_0
    //   963: aload_1
    //   964: putfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   967: goto -671 -> 296
    //   970: ldc_w 1042
    //   973: aload 4
    //   975: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +49 -> 1027
    //   981: aload_1
    //   982: ifnull +1904 -> 2886
    //   985: aload_1
    //   986: ldc_w 692
    //   989: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   992: astore_1
    //   993: aload_0
    //   994: getfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   997: ifnull -701 -> 296
    //   1000: aload_0
    //   1001: getfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   1004: aload_1
    //   1005: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq -712 -> 296
    //   1011: aload_0
    //   1012: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   1015: invokevirtual 900	awkc:YA	()Z
    //   1018: pop
    //   1019: aload_0
    //   1020: aconst_null
    //   1021: putfield 105	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQW	Ljava/lang/String;
    //   1024: goto -728 -> 296
    //   1027: ldc_w 1044
    //   1030: aload 4
    //   1032: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifeq +23 -> 1058
    //   1038: aload_0
    //   1039: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   1042: aload_0
    //   1043: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1046: invokevirtual 658	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   1049: invokevirtual 1047	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1052: invokevirtual 1050	awkc:abR	(Ljava/lang/String;)V
    //   1055: goto -759 -> 296
    //   1058: ldc_w 1052
    //   1061: aload 4
    //   1063: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1066: ifeq +39 -> 1105
    //   1069: aload_1
    //   1070: ifnull +25 -> 1095
    //   1073: aload_0
    //   1074: aload_1
    //   1075: ldc_w 1054
    //   1078: invokevirtual 1058	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1081: putfield 111	cooperation/troop_homework/jsp/TroopHWJsPlugin:dqD	Z
    //   1084: aload_0
    //   1085: aload_1
    //   1086: ldc_w 1060
    //   1089: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1092: putfield 113	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQX	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 103	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awkc	Lawkc;
    //   1099: invokevirtual 1063	awkc:eEa	()V
    //   1102: goto -806 -> 296
    //   1105: ldc_w 1065
    //   1108: aload 4
    //   1110: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1113: ifeq +25 -> 1138
    //   1116: new 1067	cooperation/troop_homework/jsp/TroopHWJsPlugin$1
    //   1119: dup
    //   1120: aload_0
    //   1121: aload_2
    //   1122: invokestatic 1072	aoiz:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   1125: invokespecial 1073	cooperation/troop_homework/jsp/TroopHWJsPlugin$1:<init>	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;Ljava/lang/String;)V
    //   1128: bipush 8
    //   1130: aconst_null
    //   1131: iconst_0
    //   1132: invokestatic 868	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1135: goto -839 -> 296
    //   1138: ldc_w 1075
    //   1141: aload 4
    //   1143: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1146: ifeq +54 -> 1200
    //   1149: aload_1
    //   1150: ifnull -854 -> 296
    //   1153: aload_1
    //   1154: ldc_w 692
    //   1157: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: astore_2
    //   1161: aload_1
    //   1162: ldc_w 1077
    //   1165: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: astore_3
    //   1169: aload_0
    //   1170: aload_1
    //   1171: ldc_w 933
    //   1174: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: putfield 891	cooperation/troop_homework/jsp/TroopHWJsPlugin:cQY	Ljava/lang/String;
    //   1180: aload_0
    //   1181: aload_3
    //   1182: aload_2
    //   1183: invokevirtual 842	cooperation/troop_homework/jsp/TroopHWJsPlugin:cu	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1186: astore_1
    //   1187: aload_0
    //   1188: getfield 1079	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awjt	Lawjt;
    //   1191: aload_2
    //   1192: aload_1
    //   1193: aload_0
    //   1194: invokevirtual 1084	awjt:a	(Ljava/lang/String;Ljava/lang/String;Lawjt$a;)V
    //   1197: goto -901 -> 296
    //   1200: ldc_w 1086
    //   1203: aload 4
    //   1205: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1208: ifeq +26 -> 1234
    //   1211: aload_1
    //   1212: ifnull -916 -> 296
    //   1215: aload_1
    //   1216: ldc_w 692
    //   1219: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore_1
    //   1223: aload_0
    //   1224: getfield 1079	cooperation/troop_homework/jsp/TroopHWJsPlugin:jdField_a_of_type_Awjt	Lawjt;
    //   1227: aload_1
    //   1228: invokevirtual 1089	awjt:pauseDownloadTask	(Ljava/lang/String;)V
    //   1231: goto -935 -> 296
    //   1234: ldc_w 1091
    //   1237: aload 4
    //   1239: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1242: ifeq +194 -> 1436
    //   1245: aload_1
    //   1246: ifnull -950 -> 296
    //   1249: aload_1
    //   1250: ldc_w 1077
    //   1253: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1256: astore 4
    //   1258: aload_1
    //   1259: ldc_w 1093
    //   1262: invokevirtual 1097	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1265: astore 5
    //   1267: aload_1
    //   1268: ldc_w 933
    //   1271: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore_2
    //   1275: new 359	org/json/JSONObject
    //   1278: dup
    //   1279: invokespecial 683	org/json/JSONObject:<init>	()V
    //   1282: astore_3
    //   1283: new 1099	org/json/JSONArray
    //   1286: dup
    //   1287: invokespecial 1100	org/json/JSONArray:<init>	()V
    //   1290: astore 15
    //   1292: aload 5
    //   1294: invokevirtual 1102	org/json/JSONArray:length	()I
    //   1297: istore 7
    //   1299: iconst_0
    //   1300: istore 6
    //   1302: iload 6
    //   1304: iload 7
    //   1306: if_icmpge +33 -> 1339
    //   1309: aload 15
    //   1311: iload 6
    //   1313: aload_0
    //   1314: aload 4
    //   1316: aload 5
    //   1318: iload 6
    //   1320: invokevirtual 1105	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1323: invokevirtual 1107	cooperation/troop_homework/jsp/TroopHWJsPlugin:cv	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1326: invokevirtual 1110	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1329: pop
    //   1330: iload 6
    //   1332: iconst_1
    //   1333: iadd
    //   1334: istore 6
    //   1336: goto -34 -> 1302
    //   1339: aload_3
    //   1340: ldc_w 1112
    //   1343: aload 15
    //   1345: invokevirtual 363	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1348: pop
    //   1349: aload_3
    //   1350: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1353: astore_3
    //   1354: aload_0
    //   1355: aload_2
    //   1356: iconst_1
    //   1357: anewarray 374	java/lang/String
    //   1360: dup
    //   1361: iconst_0
    //   1362: aload_3
    //   1363: aastore
    //   1364: invokevirtual 379	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1367: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -1074 -> 296
    //   1373: ldc_w 332
    //   1376: iconst_2
    //   1377: new 65	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1384: ldc_w 1114
    //   1387: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: aload_1
    //   1391: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1394: ldc_w 1116
    //   1397: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload_3
    //   1401: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: goto -1114 -> 296
    //   1413: astore 4
    //   1415: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq -69 -> 1349
    //   1421: ldc_w 332
    //   1424: iconst_2
    //   1425: ldc_w 1114
    //   1428: aload 4
    //   1430: invokestatic 1119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1433: goto -84 -> 1349
    //   1436: ldc_w 1121
    //   1439: aload 4
    //   1441: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1444: ifeq +68 -> 1512
    //   1447: aload_1
    //   1448: ifnull -1152 -> 296
    //   1451: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq +30 -> 1484
    //   1457: ldc_w 332
    //   1460: iconst_2
    //   1461: new 65	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1468: ldc_w 1123
    //   1471: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_1
    //   1475: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1478: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1481: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1484: aload_1
    //   1485: ldc_w 1125
    //   1488: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1491: astore_2
    //   1492: aload_1
    //   1493: ldc_w 1127
    //   1496: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1499: astore_1
    //   1500: aload_0
    //   1501: getfield 101	cooperation/troop_homework/jsp/TroopHWJsPlugin:mClient	Lskj;
    //   1504: aload_2
    //   1505: aload_1
    //   1506: invokevirtual 1131	skj:cH	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: goto -1213 -> 296
    //   1512: ldc_w 1133
    //   1515: aload 4
    //   1517: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1520: ifeq +58 -> 1578
    //   1523: aload_1
    //   1524: ifnull +54 -> 1578
    //   1527: aload_1
    //   1528: ldc_w 693
    //   1531: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1534: pop
    //   1535: aload_1
    //   1536: ldc_w 684
    //   1539: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1542: istore 6
    //   1544: aload_0
    //   1545: getfield 120	cooperation/troop_homework/jsp/TroopHWJsPlugin:qS	Ljava/util/HashMap;
    //   1548: iload 6
    //   1550: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1556: checkcast 24	cooperation/troop_homework/jsp/TroopHWJsPlugin$b
    //   1559: astore_1
    //   1560: aload_1
    //   1561: ifnull -1265 -> 296
    //   1564: aload_1
    //   1565: getfield 1136	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:isUploading	Z
    //   1568: ifne -1272 -> 296
    //   1571: aload_1
    //   1572: invokevirtual 1139	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:dIP	()V
    //   1575: goto -1279 -> 296
    //   1578: ldc_w 1141
    //   1581: aload 4
    //   1583: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1586: ifeq +62 -> 1648
    //   1589: aload_1
    //   1590: ifnull +58 -> 1648
    //   1593: aload_1
    //   1594: ldc_w 693
    //   1597: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: pop
    //   1601: aload_1
    //   1602: ldc_w 684
    //   1605: invokevirtual 943	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1608: istore 6
    //   1610: aload_0
    //   1611: getfield 120	cooperation/troop_homework/jsp/TroopHWJsPlugin:qS	Ljava/util/HashMap;
    //   1614: iload 6
    //   1616: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1619: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1622: checkcast 24	cooperation/troop_homework/jsp/TroopHWJsPlugin$b
    //   1625: astore_1
    //   1626: aload_1
    //   1627: ifnull -1331 -> 296
    //   1630: aload_1
    //   1631: getfield 1136	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:isUploading	Z
    //   1634: ifeq -1338 -> 296
    //   1637: aload_1
    //   1638: getfield 1145	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cS	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1641: iconst_1
    //   1642: invokevirtual 1151	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1645: goto -1349 -> 296
    //   1648: ldc_w 1153
    //   1651: aload 4
    //   1653: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1656: ifeq +83 -> 1739
    //   1659: aload_1
    //   1660: ifnull -1364 -> 296
    //   1663: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1666: ifeq +24 -> 1690
    //   1669: ldc_w 332
    //   1672: iconst_2
    //   1673: iconst_2
    //   1674: anewarray 151	java/lang/Object
    //   1677: dup
    //   1678: iconst_0
    //   1679: ldc_w 1155
    //   1682: aastore
    //   1683: dup
    //   1684: iconst_1
    //   1685: aload_1
    //   1686: aastore
    //   1687: invokestatic 344	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1690: aload_1
    //   1691: ldc_w 1077
    //   1694: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1697: astore_2
    //   1698: aload_1
    //   1699: ldc_w 693
    //   1702: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1705: astore_1
    //   1706: aload_0
    //   1707: getfield 101	cooperation/troop_homework/jsp/TroopHWJsPlugin:mClient	Lskj;
    //   1710: aload_2
    //   1711: aload_1
    //   1712: invokevirtual 1158	skj:cK	(Ljava/lang/String;Ljava/lang/String;)V
    //   1715: goto -1419 -> 296
    //   1718: astore_1
    //   1719: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1722: ifeq -1426 -> 296
    //   1725: ldc_w 332
    //   1728: iconst_2
    //   1729: ldc_w 1160
    //   1732: aload_1
    //   1733: invokestatic 1119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1736: goto -1440 -> 296
    //   1739: ldc_w 1162
    //   1742: aload 4
    //   1744: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1747: ifeq +167 -> 1914
    //   1750: aload_1
    //   1751: ifnull -1455 -> 296
    //   1754: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1757: ifeq +30 -> 1787
    //   1760: ldc_w 332
    //   1763: iconst_2
    //   1764: new 65	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 1164
    //   1774: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload_1
    //   1778: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1787: aload_1
    //   1788: ldc_w 684
    //   1791: iconst_0
    //   1792: invokevirtual 981	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1795: istore 6
    //   1797: aload_0
    //   1798: getfield 120	cooperation/troop_homework/jsp/TroopHWJsPlugin:qS	Ljava/util/HashMap;
    //   1801: iload 6
    //   1803: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1806: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1809: checkcast 24	cooperation/troop_homework/jsp/TroopHWJsPlugin$b
    //   1812: astore_2
    //   1813: aload_2
    //   1814: ifnull +70 -> 1884
    //   1817: aload_2
    //   1818: getfield 679	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cGT	Ljava/lang/String;
    //   1821: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1824: ifne +60 -> 1884
    //   1827: new 760	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   1830: dup
    //   1831: invokespecial 761	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   1834: astore_1
    //   1835: aload_1
    //   1836: aload_2
    //   1837: getfield 679	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cGT	Ljava/lang/String;
    //   1840: invokevirtual 787	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:setLocalPath	(Ljava/lang/String;)V
    //   1843: new 136	android/content/Intent
    //   1846: dup
    //   1847: aload_0
    //   1848: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1851: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1854: ldc_w 804
    //   1857: invokespecial 141	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1860: astore_2
    //   1861: aload_2
    //   1862: ldc_w 810
    //   1865: aload_1
    //   1866: invokevirtual 813	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1869: pop
    //   1870: aload_0
    //   1871: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   1874: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1877: aload_2
    //   1878: invokevirtual 960	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1881: goto -1585 -> 296
    //   1884: ldc_w 332
    //   1887: iconst_1
    //   1888: new 65	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   1895: ldc_w 1166
    //   1898: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: aload_2
    //   1902: invokevirtual 990	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 1033	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: goto -1615 -> 296
    //   1914: ldc_w 1168
    //   1917: aload 4
    //   1919: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1922: ifeq +18 -> 1940
    //   1925: aload_0
    //   1926: getfield 120	cooperation/troop_homework/jsp/TroopHWJsPlugin:qS	Ljava/util/HashMap;
    //   1929: invokevirtual 1171	java/util/HashMap:clear	()V
    //   1932: aload_0
    //   1933: iconst_1
    //   1934: putfield 99	cooperation/troop_homework/jsp/TroopHWJsPlugin:eBu	I
    //   1937: goto -1641 -> 296
    //   1940: ldc_w 1173
    //   1943: aload 4
    //   1945: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1948: ifeq +77 -> 2025
    //   1951: aload_1
    //   1952: ifnull -1656 -> 296
    //   1955: aload_1
    //   1956: ldc_w 684
    //   1959: iconst_0
    //   1960: invokevirtual 981	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1963: istore 6
    //   1965: aload_0
    //   1966: getfield 120	cooperation/troop_homework/jsp/TroopHWJsPlugin:qS	Ljava/util/HashMap;
    //   1969: iload 6
    //   1971: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1974: invokevirtual 969	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1977: checkcast 24	cooperation/troop_homework/jsp/TroopHWJsPlugin$b
    //   1980: astore_1
    //   1981: aload_1
    //   1982: ifnull -1686 -> 296
    //   1985: aload_1
    //   1986: getfield 679	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cGT	Ljava/lang/String;
    //   1989: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1992: ifne -1696 -> 296
    //   1995: new 201	java/io/File
    //   1998: dup
    //   1999: aload_1
    //   2000: getfield 679	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cGT	Ljava/lang/String;
    //   2003: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   2006: astore_2
    //   2007: aload_0
    //   2008: getfield 101	cooperation/troop_homework/jsp/TroopHWJsPlugin:mClient	Lskj;
    //   2011: aload_1
    //   2012: getfield 679	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cGT	Ljava/lang/String;
    //   2015: aload_2
    //   2016: invokevirtual 1174	java/io/File:getName	()Ljava/lang/String;
    //   2019: invokevirtual 1131	skj:cH	(Ljava/lang/String;Ljava/lang/String;)V
    //   2022: goto -1726 -> 296
    //   2025: ldc_w 1176
    //   2028: aload 4
    //   2030: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2033: ifeq +94 -> 2127
    //   2036: aload_1
    //   2037: ifnull +78 -> 2115
    //   2040: ldc_w 332
    //   2043: ldc_w 1178
    //   2046: aload_1
    //   2047: invokestatic 1183	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   2050: aload_1
    //   2051: ldc_w 1185
    //   2054: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2057: astore_2
    //   2058: aload_1
    //   2059: ldc_w 1187
    //   2062: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2065: astore_3
    //   2066: aload_1
    //   2067: ldc_w 1189
    //   2070: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2073: astore 4
    //   2075: aload_1
    //   2076: ldc_w 1191
    //   2079: invokevirtual 919	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2082: astore_1
    //   2083: aload_0
    //   2084: aload_0
    //   2085: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2088: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2091: aload_2
    //   2092: aload_3
    //   2093: aload_0
    //   2094: getfield 372	cooperation/troop_homework/jsp/TroopHWJsPlugin:aEt	Ljava/lang/String;
    //   2097: aload 4
    //   2099: aload_0
    //   2100: getfield 938	cooperation/troop_homework/jsp/TroopHWJsPlugin:mTroopUin	Ljava/lang/String;
    //   2103: aload_1
    //   2104: invokestatic 1196	com/tencent/mobileqq/troop/homework/arithmetic/ui/CheckArithHWResultFragment:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: bipush 6
    //   2109: invokevirtual 963	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2112: goto -1816 -> 296
    //   2115: ldc_w 332
    //   2118: ldc_w 1198
    //   2121: invokestatic 1200	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2124: goto -1828 -> 296
    //   2127: ldc_w 1202
    //   2130: aload 4
    //   2132: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2135: ifeq +186 -> 2321
    //   2138: new 359	org/json/JSONObject
    //   2141: dup
    //   2142: aload 5
    //   2144: iconst_0
    //   2145: aaload
    //   2146: invokespecial 913	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2149: ldc_w 1204
    //   2152: invokevirtual 1205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2155: astore_2
    //   2156: aload_2
    //   2157: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2160: istore 14
    //   2162: iload 14
    //   2164: ifne -1868 -> 296
    //   2167: lconst_0
    //   2168: lstore 8
    //   2170: aload_2
    //   2171: invokestatic 1208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2174: lstore 10
    //   2176: lload 10
    //   2178: lstore 8
    //   2180: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2183: ifeq +31 -> 2214
    //   2186: ldc_w 332
    //   2189: iconst_2
    //   2190: new 65	java/lang/StringBuilder
    //   2193: dup
    //   2194: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2197: ldc_w 1210
    //   2200: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: lload 8
    //   2205: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2208: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2211: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2214: lload 8
    //   2216: lconst_0
    //   2217: lcmp
    //   2218: ifle +67 -> 2285
    //   2221: aload_0
    //   2222: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2225: ifnull +55 -> 2280
    //   2228: aload_0
    //   2229: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2232: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2235: astore_1
    //   2236: aload_1
    //   2237: aconst_null
    //   2238: aload_2
    //   2239: invokestatic 1215	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:b	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2242: aload_1
    //   2243: ifnull -1947 -> 296
    //   2246: aload_1
    //   2247: ldc_w 1216
    //   2250: ldc_w 1217
    //   2253: invokevirtual 1220	android/app/Activity:overridePendingTransition	(II)V
    //   2256: goto -1960 -> 296
    //   2259: astore_1
    //   2260: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2263: ifeq -1967 -> 296
    //   2266: ldc_w 332
    //   2269: iconst_2
    //   2270: ldc_w 1222
    //   2273: aload_1
    //   2274: invokestatic 1119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2277: goto -1981 -> 296
    //   2280: aconst_null
    //   2281: astore_1
    //   2282: goto -46 -> 2236
    //   2285: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2288: ifeq -1992 -> 296
    //   2291: ldc_w 332
    //   2294: iconst_2
    //   2295: new 65	java/lang/StringBuilder
    //   2298: dup
    //   2299: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2302: ldc_w 1224
    //   2305: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: aload_2
    //   2309: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2312: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2315: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2318: goto -2022 -> 296
    //   2321: ldc_w 1226
    //   2324: aload 4
    //   2326: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2329: ifeq +245 -> 2574
    //   2332: new 359	org/json/JSONObject
    //   2335: dup
    //   2336: aload 5
    //   2338: iconst_0
    //   2339: aaload
    //   2340: invokespecial 913	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2343: astore_1
    //   2344: aload_1
    //   2345: ldc_w 1228
    //   2348: invokevirtual 1205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2351: astore_2
    //   2352: aload_2
    //   2353: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2356: istore 14
    //   2358: iload 14
    //   2360: ifne -2064 -> 296
    //   2363: aload_2
    //   2364: invokestatic 1208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2367: lstore 10
    //   2369: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2372: ifeq +31 -> 2403
    //   2375: ldc_w 332
    //   2378: iconst_2
    //   2379: new 65	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2386: ldc_w 1230
    //   2389: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: lload 10
    //   2394: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2397: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2400: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2403: aload_1
    //   2404: ldc_w 1204
    //   2407: invokevirtual 1205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2410: astore_1
    //   2411: lconst_0
    //   2412: lstore 8
    //   2414: aload_1
    //   2415: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2418: istore 14
    //   2420: lload 8
    //   2422: lstore 12
    //   2424: iload 14
    //   2426: ifne +55 -> 2481
    //   2429: aload_1
    //   2430: invokestatic 1208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2433: lstore 12
    //   2435: lload 12
    //   2437: lstore 8
    //   2439: lload 8
    //   2441: lstore 12
    //   2443: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2446: ifeq +35 -> 2481
    //   2449: ldc_w 332
    //   2452: iconst_2
    //   2453: new 65	java/lang/StringBuilder
    //   2456: dup
    //   2457: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2460: ldc_w 1210
    //   2463: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: lload 8
    //   2468: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2471: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2474: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2477: lload 8
    //   2479: lstore 12
    //   2481: lload 10
    //   2483: lconst_0
    //   2484: lcmp
    //   2485: ifle -2189 -> 296
    //   2488: lload 12
    //   2490: lconst_0
    //   2491: lcmp
    //   2492: ifle -2196 -> 296
    //   2495: aload_0
    //   2496: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2499: ifnull +70 -> 2569
    //   2502: aload_0
    //   2503: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2506: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2509: astore_1
    //   2510: aload_0
    //   2511: aload_1
    //   2512: lload 12
    //   2514: lload 10
    //   2516: invokestatic 1235	com/tencent/mobileqq/troop/homework/entry/ui/SubmitHomeWorkFragment:a	(Landroid/app/Activity;JJ)Landroid/content/Intent;
    //   2519: bipush 7
    //   2521: invokevirtual 963	cooperation/troop_homework/jsp/TroopHWJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2524: aload_1
    //   2525: ifnull -2229 -> 296
    //   2528: aload_1
    //   2529: ldc_w 1216
    //   2532: ldc_w 1217
    //   2535: invokevirtual 1220	android/app/Activity:overridePendingTransition	(II)V
    //   2538: goto -2242 -> 296
    //   2541: astore_1
    //   2542: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2545: ifeq -2249 -> 296
    //   2548: ldc_w 332
    //   2551: iconst_2
    //   2552: ldc_w 1222
    //   2555: aload_1
    //   2556: invokestatic 1119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2559: goto -2263 -> 296
    //   2562: astore_2
    //   2563: lconst_0
    //   2564: lstore 10
    //   2566: goto -197 -> 2369
    //   2569: aconst_null
    //   2570: astore_1
    //   2571: goto -61 -> 2510
    //   2574: ldc_w 1237
    //   2577: aload 4
    //   2579: invokevirtual 758	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2582: ifeq -2286 -> 296
    //   2585: new 359	org/json/JSONObject
    //   2588: dup
    //   2589: aload 5
    //   2591: iconst_0
    //   2592: aaload
    //   2593: invokespecial 913	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2596: astore_2
    //   2597: aload_2
    //   2598: ldc_w 1228
    //   2601: invokevirtual 1205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2604: astore_1
    //   2605: aload_2
    //   2606: ldc_w 1204
    //   2609: invokevirtual 1205	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2612: astore_2
    //   2613: aload_1
    //   2614: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2617: ifne +211 -> 2828
    //   2620: aload_2
    //   2621: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2624: istore 14
    //   2626: iload 14
    //   2628: ifne +200 -> 2828
    //   2631: aload_1
    //   2632: invokestatic 1208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2635: lstore 8
    //   2637: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2640: ifeq +31 -> 2671
    //   2643: ldc_w 332
    //   2646: iconst_2
    //   2647: new 65	java/lang/StringBuilder
    //   2650: dup
    //   2651: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2654: ldc_w 1239
    //   2657: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: lload 8
    //   2662: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2665: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2668: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2671: lconst_0
    //   2672: lstore 10
    //   2674: aload_2
    //   2675: invokestatic 1208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2678: lstore 12
    //   2680: lload 12
    //   2682: lstore 10
    //   2684: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2687: ifeq +31 -> 2718
    //   2690: ldc_w 332
    //   2693: iconst_2
    //   2694: new 65	java/lang/StringBuilder
    //   2697: dup
    //   2698: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2701: ldc_w 1241
    //   2704: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: lload 10
    //   2709: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2712: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2715: invokestatic 992	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2718: lload 8
    //   2720: lconst_0
    //   2721: lcmp
    //   2722: ifle -2426 -> 296
    //   2725: lload 10
    //   2727: lconst_0
    //   2728: lcmp
    //   2729: ifle -2433 -> 296
    //   2732: aload_0
    //   2733: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2736: ifnull +87 -> 2823
    //   2739: aload_0
    //   2740: getfield 467	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   2743: invokevirtual 473	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   2746: astore_1
    //   2747: new 751	android/os/Bundle
    //   2750: dup
    //   2751: invokespecial 1242	android/os/Bundle:<init>	()V
    //   2754: astore_3
    //   2755: aload_3
    //   2756: ldc_w 1228
    //   2759: lload 8
    //   2761: invokevirtual 1246	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2764: aload_3
    //   2765: ldc_w 1248
    //   2768: iconst_2
    //   2769: invokevirtual 1252	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2772: aload_1
    //   2773: aload_3
    //   2774: aload_2
    //   2775: invokestatic 1215	com/tencent/mobileqq/troop/homework/entry/ui/PublishHomeWorkFragment:b	(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;)V
    //   2778: aload_1
    //   2779: ifnull -2483 -> 296
    //   2782: aload_1
    //   2783: ldc_w 1216
    //   2786: ldc_w 1217
    //   2789: invokevirtual 1220	android/app/Activity:overridePendingTransition	(II)V
    //   2792: goto -2496 -> 296
    //   2795: astore_1
    //   2796: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2799: ifeq -2503 -> 296
    //   2802: ldc_w 332
    //   2805: iconst_2
    //   2806: ldc_w 1222
    //   2809: aload_1
    //   2810: invokestatic 1119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2813: goto -2517 -> 296
    //   2816: astore_1
    //   2817: lconst_0
    //   2818: lstore 8
    //   2820: goto -183 -> 2637
    //   2823: aconst_null
    //   2824: astore_1
    //   2825: goto -78 -> 2747
    //   2828: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2831: ifeq -2535 -> 296
    //   2834: ldc_w 332
    //   2837: iconst_2
    //   2838: new 65	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 1254
    //   2848: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: aload_1
    //   2852: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: ldc_w 1256
    //   2858: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: aload_2
    //   2862: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2868: invokestatic 1033	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2871: goto -2575 -> 296
    //   2874: astore_1
    //   2875: goto -695 -> 2180
    //   2878: astore_1
    //   2879: goto -440 -> 2439
    //   2882: astore_1
    //   2883: goto -199 -> 2684
    //   2886: ldc_w 582
    //   2889: astore_1
    //   2890: goto -1897 -> 993
    //   2893: ldc_w 582
    //   2896: astore_1
    //   2897: goto -1985 -> 912
    //   2900: aconst_null
    //   2901: astore_2
    //   2902: aconst_null
    //   2903: astore_1
    //   2904: aconst_null
    //   2905: astore_3
    //   2906: goto -2138 -> 768
    //   2909: iconst_m1
    //   2910: istore 6
    //   2912: goto -2463 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2915	0	this	TroopHWJsPlugin
    //   0	2915	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	2915	2	paramString1	String
    //   0	2915	3	paramString2	String
    //   0	2915	4	paramString3	String
    //   0	2915	5	paramVarArgs	String[]
    //   319	2592	6	i	int
    //   495	812	7	j	int
    //   706	2113	8	l1	long
    //   2174	552	10	l2	long
    //   2422	259	12	l3	long
    //   2160	467	14	bool	boolean
    //   134	1210	15	localObject	Object
    //   143	10	16	str	String
    // Exception table:
    //   from	to	target	type
    //   20	32	78	org/json/JSONException
    //   800	830	833	java/lang/NumberFormatException
    //   870	886	833	java/lang/NumberFormatException
    //   1283	1299	1413	java/lang/Exception
    //   1309	1330	1413	java/lang/Exception
    //   1339	1349	1413	java/lang/Exception
    //   1690	1715	1718	java/lang/Exception
    //   2138	2162	2259	java/lang/Exception
    //   2180	2214	2259	java/lang/Exception
    //   2221	2236	2259	java/lang/Exception
    //   2236	2242	2259	java/lang/Exception
    //   2246	2256	2259	java/lang/Exception
    //   2285	2318	2259	java/lang/Exception
    //   2332	2358	2541	java/lang/Exception
    //   2369	2403	2541	java/lang/Exception
    //   2403	2411	2541	java/lang/Exception
    //   2414	2420	2541	java/lang/Exception
    //   2443	2477	2541	java/lang/Exception
    //   2495	2510	2541	java/lang/Exception
    //   2510	2524	2541	java/lang/Exception
    //   2528	2538	2541	java/lang/Exception
    //   2363	2369	2562	java/lang/Exception
    //   2585	2626	2795	java/lang/Exception
    //   2637	2671	2795	java/lang/Exception
    //   2684	2718	2795	java/lang/Exception
    //   2732	2747	2795	java/lang/Exception
    //   2747	2778	2795	java/lang/Exception
    //   2782	2792	2795	java/lang/Exception
    //   2828	2871	2795	java/lang/Exception
    //   2631	2637	2816	java/lang/Exception
    //   2170	2176	2874	java/lang/Exception
    //   2429	2435	2878	java/lang/Exception
    //   2674	2680	2882	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    }
    label123:
    label635:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject1;
            do
            {
              do
              {
                return;
              } while (paramInt != -1);
              if (paramIntent == null) {
                localObject1 = "";
              }
              for (;;)
              {
                try
                {
                  localObject1 = new JSONObject((String)localObject1);
                }
                catch (JSONException localJSONException2)
                {
                  localObject1 = null;
                }
                try
                {
                  ((JSONObject)localObject1).put("id", this.eBu);
                  if (localObject1 != null) {
                    break;
                  }
                  this.mUiHandler.sendEmptyMessage(0);
                  return;
                }
                catch (JSONException localJSONException3)
                {
                  HashMap localHashMap1;
                  HashMap localHashMap2;
                  Object localObject2;
                  break label123;
                }
                localObject1 = paramIntent.getStringExtra("jscallback");
                continue;
                localJSONException2.printStackTrace();
              }
              callJs(this.aEt, new String[] { ((JSONObject)localObject1).toString() });
              if (paramIntent == null) {}
              for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("localPath"))
              {
                this.qR.put(Integer.valueOf(this.eBu), paramIntent);
                localObject1 = new a(this.aEt, this.mTroopUin, this.cQV);
                paramIntent = a(this, this.eBu, paramIntent, null, (a)localObject1, 0);
                this.qS.put(Integer.valueOf(this.eBu), paramIntent);
                paramIntent.c.start();
                this.eBu += 1;
                return;
              }
            } while (paramInt != -1);
            localHashMap1 = new HashMap();
            localHashMap2 = new HashMap();
            if ((paramByte == 2) && (!TextUtils.isEmpty(this.aFT)))
            {
              aqhu.cn(this.mRuntime.getActivity(), this.aFT);
              localHashMap1.put(Integer.valueOf(this.eBu), this.aFT);
              this.eBu += 1;
            }
            do
            {
              if (localHashMap2.size() <= 0) {
                break label845;
              }
              if (QLog.isColorLevel()) {
                QLog.e("TroopHWJsPlugin", 2, "video selected! size = " + localHashMap2.size());
              }
              paramIntent = new VFSFile(cQU);
              if (!paramIntent.exists()) {
                paramIntent.mkdirs();
              }
              paramIntent = localHashMap2.entrySet().iterator();
              while (paramIntent.hasNext())
              {
                localObject1 = (Map.Entry)paramIntent.next();
                paramInt = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
                if (!TextUtils.isEmpty((String)((Map.Entry)localObject1).getValue())) {
                  try
                  {
                    callJs(this.aEt, new String[] { a(this.cQV, paramInt, 2, "select", null, -1).toString() });
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                    this.mUiHandler.sendEmptyMessage(0);
                  }
                }
              }
              if (paramIntent != null) {}
              for (localObject2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (localObject2 == null) || (((ArrayList)localObject2).size() == 0); localObject2 = null)
              {
                QLog.e("TroopHWJsPlugin", 1, "selected list empty!");
                this.mUiHandler.sendEmptyMessage(0);
                return;
              }
              paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
              Object localObject3;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("selected pic or video! size = ");
                if (paramIntent != null)
                {
                  paramInt = paramIntent.size();
                  QLog.d("TroopHWJsPlugin", 2, paramInt);
                }
              }
              else
              {
                localObject2 = ((ArrayList)localObject2).iterator();
                if (!((Iterator)localObject2).hasNext()) {
                  continue;
                }
                localObject3 = (String)((Iterator)localObject2).next();
                paramInt = 0;
                if (paramIntent != null)
                {
                  if (aqfy.getMediaType((LocalMediaInfo)paramIntent.get(localObject3)) != 1) {
                    break label718;
                  }
                  paramInt = 1;
                }
                if (paramInt == 0) {
                  break label723;
                }
                localHashMap2.put(Integer.valueOf(this.eBu), localObject3);
              }
              for (;;)
              {
                this.eBu += 1;
                break label635;
                paramInt = 0;
                break;
                paramInt = 0;
                break label681;
                localHashMap1.put(Integer.valueOf(this.eBu), localObject3);
              }
            } while ((!TextUtils.isEmpty(this.aEt)) && (!TextUtils.isEmpty(this.mTroopUin)));
          } while (!QLog.isColorLevel());
          QLog.w("TroopHWJsPlugin", 2, "mJsCallback == " + this.aEt + ", mTroopUin == " + this.mTroopUin);
          return;
          ThreadManager.postImmediately(new CompressVideoJob(new a(this.aEt, this.mTroopUin, this.cQV), localHashMap2), null, false);
        } while (localHashMap1.size() <= 0);
        if (QLog.isColorLevel()) {
          QLog.e("TroopHWJsPlugin", 2, "pic selected! size = " + localHashMap1.size());
        }
        paramIntent = new VFSFile(cQU);
        if (!paramIntent.exists()) {
          paramIntent.mkdirs();
        }
        paramIntent = localHashMap1.entrySet().iterator();
        while (paramIntent.hasNext())
        {
          localObject2 = (Map.Entry)paramIntent.next();
          paramInt = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          if (!TextUtils.isEmpty((String)((Map.Entry)localObject2).getValue())) {
            try
            {
              callJs(this.aEt, new String[] { a(this.cQV, paramInt, 1, "select", null, -1).toString() });
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              this.mUiHandler.sendEmptyMessage(0);
            }
          }
        }
        ThreadManager.postImmediately(new CompressImageJob(localHashMap1), null, false);
        return;
        paramIntent = CheckArithHWResultFragment.b(paramIntent);
        try
        {
          paramIntent.put("webid", this.cQV);
          callJs(this.aEt, new String[] { paramIntent.toString() });
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      } while ((paramInt != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("SubmitHomeWorkFragment:js_callback");
    } while (TextUtils.isEmpty(paramIntent));
    label681:
    label718:
    label723:
    callJs(this.aEt, new String[] { paramIntent });
    label845:
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mClient = skj.a();
    this.mClient.bzj();
    this.jdField_a_of_type_Awkc = new awkc(this.mRuntime.getActivity(), this);
    this.jdField_a_of_type_Awjt = new awjt(this.mRuntime.getActivity());
  }
  
  public void onDestroy()
  {
    int j = 0;
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Awjt != null) {
      this.jdField_a_of_type_Awjt.destroy(this.mRuntime.getActivity());
    }
    if ("homework".equals(this.mPackageName))
    {
      Object localObject1 = new VFSFile(cQU);
      int i;
      if (((VFSFile)localObject1).exists())
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        i = 0;
        while (i < localObject1.length)
        {
          localObject1[i].delete();
          i += 1;
        }
      }
      localObject1 = new VFSFile(acbn.bmm);
      if (((VFSFile)localObject1).exists())
      {
        localObject1 = ((VFSFile)localObject1).listFiles();
        i = j;
        while (i < localObject1.length)
        {
          localObject1[i].delete();
          i += 1;
        }
      }
      localObject1 = this.qR.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("stream")))
        {
          localObject2 = new VFSFile((String)localObject2);
          if (((VFSFile)localObject2).exists()) {
            ((VFSFile)localObject2).delete();
          }
        }
      }
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("state", 2);
      localJSONObject.put("finishLen", paramLong1);
      localJSONObject.put("fileLen", paramLong2);
      callJs(this.cQY, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = this.mRuntime.getWebView();
    if ((paramCustomWebView != null) && (paramCustomWebView.getUrl() != null) && (paramCustomWebView.getUrl().contains("https://"))) {
      this.dqE = true;
    }
  }
  
  public void u(int paramInt, float paramFloat)
  {
    JSONObject localJSONObject = a(this.cQV, paramInt, 2, "uploading", null, -1);
    try
    {
      localJSONObject.put("progress", paramFloat);
      callJs(this.aEt, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  class CompressImageJob
    implements Runnable
  {
    private HashMap<Integer, String> qT;
    
    public CompressImageJob()
    {
      Object localObject;
      this.qT = ((HashMap)localObject.clone());
    }
    
    public void run()
    {
      Object localObject1 = new VFSFile(TroopHWJsPlugin.cQU);
      if (!((VFSFile)localObject1).exists()) {
        ((VFSFile)localObject1).mkdirs();
      }
      localObject1 = new HashMap();
      Iterator localIterator = this.qT.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHWJsPlugin", 2, "CompressImage, path = " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          try
          {
            localObject2 = TroopHWJsPlugin.a(i, (String)localObject2, TroopHWJsPlugin.this.mMaxWidth, TroopHWJsPlugin.this);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label207;
            }
            QLog.e("TroopHWJsPlugin", 2, "compressImage failed!");
            TroopHWJsPlugin.a(TroopHWJsPlugin.this).sendEmptyMessage(0);
          }
          catch (Exception localException)
          {
            QLog.e("TroopHWJsPlugin", 2, "compressImage failed!", localException);
            TroopHWJsPlugin.a(TroopHWJsPlugin.this).sendEmptyMessage(0);
          }
          continue;
          label207:
          TroopHWJsPlugin.this.qR.put(Integer.valueOf(i), localException);
          ((HashMap)localObject1).put(Integer.valueOf(i), localException);
          TroopHWJsPlugin.a locala = new TroopHWJsPlugin.a(TroopHWJsPlugin.this.aEt, TroopHWJsPlugin.this.mTroopUin, TroopHWJsPlugin.this.cQV);
          TroopHWJsPlugin.b localb = TroopHWJsPlugin.this.a(TroopHWJsPlugin.this, i, localException, null, locala, 1);
          TroopHWJsPlugin.this.qS.put(Integer.valueOf(i), localb);
          localb.start();
        }
        else
        {
          TroopHWJsPlugin.a(TroopHWJsPlugin.this).sendEmptyMessage(3);
          QLog.e("TroopHWJsPlugin", 2, "compressImage failed! empty image!");
        }
      }
    }
  }
  
  class CompressVideoJob
    implements Runnable
  {
    private TroopHWJsPlugin.a a;
    private HashMap<Integer, String> qU;
    
    public CompressVideoJob(HashMap<Integer, String> paramHashMap)
    {
      Object localObject;
      this.qU = localObject;
      this.a = paramHashMap;
    }
    
    public void run()
    {
      Context localContext = TroopHWJsPlugin.this.mRuntime.getActivity().getApplicationContext();
      VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.cQU);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      Iterator localIterator = this.qU.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (String)((Map.Entry)localObject).getValue();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHWJsPlugin", 2, "compressVideo, path = " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Bitmap localBitmap;
          String str;
          int j;
          try
          {
            localBitmap = TroopHWJsPlugin.a(TroopHWJsPlugin.this, i, (String)localObject);
            str = aqul.getSDKPrivatePath(localVFSFile.getAbsolutePath() + "/" + new File((String)localObject).getName());
            TroopHWJsPlugin.this.u(i, 0.05F);
            j = awjs.f(localContext, (String)localObject, str);
            TroopHWJsPlugin.this.u(i, 0.1F);
            if (j != 1) {
              break label306;
            }
            localObject = TroopHWJsPlugin.this.a(TroopHWJsPlugin.this, i, (String)localObject, localBitmap, this.a, 2);
            TroopHWJsPlugin.this.qS.put(Integer.valueOf(i), localObject);
            ((TroopHWJsPlugin.b)localObject).start();
          }
          catch (Exception localException)
          {
            QLog.e("TroopHWJsPlugin", 2, "compressVideo, Exception happened!", localException);
            TroopHWJsPlugin.a(TroopHWJsPlugin.this).sendEmptyMessage(0);
          }
          continue;
          label306:
          TroopHWJsPlugin.b localb;
          if ((j == 0) && (new File(str).exists()))
          {
            localb = TroopHWJsPlugin.this.a(TroopHWJsPlugin.this, i, str, localBitmap, this.a, 2);
            TroopHWJsPlugin.this.qS.put(Integer.valueOf(i), localb);
            localb.start();
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopHWJsPlugin", 2, "CompressVideoJob failed:" + j);
            }
            localb = TroopHWJsPlugin.this.a(TroopHWJsPlugin.this, i, localb, localBitmap, this.a, 2);
            TroopHWJsPlugin.this.qS.put(Integer.valueOf(i), localb);
            localb.start();
          }
        }
        else
        {
          TroopHWJsPlugin.a(TroopHWJsPlugin.this).sendEmptyMessage(4);
          QLog.e("TroopHWJsPlugin", 2, "compressVideo,video empty!");
        }
      }
    }
  }
  
  public class UploadVideoThumbJob
    implements Runnable
  {
    TroopHWJsPlugin.c a;
    TroopHWJsPlugin.b b;
    protected boolean dqF;
    
    public UploadVideoThumbJob(TroopHWJsPlugin.b paramb, TroopHWJsPlugin.c paramc, boolean paramBoolean)
    {
      this.b = paramb;
      this.a = paramc;
      this.dqF = paramBoolean;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 36
      //   2: iconst_2
      //   3: new 38	java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   10: ldc 41
      //   12: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: aload_0
      //   16: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   19: getfield 51	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:id	I
      //   22: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   25: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   28: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   31: aload_0
      //   32: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   35: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   38: ifnull +200 -> 238
      //   41: aload_0
      //   42: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   45: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   48: invokevirtual 74	android/graphics/Bitmap:isRecycled	()Z
      //   51: ifne +187 -> 238
      //   54: aload_0
      //   55: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   58: getfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cS	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   61: invokevirtual 83	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   64: ifne +174 -> 238
      //   67: ldc 85
      //   69: astore_3
      //   70: aload_0
      //   71: getfield 30	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:dqF	Z
      //   74: ifeq +6 -> 80
      //   77: ldc 87
      //   79: astore_3
      //   80: aload_0
      //   81: getfield 21	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:this$0	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
      //   84: getfield 91	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
      //   87: invokevirtual 96	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
      //   90: astore 5
      //   92: aload 5
      //   94: iconst_2
      //   95: invokevirtual 102	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
      //   98: checkcast 104	mqq/manager/TicketManager
      //   101: astore 4
      //   103: aload 5
      //   105: invokevirtual 107	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   108: astore 5
      //   110: aload 4
      //   112: aload 5
      //   114: invokeinterface 111 2 0
      //   119: astore 6
      //   121: new 113	java/io/File
      //   124: dup
      //   125: new 38	java/lang/StringBuilder
      //   128: dup
      //   129: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   132: getstatic 119	acbn:bmj	Ljava/lang/String;
      //   135: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   138: ldc 121
      //   140: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   146: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
      //   149: astore 4
      //   151: aload_0
      //   152: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   155: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   158: aload 4
      //   160: invokestatic 130	aqhu:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/io/File;)V
      //   163: aload_0
      //   164: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   167: getfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cS	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   170: invokevirtual 83	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   173: ifeq +66 -> 239
      //   176: ldc 36
      //   178: iconst_2
      //   179: new 38	java/lang/StringBuilder
      //   182: dup
      //   183: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   186: ldc 132
      //   188: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: aload_0
      //   192: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   195: getfield 51	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:id	I
      //   198: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   201: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   204: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   207: aload_0
      //   208: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   211: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   214: ifnull +13 -> 227
      //   217: aload_0
      //   218: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   221: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   224: invokevirtual 135	android/graphics/Bitmap:recycle	()V
      //   227: aload 4
      //   229: ifnull +9 -> 238
      //   232: aload 4
      //   234: invokevirtual 138	java/io/File:delete	()Z
      //   237: pop
      //   238: return
      //   239: aload 4
      //   241: ifnull +208 -> 449
      //   244: aload 4
      //   246: invokevirtual 141	java/io/File:exists	()Z
      //   249: ifeq +200 -> 449
      //   252: ldc 36
      //   254: iconst_2
      //   255: new 38	java/lang/StringBuilder
      //   258: dup
      //   259: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   262: ldc 143
      //   264: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   267: aload 4
      //   269: invokevirtual 146	java/io/File:getCanonicalPath	()Ljava/lang/String;
      //   272: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: ldc 148
      //   277: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: aload 4
      //   282: invokevirtual 152	java/io/File:length	()J
      //   285: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   288: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   291: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   294: aload_3
      //   295: aload 4
      //   297: invokevirtual 146	java/io/File:getCanonicalPath	()Ljava/lang/String;
      //   300: aload 5
      //   302: aload 6
      //   304: ldc2_w 156
      //   307: invokestatic 162	awjs:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
      //   310: astore_3
      //   311: aload_0
      //   312: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   315: getfield 78	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:cS	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   318: invokevirtual 83	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   321: istore_2
      //   322: iload_2
      //   323: ifeq +35 -> 358
      //   326: aload_0
      //   327: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   330: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   333: ifnull +13 -> 346
      //   336: aload_0
      //   337: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   340: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   343: invokevirtual 135	android/graphics/Bitmap:recycle	()V
      //   346: aload 4
      //   348: ifnull -110 -> 238
      //   351: aload 4
      //   353: invokevirtual 138	java/io/File:delete	()Z
      //   356: pop
      //   357: return
      //   358: aload_3
      //   359: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   362: ifne +233 -> 595
      //   365: new 170	org/json/JSONObject
      //   368: dup
      //   369: aload_3
      //   370: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   373: astore_3
      //   374: aload_3
      //   375: ifnull +220 -> 595
      //   378: aload_3
      //   379: ldc 173
      //   381: iconst_m1
      //   382: invokevirtual 177	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   385: ifne +210 -> 595
      //   388: aload_3
      //   389: ldc 179
      //   391: invokevirtual 183	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   394: astore_3
      //   395: aload_3
      //   396: ifnull +199 -> 595
      //   399: aload_3
      //   400: ldc 185
      //   402: invokevirtual 188	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   405: astore_3
      //   406: aload_0
      //   407: getfield 28	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$c;
      //   410: ifnull +190 -> 600
      //   413: aload_0
      //   414: getfield 28	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$c;
      //   417: iconst_1
      //   418: aload_3
      //   419: invokeinterface 194 3 0
      //   424: goto +176 -> 600
      //   427: iload_1
      //   428: ifne +21 -> 449
      //   431: aload_0
      //   432: getfield 28	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$c;
      //   435: ifnull +14 -> 449
      //   438: aload_0
      //   439: getfield 28	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$c;
      //   442: iconst_0
      //   443: aconst_null
      //   444: invokeinterface 194 3 0
      //   449: aload_0
      //   450: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   453: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   456: ifnull +13 -> 469
      //   459: aload_0
      //   460: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   463: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   466: invokevirtual 135	android/graphics/Bitmap:recycle	()V
      //   469: aload 4
      //   471: ifnull -233 -> 238
      //   474: aload 4
      //   476: invokevirtual 138	java/io/File:delete	()Z
      //   479: pop
      //   480: return
      //   481: astore 4
      //   483: aconst_null
      //   484: astore_3
      //   485: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   488: ifeq +13 -> 501
      //   491: ldc 36
      //   493: iconst_2
      //   494: ldc 199
      //   496: aload 4
      //   498: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   501: aload_0
      //   502: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   505: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   508: ifnull +13 -> 521
      //   511: aload_0
      //   512: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   515: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   518: invokevirtual 135	android/graphics/Bitmap:recycle	()V
      //   521: aload_3
      //   522: ifnull -284 -> 238
      //   525: aload_3
      //   526: invokevirtual 138	java/io/File:delete	()Z
      //   529: pop
      //   530: return
      //   531: astore_3
      //   532: aconst_null
      //   533: astore 4
      //   535: aload_0
      //   536: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   539: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   542: ifnull +13 -> 555
      //   545: aload_0
      //   546: getfield 26	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$b;
      //   549: getfield 68	cooperation/troop_homework/jsp/TroopHWJsPlugin$b:hi	Landroid/graphics/Bitmap;
      //   552: invokevirtual 135	android/graphics/Bitmap:recycle	()V
      //   555: aload 4
      //   557: ifnull +9 -> 566
      //   560: aload 4
      //   562: invokevirtual 138	java/io/File:delete	()Z
      //   565: pop
      //   566: aload_3
      //   567: athrow
      //   568: astore_3
      //   569: goto -34 -> 535
      //   572: astore 5
      //   574: aload_3
      //   575: astore 4
      //   577: aload 5
      //   579: astore_3
      //   580: goto -45 -> 535
      //   583: astore 5
      //   585: aload 4
      //   587: astore_3
      //   588: aload 5
      //   590: astore 4
      //   592: goto -107 -> 485
      //   595: iconst_0
      //   596: istore_1
      //   597: goto -170 -> 427
      //   600: iconst_1
      //   601: istore_1
      //   602: goto -175 -> 427
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	605	0	this	UploadVideoThumbJob
      //   427	175	1	i	int
      //   321	2	2	bool	boolean
      //   69	457	3	localObject1	Object
      //   531	36	3	localObject2	Object
      //   568	7	3	localObject3	Object
      //   579	9	3	localObject4	Object
      //   101	374	4	localObject5	Object
      //   481	16	4	localException1	Exception
      //   533	58	4	localObject6	Object
      //   90	211	5	localObject7	Object
      //   572	6	5	localObject8	Object
      //   583	6	5	localException2	Exception
      //   119	184	6	str	String
      // Exception table:
      //   from	to	target	type
      //   121	151	481	java/lang/Exception
      //   121	151	531	finally
      //   151	207	568	finally
      //   244	322	568	finally
      //   358	374	568	finally
      //   378	395	568	finally
      //   399	424	568	finally
      //   431	449	568	finally
      //   485	501	572	finally
      //   151	207	583	java/lang/Exception
      //   244	322	583	java/lang/Exception
      //   358	374	583	java/lang/Exception
      //   378	395	583	java/lang/Exception
      //   399	424	583	java/lang/Exception
      //   431	449	583	java/lang/Exception
    }
  }
  
  public static class a
  {
    public String cQV;
    public String mCallback;
    public String mTroopUin;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.mCallback = paramString1;
      this.mTroopUin = paramString2;
      this.cQV = paramString3;
    }
  }
  
  public class b
  {
    awjs.b b = new awka(this);
    public TroopHWJsPlugin.a b;
    awjs.c c;
    String cGT;
    public AtomicBoolean cS = new AtomicBoolean(false);
    Bitmap hi;
    public int id;
    public boolean isUploading;
    public int type;
    public String videoUrl;
    
    public b() {}
    
    public void dIP()
    {
      ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.3(this), null, false);
    }
    
    public void start()
    {
      ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.2(this), null, false);
    }
  }
  
  public static abstract interface c
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin
 * JD-Core Version:    0.7.0.1
 */