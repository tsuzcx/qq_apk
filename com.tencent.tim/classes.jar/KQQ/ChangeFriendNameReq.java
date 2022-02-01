package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ChangeFriendNameReq
  extends JceStruct
{
  public String cstrName = "";
  public long uFriendUin;
  
  public ChangeFriendNameReq() {}
  
  public ChangeFriendNameReq(long paramLong, String paramString)
  {
    this.uFriendUin = paramLong;
    this.cstrName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 0, true);
    this.cstrName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFriendUin, 0);
    paramJceOutputStream.write(this.cstrName, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.ChangeFriendNameReq
 * JD-Core Version:    0.7.0.1
 */