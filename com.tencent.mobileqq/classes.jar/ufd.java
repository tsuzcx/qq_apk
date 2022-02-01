import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class ufd
  implements ujj
{
  ufd(uez paramuez, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(uju paramuju)
  {
    if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramuju.jdField_a_of_type_JavaLangObject;
      paramuju = this.jdField_a_of_type_Uez.a(new Object[] { Integer.valueOf(4), Integer.valueOf(paramuju.b), paramuju.jdField_a_of_type_JavaLangString, localstPostCommentReplyV2Rsp, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Uez.hashCode()) });
      wfo.a().dispatch(paramuju);
      return;
    }
    upe.d(uez.a(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */