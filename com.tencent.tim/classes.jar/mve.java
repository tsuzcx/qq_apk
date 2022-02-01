import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.d;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mve
{
  public static final String TAG = mve.class.getSimpleName();
  private VideoFeedsPlayManager.d jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private mtg jdField_a_of_type_Mtg;
  private int aUQ;
  private int aUR;
  private int aUS;
  private boolean anU;
  private boolean aoA;
  private boolean aoB;
  private boolean aoC;
  private boolean aoD;
  private boolean aoE;
  private boolean aoF;
  private VideoInfo.InterruptedWeishiAd jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
  private mtg.k jdField_b_of_type_Mtg$k;
  private SparseBooleanArray h;
  private Activity mActivity;
  private QQAppInterface mApp;
  private String mConfigStr;
  private int mLastPosition = -1;
  
  public mve(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager.d paramd, VideoFeedsPlayManager paramVideoFeedsPlayManager, mtg parammtg, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d = paramd;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Mtg = parammtg;
    this.aoA = false;
    this.aoB = false;
    this.aoC = false;
    this.aoD = false;
    this.anU = paramBoolean;
  }
  
  private boolean Ey()
  {
    boolean bool = true;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) || (this.jdField_b_of_type_Mtg$k == null)) {
      bool = false;
    }
    int i;
    do
    {
      do
      {
        return bool;
        i = this.jdField_b_of_type_Mtg$k.aUv;
        switch (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type)
        {
        default: 
          return false;
        }
      } while ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.adUrl)) && (this.h != null) && (this.h.get(i)) && (!this.aoF));
      return false;
    } while ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appIconUrl)) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appName)) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WQ)) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WR)) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b != null) && (this.h.get(i)));
    return false;
  }
  
  private boolean Ez()
  {
    Object localObject;
    if (!this.aoA)
    {
      this.aoA = true;
      this.mConfigStr = awit.h(this.mApp);
      localObject = awit.i(this.mApp);
      boolean bool = awit.K(this.mApp);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkIsNeedShowInterruptedAd() 后台下发原始配置：" + this.mConfigStr + "\n本地副本配置：" + (String)localObject + "\n本地副本配置是否为当天：" + bool);
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.mConfigStr = ((String)localObject);
      }
      if (TextUtils.isEmpty(this.mConfigStr)) {}
    }
    try
    {
      localObject = new JSONObject(this.mConfigStr);
      if (this.anU) {}
      for (localObject = ((JSONObject)localObject).getJSONObject("weishi"); localObject == null; localObject = ((JSONObject)localObject).getJSONObject("default"))
      {
        this.mConfigStr = null;
        return false;
      }
      int i = ((JSONObject)localObject).getInt("display_count_each_entrance");
      this.aUQ = i;
      this.aUS = i;
      this.aUR = ((JSONObject)localObject).getInt("display_count_each_day");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checkIsNeedShowInterruptedAd() 初始剩余次数 mDisplayCountEachEntrance = " + this.aUQ + ", mDisplayCountEachDay = " + this.aUR);
      }
      if ((this.aUR > 0) && (this.aUQ > 0))
      {
        this.aUR -= 1;
        this.aUQ -= 1;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "checkIsNeedShowInterruptedAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = " + this.aUQ + ", mDisplayCountEachDay = " + this.aUR);
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      this.mConfigStr = null;
    }
    return false;
  }
  
  private void aSv()
  {
    this.aoF = true;
    switch (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnPause();
      }
      Object localObject = Boolean.valueOf(awit.G(kxm.getAppRuntime()));
      WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
      localBundle.putBoolean("public_account_finish_animation_out_to_bottom", true);
      localBundle.putBoolean("KEY_SLIDE_RIGHT_BACK_ENABLE", false);
      localWebViewTitleStyle.statusBarColor = -16777216;
      localWebViewTitleStyle.wP = -1;
      localWebViewTitleStyle.titleColor = -16777216;
      localWebViewTitleStyle.edP = -16777216;
      localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
      if (((Boolean)localObject).booleanValue()) {}
      for (;;)
      {
        if (!((Boolean)localObject).booleanValue()) {
          this.mActivity.overridePendingTransition(2130772009, 0);
        }
        if (!this.anU) {
          break;
        }
        try
        {
          int i = this.mActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          localObject = this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
          kbp.a(null, null, "0X800933E", "0X800933E", 0, 0, String.valueOf(i), "", "", kct.a(null, null, ((VideoInfo)localObject).vid, ((VideoInfo)localObject).Wz, null), false);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        kxm.a(this.mActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.adUrl, localBundle);
      }
    }
    aSw();
    aSx();
    this.jdField_b_of_type_Mtg$k.lB.setVisibility(0);
  }
  
  private void aSw()
  {
    if ((this.jdField_b_of_type_Mtg$k.lB == null) && ((this.jdField_b_of_type_Mtg$k.itemView instanceof ViewGroup)))
    {
      View localView = View.inflate(this.mActivity, 2131560524, (ViewGroup)this.jdField_b_of_type_Mtg$k.itemView);
      this.jdField_b_of_type_Mtg$k.lB = localView.findViewById(2131368259);
      this.jdField_b_of_type_Mtg$k.lC = localView.findViewById(2131368238);
      this.jdField_b_of_type_Mtg$k.jK = ((ImageView)localView.findViewById(2131368249));
      this.jdField_b_of_type_Mtg$k.rq = ((TextView)localView.findViewById(2131368260));
      this.jdField_b_of_type_Mtg$k.rL = ((TextView)localView.findViewById(2131368267));
      this.jdField_b_of_type_Mtg$k.rM = ((TextView)localView.findViewById(2131368247));
      this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView = ((CircleCountdownView)localView.findViewById(2131368264));
    }
  }
  
  private void aSx()
  {
    Resources localResources;
    Object localObject;
    if ((this.jdField_b_of_type_Mtg$k != null) && (this.jdField_b_of_type_Mtg$k.rM != null))
    {
      localResources = this.mActivity.getResources();
      if (this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
      {
        if (aqiz.isAppInstalled(this.mActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b.aiM)) {
          break label300;
        }
        this.jdField_b_of_type_Mtg$k.rM.setText(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WQ);
        localObject = localResources.getDrawable(2130843913);
      }
    }
    for (;;)
    {
      int i = wja.dp2px(12.0F, localResources);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      this.jdField_b_of_type_Mtg$k.rM.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_b_of_type_Mtg$k.rM.setOnClickListener(new mvf(this));
      this.jdField_b_of_type_Mtg$k.rL.setOnClickListener(new mvg(this));
      this.jdField_b_of_type_Mtg$k.rq.setText(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appName);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appIconUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_Mtg$k.jK.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_Mtg$k.lB.setOnClickListener(null);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("uin", this.mApp.getCurrentAccountUin());
        label244:
        kbp.a(null, null, "0X8009BF0", "0X8009BF0", 0, 0, "", "", "", kct.a(null, null, this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.vid, this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz, (JSONObject)localObject), false);
        return;
        label300:
        this.jdField_b_of_type_Mtg$k.rM.setText(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WR);
        localObject = localResources.getDrawable(2130843916);
      }
      catch (Exception localException)
      {
        break label244;
      }
    }
  }
  
  public boolean Ev()
  {
    return this.aoF;
  }
  
  public boolean Ew()
  {
    if (!Ey()) {}
    while ((this.aoC) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type != 0) || (!this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.adN) || (!Ez())) {
      return false;
    }
    aSv();
    this.aoC = true;
    return true;
  }
  
  public boolean Ex()
  {
    if (!Ey()) {}
    while ((this.aoD) || ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type != 1) && (!this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.adO)) || (!Ez())) {
      return false;
    }
    aSv();
    this.aoD = true;
    this.aoE = this.aoF;
    return true;
  }
  
  public void a(VideoInfo.InterruptedWeishiAd paramInterruptedWeishiAd)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramInterruptedWeishiAd;
    }
    if (this.h == null)
    {
      this.h = new SparseBooleanArray();
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.db != null))
      {
        paramInterruptedWeishiAd = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.db;
        int j = paramInterruptedWeishiAd.length;
        int i = 0;
        while (i < j)
        {
          int k = paramInterruptedWeishiAd[i];
          this.h.put(k - 1, true);
          i += 1;
        }
      }
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel())) {
      QLog.d(TAG, 2, "setInterruptedAdInfo() interruptedAdInfo = " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.toString());
    }
  }
  
  public boolean a(mtg.k paramk, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Mtg$k != null) {}
    for (int i = this.jdField_b_of_type_Mtg$k.aUv;; i = 0)
    {
      if ((paramk.aUv > i) && (paramBoolean)) {
        Ew();
      }
      if ((this.jdField_b_of_type_Mtg$k != null) && (this.jdField_b_of_type_Mtg$k.lB != null)) {
        this.jdField_b_of_type_Mtg$k.lB.setVisibility(8);
      }
      this.jdField_b_of_type_Mtg$k = paramk;
      if ((this.mLastPosition >= 0) && (this.h != null) && (this.h.indexOfKey(this.mLastPosition) >= 0) && ((this.aoD) || (this.aoC) || (this.aoB))) {
        this.h.delete(this.mLastPosition);
      }
      this.mLastPosition = paramk.aUv;
      this.aoB = false;
      this.aoC = false;
      this.aoD = false;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel())) {
        QLog.d(TAG, 2, "setPlayingVideoInfo() itemHolder.position=" + paramk.aUv);
      }
      return dV(0) | false;
    }
  }
  
  public boolean dV(int paramInt)
  {
    if (!Ey()) {}
    while ((this.aoB) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type != 0) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.aHs < 0) || (paramInt < this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.aHs) || (!Ez())) {
      return false;
    }
    aSv();
    this.aoB = true;
    return true;
  }
  
  public void doOnDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "doOnDestory() mIsConfigInited = " + this.aoA);
    }
    if ((this.aoA) && (!TextUtils.isEmpty(this.mConfigStr))) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.mConfigStr);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("display_count_each_entrance", this.aUS);
        localJSONObject2.put("display_count_each_day", this.aUR);
        if (this.anU) {}
        for (String str = "weishi";; str = "default")
        {
          localJSONObject1.put(str, localJSONObject2);
          awit.R(this.mApp, localJSONObject1.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG, 2, "doOnDestory() 本地配置更新成功，mConfigStr = " + localJSONObject1.toString());
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "doOnDestory() 本地配置更新失败，error = " + localException.getMessage());
        }
      }
    }
  }
  
  public void doOnResume()
  {
    VideoFeedsPlayManager.d locald;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.type == 0) && (this.aoE))
    {
      locald = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d;
      if (this.jdField_b_of_type_Mtg$k == null) {
        break label55;
      }
    }
    label55:
    for (VideoFeedsPlayManager.b localb = this.jdField_b_of_type_Mtg$k.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b;; localb = null)
    {
      locald.r(localb);
      this.aoF = false;
      this.aoE = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mve
 * JD-Core Version:    0.7.0.1
 */