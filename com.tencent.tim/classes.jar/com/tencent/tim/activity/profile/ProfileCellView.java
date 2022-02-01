package com.tencent.tim.activity.profile;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import atau.a;
import atbe;

public class ProfileCellView
  extends RelativeLayout
{
  private ImageView GR;
  private TextView aex;
  private TextView aey;
  
  public ProfileCellView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCellView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileCellView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559784, this, true);
    this.aex = ((TextView)findViewById(2131373648));
    this.aey = ((TextView)findViewById(2131373637));
    this.GR = ((ImageView)findViewById(2131369846));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rm);
    paramAttributeSet = paramContext.getString(1);
    String str = paramContext.getString(0);
    boolean bool = paramContext.getBoolean(2, false);
    paramContext.recycle();
    this.aex.setText(paramAttributeSet);
    this.aey.setText(str);
    paramContext = this.GR;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramContext.setVisibility(paramInt);
      return;
    }
  }
  
  public void c(atbe paramatbe)
  {
    if (paramatbe != null)
    {
      setProfileName(paramatbe.name);
      setProfileContent(paramatbe.content);
      setProfileArrowVisibility(paramatbe.dgZ);
    }
  }
  
  public void setProfileArrowVisibility(boolean paramBoolean)
  {
    ImageView localImageView = this.GR;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      setClickable(paramBoolean);
      return;
    }
  }
  
  public void setProfileContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.aey.setText(paramString);
    }
  }
  
  public void setProfileName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.aex.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.ProfileCellView
 * JD-Core Version:    0.7.0.1
 */