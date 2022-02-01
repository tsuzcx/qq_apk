package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class QQGameHeadLayout
  extends BaseNestHeaderLayout
{
  public QQGameHeadLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QQGameHeadLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void initView() {}
  
  protected int getLayoutId()
  {
    return 2131559379;
  }
  
  public boolean isPined()
  {
    return false;
  }
  
  public boolean isShow(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.QQGameHeadLayout
 * JD-Core Version:    0.7.0.1
 */