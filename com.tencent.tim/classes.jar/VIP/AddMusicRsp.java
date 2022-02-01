package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddMusicRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  public CommRsp errInfo;
  
  public AddMusicRsp() {}
  
  public AddMusicRsp(CommRsp paramCommRsp)
  {
    this.errInfo = paramCommRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.errInfo != null) {
      paramJceOutputStream.write(this.errInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.AddMusicRsp
 * JD-Core Version:    0.7.0.1
 */