package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRspDelLoginInfo
  extends JceStruct
{
  public int iResult = 0;
  public String strResult = "";
  
  public SvcRspDelLoginInfo() {}
  
  public SvcRspDelLoginInfo(int paramInt, String paramString)
  {
    this.iResult = paramInt;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 0, true);
    this.strResult = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 0);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.SvcRspDelLoginInfo
 * JD-Core Version:    0.7.0.1
 */