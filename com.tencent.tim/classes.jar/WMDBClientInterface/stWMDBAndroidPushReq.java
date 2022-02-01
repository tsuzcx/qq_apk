package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWMDBAndroidPushReq
  extends JceStruct
{
  public String city = "";
  public String province = "";
  public int pushVersion = 0;
  public int richFlagMask = 1;
  
  public stWMDBAndroidPushReq() {}
  
  public stWMDBAndroidPushReq(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.pushVersion = paramInt1;
    this.richFlagMask = paramInt2;
    this.province = paramString1;
    this.city = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pushVersion = paramJceInputStream.read(this.pushVersion, 0, true);
    this.richFlagMask = paramJceInputStream.read(this.richFlagMask, 1, true);
    this.province = paramJceInputStream.readString(2, false);
    this.city = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pushVersion, 0);
    paramJceOutputStream.write(this.richFlagMask, 1);
    if (this.province != null) {
      paramJceOutputStream.write(this.province, 2);
    }
    if (this.city != null) {
      paramJceOutputStream.write(this.city, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     WMDBClientInterface.stWMDBAndroidPushReq
 * JD-Core Version:    0.7.0.1
 */