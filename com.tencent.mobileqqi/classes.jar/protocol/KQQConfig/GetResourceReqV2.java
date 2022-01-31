package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceReqV2
  extends JceStruct
{
  static ArrayList cache_vecResReqInfo;
  public int iPluginType = 64;
  public ArrayList vecResReqInfo = null;
  
  public GetResourceReqV2() {}
  
  public GetResourceReqV2(ArrayList paramArrayList, int paramInt)
  {
    this.vecResReqInfo = paramArrayList;
    this.iPluginType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResReqInfo == null)
    {
      cache_vecResReqInfo = new ArrayList();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      cache_vecResReqInfo.add(localGetResourceReqInfoV2);
    }
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.iPluginType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReqV2
 * JD-Core Version:    0.7.0.1
 */