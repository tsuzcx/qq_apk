package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.immersive.ImmersiveUtils;
import wja;

public class QQGamePubWebView
  extends BaseNestScrollWebView
{
  public QQGamePubWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onPageFinish(String paramString)
  {
    setPaddingTop(wja.dp2px(wja.a(ImmersiveUtils.getStatusBarHeight(getContext()), getContext().getResources()) + 433.0F, getResources()));
  }
  
  public void setPaddingTop(int paramInt)
  {
    super.setPaddingTop(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView
 * JD-Core Version:    0.7.0.1
 */