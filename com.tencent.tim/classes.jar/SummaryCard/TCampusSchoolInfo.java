package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TCampusSchoolInfo
  extends JceStruct
{
  public int iIsValidForCertified;
  public long uSchoolId;
  public long uTimestamp;
  
  public TCampusSchoolInfo() {}
  
  public TCampusSchoolInfo(long paramLong1, long paramLong2, int paramInt)
  {
    this.uTimestamp = paramLong1;
    this.uSchoolId = paramLong2;
    this.iIsValidForCertified = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTimestamp = paramJceInputStream.read(this.uTimestamp, 0, false);
    this.uSchoolId = paramJceInputStream.read(this.uSchoolId, 1, false);
    this.iIsValidForCertified = paramJceInputStream.read(this.iIsValidForCertified, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTimestamp, 0);
    paramJceOutputStream.write(this.uSchoolId, 1);
    paramJceOutputStream.write(this.iIsValidForCertified, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.TCampusSchoolInfo
 * JD-Core Version:    0.7.0.1
 */