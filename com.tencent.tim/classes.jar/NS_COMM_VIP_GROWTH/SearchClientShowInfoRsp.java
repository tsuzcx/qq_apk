package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SearchClientShowInfoRsp
  extends JceStruct
{
  static UserClientShowInfo cache_stUserClientShowInfo = new UserClientShowInfo();
  public int iCode;
  public UserClientShowInfo stUserClientShowInfo;
  
  public SearchClientShowInfoRsp() {}
  
  public SearchClientShowInfoRsp(int paramInt, UserClientShowInfo paramUserClientShowInfo)
  {
    this.iCode = paramInt;
    this.stUserClientShowInfo = paramUserClientShowInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.stUserClientShowInfo = ((UserClientShowInfo)paramJceInputStream.read(cache_stUserClientShowInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.stUserClientShowInfo != null) {
      paramJceOutputStream.write(this.stUserClientShowInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp
 * JD-Core Version:    0.7.0.1
 */