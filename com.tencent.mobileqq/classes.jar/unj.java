import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.util.WeakReference;

public class unj
  extends QQCustomDialog
{
  private static WeakReference<unj> a;
  
  public unj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      unj localunj = (unj)a.get();
      if (localunj != null)
      {
        if (unq.b()) {
          uya.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localunj.dismiss();
          return;
          uya.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (unq.b())
      {
        uya.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      uya.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    uya.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = unq.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    uvi.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (unq.b()) {
        uya.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new unj(paramActivity, 2131755826);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(amtj.a(2131716012), new unk());
          a = new WeakReference(paramActivity);
        }
        ((unj)a.get()).show();
        return;
        uya.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      uya.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
    }
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (a(paramActivity, paramWSDownloadParams))
    {
      a(115, paramWSDownloadParams);
      a(paramActivity);
      return;
    }
    Log.e("WeishiDownloadUtil", "QQ download start error");
  }
  
  public static void a(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    unj localunj = new unj(paramActivity, 2131755826);
    localunj.setTitle("来腾讯微视，创造挖掘神评论");
    localunj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localunj.setPositiveButton(amtj.a(2131716014), new unl(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localunj.setNegativeButton(amtj.a(2131716013), new unm(i, paramInt));
      localunj.show();
      uvr.b(6, 0, 0);
      uvi.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = uvr.b();
    return unq.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131559016);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (unq.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    unj localunj = new unj(paramActivity, 2131755826);
    localunj.setTitle(amtj.a(2131716015));
    localunj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localunj.setPositiveButton(amtj.a(2131716011), new unn(paramActivity, paramWSDownloadParams));
    localunj.setNegativeButton(amtj.a(2131716013), new uno(paramWSDownloadParams));
    localunj.show();
    uvr.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unj
 * JD-Core Version:    0.7.0.1
 */