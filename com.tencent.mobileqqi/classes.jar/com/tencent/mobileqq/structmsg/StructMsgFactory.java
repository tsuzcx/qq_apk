package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StructMsgFactory
{
  public static AbsStructMsg a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("req_type", 1))
    {
    case 3: 
    case 4: 
    default: 
      return new StructMsgForGeneralShare(paramBundle);
    case 2: 
      return new StructMsgForAudioShare(paramBundle);
    }
    return new StructMsgForImageShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      long l1 = paramArrayOfByte.mMsgServiceID;
      long l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.a(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aload_2
    //   12: areturn
    //   13: new 82	java/io/ObjectInputStream
    //   16: dup
    //   17: new 84	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 87	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 90	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_2
    //   33: aload 5
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 94	java/io/ObjectInputStream:readInt	()I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_2
    //   44: if_icmpne +77 -> 121
    //   47: aload 4
    //   49: astore_2
    //   50: aload 5
    //   52: astore_3
    //   53: new 26	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   56: dup
    //   57: invokespecial 95	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +24 -> 86
    //   65: aload 4
    //   67: astore_2
    //   68: aload_0
    //   69: astore_3
    //   70: aload_0
    //   71: iload_1
    //   72: putfield 42	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   75: aload 4
    //   77: astore_2
    //   78: aload_0
    //   79: astore_3
    //   80: aload_0
    //   81: aload 4
    //   83: invokevirtual 99	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   86: aload_0
    //   87: astore_2
    //   88: aload 4
    //   90: ifnull -79 -> 11
    //   93: aload 4
    //   95: invokevirtual 102	java/io/ObjectInputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -95 -> 11
    //   109: ldc 110
    //   111: iconst_2
    //   112: aload_3
    //   113: invokevirtual 113	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: areturn
    //   121: iload_1
    //   122: iconst_3
    //   123: if_icmpne +20 -> 143
    //   126: aload 4
    //   128: astore_2
    //   129: aload 5
    //   131: astore_3
    //   132: new 119	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   135: dup
    //   136: invokespecial 120	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   139: astore_0
    //   140: goto -79 -> 61
    //   143: iload_1
    //   144: iconst_5
    //   145: if_icmpne +20 -> 165
    //   148: aload 4
    //   150: astore_2
    //   151: aload 5
    //   153: astore_3
    //   154: new 29	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   157: dup
    //   158: invokespecial 121	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   161: astore_0
    //   162: goto -101 -> 61
    //   165: aload 4
    //   167: astore_2
    //   168: aload 5
    //   170: astore_3
    //   171: new 21	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   174: dup
    //   175: invokespecial 122	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   178: astore_0
    //   179: goto -118 -> 61
    //   182: astore 5
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_0
    //   187: astore_2
    //   188: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +16 -> 207
    //   194: aload_0
    //   195: astore_2
    //   196: ldc 110
    //   198: iconst_2
    //   199: aload 5
    //   201: invokevirtual 123	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_3
    //   208: astore_2
    //   209: aload_0
    //   210: ifnull -199 -> 11
    //   213: aload_0
    //   214: invokevirtual 102	java/io/ObjectInputStream:close	()V
    //   217: aload_3
    //   218: areturn
    //   219: astore_0
    //   220: aload_3
    //   221: astore_2
    //   222: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -214 -> 11
    //   228: ldc 110
    //   230: iconst_2
    //   231: aload_0
    //   232: invokevirtual 113	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_3
    //   239: areturn
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 102	java/io/ObjectInputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore_2
    //   254: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -6 -> 251
    //   260: ldc 110
    //   262: iconst_2
    //   263: aload_2
    //   264: invokevirtual 113	java/io/IOException:getMessage	()Ljava/lang/String;
    //   267: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: goto -19 -> 251
    //   273: astore_0
    //   274: goto -31 -> 243
    //   277: astore 5
    //   279: aload 4
    //   281: astore_0
    //   282: goto -96 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramArrayOfByte	byte[]
    //   41	105	1	i	int
    //   6	242	2	localObject1	Object
    //   253	11	2	localIOException1	IOException
    //   1	79	3	localObject2	Object
    //   100	13	3	localIOException2	IOException
    //   131	108	3	localObject3	Object
    //   28	252	4	localObjectInputStream	java.io.ObjectInputStream
    //   3	166	5	localObject4	Object
    //   182	18	5	localException1	Exception
    //   277	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   93	98	100	java/io/IOException
    //   13	30	182	java/lang/Exception
    //   213	217	219	java/io/IOException
    //   13	30	240	finally
    //   247	251	253	java/io/IOException
    //   36	42	273	finally
    //   53	61	273	finally
    //   70	75	273	finally
    //   80	86	273	finally
    //   132	140	273	finally
    //   154	162	273	finally
    //   171	179	273	finally
    //   188	194	273	finally
    //   196	207	273	finally
    //   36	42	277	java/lang/Exception
    //   53	61	277	java/lang/Exception
    //   70	75	277	java/lang/Exception
    //   80	86	277	java/lang/Exception
    //   132	140	277	java/lang/Exception
    //   154	162	277	java/lang/Exception
    //   171	179	277	java/lang/Exception
  }
  
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlbuff is null or lenght<2");
      }
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      paramArrayOfByte = new ByteArrayInputStream(StructMsgUtils.a(paramArrayOfByte, paramInt));
      Object localObject = new StructMsgParserHandler();
      SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
      try
      {
        localSAXParserFactory.newSAXParser().parse(paramArrayOfByte, (DefaultHandler)localObject);
        paramArrayOfByte.close();
        localObject = ((StructMsgParserHandler)localObject).a();
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null) {
          continue;
        }
        paramArrayOfByte = (byte[])localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff decode structmsg success");
        return localObject;
      }
      catch (ParserConfigurationException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
        }
        return null;
      }
      catch (SAXException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "getStructMsg", paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public static StructMsgNode a(StructMsgNode paramStructMsgNode)
  {
    for (paramStructMsgNode = paramStructMsgNode.a(); (paramStructMsgNode != null) && (paramStructMsgNode.jdField_a_of_type_Int != 1); paramStructMsgNode = paramStructMsgNode.a()) {}
    return paramStructMsgNode;
  }
  
  public static String a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode.jdField_a_of_type_Int == 3) {}
    Object localObject;
    for (paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaLangString;; paramStructMsgNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramStructMsgNode;
      if (paramStructMsgNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      int j = paramStructMsgNode.a();
      int i = 0;
      if (i < j)
      {
        StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
        if (localStructMsgNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localStructMsgNode.jdField_a_of_type_Int == 3) {
            ((StringBuilder)localObject).append(localStructMsgNode.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgFactory
 * JD-Core Version:    0.7.0.1
 */