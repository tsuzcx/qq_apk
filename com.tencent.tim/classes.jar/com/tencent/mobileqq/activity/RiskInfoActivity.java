package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqiw;
import asxv;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jnm;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import vst;

public class RiskInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private DevlockInfo b;
  private LinearLayout gw;
  private List<RiskInfoItem> rb = new ArrayList();
  
  private void bRk()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(asxv.getAppPackageName());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.getAppId());
    dv("ALL", getResources().getString(2131717237));
    jnm.a(this.app, new vst(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void d(Map<String, RiskInfoItem> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.rb.iterator();
      while (localIterator.hasNext())
      {
        RiskInfoItem localRiskInfoItem = (RiskInfoItem)localIterator.next();
        String str1 = String.format("%d", new Object[] { Integer.valueOf(localRiskInfoItem.mItemId) });
        if (localRiskInfoItem.mItemId == 0) {
          str1 = localRiskInfoItem.aPK;
        }
        if (paramMap.get(str1) != null)
        {
          dv(str1, localRiskInfoItem.aPJ);
        }
        else
        {
          String str3 = localRiskInfoItem.aPL;
          String str2 = str3;
          if (TextUtils.isEmpty(str3)) {
            str2 = getResources().getString(2131693163);
          }
          dv(str1, str2);
          if (localRiskInfoItem.aPK.equalsIgnoreCase("devlock")) {
            this.b.DevSetup = 1;
          }
        }
      }
    }
    dv("ALL", "");
  }
  
  private void dv(String paramString1, String paramString2)
  {
    int i = 0;
    if (i < this.gw.getChildCount())
    {
      Object localObject = this.gw.getChildAt(i);
      FormSimpleItem localFormSimpleItem;
      if (localObject != null)
      {
        localFormSimpleItem = (FormSimpleItem)((View)localObject).findViewById(2131377349);
        if (localFormSimpleItem != null)
        {
          localObject = (RiskInfoItem)localFormSimpleItem.getTag(2017021601);
          if (((RiskInfoItem)localObject).mItemId != 0) {
            break label103;
          }
        }
      }
      label103:
      for (localObject = ((RiskInfoItem)localObject).aPK;; localObject = String.format("%d", new Object[] { Integer.valueOf(((RiskInfoItem)localObject).mItemId) }))
      {
        if ((paramString1.equalsIgnoreCase("ALL")) || (paramString1.equalsIgnoreCase((String)localObject))) {
          localFormSimpleItem.setRightText(paramString2);
        }
        i += 1;
        break;
      }
    }
  }
  
  private void fY(List<RiskInfoItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.gw.setVisibility(8);
      return;
    }
    this.gw.removeAllViews();
    this.gw.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    label47:
    RiskInfoItem localRiskInfoItem;
    if (i < j)
    {
      localRiskInfoItem = (RiskInfoItem)paramList.get(i);
      if (localRiskInfoItem != null) {
        break label76;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label76:
      View localView = getLayoutInflater().inflate(2131562068, this.gw, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131377350);
      FormSimpleItem localFormSimpleItem = (FormSimpleItem)localView.findViewById(2131377349);
      localFormSimpleItem.setLeftText(localRiskInfoItem.Qv);
      localFormSimpleItem.setRightText(localRiskInfoItem.aPJ);
      ((TextView)localView.findViewById(2131377343)).setText(localRiskInfoItem.Vf);
      String str = localRiskInfoItem.aPK;
      localLinearLayout.setTag(2017021601, localRiskInfoItem);
      localFormSimpleItem.setTag(2017021601, localRiskInfoItem);
      localFormSimpleItem.setClickable(true);
      localFormSimpleItem.setOnClickListener(this);
      this.gw.addView(localView);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    bRk();
  }
  
  public void onClick(View paramView)
  {
    RiskInfoItem localRiskInfoItem = (RiskInfoItem)paramView.getTag(2017021601);
    QLog.d("RiskInfoDetails", 1, String.format("set jump: %s", new Object[] { localRiskInfoItem.aPK }));
    wu(localRiskInfoItem.aPK);
    anot.a(this.app, "dc00899", "Safe_RiskInfo", "", localRiskInfoItem.Qv, localRiskInfoItem.aPK, localRiskInfoItem.bKE, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562067);
    setTitle(2131717234);
    this.gw = ((LinearLayout)findViewById(2131375364));
    paramBundle = getIntent().getExtras();
    this.rb = paramBundle.getParcelableArrayList("data");
    this.b = ((DevlockInfo)paramBundle.get("DevlockInfo"));
    fY(this.rb);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void wu(String paramString)
  {
    QLog.d("RiskInfoDetails", 1, String.format("jump: %s", new Object[] { paramString }));
    if (paramString.equalsIgnoreCase("devlock"))
    {
      try
      {
        if (this.b == null)
        {
          if (aqiw.isNetSupport(this)) {
            return;
          }
          QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
          return;
        }
        if (this.b.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          paramString = new Intent(this, AuthDevActivity.class);
          paramString.putExtra("phone_num", this.b.Mobile);
          paramString.putExtra("country_code", this.b.CountryCode);
          paramString.putExtra("auth_dev_open", true);
          startActivityForResult(paramString, 0);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.app.sendWirelessMeibaoReq(1);
      if (TextUtils.isEmpty(this.b.Mobile))
      {
        paramString = new Intent(this, AuthDevOpenUgActivity.class);
        paramString.putExtra("DevlockInfo", this.b);
        startActivityForResult(paramString, 0);
        return;
      }
      if (this.b.AllowSet == 0)
      {
        paramString = new Intent(this, AuthDevOpenUgActivity.class);
        paramString.putExtra("DevlockInfo", this.b);
        startActivityForResult(paramString, 0);
        return;
      }
      if (this.b.AllowSet == 1)
      {
        paramString = new Intent(this, AuthDevActivity.class);
        paramString.putExtra("phone_num", this.b.Mobile);
        paramString.putExtra("country_code", this.b.CountryCode);
        paramString.putExtra("auth_dev_open", false);
        startActivityForResult(paramString, 0);
      }
    }
    else
    {
      if (paramString.equalsIgnoreCase("phonebind")) {
        try
        {
          paramString = new Intent(this, PhoneUnityBindInfoActivity.class);
          paramString.putExtra("kSrouce", 18);
          startActivityForResult(paramString, 2001);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.equalsIgnoreCase("pickproof")) {
        try
        {
          startActivityForResult(new Intent(this, SecurityPickproofActivity.class), 0);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.equalsIgnoreCase("qpimprotect")) {
        try
        {
          startActivityForResult(new Intent(this, SecurityProtectActivity.class), 0);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.startsWith("http")) {
        for (;;)
        {
          String str;
          try
          {
            str = this.app.getCurrentAccountUin();
            Intent localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("uin", str);
            if (paramString.indexOf("?") == -1)
            {
              paramString = paramString + "?uin=" + str;
              localIntent.putExtra("url", paramString);
              startActivityForResult(localIntent, 0);
              return;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          paramString = paramString + "&uin=" + str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoActivity
 * JD-Core Version:    0.7.0.1
 */