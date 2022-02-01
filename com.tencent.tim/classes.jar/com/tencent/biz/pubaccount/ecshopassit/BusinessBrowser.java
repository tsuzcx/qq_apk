package com.tencent.biz.pubaccount.ecshopassit;

import acje;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.net.URLDecoder;
import kdi;
import kdj;
import kdk;
import kec;
import ocp;
import wja;

public class BusinessBrowser
  extends QQBrowserActivity
{
  public BusinessBrowser()
  {
    this.s = BusinessBrowserFragment.class;
  }
  
  public static class BusinessBrowserFragment
    extends WebViewFragment
    implements Animation.AnimationListener
  {
    public boolean Oe;
    public Animation S;
    RelativeLayout X;
    public Animation a;
    int aHV = -1;
    public int aHW = 0;
    public int aHX;
    boolean aei = false;
    public boolean aej = true;
    acje c = new kdk(this);
    public TextView followBtn;
    public ImageView icon;
    public View jr;
    public View js;
    View maskView;
    String msgId;
    TextView nP;
    String nick;
    BroadcastReceiver o = new kdj(this);
    public String pUin;
    
    public void A(View paramView, int paramInt)
    {
      if (paramView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        localLayoutParams.topMargin = paramInt;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if (!this.aei) {
        return i;
      }
      this.X = ((RelativeLayout)super.getActivity().findViewById(2131382187));
      this.js = super.getActivity().findViewById(2131382171);
      if ((this.X != null) && (this.js != null))
      {
        this.jr = View.inflate(super.getActivity(), 2131562096, null);
        this.maskView = this.jr.findViewById(2131371159);
        if (this.maskView != null)
        {
          if (!ThemeUtil.isInNightMode(this.mApp)) {
            break label294;
          }
          this.maskView.setVisibility(0);
        }
      }
      for (;;)
      {
        this.jr.setOnClickListener(this);
        ((SingleLineTextView)this.jr.findViewById(2131372190)).setText(String.valueOf(this.nick));
        this.icon = ((ImageView)this.jr.findViewById(2131368698));
        this.followBtn = ((TextView)this.jr.findViewById(2131367381));
        this.followBtn.setOnClickListener(this);
        this.nP = ((TextView)this.jr.findViewById(2131370787));
        paramBundle = new RelativeLayout.LayoutParams(-1, wja.dp2px(44.0F, super.getResources()));
        paramBundle.addRule(10);
        this.X.addView(this.jr, paramBundle);
        A(this.js, this.aHX);
        this.j.setOnScrollChangedListener(new kdi(this));
        paramBundle = new Intent("action_get_PA_head");
        paramBundle.putExtra("uin", this.pUin);
        super.getActivity().sendBroadcast(paramBundle);
        aBI();
        return i;
        label294:
        this.maskView.setVisibility(8);
      }
    }
    
    void aBI()
    {
      Intent localIntent = new Intent("action_follow_status");
      localIntent.putExtra("puin", this.pUin);
      super.getActivity().sendBroadcast(localIntent);
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      this.aHV = this.intent.getIntExtra("jump_from", -1);
      this.msgId = this.intent.getStringExtra("msg_id");
      this.aHX = wja.dp2px(44.0F, super.getResources());
      Object localObject = Uri.parse(super.CE());
      boolean bool;
      if (((Uri)localObject).isHierarchical())
      {
        this.pUin = ((Uri)localObject).getQueryParameter("shopPuin");
        if (TextUtils.isEmpty(this.pUin)) {
          break label234;
        }
        bool = true;
      }
      for (;;)
      {
        this.aei = bool;
        this.nick = ((Uri)localObject).getQueryParameter("shopNick");
        if (this.nick != null) {}
        try
        {
          this.nick = URLDecoder.decode(this.nick, "UTF-8");
          if (this.aei)
          {
            localObject = new IntentFilter("action_decode_finish");
            ((IntentFilter)localObject).addAction("action_follow_status_finish");
          }
        }
        catch (Exception localException1)
        {
          try
          {
            label152:
            label234:
            do
            {
              BaseApplicationImpl.getApplication().registerReceiver(this.o, (IntentFilter)localObject);
              this.S = new TranslateAnimation(0.0F, 0.0F, -this.aHX, 0.0F);
              this.S.setDuration(100L);
              this.S.setAnimationListener(this);
              this.a = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.aHX);
              this.a.setDuration(100L);
              this.a.setAnimationListener(this);
              return super.doOnCreate(paramBundle);
              bool = false;
              break;
              localException1 = localException1;
            } while (!QLog.isColorLevel());
            QLog.i("WebLog_WebViewFragment", 2, "msg_id:" + this.msgId + ",p_uin:" + this.pUin + ",nick:" + this.nick);
          }
          catch (Exception localException2)
          {
            break label152;
          }
        }
      }
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (paramAnimation == this.S)
      {
        if (this.jr != null) {
          this.jr.setVisibility(0);
        }
        A(this.js, this.aHX);
      }
      while ((paramAnimation != this.a) || (this.jr == null)) {
        return;
      }
      this.jr.setVisibility(4);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
    
    public void onClick(View paramView)
    {
      super.onClick(paramView);
      int i = paramView.getId();
      Object localObject;
      if (i == 2131367381)
      {
        localObject = (kec)this.mApp.getBusinessHandler(0);
        if (localObject != null)
        {
          if (this.aHV == 1) {
            ((kec)localObject).a(134249256, this.pUin, this.msgId, null, null, 0L, false);
          }
        }
        else {
          ocp.a(this.mApp, super.getActivity(), this.pUin, this.c);
        }
      }
      while (i != 2131364375) {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.aHV == 2) {
            ((kec)localObject).a(134249251, this.pUin, null, null, null, 0L, false);
          }
        }
      }
      if (this.aHV == 1) {
        i = 134249257;
      }
      for (;;)
      {
        localObject = new Intent(super.getActivity(), AccountDetailActivity.class);
        ((Intent)localObject).putExtra("uin", this.pUin);
        ((Intent)localObject).putExtra("report_src_param_type", "");
        ((Intent)localObject).putExtra("report_src_param_name", "");
        if (i != -1) {
          ((Intent)localObject).putExtra("report_business_tvalue", i);
        }
        if (this.msgId != null) {
          ((Intent)localObject).putExtra("strp1", this.msgId);
        }
        ((Intent)localObject).setFlags(67108864);
        super.getActivity().startActivity((Intent)localObject);
        break;
        if (this.aHV == 2) {
          i = 134249252;
        } else {
          i = -1;
        }
      }
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      this.c = null;
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.o);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void onResume()
    {
      super.onResume();
      aBI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser
 * JD-Core Version:    0.7.0.1
 */