package NS_KING_INTERFACE;

import UserGrowth.stSimpleMetaComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stGetFeedCommentListV2Rsp
  extends JceStruct
{
  static ArrayList<stSimpleMetaComment> cache_comments = new ArrayList();
  static ArrayList<stMetaExternPlatformInfo> cache_externPlatformInfos;
  static Map<String, String> cache_replyListAttachInfos;
  static Map<String, stReplyListInfo> cache_replyListInfos;
  public String attach_info = "";
  public ArrayList<stSimpleMetaComment> comments;
  public ArrayList<stMetaExternPlatformInfo> externPlatformInfos;
  public String feed_id = "";
  public int isGetAll;
  public boolean is_finished = true;
  public Map<String, String> replyListAttachInfos;
  public Map<String, stReplyListInfo> replyListInfos;
  public int total_comment_num;
  
  static
  {
    Object localObject = new stSimpleMetaComment();
    cache_comments.add(localObject);
    cache_externPlatformInfos = new ArrayList();
    localObject = new stMetaExternPlatformInfo();
    cache_externPlatformInfos.add(localObject);
    cache_replyListAttachInfos = new HashMap();
    cache_replyListAttachInfos.put("", "");
    cache_replyListInfos = new HashMap();
    localObject = new stReplyListInfo();
    cache_replyListInfos.put("", localObject);
  }
  
  public stGetFeedCommentListV2Rsp() {}
  
  public stGetFeedCommentListV2Rsp(String paramString1, ArrayList<stSimpleMetaComment> paramArrayList, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2, ArrayList<stMetaExternPlatformInfo> paramArrayList1, Map<String, String> paramMap, Map<String, stReplyListInfo> paramMap1)
  {
    this.attach_info = paramString1;
    this.comments = paramArrayList;
    this.is_finished = paramBoolean;
    this.total_comment_num = paramInt1;
    this.feed_id = paramString2;
    this.isGetAll = paramInt2;
    this.externPlatformInfos = paramArrayList1;
    this.replyListAttachInfos = paramMap;
    this.replyListInfos = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attach_info = paramJceInputStream.readString(0, true);
    this.comments = ((ArrayList)paramJceInputStream.read(cache_comments, 1, true));
    this.is_finished = paramJceInputStream.read(this.is_finished, 2, true);
    this.total_comment_num = paramJceInputStream.read(this.total_comment_num, 3, false);
    this.feed_id = paramJceInputStream.readString(4, false);
    this.isGetAll = paramJceInputStream.read(this.isGetAll, 5, false);
    this.externPlatformInfos = ((ArrayList)paramJceInputStream.read(cache_externPlatformInfos, 6, false));
    this.replyListAttachInfos = ((Map)paramJceInputStream.read(cache_replyListAttachInfos, 7, false));
    this.replyListInfos = ((Map)paramJceInputStream.read(cache_replyListInfos, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.attach_info, 0);
    paramJceOutputStream.write(this.comments, 1);
    paramJceOutputStream.write(this.is_finished, 2);
    paramJceOutputStream.write(this.total_comment_num, 3);
    if (this.feed_id != null) {
      paramJceOutputStream.write(this.feed_id, 4);
    }
    paramJceOutputStream.write(this.isGetAll, 5);
    if (this.externPlatformInfos != null) {
      paramJceOutputStream.write(this.externPlatformInfos, 6);
    }
    if (this.replyListAttachInfos != null) {
      paramJceOutputStream.write(this.replyListAttachInfos, 7);
    }
    if (this.replyListInfos != null) {
      paramJceOutputStream.write(this.replyListInfos, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stGetFeedCommentListV2Rsp
 * JD-Core Version:    0.7.0.1
 */