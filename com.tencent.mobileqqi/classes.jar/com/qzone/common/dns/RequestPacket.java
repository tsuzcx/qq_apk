package com.qzone.common.dns;

public class RequestPacket
{
  private static byte[] header;
  private static byte[] question;
  private String domain;
  private int reqId;
  
  static
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[2] = 1;
    arrayOfByte[5] = 1;
    header = arrayOfByte;
    arrayOfByte = new byte[5];
    arrayOfByte[2] = 1;
    arrayOfByte[4] = 1;
    question = arrayOfByte;
  }
  
  public RequestPacket(String paramString)
  {
    this.domain = paramString;
    this.reqId = AtomicRequestId.getInstance().getId();
  }
  
  private void warpReqId(byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(this.reqId >>> 8 & 0xFF));
    paramArrayOfByte[1] = ((byte)(this.reqId & 0xFF));
  }
  
  public byte[] getQueryData()
  {
    if (this.domain == null) {}
    do
    {
      return null;
      this.domain = this.domain.trim().toLowerCase();
    } while (this.domain.length() == 0);
    byte[] arrayOfByte1 = new byte[header.length + question.length + this.domain.length() + 1];
    String[] arrayOfString = this.domain.split("\\.");
    int j = header.length;
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length)
      {
        System.arraycopy(header, 0, arrayOfByte1, 0, header.length);
        System.arraycopy(question, 0, arrayOfByte1, j, question.length);
        warpReqId(arrayOfByte1);
        return arrayOfByte1;
      }
      arrayOfByte1[j] = ((byte)arrayOfString[i].length());
      j += 1;
      byte[] arrayOfByte2 = arrayOfString[i].getBytes();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
  }
  
  public int getReqId()
  {
    return this.reqId;
  }
  
  public int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.dns.RequestPacket
 * JD-Core Version:    0.7.0.1
 */