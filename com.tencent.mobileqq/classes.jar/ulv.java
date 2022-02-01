import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ulv
  implements uqy
{
  ulv(uls paramuls, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(urj paramurj)
  {
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramurj.jdField_a_of_type_JavaLangObject;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      uya.c(uls.a(), "---CommentEvent, addFeedComment！");
      paramurj = this.jdField_a_of_type_Uls.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramurj.b), paramurj.jdField_a_of_type_JavaLangString, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Uls.hashCode()) });
      vli.a().dispatch(paramurj);
      uls.a(this.jdField_a_of_type_Uls).a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      return;
    }
    uya.d(uls.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulv
 * JD-Core Version:    0.7.0.1
 */