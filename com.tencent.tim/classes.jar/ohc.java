import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stSimpleMetaComment;
import com.tribe.async.dispatch.Dispatcher;

class ohc
  implements oko
{
  ohc(ogv paramogv, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramokz.bb;
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment.isDing == 1) {
        ooz.e(ogv.access$200(), "点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
      for (;;)
      {
        pmi.a().dispatch(this.jdField_a_of_type_Ogv.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localstPostCommentDingRsp }));
        return;
        ooz.e(ogv.access$200(), "取消点赞成功,nothing is " + localstPostCommentDingRsp.nothing);
      }
    }
    ooz.e(ogv.access$200(), "评论点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohc
 * JD-Core Version:    0.7.0.1
 */