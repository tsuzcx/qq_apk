package com.tencent.upload.utils;

public class PduHeader
{
  public static int length = 23;
  private byte[] buf = new byte[23];
  public int checksum = 0;
  public int cmd = 0;
  public int key = 0;
  public int len = 0;
  public char reserved;
  public short response_flag = 0;
  public short response_info = 0;
  public int seq = 0;
  public final int version = 0;
  
  public PduHeader(int paramInt1, int paramInt2)
  {
    this(paramInt1, 0, paramInt2);
  }
  
  public PduHeader(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cmd = paramInt1;
    this.len = paramInt3;
    this.seq = paramInt2;
    byte[] arrayOfByte = new byte[4];
    int2byte(paramInt1, arrayOfByte);
    System.arraycopy(arrayOfByte, 0, this.buf, OFFSET.CMD, arrayOfByte.length);
    if (paramInt2 != 0)
    {
      int2byte(paramInt2, arrayOfByte);
      System.arraycopy(arrayOfByte, 0, this.buf, OFFSET.SEQ, arrayOfByte.length);
    }
    int2byte(this.len, arrayOfByte);
    System.arraycopy(arrayOfByte, 0, this.buf, OFFSET.LEN, arrayOfByte.length);
  }
  
  public static int byte2int(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  public static PduHeader decode(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, OFFSET.CMD, arrayOfByte, 0, 4);
    int i = byte2int(arrayOfByte);
    System.arraycopy(paramArrayOfByte, OFFSET.SEQ, arrayOfByte, 0, 4);
    int j = byte2int(arrayOfByte);
    System.arraycopy(paramArrayOfByte, OFFSET.LEN, arrayOfByte, 0, 4);
    return new PduHeader(i, j, byte2int(arrayOfByte));
  }
  
  public static void int2byte(int paramInt, byte[] paramArrayOfByte)
  {
    int2byte(paramInt, paramArrayOfByte, 0);
  }
  
  public static void int2byte(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  public byte[] getBuf()
  {
    return this.buf;
  }
  
  public static class OFFSET
  {
    public static int CHECKSUM;
    public static int CMD;
    public static int KEY;
    public static int LEN = 19;
    public static int RESERVERD;
    public static int RESPONSE_FLAG;
    public static int RESPONSE_INFO;
    public static int SEQ;
    public static int VERSION = 0;
    
    static
    {
      CMD = 1;
      CHECKSUM = 5;
      SEQ = 7;
      KEY = 11;
      RESPONSE_FLAG = 15;
      RESPONSE_INFO = 16;
      RESERVERD = 18;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.utils.PduHeader
 * JD-Core Version:    0.7.0.1
 */