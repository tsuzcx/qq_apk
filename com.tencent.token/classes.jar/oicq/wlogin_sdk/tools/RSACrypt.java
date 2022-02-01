package oicq.wlogin_sdk.tools;

import android.content.Context;

public class RSACrypt
{
  protected static final String DEFAULT_PRIV_KEY = "3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9";
  public static final String DEFAULT_PUB_KEY = "30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001";
  private Context _context;
  private byte[] _priv_key = new byte[0];
  private byte[] _pub_key = new byte[0];
  
  public RSACrypt(Context paramContext)
  {
    this._context = paramContext;
    try
    {
      util.loadLibrary("wtecdh", this._context);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  private native byte[] decryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native byte[] encryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int genrsakey();
  
  /* Error */
  public byte[] DecryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_1
    //   10: astore_3
    //   11: aload_1
    //   12: ifnonnull +28 -> 40
    //   15: aload_0
    //   16: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   19: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +10 -> 34
    //   27: aload_1
    //   28: astore_3
    //   29: aload_1
    //   30: arraylength
    //   31: ifne +9 -> 40
    //   34: ldc 8
    //   36: invokestatic 54	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   39: astore_3
    //   40: aload_0
    //   41: aload_3
    //   42: aload_2
    //   43: invokespecial 56	oicq/wlogin_sdk/tools/RSACrypt:decryptdata	([B[B)[B
    //   46: astore 5
    //   48: aload 5
    //   50: ifnull +16 -> 66
    //   53: aload 5
    //   55: astore_1
    //   56: aload 5
    //   58: astore 4
    //   60: aload 5
    //   62: arraylength
    //   63: ifne +18 -> 81
    //   66: aload 5
    //   68: astore 4
    //   70: aload_0
    //   71: ldc 8
    //   73: invokestatic 54	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   76: aload_2
    //   77: invokespecial 56	oicq/wlogin_sdk/tools/RSACrypt:decryptdata	([B[B)[B
    //   80: astore_1
    //   81: aload_1
    //   82: astore 4
    //   84: aload_1
    //   85: ifnonnull +42 -> 127
    //   88: aload_2
    //   89: aload_3
    //   90: invokestatic 60	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJNI	([B)Ljava/security/Key;
    //   93: invokestatic 64	oicq/wlogin_sdk/tools/util:RSADecrypt	([BLjava/security/Key;)[B
    //   96: astore 4
    //   98: aload 4
    //   100: ifnull +12 -> 112
    //   103: aload 4
    //   105: arraylength
    //   106: ifne +38 -> 144
    //   109: goto +3 -> 112
    //   112: aload_2
    //   113: ldc 8
    //   115: invokestatic 54	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   118: invokestatic 60	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJNI	([B)Ljava/security/Key;
    //   121: invokestatic 64	oicq/wlogin_sdk/tools/util:RSADecrypt	([BLjava/security/Key;)[B
    //   124: astore_1
    //   125: aload_1
    //   126: areturn
    //   127: aload 4
    //   129: areturn
    //   130: astore_1
    //   131: aload 4
    //   133: astore_1
    //   134: goto -53 -> 81
    //   137: astore_2
    //   138: aload_1
    //   139: areturn
    //   140: astore_1
    //   141: goto -14 -> 127
    //   144: aload 4
    //   146: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	RSACrypt
    //   0	147	1	paramArrayOfByte1	byte[]
    //   0	147	2	paramArrayOfByte2	byte[]
    //   10	80	3	arrayOfByte1	byte[]
    //   1	144	4	localObject	Object
    //   46	21	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	48	130	java/lang/UnsatisfiedLinkError
    //   60	66	130	java/lang/UnsatisfiedLinkError
    //   70	81	130	java/lang/UnsatisfiedLinkError
    //   88	98	137	java/lang/Exception
    //   103	109	140	java/lang/Exception
    //   112	125	140	java/lang/Exception
  }
  
  public byte[] EncryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = null;
    if (paramArrayOfByte1 != null) {
      if (paramArrayOfByte2 == null) {
        return null;
      }
    }
    try
    {
      localObject2 = encryptdata(paramArrayOfByte1, paramArrayOfByte2);
      localObject1 = localObject2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject2;
      label23:
      break label23;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = util.RSAEncrypt(paramArrayOfByte2, util.RSAPubKeyFromJNI(paramArrayOfByte1));
    }
    return localObject2;
    return null;
  }
  
