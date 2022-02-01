package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MusicInfo
  extends JceStruct
{
  static ArrayList<SingerInfo> cache_vSingerList = new ArrayList();
  public int iAccess;
  public long iDuration;
  public String sAlbumName = "";
  public String sPic = "";
  public String sSongId = "";
  public String sSongName = "";
  public String sSongUrl = "";
  public ArrayList<SingerInfo> vSingerList;
  
  static
  {
    SingerInfo localSingerInfo = new SingerInfo();
    cache_vSingerList.add(localSingerInfo);
  }
  
  public MusicInfo() {}
  
  public MusicInfo(String paramString1, String paramString2, String paramString3, ArrayList<SingerInfo> paramArrayList, String paramString4, String paramString5, int paramInt, long paramLong)
  {
    this.sSongId = paramString1;
    this.sSongName = paramString2;
    this.sAlbumName = paramString3;
    this.vSingerList = paramArrayList;
    this.sPic = paramString4;
    this.sSongUrl = paramString5;
    this.iAccess = paramInt;
    this.iDuration = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSongId = paramJceInputStream.readString(0, false);
    this.sSongName = paramJceInputStream.readString(1, false);
    this.sAlbumName = paramJceInputStream.readString(2, false);
    this.vSingerList = ((ArrayList)paramJceInputStream.read(cache_vSingerList, 3, false));
    this.sPic = paramJceInputStream.readString(4, false);
    this.sSongUrl = paramJceInputStream.readString(5, false);
    this.iAccess = paramJceInputStream.read(this.iAccess, 6, false);
    this.iDuration = paramJceInputStream.read(this.iDuration, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSongId != null) {
      paramJceOutputStream.write(this.sSongId, 0);
    }
    if (this.sSongName != null) {
      paramJceOutputStream.write(this.sSongName, 1);
    }
    if (this.sAlbumName != null) {
      paramJceOutputStream.write(this.sAlbumName, 2);
    }
    if (this.vSingerList != null) {
      paramJceOutputStream.write(this.vSingerList, 3);
    }
    if (this.sPic != null) {
      paramJceOutputStream.write(this.sPic, 4);
    }
    if (this.sSongUrl != null) {
      paramJceOutputStream.write(this.sSongUrl, 5);
    }
    paramJceOutputStream.write(this.iAccess, 6);
    paramJceOutputStream.write(this.iDuration, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.MusicInfo
 * JD-Core Version:    0.7.0.1
 */