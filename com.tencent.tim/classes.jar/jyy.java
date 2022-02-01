import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.3;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.4;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.5;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.6;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.7;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.open.downloadnew.DownloadInfo;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class jyy
  implements aryx
{
  protected String Uv;
  protected jyt a;
  public int aED;
  protected int aEG;
  protected int aEv;
  protected boolean acY;
  public AdProgressButton b;
  public INetInfoHandler b;
  public View jn;
  protected QQAppInterface mApp;
  protected String mChannelId;
  protected Context mContext;
  protected String mInfo;
  protected AnimatorSet y;
  
  public static jyy a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramJSONObject.optInt("moduleType"))
        {
        case 1: 
          if (paramJSONObject == null) {
            return paramJSONObject;
          }
          paramJSONObject.mApp = paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      paramJSONObject = jzb.a(paramJSONObject.optJSONObject("singleImageModule"));
      continue;
      paramJSONObject = jze.a(paramJSONObject.optJSONObject("mixVideoModule"));
      continue;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (this.a == null) || (TextUtils.isEmpty(paramDownloadInfo.packageName)) || (TextUtils.isEmpty(paramDownloadInfo.appId)) || (TextUtils.isEmpty(this.a.mPackageName)) || (TextUtils.isEmpty(this.a.mAppid))) {}
    while ((!paramDownloadInfo.packageName.equals(this.a.mPackageName)) || (!paramDownloadInfo.appId.equals(this.a.mAppid))) {
      return false;
    }
    return true;
  }
  
  private void aBl()
  {
    if (!aqiw.isNetworkAvailable(this.mContext)) {
      return;
    }
    if (aqiw.isWifiConnected(this.mContext))
    {
      aBm();
      return;
    }
    aBn();
  }
  
  private void aBm()
  {
    jzk.a((Activity)this.mContext, this.a, this);
    if (this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton != null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839559);
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    }
    this.aED = 3;
    jzk.a(this.mApp, this.Uv, this.mChannelId, this.mInfo, 3, 2, 0);
  }
  
  private void aBn() {}
  
  private void aBo()
  {
    if (this.aED == 3)
    {
      aryy.a().fw(this.a.mAppid);
      ThreadManager.getUIHandler().post(new AdModuleBase.3(this));
    }
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, jyt paramjyt, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.Uv = paramString1;
    this.mChannelId = paramString2;
    this.mInfo = paramString3;
    this.aEv = paramInt;
    this.a = paramjyt;
    this.acY = paramBoolean;
    return null;
  }
  
  public abstract void aBp();
  
  public void d(Context paramContext, View paramView)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131560424, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((ViewGroup)paramView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (((this.a == null) || (this.a.MS != 1)) && (!this.acY) && ((this.aEv == 1) || (this.aEv == 2)))
    {
      paramView.findViewById(2131379726).setVisibility(0);
      if (this.aEv == 1) {
        paramView.findViewById(2131379730).setVisibility(8);
      }
      localObject1 = paramView.findViewById(2131381397);
      localObject2 = paramView.findViewById(2131381398);
      ((View)localObject1).setAlpha(0.0F);
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setAlpha(0.0F);
      ((View)localObject2).setVisibility(0);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(1800L);
      ((ObjectAnimator)localObject2).setRepeatCount(-1);
      ((ObjectAnimator)localObject2).setRepeatMode(1);
      ((ObjectAnimator)localObject2).setStartDelay(100L);
      ((ObjectAnimator)localObject1).setDuration(1800L);
      ((ObjectAnimator)localObject1).setRepeatCount(-1);
      ((ObjectAnimator)localObject1).setRepeatMode(1);
      ((ObjectAnimator)localObject1).setStartDelay(240L);
      this.y = new AnimatorSet();
      this.y.playTogether(new Animator[] { localObject2, localObject1 });
      this.y.start();
    }
    if ((this.acY) && (this.a != null) && (this.a.MS == 2)) {
      paramView.findViewById(2131366063).setVisibility(0);
    }
    try
    {
      localObject1 = new URL(this.a.mIconUrl);
      ((ResizeURLImageView)paramView.findViewById(2131366080)).setImage((URL)localObject1);
      ((TextView)paramView.findViewById(2131366074)).setText(this.a.Vf);
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)paramView.findViewById(2131373673));
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(paramContext.getResources().getColor(2131165409));
      this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(new jyz(this));
      int i = jzk.a(this.mContext, this.a);
      if (i >= 0)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839559);
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(i);
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
        this.aED = 3;
        aryy.a().a(this);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new jza(this);
        AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDestroy()
  {
    this.jn = null;
    if (this.y != null)
    {
      this.y.cancel();
      this.y = null;
    }
    this.aEG = 0;
    if (this.acY) {
      aryy.a().b(this);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.5(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.7(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new AdModuleBase.4(this));
      jzk.a(this.mApp, this.Uv, this.mChannelId, this.mInfo, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new AdModuleBase.6(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void onResume()
  {
    if ((this.acY) && (this.jn != null) && (this.a != null) && (this.a.MS == 2))
    {
      AdProgressButton localAdProgressButton = (AdProgressButton)this.jn.findViewById(2131373673);
      if (this.a.mJumpType != 2) {
        break label58;
      }
    }
    label58:
    do
    {
      do
      {
        return;
      } while (this.a.mJumpType != 1);
      if (jzk.C(this.mContext, this.a.mPackageName))
      {
        this.aED = 1;
        return;
      }
      if (jzk.a(this.mContext, this.a))
      {
        this.aED = 2;
        return;
      }
    } while (this.aED == 3);
    this.aED = 0;
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyy
 * JD-Core Version:    0.7.0.1
 */