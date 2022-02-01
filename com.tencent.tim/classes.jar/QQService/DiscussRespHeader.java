package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DiscussRespHeader
  extends JceStruct
{
  public int Result;
  public String ResultDesc = "";
  
  public DiscussRespHeader() {}
  
  public DiscussRespHeader(int paramInt, String paramString)
  {
    this.Result = paramInt;
    this.ResultDesc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, true);
    this.ResultDesc = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
    paramJceOutputStream.write(this.ResultDesc, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.DiscussRespHeader
 * JD-Core Version:    0.7.0.1
 */