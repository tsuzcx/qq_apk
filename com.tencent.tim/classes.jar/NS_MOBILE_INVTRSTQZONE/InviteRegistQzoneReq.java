package NS_MOBILE_INVTRSTQZONE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InviteRegistQzoneReq
  extends JceStruct
{
  public long iHostUin;
  public long iInviteUin;
  
  public InviteRegistQzoneReq() {}
  
  public InviteRegistQzoneReq(long paramLong1, long paramLong2)
  {
    this.iHostUin = paramLong1;
    this.iInviteUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iHostUin = paramJceInputStream.read(this.iHostUin, 0, true);
    this.iInviteUin = paramJceInputStream.read(this.iInviteUin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iHostUin, 0);
    paramJceOutputStream.write(this.iInviteUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_INVTRSTQZONE.InviteRegistQzoneReq
 * JD-Core Version:    0.7.0.1
 */