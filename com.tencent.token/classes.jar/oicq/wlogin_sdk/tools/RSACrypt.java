package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.util.Log;

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
    Object localObject2 = null;
    if (paramArrayOfByte2 == null)
    {
      util.LOGI("DecryptData data is null", "");
      return null;
    }
    Object localObject1 = paramArrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = util.get_rsa_privkey(this._context);
      if (paramArrayOfByte1 != null)
      {
        localObject1 = paramArrayOfByte1;
        if (paramArrayOfByte1.length != 0) {}
      }
      else
      {
        localObject1 = util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9");
      }
    }
    try
    {
      localObject3 = decryptdata((byte[])localObject1, paramArrayOfByte2);
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        paramArrayOfByte1 = (byte[])localObject3;
        if (localObject3.length != 0) {}
      }
      else
      {
        localObject2 = localObject3;
        paramArrayOfByte1 = decryptdata(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9"), paramArrayOfByte2);
      }
    }
    catch (UnsatisfiedLinkError paramArrayOfByte1)
    {
      Object localObject3 = new StringBuilder("DecryptData UnsatisfiedLinkError ");
      ((StringBuilder)localObject3).append(Log.getStackTraceString(paramArrayOfByte1));
      util.LOGI(((StringBuilder)localObject3).toString(), "");
      paramArrayOfByte1 = (byte[])localObject2;
    }
    localObject2 = paramArrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      try
      {
        localObject1 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI((byte[])localObject1));
        paramArrayOfByte1 = (byte[])localObject1;
        try
        {
          localObject2 = new StringBuilder("dedata first:");
          int j = 0;
          int i;
          if (localObject1 == null)
          {
            i = 0;
          }
          else
          {
            paramArrayOfByte1 = (byte[])localObject1;
            i = localObject1.length;
          }
          paramArrayOfByte1 = (byte[])localObject1;
          ((StringBuilder)localObject2).append(i);
          paramArrayOfByte1 = (byte[])localObject1;
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          if (localObject1 != null)
          {
            paramArrayOfByte1 = (byte[])localObject1;
            if (localObject1.length != 0) {
              break label331;
            }
          }
          paramArrayOfByte1 = (byte[])localObject1;
          paramArrayOfByte2 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9")));
          paramArrayOfByte1 = paramArrayOfByte2;
          localObject1 = new StringBuilder("dedata second:");
          if (paramArrayOfByte2 == null)
          {
            i = j;
          }
          else
          {
            paramArrayOfByte1 = paramArrayOfByte2;
            i = paramArrayOfByte2.length;
          }
          paramArrayOfByte1 = paramArrayOfByte2;
          ((StringBuilder)localObject1).append(i);
          paramArrayOfByte1 = paramArrayOfByte2;
          util.LOGI(((StringBuilder)localObject1).toString(), "");
          return paramArrayOfByte2;
        }
        catch (Exception paramArrayOfByte2) {}
        localObject1 = new StringBuilder("DecryptData java decrypt exception ");
      }
      catch (Exception paramArrayOfByte2) {}
      ((StringBuilder)localObject1).append(paramArrayOfByte2.toString());
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      localObject2 = paramArrayOfByte1;
    }
    else
    {
      return localObject2;
    }
    label331:
    return localObject1;
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
    //   4: invokestatic 116	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   13: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   16: astore 6
    //   18: iconst_0
    //   19: istore_2
    //   20: iconst_0
    //   21: istore_1
    //   22: iconst_0
    //   23: istore_3
    //   24: aload 5
    //   26: ifnull +46 -> 72
    //   29: aload 5
    //   31: arraylength
    //   32: ifle +40 -> 72
    //   35: aload 6
    //   37: ifnull +35 -> 72
    //   40: aload 6
    //   42: arraylength
    //   43: ifle +29 -> 72
    //   46: aload_0
    //   47: aload 5
    //   49: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   52: checkcast 117	[B
    //   55: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   58: aload_0
    //   59: aload 6
    //   61: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   64: checkcast 117	[B
    //   67: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   70: iconst_0
    //   71: ireturn
    //   72: ldc 2
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   79: invokestatic 116	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   82: astore 5
    //   84: aload_0
    //   85: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   88: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   91: astore 6
    //   93: aload 5
    //   95: ifnull +58 -> 153
    //   98: aload 5
    //   100: arraylength
    //   101: ifle +52 -> 153
    //   104: aload 6
    //   106: ifnull +47 -> 153
    //   109: aload 6
    //   111: arraylength
    //   112: ifle +41 -> 153
    //   115: aload_0
    //   116: aload 5
    //   118: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   121: checkcast 117	[B
    //   124: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   127: aload_0
    //   128: aload 6
    //   130: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   133: checkcast 117	[B
    //   136: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   139: ldc 123
    //   141: ldc 50
    //   143: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iconst_1
    //   147: istore_2
    //   148: iconst_0
    //   149: istore_1
    //   150: goto +31 -> 181
    //   153: ldc 125
    //   155: ldc 50
    //   157: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: invokespecial 127	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   164: istore_1
    //   165: ldc 129
    //   167: iload_1
    //   168: invokestatic 135	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   171: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   174: ldc 50
    //   176: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: iconst_0
    //   180: istore_2
    //   181: ldc 2
    //   183: monitorexit
    //   184: iload_2
    //   185: ifeq +5 -> 190
    //   188: iconst_0
    //   189: ireturn
    //   190: ldc 2
    //   192: monitorenter
    //   193: aload_0
    //   194: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   197: invokestatic 116	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   200: astore 5
    //   202: aload_0
    //   203: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   206: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   209: astore 6
    //   211: aload 5
    //   213: ifnull +54 -> 267
    //   216: aload 5
    //   218: arraylength
    //   219: ifle +48 -> 267
    //   222: aload 6
    //   224: ifnull +43 -> 267
    //   227: aload 6
    //   229: arraylength
    //   230: ifle +37 -> 267
    //   233: aload_0
    //   234: aload 5
    //   236: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   239: checkcast 117	[B
    //   242: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   245: aload_0
    //   246: aload 6
    //   248: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   251: checkcast 117	[B
    //   254: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   257: ldc 141
    //   259: ldc 50
    //   261: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: goto +39 -> 303
    //   267: ldc 143
    //   269: ldc 50
    //   271: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   278: aload_0
    //   279: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   282: invokestatic 147	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   285: aload_0
    //   286: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   289: aload_0
    //   290: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   293: invokestatic 150	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   296: ldc 152
    //   298: ldc 50
    //   300: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: ldc 2
    //   305: monitorexit
    //   306: iload_1
    //   307: ireturn
    //   308: astore 5
    //   310: ldc 2
    //   312: monitorexit
    //   313: aload 5
    //   315: athrow
    //   316: astore 5
    //   318: iload_2
    //   319: istore_3
    //   320: iload_1
    //   321: istore_2
    //   322: iload_3
    //   323: istore_1
    //   324: goto +16 -> 340
    //   327: astore 5
    //   329: iload_1
    //   330: istore_2
    //   331: goto +7 -> 338
    //   334: astore 5
    //   336: iload_3
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
    //   363: goto +198 -> 561
    //   366: iconst_0
    //   367: istore_1
    //   368: iload_2
    //   369: istore_3
    //   370: iload_1
    //   371: istore 4
    //   373: invokestatic 156	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   376: astore 5
    //   378: aload 5
    //   380: ifnull +47 -> 427
    //   383: iload_2
    //   384: istore_3
    //   385: iload_1
    //   386: istore 4
    //   388: aload_0
    //   389: aload 5
    //   391: invokevirtual 162	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   394: invokeinterface 168 1 0
    //   399: invokestatic 172	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   402: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   405: iload_2
    //   406: istore_3
    //   407: iload_1
    //   408: istore 4
    //   410: aload_0
    //   411: aload 5
    //   413: invokevirtual 176	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   416: invokeinterface 179 1 0
    //   421: invokestatic 182	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   424: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   427: iload_1
    //   428: ifeq +5 -> 433
    //   431: iload_2
    //   432: ireturn
    //   433: ldc 2
    //   435: monitorenter
    //   436: aload_0
    //   437: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   440: invokestatic 116	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   443: astore 5
    //   445: aload_0
    //   446: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   449: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   452: astore 6
    //   454: aload 5
    //   456: ifnull +54 -> 510
    //   459: aload 5
    //   461: arraylength
    //   462: ifle +48 -> 510
    //   465: aload 6
    //   467: ifnull +43 -> 510
    //   470: aload 6
    //   472: arraylength
    //   473: ifle +37 -> 510
    //   476: aload_0
    //   477: aload 5
    //   479: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   482: checkcast 117	[B
    //   485: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   488: aload_0
    //   489: aload 6
    //   491: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   494: checkcast 117	[B
    //   497: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   500: ldc 141
    //   502: ldc 50
    //   504: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto +39 -> 546
    //   510: ldc 143
    //   512: ldc 50
    //   514: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_0
    //   518: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   521: aload_0
    //   522: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   525: invokestatic 147	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   528: aload_0
    //   529: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   532: aload_0
    //   533: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   536: invokestatic 150	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   539: ldc 152
    //   541: ldc 50
    //   543: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: ldc 2
    //   548: monitorexit
    //   549: iload_2
    //   550: ireturn
    //   551: astore 5
    //   553: ldc 2
    //   555: monitorexit
    //   556: aload 5
    //   558: athrow
    //   559: astore 5
    //   561: iload 4
    //   563: ifeq +5 -> 568
    //   566: iload_3
    //   567: ireturn
    //   568: ldc 2
    //   570: monitorenter
    //   571: aload_0
    //   572: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   575: invokestatic 116	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   578: astore 6
    //   580: aload_0
    //   581: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   584: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   587: astore 7
    //   589: aload 6
    //   591: ifnull +54 -> 645
    //   594: aload 6
    //   596: arraylength
    //   597: ifle +48 -> 645
    //   600: aload 7
    //   602: ifnull +43 -> 645
    //   605: aload 7
    //   607: arraylength
    //   608: ifle +37 -> 645
    //   611: aload_0
    //   612: aload 6
    //   614: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   617: checkcast 117	[B
    //   620: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   623: aload_0
    //   624: aload 7
    //   626: invokevirtual 121	[B:clone	()Ljava/lang/Object;
    //   629: checkcast 117	[B
    //   632: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   635: ldc 141
    //   637: ldc 50
    //   639: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: goto +39 -> 681
    //   645: ldc 143
    //   647: ldc 50
    //   649: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload_0
    //   653: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   656: aload_0
    //   657: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   660: invokestatic 147	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   663: aload_0
    //   664: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   667: aload_0
    //   668: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   671: invokestatic 150	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   674: ldc 152
    //   676: ldc 50
    //   678: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: ldc 2
    //   683: monitorexit
    //   684: aload 5
    //   686: athrow
    //   687: astore 5
    //   689: ldc 2
    //   691: monitorexit
    //   692: aload 5
    //   694: athrow
    //   695: astore 5
    //   697: goto -331 -> 366
    //   700: astore 5
    //   702: goto -334 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	RSACrypt
    //   21	407	1	i	int
    //   19	531	2	j	int
    //   23	544	3	k	int
    //   346	216	4	m	int
    //   7	228	5	arrayOfByte1	byte[]
    //   308	6	5	localObject1	Object
    //   316	1	5	localObject2	Object
    //   327	1	5	localObject3	Object
    //   334	15	5	localObject4	Object
    //   351	1	5	localObject5	Object
    //   356	1	5	localObject6	Object
    //   376	102	5	localObject7	Object
    //   551	6	5	localObject8	Object
    //   559	126	5	localObject9	Object
    //   687	6	5	localObject10	Object
    //   695	1	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   700	1	5	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   16	597	6	arrayOfByte2	byte[]
    //   587	38	7	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   193	211	308	finally
    //   216	222	308	finally
    //   227	264	308	finally
    //   267	303	308	finally
    //   303	306	308	finally
    //   310	313	308	finally
    //   181	184	316	finally
    //   165	179	327	finally
    //   75	93	334	finally
    //   98	104	334	finally
    //   109	146	334	finally
    //   153	165	334	finally
    //   340	343	351	finally
    //   72	75	356	finally
    //   436	454	551	finally
    //   459	465	551	finally
    //   470	507	551	finally
    //   510	546	551	finally
    //   546	549	551	finally
    //   553	556	551	finally
    //   348	351	559	finally
    //   373	378	559	finally
    //   388	405	559	finally
    //   410	427	559	finally
    //   571	589	687	finally
    //   594	600	687	finally
    //   605	642	687	finally
    //   645	681	687	finally
    //   681	684	687	finally
    //   689	692	687	finally
    //   72	75	695	java/lang/UnsatisfiedLinkError
    //   348	351	700	java/lang/UnsatisfiedLinkError
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