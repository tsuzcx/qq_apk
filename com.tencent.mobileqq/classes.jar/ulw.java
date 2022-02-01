import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class ulw
  implements uqy
{
  ulw(uls paramuls, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(urj paramurj)
  {
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramurj.jdField_a_of_type_JavaLangObject;
      paramurj = this.jdField_a_of_type_Uls.a(new Object[] { Integer.valueOf(4), Integer.valueOf(paramurj.b), paramurj.jdField_a_of_type_JavaLangString, localstPostCommentReplyV2Rsp, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Uls.hashCode()) });
      vli.a().dispatch(paramurj);
      return;
    }
    uya.d(uls.a(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulw
 * JD-Core Version:    0.7.0.1
 */