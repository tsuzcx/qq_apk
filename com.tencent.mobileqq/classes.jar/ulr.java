import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;

final class ulr
  implements ukd
{
  ulr(Handler paramHandler, int paramInt) {}
  
  public void a(uko paramuko)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    if ((paramuko == null) || (paramuko.jdField_a_of_type_JavaLangObject == null))
    {
      localMessage.what = 4302;
      localMessage.obj = Integer.valueOf(-1);
      Log.e(ulq.a, "点赞失败:-1");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stPostFeedDingRsp))
      {
        stPostFeedDingRsp localstPostFeedDingRsp = (stPostFeedDingRsp)paramuko.jdField_a_of_type_JavaLangObject;
        if (localstPostFeedDingRsp == null)
        {
          Log.e(ulq.a, "服务器失败！！！");
          localMessage.what = 4302;
          localMessage.obj = Integer.valueOf(paramuko.jdField_a_of_type_Int);
        }
        else
        {
          int i = localstPostFeedDingRsp.is_ding;
          localMessage.what = 4301;
          localMessage.obj = Integer.valueOf(i);
          paramuko = new Intent("weishi_public_account_ding_state_change");
          paramuko.putExtra("position", this.jdField_a_of_type_Int);
          paramuko.putExtra("is_ding", i);
          BaseApplication.getContext().sendBroadcast(paramuko);
          Log.e(ulq.a, "发送了点赞广播");
          if (i == 0) {
            Log.e(ulq.a, "请求后变成：没有点赞-by微视");
          } else {
            Log.e(ulq.a, "请求后变成：已经点赞-by微视");
          }
        }
      }
      else
      {
        Log.e(ulq.a, "点赞失败:-2");
        localMessage.what = 4302;
        localMessage.obj = Integer.valueOf(-2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulr
 * JD-Core Version:    0.7.0.1
 */