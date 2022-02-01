package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetFontBubbleReq
  extends JceStruct
{
  static BubbleReq cache_stBubbleReq = new BubbleReq();
  static FontReq cache_stFontReq;
  static LoginInfo cache_stLogin = new LoginInfo();
  public BubbleReq stBubbleReq;
  public FontReq stFontReq;
  public LoginInfo stLogin;
  
  static
  {
    cache_stFontReq = new FontReq();
  }
  
  public SetFontBubbleReq() {}
  
  public SetFontBubbleReq(LoginInfo paramLoginInfo, FontReq paramFontReq, BubbleReq paramBubbleReq)
  {
    this.stLogin = paramLoginInfo;
    this.stFontReq = paramFontReq;
    this.stBubbleReq = paramBubbleReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.stFontReq = ((FontReq)paramJceInputStream.read(cache_stFontReq, 1, false));
    this.stBubbleReq = ((BubbleReq)paramJceInputStream.read(cache_stBubbleReq, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    if (this.stFontReq != null) {
      paramJceOutputStream.write(this.stFontReq, 1);
    }
    if (this.stBubbleReq != null) {
      paramJceOutputStream.write(this.stBubbleReq, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.SetFontBubbleReq
 * JD-Core Version:    0.7.0.1
 */