package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.util.StringUtil;
import com.tencent.moai.nativepages.util.UIUtil;

public class AdLandingPageBtn
  extends AdLandingPageBtnBase
{
  private Button btn;
  private RelativeLayout layout;
  
  public AdLandingPageBtn(Context paramContext, AdLandingPageComponentBtnInfo paramAdLandingPageComponentBtnInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentBtnInfo, paramViewGroup);
  }
  
  private void setButtonBackground(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.btn.setBackground(new BitmapDrawable(this.context.getResources(), paramBitmap));
      return;
    }
    this.btn.setBackgroundDrawable(new BitmapDrawable(this.context.getResources(), paramBitmap));
  }
  
  protected View createView()
  {
    View localView = this.contentView;
    this.layout = ((RelativeLayout)localView.findViewById(2131378531));
    this.btn = ((Button)localView.findViewById(2131378530));
    return localView;
  }
  
  protected void fillItem()
  {
    setClickCount(0);
    int i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    this.layout.setBackgroundColor(this.backgroundColor);
    int j;
    if (!StringUtil.isNullOrNil(getInfo().btnBackgroundImg))
    {
      localObject = AdLandingPagesDownloadResourceHelper.getCachedImg(getInfo().btnBackgroundImg);
      if (localObject != null) {
        setButtonBackground((Bitmap)localObject);
      }
      for (;;)
      {
        this.btn.setText(getInfo().title);
        this.btn.setTextAlignment(4);
        this.btn.setTextSize(0, getInfo().fontSize);
        if ((getInfo().fontColor != null) && (getInfo().fontColor.length() > 0))
        {
          j = Color.parseColor(getInfo().fontColor);
          this.btn.setTextColor(j);
        }
        setClickAction(this.btn);
        this.btn.setLayoutParams(new RelativeLayout.LayoutParams(i - (int)getInfo().paddingLeft - (int)getInfo().paddingRight, this.btn.getLayoutParams().height));
        return;
        AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(getInfo().btnBackgroundImg, new AdLandingPageBtn.1(this));
      }
    }
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    if (getInfo().boardSize == 0.0F) {
      getInfo().boardSize = UIUtil.fromDPToPix(this.context, 1);
    }
    if (!StringUtil.isNullOrNil(getInfo().btnBorderColor))
    {
      j = Color.parseColor(getInfo().btnBorderColor);
      ((GradientDrawable)localObject).setStroke((int)getInfo().boardSize, j);
      label300:
      if (StringUtil.isNullOrNil(getInfo().btnBgColor)) {
        break label360;
      }
      ((GradientDrawable)localObject).setColor(Color.parseColor(getInfo().btnBgColor));
    }
    for (;;)
    {
      this.btn.setBackgroundDrawable((Drawable)localObject);
      break;
      j = Color.parseColor("#FFFFFF");
      ((GradientDrawable)localObject).setStroke((int)getInfo().boardSize, j);
      break label300;
      label360:
      ((GradientDrawable)localObject).setColor(0);
    }
  }
  
  public AdLandingPageComponentBtnInfo getInfo()
  {
    return (AdLandingPageComponentBtnInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563088;
  }
  
  protected void setClickAction(Button paramButton)
  {
    paramButton.setOnClickListener(new AdLandingPageBtn.2(this));
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    if (this.appearFlag) {
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Button_Show_Count", 1L);
    }
    this.appearFlag = false;
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    if (!this.appearFlag)
    {
      long l = getStayTime();
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Button_Show_Time", l);
    }
    this.appearFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtn
 * JD-Core Version:    0.7.0.1
 */