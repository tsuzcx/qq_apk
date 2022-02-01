import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleComment;
import com.tribe.async.dispatch.Dispatcher;

class uzy
  implements vfg
{
  uzy(uzs paramuzs, stSimpleComment paramstSimpleComment) {}
  
  public void a(vfr paramvfr)
  {
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_UserGrowthStSimpleComment.isDing == 1) {
        vmp.d(uzs.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        wad.a().dispatch(this.jdField_a_of_type_Uzs.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramvfr.b), paramvfr.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        vmp.d(uzs.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    vmp.d(uzs.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzy
 * JD-Core Version:    0.7.0.1
 */