  /* Error */
  public int GenRSAKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   4: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   13: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   16: astore 6
    //   18: iconst_0
    //   19: istore_3
    //   20: iconst_0
    //   21: istore_2
    //   22: iconst_0
    //   23: istore 4
    //   25: iconst_0
    //   26: istore_1
    //   27: aload 5
    //   29: ifnull +46 -> 75
    //   32: aload 5
    //   34: arraylength
    //   35: ifle +40 -> 75
    //   38: aload 6
    //   40: ifnull +35 -> 75
    //   43: aload 6
    //   45: arraylength
    //   46: ifle +29 -> 75
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   55: checkcast 78	[B
    //   58: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   67: checkcast 78	[B
    //   70: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   73: iconst_0
    //   74: ireturn
    //   75: ldc 2
    //   77: monitorenter
    //   78: aload_0
    //   79: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   82: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   91: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   94: astore 6
    //   96: aload 5
    //   98: ifnull +58 -> 156
    //   101: aload 5
    //   103: arraylength
    //   104: ifle +52 -> 156
    //   107: aload 6
    //   109: ifnull +47 -> 156
    //   112: aload 6
    //   114: arraylength
    //   115: ifle +41 -> 156
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   124: checkcast 78	[B
    //   127: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   130: aload_0
    //   131: aload 6
    //   133: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   136: checkcast 78	[B
    //   139: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   142: ldc 84
    //   144: ldc 86
    //   146: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iconst_0
    //   150: istore_2
    //   151: iconst_1
    //   152: istore_1
    //   153: goto +49 -> 202
    //   156: ldc 92
    //   158: ldc 86
    //   160: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokespecial 94	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   167: istore_2
    //   168: new 96	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   175: astore 5
    //   177: aload 5
    //   179: ldc 99
    //   181: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 5
    //   187: iload_2
    //   188: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: ldc 86
    //   199: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: ldc 2
    //   204: monitorexit
    //   205: iload_1
    //   206: ifeq +5 -> 211
    //   209: iload_2
    //   210: ireturn
    //   211: ldc 2
    //   213: monitorenter
    //   214: aload_0
    //   215: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   218: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   227: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   230: astore 6
    //   232: aload 5
    //   234: ifnull +54 -> 288
    //   237: aload 5
    //   239: arraylength
    //   240: ifle +48 -> 288
    //   243: aload 6
    //   245: ifnull +43 -> 288
    //   248: aload 6
    //   250: arraylength
    //   251: ifle +37 -> 288
    //   254: aload_0
    //   255: aload 5
    //   257: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   260: checkcast 78	[B
    //   263: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   266: aload_0
    //   267: aload 6
    //   269: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   272: checkcast 78	[B
    //   275: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   278: ldc 112
    //   280: ldc 86
    //   282: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto +39 -> 324
    //   288: ldc 114
    //   290: ldc 86
    //   292: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   299: aload_0
    //   300: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   303: invokestatic 118	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   306: aload_0
    //   307: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   310: aload_0
    //   311: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   314: invokestatic 121	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   317: ldc 123
    //   319: ldc 86
    //   321: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: ldc 2
    //   326: monitorexit
    //   327: iload_2
    //   328: ireturn
    //   329: astore 5
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload 5
    //   336: athrow
    //   337: astore 5
    //   339: goto +14 -> 353
    //   342: astore 5
    //   344: goto +7 -> 351
    //   347: astore 5
    //   349: iload_3
    //   350: istore_2
    //   351: iconst_0
    //   352: istore_1
    //   353: ldc 2
    //   355: monitorexit
    //   356: iload_2
    //   357: istore_3
    //   358: iload_1
    //   359: istore 4
    //   361: aload 5
    //   363: athrow
    //   364: astore 5
    //   366: goto -13 -> 353
    //   369: astore 5
    //   371: iconst_0
    //   372: istore_1
    //   373: iload 4
    //   375: istore_3
    //   376: iload_1
    //   377: istore 4
    //   379: goto +198 -> 577
    //   382: iconst_0
    //   383: istore_1
    //   384: iload_2
    //   385: istore_3
    //   386: iload_1
    //   387: istore 4
    //   389: invokestatic 127	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   392: astore 5
    //   394: aload 5
    //   396: ifnull +47 -> 443
    //   399: iload_2
    //   400: istore_3
    //   401: iload_1
    //   402: istore 4
    //   404: aload_0
    //   405: aload 5
    //   407: invokevirtual 133	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   410: invokeinterface 139 1 0
    //   415: invokestatic 143	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   418: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   421: iload_2
    //   422: istore_3
    //   423: iload_1
    //   424: istore 4
    //   426: aload_0
    //   427: aload 5
    //   429: invokevirtual 147	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   432: invokeinterface 150 1 0
    //   437: invokestatic 153	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   440: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   443: iload_1
    //   444: ifeq +5 -> 449
    //   447: iload_2
    //   448: ireturn
    //   449: ldc 2
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   456: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   459: astore 5
    //   461: aload_0
    //   462: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   465: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   468: astore 6
    //   470: aload 5
    //   472: ifnull +54 -> 526
    //   475: aload 5
    //   477: arraylength
    //   478: ifle +48 -> 526
    //   481: aload 6
    //   483: ifnull +43 -> 526
    //   486: aload 6
    //   488: arraylength
    //   489: ifle +37 -> 526
    //   492: aload_0
    //   493: aload 5
    //   495: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   498: checkcast 78	[B
    //   501: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   504: aload_0
    //   505: aload 6
    //   507: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   510: checkcast 78	[B
    //   513: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   516: ldc 112
    //   518: ldc 86
    //   520: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto +39 -> 562
    //   526: ldc 114
    //   528: ldc 86
    //   530: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   537: aload_0
    //   538: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   541: invokestatic 118	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   544: aload_0
    //   545: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   548: aload_0
    //   549: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   552: invokestatic 121	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   555: ldc 123
    //   557: ldc 86
    //   559: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: ldc 2
    //   564: monitorexit
    //   565: iload_2
    //   566: ireturn
    //   567: astore 5
    //   569: ldc 2
    //   571: monitorexit
    //   572: aload 5
    //   574: athrow
    //   575: astore 5
    //   577: iload 4
    //   579: ifeq +5 -> 584
    //   582: iload_3
    //   583: ireturn
    //   584: ldc 2
    //   586: monitorenter
    //   587: aload_0
    //   588: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   591: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   594: astore 6
    //   596: aload_0
    //   597: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   600: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   603: astore 7
    //   605: aload 6
    //   607: ifnull +54 -> 661
    //   610: aload 6
    //   612: arraylength
    //   613: ifle +48 -> 661
    //   616: aload 7
    //   618: ifnull +43 -> 661
    //   621: aload 7
    //   623: arraylength
    //   624: ifle +37 -> 661
    //   627: aload_0
    //   628: aload 6
    //   630: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   633: checkcast 78	[B
    //   636: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   639: aload_0
    //   640: aload 7
    //   642: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   645: checkcast 78	[B
    //   648: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   651: ldc 112
    //   653: ldc 86
    //   655: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: goto +39 -> 697
    //   661: ldc 114
    //   663: ldc 86
    //   665: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload_0
    //   669: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   672: aload_0
    //   673: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   676: invokestatic 118	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   679: aload_0
    //   680: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   683: aload_0
    //   684: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   687: invokestatic 121	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   690: ldc 123
    //   692: ldc 86
    //   694: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: ldc 2
    //   699: monitorexit
    //   700: aload 5
    //   702: athrow
    //   703: astore 5
    //   705: ldc 2
    //   707: monitorexit
    //   708: aload 5
    //   710: athrow
    //   711: astore 5
    //   713: goto -331 -> 382
    //   716: astore 5
    //   718: goto -334 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	RSACrypt
    //   26	418	1	i	int
    //   21	545	2	j	int
    //   19	564	3	k	int
    //   23	555	4	m	int
    //   7	249	5	localObject1	Object
    //   329	6	5	localObject2	Object
    //   337	1	5	localObject3	Object
    //   342	1	5	localObject4	Object
    //   347	15	5	localObject5	Object
    //   364	1	5	localObject6	Object
    //   369	1	5	localObject7	Object
    //   392	102	5	localObject8	Object
    //   567	6	5	localObject9	Object
    //   575	126	5	localObject10	Object
    //   703	6	5	localObject11	Object
    //   711	1	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   716	1	5	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   16	613	6	arrayOfByte1	byte[]
    //   603	38	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   214	232	329	finally
    //   237	243	329	finally
    //   248	285	329	finally
    //   288	324	329	finally
    //   324	327	329	finally
    //   331	334	329	finally
    //   202	205	337	finally
    //   168	202	342	finally
    //   78	96	347	finally
    //   101	107	347	finally
    //   112	149	347	finally
    //   156	168	347	finally
    //   353	356	364	finally
    //   75	78	369	finally
    //   452	470	567	finally
    //   475	481	567	finally
    //   486	523	567	finally
    //   526	562	567	finally
    //   562	565	567	finally
    //   569	572	567	finally
    //   361	364	575	finally
    //   389	394	575	finally
    //   404	421	575	finally
    //   426	443	575	finally
    //   587	605	703	finally
    //   610	616	703	finally
    //   621	658	703	finally
    //   661	697	703	finally
    //   697	700	703	finally
    //   705	708	703	finally
    //   75	78	711	java/lang/UnsatisfiedLinkError
    //   361	364	716	java/lang/UnsatisfiedLinkError
  }
  
  public byte[] get_priv_key()
  {
    return this._priv_key;
  }
  
  public byte[] get_pub_key()
  {
    return this._pub_key;
  }
  
  public void set_priv_key(byte[] paramArrayOfByte)
  {
    this._priv_key = paramArrayOfByte;
  }
  
  public void set_pub_key(byte[] paramArrayOfByte)
  {
    this._pub_key = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.RSACrypt
 * JD-Core Version:    0.7.0.1
 */