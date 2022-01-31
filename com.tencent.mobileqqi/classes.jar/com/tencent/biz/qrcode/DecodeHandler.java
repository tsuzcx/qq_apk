package com.tencent.biz.qrcode;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.qrcode.QRCodeReader;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import java.lang.ref.WeakReference;
import java.util.EnumMap;
import java.util.Map;

public class DecodeHandler
  extends Handler
{
  static final int jdField_a_of_type_Int = 250;
  static final String jdField_a_of_type_JavaLangString = "QrcodeDecoder";
  static final Map jdField_a_of_type_JavaUtilMap = new EnumMap(DecodeHintType.class);
  static final int b = 1024;
  QRCodeReader jdField_a_of_type_ComGoogleZxingQrcodeQRCodeReader = new QRCodeReader();
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public DecodeHandler(ScannerActivity paramScannerActivity, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramScannerActivity);
    jdField_a_of_type_JavaUtilMap.put(DecodeHintType.TRY_HARDER, Boolean.valueOf(true));
  }
  
  Result a(BinaryBitmap paramBinaryBitmap, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = this.jdField_a_of_type_ComGoogleZxingQrcodeQRCodeReader.a(paramBinaryBitmap, null);
      localObject1 = localObject2;
    }
    catch (ReaderException localReaderException)
    {
      Object localObject2;
      label16:
      break label16;
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (!paramBoolean) {}
    }
    try
    {
      localObject2 = this.jdField_a_of_type_ComGoogleZxingQrcodeQRCodeReader.a(paramBinaryBitmap, jdField_a_of_type_JavaUtilMap);
      return localObject2;
    }
    catch (ReaderException paramBinaryBitmap)
    {
      return localObject1;
    }
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/biz/qrcode/DecodeHandler:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 81	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 83	com/tencent/biz/qrcode/activity/ScannerActivity
    //   10: astore 12
    //   12: aload 12
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aconst_null
    //   19: astore 10
    //   21: aconst_null
    //   22: astore 11
    //   24: aconst_null
    //   25: astore 6
    //   27: aconst_null
    //   28: astore 9
    //   30: aload_1
    //   31: getfield 88	android/os/Message:what	I
    //   34: tableswitch	default:+22 -> 56, 100:+23->57, 101:+1188->1222
    //   57: aload 10
    //   59: astore 6
    //   61: aload 11
    //   63: astore 7
    //   65: aload_1
    //   66: getfield 92	android/os/Message:obj	Ljava/lang/Object;
    //   69: checkcast 94	android/net/Uri
    //   72: astore 14
    //   74: aload 10
    //   76: astore 6
    //   78: aload 11
    //   80: astore 7
    //   82: aload 12
    //   84: invokevirtual 98	com/tencent/biz/qrcode/activity/ScannerActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   87: astore 15
    //   89: aload 10
    //   91: astore 6
    //   93: aload 11
    //   95: astore 7
    //   97: new 100	android/graphics/BitmapFactory$Options
    //   100: dup
    //   101: invokespecial 101	android/graphics/BitmapFactory$Options:<init>	()V
    //   104: astore 13
    //   106: aload 10
    //   108: astore 6
    //   110: aload 11
    //   112: astore 7
    //   114: aload 13
    //   116: iconst_1
    //   117: putfield 105	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   120: aload 10
    //   122: astore 6
    //   124: aload 11
    //   126: astore 7
    //   128: aload 15
    //   130: aload 14
    //   132: invokevirtual 111	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   135: astore 8
    //   137: aload 10
    //   139: astore 6
    //   141: aload 11
    //   143: astore 7
    //   145: aload 8
    //   147: aconst_null
    //   148: aload 13
    //   150: invokestatic 117	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   153: pop
    //   154: aload 10
    //   156: astore 6
    //   158: aload 11
    //   160: astore 7
    //   162: aload 8
    //   164: invokevirtual 122	java/io/InputStream:close	()V
    //   167: aload 10
    //   169: astore 6
    //   171: aload 11
    //   173: astore 7
    //   175: aload 13
    //   177: getfield 125	android/graphics/BitmapFactory$Options:outWidth	I
    //   180: istore_2
    //   181: aload 10
    //   183: astore 6
    //   185: aload 11
    //   187: astore 7
    //   189: aload 13
    //   191: getfield 128	android/graphics/BitmapFactory$Options:outHeight	I
    //   194: istore_3
    //   195: aload 10
    //   197: astore 6
    //   199: aload 11
    //   201: astore 7
    //   203: aload 13
    //   205: iconst_0
    //   206: putfield 105	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   209: iload_2
    //   210: iload_3
    //   211: imul
    //   212: ldc 129
    //   214: if_icmple +590 -> 804
    //   217: aload 10
    //   219: astore 6
    //   221: aload 11
    //   223: astore 7
    //   225: aload 13
    //   227: iload_2
    //   228: iload_3
    //   229: imul
    //   230: i2d
    //   231: invokestatic 135	java/lang/Math:sqrt	(D)D
    //   234: ldc2_w 136
    //   237: ddiv
    //   238: invokestatic 140	java/lang/Math:ceil	(D)D
    //   241: d2i
    //   242: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   245: aload 10
    //   247: astore 6
    //   249: aload 11
    //   251: astore 7
    //   253: aload 15
    //   255: aload 14
    //   257: invokevirtual 111	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   260: astore_1
    //   261: aload 10
    //   263: astore 6
    //   265: aload 11
    //   267: astore 7
    //   269: aload_1
    //   270: aconst_null
    //   271: aload 13
    //   273: invokestatic 117	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   276: astore 8
    //   278: aload 10
    //   280: astore 6
    //   282: aload 11
    //   284: astore 7
    //   286: aload_1
    //   287: invokevirtual 122	java/io/InputStream:close	()V
    //   290: aload 10
    //   292: astore 6
    //   294: aload 11
    //   296: astore 7
    //   298: aload 8
    //   300: invokevirtual 149	android/graphics/Bitmap:getWidth	()I
    //   303: istore 4
    //   305: aload 10
    //   307: astore 6
    //   309: aload 11
    //   311: astore 7
    //   313: aload 8
    //   315: invokevirtual 152	android/graphics/Bitmap:getHeight	()I
    //   318: istore 5
    //   320: aload 10
    //   322: astore 6
    //   324: aload 11
    //   326: astore 7
    //   328: iload 4
    //   330: iload 5
    //   332: imul
    //   333: newarray int
    //   335: astore 16
    //   337: aload 10
    //   339: astore 6
    //   341: aload 11
    //   343: astore 7
    //   345: aload 8
    //   347: aload 16
    //   349: iconst_0
    //   350: iload 4
    //   352: iconst_0
    //   353: iconst_0
    //   354: iload 4
    //   356: iload 5
    //   358: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   361: aload 10
    //   363: astore 6
    //   365: aload 11
    //   367: astore 7
    //   369: aload 8
    //   371: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   374: aload 10
    //   376: astore 6
    //   378: aload 11
    //   380: astore 7
    //   382: aload_0
    //   383: new 161	com/google/zxing/BinaryBitmap
    //   386: dup
    //   387: new 163	com/google/zxing/common/HybridBinarizer
    //   390: dup
    //   391: new 165	com/google/zxing/RGBLuminanceSource
    //   394: dup
    //   395: iload 4
    //   397: iload 5
    //   399: aload 16
    //   401: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   404: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   407: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   410: iconst_1
    //   411: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   414: astore 8
    //   416: aload 8
    //   418: astore 6
    //   420: aload_1
    //   421: astore 8
    //   423: aload 6
    //   425: astore_1
    //   426: aload 8
    //   428: astore 6
    //   430: aload_1
    //   431: astore 7
    //   433: aload_1
    //   434: ifnonnull +758 -> 1192
    //   437: iload_2
    //   438: iconst_2
    //   439: imul
    //   440: iload_3
    //   441: if_icmpgt +476 -> 917
    //   444: iload_2
    //   445: sipush 1024
    //   448: if_icmpge +469 -> 917
    //   451: aload_1
    //   452: astore 6
    //   454: aload_1
    //   455: astore 7
    //   457: aload 15
    //   459: aload 14
    //   461: invokevirtual 111	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   464: astore 9
    //   466: aload_1
    //   467: astore 6
    //   469: aload_1
    //   470: astore 7
    //   472: aload_1
    //   473: astore 8
    //   475: aload 9
    //   477: invokestatic 179	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   480: astore 10
    //   482: aload_1
    //   483: astore 6
    //   485: aload_1
    //   486: astore 7
    //   488: aload_1
    //   489: astore 8
    //   491: aload 9
    //   493: invokevirtual 122	java/io/InputStream:close	()V
    //   496: aload_1
    //   497: astore 6
    //   499: aload_1
    //   500: astore 7
    //   502: aload_1
    //   503: astore 8
    //   505: iload_2
    //   506: iload_2
    //   507: imul
    //   508: newarray int
    //   510: astore 11
    //   512: aload_1
    //   513: astore 6
    //   515: aload_1
    //   516: astore 7
    //   518: aload_1
    //   519: astore 8
    //   521: aload 10
    //   523: aload 11
    //   525: iconst_0
    //   526: iload_2
    //   527: iconst_0
    //   528: iconst_0
    //   529: iload_2
    //   530: iload_2
    //   531: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   534: aload_1
    //   535: astore 6
    //   537: aload_1
    //   538: astore 7
    //   540: aload_1
    //   541: astore 8
    //   543: aload_0
    //   544: new 161	com/google/zxing/BinaryBitmap
    //   547: dup
    //   548: new 163	com/google/zxing/common/HybridBinarizer
    //   551: dup
    //   552: new 165	com/google/zxing/RGBLuminanceSource
    //   555: dup
    //   556: iload_2
    //   557: iload_2
    //   558: aload 11
    //   560: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   563: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   566: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   569: iconst_1
    //   570: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   573: astore_1
    //   574: aload_1
    //   575: ifnonnull +808 -> 1383
    //   578: aload_1
    //   579: astore 6
    //   581: aload_1
    //   582: astore 7
    //   584: aload_1
    //   585: astore 8
    //   587: aload 10
    //   589: aload 11
    //   591: iconst_0
    //   592: iload_2
    //   593: iconst_0
    //   594: iload_3
    //   595: iload_2
    //   596: isub
    //   597: iload_2
    //   598: iload_2
    //   599: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   602: aload_1
    //   603: astore 6
    //   605: aload_1
    //   606: astore 7
    //   608: aload_1
    //   609: astore 8
    //   611: aload_0
    //   612: new 161	com/google/zxing/BinaryBitmap
    //   615: dup
    //   616: new 163	com/google/zxing/common/HybridBinarizer
    //   619: dup
    //   620: new 165	com/google/zxing/RGBLuminanceSource
    //   623: dup
    //   624: iload_2
    //   625: iload_2
    //   626: aload 11
    //   628: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   631: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   634: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   637: iconst_1
    //   638: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   641: astore_1
    //   642: aload_1
    //   643: astore 7
    //   645: aload_1
    //   646: astore 8
    //   648: aload 10
    //   650: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   653: aload 9
    //   655: astore 6
    //   657: aload_1
    //   658: ifnonnull +547 -> 1205
    //   661: iload_2
    //   662: iload_3
    //   663: invokestatic 183	java/lang/Math:min	(II)I
    //   666: istore_2
    //   667: iload_2
    //   668: sipush 250
    //   671: if_icmple +534 -> 1205
    //   674: aload 13
    //   676: iload_2
    //   677: i2d
    //   678: ldc2_w 184
    //   681: ddiv
    //   682: invokestatic 140	java/lang/Math:ceil	(D)D
    //   685: d2i
    //   686: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   689: aload 15
    //   691: aload 14
    //   693: invokevirtual 111	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   696: astore 7
    //   698: aload 7
    //   700: aconst_null
    //   701: aload 13
    //   703: invokestatic 117	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   706: astore 6
    //   708: aload 7
    //   710: invokevirtual 122	java/io/InputStream:close	()V
    //   713: aload 6
    //   715: invokevirtual 149	android/graphics/Bitmap:getWidth	()I
    //   718: istore_2
    //   719: aload 6
    //   721: invokevirtual 152	android/graphics/Bitmap:getHeight	()I
    //   724: istore_3
    //   725: iload_2
    //   726: iload_3
    //   727: imul
    //   728: newarray int
    //   730: astore 8
    //   732: aload 6
    //   734: aload 8
    //   736: iconst_0
    //   737: iload_2
    //   738: iconst_0
    //   739: iconst_0
    //   740: iload_2
    //   741: iload_3
    //   742: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   745: aload 6
    //   747: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   750: aload_0
    //   751: new 161	com/google/zxing/BinaryBitmap
    //   754: dup
    //   755: new 163	com/google/zxing/common/HybridBinarizer
    //   758: dup
    //   759: new 165	com/google/zxing/RGBLuminanceSource
    //   762: dup
    //   763: iload_2
    //   764: iload_3
    //   765: aload 8
    //   767: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   770: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   773: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   776: iconst_1
    //   777: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   780: astore 6
    //   782: aload 6
    //   784: astore_1
    //   785: aload_1
    //   786: ifnull +422 -> 1208
    //   789: aload 12
    //   791: invokevirtual 188	com/tencent/biz/qrcode/activity/ScannerActivity:a	()Landroid/os/Handler;
    //   794: bipush 103
    //   796: aload_1
    //   797: invokestatic 192	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   800: invokevirtual 195	android/os/Message:sendToTarget	()V
    //   803: return
    //   804: aload 10
    //   806: astore 6
    //   808: aload 11
    //   810: astore 7
    //   812: aload 13
    //   814: iconst_1
    //   815: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   818: goto -573 -> 245
    //   821: astore 7
    //   823: aload 6
    //   825: astore_1
    //   826: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   829: ifeq -44 -> 785
    //   832: ldc 10
    //   834: iconst_2
    //   835: aload 7
    //   837: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   840: invokestatic 209	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload 6
    //   845: astore_1
    //   846: goto -61 -> 785
    //   849: astore_1
    //   850: aload 10
    //   852: astore 6
    //   854: aload 11
    //   856: astore 7
    //   858: aload 8
    //   860: invokevirtual 122	java/io/InputStream:close	()V
    //   863: aload 9
    //   865: astore_1
    //   866: goto -440 -> 426
    //   869: astore 6
    //   871: aload 7
    //   873: astore_1
    //   874: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   877: ifeq -92 -> 785
    //   880: ldc 10
    //   882: iconst_2
    //   883: aload 6
    //   885: invokevirtual 210	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   888: invokestatic 209	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 7
    //   893: astore_1
    //   894: goto -109 -> 785
    //   897: astore 6
    //   899: aload 8
    //   901: astore 6
    //   903: aload_1
    //   904: astore 7
    //   906: aload_1
    //   907: astore 8
    //   909: aload 6
    //   911: invokevirtual 122	java/io/InputStream:close	()V
    //   914: goto -257 -> 657
    //   917: aload 8
    //   919: astore 6
    //   921: aload_1
    //   922: astore 7
    //   924: iload_2
    //   925: iload_3
    //   926: iconst_2
    //   927: imul
    //   928: if_icmplt +264 -> 1192
    //   931: aload 8
    //   933: astore 6
    //   935: aload_1
    //   936: astore 7
    //   938: iload_3
    //   939: sipush 1024
    //   942: if_icmpge +250 -> 1192
    //   945: aload_1
    //   946: astore 6
    //   948: aload_1
    //   949: astore 7
    //   951: aload 15
    //   953: aload 14
    //   955: invokevirtual 111	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   958: astore 10
    //   960: aload_1
    //   961: astore 6
    //   963: aload_1
    //   964: astore 7
    //   966: aload_1
    //   967: astore 8
    //   969: aload 10
    //   971: invokestatic 179	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   974: astore 11
    //   976: aload_1
    //   977: astore 6
    //   979: aload_1
    //   980: astore 7
    //   982: aload_1
    //   983: astore 8
    //   985: aload 10
    //   987: invokevirtual 122	java/io/InputStream:close	()V
    //   990: aload_1
    //   991: astore 6
    //   993: aload_1
    //   994: astore 7
    //   996: aload_1
    //   997: astore 8
    //   999: iload_3
    //   1000: iload_3
    //   1001: imul
    //   1002: newarray int
    //   1004: astore 16
    //   1006: aload_1
    //   1007: astore 6
    //   1009: aload_1
    //   1010: astore 7
    //   1012: aload_1
    //   1013: astore 8
    //   1015: aload 11
    //   1017: aload 16
    //   1019: iconst_0
    //   1020: iload_3
    //   1021: iconst_0
    //   1022: iconst_0
    //   1023: iload_3
    //   1024: iload_3
    //   1025: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1028: aload_1
    //   1029: astore 6
    //   1031: aload_1
    //   1032: astore 7
    //   1034: aload_1
    //   1035: astore 8
    //   1037: aload_0
    //   1038: new 161	com/google/zxing/BinaryBitmap
    //   1041: dup
    //   1042: new 163	com/google/zxing/common/HybridBinarizer
    //   1045: dup
    //   1046: new 165	com/google/zxing/RGBLuminanceSource
    //   1049: dup
    //   1050: iload_3
    //   1051: iload_3
    //   1052: aload 16
    //   1054: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   1057: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   1060: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   1063: iconst_1
    //   1064: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   1067: astore 9
    //   1069: aload 9
    //   1071: astore_1
    //   1072: aload 9
    //   1074: ifnonnull +73 -> 1147
    //   1077: aload 9
    //   1079: astore 6
    //   1081: aload 9
    //   1083: astore 7
    //   1085: aload 9
    //   1087: astore 8
    //   1089: aload 11
    //   1091: aload 16
    //   1093: iconst_0
    //   1094: iload_3
    //   1095: iload_2
    //   1096: iload_3
    //   1097: isub
    //   1098: iconst_0
    //   1099: iload_3
    //   1100: iload_3
    //   1101: invokevirtual 156	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1104: aload 9
    //   1106: astore 6
    //   1108: aload 9
    //   1110: astore 7
    //   1112: aload 9
    //   1114: astore 8
    //   1116: aload_0
    //   1117: new 161	com/google/zxing/BinaryBitmap
    //   1120: dup
    //   1121: new 163	com/google/zxing/common/HybridBinarizer
    //   1124: dup
    //   1125: new 165	com/google/zxing/RGBLuminanceSource
    //   1128: dup
    //   1129: iload_3
    //   1130: iload_3
    //   1131: aload 16
    //   1133: invokespecial 168	com/google/zxing/RGBLuminanceSource:<init>	(II[I)V
    //   1136: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   1139: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   1142: iconst_1
    //   1143: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   1146: astore_1
    //   1147: aload_1
    //   1148: astore 6
    //   1150: aload_1
    //   1151: astore 7
    //   1153: aload_1
    //   1154: astore 8
    //   1156: aload 11
    //   1158: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   1161: aload 10
    //   1163: astore 6
    //   1165: goto -508 -> 657
    //   1168: astore 6
    //   1170: aload 8
    //   1172: astore 9
    //   1174: aload_1
    //   1175: astore 6
    //   1177: aload_1
    //   1178: astore 7
    //   1180: aload 9
    //   1182: invokevirtual 122	java/io/InputStream:close	()V
    //   1185: aload_1
    //   1186: astore 7
    //   1188: aload 9
    //   1190: astore 6
    //   1192: aload 7
    //   1194: astore_1
    //   1195: goto -538 -> 657
    //   1198: astore 7
    //   1200: aload 6
    //   1202: invokevirtual 122	java/io/InputStream:close	()V
    //   1205: goto -420 -> 785
    //   1208: aload 12
    //   1210: invokevirtual 188	com/tencent/biz/qrcode/activity/ScannerActivity:a	()Landroid/os/Handler;
    //   1213: bipush 105
    //   1215: invokestatic 213	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1218: invokevirtual 195	android/os/Message:sendToTarget	()V
    //   1221: return
    //   1222: aload 12
    //   1224: invokevirtual 216	com/tencent/biz/qrcode/activity/ScannerActivity:a	()Lcom/tencent/biz/qrcode/CameraManager;
    //   1227: aload_1
    //   1228: getfield 92	android/os/Message:obj	Ljava/lang/Object;
    //   1231: checkcast 218	[B
    //   1234: checkcast 218	[B
    //   1237: invokevirtual 223	com/tencent/biz/qrcode/CameraManager:a	([B)Lcom/google/zxing/PlanarYUVLuminanceSource;
    //   1240: astore 7
    //   1242: aload 6
    //   1244: astore_1
    //   1245: aload 7
    //   1247: ifnull +25 -> 1272
    //   1250: aload_0
    //   1251: new 161	com/google/zxing/BinaryBitmap
    //   1254: dup
    //   1255: new 163	com/google/zxing/common/HybridBinarizer
    //   1258: dup
    //   1259: aload 7
    //   1261: invokespecial 171	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   1264: invokespecial 174	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   1267: iconst_0
    //   1268: invokevirtual 176	com/tencent/biz/qrcode/DecodeHandler:a	(Lcom/google/zxing/BinaryBitmap;Z)Lcom/google/zxing/Result;
    //   1271: astore_1
    //   1272: aload_1
    //   1273: ifnull +18 -> 1291
    //   1276: aload 12
    //   1278: invokevirtual 188	com/tencent/biz/qrcode/activity/ScannerActivity:a	()Landroid/os/Handler;
    //   1281: bipush 104
    //   1283: aload_1
    //   1284: invokestatic 192	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   1287: invokevirtual 195	android/os/Message:sendToTarget	()V
    //   1290: return
    //   1291: ldc2_w 224
    //   1294: invokestatic 231	java/lang/Thread:sleep	(J)V
    //   1297: aload 12
    //   1299: invokevirtual 234	com/tencent/biz/qrcode/activity/ScannerActivity:d	()V
    //   1302: return
    //   1303: astore_1
    //   1304: return
    //   1305: astore 6
    //   1307: goto -436 -> 871
    //   1310: astore 6
    //   1312: aload_1
    //   1313: astore 7
    //   1315: goto -444 -> 871
    //   1318: astore 7
    //   1320: aload 8
    //   1322: astore 6
    //   1324: goto -501 -> 823
    //   1327: astore 7
    //   1329: aload_1
    //   1330: astore 6
    //   1332: goto -509 -> 823
    //   1335: astore 6
    //   1337: aload 7
    //   1339: astore 6
    //   1341: goto -141 -> 1200
    //   1344: astore_1
    //   1345: aload 10
    //   1347: astore 9
    //   1349: aload 8
    //   1351: astore_1
    //   1352: goto -178 -> 1174
    //   1355: astore_1
    //   1356: aload 9
    //   1358: astore 6
    //   1360: aload 8
    //   1362: astore_1
    //   1363: goto -460 -> 903
    //   1366: astore 6
    //   1368: aload 9
    //   1370: astore 6
    //   1372: goto -469 -> 903
    //   1375: astore 6
    //   1377: aload_1
    //   1378: astore 8
    //   1380: goto -530 -> 850
    //   1383: goto -741 -> 642
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1386	0	this	DecodeHandler
    //   0	1386	1	paramMessage	android.os.Message
    //   180	918	2	i	int
    //   194	937	3	j	int
    //   303	93	4	k	int
    //   318	80	5	m	int
    //   25	828	6	localObject1	Object
    //   869	15	6	localRuntimeException1	java.lang.RuntimeException
    //   897	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   901	263	6	localObject2	Object
    //   1168	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1175	68	6	localObject3	Object
    //   1305	1	6	localRuntimeException2	java.lang.RuntimeException
    //   1310	1	6	localRuntimeException3	java.lang.RuntimeException
    //   1322	9	6	localObject4	Object
    //   1335	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1339	20	6	localObject5	Object
    //   1366	1	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1370	1	6	localObject6	Object
    //   1375	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   63	748	7	localObject7	Object
    //   821	15	7	localIOException1	java.io.IOException
    //   856	337	7	localObject8	Object
    //   1198	1	7	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1240	74	7	localObject9	Object
    //   1318	1	7	localIOException2	java.io.IOException
    //   1327	11	7	localIOException3	java.io.IOException
    //   135	1244	8	localObject10	Object
    //   28	1341	9	localObject11	Object
    //   19	1327	10	localObject12	Object
    //   22	1135	11	localObject13	Object
    //   10	1288	12	localScannerActivity	ScannerActivity
    //   104	709	13	localOptions	android.graphics.BitmapFactory.Options
    //   72	882	14	localUri	android.net.Uri
    //   87	865	15	localContentResolver	android.content.ContentResolver
    //   335	797	16	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   65	74	821	java/io/IOException
    //   82	89	821	java/io/IOException
    //   97	106	821	java/io/IOException
    //   114	120	821	java/io/IOException
    //   128	137	821	java/io/IOException
    //   145	154	821	java/io/IOException
    //   162	167	821	java/io/IOException
    //   175	181	821	java/io/IOException
    //   189	195	821	java/io/IOException
    //   203	209	821	java/io/IOException
    //   225	245	821	java/io/IOException
    //   253	261	821	java/io/IOException
    //   269	278	821	java/io/IOException
    //   286	290	821	java/io/IOException
    //   298	305	821	java/io/IOException
    //   313	320	821	java/io/IOException
    //   328	337	821	java/io/IOException
    //   345	361	821	java/io/IOException
    //   369	374	821	java/io/IOException
    //   382	416	821	java/io/IOException
    //   457	466	821	java/io/IOException
    //   475	482	821	java/io/IOException
    //   491	496	821	java/io/IOException
    //   505	512	821	java/io/IOException
    //   521	534	821	java/io/IOException
    //   543	574	821	java/io/IOException
    //   587	602	821	java/io/IOException
    //   611	642	821	java/io/IOException
    //   812	818	821	java/io/IOException
    //   858	863	821	java/io/IOException
    //   951	960	821	java/io/IOException
    //   969	976	821	java/io/IOException
    //   985	990	821	java/io/IOException
    //   999	1006	821	java/io/IOException
    //   1015	1028	821	java/io/IOException
    //   1037	1069	821	java/io/IOException
    //   1089	1104	821	java/io/IOException
    //   1116	1147	821	java/io/IOException
    //   1156	1161	821	java/io/IOException
    //   1180	1185	821	java/io/IOException
    //   253	261	849	java/lang/OutOfMemoryError
    //   65	74	869	java/lang/RuntimeException
    //   82	89	869	java/lang/RuntimeException
    //   97	106	869	java/lang/RuntimeException
    //   114	120	869	java/lang/RuntimeException
    //   128	137	869	java/lang/RuntimeException
    //   145	154	869	java/lang/RuntimeException
    //   162	167	869	java/lang/RuntimeException
    //   175	181	869	java/lang/RuntimeException
    //   189	195	869	java/lang/RuntimeException
    //   203	209	869	java/lang/RuntimeException
    //   225	245	869	java/lang/RuntimeException
    //   253	261	869	java/lang/RuntimeException
    //   269	278	869	java/lang/RuntimeException
    //   286	290	869	java/lang/RuntimeException
    //   298	305	869	java/lang/RuntimeException
    //   313	320	869	java/lang/RuntimeException
    //   328	337	869	java/lang/RuntimeException
    //   345	361	869	java/lang/RuntimeException
    //   369	374	869	java/lang/RuntimeException
    //   382	416	869	java/lang/RuntimeException
    //   457	466	869	java/lang/RuntimeException
    //   475	482	869	java/lang/RuntimeException
    //   491	496	869	java/lang/RuntimeException
    //   505	512	869	java/lang/RuntimeException
    //   521	534	869	java/lang/RuntimeException
    //   543	574	869	java/lang/RuntimeException
    //   587	602	869	java/lang/RuntimeException
    //   611	642	869	java/lang/RuntimeException
    //   812	818	869	java/lang/RuntimeException
    //   858	863	869	java/lang/RuntimeException
    //   951	960	869	java/lang/RuntimeException
    //   969	976	869	java/lang/RuntimeException
    //   985	990	869	java/lang/RuntimeException
    //   999	1006	869	java/lang/RuntimeException
    //   1015	1028	869	java/lang/RuntimeException
    //   1037	1069	869	java/lang/RuntimeException
    //   1089	1104	869	java/lang/RuntimeException
    //   1116	1147	869	java/lang/RuntimeException
    //   1156	1161	869	java/lang/RuntimeException
    //   1180	1185	869	java/lang/RuntimeException
    //   457	466	897	java/lang/OutOfMemoryError
    //   951	960	1168	java/lang/OutOfMemoryError
    //   689	698	1198	java/lang/OutOfMemoryError
    //   1291	1302	1303	java/lang/InterruptedException
    //   648	653	1305	java/lang/RuntimeException
    //   909	914	1305	java/lang/RuntimeException
    //   661	667	1310	java/lang/RuntimeException
    //   674	689	1310	java/lang/RuntimeException
    //   689	698	1310	java/lang/RuntimeException
    //   698	782	1310	java/lang/RuntimeException
    //   1200	1205	1310	java/lang/RuntimeException
    //   648	653	1318	java/io/IOException
    //   909	914	1318	java/io/IOException
    //   661	667	1327	java/io/IOException
    //   674	689	1327	java/io/IOException
    //   689	698	1327	java/io/IOException
    //   698	782	1327	java/io/IOException
    //   1200	1205	1327	java/io/IOException
    //   698	782	1335	java/lang/OutOfMemoryError
    //   969	976	1344	java/lang/OutOfMemoryError
    //   985	990	1344	java/lang/OutOfMemoryError
    //   999	1006	1344	java/lang/OutOfMemoryError
    //   1015	1028	1344	java/lang/OutOfMemoryError
    //   1037	1069	1344	java/lang/OutOfMemoryError
    //   1089	1104	1344	java/lang/OutOfMemoryError
    //   1116	1147	1344	java/lang/OutOfMemoryError
    //   1156	1161	1344	java/lang/OutOfMemoryError
    //   475	482	1355	java/lang/OutOfMemoryError
    //   491	496	1355	java/lang/OutOfMemoryError
    //   505	512	1355	java/lang/OutOfMemoryError
    //   521	534	1355	java/lang/OutOfMemoryError
    //   543	574	1355	java/lang/OutOfMemoryError
    //   587	602	1355	java/lang/OutOfMemoryError
    //   611	642	1355	java/lang/OutOfMemoryError
    //   648	653	1366	java/lang/OutOfMemoryError
    //   269	278	1375	java/lang/OutOfMemoryError
    //   286	290	1375	java/lang/OutOfMemoryError
    //   298	305	1375	java/lang/OutOfMemoryError
    //   313	320	1375	java/lang/OutOfMemoryError
    //   328	337	1375	java/lang/OutOfMemoryError
    //   345	361	1375	java/lang/OutOfMemoryError
    //   369	374	1375	java/lang/OutOfMemoryError
    //   382	416	1375	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.DecodeHandler
 * JD-Core Version:    0.7.0.1
 */