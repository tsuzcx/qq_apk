import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;

final class olq
  implements oko
{
  olq(Handler paramHandler, int paramInt) {}
  
  public void a(okz paramokz)
  {
    Message localMessage = this.val$handler.obtainMessage();
    if ((paramokz == null) || (paramokz.bb == null))
    {
      localMessage.what = 4302;
      localMessage.obj = Integer.valueOf(-1);
      Log.e(olp.TAG, "点赞失败:-1");
    }
    for (;;)
    {
      this.val$handler.sendMessage(localMessage);
      return;
      if ((paramokz.bb instanceof stPostFeedDingRsp))
      {
        stPostFeedDingRsp localstPostFeedDingRsp = (stPostFeedDingRsp)paramokz.bb;
        if (localstPostFeedDingRsp == null)
        {
          Log.e(olp.TAG, "服务器失败！！！");
          localMessage.what = 4302;
          localMessage.obj = Integer.valueOf(paramokz.bfj);
        }
        else
        {
          int i = localstPostFeedDingRsp.is_ding;
          localMessage.what = 4301;
          localMessage.obj = Integer.valueOf(i);
          paramokz = new Intent("weishi_public_account_ding_state_change");
          paramokz.putExtra("position", this.val$position);
          paramokz.putExtra("is_ding", i);
          BaseApplication.getContext().sendBroadcast(paramokz);
          Log.e(olp.TAG, "发送了点赞广播");
          if (i == 0) {
            Log.e(olp.TAG, "请求后变成：没有点赞-by微视");
          } else {
            Log.e(olp.TAG, "请求后变成：已经点赞-by微视");
          }
        }
      }
      else
      {
        Log.e(olp.TAG, "点赞失败:-2");
        localMessage.what = 4302;
        localMessage.obj = Integer.valueOf(-2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olq
 * JD-Core Version:    0.7.0.1
 */