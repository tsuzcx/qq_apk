package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetWmxjApkRsp
  extends JceStruct
{
  public String apkUrl = "";
  public int apkVersion = 0;
  
  public stGetWmxjApkRsp() {}
  
  public stGetWmxjApkRsp(String paramString, int paramInt)
  {
    this.apkUrl = paramString;
    this.apkVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.apkUrl = paramJceInputStream.readString(0, true);
    this.apkVersion = paramJceInputStream.read(this.apkVersion, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.apkUrl, 0);
    paramJceOutputStream.write(this.apkVersion, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     AndroidClientInterface.stGetWmxjApkRsp
 * JD-Core Version:    0.7.0.1
 */