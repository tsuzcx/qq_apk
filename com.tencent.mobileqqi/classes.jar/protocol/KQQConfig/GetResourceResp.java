package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceResp
  extends JceStruct
{
  static ArrayList cache_vecResRespInfo;
  public ArrayList vecResRespInfo = null;
  
  public GetResourceResp() {}
  
  public GetResourceResp(ArrayList paramArrayList)
  {
    this.vecResRespInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResRespInfo == null)
    {
      cache_vecResRespInfo = new ArrayList();
      GetResourceRespInfo localGetResourceRespInfo = new GetResourceRespInfo();
      cache_vecResRespInfo.add(localGetResourceRespInfo);
    }
    this.vecResRespInfo = ((ArrayList)paramJceInputStream.read(cache_vecResRespInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResRespInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceResp
 * JD-Core Version:    0.7.0.1
 */