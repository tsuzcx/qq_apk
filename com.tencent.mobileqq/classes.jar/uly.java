import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleComment;
import com.tribe.async.dispatch.Dispatcher;

class uly
  implements uqy
{
  uly(uls paramuls, stSimpleComment paramstSimpleComment) {}
  
  public void a(urj paramurj)
  {
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramurj.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_UserGrowthStSimpleComment.isDing == 1) {
        uya.d(uls.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        vli.a().dispatch(this.jdField_a_of_type_Uls.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramurj.b), paramurj.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        uya.d(uls.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    uya.d(uls.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uly
 * JD-Core Version:    0.7.0.1
 */