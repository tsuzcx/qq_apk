package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetLastLoginInfoResp
  extends JceStruct
{
  static int cache_result;
  static LastLoginPageInfo cache_stPageInfo;
  static ArrayList<LastLoginInfo> cache_vecLastLoginInfo;
  public short errorCode;
  public int iRefreshIntervalMin;
  public int result;
  public LastLoginPageInfo stPageInfo;
  public ArrayList<LastLoginInfo> vecLastLoginInfo;
  
  public GetLastLoginInfoResp() {}
  
  public GetLastLoginInfoResp(int paramInt1, short paramShort, LastLoginPageInfo paramLastLoginPageInfo, ArrayList<LastLoginInfo> paramArrayList, int paramInt2)
  {
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.stPageInfo = paramLastLoginPageInfo;
    this.vecLastLoginInfo = paramArrayList;
    this.iRefreshIntervalMin = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    if (cache_stPageInfo == null) {
      cache_stPageInfo = new LastLoginPageInfo();
    }
    this.stPageInfo = ((LastLoginPageInfo)paramJceInputStream.read(cache_stPageInfo, 2, false));
    if (cache_vecLastLoginInfo == null)
    {
      cache_vecLastLoginInfo = new ArrayList();
      LastLoginInfo localLastLoginInfo = new LastLoginInfo();
      cache_vecLastLoginInfo.add(localLastLoginInfo);
    }
    this.vecLastLoginInfo = ((ArrayList)paramJceInputStream.read(cache_vecLastLoginInfo, 3, false));
    this.iRefreshIntervalMin = paramJceInputStream.read(this.iRefreshIntervalMin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    if (this.stPageInfo != null) {
      paramJceOutputStream.write(this.stPageInfo, 2);
    }
    if (this.vecLastLoginInfo != null) {
      paramJceOutputStream.write(this.vecLastLoginInfo, 3);
    }
    paramJceOutputStream.write(this.iRefreshIntervalMin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.GetLastLoginInfoResp
 * JD-Core Version:    0.7.0.1
 */