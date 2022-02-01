import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anhm
{
  public static Context F = ;
  public static int SCREEN_HEIGHT = 1;
  public static int SCREEN_WIDTH;
  public static String cdR;
  private static String cdS;
  private static String cdT;
  private static String cdU;
  private static String cdV;
  private static String cdW;
  public static int dGc = 640;
  public static int dGd = 480;
  public static final int[] ns = { 960, 640 };
  public static final int[] nt = { 720, 480 };
  public static final int[] nu = { 720, 540, 640, 480, 480, 360, 320, 240 };
  public static final int[] nv = { 1, 1, 0 };
  public static final int[] nw = { 1, 0, 0 };
  public static final int[] nx = { 1, 1, 0 };
  public static final int[] ny = { 1280, 800 };
  public static final int[] nz = { 720, 480 };
  public static long sUin = -1L;
  
  static
  {
    SCREEN_WIDTH = 1;
  }
  
  public static boolean a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.e("GloableValue", 2, "GloableValue[init]context=" + paramContext);
      }
    }
    do
    {
      return false;
      if ((sUin > 0L) && ((paramLong <= 0L) || (sUin == paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("GloableValue", 2, "GloableValue[init]sUin=" + sUin + "uin=" + paramLong);
        }
        return true;
      }
      sUin = paramLong;
    } while ((!c(paramLong, paramContext)) || (!a(paramLong + "", paramContext, paramInt1, paramInt2)));
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 8
    //   12: invokestatic 125	anld:a	()Lanld;
    //   15: getfield 128	anld:JE	Ljava/lang/String;
    //   18: astore 9
    //   20: new 130	com/tencent/maxvideo/common/MessageStruct
    //   23: dup
    //   24: bipush 6
    //   26: invokespecial 133	com/tencent/maxvideo/common/MessageStruct:<init>	(I)V
    //   29: astore 4
    //   31: aload 4
    //   33: new 80	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   40: ldc 135
    //   42: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 137
    //   51: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 9
    //   56: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 139
    //   61: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 141	anhm:cdS	Ljava/lang/String;
    //   67: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 143
    //   72: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: getstatic 145	anhm:cdT	Ljava/lang/String;
    //   78: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 147
    //   83: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: getstatic 149	anhm:cdV	Ljava/lang/String;
    //   89: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 151
    //   94: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: getstatic 153	anhm:cdU	Ljava/lang/String;
    //   100: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 155
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 157	anhm:cdW	Ljava/lang/String;
    //   111: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 159
    //   116: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 164	aniq:dGY	I
    //   122: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 169
    //   127: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: getstatic 172	aniq:dHc	I
    //   133: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 174
    //   138: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_2
    //   142: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc 176
    //   147: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_3
    //   151: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 178
    //   156: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iconst_0
    //   160: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc 180
    //   165: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: putfield 184	com/tencent/maxvideo/common/MessageStruct:mObj0	Ljava/lang/Object;
    //   174: aload 4
    //   176: aconst_null
    //   177: aconst_null
    //   178: invokestatic 190	com/tencent/maxvideo/common/GlobalInit:nativeSyncProcessMsg	(Lcom/tencent/maxvideo/common/MessageStruct;Lcom/tencent/maxvideo/common/MessageStruct;Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 196	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   186: ldc 197
    //   188: invokevirtual 203	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 209	java/io/InputStream:available	()I
    //   196: newarray byte
    //   198: astore 10
    //   200: aload_0
    //   201: aload 10
    //   203: invokevirtual 213	java/io/InputStream:read	([B)I
    //   206: pop
    //   207: new 215	java/io/FileOutputStream
    //   210: dup
    //   211: new 217	java/io/File
    //   214: dup
    //   215: new 80	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   222: aload 9
    //   224: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 219
    //   229: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   238: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   241: astore 4
    //   243: aload 4
    //   245: aload 10
    //   247: invokevirtual 229	java/io/FileOutputStream:write	([B)V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 232	java/io/InputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   268: aload_1
    //   269: invokevirtual 196	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   272: ldc 234
    //   274: invokevirtual 203	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   277: astore_0
    //   278: aload_0
    //   279: invokevirtual 209	java/io/InputStream:available	()I
    //   282: newarray byte
    //   284: astore 4
    //   286: aload_0
    //   287: aload 4
    //   289: invokevirtual 213	java/io/InputStream:read	([B)I
    //   292: pop
    //   293: new 215	java/io/FileOutputStream
    //   296: dup
    //   297: new 217	java/io/File
    //   300: dup
    //   301: new 80	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   308: aload 9
    //   310: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 236
    //   315: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   324: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   327: astore_1
    //   328: aload_1
    //   329: aload 4
    //   331: invokevirtual 229	java/io/FileOutputStream:write	([B)V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 232	java/io/InputStream:close	()V
    //   342: aload_1
    //   343: ifnull +7 -> 350
    //   346: aload_1
    //   347: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   350: iconst_1
    //   351: ireturn
    //   352: astore_0
    //   353: aconst_null
    //   354: astore 4
    //   356: aconst_null
    //   357: astore_0
    //   358: aload_0
    //   359: ifnull +7 -> 366
    //   362: aload_0
    //   363: invokevirtual 232	java/io/InputStream:close	()V
    //   366: aload 4
    //   368: ifnull -100 -> 268
    //   371: aload 4
    //   373: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   376: goto -108 -> 268
    //   379: astore_0
    //   380: goto -112 -> 268
    //   383: astore_0
    //   384: aconst_null
    //   385: astore 4
    //   387: aconst_null
    //   388: astore_0
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 232	java/io/InputStream:close	()V
    //   397: aload 4
    //   399: ifnull -131 -> 268
    //   402: aload 4
    //   404: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   407: goto -139 -> 268
    //   410: astore_0
    //   411: goto -143 -> 268
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_0
    //   417: aload 8
    //   419: astore 4
    //   421: aload_0
    //   422: ifnull +7 -> 429
    //   425: aload_0
    //   426: invokevirtual 232	java/io/InputStream:close	()V
    //   429: aload 4
    //   431: ifnull +8 -> 439
    //   434: aload 4
    //   436: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   439: aload_1
    //   440: athrow
    //   441: astore_0
    //   442: aconst_null
    //   443: astore_0
    //   444: aload 5
    //   446: astore_1
    //   447: aload_0
    //   448: ifnull +7 -> 455
    //   451: aload_0
    //   452: invokevirtual 232	java/io/InputStream:close	()V
    //   455: aload_1
    //   456: ifnull -106 -> 350
    //   459: aload_1
    //   460: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   463: goto -113 -> 350
    //   466: astore_0
    //   467: goto -117 -> 350
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_0
    //   473: aload 7
    //   475: astore_1
    //   476: aload_0
    //   477: ifnull +7 -> 484
    //   480: aload_0
    //   481: invokevirtual 232	java/io/InputStream:close	()V
    //   484: aload_1
    //   485: ifnull -135 -> 350
    //   488: aload_1
    //   489: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   492: goto -142 -> 350
    //   495: astore_0
    //   496: goto -146 -> 350
    //   499: astore_1
    //   500: aconst_null
    //   501: astore_0
    //   502: aload 6
    //   504: astore 4
    //   506: aload_0
    //   507: ifnull +7 -> 514
    //   510: aload_0
    //   511: invokevirtual 232	java/io/InputStream:close	()V
    //   514: aload 4
    //   516: ifnull +8 -> 524
    //   519: aload 4
    //   521: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   524: aload_1
    //   525: athrow
    //   526: astore_0
    //   527: goto -269 -> 258
    //   530: astore_0
    //   531: goto -263 -> 268
    //   534: astore_0
    //   535: goto -169 -> 366
    //   538: astore_0
    //   539: goto -142 -> 397
    //   542: astore_0
    //   543: goto -114 -> 429
    //   546: astore_0
    //   547: goto -108 -> 439
    //   550: astore_0
    //   551: goto -209 -> 342
    //   554: astore_0
    //   555: goto -205 -> 350
    //   558: astore_0
    //   559: goto -104 -> 455
    //   562: astore_0
    //   563: goto -79 -> 484
    //   566: astore_0
    //   567: goto -53 -> 514
    //   570: astore_0
    //   571: goto -47 -> 524
    //   574: astore_1
    //   575: aload 6
    //   577: astore 4
    //   579: goto -73 -> 506
    //   582: astore 5
    //   584: aload_1
    //   585: astore 4
    //   587: aload 5
    //   589: astore_1
    //   590: goto -84 -> 506
    //   593: astore_1
    //   594: aload 7
    //   596: astore_1
    //   597: goto -121 -> 476
    //   600: astore 4
    //   602: goto -126 -> 476
    //   605: astore_1
    //   606: aload 5
    //   608: astore_1
    //   609: goto -162 -> 447
    //   612: astore 4
    //   614: goto -167 -> 447
    //   617: astore_1
    //   618: aload 8
    //   620: astore 4
    //   622: goto -201 -> 421
    //   625: astore_1
    //   626: goto -205 -> 421
    //   629: astore 4
    //   631: aconst_null
    //   632: astore 4
    //   634: goto -245 -> 389
    //   637: astore 8
    //   639: goto -250 -> 389
    //   642: astore 4
    //   644: aconst_null
    //   645: astore 4
    //   647: goto -289 -> 358
    //   650: astore 8
    //   652: goto -294 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	paramString	String
    //   0	655	1	paramContext	Context
    //   0	655	2	paramInt1	int
    //   0	655	3	paramInt2	int
    //   29	557	4	localObject1	Object
    //   600	1	4	localIOException1	java.io.IOException
    //   612	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   620	1	4	localObject2	Object
    //   629	1	4	localIOException2	java.io.IOException
    //   632	1	4	localObject3	Object
    //   642	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   645	1	4	localObject4	Object
    //   1	444	5	localObject5	Object
    //   582	25	5	localObject6	Object
    //   7	569	6	localObject7	Object
    //   4	591	7	localObject8	Object
    //   10	609	8	localObject9	Object
    //   637	1	8	localIOException3	java.io.IOException
    //   650	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	291	9	str	String
    //   198	48	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   182	192	352	java/io/FileNotFoundException
    //   371	376	379	java/io/IOException
    //   182	192	383	java/io/IOException
    //   402	407	410	java/io/IOException
    //   182	192	414	finally
    //   268	278	441	java/io/FileNotFoundException
    //   459	463	466	java/io/IOException
    //   268	278	470	java/io/IOException
    //   488	492	495	java/io/IOException
    //   268	278	499	finally
    //   254	258	526	java/io/IOException
    //   263	268	530	java/io/IOException
    //   362	366	534	java/io/IOException
    //   393	397	538	java/io/IOException
    //   425	429	542	java/io/IOException
    //   434	439	546	java/io/IOException
    //   338	342	550	java/io/IOException
    //   346	350	554	java/io/IOException
    //   451	455	558	java/io/IOException
    //   480	484	562	java/io/IOException
    //   510	514	566	java/io/IOException
    //   519	524	570	java/io/IOException
    //   278	328	574	finally
    //   328	334	582	finally
    //   278	328	593	java/io/IOException
    //   328	334	600	java/io/IOException
    //   278	328	605	java/io/FileNotFoundException
    //   328	334	612	java/io/FileNotFoundException
    //   192	243	617	finally
    //   243	250	625	finally
    //   192	243	629	java/io/IOException
    //   243	250	637	java/io/IOException
    //   192	243	642	java/io/FileNotFoundException
    //   243	250	650	java/io/FileNotFoundException
  }
  
  public static void ahH()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.getContext().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void ahI()
  {
    try
    {
      ((AudioManager)VideoEnvironment.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean c(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            bool1 = aqhq.aCJ();
            if (!bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
              }
              return bool1;
            }
            paramContext = anld.a().JE;
            if (!TextUtils.isEmpty(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("initDirs", 2, "sdcardDirPath = empty");
          return false;
          if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + paramContext);
          }
          localFile = new File(paramContext);
          if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        return false;
        cdR = paramContext + File.separator + "trimvideo";
        File localFile = new File(cdR);
        bool1 = localFile.mkdirs();
        bool2 = localFile.isDirectory();
        if (QLog.isColorLevel()) {
          QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
        }
      } while ((!bool1) && (!bool2));
      cdV = paramContext + "/Product";
      cdU = paramContext + "/Material";
      cdW = cdU + "/ProcessedMaterial";
      cdS = paramContext + "/log.txt";
      cdT = paramContext + File.separator + "Source";
      paramContext = new File(cdT);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
      }
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public static void unInit()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    sUin = -1L;
  }
  
  public static String zR()
  {
    return cdT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */