package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NewestFeedInfo
  extends JceStruct
{
  static Map<String, String> cache_mapEx;
  static ArrayList<Media_Data> cache_mediaData = new ArrayList();
  public Map<String, String> mapEx;
  public ArrayList<Media_Data> mediaData;
  public String strContent = "";
  public String strImgUrl = "";
  public String strJmpUrl = "";
  public String strLBSInfo = "";
  public String strSummary = "";
  public String strTitle = "";
  public long uAppid;
  public long uCommentNum;
  public long uHostUin;
  public long uImgCount;
  public long uLikeNum;
  public long uTime;
  
  static
  {
    Media_Data localMedia_Data = new Media_Data();
    cache_mediaData.add(localMedia_Data);
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public NewestFeedInfo() {}
  
  public NewestFeedInfo(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong4, String paramString6, ArrayList<Media_Data> paramArrayList, long paramLong5, long paramLong6, Map<String, String> paramMap)
  {
    this.uAppid = paramLong1;
    this.uHostUin = paramLong2;
    this.uTime = paramLong3;
    this.strLBSInfo = paramString1;
    this.strSummary = paramString2;
    this.strTitle = paramString3;
    this.strContent = paramString4;
    this.strImgUrl = paramString5;
    this.uImgCount = paramLong4;
    this.strJmpUrl = paramString6;
    this.mediaData = paramArrayList;
    this.uLikeNum = paramLong5;
    this.uCommentNum = paramLong6;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uAppid = paramJceInputStream.read(this.uAppid, 0, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 1, false);
    this.uTime = paramJceInputStream.read(this.uTime, 2, false);
    this.strLBSInfo = paramJceInputStream.readString(3, false);
    this.strSummary = paramJceInputStream.readString(4, false);
    this.strTitle = paramJceInputStream.readString(5, false);
    this.strContent = paramJceInputStream.readString(6, false);
    this.strImgUrl = paramJceInputStream.readString(7, false);
    this.uImgCount = paramJceInputStream.read(this.uImgCount, 8, false);
    this.strJmpUrl = paramJceInputStream.readString(9, false);
    this.mediaData = ((ArrayList)paramJceInputStream.read(cache_mediaData, 10, false));
    this.uLikeNum = paramJceInputStream.read(this.uLikeNum, 11, false);
    this.uCommentNum = paramJceInputStream.read(this.uCommentNum, 12, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uAppid, 0);
    paramJceOutputStream.write(this.uHostUin, 1);
    paramJceOutputStream.write(this.uTime, 2);
    if (this.strLBSInfo != null) {
      paramJceOutputStream.write(this.strLBSInfo, 3);
    }
    if (this.strSummary != null) {
      paramJceOutputStream.write(this.strSummary, 4);
    }
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 5);
    }
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 6);
    }
    if (this.strImgUrl != null) {
      paramJceOutputStream.write(this.strImgUrl, 7);
    }
    paramJceOutputStream.write(this.uImgCount, 8);
    if (this.strJmpUrl != null) {
      paramJceOutputStream.write(this.strJmpUrl, 9);
    }
    if (this.mediaData != null) {
      paramJceOutputStream.write(this.mediaData, 10);
    }
    paramJceOutputStream.write(this.uLikeNum, 11);
    paramJceOutputStream.write(this.uCommentNum, 12);
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.NewestFeedInfo
 * JD-Core Version:    0.7.0.1
 */