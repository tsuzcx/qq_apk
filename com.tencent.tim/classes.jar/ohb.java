import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import com.tribe.async.dispatch.Dispatcher;

class ohb
  implements oko
{
  ohb(ogv paramogv, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stDeleteFeedCommentRsp))
    {
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramokz.bb;
      paramokz = this.jdField_a_of_type_Ogv.a(new Object[] { Integer.valueOf(6), Integer.valueOf(paramokz.mResultCode), paramokz.msg, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.id, this.jdField_a_of_type_UserGrowthStSimpleMetaReply, this.jdField_a_of_type_UserGrowthStSimpleMetaReply.id, Integer.valueOf(this.jdField_a_of_type_Ogv.hashCode()) });
      pmi.a().dispatch(paramokz);
      return;
    }
    ooz.e(ogv.access$200(), "删除回复失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohb
 * JD-Core Version:    0.7.0.1
 */