package com.tencent.mobileqq.microapp.out.activity;

import Wallet.ApkgConfig;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqmr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMiniApp;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.app.b.c;
import com.tencent.mobileqq.microapp.ui.a.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private TextView app_desc;
  private ImageView app_logo;
  private TextView app_name;
  a dialogFromBottom;
  private Button enter_miniapp;
  private ApkgConfig mConfig;
  private JSONObject mDescObj;
  private int mVersionType;
  private TextView owner_text;
  private Button recommend_to_friends;
  private TextView service_type_text;
  private ImageView title_back;
  private ImageView title_more;
  
  public static void launch(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivityForMiniApp.class, AboutFragment.class);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ay) {
      if (this.mDescObj != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new b.c(this.mConfig.mini_appid, this.mVersionType, this.mDescObj.optString("share_content"), this.mDescObj.optString("share_pic_url"), null);
      b.a().a(localObject);
      continue;
      if (paramView.getId() == R.id.bk)
      {
        getActivity().finish();
      }
      else if (paramView.getId() == R.id.bl)
      {
        this.dialogFromBottom = new a(getActivity());
        this.dialogFromBottom.setContentView(LayoutInflater.from(getActivity()).inflate(R.layout.b, null));
        localObject = (TextView)this.dialogFromBottom.findViewById(R.id.y);
        ((TextView)localObject).setText("设置");
        ((TextView)localObject).setOnClickListener(this);
        localObject = (TextView)this.dialogFromBottom.findViewById(R.id.w);
        ((TextView)localObject).setText("意见反馈");
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setOnClickListener(this);
        localObject = (TextView)this.dialogFromBottom.findViewById(R.id.u);
        ((TextView)localObject).setText("投诉");
        ((TextView)localObject).setOnClickListener(this);
        ((TextView)this.dialogFromBottom.findViewById(R.id.v)).setOnClickListener(this);
        this.dialogFromBottom.show();
      }
      else if (paramView.getId() == R.id.y)
      {
        PermissionSettingFragment.launch(getActivity(), this.mConfig.mini_appid);
        if (this.dialogFromBottom != null) {
          this.dialogFromBottom.dismiss();
        }
      }
      else if (paramView.getId() != R.id.bg)
      {
        if (paramView.getId() == R.id.v)
        {
          if (this.dialogFromBottom != null) {
            this.dialogFromBottom.dismiss();
          }
        }
        else
        {
          Intent localIntent;
          if (paramView.getId() == R.id.w)
          {
            localObject = "https://i.qianbao.qq.com/miniapp/opinion/entry.html?appid=" + this.mConfig.mini_appid + "&logourl=" + this.mConfig.icon_url + "&appname=" + this.mConfig.app_name + "&_wv=59163&_wwv=4&appverid=" + this.mConfig.mini_version;
            localIntent = new Intent(getActivity(), QQBrowserActivity.class);
            localIntent.putExtra("url", (String)localObject);
            startActivity(localIntent);
            if (this.dialogFromBottom != null) {
              this.dialogFromBottom.dismiss();
            }
          }
          else if (paramView.getId() == R.id.u)
          {
            localObject = "https://i.qianbao.qq.com/miniapp/complain/entry.html?appid=" + this.mConfig.mini_appid + "&logourl=" + this.mConfig.icon_url + "&appname=" + this.mConfig.app_name + "&_wv=59163&_wwv=4&appverid=" + this.mConfig.mini_version;
            localIntent = new Intent(getActivity(), QQBrowserActivity.class);
            localIntent.putExtra("url", (String)localObject);
            startActivity(localIntent);
            if (this.dialogFromBottom != null) {
              this.dialogFromBottom.dismiss();
            }
          }
          else if (paramView.getId() == R.id.x)
          {
            getActivity().finish();
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.c, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.title_back = ((ImageView)paramView.findViewById(R.id.bk));
    this.title_back.setOnClickListener(this);
    this.title_more = ((ImageView)paramView.findViewById(R.id.bl));
    this.title_more.setOnClickListener(this);
    this.app_logo = ((ImageView)paramView.findViewById(R.id.f));
    this.app_name = ((TextView)paramView.findViewById(R.id.g));
    this.app_desc = ((TextView)paramView.findViewById(R.id.e));
    this.service_type_text = ((TextView)paramView.findViewById(R.id.bf));
    this.owner_text = ((TextView)paramView.findViewById(R.id.ar));
    this.enter_miniapp = ((Button)paramView.findViewById(R.id.x));
    this.enter_miniapp.setOnClickListener(this);
    this.recommend_to_friends = ((Button)paramView.findViewById(R.id.ay));
    this.recommend_to_friends.setOnClickListener(this);
    paramView = getActivity().getIntent();
    if (paramView != null)
    {
      this.mVersionType = paramView.getIntExtra("versionType", 0);
      paramView = (MiniAppConfig)paramView.getSerializableExtra("app_config");
      if (paramView != null)
      {
        this.mConfig = paramView.config;
        if (this.mConfig != null) {
          break label217;
        }
      }
    }
    label217:
    do
    {
      return;
      paramView = this.mConfig.desc_info;
    } while (aqmr.isEmpty(paramView));
    try
    {
      this.mDescObj = new JSONObject(paramView);
      paramView = this.mDescObj.getString("desc_info");
      paramBundle = this.mDescObj.getString("service_type");
      String str = this.mDescObj.getString("owner_info");
      this.app_name.setText(this.mConfig.app_name);
      this.app_desc.setText(paramView);
      this.service_type_text.setText(paramBundle);
      this.owner_text.setText(str);
      this.app_logo.setImageDrawable(URLDrawable.getDrawable(this.mConfig.icon_url));
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.AboutFragment
 * JD-Core Version:    0.7.0.1
 */