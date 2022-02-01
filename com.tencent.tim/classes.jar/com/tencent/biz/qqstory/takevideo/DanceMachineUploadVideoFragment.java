package com.tencent.biz.qqstory.takevideo;

import acfp;
import achq;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import aonu;
import aooi;
import aqoi;
import aurf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import rax;
import ray;

public class DanceMachineUploadVideoFragment
  extends PublicBaseFragment
  implements Handler.Callback
{
  private static aurf d;
  private long Aj = -1L;
  public QQAppInterface app;
  private int bpu = -1;
  private achq jdField_e_of_type_Achq = new rax(this);
  private MessageForShortVideo jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo;
  public BaseActivity mActivity;
  private String mVideoPath;
  private boolean needCallback = true;
  protected Dialog v;
  
  /* Error */
  private int bh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +36 -> 40
    //   7: aload_0
    //   8: getfield 74	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   14: invokevirtual 85	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
    //   17: aload_1
    //   18: invokestatic 91	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   21: ifne +21 -> 42
    //   24: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 99
    //   32: iconst_2
    //   33: ldc 101
    //   35: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_m1
    //   39: ireturn
    //   40: iconst_m1
    //   41: ireturn
    //   42: new 106	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 113	java/io/File:length	()J
    //   57: lstore 5
    //   59: lload 5
    //   61: lconst_0
    //   62: lcmp
    //   63: ifne +19 -> 82
    //   66: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 99
    //   74: iconst_2
    //   75: ldc 115
    //   77: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_m1
    //   81: ireturn
    //   82: aconst_null
    //   83: astore 7
    //   85: new 117	java/io/FileInputStream
    //   88: dup
    //   89: aload 8
    //   91: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore 8
    //   96: aload 8
    //   98: lload 5
    //   100: invokestatic 126	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   103: invokestatic 132	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   106: astore 9
    //   108: aload 9
    //   110: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +55 -> 168
    //   116: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +29 -> 148
    //   122: ldc 99
    //   124: iconst_2
    //   125: new 140	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   132: ldc 143
    //   134: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 9
    //   139: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload 8
    //   150: ifnull +8 -> 158
    //   153: aload 8
    //   155: invokevirtual 154	java/io/FileInputStream:close	()V
    //   158: iconst_m1
    //   159: ireturn
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   165: goto -7 -> 158
    //   168: aload 8
    //   170: astore 7
    //   172: aload 9
    //   174: astore 10
    //   176: aload 8
    //   178: ifnull +16 -> 194
    //   181: aload 8
    //   183: invokevirtual 154	java/io/FileInputStream:close	()V
    //   186: aload 9
    //   188: astore 10
    //   190: aload 8
    //   192: astore 7
    //   194: new 159	android/media/MediaMetadataRetriever
    //   197: dup
    //   198: invokespecial 160	android/media/MediaMetadataRetriever:<init>	()V
    //   201: astore 8
    //   203: aload 8
    //   205: aload_1
    //   206: invokevirtual 163	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   209: lconst_0
    //   210: lstore_3
    //   211: aload 8
    //   213: bipush 9
    //   215: invokevirtual 167	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   218: astore 9
    //   220: aload 9
    //   222: ifnull +12 -> 234
    //   225: aload 9
    //   227: invokestatic 173	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   230: invokevirtual 176	java/lang/Long:longValue	()J
    //   233: lstore_3
    //   234: lload_3
    //   235: ldc2_w 177
    //   238: lcmp
    //   239: ifle +248 -> 487
    //   242: ldc2_w 177
    //   245: lstore_3
    //   246: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +38 -> 287
    //   252: ldc 99
    //   254: iconst_2
    //   255: new 140	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   262: ldc 180
    //   264: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 9
    //   269: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 182
    //   274: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: lload_3
    //   278: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 8
    //   289: lload_3
    //   290: ldc2_w 189
    //   293: lmul
    //   294: invokevirtual 194	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   297: astore 11
    //   299: aload 8
    //   301: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   304: aload 11
    //   306: ifnonnull +223 -> 529
    //   309: iconst_m1
    //   310: ireturn
    //   311: astore 7
    //   313: aload 7
    //   315: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   318: aload 8
    //   320: astore 7
    //   322: aload 9
    //   324: astore 10
    //   326: goto -132 -> 194
    //   329: astore 10
    //   331: aconst_null
    //   332: astore 8
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 10
    //   339: invokevirtual 198	java/io/FileNotFoundException:printStackTrace	()V
    //   342: aconst_null
    //   343: astore 9
    //   345: aload 9
    //   347: astore 7
    //   349: aload 8
    //   351: astore 10
    //   353: iconst_0
    //   354: ifeq -160 -> 194
    //   357: new 200	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 201	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: astore 7
    //   367: aload 7
    //   369: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   372: aload 9
    //   374: astore 7
    //   376: aload 8
    //   378: astore 10
    //   380: goto -186 -> 194
    //   383: astore_1
    //   384: aload 7
    //   386: ifnull +8 -> 394
    //   389: aload 7
    //   391: invokevirtual 154	java/io/FileInputStream:close	()V
    //   394: aload_1
    //   395: athrow
    //   396: astore 7
    //   398: aload 7
    //   400: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   403: goto -9 -> 394
    //   406: astore 7
    //   408: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +28 -> 439
    //   414: ldc 99
    //   416: iconst_2
    //   417: new 140	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   424: ldc 203
    //   426: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload 8
    //   441: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   444: iconst_m1
    //   445: ireturn
    //   446: astore 11
    //   448: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +31 -> 482
    //   454: ldc 99
    //   456: iconst_2
    //   457: new 140	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   464: ldc 205
    //   466: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 9
    //   471: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: aload 11
    //   479: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: lconst_0
    //   483: lstore_3
    //   484: goto -250 -> 234
    //   487: lconst_0
    //   488: lstore_3
    //   489: goto -243 -> 246
    //   492: astore 9
    //   494: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +13 -> 510
    //   500: ldc 99
    //   502: iconst_2
    //   503: ldc 210
    //   505: aload 9
    //   507: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 8
    //   512: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   515: aconst_null
    //   516: astore 11
    //   518: goto -214 -> 304
    //   521: astore_1
    //   522: aload 8
    //   524: invokevirtual 197	android/media/MediaMetadataRetriever:release	()V
    //   527: aload_1
    //   528: athrow
    //   529: iconst_2
    //   530: iconst_2
    //   531: invokestatic 215	rlc:ce	(I)Ljava/lang/String;
    //   534: ldc 217
    //   536: invokestatic 221	rlc:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 13
    //   541: aload 11
    //   543: getstatic 227	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   546: bipush 100
    //   548: aload 13
    //   550: invokestatic 232	rop:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   553: istore_2
    //   554: aload 11
    //   556: invokevirtual 237	android/graphics/Bitmap:recycle	()V
    //   559: iload_2
    //   560: ifne +19 -> 579
    //   563: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +11 -> 577
    //   569: ldc 99
    //   571: iconst_2
    //   572: ldc 239
    //   574: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: iconst_m1
    //   578: ireturn
    //   579: new 106	java/io/File
    //   582: dup
    //   583: aload 13
    //   585: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   588: astore 8
    //   590: aload 8
    //   592: invokevirtual 244	java/io/File:exists	()Z
    //   595: ifeq +135 -> 730
    //   598: aload 8
    //   600: invokevirtual 247	java/io/File:isFile	()Z
    //   603: ifeq +127 -> 730
    //   606: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +29 -> 638
    //   612: ldc 99
    //   614: iconst_2
    //   615: new 140	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   622: ldc 249
    //   624: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 13
    //   629: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: new 117	java/io/FileInputStream
    //   641: dup
    //   642: aload 13
    //   644: invokespecial 250	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   647: astore 8
    //   649: aload 8
    //   651: new 106	java/io/File
    //   654: dup
    //   655: aload 13
    //   657: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   660: invokevirtual 113	java/io/File:length	()J
    //   663: invokestatic 126	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   666: invokestatic 132	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   669: astore 7
    //   671: aload 7
    //   673: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   676: ifeq +70 -> 746
    //   679: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +29 -> 711
    //   685: ldc 99
    //   687: iconst_2
    //   688: new 140	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   695: ldc 252
    //   697: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 7
    //   702: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: aload 8
    //   713: ifnull -675 -> 38
    //   716: aload 8
    //   718: invokevirtual 154	java/io/FileInputStream:close	()V
    //   721: iconst_m1
    //   722: ireturn
    //   723: astore_1
    //   724: aload_1
    //   725: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   728: iconst_m1
    //   729: ireturn
    //   730: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +11 -> 744
    //   736: ldc 99
    //   738: iconst_2
    //   739: ldc 254
    //   741: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: iconst_m1
    //   745: ireturn
    //   746: aload 7
    //   748: astore 9
    //   750: aload 8
    //   752: ifnull +12 -> 764
    //   755: aload 8
    //   757: invokevirtual 154	java/io/FileInputStream:close	()V
    //   760: aload 7
    //   762: astore 9
    //   764: iconst_0
    //   765: iconst_2
    //   766: invokestatic 259	anfr:a	(II)Langi;
    //   769: astore 7
    //   771: new 261	android/content/Intent
    //   774: dup
    //   775: invokespecial 262	android/content/Intent:<init>	()V
    //   778: astore 8
    //   780: aload 8
    //   782: ldc_w 264
    //   785: ldc_w 266
    //   788: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   791: pop
    //   792: aload 8
    //   794: ldc_w 272
    //   797: iconst_0
    //   798: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   801: pop
    //   802: aload 8
    //   804: ldc_w 277
    //   807: aload_1
    //   808: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   811: pop
    //   812: aload 8
    //   814: ldc_w 279
    //   817: lload 5
    //   819: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   822: pop
    //   823: aload 8
    //   825: ldc_w 284
    //   828: aload 10
    //   830: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   833: pop
    //   834: aload 8
    //   836: ldc_w 286
    //   839: aload 11
    //   841: invokevirtual 290	android/graphics/Bitmap:getWidth	()I
    //   844: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   847: pop
    //   848: aload 8
    //   850: ldc_w 292
    //   853: aload 11
    //   855: invokevirtual 295	android/graphics/Bitmap:getHeight	()I
    //   858: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   861: pop
    //   862: aload 8
    //   864: ldc_w 297
    //   867: aload 13
    //   869: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   872: pop
    //   873: aload 8
    //   875: ldc_w 299
    //   878: aload 9
    //   880: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   883: pop
    //   884: aload 8
    //   886: ldc_w 301
    //   889: iconst_2
    //   890: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   893: pop
    //   894: aload 8
    //   896: aload 7
    //   898: invokestatic 304	anfr:a	(Ljava/lang/Object;Langi;)Langt;
    //   901: astore_1
    //   902: aload_1
    //   903: iconst_0
    //   904: putfield 309	angt:cFz	Z
    //   907: aload_1
    //   908: iconst_1
    //   909: putfield 312	angt:cFB	Z
    //   912: aload_0
    //   913: new 314	anff
    //   916: dup
    //   917: aload_0
    //   918: getfield 74	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   921: invokespecial 317	anff:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   924: aload_1
    //   925: invokevirtual 320	anff:a	(Langt;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   928: checkcast 322	com/tencent/mobileqq/data/MessageForShortVideo
    //   931: putfield 324	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   934: aload_1
    //   935: aload_0
    //   936: getfield 324	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   939: putfield 328	angt:message	Ljava/lang/Object;
    //   942: aload 7
    //   944: aload_1
    //   945: invokevirtual 334	angi:c	(Langt;)V
    //   948: aload 7
    //   950: aload_0
    //   951: getfield 74	com/tencent/biz/qqstory/takevideo/DanceMachineUploadVideoFragment:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   954: invokestatic 337	anfr:a	(Langi;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   957: iconst_0
    //   958: ireturn
    //   959: astore 8
    //   961: aload 8
    //   963: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   966: aload 7
    //   968: astore 9
    //   970: goto -206 -> 764
    //   973: astore 9
    //   975: aconst_null
    //   976: astore 12
    //   978: aload 7
    //   980: astore 8
    //   982: aload 12
    //   984: astore 7
    //   986: aload 9
    //   988: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   991: aload 7
    //   993: astore 9
    //   995: iconst_0
    //   996: ifeq -232 -> 764
    //   999: new 200	java/lang/NullPointerException
    //   1002: dup
    //   1003: invokespecial 201	java/lang/NullPointerException:<init>	()V
    //   1006: athrow
    //   1007: astore 8
    //   1009: aload 8
    //   1011: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   1014: aload 7
    //   1016: astore 9
    //   1018: goto -254 -> 764
    //   1021: astore_1
    //   1022: aload 7
    //   1024: astore 8
    //   1026: aload 8
    //   1028: ifnull +8 -> 1036
    //   1031: aload 8
    //   1033: invokevirtual 154	java/io/FileInputStream:close	()V
    //   1036: aload_1
    //   1037: athrow
    //   1038: astore 7
    //   1040: aload 7
    //   1042: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   1045: goto -9 -> 1036
    //   1048: astore_1
    //   1049: goto -23 -> 1026
    //   1052: astore_1
    //   1053: goto -27 -> 1026
    //   1056: astore 9
    //   1058: aconst_null
    //   1059: astore 7
    //   1061: goto -75 -> 986
    //   1064: astore 9
    //   1066: goto -80 -> 986
    //   1069: astore_1
    //   1070: aload 8
    //   1072: astore 7
    //   1074: goto -690 -> 384
    //   1077: astore_1
    //   1078: goto -694 -> 384
    //   1081: astore 10
    //   1083: aconst_null
    //   1084: astore 9
    //   1086: aload 8
    //   1088: astore 7
    //   1090: aload 9
    //   1092: astore 8
    //   1094: goto -757 -> 337
    //   1097: astore 10
    //   1099: aload 8
    //   1101: astore 7
    //   1103: aload 9
    //   1105: astore 8
    //   1107: goto -770 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1110	0	this	DanceMachineUploadVideoFragment
    //   0	1110	1	paramString	String
    //   553	7	2	bool	boolean
    //   210	279	3	l1	long
    //   57	761	5	l2	long
    //   83	110	7	localObject1	Object
    //   311	3	7	localIOException1	java.io.IOException
    //   320	28	7	localObject2	Object
    //   365	3	7	localIOException2	java.io.IOException
    //   374	16	7	localObject3	Object
    //   396	3	7	localIOException3	java.io.IOException
    //   406	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   669	354	7	localObject4	Object
    //   1038	3	7	localIOException4	java.io.IOException
    //   1059	43	7	localObject5	Object
    //   50	845	8	localObject6	Object
    //   959	3	8	localIOException5	java.io.IOException
    //   980	1	8	localObject7	Object
    //   1007	3	8	localIOException6	java.io.IOException
    //   1024	82	8	localObject8	Object
    //   106	364	9	str1	String
    //   492	14	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   748	221	9	localObject9	Object
    //   973	14	9	localIOException7	java.io.IOException
    //   993	24	9	localObject10	Object
    //   1056	1	9	localIOException8	java.io.IOException
    //   1064	1	9	localIOException9	java.io.IOException
    //   1084	20	9	localObject11	Object
    //   174	151	10	str2	String
    //   329	9	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   351	478	10	localObject12	Object
    //   1081	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   1097	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   297	8	11	localBitmap1	android.graphics.Bitmap
    //   446	32	11	localNumberFormatException	java.lang.NumberFormatException
    //   516	338	11	localBitmap2	android.graphics.Bitmap
    //   976	7	12	localObject13	Object
    //   539	329	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   153	158	160	java/io/IOException
    //   181	186	311	java/io/IOException
    //   85	96	329	java/io/FileNotFoundException
    //   357	365	365	java/io/IOException
    //   85	96	383	finally
    //   389	394	396	java/io/IOException
    //   203	209	406	java/lang/IllegalArgumentException
    //   225	234	446	java/lang/NumberFormatException
    //   287	299	492	java/lang/OutOfMemoryError
    //   287	299	521	finally
    //   494	510	521	finally
    //   716	721	723	java/io/IOException
    //   755	760	959	java/io/IOException
    //   638	649	973	java/io/IOException
    //   999	1007	1007	java/io/IOException
    //   638	649	1021	finally
    //   1031	1036	1038	java/io/IOException
    //   649	671	1048	finally
    //   671	711	1048	finally
    //   986	991	1052	finally
    //   649	671	1056	java/io/IOException
    //   671	711	1064	java/io/IOException
    //   96	108	1069	finally
    //   108	148	1069	finally
    //   337	342	1077	finally
    //   96	108	1081	java/io/FileNotFoundException
    //   108	148	1097	java/io/FileNotFoundException
  }
  
  public boolean KR()
  {
    boolean bool1;
    if (this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return bool1;
          aqoi localaqoi = this.app.a().a(this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          if ((localaqoi == null) || (!(localaqoi instanceof aonu))) {
            return false;
          }
          bool2 = ((aonu)localaqoi).isPause();
          i = this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus;
          bool1 = true;
        } while ((!bool2) && (i != 1002) && (i != 1001));
        bool2 = this.app.a().B(this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_e_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("UploadDanceMachineVideo", 2, "stop upload task error");
    return bool2;
  }
  
  public void go()
  {
    try
    {
      if (this.v != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadDanceMachineVideo", 2, "cancelProgressDialog");
        }
        this.v.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("UploadDanceMachineVideo", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case -2: 
      sq(acfp.m(2131704603));
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "upload time out");
    }
    this.Aj = -1L;
    go();
    KR();
    this.mActivity.setResult(2);
    this.mActivity.finish();
    this.needCallback = false;
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    d = new aurf(this);
    paramBundle = this.mActivity.getIntent();
    this.mVideoPath = paramBundle.getExtras().getString("upload_video_path");
    this.bpu = paramBundle.getExtras().getInt("share_method", -1);
    this.mActivity.addObserver(this.jdField_e_of_type_Achq);
    if (!TextUtils.isEmpty(this.mVideoPath))
    {
      ThreadManager.executeOnSubThread(new DanceMachineUploadVideoFragment.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadDanceMachineVideo", 2, "upload param invalid : mVideoPath is null");
    }
    this.mActivity.setResult(2);
    this.mActivity.finish();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.app = ((QQAppInterface)getActivity().getAppInterface());
      this.mActivity.setTheme(16973841);
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mActivity.removeObserver(this.jdField_e_of_type_Achq);
    if (d != null) {
      d.removeCallbacksAndMessages(null);
    }
  }
  
  protected void sq(String paramString)
  {
    if (this.v == null)
    {
      this.v = new ReportDialog(this.mActivity, 2131756467);
      this.v.setContentView(2131559174);
      this.v.setOnKeyListener(new ray(this));
      localObject = this.mActivity.getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.v.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.v.getWindow().setAttributes(localLayoutParams);
      this.v.show();
    }
    Object localObject = (TextView)this.v.findViewById(2131373180);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719518);
    }
    for (;;)
    {
      if (!this.v.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadDanceMachineVideo", 2, "showProgressDialog");
        }
        this.v.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment
 * JD-Core Version:    0.7.0.1
 */