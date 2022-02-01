package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPostFeedCommentV2Req
  extends JceStruct
{
  static stSimpleMetaComment cache_comment = new stSimpleMetaComment();
  static ArrayList<stMetaReportDataItem> cache_data = new ArrayList();
  public stSimpleMetaComment comment;
  public ArrayList<stMetaReportDataItem> data;
  public String feed_id = "";
  public int hadMancheked;
  
  static
  {
    stMetaReportDataItem localstMetaReportDataItem = new stMetaReportDataItem();
    cache_data.add(localstMetaReportDataItem);
  }
  
  public stPostFeedCommentV2Req() {}
  
  public stPostFeedCommentV2Req(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    this.feed_id = paramString;
    this.comment = paramstSimpleMetaComment;
  }
  
  public stPostFeedCommentV2Req(String paramString, stSimpleMetaComment paramstSimpleMetaComment, ArrayList<stMetaReportDataItem> paramArrayList, int paramInt)
  {
    this.feed_id = paramString;
    this.comment = paramstSimpleMetaComment;
    this.data = paramArrayList;
    this.hadMancheked = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, true);
    this.comment = ((stSimpleMetaComment)paramJceInputStream.read(cache_comment, 1, true));
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 2, false));
    this.hadMancheked = paramJceInputStream.read(this.hadMancheked, 3, false);
  }
  
  public String toString()
  {
    return "stPostFeedCommentV2Req{feed_id='" + this.feed_id + '\'' + ", comment=" + this.comment + ", data=" + this.data + ", hadMancheked=" + this.hadMancheked + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_id, 0);
    paramJceOutputStream.write(this.comment, 1);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 2);
    }
    paramJceOutputStream.write(this.hadMancheked, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stPostFeedCommentV2Req
 * JD-Core Version:    0.7.0.1
 */