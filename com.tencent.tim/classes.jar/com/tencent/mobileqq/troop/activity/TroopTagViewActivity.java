package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aqzl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

public class TroopTagViewActivity
  extends QQBrowserActivity
{
  protected boolean cLA;
  protected String cnr;
  public String cns;
  public int dSf = 1;
  protected int mActivityType;
  protected String mTags;
  protected String mTroopUin;
  
  public TroopTagViewActivity()
  {
    this.s = TroopTagViewFragment.class;
  }
  
  public void Sq(String paramString)
  {
    this.cns = paramString;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      super.finish();
      return true;
    }
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      super.finish();
      return true;
    }
    this.mActivityType = localBundle.getInt("act_type", 3);
    this.mTags = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.cnr = localBundle.getString("subclass");; this.cnr = "")
    {
      this.mTroopUin = localBundle.getString("troopuin");
      if (!TextUtils.isEmpty(this.mTroopUin)) {
        break;
      }
      super.finish();
      return true;
    }
    this.cLA = localBundle.getBoolean("isAdmin");
    localIntent.putExtra("hide_operation_bar", true);
    String str;
    if (TextUtils.isEmpty(this.mTags))
    {
      str = "";
      this.dSf = localBundle.getInt("modifyToSrv", 1);
      if (this.mActivityType != 1) {
        break label263;
      }
      localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { Long.valueOf(System.currentTimeMillis() / 1000L), str, this.mTroopUin, this.cnr, Integer.valueOf(this.dSf) }));
    }
    for (;;)
    {
      localIntent.putExtra("isShowAd", false);
      super.doOnCreate(paramBundle);
      localIntent.putExtra("act_type", 3);
      return true;
      str = URLEncoder.encode(this.mTags).replace("+", "%20");
      break;
      label263:
      if (this.mActivityType == 2) {
        localIntent.putExtra("url", String.format("https://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { str, this.mTroopUin, this.cnr, Integer.valueOf(this.dSf) }));
      } else {
        localIntent.putExtra("url", localBundle.getString("url"));
      }
    }
  }
  
  public void finish()
  {
    if (!TextUtils.isEmpty(this.cns))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tags", this.cns);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public static class TroopTagViewFragment
    extends WebViewFragment
  {
    protected boolean cLA;
    protected String cnr;
    public int dSf = 1;
    protected int mActivityType;
    protected String mTags;
    protected String mTroopUin;
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      if ((this.mActivityType == 1) && (this.cLA))
      {
        this.a.rightViewText.setText(2131721064);
        this.a.rightViewText.setVisibility(0);
        this.a.rightViewImg.setVisibility(8);
        this.a.rightViewText.setOnClickListener(this);
        return i;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightViewImg.setVisibility(8);
      return i;
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      Bundle localBundle = this.intent.getExtras();
      this.mActivityType = localBundle.getInt("act_type", 3);
      this.mTags = localBundle.getString("tags");
      if (localBundle.containsKey("subclass")) {}
      for (this.cnr = localBundle.getString("subclass");; this.cnr = "")
      {
        this.mTroopUin = localBundle.getString("troopuin");
        this.cLA = localBundle.getBoolean("isAdmin");
        this.dSf = localBundle.getInt("modifyToSrv", 1);
        return super.doOnCreate(paramBundle);
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView == this.a.rightViewText) {
        if ((this.mActivityType == 1) && (this.cLA))
        {
          Intent localIntent = new Intent(super.getActivity(), TroopTagViewActivity.class);
          localIntent.putExtra("troopuin", this.mTroopUin);
          localIntent.putExtra("tags", this.mTags);
          localIntent.putExtra("act_type", 2);
          localIntent.putExtra("modifyToSrv", this.dSf);
          localIntent.putExtra("uin", this.mApp.getCurrentAccountUin());
          super.getActivity().startActivity(localIntent);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        super.onClick(paramView);
        continue;
        super.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity
 * JD-Core Version:    0.7.0.1
 */