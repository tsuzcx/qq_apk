import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ogz
  implements oko
{
  ogz(ogv paramogv, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stDeleteFeedCommentRsp))
    {
      stDeleteFeedCommentRsp localstDeleteFeedCommentRsp = (stDeleteFeedCommentRsp)paramokz.bb;
      paramokz = this.jdField_a_of_type_Ogv.a(new Object[] { Integer.valueOf(5), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localstDeleteFeedCommentRsp, this.jdField_a_of_type_UserGrowthStSimpleMetaComment.id, Integer.valueOf(this.jdField_a_of_type_Ogv.hashCode()) });
      pmi.a().dispatch(paramokz);
      return;
    }
    ooz.e(ogv.access$200(), "删除评论失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogz
 * JD-Core Version:    0.7.0.1
 */