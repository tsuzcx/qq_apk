package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespPushMsg
  extends JceStruct
{
  static ArrayList cache_vDelInfos;
  public long lUin = 0L;
  public int svrip = 0;
  public ArrayList vDelInfos = null;
  
  public SvcRespPushMsg() {}
  
  public SvcRespPushMsg(long paramLong, ArrayList paramArrayList, int paramInt)
  {
    this.lUin = paramLong;
    this.vDelInfos = paramArrayList;
    this.svrip = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vDelInfos == null)
    {
      cache_vDelInfos = new ArrayList();
      DelMsgInfo localDelMsgInfo = new DelMsgInfo();
      cache_vDelInfos.add(localDelMsgInfo);
    }
    this.vDelInfos = ((ArrayList)paramJceInputStream.read(cache_vDelInfos, 1, true));
    this.svrip = paramJceInputStream.read(this.svrip, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vDelInfos, 1);
    paramJceOutputStream.write(this.svrip, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     OnlinePushPack.SvcRespPushMsg
 * JD-Core Version:    0.7.0.1
 */