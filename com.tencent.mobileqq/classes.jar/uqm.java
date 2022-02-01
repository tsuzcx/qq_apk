import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class uqm
  implements uqy
{
  uqm(uql paramuql, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(urj paramurj)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramurj == null) || (paramurj.a == null))
    {
      uya.a("WSLikeAnimationManger", "点赞失败:-1");
      paramurj = this.jdField_a_of_type_Uql;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        uql.a(paramurj, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      unw.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramurj.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramurj = (stPostFeedDingRsp)paramurj.a;
      if (paramurj == null)
      {
        uya.a("WSLikeAnimationManger", "服务器失败！！！");
        paramurj = this.jdField_a_of_type_Uql;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          uql.a(paramurj, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramurj.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        uya.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        uya.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    uya.a("WSLikeAnimationManger", "点赞失败:-2");
    paramurj = this.jdField_a_of_type_Uql;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      uql.a(paramurj, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqm
 * JD-Core Version:    0.7.0.1
 */