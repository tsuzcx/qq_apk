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
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: getfield 39	oicq/wlogin_sdk/tlv_type/tlv_t508:_head_len	I
    //   13: invokevirtual 43	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   16: pop
    //   17: aload_3
    //   18: invokevirtual 47	java/nio/ByteBuffer:get	()B
    //   21: istore_1
    //   22: iconst_1
    //   23: istore_2
    //   24: iload_1
    //   25: iconst_1
    //   26: if_icmpne +126 -> 152
    //   29: goto +3 -> 32
    //   32: iload_2
    //   33: putstatic 49	oicq/wlogin_sdk/tlv_type/tlv_t508:doFetch	Z
    //   36: aload_3
    //   37: invokevirtual 53	java/nio/ByteBuffer:getInt	()I
    //   40: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   43: aload_3
    //   44: invokevirtual 59	java/nio/ByteBuffer:getShort	()S
    //   47: newarray byte
    //   49: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   52: aload_3
    //   53: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   56: invokevirtual 61	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   59: pop
    //   60: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   63: ifne +9 -> 72
    //   66: sipush 1000
    //   69: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   72: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   75: ifnonnull +9 -> 84
    //   78: iconst_0
    //   79: newarray byte
    //   81: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   84: getstatic 67	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   87: areturn
    //   88: astore_3
    //   89: goto +33 -> 122
    //   92: getstatic 70	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   95: astore_3
    //   96: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   99: ifne +9 -> 108
    //   102: sipush 1000
    //   105: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   108: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   111: ifnonnull +9 -> 120
    //   114: iconst_0
    //   115: newarray byte
    //   117: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   120: aload_3
    //   121: areturn
    //   122: getstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   125: ifne +9 -> 134
    //   128: sipush 1000
    //   131: putstatic 55	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   134: getstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   137: ifnonnull +9 -> 146
    //   140: iconst_0
    //   141: newarray byte
    //   143: putstatic 16	oicq/wlogin_sdk/tlv_type/tlv_t508:userBuf	[B
    //   146: aload_3
    //   147: athrow
    //   148: astore_3
    //   149: goto -57 -> 92
    //   152: iconst_0
    //   153: istore_2
    //   154: goto -122 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	tlv_t508
    //   21	6	1	i	int
    //   23	131	2	bool	boolean
    //   7	46	3	localByteBuffer	java.nio.ByteBuffer
    //   88	1	3	localObject	java.lang.Object
    //   95	52	3	localBoolean	java.lang.Boolean
    //   148	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	88	finally
    //   32	60	88	finally
    //   92	96	88	finally
    //   0	22	148	java/lang/Exception
    //   32	60	148	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t508
 * JD-Core Version:    0.7.0.1
 */