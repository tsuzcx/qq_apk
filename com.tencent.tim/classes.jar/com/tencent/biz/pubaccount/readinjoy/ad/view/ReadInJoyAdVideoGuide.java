package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import aqiz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import jzk;
import wja;

public class ReadInJoyAdVideoGuide
  extends RelativeLayout
  implements View.OnClickListener
{
  private a a;
  private int aGV;
  private String abv;
  private boolean agQ;
  private View jO;
  private String mPkgName;
  private TextView nameTv;
  private TextView oz;
  private URLImageView p;
  
  public ReadInJoyAdVideoGuide(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private String getBtnText()
  {
    switch (nt())
    {
    }
    return "";
  }
  
  private void init(Context paramContext)
  {
    inflate(paramContext, 2131560245, this);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    initView();
  }
  
  private void initView()
  {
    this.p = ((URLImageView)findViewById(2131362847));
    this.nameTv = ((TextView)findViewById(2131362859));
    this.oz = ((TextView)findViewById(2131363844));
    this.jO = findViewById(2131362138);
    this.p.setOnClickListener(this);
    this.nameTv.setOnClickListener(this);
    this.oz.setOnClickListener(this);
    this.jO.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  private void mm(String paramString)
  {
    Resources localResources;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!TextUtils.isEmpty(paramString)) && (this.p != null))
    {
      localResources = getResources();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = wja.dp2px(60.0F, localResources);
      localURLDrawableOptions.mRequestHeight = wja.dp2px(60.0F, localResources);
    }
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      paramString.setTag(aqbn.d(wja.dp2px(60.0F, localResources), wja.dp2px(60.0F, localResources), wja.dp2px(12.0F, localResources)));
      paramString.setDecodeHandler(aqbn.a);
      this.p.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private int nt()
  {
    if (this.agQ) {
      return 4;
    }
    if (this.aGV != 12) {
      return 1;
    }
    if (!TextUtils.isEmpty(this.mPkgName))
    {
      if (aqiz.isAppInstalled(getContext(), this.mPkgName)) {
        return 3;
      }
      return 2;
    }
    return 0;
  }
  
  private void setAppName(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.nameTv != null))
    {
      String str = paramString;
      if (paramString.length() > 12) {
        str = paramString.substring(0, 11) + "…";
      }
      this.nameTv.setText(str);
    }
  }
  
  private void setAppPkgName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mPkgName = paramString;
      aFt();
    }
  }
  
  public void aFt()
  {
    if (!TextUtils.isEmpty(this.abv)) {}
    for (String str = this.abv;; str = getBtnText())
    {
      if ((this.oz != null) && (!TextUtils.isEmpty(str))) {
        this.oz.setText(str);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = jzk.aGl;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.B(paramView, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdVideoGuide", 2, "onClick:" + i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = jzk.aGh;
      continue;
      i = jzk.aGi;
      continue;
      i = jzk.aGj;
      continue;
      i = jzk.aGk;
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdVideoGuide", 2, "onVisibilityChanged:" + paramInt);
    }
    super.onVisibilityChanged(paramView, paramInt);
    aFt();
  }
  
  public void setAdGuideClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.aGV = paramInt;
    mm(paramString1);
    setAppName(paramString2);
    setAppPkgName(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:").append(this.aGV).append("\n");
      localStringBuilder.append("icon:").append(paramString1).append("\n");
      localStringBuilder.append("name:").append(paramString2).append("\n");
      localStringBuilder.append("pkgname:").append(paramString3).append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.aGV = paramInt;
    this.agQ = paramBoolean;
    mm(paramString1);
    setAppName(paramString2);
    setAppPkgName(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:").append(this.aGV).append("\n");
      localStringBuilder.append("icon:").append(paramString1).append("\n");
      localStringBuilder.append("name:").append(paramString2).append("\n");
      localStringBuilder.append("pkgname:").append(paramString3).append("\n");
      localStringBuilder.append("isAmsSubscribeAd:").append(paramBoolean).append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
  }
  
  public void setBtnInfo(String paramString)
  {
    this.abv = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void B(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide
 * JD-Core Version:    0.7.0.1
 */