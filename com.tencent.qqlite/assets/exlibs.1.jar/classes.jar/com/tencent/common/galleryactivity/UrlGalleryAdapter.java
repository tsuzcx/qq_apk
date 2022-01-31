package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.net.URL;
import tz;

@Deprecated
public class UrlGalleryAdapter
  extends AbstractImageAdapter
{
  public View a(URL paramURL, ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      URLImageView localURLImageView = (URLImageView)paramViewGroup.getChildAt(i);
      Object localObject = localURLImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().equals(paramURL))) {
          return localURLImageView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public URLDrawable a(URL paramURL, ViewGroup paramViewGroup)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = paramURL.toString();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = ((URLImageView)paramViewGroup.getChildAt(i)).getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().toString().equals(paramURL))) {
          return (URLDrawable)((URLDrawable)localObject).getConstantState().newDrawable(paramViewGroup.getContext().getResources());
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    if ((localURLDrawable.getStatus() != 1) && (localURLDrawable.getStatus() != 2))
    {
      int i = localURLDrawable.getProgress();
      if (i == 0) {
        return;
      }
      a(paramInt, i / 100);
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    if (localURLDrawable.getStatus() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool);
      break;
    }
  }
  
  public void a(View paramView, URLDrawable paramURLDrawable)
  {
    if (!paramURLDrawable.isAnim()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      String str = paramURLDrawable.getURL().toString();
      if ((paramURLDrawable.getStatus() == 1) && (AbsDownloader.a(str)))
      {
        paramURLDrawable = AbsDownloader.a(str);
        if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {
          paramView.setTag(2131296389, Integer.valueOf(ImageUtil.c(paramURLDrawable.getAbsolutePath())));
        }
      }
      return;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    URLImageView localURLImageView;
    URLGalleryImage localURLGalleryImage;
    do
    {
      return paramView;
      localURLImageView = new URLImageView(paramViewGroup.getContext());
      localURLImageView.setAdjustViewBounds(true);
      localURLGalleryImage = (URLGalleryImage)a(paramInt);
      paramView = localURLImageView;
    } while (localURLGalleryImage == null);
    paramView = a(localURLGalleryImage.a(), paramViewGroup);
    if (paramView == null) {
      paramView = (URLDrawable)localURLGalleryImage.b();
    }
    for (;;)
    {
      localURLImageView.setImageDrawable(paramView);
      if ((paramView.getStatus() != 1) && (paramView.getStatus() != 4) && (paramView.getStatus() != 2))
      {
        int i = paramView.getProgress();
        localURLImageView.setURLDrawableDownListener(new tz(this, paramInt, paramViewGroup));
        a(paramInt, i / 100);
        return localURLImageView;
      }
      if (paramView.getStatus() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramInt, bool);
        a(localURLImageView, paramView);
        return localURLImageView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.UrlGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */