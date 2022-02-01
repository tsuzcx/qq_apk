import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class ulq
  extends umc
  implements ukd
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
    paramString = new uko(new uox(paramString, i), paramHandler, new ulr(paramHandler, paramInt), 4300);
    ukh.a().a(paramString);
  }
  
  public void a(uko paramuko)
  {
    if ((paramuko.a instanceof stPostFeedDingRsp))
    {
      paramuko = (stPostFeedDingRsp)paramuko.a;
      if (paramuko == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramuko.is_ding == 0)
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
 * Qualified Name:     ulq
 * JD-Core Version:    0.7.0.1
 */