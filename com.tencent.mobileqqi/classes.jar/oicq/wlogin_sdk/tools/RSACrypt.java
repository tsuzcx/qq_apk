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
  
  public byte[] DecryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    localObject = null;
    byte[] arrayOfByte1 = null;
    if (paramArrayOfByte2 == null) {
      localObject = arrayOfByte1;
    }
    for (;;)
    {
      return localObject;
      arrayOfByte1 = paramArrayOfByte1;
      if (paramArrayOfByte1 == null)
      {
        paramArrayOfByte1 = util.get_rsa_privkey(this._context);
        if (paramArrayOfByte1 != null)
        {
          arrayOfByte1 = paramArrayOfByte1;
          if (paramArrayOfByte1.length != 0) {}
        }
        else
        {
          arrayOfByte1 = util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9");
        }
      }
      try
      {
        byte[] arrayOfByte2 = decryptdata(arrayOfByte1, paramArrayOfByte2);
        if (arrayOfByte2 != null)
        {
          paramArrayOfByte1 = arrayOfByte2;
          localObject = arrayOfByte2;
          if (arrayOfByte2.length != 0) {}
        }
        else
        {
          localObject = arrayOfByte2;
          paramArrayOfByte1 = decryptdata(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9"), paramArrayOfByte2);
        }
      }
      catch (UnsatisfiedLinkError paramArrayOfByte1)
      {
        for (;;)
        {
          paramArrayOfByte1 = (byte[])localObject;
        }
      }
      localObject = paramArrayOfByte1;
      if (paramArrayOfByte1 != null) {
        continue;
      }
      try
      {
        arrayOfByte1 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(arrayOfByte1));
        if (arrayOfByte1 != null)
        {
          localObject = arrayOfByte1;
          paramArrayOfByte1 = arrayOfByte1;
          if (arrayOfByte1.length != 0) {
            continue;
          }
        }
        paramArrayOfByte1 = arrayOfByte1;
        paramArrayOfByte2 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9")));
        return paramArrayOfByte2;
      }
      catch (Exception paramArrayOfByte2)
      {
        return paramArrayOfByte1;
      }
    }
  }
  
  public byte[] EncryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null) {
        break label24;
      }
      localObject2 = localObject3;
    }
    label24:
    label35:
    do
    {
      return localObject2;
      try
      {
        localObject2 = encryptdata(paramArrayOfByte1, paramArrayOfByte2);
        localObject1 = localObject2;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        break label35;
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return util.RSAEncrypt(paramArrayOfByte2, util.RSAPubKeyFromJNI(paramArrayOfByte1));
  }
  
  /* Error */
  public int GenRSAKey()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 6
    //   15: aload_0
    //   16: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   19: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   28: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   31: astore 8
    //   33: aload 7
    //   35: ifnull +49 -> 84
    //   38: aload 7
    //   40: arraylength
    //   41: ifle +43 -> 84
    //   44: aload 8
    //   46: ifnull +38 -> 84
    //   49: aload 8
    //   51: arraylength
    //   52: ifle +32 -> 84
    //   55: aload_0
    //   56: aload 7
    //   58: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   61: checkcast 78	[B
    //   64: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   67: aload_0
    //   68: aload 8
    //   70: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   73: checkcast 78	[B
    //   76: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   79: iload 6
    //   81: istore_2
    //   82: iload_2
    //   83: ireturn
    //   84: ldc 2
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   91: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   94: astore 7
    //   96: aload_0
    //   97: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   100: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   103: astore 8
    //   105: aload 7
    //   107: ifnull +141 -> 248
    //   110: aload 7
    //   112: arraylength
    //   113: ifle +135 -> 248
    //   116: aload 8
    //   118: ifnull +130 -> 248
    //   121: aload 8
    //   123: arraylength
    //   124: ifle +124 -> 248
    //   127: aload_0
    //   128: aload 7
    //   130: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   133: checkcast 78	[B
    //   136: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   139: aload_0
    //   140: aload 8
    //   142: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   145: checkcast 78	[B
    //   148: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   151: ldc 84
    //   153: ldc 86
    //   155: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iconst_1
    //   159: istore_3
    //   160: ldc 2
    //   162: monitorexit
    //   163: iload_1
    //   164: istore_2
    //   165: iload_3
    //   166: ifne -84 -> 82
    //   169: ldc 2
    //   171: monitorenter
    //   172: aload_0
    //   173: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   176: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   179: astore 7
    //   181: aload_0
    //   182: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   185: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   188: astore 8
    //   190: aload 7
    //   192: ifnull +442 -> 634
    //   195: aload 7
    //   197: arraylength
    //   198: ifle +436 -> 634
    //   201: aload 8
    //   203: ifnull +431 -> 634
    //   206: aload 8
    //   208: arraylength
    //   209: ifle +425 -> 634
    //   212: aload_0
    //   213: aload 7
    //   215: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   218: checkcast 78	[B
    //   221: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   224: aload_0
    //   225: aload 8
    //   227: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   230: checkcast 78	[B
    //   233: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   236: ldc 92
    //   238: ldc 86
    //   240: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: ldc 2
    //   245: monitorexit
    //   246: iload_1
    //   247: ireturn
    //   248: ldc 94
    //   250: ldc 86
    //   252: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: invokespecial 96	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   259: istore_1
    //   260: iload_1
    //   261: istore 4
    //   263: new 98	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   270: ldc 101
    //   272: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload_1
    //   276: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: ldc 86
    //   284: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: iconst_0
    //   288: istore_3
    //   289: goto -129 -> 160
    //   292: iload_1
    //   293: istore_3
    //   294: iload_2
    //   295: istore 4
    //   297: ldc 2
    //   299: monitorexit
    //   300: aload 7
    //   302: athrow
    //   303: astore 7
    //   305: iload_1
    //   306: istore_3
    //   307: iload_2
    //   308: istore_1
    //   309: invokestatic 116	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   312: astore 7
    //   314: aload 7
    //   316: ifnull +37 -> 353
    //   319: aload_0
    //   320: aload 7
    //   322: invokevirtual 122	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   325: invokeinterface 128 1 0
    //   330: invokestatic 132	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   333: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   336: aload_0
    //   337: aload 7
    //   339: invokevirtual 136	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   342: invokeinterface 139 1 0
    //   347: invokestatic 142	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   350: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   353: iload_1
    //   354: istore_2
    //   355: iload_3
    //   356: ifne -274 -> 82
    //   359: ldc 2
    //   361: monitorenter
    //   362: aload_0
    //   363: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   366: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   369: astore 7
    //   371: aload_0
    //   372: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   375: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   378: astore 8
    //   380: aload 7
    //   382: ifnull +205 -> 587
    //   385: aload 7
    //   387: arraylength
    //   388: ifle +199 -> 587
    //   391: aload 8
    //   393: ifnull +194 -> 587
    //   396: aload 8
    //   398: arraylength
    //   399: ifle +188 -> 587
    //   402: aload_0
    //   403: aload 7
    //   405: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   408: checkcast 78	[B
    //   411: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   414: aload_0
    //   415: aload 8
    //   417: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   420: checkcast 78	[B
    //   423: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   426: ldc 92
    //   428: ldc 86
    //   430: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: ldc 2
    //   435: monitorexit
    //   436: goto -190 -> 246
    //   439: ldc 2
    //   441: monitorenter
    //   442: aload_0
    //   443: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   446: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   449: astore 8
    //   451: aload_0
    //   452: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   455: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   458: astore 9
    //   460: aload 8
    //   462: ifnull +78 -> 540
    //   465: aload 8
    //   467: arraylength
    //   468: ifle +72 -> 540
    //   471: aload 9
    //   473: ifnull +67 -> 540
    //   476: aload 9
    //   478: arraylength
    //   479: ifle +61 -> 540
    //   482: aload_0
    //   483: aload 8
    //   485: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   488: checkcast 78	[B
    //   491: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   494: aload_0
    //   495: aload 9
    //   497: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   500: checkcast 78	[B
    //   503: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   506: ldc 92
    //   508: ldc 86
    //   510: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: ldc 2
    //   515: monitorexit
    //   516: aload 7
    //   518: athrow
    //   519: astore 7
    //   521: iconst_0
    //   522: istore_3
    //   523: iload 5
    //   525: istore_1
    //   526: iload_3
    //   527: ifeq -88 -> 439
    //   530: iload_1
    //   531: ireturn
    //   532: astore 7
    //   534: ldc 2
    //   536: monitorexit
    //   537: aload 7
    //   539: athrow
    //   540: ldc 144
    //   542: ldc 86
    //   544: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   551: aload_0
    //   552: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   555: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   558: aload_0
    //   559: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   562: aload_0
    //   563: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   566: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   569: ldc 153
    //   571: ldc 86
    //   573: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: goto -63 -> 513
    //   579: astore 7
    //   581: ldc 2
    //   583: monitorexit
    //   584: aload 7
    //   586: athrow
    //   587: ldc 144
    //   589: ldc 86
    //   591: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   598: aload_0
    //   599: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   602: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   605: aload_0
    //   606: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   609: aload_0
    //   610: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   613: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   616: ldc 153
    //   618: ldc 86
    //   620: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: goto -190 -> 433
    //   626: astore 7
    //   628: ldc 2
    //   630: monitorexit
    //   631: aload 7
    //   633: athrow
    //   634: ldc 144
    //   636: ldc 86
    //   638: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: aload_0
    //   642: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   645: aload_0
    //   646: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   649: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   652: aload_0
    //   653: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   656: aload_0
    //   657: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   660: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   663: ldc 153
    //   665: ldc 86
    //   667: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: goto -427 -> 243
    //   673: astore 7
    //   675: iload_1
    //   676: istore_3
    //   677: iload_2
    //   678: istore_1
    //   679: goto -153 -> 526
    //   682: astore 7
    //   684: goto -158 -> 526
    //   687: astore 7
    //   689: iconst_0
    //   690: istore_3
    //   691: iload 4
    //   693: istore_1
    //   694: goto -385 -> 309
    //   697: astore 7
    //   699: iload_3
    //   700: istore_1
    //   701: iload 4
    //   703: istore_2
    //   704: goto -412 -> 292
    //   707: astore 7
    //   709: iload_1
    //   710: istore_2
    //   711: iload_3
    //   712: istore_1
    //   713: goto -421 -> 292
    //   716: astore 7
    //   718: iconst_0
    //   719: istore_3
    //   720: iload_2
    //   721: istore_1
    //   722: iload_3
    //   723: istore_2
    //   724: goto -432 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	this	RSACrypt
    //   1	721	1	i	int
    //   3	721	2	j	int
    //   11	712	3	k	int
    //   5	697	4	m	int
    //   8	516	5	n	int
    //   13	67	6	i1	int
    //   22	279	7	arrayOfByte1	byte[]
    //   303	1	7	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   312	205	7	localObject1	Object
    //   519	1	7	localObject2	Object
    //   532	6	7	localObject3	Object
    //   579	6	7	localObject4	Object
    //   626	6	7	localObject5	Object
    //   673	1	7	localObject6	Object
    //   682	1	7	localObject7	Object
    //   687	1	7	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   697	1	7	localObject8	Object
    //   707	1	7	localObject9	Object
    //   716	1	7	localObject10	Object
    //   31	453	8	arrayOfByte2	byte[]
    //   458	38	9	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   300	303	303	java/lang/UnsatisfiedLinkError
    //   84	87	519	finally
    //   442	460	532	finally
    //   465	471	532	finally
    //   476	513	532	finally
    //   513	516	532	finally
    //   534	537	532	finally
    //   540	576	532	finally
    //   362	380	579	finally
    //   385	391	579	finally
    //   396	433	579	finally
    //   433	436	579	finally
    //   581	584	579	finally
    //   587	623	579	finally
    //   172	190	626	finally
    //   195	201	626	finally
    //   206	243	626	finally
    //   243	246	626	finally
    //   628	631	626	finally
    //   634	670	626	finally
    //   300	303	673	finally
    //   309	314	682	finally
    //   319	353	682	finally
    //   84	87	687	java/lang/UnsatisfiedLinkError
    //   263	287	697	finally
    //   297	300	697	finally
    //   160	163	707	finally
    //   87	105	716	finally
    //   110	116	716	finally
    //   121	158	716	finally
    //   248	260	716	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.RSACrypt
 * JD-Core Version:    0.7.0.1
 */