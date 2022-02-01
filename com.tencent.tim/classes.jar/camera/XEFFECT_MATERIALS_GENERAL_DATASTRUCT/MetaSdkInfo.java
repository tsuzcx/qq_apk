package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MetaSdkInfo
  extends JceStruct
{
  public int sdk;
  public String sdkVersion = "";
  
  public MetaSdkInfo() {}
  
  public MetaSdkInfo(int paramInt, String paramString)
  {
    this.sdk = paramInt;
    this.sdkVersion = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sdk = paramJceInputStream.read(this.sdk, 0, false);
    this.sdkVersion = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sdk, 0);
    if (this.sdkVersion != null) {
      paramJceOutputStream.write(this.sdkVersion, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo
 * JD-Core Version:    0.7.0.1
 */