package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetMusicListRsp
  extends JceStruct
{
  static CommRsp cache_errInfo = new CommRsp();
  static MusicListInfo cache_stMusicList = new MusicListInfo();
  public CommRsp errInfo;
  public long iTotal;
  public boolean isEnd = true;
  public String sCookie = "";
  public MusicListInfo stMusicList;
  
  public GetMusicListRsp() {}
  
  public GetMusicListRsp(CommRsp paramCommRsp, MusicListInfo paramMusicListInfo, String paramString, boolean paramBoolean, long paramLong)
  {
    this.errInfo = paramCommRsp;
    this.stMusicList = paramMusicListInfo;
    this.sCookie = paramString;
    this.isEnd = paramBoolean;
    this.iTotal = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.errInfo = ((CommRsp)paramJceInputStream.read(cache_errInfo, 0, false));
    this.stMusicList = ((MusicListInfo)paramJceInputStream.read(cache_stMusicList, 1, false));
    this.sCookie = paramJceInputStream.readString(2, false);
    this.isEnd = paramJceInputStream.read(this.isEnd, 3, false);
    this.iTotal = paramJceInputStream.read(this.iTotal, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.errInfo != null) {
      paramJceOutputStream.write(this.errInfo, 0);
    }
    if (this.stMusicList != null) {
      paramJceOutputStream.write(this.stMusicList, 1);
    }
    if (this.sCookie != null) {
      paramJceOutputStream.write(this.sCookie, 2);
    }
    paramJceOutputStream.write(this.isEnd, 3);
    paramJceOutputStream.write(this.iTotal, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.GetMusicListRsp
 * JD-Core Version:    0.7.0.1
 */