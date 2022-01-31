package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TagInfo
  extends JceStruct
{
  public byte bType = 0;
  public long iTagId = 0L;
  public String strContent = "";
  
  public TagInfo() {}
  
  public TagInfo(byte paramByte, long paramLong, String paramString)
  {
    this.bType = paramByte;
    this.iTagId = paramLong;
    this.strContent = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bType = paramJceInputStream.read(this.bType, 0, true);
    this.iTagId = paramJceInputStream.read(this.iTagId, 1, true);
    this.strContent = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bType, 0);
    paramJceOutputStream.write(this.iTagId, 1);
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.TagInfo
 * JD-Core Version:    0.7.0.1
 */