package com.tencent.mobileqq.activity.activateFriend;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivateFriendViewItem
  extends RelativeLayout
{
  TextView BM;
  TextView Hs;
  ImageView gn;
  int index;
  public boolean isChecked = true;
  ImageView rP;
  
  public ActivateFriendViewItem(Context paramContext)
  {
    this(paramContext, true, true);
  }
  
  public ActivateFriendViewItem(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    b(paramContext, paramBoolean1, paramBoolean2);
  }
  
  private void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    LayoutInflater.from(paramContext).inflate(2131561169, this, true);
    this.gn = ((ImageView)findViewById(2131368698));
    this.rP = ((ImageView)findViewById(2131373187));
    this.BM = ((TextView)findViewById(2131372190));
    this.Hs = ((TextView)findViewById(2131363516));
    if (!paramBoolean2)
    {
      this.BM.setHorizontallyScrolling(false);
      this.Hs.setHorizontallyScrolling(false);
    }
    if (!paramBoolean1)
    {
      paramContext = findViewById(2131368418).getBackground();
      if ((paramContext != null) && ((paramContext instanceof GradientDrawable))) {
        ((GradientDrawable)paramContext).setColor(-1);
      }
      this.BM.setTextColor(-16777216);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.rP != null) && (this.rP.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.isChecked);
    }
  }
  
  public void setBirthday(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.Hs.setVisibility(8);
      return;
    }
    this.Hs.setVisibility(0);
    this.Hs.setText(paramString);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
    if (this.isChecked) {
      this.rP.setImageResource(2130845638);
    }
    for (;;)
    {
      String str2 = "" + this.BM.getText();
      String str1 = str2;
      if (this.Hs.getVisibility() == 0) {
        str1 = str2 + this.Hs.getText();
      }
      setContentDescription(str1);
      return;
      this.rP.setImageResource(2130845640);
    }
  }
  
  public void setHead(Bitmap paramBitmap)
  {
    this.gn.setImageBitmap(paramBitmap);
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setNickName(String paramString)
  {
    this.BM.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem
 * JD-Core Version:    0.7.0.1
 */