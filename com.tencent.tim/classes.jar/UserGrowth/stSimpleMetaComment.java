package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stSimpleMetaComment
  extends JceStruct
{
  static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
  static stSimpleMetaPerson cache_receiver = new stSimpleMetaPerson();
  static ArrayList<stSimpleMetaReply> cache_replyList = new ArrayList();
  static Map<Integer, String> cache_reserve;
  public String beReplyCommendId = "";
  public int createtime;
  public long dingNum;
  public int essOpUin;
  public String feedId = "";
  public String feedOwnerId = "";
  public String id = "";
  public int isDing;
  public boolean isTempData;
  public int mask;
  public stSimpleMetaPerson poster;
  public String poster_id = "";
  public stSimpleMetaPerson receiver;
  public String receiver_id = "";
  public long replyIdNum;
  public ArrayList<stSimpleMetaReply> replyList;
  public long replyNum;
  public Map<Integer, String> reserve;
  public int robotMode;
  public String wording = "";
  
  static
  {
    stSimpleMetaReply localstSimpleMetaReply = new stSimpleMetaReply();
    cache_replyList.add(localstSimpleMetaReply);
    cache_reserve = new HashMap();
    cache_reserve.put(Integer.valueOf(0), "");
  }
  
  public stSimpleMetaComment() {}
  
  public stSimpleMetaComment(String paramString1, String paramString2, String paramString3, stSimpleMetaPerson paramstSimpleMetaPerson1, String paramString4, stSimpleMetaPerson paramstSimpleMetaPerson2, int paramInt1, int paramInt2, int paramInt3, String paramString5, int paramInt4, long paramLong1, int paramInt5, ArrayList<stSimpleMetaReply> paramArrayList, long paramLong2, String paramString6, Map<Integer, String> paramMap, String paramString7, long paramLong3)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.poster_id = paramString3;
    this.poster = paramstSimpleMetaPerson1;
    this.receiver_id = paramString4;
    this.receiver = paramstSimpleMetaPerson2;
    this.createtime = paramInt1;
    this.mask = paramInt2;
    this.robotMode = paramInt3;
    this.beReplyCommendId = paramString5;
    this.essOpUin = paramInt4;
    this.dingNum = paramLong1;
    this.isDing = paramInt5;
    this.replyList = paramArrayList;
    this.replyNum = paramLong2;
    this.feedOwnerId = paramString6;
    this.reserve = paramMap;
    this.feedId = paramString7;
    this.replyIdNum = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.poster_id = paramJceInputStream.readString(2, false);
    this.poster = ((stSimpleMetaPerson)paramJceInputStream.read(cache_poster, 3, false));
    this.receiver_id = paramJceInputStream.readString(4, false);
    this.receiver = ((stSimpleMetaPerson)paramJceInputStream.read(cache_receiver, 5, false));
    this.createtime = paramJceInputStream.read(this.createtime, 6, false);
    this.mask = paramJceInputStream.read(this.mask, 7, false);
    this.robotMode = paramJceInputStream.read(this.robotMode, 8, false);
    this.beReplyCommendId = paramJceInputStream.readString(9, false);
    this.essOpUin = paramJceInputStream.read(this.essOpUin, 10, false);
    this.dingNum = paramJceInputStream.read(this.dingNum, 11, false);
    this.isDing = paramJceInputStream.read(this.isDing, 12, false);
    this.replyList = ((ArrayList)paramJceInputStream.read(cache_replyList, 13, false));
    this.replyNum = paramJceInputStream.read(this.replyNum, 14, false);
    this.feedOwnerId = paramJceInputStream.readString(15, false);
    this.reserve = ((Map)paramJceInputStream.read(cache_reserve, 16, false));
    this.feedId = paramJceInputStream.readString(17, false);
    this.replyIdNum = paramJceInputStream.read(this.replyIdNum, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.wording != null) {
      paramJceOutputStream.write(this.wording, 1);
    }
    if (this.poster_id != null) {
      paramJceOutputStream.write(this.poster_id, 2);
    }
    if (this.poster != null) {
      paramJceOutputStream.write(this.poster, 3);
    }
    if (this.receiver_id != null) {
      paramJceOutputStream.write(this.receiver_id, 4);
    }
    if (this.receiver != null) {
      paramJceOutputStream.write(this.receiver, 5);
    }
    paramJceOutputStream.write(this.createtime, 6);
    paramJceOutputStream.write(this.mask, 7);
    paramJceOutputStream.write(this.robotMode, 8);
    if (this.beReplyCommendId != null) {
      paramJceOutputStream.write(this.beReplyCommendId, 9);
    }
    paramJceOutputStream.write(this.essOpUin, 10);
    paramJceOutputStream.write(this.dingNum, 11);
    paramJceOutputStream.write(this.isDing, 12);
    if (this.replyList != null) {
      paramJceOutputStream.write(this.replyList, 13);
    }
    paramJceOutputStream.write(this.replyNum, 14);
    if (this.feedOwnerId != null) {
      paramJceOutputStream.write(this.feedOwnerId, 15);
    }
    if (this.reserve != null) {
      paramJceOutputStream.write(this.reserve, 16);
    }
    if (this.feedId != null) {
      paramJceOutputStream.write(this.feedId, 17);
    }
    paramJceOutputStream.write(this.replyIdNum, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleMetaComment
 * JD-Core Version:    0.7.0.1
 */