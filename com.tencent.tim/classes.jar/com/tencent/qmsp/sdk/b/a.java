package com.tencent.qmsp.sdk.b;

import com.tencent.qmsp.sdk.f.k;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class a
{
  private static final byte[] a = { 49, 99, -3, 81, 63, 117, 116, -14, 40 };
  private static final byte[] b = { 4, 85, -128 };
  private static final byte[] c = { 4, 85, -128, 15, 13, 25, 84, -78, 21, 91, -112, 115, 123, 11, 118, -7, 33, 121, -67, 71 };
  private static final byte[] d = { -58, -26, -51, -19 };
  private static final byte[] e = { -58, -26, -51, -19, 30, -3, -21, -29, 87, 39, 40, 12, -119, -40, -84, 65 };
  private static final b f = b.d;
  private static ThreadLocal<Integer> g = new ThreadLocal();
  
  /* Error */
  public static d a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: getstatic 44	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   3: getstatic 51	com/tencent/qmsp/sdk/b/a$c:c	Lcom/tencent/qmsp/sdk/b/a$c;
    //   6: invokevirtual 54	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   9: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: invokevirtual 64	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   15: new 66	java/net/InetSocketAddress
    //   18: dup
    //   19: getstatic 25	com/tencent/qmsp/sdk/b/a:a	[B
    //   22: invokestatic 71	com/tencent/qmsp/sdk/f/k:a	([B)Ljava/lang/String;
    //   25: ldc 72
    //   27: invokespecial 75	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   30: astore 8
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: iconst_1
    //   38: if_icmpge +340 -> 378
    //   41: new 77	java/net/Socket
    //   44: dup
    //   45: invokespecial 78	java/net/Socket:<init>	()V
    //   48: astore 9
    //   50: aload 9
    //   52: aload 8
    //   54: invokestatic 84	com/tencent/qmsp/sdk/app/QmspSDK:getAtomConnTimeOut	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   57: invokevirtual 89	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   60: invokevirtual 93	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   63: new 95	java/io/DataOutputStream
    //   66: dup
    //   67: new 97	java/io/BufferedOutputStream
    //   70: dup
    //   71: aload 9
    //   73: invokevirtual 101	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   76: invokespecial 104	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   79: invokespecial 105	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: astore 5
    //   84: iload_0
    //   85: aload_1
    //   86: iload_2
    //   87: aload_3
    //   88: aload 5
    //   90: invokestatic 108	com/tencent/qmsp/sdk/b/a:a	(ILjava/lang/String;ILorg/json/JSONObject;Ljava/io/DataOutputStream;)V
    //   93: aload 9
    //   95: invokestatic 111	com/tencent/qmsp/sdk/app/QmspSDK:getAtomReadTimeOut	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   98: invokevirtual 89	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   101: invokevirtual 115	java/net/Socket:setSoTimeout	(I)V
    //   104: new 117	java/io/DataInputStream
    //   107: dup
    //   108: new 119	java/io/BufferedInputStream
    //   111: dup
    //   112: aload 9
    //   114: invokevirtual 123	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   117: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: invokespecial 127	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore 7
    //   125: new 12	com/tencent/qmsp/sdk/b/a$d
    //   128: dup
    //   129: aload 7
    //   131: invokestatic 130	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/DataInputStream;)Lorg/json/JSONObject;
    //   134: getstatic 44	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   137: invokevirtual 133	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   140: checkcast 56	java/lang/Integer
    //   143: invokevirtual 136	java/lang/Integer:intValue	()I
    //   146: invokespecial 139	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   149: astore 6
    //   151: aload 7
    //   153: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   156: aload 5
    //   158: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   161: aload 9
    //   163: invokevirtual 145	java/net/Socket:close	()V
    //   166: aload 6
    //   168: areturn
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   174: goto -8 -> 166
    //   177: astore 6
    //   179: aload 5
    //   181: astore 6
    //   183: aload 7
    //   185: astore 5
    //   187: getstatic 44	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   190: getstatic 151	com/tencent/qmsp/sdk/b/a$c:l	Lcom/tencent/qmsp/sdk/b/a$c;
    //   193: invokevirtual 54	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   196: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: invokevirtual 64	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   202: aload 5
    //   204: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   207: aload 6
    //   209: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   212: aload 9
    //   214: invokevirtual 145	java/net/Socket:close	()V
    //   217: iload 4
    //   219: iconst_1
    //   220: iadd
    //   221: istore 4
    //   223: goto -188 -> 35
    //   226: astore 6
    //   228: new 12	com/tencent/qmsp/sdk/b/a$d
    //   231: dup
    //   232: aconst_null
    //   233: getstatic 154	com/tencent/qmsp/sdk/b/a$c:i	Lcom/tencent/qmsp/sdk/b/a$c;
    //   236: invokevirtual 54	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   239: invokespecial 139	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   242: astore 6
    //   244: aconst_null
    //   245: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   248: aload 5
    //   250: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   253: aload 9
    //   255: invokevirtual 145	java/net/Socket:close	()V
    //   258: aload 6
    //   260: areturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   266: aload 6
    //   268: areturn
    //   269: astore 5
    //   271: aconst_null
    //   272: astore 5
    //   274: goto -46 -> 228
    //   277: astore 6
    //   279: aload 5
    //   281: astore 6
    //   283: aconst_null
    //   284: astore 5
    //   286: goto -99 -> 187
    //   289: astore 5
    //   291: new 12	com/tencent/qmsp/sdk/b/a$d
    //   294: dup
    //   295: aconst_null
    //   296: getstatic 157	com/tencent/qmsp/sdk/b/a$c:h	Lcom/tencent/qmsp/sdk/b/a$c;
    //   299: invokevirtual 54	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   302: invokespecial 139	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   305: astore 5
    //   307: aconst_null
    //   308: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   311: aconst_null
    //   312: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   315: aload 9
    //   317: invokevirtual 145	java/net/Socket:close	()V
    //   320: aload 5
    //   322: areturn
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   328: aload 5
    //   330: areturn
    //   331: astore 5
    //   333: aconst_null
    //   334: astore 6
    //   336: aconst_null
    //   337: astore 5
    //   339: goto -152 -> 187
    //   342: astore 5
    //   344: aload 5
    //   346: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   349: goto -132 -> 217
    //   352: astore_1
    //   353: aload 5
    //   355: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   358: aload 6
    //   360: invokestatic 142	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   363: aload 9
    //   365: invokevirtual 145	java/net/Socket:close	()V
    //   368: aload_1
    //   369: athrow
    //   370: astore_3
    //   371: aload_3
    //   372: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   375: goto -7 -> 368
    //   378: new 12	com/tencent/qmsp/sdk/b/a$d
    //   381: dup
    //   382: aconst_null
    //   383: getstatic 44	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   386: invokevirtual 133	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   389: checkcast 56	java/lang/Integer
    //   392: invokevirtual 136	java/lang/Integer:intValue	()I
    //   395: invokespecial 139	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   398: areturn
    //   399: astore 6
    //   401: goto -122 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramInt1	int
    //   0	404	1	paramString	String
    //   0	404	2	paramInt2	int
    //   0	404	3	paramJSONObject	JSONObject
    //   33	189	4	i	int
    //   82	167	5	localObject1	Object
    //   269	1	5	localIOException1	IOException
    //   272	13	5	localObject2	Object
    //   289	1	5	localIOException2	IOException
    //   305	24	5	locald1	d
    //   331	1	5	localObject3	Object
    //   337	1	5	localObject4	Object
    //   342	12	5	localIOException3	IOException
    //   149	18	6	locald2	d
    //   177	1	6	localObject5	Object
    //   181	27	6	localObject6	Object
    //   226	1	6	localIOException4	IOException
    //   242	25	6	locald3	d
    //   277	1	6	localObject7	Object
    //   281	78	6	localObject8	Object
    //   399	1	6	localObject9	Object
    //   123	61	7	localDataInputStream	DataInputStream
    //   30	23	8	localInetSocketAddress	java.net.InetSocketAddress
    //   48	316	9	localSocket	java.net.Socket
    // Exception table:
    //   from	to	target	type
    //   161	166	169	java/io/IOException
    //   125	151	177	finally
    //   84	93	226	java/io/IOException
    //   253	258	261	java/io/IOException
    //   63	84	269	java/io/IOException
    //   84	93	277	finally
    //   93	125	277	finally
    //   50	63	289	java/io/IOException
    //   315	320	323	java/io/IOException
    //   50	63	331	finally
    //   63	84	331	finally
    //   291	307	331	finally
    //   212	217	342	java/io/IOException
    //   187	202	352	finally
    //   363	368	370	java/io/IOException
    //   228	244	399	finally
  }
  
  private static JSONObject a(b paramb, byte[] paramArrayOfByte)
  {
    int i = a.a.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return new JSONObject(new String(paramArrayOfByte, Charset.forName("UTF-8")));
    }
    paramb = new SecretKeySpec(e, k.a(b));
    Cipher localCipher = Cipher.getInstance(k.a(c));
    localCipher.init(2, paramb, new IvParameterSpec(e));
    return new JSONObject(new String(localCipher.doFinal(paramArrayOfByte), Charset.forName("UTF-8")));
  }
  
  private static JSONObject a(DataInputStream paramDataInputStream)
  {
    Object localObject1 = new byte[28];
    try
    {
      paramDataInputStream.readFully((byte[])localObject1);
      Object localObject2 = ByteBuffer.wrap((byte[])localObject1, 18, 10);
      int i = ((ByteBuffer)localObject2).getShort();
      g.set(Integer.valueOf(i));
      localObject1 = b.a(((ByteBuffer)localObject2).getShort());
      i = ((ByteBuffer)localObject2).getShort();
      int j = ((ByteBuffer)localObject2).getInt();
      paramDataInputStream.readFully(new byte[i]);
      localObject2 = new byte[j];
      paramDataInputStream.readFully((byte[])localObject2);
      if (j == 0) {
        return null;
      }
      try
      {
        paramDataInputStream = a((b)localObject1, (byte[])localObject2);
        return paramDataInputStream;
      }
      catch (Exception paramDataInputStream)
      {
        g.set(Integer.valueOf(c.m.a()));
        return null;
      }
      return null;
    }
    catch (IOException paramDataInputStream)
    {
      g.set(Integer.valueOf(c.j.a()));
    }
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject, DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.write(d);
    paramDataOutputStream.writeInt(paramInt1);
    paramDataOutputStream.writeInt(paramInt2);
    paramDataOutputStream.writeInt(0);
    paramDataOutputStream.writeShort(0);
    paramDataOutputStream.writeShort(0);
    b localb1 = f;
    try
    {
      byte[] arrayOfByte = a(localb1, paramJSONObject);
      paramJSONObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
        b localb2 = b.e;
      }
    }
    paramDataOutputStream.writeShort(localb1.a());
    paramString = paramString.getBytes("UTF-8");
    paramDataOutputStream.writeShort(paramString.length + 3);
    paramDataOutputStream.writeInt(paramJSONObject.length);
    paramDataOutputStream.write(1);
    paramDataOutputStream.writeShort(paramString.length);
    paramDataOutputStream.write(paramString);
    paramDataOutputStream.write(paramJSONObject);
    paramDataOutputStream.flush();
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static byte[] a(b paramb, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
    int i = a.a.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return paramJSONObject;
      }
      throw new IOException("unsupported");
    }
    paramb = new SecretKeySpec(e, k.a(b));
    Cipher localCipher = Cipher.getInstance(k.a(c));
    localCipher.init(1, paramb, new IvParameterSpec(e));
    return localCipher.doFinal(paramJSONObject);
  }
  
  public static enum b
  {
    private short a;
    private String b;
    
    private b(short paramShort, String paramString)
    {
      this.a = paramShort;
      this.b = paramString;
    }
    
    public static b a(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return c;
        }
        return e;
      }
      return d;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public String toString()
    {
      return this.b;
    }
  }
  
  static enum c
  {
    private int a;
    private String b;
    
    private c(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public String toString()
    {
      return this.b;
    }
  }
  
  public static class d
  {
    public JSONObject a;
    public int b;
    
    public d(JSONObject paramJSONObject, int paramInt)
    {
      this.a = paramJSONObject;
      this.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */