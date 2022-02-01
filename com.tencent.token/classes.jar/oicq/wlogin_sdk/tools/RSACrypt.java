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
    //   19: istore 4
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore_1
    //   25: iconst_0
    //   26: istore_2
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
    //   98: ifnull +56 -> 154
    //   101: aload 5
    //   103: arraylength
    //   104: ifle +50 -> 154
    //   107: aload 6
    //   109: ifnull +45 -> 154
    //   112: aload 6
    //   114: arraylength
    //   115: ifle +39 -> 154
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
    //   149: iconst_1
    //   150: istore_1
    //   151: goto +35 -> 186
    //   154: ldc 92
    //   156: ldc 86
    //   158: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: invokespecial 94	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   165: istore_1
    //   166: ldc 96
    //   168: iload_1
    //   169: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   172: invokevirtual 106	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   175: ldc 86
    //   177: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: iconst_0
    //   181: istore_3
    //   182: iload_1
    //   183: istore_2
    //   184: iload_3
    //   185: istore_1
    //   186: ldc 2
    //   188: monitorexit
    //   189: iload_1
    //   190: ifeq +5 -> 195
    //   193: iload_2
    //   194: ireturn
    //   195: ldc 2
    //   197: monitorenter
    //   198: aload_0
    //   199: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   202: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   205: astore 5
    //   207: aload_0
    //   208: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   211: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   214: astore 6
    //   216: aload 5
    //   218: ifnull +54 -> 272
    //   221: aload 5
    //   223: arraylength
    //   224: ifle +48 -> 272
    //   227: aload 6
    //   229: ifnull +43 -> 272
    //   232: aload 6
    //   234: arraylength
    //   235: ifle +37 -> 272
    //   238: aload_0
    //   239: aload 5
    //   241: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   244: checkcast 78	[B
    //   247: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   250: aload_0
    //   251: aload 6
    //   253: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   256: checkcast 78	[B
    //   259: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   262: ldc 108
    //   264: ldc 86
    //   266: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: goto +39 -> 308
    //   272: ldc 110
    //   274: ldc 86
    //   276: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_0
    //   280: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   283: aload_0
    //   284: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   287: invokestatic 114	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   290: aload_0
    //   291: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   294: aload_0
    //   295: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   298: invokestatic 117	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   301: ldc 119
    //   303: ldc 86
    //   305: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: ldc 2
    //   310: monitorexit
    //   311: iload_2
    //   312: ireturn
    //   313: astore 5
    //   315: ldc 2
    //   317: monitorexit
    //   318: aload 5
    //   320: athrow
    //   321: astore 5
    //   323: goto +17 -> 340
    //   326: astore 5
    //   328: iload_1
    //   329: istore_2
    //   330: goto +8 -> 338
    //   333: astore 5
    //   335: iload 4
    //   337: istore_2
    //   338: iconst_0
    //   339: istore_1
    //   340: ldc 2
    //   342: monitorexit
    //   343: iload_2
    //   344: istore_3
    //   345: iload_1
    //   346: istore 4
    //   348: aload 5
    //   350: athrow
    //   351: astore 5
    //   353: goto -13 -> 340
    //   356: astore 5
    //   358: iconst_0
    //   359: istore 4
    //   361: iload_1
    //   362: istore_3
    //   363: goto +200 -> 563
    //   366: iconst_0
    //   367: istore_1
    //   368: iload_3
    //   369: istore_2
    //   370: iload_2
    //   371: istore_3
    //   372: iload_1
    //   373: istore 4
    //   375: invokestatic 123	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   378: astore 5
    //   380: aload 5
    //   382: ifnull +47 -> 429
    //   385: iload_2
    //   386: istore_3
    //   387: iload_1
    //   388: istore 4
    //   390: aload_0
    //   391: aload 5
    //   393: invokevirtual 129	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   396: invokeinterface 135 1 0
    //   401: invokestatic 139	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   404: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   407: iload_2
    //   408: istore_3
    //   409: iload_1
    //   410: istore 4
    //   412: aload_0
    //   413: aload 5
    //   415: invokevirtual 143	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   418: invokeinterface 146 1 0
    //   423: invokestatic 149	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   426: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   429: iload_1
    //   430: ifeq +5 -> 435
    //   433: iload_2
    //   434: ireturn
    //   435: ldc 2
    //   437: monitorenter
    //   438: aload_0
    //   439: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   442: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   445: astore 5
    //   447: aload_0
    //   448: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   451: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   454: astore 6
    //   456: aload 5
    //   458: ifnull +54 -> 512
    //   461: aload 5
    //   463: arraylength
    //   464: ifle +48 -> 512
    //   467: aload 6
    //   469: ifnull +43 -> 512
    //   472: aload 6
    //   474: arraylength
    //   475: ifle +37 -> 512
    //   478: aload_0
    //   479: aload 5
    //   481: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   484: checkcast 78	[B
    //   487: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   490: aload_0
    //   491: aload 6
    //   493: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   496: checkcast 78	[B
    //   499: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   502: ldc 108
    //   504: ldc 86
    //   506: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto +39 -> 548
    //   512: ldc 110
    //   514: ldc 86
    //   516: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload_0
    //   520: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   523: aload_0
    //   524: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   527: invokestatic 114	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   530: aload_0
    //   531: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   534: aload_0
    //   535: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   538: invokestatic 117	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   541: ldc 119
    //   543: ldc 86
    //   545: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: ldc 2
    //   550: monitorexit
    //   551: iload_2
    //   552: ireturn
    //   553: astore 5
    //   555: ldc 2
    //   557: monitorexit
    //   558: aload 5
    //   560: athrow
    //   561: astore 5
    //   563: iload 4
    //   565: ifeq +5 -> 570
    //   568: iload_3
    //   569: ireturn
    //   570: ldc 2
    //   572: monitorenter
    //   573: aload_0
    //   574: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   577: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   580: astore 6
    //   582: aload_0
    //   583: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   586: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   589: astore 7
    //   591: aload 6
    //   593: ifnull +54 -> 647
    //   596: aload 6
    //   598: arraylength
    //   599: ifle +48 -> 647
    //   602: aload 7
    //   604: ifnull +43 -> 647
    //   607: aload 7
    //   609: arraylength
    //   610: ifle +37 -> 647
    //   613: aload_0
    //   614: aload 6
    //   616: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   619: checkcast 78	[B
    //   622: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   625: aload_0
    //   626: aload 7
    //   628: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   631: checkcast 78	[B
    //   634: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   637: ldc 108
    //   639: ldc 86
    //   641: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: goto +39 -> 683
    //   647: ldc 110
    //   649: ldc 86
    //   651: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload_0
    //   655: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   658: aload_0
    //   659: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   662: invokestatic 114	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   665: aload_0
    //   666: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   669: aload_0
    //   670: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   673: invokestatic 117	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   676: ldc 119
    //   678: ldc 86
    //   680: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: ldc 2
    //   685: monitorexit
    //   686: aload 5
    //   688: athrow
    //   689: astore 5
    //   691: ldc 2
    //   693: monitorexit
    //   694: aload 5
    //   696: athrow
    //   697: astore 5
    //   699: goto -333 -> 366
    //   702: astore 5
    //   704: goto -334 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	RSACrypt
    //   24	406	1	i	int
    //   26	526	2	j	int
    //   22	547	3	k	int
    //   19	545	4	m	int
    //   7	233	5	arrayOfByte1	byte[]
    //   313	6	5	localObject1	Object
    //   321	1	5	localObject2	Object
    //   326	1	5	localObject3	Object
    //   333	16	5	localObject4	Object
    //   351	1	5	localObject5	Object
    //   356	1	5	localObject6	Object
    //   378	102	5	localObject7	Object
    //   553	6	5	localObject8	Object
    //   561	126	5	localObject9	Object
    //   689	6	5	localObject10	Object
    //   697	1	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   702	1	5	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   16	599	6	arrayOfByte2	byte[]
    //   589	38	7	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   198	216	313	finally
    //   221	227	313	finally
    //   232	269	313	finally
    //   272	308	313	finally
    //   308	311	313	finally
    //   315	318	313	finally
    //   186	189	321	finally
    //   166	180	326	finally
    //   78	96	333	finally
    //   101	107	333	finally
    //   112	149	333	finally
    //   154	166	333	finally
    //   340	343	351	finally
    //   75	78	356	finally
    //   438	456	553	finally
    //   461	467	553	finally
    //   472	509	553	finally
    //   512	548	553	finally
    //   548	551	553	finally
    //   555	558	553	finally
    //   348	351	561	finally
    //   375	380	561	finally
    //   390	407	561	finally
    //   412	429	561	finally
    //   573	591	689	finally
    //   596	602	689	finally
    //   607	644	689	finally
    //   647	683	689	finally
    //   683	686	689	finally
    //   691	694	689	finally
    //   75	78	697	java/lang/UnsatisfiedLinkError
    //   348	351	702	java/lang/UnsatisfiedLinkError
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