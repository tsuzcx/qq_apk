package com.tencent.biz.qqstory.album.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.io.File;

public class AlbumImageView
  extends BubbleImageView
{
  public URLDrawable n;
  
  public AlbumImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AlbumImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    TE(false);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Rect localRect = paramURLDrawable.getBounds();
    paramURLDrawable.setBounds(localRect.left - 1, localRect.top, localRect.right, localRect.bottom);
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setLocalDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    setImageDrawable(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.n != paramURLDrawable) {
      this.n = paramURLDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumImageView
 * JD-Core Version:    0.7.0.1
 */