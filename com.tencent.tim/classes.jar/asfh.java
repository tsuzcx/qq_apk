import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import com.tencent.qphone.base.util.QLog;

public class asfh
{
  public static QbarNative a;
  public static QbarNative b;
  private static String cEA;
  private static String cEB;
  private static boolean dei;
  private static int elM = -1;
  private static int elN = -1;
  private static int elO;
  private static int elP;
  private static int elQ;
  public static final String[] iw = { "detect_model.bin", "detect_model.param", "srnet.bin", "srnet.param" };
  private static int[] pt;
  
  /* Error */
  public static String GetVersion()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +63 -> 69
    //   9: ldc 51
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 58
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 26	asfh:elM	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 28	asfh:elN	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   72: ifnull +16 -> 88
    //   75: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   78: astore_0
    //   79: invokestatic 90	com/tencent/qbar/QbarNative:getVersion	()Ljava/lang/String;
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   91: ifnull +14 -> 105
    //   94: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   97: astore_0
    //   98: invokestatic 90	com/tencent/qbar/QbarNative:getVersion	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -19 -> 83
    //   105: ldc 92
    //   107: astore_0
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   78	30	0	localObject1	Object
    //   111	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	69	111	finally
    //   69	83	111	finally
    //   88	102	111	finally
  }
  
  public static int Nn()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForCamera.");
      }
      int i = kT(0);
      return i;
    }
    finally {}
  }
  
  public static int Release()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForFile.");
      }
      int i = kT(1);
      return i;
    }
    finally {}
  }
  
  public static int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ScanImageForFile.");
      }
      paramInt1 = b(paramArrayOfByte, paramInt1, paramInt2, 1);
      return paramInt1;
    }
    finally {}
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QbarNativeImpl", 2, String.format("Init searchMode=%s scanMode=%s inputCharset=%s outputCharset=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 }));
        }
        int i = -1;
        boolean bool = RecogUtil.isX86VM();
        if (bool)
        {
          paramInt2 = i;
          return paramInt2;
        }
        if (paramInt2 == 1)
        {
          if (b != null)
          {
            dei = true;
            elQ = 0;
            Nn();
          }
          if ((a == null) || (elM < 0))
          {
            a = new QbarNative();
            elM = a.a(paramInt1, 1, paramString1, paramString2, a(paramInt2));
          }
          paramInt1 = elM;
          paramInt2 = paramInt1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QbarNativeImpl", 2, String.format("Init result=%s ", new Object[] { Integer.valueOf(paramInt1) }));
          paramInt2 = paramInt1;
          continue;
        }
        if (b == null) {
          break label186;
        }
      }
      finally {}
      if (elN < 0)
      {
        label186:
        b = new QbarNative();
        elN = b.a(paramInt1, 0, paramString1, paramString2, a(paramInt2));
        elO = paramInt1;
        cEA = paramString1;
        cEB = paramString2;
        dei = false;
      }
      paramInt1 = elN;
    }
  }
  
  public static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForFile.");
      }
      int i = a(paramStringBuilder1, paramStringBuilder2, 1);
      return i;
    }
    finally {}
  }
  
  /* Error */
  private static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +72 -> 78
    //   9: ldc 51
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 158
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 26	asfh:elM	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 28	asfh:elN	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 160
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +18 -> 98
    //   83: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +25 -> 111
    //   89: getstatic 26	asfh:elM	I
    //   92: istore_2
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   101: ifnonnull +10 -> 111
    //   104: getstatic 28	asfh:elN	I
    //   107: istore_2
    //   108: goto -15 -> 93
    //   111: iload_2
    //   112: iconst_1
    //   113: if_icmpne +15 -> 128
    //   116: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 162	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   124: istore_2
    //   125: goto -32 -> 93
    //   128: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 162	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   136: istore_2
    //   137: goto -44 -> 93
    //   140: astore_3
    //   141: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +38 -> 182
    //   147: ldc 51
    //   149: iconst_2
    //   150: new 53	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   157: ldc 164
    //   159: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: ldc 166
    //   168: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: aload_3
    //   179: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -91 -> 93
    //   187: astore_0
    //   188: ldc 2
    //   190: monitorexit
    //   191: aload_0
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramStringBuilder1	StringBuilder
    //   0	193	1	paramStringBuilder2	StringBuilder
    //   0	193	2	paramInt	int
    //   140	39	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   116	125	140	java/lang/UnsatisfiedLinkError
    //   128	137	140	java/lang/UnsatisfiedLinkError
    //   3	78	187	finally
    //   83	93	187	finally
    //   98	108	187	finally
    //   116	125	187	finally
    //   128	137	187	finally
    //   141	182	187	finally
  }
  
  /* Error */
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 51
    //   11: iconst_2
    //   12: ldc 171
    //   14: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: getstatic 129	asfh:dei	Z
    //   20: ifeq +184 -> 204
    //   23: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +74 -> 100
    //   29: ldc 51
    //   31: iconst_2
    //   32: new 53	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   39: ldc 173
    //   41: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 26	asfh:elM	I
    //   47: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 67
    //   52: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: ldc 74
    //   63: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: getstatic 28	asfh:elN	I
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 76
    //   74: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   80: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: ldc 175
    //   85: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 131	asfh:elQ	I
    //   91: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   103: ifnonnull +24 -> 127
    //   106: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   109: ifnull +108 -> 217
    //   112: getstatic 131	asfh:elQ	I
    //   115: iconst_3
    //   116: if_icmpge +101 -> 217
    //   119: getstatic 131	asfh:elQ	I
    //   122: iconst_1
    //   123: iadd
    //   124: putstatic 131	asfh:elQ	I
    //   127: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +74 -> 204
    //   133: ldc 51
    //   135: iconst_2
    //   136: new 53	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   143: ldc 177
    //   145: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 26	asfh:elM	I
    //   151: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 67
    //   156: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   162: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc 74
    //   167: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 28	asfh:elN	I
    //   173: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 76
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   184: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: ldc 175
    //   189: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 131	asfh:elQ	I
    //   195: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: iload_1
    //   206: iload_2
    //   207: iconst_0
    //   208: invokestatic 109	asfh:b	([BIII)I
    //   211: istore_1
    //   212: ldc 2
    //   214: monitorexit
    //   215: iload_1
    //   216: ireturn
    //   217: getstatic 148	asfh:cEB	Ljava/lang/String;
    //   220: ifnull -93 -> 127
    //   223: getstatic 148	asfh:cEB	Ljava/lang/String;
    //   226: ifnull -99 -> 127
    //   229: getstatic 179	asfh:pt	[I
    //   232: ifnull -105 -> 127
    //   235: getstatic 144	asfh:elO	I
    //   238: getstatic 146	asfh:cEA	Ljava/lang/String;
    //   241: getstatic 148	asfh:cEB	Ljava/lang/String;
    //   244: invokestatic 183	asfh:c	(ILjava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: getstatic 179	asfh:pt	[I
    //   251: getstatic 185	asfh:elP	I
    //   254: invokestatic 188	asfh:d	([II)I
    //   257: pop
    //   258: goto -131 -> 127
    //   261: astore_0
    //   262: ldc 2
    //   264: monitorexit
    //   265: aload_0
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramArrayOfByte	byte[]
    //   0	267	1	paramInt1	int
    //   0	267	2	paramInt2	int
    //   0	267	3	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   3	17	261	finally
    //   17	100	261	finally
    //   100	127	261	finally
    //   127	204	261	finally
    //   204	212	261	finally
    //   217	258	261	finally
  }
  
  /* Error */
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +72 -> 78
    //   9: ldc 51
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 191
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 26	asfh:elM	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 28	asfh:elN	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 160
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +30 -> 110
    //   83: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +12 -> 98
    //   89: getstatic 26	asfh:elM	I
    //   92: istore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   101: aload_0
    //   102: iload_1
    //   103: invokevirtual 193	com/tencent/qbar/QbarNative:b	([II)I
    //   106: istore_1
    //   107: goto -14 -> 93
    //   110: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   113: ifnonnull +10 -> 123
    //   116: getstatic 28	asfh:elN	I
    //   119: istore_1
    //   120: goto -27 -> 93
    //   123: aload_0
    //   124: putstatic 179	asfh:pt	[I
    //   127: iload_1
    //   128: putstatic 185	asfh:elP	I
    //   131: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   134: aload_0
    //   135: iload_1
    //   136: invokevirtual 193	com/tencent/qbar/QbarNative:b	([II)I
    //   139: istore_1
    //   140: goto -47 -> 93
    //   143: astore_0
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_0
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramArrayOfInt	int[]
    //   0	149	1	paramInt1	int
    //   0	149	2	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   3	78	143	finally
    //   83	93	143	finally
    //   98	107	143	finally
    //   110	120	143	finally
    //   123	140	143	finally
  }
  
  private static QbarNative.QbarAiModelParam a(int paramInt)
  {
    QbarNative.QbarAiModelParam localQbarAiModelParam = new QbarNative.QbarAiModelParam();
    localQbarAiModelParam.detect_model_bin_path_ = "";
    localQbarAiModelParam.detect_model_param_path_ = "";
    localQbarAiModelParam.superresolution_model_bin_path_ = "";
    localQbarAiModelParam.superresolution_model_param_path_ = "";
    boolean bool = false;
    if (ajny.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", iw))
    {
      String str = ajny.bn("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e");
      localQbarAiModelParam.detect_model_bin_path_ = (str + "/detect_model.bin");
      localQbarAiModelParam.detect_model_param_path_ = (str + "/detect_model.param");
      localQbarAiModelParam.superresolution_model_bin_path_ = (str + "/srnet.bin");
      localQbarAiModelParam.superresolution_model_param_path_ = (str + "/srnet.param");
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QbarNativeImpl", 2, "getQbarAiModelParam has AI model : " + bool);
    }
    return localQbarAiModelParam;
  }
  
  public static int b(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForFile.");
      }
      paramInt = a(paramInt, 1, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int b(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForCamera.");
      }
      int i = a(paramStringBuilder1, paramStringBuilder2, 0);
      return i;
    }
    finally {}
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QbarNativeImpl", 2, "ScanImage. sInitResult=" + elM + " sQbarNative=" + a + " sInitResultForCamera=" + elN + " sQbarNativeForCamera=" + b + " scanMode=" + paramInt3);
        }
        if (!by(paramInt1, paramInt2))
        {
          QLog.i("QbarNativeImpl", 1, "ScanImage in limit size, return. width=" + paramInt1 + " height=" + paramInt2);
          paramInt1 = i;
          return paramInt1;
        }
        if (paramInt3 == 1)
        {
          if (a == null)
          {
            paramInt1 = elM;
            continue;
          }
          paramInt2 = a.k(paramArrayOfByte, paramInt1, paramInt2);
        }
        else
        {
          if (b == null)
          {
            paramInt1 = elN;
            continue;
          }
          paramInt2 = b.k(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
      finally {}
      paramInt1 = i;
      if (paramInt2 >= 0) {
        paramInt1 = 1;
      }
    }
  }
  
  public static boolean by(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 >= 20) && (paramInt2 >= 20))
    {
      bool1 = bool2;
      if (paramInt1 < 32)
      {
        bool1 = bool2;
        if (paramInt2 >= 32) {}
      }
    }
    else
    {
      QLog.i("QbarNativeImpl", 1, "isValidScanImageSize false, in limit size. width=" + paramInt1 + " height=" + paramInt2);
      bool1 = false;
    }
    return bool1;
  }
  
  public static int c(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForCamera.");
      }
      paramInt = a(paramInt, 0, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int c(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForFile.");
      }
      paramInt = a(paramArrayOfInt, paramInt, 1);
      return paramInt;
    }
    finally {}
  }
  
  public static int d(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForCamera.");
      }
      paramInt = a(paramArrayOfInt, paramInt, 0);
      return paramInt;
    }
    finally {}
  }
  
  /* Error */
  private static int kT(int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +64 -> 72
    //   11: ldc 51
    //   13: iconst_2
    //   14: new 53	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 269
    //   24: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 26	asfh:elM	I
    //   30: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 67
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   41: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc 74
    //   46: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 28	asfh:elN	I
    //   52: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 76
    //   57: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   63: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iload_0
    //   73: iconst_1
    //   74: if_icmpne +98 -> 172
    //   77: iload_1
    //   78: istore_0
    //   79: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   82: ifnull +18 -> 100
    //   85: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   88: invokevirtual 272	com/tencent/qbar/QbarNative:release	()I
    //   91: istore_0
    //   92: aconst_null
    //   93: putstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   96: iconst_m1
    //   97: putstatic 26	asfh:elM	I
    //   100: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +64 -> 167
    //   106: ldc 51
    //   108: iconst_2
    //   109: new 53	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 274
    //   119: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 26	asfh:elM	I
    //   125: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc 67
    //   130: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 69	asfh:a	Lcom/tencent/qbar/QbarNative;
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: ldc 74
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 28	asfh:elN	I
    //   147: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 76
    //   152: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   158: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: ldc 2
    //   169: monitorexit
    //   170: iload_0
    //   171: ireturn
    //   172: iload_1
    //   173: istore_0
    //   174: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   177: ifnull -77 -> 100
    //   180: getstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   183: invokevirtual 272	com/tencent/qbar/QbarNative:release	()I
    //   186: istore_1
    //   187: aconst_null
    //   188: putstatic 78	asfh:b	Lcom/tencent/qbar/QbarNative;
    //   191: iconst_m1
    //   192: putstatic 28	asfh:elN	I
    //   195: iload_1
    //   196: istore_0
    //   197: getstatic 129	asfh:dei	Z
    //   200: ifne -100 -> 100
    //   203: iconst_m1
    //   204: putstatic 144	asfh:elO	I
    //   207: aconst_null
    //   208: putstatic 146	asfh:cEA	Ljava/lang/String;
    //   211: aconst_null
    //   212: putstatic 148	asfh:cEB	Ljava/lang/String;
    //   215: aconst_null
    //   216: putstatic 179	asfh:pt	[I
    //   219: iconst_m1
    //   220: putstatic 185	asfh:elP	I
    //   223: iconst_0
    //   224: putstatic 131	asfh:elQ	I
    //   227: iload_1
    //   228: istore_0
    //   229: goto -129 -> 100
    //   232: astore_2
    //   233: ldc 2
    //   235: monitorexit
    //   236: aload_2
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramInt	int
    //   1	227	1	i	int
    //   232	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	72	232	finally
    //   79	100	232	finally
    //   100	167	232	finally
    //   174	195	232	finally
    //   197	227	232	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asfh
 * JD-Core Version:    0.7.0.1
 */