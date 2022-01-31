package NS_SHARE_ALBUM;

import NS_MOBILE_FEEDS.cell_lbs;
import NS_MOBILE_FEEDS.s_user;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BatchInfo
  extends JceStruct
{
  static cell_lbs cache_lbs;
  static s_user cache_user;
  public cell_lbs lbs = null;
  public long uploadtime = 0L;
  public s_user user = null;
  
  public BatchInfo() {}
  
  public BatchInfo(s_user params_user, cell_lbs paramcell_lbs, long paramLong)
  {
    this.user = params_user;
    this.lbs = paramcell_lbs;
    this.uploadtime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    if (cache_lbs == null) {
      cache_lbs = new cell_lbs();
    }
    this.lbs = ((cell_lbs)paramJceInputStream.read(cache_lbs, 1, false));
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.lbs != null) {
      paramJceOutputStream.write(this.lbs, 1);
    }
    paramJceOutputStream.write(this.uploadtime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.BatchInfo
 * JD-Core Version:    0.7.0.1
 */