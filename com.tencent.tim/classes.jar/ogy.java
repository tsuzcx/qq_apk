import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ogy
  implements oko
{
  ogy(ogv paramogv) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramokz.bb;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      ooz.w(ogv.access$200(), "---CommentEvent, addFeedComment！");
      paramokz = this.a.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.a.hashCode()) });
      pmi.a().dispatch(paramokz);
      ogv.a(this.a).b(localstSimpleMetaComment);
      return;
    }
    ooz.e(ogv.access$200(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogy
 * JD-Core Version:    0.7.0.1
 */