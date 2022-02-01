package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetMusicListRsp
  extends JceStruct
{
  static ArrayList<MusicInfo> cache_music_list;
  public ArrayList<MusicInfo> music_list;
  
  public GetMusicListRsp() {}
  
  public GetMusicListRsp(ArrayList<MusicInfo> paramArrayList)
  {
    this.music_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_music_list == null)
    {
      cache_music_list = new ArrayList();
      MusicInfo localMusicInfo = new MusicInfo();
      cache_music_list.add(localMusicInfo);
    }
    this.music_list = ((ArrayList)paramJceInputStream.read(cache_music_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.music_list != null) {
      paramJceOutputStream.write(this.music_list, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MUSIC.GetMusicListRsp
 * JD-Core Version:    0.7.0.1
 */