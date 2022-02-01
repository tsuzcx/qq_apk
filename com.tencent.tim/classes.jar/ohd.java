import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tribe.async.dispatch.Dispatcher;

class ohd
  implements oko
{
  ohd(ogv paramogv) {}
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stPostCommentDingRsp))
    {
      stPostCommentDingRsp localstPostCommentDingRsp = (stPostCommentDingRsp)paramokz.bb;
      ooz.e(ogv.access$200(), "回复点赞/取消成功,nothing is " + localstPostCommentDingRsp.nothing);
      pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Integer.valueOf(paramokz.mResultCode), paramokz.msg, localstPostCommentDingRsp }));
      return;
    }
    ooz.e(ogv.access$200(), "回复点赞失败new！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohd
 * JD-Core Version:    0.7.0.1
 */