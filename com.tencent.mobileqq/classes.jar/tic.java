import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class tic
  extends tio
  implements tgt
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
    paramString = new the(new tkm(paramString, i), paramHandler, new tid(paramHandler, paramInt), 4300);
    tgx.a().a(paramString);
  }
  
  public void a(the paramthe)
  {
    if ((paramthe.a instanceof stPostFeedDingRsp))
    {
      paramthe = (stPostFeedDingRsp)paramthe.a;
      if (paramthe == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramthe.is_ding == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tic
 * JD-Core Version:    0.7.0.1
 */