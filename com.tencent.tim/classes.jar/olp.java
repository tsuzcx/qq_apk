import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class olp
  extends omb
  implements oko
{
  public static String TAG = "weishi";
  
  public static void b(String paramString, boolean paramBoolean, int paramInt, Handler paramHandler)
  {
    int i = 1;
    if (!paramBoolean)
    {
      i = 2;
      Log.e(TAG, "此次是取消点赞：---------------");
    }
    paramString = new okz(new ony(paramString, i), paramHandler, new olq(paramHandler, paramInt), 4300);
    oks.a().b(paramString);
  }
  
  public void a(okz paramokz)
  {
    if ((paramokz.bb instanceof stPostFeedDingRsp))
    {
      paramokz = (stPostFeedDingRsp)paramokz.bb;
      if (paramokz == null)
      {
        Log.e(TAG, "服务器失败！！！");
        return;
      }
      if (paramokz.is_ding == 0)
      {
        Log.e(TAG, "没有点赞~~~~~~~~~~~~~~~~");
        return;
      }
      Log.e(TAG, "已经点赞~~~~~~~~~~~~~~~~");
      return;
    }
    Log.e(TAG, "真无语！！！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olp
 * JD-Core Version:    0.7.0.1
 */