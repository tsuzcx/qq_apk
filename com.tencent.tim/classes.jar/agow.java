import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class agow
  implements agpc
{
  final String TAG = "DiscFileUploader<FileAssistant>";
  agpa a = null;
  String bIH;
  String bII;
  long uFileSize;
  
  /* Error */
  public long a(aomh paramaomh, agoz paramagoz)
  {
    // Byte code:
    //   0: new 32	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: getfield 38	aomh:mRespData	[B
    //   8: invokespecial 41	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: new 43	java/io/DataInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 46	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc2_w 47
    //   27: invokevirtual 52	java/io/DataInputStream:skip	(J)J
    //   30: pop2
    //   31: aload 6
    //   33: invokevirtual 56	java/io/DataInputStream:readInt	()I
    //   36: ifeq +32 -> 68
    //   39: aload_2
    //   40: ldc2_w 57
    //   43: putfield 63	agoz:Zs	J
    //   46: aload_2
    //   47: ldc 65
    //   49: putfield 68	agoz:strErrMsg	Ljava/lang/String;
    //   52: aload_0
    //   53: aload_2
    //   54: invokevirtual 71	agow:a	(Lagoz;)V
    //   57: aload_1
    //   58: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   61: aload 6
    //   63: invokevirtual 75	java/io/DataInputStream:close	()V
    //   66: lconst_0
    //   67: lreturn
    //   68: aload 6
    //   70: ldc2_w 76
    //   73: invokevirtual 52	java/io/DataInputStream:skip	(J)J
    //   76: pop2
    //   77: aload 6
    //   79: invokevirtual 81	java/io/DataInputStream:readByte	()B
    //   82: istore_3
    //   83: iload_3
    //   84: ifne +65 -> 149
    //   87: aload 6
    //   89: invokevirtual 56	java/io/DataInputStream:readInt	()I
    //   92: istore_3
    //   93: aload 6
    //   95: invokevirtual 56	java/io/DataInputStream:readInt	()I
    //   98: i2l
    //   99: lstore 4
    //   101: iload_3
    //   102: i2l
    //   103: lload 4
    //   105: bipush 32
    //   107: lshl
    //   108: lor
    //   109: lstore 4
    //   111: aload_2
    //   112: getfield 84	agoz:Zy	J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifne +9 -> 126
    //   120: aload_2
    //   121: lload 4
    //   123: putfield 84	agoz:Zy	J
    //   126: aload_2
    //   127: lload 4
    //   129: aload_2
    //   130: getfield 84	agoz:Zy	J
    //   133: lsub
    //   134: putfield 87	agoz:Zz	J
    //   137: aload_1
    //   138: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   141: aload 6
    //   143: invokevirtual 75	java/io/DataInputStream:close	()V
    //   146: lload 4
    //   148: lreturn
    //   149: iload_3
    //   150: iconst_1
    //   151: if_icmpne +37 -> 188
    //   154: aload_2
    //   155: lconst_0
    //   156: putfield 63	agoz:Zs	J
    //   159: aload_2
    //   160: aload_2
    //   161: getfield 90	agoz:Zv	J
    //   164: lconst_1
    //   165: ladd
    //   166: putfield 93	agoz:Zw	J
    //   169: aload_0
    //   170: aload_2
    //   171: invokevirtual 96	agow:b	(Lagoz;)V
    //   174: aload_1
    //   175: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   178: aload 6
    //   180: invokevirtual 75	java/io/DataInputStream:close	()V
    //   183: lconst_0
    //   184: lreturn
    //   185: astore_1
    //   186: lconst_0
    //   187: lreturn
    //   188: aload_2
    //   189: ldc2_w 57
    //   192: putfield 63	agoz:Zs	J
    //   195: aload_2
    //   196: ldc 98
    //   198: putfield 68	agoz:strErrMsg	Ljava/lang/String;
    //   201: aload_0
    //   202: aload_2
    //   203: invokevirtual 71	agow:a	(Lagoz;)V
    //   206: aload_1
    //   207: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   210: aload 6
    //   212: invokevirtual 75	java/io/DataInputStream:close	()V
    //   215: lconst_0
    //   216: lreturn
    //   217: astore_1
    //   218: lconst_0
    //   219: lreturn
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   225: aload_1
    //   226: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   229: aload 6
    //   231: invokevirtual 75	java/io/DataInputStream:close	()V
    //   234: ldc2_w 102
    //   237: lreturn
    //   238: astore_2
    //   239: aload_1
    //   240: invokevirtual 74	java/io/ByteArrayInputStream:close	()V
    //   243: aload 6
    //   245: invokevirtual 75	java/io/DataInputStream:close	()V
    //   248: aload_2
    //   249: athrow
    //   250: astore_1
    //   251: goto -3 -> 248
    //   254: astore_1
    //   255: goto -21 -> 234
    //   258: astore_1
    //   259: goto -113 -> 146
    //   262: astore_1
    //   263: lconst_0
    //   264: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	agow
    //   0	265	1	paramaomh	aomh
    //   0	265	2	paramagoz	agoz
    //   82	70	3	i	int
    //   99	48	4	l	long
    //   20	224	6	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   174	183	185	java/lang/Exception
    //   206	215	217	java/lang/Exception
    //   22	57	220	java/io/IOException
    //   68	83	220	java/io/IOException
    //   87	101	220	java/io/IOException
    //   111	126	220	java/io/IOException
    //   126	137	220	java/io/IOException
    //   154	174	220	java/io/IOException
    //   188	206	220	java/io/IOException
    //   22	57	238	finally
    //   68	83	238	finally
    //   87	101	238	finally
    //   111	126	238	finally
    //   126	137	238	finally
    //   154	174	238	finally
    //   188	206	238	finally
    //   221	225	238	finally
    //   239	248	250	java/lang/Exception
    //   225	234	254	java/lang/Exception
    //   137	146	258	java/lang/Exception
    //   57	66	262	java/lang/Exception
  }
  
  public void a(agoz paramagoz)
  {
    QLog.i("DiscFileUploader<FileAssistant>", 1, "=_= ^! [Upload Step] Send Error!:" + paramagoz.strErrMsg);
    paramagoz.diE();
    this.a.j(null, 0);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, agpa paramagpa)
  {
    this.bIH = paramString1;
    this.bII = paramString2;
    this.uFileSize = paramLong;
    this.a = paramagpa;
  }
  
  public void a(boolean paramBoolean, agoz paramagoz) {}
  
  public byte[] a(byte[] paramArrayOfByte, long paramLong, agoz paramagoz)
  {
    if ((this.bIH == null) || (this.bII == null) || (this.bIH.length() == 0) || (this.bII.length() == 0))
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException();
      }
      paramagoz.Zs = 9005L;
      a(paramagoz);
      return null;
    }
    byte[] arrayOfByte1 = HexUtil.hexStr2Bytes(this.bII);
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(this.bIH);
    int i = arrayOfByte2.length + 2 + 2 + arrayOfByte1.length + 20 + paramArrayOfByte.length;
    localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(arrayOfByte2.length);
      localDataOutputStream.write(arrayOfByte2);
      localDataOutputStream.writeShort(arrayOfByte1.length);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt((int)(this.uFileSize & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.uFileSize >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception paramagoz)
      {
        return paramArrayOfByte;
      }
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception paramagoz)
      {
        break label319;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramagoz.Zs = 9003L;
      paramagoz.strErrMsg = ahav.ti();
      a(paramagoz);
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally {}
  }
  
  public void as(long paramLong1, long paramLong2)
  {
    this.a.as(paramLong1, paramLong2);
  }
  
  public void b(agoz paramagoz)
  {
    QLog.i("DiscFileUploader<FileAssistant>", 1, "=_= ^> [Upload Step] Send Success!Go [Disc Feed]");
    paramagoz.diD();
    this.a.dgy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agow
 * JD-Core Version:    0.7.0.1
 */