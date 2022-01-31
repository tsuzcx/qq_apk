package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_update_timestamp_req
  extends JceStruct
{
  public int none = 0;
  
  public sa_update_timestamp_req() {}
  
  public sa_update_timestamp_req(int paramInt)
  {
    this.none = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.none = paramJceInputStream.read(this.none, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.none, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_update_timestamp_req
 * JD-Core Version:    0.7.0.1
 */