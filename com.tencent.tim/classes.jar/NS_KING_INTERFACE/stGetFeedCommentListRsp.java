package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stGetFeedCommentListRsp
  extends JceStruct
  implements Cloneable
{
  static ArrayList<stMetaComment> cache_comments;
  static ArrayList<stMetaExternPlatformInfo> cache_externPlatformInfos;
  static Map<String, String> cache_replyListAttachInfos;
  static Map<String, stReplyListInfo> cache_replyListInfos;
  public String attach_info = "";
  public ArrayList<stMetaComment> comments;
  public ArrayList<stMetaExternPlatformInfo> externPlatformInfos;
  public String feed_id = "";
  public int isGetAll;
  public boolean is_finished = true;
  public Map<String, String> replyListAttachInfos;
  public Map<String, stReplyListInfo> replyListInfos;
  public int total_comment_num;
  
  static
  {
    if (!stGetFeedCommentListRsp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_comments = new ArrayList();
      Object localObject = new stMetaComment();
      cache_comments.add(localObject);
      cache_externPlatformInfos = new ArrayList();
      localObject = new stMetaExternPlatformInfo();
      cache_externPlatformInfos.add(localObject);
      cache_replyListAttachInfos = new HashMap();
      cache_replyListAttachInfos.put("", "");
      cache_replyListInfos = new HashMap();
      localObject = new stReplyListInfo();
      cache_replyListInfos.put("", localObject);
      return;
    }
  }
  
  public stGetFeedCommentListRsp() {}
  
  public stGetFeedCommentListRsp(String paramString1, ArrayList<stMetaComment> paramArrayList, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2, ArrayList<stMetaExternPlatformInfo> paramArrayList1, Map<String, String> paramMap, Map<String, stReplyListInfo> paramMap1)
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
  
  public String className()
  {
    return "NS_KING_INTERFACE.stGetFeedCommentListRsp";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.attach_info, "attach_info");
    paramStringBuilder.display(this.comments, "comments");
    paramStringBuilder.display(this.is_finished, "is_finished");
    paramStringBuilder.display(this.total_comment_num, "total_comment_num");
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.isGetAll, "isGetAll");
    paramStringBuilder.display(this.externPlatformInfos, "externPlatformInfos");
    paramStringBuilder.display(this.replyListAttachInfos, "replyListAttachInfos");
    paramStringBuilder.display(this.replyListInfos, "replyListInfos");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.attach_info, true);
    paramStringBuilder.displaySimple(this.comments, true);
    paramStringBuilder.displaySimple(this.is_finished, true);
    paramStringBuilder.displaySimple(this.total_comment_num, true);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.isGetAll, true);
    paramStringBuilder.displaySimple(this.externPlatformInfos, true);
    paramStringBuilder.displaySimple(this.replyListAttachInfos, true);
    paramStringBuilder.displaySimple(this.replyListInfos, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stGetFeedCommentListRsp)paramObject;
    } while ((!JceUtil.equals(this.attach_info, paramObject.attach_info)) || (!JceUtil.equals(this.comments, paramObject.comments)) || (!JceUtil.equals(this.is_finished, paramObject.is_finished)) || (!JceUtil.equals(this.total_comment_num, paramObject.total_comment_num)) || (!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.isGetAll, paramObject.isGetAll)) || (!JceUtil.equals(this.externPlatformInfos, paramObject.externPlatformInfos)) || (!JceUtil.equals(this.replyListAttachInfos, paramObject.replyListAttachInfos)) || (!JceUtil.equals(this.replyListInfos, paramObject.replyListInfos)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stGetFeedCommentListRsp";
  }
  
  public String getAttach_info()
  {
    return this.attach_info;
  }
  
  public ArrayList<stMetaComment> getComments()
  {
    return this.comments;
  }
  
  public ArrayList<stMetaExternPlatformInfo> getExternPlatformInfos()
  {
    return this.externPlatformInfos;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
  }
  
  public int getIsGetAll()
  {
    return this.isGetAll;
  }
  
  public boolean getIs_finished()
  {
    return this.is_finished;
  }
  
  public Map<String, String> getReplyListAttachInfos()
  {
    return this.replyListAttachInfos;
  }
  
  public Map<String, stReplyListInfo> getReplyListInfos()
  {
    return this.replyListInfos;
  }
  
  public int getTotal_comment_num()
  {
    return this.total_comment_num;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
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
  
  public void setAttach_info(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void setComments(ArrayList<stMetaComment> paramArrayList)
  {
    this.comments = paramArrayList;
  }
  
  public void setExternPlatformInfos(ArrayList<stMetaExternPlatformInfo> paramArrayList)
  {
    this.externPlatformInfos = paramArrayList;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void setIsGetAll(int paramInt)
  {
    this.isGetAll = paramInt;
  }
  
  public void setIs_finished(boolean paramBoolean)
  {
    this.is_finished = paramBoolean;
  }
  
  public void setReplyListAttachInfos(Map<String, String> paramMap)
  {
    this.replyListAttachInfos = paramMap;
  }
  
  public void setReplyListInfos(Map<String, stReplyListInfo> paramMap)
  {
    this.replyListInfos = paramMap;
  }
  
  public void setTotal_comment_num(int paramInt)
  {
    this.total_comment_num = paramInt;
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
 * Qualified Name:     NS_KING_INTERFACE.stGetFeedCommentListRsp
 * JD-Core Version:    0.7.0.1
 */