import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class ugs
  extends bhpc
{
  private static WeakReference<ugs> a;
  
  public ugs(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      ugs localugs = (ugs)a.get();
      if (localugs != null)
      {
        if (ugz.b()) {
          uqf.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localugs.dismiss();
          return;
          uqf.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (ugz.b())
      {
        uqf.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      uqf.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    uqf.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = ugz.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    uno.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (ugz.b()) {
        uqf.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new ugs(paramActivity, 2131755824);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(anzj.a(2131715778), new ugt());
          a = new WeakReference(paramActivity);
        }
        ((ugs)a.get()).show();
        return;
        uqf.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      uqf.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    ugs localugs = new ugs(paramActivity, 2131755824);
    localugs.setTitle("来腾讯微视，创造挖掘神评论");
    localugs.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localugs.setPositiveButton(anzj.a(2131715780), new ugu(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localugs.setNegativeButton(anzj.a(2131715779), new ugv(i, paramInt));
      localugs.show();
      unx.b(6, 0, 0);
      uno.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = unx.b();
    return ugz.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131559008);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (ugz.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    ugs localugs = new ugs(paramActivity, 2131755824);
    localugs.setTitle(anzj.a(2131715781));
    localugs.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localugs.setPositiveButton(anzj.a(2131715777), new ugw(paramActivity, paramWSDownloadParams));
    localugs.setNegativeButton(anzj.a(2131715779), new ugx(paramWSDownloadParams));
    localugs.show();
    unx.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugs
 * JD-Core Version:    0.7.0.1
 */