package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqDownUrl
  extends JceStruct
{
  static ReqHeader cache_stReqHeader;
  public ReqHeader stReqHeader = null;
  public String strFileName = "";
  public int uUploadTime = 0;
  
  public ReqDownUrl() {}
  
  public ReqDownUrl(ReqHeader paramReqHeader, String paramString, int paramInt)
  {
    this.stReqHeader = paramReqHeader;
    this.strFileName = paramString;
    this.uUploadTime = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stReqHeader == null) {
      cache_stReqHeader = new ReqHeader();
    }
    this.stReqHeader = ((ReqHeader)paramJceInputStream.read(cache_stReqHeader, 0, true));
    this.strFileName = paramJceInputStream.readString(1, true);
    this.uUploadTime = paramJceInputStream.read(this.uUploadTime, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stReqHeader, 0);
    paramJceOutputStream.write(this.strFileName, 1);
    paramJceOutputStream.write(this.uUploadTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GroupPic.ReqDownUrl
 * JD-Core Version:    0.7.0.1
 */