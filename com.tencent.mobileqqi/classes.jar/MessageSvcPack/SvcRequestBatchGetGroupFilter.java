package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestBatchGetGroupFilter
  extends JceStruct
{
  static ArrayList cache_vGroupCode;
  public byte cVerifyType = 0;
  public long lUin = 0L;
  public ArrayList vGroupCode = null;
  
  public SvcRequestBatchGetGroupFilter() {}
  
  public SvcRequestBatchGetGroupFilter(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.lUin = paramLong;
    this.cVerifyType = paramByte;
    this.vGroupCode = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, true);
    if (cache_vGroupCode == null)
    {
      cache_vGroupCode = new ArrayList();
      cache_vGroupCode.add(Long.valueOf(0L));
    }
    this.vGroupCode = ((ArrayList)paramJceInputStream.read(cache_vGroupCode, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.vGroupCode, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestBatchGetGroupFilter
 * JD-Core Version:    0.7.0.1
 */