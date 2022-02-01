import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ufc
  implements ujj
{
  ufc(uez paramuez, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(uju paramuju)
  {
    if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramuju.jdField_a_of_type_JavaLangObject;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      upe.c(uez.a(), "---CommentEvent, addFeedComment！");
      paramuju = this.jdField_a_of_type_Uez.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramuju.b), paramuju.jdField_a_of_type_JavaLangString, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Uez.hashCode()) });
      wfo.a().dispatch(paramuju);
      uez.a(this.jdField_a_of_type_Uez).a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      return;
    }
    upe.d(uez.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufc
 * JD-Core Version:    0.7.0.1
 */