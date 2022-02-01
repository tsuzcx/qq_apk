import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class oke
  implements oko
{
  oke(okd paramokd, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(okz paramokz)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.dL, this.val$position);
    if ((paramokz == null) || (paramokz.bb == null))
    {
      ooz.i("WSLikeAnimationManger", "点赞失败:-1");
      paramokz = this.a;
      str = this.dL;
      if (this.axB)
      {
        i = 0;
        okd.a(paramokz, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      oiv.a().b(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramokz.bb instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramokz = (stPostFeedDingRsp)paramokz.bb;
      if (paramokz == null)
      {
        ooz.i("WSLikeAnimationManger", "服务器失败！！！");
        paramokz = this.a;
        str = this.dL;
        if (this.axB) {}
        for (;;)
        {
          okd.a(paramokz, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramokz.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        ooz.i("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        ooz.i("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    ooz.i("WSLikeAnimationManger", "点赞失败:-2");
    paramokz = this.a;
    String str = this.dL;
    if (this.axB) {}
    for (i = j;; i = 1)
    {
      okd.a(paramokz, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */