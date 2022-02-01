import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;

public class imm
{
  private static String Ou;
  static boolean Sy;
  static long lU;
  static int mChip;
  public static int mCoreNumber;
  static int mCpuArchitecture;
  static String mFeature;
  static String mHardware;
  static boolean mIsMarvell;
  static boolean mIsSupportSharpAudio;
  static boolean mIsSupportSharpVideo;
  public static long mMaxCpuFreq;
  static int mOpenGLVersion;
  static String mProcessorName = "";
  static String mVendorId;
  static boolean mfReadCpuInfo;
  static long mgMaxCpuFreq;
  static int mgNumCores;
  public int mScreenHeight = 480;
  public int mScreenWidth = 320;
  public int mdispHeight = 240;
  public int mdispWidth = 320;
  
  static
  {
    mFeature = "";
    mCpuArchitecture = 5;
    mCoreNumber = 1;
    mOpenGLVersion = 2;
    mChip = 1;
    mIsSupportSharpAudio = true;
    mIsSupportSharpVideo = true;
    getCpuInfo();
  }
  
  /* Error */
  public static long bD()
  {
    // Byte code:
    //   0: getstatic 73	imm:Sy	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 75	imm:lU	J
    //   9: lreturn
    //   10: aconst_null
    //   11: astore_2
    //   12: new 77	java/io/BufferedReader
    //   15: dup
    //   16: new 79	java/io/FileReader
    //   19: dup
    //   20: ldc 81
    //   22: invokespecial 84	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnonnull +21 -> 60
    //   42: aload_3
    //   43: astore_2
    //   44: iconst_1
    //   45: putstatic 73	imm:Sy	Z
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokevirtual 94	java/io/BufferedReader:close	()V
    //   56: getstatic 75	imm:lU	J
    //   59: lreturn
    //   60: aload_3
    //   61: astore_2
    //   62: aload 4
    //   64: ldc 96
    //   66: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: ifeq -40 -> 29
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: bipush 58
    //   78: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   81: istore_0
    //   82: iload_0
    //   83: iconst_1
    //   84: if_icmple -42 -> 42
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: iload_0
    //   92: iconst_1
    //   93: iadd
    //   94: aload 4
    //   96: invokevirtual 110	java/lang/String:length	()I
    //   99: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   102: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   105: astore 5
    //   107: iconst_0
    //   108: istore_0
    //   109: aload_3
    //   110: astore_2
    //   111: iload_0
    //   112: aload 4
    //   114: invokevirtual 110	java/lang/String:length	()I
    //   117: if_icmpge +161 -> 278
    //   120: iload_0
    //   121: istore_1
    //   122: aload_3
    //   123: astore_2
    //   124: aload 5
    //   126: iload_0
    //   127: invokevirtual 121	java/lang/String:charAt	(I)C
    //   130: bipush 48
    //   132: if_icmplt +18 -> 150
    //   135: aload_3
    //   136: astore_2
    //   137: aload 5
    //   139: iload_0
    //   140: invokevirtual 121	java/lang/String:charAt	(I)C
    //   143: bipush 57
    //   145: if_icmple +77 -> 222
    //   148: iload_0
    //   149: istore_1
    //   150: aload_3
    //   151: astore_2
    //   152: aload 5
    //   154: iconst_0
    //   155: iload_1
    //   156: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   162: astore 4
    //   164: aload 4
    //   166: ifnull -124 -> 42
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: invokevirtual 110	java/lang/String:length	()I
    //   176: ifle -134 -> 42
    //   179: aload_3
    //   180: astore_2
    //   181: aload 4
    //   183: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   186: putstatic 75	imm:lU	J
    //   189: goto -147 -> 42
    //   192: astore_2
    //   193: aload_3
    //   194: astore_2
    //   195: ldc 129
    //   197: iconst_1
    //   198: ldc 131
    //   200: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_3
    //   204: ifnull -148 -> 56
    //   207: aload_3
    //   208: invokevirtual 94	java/io/BufferedReader:close	()V
    //   211: goto -155 -> 56
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   219: goto -163 -> 56
    //   222: iload_0
    //   223: iconst_1
    //   224: iadd
    //   225: istore_0
    //   226: goto -117 -> 109
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   234: goto -178 -> 56
    //   237: astore 4
    //   239: aload_2
    //   240: astore_3
    //   241: aload 4
    //   243: astore_2
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 94	java/io/BufferedReader:close	()V
    //   252: aload_2
    //   253: athrow
    //   254: astore_3
    //   255: aload_3
    //   256: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore 4
    //   264: aload_2
    //   265: astore_3
    //   266: aload 4
    //   268: astore_2
    //   269: goto -25 -> 244
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_3
    //   275: goto -82 -> 193
    //   278: iconst_0
    //   279: istore_1
    //   280: goto -130 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	145	0	i	int
    //   121	159	1	j	int
    //   11	170	2	localObject1	Object
    //   192	1	2	localException1	Exception
    //   194	1	2	localObject2	Object
    //   214	2	2	localIOException1	java.io.IOException
    //   229	11	2	localIOException2	java.io.IOException
    //   243	26	2	localObject3	Object
    //   272	1	2	localException2	Exception
    //   28	221	3	localObject4	Object
    //   254	2	3	localIOException3	java.io.IOException
    //   265	10	3	localObject5	Object
    //   35	147	4	str1	String
    //   237	5	4	localObject6	Object
    //   262	5	4	localObject7	Object
    //   105	48	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	37	192	java/lang/Exception
    //   44	48	192	java/lang/Exception
    //   62	72	192	java/lang/Exception
    //   74	82	192	java/lang/Exception
    //   89	107	192	java/lang/Exception
    //   111	120	192	java/lang/Exception
    //   124	135	192	java/lang/Exception
    //   137	148	192	java/lang/Exception
    //   152	164	192	java/lang/Exception
    //   171	179	192	java/lang/Exception
    //   181	189	192	java/lang/Exception
    //   207	211	214	java/io/IOException
    //   52	56	229	java/io/IOException
    //   12	29	237	finally
    //   248	252	254	java/io/IOException
    //   31	37	262	finally
    //   44	48	262	finally
    //   62	72	262	finally
    //   74	82	262	finally
    //   89	107	262	finally
    //   111	120	262	finally
    //   124	135	262	finally
    //   137	148	262	finally
    //   152	164	262	finally
    //   171	179	262	finally
    //   181	189	262	finally
    //   195	203	262	finally
    //   12	29	272	java/lang/Exception
  }
  
