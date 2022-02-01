import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.util.WeakReference;

public class vbj
  extends QQCustomDialog
{
  private static WeakReference<vbj> a;
  
  public vbj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      vbj localvbj = (vbj)a.get();
      if (localvbj != null)
      {
        if (vbq.b()) {
          vmp.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localvbj.dismiss();
          return;
          vmp.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (vbq.b())
      {
        vmp.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      vmp.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    vmp.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = vbq.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    vjx.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (vbq.b()) {
        vmp.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new vbj(paramActivity, 2131755829);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(anvx.a(2131716360), new vbk());
          a = new WeakReference(paramActivity);
        }
        ((vbj)a.get()).show();
        return;
        vmp.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      vmp.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    vbj localvbj = new vbj(paramActivity, 2131755829);
    localvbj.setTitle("来腾讯微视，创造挖掘神评论");
    localvbj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localvbj.setPositiveButton(anvx.a(2131716362), new vbl(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localvbj.setNegativeButton(anvx.a(2131716361), new vbm(i, paramInt));
      localvbj.show();
      vkf.b(6, 0, 0);
      vjx.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = vkf.b();
    return vbq.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131559043);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (vbq.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    vbj localvbj = new vbj(paramActivity, 2131755829);
    localvbj.setTitle(anvx.a(2131716363));
    localvbj.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localvbj.setPositiveButton(anvx.a(2131716359), new vbn(paramActivity, paramWSDownloadParams));
    localvbj.setNegativeButton(anvx.a(2131716361), new vbo(paramWSDownloadParams));
    localvbj.show();
    vkf.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbj
 * JD-Core Version:    0.7.0.1
 */