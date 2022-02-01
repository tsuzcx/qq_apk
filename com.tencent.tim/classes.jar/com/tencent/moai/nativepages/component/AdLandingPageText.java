package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.moai.nativepages.model.AdLandingPageComponentTextInfo;
import com.tencent.moai.nativepages.util.DataUtil;

public class AdLandingPageText
  extends AdLandingPageBaseComp
{
  private TextView textView;
  
  public AdLandingPageText(Context paramContext, AdLandingPageComponentTextInfo paramAdLandingPageComponentTextInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentTextInfo, paramViewGroup);
  }
  
  public View createView()
  {
    this.contentView.setBackgroundColor(this.backgroundColor);
    this.contentView.findViewById(2131378524).setBackgroundColor(this.backgroundColor);
    this.contentView.findViewById(2131378525).setBackgroundColor(this.backgroundColor);
    this.textView = ((TextView)this.contentView.findViewById(2131378525));
    return this.contentView;
  }
  
  protected void fillItem()
  {
    this.textView.setText(getInfo().wordingTitle);
    int i;
    if (getInfo().textAlignment == 0)
    {
      this.textView.setGravity(3);
      if ((getInfo().textColor == null) || (getInfo().textColor.length() <= 0)) {
        break label225;
      }
      i = Color.parseColor(getInfo().textColor);
      this.textView.setTextColor(i);
    }
    for (;;)
    {
      if (getInfo().textSize > 0.0F) {
        this.textView.setTextSize(0, getInfo().textSize);
      }
      TextPaint localTextPaint = this.textView.getPaint();
      if (getInfo().textBolded) {
        localTextPaint.setFakeBoldText(true);
      }
      if (getInfo().textItaliced) {
        localTextPaint.setTextSkewX(-0.25F);
      }
      if (getInfo().textUnderlined) {
        localTextPaint.setUnderlineText(true);
      }
      if (getInfo().maxLines > 0) {
        this.textView.setMaxLines(getInfo().maxLines);
      }
      return;
      if (getInfo().textAlignment == 1)
      {
        this.textView.setGravity(17);
        break;
      }
      if (getInfo().textAlignment != 2) {
        break;
      }
      this.textView.setGravity(5);
      break;
      label225:
      i = Color.parseColor("#FFFFFF");
      this.textView.setTextColor(i);
    }
  }
  
  public AdLandingPageComponentTextInfo getInfo()
  {
    return (AdLandingPageComponentTextInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563098;
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    if (this.appearFlag) {
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Text_Show_Count", 1L);
    }
    this.appearFlag = false;
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    if (!this.appearFlag)
    {
      long l = getStayTime();
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Text_Show_Time", l);
    }
    this.appearFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageText
 * JD-Core Version:    0.7.0.1
 */