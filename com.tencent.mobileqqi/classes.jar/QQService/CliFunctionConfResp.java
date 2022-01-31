package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CliFunctionConfResp
  extends JceStruct
{
  static ArrayList cache_vFuncInfo;
  public int iResultCode = 0;
  public ArrayList vFuncInfo = null;
  
  public CliFunctionConfResp() {}
  
  public CliFunctionConfResp(int paramInt, ArrayList paramArrayList)
  {
    this.iResultCode = paramInt;
    this.vFuncInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResultCode = paramJceInputStream.read(this.iResultCode, 1, true);
    if (cache_vFuncInfo == null)
    {
      cache_vFuncInfo = new ArrayList();
      FuncInfo localFuncInfo = new FuncInfo();
      cache_vFuncInfo.add(localFuncInfo);
    }
    this.vFuncInfo = ((ArrayList)paramJceInputStream.read(cache_vFuncInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResultCode, 1);
    paramJceOutputStream.write(this.vFuncInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.CliFunctionConfResp
 * JD-Core Version:    0.7.0.1
 */