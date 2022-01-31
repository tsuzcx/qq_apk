package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFavoriteGroup
  extends JceStruct
{
  public long dwGroupCode = 0L;
  public long dwTimestamp = 0L;
  
  public stFavoriteGroup() {}
  
  public stFavoriteGroup(long paramLong1, long paramLong2)
  {
    this.dwGroupCode = paramLong1;
    this.dwTimestamp = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupCode, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.stFavoriteGroup
 * JD-Core Version:    0.7.0.1
 */