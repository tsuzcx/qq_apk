package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespRedirect
  extends JceStruct
{
  static RespHeader cache_stRespHeader;
  static ArrayList cache_vHostList;
  public byte cExist = 0;
  public int iFileId = 0;
  public RespHeader stRespHeader = null;
  public ArrayList vHostList = null;
  
  public RespRedirect() {}
  
  public RespRedirect(RespHeader paramRespHeader, ArrayList paramArrayList, byte paramByte, int paramInt)
  {
    this.stRespHeader = paramRespHeader;
    this.vHostList = paramArrayList;
    this.cExist = paramByte;
    this.iFileId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stRespHeader == null) {
      cache_stRespHeader = new RespHeader();
    }
    this.stRespHeader = ((RespHeader)paramJceInputStream.read(cache_stRespHeader, 0, true));
    if (cache_vHostList == null)
    {
      cache_vHostList = new ArrayList();
      HostInfo localHostInfo = new HostInfo();
      cache_vHostList.add(localHostInfo);
    }
    this.vHostList = ((ArrayList)paramJceInputStream.read(cache_vHostList, 1, true));
    this.cExist = paramJceInputStream.read(this.cExist, 2, true);
    this.iFileId = paramJceInputStream.read(this.iFileId, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stRespHeader, 0);
    paramJceOutputStream.write(this.vHostList, 1);
    paramJceOutputStream.write(this.cExist, 2);
    paramJceOutputStream.write(this.iFileId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     GroupPic.RespRedirect
 * JD-Core Version:    0.7.0.1
 */