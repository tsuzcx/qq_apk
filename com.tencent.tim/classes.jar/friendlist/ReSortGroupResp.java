package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReSortGroupResp
  extends JceStruct
{
  public long dwSequence;
  public long dwToUin;
  
  public ReSortGroupResp() {}
  
  public ReSortGroupResp(long paramLong1, long paramLong2)
  {
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.ReSortGroupResp
 * JD-Core Version:    0.7.0.1
 */