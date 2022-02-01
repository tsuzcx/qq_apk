package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BatchResponse
  extends JceStruct
{
  static byte[] cache_buffer;
  static int cache_type;
  public byte[] buffer;
  public int result;
  public int seq;
  public int type;
  
  public BatchResponse() {}
  
  public BatchResponse(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.type = paramInt1;
    this.seq = paramInt2;
    this.result = paramInt3;
    this.buffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.seq = paramJceInputStream.read(this.seq, 1, false);
    this.result = paramJceInputStream.read(this.result, 2, false);
    if (cache_buffer == null)
    {
      cache_buffer = (byte[])new byte[1];
      ((byte[])cache_buffer)[0] = 0;
    }
    this.buffer = ((byte[])paramJceInputStream.read(cache_buffer, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.seq, 1);
    paramJceOutputStream.write(this.result, 2);
    if (this.buffer != null) {
      paramJceOutputStream.write(this.buffer, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.BatchResponse
 * JD-Core Version:    0.7.0.1
 */