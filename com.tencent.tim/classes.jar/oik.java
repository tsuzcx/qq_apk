import UserGrowth.stReportItem;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import mqq.util.WeakReference;

public class oik
  extends aqju
{
  private static WeakReference<oik> B;
  
  public oik(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    init();
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramWSDownloadParams == null) || (paramWSDownloadParams.mStReportItem == null)) {
      return;
    }
    paramWSDownloadParams.mStReportItem.downloadscene = oir.e(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
    ond.a(paramInt, paramWSDownloadParams.mStReportItem);
  }
  
  public static void a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (a(paramActivity, paramWSDownloadParams))
    {
      a(115, paramWSDownloadParams);
      aX(paramActivity);
      return;
    }
    Log.e("WeishiDownloadUtil", "QQ download start error");
  }
  
  public static void a(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams, int paramInt)
  {
    oik localoik = new oik(paramActivity, 2131756467);
    localoik.setTitle("来腾讯微视，创造挖掘神评论");
    localoik.setMessage("️⬆完成安装即可领取最高188红包⬆");
    if (paramWSDownloadParams.mStReportItem == null) {}
    for (int i = paramWSDownloadParams.mScene;; i = paramWSDownloadParams.mStReportItem.pagetype)
    {
      localoik.setPositiveButton("", new oim(paramActivity, paramString, paramWSDownloadParams, i, paramInt));
      localoik.setNegativeButton("", new oin(i, paramInt));
      localoik.show();
      ong.X(6, 0, 0);
      ond.a(6, i, paramInt, null);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = ong.lD();
    return oir.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  public static void aX(Activity paramActivity)
  {
    try
    {
      if (oir.isQzoneProcess()) {
        ooz.e("WeishiDownloadUtil", "弹出qzone弹窗---");
      }
      for (;;)
      {
        if ((B == null) || (B.get() == null))
        {
          paramActivity = new oik(paramActivity, 2131756467);
          paramActivity.setTitle("正在下载腾讯微视APP");
          paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
          paramActivity.setPositiveButton("", new oil());
          B = new WeakReference(paramActivity);
        }
        ((oik)B.get()).show();
        return;
        ooz.e("WeishiDownloadUtil", "弹出qq弹窗");
      }
      return;
    }
    catch (Exception paramActivity)
    {
      ooz.e("WeishiDownloadUtil", "showDownloadDialog error:" + paramActivity.getLocalizedMessage());
    }
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (oir.isDownloading())
    {
      a(paramActivity, paramWSDownloadParams);
      return;
    }
    oik localoik = new oik(paramActivity, 2131756467);
    localoik.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localoik.setPositiveButton("", new oio(paramActivity, paramWSDownloadParams));
    localoik.setNegativeButton("", new oip(paramWSDownloadParams));
    localoik.show();
    ong.i(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
  
  public static void beW()
  {
    if (B != null)
    {
      oik localoik = (oik)B.get();
      if (localoik != null)
      {
        if (oir.isQzoneProcess()) {
          ooz.w("WeishiDownloadUtil", "关闭qzone弹窗");
        }
        for (;;)
        {
          localoik.dismiss();
          return;
          ooz.w("WeishiDownloadUtil", "关闭qq弹窗");
        }
      }
      if (oir.isQzoneProcess())
      {
        ooz.e("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      ooz.e("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    ooz.e("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  private void init()
  {
    setContentView(2131559151);
    setCanceledOnTouchOutside(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oik
 * JD-Core Version:    0.7.0.1
 */