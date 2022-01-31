public class wef
{
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 10	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 14	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 16	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 19	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 23	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 27	java/io/ByteArrayInputStream:close	()V
    //   27: aload_2
    //   28: invokevirtual 28	java/io/ObjectInputStream:close	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 31	java/lang/Exception:printStackTrace	()V
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: goto -7 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramArrayOfByte	byte[]
    //   8	16	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   33	4	1	localException1	java.lang.Exception
    //   42	1	1	localException2	java.lang.Exception
    //   17	11	2	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   0	23	33	java/lang/Exception
    //   23	31	42	java/lang/Exception
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: new 35	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 39	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 42	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 46	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_1
    //   23: invokevirtual 50	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   31: aload_2
    //   32: invokevirtual 52	java/io/ObjectOutputStream:close	()V
    //   35: aload_0
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 31	java/lang/Exception:printStackTrace	()V
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: goto -7 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramObject	Object
    //   7	21	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   37	4	1	localException1	java.lang.Exception
    //   46	1	1	localException2	java.lang.Exception
    //   16	16	2	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	27	37	java/lang/Exception
    //   27	35	46	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wef
 * JD-Core Version:    0.7.0.1
 */