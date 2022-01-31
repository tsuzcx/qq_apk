package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespUserInfo
  extends JceStruct
{
  static ArrayList cache_stInfos;
  public byte result = 0;
  public ArrayList stInfos = null;
  public long uin = 0L;
  
  public SvcRespUserInfo() {}
  
  public SvcRespUserInfo(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.result = paramByte;
    this.stInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_stInfos == null)
    {
      cache_stInfos = new ArrayList();
      MsfOnlineInfo localMsfOnlineInfo = new MsfOnlineInfo();
      cache_stInfos.add(localMsfOnlineInfo);
    }
    this.stInfos = ((ArrayList)paramJceInputStream.read(cache_stInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.result, 1);
    if (this.stInfos != null) {
      paramJceOutputStream.write(this.stInfos, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespUserInfo
 * JD-Core Version:    0.7.0.1
 */