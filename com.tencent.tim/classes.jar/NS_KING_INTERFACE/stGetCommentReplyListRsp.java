package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class stGetCommentReplyListRsp
  extends JceStruct
  implements Cloneable
{
  static ArrayList<stMetaReply> cache_reply_list;
  public String attach_info = "";
  public boolean isFinished = true;
  public boolean isRFinished = true;
  public ArrayList<stMetaReply> reply_list;
  public int total_reply_num;
  
  static
  {
    if (!stGetCommentReplyListRsp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_reply_list = new ArrayList();
      stMetaReply localstMetaReply = new stMetaReply();
      cache_reply_list.add(localstMetaReply);
      return;
    }
  }
  
  public stGetCommentReplyListRsp() {}
  
  public stGetCommentReplyListRsp(String paramString, ArrayList<stMetaReply> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.attach_info = paramString;
    this.reply_list = paramArrayList;
    this.isFinished = paramBoolean1;
    this.total_reply_num = paramInt;
    this.isRFinished = paramBoolean2;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stGetCommentReplyListRsp";
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
    paramStringBuilder.display(this.reply_list, "reply_list");
    paramStringBuilder.display(this.isFinished, "isFinished");
    paramStringBuilder.display(this.total_reply_num, "total_reply_num");
    paramStringBuilder.display(this.isRFinished, "isRFinished");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.attach_info, true);
    paramStringBuilder.displaySimple(this.reply_list, true);
    paramStringBuilder.displaySimple(this.isFinished, true);
    paramStringBuilder.displaySimple(this.total_reply_num, true);
    paramStringBuilder.displaySimple(this.isRFinished, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stGetCommentReplyListRsp)paramObject;
    } while ((!JceUtil.equals(this.attach_info, paramObject.attach_info)) || (!JceUtil.equals(this.reply_list, paramObject.reply_list)) || (!JceUtil.equals(this.isFinished, paramObject.isFinished)) || (!JceUtil.equals(this.total_reply_num, paramObject.total_reply_num)) || (!JceUtil.equals(this.isRFinished, paramObject.isRFinished)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stGetCommentReplyListRsp";
  }
  
  public String getAttach_info()
  {
    return this.attach_info;
  }
  
  public boolean getIsFinished()
  {
    return this.isFinished;
  }
  
  public boolean getIsRFinished()
  {
    return this.isRFinished;
  }
  
  public ArrayList<stMetaReply> getReply_list()
  {
    return this.reply_list;
  }
  
  public int getTotal_reply_num()
  {
    return this.total_reply_num;
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
    this.reply_list = ((ArrayList)paramJceInputStream.read(cache_reply_list, 1, true));
    this.isFinished = paramJceInputStream.read(this.isFinished, 2, true);
    this.total_reply_num = paramJceInputStream.read(this.total_reply_num, 3, false);
    this.isRFinished = paramJceInputStream.read(this.isRFinished, 4, false);
  }
  
  public void setAttach_info(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void setIsFinished(boolean paramBoolean)
  {
    this.isFinished = paramBoolean;
  }
  
  public void setIsRFinished(boolean paramBoolean)
  {
    this.isRFinished = paramBoolean;
  }
  
  public void setReply_list(ArrayList<stMetaReply> paramArrayList)
  {
    this.reply_list = paramArrayList;
  }
  
  public void setTotal_reply_num(int paramInt)
  {
    this.total_reply_num = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.attach_info, 0);
    paramJceOutputStream.write(this.reply_list, 1);
    paramJceOutputStream.write(this.isFinished, 2);
    paramJceOutputStream.write(this.total_reply_num, 3);
    paramJceOutputStream.write(this.isRFinished, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stGetCommentReplyListRsp
 * JD-Core Version:    0.7.0.1
 */