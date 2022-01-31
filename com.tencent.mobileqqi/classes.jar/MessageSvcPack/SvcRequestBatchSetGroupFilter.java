package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestBatchSetGroupFilter
  extends JceStruct
{
  static ArrayList cache_vGroupFilterInfo;
  public byte cVerifyType = 0;
  public long lUin = 0L;
  public ArrayList vGroupFilterInfo = null;
  
  public SvcRequestBatchSetGroupFilter() {}
  
  public SvcRequestBatchSetGroupFilter(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.lUin = paramLong;
    this.cVerifyType = paramByte;
    this.vGroupFilterInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    if (cache_vGroupFilterInfo == null)
    {
      cache_vGroupFilterInfo = new ArrayList();
      GroupFilterInfo localGroupFilterInfo = new GroupFilterInfo();
      cache_vGroupFilterInfo.add(localGroupFilterInfo);
    }
    this.vGroupFilterInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupFilterInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.vGroupFilterInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestBatchSetGroupFilter
 * JD-Core Version:    0.7.0.1
 */