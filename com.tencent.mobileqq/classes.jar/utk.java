import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class utk
  extends utw
  implements uqy
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
    paramString = new urj(new uwr(paramString, i), paramHandler, new utl(paramHandler, paramInt), 4300);
    urc.a().a(paramString);
  }
  
  public void a(urj paramurj)
  {
    if ((paramurj.a instanceof stPostFeedDingRsp))
    {
      paramurj = (stPostFeedDingRsp)paramurj.a;
      if (paramurj == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramurj.is_ding == 0)
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
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */