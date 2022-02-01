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
  private u a;
  private int b;
  private int c;
  private ErrMsg d;
  
  public i(u paramu, int paramInt1, int paramInt2, ErrMsg paramErrMsg)
  {
    this.a = paramu;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramErrMsg;
  }
  
  int a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    localObject1 = null;
    util.LOGI("notice len " + paramArrayOfByte.length, this.a.f + "");
    arrayOfByte = util.string_to_buf("30820122300d06092a864886f70d01010105000382010f003082010a0282010100bb65a9189e42aabf8c4c97b8bb7e35f6239df71152c0108d5c9b98d86ed7b14fa4b6e2ca5749eda03b5746e97b10c1772eab364fcedbfc4b3bb4d839ed97f657daa54622b54dfb29fe66f37f3e26e779675fec2337d0f8cbdf550b04f936be0927bbbecc851b6d966a3ba51c9747a8c588979ec248d5c8a66d1dd4fed0bcd3eb78725fd04b25cdceeac17d0068f07b3a2a360105cc1f4a0fd361d8d3ff0a9e5598b4196304635482be7ceda63a80479aa396a341fb206c81d7c476f860ac6d90734d523d1015eb73f390104c2bb85d0c05db4d11feae941ff5c92be9a1c123283dc2e0dc1368420d6f71cc50e343534e7c0ff16345680859e14c35f1f021cdfb0203010001");
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new byte[localByteBuffer.getShort()];
      localByteBuffer.get(paramArrayOfByte);
      Object localObject3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      ((Cipher)localObject3).init(2, (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte)));
      paramArrayOfByte = ((Cipher)localObject3).doFinal(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        localObject3 = ByteBuffer.wrap(paramArrayOfByte);
        arrayOfByte = new byte[((ByteBuffer)localObject3).getShort()];
        paramArrayOfByte = localObject2;
      }
      int j;
      int i;
      int k;
      return -1000;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          ((ByteBuffer)localObject3).get(arrayOfByte);
          paramArrayOfByte = localObject2;
          localObject1 = new byte[((ByteBuffer)localObject3).getShort()];
          paramArrayOfByte = (byte[])localObject1;
          ((ByteBuffer)localObject3).get((byte[])localObject1);
          paramArrayOfByte = (byte[])localObject1;
          ((ByteBuffer)localObject3).getInt();
          paramArrayOfByte = arrayOfByte;
          if ((paramArrayOfByte != null) && (localObject1 != null)) {
            continue;
          }
          return -1000;
        }
        catch (Exception localException2)
        {
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = arrayOfByte;
          continue;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
        util.printException(localException1);
      }
      arrayOfByte = new byte[localByteBuffer.limit() - localByteBuffer.position()];
      localByteBuffer.get(arrayOfByte);
      paramArrayOfByte = cryptor.decrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        return -1000;
      }
      if (!Arrays.equals((byte[])localObject1, MD5.toMD5Byte(paramArrayOfByte))) {
        return -1000;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      paramArrayOfByte.getShort();
      j = paramArrayOfByte.getShort();
      if (j == 0) {
        return -1000;
      }
      i = 0;
      if (i < j)
      {
        k = paramArrayOfByte.getShort();
        localObject1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject1);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          localObject1 = ByteBuffer.wrap((byte[])localObject1);
          k = ((ByteBuffer)localObject1).getInt();
          util.LOGI("what " + k, "");
          if (k != 0) {
            return -1000;
          }
          arrayOfByte = new byte[((ByteBuffer)localObject1).getShort()];
          util.LOGI("msg len " + arrayOfByte.length, "");
          if (arrayOfByte.length == 0) {
            return -1000;
          }
          ((ByteBuffer)localObject1).get(arrayOfByte);
          this.d.setMessage(new String(arrayOfByte));
          this.d.setType(257);
          continue;
          this.d.setTitle(new String((byte[])localObject1));
        }
      }
      return this.d.getType();
    }
  }
  
  byte[] a(int paramInt)
  {
    Object localObject1 = ByteBuffer.allocate("6.0.0.2484".length() + 24 + 2 + 2 + 1 + 4);
    Object localObject2 = u.b(this.a.h);
    ((ByteBuffer)localObject1).put(u.ag);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sappid);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sub_appid);
    ((ByteBuffer)localObject1).putShort((short)0);
    ((ByteBuffer)localObject1).putLong(this.a.f);
    ((ByteBuffer)localObject1).putShort((short)"6.0.0.2484".length());
    ((ByteBuffer)localObject1).put("6.0.0.2484".getBytes());
    ((ByteBuffer)localObject1).putShort((short)this.b);
    ((ByteBuffer)localObject1).putShort((short)this.c);
    if (paramInt == -1000) {}
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject1).put((byte)i);
      ((ByteBuffer)localObject1).putInt(paramInt);
      localObject2 = new tlv_t8().get_tlv_8(0, u.v, 0);
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
  }
  
  /* Error */
  int b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_3
    //   6: astore_2
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 246	oicq/wlogin_sdk/request/i:a	(I)[B
    //   12: astore 4
    //   14: aload_3
    //   15: astore_2
    //   16: new 30	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   23: astore 6
    //   25: aload_3
    //   26: astore_2
    //   27: invokestatic 252	java/lang/Math:random	()D
    //   30: ldc2_w 253
    //   33: dmul
    //   34: invokestatic 258	java/lang/Math:round	(D)J
    //   37: l2i
    //   38: istore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload 6
    //   43: iconst_3
    //   44: anewarray 151	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 260
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 262
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc_w 264
    //   64: aastore
    //   65: iload_1
    //   66: iconst_3
    //   67: irem
    //   68: aaload
    //   69: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 266
    //   75: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 6
    //   83: aload_3
    //   84: astore_2
    //   85: new 268	java/net/URL
    //   88: dup
    //   89: new 30	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 270
    //   99: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 6
    //   104: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 272
    //   110: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 274	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 278	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   122: checkcast 280	java/net/HttpURLConnection
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 282
    //   130: invokevirtual 285	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: ldc_w 287
    //   137: new 30	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   144: aload 4
    //   146: arraylength
    //   147: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc 55
    //   152: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 290	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ldc_w 292
    //   165: ldc_w 294
    //   168: invokevirtual 290	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_3
    //   172: getstatic 297	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   175: invokevirtual 300	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   178: aload_3
    //   179: getstatic 297	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   182: invokevirtual 303	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   185: aload_3
    //   186: iconst_1
    //   187: invokevirtual 307	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   190: aload_3
    //   191: iconst_1
    //   192: invokevirtual 310	java/net/HttpURLConnection:setDoInput	(Z)V
    //   195: aload_3
    //   196: aload_0
    //   197: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/u;
    //   200: getfield 313	oicq/wlogin_sdk/request/u:l	I
    //   203: i2l
    //   204: invokestatic 318	oicq/wlogin_sdk/request/j:a	(Ljava/net/HttpURLConnection;J)Z
    //   207: ifne +46 -> 253
    //   210: ldc_w 320
    //   213: new 30	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   220: ldc 55
    //   222: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/u;
    //   229: getfield 50	oicq/wlogin_sdk/request/u:f	J
    //   232: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   249: sipush -1000
    //   252: ireturn
    //   253: aload_3
    //   254: invokevirtual 327	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   257: astore_2
    //   258: aload_2
    //   259: aload 4
    //   261: invokevirtual 332	java/io/OutputStream:write	([B)V
    //   264: aload_2
    //   265: invokevirtual 335	java/io/OutputStream:close	()V
    //   268: aload_3
    //   269: invokevirtual 338	java/net/HttpURLConnection:getResponseCode	()I
    //   272: istore_1
    //   273: new 30	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 340
    //   283: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_1
    //   287: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: new 30	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   300: ldc 55
    //   302: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/u;
    //   309: getfield 50	oicq/wlogin_sdk/request/u:f	J
    //   312: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: sipush 200
    //   324: iload_1
    //   325: if_icmpeq +15 -> 340
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   336: sipush -1000
    //   339: ireturn
    //   340: ldc_w 342
    //   343: new 30	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   350: ldc 55
    //   352: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: getfield 18	oicq/wlogin_sdk/request/i:a	Loicq/wlogin_sdk/request/u;
    //   359: getfield 50	oicq/wlogin_sdk/request/u:f	J
    //   362: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   365: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload_3
    //   372: invokevirtual 346	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   375: astore_2
    //   376: new 348	java/io/ByteArrayOutputStream
    //   379: dup
    //   380: invokespecial 349	java/io/ByteArrayOutputStream:<init>	()V
    //   383: astore 4
    //   385: sipush 1024
    //   388: newarray byte
    //   390: astore 5
    //   392: aload_2
    //   393: aload 5
    //   395: invokevirtual 354	java/io/InputStream:read	([B)I
    //   398: istore_1
    //   399: iload_1
    //   400: iconst_m1
    //   401: if_icmpeq +36 -> 437
    //   404: aload 4
    //   406: aload 5
    //   408: iconst_0
    //   409: iload_1
    //   410: invokevirtual 357	java/io/ByteArrayOutputStream:write	([BII)V
    //   413: goto -21 -> 392
    //   416: astore 4
    //   418: aload_3
    //   419: astore_2
    //   420: aload 4
    //   422: invokestatic 122	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   425: aload_3
    //   426: ifnull +7 -> 433
    //   429: aload_3
    //   430: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   433: sipush -1000
    //   436: ireturn
    //   437: aload_0
    //   438: aload 4
    //   440: invokevirtual 360	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   443: invokevirtual 362	oicq/wlogin_sdk/request/i:a	([B)I
    //   446: sipush -1000
    //   449: if_icmpeq +26 -> 475
    //   452: iconst_1
    //   453: istore_1
    //   454: aload 4
    //   456: invokevirtual 363	java/io/ByteArrayOutputStream:close	()V
    //   459: iload_1
    //   460: ifne +20 -> 480
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   471: sipush -1000
    //   474: ireturn
    //   475: iconst_0
    //   476: istore_1
    //   477: goto -23 -> 454
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   488: sipush 257
    //   491: ireturn
    //   492: astore 4
    //   494: aload_2
    //   495: astore_3
    //   496: aload 4
    //   498: astore_2
    //   499: aload_3
    //   500: ifnull +7 -> 507
    //   503: aload_3
    //   504: invokevirtual 323	java/net/HttpURLConnection:disconnect	()V
    //   507: aload_2
    //   508: athrow
    //   509: astore_2
    //   510: goto -11 -> 499
    //   513: astore 4
    //   515: aload 5
    //   517: astore_3
    //   518: goto -100 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	i
    //   0	521	1	paramInt	int
    //   6	502	2	localObject1	Object
    //   509	1	2	localObject2	Object
    //   1	517	3	localObject3	Object
    //   12	393	4	localObject4	Object
    //   416	39	4	localException1	Exception
    //   492	5	4	localObject5	Object
    //   513	1	4	localException2	Exception
    //   3	513	5	arrayOfByte	byte[]
    //   23	80	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   126	241	416	java/lang/Exception
    //   253	321	416	java/lang/Exception
    //   340	392	416	java/lang/Exception
    //   392	399	416	java/lang/Exception
    //   404	413	416	java/lang/Exception
    //   437	452	416	java/lang/Exception
    //   454	459	416	java/lang/Exception
    //   7	14	492	finally
    //   16	25	492	finally
    //   27	39	492	finally
    //   41	83	492	finally
    //   85	126	492	finally
    //   420	425	492	finally
    //   126	241	509	finally
    //   253	321	509	finally
    //   340	392	509	finally
    //   392	399	509	finally
    //   404	413	509	finally
    //   437	452	509	finally
    //   454	459	509	finally
    //   7	14	513	java/lang/Exception
    //   16	25	513	java/lang/Exception
    //   27	39	513	java/lang/Exception
    //   41	83	513	java/lang/Exception
    //   85	126	513	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.i
 * JD-Core Version:    0.7.0.1
 */