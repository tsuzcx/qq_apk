package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSongInfo
  extends JceStruct
{
  public int copyright;
  public int iIsOnly;
  public int iPlayTime;
  public int iPlayable;
  public int iSize;
  public int iSizeHq;
  public int iSizeSq;
  public int iSizeStandard;
  public int iSource;
  public int iTryBegin;
  public int iTryEnd;
  public int iTrySize;
  public String strGenre = "";
  public String strH5Url = "";
  public String strLanguage = "";
  public String strMid = "";
  public String strName = "";
  public String strPlayUrl = "";
  public String strPlayUrlHq = "";
  public String strPlayUrlSq = "";
  public String strPlayUrlStandard = "";
  public long uiId;
  
  public stSongInfo() {}
  
  public stSongInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    this.uiId = paramLong;
    this.strMid = paramString1;
    this.strName = paramString2;
    this.strGenre = paramString3;
    this.iIsOnly = paramInt1;
    this.strLanguage = paramString4;
    this.iPlayable = paramInt2;
    this.iTrySize = paramInt3;
    this.iTryBegin = paramInt4;
    this.iTryEnd = paramInt5;
    this.iPlayTime = paramInt6;
    this.strH5Url = paramString5;
    this.strPlayUrl = paramString6;
    this.strPlayUrlStandard = paramString7;
    this.strPlayUrlHq = paramString8;
    this.strPlayUrlSq = paramString9;
    this.iSize = paramInt7;
    this.iSizeStandard = paramInt8;
    this.iSizeHq = paramInt9;
    this.iSizeSq = paramInt10;
    this.copyright = paramInt11;
    this.iSource = paramInt12;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiId = paramJceInputStream.read(this.uiId, 0, false);
    this.strMid = paramJceInputStream.readString(1, false);
    this.strName = paramJceInputStream.readString(2, false);
    this.strGenre = paramJceInputStream.readString(3, false);
    this.iIsOnly = paramJceInputStream.read(this.iIsOnly, 4, false);
    this.strLanguage = paramJceInputStream.readString(5, false);
    this.iPlayable = paramJceInputStream.read(this.iPlayable, 6, false);
    this.iTrySize = paramJceInputStream.read(this.iTrySize, 7, false);
    this.iTryBegin = paramJceInputStream.read(this.iTryBegin, 8, false);
    this.iTryEnd = paramJceInputStream.read(this.iTryEnd, 9, false);
    this.iPlayTime = paramJceInputStream.read(this.iPlayTime, 10, false);
    this.strH5Url = paramJceInputStream.readString(11, false);
    this.strPlayUrl = paramJceInputStream.readString(12, false);
    this.strPlayUrlStandard = paramJceInputStream.readString(13, false);
    this.strPlayUrlHq = paramJceInputStream.readString(14, false);
    this.strPlayUrlSq = paramJceInputStream.readString(15, false);
    this.iSize = paramJceInputStream.read(this.iSize, 16, false);
    this.iSizeStandard = paramJceInputStream.read(this.iSizeStandard, 17, false);
    this.iSizeHq = paramJceInputStream.read(this.iSizeHq, 18, false);
    this.iSizeSq = paramJceInputStream.read(this.iSizeSq, 19, false);
    this.copyright = paramJceInputStream.read(this.copyright, 20, false);
    this.iSource = paramJceInputStream.read(this.iSource, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiId, 0);
    if (this.strMid != null) {
      paramJceOutputStream.write(this.strMid, 1);
    }
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 2);
    }
    if (this.strGenre != null) {
      paramJceOutputStream.write(this.strGenre, 3);
    }
    paramJceOutputStream.write(this.iIsOnly, 4);
    if (this.strLanguage != null) {
      paramJceOutputStream.write(this.strLanguage, 5);
    }
    paramJceOutputStream.write(this.iPlayable, 6);
    paramJceOutputStream.write(this.iTrySize, 7);
    paramJceOutputStream.write(this.iTryBegin, 8);
    paramJceOutputStream.write(this.iTryEnd, 9);
    paramJceOutputStream.write(this.iPlayTime, 10);
    if (this.strH5Url != null) {
      paramJceOutputStream.write(this.strH5Url, 11);
    }
    if (this.strPlayUrl != null) {
      paramJceOutputStream.write(this.strPlayUrl, 12);
    }
    if (this.strPlayUrlStandard != null) {
      paramJceOutputStream.write(this.strPlayUrlStandard, 13);
    }
    if (this.strPlayUrlHq != null) {
      paramJceOutputStream.write(this.strPlayUrlHq, 14);
    }
    if (this.strPlayUrlSq != null) {
      paramJceOutputStream.write(this.strPlayUrlSq, 15);
    }
    paramJceOutputStream.write(this.iSize, 16);
    paramJceOutputStream.write(this.iSizeStandard, 17);
    paramJceOutputStream.write(this.iSizeHq, 18);
    paramJceOutputStream.write(this.iSizeSq, 19);
    paramJceOutputStream.write(this.copyright, 20);
    paramJceOutputStream.write(this.iSource, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stSongInfo
 * JD-Core Version:    0.7.0.1
 */