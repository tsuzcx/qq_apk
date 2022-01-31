package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkContentBox
  extends JceStruct
{
  public String sColour = "";
  public String sContentBoxType = "";
  public String sExt = "";
  public String sMsg = "";
  
  public MarkContentBox() {}
  
  public MarkContentBox(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sContentBoxType = paramString1;
    this.sColour = paramString2;
    this.sMsg = paramString3;
    this.sExt = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sContentBoxType = paramJceInputStream.readString(0, true);
    this.sColour = paramJceInputStream.readString(1, true);
    this.sMsg = paramJceInputStream.readString(2, false);
    this.sExt = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sContentBoxType, 0);
    paramJceOutputStream.write(this.sColour, 1);
    if (this.sMsg != null) {
      paramJceOutputStream.write(this.sMsg, 2);
    }
    if (this.sExt != null) {
      paramJceOutputStream.write(this.sExt, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.MarkContentBox
 * JD-Core Version:    0.7.0.1
 */