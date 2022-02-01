import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class agzx
  implements agzt
{
  String bIH;
  String bII;
  String bJA;
  agie f;
  long uFileSize;
  
  public void Kg(boolean paramBoolean) {}
  
  public long a(aomh paramaomh)
  {
    paramaomh = new ByteArrayInputStream(paramaomh.mRespData);
    DataInputStream localDataInputStream = new DataInputStream(paramaomh);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        onError();
      }
    }
    catch (IOException localIOException)
    {
      int i;
      int j;
      long l;
      localIOException.printStackTrace();
    }
    finally
    {
      try
      {
        paramaomh.close();
        localDataInputStream.close();
        return -1L;
        localObject = finally;
        try
        {
          paramaomh.close();
          localDataInputStream.close();
          throw localObject;
        }
        catch (Exception paramaomh)
        {
          break label187;
        }
      }
      catch (Exception paramaomh)
      {
        break label172;
      }
    }
    try
    {
      paramaomh.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramaomh) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      j = localDataInputStream.readInt();
      l = j;
      l = i | l << 32;
      try
      {
        paramaomh.close();
        localDataInputStream.close();
        return l;
      }
      catch (Exception paramaomh)
      {
        return l;
      }
    }
    if (i == 1)
    {
      onSuccess();
      try
      {
        paramaomh.close();
        localDataInputStream.close();
        return 0L;
      }
      catch (Exception paramaomh)
      {
        return 0L;
      }
    }
    onError();
    try
    {
      paramaomh.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramaomh)
    {
      return 0L;
    }
    label172:
    label187:
    return 0L;
  }
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	agzx:bII	Ljava/lang/String;
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 6
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: getfield 77	agzx:bJA	Ljava/lang/String;
    //   19: astore 5
    //   21: aload_0
    //   22: getfield 79	agzx:bIH	Ljava/lang/String;
    //   25: ifnull +26 -> 51
    //   28: aload 5
    //   30: ifnull +21 -> 51
    //   33: aload_0
    //   34: getfield 79	agzx:bIH	Ljava/lang/String;
    //   37: invokevirtual 84	java/lang/String:length	()I
    //   40: ifeq +11 -> 51
    //   43: aload 5
    //   45: invokevirtual 84	java/lang/String:length	()I
    //   48: ifne +23 -> 71
    //   51: invokestatic 90	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   54: ifeq +11 -> 65
    //   57: new 92	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 94	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: aload_0
    //   66: invokevirtual 54	agzx:onError	()V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 5
    //   73: invokestatic 100	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   76: astore 7
    //   78: aload_0
    //   79: getfield 79	agzx:bIH	Ljava/lang/String;
    //   82: invokestatic 100	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   85: astore 8
    //   87: aload 8
    //   89: arraylength
    //   90: iconst_2
    //   91: iadd
    //   92: iconst_2
    //   93: iadd
    //   94: aload 7
    //   96: arraylength
    //   97: iadd
    //   98: bipush 20
    //   100: iadd
    //   101: aload_1
    //   102: arraylength
    //   103: iadd
    //   104: istore 4
    //   106: new 102	java/io/ByteArrayOutputStream
    //   109: dup
    //   110: iload 4
    //   112: bipush 16
    //   114: iadd
    //   115: invokespecial 105	java/io/ByteArrayOutputStream:<init>	(I)V
    //   118: astore 5
    //   120: new 107	java/io/DataOutputStream
    //   123: dup
    //   124: aload 5
    //   126: invokespecial 110	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: astore 6
    //   131: aload 6
    //   133: ldc 111
    //   135: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   138: aload 6
    //   140: sipush 1007
    //   143: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   146: aload 6
    //   148: iconst_0
    //   149: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   152: aload 6
    //   154: iload 4
    //   156: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   159: aload 6
    //   161: aload 8
    //   163: arraylength
    //   164: invokevirtual 117	java/io/DataOutputStream:writeShort	(I)V
    //   167: aload 6
    //   169: aload 8
    //   171: invokevirtual 120	java/io/DataOutputStream:write	([B)V
    //   174: aload 6
    //   176: aload 7
    //   178: arraylength
    //   179: invokevirtual 117	java/io/DataOutputStream:writeShort	(I)V
    //   182: aload 6
    //   184: aload 7
    //   186: invokevirtual 120	java/io/DataOutputStream:write	([B)V
    //   189: aload 6
    //   191: aload_0
    //   192: getfield 122	agzx:uFileSize	J
    //   195: ldc2_w 123
    //   198: land
    //   199: l2i
    //   200: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   203: aload 6
    //   205: lload_2
    //   206: ldc2_w 123
    //   209: land
    //   210: l2i
    //   211: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   214: aload 6
    //   216: aload_1
    //   217: arraylength
    //   218: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   221: aload 6
    //   223: aload_0
    //   224: getfield 122	agzx:uFileSize	J
    //   227: bipush 32
    //   229: lshr
    //   230: l2i
    //   231: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   234: aload 6
    //   236: lload_2
    //   237: bipush 32
    //   239: lshr
    //   240: l2i
    //   241: invokevirtual 114	java/io/DataOutputStream:writeInt	(I)V
    //   244: aload 6
    //   246: aload_1
    //   247: iconst_0
    //   248: aload_1
    //   249: arraylength
    //   250: invokevirtual 127	java/io/DataOutputStream:write	([BII)V
    //   253: aload 5
    //   255: invokevirtual 131	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   258: astore_1
    //   259: aload 5
    //   261: invokevirtual 132	java/io/ByteArrayOutputStream:close	()V
    //   264: aload 6
    //   266: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   269: aload_1
    //   270: areturn
    //   271: astore 5
    //   273: aload_1
    //   274: areturn
    //   275: astore_1
    //   276: aload_0
    //   277: invokevirtual 54	agzx:onError	()V
    //   280: aload 5
    //   282: invokevirtual 132	java/io/ByteArrayOutputStream:close	()V
    //   285: aload 6
    //   287: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: aload 5
    //   295: invokevirtual 132	java/io/ByteArrayOutputStream:close	()V
    //   298: aload 6
    //   300: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: astore 5
    //   307: goto -4 -> 303
    //   310: astore_1
    //   311: goto -21 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	agzx
    //   0	314	1	paramArrayOfByte	byte[]
    //   0	314	2	paramLong	long
    //   104	51	4	i	int
    //   8	252	5	localObject1	Object
    //   271	23	5	localException1	Exception
    //   305	1	5	localException2	Exception
    //   4	295	6	localObject2	Object
    //   76	109	7	arrayOfByte1	byte[]
    //   85	85	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   259	269	271	java/lang/Exception
    //   131	259	275	java/io/IOException
    //   131	259	292	finally
    //   276	280	292	finally
    //   293	303	305	java/lang/Exception
    //   280	290	310	java/lang/Exception
  }
  
  public void as(long paramLong1, long paramLong2)
  {
    this.f.as(paramLong1, paramLong2);
  }
  
  public void onError() {}
  
  public void onSuccess()
  {
    this.f.dgt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzx
 * JD-Core Version:    0.7.0.1
 */