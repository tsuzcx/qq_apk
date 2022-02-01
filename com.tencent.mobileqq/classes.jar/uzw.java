import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class uzw
  implements vfg
{
  uzw(uzs paramuzs, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(vfr paramvfr)
  {
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramvfr.jdField_a_of_type_JavaLangObject;
      paramvfr = this.jdField_a_of_type_Uzs.a(new Object[] { Integer.valueOf(4), Integer.valueOf(paramvfr.b), paramvfr.jdField_a_of_type_JavaLangString, localstPostCommentReplyV2Rsp, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Uzs.hashCode()) });
      wad.a().dispatch(paramvfr);
      return;
    }
    vmp.d(uzs.a(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzw
 * JD-Core Version:    0.7.0.1
 */