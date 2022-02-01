package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class tag_together_modify_req
  extends JceStruct
{
  static Map<Integer, String> cache_mapExt;
  static tag_deatail_info cache_stTagDetailInfo = new tag_deatail_info();
  public Map<Integer, String> mapExt;
  public String sPgcFeedKey = "";
  public tag_deatail_info stTagDetailInfo;
  public long uModifyType;
  public long uPgcAppid;
  public long uPgcUin;
  
  static
  {
    cache_mapExt = new HashMap();
    cache_mapExt.put(Integer.valueOf(0), "");
  }
  
  public tag_together_modify_req() {}
  
  public tag_together_modify_req(long paramLong1, long paramLong2, String paramString, tag_deatail_info paramtag_deatail_info, Map<Integer, String> paramMap, long paramLong3)
  {
    this.uPgcUin = paramLong1;
    this.uPgcAppid = paramLong2;
    this.sPgcFeedKey = paramString;
    this.stTagDetailInfo = paramtag_deatail_info;
    this.mapExt = paramMap;
    this.uModifyType = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uPgcUin = paramJceInputStream.read(this.uPgcUin, 0, false);
    this.uPgcAppid = paramJceInputStream.read(this.uPgcAppid, 1, false);
    this.sPgcFeedKey = paramJceInputStream.readString(2, false);
    this.stTagDetailInfo = ((tag_deatail_info)paramJceInputStream.read(cache_stTagDetailInfo, 3, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 4, false));
    this.uModifyType = paramJceInputStream.read(this.uModifyType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uPgcUin, 0);
    paramJceOutputStream.write(this.uPgcAppid, 1);
    if (this.sPgcFeedKey != null) {
      paramJceOutputStream.write(this.sPgcFeedKey, 2);
    }
    if (this.stTagDetailInfo != null) {
      paramJceOutputStream.write(this.stTagDetailInfo, 3);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 4);
    }
    paramJceOutputStream.write(this.uModifyType, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.tag_together_modify_req
 * JD-Core Version:    0.7.0.1
 */