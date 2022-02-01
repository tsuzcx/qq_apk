package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqzl;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.coupon.CouponProto.MarkBusinessFavourUpdateReq;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import jnl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity
  extends PublicAccountBrowser
{
  static String Ts = "https://web.p.qq.com/qqmpmobile/coupon/shop.html?_bid=108";
  public int from;
  
  public CouponActivity()
  {
    this.s = CouponWebViewFragment.class;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.from = getIntent().getIntExtra("from", 10);
    return super.doOnCreate(paramBundle);
  }
  
  public static class CouponWebViewFragment
    extends WebViewFragment
  {
    boolean abg = false;
    int from = 0;
    
    private void ayX()
    {
      NewIntent localNewIntent = new NewIntent(super.getActivity(), jnl.class);
      localNewIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
      localNewIntent.putExtra("data", new CouponProto.MarkBusinessFavourUpdateReq().toByteArray());
      if (this.mApp == null) {
        this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      }
      this.mApp.startServlet(localNewIntent);
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if (!this.intent.hasExtra("source"))
      {
        this.a.rightViewImg.setVisibility(8);
        this.a.rightViewText.setVisibility(0);
        this.a.rightViewText.setText(2131698320);
        this.a.rightViewText.setOnClickListener(this);
        return i;
      }
      this.intent.removeExtra("source");
      this.a.rightViewImg.setVisibility(8);
      this.a.rightViewText.setVisibility(8);
      return i;
    }
    
    public void d(Intent paramIntent, String paramString)
    {
      super.d(this.intent, this.mUrl);
      if (!this.intent.hasExtra("source"))
      {
        this.a.rightViewImg.setVisibility(8);
        this.a.rightViewText.setVisibility(0);
        this.a.rightViewText.setText(2131698320);
        this.a.rightViewText.setClickable(false);
        return;
      }
      this.a.rightViewImg.setVisibility(8);
      this.a.rightViewText.setVisibility(8);
    }
    
    public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (paramIntent != null)
      {
        paramInt1 = paramInt2;
        if (paramIntent.getExtras() != null) {
          paramInt1 = paramIntent.getExtras().getInt("toPage");
        }
      }
      if ((paramInt1 != 0) && ((this.from & paramInt1) == 0))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("toPage", paramInt1);
        super.getActivity().setResult(-1, paramIntent);
        super.getActivity().finish();
      }
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      Object localObject1 = this.intent.getExtras().getString("url");
      this.from = this.intent.getIntExtra("from", 10);
      this.intent.putExtra("webStyle", "noBottomBar");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.intent.putExtra("title", super.getResources().getString(2131698323));
        this.abg = true;
        super.doOnCreate(paramBundle);
        if (this.abg)
        {
          paramBundle = new StringBuffer();
          try
          {
            localObject1 = this.intent.getStringExtra("jsonParams");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = new JSONObject((String)localObject1);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                Object localObject2 = ((JSONObject)localObject1).get(str);
                paramBundle.append("&" + str + "=" + localObject2.toString());
              }
            }
            if ((this.from & 0x5) != 0) {}
          }
          catch (JSONException localJSONException) {}
        }
      }
      for (paramBundle = CouponActivity.Ts + "&stype=2" + paramBundle.toString();; paramBundle = CouponActivity.Ts + paramBundle.toString())
      {
        this.intent.putExtra("url", paramBundle);
        this.intent.putExtra("from", this.from & 0x1C | 0x10);
        ayX();
        anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "coupon.activity.show", 0, 0, "", "", "", "");
        return true;
        this.intent.removeExtra("title");
        break;
      }
    }
    
    public String getUAMark()
    {
      if (this.intent.hasExtra("source")) {
        return "PA MyCoupon";
      }
      return "PA Coupon";
    }
    
    public void onClick(View paramView)
    {
      Intent localIntent;
      if (paramView == this.a.rightViewText) {
        if ((this.from & 0x4) != 0)
        {
          localIntent = new Intent();
          localIntent.putExtra("isNeedFinish", true);
          localIntent.putExtra("toPage", 1);
          super.getActivity().setResult(-1, localIntent);
          super.getActivity().finish();
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localIntent = new Intent(super.getActivity(), CouponActivity.class);
        localIntent.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
        localIntent.putExtra("source", "2");
        localIntent.putExtra("from", this.from & 0xC | 0x5);
        super.getActivity().startActivityForResult(localIntent, 100);
        continue;
        super.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity
 * JD-Core Version:    0.7.0.1
 */