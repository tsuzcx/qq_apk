package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleRecommendReq
  extends JceStruct
{
  static LoginInfo cache_stLogin = new LoginInfo();
  public LoginInfo stLogin;
  
  public BubbleRecommendReq() {}
  
  public BubbleRecommendReq(LoginInfo paramLoginInfo)
  {
    this.stLogin = paramLoginInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.BubbleRecommendReq
 * JD-Core Version:    0.7.0.1
 */