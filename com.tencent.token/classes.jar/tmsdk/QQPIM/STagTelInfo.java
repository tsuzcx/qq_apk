package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class STagTelInfo
  extends JceStruct
{
  public String comment = "";
  public String phoneName = "";
  public String phoneNum = "";
  public int tagCount = 0;
  public int tagType = 0;
  
  public STagTelInfo() {}
  
  public STagTelInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.phoneNum = paramString1;
    this.tagType = paramInt1;
    this.tagCount = paramInt2;
    this.phoneName = paramString2;
    this.comment = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.phoneNum = paramJceInputStream.readString(1, true);
    this.tagType = paramJceInputStream.read(this.tagType, 2, true);
    this.tagCount = paramJceInputStream.read(this.tagCount, 3, true);
    this.phoneName = paramJceInputStream.readString(4, false);
    this.comment = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phoneNum, 1);
    paramJceOutputStream.write(this.tagType, 2);
    paramJceOutputStream.write(this.tagCount, 3);
    String str = this.phoneName;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.comment;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STagTelInfo
 * JD-Core Version:    0.7.0.1
 */