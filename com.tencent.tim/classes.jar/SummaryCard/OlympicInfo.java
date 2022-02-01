package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OlympicInfo
  extends JceStruct
{
  public int iTorch;
  
  public OlympicInfo() {}
  
  public OlympicInfo(int paramInt)
  {
    this.iTorch = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTorch = paramJceInputStream.read(this.iTorch, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTorch, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.OlympicInfo
 * JD-Core Version:    0.7.0.1
 */