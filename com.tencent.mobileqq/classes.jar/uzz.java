import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tribe.async.dispatch.Dispatcher;

class uzz
  implements vfg
{
  uzz(uzs paramuzs) {}
  
  public void a(vfr paramvfr)
  {
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      vmp.d(uzs.a(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      wad.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramvfr.b), paramvfr.jdField_a_of_type_JavaLangString, localstPostCommentDingRsp }));
      return;
    }
    vmp.d(uzs.a(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzz
 * JD-Core Version:    0.7.0.1
 */