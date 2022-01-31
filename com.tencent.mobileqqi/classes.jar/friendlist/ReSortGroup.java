package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReSortGroup
  extends JceStruct
{
  static byte[] cache_cGroupId;
  static byte[] cache_cSortId;
  public byte[] cGroupId = null;
  public byte cNum = 0;
  public byte[] cSortId = null;
  
  public ReSortGroup() {}
  
  public ReSortGroup(byte paramByte, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.cNum = paramByte;
    this.cGroupId = paramArrayOfByte1;
    this.cSortId = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cNum = paramJceInputStream.read(this.cNum, 0, true);
    if (cache_cGroupId == null)
    {
      cache_cGroupId = (byte[])new byte[1];
      ((byte[])cache_cGroupId)[0] = 0;
    }
    this.cGroupId = ((byte[])paramJceInputStream.read(cache_cGroupId, 1, true));
    if (cache_cSortId == null)
    {
      cache_cSortId = (byte[])new byte[1];
      ((byte[])cache_cSortId)[0] = 0;
    }
    this.cSortId = ((byte[])paramJceInputStream.read(cache_cSortId, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cNum, 0);
    paramJceOutputStream.write(this.cGroupId, 1);
    paramJceOutputStream.write(this.cSortId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.ReSortGroup
 * JD-Core Version:    0.7.0.1
 */