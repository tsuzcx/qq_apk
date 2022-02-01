package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import rpq;

public class QQNotifySettingInnerFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private TextView HC;
  private TextView HD;
  private ScrollView i;
  private ImageView rT;
  private ImageView rU;
  
  private void bYj()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.i.post(new QQNotifySettingInnerFragment.1(this, localTranslateAnimation));
  }
  
  public static void e(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", paramString1);
    localIntent.putExtra("key_busid", paramString2);
    localIntent.putExtra("key_domain", paramString3);
    PublicFragmentActivity.b.startForResult(paramActivity, localIntent, PublicTransFragmentActivity.class, QQNotifySettingInnerFragment.class, 48128);
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    super.a(paramAcsGetMsgRsp);
    bYj();
  }
  
  public void bYi()
  {
    QQToast.a(getActivity(), acfp.m(2131711989), 0).show();
  }
  
  public void bn(int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      this.bcq = bool;
      this.bNq = paramInt;
      this.aSi = paramString;
      if (!this.bcq) {
        break label124;
      }
      this.dN.setTag("1");
      this.dN.setText(acfp.m(2131711987));
      this.HC.setText(acfp.m(2131711985));
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestHeight = this.rU.getHeight();
      paramString.mRequestWidth = this.rU.getWidth();
      paramString = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", paramString);
      if (paramString != null)
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        this.rU.setImageDrawable(paramString);
      }
    }
    label124:
    while (this.bNq == 2)
    {
      return;
      bool = false;
      break;
    }
    bm(this.bNq, this.aSi);
  }
  
  public void bo(int paramInt, String paramString)
  {
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("errorCode", paramInt);
      localIntent.putExtra("msg", paramString);
      getActivity().setResult(-1, localIntent);
    }
  }
  
  public View d(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131561177, paramViewGroup, false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.i = ((ScrollView)this.root.findViewById(2131362713));
    this.HD = ((TextView)this.root.findViewById(2131380646));
    this.HD.setVisibility(8);
    ((LinearLayout)this.root.findViewById(2131369772)).setVisibility(0);
    this.rU = ((ImageView)this.root.findViewById(2131369773));
    this.rU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = rpq.dip2px(getActivity(), 86.0F);
    paramLayoutInflater.mRequestWidth = rpq.dip2px(getActivity(), 86.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_c180abdeaa834c09173949780f36b7a6.png", paramLayoutInflater);
    if (paramLayoutInflater != null)
    {
      if (paramLayoutInflater.getStatus() == 2) {
        paramLayoutInflater.restartDownload();
      }
      this.rU.setImageDrawable(paramLayoutInflater);
    }
    this.HC = ((TextView)this.root.findViewById(2131369774));
    this.rT = ((ImageView)this.root.findViewById(2131363823));
    this.rT.setOnClickListener(this);
    paramLayoutInflater = this.root;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment
 * JD-Core Version:    0.7.0.1
 */