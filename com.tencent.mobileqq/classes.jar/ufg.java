import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ufg
  implements ukd
{
  ufg(ufb paramufb, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(uko paramuko)
  {
    if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramuko.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1) {
        uqf.d(ufb.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        wjj.a().dispatch(this.jdField_a_of_type_Ufb.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramuko.b), paramuko.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        uqf.d(ufb.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    uqf.d(ufb.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */