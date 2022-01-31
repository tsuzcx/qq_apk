package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespDownPicUrl
  extends JceStruct
{
  static RespHeader cache_stRespHeader;
  static ArrayList cache_vSvrList;
  public RespHeader stRespHeader = null;
  public String strBigUrl = "";
  public String strSrcUrl = "";
  public String strThumbnailUrl = "";
  public ArrayList vSvrList = null;
  
  public RespDownPicUrl() {}
  
  public RespDownPicUrl(RespHeader paramRespHeader, String paramString1, String paramString2, String paramString3, ArrayList paramArrayList)
  {
    this.stRespHeader = paramRespHeader;
    this.strThumbnailUrl = paramString1;
    this.strBigUrl = paramString2;
    this.strSrcUrl = paramString3;
    this.vSvrList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stRespHeader == null) {
      cache_stRespHeader = new RespHeader();
    }
    this.stRespHeader = ((RespHeader)paramJceInputStream.read(cache_stRespHeader, 0, true));
    this.strThumbnailUrl = paramJceInputStream.readString(1, true);
    this.strBigUrl = paramJceInputStream.readString(2, true);
    this.strSrcUrl = paramJceInputStream.readString(3, true);
    if (cache_vSvrList == null)
    {
      cache_vSvrList = new ArrayList();
      ServerListInfo localServerListInfo = new ServerListInfo();
      cache_vSvrList.add(localServerListInfo);
    }
    this.vSvrList = ((ArrayList)paramJceInputStream.read(cache_vSvrList, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stRespHeader, 0);
    paramJceOutputStream.write(this.strThumbnailUrl, 1);
    paramJceOutputStream.write(this.strBigUrl, 2);
    paramJceOutputStream.write(this.strSrcUrl, 3);
    paramJceOutputStream.write(this.vSvrList, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GroupPic.RespDownPicUrl
 * JD-Core Version:    0.7.0.1
 */