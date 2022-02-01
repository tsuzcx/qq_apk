import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class ugq
  extends bgpa
{
  private static WeakReference<ugq> a;
  
  public ugq(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    if (a != null)
    {
      ugq localugq = (ugq)a.get();
      if (localugq != null)
      {
        if (ugx.b()) {
          upe.c("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localugq.dismiss();
          return;
          upe.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (ugx.b())
      {
        upe.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      upe.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    upe.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = ugx.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    umq.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (ugx.b()) {
        upe.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((a == null) || (a.get() == null))
        {
          paramActivity = new ugq(paramActivity, 2131755823);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton(anni.a(2131715669), new ugr());
          a = new WeakReference(paramActivity);
        }
        ((ugq)a.get()).show();
        return;
        upe.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      upe.d("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
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
    ugq localugq = new ugq(paramActivity, 2131755823);
    localugq.setTitle("来腾讯微视，创造挖掘神评论");
    localugq.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localugq.setPositiveButton(anni.a(2131715671), new ugs(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localugq.setNegativeButton(anni.a(2131715670), new ugt(i, paramInt));
      localugq.show();
      umw.b(6, 0, 0);
      umq.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = umw.b();
    return ugx.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131559009);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (ugx.c())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    ugq localugq = new ugq(paramActivity, 2131755823);
    localugq.setTitle(anni.a(2131715672));
    localugq.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localugq.setPositiveButton(anni.a(2131715668), new ugu(paramActivity, paramWSDownloadParams));
    localugq.setNegativeButton(anni.a(2131715670), new ugv(paramWSDownloadParams));
    localugq.show();
    umw.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */