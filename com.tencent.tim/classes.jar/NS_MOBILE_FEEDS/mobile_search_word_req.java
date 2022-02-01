package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_search_word_req
  extends JceStruct
{
  public String keyword = "";
  public int type;
  public long uHostUin;
  
  public mobile_search_word_req() {}
  
  public mobile_search_word_req(long paramLong, int paramInt, String paramString)
  {
    this.uHostUin = paramLong;
    this.type = paramInt;
    this.keyword = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.keyword = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uHostUin, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.keyword != null) {
      paramJceOutputStream.write(this.keyword, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_search_word_req
 * JD-Core Version:    0.7.0.1
 */