import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class anpt
{
  public static int dLu = 1;
  public static int dLv = 2;
  public static int dLw = 4;
  public static int dLx = 8;
  public static int dLy = 16;
  long anO;
  String brand;
  boolean cJo;
  boolean cJp;
  String cgl = "";
  String cgm = "";
  String cgn = "";
  String cgo = "";
  int cpuArch = 0;
  int dLA;
  int dLB;
  int dLC;
  int dLD;
  int dLz;
  String model;
  
  public static boolean ayJ()
  {
    int m = es(Build.CPU_ABI);
    if (Build.VERSION.SDK_INT >= 21)
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      if (arrayOfString != null)
      {
        int n = arrayOfString.length;
        int j = 0;
        for (int i = 0;; i = k | i)
        {
          k = i;
          if (j >= n) {
            break;
          }
          k = es(arrayOfString[j]);
          j += 1;
        }
      }
    }
    int k = 0;
    if ((m == dLx) || ((dLx & k) == dLx)) {}
    do
    {
      do
      {
        return false;
      } while ((m == dLy) || ((dLy & k) == dLy));
      if ((m == dLw) || ((dLw & k) == dLw)) {
        return true;
      }
      if ((m == dLv) || ((dLv & k) == dLv)) {
        return true;
      }
    } while ((m != dLu) && ((k & dLu) != dLu));
    return true;
  }
  
  private boolean ayK()
  {
    Object localObject = System.getProperty("java.library.path");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return false;
      localObject = ((String)localObject).split(":");
      if ((localObject != null) && (localObject.length != 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          if (new File(str + File.separator + "libOpenCL.so").exists()) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  static long bE()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: new 131	java/io/BufferedReader
    //   8: dup
    //   9: new 133	java/io/FileReader
    //   12: dup
    //   13: ldc 135
    //   15: invokespecial 136	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 7
    //   23: lload_3
    //   24: lstore_1
    //   25: aload 7
    //   27: ifnull +92 -> 119
    //   30: aload 7
    //   32: astore 5
    //   34: aload 7
    //   36: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 6
    //   41: aload 6
    //   43: ifnull +217 -> 260
    //   46: aload 7
    //   48: astore 5
    //   50: aload 7
    //   52: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 9
    //   57: aload 6
    //   59: astore 8
    //   61: aload 9
    //   63: astore 6
    //   65: goto -24 -> 41
    //   68: lload_3
    //   69: lstore_1
    //   70: iload_0
    //   71: iconst_m1
    //   72: if_icmpeq +47 -> 119
    //   75: aload 7
    //   77: astore 5
    //   79: aload 8
    //   81: iconst_0
    //   82: iload_0
    //   83: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   86: astore 6
    //   88: lload_3
    //   89: lstore_1
    //   90: aload 6
    //   92: ifnull +27 -> 119
    //   95: lload_3
    //   96: lstore_1
    //   97: aload 7
    //   99: astore 5
    //   101: aload 6
    //   103: invokevirtual 150	java/lang/String:length	()I
    //   106: ifle +13 -> 119
    //   109: aload 7
    //   111: astore 5
    //   113: aload 6
    //   115: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   118: lstore_1
    //   119: lload_1
    //   120: lstore_3
    //   121: aload 7
    //   123: ifnull +10 -> 133
    //   126: aload 7
    //   128: invokevirtual 159	java/io/BufferedReader:close	()V
    //   131: lload_1
    //   132: lstore_3
    //   133: lload_3
    //   134: lreturn
    //   135: aload 7
    //   137: astore 5
    //   139: aload 8
    //   141: bipush 9
    //   143: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   146: istore_0
    //   147: goto -79 -> 68
    //   150: astore 5
    //   152: aload 5
    //   154: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   157: lload_1
    //   158: lreturn
    //   159: astore 8
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 6
    //   166: astore 5
    //   168: ldc 168
    //   170: iconst_1
    //   171: new 103	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   178: ldc 170
    //   180: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 8
    //   185: invokevirtual 171	java/lang/Exception:toString	()Ljava/lang/String;
    //   188: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 6
    //   199: ifnull -66 -> 133
    //   202: aload 6
    //   204: invokevirtual 159	java/io/BufferedReader:close	()V
    //   207: lconst_0
    //   208: lreturn
    //   209: astore 5
    //   211: aload 5
    //   213: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   216: lconst_0
    //   217: lreturn
    //   218: astore 6
    //   220: aconst_null
    //   221: astore 5
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 159	java/io/BufferedReader:close	()V
    //   233: aload 6
    //   235: athrow
    //   236: astore 5
    //   238: aload 5
    //   240: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   243: goto -10 -> 233
    //   246: astore 6
    //   248: goto -25 -> 223
    //   251: astore 8
    //   253: aload 7
    //   255: astore 6
    //   257: goto -93 -> 164
    //   260: aload 8
    //   262: ifnonnull -127 -> 135
    //   265: iconst_m1
    //   266: istore_0
    //   267: goto -199 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	197	0	i	int
    //   24	134	1	l1	long
    //   1	133	3	l2	long
    //   32	106	5	localBufferedReader1	java.io.BufferedReader
    //   150	3	5	localIOException1	java.io.IOException
    //   166	1	5	localObject1	Object
    //   209	3	5	localIOException2	java.io.IOException
    //   221	8	5	localObject2	Object
    //   236	3	5	localIOException3	java.io.IOException
    //   39	164	6	localObject3	Object
    //   218	16	6	localObject4	Object
    //   246	1	6	localObject5	Object
    //   255	1	6	localBufferedReader2	java.io.BufferedReader
    //   21	233	7	localBufferedReader3	java.io.BufferedReader
    //   3	137	8	localObject6	Object
    //   159	25	8	localException1	Exception
    //   251	10	8	localException2	Exception
    //   55	7	9	str	String
    // Exception table:
    //   from	to	target	type
    //   126	131	150	java/io/IOException
    //   5	23	159	java/lang/Exception
    //   202	207	209	java/io/IOException
    //   5	23	218	finally
    //   228	233	236	java/io/IOException
    //   34	41	246	finally
    //   50	57	246	finally
    //   79	88	246	finally
    //   101	109	246	finally
    //   113	119	246	finally
    //   139	147	246	finally
    //   168	197	246	finally
    //   34	41	251	java/lang/Exception
    //   50	57	251	java/lang/Exception
    //   79	88	251	java/lang/Exception
    //   101	109	251	java/lang/Exception
    //   113	119	251	java/lang/Exception
    //   139	147	251	java/lang/Exception
  }
  
  /* Error */
  private void dSZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 184	anpt:cJp	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 10
    //   11: new 103	java/lang/StringBuilder
    //   14: dup
    //   15: sipush 1024
    //   18: invokespecial 187	java/lang/StringBuilder:<init>	(I)V
    //   21: pop
    //   22: ldc2_w 188
    //   25: lstore 5
    //   27: ldc 190
    //   29: fstore_1
    //   30: new 131	java/io/BufferedReader
    //   33: dup
    //   34: new 133	java/io/FileReader
    //   37: dup
    //   38: ldc 192
    //   40: invokespecial 136	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 9
    //   48: aload 9
    //   50: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 10
    //   55: aload 10
    //   57: ifnonnull +78 -> 135
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 184	anpt:cJp	Z
    //   65: lload 5
    //   67: lstore 7
    //   69: fload_1
    //   70: fstore_2
    //   71: aload 9
    //   73: ifnull +14 -> 87
    //   76: aload 9
    //   78: invokevirtual 159	java/io/BufferedReader:close	()V
    //   81: fload_1
    //   82: fstore_2
    //   83: lload 5
    //   85: lstore 7
    //   87: aload_0
    //   88: getfield 184	anpt:cJp	Z
    //   91: ifeq -84 -> 7
    //   94: invokestatic 195	anpt:readNumCores	()I
    //   97: istore_3
    //   98: iload_3
    //   99: ifle +736 -> 835
    //   102: aload_0
    //   103: iload_3
    //   104: putfield 197	anpt:dLD	I
    //   107: aload_0
    //   108: invokespecial 200	anpt:readMaxCpuFreq	()J
    //   111: lstore 5
    //   113: lload 5
    //   115: lconst_0
    //   116: lcmp
    //   117: ifle +737 -> 854
    //   120: aload_0
    //   121: lload 5
    //   123: putfield 202	anpt:anO	J
    //   126: return
    //   127: astore 9
    //   129: aload 9
    //   131: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   134: return
    //   135: aload 10
    //   137: ldc 205
    //   139: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq +104 -> 246
    //   145: aload 10
    //   147: bipush 58
    //   149: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   152: istore_3
    //   153: iload_3
    //   154: iconst_1
    //   155: if_icmple -107 -> 48
    //   158: aload_0
    //   159: aload 10
    //   161: iload_3
    //   162: iconst_1
    //   163: iadd
    //   164: aload 10
    //   166: invokevirtual 150	java/lang/String:length	()I
    //   169: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: putfield 50	anpt:cgl	Ljava/lang/String;
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 50	anpt:cgl	Ljava/lang/String;
    //   180: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   183: putfield 50	anpt:cgl	Ljava/lang/String;
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 50	anpt:cgl	Ljava/lang/String;
    //   191: getstatic 218	java/util/Locale:US	Ljava/util/Locale;
    //   194: invokevirtual 222	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   197: putfield 50	anpt:cgl	Ljava/lang/String;
    //   200: goto -152 -> 48
    //   203: astore 10
    //   205: lload 5
    //   207: lstore 7
    //   209: fload_1
    //   210: fstore_2
    //   211: aload 9
    //   213: ifnull -126 -> 87
    //   216: aload 9
    //   218: invokevirtual 159	java/io/BufferedReader:close	()V
    //   221: lload 5
    //   223: lstore 7
    //   225: fload_1
    //   226: fstore_2
    //   227: goto -140 -> 87
    //   230: astore 9
    //   232: aload 9
    //   234: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   237: lload 5
    //   239: lstore 7
    //   241: fload_1
    //   242: fstore_2
    //   243: goto -156 -> 87
    //   246: aload 10
    //   248: ldc 224
    //   250: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: ifeq +187 -> 440
    //   256: aload 10
    //   258: bipush 58
    //   260: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   263: istore_3
    //   264: iload_3
    //   265: iconst_1
    //   266: if_icmple +50 -> 316
    //   269: aload 10
    //   271: iload_3
    //   272: iconst_1
    //   273: iadd
    //   274: aload 10
    //   276: invokevirtual 150	java/lang/String:length	()I
    //   279: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   282: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   285: astore 11
    //   287: aload 11
    //   289: ifnull +27 -> 316
    //   292: aload 11
    //   294: invokevirtual 150	java/lang/String:length	()I
    //   297: ifle +19 -> 316
    //   300: aload 11
    //   302: ldc 226
    //   304: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   307: ifeq +70 -> 377
    //   310: aload_0
    //   311: bipush 8
    //   313: putfield 231	anpt:dLC	I
    //   316: aload 10
    //   318: ldc 233
    //   320: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   323: ifeq -275 -> 48
    //   326: aload_0
    //   327: iconst_5
    //   328: putfield 231	anpt:dLC	I
    //   331: goto -283 -> 48
    //   334: astore 10
    //   336: lload 5
    //   338: lstore 7
    //   340: fload_1
    //   341: fstore_2
    //   342: aload 9
    //   344: ifnull -257 -> 87
    //   347: aload 9
    //   349: invokevirtual 159	java/io/BufferedReader:close	()V
    //   352: lload 5
    //   354: lstore 7
    //   356: fload_1
    //   357: fstore_2
    //   358: goto -271 -> 87
    //   361: astore 9
    //   363: aload 9
    //   365: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   368: lload 5
    //   370: lstore 7
    //   372: fload_1
    //   373: fstore_2
    //   374: goto -287 -> 87
    //   377: aload_0
    //   378: aload 11
    //   380: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   383: l2i
    //   384: putfield 231	anpt:dLC	I
    //   387: goto -71 -> 316
    //   390: astore 12
    //   392: iconst_1
    //   393: istore_3
    //   394: aload 11
    //   396: invokevirtual 150	java/lang/String:length	()I
    //   399: istore 4
    //   401: iload_3
    //   402: iload 4
    //   404: if_icmpge -88 -> 316
    //   407: aload_0
    //   408: aload 11
    //   410: iconst_0
    //   411: aload 11
    //   413: invokevirtual 150	java/lang/String:length	()I
    //   416: iload_3
    //   417: isub
    //   418: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   421: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   424: l2i
    //   425: putfield 231	anpt:dLC	I
    //   428: goto -112 -> 316
    //   431: astore 12
    //   433: iload_3
    //   434: iconst_1
    //   435: iadd
    //   436: istore_3
    //   437: goto -43 -> 394
    //   440: aload 10
    //   442: ldc 238
    //   444: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   447: ifeq +96 -> 543
    //   450: aload 10
    //   452: bipush 58
    //   454: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   457: istore_3
    //   458: iload_3
    //   459: iconst_1
    //   460: if_icmple -412 -> 48
    //   463: aload_0
    //   464: aload 10
    //   466: iload_3
    //   467: iconst_1
    //   468: iadd
    //   469: aload 10
    //   471: invokevirtual 150	java/lang/String:length	()I
    //   474: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   477: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   480: putfield 52	anpt:cgm	Ljava/lang/String;
    //   483: aload_0
    //   484: aload_0
    //   485: getfield 52	anpt:cgm	Ljava/lang/String;
    //   488: getstatic 218	java/util/Locale:US	Ljava/util/Locale;
    //   491: invokevirtual 222	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   494: putfield 52	anpt:cgm	Ljava/lang/String;
    //   497: goto -449 -> 48
    //   500: astore 10
    //   502: lload 5
    //   504: lstore 7
    //   506: fload_1
    //   507: fstore_2
    //   508: aload 9
    //   510: ifnull -423 -> 87
    //   513: aload 9
    //   515: invokevirtual 159	java/io/BufferedReader:close	()V
    //   518: lload 5
    //   520: lstore 7
    //   522: fload_1
    //   523: fstore_2
    //   524: goto -437 -> 87
    //   527: astore 9
    //   529: aload 9
    //   531: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   534: lload 5
    //   536: lstore 7
    //   538: fload_1
    //   539: fstore_2
    //   540: goto -453 -> 87
    //   543: aload 10
    //   545: ldc 240
    //   547: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   550: ifeq +82 -> 632
    //   553: aload 10
    //   555: bipush 58
    //   557: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   560: istore_3
    //   561: iload_3
    //   562: iconst_1
    //   563: if_icmple -515 -> 48
    //   566: aload_0
    //   567: aload 10
    //   569: iload_3
    //   570: iconst_1
    //   571: iadd
    //   572: aload 10
    //   574: invokevirtual 150	java/lang/String:length	()I
    //   577: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   580: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   583: putfield 54	anpt:cgn	Ljava/lang/String;
    //   586: goto -538 -> 48
    //   589: astore 10
    //   591: lload 5
    //   593: lstore 7
    //   595: fload_1
    //   596: fstore_2
    //   597: aload 9
    //   599: ifnull -512 -> 87
    //   602: aload 9
    //   604: invokevirtual 159	java/io/BufferedReader:close	()V
    //   607: lload 5
    //   609: lstore 7
    //   611: fload_1
    //   612: fstore_2
    //   613: goto -526 -> 87
    //   616: astore 9
    //   618: aload 9
    //   620: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   623: lload 5
    //   625: lstore 7
    //   627: fload_1
    //   628: fstore_2
    //   629: goto -542 -> 87
    //   632: aload 10
    //   634: ldc 242
    //   636: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   639: ifeq +38 -> 677
    //   642: aload_0
    //   643: aload 10
    //   645: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   648: putfield 56	anpt:cgo	Ljava/lang/String;
    //   651: goto -603 -> 48
    //   654: astore 11
    //   656: aload 9
    //   658: astore 10
    //   660: aload 11
    //   662: astore 9
    //   664: aload 10
    //   666: ifnull +8 -> 674
    //   669: aload 10
    //   671: invokevirtual 159	java/io/BufferedReader:close	()V
    //   674: aload 9
    //   676: athrow
    //   677: aload 10
    //   679: ldc 244
    //   681: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   684: ifeq +67 -> 751
    //   687: aload 10
    //   689: bipush 58
    //   691: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   694: istore_3
    //   695: iload_3
    //   696: iconst_1
    //   697: if_icmple -649 -> 48
    //   700: aload 10
    //   702: iload_3
    //   703: iconst_1
    //   704: iadd
    //   705: aload 10
    //   707: invokevirtual 150	java/lang/String:length	()I
    //   710: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   713: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   716: astore 10
    //   718: aload 10
    //   720: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   723: lstore 7
    //   725: lload 7
    //   727: lconst_0
    //   728: lcmp
    //   729: iflt -681 -> 48
    //   732: lconst_1
    //   733: lload 7
    //   735: ladd
    //   736: lload 5
    //   738: lcmp
    //   739: ifle -691 -> 48
    //   742: lconst_1
    //   743: lload 7
    //   745: ladd
    //   746: lstore 5
    //   748: goto -700 -> 48
    //   751: aload 10
    //   753: ldc 246
    //   755: invokevirtual 209	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   758: ifeq -710 -> 48
    //   761: aload 10
    //   763: bipush 58
    //   765: invokevirtual 163	java/lang/String:indexOf	(I)I
    //   768: istore_3
    //   769: iload_3
    //   770: iconst_1
    //   771: if_icmple -723 -> 48
    //   774: aload 10
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: aload 10
    //   781: invokevirtual 150	java/lang/String:length	()I
    //   784: invokevirtual 146	java/lang/String:substring	(II)Ljava/lang/String;
    //   787: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   790: astore 10
    //   792: aload 10
    //   794: invokestatic 252	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   797: fstore_2
    //   798: fload_2
    //   799: fload_1
    //   800: fcmpl
    //   801: ifle +168 -> 969
    //   804: fload_2
    //   805: fstore_1
    //   806: goto -758 -> 48
    //   809: astore 9
    //   811: aload 9
    //   813: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   816: lload 5
    //   818: lstore 7
    //   820: fload_1
    //   821: fstore_2
    //   822: goto -735 -> 87
    //   825: astore 10
    //   827: aload 10
    //   829: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   832: goto -158 -> 674
    //   835: lload 7
    //   837: lconst_0
    //   838: lcmp
    //   839: ifle -732 -> 107
    //   842: lload 7
    //   844: l2i
    //   845: istore_3
    //   846: aload_0
    //   847: iload_3
    //   848: putfield 197	anpt:dLD	I
    //   851: goto -744 -> 107
    //   854: fload_2
    //   855: fconst_0
    //   856: fcmpl
    //   857: ifle -850 -> 7
    //   860: fload_2
    //   861: ldc 253
    //   863: fcmpg
    //   864: ifge +19 -> 883
    //   867: aload_0
    //   868: fload_2
    //   869: f2d
    //   870: ldc2_w 254
    //   873: dmul
    //   874: ldc2_w 256
    //   877: dmul
    //   878: d2l
    //   879: putfield 202	anpt:anO	J
    //   882: return
    //   883: fload_2
    //   884: ldc_w 258
    //   887: fcmpl
    //   888: ifle +19 -> 907
    //   891: aload_0
    //   892: fload_2
    //   893: f2d
    //   894: ldc2_w 259
    //   897: ddiv
    //   898: ldc2_w 256
    //   901: dmul
    //   902: d2l
    //   903: putfield 202	anpt:anO	J
    //   906: return
    //   907: aload_0
    //   908: ldc_w 261
    //   911: fload_2
    //   912: fmul
    //   913: f2l
    //   914: putfield 202	anpt:anO	J
    //   917: return
    //   918: astore 10
    //   920: goto -872 -> 48
    //   923: astore 10
    //   925: goto -877 -> 48
    //   928: astore 9
    //   930: aconst_null
    //   931: astore 10
    //   933: goto -269 -> 664
    //   936: astore 9
    //   938: aconst_null
    //   939: astore 9
    //   941: goto -350 -> 591
    //   944: astore 9
    //   946: aconst_null
    //   947: astore 9
    //   949: goto -447 -> 502
    //   952: astore 9
    //   954: aconst_null
    //   955: astore 9
    //   957: goto -621 -> 336
    //   960: astore 9
    //   962: aload 10
    //   964: astore 9
    //   966: goto -761 -> 205
    //   969: goto -163 -> 806
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	972	0	this	anpt
    //   29	792	1	f1	float
    //   70	842	2	f2	float
    //   97	751	3	i	int
    //   399	6	4	j	int
    //   25	792	5	l1	long
    //   67	776	7	l2	long
    //   46	31	9	localBufferedReader	java.io.BufferedReader
    //   127	90	9	localException1	Exception
    //   230	118	9	localIOException1	java.io.IOException
    //   361	153	9	localIOException2	java.io.IOException
    //   527	76	9	localIOException3	java.io.IOException
    //   616	41	9	localIOException4	java.io.IOException
    //   662	13	9	localObject1	Object
    //   809	3	9	localIOException5	java.io.IOException
    //   928	1	9	localObject2	Object
    //   936	1	9	localException2	Exception
    //   939	1	9	localObject3	Object
    //   944	1	9	localNumberFormatException1	java.lang.NumberFormatException
    //   947	1	9	localObject4	Object
    //   952	1	9	localIOException6	java.io.IOException
    //   955	1	9	localObject5	Object
    //   960	1	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   964	1	9	localObject6	Object
    //   9	156	10	str1	String
    //   203	114	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   334	136	10	localIOException7	java.io.IOException
    //   500	73	10	localNumberFormatException2	java.lang.NumberFormatException
    //   589	55	10	localException3	Exception
    //   658	135	10	localObject7	Object
    //   825	3	10	localIOException8	java.io.IOException
    //   918	1	10	localNumberFormatException3	java.lang.NumberFormatException
    //   923	1	10	localNumberFormatException4	java.lang.NumberFormatException
    //   931	32	10	localObject8	Object
    //   285	127	11	str2	String
    //   654	7	11	localObject9	Object
    //   390	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   431	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   94	98	127	java/lang/Exception
    //   102	107	127	java/lang/Exception
    //   107	113	127	java/lang/Exception
    //   120	126	127	java/lang/Exception
    //   846	851	127	java/lang/Exception
    //   867	882	127	java/lang/Exception
    //   891	906	127	java/lang/Exception
    //   907	917	127	java/lang/Exception
    //   48	55	203	java/io/FileNotFoundException
    //   60	65	203	java/io/FileNotFoundException
    //   135	153	203	java/io/FileNotFoundException
    //   158	200	203	java/io/FileNotFoundException
    //   246	264	203	java/io/FileNotFoundException
    //   269	287	203	java/io/FileNotFoundException
    //   292	316	203	java/io/FileNotFoundException
    //   316	331	203	java/io/FileNotFoundException
    //   377	387	203	java/io/FileNotFoundException
    //   394	401	203	java/io/FileNotFoundException
    //   407	428	203	java/io/FileNotFoundException
    //   440	458	203	java/io/FileNotFoundException
    //   463	497	203	java/io/FileNotFoundException
    //   543	561	203	java/io/FileNotFoundException
    //   566	586	203	java/io/FileNotFoundException
    //   632	651	203	java/io/FileNotFoundException
    //   677	695	203	java/io/FileNotFoundException
    //   700	718	203	java/io/FileNotFoundException
    //   718	725	203	java/io/FileNotFoundException
    //   751	769	203	java/io/FileNotFoundException
    //   774	792	203	java/io/FileNotFoundException
    //   792	798	203	java/io/FileNotFoundException
    //   216	221	230	java/io/IOException
    //   48	55	334	java/io/IOException
    //   60	65	334	java/io/IOException
    //   135	153	334	java/io/IOException
    //   158	200	334	java/io/IOException
    //   246	264	334	java/io/IOException
    //   269	287	334	java/io/IOException
    //   292	316	334	java/io/IOException
    //   316	331	334	java/io/IOException
    //   377	387	334	java/io/IOException
    //   394	401	334	java/io/IOException
    //   407	428	334	java/io/IOException
    //   440	458	334	java/io/IOException
    //   463	497	334	java/io/IOException
    //   543	561	334	java/io/IOException
    //   566	586	334	java/io/IOException
    //   632	651	334	java/io/IOException
    //   677	695	334	java/io/IOException
    //   700	718	334	java/io/IOException
    //   718	725	334	java/io/IOException
    //   751	769	334	java/io/IOException
    //   774	792	334	java/io/IOException
    //   792	798	334	java/io/IOException
    //   347	352	361	java/io/IOException
    //   377	387	390	java/lang/NumberFormatException
    //   407	428	431	java/lang/NumberFormatException
    //   48	55	500	java/lang/NumberFormatException
    //   60	65	500	java/lang/NumberFormatException
    //   135	153	500	java/lang/NumberFormatException
    //   158	200	500	java/lang/NumberFormatException
    //   246	264	500	java/lang/NumberFormatException
    //   269	287	500	java/lang/NumberFormatException
    //   292	316	500	java/lang/NumberFormatException
    //   316	331	500	java/lang/NumberFormatException
    //   394	401	500	java/lang/NumberFormatException
    //   440	458	500	java/lang/NumberFormatException
    //   463	497	500	java/lang/NumberFormatException
    //   543	561	500	java/lang/NumberFormatException
    //   566	586	500	java/lang/NumberFormatException
    //   632	651	500	java/lang/NumberFormatException
    //   677	695	500	java/lang/NumberFormatException
    //   700	718	500	java/lang/NumberFormatException
    //   751	769	500	java/lang/NumberFormatException
    //   774	792	500	java/lang/NumberFormatException
    //   513	518	527	java/io/IOException
    //   48	55	589	java/lang/Exception
    //   60	65	589	java/lang/Exception
    //   135	153	589	java/lang/Exception
    //   158	200	589	java/lang/Exception
    //   246	264	589	java/lang/Exception
    //   269	287	589	java/lang/Exception
    //   292	316	589	java/lang/Exception
    //   316	331	589	java/lang/Exception
    //   377	387	589	java/lang/Exception
    //   394	401	589	java/lang/Exception
    //   407	428	589	java/lang/Exception
    //   440	458	589	java/lang/Exception
    //   463	497	589	java/lang/Exception
    //   543	561	589	java/lang/Exception
    //   566	586	589	java/lang/Exception
    //   632	651	589	java/lang/Exception
    //   677	695	589	java/lang/Exception
    //   700	718	589	java/lang/Exception
    //   718	725	589	java/lang/Exception
    //   751	769	589	java/lang/Exception
    //   774	792	589	java/lang/Exception
    //   792	798	589	java/lang/Exception
    //   602	607	616	java/io/IOException
    //   48	55	654	finally
    //   60	65	654	finally
    //   135	153	654	finally
    //   158	200	654	finally
    //   246	264	654	finally
    //   269	287	654	finally
    //   292	316	654	finally
    //   316	331	654	finally
    //   377	387	654	finally
    //   394	401	654	finally
    //   407	428	654	finally
    //   440	458	654	finally
    //   463	497	654	finally
    //   543	561	654	finally
    //   566	586	654	finally
    //   632	651	654	finally
    //   677	695	654	finally
    //   700	718	654	finally
    //   718	725	654	finally
    //   751	769	654	finally
    //   774	792	654	finally
    //   792	798	654	finally
    //   76	81	809	java/io/IOException
    //   669	674	825	java/io/IOException
    //   718	725	918	java/lang/NumberFormatException
    //   792	798	923	java/lang/NumberFormatException
    //   30	48	928	finally
    //   30	48	936	java/lang/Exception
    //   30	48	944	java/lang/NumberFormatException
    //   30	48	952	java/io/IOException
    //   30	48	960	java/io/FileNotFoundException
  }
  
  private static int es(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if ("arm64-v8a".equalsIgnoreCase(paramString)) {
        return dLw;
      }
      if ("armeabi-v7a".equalsIgnoreCase(paramString)) {
        return dLv;
      }
      if (("armeabi".equalsIgnoreCase(paramString)) || (paramString.indexOf("arm") >= 0)) {
        return dLu;
      }
      if (("x86".equalsIgnoreCase(paramString)) || (paramString.indexOf("x86") >= 0)) {
        return dLx;
      }
    } while ((!"mips".equalsIgnoreCase(paramString)) && (paramString.indexOf("mips") < 0));
    return dLy;
  }
  
  /* Error */
  private long readMaxCpuFreq()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 197	anpt:dLD	I
    //   6: iconst_1
    //   7: if_icmpge +24 -> 31
    //   10: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 168
    //   18: iconst_2
    //   19: ldc_w 280
    //   22: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: bipush 8
    //   28: putfield 197	anpt:dLD	I
    //   31: iconst_0
    //   32: istore_3
    //   33: lconst_0
    //   34: lstore 6
    //   36: lconst_0
    //   37: lstore 4
    //   39: iload_2
    //   40: aload_0
    //   41: getfield 197	anpt:dLD	I
    //   44: if_icmpge +277 -> 321
    //   47: aconst_null
    //   48: astore 13
    //   50: new 131	java/io/BufferedReader
    //   53: dup
    //   54: new 133	java/io/FileReader
    //   57: dup
    //   58: new 103	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 285
    //   68: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc_w 290
    //   78: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokespecial 136	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore 12
    //   92: lload 4
    //   94: lstore 8
    //   96: aload 12
    //   98: ifnull +53 -> 151
    //   101: aload 12
    //   103: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   106: astore 13
    //   108: aload 13
    //   110: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +271 -> 384
    //   116: aload 13
    //   118: invokevirtual 212	java/lang/String:trim	()Ljava/lang/String;
    //   121: astore 13
    //   123: lload 4
    //   125: lstore 8
    //   127: aload 13
    //   129: ifnull +22 -> 151
    //   132: lload 4
    //   134: lstore 8
    //   136: aload 13
    //   138: invokevirtual 150	java/lang/String:length	()I
    //   141: ifle +10 -> 151
    //   144: aload 13
    //   146: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   149: lstore 8
    //   151: iload_3
    //   152: istore_1
    //   153: lload 8
    //   155: lstore 4
    //   157: aload 12
    //   159: ifnull +14 -> 173
    //   162: aload 12
    //   164: invokevirtual 159	java/io/BufferedReader:close	()V
    //   167: lload 8
    //   169: lstore 4
    //   171: iload_3
    //   172: istore_1
    //   173: lload 6
    //   175: lstore 8
    //   177: lload 4
    //   179: lload 6
    //   181: lcmp
    //   182: ifle +7 -> 189
    //   185: lload 4
    //   187: lstore 8
    //   189: iload_2
    //   190: iconst_1
    //   191: iadd
    //   192: istore_2
    //   193: iload_1
    //   194: istore_3
    //   195: lload 8
    //   197: lstore 6
    //   199: goto -160 -> 39
    //   202: astore 12
    //   204: aload 12
    //   206: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   209: iload_3
    //   210: istore_1
    //   211: lload 8
    //   213: lstore 4
    //   215: goto -42 -> 173
    //   218: astore 13
    //   220: aconst_null
    //   221: astore 12
    //   223: ldc 168
    //   225: iconst_1
    //   226: new 103	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 292
    //   236: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload_2
    //   240: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 294
    //   246: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 13
    //   251: invokevirtual 171	java/lang/Exception:toString	()Ljava/lang/String;
    //   254: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload 12
    //   265: ifnull +8 -> 273
    //   268: aload 12
    //   270: invokevirtual 159	java/io/BufferedReader:close	()V
    //   273: iconst_1
    //   274: istore_1
    //   275: lconst_0
    //   276: lstore 4
    //   278: goto -105 -> 173
    //   281: astore 12
    //   283: aload 12
    //   285: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   288: iconst_1
    //   289: istore_1
    //   290: lconst_0
    //   291: lstore 4
    //   293: goto -120 -> 173
    //   296: astore 12
    //   298: aload 13
    //   300: ifnull +8 -> 308
    //   303: aload 13
    //   305: invokevirtual 159	java/io/BufferedReader:close	()V
    //   308: aload 12
    //   310: athrow
    //   311: astore 13
    //   313: aload 13
    //   315: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   318: goto -10 -> 308
    //   321: lload 6
    //   323: lstore 8
    //   325: iload_3
    //   326: ifeq +24 -> 350
    //   329: invokestatic 296	anpt:bE	()J
    //   332: lstore 10
    //   334: lload 6
    //   336: lstore 8
    //   338: lload 10
    //   340: lload 4
    //   342: lcmp
    //   343: ifle +7 -> 350
    //   346: lload 10
    //   348: lstore 8
    //   350: lload 8
    //   352: lreturn
    //   353: astore 14
    //   355: aload 12
    //   357: astore 13
    //   359: aload 14
    //   361: astore 12
    //   363: goto -65 -> 298
    //   366: astore 14
    //   368: aload 12
    //   370: astore 13
    //   372: aload 14
    //   374: astore 12
    //   376: goto -78 -> 298
    //   379: astore 13
    //   381: goto -158 -> 223
    //   384: ldc 48
    //   386: astore 13
    //   388: goto -265 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	anpt
    //   152	138	1	i	int
    //   1	239	2	j	int
    //   32	294	3	k	int
    //   37	304	4	l1	long
    //   34	301	6	l2	long
    //   94	257	8	l3	long
    //   332	15	10	l4	long
    //   90	73	12	localBufferedReader	java.io.BufferedReader
    //   202	3	12	localIOException1	java.io.IOException
    //   221	48	12	localObject1	Object
    //   281	3	12	localIOException2	java.io.IOException
    //   296	60	12	localObject2	Object
    //   361	14	12	localObject3	Object
    //   48	97	13	str1	String
    //   218	86	13	localException1	Exception
    //   311	3	13	localIOException3	java.io.IOException
    //   357	14	13	localObject4	Object
    //   379	1	13	localException2	Exception
    //   386	1	13	str2	String
    //   353	7	14	localObject5	Object
    //   366	7	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   162	167	202	java/io/IOException
    //   50	92	218	java/lang/Exception
    //   268	273	281	java/io/IOException
    //   50	92	296	finally
    //   303	308	311	java/io/IOException
    //   101	123	353	finally
    //   136	151	353	finally
    //   223	263	366	finally
    //   101	123	379	java/lang/Exception
    //   136	151	379	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new anpu()).length;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public String Ap()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    this.dLz = es(Build.CPU_ABI);
    this.dLA = es(Build.CPU_ABI2);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          this.dLB = (es(localObject[i]) | this.dLB);
          i += 1;
        }
      }
    }
    if (Build.BRAND == null)
    {
      localObject = "";
      this.brand = ((String)localObject);
      if (Build.MODEL != null) {
        break label792;
      }
      localObject = "";
      label100:
      this.model = ((String)localObject);
      if ((this.dLz != dLx) && ((this.dLB & dLx) != dLx)) {
        break label799;
      }
      this.cpuArch = 7;
      if ((this.dLA == dLv) || (this.dLA == dLu) || ((this.dLB & dLv) == dLv) || ((this.dLB & dLv) == dLv)) {
        this.cpuArch = 8;
      }
      label189:
      dSZ();
      if (this.cJp)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CPUReport", 2, "getCpuArch not found in android.Build infoArchId:" + this.dLC + " vendorId:" + this.cgn);
        }
        if (this.cpuArch == 0) {}
        switch (this.dLC)
        {
        default: 
          if ((this.cgn != null) && ((this.cgn.equalsIgnoreCase("AuthenticAMD")) || (this.cgn.equalsIgnoreCase("GenuineIntel")))) {
            this.cpuArch = 7;
          }
          label327:
          if ((this.cpuArch == 4) && (this.cgl.contains("aarch64")))
          {
            this.cpuArch = 5;
            label352:
            if ((this.cpuArch != 4) || (this.cgm.contains("neon"))) {
              break label989;
            }
            this.cpuArch = 3;
            if (QLog.isColorLevel()) {
              QLog.i("CPUReport", 2, "getCpuArch armv7a neon not supported " + this.brand + " " + this.model);
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("cpuArch").append("=").append(this.cpuArch).append('\n');
        localStringBuilder.append("CPU_ABI").append("=").append(this.dLz).append('\n');
        localStringBuilder.append("CPU_ABI2").append("=").append(this.dLA).append('\n');
        localStringBuilder.append("SUPPORTED_ABIS").append("=").append(this.dLB).append('\n');
        localStringBuilder.append("brand").append("=").append(this.brand).append('\n');
        localStringBuilder.append("model").append("=").append(this.model).append('\n');
        localStringBuilder.append("infoProcessorName").append("=").append(this.cgl).append('\n');
        localStringBuilder.append("infoArchitectureId").append("=").append(this.dLC).append('\n');
        localStringBuilder.append("infoVendorId").append("=").append(this.cgn).append('\n');
        localStringBuilder.append("infoHardware").append("=").append(this.cgo).append('\n');
        localStringBuilder.append("infoCoreNum").append("=").append(this.dLD).append('\n');
        localStringBuilder.append("infoMaxCoreFreq").append("=").append(this.anO).append('\n');
        localStringBuilder.append("doneReadCpuInfo").append("=").append(this.cJp).append('\n');
        QLog.i("CPUReport", 2, localStringBuilder.toString());
      }
      return localStringBuilder.toString();
      localObject = Build.BRAND;
      break;
      label792:
      localObject = Build.BOARD;
      break label100;
      label799:
      if ((this.dLz == dLw) || ((this.dLB & dLw) == dLw))
      {
        this.cpuArch = 5;
        break label189;
      }
      if ((this.dLz == dLv) || ((this.dLB & dLv) == dLv))
      {
        this.cpuArch = 4;
        break label189;
      }
      if ((this.dLz == dLu) || ((this.dLB & dLu) == dLu))
      {
        this.cpuArch = 1;
        break label189;
      }
      if ((this.dLz != dLy) && ((this.dLB & dLy) != dLy)) {
        break label189;
      }
      this.cpuArch = 6;
      break label189;
      this.cpuArch = 1;
      break label327;
      this.cpuArch = 2;
      break label327;
      this.cpuArch = 4;
      break label327;
      this.cpuArch = 5;
      break label327;
      if ((this.cpuArch != 1) || (!this.cgl.contains("armv6"))) {
        break label352;
      }
      this.cpuArch = 2;
      break label352;
      label989:
      if ((this.cpuArch == 8) && (this.cgm.contains("neon")))
      {
        this.cpuArch = 9;
        if (QLog.isColorLevel()) {
          QLog.i("CPUReport", 2, "getCpuArch x86 neon supported " + this.brand + " " + this.model);
        }
      }
    }
  }
  
  public final boolean ayI()
  {
    return (this.cpuArch == 5) || (this.cpuArch == 4) || (this.cpuArch == 9);
  }
  
  public void report(QQAppInterface paramQQAppInterface)
  {
    try
    {
      Ap();
      this.cJo = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(this.cpuArch));
      localHashMap.put("CPU_ABI", String.valueOf(this.dLz));
      localHashMap.put("CPU_ABI2", String.valueOf(this.dLA));
      localHashMap.put("SUPPORTED_ABIS", String.valueOf(this.dLB));
      localHashMap.put("brand", this.brand);
      localHashMap.put("model", this.model);
      localHashMap.put("infoProcessorName", this.cgl);
      localHashMap.put("infoArchitectureId", String.valueOf(this.dLC));
      localHashMap.put("infoVendorId", this.cgn);
      localHashMap.put("infoHardware", this.cgo);
      localHashMap.put("infoCoreNum", String.valueOf(this.dLD));
      localHashMap.put("infoMaxCoreFreq", Long.toString(this.anO));
      if (this.cJp)
      {
        String str1 = "1";
        localHashMap.put("doneReadCpuInfo", str1);
        if (!this.cJo) {
          break label289;
        }
        str1 = "1";
        localHashMap.put("doneGetField", str1);
        if (!ayK()) {
          break label296;
        }
        str1 = "1";
        localHashMap.put("hasOpenCLSo", str1);
        anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "CPUREPORT_730", true, 0L, 0L, localHashMap, "");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        continue;
        String str2 = "0";
        continue;
        label289:
        str2 = "0";
        continue;
        label296:
        str2 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpt
 * JD-Core Version:    0.7.0.1
 */