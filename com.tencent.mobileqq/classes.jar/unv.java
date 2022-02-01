import UserGrowth.stPostFeedCommentV2Req;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class unv
  extends ujr<stPostFeedCommentV2Rsp>
{
  public unv(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    super("PostFeedCommentV2", 10003);
    this.a = new stPostFeedCommentV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment, new ArrayList(), 0);
    upe.c("WsCommentBusiness", "stPostFeedCommentV2Req:" + this.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unv
 * JD-Core Version:    0.7.0.1
 */