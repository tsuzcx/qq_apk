package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_delugc_req
  extends JceStruct
{
  static Map cache_busi_param;
  public int appid = 0;
  public Map busi_param = null;
  public String content = "";
  public int isverified = 0;
  public long ownuin = 0L;
  public String srcId = "";
  public String srcSubid = "";
  public long uin = 0L;
  
  public operation_delugc_req() {}
  
  public operation_delugc_req(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, Map paramMap)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcId = paramString1;
    this.srcSubid = paramString2;
    this.content = paramString3;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcId = paramJceInputStream.readString(3, false);
    this.srcSubid = paramJceInputStream.readString(4, false);
    this.content = paramJceInputStream.readString(5, false);
    this.isverified = paramJceInputStream.read(this.isverified, 6, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 3);
    }
    if (this.srcSubid != null) {
      paramJceOutputStream.write(this.srcSubid, 4);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 5);
    }
    paramJceOutputStream.write(this.isverified, 6);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delugc_req
 * JD-Core Version:    0.7.0.1
 */