package com.tencent.mobileqq.data;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForDarenAssistant
  extends ChatMessage
{
  public static final String TAG = "Q.msg_box.MessageForDarenAssistant";
  public String jumpUrl;
  
  private void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.msg = paramObjectInput.readUTF();
    this.jumpUrl = paramObjectInput.readUTF();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.msg);
    paramObjectOutput.writeUTF(this.jumpUrl);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 45	java/io/ObjectInputStream
    //   3: dup
    //   4: new 47	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 51	com/tencent/mobileqq/data/MessageForDarenAssistant:msgData	[B
    //   12: invokespecial 54	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 57	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 59	com/tencent/mobileqq/data/MessageForDarenAssistant:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 62	java/io/ObjectInputStream:close	()V
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   40: return
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_2
    //   53: astore_1
    //   54: ldc 8
    //   56: iconst_2
    //   57: ldc 73
    //   59: aload_3
    //   60: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_2
    //   64: ifnull -30 -> 34
    //   67: aload_2
    //   68: invokevirtual 62	java/io/ObjectInputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   77: return
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 62	java/io/ObjectInputStream:close	()V
    //   89: aload_2
    //   90: athrow
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   96: goto -7 -> 89
    //   99: astore_2
    //   100: goto -19 -> 81
    //   103: astore_3
    //   104: goto -60 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	MessageForDarenAssistant
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
    //   0: new 87	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 88	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 90	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 93	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 95	com/tencent/mobileqq/data/MessageForDarenAssistant:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 96	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 100	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 51	com/tencent/mobileqq/data/MessageForDarenAssistant:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 96	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq -10 -> 51
    //   64: ldc 103
    //   66: iconst_2
    //   67: ldc 105
    //   69: aload_1
    //   70: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: goto -22 -> 51
    //   76: astore_1
    //   77: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq -24 -> 56
    //   83: ldc 103
    //   85: iconst_2
    //   86: ldc 105
    //   88: aload_1
    //   89: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: return
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: astore_1
    //   98: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +14 -> 115
    //   104: aload_2
    //   105: astore_1
    //   106: ldc 103
    //   108: iconst_2
    //   109: ldc 105
    //   111: aload_3
    //   112: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 96	java/io/ObjectOutputStream:close	()V
    //   123: aload 4
    //   125: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -77 -> 56
    //   136: ldc 103
    //   138: iconst_2
    //   139: ldc 105
    //   141: aload_1
    //   142: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: return
    //   146: astore_1
    //   147: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq -27 -> 123
    //   153: ldc 103
    //   155: iconst_2
    //   156: ldc 105
    //   158: aload_1
    //   159: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: goto -39 -> 123
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 96	java/io/ObjectOutputStream:close	()V
    //   176: aload 4
    //   178: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -11 -> 176
    //   190: ldc 103
    //   192: iconst_2
    //   193: ldc 105
    //   195: aload_1
    //   196: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: goto -23 -> 176
    //   202: astore_1
    //   203: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq -25 -> 181
    //   209: ldc 103
    //   211: iconst_2
    //   212: ldc 105
    //   214: aload_1
    //   215: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: goto -37 -> 181
    //   221: astore_2
    //   222: goto -54 -> 168
    //   225: astore_3
    //   226: goto -130 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	MessageForDarenAssistant
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   57	13	1	localException1	java.lang.Exception
    //   76	13	1	localException2	java.lang.Exception
    //   97	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   129	13	1	localException3	java.lang.Exception
    //   146	13	1	localException4	java.lang.Exception
    //   167	6	1	localObject1	java.lang.Object
    //   183	13	1	localException5	java.lang.Exception
    //   202	13	1	localException6	java.lang.Exception
    //   18	102	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   165	17	2	localObject2	java.lang.Object
    //   221	1	2	localObject3	java.lang.Object
    //   93	19	3	localException7	java.lang.Exception
    //   225	1	3	localException8	java.lang.Exception
    //   7	170	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	57	java/lang/Exception
    //   51	56	76	java/lang/Exception
    //   9	19	93	java/lang/Exception
    //   123	128	129	java/lang/Exception
    //   119	123	146	java/lang/Exception
    //   9	19	165	finally
    //   172	176	183	java/lang/Exception
    //   176	181	202	java/lang/Exception
    //   21	26	221	finally
    //   28	32	221	finally
    //   34	43	221	finally
    //   98	104	221	finally
    //   106	115	221	finally
    //   21	26	225	java/lang/Exception
    //   28	32	225	java/lang/Exception
    //   34	43	225	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDarenAssistant
 * JD-Core Version:    0.7.0.1
 */