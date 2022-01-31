package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UinPairMsg
  extends JceStruct
{
  static ArrayList cache_vMsgInfos;
  public long lPeerUin = 0L;
  public long uLastReadTime = 0L;
  public long uMsgCompleted = 0L;
  public ArrayList vMsgInfos = null;
  
  public UinPairMsg() {}
  
  public UinPairMsg(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList)
  {
    this.uLastReadTime = paramLong1;
    this.lPeerUin = paramLong2;
    this.uMsgCompleted = paramLong3;
    this.vMsgInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uLastReadTime = paramJceInputStream.read(this.uLastReadTime, 1, false);
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 2, false);
    this.uMsgCompleted = paramJceInputStream.read(this.uMsgCompleted, 3, false);
    if (cache_vMsgInfos == null)
    {
      cache_vMsgInfos = new ArrayList();
      MsgInfo localMsgInfo = new MsgInfo();
      cache_vMsgInfos.add(localMsgInfo);
    }
    this.vMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vMsgInfos, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uLastReadTime, 1);
    paramJceOutputStream.write(this.lPeerUin, 2);
    paramJceOutputStream.write(this.uMsgCompleted, 3);
    if (this.vMsgInfos != null) {
      paramJceOutputStream.write(this.vMsgInfos, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     OnlinePushPack.UinPairMsg
 * JD-Core Version:    0.7.0.1
 */