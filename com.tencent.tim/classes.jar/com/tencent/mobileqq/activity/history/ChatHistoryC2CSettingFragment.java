package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anot;
import aqiw;
import aqqj;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import zfx;

public class ChatHistoryC2CSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  FormSimpleItem aq;
  FormSimpleItem ar;
  public int cdn;
  public SessionInfo mSessionInfo;
  
  private void bKs()
  {
    int i = getActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getActivity().app.getCurrentAccountUin(), 0);
    Object localObject = null;
    switch (i)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (this.aq != null) {
          this.aq.setRightText((CharSequence)localObject);
        }
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131717266);
      break;
      localObject = getResources().getString(2131717264);
      break;
      localObject = getResources().getString(2131717265);
      break;
      localObject = getResources().getString(2131717267);
      break;
      localObject = getResources().getString(2131717284);
      break;
    }
    QLog.d("Q.history.C2CSettingFragment", 2, "messge roam flag is error ,is : " + i);
  }
  
  public static void d(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    PublicFragmentActivity.startForResult((Activity)paramContext, localIntent, ChatHistoryC2CSettingFragment.class, paramInt2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131691425));
    this.aq = ((FormSimpleItem)this.mContentView.findViewById(2131363976));
    this.aq.setVisibility(8);
    this.ar = ((FormSimpleItem)this.mContentView.findViewById(2131363838));
    this.aq.setOnClickListener(this);
    this.ar.setOnClickListener(this);
  }
  
  public int getContentLayoutId()
  {
    return 2131558950;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      paramInt1 = getActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getActivity().app.getCurrentAccountUin(), -1);
    } while (paramInt1 == this.cdn);
    this.cdn = paramInt1;
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
      if (aqiw.isNetSupport(BaseApplication.getContext()))
      {
        QQAppInterface localQQAppInterface = getActivity().app;
        this.cdn = localQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + localQQAppInterface.getCurrentAccountUin(), -1);
        VipUtils.a(localQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, new String[] { "0", "0", "msgHistory" });
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        String str = aqqj.getUrl("vipRoamChatCell");
        if (!TextUtils.isEmpty(str))
        {
          if (str.contains("?")) {}
          for (str = str + "&ADTAG=msgHistory";; str = str + "?ADTAG=msgHistory")
          {
            localIntent.putExtra("url", str);
            startActivityForResult(localIntent, 2011);
            anot.a(localQQAppInterface, "dc00898", "", "", "0X800A0AE", "0X800A0AE", 0, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131718888, 1).show();
        continue;
        anot.a(getActivity().app, "dc00898", "", "", "0X800A17C", "0X800A17C", 2, 0, "", "", "", "");
        ChatSettingActivity.a(getActivity().app, getActivity(), this.mSessionInfo.aTl, this.mSessionInfo.cZ, new zfx(this), 3);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSessionInfo = new SessionInfo();
    paramBundle = getActivity().getIntent().getExtras();
    this.mSessionInfo.aTl = paramBundle.getString("uin");
    this.mSessionInfo.cZ = paramBundle.getInt("uintype");
  }
  
  public void onResume()
  {
    super.onResume();
    bKs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment
 * JD-Core Version:    0.7.0.1
 */