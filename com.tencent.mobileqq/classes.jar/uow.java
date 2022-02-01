import UserGrowth.stPostFeedCommentV2Req;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class uow
  extends ukl<stPostFeedCommentV2Rsp>
{
  public uow(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    super("PostFeedCommentV2", 10003);
    this.a = new stPostFeedCommentV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment, new ArrayList(), 0);
    uqf.c("WsCommentBusiness", "stPostFeedCommentV2Req:" + this.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */