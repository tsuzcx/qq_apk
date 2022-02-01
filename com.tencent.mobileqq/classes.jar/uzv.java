import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class uzv
  implements vfg
{
  uzv(uzs paramuzs, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(vfr paramvfr)
  {
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stPostFeedCommentV2Rsp))
    {
      stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramvfr.jdField_a_of_type_JavaLangObject;
      stSimpleMetaComment localstSimpleMetaComment = localstPostFeedCommentV2Rsp.comment;
      vmp.c(uzs.a(), "---CommentEvent, addFeedComment！");
      paramvfr = this.jdField_a_of_type_Uzs.a(new Object[] { Integer.valueOf(3), Integer.valueOf(paramvfr.b), paramvfr.jdField_a_of_type_JavaLangString, localstPostFeedCommentV2Rsp, localstSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Uzs.hashCode()) });
      wad.a().dispatch(paramvfr);
      uzs.a(this.jdField_a_of_type_Uzs).a(this.jdField_a_of_type_UserGrowthStSimpleMetaComment);
      return;
    }
    vmp.d(uzs.a(), "添加评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzv
 * JD-Core Version:    0.7.0.1
 */