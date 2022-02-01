import UserGrowth.stPostFeedCommentV2Req;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class onx
  extends okw<stPostFeedCommentV2Rsp>
{
  public onx(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    super("PostFeedCommentV2");
    this.req = new stPostFeedCommentV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment, new ArrayList(), 0);
    ooz.w("WsCommentBusiness", "stPostFeedCommentV2Req:" + this.req.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onx
 * JD-Core Version:    0.7.0.1
 */