package com.tencent.biz.pubaccount.readinjoy.ad.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import ayxa;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import jzk;
import kks;
import kkt;
import kku.a;
import kkw;
import knq;
import kwz;
import mqq.os.MqqHandler;
import muj;
import mwl;
import ods;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyAdPKFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private ImageButton P;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private AdvertisementInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private KandianUrlImageView c;
  private Runnable cy = new ReadinjoyAdPKFragment.1(this);
  private Bitmap mBitmap;
  private Context mContext;
  private View mRootView;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private TextView og;
  private TextView oh;
  private TextView oi;
  private TextView oj;
  
  public static void a(Activity paramActivity, Class<? extends ReadinjoyAdPKFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "error");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtras(paramBundle);
    PublicFragmentActivity.b.start(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, String paramString, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
    localURLDrawableOptions.mRequestHeight = paramKandianUrlImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      if (paramBoolean) {
        paramString.setDecodeHandler(aqbn.b);
      }
      paramKandianUrlImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramKandianUrlImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoyAdPKFragment", 2, "loadImage ERROR e = " + paramKandianUrlImageView.getMessage());
    }
  }
  
  private void aDZ()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)getArguments().getParcelable("param_ad_info");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "PARAM_AD_INFO: null");
      }
      getActivity().finish();
      return;
    }
    localAdvertisementInfo.resetClickPos();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.mRootView.findViewById(2131362152));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.mRootView.findViewById(2131362116));
    this.og = ((TextView)this.mRootView.findViewById(2131362118));
    this.oh = ((TextView)this.mRootView.findViewById(2131380976));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.mRootView.findViewById(2131368915));
    this.c = ((KandianUrlImageView)this.mRootView.findViewById(2131368930));
    this.oi = ((TextView)this.mRootView.findViewById(2131380778));
    this.oj = ((TextView)this.mRootView.findViewById(2131380903));
    this.P = ((ImageButton)this.mRootView.findViewById(2131371280));
    this.oi.setOnClickListener(this);
    this.oj.setOnClickListener(this);
    this.mRootView.findViewById(2131371280).setOnClickListener(this);
    URL localURL = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
    Object localObject;
    if (localURL != null) {
      localObject = localURL.getFile();
    }
    for (;;)
    {
      if (localURL != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (String)localObject, false);
        kwz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, this.mContext, true);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName)) {
          this.og.setText(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, true);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle)) {
          this.oh.setText(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle);
        }
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.gi.size() >= 2))
        {
          localObject = (kkt)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.gi.get(0);
          if (localObject != null)
          {
            if (!TextUtils.isEmpty(((kkt)localObject).buttonTxt)) {
              this.oi.setText(((kkt)localObject).buttonTxt);
            }
            if (!TextUtils.isEmpty(((kkt)localObject).aal)) {
              a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((kkt)localObject).aal, false);
            }
          }
          localObject = (kkt)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.gi.get(1);
          if (localObject != null)
          {
            if (!TextUtils.isEmpty(((kkt)localObject).buttonTxt)) {
              this.oj.setText(((kkt)localObject).buttonTxt);
            }
            if (!TextUtils.isEmpty(((kkt)localObject).aal)) {
              a(this.c, ((kkt)localObject).aal, false);
            }
          }
        }
        localObject = knq.get(1);
        if ((localObject != null) && ((localObject instanceof Bitmap))) {
          this.mBitmap = ((Bitmap)localObject);
        }
        ThreadManager.getSubThreadHandler().post(this.cy);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("comp_stat_src", "12");
        jzk.a(new kku.a().a(getActivity()).a(jzk.aEK).b(jzk.aFU).a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e((JSONObject)localObject).a(true).a());
        return;
        localObject = null;
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(4);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void pi(int paramInt)
  {
    Object localObject = new kks();
    ((kks)localObject).afY = true;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = paramInt;
    if ((!ods.a(ods.a(this.mContext, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, (kks)localObject), getActivity(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJA != 32))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = true;
      ods.a((Activity)this.mContext, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true, false, (kks)localObject);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = false;
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("comp_stat_src", "12");
      jzk.a(new kku.a().a(getActivity()).a(jzk.aEJ).b(jzk.aFU).a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e((JSONObject)localObject).d(paramInt).a(true).a());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pi(101);
      continue;
      pi(102);
      continue;
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aDZ();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = mwl.a(2131560240, true, new ViewGroup.LayoutParams(-1, -1));
    this.mContext = paramViewGroup.getContext();
    initView();
    muj.aM(getActivity());
    getActivity().getWindow().setFlags(1024, 1024);
    ayxa.initLiuHaiProperty(getActivity());
    if (ayxa.isLiuHaiUseValid()) {
      ayxa.enableNotch(getActivity());
    }
    if (ayxa.isLiuHaiUseValid())
    {
      int i = ayxa.getNotchInScreenHeight(getActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      paramLayoutInflater.topMargin += i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.P.getLayoutParams();
      paramLayoutInflater.topMargin = (i + paramLayoutInflater.topMargin);
      this.P.setLayoutParams(paramLayoutInflater);
    }
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mUiHandler.removeCallbacksAndMessages(null);
    if (this.cy != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.cy);
    }
    knq.remove(1);
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    muj.aM(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment
 * JD-Core Version:    0.7.0.1
 */