package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import aqdj;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.TabInfo;

public class TroopAppFormItem
  extends RelativeLayout
{
  ImageView EF;
  ImageView EO;
  View IW;
  TextView abn;
  String desc = "";
  RoundCornerImageView k;
  TextView mAppName;
  String name = "";
  String picUrl;
  int redDotNum = 0;
  
  public TroopAppFormItem(Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public void a(oidb_0xea4.TabInfo paramTabInfo, int paramInt)
  {
    if (paramTabInfo.appid.get() == 1106912788L) {
      this.k.setCorner(aqcx.dip2px(getContext(), 30.0F));
    }
    f(paramTabInfo.name.get(), paramTabInfo.desc.get(), paramTabInfo.pic.get(), paramTabInfo.red_point.get(), paramInt);
  }
  
  public void baG()
  {
    this.EO.setVisibility(8);
    this.EF.setVisibility(8);
  }
  
  protected Drawable d(Resources paramResources, int paramInt)
  {
    return FormSimpleItem.c(paramResources, paramInt, false);
  }
  
  void eck()
  {
    float f2 = 0.0F;
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (this.name == null)
    {
      f1 = 0.0F;
      if (this.desc != null) {
        break label174;
      }
      label33:
      float f3 = i - aqcx.dip2px(getContext(), 12.0F) - aqcx.dip2px(getContext(), 12.0F) - aqcx.dip2px(getContext(), 15.0F);
      if ((this.redDotNum != -1) || (TextUtils.isEmpty(this.desc))) {
        break label241;
      }
      if (TextUtils.isEmpty(this.picUrl)) {
        break label192;
      }
      f1 = i - aqcx.dip2px(getContext(), 30.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - f1;
    }
    for (;;)
    {
      this.abn.setMaxWidth((int)(f1 + 1.0F));
      return;
      f1 = this.mAppName.getPaint().measureText(this.name) + 150.0F;
      break;
      label174:
      this.abn.getPaint().measureText(this.desc);
      break label33;
      label192:
      f1 = i - aqcx.dip2px(getContext(), 10.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - f1;
      continue;
      label241:
      if (!TextUtils.isEmpty(this.picUrl))
      {
        f1 = i - aqcx.dip2px(getContext(), 30.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - aqcx.dip2px(getContext(), 5.0F) - f1;
      }
      else
      {
        f1 = aqcx.dip2px(getContext(), 5.0F);
        f1 = f2;
      }
    }
  }
  
  public void ecl()
  {
    this.EO.setVisibility(8);
    this.IW.setVisibility(8);
    this.abn.setVisibility(8);
  }
  
  public void f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.name = paramString1;
    this.desc = paramString2;
    this.picUrl = paramString3;
    this.redDotNum = paramInt1;
    this.mAppName.setText(paramString1);
    this.abn.setText(paramString2);
    eck();
    if (!TextUtils.isEmpty(this.picUrl))
    {
      if (Friends.isValidUin(this.picUrl))
      {
        paramString1 = aqdj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, this.picUrl);
        this.k.setImageDrawable(paramString1);
      }
    }
    else
    {
      if ((this.redDotNum != -1) && (this.redDotNum <= 0)) {
        break label254;
      }
      if (!TextUtils.isEmpty(this.picUrl)) {
        break label226;
      }
      this.EO.setVisibility(0);
      this.IW.setVisibility(8);
    }
    for (;;)
    {
      setBgType(paramInt2);
      return;
      if (this.picUrl.startsWith("http"))
      {
        paramString1 = getResources().getDrawable(2130840645);
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mLoadingDrawable = paramString1;
        paramString2.mFailedDrawable = paramString1;
        paramString2.mRequestWidth = aqcx.dip2px(getContext(), 30.0F);
        paramString2.mRequestHeight = aqcx.dip2px(getContext(), 30.0F);
        paramString1 = URLDrawable.getDrawable(this.picUrl, paramString2);
        this.k.setImageDrawable(paramString1);
        break;
      }
      this.picUrl = null;
      break;
      label226:
      this.EO.setVisibility(8);
      this.EF.setVisibility(0);
      this.IW.setVisibility(0);
      continue;
      label254:
      this.EO.setVisibility(8);
      if (TextUtils.isEmpty(this.picUrl))
      {
        this.IW.setVisibility(8);
      }
      else
      {
        this.EF.setVisibility(8);
        this.IW.setVisibility(0);
      }
    }
  }
  
  public void initViews()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560767, this);
    this.mAppName = ((TextView)localView.findViewById(2131372190));
    this.abn = ((TextView)localView.findViewById(2131378921));
    this.EO = ((ImageView)localView.findViewById(2131370385));
    this.IW = localView.findViewById(2131377323);
    this.k = ((RoundCornerImageView)localView.findViewById(2131368820));
    this.k.setCorner(aqcx.dip2px(getContext(), 4.0F));
    this.EF = ((ImageView)localView.findViewById(2131368928));
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    setBackgroundDrawable(d(getResources(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAppFormItem
 * JD-Core Version:    0.7.0.1
 */