package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetKuolieRecomListReq
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  public CommonInfo commInfo;
  public String userId = "";
  
  public GetKuolieRecomListReq() {}
  
  public GetKuolieRecomListReq(CommonInfo paramCommonInfo, String paramString)
  {
    this.commInfo = paramCommonInfo;
    this.userId = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.userId = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commInfo != null) {
      paramJceOutputStream.write(this.commInfo, 0);
    }
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieRecomListReq
 * JD-Core Version:    0.7.0.1
 */