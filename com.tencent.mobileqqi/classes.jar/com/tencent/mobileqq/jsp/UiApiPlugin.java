package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import fzw;
import fzx;
import fzz;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, QQProgressDialog.Callback, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 1001;
  static final String jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  static final byte jdField_b_of_type_Byte = 2;
  public static final int b = 0;
  static final String jdField_b_of_type_JavaLangString = "getPictureParam";
  static final byte jdField_c_of_type_Byte = 3;
  public static final int c = 1;
  static final String jdField_c_of_type_JavaLangString = "name";
  static final byte jdField_d_of_type_Byte = 4;
  static final String jdField_d_of_type_JavaLangString = "callback";
  static final String e = "callback_url";
  static final String f = "match";
  static final String g = "data";
  static final String h = "imageID";
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public QQProgressDialog a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  protected String i = null;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public UiApiPlugin()
  {
    this.d = 0;
  }
  
  /* Error */
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 81	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 82	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: new 84	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 10
    //   19: aload 10
    //   21: invokevirtual 91	java/io/File:length	()J
    //   24: ldc2_w 92
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 79	java/io/IOException
    //   34: dup
    //   35: invokespecial 94	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 96	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 97	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 9
    //   48: aload 9
    //   50: iconst_1
    //   51: putfield 100	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 9
    //   57: invokestatic 106	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 9
    //   63: getfield 109	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 7
    //   68: aload 9
    //   70: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 8
    //   75: iload 7
    //   77: iflt +8 -> 85
    //   80: iload 8
    //   82: ifge +11 -> 93
    //   85: new 79	java/io/IOException
    //   88: dup
    //   89: invokespecial 94	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 7
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 8
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 11
    //   107: ldc 37
    //   109: iconst_1
    //   110: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 11
    //   116: areturn
    //   117: iload 7
    //   119: iload_3
    //   120: if_icmpgt +332 -> 452
    //   123: iload 8
    //   125: iload 4
    //   127: if_icmpgt +325 -> 452
    //   130: new 118	java/io/FileInputStream
    //   133: dup
    //   134: aload 10
    //   136: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 10
    //   141: aload 10
    //   143: invokevirtual 127	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 10
    //   149: invokevirtual 127	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 10
    //   155: invokevirtual 127	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +103 -> 266
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +96 -> 266
    //   173: new 129	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 131
    //   179: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: astore 9
    //   184: aload 9
    //   186: iconst_3
    //   187: newarray byte
    //   189: dup
    //   190: iconst_0
    //   191: iload_1
    //   192: i2b
    //   193: bastore
    //   194: dup
    //   195: iconst_1
    //   196: iload_2
    //   197: i2b
    //   198: bastore
    //   199: dup
    //   200: iconst_2
    //   201: iload_3
    //   202: i2b
    //   203: bastore
    //   204: iconst_2
    //   205: invokestatic 137	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   208: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: sipush 30720
    //   215: newarray byte
    //   217: astore 12
    //   219: aload 10
    //   221: aload 12
    //   223: invokevirtual 144	java/io/InputStream:read	([B)I
    //   226: istore_1
    //   227: iload_1
    //   228: iconst_m1
    //   229: if_icmpeq +182 -> 411
    //   232: invokestatic 150	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   235: invokevirtual 154	java/lang/Thread:isInterrupted	()Z
    //   238: ifeq +121 -> 359
    //   241: new 156	java/lang/InterruptedException
    //   244: dup
    //   245: invokespecial 157	java/lang/InterruptedException:<init>	()V
    //   248: athrow
    //   249: astore_0
    //   250: aload 10
    //   252: astore 9
    //   254: aload 9
    //   256: ifnull +8 -> 264
    //   259: aload 9
    //   261: invokevirtual 160	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: iload_1
    //   267: bipush 66
    //   269: if_icmpne +23 -> 292
    //   272: iload_2
    //   273: bipush 77
    //   275: if_icmpne +17 -> 292
    //   278: new 129	java/lang/StringBuilder
    //   281: dup
    //   282: ldc 162
    //   284: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: astore 9
    //   289: goto -105 -> 184
    //   292: iload_1
    //   293: sipush 137
    //   296: if_icmpne +23 -> 319
    //   299: iload_2
    //   300: bipush 80
    //   302: if_icmpne +17 -> 319
    //   305: new 129	java/lang/StringBuilder
    //   308: dup
    //   309: ldc 164
    //   311: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: astore 9
    //   316: goto -132 -> 184
    //   319: iload_1
    //   320: bipush 71
    //   322: if_icmpne +23 -> 345
    //   325: iload_2
    //   326: bipush 73
    //   328: if_icmpne +17 -> 345
    //   331: new 129	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 166
    //   337: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: astore 9
    //   342: goto -158 -> 184
    //   345: new 129	java/lang/StringBuilder
    //   348: dup
    //   349: ldc 168
    //   351: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: astore 9
    //   356: goto -172 -> 184
    //   359: iload_1
    //   360: sipush 30720
    //   363: if_icmpge +33 -> 396
    //   366: iload_1
    //   367: newarray byte
    //   369: astore 13
    //   371: aload 12
    //   373: iconst_0
    //   374: aload 13
    //   376: iconst_0
    //   377: iload_1
    //   378: invokestatic 174	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   381: aload 9
    //   383: aload 13
    //   385: iconst_2
    //   386: invokestatic 137	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   389: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: goto -174 -> 219
    //   396: aload 9
    //   398: aload 12
    //   400: iconst_2
    //   401: invokestatic 137	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   404: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: goto -189 -> 219
    //   411: aload 11
    //   413: ldc 37
    //   415: iconst_0
    //   416: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 11
    //   422: ldc 40
    //   424: aload 9
    //   426: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 11
    //   432: ldc 43
    //   434: aload_0
    //   435: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   438: pop
    //   439: aload 10
    //   441: ifnull -327 -> 114
    //   444: aload 10
    //   446: invokevirtual 160	java/io/InputStream:close	()V
    //   449: aload 11
    //   451: areturn
    //   452: iload 7
    //   454: iload_3
    //   455: idiv
    //   456: iload 8
    //   458: iload 4
    //   460: idiv
    //   461: invokestatic 183	java/lang/Math:max	(II)I
    //   464: istore_1
    //   465: aload 9
    //   467: iconst_0
    //   468: putfield 100	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   471: iload_1
    //   472: iload_1
    //   473: iconst_1
    //   474: iushr
    //   475: ior
    //   476: istore_1
    //   477: iload_1
    //   478: iload_1
    //   479: iconst_2
    //   480: iushr
    //   481: ior
    //   482: istore_1
    //   483: iload_1
    //   484: iload_1
    //   485: iconst_4
    //   486: iushr
    //   487: ior
    //   488: istore_1
    //   489: iload_1
    //   490: iload_1
    //   491: bipush 8
    //   493: iushr
    //   494: ior
    //   495: istore_1
    //   496: aload 9
    //   498: iload_1
    //   499: iload_1
    //   500: bipush 16
    //   502: iushr
    //   503: ior
    //   504: iconst_1
    //   505: iadd
    //   506: iconst_1
    //   507: iushr
    //   508: putfield 186	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   511: aload_0
    //   512: aload 9
    //   514: invokestatic 106	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   517: astore 12
    //   519: iload 7
    //   521: iload 4
    //   523: imul
    //   524: iload 8
    //   526: iload_3
    //   527: imul
    //   528: if_icmple +247 -> 775
    //   531: iload_3
    //   532: i2f
    //   533: aload 12
    //   535: invokevirtual 191	android/graphics/Bitmap:getWidth	()I
    //   538: i2f
    //   539: fdiv
    //   540: fstore 5
    //   542: new 193	android/graphics/Matrix
    //   545: dup
    //   546: invokespecial 194	android/graphics/Matrix:<init>	()V
    //   549: astore 10
    //   551: new 196	android/media/ExifInterface
    //   554: dup
    //   555: aload_0
    //   556: invokespecial 197	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   559: ldc 199
    //   561: iconst_1
    //   562: invokevirtual 203	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   565: tableswitch	default:+410 -> 975, 2:+225->790, 3:+256->821, 4:+277->842, 5:+290->855, 6:+312->877, 7:+333->898, 8:+355->920
    //   609: lconst_1
    //   610: fload 5
    //   612: fload 5
    //   614: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   617: aload 12
    //   619: iconst_0
    //   620: iconst_0
    //   621: aload 12
    //   623: invokevirtual 191	android/graphics/Bitmap:getWidth	()I
    //   626: aload 12
    //   628: invokevirtual 210	android/graphics/Bitmap:getHeight	()I
    //   631: aload 10
    //   633: iconst_1
    //   634: invokestatic 214	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   637: astore 10
    //   639: aload 12
    //   641: aload 10
    //   643: if_acmpeq +8 -> 651
    //   646: aload 12
    //   648: invokevirtual 217	android/graphics/Bitmap:recycle	()V
    //   651: new 219	java/io/ByteArrayOutputStream
    //   654: dup
    //   655: sipush 1024
    //   658: invokespecial 222	java/io/ByteArrayOutputStream:<init>	(I)V
    //   661: astore 12
    //   663: aload 9
    //   665: getfield 225	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   668: astore 9
    //   670: ldc 227
    //   672: aload 9
    //   674: invokevirtual 233	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   677: ifne +23 -> 700
    //   680: ldc 235
    //   682: aload 9
    //   684: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   687: ifne +13 -> 700
    //   690: ldc 241
    //   692: aload 9
    //   694: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   697: ifeq +244 -> 941
    //   700: new 129	java/lang/StringBuilder
    //   703: dup
    //   704: ldc 164
    //   706: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   709: astore 9
    //   711: aload 10
    //   713: getstatic 247	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   716: bipush 100
    //   718: aload 12
    //   720: invokevirtual 251	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   723: pop
    //   724: aload 10
    //   726: invokevirtual 217	android/graphics/Bitmap:recycle	()V
    //   729: aload 9
    //   731: aload 12
    //   733: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   736: iconst_2
    //   737: invokestatic 137	com/tencent/mobileqq/utils/Base64Util:a	([BI)Ljava/lang/String;
    //   740: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 11
    //   746: ldc 37
    //   748: iconst_0
    //   749: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   752: pop
    //   753: aload 11
    //   755: ldc 40
    //   757: aload 9
    //   759: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   762: pop
    //   763: aload 11
    //   765: ldc 43
    //   767: aload_0
    //   768: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   771: pop
    //   772: aload 11
    //   774: areturn
    //   775: iload 4
    //   777: i2f
    //   778: aload 12
    //   780: invokevirtual 210	android/graphics/Bitmap:getHeight	()I
    //   783: i2f
    //   784: fdiv
    //   785: fstore 5
    //   787: goto -245 -> 542
    //   790: fload 5
    //   792: fneg
    //   793: fstore 6
    //   795: aload 10
    //   797: fload 6
    //   799: fload 5
    //   801: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   804: goto -187 -> 617
    //   807: astore 13
    //   809: aload 10
    //   811: fload 5
    //   813: fload 5
    //   815: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   818: goto -201 -> 617
    //   821: aload 10
    //   823: fload 5
    //   825: fload 5
    //   827: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   830: aload 10
    //   832: ldc_w 256
    //   835: invokevirtual 260	android/graphics/Matrix:postRotate	(F)Z
    //   838: pop
    //   839: goto -222 -> 617
    //   842: aload 10
    //   844: fload 5
    //   846: fload 5
    //   848: fneg
    //   849: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   852: goto -235 -> 617
    //   855: aload 10
    //   857: fload 5
    //   859: fload 5
    //   861: fneg
    //   862: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   865: aload 10
    //   867: ldc_w 261
    //   870: invokevirtual 260	android/graphics/Matrix:postRotate	(F)Z
    //   873: pop
    //   874: goto -257 -> 617
    //   877: aload 10
    //   879: fload 5
    //   881: fload 5
    //   883: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   886: aload 10
    //   888: ldc_w 261
    //   891: invokevirtual 260	android/graphics/Matrix:postRotate	(F)Z
    //   894: pop
    //   895: goto -278 -> 617
    //   898: aload 10
    //   900: fload 5
    //   902: fneg
    //   903: fload 5
    //   905: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   908: aload 10
    //   910: ldc_w 261
    //   913: invokevirtual 260	android/graphics/Matrix:postRotate	(F)Z
    //   916: pop
    //   917: goto -300 -> 617
    //   920: aload 10
    //   922: fload 5
    //   924: fload 5
    //   926: invokevirtual 207	android/graphics/Matrix:setScale	(FF)V
    //   929: aload 10
    //   931: ldc_w 262
    //   934: invokevirtual 260	android/graphics/Matrix:postRotate	(F)Z
    //   937: pop
    //   938: goto -321 -> 617
    //   941: new 129	java/lang/StringBuilder
    //   944: dup
    //   945: ldc 131
    //   947: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   950: astore 9
    //   952: aload 10
    //   954: getstatic 265	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   957: bipush 80
    //   959: aload 12
    //   961: invokevirtual 251	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   964: pop
    //   965: goto -241 -> 724
    //   968: astore_0
    //   969: aconst_null
    //   970: astore 9
    //   972: goto -718 -> 254
    //   975: goto -367 -> 608
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	paramString	String
    //   0	978	1	paramInt1	int
    //   0	978	2	paramInt2	int
    //   0	978	3	paramInt3	int
    //   0	978	4	paramInt4	int
    //   540	385	5	f1	float
    //   793	5	6	f2	float
    //   66	458	7	n	int
    //   73	455	8	i1	int
    //   46	925	9	localObject1	Object
    //   17	936	10	localObject2	Object
    //   7	766	11	localJSONObject	JSONObject
    //   217	743	12	localObject3	Object
    //   369	15	13	arrayOfByte	byte[]
    //   807	1	13	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   141	159	249	finally
    //   173	184	249	finally
    //   184	219	249	finally
    //   219	227	249	finally
    //   232	249	249	finally
    //   278	289	249	finally
    //   305	316	249	finally
    //   331	342	249	finally
    //   345	356	249	finally
    //   366	393	249	finally
    //   396	408	249	finally
    //   411	439	249	finally
    //   551	608	807	java/io/IOException
    //   608	617	807	java/io/IOException
    //   795	804	807	java/io/IOException
    //   821	839	807	java/io/IOException
    //   842	852	807	java/io/IOException
    //   855	874	807	java/io/IOException
    //   877	895	807	java/io/IOException
    //   898	917	807	java/io/IOException
    //   920	938	807	java/io/IOException
    //   130	141	968	finally
  }
  
  private void a(String paramString)
  {
    int n = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if (paramString.equals(this.j))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = ActionSheet.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label283;
        }
        int i2 = ((JSONArray)localObject2).length();
        i1 = i2;
        if (n < i2)
        {
          ((ActionSheet)localObject1).c(((JSONArray)localObject2).getString(n));
          n += 1;
          continue;
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).d((CharSequence)localObject2);
        }
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).setOnCancelListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.k = localJSONObject.optString("onclick");
        this.d = i1;
        this.j = paramString;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label283:
      int i1 = 0;
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity == null) {
        return;
      }
      paramString = new JSONObject(paramString);
      int n = paramString.optInt("iconID");
      String str1 = paramString.optString("title");
      String str2 = paramString.optString("callback");
      String str3 = paramString.optString("color");
      boolean bool = paramString.optBoolean("hidden");
      if ((localActivity instanceof QQBrowserActivity))
      {
        ((QQBrowserActivity)localActivity).a(str2, str1, str3, bool, n);
        return;
      }
    }
    catch (JSONException paramString) {}
  }
  
  private void c(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mRuntime.a();
    } while (localObject == null);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("url");
        localJSONObject = localJSONObject.getJSONObject("options");
        if (localActivity.getClass().getSimpleName().equals("VASWebviewActivity"))
        {
          ((WebView)localObject).loadUrl(paramString);
          return;
        }
        if ((TextUtils.isEmpty(paramString)) || (localJSONObject == null) || (!localJSONObject.has("style"))) {
          break;
        }
        localObject = localActivity.getIntent().getExtras();
        ((Bundle)localObject).putString("leftViewText", "");
        switch (localJSONObject.optInt("style"))
        {
        case 0: 
          Intent localIntent = new Intent(localActivity, localActivity.getClass());
          localIntent.putExtras((Bundle)localObject);
          localIntent.putExtra("url", paramString);
          localIntent.setFlags(0);
          localActivity.startActivityForResult(localIntent, 100);
          switch (localJSONObject.optInt("animation"))
          {
          case 0: 
          case 1: 
            localActivity.overridePendingTransition(0, 0);
            return;
          }
          break;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      ((Bundle)localObject).putBoolean("hide_more_button", false);
      ((Bundle)localObject).putBoolean("hide_operation_bar", true);
      continue;
      ((Bundle)localObject).putBoolean("hide_more_button", true);
      ((Bundle)localObject).putBoolean("hide_operation_bar", true);
      continue;
      ((Bundle)localObject).putBoolean("hide_more_button", false);
      ((Bundle)localObject).putBoolean("hide_operation_bar", false);
      ((Bundle)localObject).putString("webStyle", "");
      continue;
      ((Bundle)localObject).putBoolean("hide_more_button", true);
      ((Bundle)localObject).putBoolean("hide_operation_bar", false);
      ((Bundle)localObject).putString("webStyle", "");
      continue;
      localActivity.overridePendingTransition(2130968681, 0);
      return;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.k)) {
      callJs(this.k, new String[] { "0", Integer.toString(paramInt) });
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Boolean = false;
      callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
    }
    do
    {
      for (;;)
      {
        return false;
        if (paramInt == 5)
        {
          this.jdField_a_of_type_Boolean = true;
          callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
        }
        else
        {
          if (paramInt != 14) {
            break;
          }
          this.i = null;
        }
      }
    } while (((paramInt != 12) && (paramInt != 13)) || (TextUtils.isEmpty(this.i)));
    callJs(this.i, new String[] { "" });
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = false;
    if ((!"ui".equals(paramString2)) || (("showTips".equals(paramString3)) && (paramVarArgs.length > 0))) {}
    try
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramString2 = paramString1.optString("text");
      switch (paramString1.optInt("type"))
      {
      case 0: 
        if (TextUtils.isEmpty(paramString2)) {
          break label1801;
        }
        QQToast.a(paramJsBridgeListener, paramString2, 0).b(paramJsBridgeListener.getResources().getDimensionPixelSize(2131427376));
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      break label1801;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramJsBridgeListener = QQToast.a(paramJsBridgeListener, 0, paramString2, 0).a(0);
      paramJsBridgeListener.setGravity(23, 0, 0);
      paramJsBridgeListener.show();
      break label1801;
      if ("showLoadingTips".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("text");
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            break label1801;
          }
          this.jdField_a_of_type_AndroidAppProgressDialog = Utils.a(this.mRuntime.a(), paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener) {}
      } else if (("hideLoadingTips".equals(paramString3)) && ((this.jdField_a_of_type_AndroidAppProgressDialog == null) || (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()))) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      this.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
    catch (Exception paramJsBridgeListener)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
    finally
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = null;
      throw paramJsBridgeListener;
      if (("openUrl".equals(paramString3)) && (paramVarArgs.length == 1)) {
        c(paramVarArgs[0]);
      } else if ("pageVisibility".equals(paramString3)) {
        paramJsBridgeListener.a(Boolean.valueOf(this.jdField_a_of_type_Boolean));
      } else if (("setActionButton".equals(paramString3)) && (paramVarArgs.length == 1)) {
        b(paramVarArgs[0]);
      } else if (("showActionSheet".equals(paramString3)) && (paramVarArgs.length == 1)) {
        a(paramVarArgs[0]);
      } else if ((!"scanQRcode".equals(paramString3)) || (paramVarArgs.length != 1)) {}
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.optString("name");
        this.l = paramString1.optString("callback");
        paramString1 = this.mRuntime.a().getUrl();
        paramString2 = new Intent(this.mRuntime.a(), ScannerActivity.class).putExtra("from", "web");
        if ((TextUtils.isEmpty(paramJsBridgeListener)) && (TextUtils.isEmpty(this.l)))
        {
          paramString2.putExtra("finishAfterSucc", true);
          this.mRuntime.a().startActivity(paramString2);
        }
        else
        {
          paramString2.putExtra("name", paramJsBridgeListener).putExtra("callback_url", paramString1).putExtra("scanForResult", true);
          startActivityForResult(paramString2, (byte)3);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        int n;
        break label1801;
      }
      if (("setOnCloseHandler".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        try
        {
          this.i = new JSONObject(paramVarArgs[0]).optString("callback");
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if (("setOnShareHandler".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          paramString1 = this.mRuntime.a();
          if (!(paramString1 instanceof QQBrowserActivity)) {
            break label1801;
          }
          ((QQBrowserActivity)paramString1).a().a(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if (("showDialog".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs[0]);
          paramString3 = this.mRuntime.a();
          if ((paramString3 == null) || (paramString3.isFinishing())) {
            break label1815;
          }
          paramJsBridgeListener = paramVarArgs.optString("title");
          Object localObject = paramVarArgs.optString("text");
          bool1 = paramVarArgs.optBoolean("needOkBtn", true);
          boolean bool2 = paramVarArgs.optBoolean("needCancelBtn", true);
          paramString1 = paramVarArgs.optString("okBtnText");
          paramString2 = paramVarArgs.optString("cancelBtnText");
          paramVarArgs = paramVarArgs.optString("callback");
          QQCustomDialog localQQCustomDialog = DialogUtil.a(paramString3, 0);
          localQQCustomDialog.setTitle(paramJsBridgeListener);
          localQQCustomDialog.setMessage((String)localObject);
          localObject = new fzw(this, paramVarArgs);
          if (bool2)
          {
            paramJsBridgeListener = paramString2;
            if (TextUtils.isEmpty(paramString2)) {
              paramJsBridgeListener = paramString3.getString(2131561746);
            }
            localQQCustomDialog.setNegativeButton(paramJsBridgeListener, (DialogInterface.OnClickListener)localObject);
          }
          if (bool1)
          {
            paramJsBridgeListener = paramString1;
            if (TextUtils.isEmpty(paramString1)) {
              paramJsBridgeListener = paramString3.getString(2131562539);
            }
            localQQCustomDialog.setPositiveButton(paramJsBridgeListener, (DialogInterface.OnClickListener)localObject);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            localQQCustomDialog.setOnCancelListener(new fzx(this, paramVarArgs));
          }
          try
          {
            localQQCustomDialog.show();
          }
          catch (Exception paramJsBridgeListener) {}
          if (!"openView".equals(paramString3)) {
            break label1801;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if (paramVarArgs.length == 1)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          if (paramJsBridgeListener != null)
          {
            paramString1 = this.mRuntime.a();
            paramString2 = paramJsBridgeListener.optString("name");
            paramString3 = paramJsBridgeListener.optString("options");
            paramVarArgs = paramJsBridgeListener.optString("onclose");
            n = paramJsBridgeListener.optInt("animation", -1);
            paramJsBridgeListener = new Intent();
            paramJsBridgeListener.setComponent(new ComponentName(paramString1, paramString2));
            paramJsBridgeListener.putExtra("options", paramString3);
            if (TextUtils.isEmpty(paramVarArgs))
            {
              paramString1.startActivity(paramJsBridgeListener);
              switch (n)
              {
              default: 
                if (!PoiMapActivity.class.getName().equals(paramString2)) {
                  break label1801;
                }
                this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c();
              }
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener = null;
            continue;
            this.m = paramVarArgs;
            startActivityForResult(paramJsBridgeListener, (byte)4);
            continue;
            paramString1.overridePendingTransition(2130968591, 2130968589);
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "UiApiPlugin openView error, json is NULL-----");
          break label1801;
          if (!"media".equals(paramString2)) {
            break label1804;
          }
          if (("getPicture".equals(paramString3)) && (paramVarArgs.length == 1)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramString2 = paramString1.optString("callback");
              if (TextUtils.isEmpty(paramString2)) {
                return true;
              }
              n = paramString1.optInt("source", 0);
              paramJsBridgeListener = BaseApplicationImpl.getContext();
              if (n == 0)
              {
                paramString3 = this.mRuntime.a();
                if ((paramString3 instanceof QQBrowserActivity))
                {
                  paramString2 = new Intent();
                  paramString2.setClass(paramString3, PhotoListActivity.class);
                  paramString2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString3.getClass().getName());
                  paramString2.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
                  paramString2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramString1.optInt("max", 1));
                  ((QQBrowserActivity)paramString3).a(this, paramString2, (byte)2);
                  PreferenceManager.getDefaultSharedPreferences(paramJsBridgeListener).edit().putString("getPictureParam", paramVarArgs[0]).commit();
                  break label1817;
                }
                callJs(paramString2, new String[] { "2", "[]" });
                return true;
              }
              if (n != 1) {
                break label1817;
              }
              paramString3 = new File(AppConstants.an + "photo/");
              if ((!paramString3.exists()) && (!paramString3.mkdirs()))
              {
                QQToast.a(paramJsBridgeListener, 2131562496, 0).a();
                callJs(paramString2, new String[] { "2", "[]" });
                return true;
              }
              paramString2 = AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg";
              paramString3 = new Intent();
              FileProvider7Helper.setSystemCapture(this.mRuntime.a(), new File(paramString2), paramString3);
              if (paramString1.optBoolean("front", false)) {
                paramString3.putExtra("android.intent.extras.CAMERA_FACING", 1);
              }
              try
              {
                startActivityForResult(paramString3, (byte)1);
                PreferenceManager.getDefaultSharedPreferences(paramJsBridgeListener).edit().putString("camera_photo_path", paramString2).putString("getPictureParam", paramVarArgs[0]).commit();
              }
              catch (Exception paramString1)
              {
                paramString1.printStackTrace();
                QQToast.a(paramJsBridgeListener, 2131561740, 0).a();
              }
              if (!"getLocalImage".equals(paramString3)) {
                break label1817;
              }
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          if (paramVarArgs.length != 1) {
            break label1817;
          }
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("callback");
            paramString2 = paramJsBridgeListener.optString("imageID");
            if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
              break label1819;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
            {
              paramString3 = this.mRuntime.a();
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramString3, paramString3.getResources().getDimensionPixelSize(2131427376));
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562663);
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this);
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            }
            new fzz(this, paramString1, paramJsBridgeListener.optInt("outMaxWidth", 1280), paramJsBridgeListener.optInt("outMaxHeight", 1280), paramJsBridgeListener.optInt("inMinWidth", 1), paramJsBridgeListener.optInt("inMinHeight", 1), paramString2).start();
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      label1801:
      bool1 = true;
    }
    label1804:
    return bool1;
    label1815:
    return true;
    label1817:
    return true;
    label1819:
    return true;
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 833	com/tencent/mobileqq/webviewplugin/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpeq +8 -> 17
    //   12: iload_2
    //   13: iconst_2
    //   14: if_icmpne +527 -> 541
    //   17: invokestatic 709	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   20: astore 6
    //   22: aload 6
    //   24: invokestatic 736	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   27: astore 7
    //   29: aload 7
    //   31: ldc_w 793
    //   34: ldc_w 424
    //   37: invokeinterface 836 3 0
    //   42: astore 8
    //   44: aload 7
    //   46: ldc 23
    //   48: ldc_w 424
    //   51: invokeinterface 836 3 0
    //   56: astore 7
    //   58: aload 6
    //   60: invokestatic 736	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   63: invokeinterface 742 1 0
    //   68: ldc_w 793
    //   71: invokeinterface 840 2 0
    //   76: ldc 23
    //   78: invokeinterface 840 2 0
    //   83: invokeinterface 750 1 0
    //   88: pop
    //   89: aload 7
    //   91: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +4 -> 98
    //   97: return
    //   98: new 81	org/json/JSONObject
    //   101: dup
    //   102: aload 7
    //   104: invokespecial 298	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 31
    //   113: invokevirtual 842	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: istore 5
    //   125: iload 5
    //   127: ifne -30 -> 97
    //   130: iload_3
    //   131: iconst_m1
    //   132: if_icmpne +386 -> 518
    //   135: iload_2
    //   136: iconst_1
    //   137: if_icmpne +111 -> 248
    //   140: iconst_1
    //   141: anewarray 229	java/lang/String
    //   144: astore_1
    //   145: aload_1
    //   146: iconst_0
    //   147: aload 8
    //   149: aastore
    //   150: aload 7
    //   152: ldc_w 844
    //   155: iconst_0
    //   156: invokevirtual 626	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   159: ifeq +207 -> 366
    //   162: new 318	org/json/JSONArray
    //   165: dup
    //   166: invokespecial 845	org/json/JSONArray:<init>	()V
    //   169: astore 7
    //   171: aload_1
    //   172: arraylength
    //   173: istore 4
    //   175: iconst_0
    //   176: istore_3
    //   177: iload_3
    //   178: iload 4
    //   180: if_icmpge +137 -> 317
    //   183: aload_1
    //   184: iload_3
    //   185: aaload
    //   186: astore 8
    //   188: new 81	org/json/JSONObject
    //   191: dup
    //   192: invokespecial 82	org/json/JSONObject:<init>	()V
    //   195: astore 9
    //   197: aload 9
    //   199: ldc 40
    //   201: ldc_w 424
    //   204: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 9
    //   210: ldc 43
    //   212: aload 8
    //   214: invokevirtual 177	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 9
    //   220: ldc 37
    //   222: iconst_0
    //   223: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 7
    //   229: aload 9
    //   231: invokevirtual 848	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   234: pop
    //   235: iload_3
    //   236: iconst_1
    //   237: iadd
    //   238: istore_3
    //   239: goto -62 -> 177
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 608	org/json/JSONException:printStackTrace	()V
    //   247: return
    //   248: aload_1
    //   249: ifnull +45 -> 294
    //   252: aload_1
    //   253: ldc_w 850
    //   256: invokevirtual 854	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +10 -> 271
    //   264: aload_1
    //   265: invokevirtual 859	java/util/ArrayList:size	()I
    //   268: ifne +31 -> 299
    //   271: aload_0
    //   272: aload 6
    //   274: iconst_2
    //   275: anewarray 229	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 752
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: ldc_w 754
    //   289: aastore
    //   290: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   293: return
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -36 -> 260
    //   299: aload_1
    //   300: aload_1
    //   301: invokevirtual 859	java/util/ArrayList:size	()I
    //   304: anewarray 229	java/lang/String
    //   307: invokevirtual 863	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   310: checkcast 865	[Ljava/lang/String;
    //   313: astore_1
    //   314: goto -164 -> 150
    //   317: aload_0
    //   318: aload 6
    //   320: iconst_2
    //   321: anewarray 229	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 470
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload 7
    //   334: invokevirtual 866	org/json/JSONArray:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   341: return
    //   342: astore_1
    //   343: aload_0
    //   344: aload 6
    //   346: iconst_2
    //   347: anewarray 229	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: ldc_w 752
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: ldc_w 754
    //   361: aastore
    //   362: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   365: return
    //   366: aload_0
    //   367: getfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   370: ifnonnull +54 -> 424
    //   373: aload_0
    //   374: getfield 292	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   377: invokevirtual 297	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   380: astore 8
    //   382: aload_0
    //   383: new 801	com/tencent/mobileqq/widget/QQProgressDialog
    //   386: dup
    //   387: aload 8
    //   389: aload 8
    //   391: invokevirtual 802	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   394: ldc_w 515
    //   397: invokevirtual 521	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   400: invokespecial 805	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   403: putfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   406: aload_0
    //   407: getfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   410: ldc_w 806
    //   413: invokevirtual 808	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   416: aload_0
    //   417: getfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   420: aload_0
    //   421: invokevirtual 811	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   424: aload_0
    //   425: getfield 480	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   428: ifnull +10 -> 438
    //   431: aload_0
    //   432: getfield 480	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   435: invokevirtual 483	java/lang/Thread:interrupt	()V
    //   438: aload_0
    //   439: getfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   442: invokevirtual 812	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifne +10 -> 455
    //   448: aload_0
    //   449: getfield 799	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   452: invokevirtual 813	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   455: aload_0
    //   456: new 868	fzy
    //   459: dup
    //   460: aload_0
    //   461: aload 6
    //   463: aload 7
    //   465: ldc_w 817
    //   468: sipush 1280
    //   471: invokevirtual 672	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   474: aload 7
    //   476: ldc_w 819
    //   479: sipush 1280
    //   482: invokevirtual 672	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   485: aload 7
    //   487: ldc_w 821
    //   490: iconst_1
    //   491: invokevirtual 672	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   494: aload 7
    //   496: ldc_w 823
    //   499: iconst_1
    //   500: invokevirtual 672	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   503: aload_1
    //   504: invokespecial 871	fzy:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;IIII[Ljava/lang/String;)V
    //   507: putfield 480	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   510: aload_0
    //   511: getfield 480	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   514: invokevirtual 872	java/lang/Thread:start	()V
    //   517: return
    //   518: aload_0
    //   519: aload 6
    //   521: iconst_2
    //   522: anewarray 229	java/lang/String
    //   525: dup
    //   526: iconst_0
    //   527: ldc_w 874
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: ldc_w 754
    //   536: aastore
    //   537: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   540: return
    //   541: iload_2
    //   542: iconst_3
    //   543: if_icmpne +207 -> 750
    //   546: aload_1
    //   547: ifnull -450 -> 97
    //   550: aload_1
    //   551: ldc_w 876
    //   554: invokevirtual 879	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   557: astore 6
    //   559: aload_0
    //   560: getfield 580	com/tencent/mobileqq/jsp/UiApiPlugin:l	Ljava/lang/String;
    //   563: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   566: ifeq +145 -> 711
    //   569: aload_1
    //   570: ldc 34
    //   572: invokevirtual 879	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   575: astore 8
    //   577: aload_1
    //   578: ldc 27
    //   580: invokevirtual 879	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 7
    //   585: aload 8
    //   587: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   590: ifne -493 -> 97
    //   593: aload 7
    //   595: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   598: ifne -501 -> 97
    //   601: aload 8
    //   603: ldc_w 881
    //   606: invokevirtual 885	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   609: astore 8
    //   611: new 129	java/lang/StringBuilder
    //   614: dup
    //   615: aload 8
    //   617: iconst_0
    //   618: aaload
    //   619: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   622: astore 9
    //   624: aload 8
    //   626: iconst_0
    //   627: aaload
    //   628: ldc_w 887
    //   631: invokevirtual 890	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   634: ifeq +70 -> 704
    //   637: ldc_w 892
    //   640: astore_1
    //   641: aload 9
    //   643: aload_1
    //   644: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload 7
    //   649: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: ldc_w 894
    //   655: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 6
    //   660: invokestatic 899	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: astore_1
    //   667: aload 8
    //   669: arraylength
    //   670: iconst_1
    //   671: if_icmple +18 -> 689
    //   674: aload_1
    //   675: ldc_w 881
    //   678: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 8
    //   683: iconst_1
    //   684: aaload
    //   685: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload_0
    //   690: getfield 292	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   693: invokevirtual 382	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/smtt/sdk/WebView;
    //   696: aload_1
    //   697: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokevirtual 403	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   703: return
    //   704: ldc_w 887
    //   707: astore_1
    //   708: goto -67 -> 641
    //   711: aload_0
    //   712: getfield 580	com/tencent/mobileqq/jsp/UiApiPlugin:l	Ljava/lang/String;
    //   715: astore 7
    //   717: aload 6
    //   719: ifnonnull +22 -> 741
    //   722: ldc_w 901
    //   725: astore_1
    //   726: aload_0
    //   727: aload 7
    //   729: iconst_1
    //   730: anewarray 229	java/lang/String
    //   733: dup
    //   734: iconst_0
    //   735: aload_1
    //   736: aastore
    //   737: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   740: return
    //   741: aload 6
    //   743: invokestatic 905	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   746: astore_1
    //   747: goto -21 -> 726
    //   750: iload_2
    //   751: iconst_4
    //   752: if_icmpne -655 -> 97
    //   755: aload_0
    //   756: getfield 693	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   759: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   762: ifne -665 -> 97
    //   765: iload_3
    //   766: iconst_m1
    //   767: if_icmpne +66 -> 833
    //   770: aload_1
    //   771: ifnonnull +51 -> 822
    //   774: ldc_w 424
    //   777: astore_1
    //   778: new 129	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 907
    //   788: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: aload_1
    //   792: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 909
    //   798: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: astore_1
    //   805: aload_0
    //   806: aload_0
    //   807: getfield 693	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   810: iconst_1
    //   811: anewarray 229	java/lang/String
    //   814: dup
    //   815: iconst_0
    //   816: aload_1
    //   817: aastore
    //   818: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   821: return
    //   822: aload_1
    //   823: ldc_w 911
    //   826: invokevirtual 879	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   829: astore_1
    //   830: goto -52 -> 778
    //   833: iload_3
    //   834: ifne -737 -> 97
    //   837: aload_0
    //   838: aload_0
    //   839: getfield 693	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   842: iconst_1
    //   843: anewarray 229	java/lang/String
    //   846: dup
    //   847: iconst_0
    //   848: ldc_w 913
    //   851: aastore
    //   852: invokevirtual 478	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   855: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	856	0	this	UiApiPlugin
    //   0	856	1	paramIntent	Intent
    //   0	856	2	paramByte	byte
    //   0	856	3	paramInt	int
    //   173	8	4	n	int
    //   123	3	5	bool	boolean
    //   20	722	6	localObject1	Object
    //   27	701	7	localObject2	Object
    //   42	640	8	localObject3	Object
    //   195	447	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   98	125	242	org/json/JSONException
    //   162	175	342	org/json/JSONException
    //   188	235	342	org/json/JSONException
    //   317	341	342	org/json/JSONException
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.k)) {
      callJs(this.k, new String[] { "1", Integer.toString(this.d) });
    }
  }
  
  protected void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.k)) {
      callJs(this.k, new String[] { "1", Integer.toString(this.d) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */