package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetServerListRes
  extends JceStruct
{
  static ArrayList cache_vServerListInfo;
  public int iResult = 0;
  public int iTime = 0;
  public ArrayList vServerListInfo = null;
  
  public GetServerListRes() {}
  
  public GetServerListRes(int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    this.iResult = paramInt1;
    this.vServerListInfo = paramArrayList;
    this.iTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    if (cache_vServerListInfo == null)
    {
      cache_vServerListInfo = new ArrayList();
      MeasureInfo localMeasureInfo = new MeasureInfo();
      cache_vServerListInfo.add(localMeasureInfo);
    }
    this.vServerListInfo = ((ArrayList)paramJceInputStream.read(cache_vServerListInfo, 2, true));
    this.iTime = paramJceInputStream.read(this.iTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.vServerListInfo, 2);
    paramJceOutputStream.write(this.iTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.GetServerListRes
 * JD-Core Version:    0.7.0.1
 */