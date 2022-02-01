package PUSH_UPDATE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PushUpdateFeeds
  extends JceStruct
{
  static Map<Integer, String> cache_cell_checksum;
  static Map<Integer, String> cache_cell_infos;
  static CommentReplyInfo cache_commmet_reply_info;
  static Map<String, String> cache_extendinfo;
  static Map<Integer, byte[]> cache_feeds_data = new HashMap();
  public boolean all_pull = true;
  public Map<Integer, String> cell_checksum;
  public Map<Integer, String> cell_infos;
  public CommentReplyInfo commmet_reply_info;
  public Map<String, String> extendinfo;
  public Map<Integer, byte[]> feeds_data;
  public long feeds_update_time;
  public boolean need_pull = true;
  public String ugc_key = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_feeds_data.put(Integer.valueOf(0), arrayOfByte);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
    cache_cell_infos = new HashMap();
    cache_cell_infos.put(Integer.valueOf(0), "");
    cache_commmet_reply_info = new CommentReplyInfo();
    cache_cell_checksum = new HashMap();
    cache_cell_checksum.put(Integer.valueOf(0), "");
  }
  
  public PushUpdateFeeds() {}
  
  public PushUpdateFeeds(String paramString, Map<Integer, byte[]> paramMap, Map<String, String> paramMap1, Map<Integer, String> paramMap2, CommentReplyInfo paramCommentReplyInfo, long paramLong, boolean paramBoolean1, Map<Integer, String> paramMap3, boolean paramBoolean2)
  {
    this.ugc_key = paramString;
    this.feeds_data = paramMap;
    this.extendinfo = paramMap1;
    this.cell_infos = paramMap2;
    this.commmet_reply_info = paramCommentReplyInfo;
    this.feeds_update_time = paramLong;
    this.need_pull = paramBoolean1;
    this.cell_checksum = paramMap3;
    this.all_pull = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ugc_key = paramJceInputStream.readString(0, false);
    this.feeds_data = ((Map)paramJceInputStream.read(cache_feeds_data, 1, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 2, false));
    this.cell_infos = ((Map)paramJceInputStream.read(cache_cell_infos, 3, false));
    this.commmet_reply_info = ((CommentReplyInfo)paramJceInputStream.read(cache_commmet_reply_info, 4, false));
    this.feeds_update_time = paramJceInputStream.read(this.feeds_update_time, 5, false);
    this.need_pull = paramJceInputStream.read(this.need_pull, 6, false);
    this.cell_checksum = ((Map)paramJceInputStream.read(cache_cell_checksum, 7, false));
    this.all_pull = paramJceInputStream.read(this.all_pull, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ugc_key != null) {
      paramJceOutputStream.write(this.ugc_key, 0);
    }
    if (this.feeds_data != null) {
      paramJceOutputStream.write(this.feeds_data, 1);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 2);
    }
    if (this.cell_infos != null) {
      paramJceOutputStream.write(this.cell_infos, 3);
    }
    if (this.commmet_reply_info != null) {
      paramJceOutputStream.write(this.commmet_reply_info, 4);
    }
    paramJceOutputStream.write(this.feeds_update_time, 5);
    paramJceOutputStream.write(this.need_pull, 6);
    if (this.cell_checksum != null) {
      paramJceOutputStream.write(this.cell_checksum, 7);
    }
    paramJceOutputStream.write(this.all_pull, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     PUSH_UPDATE_FEEDS.PushUpdateFeeds
 * JD-Core Version:    0.7.0.1
 */