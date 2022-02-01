package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public int faceID;
  public LoginInfo stLogin;
  
  public FaceReq() {}
  
  public FaceReq(LoginInfo paramLoginInfo, int paramInt)
  {
    this.stLogin = paramLoginInfo;
    this.faceID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.faceID = paramJceInputStream.read(this.faceID, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    paramJceOutputStream.write(this.faceID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.FaceReq
 * JD-Core Version:    0.7.0.1
 */