package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stConfInfo
  extends JceStruct
{
  public long bubbleEndTime;
  public long bubbleStartTime;
  public long collectTime;
  public int defaultFeedPosition;
  public int defaultTogetherFeed;
  public int exclusive;
  public int feedUseType;
  public String followFeed = "";
  public long iStartPos;
  public int iType;
  public int isCollected;
  public String strLabel = "";
  public String togetherFeed = "";
  public int togetherType;
  public int useCount;
  
  public stConfInfo() {}
  
  public stConfInfo(int paramInt1, long paramLong1, String paramString1, int paramInt2, long paramLong2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong3, long paramLong4)
  {
    this.iType = paramInt1;
    this.iStartPos = paramLong1;
    this.strLabel = paramString1;
    this.isCollected = paramInt2;
    this.collectTime = paramLong2;
    this.exclusive = paramInt3;
    this.followFeed = paramString2;
    this.useCount = paramInt4;
    this.togetherFeed = paramString3;
    this.togetherType = paramInt5;
    this.feedUseType = paramInt6;
    this.defaultFeedPosition = paramInt7;
    this.defaultTogetherFeed = paramInt8;
    this.bubbleStartTime = paramLong3;
    this.bubbleEndTime = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.iStartPos = paramJceInputStream.read(this.iStartPos, 1, false);
    this.strLabel = paramJceInputStream.readString(2, false);
    this.isCollected = paramJceInputStream.read(this.isCollected, 3, false);
    this.collectTime = paramJceInputStream.read(this.collectTime, 4, false);
    this.exclusive = paramJceInputStream.read(this.exclusive, 5, false);
    this.followFeed = paramJceInputStream.readString(6, false);
    this.useCount = paramJceInputStream.read(this.useCount, 7, false);
    this.togetherFeed = paramJceInputStream.readString(8, false);
    this.togetherType = paramJceInputStream.read(this.togetherType, 9, false);
    this.feedUseType = paramJceInputStream.read(this.feedUseType, 10, false);
    this.defaultFeedPosition = paramJceInputStream.read(this.defaultFeedPosition, 11, false);
    this.defaultTogetherFeed = paramJceInputStream.read(this.defaultTogetherFeed, 12, false);
    this.bubbleStartTime = paramJceInputStream.read(this.bubbleStartTime, 13, false);
    this.bubbleEndTime = paramJceInputStream.read(this.bubbleEndTime, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    paramJceOutputStream.write(this.iStartPos, 1);
    if (this.strLabel != null) {
      paramJceOutputStream.write(this.strLabel, 2);
    }
    paramJceOutputStream.write(this.isCollected, 3);
    paramJceOutputStream.write(this.collectTime, 4);
    paramJceOutputStream.write(this.exclusive, 5);
    if (this.followFeed != null) {
      paramJceOutputStream.write(this.followFeed, 6);
    }
    paramJceOutputStream.write(this.useCount, 7);
    if (this.togetherFeed != null) {
      paramJceOutputStream.write(this.togetherFeed, 8);
    }
    paramJceOutputStream.write(this.togetherType, 9);
    paramJceOutputStream.write(this.feedUseType, 10);
    paramJceOutputStream.write(this.defaultFeedPosition, 11);
    paramJceOutputStream.write(this.defaultTogetherFeed, 12);
    paramJceOutputStream.write(this.bubbleStartTime, 13);
    paramJceOutputStream.write(this.bubbleEndTime, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stConfInfo
 * JD-Core Version:    0.7.0.1
 */