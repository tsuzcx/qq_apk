package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CollectCouponRsp
  extends JceStruct
{
  public int ret_code = -1;
  public long sequence;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, true);
    this.sequence = paramJceInputStream.read(this.sequence, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    paramJceOutputStream.write(this.sequence, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QCARD.CollectCouponRsp
 * JD-Core Version:    0.7.0.1
 */