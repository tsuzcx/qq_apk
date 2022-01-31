package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqIncreaseVisitor
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public ReqHead stHeader = null;
  
  public ReqIncreaseVisitor() {}
  
  public ReqIncreaseVisitor(ReqHead paramReqHead)
  {
    this.stHeader = paramReqHead;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqIncreaseVisitor
 * JD-Core Version:    0.7.0.1
 */