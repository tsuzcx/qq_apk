import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class mvj
  implements View.OnClickListener
{
  private static final String TAG = mvj.class.getSimpleName();
  private int aUT = -1;
  private boolean aoH;
  private Activity mActivity;
  private QQAppInterface mApp;
  
  mvj(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
  }
  
  private boolean EB()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(179);
    if (localAladdinConfig == null) {
      return true;
    }
    if (localAladdinConfig.getIntegerFromString("like_action_download_bar_is_display", 1) == 1) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      i = localAladdinConfig.getIntegerFromString("like_action_download_bar_display_count_every_day", 2147483647);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "innerCheckIsNeedShow() 神灯配置 isNeedDisplay=" + bool + ", displayCountEveryDay=" + i);
      }
      if (bool) {
        break;
      }
      return false;
    }
    if (this.aUT < 0) {
      this.aUT = awit.M(this.mApp);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "innerCheckIsNeedShow() 本地显示次数(更新前) mLocalShowCountToday=" + this.aUT);
    }
    if (this.aUT < i)
    {
      this.aUT += 1;
      return true;
    }
    return false;
  }
  
  private boolean j(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.a == null) || (TextUtils.isEmpty(paramVideoInfo.a.Xx)) || (paramVideoInfo.a.c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "innerCheckAdParamValid() 参数无效");
      }
      return false;
    }
    return true;
  }
  
  private void z(VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramVideoInfo.a == null) {
        break label89;
      }
      str1 = paramVideoInfo.a.WT;
      localJSONObject.put("common_data", str1);
    }
    catch (Exception localException)
    {
      String str1;
      label31:
      String str2;
      break label31;
    }
    str2 = paramVideoInfo.hH;
    if (!TextUtils.isEmpty(paramVideoInfo.Wz)) {}
    for (str1 = paramVideoInfo.Wz;; str1 = "0")
    {
      kbp.a(null, str2, "0X800A018", "0X800A018", 0, 0, "0", "0", str1, kct.a("", paramVideoInfo.hH, paramVideoInfo.vid, paramVideoInfo.Wz, localJSONObject), false);
      return;
      label89:
      str1 = "";
      break;
    }
  }
  
  boolean EA()
  {
    return this.aoH;
  }
  
  void a(VideoInfo paramVideoInfo, mtg.k paramk)
  {
    if ((paramk.bn != null) && (paramk.bn.getVisibility() == 0)) {}
    do
    {
      do
      {
        return;
      } while ((paramk.a != null) && (paramk.a.d != null) && (!paramk.a.d.adM));
      if ((!j(paramVideoInfo)) || (!EB())) {
        break;
      }
      this.aoH = true;
      if (paramk.bn == null)
      {
        paramk.bn = ((ViewGroup)((ViewStub)paramk.bt.findViewById(2131381679)).inflate());
        paramk.y = ((URLImageView)paramk.bn.findViewById(2131378324));
        paramk.rK = ((TextView)paramk.bn.findViewById(2131378325));
      }
    } while (paramk.bn.getVisibility() == 0);
    if (!TextUtils.isEmpty(paramVideoInfo.a.logoUrl)) {}
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqnm.dip2px(32.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqnm.dip2px(32.0F);
      localObject = URLDrawable.getDrawable(paramVideoInfo.a.logoUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(new int[] { 0, 0, aqcx.dip2px(this.mApp.getApp(), 3.0F), 3 });
      ((URLDrawable)localObject).setDecodeHandler(aqbn.j);
      paramk.y.setImageDrawable((Drawable)localObject);
      label235:
      paramk.rK.setText(paramVideoInfo.a.Xx);
      paramk.bn.setOnClickListener(this);
      paramk.bn.setTag(paramVideoInfo);
      paramk.bn.setVisibility(0);
      muj.a(paramk.bn, 200);
      return;
      this.aoH = false;
      return;
    }
    catch (Exception localException)
    {
      break label235;
    }
  }
  
  void b(mtg.k paramk)
  {
    if ((paramk.bn != null) && (paramk.bn.getVisibility() == 0)) {
      paramk.bn.setVisibility(8);
    }
  }
  
  void doOnDestory()
  {
    if (this.aUT > 0) {
      awit.J(this.mApp, this.aUT);
    }
  }
  
  public void onClick(View paramView)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramView.getTag();
    muj.a(this.mActivity, localVideoInfo.a.c);
    z(localVideoInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvj
 * JD-Core Version:    0.7.0.1
 */