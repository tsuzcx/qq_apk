package ShareAlbumHelperProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMyAlbumListReq
  extends JceStruct
{
  public long last_visit_time = 0L;
  
  public GetMyAlbumListReq() {}
  
  public GetMyAlbumListReq(long paramLong)
  {
    this.last_visit_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.last_visit_time = paramJceInputStream.read(this.last_visit_time, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.last_visit_time, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ShareAlbumHelperProtocol.GetMyAlbumListReq
 * JD-Core Version:    0.7.0.1
 */