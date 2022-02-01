package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_comm_mall
  extends JceStruct
{
  static byte[] cache_busi_buff = (byte[])new byte[1];
  public byte[] busi_buff;
  
  static
  {
    ((byte[])cache_busi_buff)[0] = 0;
  }
  
  public cell_comm_mall() {}
  
  public cell_comm_mall(byte[] paramArrayOfByte)
  {
    this.busi_buff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_buff = ((byte[])paramJceInputStream.read(cache_busi_buff, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_buff != null) {
      paramJceOutputStream.write(this.busi_buff, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comm_mall
 * JD-Core Version:    0.7.0.1
 */