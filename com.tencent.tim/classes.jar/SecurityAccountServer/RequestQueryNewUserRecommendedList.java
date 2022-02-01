package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryNewUserRecommendedList
  extends JceStruct
{
  public String MobileUniqueNo = "";
  public long WantNum;
  
  public RequestQueryNewUserRecommendedList() {}
  
  public RequestQueryNewUserRecommendedList(String paramString, long paramLong)
  {
    this.MobileUniqueNo = paramString;
    this.WantNum = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MobileUniqueNo = paramJceInputStream.readString(1, false);
    this.WantNum = paramJceInputStream.read(this.WantNum, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 1);
    }
    paramJceOutputStream.write(this.WantNum, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryNewUserRecommendedList
 * JD-Core Version:    0.7.0.1
 */