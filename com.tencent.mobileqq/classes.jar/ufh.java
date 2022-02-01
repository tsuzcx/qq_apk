import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tribe.async.dispatch.Dispatcher;

class ufh
  implements ukd
{
  ufh(ufb paramufb) {}
  
  public void a(uko paramuko)
  {
    if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramuko.jdField_a_of_type_JavaLangObject;
      uqf.d(ufb.a(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      wjj.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramuko.b), paramuko.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
      return;
    }
    uqf.d(ufb.a(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */