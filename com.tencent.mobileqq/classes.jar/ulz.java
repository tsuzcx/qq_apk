import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tribe.async.dispatch.Dispatcher;

class ulz
  implements uqy
{
  ulz(uls paramuls) {}
  
  public void a(urj paramurj)
  {
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramurj.jdField_a_of_type_JavaLangObject;
      uya.d(uls.a(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      vli.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramurj.b), paramurj.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
      return;
    }
    uya.d(uls.a(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulz
 * JD-Core Version:    0.7.0.1
 */