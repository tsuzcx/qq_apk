package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddMusicReq
  extends JceStruct
{
  static MusicInfo cache_stMusic = new MusicInfo();
  static SourceInfo cache_stSource = new SourceInfo();
  public long iUin;
  public MusicInfo stMusic;
  public SourceInfo stSource;
  
  public AddMusicReq() {}
  
  public AddMusicReq(long paramLong, MusicInfo paramMusicInfo, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.stMusic = paramMusicInfo;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.stMusic = ((MusicInfo)paramJceInputStream.read(cache_stMusic, 1, false));
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.stMusic != null) {
      paramJceOutputStream.write(this.stMusic, 1);
    }
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.AddMusicReq
 * JD-Core Version:    0.7.0.1
 */