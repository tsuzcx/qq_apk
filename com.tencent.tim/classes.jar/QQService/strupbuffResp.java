package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class strupbuffResp
  extends JceStruct
{
  public int seqno;
  
  public strupbuffResp() {}
  
  public strupbuffResp(int paramInt)
  {
    this.seqno = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seqno = paramJceInputStream.read(this.seqno, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqno, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.strupbuffResp
 * JD-Core Version:    0.7.0.1
 */