package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespDownUrl
  extends JceStruct
{
  static RespHeader cache_stRespHeader;
  static ArrayList cache_vGpttDownSvrList;
  public byte fileType = 0;
  public RespHeader stRespHeader = null;
  public String strUrl = "";
  public ArrayList vGpttDownSvrList = null;
  
  public RespDownUrl() {}
  
  public RespDownUrl(RespHeader paramRespHeader, String paramString, byte paramByte, ArrayList paramArrayList)
  {
    this.stRespHeader = paramRespHeader;
    this.strUrl = paramString;
    this.fileType = paramByte;
    this.vGpttDownSvrList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stRespHeader == null) {
      cache_stRespHeader = new RespHeader();
    }
    this.stRespHeader = ((RespHeader)paramJceInputStream.read(cache_stRespHeader, 0, true));
    this.strUrl = paramJceInputStream.readString(1, true);
    this.fileType = paramJceInputStream.read(this.fileType, 2, false);
    if (cache_vGpttDownSvrList == null)
    {
      cache_vGpttDownSvrList = new ArrayList();
      ServerListInfo localServerListInfo = new ServerListInfo();
      cache_vGpttDownSvrList.add(localServerListInfo);
    }
    this.vGpttDownSvrList = ((ArrayList)paramJceInputStream.read(cache_vGpttDownSvrList, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stRespHeader, 0);
    paramJceOutputStream.write(this.strUrl, 1);
    paramJceOutputStream.write(this.fileType, 2);
    if (this.vGpttDownSvrList != null) {
      paramJceOutputStream.write(this.vGpttDownSvrList, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     GroupPic.RespDownUrl
 * JD-Core Version:    0.7.0.1
 */