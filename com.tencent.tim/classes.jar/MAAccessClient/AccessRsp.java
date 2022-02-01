package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AccessRsp
  extends JceStruct
{
  static byte[] cache_body = (byte[])new byte[1];
  static Tips cache_tips = new Tips();
  public byte[] body;
  public int ret;
  public Tips tips;
  
  static
  {
    ((byte[])cache_body)[0] = 0;
  }
  
  public AccessRsp() {}
  
  public AccessRsp(int paramInt, byte[] paramArrayOfByte, Tips paramTips)
  {
    this.ret = paramInt;
    this.body = paramArrayOfByte;
    this.tips = paramTips;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, true));
    this.tips = ((Tips)paramJceInputStream.read(cache_tips, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.body, 1);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MAAccessClient.AccessRsp
 * JD-Core Version:    0.7.0.1
 */