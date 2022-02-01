package com.tencent.biz.pubaccount;

import acja;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdj;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import jzs;
import jzs.a;

public class AccountMoreDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected AccountDetailTopGestureLayout a;
  private ViewGroup aJ;
  private AccountDetail b;
  Button bK;
  protected float density;
  public RelativeLayout ez;
  ImageView hH;
  public ImageView hI;
  public ImageView hJ;
  public ImageView hK;
  protected Intent mIntent;
  private String mUin;
  public TextView nJ;
  protected ImageView rightViewImg;
  TextView rightViewText;
  int titleHeight = 0;
  
  private static String a(AccountDetail paramAccountDetail)
  {
    if ((paramAccountDetail.paConfigAttrs != null) && (paramAccountDetail.paConfigAttrs.isEmpty())) {
      return null;
    }
    jzs.a locala;
    do
    {
      paramAccountDetail = paramAccountDetail.paConfigAttrs.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!paramAccountDetail.hasNext()) {
            break;
          }
          localObject = (jzs)paramAccountDetail.next();
        } while (((jzs)localObject).type != 0);
        localObject = ((jzs)localObject).fR.iterator();
      }
      locala = (jzs.a)((Iterator)localObject).next();
    } while (locala.aGH != 8);
    return locala.Vq;
    return null;
  }
  
  private void init(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    this.mUin = paramIntent.getStringExtra("uin");
    initView();
    initData();
  }
  
  private void initData()
  {
    this.b = ((acja)this.app.getManager(56)).a(this.mUin);
    this.aJ.removeAllViews();
    if (this.b == null) {}
    LayoutInflater localLayoutInflater;
    String str1;
    do
    {
      return;
      this.nJ.setText(this.b.name);
      localLayoutInflater = LayoutInflater.from(this);
      String str2 = this.b.certifiedDescription;
      if ((!TextUtils.isEmpty(str2)) && (str2.contains(":")))
      {
        int i = str2.indexOf(":");
        str1 = str2.substring(0, i);
        if (str2.length() > i + 1)
        {
          str2 = str2.substring(i + 1);
          this.aJ.addView(new a(localLayoutInflater, null, str1, str2).getView());
        }
      }
      if (!TextUtils.isEmpty(this.b.summary)) {
        this.aJ.addView(new a(localLayoutInflater, null, "信息简介", this.b.summary).getView());
      }
      if (!TextUtils.isEmpty(this.b.certifiedEnterprise)) {
        this.aJ.addView(new a(localLayoutInflater, null, "认证来源", this.b.certifiedEnterprise).getView());
      }
      if (!TextUtils.isEmpty(this.b.certifiedEnterprise)) {
        this.aJ.addView(new a(localLayoutInflater, null, "认证来源", this.b.certifiedEnterprise).getView());
      }
      str1 = a(this.b);
    } while (TextUtils.isEmpty(str1));
    this.aJ.addView(new a(localLayoutInflater, null, "联系电话", str1).getView());
  }
  
  private void initTitle()
  {
    this.ez = ((RelativeLayout)super.findViewById(2131370423));
    this.ez.setOnClickListener(null);
    int j;
    if (yt()) {
      j = (int)(64.0F * this.density);
    }
    for (int i = (int)(4.0F * this.density);; i = (int)(25.0F * this.density))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, j);
      this.ez.setLayoutParams(localLayoutParams);
      this.ez.setPadding(0, i, 0, 0);
      this.titleHeight = j;
      if (this.a != null) {
        this.a.setTitleHeight(this.titleHeight);
      }
      this.hH = ((ImageView)super.findViewById(2131370422));
      this.hH.setOnClickListener(this);
      this.rightViewText = ((TextView)super.findViewById(2131369612));
      this.rightViewText.setText("");
      this.rightViewImg = ((ImageView)super.findViewById(2131369594));
      this.rightViewImg.setImageResource(2130844509);
      this.rightViewImg.setContentDescription(getString(2131699738));
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.hI = ((ImageView)super.findViewById(2131368751));
      this.hJ = ((ImageView)super.findViewById(2131368711));
      this.hK = ((ImageView)super.findViewById(2131364413));
      this.bK = ((Button)super.findViewById(2131361907));
      this.bK.setOnClickListener(this);
      this.hH.setImageResource(2130851112);
      this.rightViewImg.setImageResource(2130843304);
      this.hI.setVisibility(0);
      this.hI.setBackgroundDrawable(aqdj.a(this.app, 1, this.mUin));
      this.hJ.setVisibility(0);
      this.hK.setVisibility(8);
      return;
      j = (int)(75.0F * this.density);
    }
  }
  
  private void initView()
  {
    super.setContentView(2131558457);
    this.density = super.getResources().getDisplayMetrics().density;
    initTitle();
    this.aJ = ((ViewGroup)findViewById(2131361942));
    this.nJ = ((TextView)findViewById(2131361941));
    this.nJ.setSingleLine();
    this.nJ.setTextColor(-16777216);
  }
  
  private boolean yt()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.a = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.a);
    }
    init(getIntent());
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    init(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370422) {
      doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  static class a
  {
    private ViewGroup rootView;
    
    public a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, String paramString1, String paramString2)
    {
      this.rootView = ((ViewGroup)paramLayoutInflater.inflate(2131558458, paramViewGroup));
      paramLayoutInflater = (TextView)this.rootView.findViewById(2131361940);
      paramViewGroup = (TextView)this.rootView.findViewById(2131361939);
      paramLayoutInflater.setText(paramString1);
      paramViewGroup.setText(paramString2);
    }
    
    public View getView()
    {
      return this.rootView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountMoreDetailActivity
 * JD-Core Version:    0.7.0.1
 */