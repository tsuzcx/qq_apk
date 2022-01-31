package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSearch
  extends JceStruct
{
  public int shVersion = 0;
  public String strCountryCode = "";
  public String strKeyword = "";
  
  public ReqSearch() {}
  
  public ReqSearch(String paramString1, String paramString2, int paramInt)
  {
    this.strKeyword = paramString1;
    this.strCountryCode = paramString2;
    this.shVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strKeyword = paramJceInputStream.readString(0, true);
    this.strCountryCode = paramJceInputStream.readString(1, true);
    this.shVersion = paramJceInputStream.read(this.shVersion, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strKeyword, 0);
    paramJceOutputStream.write(this.strCountryCode, 1);
    paramJceOutputStream.write(this.shVersion, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SummaryCard.ReqSearch
 * JD-Core Version:    0.7.0.1
 */