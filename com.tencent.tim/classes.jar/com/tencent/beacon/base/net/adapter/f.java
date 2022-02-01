package com.tencent.beacon.base.net.adapter;

import android.text.TextUtils;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.pack.SocketRequestPackage;
import com.tencent.beacon.pack.SocketResponsePackage;
import com.tencent.beacon.pack.b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class f
  extends AbstractNetAdapter
{
  private com.tencent.beacon.base.net.a.c<byte[], SocketResponsePackage> a = new com.tencent.beacon.base.net.a.e();
  private com.tencent.beacon.base.net.a.c<JceRequestEntity, SocketRequestPackage> b = new com.tencent.beacon.base.net.a.d();
  
  public static AbstractNetAdapter a()
  {
    return new f();
  }
  
  private Socket a(String paramString, int paramInt)
    throws IOException
  {
    com.tencent.beacon.base.util.c.a("SocketAdapter", "create socket domain: %s, port: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new Socket(InetAddress.getByName(paramString).getHostAddress(), paramInt);
    paramString.setSoTimeout(30000);
    return paramString;
  }
  
  private void a(Callback<byte[]> paramCallback, String paramString, SocketResponsePackage paramSocketResponsePackage)
    throws NetException
  {
    String str = paramSocketResponsePackage.msg;
    if ((str != null) && (str.equals("decrypt Data fail!")))
    {
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(paramString, "405", paramSocketResponsePackage.statusCode, "server encrypt-status error!"));
      return;
    }
    paramCallback.onResponse(paramSocketResponsePackage.body);
  }
  
  private void a(Socket paramSocket, SocketRequestPackage paramSocketRequestPackage)
    throws IOException
  {
    b localb = new b();
    paramSocketRequestPackage.writeTo(localb);
    paramSocket = paramSocket.getOutputStream();
    paramSocketRequestPackage = localb.b();
    paramSocket.write(a(paramSocketRequestPackage, paramSocketRequestPackage.length));
    paramSocket.flush();
  }
  
  /* Error */
  private byte[] a(Socket paramSocket, boolean paramBoolean)
    throws Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: invokevirtual 148	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   10: astore 4
    //   12: new 150	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 151	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_1
    //   20: sipush 2048
    //   23: newarray byte
    //   25: astore 5
    //   27: aload 4
    //   29: aload 5
    //   31: invokevirtual 157	java/io/InputStream:read	([B)I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_m1
    //   37: if_icmpeq +45 -> 82
    //   40: aload_1
    //   41: aload 5
    //   43: iconst_0
    //   44: iload_3
    //   45: invokevirtual 160	java/io/ByteArrayOutputStream:write	([BII)V
    //   48: goto -21 -> 27
    //   51: astore 6
    //   53: aload_1
    //   54: astore 5
    //   56: aload 6
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 163	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   63: iconst_2
    //   64: anewarray 165	java/io/Closeable
    //   67: dup
    //   68: iconst_0
    //   69: aload 4
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload 5
    //   76: aastore
    //   77: invokestatic 170	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   80: aload_1
    //   81: athrow
    //   82: aload_1
    //   83: invokevirtual 171	java/io/ByteArrayOutputStream:flush	()V
    //   86: aload_1
    //   87: invokevirtual 174	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: astore 6
    //   92: aload 6
    //   94: astore 5
    //   96: iload_2
    //   97: ifne +34 -> 131
    //   100: aload 6
    //   102: arraylength
    //   103: iconst_4
    //   104: isub
    //   105: invokestatic 180	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   108: astore 5
    //   110: aload 5
    //   112: aload 6
    //   114: iconst_2
    //   115: aload 6
    //   117: arraylength
    //   118: iconst_4
    //   119: isub
    //   120: invokevirtual 184	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   123: pop
    //   124: aload 5
    //   126: invokevirtual 187	java/nio/ByteBuffer:array	()[B
    //   129: astore 5
    //   131: aload_1
    //   132: invokevirtual 190	java/io/ByteArrayOutputStream:close	()V
    //   135: aload 4
    //   137: invokevirtual 191	java/io/InputStream:close	()V
    //   140: iconst_2
    //   141: anewarray 165	java/io/Closeable
    //   144: dup
    //   145: iconst_0
    //   146: aload 4
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_1
    //   152: aastore
    //   153: invokestatic 170	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   156: aload 5
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore 4
    //   163: aload 6
    //   165: astore 5
    //   167: iconst_2
    //   168: anewarray 165	java/io/Closeable
    //   171: dup
    //   172: iconst_0
    //   173: aload 4
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload 5
    //   180: aastore
    //   181: invokestatic 170	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: aconst_null
    //   188: astore 4
    //   190: goto -131 -> 59
    //   193: astore 6
    //   195: aload_1
    //   196: astore 5
    //   198: aload 6
    //   200: astore_1
    //   201: goto -34 -> 167
    //   204: astore_1
    //   205: goto -38 -> 167
    //   208: astore_1
    //   209: goto -150 -> 59
    //   212: astore_1
    //   213: aload 6
    //   215: astore 5
    //   217: goto -50 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	f
    //   0	220	1	paramSocket	Socket
    //   0	220	2	paramBoolean	boolean
    //   34	11	3	i	int
    //   10	179	4	localInputStream	java.io.InputStream
    //   4	212	5	localObject1	Object
    //   1	1	6	localObject2	Object
    //   51	6	6	localThrowable	Throwable
    //   90	74	6	arrayOfByte	byte[]
    //   193	21	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	51	java/lang/Throwable
    //   27	35	51	java/lang/Throwable
    //   40	48	51	java/lang/Throwable
    //   82	92	51	java/lang/Throwable
    //   100	131	51	java/lang/Throwable
    //   131	140	51	java/lang/Throwable
    //   6	12	159	finally
    //   6	12	186	java/lang/Throwable
    //   20	27	193	finally
    //   27	35	193	finally
    //   40	48	193	finally
    //   82	92	193	finally
    //   100	131	193	finally
    //   131	140	193	finally
    //   59	63	204	finally
    //   12	20	208	java/lang/Throwable
    //   12	20	212	finally
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putShort((short)(i & 0xFFFF));
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.put((byte)13);
    localByteBuffer.put((byte)10);
    if (paramInt >= 65532) {
      com.tencent.beacon.base.util.c.b("[Error] send bytes exceed 64kB will failure!", new Object[0]);
    }
    return localByteBuffer.array();
  }
  
  public void request(JceRequestEntity paramJceRequestEntity, Callback<byte[]> paramCallback)
  {
    Object localObject = paramJceRequestEntity.getDomain();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    String str = paramJceRequestEntity.getType().name();
    try
    {
      localObject = a((String)localObject, paramJceRequestEntity.getPort());
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.beacon.base.util.c.a("SocketAdapter", 0, "send data size: " + paramJceRequestEntity.getContent().length, new Object[0]);
      a((Socket)localObject, (SocketRequestPackage)this.b.a(paramJceRequestEntity));
      if (paramJceRequestEntity.getType() != RequestType.EVENT) {
        break label171;
      }
      bool = true;
    }
    catch (ConnectException paramJceRequestEntity)
    {
      for (;;)
      {
        paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "401", -1, " connect time more than 30s", paramJceRequestEntity));
        return;
        boolean bool = false;
      }
      localObject = new StringBuilder();
      com.tencent.beacon.base.util.c.a("SocketAdapter", 1, "receivedData: " + paramJceRequestEntity.length, new Object[0]);
      paramJceRequestEntity = (SocketResponsePackage)this.a.a(paramJceRequestEntity);
      if (paramJceRequestEntity != null) {
        break label278;
      }
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "402", -1, "responsePackage == null"));
      return;
    }
    catch (SocketTimeoutException paramJceRequestEntity)
    {
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "401", -1, " request time more than 30s", paramJceRequestEntity));
      return;
      com.tencent.beacon.base.util.c.a("SocketAdapter", 2, "socket response code: %s, header: %s, msg: %s", new Object[] { Integer.valueOf(paramJceRequestEntity.statusCode), paramJceRequestEntity.header, paramJceRequestEntity.msg });
      if (paramJceRequestEntity.statusCode != 200) {
        break label380;
      }
      a(paramCallback, str, paramJceRequestEntity);
      return;
    }
    catch (Throwable paramJceRequestEntity)
    {
      com.tencent.beacon.base.util.c.b("SocketAdapter socket request error: %s", new Object[] { paramJceRequestEntity.getMessage() });
      com.tencent.beacon.base.util.c.a(paramJceRequestEntity);
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "449", -1, " unknown request error!", paramJceRequestEntity));
      return;
    }
    paramJceRequestEntity = a((Socket)localObject, bool);
    if ((paramJceRequestEntity == null) || (paramJceRequestEntity.length <= 0))
    {
      paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "402", -1, "receiveData == null"));
      return;
    }
    label171:
    label380:
    int i = paramJceRequestEntity.statusCode;
    label278:
    localObject = new StringBuilder();
    paramCallback.onFailure(new com.tencent.beacon.base.net.d(str, "402", i, "responsePackage msg: " + paramJceRequestEntity.msg));
  }
  
  public void request(com.tencent.beacon.base.net.call.e parame, Callback<BResponse> paramCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.f
 * JD-Core Version:    0.7.0.1
 */