  /* Error */
  static long bE()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 77	java/io/BufferedReader
    //   8: dup
    //   9: new 79	java/io/FileReader
    //   12: dup
    //   13: ldc 143
    //   15: invokespecial 84	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 9
    //   23: lload_3
    //   24: lstore_1
    //   25: aload 9
    //   27: ifnull +92 -> 119
    //   30: aload 9
    //   32: astore 7
    //   34: aload 9
    //   36: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 8
    //   41: aload 8
    //   43: ifnull +260 -> 303
    //   46: aload 9
    //   48: astore 7
    //   50: aload 9
    //   52: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 11
    //   57: aload 8
    //   59: astore 10
    //   61: aload 11
    //   63: astore 8
    //   65: goto -24 -> 41
    //   68: lload_3
    //   69: lstore_1
    //   70: iload_0
    //   71: iconst_m1
    //   72: if_icmpeq +47 -> 119
    //   75: aload 9
    //   77: astore 7
    //   79: aload 10
    //   81: iconst_0
    //   82: iload_0
    //   83: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   86: astore 8
    //   88: lload_3
    //   89: lstore_1
    //   90: aload 8
    //   92: ifnull +27 -> 119
    //   95: lload_3
    //   96: lstore_1
    //   97: aload 9
    //   99: astore 7
    //   101: aload 8
    //   103: invokevirtual 110	java/lang/String:length	()I
    //   106: ifle +13 -> 119
    //   109: aload 9
    //   111: astore 7
    //   113: aload 8
    //   115: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   118: lstore_1
    //   119: lload_1
    //   120: lstore 5
    //   122: aload 9
    //   124: ifnull +11 -> 135
    //   127: aload 9
    //   129: invokevirtual 94	java/io/BufferedReader:close	()V
    //   132: lload_1
    //   133: lstore 5
    //   135: ldc 129
    //   137: new 145	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   144: ldc 148
    //   146: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: lload 5
    //   151: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 164	igd:aK	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: lload 5
    //   162: lreturn
    //   163: aload 9
    //   165: astore 7
    //   167: aload 10
    //   169: bipush 9
    //   171: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   174: istore_0
    //   175: goto -107 -> 68
    //   178: astore 7
    //   180: aload 7
    //   182: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   185: lload_1
    //   186: lstore 5
    //   188: goto -53 -> 135
    //   191: astore 10
    //   193: aconst_null
    //   194: astore 8
    //   196: aload 8
    //   198: astore 7
    //   200: ldc 129
    //   202: new 145	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   209: ldc 166
    //   211: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 10
    //   216: invokevirtual 167	java/lang/Exception:toString	()Ljava/lang/String;
    //   219: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 173	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   228: pop
    //   229: lload_3
    //   230: lstore 5
    //   232: aload 8
    //   234: ifnull -99 -> 135
    //   237: aload 8
    //   239: invokevirtual 94	java/io/BufferedReader:close	()V
    //   242: lload_3
    //   243: lstore 5
    //   245: goto -110 -> 135
    //   248: astore 7
    //   250: aload 7
    //   252: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   255: lload_3
    //   256: lstore 5
    //   258: goto -123 -> 135
    //   261: astore 8
    //   263: aconst_null
    //   264: astore 7
    //   266: aload 7
    //   268: ifnull +8 -> 276
    //   271: aload 7
    //   273: invokevirtual 94	java/io/BufferedReader:close	()V
    //   276: aload 8
    //   278: athrow
    //   279: astore 7
    //   281: aload 7
    //   283: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   286: goto -10 -> 276
    //   289: astore 8
    //   291: goto -25 -> 266
    //   294: astore 10
    //   296: aload 9
    //   298: astore 8
    //   300: goto -104 -> 196
    //   303: aload 10
    //   305: ifnonnull -142 -> 163
    //   308: iconst_m1
    //   309: istore_0
    //   310: goto -242 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	240	0	i	int
    //   24	162	1	l1	long
    //   1	255	3	l2	long
    //   120	137	5	l3	long
    //   32	134	7	localBufferedReader1	java.io.BufferedReader
    //   178	3	7	localIOException1	java.io.IOException
    //   198	1	7	localObject1	Object
    //   248	3	7	localIOException2	java.io.IOException
    //   264	8	7	localObject2	Object
    //   279	3	7	localIOException3	java.io.IOException
    //   39	199	8	localObject3	Object
    //   261	16	8	localObject4	Object
    //   289	1	8	localObject5	Object
    //   298	1	8	localBufferedReader2	java.io.BufferedReader
    //   21	276	9	localBufferedReader3	java.io.BufferedReader
    //   3	165	10	localObject6	Object
    //   191	24	10	localException1	Exception
    //   294	10	10	localException2	Exception
    //   55	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   127	132	178	java/io/IOException
    //   5	23	191	java/lang/Exception
    //   237	242	248	java/io/IOException
    //   5	23	261	finally
    //   271	276	279	java/io/IOException
    //   34	41	289	finally
    //   50	57	289	finally
    //   79	88	289	finally
    //   101	109	289	finally
    //   113	119	289	finally
    //   167	175	289	finally
    //   200	229	289	finally
    //   34	41	294	java/lang/Exception
    //   50	57	294	java/lang/Exception
    //   79	88	294	java/lang/Exception
    //   101	109	294	java/lang/Exception
    //   113	119	294	java/lang/Exception
    //   167	175	294	java/lang/Exception
  }
  
  public static String gU()
  {
    getCpuInfo();
    return Ou;
  }
  
  public static String gV()
  {
    getCpuInfo();
    return mFeature;
  }
  
  public static String gW()
  {
    getCpuInfo();
    return mVendorId;
  }
  
  public static String getCPUName()
  {
    getCpuInfo();
    return mProcessorName;
  }
  
  public static int getCpuArchitecture()
  {
    getCpuInfo();
    return mChip;
  }
  
  /* Error */
  public static void getCpuInfo()
  {
    // Byte code:
    //   0: getstatic 188	imm:mfReadCpuInfo	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 189
    //   14: lstore 4
    //   16: ldc 191
    //   18: fstore_0
    //   19: new 145	java/lang/StringBuilder
    //   22: dup
    //   23: sipush 1024
    //   26: invokespecial 194	java/lang/StringBuilder:<init>	(I)V
    //   29: astore 10
    //   31: new 77	java/io/BufferedReader
    //   34: dup
    //   35: new 79	java/io/FileReader
    //   38: dup
    //   39: ldc 196
    //   41: invokespecial 84	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnonnull +269 -> 327
    //   61: iconst_1
    //   62: putstatic 188	imm:mfReadCpuInfo	Z
    //   65: lload 4
    //   67: lstore 6
    //   69: fload_0
    //   70: fstore_1
    //   71: aload 8
    //   73: ifnull +14 -> 87
    //   76: aload 8
    //   78: invokevirtual 94	java/io/BufferedReader:close	()V
    //   81: fload_0
    //   82: fstore_1
    //   83: lload 4
    //   85: lstore 6
    //   87: invokestatic 199	imm:readNumCores	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1163 -> 1255
    //   95: iload_2
    //   96: putstatic 42	imm:mCoreNumber	I
    //   99: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 205
    //   109: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 42	imm:mCoreNumber	I
    //   118: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 210
    //   126: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 213	imm:readMaxCpuFreq	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1164 -> 1303
    //   142: lload 4
    //   144: putstatic 215	imm:mMaxCpuFreq	J
    //   147: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 217
    //   157: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 215	imm:mMaxCpuFreq	J
    //   166: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 210
    //   174: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 42	imm:mCoreNumber	I
    //   181: ifle +11 -> 192
    //   184: getstatic 215	imm:mMaxCpuFreq	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1214 -> 1403
    //   192: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 219
    //   202: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 42	imm:mCoreNumber	I
    //   211: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 221
    //   219: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 215	imm:mMaxCpuFreq	J
    //   228: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 210
    //   236: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 188	imm:mfReadCpuInfo	Z
    //   244: invokestatic 224	imm:readCpuArchitecture	()I
    //   247: putstatic 46	imm:mChip	I
    //   250: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 226
    //   260: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 46	imm:mChip	I
    //   269: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 228
    //   277: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 50	imm:mIsSupportSharpVideo	Z
    //   286: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 233
    //   294: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 48	imm:mIsSupportSharpAudio	Z
    //   303: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 210
    //   311: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 129
    //   317: iconst_2
    //   318: aload 10
    //   320: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: aload 9
    //   329: ldc 235
    //   331: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   334: ifeq +88 -> 422
    //   337: aload 9
    //   339: bipush 58
    //   341: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   344: istore_2
    //   345: iload_2
    //   346: iconst_1
    //   347: if_icmple -298 -> 49
    //   350: aload 9
    //   352: iload_2
    //   353: iconst_1
    //   354: iadd
    //   355: aload 9
    //   357: invokevirtual 110	java/lang/String:length	()I
    //   360: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   366: ldc 237
    //   368: ldc 34
    //   370: invokevirtual 241	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   373: putstatic 176	imm:Ou	Ljava/lang/String;
    //   376: goto -327 -> 49
    //   379: astore 9
    //   381: lload 4
    //   383: lstore 6
    //   385: fload_0
    //   386: fstore_1
    //   387: aload 8
    //   389: ifnull -302 -> 87
    //   392: aload 8
    //   394: invokevirtual 94	java/io/BufferedReader:close	()V
    //   397: lload 4
    //   399: lstore 6
    //   401: fload_0
    //   402: fstore_1
    //   403: goto -316 -> 87
    //   406: astore 8
    //   408: aload 8
    //   410: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   413: lload 4
    //   415: lstore 6
    //   417: fload_0
    //   418: fstore_1
    //   419: goto -332 -> 87
    //   422: aload 9
    //   424: ldc 243
    //   426: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   429: ifeq +134 -> 563
    //   432: aload 9
    //   434: bipush 58
    //   436: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   439: istore_2
    //   440: iload_2
    //   441: iconst_1
    //   442: if_icmple -393 -> 49
    //   445: aload 9
    //   447: iload_2
    //   448: iconst_1
    //   449: iadd
    //   450: aload 9
    //   452: invokevirtual 110	java/lang/String:length	()I
    //   455: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   458: putstatic 36	imm:mProcessorName	Ljava/lang/String;
    //   461: getstatic 36	imm:mProcessorName	Ljava/lang/String;
    //   464: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   467: putstatic 36	imm:mProcessorName	Ljava/lang/String;
    //   470: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq -424 -> 49
    //   476: aload 10
    //   478: ldc 245
    //   480: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 10
    //   486: getstatic 36	imm:mProcessorName	Ljava/lang/String;
    //   489: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: ldc 247
    //   497: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 10
    //   503: aload 9
    //   505: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 10
    //   511: ldc 210
    //   513: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: goto -468 -> 49
    //   520: astore 9
    //   522: lload 4
    //   524: lstore 6
    //   526: fload_0
    //   527: fstore_1
    //   528: aload 8
    //   530: ifnull -443 -> 87
    //   533: aload 8
    //   535: invokevirtual 94	java/io/BufferedReader:close	()V
    //   538: lload 4
    //   540: lstore 6
    //   542: fload_0
    //   543: fstore_1
    //   544: goto -457 -> 87
    //   547: astore 8
    //   549: aload 8
    //   551: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   554: lload 4
    //   556: lstore 6
    //   558: fload_0
    //   559: fstore_1
    //   560: goto -473 -> 87
    //   563: aload 9
    //   565: ldc 249
    //   567: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   570: ifeq +230 -> 800
    //   573: aload 9
    //   575: bipush 58
    //   577: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   580: istore_2
    //   581: iload_2
    //   582: iconst_1
    //   583: if_icmple +49 -> 632
    //   586: aload 9
    //   588: iload_2
    //   589: iconst_1
    //   590: iadd
    //   591: aload 9
    //   593: invokevirtual 110	java/lang/String:length	()I
    //   596: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   599: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   602: astore 11
    //   604: aload 11
    //   606: ifnull +26 -> 632
    //   609: aload 11
    //   611: invokevirtual 110	java/lang/String:length	()I
    //   614: ifle +18 -> 632
    //   617: aload 11
    //   619: ldc 251
    //   621: invokevirtual 254	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   624: ifeq +117 -> 741
    //   627: bipush 8
    //   629: putstatic 40	imm:mCpuArchitecture	I
    //   632: aload 9
    //   634: ldc_w 256
    //   637: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   640: ifeq +7 -> 647
    //   643: iconst_5
    //   644: putstatic 40	imm:mCpuArchitecture	I
    //   647: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq -601 -> 49
    //   653: aload 10
    //   655: ldc_w 262
    //   658: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 10
    //   664: getstatic 40	imm:mCpuArchitecture	I
    //   667: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 10
    //   673: ldc 247
    //   675: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 10
    //   681: aload 9
    //   683: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 10
    //   689: ldc 210
    //   691: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: goto -646 -> 49
    //   698: astore 9
    //   700: lload 4
    //   702: lstore 6
    //   704: fload_0
    //   705: fstore_1
    //   706: aload 8
    //   708: ifnull -621 -> 87
    //   711: aload 8
    //   713: invokevirtual 94	java/io/BufferedReader:close	()V
    //   716: lload 4
    //   718: lstore 6
    //   720: fload_0
    //   721: fstore_1
    //   722: goto -635 -> 87
    //   725: astore 8
    //   727: aload 8
    //   729: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   732: lload 4
    //   734: lstore 6
    //   736: fload_0
    //   737: fstore_1
    //   738: goto -651 -> 87
    //   741: aload 11
    //   743: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   746: l2i
    //   747: putstatic 40	imm:mCpuArchitecture	I
    //   750: goto -118 -> 632
    //   753: astore 12
    //   755: iconst_1
    //   756: istore_2
    //   757: aload 11
    //   759: invokevirtual 110	java/lang/String:length	()I
    //   762: istore_3
    //   763: iload_2
    //   764: iload_3
    //   765: if_icmpge -133 -> 632
    //   768: aload 11
    //   770: iconst_0
    //   771: aload 11
    //   773: invokevirtual 110	java/lang/String:length	()I
    //   776: iload_2
    //   777: isub
    //   778: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   781: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   784: l2i
    //   785: putstatic 40	imm:mCpuArchitecture	I
    //   788: goto -156 -> 632
    //   791: astore 12
    //   793: iload_2
    //   794: iconst_1
    //   795: iadd
    //   796: istore_2
    //   797: goto -40 -> 757
    //   800: aload 9
    //   802: ldc_w 264
    //   805: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   808: ifeq +109 -> 917
    //   811: aload 9
    //   813: bipush 58
    //   815: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   818: istore_2
    //   819: iload_2
    //   820: iconst_1
    //   821: if_icmple +22 -> 843
    //   824: aload 9
    //   826: iload_2
    //   827: iconst_1
    //   828: iadd
    //   829: aload 9
    //   831: invokevirtual 110	java/lang/String:length	()I
    //   834: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   837: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   840: putstatic 38	imm:mFeature	Ljava/lang/String;
    //   843: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq -797 -> 49
    //   849: aload 10
    //   851: ldc_w 266
    //   854: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 10
    //   860: getstatic 38	imm:mFeature	Ljava/lang/String;
    //   863: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload 10
    //   869: ldc 247
    //   871: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 10
    //   877: aload 9
    //   879: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 10
    //   885: ldc 210
    //   887: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: goto -842 -> 49
    //   894: astore 10
    //   896: aload 8
    //   898: astore 9
    //   900: aload 10
    //   902: astore 8
    //   904: aload 9
    //   906: ifnull +8 -> 914
    //   909: aload 9
    //   911: invokevirtual 94	java/io/BufferedReader:close	()V
    //   914: aload 8
    //   916: athrow
    //   917: aload 9
    //   919: ldc_w 268
    //   922: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   925: ifeq +86 -> 1011
    //   928: aload 9
    //   930: bipush 58
    //   932: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   935: istore_2
    //   936: iload_2
    //   937: iconst_1
    //   938: if_icmple +22 -> 960
    //   941: aload 9
    //   943: iload_2
    //   944: iconst_1
    //   945: iadd
    //   946: aload 9
    //   948: invokevirtual 110	java/lang/String:length	()I
    //   951: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   954: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   957: putstatic 180	imm:mVendorId	Ljava/lang/String;
    //   960: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   963: ifeq -914 -> 49
    //   966: aload 10
    //   968: ldc_w 270
    //   971: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload 10
    //   977: getstatic 180	imm:mVendorId	Ljava/lang/String;
    //   980: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload 10
    //   986: ldc 247
    //   988: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: pop
    //   992: aload 10
    //   994: aload 9
    //   996: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload 10
    //   1002: ldc 210
    //   1004: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: goto -959 -> 49
    //   1011: aload 9
    //   1013: ldc 235
    //   1015: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1018: ifeq +77 -> 1095
    //   1021: aload 9
    //   1023: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   1026: putstatic 272	imm:mHardware	Ljava/lang/String;
    //   1029: aload 9
    //   1031: ldc_w 274
    //   1034: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1037: ifeq +7 -> 1044
    //   1040: iconst_1
    //   1041: putstatic 276	imm:mIsMarvell	Z
    //   1044: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1047: ifeq -998 -> 49
    //   1050: aload 10
    //   1052: ldc_w 278
    //   1055: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 10
    //   1061: getstatic 276	imm:mIsMarvell	Z
    //   1064: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload 10
    //   1070: ldc 247
    //   1072: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 10
    //   1078: aload 9
    //   1080: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 10
    //   1086: ldc 210
    //   1088: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: goto -1043 -> 49
    //   1095: aload 9
    //   1097: ldc_w 280
    //   1100: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1103: ifeq +67 -> 1170
    //   1106: aload 9
    //   1108: bipush 58
    //   1110: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   1113: istore_2
    //   1114: iload_2
    //   1115: iconst_1
    //   1116: if_icmple -1067 -> 49
    //   1119: aload 9
    //   1121: iload_2
    //   1122: iconst_1
    //   1123: iadd
    //   1124: aload 9
    //   1126: invokevirtual 110	java/lang/String:length	()I
    //   1129: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   1132: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   1135: astore 9
    //   1137: aload 9
    //   1139: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1142: lstore 6
    //   1144: lload 6
    //   1146: lconst_0
    //   1147: lcmp
    //   1148: iflt -1099 -> 49
    //   1151: lconst_1
    //   1152: lload 6
    //   1154: ladd
    //   1155: lload 4
    //   1157: lcmp
    //   1158: ifle -1109 -> 49
    //   1161: lconst_1
    //   1162: lload 6
    //   1164: ladd
    //   1165: lstore 4
    //   1167: goto -1118 -> 49
    //   1170: aload 9
    //   1172: ldc_w 282
    //   1175: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1178: ifeq -1129 -> 49
    //   1181: aload 9
    //   1183: bipush 58
    //   1185: invokevirtual 106	java/lang/String:indexOf	(I)I
    //   1188: istore_2
    //   1189: iload_2
    //   1190: iconst_1
    //   1191: if_icmple -1142 -> 49
    //   1194: aload 9
    //   1196: iload_2
    //   1197: iconst_1
    //   1198: iadd
    //   1199: aload 9
    //   1201: invokevirtual 110	java/lang/String:length	()I
    //   1204: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   1207: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   1210: astore 9
    //   1212: aload 9
    //   1214: invokestatic 288	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1217: fstore_1
    //   1218: fload_1
    //   1219: fload_0
    //   1220: fcmpl
    //   1221: ifle +232 -> 1453
    //   1224: fload_1
    //   1225: fstore_0
    //   1226: goto -1177 -> 49
    //   1229: astore 8
    //   1231: aload 8
    //   1233: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   1236: lload 4
    //   1238: lstore 6
    //   1240: fload_0
    //   1241: fstore_1
    //   1242: goto -1155 -> 87
    //   1245: astore 9
    //   1247: aload 9
    //   1249: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   1252: goto -338 -> 914
    //   1255: lload 6
    //   1257: lconst_0
    //   1258: lcmp
    //   1259: ifle -1129 -> 130
    //   1262: lload 6
    //   1264: l2i
    //   1265: putstatic 42	imm:mCoreNumber	I
    //   1268: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq -1141 -> 130
    //   1274: aload 10
    //   1276: ldc_w 290
    //   1279: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload 10
    //   1285: getstatic 42	imm:mCoreNumber	I
    //   1288: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload 10
    //   1294: ldc 210
    //   1296: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: goto -1170 -> 130
    //   1303: fload_1
    //   1304: fconst_0
    //   1305: fcmpl
    //   1306: ifle -1128 -> 178
    //   1309: fload_1
    //   1310: ldc_w 291
    //   1313: fcmpg
    //   1314: ifge +52 -> 1366
    //   1317: fload_1
    //   1318: f2d
    //   1319: ldc2_w 292
    //   1322: dmul
    //   1323: ldc2_w 294
    //   1326: dmul
    //   1327: d2l
    //   1328: putstatic 215	imm:mMaxCpuFreq	J
    //   1331: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1334: ifeq -1156 -> 178
    //   1337: aload 10
    //   1339: ldc_w 297
    //   1342: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 10
    //   1348: getstatic 215	imm:mMaxCpuFreq	J
    //   1351: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: aload 10
    //   1357: ldc 210
    //   1359: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: pop
    //   1363: goto -1185 -> 178
    //   1366: fload_1
    //   1367: ldc_w 298
    //   1370: fcmpl
    //   1371: ifle +20 -> 1391
    //   1374: fload_1
    //   1375: f2d
    //   1376: ldc2_w 299
    //   1379: ddiv
    //   1380: ldc2_w 294
    //   1383: dmul
    //   1384: d2l
    //   1385: putstatic 215	imm:mMaxCpuFreq	J
    //   1388: goto -57 -> 1331
    //   1391: ldc_w 301
    //   1394: fload_1
    //   1395: fmul
    //   1396: f2l
    //   1397: putstatic 215	imm:mMaxCpuFreq	J
    //   1400: goto -69 -> 1331
    //   1403: iconst_1
    //   1404: putstatic 188	imm:mfReadCpuInfo	Z
    //   1407: goto -1163 -> 244
    //   1410: astore 9
    //   1412: goto -1363 -> 49
    //   1415: astore 9
    //   1417: goto -1368 -> 49
    //   1420: astore 8
    //   1422: aconst_null
    //   1423: astore 9
    //   1425: goto -521 -> 904
    //   1428: astore 8
    //   1430: aconst_null
    //   1431: astore 8
    //   1433: goto -733 -> 700
    //   1436: astore 8
    //   1438: aconst_null
    //   1439: astore 8
    //   1441: goto -919 -> 522
    //   1444: astore 8
    //   1446: aload 9
    //   1448: astore 8
    //   1450: goto -1069 -> 381
    //   1453: goto -227 -> 1226
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1223	0	f1	float
    //   70	1325	1	f2	float
    //   90	1109	2	i	int
    //   762	4	3	j	int
    //   14	1223	4	l1	long
    //   67	1196	6	l2	long
    //   47	346	8	localBufferedReader	java.io.BufferedReader
    //   406	128	8	localIOException1	java.io.IOException
    //   547	165	8	localIOException2	java.io.IOException
    //   725	172	8	localIOException3	java.io.IOException
    //   902	13	8	localObject1	Object
    //   1229	3	8	localIOException4	java.io.IOException
    //   1420	1	8	localObject2	Object
    //   1428	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1431	1	8	localObject3	Object
    //   1436	1	8	localIOException5	java.io.IOException
    //   1439	1	8	localObject4	Object
    //   1444	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1448	1	8	localObject5	Object
    //   9	347	9	str1	String
    //   379	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   520	162	9	localIOException6	java.io.IOException
    //   698	180	9	localNumberFormatException2	java.lang.NumberFormatException
    //   898	315	9	localObject6	Object
    //   1245	3	9	localIOException7	java.io.IOException
    //   1410	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1415	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1423	24	9	localObject7	Object
    //   29	855	10	localStringBuilder	java.lang.StringBuilder
    //   894	462	10	localObject8	Object
    //   602	170	11	str2	String
    //   753	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   791	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   49	56	379	java/io/FileNotFoundException
    //   61	65	379	java/io/FileNotFoundException
    //   327	345	379	java/io/FileNotFoundException
    //   350	376	379	java/io/FileNotFoundException
    //   422	440	379	java/io/FileNotFoundException
    //   445	517	379	java/io/FileNotFoundException
    //   563	581	379	java/io/FileNotFoundException
    //   586	604	379	java/io/FileNotFoundException
    //   609	632	379	java/io/FileNotFoundException
    //   632	647	379	java/io/FileNotFoundException
    //   647	695	379	java/io/FileNotFoundException
    //   741	750	379	java/io/FileNotFoundException
    //   757	763	379	java/io/FileNotFoundException
    //   768	788	379	java/io/FileNotFoundException
    //   800	819	379	java/io/FileNotFoundException
    //   824	843	379	java/io/FileNotFoundException
    //   843	891	379	java/io/FileNotFoundException
    //   917	936	379	java/io/FileNotFoundException
    //   941	960	379	java/io/FileNotFoundException
    //   960	1008	379	java/io/FileNotFoundException
    //   1011	1044	379	java/io/FileNotFoundException
    //   1044	1092	379	java/io/FileNotFoundException
    //   1095	1114	379	java/io/FileNotFoundException
    //   1119	1137	379	java/io/FileNotFoundException
    //   1137	1144	379	java/io/FileNotFoundException
    //   1170	1189	379	java/io/FileNotFoundException
    //   1194	1212	379	java/io/FileNotFoundException
    //   1212	1218	379	java/io/FileNotFoundException
    //   392	397	406	java/io/IOException
    //   49	56	520	java/io/IOException
    //   61	65	520	java/io/IOException
    //   327	345	520	java/io/IOException
    //   350	376	520	java/io/IOException
    //   422	440	520	java/io/IOException
    //   445	517	520	java/io/IOException
    //   563	581	520	java/io/IOException
    //   586	604	520	java/io/IOException
    //   609	632	520	java/io/IOException
    //   632	647	520	java/io/IOException
    //   647	695	520	java/io/IOException
    //   741	750	520	java/io/IOException
    //   757	763	520	java/io/IOException
    //   768	788	520	java/io/IOException
    //   800	819	520	java/io/IOException
    //   824	843	520	java/io/IOException
    //   843	891	520	java/io/IOException
    //   917	936	520	java/io/IOException
    //   941	960	520	java/io/IOException
    //   960	1008	520	java/io/IOException
    //   1011	1044	520	java/io/IOException
    //   1044	1092	520	java/io/IOException
    //   1095	1114	520	java/io/IOException
    //   1119	1137	520	java/io/IOException
    //   1137	1144	520	java/io/IOException
    //   1170	1189	520	java/io/IOException
    //   1194	1212	520	java/io/IOException
    //   1212	1218	520	java/io/IOException
    //   533	538	547	java/io/IOException
    //   49	56	698	java/lang/NumberFormatException
    //   61	65	698	java/lang/NumberFormatException
    //   327	345	698	java/lang/NumberFormatException
    //   350	376	698	java/lang/NumberFormatException
    //   422	440	698	java/lang/NumberFormatException
    //   445	517	698	java/lang/NumberFormatException
    //   563	581	698	java/lang/NumberFormatException
    //   586	604	698	java/lang/NumberFormatException
    //   609	632	698	java/lang/NumberFormatException
    //   632	647	698	java/lang/NumberFormatException
    //   647	695	698	java/lang/NumberFormatException
    //   757	763	698	java/lang/NumberFormatException
    //   800	819	698	java/lang/NumberFormatException
    //   824	843	698	java/lang/NumberFormatException
    //   843	891	698	java/lang/NumberFormatException
    //   917	936	698	java/lang/NumberFormatException
    //   941	960	698	java/lang/NumberFormatException
    //   960	1008	698	java/lang/NumberFormatException
    //   1011	1044	698	java/lang/NumberFormatException
    //   1044	1092	698	java/lang/NumberFormatException
    //   1095	1114	698	java/lang/NumberFormatException
    //   1119	1137	698	java/lang/NumberFormatException
    //   1170	1189	698	java/lang/NumberFormatException
    //   1194	1212	698	java/lang/NumberFormatException
    //   711	716	725	java/io/IOException
    //   741	750	753	java/lang/NumberFormatException
    //   768	788	791	java/lang/NumberFormatException
    //   49	56	894	finally
    //   61	65	894	finally
    //   327	345	894	finally
    //   350	376	894	finally
    //   422	440	894	finally
    //   445	517	894	finally
    //   563	581	894	finally
    //   586	604	894	finally
    //   609	632	894	finally
    //   632	647	894	finally
    //   647	695	894	finally
    //   741	750	894	finally
    //   757	763	894	finally
    //   768	788	894	finally
    //   800	819	894	finally
    //   824	843	894	finally
    //   843	891	894	finally
    //   917	936	894	finally
    //   941	960	894	finally
    //   960	1008	894	finally
    //   1011	1044	894	finally
    //   1044	1092	894	finally
    //   1095	1114	894	finally
    //   1119	1137	894	finally
    //   1137	1144	894	finally
    //   1170	1189	894	finally
    //   1194	1212	894	finally
    //   1212	1218	894	finally
    //   76	81	1229	java/io/IOException
    //   909	914	1245	java/io/IOException
    //   1137	1144	1410	java/lang/NumberFormatException
    //   1212	1218	1415	java/lang/NumberFormatException
    //   31	49	1420	finally
    //   31	49	1428	java/lang/NumberFormatException
    //   31	49	1436	java/io/IOException
    //   31	49	1444	java/io/FileNotFoundException
  }
  
  public static String getCpuReport()
  {
    getCpuInfo();
    return "prcs(" + mProcessorName + ") arch(" + mCpuArchitecture + ") hard(" + mHardware + ") chip(" + mChip + ") freq(" + mMaxCpuFreq + ") num(" + mCoreNumber + ")";
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static long getMaxCpuFreq()
  {
    getCpuInfo();
    igd.aJ("VcSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + mMaxCpuFreq);
    return mMaxCpuFreq;
  }
  
  public static String getModelReport()
  {
    getCpuInfo();
    return "model(" + Build.MODEL + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + mOpenGLVersion + ")";
  }
  
  public static int getNumCores()
  {
    getCpuInfo();
    return mCoreNumber;
  }
  
  public static boolean hasFeature(String paramString)
  {
    try
    {
      if ((mFeature == null) || (mFeature.equals(""))) {
        getCpuInfo();
      }
      int i = mFeature.indexOf(paramString);
      if (i > 0) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isBeautySupported()
  {
    return ((hasFeature("neon")) || (hasFeature("asimd"))) && (getNumCores() >= 2) && (getCpuArchitecture() >= 4);
  }
  
  public static boolean isLowLevelDevice()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (mgNumCores == 0) {
        mgNumCores = getNumCores();
      }
      if (mgMaxCpuFreq == 0L) {
        mgMaxCpuFreq = getMaxCpuFreq();
      }
    } while ((mgNumCores <= 1) && (mgMaxCpuFreq <= 1025000L));
    return false;
  }
  
  public static boolean isNormalSharp()
  {
    getCpuInfo();
    return (mChip >= 3) && (mMaxCpuFreq / 1000L >= 800L);
  }
  
  public static boolean isSupportSharpAudio()
  {
    return true;
  }
  
  public static int lf()
  {
    getCpuInfo();
    return mOpenGLVersion;
  }
  
  static int readCpuArchitecture()
  {
    if (mProcessorName.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((mCpuArchitecture == 7) && (mFeature.indexOf("neon") < 0))
    {
      long l = getMaxCpuFreq();
      int i = getNumCores();
      if ((l < 1100000L) || (i < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (mCpuArchitecture)
    {
    case 6: 
    default: 
      if ((mVendorId != null) && ((mVendorId.equalsIgnoreCase("AuthenticAMD")) || (mVendorId.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  /* Error */
  static long readMaxCpuFreq()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 42	imm:mCoreNumber	I
    //   5: iconst_1
    //   6: if_icmpge +23 -> 29
    //   9: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 129
    //   17: iconst_2
    //   18: ldc_w 413
    //   21: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: bipush 8
    //   26: putstatic 42	imm:mCoreNumber	I
    //   29: iconst_0
    //   30: istore_2
    //   31: lconst_0
    //   32: lstore 5
    //   34: lconst_0
    //   35: lstore_3
    //   36: iload_1
    //   37: getstatic 42	imm:mCoreNumber	I
    //   40: if_icmpge +320 -> 360
    //   43: aconst_null
    //   44: astore 12
    //   46: new 77	java/io/BufferedReader
    //   49: dup
    //   50: new 79	java/io/FileReader
    //   53: dup
    //   54: new 145	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 415
    //   64: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 417
    //   74: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 84	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore 11
    //   88: lload_3
    //   89: lstore 7
    //   91: aload 11
    //   93: ifnull +51 -> 144
    //   96: aload 11
    //   98: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 12
    //   103: aload 12
    //   105: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +340 -> 448
    //   111: aload 12
    //   113: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   116: astore 12
    //   118: lload_3
    //   119: lstore 7
    //   121: aload 12
    //   123: ifnull +21 -> 144
    //   126: lload_3
    //   127: lstore 7
    //   129: aload 12
    //   131: invokevirtual 110	java/lang/String:length	()I
    //   134: ifle +10 -> 144
    //   137: aload 12
    //   139: invokestatic 127	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   142: lstore 7
    //   144: iload_2
    //   145: istore_0
    //   146: lload 7
    //   148: lstore_3
    //   149: aload 11
    //   151: ifnull +13 -> 164
    //   154: aload 11
    //   156: invokevirtual 94	java/io/BufferedReader:close	()V
    //   159: lload 7
    //   161: lstore_3
    //   162: iload_2
    //   163: istore_0
    //   164: lload 5
    //   166: lstore 7
    //   168: lload_3
    //   169: lload 5
    //   171: lcmp
    //   172: ifle +6 -> 178
    //   175: lload_3
    //   176: lstore 7
    //   178: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +50 -> 231
    //   184: ldc 129
    //   186: iconst_2
    //   187: new 145	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 424
    //   197: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_1
    //   201: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 426
    //   207: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload_3
    //   211: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: ldc_w 428
    //   217: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: lload 7
    //   222: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: iload_0
    //   236: istore_2
    //   237: lload 7
    //   239: lstore 5
    //   241: goto -205 -> 36
    //   244: astore 11
    //   246: aload 11
    //   248: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   251: iload_2
    //   252: istore_0
    //   253: lload 7
    //   255: lstore_3
    //   256: goto -92 -> 164
    //   259: astore 12
    //   261: aconst_null
    //   262: astore 11
    //   264: ldc 129
    //   266: iconst_1
    //   267: new 145	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 430
    //   277: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload_1
    //   281: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc_w 432
    //   287: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 12
    //   292: invokevirtual 167	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 11
    //   306: ifnull +8 -> 314
    //   309: aload 11
    //   311: invokevirtual 94	java/io/BufferedReader:close	()V
    //   314: iconst_1
    //   315: istore_0
    //   316: lconst_0
    //   317: lstore_3
    //   318: goto -154 -> 164
    //   321: astore 11
    //   323: aload 11
    //   325: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   328: iconst_1
    //   329: istore_0
    //   330: lconst_0
    //   331: lstore_3
    //   332: goto -168 -> 164
    //   335: astore 11
    //   337: aload 12
    //   339: ifnull +8 -> 347
    //   342: aload 12
    //   344: invokevirtual 94	java/io/BufferedReader:close	()V
    //   347: aload 11
    //   349: athrow
    //   350: astore 12
    //   352: aload 12
    //   354: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   357: goto -10 -> 347
    //   360: lload 5
    //   362: lstore 7
    //   364: iload_2
    //   365: ifeq +23 -> 388
    //   368: invokestatic 436	imm:bE	()J
    //   371: lstore 9
    //   373: lload 5
    //   375: lstore 7
    //   377: lload 9
    //   379: lload_3
    //   380: lcmp
    //   381: ifle +7 -> 388
    //   384: lload 9
    //   386: lstore 7
    //   388: ldc 129
    //   390: new 145	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 438
    //   400: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: lload 7
    //   405: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 164	igd:aK	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: lload 7
    //   416: lreturn
    //   417: astore 13
    //   419: aload 11
    //   421: astore 12
    //   423: aload 13
    //   425: astore 11
    //   427: goto -90 -> 337
    //   430: astore 13
    //   432: aload 11
    //   434: astore 12
    //   436: aload 13
    //   438: astore 11
    //   440: goto -103 -> 337
    //   443: astore 12
    //   445: goto -181 -> 264
    //   448: ldc 34
    //   450: astore 12
    //   452: goto -334 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   145	185	0	i	int
    //   1	280	1	j	int
    //   30	335	2	k	int
    //   35	345	3	l1	long
    //   32	342	5	l2	long
    //   89	326	7	l3	long
    //   371	14	9	l4	long
    //   86	69	11	localBufferedReader	java.io.BufferedReader
    //   244	3	11	localIOException1	java.io.IOException
    //   262	48	11	localObject1	Object
    //   321	3	11	localIOException2	java.io.IOException
    //   335	85	11	localObject2	Object
    //   425	14	11	localObject3	Object
    //   44	94	12	str1	String
    //   259	84	12	localException1	Exception
    //   350	3	12	localIOException3	java.io.IOException
    //   421	14	12	localObject4	Object
    //   443	1	12	localException2	Exception
    //   450	1	12	str2	String
    //   417	7	13	localObject5	Object
    //   430	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   154	159	244	java/io/IOException
    //   46	88	259	java/lang/Exception
    //   309	314	321	java/io/IOException
    //   46	88	335	finally
    //   342	347	350	java/io/IOException
    //   96	118	417	finally
    //   129	144	417	finally
    //   264	304	430	finally
    //   96	118	443	java/lang/Exception
    //   129	144	443	java/lang/Exception
  }
  
  static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new imn()).length;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static boolean tZ()
  {
    getCpuInfo();
    return mIsMarvell;
  }
  
  public int getCameraFacing()
  {
    return 2;
  }
  
  public int getOsType()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int j = str.charAt(0);
        int k = str.charAt(2);
        int i = 0;
        if (str.length() >= 5) {
          i = str.charAt(4);
        }
        switch (j)
        {
        default: 
          return 200;
        case 49: 
          if (k == 49) {
            return 101;
          }
          if (k == 53) {
            return 102;
          }
          if (k == 54) {
            return 103;
          }
          break;
        case 50: 
          if (k == 48)
          {
            if (i == 49) {
              return 105;
            }
            return 104;
          }
          if (k == 49) {
            return 106;
          }
          if (k == 50)
          {
            if (i == 49) {
              return 108;
            }
            return 107;
          }
          if ((k == 51) && (i >= 48) && (i <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (k == 48) {
            return 110;
          }
          if (k == 49) {
            return 111;
          }
          if (k == 50) {
            return 112;
          }
          break;
        case 52: 
          if (k == 48) {
            return 113;
          }
          if (k == 49) {
            return 114;
          }
          if (k == 50) {
            return 115;
          }
          if (k == 51) {
            return 116;
          }
          if (k == 52) {
            return 117;
          }
          break;
        case 53: 
          if (k == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imm
 * JD-Core Version:    0.7.0.1
 */