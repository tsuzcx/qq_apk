package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TPraiseInfo
  extends JceStruct
{
  public int iIsPayed;
  public long uCustomId;
  
  public TPraiseInfo() {}
  
  public TPraiseInfo(long paramLong, int paramInt)
  {
    this.uCustomId = paramLong;
    this.iIsPayed = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCustomId = paramJceInputStream.read(this.uCustomId, 0, false);
    this.iIsPayed = paramJceInputStream.read(this.iIsPayed, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCustomId, 0);
    paramJceOutputStream.write(this.iIsPayed, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.TPraiseInfo
 * JD-Core Version:    0.7.0.1
 */