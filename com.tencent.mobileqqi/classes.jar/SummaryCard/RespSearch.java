package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespSearch
  extends JceStruct
{
  static ArrayList cache_vRecords;
  static byte[] cache_vSecureSig;
  public ArrayList vRecords = null;
  public byte[] vSecureSig = null;
  
  public RespSearch() {}
  
  public RespSearch(ArrayList paramArrayList, byte[] paramArrayOfByte)
  {
    this.vRecords = paramArrayList;
    this.vSecureSig = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vRecords == null)
    {
      cache_vRecords = new ArrayList();
      SearchInfo localSearchInfo = new SearchInfo();
      cache_vRecords.add(localSearchInfo);
    }
    this.vRecords = ((ArrayList)paramJceInputStream.read(cache_vRecords, 0, true));
    if (cache_vSecureSig == null)
    {
      cache_vSecureSig = (byte[])new byte[1];
      ((byte[])cache_vSecureSig)[0] = 0;
    }
    this.vSecureSig = ((byte[])paramJceInputStream.read(cache_vSecureSig, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vRecords, 0);
    if (this.vSecureSig != null) {
      paramJceOutputStream.write(this.vSecureSig, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SummaryCard.RespSearch
 * JD-Core Version:    0.7.0.1
 */