package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SDKConfRes
  extends JceStruct
{
  public int iEspConfTime = 0;
  public int iGetSdkNewTime = 0;
  public int iNewConfVersion = 0;
  public int iUpdateType = 0;
  public String sConf = "";
  public String sEspConf = "";
  
  public SDKConfRes() {}
  
  public SDKConfRes(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    this.iUpdateType = paramInt1;
    this.iGetSdkNewTime = paramInt2;
    this.iNewConfVersion = paramInt3;
    this.sConf = paramString1;
    this.iEspConfTime = paramInt4;
    this.sEspConf = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUpdateType = paramJceInputStream.read(this.iUpdateType, 1, true);
    this.iGetSdkNewTime = paramJceInputStream.read(this.iGetSdkNewTime, 2, false);
    this.iNewConfVersion = paramJceInputStream.read(this.iNewConfVersion, 3, false);
    this.sConf = paramJceInputStream.readString(4, false);
    this.iEspConfTime = paramJceInputStream.read(this.iEspConfTime, 5, false);
    this.sEspConf = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUpdateType, 1);
    paramJceOutputStream.write(this.iGetSdkNewTime, 2);
    paramJceOutputStream.write(this.iNewConfVersion, 3);
    if (this.sConf != null) {
      paramJceOutputStream.write(this.sConf, 4);
    }
    paramJceOutputStream.write(this.iEspConfTime, 5);
    if (this.sEspConf != null) {
      paramJceOutputStream.write(this.sEspConf, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.SDKConfRes
 * JD-Core Version:    0.7.0.1
 */