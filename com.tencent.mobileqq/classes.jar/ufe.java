import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ufe
  implements ujj
{
  ufe(uez paramuez, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(uju paramuju)
  {
    if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramuju.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1) {
        upe.d(uez.a(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        wfo.a().dispatch(this.jdField_a_of_type_Uez.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramuju.b), paramuju.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
        return;
        upe.d(uez.a(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    upe.d(uez.a(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufe
 * JD-Core Version:    0.7.0.1
 */