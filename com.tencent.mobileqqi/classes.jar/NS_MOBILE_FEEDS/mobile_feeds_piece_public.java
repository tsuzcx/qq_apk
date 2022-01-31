package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feeds_piece_public
  extends JceStruct
{
  public String attach_info = "";
  public int hasmore = 0;
  public String hostnick = "";
  public long newcount = 0L;
  public int no_update = 0;
  public long req_count = 0L;
  
  public mobile_feeds_piece_public() {}
  
  public mobile_feeds_piece_public(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    this.hasmore = paramInt1;
    this.newcount = paramLong1;
    this.hostnick = paramString1;
    this.attach_info = paramString2;
    this.no_update = paramInt2;
    this.req_count = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.newcount = paramJceInputStream.read(this.newcount, 1, false);
    this.hostnick = paramJceInputStream.readString(2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.no_update = paramJceInputStream.read(this.no_update, 4, false);
    this.req_count = paramJceInputStream.read(this.req_count, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    paramJceOutputStream.write(this.newcount, 1);
    if (this.hostnick != null) {
      paramJceOutputStream.write(this.hostnick, 2);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.no_update, 4);
    paramJceOutputStream.write(this.req_count, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_public
 * JD-Core Version:    0.7.0.1
 */