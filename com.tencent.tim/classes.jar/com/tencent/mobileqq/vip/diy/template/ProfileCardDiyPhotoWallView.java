package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aoop;
import aqvx.b;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView;
import java.util.LinkedList;

public class ProfileCardDiyPhotoWallView
  extends ProfileCardNewPhotoWallView
{
  private String cyf;
  private int mBorderColor = -16777216;
  private int mBorderWidth = 10;
  
  public ProfileCardDiyPhotoWallView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileCardDiyPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.width -= getResources().getDimensionPixelSize(2131297953) * 2;
  }
  
  public ViewGroup a(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup = super.a(paramInt1, paramInt2, paramInt3);
    if ((!TextUtils.isEmpty(this.cyf)) && (this.cyf.startsWith("http")))
    {
      localViewGroup.setBackgroundDrawable(a(this.cyf, new aqvx.b(paramInt1 * 2, paramInt2 * 2)));
      return localViewGroup;
    }
    localViewGroup.setBackgroundColor(this.mBorderColor);
    return localViewGroup;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
    throws IllegalArgumentException
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  public void a(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    super.a(paramLinkedList, paramInt);
  }
  
  public View cz()
  {
    View localView = this.mLayoutInflater.inflate(2131562236, null);
    localView.setPadding(this.mBorderWidth, this.mBorderWidth, this.mBorderWidth, this.mBorderWidth);
    return localView;
  }
  
  public void setBorderImgUrl(String paramString)
  {
    this.cyf = paramString;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
  
  public void setItemViewBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    this.bYc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileCardDiyPhotoWallView
 * JD-Core Version:    0.7.0.1
 */