package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponseTransFile
  extends JceStruct
{
  public byte cReplyCode = 0;
  public String strResult = "";
  
  public SvcResponseTransFile() {}
  
  public SvcResponseTransFile(byte paramByte, String paramString)
  {
    this.cReplyCode = paramByte;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseTransFile
 * JD-Core Version:    0.7.0.1
 */