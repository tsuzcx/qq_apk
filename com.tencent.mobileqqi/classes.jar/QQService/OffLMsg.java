package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OffLMsg
  extends JceStruct
{
  static GrpMsg cache_stMsg;
  public GrpMsg stMsg = null;
  
  public OffLMsg() {}
  
  public OffLMsg(GrpMsg paramGrpMsg)
  {
    this.stMsg = paramGrpMsg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stMsg == null) {
      cache_stMsg = new GrpMsg();
    }
    this.stMsg = ((GrpMsg)paramJceInputStream.read(cache_stMsg, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stMsg, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.OffLMsg
 * JD-Core Version:    0.7.0.1
 */