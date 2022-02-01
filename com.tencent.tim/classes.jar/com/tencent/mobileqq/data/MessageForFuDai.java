package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.c;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForFuDai
  extends ChatMessage
  implements CustomFrameAnimationDrawable.c
{
  private static final String TAG = "MessageForFuDai";
  public String aioTails = "";
  public int busiId;
  public int currentFrame;
  public int expireTime;
  public String fdId = "";
  public String fdTxt = "";
  private String highlightMsg = "";
  public String hostUin = "";
  public int shareType;
  private int state;
  public String targetId = "";
  public int themeId;
  public boolean useDefaultImag;
  
  protected void doParse()
  {
    a.a(this.msgData, this);
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getSummaryMsg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForFuDai", 2, "getSummaryMsg() called fdTxt=" + this.fdTxt);
    }
    return this.fdTxt;
  }
  
  public String highlightMsg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForFuDai", 2, "highlightMsg Txt=" + this.highlightMsg);
    }
    return this.highlightMsg;
  }
  
  public boolean isEmpty()
  {
    return this.state == 4;
  }
  
  public boolean isExpired()
  {
    return true;
  }
  
  public boolean isGrabByMe()
  {
    return (this.state == 3) || (this.state == 7);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void onUpdate(int paramInt)
  {
    this.currentFrame = paramInt;
  }
  
  public void prewrite()
  {
    this.msgData = b.a(this);
  }
  
  public String toString()
  {
    return "MessageForFuDai{hostUin='" + MsfSdkUtils.getShortUin(this.hostUin) + '\'' + ", fdId='" + this.fdId + '\'' + ", shareType=" + this.shareType + ", targetId='" + this.targetId + '\'' + ", fdTxt='" + this.fdTxt + '\'' + ", aioTails='" + this.aioTails + '\'' + ", state=" + this.state + ", busiId=" + this.busiId + ", highlightMsg='" + this.highlightMsg + '\'' + ", themeId=" + this.themeId + ", expireTime=" + this.expireTime + ", currentFrame=" + this.currentFrame + ", useDefaultImag=" + this.useDefaultImag + '}';
  }
  
  public static class a
  {
    /* Error */
    public static void a(byte[] paramArrayOfByte, MessageForFuDai paramMessageForFuDai)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: new 14	java/io/ByteArrayInputStream
      //   5: dup
      //   6: aload_0
      //   7: invokespecial 18	java/io/ByteArrayInputStream:<init>	([B)V
      //   10: astore_2
      //   11: new 20	java/io/ObjectInputStream
      //   14: dup
      //   15: aload_2
      //   16: invokespecial 23	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   19: astore_3
      //   20: aload_1
      //   21: aload_3
      //   22: invokevirtual 27	java/io/ObjectInputStream:readInt	()I
      //   25: invokestatic 31	com/tencent/mobileqq/data/MessageForFuDai:access$002	(Lcom/tencent/mobileqq/data/MessageForFuDai;I)I
      //   28: pop
      //   29: aload_1
      //   30: new 33	java/lang/StringBuilder
      //   33: dup
      //   34: invokespecial 36	java/lang/StringBuilder:<init>	()V
      //   37: aload_3
      //   38: invokevirtual 40	java/io/ObjectInputStream:readLong	()J
      //   41: invokevirtual 44	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   44: ldc 46
      //   46: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: putfield 57	com/tencent/mobileqq/data/MessageForFuDai:hostUin	Ljava/lang/String;
      //   55: aload_1
      //   56: aload_3
      //   57: invokevirtual 60	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
      //   60: putfield 63	com/tencent/mobileqq/data/MessageForFuDai:fdId	Ljava/lang/String;
      //   63: aload_1
      //   64: aload_3
      //   65: invokevirtual 27	java/io/ObjectInputStream:readInt	()I
      //   68: putfield 67	com/tencent/mobileqq/data/MessageForFuDai:shareType	I
      //   71: aload_1
      //   72: new 33	java/lang/StringBuilder
      //   75: dup
      //   76: invokespecial 36	java/lang/StringBuilder:<init>	()V
      //   79: aload_3
      //   80: invokevirtual 40	java/io/ObjectInputStream:readLong	()J
      //   83: invokevirtual 44	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   86: ldc 46
      //   88: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   91: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   94: putfield 70	com/tencent/mobileqq/data/MessageForFuDai:targetId	Ljava/lang/String;
      //   97: aload_1
      //   98: aload_3
      //   99: invokevirtual 60	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
      //   102: putfield 73	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
      //   105: aload_1
      //   106: aload_3
      //   107: invokevirtual 60	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
      //   110: putfield 76	com/tencent/mobileqq/data/MessageForFuDai:aioTails	Ljava/lang/String;
      //   113: aload_1
      //   114: aload_3
      //   115: invokevirtual 27	java/io/ObjectInputStream:readInt	()I
      //   118: putfield 79	com/tencent/mobileqq/data/MessageForFuDai:busiId	I
      //   121: aload_1
      //   122: aload_3
      //   123: invokevirtual 60	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
      //   126: invokestatic 83	com/tencent/mobileqq/data/MessageForFuDai:access$102	(Lcom/tencent/mobileqq/data/MessageForFuDai;Ljava/lang/String;)Ljava/lang/String;
      //   129: pop
      //   130: aload_1
      //   131: aload_3
      //   132: invokevirtual 27	java/io/ObjectInputStream:readInt	()I
      //   135: putfield 86	com/tencent/mobileqq/data/MessageForFuDai:expireTime	I
      //   138: aload_1
      //   139: aload_3
      //   140: invokevirtual 27	java/io/ObjectInputStream:readInt	()I
      //   143: putfield 89	com/tencent/mobileqq/data/MessageForFuDai:themeId	I
      //   146: aload_1
      //   147: aload_1
      //   148: getfield 73	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
      //   151: putfield 92	com/tencent/mobileqq/data/MessageForFuDai:msg	Ljava/lang/String;
      //   154: aload_3
      //   155: ifnull +7 -> 162
      //   158: aload_3
      //   159: invokevirtual 95	java/io/ObjectInputStream:close	()V
      //   162: aload_2
      //   163: ifnull +7 -> 170
      //   166: aload_2
      //   167: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
      //   170: return
      //   171: astore_0
      //   172: ldc 98
      //   174: iconst_1
      //   175: ldc 100
      //   177: aload_0
      //   178: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   181: goto -19 -> 162
      //   184: astore_0
      //   185: ldc 98
      //   187: iconst_1
      //   188: ldc 100
      //   190: aload_0
      //   191: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   194: return
      //   195: astore_2
      //   196: aconst_null
      //   197: astore_1
      //   198: aload_3
      //   199: astore_0
      //   200: ldc 98
      //   202: iconst_1
      //   203: ldc 100
      //   205: aload_2
      //   206: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   209: aload_1
      //   210: ifnull +7 -> 217
      //   213: aload_1
      //   214: invokevirtual 95	java/io/ObjectInputStream:close	()V
      //   217: aload_0
      //   218: ifnull -48 -> 170
      //   221: aload_0
      //   222: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
      //   225: return
      //   226: astore_0
      //   227: ldc 98
      //   229: iconst_1
      //   230: ldc 100
      //   232: aload_0
      //   233: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   236: return
      //   237: astore_1
      //   238: ldc 98
      //   240: iconst_1
      //   241: ldc 100
      //   243: aload_1
      //   244: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   247: goto -30 -> 217
      //   250: astore_0
      //   251: aconst_null
      //   252: astore_1
      //   253: aconst_null
      //   254: astore_2
      //   255: aload_1
      //   256: ifnull +7 -> 263
      //   259: aload_1
      //   260: invokevirtual 95	java/io/ObjectInputStream:close	()V
      //   263: aload_2
      //   264: ifnull +7 -> 271
      //   267: aload_2
      //   268: invokevirtual 96	java/io/ByteArrayInputStream:close	()V
      //   271: aload_0
      //   272: athrow
      //   273: astore_1
      //   274: ldc 98
      //   276: iconst_1
      //   277: ldc 100
      //   279: aload_1
      //   280: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   283: goto -20 -> 263
      //   286: astore_1
      //   287: ldc 98
      //   289: iconst_1
      //   290: ldc 100
      //   292: aload_1
      //   293: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   296: goto -25 -> 271
      //   299: astore_0
      //   300: aconst_null
      //   301: astore_1
      //   302: goto -47 -> 255
      //   305: astore_0
      //   306: aload_3
      //   307: astore_1
      //   308: goto -53 -> 255
      //   311: astore_3
      //   312: aload_0
      //   313: astore_2
      //   314: aload_3
      //   315: astore_0
      //   316: goto -61 -> 255
      //   319: astore_3
      //   320: aconst_null
      //   321: astore_1
      //   322: aload_2
      //   323: astore_0
      //   324: aload_3
      //   325: astore_2
      //   326: goto -126 -> 200
      //   329: astore_1
      //   330: aload_2
      //   331: astore_0
      //   332: aload_1
      //   333: astore_2
      //   334: aload_3
      //   335: astore_1
      //   336: goto -136 -> 200
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	339	0	paramArrayOfByte	byte[]
      //   0	339	1	paramMessageForFuDai	MessageForFuDai
      //   10	157	2	localByteArrayInputStream	java.io.ByteArrayInputStream
      //   195	11	2	localException1	java.lang.Exception
      //   254	80	2	localObject1	Object
      //   1	306	3	localObjectInputStream	java.io.ObjectInputStream
      //   311	4	3	localObject2	Object
      //   319	16	3	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   158	162	171	java/io/IOException
      //   166	170	184	java/io/IOException
      //   2	11	195	java/lang/Exception
      //   221	225	226	java/io/IOException
      //   213	217	237	java/io/IOException
      //   2	11	250	finally
      //   259	263	273	java/io/IOException
      //   267	271	286	java/io/IOException
      //   11	20	299	finally
      //   20	154	305	finally
      //   200	209	311	finally
      //   11	20	319	java/lang/Exception
      //   20	154	329	java/lang/Exception
    }
  }
  
  public static class b
  {
    /* Error */
    public static byte[] a(MessageForFuDai paramMessageForFuDai)
    {
      // Byte code:
      //   0: new 15	java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
      //   7: astore_3
      //   8: new 21	java/io/ObjectOutputStream
      //   11: dup
      //   12: aload_3
      //   13: invokespecial 24	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   16: astore_2
      //   17: aload_2
      //   18: astore 5
      //   20: aload_3
      //   21: astore 4
      //   23: aload_2
      //   24: aload_0
      //   25: invokestatic 28	com/tencent/mobileqq/data/MessageForFuDai:access$000	(Lcom/tencent/mobileqq/data/MessageForFuDai;)I
      //   28: invokevirtual 32	java/io/ObjectOutputStream:writeInt	(I)V
      //   31: aload_2
      //   32: astore 5
      //   34: aload_3
      //   35: astore 4
      //   37: aload_0
      //   38: getfield 36	com/tencent/mobileqq/data/MessageForFuDai:hostUin	Ljava/lang/String;
      //   41: invokestatic 42	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
      //   44: astore_1
      //   45: aload_2
      //   46: astore 5
      //   48: aload_3
      //   49: astore 4
      //   51: aload_2
      //   52: aload_1
      //   53: invokevirtual 46	java/lang/Long:longValue	()J
      //   56: invokevirtual 50	java/io/ObjectOutputStream:writeLong	(J)V
      //   59: aload_2
      //   60: astore 5
      //   62: aload_3
      //   63: astore 4
      //   65: aload_2
      //   66: aload_0
      //   67: getfield 53	com/tencent/mobileqq/data/MessageForFuDai:fdId	Ljava/lang/String;
      //   70: invokevirtual 57	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
      //   73: aload_2
      //   74: astore 5
      //   76: aload_3
      //   77: astore 4
      //   79: aload_2
      //   80: aload_0
      //   81: getfield 61	com/tencent/mobileqq/data/MessageForFuDai:shareType	I
      //   84: invokevirtual 32	java/io/ObjectOutputStream:writeInt	(I)V
      //   87: aload_2
      //   88: astore 5
      //   90: aload_3
      //   91: astore 4
      //   93: aload_0
      //   94: getfield 64	com/tencent/mobileqq/data/MessageForFuDai:targetId	Ljava/lang/String;
      //   97: invokestatic 42	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
      //   100: astore_1
      //   101: aload_2
      //   102: astore 5
      //   104: aload_3
      //   105: astore 4
      //   107: aload_2
      //   108: aload_1
      //   109: invokevirtual 46	java/lang/Long:longValue	()J
      //   112: invokevirtual 50	java/io/ObjectOutputStream:writeLong	(J)V
      //   115: aload_2
      //   116: astore 5
      //   118: aload_3
      //   119: astore 4
      //   121: aload_2
      //   122: aload_0
      //   123: getfield 67	com/tencent/mobileqq/data/MessageForFuDai:fdTxt	Ljava/lang/String;
      //   126: invokevirtual 57	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
      //   129: aload_2
      //   130: astore 5
      //   132: aload_3
      //   133: astore 4
      //   135: aload_2
      //   136: aload_0
      //   137: getfield 70	com/tencent/mobileqq/data/MessageForFuDai:aioTails	Ljava/lang/String;
      //   140: invokevirtual 57	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
      //   143: aload_2
      //   144: astore 5
      //   146: aload_3
      //   147: astore 4
      //   149: aload_2
      //   150: aload_0
      //   151: getfield 73	com/tencent/mobileqq/data/MessageForFuDai:busiId	I
      //   154: invokevirtual 32	java/io/ObjectOutputStream:writeInt	(I)V
      //   157: aload_2
      //   158: astore 5
      //   160: aload_3
      //   161: astore 4
      //   163: aload_2
      //   164: aload_0
      //   165: invokestatic 77	com/tencent/mobileqq/data/MessageForFuDai:access$100	(Lcom/tencent/mobileqq/data/MessageForFuDai;)Ljava/lang/String;
      //   168: invokevirtual 57	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
      //   171: aload_2
      //   172: astore 5
      //   174: aload_3
      //   175: astore 4
      //   177: aload_2
      //   178: aload_0
      //   179: getfield 80	com/tencent/mobileqq/data/MessageForFuDai:expireTime	I
      //   182: invokevirtual 32	java/io/ObjectOutputStream:writeInt	(I)V
      //   185: aload_2
      //   186: astore 5
      //   188: aload_3
      //   189: astore 4
      //   191: aload_2
      //   192: aload_0
      //   193: getfield 83	com/tencent/mobileqq/data/MessageForFuDai:themeId	I
      //   196: invokevirtual 32	java/io/ObjectOutputStream:writeInt	(I)V
      //   199: aload_2
      //   200: astore 5
      //   202: aload_3
      //   203: astore 4
      //   205: aload_2
      //   206: invokevirtual 86	java/io/ObjectOutputStream:flush	()V
      //   209: aload_2
      //   210: astore 5
      //   212: aload_3
      //   213: astore 4
      //   215: aload_3
      //   216: invokevirtual 90	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   219: astore_0
      //   220: aload_2
      //   221: astore 5
      //   223: aload_3
      //   224: astore 4
      //   226: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   229: ifeq +40 -> 269
      //   232: aload_2
      //   233: astore 5
      //   235: aload_3
      //   236: astore 4
      //   238: ldc 98
      //   240: iconst_2
      //   241: new 100	java/lang/StringBuilder
      //   244: dup
      //   245: invokespecial 101	java/lang/StringBuilder:<init>	()V
      //   248: ldc 103
      //   250: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: aload_0
      //   254: arraylength
      //   255: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   258: ldc 112
      //   260: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   266: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   269: aload_2
      //   270: ifnull +7 -> 277
      //   273: aload_2
      //   274: invokevirtual 123	java/io/ObjectOutputStream:close	()V
      //   277: aload_0
      //   278: astore_1
      //   279: aload_3
      //   280: ifnull +9 -> 289
      //   283: aload_3
      //   284: invokevirtual 124	java/io/ByteArrayOutputStream:close	()V
      //   287: aload_0
      //   288: astore_1
      //   289: aload_1
      //   290: areturn
      //   291: astore_1
      //   292: aload_2
      //   293: astore 5
      //   295: aload_3
      //   296: astore 4
      //   298: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   301: ifeq +233 -> 534
      //   304: aload_2
      //   305: astore 5
      //   307: aload_3
      //   308: astore 4
      //   310: ldc 98
      //   312: iconst_2
      //   313: ldc 126
      //   315: aload_1
      //   316: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   319: goto +215 -> 534
      //   322: astore_1
      //   323: aload_2
      //   324: astore 5
      //   326: aload_3
      //   327: astore 4
      //   329: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   332: ifeq +18 -> 350
      //   335: aload_2
      //   336: astore 5
      //   338: aload_3
      //   339: astore 4
      //   341: ldc 98
      //   343: iconst_2
      //   344: ldc 132
      //   346: aload_1
      //   347: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   350: lconst_0
      //   351: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   354: astore_1
      //   355: goto -254 -> 101
      //   358: astore_1
      //   359: ldc 98
      //   361: iconst_1
      //   362: ldc 137
      //   364: aload_1
      //   365: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   368: goto -91 -> 277
      //   371: astore_1
      //   372: ldc 98
      //   374: iconst_1
      //   375: ldc 137
      //   377: aload_1
      //   378: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   381: aload_0
      //   382: areturn
      //   383: astore_1
      //   384: aconst_null
      //   385: astore_2
      //   386: aconst_null
      //   387: astore_3
      //   388: aconst_null
      //   389: astore_0
      //   390: aload_2
      //   391: astore 5
      //   393: aload_3
      //   394: astore 4
      //   396: ldc 98
      //   398: iconst_1
      //   399: ldc 137
      //   401: aload_1
      //   402: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   405: aload_2
      //   406: ifnull +7 -> 413
      //   409: aload_2
      //   410: invokevirtual 123	java/io/ObjectOutputStream:close	()V
      //   413: aload_0
      //   414: astore_1
      //   415: aload_3
      //   416: ifnull -127 -> 289
      //   419: aload_3
      //   420: invokevirtual 124	java/io/ByteArrayOutputStream:close	()V
      //   423: aload_0
      //   424: areturn
      //   425: astore_1
      //   426: ldc 98
      //   428: iconst_1
      //   429: ldc 137
      //   431: aload_1
      //   432: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   435: aload_0
      //   436: areturn
      //   437: astore_1
      //   438: ldc 98
      //   440: iconst_1
      //   441: ldc 137
      //   443: aload_1
      //   444: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   447: goto -34 -> 413
      //   450: astore_0
      //   451: aconst_null
      //   452: astore 5
      //   454: aconst_null
      //   455: astore_3
      //   456: aload 5
      //   458: ifnull +8 -> 466
      //   461: aload 5
      //   463: invokevirtual 123	java/io/ObjectOutputStream:close	()V
      //   466: aload_3
      //   467: ifnull +7 -> 474
      //   470: aload_3
      //   471: invokevirtual 124	java/io/ByteArrayOutputStream:close	()V
      //   474: aload_0
      //   475: athrow
      //   476: astore_1
      //   477: ldc 98
      //   479: iconst_1
      //   480: ldc 137
      //   482: aload_1
      //   483: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   486: goto -20 -> 466
      //   489: astore_1
      //   490: ldc 98
      //   492: iconst_1
      //   493: ldc 137
      //   495: aload_1
      //   496: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   499: goto -25 -> 474
      //   502: astore_0
      //   503: aconst_null
      //   504: astore 5
      //   506: goto -50 -> 456
      //   509: astore_0
      //   510: aload 4
      //   512: astore_3
      //   513: goto -57 -> 456
      //   516: astore_1
      //   517: aconst_null
      //   518: astore_2
      //   519: aconst_null
      //   520: astore_0
      //   521: goto -131 -> 390
      //   524: astore_1
      //   525: aconst_null
      //   526: astore_0
      //   527: goto -137 -> 390
      //   530: astore_1
      //   531: goto -141 -> 390
      //   534: lconst_0
      //   535: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   538: astore_1
      //   539: goto -494 -> 45
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	542	0	paramMessageForFuDai	MessageForFuDai
      //   44	246	1	localObject1	Object
      //   291	25	1	localException1	java.lang.Exception
      //   322	25	1	localException2	java.lang.Exception
      //   354	1	1	localLong1	java.lang.Long
      //   358	7	1	localIOException1	java.io.IOException
      //   371	7	1	localIOException2	java.io.IOException
      //   383	19	1	localException3	java.lang.Exception
      //   414	1	1	localMessageForFuDai	MessageForFuDai
      //   425	7	1	localIOException3	java.io.IOException
      //   437	7	1	localIOException4	java.io.IOException
      //   476	7	1	localIOException5	java.io.IOException
      //   489	7	1	localIOException6	java.io.IOException
      //   516	1	1	localException4	java.lang.Exception
      //   524	1	1	localException5	java.lang.Exception
      //   530	1	1	localException6	java.lang.Exception
      //   538	1	1	localLong2	java.lang.Long
      //   16	503	2	localObjectOutputStream1	java.io.ObjectOutputStream
      //   7	506	3	localObject2	Object
      //   21	490	4	localObject3	Object
      //   18	487	5	localObjectOutputStream2	java.io.ObjectOutputStream
      // Exception table:
      //   from	to	target	type
      //   37	45	291	java/lang/Exception
      //   93	101	322	java/lang/Exception
      //   273	277	358	java/io/IOException
      //   283	287	371	java/io/IOException
      //   0	8	383	java/lang/Exception
      //   419	423	425	java/io/IOException
      //   409	413	437	java/io/IOException
      //   0	8	450	finally
      //   461	466	476	java/io/IOException
      //   470	474	489	java/io/IOException
      //   8	17	502	finally
      //   23	31	509	finally
      //   37	45	509	finally
      //   51	59	509	finally
      //   65	73	509	finally
      //   79	87	509	finally
      //   93	101	509	finally
      //   107	115	509	finally
      //   121	129	509	finally
      //   135	143	509	finally
      //   149	157	509	finally
      //   163	171	509	finally
      //   177	185	509	finally
      //   191	199	509	finally
      //   205	209	509	finally
      //   215	220	509	finally
      //   226	232	509	finally
      //   238	269	509	finally
      //   298	304	509	finally
      //   310	319	509	finally
      //   329	335	509	finally
      //   341	350	509	finally
      //   396	405	509	finally
      //   8	17	516	java/lang/Exception
      //   23	31	524	java/lang/Exception
      //   51	59	524	java/lang/Exception
      //   65	73	524	java/lang/Exception
      //   79	87	524	java/lang/Exception
      //   107	115	524	java/lang/Exception
      //   121	129	524	java/lang/Exception
      //   135	143	524	java/lang/Exception
      //   149	157	524	java/lang/Exception
      //   163	171	524	java/lang/Exception
      //   177	185	524	java/lang/Exception
      //   191	199	524	java/lang/Exception
      //   205	209	524	java/lang/Exception
      //   215	220	524	java/lang/Exception
      //   298	304	524	java/lang/Exception
      //   310	319	524	java/lang/Exception
      //   329	335	524	java/lang/Exception
      //   341	350	524	java/lang/Exception
      //   226	232	530	java/lang/Exception
      //   238	269	530	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFuDai
 * JD-Core Version:    0.7.0.1
 */