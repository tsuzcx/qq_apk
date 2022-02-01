package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import adwf;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import anpc;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import zsz;

public class VideoDrawableHandler
  implements Handler.Callback
{
  private static int cKu;
  public static int cKv = 1;
  public static int cKw = 2;
  public static int cKx = 4;
  LinkedList<DecodeFrameTask> jdField_A_of_type_JavaUtilLinkedList = new LinkedList();
  Vector<WeakReference<adwf>> jdField_A_of_type_JavaUtilVector = new Vector();
  boolean NW = true;
  a a;
  private AppInterface appInterface;
  MediaMetadataRetriever b;
  final Object dj = new Object();
  Bitmap eY;
  private Bitmap eZ;
  long mDuration = 0L;
  private String mFilePath;
  Handler mHandler = new Handler(Looper.getMainLooper(), this);
  Bitmap mLastBitmap;
  
  public VideoDrawableHandler(AppInterface paramAppInterface, a parama)
  {
    this.appInterface = paramAppInterface;
    this.a = parama;
  }
  
  private void cUQ()
  {
    if (!this.NW) {}
    DecodeFrameTask localDecodeFrameTask;
    do
    {
      return;
      localDecodeFrameTask = (DecodeFrameTask)this.jdField_A_of_type_JavaUtilLinkedList.poll();
    } while (localDecodeFrameTask == null);
    this.NW = false;
    ThreadManager.postImmediately(localDecodeFrameTask, null, true);
  }
  
  /* Error */
  public static Bitmap createVideoThumbnail(String paramString)
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 129	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 132	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: astore 4
    //   14: aload_1
    //   15: astore_3
    //   16: aload_1
    //   17: ldc 134
    //   19: iconst_1
    //   20: anewarray 125	java/lang/Class
    //   23: dup
    //   24: iconst_0
    //   25: ldc 136
    //   27: aastore
    //   28: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aload_2
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_2
    //   45: astore 4
    //   47: aload_1
    //   48: astore_3
    //   49: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 9
    //   54: if_icmpgt +62 -> 116
    //   57: aload_2
    //   58: astore 4
    //   60: aload_1
    //   61: astore_3
    //   62: aload_1
    //   63: ldc 153
    //   65: iconst_0
    //   66: anewarray 125	java/lang/Class
    //   69: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aload_2
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 155	android/graphics/Bitmap
    //   83: astore 5
    //   85: aload 5
    //   87: astore_0
    //   88: aload_2
    //   89: ifnull +25 -> 114
    //   92: aload_1
    //   93: ldc 157
    //   95: iconst_0
    //   96: anewarray 125	java/lang/Class
    //   99: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   102: aload_2
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 5
    //   113: astore_0
    //   114: aload_0
    //   115: areturn
    //   116: aload_2
    //   117: astore 4
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: ldc 159
    //   124: iconst_0
    //   125: anewarray 125	java/lang/Class
    //   128: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   131: aload_2
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 161	[B
    //   142: checkcast 161	[B
    //   145: astore 5
    //   147: aload 5
    //   149: ifnull +90 -> 239
    //   152: aload_2
    //   153: astore 4
    //   155: aload_1
    //   156: astore_3
    //   157: aload 5
    //   159: iconst_0
    //   160: aload 5
    //   162: arraylength
    //   163: invokestatic 167	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   166: astore 5
    //   168: aload 5
    //   170: astore_3
    //   171: aload_3
    //   172: ifnull +67 -> 239
    //   175: aload_3
    //   176: astore_0
    //   177: aload_2
    //   178: ifnull -64 -> 114
    //   181: aload_1
    //   182: ldc 157
    //   184: iconst_0
    //   185: anewarray 125	java/lang/Class
    //   188: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   191: aload_2
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload_3
    //   201: areturn
    //   202: astore_0
    //   203: aload_3
    //   204: areturn
    //   205: astore 5
    //   207: aload_2
    //   208: astore 4
    //   210: aload_1
    //   211: astore_3
    //   212: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +572 -> 787
    //   218: aload_2
    //   219: astore 4
    //   221: aload_1
    //   222: astore_3
    //   223: ldc 175
    //   225: iconst_2
    //   226: aload 5
    //   228: invokevirtual 179	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   231: aload 5
    //   233: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: goto +551 -> 787
    //   239: aload_2
    //   240: astore 4
    //   242: aload_1
    //   243: astore_3
    //   244: aload_0
    //   245: iconst_1
    //   246: invokestatic 188	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   249: astore_0
    //   250: aload_0
    //   251: astore_3
    //   252: aload_3
    //   253: ifnull +33 -> 286
    //   256: aload_3
    //   257: astore_0
    //   258: aload_2
    //   259: ifnull -145 -> 114
    //   262: aload_1
    //   263: ldc 157
    //   265: iconst_0
    //   266: anewarray 125	java/lang/Class
    //   269: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   272: aload_2
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: aload_3
    //   282: areturn
    //   283: astore_0
    //   284: aload_3
    //   285: areturn
    //   286: aload_2
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: aload_1
    //   292: ldc 190
    //   294: iconst_0
    //   295: anewarray 125	java/lang/Class
    //   298: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   301: aload_2
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 155	android/graphics/Bitmap
    //   312: astore 5
    //   314: aload 5
    //   316: astore_0
    //   317: aload_2
    //   318: ifnull -204 -> 114
    //   321: aload_1
    //   322: ldc 157
    //   324: iconst_0
    //   325: anewarray 125	java/lang/Class
    //   328: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   331: aload_2
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload 5
    //   342: areturn
    //   343: astore_0
    //   344: aload 5
    //   346: areturn
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_0
    //   350: aconst_null
    //   351: astore_1
    //   352: aload_0
    //   353: ifnull +22 -> 375
    //   356: aload_1
    //   357: ldc 157
    //   359: iconst_0
    //   360: anewarray 125	java/lang/Class
    //   363: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   366: aload_0
    //   367: iconst_0
    //   368: anewarray 4	java/lang/Object
    //   371: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: aconst_null
    //   376: areturn
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: aload_2
    //   383: ifnull -8 -> 375
    //   386: aload_1
    //   387: ldc 157
    //   389: iconst_0
    //   390: anewarray 125	java/lang/Class
    //   393: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   396: aload_2
    //   397: iconst_0
    //   398: anewarray 4	java/lang/Object
    //   401: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   404: pop
    //   405: goto -30 -> 375
    //   408: astore_0
    //   409: goto -34 -> 375
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_2
    //   415: aconst_null
    //   416: astore_1
    //   417: aload_2
    //   418: astore 4
    //   420: aload_1
    //   421: astore_3
    //   422: ldc 175
    //   424: ldc 191
    //   426: aload_0
    //   427: invokestatic 197	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   430: pop
    //   431: aload_2
    //   432: ifnull -57 -> 375
    //   435: aload_1
    //   436: ldc 157
    //   438: iconst_0
    //   439: anewarray 125	java/lang/Class
    //   442: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   445: aload_2
    //   446: iconst_0
    //   447: anewarray 4	java/lang/Object
    //   450: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: goto -79 -> 375
    //   457: astore_0
    //   458: goto -83 -> 375
    //   461: astore_0
    //   462: aconst_null
    //   463: astore_2
    //   464: aconst_null
    //   465: astore_1
    //   466: aload_2
    //   467: astore 4
    //   469: aload_1
    //   470: astore_3
    //   471: ldc 175
    //   473: ldc 191
    //   475: aload_0
    //   476: invokestatic 197	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   479: pop
    //   480: aload_2
    //   481: ifnull -106 -> 375
    //   484: aload_1
    //   485: ldc 157
    //   487: iconst_0
    //   488: anewarray 125	java/lang/Class
    //   491: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   494: aload_2
    //   495: iconst_0
    //   496: anewarray 4	java/lang/Object
    //   499: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: goto -128 -> 375
    //   506: astore_0
    //   507: goto -132 -> 375
    //   510: astore_0
    //   511: aconst_null
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_1
    //   515: aload_2
    //   516: astore 4
    //   518: aload_1
    //   519: astore_3
    //   520: ldc 175
    //   522: ldc 191
    //   524: aload_0
    //   525: invokestatic 197	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   528: pop
    //   529: aload_2
    //   530: ifnull -155 -> 375
    //   533: aload_1
    //   534: ldc 157
    //   536: iconst_0
    //   537: anewarray 125	java/lang/Class
    //   540: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   543: aload_2
    //   544: iconst_0
    //   545: anewarray 4	java/lang/Object
    //   548: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: goto -177 -> 375
    //   555: astore_0
    //   556: goto -181 -> 375
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_2
    //   562: aconst_null
    //   563: astore_1
    //   564: aload_2
    //   565: astore 4
    //   567: aload_1
    //   568: astore_3
    //   569: ldc 175
    //   571: ldc 191
    //   573: aload_0
    //   574: invokestatic 197	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   577: pop
    //   578: aload_2
    //   579: ifnull -204 -> 375
    //   582: aload_1
    //   583: ldc 157
    //   585: iconst_0
    //   586: anewarray 125	java/lang/Class
    //   589: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   592: aload_2
    //   593: iconst_0
    //   594: anewarray 4	java/lang/Object
    //   597: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   600: pop
    //   601: goto -226 -> 375
    //   604: astore_0
    //   605: goto -230 -> 375
    //   608: astore_0
    //   609: aconst_null
    //   610: astore_2
    //   611: aconst_null
    //   612: astore_1
    //   613: aload_2
    //   614: astore 4
    //   616: aload_1
    //   617: astore_3
    //   618: ldc 175
    //   620: ldc 191
    //   622: aload_0
    //   623: invokestatic 197	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   626: pop
    //   627: aload_2
    //   628: ifnull -253 -> 375
    //   631: aload_1
    //   632: ldc 157
    //   634: iconst_0
    //   635: anewarray 125	java/lang/Class
    //   638: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   641: aload_2
    //   642: iconst_0
    //   643: anewarray 4	java/lang/Object
    //   646: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   649: pop
    //   650: goto -275 -> 375
    //   653: astore_0
    //   654: goto -279 -> 375
    //   657: astore_0
    //   658: aconst_null
    //   659: astore 4
    //   661: aconst_null
    //   662: astore_1
    //   663: aload 4
    //   665: ifnull +23 -> 688
    //   668: aload_1
    //   669: ldc 157
    //   671: iconst_0
    //   672: anewarray 125	java/lang/Class
    //   675: invokevirtual 140	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   678: aload 4
    //   680: iconst_0
    //   681: anewarray 4	java/lang/Object
    //   684: invokevirtual 146	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   687: pop
    //   688: aload_0
    //   689: athrow
    //   690: astore_1
    //   691: goto -3 -> 688
    //   694: astore_0
    //   695: aconst_null
    //   696: astore 4
    //   698: goto -35 -> 663
    //   701: astore_0
    //   702: aload_3
    //   703: astore_1
    //   704: goto -41 -> 663
    //   707: astore_0
    //   708: aconst_null
    //   709: astore_2
    //   710: goto -97 -> 613
    //   713: astore_0
    //   714: goto -101 -> 613
    //   717: astore_0
    //   718: aconst_null
    //   719: astore_2
    //   720: goto -156 -> 564
    //   723: astore_0
    //   724: goto -160 -> 564
    //   727: astore_0
    //   728: aconst_null
    //   729: astore_2
    //   730: goto -215 -> 515
    //   733: astore_0
    //   734: goto -219 -> 515
    //   737: astore_0
    //   738: aconst_null
    //   739: astore_2
    //   740: goto -274 -> 466
    //   743: astore_0
    //   744: goto -278 -> 466
    //   747: astore_0
    //   748: aconst_null
    //   749: astore_2
    //   750: goto -333 -> 417
    //   753: astore_0
    //   754: goto -337 -> 417
    //   757: astore_0
    //   758: aconst_null
    //   759: astore_2
    //   760: goto -378 -> 382
    //   763: astore_0
    //   764: goto -382 -> 382
    //   767: astore_0
    //   768: goto -393 -> 375
    //   771: astore_0
    //   772: aconst_null
    //   773: astore_0
    //   774: goto -422 -> 352
    //   777: astore_0
    //   778: aload_2
    //   779: astore_0
    //   780: goto -428 -> 352
    //   783: astore_0
    //   784: aload 5
    //   786: areturn
    //   787: aconst_null
    //   788: astore_3
    //   789: goto -618 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	paramString	String
    //   5	664	1	localClass	java.lang.Class
    //   690	1	1	localException	Exception
    //   703	1	1	localObject1	Object
    //   10	769	2	localObject2	Object
    //   15	774	3	localObject3	Object
    //   12	685	4	localObject4	Object
    //   83	86	5	localObject5	Object
    //   205	27	5	localOutOfMemoryError	OutOfMemoryError
    //   312	473	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   181	200	202	java/lang/Exception
    //   157	168	205	java/lang/OutOfMemoryError
    //   262	281	283	java/lang/Exception
    //   321	340	343	java/lang/Exception
    //   0	6	347	java/lang/IllegalArgumentException
    //   0	6	377	java/lang/RuntimeException
    //   386	405	408	java/lang/Exception
    //   0	6	412	java/lang/InstantiationException
    //   435	454	457	java/lang/Exception
    //   0	6	461	java/lang/reflect/InvocationTargetException
    //   484	503	506	java/lang/Exception
    //   0	6	510	java/lang/ClassNotFoundException
    //   533	552	555	java/lang/Exception
    //   0	6	559	java/lang/NoSuchMethodException
    //   582	601	604	java/lang/Exception
    //   0	6	608	java/lang/IllegalAccessException
    //   631	650	653	java/lang/Exception
    //   0	6	657	finally
    //   668	688	690	java/lang/Exception
    //   6	11	694	finally
    //   16	44	701	finally
    //   49	57	701	finally
    //   62	85	701	finally
    //   121	147	701	finally
    //   157	168	701	finally
    //   212	218	701	finally
    //   223	236	701	finally
    //   244	250	701	finally
    //   291	314	701	finally
    //   422	431	701	finally
    //   471	480	701	finally
    //   520	529	701	finally
    //   569	578	701	finally
    //   618	627	701	finally
    //   6	11	707	java/lang/IllegalAccessException
    //   16	44	713	java/lang/IllegalAccessException
    //   49	57	713	java/lang/IllegalAccessException
    //   62	85	713	java/lang/IllegalAccessException
    //   121	147	713	java/lang/IllegalAccessException
    //   157	168	713	java/lang/IllegalAccessException
    //   212	218	713	java/lang/IllegalAccessException
    //   223	236	713	java/lang/IllegalAccessException
    //   244	250	713	java/lang/IllegalAccessException
    //   291	314	713	java/lang/IllegalAccessException
    //   6	11	717	java/lang/NoSuchMethodException
    //   16	44	723	java/lang/NoSuchMethodException
    //   49	57	723	java/lang/NoSuchMethodException
    //   62	85	723	java/lang/NoSuchMethodException
    //   121	147	723	java/lang/NoSuchMethodException
    //   157	168	723	java/lang/NoSuchMethodException
    //   212	218	723	java/lang/NoSuchMethodException
    //   223	236	723	java/lang/NoSuchMethodException
    //   244	250	723	java/lang/NoSuchMethodException
    //   291	314	723	java/lang/NoSuchMethodException
    //   6	11	727	java/lang/ClassNotFoundException
    //   16	44	733	java/lang/ClassNotFoundException
    //   49	57	733	java/lang/ClassNotFoundException
    //   62	85	733	java/lang/ClassNotFoundException
    //   121	147	733	java/lang/ClassNotFoundException
    //   157	168	733	java/lang/ClassNotFoundException
    //   212	218	733	java/lang/ClassNotFoundException
    //   223	236	733	java/lang/ClassNotFoundException
    //   244	250	733	java/lang/ClassNotFoundException
    //   291	314	733	java/lang/ClassNotFoundException
    //   6	11	737	java/lang/reflect/InvocationTargetException
    //   16	44	743	java/lang/reflect/InvocationTargetException
    //   49	57	743	java/lang/reflect/InvocationTargetException
    //   62	85	743	java/lang/reflect/InvocationTargetException
    //   121	147	743	java/lang/reflect/InvocationTargetException
    //   157	168	743	java/lang/reflect/InvocationTargetException
    //   212	218	743	java/lang/reflect/InvocationTargetException
    //   223	236	743	java/lang/reflect/InvocationTargetException
    //   244	250	743	java/lang/reflect/InvocationTargetException
    //   291	314	743	java/lang/reflect/InvocationTargetException
    //   6	11	747	java/lang/InstantiationException
    //   16	44	753	java/lang/InstantiationException
    //   49	57	753	java/lang/InstantiationException
    //   62	85	753	java/lang/InstantiationException
    //   121	147	753	java/lang/InstantiationException
    //   157	168	753	java/lang/InstantiationException
    //   212	218	753	java/lang/InstantiationException
    //   223	236	753	java/lang/InstantiationException
    //   244	250	753	java/lang/InstantiationException
    //   291	314	753	java/lang/InstantiationException
    //   6	11	757	java/lang/RuntimeException
    //   16	44	763	java/lang/RuntimeException
    //   49	57	763	java/lang/RuntimeException
    //   62	85	763	java/lang/RuntimeException
    //   121	147	763	java/lang/RuntimeException
    //   157	168	763	java/lang/RuntimeException
    //   212	218	763	java/lang/RuntimeException
    //   223	236	763	java/lang/RuntimeException
    //   244	250	763	java/lang/RuntimeException
    //   291	314	763	java/lang/RuntimeException
    //   356	375	767	java/lang/Exception
    //   6	11	771	java/lang/IllegalArgumentException
    //   16	44	777	java/lang/IllegalArgumentException
    //   49	57	777	java/lang/IllegalArgumentException
    //   62	85	777	java/lang/IllegalArgumentException
    //   121	147	777	java/lang/IllegalArgumentException
    //   157	168	777	java/lang/IllegalArgumentException
    //   212	218	777	java/lang/IllegalArgumentException
    //   223	236	777	java/lang/IllegalArgumentException
    //   244	250	777	java/lang/IllegalArgumentException
    //   291	314	777	java/lang/IllegalArgumentException
    //   92	111	783	java/lang/Exception
  }
  
  public void a(adwf paramadwf)
  {
    synchronized (this.dj)
    {
      if (!this.jdField_A_of_type_JavaUtilVector.contains(paramadwf)) {
        this.jdField_A_of_type_JavaUtilVector.add(new WeakReference(paramadwf));
      }
      return;
    }
  }
  
  public Bitmap av()
  {
    return this.eZ;
  }
  
  public void clearTask()
  {
    synchronized (this.dj)
    {
      this.jdField_A_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
  
  @TargetApi(10)
  public void destroy()
  {
    clearTask();
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      paramMessage = this.dj;
      if (i == 0) {}
      try
      {
        refresh();
        if ((this.mLastBitmap != null) && (!this.mLastBitmap.isRecycled()) && (this.mLastBitmap != this.eY) && (this.mLastBitmap != this.eZ)) {
          this.mLastBitmap.recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, "refresh. pending task size:" + this.jdField_A_of_type_JavaUtilLinkedList.size());
        }
        this.NW = true;
        cUQ();
      }
      finally {}
    }
  }
  
  @TargetApi(10)
  public boolean init(String paramString)
  {
    boolean bool2 = false;
    try
    {
      if (this.b != null) {
        this.b.release();
      }
      this.b = new MediaMetadataRetriever();
      this.b.setDataSource(paramString);
      this.mDuration = Long.valueOf(this.b.extractMetadata(9)).longValue();
      if (QLog.isColorLevel()) {
        QLog.i("VideoDrawableHandler", 2, "duration:" + this.mDuration);
      }
      long l = this.mDuration;
      if (l <= 0L) {
        break label248;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawableHandler", 2, localException.getMessage(), localException);
        }
        boolean bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoDrawableHandler", 2, "init suc:" + bool1 + " path:" + paramString);
    }
    if (bool1)
    {
      this.mFilePath = paramString;
      this.eZ = createVideoThumbnail(this.mFilePath);
    }
    localStringBuilder = new StringBuilder().append("init suc:").append(bool1).append(" thumb!=Null:");
    if (this.eZ != null) {
      bool2 = true;
    }
    QLog.i("VideoDrawableHandler", 1, bool2 + " path:" + paramString);
    return bool1;
  }
  
  @TargetApi(10)
  public Bitmap k(int paramInt)
  {
    boolean bool2 = false;
    if (this.b == null) {
      return null;
    }
    if (this.eZ != null) {}
    for (int j = cKx | 0x0;; j = 0)
    {
      int k;
      if (cKu < 3)
      {
        try
        {
          localObject1 = this.b.getFrameAtTime(paramInt * 1000, 2);
          if (localObject1 != null) {
            break label598;
          }
          i = 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1;
            if (QLog.isColorLevel()) {
              QLog.i("VideoDrawableHandler", 2, localOutOfMemoryError1.getMessage(), localOutOfMemoryError1);
            }
            localObject2 = null;
            i = 3;
          }
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("VideoDrawableHandler", 2, localThrowable1.getMessage(), localThrowable1);
            }
            localObject3 = null;
            i = 2;
            continue;
            j = i;
            i = 0;
            continue;
            k = i;
            i = j;
            continue;
            i = 0;
          }
        }
        if (localObject1 != null)
        {
          k = cKv;
          j |= k;
          k = i;
        }
      }
      for (int i = j;; i = j)
      {
        if ((k == 1) || (k == 2)) {
          cKu += 1;
        }
        if ((localObject1 == null) && (k != 3))
        {
          try
          {
            localObject4 = this.b.getFrameAtTime(paramInt * 1000, 2);
            localObject1 = localObject4;
            if (localObject1 != null) {
              break label578;
            }
            j = 1;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;)
            {
              Object localObject4;
              anpc localanpc;
              String str;
              Object localObject2;
              if (QLog.isColorLevel()) {
                QLog.i("VideoDrawableHandler", 2, localOutOfMemoryError2.getMessage(), localOutOfMemoryError2);
              }
              j = 3;
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("VideoDrawableHandler", 2, localThrowable2.getMessage(), localThrowable2);
              }
              j = 2;
              continue;
              boolean bool1 = false;
              continue;
              int m = i;
              i = j;
              j = m;
              continue;
              j = 0;
            }
          }
          if (localObject1 != null)
          {
            m = cKw | i;
            i = j;
            j = m;
            m = i << 2 | k;
            if (localObject1 == null) {
              QLog.i("VideoDrawableHandler", 1, "getBitmapAt at:" + paramInt + " status:" + j + " errorReason:" + m);
            }
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder().append("getBitmapAt ").append(paramInt).append(" failCount:").append(cKu).append(" bmp!=null:");
              if (localObject1 != null)
              {
                bool1 = true;
                QLog.i("VideoDrawableHandler", 2, bool1 + " status:" + j + " errorReason:" + m);
              }
            }
            else
            {
              localObject4 = new HashMap();
              ((HashMap)localObject4).put("param_DeviceType", zsz.getDeviceType() + "");
              ((HashMap)localObject4).put("param_ErrorArbitary", k + "");
              ((HashMap)localObject4).put("param_ErrorKey", i + "");
              localanpc = anpc.a(BaseApplicationImpl.getContext());
              str = this.appInterface.getCurrentAccountUin();
              bool1 = bool2;
              if (localObject1 != null) {
                bool1 = true;
              }
              localanpc.collectPerformance(str, "CMD_EXTRACT_FRAME", bool1, j, m, (HashMap)localObject4, "");
              return localObject1;
            }
          }
        }
        label578:
        label598:
        k = 0;
        Object localObject3 = null;
      }
    }
  }
  
  public void onProgressUpdate(int paramInt)
  {
    DecodeFrameTask localDecodeFrameTask = new DecodeFrameTask(paramInt);
    synchronized (this.dj)
    {
      this.jdField_A_of_type_JavaUtilLinkedList.add(localDecodeFrameTask);
      if (this.jdField_A_of_type_JavaUtilLinkedList.size() > 2) {
        this.jdField_A_of_type_JavaUtilLinkedList.removeFirst();
      }
      cUQ();
      return;
    }
  }
  
  public void refresh()
  {
    int i = 0;
    while (i < this.jdField_A_of_type_JavaUtilVector.size())
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_A_of_type_JavaUtilVector.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((adwf)localWeakReference.get()).setBitmap(this.eY);
      }
      i += 1;
    }
  }
  
  public class DecodeFrameTask
    implements Runnable
  {
    int at;
    
    public DecodeFrameTask(int paramInt)
    {
      this.at = paramInt;
    }
    
    @TargetApi(10)
    public void run()
    {
      Bitmap localBitmap = VideoDrawableHandler.this.k(this.at);
      int i;
      if (localBitmap == null)
      {
        localBitmap = VideoDrawableHandler.a(VideoDrawableHandler.this);
        if (localBitmap == null) {
          i = 2;
        }
      }
      for (;;)
      {
        if ((localBitmap != null) && (VideoDrawableHandler.this.eY != localBitmap)) {}
        for (;;)
        {
          synchronized (VideoDrawableHandler.this.dj)
          {
            VideoDrawableHandler.this.mLastBitmap = VideoDrawableHandler.this.eY;
            VideoDrawableHandler.this.eY = localBitmap;
            VideoDrawableHandler.this.mHandler.obtainMessage(0, 0, 0).sendToTarget();
            if (VideoDrawableHandler.this.a != null) {
              VideoDrawableHandler.this.a.hD(this.at, i);
            }
            if (QLog.isColorLevel()) {
              QLog.i("VideoDrawableHandler", 2, "task run at:" + this.at + " bmp:" + VideoDrawableHandler.this.eY);
            }
            return;
          }
          VideoDrawableHandler.this.mHandler.obtainMessage(0, 1, 0).sendToTarget();
        }
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void hD(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler
 * JD-Core Version:    0.7.0.1
 */