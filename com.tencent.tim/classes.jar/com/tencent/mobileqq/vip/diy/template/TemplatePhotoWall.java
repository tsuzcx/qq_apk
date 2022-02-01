package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.PhotoWallView.b;

public class TemplatePhotoWall
  extends PhotoWallView
{
  public TemplatePhotoWall(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, PhotoWallView.b paramb)
  {
    super(paramContext, paramQQAppInterface, paramString, paramb);
    this.JB.setAlpha(0.8F);
  }
  
  public int getLayout()
  {
    return 2131562223;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.TemplatePhotoWall
 * JD-Core Version:    0.7.0.1
 */