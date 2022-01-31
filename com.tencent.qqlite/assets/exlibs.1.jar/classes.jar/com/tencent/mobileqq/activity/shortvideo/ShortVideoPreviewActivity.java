package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import coa;
import cob;
import coc;
import cod;
import coe;
import cof;
import cog;
import coh;
import coi;
import coj;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "preview_only";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "ShortVideoPreviewActivity";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 3;
  private static final String jdField_i_of_type_JavaLangString = "state_play_position";
  private static final String jdField_j_of_type_JavaLangString = "state_play_state";
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new coa(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new cod(this);
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private int jdField_j_of_type_Int;
  private int p = 0;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: iconst_2
    //   13: istore_1
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 89	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokestatic 94	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +55 -> 79
    //   27: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 22
    //   35: iconst_2
    //   36: ldc 102
    //   38: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 107	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 107	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 107	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload_1
    //   78: ireturn
    //   79: aload_2
    //   80: invokestatic 111	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   83: astore 8
    //   85: aload 8
    //   87: ifnonnull +56 -> 143
    //   90: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +11 -> 104
    //   96: ldc 22
    //   98: iconst_2
    //   99: ldc 113
    //   101: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 107	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: iconst_0
    //   117: ifeq +11 -> 128
    //   120: new 107	java/lang/NullPointerException
    //   123: dup
    //   124: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   127: athrow
    //   128: iconst_0
    //   129: ifeq -52 -> 77
    //   132: new 107	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: astore_2
    //   141: iconst_2
    //   142: ireturn
    //   143: aload_0
    //   144: aload 8
    //   146: invokevirtual 118	android/graphics/Bitmap:getWidth	()I
    //   149: putfield 120	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:i	I
    //   152: aload_0
    //   153: aload 8
    //   155: invokevirtual 123	android/graphics/Bitmap:getHeight	()I
    //   158: putfield 125	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:j	I
    //   161: new 127	java/io/File
    //   164: dup
    //   165: aload_0
    //   166: getfield 89	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   169: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_0
    //   174: aload_2
    //   175: invokevirtual 134	java/io/File:length	()J
    //   178: putfield 136	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_a_of_type_Long	J
    //   181: new 138	java/io/FileInputStream
    //   184: dup
    //   185: aload_2
    //   186: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: astore_3
    //   190: aload_0
    //   191: aload_3
    //   192: aload_0
    //   193: getfield 136	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_a_of_type_Long	J
    //   196: invokestatic 147	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   199: invokestatic 153	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   202: putfield 155	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 155	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   209: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +71 -> 283
    //   215: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +31 -> 249
    //   221: ldc 22
    //   223: iconst_2
    //   224: new 163	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   231: ldc 166
    //   233: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 155	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   240: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_3
    //   250: ifnull +7 -> 257
    //   253: aload_3
    //   254: invokevirtual 177	java/io/FileInputStream:close	()V
    //   257: iconst_0
    //   258: ifeq +11 -> 269
    //   261: new 107	java/lang/NullPointerException
    //   264: dup
    //   265: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   268: athrow
    //   269: iconst_0
    //   270: ifeq +11 -> 281
    //   273: new 107	java/lang/NullPointerException
    //   276: dup
    //   277: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   280: athrow
    //   281: iconst_5
    //   282: ireturn
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 155	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   288: ldc 179
    //   290: invokestatic 182	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   293: putfield 184	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:g	Ljava/lang/String;
    //   296: new 163	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   303: invokestatic 186	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   306: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 188
    //   311: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 192	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   320: new 127	java/io/File
    //   323: dup
    //   324: aload_0
    //   325: getfield 184	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:g	Ljava/lang/String;
    //   328: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   331: astore 9
    //   333: new 127	java/io/File
    //   336: dup
    //   337: aload 9
    //   339: invokevirtual 195	java/io/File:getParent	()Ljava/lang/String;
    //   342: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   345: astore_2
    //   346: aload_2
    //   347: invokevirtual 198	java/io/File:exists	()Z
    //   350: ifeq +10 -> 360
    //   353: aload_2
    //   354: invokevirtual 201	java/io/File:isDirectory	()Z
    //   357: ifne +8 -> 365
    //   360: aload_2
    //   361: invokevirtual 204	java/io/File:mkdirs	()Z
    //   364: pop
    //   365: aload 9
    //   367: invokevirtual 198	java/io/File:exists	()Z
    //   370: ifeq +11 -> 381
    //   373: aload 9
    //   375: invokevirtual 207	java/io/File:isFile	()Z
    //   378: ifne +9 -> 387
    //   381: aload 9
    //   383: invokevirtual 210	java/io/File:createNewFile	()Z
    //   386: pop
    //   387: new 212	java/io/FileOutputStream
    //   390: dup
    //   391: aload 9
    //   393: invokespecial 213	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   396: astore_2
    //   397: aload 8
    //   399: getstatic 219	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   402: bipush 50
    //   404: aload_2
    //   405: invokevirtual 223	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   408: pop
    //   409: aload_2
    //   410: invokevirtual 226	java/io/FileOutputStream:flush	()V
    //   413: new 138	java/io/FileInputStream
    //   416: dup
    //   417: aload 9
    //   419: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   422: astore 4
    //   424: aload_0
    //   425: aload 4
    //   427: aload 9
    //   429: invokevirtual 134	java/io/File:length	()J
    //   432: invokestatic 147	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   435: invokestatic 153	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   438: putfield 228	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   441: aload_0
    //   442: getfield 228	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   445: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +65 -> 513
    //   451: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +31 -> 485
    //   457: ldc 22
    //   459: iconst_2
    //   460: new 163	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   467: ldc 230
    //   469: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: getfield 228	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   476: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_3
    //   486: ifnull +7 -> 493
    //   489: aload_3
    //   490: invokevirtual 177	java/io/FileInputStream:close	()V
    //   493: aload_2
    //   494: ifnull +7 -> 501
    //   497: aload_2
    //   498: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   501: aload 4
    //   503: ifnull +8 -> 511
    //   506: aload 4
    //   508: invokevirtual 177	java/io/FileInputStream:close	()V
    //   511: iconst_5
    //   512: ireturn
    //   513: aload_0
    //   514: getfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_b_of_type_Long	J
    //   517: lconst_0
    //   518: lcmp
    //   519: ifne +14 -> 533
    //   522: aload_0
    //   523: aload_0
    //   524: getfield 89	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   527: invokestatic 236	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   530: putfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_b_of_type_Long	J
    //   533: aload_3
    //   534: ifnull +7 -> 541
    //   537: aload_3
    //   538: invokevirtual 177	java/io/FileInputStream:close	()V
    //   541: aload_2
    //   542: ifnull +7 -> 549
    //   545: aload_2
    //   546: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   549: aload 4
    //   551: ifnull +8 -> 559
    //   554: aload 4
    //   556: invokevirtual 177	java/io/FileInputStream:close	()V
    //   559: iconst_1
    //   560: ireturn
    //   561: astore 4
    //   563: aconst_null
    //   564: astore_2
    //   565: aconst_null
    //   566: astore_3
    //   567: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +13 -> 583
    //   573: ldc 22
    //   575: iconst_2
    //   576: ldc 238
    //   578: aload 4
    //   580: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   583: iconst_3
    //   584: istore_1
    //   585: aload_3
    //   586: ifnull +7 -> 593
    //   589: aload_3
    //   590: invokevirtual 177	java/io/FileInputStream:close	()V
    //   593: aload_2
    //   594: ifnull +7 -> 601
    //   597: aload_2
    //   598: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   601: aload 5
    //   603: ifnull -526 -> 77
    //   606: aload 5
    //   608: invokevirtual 177	java/io/FileInputStream:close	()V
    //   611: iconst_3
    //   612: ireturn
    //   613: astore_2
    //   614: iconst_3
    //   615: ireturn
    //   616: astore 5
    //   618: aconst_null
    //   619: astore_2
    //   620: aconst_null
    //   621: astore 8
    //   623: aload 6
    //   625: astore 7
    //   627: aload_2
    //   628: astore 4
    //   630: aload 8
    //   632: astore_3
    //   633: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +23 -> 659
    //   639: aload 6
    //   641: astore 7
    //   643: aload_2
    //   644: astore 4
    //   646: aload 8
    //   648: astore_3
    //   649: ldc 22
    //   651: iconst_2
    //   652: ldc 238
    //   654: aload 5
    //   656: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   659: aload 8
    //   661: ifnull +8 -> 669
    //   664: aload 8
    //   666: invokevirtual 177	java/io/FileInputStream:close	()V
    //   669: aload 6
    //   671: ifnull +8 -> 679
    //   674: aload 6
    //   676: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   679: aload_2
    //   680: ifnull +7 -> 687
    //   683: aload_2
    //   684: invokevirtual 177	java/io/FileInputStream:close	()V
    //   687: iconst_5
    //   688: ireturn
    //   689: astore 5
    //   691: aconst_null
    //   692: astore_2
    //   693: aconst_null
    //   694: astore 8
    //   696: aload 4
    //   698: astore 6
    //   700: aload 6
    //   702: astore 7
    //   704: aload_2
    //   705: astore 4
    //   707: aload 8
    //   709: astore_3
    //   710: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +23 -> 736
    //   716: aload 6
    //   718: astore 7
    //   720: aload_2
    //   721: astore 4
    //   723: aload 8
    //   725: astore_3
    //   726: ldc 22
    //   728: iconst_2
    //   729: ldc 243
    //   731: aload 5
    //   733: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: iconst_4
    //   737: istore_1
    //   738: aload 8
    //   740: ifnull +8 -> 748
    //   743: aload 8
    //   745: invokevirtual 177	java/io/FileInputStream:close	()V
    //   748: aload 6
    //   750: ifnull +8 -> 758
    //   753: aload 6
    //   755: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   758: aload_2
    //   759: ifnull -682 -> 77
    //   762: aload_2
    //   763: invokevirtual 177	java/io/FileInputStream:close	()V
    //   766: iconst_4
    //   767: ireturn
    //   768: astore_2
    //   769: iconst_4
    //   770: ireturn
    //   771: astore_2
    //   772: aconst_null
    //   773: astore 4
    //   775: aconst_null
    //   776: astore_3
    //   777: aload 7
    //   779: astore 5
    //   781: aload_3
    //   782: ifnull +7 -> 789
    //   785: aload_3
    //   786: invokevirtual 177	java/io/FileInputStream:close	()V
    //   789: aload 5
    //   791: ifnull +8 -> 799
    //   794: aload 5
    //   796: invokevirtual 231	java/io/FileOutputStream:close	()V
    //   799: aload 4
    //   801: ifnull +8 -> 809
    //   804: aload 4
    //   806: invokevirtual 177	java/io/FileInputStream:close	()V
    //   809: aload_2
    //   810: athrow
    //   811: astore_2
    //   812: goto -759 -> 53
    //   815: astore_2
    //   816: goto -751 -> 65
    //   819: astore_2
    //   820: iconst_2
    //   821: ireturn
    //   822: astore_2
    //   823: goto -707 -> 116
    //   826: astore_2
    //   827: goto -699 -> 128
    //   830: astore_2
    //   831: goto -574 -> 257
    //   834: astore_2
    //   835: goto -566 -> 269
    //   838: astore_2
    //   839: goto -558 -> 281
    //   842: astore_3
    //   843: goto -350 -> 493
    //   846: astore_2
    //   847: goto -346 -> 501
    //   850: astore_2
    //   851: goto -340 -> 511
    //   854: astore_3
    //   855: goto -314 -> 541
    //   858: astore_2
    //   859: goto -310 -> 549
    //   862: astore_2
    //   863: goto -304 -> 559
    //   866: astore_3
    //   867: goto -274 -> 593
    //   870: astore_2
    //   871: goto -270 -> 601
    //   874: astore_3
    //   875: goto -206 -> 669
    //   878: astore_3
    //   879: goto -200 -> 679
    //   882: astore_2
    //   883: goto -196 -> 687
    //   886: astore_3
    //   887: goto -139 -> 748
    //   890: astore_3
    //   891: goto -133 -> 758
    //   894: astore_3
    //   895: goto -106 -> 789
    //   898: astore_3
    //   899: goto -100 -> 799
    //   902: astore_3
    //   903: goto -94 -> 809
    //   906: astore_2
    //   907: aconst_null
    //   908: astore 4
    //   910: aload 7
    //   912: astore 5
    //   914: goto -133 -> 781
    //   917: astore 6
    //   919: aconst_null
    //   920: astore 4
    //   922: aload_2
    //   923: astore 5
    //   925: aload 6
    //   927: astore_2
    //   928: goto -147 -> 781
    //   931: astore 6
    //   933: aload_2
    //   934: astore 5
    //   936: aload 6
    //   938: astore_2
    //   939: goto -158 -> 781
    //   942: astore 6
    //   944: aload 5
    //   946: astore 4
    //   948: aload_2
    //   949: astore 5
    //   951: aload 6
    //   953: astore_2
    //   954: goto -173 -> 781
    //   957: astore_2
    //   958: aload 7
    //   960: astore 5
    //   962: goto -181 -> 781
    //   965: astore 5
    //   967: aconst_null
    //   968: astore_2
    //   969: aload 4
    //   971: astore 6
    //   973: aload_3
    //   974: astore 8
    //   976: goto -276 -> 700
    //   979: astore 5
    //   981: aconst_null
    //   982: astore 4
    //   984: aload_2
    //   985: astore 6
    //   987: aload 4
    //   989: astore_2
    //   990: aload_3
    //   991: astore 8
    //   993: goto -293 -> 700
    //   996: astore 5
    //   998: aload_2
    //   999: astore 6
    //   1001: aload 4
    //   1003: astore_2
    //   1004: aload_3
    //   1005: astore 8
    //   1007: goto -307 -> 700
    //   1010: astore 5
    //   1012: aconst_null
    //   1013: astore_2
    //   1014: aload_3
    //   1015: astore 8
    //   1017: goto -394 -> 623
    //   1020: astore 5
    //   1022: aconst_null
    //   1023: astore 4
    //   1025: aload_2
    //   1026: astore 6
    //   1028: aload 4
    //   1030: astore_2
    //   1031: aload_3
    //   1032: astore 8
    //   1034: goto -411 -> 623
    //   1037: astore 5
    //   1039: aload_2
    //   1040: astore 6
    //   1042: aload 4
    //   1044: astore_2
    //   1045: aload_3
    //   1046: astore 8
    //   1048: goto -425 -> 623
    //   1051: astore 4
    //   1053: aconst_null
    //   1054: astore_2
    //   1055: goto -488 -> 567
    //   1058: astore 4
    //   1060: goto -493 -> 567
    //   1063: astore 6
    //   1065: aload 4
    //   1067: astore 5
    //   1069: aload 6
    //   1071: astore 4
    //   1073: goto -506 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1076	0	this	ShortVideoPreviewActivity
    //   13	725	1	i1	int
    //   22	58	2	localBitmap	Bitmap
    //   140	1	2	localIOException1	java.io.IOException
    //   172	426	2	localObject1	Object
    //   613	1	2	localIOException2	java.io.IOException
    //   619	144	2	localObject2	Object
    //   768	1	2	localIOException3	java.io.IOException
    //   771	39	2	localObject3	Object
    //   811	1	2	localIOException4	java.io.IOException
    //   815	1	2	localIOException5	java.io.IOException
    //   819	1	2	localIOException6	java.io.IOException
    //   822	1	2	localIOException7	java.io.IOException
    //   826	1	2	localIOException8	java.io.IOException
    //   830	1	2	localIOException9	java.io.IOException
    //   834	1	2	localIOException10	java.io.IOException
    //   838	1	2	localIOException11	java.io.IOException
    //   846	1	2	localIOException12	java.io.IOException
    //   850	1	2	localIOException13	java.io.IOException
    //   858	1	2	localIOException14	java.io.IOException
    //   862	1	2	localIOException15	java.io.IOException
    //   870	1	2	localIOException16	java.io.IOException
    //   882	1	2	localIOException17	java.io.IOException
    //   906	17	2	localObject4	Object
    //   927	27	2	localObject5	Object
    //   957	1	2	localObject6	Object
    //   968	87	2	localObject7	Object
    //   189	597	3	localObject8	Object
    //   842	1	3	localIOException18	java.io.IOException
    //   854	1	3	localIOException19	java.io.IOException
    //   866	1	3	localIOException20	java.io.IOException
    //   874	1	3	localIOException21	java.io.IOException
    //   878	1	3	localIOException22	java.io.IOException
    //   886	1	3	localIOException23	java.io.IOException
    //   890	1	3	localIOException24	java.io.IOException
    //   894	1	3	localIOException25	java.io.IOException
    //   898	1	3	localIOException26	java.io.IOException
    //   902	144	3	localIOException27	java.io.IOException
    //   4	551	4	localFileInputStream	java.io.FileInputStream
    //   561	18	4	localIOException28	java.io.IOException
    //   628	415	4	localObject9	Object
    //   1051	1	4	localIOException29	java.io.IOException
    //   1058	8	4	localIOException30	java.io.IOException
    //   1071	1	4	localIOException31	java.io.IOException
    //   10	597	5	localObject10	Object
    //   616	39	5	localException1	Exception
    //   689	43	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   779	182	5	localObject11	Object
    //   965	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   979	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   996	1	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1010	1	5	localException2	Exception
    //   1020	1	5	localException3	Exception
    //   1037	1	5	localException4	Exception
    //   1067	1	5	localIOException32	java.io.IOException
    //   1	753	6	localObject12	Object
    //   917	9	6	localObject13	Object
    //   931	6	6	localObject14	Object
    //   942	10	6	localObject15	Object
    //   971	70	6	localObject16	Object
    //   1063	7	6	localIOException33	java.io.IOException
    //   7	952	7	localObject17	Object
    //   83	964	8	localObject18	Object
    //   331	97	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   132	140	140	java/io/IOException
    //   14	23	561	java/io/IOException
    //   27	41	561	java/io/IOException
    //   79	85	561	java/io/IOException
    //   90	104	561	java/io/IOException
    //   143	190	561	java/io/IOException
    //   606	611	613	java/io/IOException
    //   14	23	616	java/lang/Exception
    //   27	41	616	java/lang/Exception
    //   79	85	616	java/lang/Exception
    //   90	104	616	java/lang/Exception
    //   143	190	616	java/lang/Exception
    //   14	23	689	java/lang/OutOfMemoryError
    //   27	41	689	java/lang/OutOfMemoryError
    //   79	85	689	java/lang/OutOfMemoryError
    //   90	104	689	java/lang/OutOfMemoryError
    //   143	190	689	java/lang/OutOfMemoryError
    //   762	766	768	java/io/IOException
    //   14	23	771	finally
    //   27	41	771	finally
    //   79	85	771	finally
    //   90	104	771	finally
    //   143	190	771	finally
    //   45	53	811	java/io/IOException
    //   57	65	815	java/io/IOException
    //   69	77	819	java/io/IOException
    //   108	116	822	java/io/IOException
    //   120	128	826	java/io/IOException
    //   253	257	830	java/io/IOException
    //   261	269	834	java/io/IOException
    //   273	281	838	java/io/IOException
    //   489	493	842	java/io/IOException
    //   497	501	846	java/io/IOException
    //   506	511	850	java/io/IOException
    //   537	541	854	java/io/IOException
    //   545	549	858	java/io/IOException
    //   554	559	862	java/io/IOException
    //   589	593	866	java/io/IOException
    //   597	601	870	java/io/IOException
    //   664	669	874	java/io/IOException
    //   674	679	878	java/io/IOException
    //   683	687	882	java/io/IOException
    //   743	748	886	java/io/IOException
    //   753	758	890	java/io/IOException
    //   785	789	894	java/io/IOException
    //   794	799	898	java/io/IOException
    //   804	809	902	java/io/IOException
    //   190	249	906	finally
    //   283	360	906	finally
    //   360	365	906	finally
    //   365	381	906	finally
    //   381	387	906	finally
    //   387	397	906	finally
    //   397	424	917	finally
    //   424	485	931	finally
    //   513	533	931	finally
    //   567	583	942	finally
    //   633	639	957	finally
    //   649	659	957	finally
    //   710	716	957	finally
    //   726	736	957	finally
    //   190	249	965	java/lang/OutOfMemoryError
    //   283	360	965	java/lang/OutOfMemoryError
    //   360	365	965	java/lang/OutOfMemoryError
    //   365	381	965	java/lang/OutOfMemoryError
    //   381	387	965	java/lang/OutOfMemoryError
    //   387	397	965	java/lang/OutOfMemoryError
    //   397	424	979	java/lang/OutOfMemoryError
    //   424	485	996	java/lang/OutOfMemoryError
    //   513	533	996	java/lang/OutOfMemoryError
    //   190	249	1010	java/lang/Exception
    //   283	360	1010	java/lang/Exception
    //   360	365	1010	java/lang/Exception
    //   365	381	1010	java/lang/Exception
    //   381	387	1010	java/lang/Exception
    //   387	397	1010	java/lang/Exception
    //   397	424	1020	java/lang/Exception
    //   424	485	1037	java/lang/Exception
    //   513	533	1037	java/lang/Exception
    //   190	249	1051	java/io/IOException
    //   283	360	1051	java/io/IOException
    //   360	365	1051	java/io/IOException
    //   365	381	1051	java/io/IOException
    //   381	387	1051	java/io/IOException
    //   387	397	1051	java/io/IOException
    //   397	424	1058	java/io/IOException
    //   424	485	1063	java/io/IOException
    //   513	533	1063	java/io/IOException
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  private void a(int paramInt)
  {
    if (!FileUtils.b(this.jdField_c_of_type_JavaLangString))
    {
      QQToast.a(this, 2131364425, 0).a();
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new coe(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      g();
      DialogUtil.a(this, 232, null, getString(2131364432), new cof(this), null).show();
    }
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.d = paramIntent.getExtras().getString("uin");
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.e = paramIntent.getStringExtra("file_source");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("preview_only", false);
    paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (paramIntent.contains("ChatActivity")) {
      this.u = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, " initData(),  mVideoPath :" + this.jdField_c_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.d + ",mUinType:" + this.jdField_h_of_type_Int + ",mFileSource:" + this.e + ",mDestType:" + this.u);
      }
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(this.d)) || (!FileUtils.b(this.jdField_c_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131364425, 0).a();
        finish();
      }
      return;
      if (paramIntent.contains("QZonePublishMoodActivity")) {
        this.u = 1;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.u = 3;
      } else {
        this.u = 0;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.p = paramInt;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838957);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + a(paramInt));
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838956);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.u)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362791);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362486);
        }
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("发送");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362791);
    }
  }
  
  private void c(int paramInt)
  {
    DialogUtil.a(this, 232, null, getString(paramInt), new coi(this), null).show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#pause#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.p == 1))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  private void e(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        k();
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624119);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903271);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131297435));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "showProgressDialog", localThrowable);
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.p == 2))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(1);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    b(0);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#stop#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.p == 1) || (this.p == 2))) {
      d();
    }
  }
  
  private void i()
  {
    int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    int i2 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "adjustVideoRatio, videoWith:" + i1 + ",videoHeight:" + i2);
    }
    if ((this.r == 0) || (this.q == 0) || (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (i1 == 0) || (i2 == 0)) {
      return;
    }
    if (this.r / this.q > i2 / i1)
    {
      f1 = this.q;
      i1 = (int)(i2 * f1 / i1);
      i1 = (int)((this.r - i1) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, i1, 0, i1);
      this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = this.r;
    i1 = (int)(i1 * f1 / i2);
    i1 = (int)((this.q - i1) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(i1, 0, i1, 0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  private void j()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label140;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        if (Utils.b() > 512000L)
        {
          if (NetworkUtil.c(this))
          {
            this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
            localObject = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
            DialogUtil.a(this, 232, null, String.format(getResources().getString(2131364440), new Object[] { localObject }), new cog(this), new coh(this)).show();
            return;
            i1 = 0;
            break;
            label140:
            i1 = 0;
            continue;
          }
          new coj(this, null).execute(new Void[0]);
          return;
        }
        c(2131364437);
        return;
      }
    }
    QQToast.a(this, 1, 2131363510, 0).b(getTitleBarHeight());
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(getIntent());
    if (paramBundle != null)
    {
      this.t = paramBundle.getInt("state_play_state");
      this.s = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.s + ",mSavedPlayState : " + a(this.t));
      }
    }
    super.setContentView(2130903555);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131298497));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new cob(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297052));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297064));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298507));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298501));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new coc(this));
    c();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    d();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297064: 
      finish();
      return;
    case 2131298501: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(this.p));
      }
      if ((this.t == 2) && (this.s > 0))
      {
        a(this.s);
        this.t = 0;
        this.s = 0;
        return;
      }
      switch (this.p)
      {
      default: 
        return;
      case 0: 
        if (this.app.d())
        {
          QQToast.a(this, 0, 2131364442, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        e();
        return;
      case 2: 
        f();
        return;
      }
      a(0);
      return;
    }
    switch (this.u)
    {
    case 2: 
    default: 
      return;
    case 0: 
      j();
      return;
    }
    paramView = getIntent();
    paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
    paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    PhotoUtils.a(this, paramView, localArrayList, 2, false);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    b(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreviewActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    b(3);
    g();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared");
    }
    i();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    b(1);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (((this.p == 1) || (this.p == 2)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
      this.s = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    this.t = this.p;
    paramBundle.putInt("state_play_state", this.p);
    paramBundle.putInt("state_play_position", this.s);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.s + " ,playState = " + a(this.p));
    }
  }
  
  public void onStart()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */