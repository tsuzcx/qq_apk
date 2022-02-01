package com.tencent.mobileqq.activity.activateFriend;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.net.URLDecoder;
import java.net.URLEncoder;
import rpq;

public class QQNotifySettingFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private TextView HA;
  private TextView HB;
  private LinearLayout gS;
  private ImageView rS;
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", URLDecoder.decode(paramString1));
    localIntent.putExtra("key_busid", URLDecoder.decode(paramString2));
    localIntent.putExtra("key_schema", URLDecoder.decode(paramString3));
    localIntent.putExtra("key_domain", URLDecoder.decode(paramString4));
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, QQNotifySettingFragment.class);
  }
  
  public void bYi()
  {
    QQToast.a(getActivity(), acfp.m(2131711986), 0).show();
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
        break label136;
      }
      this.dN.setTag("1");
      this.dN.setText(acfp.m(2131711982));
      this.HA.setText(acfp.m(2131711988));
      this.HB.setText(acfp.m(2131711984));
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestHeight = this.rS.getHeight();
      paramString.mRequestWidth = this.rS.getWidth();
      paramString = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", paramString);
      if (paramString != null)
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        this.rS.setImageDrawable(paramString);
      }
    }
    label136:
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
    paramString = getArguments().getString("key_schema");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString + "://?retcode=" + this.bNq + "&retmsg=" + URLEncoder.encode(this.aSi)));
    paramString.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
    try
    {
      startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public View d(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131561176, paramViewGroup, false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131380588) {
      bm(this.bNq, this.aSi);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.gS = ((LinearLayout)this.root.findViewById(2131369771));
    this.gS.setVisibility(0);
    this.rS = ((ImageView)this.root.findViewById(2131369769));
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = rpq.dip2px(getActivity(), 106.0F);
    paramLayoutInflater.mRequestWidth = rpq.dip2px(getActivity(), 195.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_a69bf0fc5262c4bc452dd03f6b95a9c0.png", paramLayoutInflater);
    if (paramLayoutInflater != null) {
      this.rS.setImageDrawable(paramLayoutInflater);
    }
    this.HB = ((TextView)this.root.findViewById(2131369770));
    this.HA = ((TextView)this.root.findViewById(2131380588));
    this.HA.setOnClickListener(this);
    paramLayoutInflater = this.root;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */