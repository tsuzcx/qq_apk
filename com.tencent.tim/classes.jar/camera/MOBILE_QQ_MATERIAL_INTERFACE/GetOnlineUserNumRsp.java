package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineUserNumRsp
  extends JceStruct
{
  public int Code;
  public int OnlineUserNum;
  
  public GetOnlineUserNumRsp() {}
  
  public GetOnlineUserNumRsp(int paramInt1, int paramInt2)
  {
    this.Code = paramInt1;
    this.OnlineUserNum = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.OnlineUserNum = paramJceInputStream.read(this.OnlineUserNum, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    paramJceOutputStream.write(this.OnlineUserNum, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp
 * JD-Core Version:    0.7.0.1
 */