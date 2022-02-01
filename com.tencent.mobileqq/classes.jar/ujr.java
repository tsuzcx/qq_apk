import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class ujr
  implements ukd
{
  ujr(ujq paramujq, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(uko paramuko)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramuko == null) || (paramuko.a == null))
    {
      uqf.a("WSLikeAnimationManger", "点赞失败:-1");
      paramuko = this.jdField_a_of_type_Ujq;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        ujq.a(paramuko, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      uhf.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramuko.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramuko = (stPostFeedDingRsp)paramuko.a;
      if (paramuko == null)
      {
        uqf.a("WSLikeAnimationManger", "服务器失败！！！");
        paramuko = this.jdField_a_of_type_Ujq;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          ujq.a(paramuko, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramuko.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        uqf.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        uqf.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    uqf.a("WSLikeAnimationManger", "点赞失败:-2");
    paramuko = this.jdField_a_of_type_Ujq;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      ujq.a(paramuko, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujr
 * JD-Core Version:    0.7.0.1
 */