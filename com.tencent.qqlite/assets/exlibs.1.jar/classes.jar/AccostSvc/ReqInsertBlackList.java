package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqInsertBlackList
  extends JceStruct
{
  static int cache_eType;
  static ReqHeader cache_stHeader;
  static ArrayList cache_vBlackList;
  public int eType = 0;
  public ReqHeader stHeader = null;
  public ArrayList vBlackList = null;
  
  public ReqInsertBlackList() {}
  
  public ReqInsertBlackList(ReqHeader paramReqHeader, ArrayList paramArrayList, int paramInt)
  {
    this.stHeader = paramReqHeader;
    this.vBlackList = paramArrayList;
    this.eType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_vBlackList == null)
    {
      cache_vBlackList = new ArrayList();
      cache_vBlackList.add(Long.valueOf(0L));
    }
    this.vBlackList = ((ArrayList)paramJceInputStream.read(cache_vBlackList, 1, true));
    this.eType = paramJceInputStream.read(this.eType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.vBlackList, 1);
    paramJceOutputStream.write(this.eType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AccostSvc.ReqInsertBlackList
 * JD-Core Version:    0.7.0.1
 */