import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class yvv
{
  public static final String a;
  private static yvv jdField_a_of_type_Yvv;
  public static final String b = jdField_a_of_type_JavaLangString + "cache/videostory/";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  private ywd jdField_a_of_type_Ywd;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  }
  
  private yvv()
  {
    File localFile = new File(b);
    if (!localFile.exists())
    {
      boolean bool = localFile.mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("Q.videostory.capture", 2, "VideoStoryPicToVideo, createDir:" + bool);
      }
    }
  }
  
  public static yvv a()
  {
    if (jdField_a_of_type_Yvv == null) {}
    try
    {
      if (jdField_a_of_type_Yvv == null) {
        jdField_a_of_type_Yvv = new yvv();
      }
      return jdField_a_of_type_Yvv;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, yvx paramyvx)
  {
    yvy localyvy = new yvy(0, "success");
    try
    {
      xpc.b(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, new yvw(this, paramyvx, localyvy));
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      do
      {
        paramString1.printStackTrace();
        if (paramyvx != null)
        {
          localyvy.a(943004);
          localyvy.a(paramString1.getMessage());
          paramyvx.b(localyvy);
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.videostory.capture", 2, "picToVideo failure");
      return;
    }
    catch (IOException paramString1)
    {
      do
      {
        paramString1.printStackTrace();
        if (paramyvx != null)
        {
          localyvy.a(943004);
          localyvy.a(paramString1.getMessage());
          paramyvx.b(localyvy);
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.videostory.capture", 2, "picToVideo failure");
    }
  }
  
  /* Error */
  @android.support.annotation.RequiresApi(api=17)
  private void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, yvx paramyvx)
  {
    // Byte code:
    //   0: new 91	yvy
    //   3: dup
    //   4: iconst_0
    //   5: ldc 93
    //   7: invokespecial 96	yvy:<init>	(ILjava/lang/String;)V
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 18
    //   15: new 140	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore 17
    //   25: new 143	java/io/BufferedInputStream
    //   28: dup
    //   29: aload 17
    //   31: ldc 144
    //   33: invokespecial 147	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   36: astore 16
    //   38: aload 16
    //   40: aconst_null
    //   41: iload 4
    //   43: iload 5
    //   45: invokestatic 152	bcwc:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   48: astore 18
    //   50: aload 16
    //   52: ifnull +16 -> 68
    //   55: iload 4
    //   57: istore 12
    //   59: iload 5
    //   61: istore 14
    //   63: aload 16
    //   65: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   68: aload 18
    //   70: astore 16
    //   72: aload 17
    //   74: ifnull +20 -> 94
    //   77: iload 4
    //   79: istore 12
    //   81: iload 5
    //   83: istore 14
    //   85: aload 17
    //   87: invokevirtual 156	java/io/FileInputStream:close	()V
    //   90: aload 18
    //   92: astore 16
    //   94: aload 16
    //   96: astore 17
    //   98: aload 16
    //   100: ifnonnull +29 -> 129
    //   103: iload 4
    //   105: istore 11
    //   107: iload 5
    //   109: istore 13
    //   111: iload 4
    //   113: istore 12
    //   115: iload 5
    //   117: istore 14
    //   119: aload_1
    //   120: iload 4
    //   122: iload 5
    //   124: invokestatic 159	bcwc:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   127: astore 17
    //   129: aload 17
    //   131: ifnonnull +249 -> 380
    //   134: aload 8
    //   136: ifnull +74 -> 210
    //   139: iload 4
    //   141: istore 11
    //   143: iload 5
    //   145: istore 13
    //   147: iload 4
    //   149: istore 12
    //   151: iload 5
    //   153: istore 14
    //   155: aload 19
    //   157: ldc 160
    //   159: invokevirtual 113	yvy:a	(I)V
    //   162: iload 4
    //   164: istore 11
    //   166: iload 5
    //   168: istore 13
    //   170: iload 4
    //   172: istore 12
    //   174: iload 5
    //   176: istore 14
    //   178: aload 19
    //   180: ldc 162
    //   182: invokevirtual 118	yvy:a	(Ljava/lang/String;)V
    //   185: iload 4
    //   187: istore 11
    //   189: iload 5
    //   191: istore 13
    //   193: iload 4
    //   195: istore 12
    //   197: iload 5
    //   199: istore 14
    //   201: aload 8
    //   203: aload 19
    //   205: invokeinterface 123 2 0
    //   210: return
    //   211: astore 18
    //   213: aconst_null
    //   214: astore 17
    //   216: aconst_null
    //   217: astore 16
    //   219: aload 18
    //   221: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   224: aload 16
    //   226: ifnull +16 -> 242
    //   229: iload 4
    //   231: istore 12
    //   233: iload 5
    //   235: istore 14
    //   237: aload 16
    //   239: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   242: aload 17
    //   244: ifnull +502 -> 746
    //   247: iload 4
    //   249: istore 12
    //   251: iload 5
    //   253: istore 14
    //   255: aload 17
    //   257: invokevirtual 156	java/io/FileInputStream:close	()V
    //   260: aconst_null
    //   261: astore 16
    //   263: goto -169 -> 94
    //   266: astore 16
    //   268: aconst_null
    //   269: astore 16
    //   271: goto -177 -> 94
    //   274: astore_1
    //   275: aconst_null
    //   276: astore 17
    //   278: aload 18
    //   280: astore 16
    //   282: aload 16
    //   284: ifnull +16 -> 300
    //   287: iload 4
    //   289: istore 12
    //   291: iload 5
    //   293: istore 14
    //   295: aload 16
    //   297: invokevirtual 155	java/io/BufferedInputStream:close	()V
    //   300: aload 17
    //   302: ifnull +16 -> 318
    //   305: iload 4
    //   307: istore 12
    //   309: iload 5
    //   311: istore 14
    //   313: aload 17
    //   315: invokevirtual 156	java/io/FileInputStream:close	()V
    //   318: iload 4
    //   320: istore 11
    //   322: iload 5
    //   324: istore 13
    //   326: iload 4
    //   328: istore 12
    //   330: iload 5
    //   332: istore 14
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_1
    //   339: iload 13
    //   341: istore 5
    //   343: iload 11
    //   345: istore 4
    //   347: aload_1
    //   348: ifnonnull +261 -> 609
    //   351: aload 8
    //   353: ifnull -143 -> 210
    //   356: aload 19
    //   358: ldc 160
    //   360: invokevirtual 113	yvy:a	(I)V
    //   363: aload 19
    //   365: ldc 162
    //   367: invokevirtual 118	yvy:a	(Ljava/lang/String;)V
    //   370: aload 8
    //   372: aload 19
    //   374: invokeinterface 123 2 0
    //   379: return
    //   380: iload 4
    //   382: istore 11
    //   384: iload 5
    //   386: istore 13
    //   388: iload 4
    //   390: istore 12
    //   392: iload 5
    //   394: istore 14
    //   396: aload_1
    //   397: invokestatic 168	bdda:b	(Ljava/lang/String;)I
    //   400: istore 15
    //   402: aload 17
    //   404: astore_1
    //   405: iload 4
    //   407: istore 9
    //   409: iload 5
    //   411: istore 10
    //   413: iload 15
    //   415: ifeq +169 -> 584
    //   418: aload 17
    //   420: astore_1
    //   421: iload 4
    //   423: istore 9
    //   425: iload 5
    //   427: istore 10
    //   429: iload 15
    //   431: bipush 90
    //   433: irem
    //   434: ifne +150 -> 584
    //   437: iload 4
    //   439: istore 11
    //   441: iload 5
    //   443: istore 13
    //   445: iload 4
    //   447: istore 12
    //   449: iload 5
    //   451: istore 14
    //   453: new 170	android/graphics/Matrix
    //   456: dup
    //   457: invokespecial 171	android/graphics/Matrix:<init>	()V
    //   460: astore_1
    //   461: iload 4
    //   463: istore 11
    //   465: iload 5
    //   467: istore 13
    //   469: iload 4
    //   471: istore 12
    //   473: iload 5
    //   475: istore 14
    //   477: aload_1
    //   478: iload 15
    //   480: i2f
    //   481: aload 17
    //   483: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   486: i2f
    //   487: fconst_2
    //   488: fdiv
    //   489: aload 17
    //   491: invokevirtual 180	android/graphics/Bitmap:getHeight	()I
    //   494: i2f
    //   495: fconst_2
    //   496: fdiv
    //   497: invokevirtual 184	android/graphics/Matrix:postRotate	(FFF)Z
    //   500: pop
    //   501: iload 4
    //   503: istore 11
    //   505: iload 5
    //   507: istore 13
    //   509: iload 4
    //   511: istore 12
    //   513: iload 5
    //   515: istore 14
    //   517: aload 17
    //   519: iconst_0
    //   520: iconst_0
    //   521: aload 17
    //   523: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   526: aload 17
    //   528: invokevirtual 180	android/graphics/Bitmap:getHeight	()I
    //   531: aload_1
    //   532: iconst_1
    //   533: invokestatic 188	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   536: astore_1
    //   537: iload 15
    //   539: bipush 90
    //   541: if_icmpeq +211 -> 752
    //   544: iload 4
    //   546: istore 9
    //   548: iload 5
    //   550: istore 10
    //   552: iload 15
    //   554: sipush 270
    //   557: if_icmpne +6 -> 563
    //   560: goto +192 -> 752
    //   563: iload 9
    //   565: istore 11
    //   567: iload 10
    //   569: istore 13
    //   571: iload 9
    //   573: istore 12
    //   575: iload 10
    //   577: istore 14
    //   579: aload 17
    //   581: invokevirtual 191	android/graphics/Bitmap:recycle	()V
    //   584: iload 10
    //   586: istore 5
    //   588: iload 9
    //   590: istore 4
    //   592: goto -245 -> 347
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_1
    //   598: iload 14
    //   600: istore 5
    //   602: iload 12
    //   604: istore 4
    //   606: goto -259 -> 347
    //   609: aload_0
    //   610: new 193	ywd
    //   613: dup
    //   614: aload_2
    //   615: iload 4
    //   617: iload 5
    //   619: invokestatic 198	axlp:a	()Laxlp;
    //   622: iconst_1
    //   623: invokevirtual 201	axlp:a	(I)I
    //   626: iconst_4
    //   627: imul
    //   628: sipush 1000
    //   631: imul
    //   632: aload_3
    //   633: invokestatic 207	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   636: invokevirtual 210	java/lang/Integer:intValue	()I
    //   639: sipush 1000
    //   642: imul
    //   643: i2l
    //   644: iload 6
    //   646: iload 7
    //   648: invokespecial 213	ywd:<init>	(Ljava/lang/String;IIIJZI)V
    //   651: putfield 215	yvv:jdField_a_of_type_Ywd	Lywd;
    //   654: aload_0
    //   655: getfield 215	yvv:jdField_a_of_type_Ywd	Lywd;
    //   658: bipush 16
    //   660: invokevirtual 216	ywd:a	(I)V
    //   663: new 218	java/util/ArrayList
    //   666: dup
    //   667: invokespecial 219	java/util/ArrayList:<init>	()V
    //   670: astore_2
    //   671: aload_2
    //   672: aload_1
    //   673: invokevirtual 223	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   676: pop
    //   677: aload_0
    //   678: getfield 215	yvv:jdField_a_of_type_Ywd	Lywd;
    //   681: aload_2
    //   682: aload 8
    //   684: invokevirtual 226	ywd:a	(Ljava/util/List;Lyvx;)V
    //   687: return
    //   688: astore 16
    //   690: goto -622 -> 68
    //   693: astore 16
    //   695: aload 18
    //   697: astore 16
    //   699: goto -605 -> 94
    //   702: astore 16
    //   704: goto -462 -> 242
    //   707: astore 16
    //   709: goto -409 -> 300
    //   712: astore 16
    //   714: goto -396 -> 318
    //   717: astore_1
    //   718: aload 18
    //   720: astore 16
    //   722: goto -440 -> 282
    //   725: astore_1
    //   726: goto -444 -> 282
    //   729: astore_1
    //   730: goto -448 -> 282
    //   733: astore 18
    //   735: aconst_null
    //   736: astore 16
    //   738: goto -519 -> 219
    //   741: astore 18
    //   743: goto -524 -> 219
    //   746: aconst_null
    //   747: astore 16
    //   749: goto -655 -> 94
    //   752: iload 5
    //   754: istore 9
    //   756: iload 4
    //   758: istore 10
    //   760: goto -197 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	yvv
    //   0	763	1	paramString1	String
    //   0	763	2	paramString2	String
    //   0	763	3	paramString3	String
    //   0	763	4	paramInt1	int
    //   0	763	5	paramInt2	int
    //   0	763	6	paramBoolean	boolean
    //   0	763	7	paramInt3	int
    //   0	763	8	paramyvx	yvx
    //   407	348	9	i	int
    //   411	348	10	j	int
    //   105	461	11	k	int
    //   57	546	12	m	int
    //   109	461	13	n	int
    //   61	538	14	i1	int
    //   400	158	15	i2	int
    //   36	226	16	localObject1	Object
    //   266	1	16	localException1	java.lang.Exception
    //   269	27	16	localException2	java.lang.Exception
    //   688	1	16	localException3	java.lang.Exception
    //   693	1	16	localException4	java.lang.Exception
    //   697	1	16	localException5	java.lang.Exception
    //   702	1	16	localException6	java.lang.Exception
    //   707	1	16	localException7	java.lang.Exception
    //   712	1	16	localException8	java.lang.Exception
    //   720	28	16	localException9	java.lang.Exception
    //   23	557	17	localObject2	Object
    //   13	78	18	localBitmap	android.graphics.Bitmap
    //   211	508	18	localException10	java.lang.Exception
    //   733	1	18	localException11	java.lang.Exception
    //   741	1	18	localException12	java.lang.Exception
    //   10	363	19	localyvy	yvy
    // Exception table:
    //   from	to	target	type
    //   15	25	211	java/lang/Exception
    //   255	260	266	java/lang/Exception
    //   15	25	274	finally
    //   119	129	336	java/lang/Exception
    //   155	162	336	java/lang/Exception
    //   178	185	336	java/lang/Exception
    //   201	210	336	java/lang/Exception
    //   334	336	336	java/lang/Exception
    //   396	402	336	java/lang/Exception
    //   453	461	336	java/lang/Exception
    //   477	501	336	java/lang/Exception
    //   517	537	336	java/lang/Exception
    //   579	584	336	java/lang/Exception
    //   63	68	595	java/lang/OutOfMemoryError
    //   85	90	595	java/lang/OutOfMemoryError
    //   119	129	595	java/lang/OutOfMemoryError
    //   155	162	595	java/lang/OutOfMemoryError
    //   178	185	595	java/lang/OutOfMemoryError
    //   201	210	595	java/lang/OutOfMemoryError
    //   237	242	595	java/lang/OutOfMemoryError
    //   255	260	595	java/lang/OutOfMemoryError
    //   295	300	595	java/lang/OutOfMemoryError
    //   313	318	595	java/lang/OutOfMemoryError
    //   334	336	595	java/lang/OutOfMemoryError
    //   396	402	595	java/lang/OutOfMemoryError
    //   453	461	595	java/lang/OutOfMemoryError
    //   477	501	595	java/lang/OutOfMemoryError
    //   517	537	595	java/lang/OutOfMemoryError
    //   579	584	595	java/lang/OutOfMemoryError
    //   63	68	688	java/lang/Exception
    //   85	90	693	java/lang/Exception
    //   237	242	702	java/lang/Exception
    //   295	300	707	java/lang/Exception
    //   313	318	712	java/lang/Exception
    //   25	38	717	finally
    //   38	50	725	finally
    //   219	224	729	finally
    //   25	38	733	java/lang/Exception
    //   38	50	741	java/lang/Exception
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = "";
    File localFile = new File(paramString1);
    paramString1 = str;
    if (localFile != null)
    {
      str = localFile.getName();
      paramString1 = str;
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = str.replace(".", "_");
        paramString1 = paramString1 + "_" + localFile.length() + "_" + paramString2;
        paramString1 = paramString1 + ".mp4";
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = b + paramString1;; paramString1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.videostory.capture", 2, "genOupPath" + paramString1);
      }
      return paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, yvx paramyvx)
  {
    yvy localyvy = new yvy(0, "success");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      localyvy.a(940007);
      localyvy.a("Invalid argument");
      paramyvx.b(localyvy);
    }
    do
    {
      return;
      if (paramString3.equals("0"))
      {
        localyvy.a(941003);
        localyvy.a("duration is 0");
        paramyvx.b(localyvy);
        return;
      }
      if (!arof.b(paramString2)) {
        break;
      }
    } while (paramyvx == null);
    localyvy.a(0);
    localyvy.a("success");
    paramyvx.a(localyvy);
    return;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ThreadManager.newFreeThread(new VideoStoryPicToVideo.1(this, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean, paramInt3, paramyvx), "videoStoryPicToVideo", 5).start();
      return;
    }
    a(paramString1, paramString2, paramString3, paramyvx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvv
 * JD-Core Version:    0.7.0.1
 */