package oicq.wlogin_sdk.request;

import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class i
{
  private t a;
  private int b;
  private int c;
  private ErrMsg d;
  
  public i(t paramt, int paramInt1, int paramInt2, ErrMsg paramErrMsg)
  {
    this.a = paramt;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramErrMsg;
  }
  
  int a(byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder("notice len ");
    ((StringBuilder)localObject1).append(paramArrayOfByte.length);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.f);
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = util.string_to_buf("30820122300d06092a864886f70d01010105000382010f003082010a0282010100bb65a9189e42aabf8c4c97b8bb7e35f6239df71152c0108d5c9b98d86ed7b14fa4b6e2ca5749eda03b5746e97b10c1772eab364fcedbfc4b3bb4d839ed97f657daa54622b54dfb29fe66f37f3e26e779675fec2337d0f8cbdf550b04f936be0927bbbecc851b6d966a3ba51c9747a8c588979ec248d5c8a66d1dd4fed0bcd3eb78725fd04b25cdceeac17d0068f07b3a2a360105cc1f4a0fd361d8d3ff0a9e5598b4196304635482be7ceda63a80479aa396a341fb206c81d7c476f860ac6d90734d523d1015eb73f390104c2bb85d0c05db4d11feae941ff5c92be9a1c123283dc2e0dc1368420d6f71cc50e343534e7c0ff16345680859e14c35f1f021cdfb0203010001");
    Object localObject3 = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte = null;
    localObject2 = null;
    try
    {
      Object localObject4 = new byte[((ByteBuffer)localObject3).getShort()];
      ((ByteBuffer)localObject3).get((byte[])localObject4);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject1)));
      localObject1 = localCipher.doFinal((byte[])localObject4);
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return -1000;
        }
        localObject4 = ByteBuffer.wrap((byte[])localObject1);
        localObject1 = new byte[((ByteBuffer)localObject4).getShort()];
        paramArrayOfByte = (byte[])localObject2;
        try
        {
          ((ByteBuffer)localObject4).get((byte[])localObject1);
          paramArrayOfByte = (byte[])localObject2;
          localObject2 = new byte[((ByteBuffer)localObject4).getShort()];
          paramArrayOfByte = (byte[])localObject2;
          ((ByteBuffer)localObject4).get((byte[])localObject2);
          paramArrayOfByte = (byte[])localObject2;
          ((ByteBuffer)localObject4).getInt();
          paramArrayOfByte = (byte[])localObject2;
        }
        catch (Exception localException1)
        {
          break label229;
        }
      }
      else
      {
        return -1000;
      }
    }
    catch (Exception localException2)
    {
      localObject1 = null;
      label229:
      util.printException(localException2);
      if (localObject1 != null)
      {
        if (paramArrayOfByte == null) {
          return -1000;
        }
        byte[] arrayOfByte = new byte[((ByteBuffer)localObject3).limit() - ((ByteBuffer)localObject3).position()];
        ((ByteBuffer)localObject3).get(arrayOfByte);
        int j = arrayOfByte.length;
        int i = 0;
        localObject1 = cryptor.decrypt(arrayOfByte, 0, j, (byte[])localObject1);
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return -1000;
          }
          if (!Arrays.equals(paramArrayOfByte, MD5.toMD5Byte((byte[])localObject1))) {
            return -1000;
          }
          paramArrayOfByte = ByteBuffer.wrap((byte[])localObject1);
          paramArrayOfByte.getShort();
          j = paramArrayOfByte.getShort();
          if (j == 0) {
            return -1000;
          }
          while (i < j)
          {
            int k = paramArrayOfByte.getShort();
            localObject1 = new byte[paramArrayOfByte.getShort()];
            paramArrayOfByte.get((byte[])localObject1);
            switch (k)
            {
            default: 
              break;
            case 1282: 
              this.d.setTitle(new String((byte[])localObject1));
              break;
            case 1281: 
              localObject1 = ByteBuffer.wrap((byte[])localObject1);
              k = ((ByteBuffer)localObject1).getInt();
              util.LOGI("what ".concat(String.valueOf(k)), "");
              if (k != 0) {
                return -1000;
              }
              arrayOfByte = new byte[((ByteBuffer)localObject1).getShort()];
              localObject3 = new StringBuilder("msg len ");
              ((StringBuilder)localObject3).append(arrayOfByte.length);
              util.LOGI(((StringBuilder)localObject3).toString(), "");
              if (arrayOfByte.length == 0) {
                return -1000;
              }
              ((ByteBuffer)localObject1).get(arrayOfByte);
              this.d.setMessage(new String(arrayOfByte));
              this.d.setType(257);
            }
            i += 1;
          }
          return this.d.getType();
        }
        return -1000;
      }
    }
    return -1000;
  }
  
  byte[] a(int paramInt)
  {
    Object localObject1 = ByteBuffer.allocate(43);
    Object localObject2 = t.b(this.a.h);
    ((ByteBuffer)localObject1).put(t.ad);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sappid);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sub_appid);
    ((ByteBuffer)localObject1).putShort((short)0);
    ((ByteBuffer)localObject1).putLong(this.a.f);
    ((ByteBuffer)localObject1).putShort((short)10);
    ((ByteBuffer)localObject1).put("6.0.0.2202".getBytes());
    ((ByteBuffer)localObject1).putShort((short)this.b);
    ((ByteBuffer)localObject1).putShort((short)this.c);
    int i;
    if (paramInt == -1000) {
      i = 1;
    } else {
      i = 0;
    }
    ((ByteBuffer)localObject1).put((byte)i);
    ((ByteBuffer)localObject1).putInt(paramInt);
    localObject2 = new tlv_t8().get_tlv_8(0, t.u, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(((ByteBuffer)localObject1).capacity() + 4 + 4 + (tlv_t508.userBuf.length + 4) + 8 + localObject2.length);
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort((short)3);
    localByteBuffer.putShort((short)512);
    localByteBuffer.putShort((short)((ByteBuffer)localObject1).capacity());
    localByteBuffer.put(((ByteBuffer)localObject1).array());
    localByteBuffer.putShort((short)513);
    localByteBuffer.putShort((short)4);
    localByteBuffer.putInt(2);
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort((short)tlv_t508.userBuf.length);
    localByteBuffer.put(tlv_t508.userBuf);
    localByteBuffer.put((byte[])localObject2);
    localObject2 = cryptor.encrypt(localByteBuffer.array(), 0, localByteBuffer.position(), this.a.c);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = ByteBuffer.allocate(this.a.c.length + 2 + 2 + localObject1.length);
    ((ByteBuffer)localObject2).putShort((short)this.a.c.length);
    ((ByteBuffer)localObject2).put(this.a.c);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    return ((ByteBuffer)localObject2).array();
  }
  
  /* Error */
  int b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 250	oicq/wlogin_sdk/request/i:a	(I)[B
    //   14: astore 5
    //   16: aload 4
    //   18: astore_3
    //   19: new 30	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   26: astore 7
    //   28: iconst_0
    //   29: istore_1
    //   30: aload 4
    //   32: astore_3
    //   33: invokestatic 256	java/lang/Math:random	()D
    //   36: ldc2_w 257
    //   39: dmul
    //   40: invokestatic 262	java/lang/Math:round	(D)J
    //   43: l2i
    //   44: istore_2
    //   45: aload 4
    //   47: astore_3
    //   48: aload 7
    //   50: iconst_3
    //   51: anewarray 145	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 264
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc_w 266
    //   65: aastore
    //   66: dup
    //   67: iconst_2
    //   68: ldc_w 268
    //   71: aastore
    //   72: iload_2
    //   73: iconst_3
    //   74: irem
    //   75: aaload
    //   76: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: astore_3
    //   83: aload 7
    //   85: ldc_w 273
    //   88: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 4
    //   94: astore_3
    //   95: aload 7
    //   97: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 7
    //   102: aload 4
    //   104: astore_3
    //   105: new 30	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 275
    //   112: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: astore 8
    //   117: aload 4
    //   119: astore_3
    //   120: aload 8
    //   122: aload 7
    //   124: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 4
    //   130: astore_3
    //   131: aload 8
    //   133: ldc_w 277
    //   136: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: astore_3
    //   143: new 279	java/net/URL
    //   146: dup
    //   147: aload 8
    //   149: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 280	java/net/URL:<init>	(Ljava/lang/String;)V
    //   155: invokevirtual 284	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   158: checkcast 286	java/net/HttpURLConnection
    //   161: astore 4
    //   163: aload 4
    //   165: ldc_w 288
    //   168: invokevirtual 291	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   171: new 30	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   178: astore_3
    //   179: aload_3
    //   180: aload 5
    //   182: arraylength
    //   183: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 4
    //   189: ldc_w 293
    //   192: aload_3
    //   193: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 296	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 4
    //   201: ldc_w 298
    //   204: ldc_w 300
    //   207: invokevirtual 296	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 4
    //   212: getstatic 303	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   215: invokevirtual 306	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   218: aload 4
    //   220: getstatic 303	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   223: invokevirtual 309	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   226: aload 4
    //   228: iconst_1
    //   229: invokevirtual 313	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   232: aload 4
    //   234: iconst_1
    //   235: invokevirtual 316	java/net/HttpURLConnection:setDoInput	(Z)V
    //   238: aload 4
    //   240: aload_0
    //   241: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/t;
    //   244: getfield 319	oicq/wlogin_sdk/request/t:l	I
    //   247: i2l
    //   248: invokestatic 324	oicq/wlogin_sdk/request/j:a	(Ljava/net/HttpURLConnection;J)Z
    //   251: ifne +47 -> 298
    //   254: new 30	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   261: astore_3
    //   262: aload_3
    //   263: aload_0
    //   264: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/t;
    //   267: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   270: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: ldc_w 326
    //   277: aload_3
    //   278: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 59	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   294: sipush -1000
    //   297: ireturn
    //   298: aload 4
    //   300: invokevirtual 333	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   303: astore_3
    //   304: aload_3
    //   305: aload 5
    //   307: invokevirtual 338	java/io/OutputStream:write	([B)V
    //   310: aload_3
    //   311: invokevirtual 341	java/io/OutputStream:close	()V
    //   314: aload 4
    //   316: invokevirtual 344	java/net/HttpURLConnection:getResponseCode	()I
    //   319: istore_2
    //   320: ldc_w 346
    //   323: iload_2
    //   324: invokestatic 157	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   327: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore_3
    //   331: new 30	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   338: astore 5
    //   340: aload 5
    //   342: aload_0
    //   343: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/t;
    //   346: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   349: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_3
    //   354: aload 5
    //   356: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 59	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: sipush 200
    //   365: iload_2
    //   366: if_icmpeq +17 -> 383
    //   369: aload 4
    //   371: ifnull +8 -> 379
    //   374: aload 4
    //   376: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   379: sipush -1000
    //   382: ireturn
    //   383: new 30	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   390: astore_3
    //   391: aload_3
    //   392: aload_0
    //   393: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/t;
    //   396: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   399: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: ldc_w 348
    //   406: aload_3
    //   407: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 59	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload 4
    //   415: invokevirtual 352	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   418: astore_3
    //   419: new 354	java/io/ByteArrayOutputStream
    //   422: dup
    //   423: invokespecial 355	java/io/ByteArrayOutputStream:<init>	()V
    //   426: astore 5
    //   428: sipush 1024
    //   431: newarray byte
    //   433: astore 6
    //   435: aload_3
    //   436: aload 6
    //   438: invokevirtual 360	java/io/InputStream:read	([B)I
    //   441: istore_2
    //   442: iload_2
    //   443: iconst_m1
    //   444: if_icmpeq +15 -> 459
    //   447: aload 5
    //   449: aload 6
    //   451: iconst_0
    //   452: iload_2
    //   453: invokevirtual 363	java/io/ByteArrayOutputStream:write	([BII)V
    //   456: goto -21 -> 435
    //   459: aload_0
    //   460: aload 5
    //   462: invokevirtual 366	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   465: invokevirtual 368	oicq/wlogin_sdk/request/i:a	([B)I
    //   468: sipush -1000
    //   471: if_icmpeq +5 -> 476
    //   474: iconst_1
    //   475: istore_1
    //   476: aload 5
    //   478: invokevirtual 369	java/io/ByteArrayOutputStream:close	()V
    //   481: iload_1
    //   482: ifne +17 -> 499
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   495: sipush -1000
    //   498: ireturn
    //   499: aload 4
    //   501: ifnull +8 -> 509
    //   504: aload 4
    //   506: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   509: sipush 257
    //   512: ireturn
    //   513: astore_3
    //   514: goto +47 -> 561
    //   517: astore 5
    //   519: goto +20 -> 539
    //   522: astore 5
    //   524: aload_3
    //   525: astore 4
    //   527: aload 5
    //   529: astore_3
    //   530: goto +31 -> 561
    //   533: astore 5
    //   535: aload 6
    //   537: astore 4
    //   539: aload 4
    //   541: astore_3
    //   542: aload 5
    //   544: invokestatic 120	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   547: aload 4
    //   549: ifnull +8 -> 557
    //   552: aload 4
    //   554: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   557: sipush -1000
    //   560: ireturn
    //   561: aload 4
    //   563: ifnull +8 -> 571
    //   566: aload 4
    //   568: invokevirtual 329	java/net/HttpURLConnection:disconnect	()V
    //   571: aload_3
    //   572: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	i
    //   0	573	1	paramInt	int
    //   44	409	2	i	int
    //   8	428	3	localObject1	Object
    //   513	12	3	localObject2	Object
    //   529	43	3	localObject3	Object
    //   4	563	4	localObject4	Object
    //   14	463	5	localObject5	Object
    //   517	1	5	localException1	Exception
    //   522	6	5	localObject6	Object
    //   533	10	5	localException2	Exception
    //   1	535	6	arrayOfByte	byte[]
    //   26	97	7	localObject7	Object
    //   115	33	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   163	284	513	finally
    //   298	362	513	finally
    //   383	435	513	finally
    //   435	442	513	finally
    //   447	456	513	finally
    //   459	474	513	finally
    //   476	481	513	finally
    //   163	284	517	java/lang/Exception
    //   298	362	517	java/lang/Exception
    //   383	435	517	java/lang/Exception
    //   435	442	517	java/lang/Exception
    //   447	456	517	java/lang/Exception
    //   459	474	517	java/lang/Exception
    //   476	481	517	java/lang/Exception
    //   9	16	522	finally
    //   19	28	522	finally
    //   33	45	522	finally
    //   48	80	522	finally
    //   83	92	522	finally
    //   95	102	522	finally
    //   105	117	522	finally
    //   120	128	522	finally
    //   131	140	522	finally
    //   143	163	522	finally
    //   542	547	522	finally
    //   9	16	533	java/lang/Exception
    //   19	28	533	java/lang/Exception
    //   33	45	533	java/lang/Exception
    //   48	80	533	java/lang/Exception
    //   83	92	533	java/lang/Exception
    //   95	102	533	java/lang/Exception
    //   105	117	533	java/lang/Exception
    //   120	128	533	java/lang/Exception
    //   131	140	533	java/lang/Exception
    //   143	163	533	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.i
 * JD-Core Version:    0.7.0.1
 */