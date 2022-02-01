package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_arkshare
  extends JceStruct
{
  public String ark_content = "";
  public String ark_id = "";
  public String view_id = "";
  
  public s_arkshare() {}
  
  public s_arkshare(String paramString1, String paramString2, String paramString3)
  {
    this.ark_id = paramString1;
    this.view_id = paramString2;
    this.ark_content = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ark_id = paramJceInputStream.readString(0, false);
    this.view_id = paramJceInputStream.readString(1, false);
    this.ark_content = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ark_id != null) {
      paramJceOutputStream.write(this.ark_id, 0);
    }
    if (this.view_id != null) {
      paramJceOutputStream.write(this.view_id, 1);
    }
    if (this.ark_content != null) {
      paramJceOutputStream.write(this.ark_content, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.s_arkshare
 * JD-Core Version:    0.7.0.1
 */