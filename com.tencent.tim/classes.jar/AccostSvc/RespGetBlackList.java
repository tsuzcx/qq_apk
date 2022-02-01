package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetBlackList
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList<BlackSimpleInfo> cache_vBlackList;
  static ArrayList<Long> cache_vBlackListUin;
  static ArrayList<Long> cache_vMobileBlackListUin;
  public long lNextMid = -1L;
  public RespHeader stHeader;
  public ArrayList<BlackSimpleInfo> vBlackList;
  public ArrayList<Long> vBlackListUin;
  public ArrayList<Long> vMobileBlackListUin;
  
  public RespGetBlackList() {}
  
  public RespGetBlackList(RespHeader paramRespHeader, long paramLong, ArrayList<BlackSimpleInfo> paramArrayList, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2)
  {
    this.stHeader = paramRespHeader;
    this.lNextMid = paramLong;
    this.vBlackList = paramArrayList;
    this.vBlackListUin = paramArrayList1;
    this.vMobileBlackListUin = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 1, true);
    if (cache_vBlackList == null)
    {
      cache_vBlackList = new ArrayList();
      BlackSimpleInfo localBlackSimpleInfo = new BlackSimpleInfo();
      cache_vBlackList.add(localBlackSimpleInfo);
    }
    this.vBlackList = ((ArrayList)paramJceInputStream.read(cache_vBlackList, 2, false));
    if (cache_vBlackListUin == null)
    {
      cache_vBlackListUin = new ArrayList();
      cache_vBlackListUin.add(Long.valueOf(0L));
    }
    this.vBlackListUin = ((ArrayList)paramJceInputStream.read(cache_vBlackListUin, 3, false));
    if (cache_vMobileBlackListUin == null)
    {
      cache_vMobileBlackListUin = new ArrayList();
      cache_vMobileBlackListUin.add(Long.valueOf(0L));
    }
    this.vMobileBlackListUin = ((ArrayList)paramJceInputStream.read(cache_vMobileBlackListUin, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lNextMid, 1);
    if (this.vBlackList != null) {
      paramJceOutputStream.write(this.vBlackList, 2);
    }
    if (this.vBlackListUin != null) {
      paramJceOutputStream.write(this.vBlackListUin, 3);
    }
    if (this.vMobileBlackListUin != null) {
      paramJceOutputStream.write(this.vMobileBlackListUin, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     AccostSvc.RespGetBlackList
 * JD-Core Version:    0.7.0.1
 */