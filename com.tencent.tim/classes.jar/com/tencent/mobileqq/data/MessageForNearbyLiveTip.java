package com.tencent.mobileqq.data;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForNearbyLiveTip
  extends ChatMessage
{
  public String c2cMsgWording;
  public int endLiveWordingType;
  public String headUrl;
  public boolean isLiving;
  public String jumpingUrl;
  public String liveEndWording;
  public String nickName;
  public int startLiveWordingType;
  
  public static boolean isGroupVideoTip(String paramString)
  {
    return (paramString != null) && (paramString.contains("identifier_for_huayang=tips_for_qq_huayang")) && (paramString.contains("buz_type=videohub"));
  }
  
  public static boolean isHuayangTip(String paramString)
  {
    return (paramString != null) && (paramString.contains("identifier_for_huayang=tips_for_qq_huayang"));
  }
  
  public static boolean isSupportHuayangBusinessType(String paramString)
  {
    return (paramString != null) && ((paramString.contains("buz_type=huayang")) || (paramString.contains("buz_type=videohub")));
  }
  
  private void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.isLiving = paramObjectInput.readBoolean();
    this.jumpingUrl = paramObjectInput.readUTF();
    this.nickName = paramObjectInput.readUTF();
    this.headUrl = paramObjectInput.readUTF();
    this.msg = paramObjectInput.readUTF();
    this.liveEndWording = paramObjectInput.readUTF();
    this.c2cMsgWording = paramObjectInput.readUTF();
    this.startLiveWordingType = paramObjectInput.readInt();
    this.endLiveWordingType = paramObjectInput.readInt();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeBoolean(this.isLiving);
    paramObjectOutput.writeUTF(this.jumpingUrl);
    paramObjectOutput.writeUTF(this.nickName);
    paramObjectOutput.writeUTF(this.headUrl);
    paramObjectOutput.writeUTF(this.msg);
    paramObjectOutput.writeUTF(this.liveEndWording);
    paramObjectOutput.writeUTF(this.c2cMsgWording);
    paramObjectOutput.writeInt(this.startLiveWordingType);
    paramObjectOutput.writeInt(this.endLiveWordingType);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 97	java/io/ObjectInputStream
    //   3: dup
    //   4: new 99	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 103	com/tencent/mobileqq/data/MessageForNearbyLiveTip:msgData	[B
    //   12: invokespecial 106	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 109	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 111	com/tencent/mobileqq/data/MessageForNearbyLiveTip:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 114	java/io/ObjectInputStream:close	()V
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   40: return
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_2
    //   53: astore_1
    //   54: ldc 124
    //   56: iconst_2
    //   57: ldc 126
    //   59: aload_3
    //   60: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_2
    //   64: ifnull -30 -> 34
    //   67: aload_2
    //   68: invokevirtual 114	java/io/ObjectInputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   77: return
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 114	java/io/ObjectInputStream:close	()V
    //   89: aload_2
    //   90: athrow
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   96: goto -7 -> 89
    //   99: astore_2
    //   100: goto -19 -> 81
    //   103: astore_3
    //   104: goto -60 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	MessageForNearbyLiveTip
    //   20	1	1	localObjectInputStream1	java.io.ObjectInputStream
    //   35	2	1	localException1	java.lang.Exception
    //   45	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   72	2	1	localException2	java.lang.Exception
    //   80	6	1	localObject1	java.lang.Object
    //   91	2	1	localException3	java.lang.Exception
    //   18	50	2	localObjectInputStream3	java.io.ObjectInputStream
    //   78	12	2	localObject2	java.lang.Object
    //   99	1	2	localObject3	java.lang.Object
    //   41	19	3	localException4	java.lang.Exception
    //   103	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	34	35	java/lang/Exception
    //   0	19	41	java/lang/Exception
    //   67	71	72	java/lang/Exception
    //   0	19	78	finally
    //   85	89	91	java/lang/Exception
    //   21	26	99	finally
    //   46	52	99	finally
    //   54	63	99	finally
    //   21	26	103	java/lang/Exception
  }
  
  public void getBytes()
  {
    prewrite();
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 140	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 141	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 143	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 146	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 148	com/tencent/mobileqq/data/MessageForNearbyLiveTip:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 149	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 153	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 103	com/tencent/mobileqq/data/MessageForNearbyLiveTip:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 149	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -15 -> 51
    //   69: ldc 124
    //   71: iconst_2
    //   72: ldc 156
    //   74: aload_1
    //   75: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -27 -> 51
    //   81: astore_1
    //   82: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq -24 -> 61
    //   88: ldc 124
    //   90: iconst_2
    //   91: ldc 156
    //   93: aload_1
    //   94: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: return
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +14 -> 120
    //   109: aload_2
    //   110: astore_1
    //   111: ldc 124
    //   113: iconst_2
    //   114: ldc 156
    //   116: aload_3
    //   117: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 149	java/io/ObjectOutputStream:close	()V
    //   128: aload 4
    //   130: ifnull -69 -> 61
    //   133: aload 4
    //   135: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   138: return
    //   139: astore_1
    //   140: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -82 -> 61
    //   146: ldc 124
    //   148: iconst_2
    //   149: ldc 156
    //   151: aload_1
    //   152: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: return
    //   156: astore_1
    //   157: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -32 -> 128
    //   163: ldc 124
    //   165: iconst_2
    //   166: ldc 156
    //   168: aload_1
    //   169: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -44 -> 128
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 149	java/io/ObjectOutputStream:close	()V
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   196: aload_2
    //   197: athrow
    //   198: astore_1
    //   199: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -16 -> 186
    //   205: ldc 124
    //   207: iconst_2
    //   208: ldc 156
    //   210: aload_1
    //   211: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: goto -28 -> 186
    //   217: astore_1
    //   218: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq -25 -> 196
    //   224: ldc 124
    //   226: iconst_2
    //   227: ldc 156
    //   229: aload_1
    //   230: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -37 -> 196
    //   236: astore_2
    //   237: goto -59 -> 178
    //   240: astore_3
    //   241: goto -140 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	MessageForNearbyLiveTip
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	13	1	localException1	java.lang.Exception
    //   81	13	1	localException2	java.lang.Exception
    //   102	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   139	13	1	localException3	java.lang.Exception
    //   156	13	1	localException4	java.lang.Exception
    //   177	6	1	localObject1	java.lang.Object
    //   198	13	1	localException5	java.lang.Exception
    //   217	13	1	localException6	java.lang.Exception
    //   18	107	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   175	22	2	localObject2	java.lang.Object
    //   236	1	2	localObject3	java.lang.Object
    //   98	19	3	localException7	java.lang.Exception
    //   240	1	3	localException8	java.lang.Exception
    //   7	185	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	81	java/lang/Exception
    //   9	19	98	java/lang/Exception
    //   133	138	139	java/lang/Exception
    //   124	128	156	java/lang/Exception
    //   9	19	175	finally
    //   182	186	198	java/lang/Exception
    //   191	196	217	java/lang/Exception
    //   21	26	236	finally
    //   28	32	236	finally
    //   34	43	236	finally
    //   103	109	236	finally
    //   111	120	236	finally
    //   21	26	240	java/lang/Exception
    //   28	32	240	java/lang/Exception
    //   34	43	240	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyLiveTip
 * JD-Core Version:    0.7.0.1
 */