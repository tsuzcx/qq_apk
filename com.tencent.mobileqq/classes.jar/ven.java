import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class ven
  implements vfg
{
  ven(vem paramvem, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(vfr paramvfr)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramvfr == null) || (paramvfr.a == null))
    {
      vmp.a("WSLikeAnimationManger", "点赞失败:-1");
      paramvfr = this.jdField_a_of_type_Vem;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        vem.a(paramvfr, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      vbw.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramvfr.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramvfr = (stPostFeedDingRsp)paramvfr.a;
      if (paramvfr == null)
      {
        vmp.a("WSLikeAnimationManger", "服务器失败！！！");
        paramvfr = this.jdField_a_of_type_Vem;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          vem.a(paramvfr, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramvfr.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        vmp.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        vmp.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    vmp.a("WSLikeAnimationManger", "点赞失败:-2");
    paramvfr = this.jdField_a_of_type_Vem;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      vem.a(paramvfr, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ven
 * JD-Core Version:    0.7.0.1
 */