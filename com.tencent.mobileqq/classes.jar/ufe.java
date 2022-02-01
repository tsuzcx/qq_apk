import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ufe
  implements ukd
{
  ufe(ufb paramufb, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(uko paramuko)
  {
    if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramuko.jdField_a_of_type_JavaLangObject;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      uqf.c(ufb.a(), "---CommentEvent, addFeedComment！");
      paramuko = this.jdField_a_of_type_Ufb.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramuko.b), paramuko.jdField_a_of_type_JavaLangString, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Ufb.hashCode()) });
      wjj.a().dispatch(paramuko);
      ufb.a(this.jdField_a_of_type_Ufb).a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      return;
    }
    uqf.d(ufb.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufe
 * JD-Core Version:    0.7.0.1
 */