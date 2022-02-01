package oicq.wlogin_sdk.tlv_type;

public class tlv_t508
  extends tlv_t
{
  public static boolean doFetch = true;
  public static int timeout = 1000;
  public static byte[] userBuf = new byte[0];
  
  public tlv_t508()
  {
    this._cmd = 1288;
  }
  
  /* Error */
  public java.lang.Boolean verify()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	oicq/wlogin_sdk/tlv_type/tlv_t508:_buf	[B
    //   4: invokestatic 36	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 39	oicq/wlogin_sdk/tlv_type/tlv_t508:_head_len	I
    //   13: invokevirtual 43	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   16: pop
    //   17: aload_2
    //   18: invokevirtual 47	java/nio/ByteBuffer:get	()B
    //   21: iconst_1
    //   22: if_icmpne +128 -> 150
    //   25: iconst_1
    //   26: istore_1
    //   27: goto +3 -> 30
    //   30: iload_1
    //   31: putstatic 49	oicq/wlogin_sdk/tlv_type/tlv_t508:doFetch	Z
    //   34: aload_2
    //   35: invokevirtual 53	java/nio/ByteBuffer:getInt	()I
    //   38: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   41: aload_2
    //   42: invokevirtual 59	java/nio/ByteBuffer:getShort	()S
    //   45: newarray byte
    //   47: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   50: aload_2
    //   51: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   54: invokevirtual 61	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   57: pop
    //   58: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   61: ifne +9 -> 70
    //   64: sipush 1000
    //   67: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   70: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   73: ifnonnull +9 -> 82
    //   76: iconst_0
    //   77: newarray byte
    //   79: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   82: iconst_1
    //   83: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: areturn
    //   87: astore_2
    //   88: goto +32 -> 120
    //   91: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   94: ifne +9 -> 103
    //   97: sipush 1000
    //   100: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   103: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   106: ifnonnull +9 -> 115
    //   109: iconst_0
    //   110: newarray byte
    //   112: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   115: iconst_0
    //   116: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   119: areturn
    //   120: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   123: ifne +9 -> 132
    //   126: sipush 1000
    //   129: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   132: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   135: ifnonnull +9 -> 144
    //   138: iconst_0
    //   139: newarray byte
    //   141: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: goto -56 -> 91
    //   150: iconst_0
    //   151: istore_1
    //   152: goto -122 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	tlv_t508
    //   26	126	1	bool	boolean
    //   7	44	2	localByteBuffer	java.nio.ByteBuffer
    //   87	58	2	localObject	java.lang.Object
    //   146	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	25	87	finally
    //   30	58	87	finally
    //   0	25	146	java/lang/Exception
    //   30	58	146	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t508
 * JD-Core Version:    0.7.0.1
 */