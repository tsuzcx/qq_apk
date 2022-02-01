package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cardDiyComplicatedInfo
  extends JceStruct
{
  public String detail = "";
  
  public cardDiyComplicatedInfo() {}
  
  public cardDiyComplicatedInfo(String paramString)
  {
    this.detail = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.detail = paramJceInputStream.readString(0, false);
  }
  
  public String toString()
  {
    return this.detail;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail != null) {
      paramJceOutputStream.write(this.detail, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCardTaf.cardDiyComplicatedInfo
 * JD-Core Version:    0.7.0.1
 */