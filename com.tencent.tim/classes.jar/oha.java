import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class oha
  implements oko
{
  oha(ogv paramogv, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stPostCommentReplyV2Rsp))
    {
      stPostCommentReplyV2Rsp localstPostCommentReplyV2Rsp = (stPostCommentReplyV2Rsp)paramokz.bb;
      paramokz = this.jdField_a_of_type_Ogv.a(new Object[] { Integer.valueOf(4), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localstPostCommentReplyV2Rsp, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Ogv.hashCode()) });
      pmi.a().dispatch(paramokz);
      return;
    }
    ooz.e(ogv.access$200(), "添加回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oha
 * JD-Core Version:    0.7.0.1
 */