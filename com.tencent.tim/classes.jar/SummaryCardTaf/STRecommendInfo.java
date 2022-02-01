package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class STRecommendInfo
  extends JceStruct
{
  public long iRecomCard;
  public String strDesc = "";
  public String strRecomUrl = "";
  
  public STRecommendInfo() {}
  
  public STRecommendInfo(long paramLong, String paramString1, String paramString2)
  {
    this.iRecomCard = paramLong;
    this.strRecomUrl = paramString1;
    this.strDesc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRecomCard = paramJceInputStream.read(this.iRecomCard, 1, false);
    this.strRecomUrl = paramJceInputStream.readString(2, false);
    this.strDesc = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRecomCard, 1);
    if (this.strRecomUrl != null) {
      paramJceOutputStream.write(this.strRecomUrl, 2);
    }
    if (this.strDesc != null) {
      paramJceOutputStream.write(this.strDesc, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCardTaf.STRecommendInfo
 * JD-Core Version:    0.7.0.1
 */