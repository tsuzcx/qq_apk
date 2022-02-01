package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.gamecenter.web.view.BaseNestScrollWebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import wja;

public class MiniGamePublicAccountWebView
  extends BaseNestScrollWebView
{
  public static final int HEAD_HEIGHT_DB = 419;
  public static final int TITLE_HEIGHT_DB = 44;
  
  public MiniGamePublicAccountWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MiniGamePublicAccountWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onPageFinish(String paramString)
  {
    setPaddingTop(wja.dp2px(wja.a(ImmersiveUtils.getStatusBarHeight(getContext()), getContext().getResources()) + 463.0F, getResources()));
  }
  
  public void setPaddingTop(int paramInt)
  {
    super.setPaddingTop(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView
 * JD-Core Version:    0.7.0.1
 */