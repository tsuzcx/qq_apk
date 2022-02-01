package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespondQueryIPwdStat
  extends JceStruct
{
  public long uIsSetPwd;
  
  public RespondQueryIPwdStat() {}
  
  public RespondQueryIPwdStat(long paramLong)
  {
    this.uIsSetPwd = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uIsSetPwd = paramJceInputStream.read(this.uIsSetPwd, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uIsSetPwd, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     IPwdPxyMQQ.RespondQueryIPwdStat
 * JD-Core Version:    0.7.0.1
 */