package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class shareData
  extends JceStruct
{
  public String msgtail = "";
  public String picurl = "";
  public String pkgname = "";
  public String url = "";
  
  public shareData() {}
  
  public shareData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pkgname = paramString1;
    this.msgtail = paramString2;
    this.picurl = paramString3;
    this.url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgname = paramJceInputStream.readString(0, true);
    this.msgtail = paramJceInputStream.readString(1, true);
    this.picurl = paramJceInputStream.readString(2, true);
    this.url = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgname, 0);
    paramJceOutputStream.write(this.msgtail, 1);
    paramJceOutputStream.write(this.picurl, 2);
    paramJceOutputStream.write(this.url, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.shareData
 * JD-Core Version:    0.7.0.1
 */