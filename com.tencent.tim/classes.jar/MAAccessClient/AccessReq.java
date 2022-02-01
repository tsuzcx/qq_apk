package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AccessReq
  extends JceStruct
{
  static byte[] cache_body = (byte[])new byte[1];
  public byte[] body;
  public int gray;
  public String imei = "";
  public String manufacture = "";
  public String mode = "";
  public int platform = 1;
  public String qimei = "";
  public String rom = "";
  
  static
  {
    ((byte[])cache_body)[0] = 0;
  }
  
  public AccessReq() {}
  
  public AccessReq(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this.imei = paramString1;
    this.mode = paramString2;
    this.manufacture = paramString3;
    this.rom = paramString4;
    this.gray = paramInt1;
    this.body = paramArrayOfByte;
    this.platform = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.mode = paramJceInputStream.readString(1, false);
    this.manufacture = paramJceInputStream.readString(2, false);
    this.rom = paramJceInputStream.readString(3, false);
    this.gray = paramJceInputStream.read(this.gray, 4, false);
    this.body = ((byte[])paramJceInputStream.read(cache_body, 5, false));
    this.qimei = paramJceInputStream.readString(6, false);
    this.platform = paramJceInputStream.read(this.platform, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.imei != null) {
      paramJceOutputStream.write(this.imei, 0);
    }
    if (this.mode != null) {
      paramJceOutputStream.write(this.mode, 1);
    }
    if (this.manufacture != null) {
      paramJceOutputStream.write(this.manufacture, 2);
    }
    if (this.rom != null) {
      paramJceOutputStream.write(this.rom, 3);
    }
    paramJceOutputStream.write(this.gray, 4);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 5);
    }
    if (this.qimei != null) {
      paramJceOutputStream.write(this.qimei, 6);
    }
    paramJceOutputStream.write(this.platform, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MAAccessClient.AccessReq
 * JD-Core Version:    0.7.0.1
 */