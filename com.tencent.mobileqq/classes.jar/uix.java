import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;

class uix
  implements ujj
{
  uix(uiw paramuiw, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void a(uju paramuju)
  {
    int j = 0;
    int i = 0;
    LikeRspEvent localLikeRspEvent = new LikeRspEvent(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramuju == null) || (paramuju.a == null))
    {
      upe.a("WSLikeAnimationManger", "点赞失败:-1");
      paramuju = this.jdField_a_of_type_Uiw;
      str = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        uiw.a(paramuju, str, localLikeRspEvent, i);
      }
    }
    for (;;)
    {
      uhd.a().a(localLikeRspEvent);
      return;
      i = 1;
      break;
      if (!(paramuju.a instanceof stPostFeedDingRsp)) {
        break label189;
      }
      paramuju = (stPostFeedDingRsp)paramuju.a;
      if (paramuju == null)
      {
        upe.a("WSLikeAnimationManger", "服务器失败！！！");
        paramuju = this.jdField_a_of_type_Uiw;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          uiw.a(paramuju, str, localLikeRspEvent, i);
          break;
          i = 1;
        }
      }
      i = paramuju.is_ding;
      localLikeRspEvent.setRpsStatus(4301);
      localLikeRspEvent.setRspIsDing(i);
      if (i == 0) {
        upe.a("WSLikeAnimationManger", "请求后变成：没有点赞-by微视");
      } else {
        upe.a("WSLikeAnimationManger", "请求后变成：已经点赞-by微视");
      }
    }
    label189:
    upe.a("WSLikeAnimationManger", "点赞失败:-2");
    paramuju = this.jdField_a_of_type_Uiw;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      uiw.a(paramuju, str, localLikeRspEvent, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uix
 * JD-Core Version:    0.7.0.1
 */