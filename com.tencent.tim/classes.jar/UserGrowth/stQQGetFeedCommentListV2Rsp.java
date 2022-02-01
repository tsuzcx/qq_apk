package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stQQGetFeedCommentListV2Rsp
  extends JceStruct
{
  static ArrayList<stCommentJumpText> cache_comment_text;
  static stGetFeedCommentListV2Rsp cache_rsp = new stGetFeedCommentListV2Rsp();
  public ArrayList<stCommentJumpText> comment_text;
  public int link;
  public stGetFeedCommentListV2Rsp rsp;
  
  static
  {
    cache_comment_text = new ArrayList();
    stCommentJumpText localstCommentJumpText = new stCommentJumpText();
    cache_comment_text.add(localstCommentJumpText);
  }
  
  public stQQGetFeedCommentListV2Rsp() {}
  
  public stQQGetFeedCommentListV2Rsp(stGetFeedCommentListV2Rsp paramstGetFeedCommentListV2Rsp, int paramInt, ArrayList<stCommentJumpText> paramArrayList)
  {
    this.rsp = paramstGetFeedCommentListV2Rsp;
    this.link = paramInt;
    this.comment_text = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp = ((stGetFeedCommentListV2Rsp)paramJceInputStream.read(cache_rsp, 0, false));
    this.link = paramJceInputStream.read(this.link, 1, false);
    this.comment_text = ((ArrayList)paramJceInputStream.read(cache_comment_text, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rsp != null) {
      paramJceOutputStream.write(this.rsp, 0);
    }
    paramJceOutputStream.write(this.link, 1);
    if (this.comment_text != null) {
      paramJceOutputStream.write(this.comment_text, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stQQGetFeedCommentListV2Rsp
 * JD-Core Version:    0.7.0.1
 */