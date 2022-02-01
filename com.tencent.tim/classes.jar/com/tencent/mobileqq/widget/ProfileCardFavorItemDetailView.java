package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import wja;

public class ProfileCardFavorItemDetailView
  extends LinearLayout
{
  private ImageView FJ;
  private final String TAG = "NEW_CARD_FAVOR";
  public TextView ack;
  public TextView acl;
  public TextView acm;
  private Context ctx;
  LinearLayout lu;
  LinearLayout lv;
  LinearLayout lw;
  LinearLayout lx;
  LinearLayout ly;
  LinearLayout lz;
  private View mContentView;
  
  public ProfileCardFavorItemDetailView(Context paramContext)
  {
    super(paramContext);
    this.ctx = paramContext;
    init();
  }
  
  public ProfileCardFavorItemDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ctx = paramContext;
    init();
  }
  
  private void init()
  {
    this.mContentView = LayoutInflater.from(this.ctx).inflate(2131559703, this, true);
    this.FJ = ((ImageView)this.mContentView.findViewById(2131366731));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.FJ.setColorFilter(1996488704);
    }
    this.lu = ((LinearLayout)this.mContentView.findViewById(2131365324));
    this.lv = ((LinearLayout)this.mContentView.findViewById(2131365325));
    this.lw = ((LinearLayout)this.mContentView.findViewById(2131365327));
    this.lx = ((LinearLayout)this.mContentView.findViewById(2131365328));
    this.ly = ((LinearLayout)this.mContentView.findViewById(2131365330));
    this.lz = ((LinearLayout)this.mContentView.findViewById(2131365331));
    this.ack = ((TextView)this.mContentView.findViewById(2131382308));
    this.acl = ((TextView)this.mContentView.findViewById(2131382309));
    this.acm = ((TextView)this.mContentView.findViewById(2131382310));
  }
  
  public void a(Drawable paramDrawable, String paramString, int paramInt1, int paramInt2)
  {
    paramDrawable = new Label(this.ctx, paramDrawable, paramString, paramInt1);
    paramString = new LinearLayout.LayoutParams(-2, wja.dp2px(15.0F, getResources()));
    paramString.leftMargin = wja.dp2px(4.0F, getResources());
    paramDrawable.setLayoutParams(paramString);
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      this.lu.addView(paramDrawable);
      return;
    case 2: 
      this.lv.addView(paramDrawable);
      return;
    case 3: 
      this.lw.addView(paramDrawable);
      return;
    case 4: 
      this.lx.addView(paramDrawable);
      return;
    case 5: 
      this.ly.addView(paramDrawable);
      return;
    }
    this.lz.addView(paramDrawable);
  }
  
  public void gy(String paramString, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(16777215);
    URLImageView localURLImageView = new URLImageView(this.ctx);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    localURLDrawableOptions.mRequestHeight = wja.dp2px(15.0F, getResources());
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      localURLImageView.setVisibility(8);
    }
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setImageDrawable(paramString);
    localURLImageView.setMaxHeight(wja.dp2px(15.0F, getResources()));
    localURLImageView.setAdjustViewBounds(true);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.leftMargin = wja.dp2px(4.0F, getResources());
    localURLImageView.setLayoutParams(paramString);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.lu.addView(localURLImageView);
      return;
    case 2: 
      this.lv.addView(localURLImageView);
      return;
    case 3: 
      this.lw.addView(localURLImageView);
      return;
    case 4: 
      this.lx.addView(localURLImageView);
      return;
    case 5: 
      this.ly.addView(localURLImageView);
      return;
    }
    this.lz.addView(localURLImageView);
  }
  
  public void setContent(String paramString)
  {
    this.acl.setText(paramString);
  }
  
  public void setDesc(String paramString)
  {
    this.acm.setText(paramString);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.FJ.setImageDrawable(paramDrawable);
  }
  
  public void setNeedTopMargin(boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mContentView.getLayoutParams();
    if (localLayoutParams != null) {
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (int i = wja.dp2px(14.0F, getResources());; i = 0)
    {
      localLayoutParams.topMargin = i;
      this.mContentView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    this.ack.setText(paramString);
  }
  
  class Label
    extends TextView
  {
    public Label(Context paramContext, Drawable paramDrawable, String paramString, int paramInt)
    {
      super();
      setTextSize(1, 11.0F);
      setTextColor(-1);
      if (paramDrawable != null)
      {
        this$1 = "[icon] " + paramString;
        int i = (int)(wja.dp2px(11.0F, getResources()) * 0.8D + 0.5D);
        paramDrawable.setBounds(0, 0, i, i);
        this$1 = new SpannableString(ProfileCardFavorItemDetailView.this);
        ProfileCardFavorItemDetailView.this.setSpan(new ImageSpan(paramDrawable, 1), 0, 6, 17);
      }
      for (;;)
      {
        setText(ProfileCardFavorItemDetailView.this);
        this$1 = new GradientDrawable();
        ProfileCardFavorItemDetailView.this.setColor(paramInt);
        ProfileCardFavorItemDetailView.this.setCornerRadius(8.0F);
        setBackgroundDrawable(ProfileCardFavorItemDetailView.this);
        setPadding(wja.dp2px(4.0F, getResources()), 0, wja.dp2px(4.0F, getResources()), 0);
        setLayoutParams(new ViewGroup.LayoutParams(-2, wja.dp2px(15.0F, getResources())));
        return;
        this$1 = new SpannableString(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView
 * JD-Core Version:    0.7.0.1
 */