package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespHeader
  extends JceStruct
{
  public int Result = 0;
  public String ResultDesc = "";
  
  public RespHeader() {}
  
  public RespHeader(int paramInt, String paramString)
  {
    this.Result = paramInt;
    this.ResultDesc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, true);
    this.ResultDesc = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
    if (this.ResultDesc != null) {
      paramJceOutputStream.write(this.ResultDesc, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GeneralSettings.RespHeader
 * JD-Core Version:    0.7.0.1
 */