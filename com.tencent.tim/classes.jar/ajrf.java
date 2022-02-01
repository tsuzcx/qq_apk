import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyTribeAppController.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class ajrf
{
  private String TAG = "NearbyTribeAppController";
  private ahcj.b a = new ajrh(this);
  private String aTV;
  protected QQAppInterface app;
  private boolean bMu = true;
  private int dkO;
  private String[] fA = { acfp.m(2131708928), acfp.m(2131708931), "好看的人都在用兴趣部落APP", acfp.m(2131708934), acfp.m(2131708933) };
  private String[] fz = { acfp.m(2131708939), acfp.m(2131708938), "好看的人都在用兴趣部落APP", acfp.m(2131708937), acfp.m(2131708935), "看看好友在兴趣部落APP玩什么？" };
  private boolean isDestroy;
  private Context mContext;
  private Handler mMainThreadHandler;
  
  public ajrf(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.app = paramQQAppInterface;
  }
  
  public void J(TextView paramTextView)
  {
    String str = aqiz.O(this.mContext, "com.tencent.tribe");
    Random localRandom = new Random();
    int i;
    if (!"0".equals(str))
    {
      i = localRandom.nextInt(this.fA.length);
      this.dkO = (i + 1);
      this.aTV = this.fA[i];
      paramTextView.setText(this.aTV);
    }
    for (paramTextView = "exp_app_call";; paramTextView = "exp_app_download")
    {
      anot.a(this.app, "dc00899", "Grp_tribe", "", "user_profile", paramTextView, 0, 0, String.valueOf(this.dkO), "", "", "");
      return;
      i = localRandom.nextInt(this.fz.length);
      this.dkO = (i + 1);
      this.aTV = this.fz[i];
      paramTextView.setText(this.aTV);
    }
  }
  
  public void MU(String paramString)
  {
    try
    {
      this.bMu = true;
      QLog.e(this.TAG, 1, "这里已经下架，如果依然发现该log，异常case");
      ahch.a("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", new ajrg(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131708936), 0).show(50);
    }
  }
  
  public void dyS()
  {
    if (!aqiw.isNetworkAvailable(this.mContext)) {
      QQToast.a(this.mContext, 1, this.mContext.getString(2131696273), 0).show();
    }
    do
    {
      do
      {
        return;
        if ("0".equals(aqiz.O(this.mContext, "com.tencent.tribe"))) {
          break;
        }
      } while (!(this.mContext instanceof Activity));
      TroopBarPublishUtils.ck((Activity)this.mContext);
      anot.a(this.app, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_call", 0, 0, String.valueOf(this.dkO), "", "", "");
      return;
      if (this.bMu) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "invokeTribeOpenOrDownload,isActivate=false");
    return;
    ThreadManager.post(new NearbyTribeAppController.1(this), 8, null, true);
    anot.a(this.app, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_download", 0, 0, String.valueOf(this.dkO), "", "", "");
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
    this.mMainThreadHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrf
 * JD-Core Version:    0.7.0.1
 */