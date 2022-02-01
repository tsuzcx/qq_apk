import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class uks
  extends ule
  implements ujj
{
  public static String a = "weishi";
  
  public static void a(String paramString, boolean paramBoolean, int paramInt, Handler paramHandler)
  {
    int i = 1;
    if (!paramBoolean)
    {
      i = 2;
      Log.e(a, "此次是取消点赞：---------------");
    }
    paramString = new uju(new unw(paramString, i), paramHandler, new ukt(paramHandler, paramInt), 4300);
    ujn.a().a(paramString);
  }
  
  public void a(uju paramuju)
  {
    if ((paramuju.a instanceof stPostFeedDingRsp))
    {
      paramuju = (stPostFeedDingRsp)paramuju.a;
      if (paramuju == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramuju.is_ding == 0)
      {
        Log.e(a, "没有点赞~~~~~~~~~~~~~~~~");
        return;
      }
      Log.e(a, "已经点赞~~~~~~~~~~~~~~~~");
      return;
    }
    Log.e(a, "真无语！！！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uks
 * JD-Core Version:    0.7.0.1
 */