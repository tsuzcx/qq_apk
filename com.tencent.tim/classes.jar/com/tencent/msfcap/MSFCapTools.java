package com.tencent.msfcap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MSFCapTools
{
  public static final String a = "MSFCapTools";
  public static final int b = 18989;
  public static final int c = 50;
  private static final int d = 2048;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 2 + paramInt3 + paramInt2;
  }
  
  public static Object a(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    paramCreator = paramCreator.createFromParcel(paramArrayOfByte);
    paramArrayOfByte.recycle();
    return paramCreator;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("md5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = new BigInteger(1, localMessageDigest.digest()).toString(16);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static void a(com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   8: lstore_2
    //   9: new 80	java/net/Socket
    //   12: dup
    //   13: invokespecial 81	java/net/Socket:<init>	()V
    //   16: astore 4
    //   18: aload_0
    //   19: invokestatic 84	com/tencent/msfcap/MSFCapTools:a	(Landroid/os/Parcelable;)[B
    //   22: astore 5
    //   24: aload 4
    //   26: new 86	java/net/InetSocketAddress
    //   29: dup
    //   30: ldc 88
    //   32: sipush 18989
    //   35: invokespecial 91	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   38: bipush 50
    //   40: invokevirtual 95	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   43: aload 4
    //   45: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   48: ifeq +151 -> 199
    //   51: new 101	java/io/DataOutputStream
    //   54: dup
    //   55: aload 4
    //   57: invokevirtual 105	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   60: invokespecial 108	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: iload_1
    //   64: aload 5
    //   66: invokestatic 111	com/tencent/msfcap/MSFCapTools:a	(Ljava/io/DataOutputStream;I[B)V
    //   69: aload 5
    //   71: arraylength
    //   72: sipush 2048
    //   75: if_icmple +39 -> 114
    //   78: aload_0
    //   79: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   82: ifnull +32 -> 114
    //   85: ldc 8
    //   87: ldc 118
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_0
    //   100: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   103: invokestatic 120	com/tencent/msfcap/MSFCapTools:a	([B)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: new 133	java/io/DataInputStream
    //   117: dup
    //   118: aload 4
    //   120: invokevirtual 137	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   123: invokespecial 140	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: invokestatic 143	com/tencent/msfcap/MSFCapTools:a	(Ljava/io/DataInputStream;)[B
    //   129: astore 5
    //   131: aload 5
    //   133: getstatic 147	com/tencent/qphone/base/remote/FromServiceMsg:CREATOR	Landroid/os/Parcelable$Creator;
    //   136: invokestatic 149	com/tencent/msfcap/MSFCapTools:a	([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;
    //   139: checkcast 113	com/tencent/qphone/base/remote/FromServiceMsg
    //   142: astore 6
    //   144: aload 5
    //   146: arraylength
    //   147: sipush 2048
    //   150: if_icmple +40 -> 190
    //   153: aload_0
    //   154: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   157: ifnull +33 -> 190
    //   160: ldc 8
    //   162: ldc 151
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload 6
    //   176: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   179: invokestatic 120	com/tencent/msfcap/MSFCapTools:a	([B)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: aload_0
    //   191: aload 6
    //   193: invokevirtual 116	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   196: invokevirtual 154	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   199: aload 4
    //   201: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   204: ifeq +8 -> 212
    //   207: aload 4
    //   209: invokevirtual 157	java/net/Socket:close	()V
    //   212: ldc 159
    //   214: iconst_2
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload_0
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   227: lload_2
    //   228: lsub
    //   229: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   232: aastore
    //   233: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   236: astore_0
    //   237: ldc 8
    //   239: aload_0
    //   240: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   243: pop
    //   244: return
    //   245: astore 5
    //   247: aload 4
    //   249: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   252: ifeq +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 157	java/net/Socket:close	()V
    //   260: ldc 8
    //   262: ldc 159
    //   264: iconst_2
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload_0
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   277: lload_2
    //   278: lsub
    //   279: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   282: aastore
    //   283: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   289: pop
    //   290: aload 5
    //   292: athrow
    //   293: astore 5
    //   295: aload 4
    //   297: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   300: ifeq +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 157	java/net/Socket:close	()V
    //   308: ldc 159
    //   310: iconst_2
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_0
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   323: lload_2
    //   324: lsub
    //   325: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   328: aastore
    //   329: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   332: astore_0
    //   333: goto -96 -> 237
    //   336: astore 4
    //   338: goto -126 -> 212
    //   341: astore 4
    //   343: goto -83 -> 260
    //   346: astore 4
    //   348: goto -40 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	351	1	paramInt	int
    //   8	316	2	l	long
    //   16	288	4	localSocket	java.net.Socket
    //   336	1	4	localIOException1	IOException
    //   341	1	4	localIOException2	IOException
    //   346	1	4	localIOException3	IOException
    //   22	123	5	arrayOfByte	byte[]
    //   245	46	5	localObject	Object
    //   293	1	5	localException	java.lang.Exception
    //   142	50	6	localFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    // Exception table:
    //   from	to	target	type
    //   18	114	245	finally
    //   114	190	245	finally
    //   190	199	245	finally
    //   18	114	293	java/lang/Exception
    //   114	190	293	java/lang/Exception
    //   190	199	293	java/lang/Exception
    //   199	212	336	java/io/IOException
    //   247	260	341	java/io/IOException
    //   295	308	346	java/io/IOException
  }
  
  /* Error */
  public static void a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   8: lstore_2
    //   9: new 80	java/net/Socket
    //   12: dup
    //   13: invokespecial 81	java/net/Socket:<init>	()V
    //   16: astore 4
    //   18: aload_0
    //   19: invokestatic 84	com/tencent/msfcap/MSFCapTools:a	(Landroid/os/Parcelable;)[B
    //   22: astore 5
    //   24: aload 4
    //   26: new 86	java/net/InetSocketAddress
    //   29: dup
    //   30: ldc 88
    //   32: sipush 18989
    //   35: invokespecial 91	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   38: bipush 50
    //   40: invokevirtual 95	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   43: aload 4
    //   45: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   48: ifeq +52 -> 100
    //   51: new 101	java/io/DataOutputStream
    //   54: dup
    //   55: aload 4
    //   57: invokevirtual 105	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   60: invokespecial 108	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: iload_1
    //   64: aload 5
    //   66: invokestatic 111	com/tencent/msfcap/MSFCapTools:a	(Ljava/io/DataOutputStream;I[B)V
    //   69: aload_0
    //   70: new 133	java/io/DataInputStream
    //   73: dup
    //   74: aload 4
    //   76: invokevirtual 137	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   79: invokespecial 140	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: invokestatic 143	com/tencent/msfcap/MSFCapTools:a	(Ljava/io/DataInputStream;)[B
    //   85: getstatic 169	com/tencent/qphone/base/remote/ToServiceMsg:CREATOR	Landroid/os/Parcelable$Creator;
    //   88: invokestatic 149	com/tencent/msfcap/MSFCapTools:a	([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;
    //   91: checkcast 168	com/tencent/qphone/base/remote/ToServiceMsg
    //   94: invokevirtual 170	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   97: invokevirtual 171	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   100: aload 4
    //   102: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   105: ifeq +8 -> 113
    //   108: aload 4
    //   110: invokevirtual 157	java/net/Socket:close	()V
    //   113: ldc 173
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   128: lload_2
    //   129: lsub
    //   130: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: aastore
    //   134: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   137: astore_0
    //   138: ldc 8
    //   140: aload_0
    //   141: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   144: pop
    //   145: return
    //   146: astore 5
    //   148: aload 4
    //   150: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   153: ifeq +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 157	java/net/Socket:close	()V
    //   161: ldc 8
    //   163: ldc 173
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_0
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   178: lload_2
    //   179: lsub
    //   180: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: aastore
    //   184: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   187: invokestatic 131	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: aload 5
    //   193: athrow
    //   194: astore 5
    //   196: aload 4
    //   198: invokevirtual 99	java/net/Socket:isConnected	()Z
    //   201: ifeq +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 157	java/net/Socket:close	()V
    //   209: ldc 173
    //   211: iconst_2
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   224: lload_2
    //   225: lsub
    //   226: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   229: aastore
    //   230: invokestatic 126	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: astore_0
    //   234: goto -96 -> 138
    //   237: astore 4
    //   239: goto -126 -> 113
    //   242: astore 4
    //   244: goto -83 -> 161
    //   247: astore 4
    //   249: goto -40 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	252	1	paramInt	int
    //   8	217	2	l	long
    //   16	189	4	localSocket	java.net.Socket
    //   237	1	4	localIOException1	IOException
    //   242	1	4	localIOException2	IOException
    //   247	1	4	localIOException3	IOException
    //   22	43	5	arrayOfByte	byte[]
    //   146	46	5	localObject	Object
    //   194	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	100	146	finally
    //   18	100	194	java/lang/Exception
    //   100	113	237	java/io/IOException
    //   148	161	242	java/io/IOException
    //   196	209	247	java/io/IOException
  }
  
  public static void a(DataOutputStream paramDataOutputStream, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    paramDataOutputStream.writeInt(paramInt);
    paramDataOutputStream.flush();
    paramDataOutputStream.writeInt(paramArrayOfByte.length);
    paramDataOutputStream.flush();
    paramDataOutputStream.write(paramArrayOfByte);
    paramDataOutputStream.flush();
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
  
  public static byte[] a(DataInputStream paramDataInputStream)
    throws IOException
  {
    paramDataInputStream.readInt();
    byte[] arrayOfByte = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  /* Error */
  public static byte[] a(java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 207	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 208	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 6
    //   15: new 210	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 6
    //   21: invokespecial 211	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 215	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokevirtual 216	java/io/ObjectOutputStream:flush	()V
    //   38: aload_2
    //   39: astore_1
    //   40: aload 6
    //   42: invokevirtual 219	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_0
    //   46: aload_2
    //   47: ifnull +7 -> 54
    //   50: aload_2
    //   51: invokevirtual 220	java/io/ObjectOutputStream:close	()V
    //   54: aload_0
    //   55: astore_1
    //   56: aload 6
    //   58: ifnull +12 -> 70
    //   61: aload_0
    //   62: astore_1
    //   63: aload 6
    //   65: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   68: aload_0
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 222	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 220	java/io/ObjectOutputStream:close	()V
    //   89: aload 5
    //   91: astore_1
    //   92: aload 6
    //   94: ifnull -24 -> 70
    //   97: aload 4
    //   99: astore_1
    //   100: aload 6
    //   102: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 220	java/io/ObjectOutputStream:close	()V
    //   121: aload 6
    //   123: ifnull +8 -> 131
    //   126: aload 6
    //   128: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_1
    //   134: goto -13 -> 121
    //   137: astore_1
    //   138: goto -7 -> 131
    //   141: astore_0
    //   142: goto -53 -> 89
    //   145: astore_1
    //   146: goto -92 -> 54
    //   149: astore_0
    //   150: goto -37 -> 113
    //   153: astore_3
    //   154: aload_2
    //   155: astore_0
    //   156: goto -81 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramSerializable	java.io.Serializable
    //   26	92	1	localObject1	Object
    //   133	1	1	localIOException1	IOException
    //   137	1	1	localIOException2	IOException
    //   145	1	1	localIOException3	IOException
    //   24	131	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   72	6	3	localIOException4	IOException
    //   153	1	3	localIOException5	IOException
    //   1	97	4	localObject2	Object
    //   4	86	5	localObject3	Object
    //   13	114	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	25	72	java/io/IOException
    //   63	68	107	java/io/IOException
    //   100	105	107	java/io/IOException
    //   15	25	110	finally
    //   117	121	133	java/io/IOException
    //   126	131	137	java/io/IOException
    //   85	89	141	java/io/IOException
    //   50	54	145	java/io/IOException
    //   27	32	149	finally
    //   34	38	149	finally
    //   40	46	149	finally
    //   77	81	149	finally
    //   27	32	153	java/io/IOException
    //   34	38	153	java/io/IOException
    //   40	46	153	java/io/IOException
  }
  
  public static Parcel b(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msfcap.MSFCapTools
 * JD-Core Version:    0.7.0.1
 */