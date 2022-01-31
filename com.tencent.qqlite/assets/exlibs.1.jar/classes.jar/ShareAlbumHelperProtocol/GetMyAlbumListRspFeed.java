package ShareAlbumHelperProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMyAlbumListRspFeed
  extends JceStruct
{
  public String desc = "";
  public long last_time = 0L;
  
  public GetMyAlbumListRspFeed() {}
  
  public GetMyAlbumListRspFeed(long paramLong, String paramString)
  {
    this.last_time = paramLong;
    this.desc = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.last_time = paramJceInputStream.read(this.last_time, 0, false);
    this.desc = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.last_time, 0);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ShareAlbumHelperProtocol.GetMyAlbumListRspFeed
 * JD-Core Version:    0.7.0.1
 */