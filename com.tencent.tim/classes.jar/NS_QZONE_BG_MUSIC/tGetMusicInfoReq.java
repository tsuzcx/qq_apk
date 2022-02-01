package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class tGetMusicInfoReq
  extends JceStruct
{
  static ArrayList<String> cache_vecSongId = new ArrayList();
  public int iNeedUrl;
  public long lUin;
  public ArrayList<String> vecSongId;
  
  static
  {
    cache_vecSongId.add("");
  }
  
  public tGetMusicInfoReq() {}
  
  public tGetMusicInfoReq(long paramLong, ArrayList<String> paramArrayList, int paramInt)
  {
    this.lUin = paramLong;
    this.vecSongId = paramArrayList;
    this.iNeedUrl = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.vecSongId = ((ArrayList)paramJceInputStream.read(cache_vecSongId, 1, false));
    this.iNeedUrl = paramJceInputStream.read(this.iNeedUrl, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.vecSongId != null) {
      paramJceOutputStream.write(this.vecSongId, 1);
    }
    paramJceOutputStream.write(this.iNeedUrl, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QZONE_BG_MUSIC.tGetMusicInfoReq
 * JD-Core Version:    0.7.0.1
 */