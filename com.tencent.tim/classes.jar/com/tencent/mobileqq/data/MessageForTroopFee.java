package com.tencent.mobileqq.data;

import android.text.TextUtils;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MessageForTroopFee
  extends ChatMessage
{
  public String actionUrl;
  public String backgroundColor = "#FD9527";
  public String brief;
  public String source;
  public String summary;
  public String title;
  
  /* Error */
  public static MessageForTroopFee decodeMsgFromXmlBuff(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +10 -> 12
    //   5: aload 4
    //   7: arraylength
    //   8: iconst_2
    //   9: if_icmpge +21 -> 30
    //   12: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 43
    //   20: iconst_2
    //   21: ldc 45
    //   23: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_0
    //   28: aload_0
    //   29: areturn
    //   30: aload 4
    //   32: iload 5
    //   34: invokestatic 54	ansi:d	([BI)[B
    //   37: astore_0
    //   38: new 56	java/lang/String
    //   41: dup
    //   42: aload_0
    //   43: ldc 58
    //   45: invokespecial 61	java/lang/String:<init>	([BLjava/lang/String;)V
    //   48: invokestatic 67	anre:nI	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_0
    //   52: new 69	java/io/ByteArrayInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokevirtual 73	java/lang/String:getBytes	()[B
    //   60: invokespecial 76	java/io/ByteArrayInputStream:<init>	([B)V
    //   63: astore_0
    //   64: new 6	com/tencent/mobileqq/data/MessageForTroopFee$a
    //   67: dup
    //   68: invokespecial 77	com/tencent/mobileqq/data/MessageForTroopFee$a:<init>	()V
    //   71: astore 4
    //   73: invokestatic 83	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   76: astore 6
    //   78: aload 6
    //   80: invokevirtual 87	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 93	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   89: aload_0
    //   90: invokevirtual 98	java/io/InputStream:close	()V
    //   93: aload 4
    //   95: invokevirtual 101	com/tencent/mobileqq/data/MessageForTroopFee$a:a	()Lcom/tencent/mobileqq/data/MessageForTroopFee;
    //   98: astore 4
    //   100: aload 4
    //   102: astore_0
    //   103: aload 4
    //   105: invokevirtual 104	com/tencent/mobileqq/data/MessageForTroopFee:checkParams	()Z
    //   108: ifeq -80 -> 28
    //   111: aload 4
    //   113: astore_0
    //   114: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -89 -> 28
    //   120: ldc 43
    //   122: iconst_2
    //   123: ldc 106
    //   125: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 4
    //   130: areturn
    //   131: astore_0
    //   132: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +12 -> 147
    //   138: ldc 108
    //   140: iconst_2
    //   141: ldc 110
    //   143: aload_0
    //   144: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 117	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -13 -> 147
    //   163: ldc 108
    //   165: iconst_2
    //   166: ldc 110
    //   168: aload_0
    //   169: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -25 -> 147
    //   175: astore_0
    //   176: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq -32 -> 147
    //   182: ldc 108
    //   184: iconst_2
    //   185: ldc 110
    //   187: aload_0
    //   188: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: goto -44 -> 147
    //   194: astore_0
    //   195: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq -51 -> 147
    //   201: ldc 108
    //   203: iconst_2
    //   204: ldc 110
    //   206: aload_0
    //   207: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -63 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	213	1	paramInt1	int
    //   0	213	2	paramLong	long
    //   0	213	4	paramArrayOfByte	byte[]
    //   0	213	5	paramInt2	int
    //   76	3	6	localSAXParserFactory	javax.xml.parsers.SAXParserFactory
    // Exception table:
    //   from	to	target	type
    //   78	100	131	javax/xml/parsers/ParserConfigurationException
    //   103	111	131	javax/xml/parsers/ParserConfigurationException
    //   114	128	131	javax/xml/parsers/ParserConfigurationException
    //   38	52	149	java/io/UnsupportedEncodingException
    //   78	100	156	org/xml/sax/SAXException
    //   103	111	156	org/xml/sax/SAXException
    //   114	128	156	org/xml/sax/SAXException
    //   78	100	175	java/io/IOException
    //   103	111	175	java/io/IOException
    //   114	128	175	java/io/IOException
    //   78	100	194	java/lang/Exception
    //   103	111	194	java/lang/Exception
    //   114	128	194	java/lang/Exception
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.title)) && (!TextUtils.isEmpty(this.summary)) && (!TextUtils.isEmpty(this.source)) && (!TextUtils.isEmpty(this.actionUrl)) && (!TextUtils.isEmpty(this.brief));
  }
  
  public void copyFrom(MessageForTroopFee paramMessageForTroopFee)
  {
    this.title = paramMessageForTroopFee.title;
    this.summary = paramMessageForTroopFee.summary;
    this.source = paramMessageForTroopFee.source;
    this.actionUrl = paramMessageForTroopFee.actionUrl;
    this.brief = paramMessageForTroopFee.brief;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 138	java/io/ObjectInputStream
    //   3: dup
    //   4: new 69	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 142	com/tencent/mobileqq/data/MessageForTroopFee:msgData	[B
    //   12: invokespecial 76	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 145	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 149	com/tencent/mobileqq/data/MessageForTroopFee:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 153	com/tencent/mobileqq/data/MessageForTroopFee:getSummaryMsg	()Ljava/lang/String;
    //   33: putfield 156	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   44: return
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   50: return
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 108
    //   66: iconst_2
    //   67: ldc 160
    //   69: aload_3
    //   70: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: ifnull -30 -> 44
    //   77: aload_2
    //   78: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   81: return
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   87: return
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 157	java/io/ObjectInputStream:close	()V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_2
    //   110: goto -19 -> 91
    //   113: astore_3
    //   114: goto -60 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	MessageForTroopFee
    //   20	8	1	localObjectInputStream1	java.io.ObjectInputStream
    //   45	2	1	localException1	java.lang.Exception
    //   55	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   82	2	1	localException2	java.lang.Exception
    //   90	6	1	localObject1	java.lang.Object
    //   101	2	1	localException3	java.lang.Exception
    //   18	60	2	localObjectInputStream3	java.io.ObjectInputStream
    //   88	12	2	localObject2	java.lang.Object
    //   109	1	2	localObject3	java.lang.Object
    //   51	19	3	localException4	java.lang.Exception
    //   113	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   40	44	45	java/lang/Exception
    //   0	19	51	java/lang/Exception
    //   77	81	82	java/lang/Exception
    //   0	19	88	finally
    //   95	99	101	java/lang/Exception
    //   21	26	109	finally
    //   28	36	109	finally
    //   56	62	109	finally
    //   64	73	109	finally
    //   21	26	113	java/lang/Exception
    //   28	36	113	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getSummaryMsg()
  {
    return this.brief + this.title;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 181	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 182	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 184	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 187	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 191	com/tencent/mobileqq/data/MessageForTroopFee:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 192	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 195	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 142	com/tencent/mobileqq/data/MessageForTroopFee:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 192	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 196	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   67: goto -16 -> 51
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   75: return
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_2
    //   80: astore_1
    //   81: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +14 -> 98
    //   87: aload_2
    //   88: astore_1
    //   89: ldc 108
    //   91: iconst_2
    //   92: ldc 198
    //   94: aload_3
    //   95: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 192	java/io/ObjectOutputStream:close	()V
    //   112: aload 4
    //   114: ifnull -53 -> 61
    //   117: aload 4
    //   119: invokevirtual 196	java/io/ByteArrayOutputStream:close	()V
    //   122: return
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   134: goto -22 -> 112
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 192	java/io/ObjectOutputStream:close	()V
    //   148: aload 4
    //   150: ifnull +8 -> 158
    //   153: aload 4
    //   155: invokevirtual 196	java/io/ByteArrayOutputStream:close	()V
    //   158: aload_2
    //   159: athrow
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   165: goto -17 -> 148
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   173: goto -15 -> 158
    //   176: astore_2
    //   177: goto -37 -> 140
    //   180: astore_3
    //   181: goto -102 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	MessageForTroopFee
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	2	1	localException1	java.lang.Exception
    //   70	2	1	localException2	java.lang.Exception
    //   80	20	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   123	2	1	localException3	java.lang.Exception
    //   129	2	1	localException4	java.lang.Exception
    //   139	6	1	localObject1	java.lang.Object
    //   160	2	1	localException5	java.lang.Exception
    //   168	2	1	localException6	java.lang.Exception
    //   18	91	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   137	22	2	localObject2	java.lang.Object
    //   176	1	2	localObject3	java.lang.Object
    //   76	25	3	localException7	java.lang.Exception
    //   180	1	3	localException8	java.lang.Exception
    //   7	147	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	70	java/lang/Exception
    //   9	19	76	java/lang/Exception
    //   117	122	123	java/lang/Exception
    //   108	112	129	java/lang/Exception
    //   9	19	137	finally
    //   144	148	160	java/lang/Exception
    //   153	158	168	java/lang/Exception
    //   21	26	176	finally
    //   28	32	176	finally
    //   34	43	176	finally
    //   81	87	176	finally
    //   89	98	176	finally
    //   100	104	176	finally
    //   21	26	180	java/lang/Exception
    //   28	32	180	java/lang/Exception
    //   34	43	180	java/lang/Exception
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.title = paramObjectInput.readUTF();
    this.summary = paramObjectInput.readUTF();
    this.source = paramObjectInput.readUTF();
    this.actionUrl = paramObjectInput.readUTF();
    this.brief = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.title);
    paramObjectOutput.writeUTF(this.summary);
    paramObjectOutput.writeUTF(this.source);
    paramObjectOutput.writeUTF(this.actionUrl);
    paramObjectOutput.writeUTF(this.brief);
  }
  
  static class a
    extends DefaultHandler
  {
    MessageForTroopFee a = new MessageForTroopFee();
    public String bCw = "";
    
    public MessageForTroopFee a()
    {
      return this.a;
    }
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (this.bCw.equals("title")) {
        this.a.title = paramArrayOfChar;
      }
      while (!this.bCw.equals("summary")) {
        return;
      }
      this.a.summary = paramArrayOfChar;
    }
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
      throws SAXException
    {
      if (paramString3.equals("msg"))
      {
        this.a.actionUrl = paramAttributes.getValue("url");
        this.a.brief = paramAttributes.getValue("brief");
      }
      do
      {
        return;
        if (paramString3.equals("title"))
        {
          this.bCw = "title";
          return;
        }
        if (paramString3.equals("summary"))
        {
          this.bCw = "summary";
          return;
        }
      } while (!paramString3.equals("source"));
      this.a.source = paramAttributes.getValue("name");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFee
 * JD-Core Version:    0.7.0.1
 */