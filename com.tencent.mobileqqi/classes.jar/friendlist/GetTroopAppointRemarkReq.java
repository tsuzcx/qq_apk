package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopAppointRemarkReq
  extends JceStruct
{
  static ArrayList cache_vecUinList;
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public byte cRichInfo = 0;
  public long uin = 0L;
  public ArrayList vecUinList = null;
  
  public GetTroopAppointRemarkReq() {}
  
  public GetTroopAppointRemarkReq(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, byte paramByte)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.vecUinList = paramArrayList;
    this.cRichInfo = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 3, true);
    if (cache_vecUinList == null)
    {
      cache_vecUinList = new ArrayList();
      cache_vecUinList.add(Long.valueOf(0L));
    }
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 4, true));
    this.cRichInfo = paramJceInputStream.read(this.cRichInfo, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 3);
    paramJceOutputStream.write(this.vecUinList, 4);
    paramJceOutputStream.write(this.cRichInfo, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetTroopAppointRemarkReq
 * JD-Core Version:    0.7.0.1
 */